package cn.com.sinosoft.web.service.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.common.service.axis.ClientBindModel;
import cn.com.sinosoft.common.service.axis.ClientBindQueryLocator;
import cn.com.sinosoft.common.service.axis.ClientBindQueryPortType;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.web.entity.IDTypeEntity;
import cn.com.sinosoft.web.service.facade.ClientBindService;
import cn.com.sinosoft.web.util.JSONClientUtil;
import net.sf.json.JSONObject;

@Service
public class ClientBindServiceImpl extends GenericHibernateDao<GeMobileCustomer, Integer> implements ClientBindService {

private static Log logger = LogFactory.getLog(ClientBindServiceImpl.class);	
private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 功能：用户绑定信息查询(长险)
	 * 描述：接口查询用户信息并存库
	 * 作者： ZhangTiancong
	 * @param	idType		证件类型
	 * @param	idNo		证件号码
	 * @param	clientName	用户姓名
	 * @param	OpenID		微信ID
	 * @return 	报文实体
	 */
	public ClientBindModel clientBindQuery(String idType,String idNo,String clientName,String OpenID){
		ClientBindQueryLocator service = new ClientBindQueryLocator();
		ClientBindModel result = new ClientBindModel();
			try {
				ClientBindQueryPortType portType = service.getClientBindQueryHttpSoap11Endpoint();
				result = portType.getClientBindDetail(idType, idNo, clientName);
				if("0".equals(result.getCode().toString())){
					GeMobileCustomer mc = new GeMobileCustomer(); 
					mc.setCoustomerid(result.getPartyCode());
					mc.setName(result.getPartyName());
					mc.setIdtype(IDTypeEntity.formatIDType("longType", "saveType", result.getIdType()));
					mc.setIdnumber(result.getIdNo());
					mc.setSex(formatSex(result.getSex()));
					mc.setBirthday(result.getBirthDate());
					mc.setEmail(result.getEmail());
					mc.setAddress(result.getContactAddress());
					mc.setPostcode(result.getPostalcode());
					mc.setTelphone(result.getContactNo());
					mc.setMicroid(OpenID);
					mc.setCreattime(df.format(new Date()));
					mc.setUpdatetime(df.format(new Date()));
					mc.setDeleteTag("00");
					mc.setType("1");
					this.save(mc);
				}
			} catch (Exception e) {
				logger.error("长险用户绑定异常",e);
			}
			return result;
	}

	/**
	 * 功能：用户绑定信息查询(短险)
	 * 描述：接口查询用户信息并存库
	 * 作者： ZhangTiancong
	 * @param	idType		证件类型
	 * @param	idNo		证件号码
	 * @param	clientName	用户姓名
	 * @param	OpenID		微信ID
	 * @return 	true-保存成功  false-保存失败
	 */
	public boolean ShortClientBind(String idType,String idNo,String clientName,String OpenID){
		JSONClientUtil client = new JSONClientUtil();
		String param = null;	
		try {
			param = "name="+URLEncoder.encode(clientName,"utf-8")+"&idType="+idType+"&idNo="+idNo;
			JSONObject result = (JSONObject)client.send("client", param).get("client");
			if(result != null){
				GeMobileCustomer mc = new GeMobileCustomer();
				mc.setCoustomerid(result.get("customerNo").toString());
				mc.setName(result.get("name").toString());
				mc.setIdtype(IDTypeEntity.formatIDType("chineseType", "saveType", result.get("idType").toString()));
				mc.setIdnumber(result.get("idNo").toString());
				mc.setSex(formatSex(result.get("gender").toString()));
				mc.setBirthday(formatDate(result.get("birthday").toString()));
				mc.setEmail(formatNULL(result.get("email").toString()));
				mc.setAddress(formatNULL(result.get("postalAddress").toString()));
				mc.setPostcode(formatNULL(result.get("zipCode").toString()));
				mc.setTelphone(result.get("phone").toString());
				mc.setMicroid(OpenID);
				mc.setCreattime(df.format(new Date()));
				mc.setUpdatetime(df.format(new Date()));
				mc.setDeleteTag("00");
				mc.setType("2");
				this.save(mc);
				return true;
			}else{
				logger.info("短险未查到用户"+param);
				return false;
			}
		} catch (IOException e) {
			logger.error("短险用户绑定异常",e);
			return false;
		}		
	}
	
	/**
	 * 功能：已绑定用户验证
	 * 描述：数据库验证用户是否已绑定当前微信
	 * 作者： ZhangTiancong
	 * @param	idType		证件类型
	 * @param	idNo		证件号码
	 * @param	clientName	用户姓名
	 * @param	OpenID		微信ID
	 * @return 用户信息列表
	 */
	public List<GeMobileCustomer> checkCustomer(String idType,String idNo,String clientName,String OpenID) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("idtype", idType);
		queryRule.addEqual("idnumber", idNo);
		queryRule.addEqual("deleteTag", "00");
		queryRule.addEqual("name", clientName);
		queryRule.addEqual("microid", OpenID);
		queryRule.addDescOrder("creattime");
		return this.find(queryRule);
	}
	
	/**
	 * 功能：是否绑定微信查询
	 * 描述：数据库验证当前微信是否绑定过
	 * 作者： ZhangTiancong
	 * @param	OpenID		微信ID
	 * @return 用户信息列表
	 */
	public List<GeMobileCustomer> checkOpenID(String OpenID) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("microid", OpenID);
		queryRule.addEqual("deleteTag", "00");
		queryRule.addDescOrder("creattime");
		return this.find(queryRule);
	}
	
	/**
	 * 投保人是否已经被绑定
	 */
	public boolean checkCustomer(String idType,String idNo,String clientName){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("idtype", idType);
		queryRule.addEqual("idnumber", idNo);
		queryRule.addEqual("deleteTag", "00");
		queryRule.addEqual("name", clientName);
		queryRule.addDescOrder("creattime");
		List<GeMobileCustomer> customers = this.find(queryRule);
		if(customers.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	public String parselong(String string) {       
		Long l = 0l;  
		try {
			l = Long.parseLong(string);
		} catch (NumberFormatException e) {
			logger.error("短险生日类型转换失败",e);
		}
		Date date = new Date(l);
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		return df.format(date);
	}
	
	public String formatDate(String string){
		return string.replace("-", "/");
	}
	
	public String formatNULL(String string){
		if("null".equals(string)){
			return null;
		}else{
			return string;
		}
	}
	
	public String formatSex(String string){
		if("男".equals(string.trim())){
			return "M";
		}else if("女".equals(string.trim())){
			return "F";			
		}else{
			return string;
		}
	}
	
	/**
	 * 更新客户信息
	 */
	public void updateCustomerBymicroid(String email,String address,String postcode,String telphone,String customerid){
		Session session = this.getSession();
		session.beginTransaction();
		String updatetime= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		Query query =session.createQuery("update GeMobileCustomer set email = '"+ email+"',address = '"+address+"',postcode = '"+postcode+"', telphone = '"+telphone+"',updatetime = '"+updatetime+"'  where coustomerid ='"+customerid+"'");
		query.executeUpdate();
//		session.getTransaction().commit();
	}
	
	/**
	 * 查找单一对象
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public GeMobileCustomer getOne(String propertyName, Object value){
		return this.findUnique(propertyName, value);
	}
	
	public String findPhone(String idType,String idNo,String clientName,String OpenID){
		//长险所用
		ClientBindQueryLocator service = new ClientBindQueryLocator();
		ClientBindModel longResult = new ClientBindModel();
		//短险所用
		JSONClientUtil client = new JSONClientUtil();
		String param = null;
		String phone = null;
		//String longTag=null;
		String shortTag=null;
		try {
			String longPhone = null;
			String longPartyCode = null;
			String shortPhone = null;
			String shortPartyCode = null;
			String longType = IDTypeEntity.formatIDType("saveType","longType", idType);
			//长险
			ClientBindQueryPortType portType = service.getClientBindQueryHttpSoap11Endpoint();
			longResult = portType.getClientBindDetail(longType, idNo, clientName);
			if("0".equals(longResult.getCode().toString())){
				longPhone = longResult.getContactNo();
				longPartyCode=longResult.getPartyCode();
				logger.info("##长险查询证件号信息:"+clientName+" |证件号"+longResult.getIdNo()+" |手机号： "+longPhone+" |客户号："+longPartyCode+"|clientBind_long return:"+longResult.getCode().toString()+"|"+longResult.getContenct());
				phone = longPhone;
				if(!longPhone.startsWith("1")){
					//长险电话号不规则 开始调用短险
					shortTag = "1";
					logger.error("长险返回电话号不规则，开始调用短险接口！");
				}
			}else{
				//longTag="NON";
				logger.info("##长险未查到用户：name="+clientName+" idType="+longType+" idNo="+idNo);
				shortTag = "1";
			}
			if("1".equals(shortTag)){
				//短险
				String shortType = IDTypeEntity.formatIDType("saveType","shortType", idType);
				param = "name="+URLEncoder.encode(clientName,"utf-8")+"&idType="+shortType+"&idNo="+idNo;
				JSONObject shortResult = (JSONObject)client.send("client", param).get("client");
				if(shortResult != null){
					shortPhone = shortResult.get("phone").toString();
					shortPartyCode=shortResult.get("customerNo").toString();
					logger.info("##短险查询证件号信息："+shortResult.get("idNo").toString()+" |手机号："+shortPhone+" |客户号："+shortPartyCode+"|传入用户信息：name="+clientName+" idType="+shortType+" idNo="+idNo);
					phone = shortPhone;
				}else{
					//shortTag="NON";
					logger.info("##短险未查到用户: name="+clientName+" idType="+shortType+" idNo="+idNo);
				}
			}
			/*手机号取舍
			对客户号进行校验
			俩个都是数字的 取最大的
			有数字和字母的 取数字的*/
			/*if("NON".equals(shortTag) && "NON".equals(longTag)){
				phone = shortTag;
			} else {
				if(null != longPhone && null != shortPhone){
					if(longPhone.startsWith("1") && shortPhone.startsWith("1")){
						 Pattern pattern = Pattern.compile("[0-9]*");
						 Matcher isShort = pattern.matcher(shortPartyCode);
						 Matcher isLong = pattern.matcher(longPartyCode);
						 if(isShort.matches() && isLong.matches()){
							 int ishort = Integer.parseInt(shortPartyCode);
							 int ilong = Integer.parseInt(longPartyCode);
							 if(ishort > ilong){
								 phone = shortPhone;
							 } else {
								 phone = longPhone;
							 }
						 } else {
							 if(isShort.matches()){
								 phone = shortPhone;
							 } else if(isLong.matches()){
								 phone = longPhone;
							 }
						 }
					} else {
						if(longPhone.startsWith("1")){
							phone = longPhone;
						} else if(shortPhone.startsWith("1")){
							phone = shortPhone;
						}
					}
				} else {
					if(null != longPhone){
						phone = longPhone;
					} else if(null != shortPhone){
						phone = shortPhone;
					}
				}
			}*/
		} catch (Exception e) {
			logger.error("接口获取手机号异常",e);
		}
		return phone;
	}
	
	public List<GeMobileCustomer> findCustomers(String idType,String idNo,String clientName,String type){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("idtype", idType);
		queryRule.addEqual("idnumber", idNo);
		queryRule.addEqual("deleteTag", "00");
		queryRule.addEqual("name", clientName);
		queryRule.addEqual("type", type);
		queryRule.addDescOrder("creattime");
		return this.find(queryRule);
	}

	@Override
	public void updateCustomer(GeMobileCustomer mobileCustomer) {
		this.update(mobileCustomer);
	}
}

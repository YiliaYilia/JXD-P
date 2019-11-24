package cn.com.sinosoft.user.service.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.com.sinosoft.user.service.axis.ClientBindModel;
import cn.com.sinosoft.user.service.axis.ClientBindQueryLocator;
import cn.com.sinosoft.user.service.axis.ClientBindQueryPortType;
import net.sf.json.JSONObject;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.system.MobileCustomer;
import cn.com.sinosoft.user.service.MobileCustomerService;

@Component
public class MobileCustomerServiceImpl extends GenericHibernateDao<MobileCustomer, String>  implements MobileCustomerService {


	@SuppressWarnings("unchecked")
	public Page<MobileCustomer> getMobileCustomerByNameAndIdNumber(MobileCustomer mobileCustomer,int pageNumber, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("deleteTag", "00");
		if(mobileCustomer!=null){
			if(!StringUtils.isEmpty(mobileCustomer.getIdnumber())){
				queryRule.addLike("idnumber", "%"+mobileCustomer.getIdnumber()+"%");
			}
			if(!StringUtils.isEmpty(mobileCustomer.getName())){
				queryRule.addLike("name", "%"+mobileCustomer.getName()+"%");
			}
			if(!StringUtils.isEmpty(mobileCustomer.getStarttime())){
				queryRule.addGreaterEqual("creattime", mobileCustomer.getStarttime());
			}
			if(!StringUtils.isEmpty(mobileCustomer.getEndtime())){
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date endTime;
				try {
					endTime = sdf.parse(mobileCustomer.getEndtime());
					calendar.setTime(endTime);
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					String strEndtime = sdf.format(calendar.getTime());
					queryRule.addLessEqual("creattime", strEndtime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return this.find(queryRule, pageNumber, pageSize);
	}
	
	public List<MobileCustomer> getMobileCustomer() {
		String[] str = {"00"};
		return findByHql("from MobileCustomer m where m.deleteTag=?", str);
		//return super.getAll(entityClass, false);
	}
	
	public MobileCustomer getOne(String propertyName, Object value){
		return this.findUnique(propertyName,value);
	}

	@Override
	public int updateCustomer(String name, String openId) {
		// TODO Auto-generated method stub
		String sql ="update MobileCustomer set deleteTag='01' where name='"+name+"' and microid='"+openId+"'";
		Query query = getSession().createQuery(sql);
		int i = query.executeUpdate();
		return i;
	}

	@Override
	public int bindingCustomer(String name,String idType,String idNumber,String openId){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//调用核心
			ClientBindQueryLocator service = new ClientBindQueryLocator();
			ClientBindModel result = new ClientBindModel();
			ClientBindQueryPortType portType = service.getClientBindQueryHttpSoap11Endpoint();
			result = portType.getClientBindDetail(idType, idNumber, name);
			if(idType.equals("ID Card")){
				idType = "ID_CARD";
			}
			if(idType.equals("Passport")){
				idType = "PASSPORT";
			}
			if(idType.equals("DL")){
				idType = "DRIVING_LICENSE";
			}
			if("0".equals(result.getCode().toString())){
				MobileCustomer mc = new MobileCustomer();
				mc.setCoustomerid(result.getPartyCode());
				mc.setName(result.getPartyName());
				mc.setIdtype(idType);
				mc.setIdnumber(result.getIdNo());
				mc.setSex(formatSex(result.getSex()));
				mc.setBirthday(result.getBirthDate());
				mc.setEmail(result.getEmail());
				mc.setAddress(result.getContactAddress());
				mc.setPostcode(result.getPostalcode());
				mc.setTelphone(result.getContactNo());
				mc.setMicroid(openId);
				mc.setCreattime(df.format(new Date()));
				mc.setUpdatetime(df.format(new Date()));
				mc.setDeleteTag("00");
				mc.setType("1");
				this.save(mc);
			}else {
				logger.error("没有查询到该用户");
				return 0;
			}
			return 1;
		} catch (Exception e) {
			logger.error("用户绑定异常",e);
			return 0;
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
}

package cn.com.sinosoft.web.action;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.BasicQuery;
import cn.com.sinosoft.common.service.axis.CRSInterfaceModel;
import cn.com.sinosoft.common.service.axis.CardInformation;
import cn.com.sinosoft.common.service.axis.ClientBindModel;
import cn.com.sinosoft.common.service.axis.ClientBindQueryLocator;
import cn.com.sinosoft.common.service.axis.ClientBindQueryPortType;
import cn.com.sinosoft.common.service.axis.PartyChangeModel;
import cn.com.sinosoft.common.service.axis.PartyChangeReturnModel;
import cn.com.sinosoft.common.service.axis.PartyInformation;
import cn.com.sinosoft.common.service.axis.RoleQueryModel;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.domain.sale.GeMobileCustomerChange;
import cn.com.sinosoft.domain.user.DateChangeData;
import cn.com.sinosoft.ess.product.common.Data;
import cn.com.sinosoft.web.entity.IDTypeEntity;
import cn.com.sinosoft.web.service.facade.ClientBindService;
import cn.com.sinosoft.web.service.facade.DateChangeDataService;
import cn.com.sinosoft.web.service.facade.GeGeographicalAreafindService;
import cn.com.sinosoft.web.service.facade.MobileCustomerChangeService;
import cn.com.sinosoft.web.service.facade.PartyChangeService;
import cn.com.sinosoft.web.service.facade.PolicyBasicQueryService;
import cn.com.sinosoft.web.service.facade.SinoImageService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;
/**
 * 身份证变更类
 * @author Administrator
 *
 */
public class PartyChangeAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(PartyChangeAction.class);
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	PartyChangeService partyChangeService;
	@Autowired
	ClientBindService clientBindService;
	@Autowired
	DateChangeDataService dateChangeDataService;
	@Autowired
	MobileCustomerChangeService mobileCustomerChangeService;
	@Autowired
	GeGeographicalAreafindService GeGeographicalAreafindService;
	@Autowired
	private PolicyBasicQueryService policyBasicQueryService;
	private static Properties pro = new Properties();
	@Autowired
	private SinoImageService sinoImageService;
	private ExecutorService sinoImagePool = Executors.newFixedThreadPool(2);
	static{
		try {
			pro.load(new InputStreamReader(PartyChangeAction.class.getResourceAsStream("/config/SecondPeriod.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 个人信息查询
	 * @throws ScriptException
	 */
	@Action(value="myInfo")
	public String myInfo() throws ScriptException{
		String OpenID = WeiXinServiceImpl.getOpenId(this.getHttpServletRequest());
		//String OpenID = "oipGbs_hYaKskAVyEG0liYpjAG2A"; //lks
		//String OpenID = "oipGbs6aOJCQcO0jGszXYVdAmp_I"; //gyx
		//先确定是否已经绑定
		if(Data.hasValue(OpenID) && !"null".equals(OpenID) && clientBindService.checkOpenID(OpenID).size()>0){
			String address = null;
			String stateName = null;
			String cityName = null;
			List<GeMobileCustomer> list = clientBindService.checkOpenID(OpenID);
			List<PartyChangeModel> list1 = new ArrayList<PartyChangeModel>();

			for (GeMobileCustomer geMobileCustomer : list) {
				String customerId = geMobileCustomer.getCoustomerid();
				if(!(customerId.startsWith("C") && customerId.length() == 12)){
					list1.add(partyChangeService.WeChatQuery(customerId));
				}
			}
			if(list1.size()>0){
				GeMobileCustomer customerUpdate = list.get(0);
				PartyChangeModel customerPro = list1.get(0);
				customerUpdate.setAddress(customerPro.getContactAddress());
				customerUpdate.setEmail(customerPro.getEmail());
				customerUpdate.setTelphone(customerPro.getContactNo());
				customerUpdate.setPostcode(customerPro.getPostalcode());
				this.setRequestAttribute("myinfo", customerUpdate);
				address = customerPro.getContactAddress();
			}else{
				try{
					GeMobileCustomer customer = list.get(0);
					String idType = customer.getIdtype();
					String idNumber = customer.getIdnumber();
					String name = customer.getName();
					ClientBindQueryLocator bindQueryService = new ClientBindQueryLocator();
					ClientBindQueryPortType portType = bindQueryService.getClientBindQueryHttpSoap11Endpoint();
					ClientBindModel result = portType.getClientBindDetail(idType, idNumber, name);
					if("0".equals(result.getCode().toString())){
						//如果核心中查询到客户信息，将客户信息存入微信库
						clientBindService.clientBindQuery(IDTypeEntity.formatIDType("saveType","longType", idType), idNumber, name,OpenID);
						logger.info("********** 短险用户查询核心重新绑定成功 ***********");
						PartyChangeModel customerPro = partyChangeService.WeChatQuery(result.getPartyCode());
						customer.setAddress(customerPro.getContactAddress());
						customer.setEmail(customerPro.getEmail());
						customer.setTelphone(customerPro.getContactNo());
						customer.setPostcode(customerPro.getPostalcode());
						this.setRequestAttribute("myinfo", customer);
						address = customerPro.getContactAddress();
					}else{
						logger.info("个人信息查询短险客户号："+list.get(0).getCoustomerid());
						this.setRequestAttribute("myinfo", list.get(0));
						address = list.get(0).getAddress();
					}
				}catch (Exception e){
					logger.error("用户信息查询异常",e);
				}
			}

			if(address==null || "".equals(address)){
				this.setRequestAttribute("address1", "");
				this.setRequestAttribute("county", "");
				return "../page/infoChange";
			}
			//获取省地址
			stateName = findStateAndCityName(address, "1");
			String state_code = GeGeographicalAreafindService.findArea_code(stateName, "1");
			if(state_code != null && state_code!=""){
				this.setRequestAttribute("stateName", stateName);
			}else{
				this.setRequestAttribute("address1", stateName);
				this.setRequestAttribute("county", "");
				return "../page/infoChange";
			}
			address = address.replaceFirst(stateName,"");
			if(address == null || "".equals(address)){
				this.setRequestAttribute("county", "");
				this.setRequestAttribute("address1", "");
				return "../page/infoChange";
			}
			cityName = findStateAndCityName(address, "2");
			String city_code = GeGeographicalAreafindService.findArea_code(cityName, "2");
			if(city_code != null && city_code != ""){
				this.setRequestAttribute("cityName", cityName);
			}else{
				this.setRequestAttribute("county", "");
				this.setRequestAttribute("address1", cityName);
				return "../page/infoChange";
			}
			address = address.replaceFirst(cityName,"");
			if(address == null || "".equals(address)){
				this.setRequestAttribute("county", "");
				this.setRequestAttribute("address1", "");
				return "../page/infoChange";
			}
			//地址信息截取省市不为空后 在进去区/县 信息截取
			if(address.contains("区/县")){
				String[] ads = address.split("区/县");
				this.setRequestAttribute("county", ads[0]);
				if(count(address,"区/县")==1){
					this.setRequestAttribute("address1", ads[1]);
					return "../page/infoChange";
				}else{
					address = address.replaceFirst(ads[0]+"区/县","");
					this.setRequestAttribute("address1", address);
					return "../page/infoChange";
				}
			}else{
				this.setRequestAttribute("county", "");
			}
			this.setRequestAttribute("address1", address);
			return "../page/infoChange";
		}else{
			this.setRequestAttribute("OpenID", OpenID);
			return "../page/index";
		}
	}

	/**
	 * 个人税收居民身份声明
	 * @throws ScriptException
	 */
	@Action(value="crsInfoChange")
	public String crsInfoChange() throws ScriptException{
		String OpenID = WeiXinServiceImpl.getOpenId(this.getHttpServletRequest());
		//String OpenID = "oipGbs_hYaKskAVyEG0liYpjAG2A"; //lks
		//String OpenID = "oipGbs6aOJCQcO0jGszXYVdAmp_I"; //gyx
		//先确定是否已经绑定
		if(Data.hasValue(OpenID)&&clientBindService.checkOpenID(OpenID).size()>0){
			List<GeMobileCustomer> list = clientBindService.checkOpenID(OpenID);
			List<GeMobileCustomer> list1 = new ArrayList<GeMobileCustomer>();
			if(list.size()>1){
				for (GeMobileCustomer geMobileCustomer : list) {
					String customerId = geMobileCustomer.getCoustomerid();
					if(!(customerId.startsWith("C") && customerId.length() == 12)){
						list1.add(geMobileCustomer);
					}
				}
				if(list1.size()>0){
					this.setRequestAttribute("myinfo", list1.get(0));
				}else{
					this.setRequestAttribute("myinfo", list.get(0));
				}
			}else{
				this.setRequestAttribute("myinfo", list.get(0));
			}
			return "../page/crsInfoChange";
		}else{
			this.setRequestAttribute("OpenID", OpenID);
			return "../page/index";
		}
	}

	/**
	 * 个人信息变更
	 */
	@Action(value="changeMine")
	public void changeMine(){
		JSONObject resultJson = new JSONObject();
		resultJson.put("contenct","个人信息变更失败！");
		HttpServletRequest request = super.getHttpServletRequest();
		String partyCode = request.getParameter("partyCode")==null?"":request.getParameter("partyCode");//客户号
		String name = request.getParameter("name")==null?"":request.getParameter("name");//客户姓名
		String country = "CHN";    //国家——中国 CHN
		String state = request.getParameter("state")==null?"":request.getParameter("state");//省
		String city = request.getParameter("city")==null?"":request.getParameter("city");//市
		String contactAddress = request.getParameter("contactAddress")==null?"":request.getParameter("contactAddress");//详细地址
		String contactNo = request.getParameter("contactNo")==null?"":request.getParameter("contactNo");//手机
		String email = request.getParameter("email")==null?"":request.getParameter("email");//邮箱
		String postalcode = request.getParameter("postalcode")==null?"":request.getParameter("postalcode");//邮编
		String microid = request.getParameter("microid")==null?"":request.getParameter("microid");//openId
		String idtype = request.getParameter("idtype")==null?"":request.getParameter("idtype");//证件类型
		String idnumber = request.getParameter("idnumber")==null?"":request.getParameter("idnumber");//证件号码
		String taxDeclaraID = request.getParameter("taxDeclaraID")==null?"":request.getParameter("taxDeclaraID");//crs id
		String updatetime= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String address = state+city+contactAddress;
		logger.info("获取客户号："+partyCode);
		//省市转为编码格式
		String state_code = GeGeographicalAreafindService.findArea_code(state, "1");
		String city_code = GeGeographicalAreafindService.findArea_code(city, "2");
		//香港、澳门、台湾国籍改为中国香港、中国澳门、中国台湾
		if(state_code != null && "TW".equals(state_code)){
			country = "TWN";
		}else if(state_code != null && "HK-S".equals(state_code)){
			country = "HKG";
		}else if(state_code != null && "MAC-S".equals(state_code)){
			country = "MAC";
		}
		logger.info("国籍："+country+"--省编码："+state_code+"--市编码:"+city_code);
		if(partyCode.startsWith("C") && partyCode.length() == 12){
			resultJson.put("contenct","您的保单类型暂不支持个人信息变更");
			logger.info("保单类型暂不支持个人信息变更，客户号："+partyCode);
		}else{
			PartyChangeModel pcm = new PartyChangeModel();
			pcm.setCountry(country);
			pcm.setState(state_code);
			pcm.setCity(city_code);
			pcm.setPartyCode(partyCode);
			pcm.setContactAddress(contactAddress);
			pcm.setContactNo(contactNo);
			pcm.setEmail(email);
			pcm.setPostalcode(postalcode);
			pcm.setTaxDeclaraID(taxDeclaraID);
			//调取个人信息变更接口
			PartyChangeReturnModel pcr = partyChangeService.PartyChange(pcm);
			if(pcr.getCode() != null && "0".equals(pcr.getCode().toString())){
				clientBindService.updateCustomerBymicroid(email, address, postalcode, contactNo, partyCode);
				//插入个人信息变更日志表
				GeMobileCustomerChange geMobileCustomerChange = new GeMobileCustomerChange();
				geMobileCustomerChange.setAddress(address);
				geMobileCustomerChange.setCoustomerid(partyCode);
				geMobileCustomerChange.setName(name);
				geMobileCustomerChange.setEmail(email);
				geMobileCustomerChange.setPostcode(postalcode);
				geMobileCustomerChange.setMobile(contactNo);
				geMobileCustomerChange.setUpdatetime(updatetime);
				geMobileCustomerChange.setMicroid(microid);
				geMobileCustomerChange.setIdtype(idtype);
				geMobileCustomerChange.setIdnumber(idnumber);
				mobileCustomerChangeService.add(geMobileCustomerChange);
				resultJson.put("contenct","个人信息变更成功！");
				resultJson.put("code",pcr.getCode());
				logger.info("个人信息变更成功，客户号："+partyCode);
			}else{
				resultJson.put("contenct","个人信息变更失败！由于："+pcr.getContenct());
				resultJson.put("code",pcr.getCode());
				logger.info("个人信息变更失败，客户号："+partyCode+"，由于："+pcr.getContenct());
			}
		}
		super.renderJson(resultJson.toString());
	}

	/**
	 * 个人信息变更时CRS校验
	 */
	@Action(value="dealPartyTaxType")
	public void dealPartyTaxType(){
		logger.info("crs信息校验开始");
		JSONObject resultJson = new JSONObject();
		resultJson.put("contenct", "crs信息校验失败！");
		HttpServletRequest request = super.getHttpServletRequest();
		String partyCode = request.getParameter("partyCode")==null?"":request.getParameter("partyCode");//客户号
		String callBy = request.getParameter("callBy")==null?"":request.getParameter("callBy");//调用者标识
		String taxType = request.getParameter("taxType")==null?"":request.getParameter("taxType");//税收居民身份
		String operate = request.getParameter("operate")==null?"":request.getParameter("operate");//操作类型
		String state = request.getParameter("state")==null?"":request.getParameter("state");//省
		//省市转为编码格式
		String country = null;
		logger.info("crs信息校验1");
		if(state != null && !"".equals(state)){
			country = "CHN";//国家——中国 CHN
			String state_code = GeGeographicalAreafindService.findArea_code(state, "1");
			//香港、澳门、台湾国籍改为中国香港、中国澳门、中国台湾
			if(state_code != null && "TW".equals(state_code)){
				country = "TWN";
			}else if(state_code != null && "HK-S".equals(state_code)){
				country = "HKG";
			}else if(state_code != null && "MAC-S".equals(state_code)){
				country = "MAC";
			}
		}
		logger.info("获取客户号："+partyCode+",crs居民类型："+taxType+",国籍："+country);
		//调用dealPartyTaxType check
		CRSInterfaceModel  crsInterfaceModel= partyChangeService.dealPartyTaxType(partyCode,taxType,operate,callBy,country);
		logger.info("crs信息校验2");
		if(crsInterfaceModel.getCode() != null && crsInterfaceModel.getCode() == 0){//校验成功
			resultJson.put("contenct", "crs信息校验成功！");
			resultJson.put("code", crsInterfaceModel.getCode());
			resultJson.put("taxDeclaraID", crsInterfaceModel.getTaxDeclaraID());
			logger.info("crs校验成功，客户号："+partyCode);
		}else{
			resultJson.put("contenct", "crs信息校验失败！由于："+crsInterfaceModel.getContenct());
			resultJson.put("code", crsInterfaceModel.getCode());
			logger.info("crs校验失败，客户号："+partyCode+",由于："+crsInterfaceModel.getContenct());
		}
		super.renderJson(resultJson.toString());
	}

	/**
	 * 证件日期变更
	 */
	@Action(value="PartyChange")
	public void PartyChange(){
		logger.info("进入证件有效期变更...");
		JSONObject resultJson = new JSONObject();
		resultJson.put("contenct","证件有效期变更失败！");
		HttpServletRequest request = super.getHttpServletRequest();
		String partyType = request.getParameter("partyType")==null?"":request.getParameter("partyType");//变更主体
		if(partyType.equals("pol")){
			partyType = "投保人";
		}else if(partyType.equals("lifeAssd")){
			partyType = "被保险人";
		}else if(partyType.equals("benfic")){
			partyType = "身故受益人";
		}
		String CardNo = request.getParameter("CardNo")==null?"":request.getParameter("CardNo");//证件号
		String CardType = request.getParameter("CardType")==null?"":request.getParameter("CardType");//证件类型
		String partyCode = request.getParameter("partyCode")==null?"":request.getParameter("partyCode");//客户号
		String ExpiredDate = request.getParameter("ExpiredDate")==null?"":request.getParameter("ExpiredDate");//证件有效期
		String taxDeclaraID = request.getParameter("taxDeclaraID")==null?"":request.getParameter("taxDeclaraID");//crs id
		String mediaPathFront = request.getParameter("mediaPathFront")==null?"":request.getParameter("mediaPathFront");
		String mediaPathContrary = request.getParameter("mediaPathContrary")==null?"":request.getParameter("mediaPathContrary");
		//链接核心，调长险接口
		PartyChangeModel pcm = new PartyChangeModel();
		pcm.setExpiredDate(ExpiredDate);
		pcm.setPartyCode(partyCode);
		pcm.setTaxDeclaraID(taxDeclaraID);
		PartyChangeReturnModel pcr = partyChangeService.PartyChange(pcm);
		if(pcr.getCode() != null && "0".equals(pcr.getCode().toString())){
			//存储图片
			String filePath = this.getServletContext().getRealPath("/");
			String newMediaPathFront = CardNo+"_front" + mediaPathFront.substring(mediaPathFront.lastIndexOf("."));
			String newMediaPathContrary = CardNo+"_contrary" + mediaPathContrary.substring(mediaPathContrary.lastIndexOf("."));
			if(partyChangeService.copyPicture(mediaPathFront,newMediaPathFront,filePath)
					&& partyChangeService.copyPicture(mediaPathContrary,newMediaPathContrary,filePath)){
				String identityImagePath = pro.getProperty("identityImagePath");
				DateChangeData dateChangeData = new DateChangeData();
				dateChangeData.setCoustomerid(partyCode);//设置主键
				dateChangeData.setFront(identityImagePath+newMediaPathFront);
				dateChangeData.setContrary(identityImagePath+newMediaPathContrary);
				dateChangeDataService.saveImagePath("coustomerid",partyCode,dateChangeData,null);
				//变更报表入库
				dateChangeData.setCardNo(CardNo);
				dateChangeData.setCardType(CardType);
				dateChangeData.setCoustomerid(partyCode);
				dateChangeData.setExpiredDate(ExpiredDate);
				dateChangeData.setChangeType(partyType);
				dateChangeData.setUpdatetime(new Date());
				dateChangeDataService.saveOrUpdate("coustomerid",partyCode,dateChangeData);
				resultJson.put("code",pcr.getCode());
				resultJson.put("contenct","证件有效期变更成功！");
				logger.info("证件有效期变更成功！客户号："+partyCode+"，修改时间:"+dateChangeData.getUpdatetime());
				//另起线程进行影像上传
				if(partyType.equals("投保人") || partyType.equals("被保险人")){
					logger.info("*******异步影像上传开始******");
					final String filePathTemp = ServletActionContext.getServletContext().getRealPath("/") + "IdentityImage/";
					final DateChangeData dateChangeDataTemp = dateChangeData;
					sinoImagePool.execute(new Thread(new Runnable() {
						@Override
						public void run() {
							logger.info("客户号:"+dateChangeDataTemp.getCoustomerid());
							sinoImageService.sinoImageCertificate(dateChangeDataTemp,filePathTemp);
						}
					}));
				}
			}
		}else{
			resultJson.put("code",pcr.getCode());
			resultJson.put("contenct","证件有效期变更失败！由于："+pcr.getContenct());
			logger.info("证件有效期变更失败！客户号："+partyCode+"，由于："+pcr.getContenct());
		}
		super.renderJson(resultJson.toString());
	}

	/**
	 * 根据meadia_id下载图片
	 */
	@Action(value="downloadMedia")
	public void downloadMedia(){
		HttpServletRequest request = super.getHttpServletRequest();
		String filePath = this.getServletContext().getRealPath("/");
		String mediaName = null;
		String mediaPath = null;
		String partyCode = request.getParameter("partyCode")==null?"":request.getParameter("partyCode");//客户号
		String meadia_id = request.getParameter("media_id");
		String cardNo = request.getParameter("CardNo");
		String type = request.getParameter("type");
		DateChangeData dateChangeData = new DateChangeData();
		WeiXinServiceImpl weixin = new WeiXinServiceImpl();
		dateChangeData.setCoustomerid(partyCode);//设置主键
		if(type.equals("front")){
			mediaPath = weixin.downloadMedia(meadia_id,filePath+"IdentityImage/",cardNo+"_front");
			dateChangeData.setFront(mediaPath);
			String[] split = mediaPath.split("/");
			mediaName = split[split.length-1];
			this.setRequestAttribute("froutName", mediaName);
		}else if(type.equals("contrary")){
			mediaPath = weixin.downloadMedia(meadia_id,filePath+"IdentityImage/",cardNo+"_contrary");
			dateChangeData.setContrary(mediaPath);
			this.setRequestAttribute("contraryName", mediaName);
		}
		dateChangeDataService.saveImagePath("coustomerid",partyCode,dateChangeData,type);
	}



	/**
	 * 保单人员信息查询
	 */
	@Action(value="getMemberList")
	public String getMemberList(){
		String flag = "0";
		HttpServletRequest request = super.getHttpServletRequest();
		String policyNo = request.getParameter("policyNo")==null?"":request.getParameter("policyNo");
		if(Data.hasValue(policyNo)){
			RoleQueryModel roleQueryModel = partyChangeService.RoleQuery(policyNo);
			if("0".equals(roleQueryModel.getCode().toString())){
				List<Map<String, String>> benficParty = formatPartyInformation(roleQueryModel.getTBenficPartyInformation());
				for(Map<String, String> benfic:benficParty){
					if(benfic.get("partyCode").equals("00000001")){
						flag = "1";
					}
				}
				this.setRequestAttribute("benficParty", benficParty);//受益人列表
				this.setRequestAttribute("lifeAssdParty", formatPartyInformation(roleQueryModel.getTLifeAssdPartyInformation()));
				this.setRequestAttribute("polParty", formatPartyInformation(roleQueryModel.getTPolPartyInformation()));
				this.setRequestAttribute("flag", flag);
			}else{
				this.setRequestAttribute("Contenct", "保单信息查询失败");
			}
		}
		return "../page/memberlist";
	}

	@Action(value="/identityOCR")
	public void identityOCR(){
		HttpServletRequest request = super.getHttpServletRequest();
		String filePath = this.getServletContext().getRealPath("/");
		String partyType = request.getParameter("partyType")==null?"":request.getParameter("partyType");
		String partyCode = request.getParameter("partyCode")==null?"":request.getParameter("partyCode");//客户号
		String cardNo = request.getParameter("cardNo")==null?"":request.getParameter("cardNo");//证件号
		String type = request.getParameter("type")==null?"":request.getParameter("type");
		MultiPartRequestWrapper req = (MultiPartRequestWrapper) this.getHttpServletRequest();
		String identityOCRUrl = pro.getProperty("identityOCRUrl");
		String apiKey = pro.getProperty("api_key");
		String apiSecret = pro.getProperty("api_secret");
		logger.info("partyType:"+partyType+",partyCode:"+partyCode+",cardNo:"+cardNo+",type:"+type);
		identityOCRUrl = identityOCRUrl + "?" + "api_key=" + apiKey + "&api_secret=" + apiSecret;
		renderJson(partyChangeService.identityOCR(partyCode,partyType,cardNo,type,req,identityOCRUrl,filePath));

	}

	@Action(value="certificate")
	public String certificate() {
		logger.info("****************get into certificate***************");
		HttpServletRequest request = super.getHttpServletRequest();
		String openID = WeiXinServiceImpl.getOpenId(request);
		//String openID = "oipGbs6aOJCQcO0jGszXYVdAmp_I"; //gyx
		String polPartyCode = request.getParameter("polPartyCode")==null?"":request.getParameter("polPartyCode");
		if(Data.hasValue(openID) && Data.hasValue(polPartyCode)){
			try {
				String partyType = request.getParameter("partyType")==null?"":new String(request.getParameter("partyType").getBytes("ISO8859-1"),"UTF-8");
				String partyCode = request.getParameter("partyCode")==null?"":request.getParameter("partyCode");
				String cardNo = request.getParameter("cardNo")==null?"":request.getParameter("cardNo");
				String cardType = request.getParameter("cardType")==null?"":new String(request.getParameter("cardType").getBytes("ISO8859-1"),"UTF-8");
				//String cardType = request.getParameter("cardType")==null?"":request.getParameter("cardType");
				String expiredDate = request.getParameter("expiredDate")==null?"":request.getParameter("expiredDate");
				logger.info("polPartyCode:" + polPartyCode + ",openID:" + openID);
				List<GeMobileCustomer> existCustomer = clientBindService.checkOpenID(openID);
				if(existCustomer != null && existCustomer.size() > 0){
					for (GeMobileCustomer geMobileCustomer : existCustomer) {
						if(polPartyCode.equals(geMobileCustomer.getCoustomerid())){
							logger.info("id:" + existCustomer.get(0).getId() + ",coustomerid:" + existCustomer.get(0).getCoustomerid());
							logger.info("partyType:"+partyType+",partyCode:"+partyCode+",cardNo:"+cardNo+",cardType:"+cardType+",expiredDate:"+expiredDate);
							this.setRequestAttribute("partyType", partyType);
							this.setRequestAttribute("partyCode", partyCode);
							this.setRequestAttribute("cardNo", cardNo);
							this.setRequestAttribute("cardType", cardType);
							this.setRequestAttribute("expiredDate", expiredDate);
							String conservationFlag = request.getParameter("conservationFlag");
							if(conservationFlag != null && "bankAccountChange".equals(conservationFlag)){
								this.setRequestAttribute("policyNum", request.getParameter("policyNum"));
								this.setRequestAttribute("polName", request.getParameter("polName")==null?"":new String(request.getParameter("polName").getBytes("ISO8859-1"),"UTF-8"));
								this.setRequestAttribute("accountBank", request.getParameter("accountBank")==null?"":new String(request.getParameter("accountBank").getBytes("ISO8859-1"),"UTF-8"));
								this.setRequestAttribute("bankCardID", request.getParameter("bankCardID"));
								this.setRequestAttribute("renewalIndicator", request.getParameter("renewalIndicator"));
							}else if(conservationFlag != null && "accountAssetTransfer".equals(conservationFlag)){
								String policyNo = request.getParameter("policyNum");
								BasicQuery policyBasic = policyBasicQueryService.policyBasicQuery(policyNo);
								policyBasic.setInvestments(policyBasic.getTInvestmentModel());
								this.setRequestAttribute("policyBasic", policyBasic);
								this.setRequestAttribute("policyNum", request.getParameter("policyNum"));
								this.setRequestAttribute("price", request.getParameter("price"));
								this.setRequestAttribute("priceDate", request.getParameter("priceDate"));
								this.setRequestAttribute("units", request.getParameter("units"));
								this.setRequestAttribute("productCode", request.getParameter("productCode"));
								this.setRequestAttribute("productName", request.getParameter("productName")==null?"":new String(request.getParameter("productName").getBytes("ISO8859-1"),"UTF-8"));
								this.setRequestAttribute("coustomerid", request.getParameter("coustomerid"));
								this.setRequestAttribute("applicantName", request.getParameter("applicantName")==null?"":new String(request.getParameter("applicantName").getBytes("ISO8859-1"),"UTF-8"));
								this.setRequestAttribute("accountBank", request.getParameter("accountBank")==null?"":new String(request.getParameter("accountBank").getBytes("ISO8859-1"),"UTF-8"));
								this.setRequestAttribute("bankCardId", request.getParameter("bankCardId"));
							}
							logger.info("****************certificate end***************");
							return "../page/certificate";
						}
					}
				}
			} catch (Exception e) {
				logger.error("certificate 异常：",e);
			}
		}
		this.setRequestAttribute("OpenID", openID);
		return "../page/index";
	}

	/**
	 * 通过客户号进行证件有效期校验
	 * @return
	 */
	@Action(value="expiredDateCheckByPartyCode")
	public void expiredDateCheckByPartyCode() {
		logger.info("****************get into expiredDateCheckByPartyCode***************");
		HttpServletRequest request = super.getHttpServletRequest();
		Map<String, String> retMap = new HashMap<String, String>();
		String partyCode = request.getParameter("partyCode")==null? "":request.getParameter("partyCode");
		if(partyCode == null || "".equals(partyCode)){
			retMap.put("code", "3");
			retMap.put("message", "未查到该客户在长险的相关信息。如需帮助请致电客服专线4008109339");
		}else{
			//校验客户证件有效期
			retMap = partyChangeService.expiredDateCheck(partyCode);
		}
		logger.info("partyCode:"+partyCode+",code:"+retMap.get("code")+",message:"+retMap.get("message"));
		logger.info("****************expiredDateCheckByPartyCode end***************");
		this.renderJson(JSONObject.fromObject(retMap).toString());
	}
	
	/**
	 * 通过openId证件有效期校验
	 * @return
	 */
	@Action(value="expiredDateCheckByOpenId")
	public void expiredDateCheckByOpenId() {
		logger.info("****************get into expiredDateCheckByOpenId***************");
		HttpServletRequest request = super.getHttpServletRequest();
		Map<String, String> retMap = new HashMap<String, String>();
		String openId = request.getParameter("openId")==null? "":request.getParameter("openId");
		if(openId == null || "".equals(openId)){//openId为空
			retMap.put("code", "-1");
			retMap.put("message", "获取openId失败，请取消关注后再重新关注。如需帮助请致电客服专线4008109339");
		}else{
			String partyCode = null;
			List<GeMobileCustomer> customers = clientBindService.checkOpenID(openId);
			if(customers.size()==0){//未查到绑定客户
				retMap.put("code", "2");
				retMap.put("message", "该微信未绑定客户");
			}else{
				for(GeMobileCustomer temp:customers){
					if(temp.getType() != null && "1".equals(temp.getType())){//如果客户为长险
						partyCode = temp.getCoustomerid();
						break;
					}
				}
				if(partyCode == null || "".equals(partyCode)){
					retMap.put("code", "3");
					retMap.put("message", "未查到该客户在长险的相关信息。如需帮助请致电客服专线4008109339");
				}else{
					//校验客户证件有效期
					retMap = partyChangeService.expiredDateCheck(partyCode);
				}
			}
		}
		logger.info("openId:"+openId+",code:"+retMap.get("code")+",message:"+retMap.get("message"));
		logger.info("****************expiredDateCheckByOpenId end***************");
		this.renderJson(JSONObject.fromObject(retMap).toString());
	}

	/**
	 * 保单人员查询结果集格式化
	 * @param partyInfos
	 * @return
	 */
	public List<Map<String,String>> formatPartyInformation(PartyInformation[] partyInfos){
		List<Map<String,String>> list = new  ArrayList();
		HashMap<String,String> hm = null;
		String CardNo = "";
		String CardType = "";
		String ExpiredDate = "";
		for(PartyInformation partyInfo:partyInfos){
			if(partyInfo.getTCardInformation().length>0){
				//暂时单人无视多证件的情况
				CardInformation cardInfo = partyInfo.getTCardInformation(0);
				CardNo = cardInfo.getCardNo();
				CardType = IDTypeEntity.formatIDType("longType", "chineseType", cardInfo.getCardType());
				ExpiredDate = cardInfo.getExpiredDate();
			}
			hm = new HashMap();
			hm.put("name", partyInfo.getName());
			hm.put("partyCode", partyInfo.getPartyCode());
			hm.put("CardNo",CardNo);
			hm.put("CardType",CardType);
			hm.put("ExpiredDate", ExpiredDate);
			list.add(hm);
		}
		return list;

	}

	/**
	 * 输入地址返回省 市 名称
	 * @param address
	 * @param area_status
	 * @return
	 */
	public String findStateAndCityName(String address ,String area_status){
		String name = null;
		boolean flag = false;
		for(int i=1;i<address.length();i++){
			name = address.substring(0,i);
			String state_code = GeGeographicalAreafindService.findArea_code(name, area_status);
			if(state_code !=null){
				flag = true;
				break;
			}
		}
		if(flag){
			logger.info(name);
			return name;
		}else{
			return address;
		}
	}

	/**
	 * 一个字符串中包含另一个字符串几次
	 * @param text
	 * @param sub
	 * @return
	 */
	public static int count(String text,String sub){
	    int count =0, start =0;
	    while((start=text.indexOf(sub,start))>=0){
	        start += sub.length();
	        count ++;
	    }
	    return count;
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

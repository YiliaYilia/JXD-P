//package cn.com.sinosoft.web.action;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.ResourceBundle;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.struts2.convention.annotation.Action;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.w3c.dom.Document;
//
//import cn.com.sinosoft.common.WebServiceAgent;
//import cn.com.sinosoft.core.web.Struts2Action;
//import cn.com.sinosoft.domain.user.MobileCustomer;
//import cn.com.sinosoft.ess.product.service.PolicyMobileService;
//import cn.com.sinosoft.ess.protal.service.PolicySearch;
//
//
//public class PolicyMobileAction extends Struts2Action{
//	private static final long serialVersionUID = 1L;
//	private final static Logger logger = LoggerFactory.getLogger(PolicyMobileAction.class);
//	@Autowired
//	PolicyMobileService mobileService ;
//	@Autowired
//	MobileCustomer policyMain;
//	String weixinId;
//	@Action(value="getPolicyList")
//	public String getPolicyList(){
//		MobileCustomer policyMain = mobileService.getPolicyMobileMainAll(weixinId);
//		if(policyMain==null){
//			return "/page";
//		}
//		
//		return "";
//	}
//	/**
//	 * 根据四要素信息查询核心接口
//	 * @param policyMain
//	 * @return
//	 */
//	@Action(value="getListFromWeb")
//	public String getListFromWeb(MobileCustomer policyMain){
//		String name = policyMain.getName();
//		String idType= policyMain.getIdtype();
//		String idNo = policyMain.getIdnumber();
//		WebServiceAgent agent = new WebServiceAgent();
//		PolicyBinding info =new PolicyBinding();
//		String inputXML=info.requestXML(name, idType, idNo);
//		//读取配置文件
//		ResourceBundle resourceBundle = ResourceBundle.getBundle(""); 
//		String method = resourceBundle.getString("");
//		String url = resourceBundle.getString("");
//		String result = agent.getResult(inputXML, method, url);
//		MobileCustomer m = (MobileCustomer)info.responseXML(result,m);
//		m.setMicroid(weixinId);
//		mobileService.savePolicy(m);
//		super.setRequestAttribute("", m);
//		return "/page/";
//	}
//	
//	public String getWeixinId() {
//		return weixinId;
//	}
//	public void setWeixinId(String weixinId) {
//		this.weixinId = weixinId;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//}

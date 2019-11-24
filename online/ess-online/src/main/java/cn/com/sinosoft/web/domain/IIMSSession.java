package cn.com.sinosoft.web.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.sinosoft.common.service.axis.LinkWebLocator;
import cn.com.sinosoft.common.service.axis.LinkWebSoap_PortType;
import cn.com.sinosoft.common.service.axis.LoginMsg;
import cn.com.sinosoft.common.service.axis.LoginVO;


public class IIMSSession{
	private static Log logger = LogFactory.getLog(IIMSSession.class);
	private String roleType = "" ;
	private String sessionId = "" ;
	

	/**
	 * 获得SessionID
	 * @param coustomerid 登陆客户号
	 * @param passWord 客户号密码
	 * @return 接口返回代码
	 */
	public String login(String coustomerid,String passWord) {
		String flag = null;
		try {
			LinkWebLocator hts = new LinkWebLocator();
			LinkWebSoap_PortType detail = null;
			detail = hts.getLinkWebSoap();
			LoginMsg result= detail.login(coustomerid, passWord);
			String returnCode = result.getHeader().getReturnCode();
			String returnMsg = result.getHeader().getReturnMsg();
			LoginVO body = result.getBody();
			flag = returnCode;
			if("0".equals(returnCode)){
				roleType = body.getRoleType();
				sessionId = body.getSessionId();
				logger.info(coustomerid+"登录成功，已获得sessionId:"+sessionId);
			}else{
				logger.error("登录失败:code: "+returnCode+",msg: "+returnMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("登录异常:"+e);
		}
		return flag; 
	}
	

	public String getRoleType() {
		return roleType;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	
	public static void main(String[] args){
		String login = new IIMSSession().login("4155", "800521");
		System.out.println(login);
	}
}

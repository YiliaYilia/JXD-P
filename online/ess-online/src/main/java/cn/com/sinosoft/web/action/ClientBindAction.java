package cn.com.sinosoft.web.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.ClientBindModel;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.web.entity.IDTypeEntity;
import cn.com.sinosoft.web.service.facade.ClientBindService;
import cn.com.sinosoft.web.service.facade.SmsService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;

public class ClientBindAction extends Struts2Action{
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(ClientBindAction.class);
	@Autowired
	ClientBindService clientBindService;
	@Autowired
	SmsService smsService;
	/**
	 * 第一次进入收集OpenID
	 * @return
	 */
	@Action(value="firstLogin")
	public String firstLogin(){
		WeiXinServiceImpl weixin = new WeiXinServiceImpl();
		String OpenID = weixin.getOpenId(this.getHttpServletRequest());
		//String OpenID = "oipGbs9ck-qldsZUXQiv7YUQSh-A";
		this.setRequestAttribute("OpenID", OpenID);
		return "../page/index";
	}
	/**
	 * 功能：用户绑定
	 * 描述：响应页面绑定请求/请求核心绑定接口/公众号推送绑定成功结果
	 * 作者： ZhangTiancong
	 * @param	idType		证件类型
	 * @param	idNo		证件号码
	 * @param	clientName	用户姓名
	 * @param	OpenID		微信ID
	 * @return 成功返回"成功"|失败返回报文<失败原因> 
	 */
	@Action(value = "clientBind")
	public void clientBind(){
		String flag = "";
		String content = "";
		String resultsjon = "";
		HttpServletRequest request = super.getHttpServletRequest();
		String idType = request.getParameter("idType")==null?"":request.getParameter("idType");
		String idNo = request.getParameter("idNo")==null?"":request.getParameter("idNo").trim();
		String clientName = request.getParameter("clientName")==null?"":request.getParameter("clientName").trim();
		String OpenID = request.getParameter("OpenID");
		if(OpenID == null || "".equals(OpenID) || "null".equals(OpenID)){
			flag = "4";
			content = "绑定错误，请取消关注后再次关注本公众号。如需帮助请致电客服专线4008109339";
		}else{
			List<GeMobileCustomer> customersByTheOpenId = this.clientBindService.checkOpenID(OpenID);
			boolean result = clientBindService.checkCustomer(idType, idNo, clientName);//此投保人是否已经被某一手机绑定
			List<GeMobileCustomer> existCustomer = this.clientBindService.checkCustomer(idType, idNo, clientName, OpenID);
			if(existCustomer.size() > 0) {
		      flag = "1";
		      content = "您好，用户信息已绑定，无需再次绑定";
		    }else if(customersByTheOpenId.size() > 0) {
		      flag = "3";
		      content = "您好，您已进行过用户绑定，请勿再次绑定";
		    }else if(result){//投保人已经绑定了其它的openId
				flag = "4";
				content = "您好，用户绑定失败，如需帮助请致电客服专线4008109339";
				logger.info("绑定信息 openId："+OpenID+" 证件号："+idNo+" 绑定名："+clientName);
			}else {
				//查询长险
				ClientBindModel clientBind = clientBindService.clientBindQuery(IDTypeEntity.formatIDType("saveType","longType", idType), idNo, clientName,OpenID);
				boolean longResult = "0".equals(clientBind.getCode().toString());
				boolean shortResult = clientBindService.ShortClientBind(IDTypeEntity.formatIDType("saveType","shortType", idType), idNo, clientName,OpenID);
				logger.info("user:"+OpenID+" idNo:"+clientBind.getIdNo()+"|clientBind_long return:"+clientBind.getCode().toString()+"|"+clientBind.getContenct());
				logger.info("user:"+OpenID+"|clientBind_short return:"+(shortResult?"绑定成功":"绑定失败"));
				if(shortResult || longResult){//绑定成功
					WeiXinServiceImpl weixin = new WeiXinServiceImpl();
					weixin.sendMessage(OpenID,"绑定成功");
					flag = "0";
				}else{//绑定失败
					flag = "2";
					content = "您好，用户绑定失败，如需帮助请致电客服专线4008109339。";
				}
			}
		}
		resultsjon = "{\"flag\":\""+flag+"\",\"content\":\""+content+"\"}";
		logger.info("证件类型:"+idType+",证件号:"+idNo+",绑定名:"+clientName+",OpenID:"+OpenID+",绑定结果："+content+",flag:"+flag);
		super.renderJson(resultsjon);
	}
	
	/**
	 * 获取手机号
	 */
	@Action(value = "findPhone")
	public void findPhone(){
		String flag = "";
		String content = "";
		String resultsjon = "";
		HttpServletRequest request = super.getHttpServletRequest();
		String idType = request.getParameter("idType")==null?"":request.getParameter("idType");
		String idNo = request.getParameter("idNo")==null?"":request.getParameter("idNo").trim();
		String clientName = request.getParameter("clientName")==null?"":request.getParameter("clientName").trim();
		String OpenID = request.getParameter("OpenID");
		if(OpenID == null || "".equals(OpenID)){
			flag = "4";
			content = "绑定错误，请取消关注后再次关注本公众号。如需帮助请致电客服专线4008109339";
		}else{
			List<GeMobileCustomer> customersByTheOpenId = this.clientBindService.checkOpenID(OpenID);
			boolean result = clientBindService.checkCustomer(idType, idNo, clientName);//此投保人是否已经被某一手机绑定
			List<GeMobileCustomer> existCustomer = this.clientBindService.checkCustomer(idType, idNo, clientName, OpenID);
			if(existCustomer.size() > 0) {
				flag = "1";
			    content = "您好，用户信息已绑定，无需再次绑定";
			}else if(customersByTheOpenId.size() > 0) {
			    flag = "3";
			    content = "您好，您已进行过用户绑定，请勿再次绑定";
			}else if(result){//投保人已经绑定了其它的openId
				flag = "4";
				content = "您好，用户绑定失败，如需帮助请致电客服专线4008109339";
				logger.info("绑定信息 openId："+OpenID+" 证件号："+idNo+" 绑定名："+clientName);
			}else{
				flag="0";
				content = clientBindService.findPhone(idType, idNo, clientName,OpenID);
			}
		}
		logger.info("证件类型:"+idType+",证件号:"+idNo+",绑定名:"+clientName+",OpenID:"+OpenID+",绑定结果："+content+",flag:"+flag);
		resultsjon = "{\"flag\":\""+flag+"\",\"content\":\""+content+"\"}";
		super.renderJson(resultsjon);
	}
	
	/**
	 * 发送手机验证码
	 */
	@Action(value = "sendRandomVcode")
	public void sendRandomVcode(){
		String resultsjon = "";
		String resultCode = "";
		String Vcode = createRandomVcode();
		try {
			HttpServletRequest request = super.getHttpServletRequest();
			String mobile = request.getParameter("mobile")==null?"":request.getParameter("mobile");
			//String result = MessageUtil.sendMessage(mobile, "感谢使用，您的验证码："+Vcode+"，请在5分钟内使用，勿泄漏！非本人操作请致电客服。");
			smsService.send(mobile, "感谢使用，您的验证码："+Vcode+"，请在5分钟内使用，勿泄漏！非本人操作请致电客服。");
			resultCode = "2002";
			logger.info(mobile+"发送短信成功，验证码："+Vcode);
		} catch (Exception e) {
			resultCode = "9000";
			logger.error("发送短信异常："+e);
		}
		resultsjon = "{\"resultCode\":\""+resultCode+"\",\"Vcode\":\""+Vcode+"\"}";
		super.renderJson(resultsjon);
	}
	
	/**
	 * 功能：用户解除绑定
	 */
	@Action(value = "clientUnbind")
	public void clientUnbind(){
		//获取openId,根据openId查询客户绑定信息信息：若客户未绑定，则提示该客户未进行过绑定；否则，进行解绑并返回解绑成功
		Map<String,String> retMap = new HashMap<String,String>();
		HttpServletRequest request = super.getHttpServletRequest();
		String openId = request.getParameter("openId");
		if(openId == null || "".equals(openId) || "null".equals(openId)){
			retMap.put("flag", "2");
			retMap.put("content", "解绑错误，请取消关注后再次关注本公众号。如需帮助请致电客服专线4008109339");
		}else{
			List<GeMobileCustomer> mobileCustomers = this.clientBindService.checkOpenID(openId);
			if(mobileCustomers == null || mobileCustomers.size()==0){
				retMap.put("flag", "1");
				retMap.put("content", "解绑失败，未查到绑定客户。如需帮助请致电客服专线4008109339");
			}else{//解绑
				String customerids = "";
				for(GeMobileCustomer mobileCustomer:mobileCustomers){
					mobileCustomer.setDeleteTag("01");
					clientBindService.updateCustomer(mobileCustomer);
					customerids = customerids + mobileCustomer.getCoustomerid() + "、";
				}
				retMap.put("flag", "0");
				retMap.put("content", "解绑成功!");
				customerids = customerids.length()==0?"":customerids.substring(0, customerids.length()-1);
				retMap.put("customerids", customerids);
			}
		}
		logger.info("openId:"+openId+",客户号:" + retMap.get("customerids") + ",flag:"+ retMap.get("flag") + ",解绑结果:" + retMap.get("content"));
		super.renderJson(JSONObject.fromObject(retMap).toString());
	}
	
    /**
     * 随机生成4位随机验证码
     */
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 4; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
    
}

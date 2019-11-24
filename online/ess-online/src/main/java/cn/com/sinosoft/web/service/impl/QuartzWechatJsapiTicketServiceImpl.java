package cn.com.sinosoft.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.web.domain.Token;
import cn.com.sinosoft.web.listener.client.SocketClient;
import cn.com.sinosoft.web.service.facade.QuartzWechatJsapiTicketService;
import cn.com.sinosoft.web.util.CommonUtil;

@Component
@Service("quartzWechatJsapiTicketService")
public class QuartzWechatJsapiTicketServiceImpl implements QuartzWechatJsapiTicketService {

	private static Logger log = LoggerFactory.getLogger(QuartzWechatJsapiTicketServiceImpl.class);
	
	public void doTaskJsapiTicket() {
		WeiXinServiceImpl weixin = new WeiXinServiceImpl();
		log.info("Get wechat jsapi_ticket is start.");
		Token token = CommonUtil.getToken(weixin.getId("AppId"), weixin.getId("AppSecret"));
        String access_token = token.getAccessToken();
        String ticket = weixin.getTicket(access_token);
        	if(ticket==null){
        		log.info("重新获取token开始");
        		token = CommonUtil.getToken(weixin.getId("AppId"), weixin.getId("AppSecret"));
        		access_token = token.getAccessToken();
        		ticket = weixin.getTicket(access_token);
        		log.info("已重新获取ticket"+ticket);
        		log.info("重新获取token结束");
        	}
		if(ticket!=null){
			token.setTicket(ticket);
		}
		log.info("Get wechat jsapi_ticket is end.");
	}
	
	/**
	 * 从socket中获取
	 */
	public void doTaskJsapiTicketBySocket() {
		String access_token =null;
		String ticket=null;
		Map<String, String> tokenTicket = new HashMap<String, String>();
		try {
			log.info("Get wechat jsapi_ticket by socket is start.");
			tokenTicket = SocketClient.send();
			if(tokenTicket!=null){
				access_token = tokenTicket.get("accessToken");
				ticket = tokenTicket.get("ticket");
			}
			log.info("access_token:"+access_token);
			Token token = Token.getToken();
			token.getInstance(access_token);
	    	log.info("ticket:"+ticket);
			if(ticket!=null){
				token.setTicket(ticket);
			}
			log.info("Get wechat jsapi_ticket by socket is end.");
		} catch (Exception e) {
			log.error("##定时获取socket中token数据异常："+e.getMessage()+" access_token:"+access_token);
			// TODO: handle exception
		}
	}

}

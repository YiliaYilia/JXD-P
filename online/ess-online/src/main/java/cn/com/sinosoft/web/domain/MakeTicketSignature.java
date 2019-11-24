package cn.com.sinosoft.web.domain;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;
import cn.com.sinosoft.web.util.SHA1;

public class MakeTicketSignature {
	private String jsapi_ticket;
	private String noncestr;
	private String timestamp;
	private String url;
	private String signature;
	private String appid;
	
	public MakeTicketSignature(){
		Token token = Token.getInstance();
		if(token==null){
			jsapi_ticket = "";
		}else{
			jsapi_ticket = token.getTicket();
		}
		timestamp = Long.toString(System.currentTimeMillis()/1000);
		noncestr = "u8dgh1c9UCMoQ2Tj";
	}
	public String getSignature(String url){
		this.url = url;
		 SHA1 sha1 = new SHA1();
		 String str = "jsapi_ticket="+jsapi_ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
		 signature = sha1.getDigestOfString(str.getBytes());
		 return signature;
	}

	public String getAppid(){
		return WeiXinServiceImpl.getId("AppId");
	}
	
	public String getTimestamp(){
		return timestamp;
	}
	
	public String getNoncestr(){
		return noncestr;
	}
}

package cn.com.sinosoft.weixin.util;



import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.IOException;
import org.jdom.JDOMException;

public class ClientResponseHandler {
	private String content;
	
	private SortedMap parameters; 

	private String debugInfo;
	
	private String key;
	
	private String charset;
	
	public ClientResponseHandler() {
		this.content = "";
		this.parameters = new TreeMap();
		this.debugInfo = "";
		this.key = "";
		this.charset = "UTF-8";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) throws Exception {
		this.content = content;
		
		this.doParse();
	}

	public String getParameter(String parameter) {
		String s = (String)this.parameters.get(parameter); 
		return (null == s) ? "" : s;
	}

	public void setParameter(String parameter, String parameterValue) {
		String v = "";
		if(null != parameterValue) {
			v = parameterValue.trim();
		}
		this.parameters.put(parameter, v);
	}

	public SortedMap getAllParameters() {
		return this.parameters;
	}	

	public String getDebugInfo() {
		return debugInfo;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getCharset() {
		return this.charset;
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}	
	
	public boolean isTenpaySign() {
		StringBuffer sb = new StringBuffer();
		Set es = this.parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			if(!"sign".equals(k) && null != v && !"".equals(v)) {
				sb.append(k + "=" + v + "&");
			}
		}
		
		sb.append("key=" + this.getKey());
		

		String sign = MD5Util.MD5Encode(sb.toString(), this.charset).toLowerCase();
		
		String tenpaySign = this.getParameter("sign").toLowerCase();
	
		this.setDebugInfo(sb.toString() + " => sign:" + sign +
				" tenpaySign:" + tenpaySign);
		
		return tenpaySign.equals(sign);
	}
	
	protected boolean isTenpaySign(String signParameterArray[]) {

		StringBuffer signPars = new StringBuffer();
		for(int index = 0; index < signParameterArray.length; index++) {
			String k = signParameterArray[index];
			String v = this.getParameter(k);
			if(null != v && !"".equals(v)) {
				signPars.append(k + "=" + v + "&");
			}
		}
		
		signPars.append("key=" + this.getKey());
				
		String sign = MD5Util.MD5Encode(
				signPars.toString(), this.charset).toLowerCase();
		
		String tenpaySign = this.getParameter("sign").toLowerCase();

		this.setDebugInfo(signPars.toString() + " => sign:" + sign +
				" tenpaySign:" + tenpaySign);
		
		return tenpaySign.equals(sign);
	}
	

	protected void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}
	
	protected void doParse() throws JDOMException, IOException {
		String xmlContent = this.getContent();

		Map m = XMLUtil.doXMLParse(xmlContent);

		Iterator it = m.keySet().iterator();
		while(it.hasNext()) {
			String k = (String) it.next();
			String v = (String) m.get(k);
			this.setParameter(k, v);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		String aa="<xml><appid><![CDATA[wxf7976813f2c4c421]]></appid>"+
"<attach><![CDATA[微信]]></attach>"+
"<bank_type><![CDATA[CFT]]></bank_type>"+
"<cash_fee><![CDATA[1]]></cash_fee>"+
"<fee_type><![CDATA[CNY]]></fee_type>"+
"<is_subscribe><![CDATA[Y]]></is_subscribe>"+
"<mch_id><![CDATA[1237340702]]></mch_id>"+
"<nonce_str><![CDATA[2xhBm96biO3U2XzgtwzIMVDntts3tMWu]]></nonce_str>"+
"<openid><![CDATA[oeYOqs8OH2CfV3WJHdQvBkYXK-mE]]></openid>"+
"<out_trade_no><![CDATA[E10010114120915330813]]></out_trade_no>"+
"<result_code><![CDATA[SUCCESS]]></result_code>"+
"<return_code><![CDATA[SUCCESS]]></return_code>"+
"<sign><![CDATA[C357750F4527B1BE79D07765F5796347]]></sign>"+
"<time_end><![CDATA[20150603150247]]></time_end>"+
"<total_fee>1</total_fee>"+
"<trade_type><![CDATA[NATIVE]]></trade_type>"+
"<transaction_id><![CDATA[1003310499201506030202686299]]></transaction_id>"+
"</xml>";
		ClientResponseHandler  handler = new ClientResponseHandler();
		handler.setContent(aa);
		handler.getParameter("bank_type");
	}
}

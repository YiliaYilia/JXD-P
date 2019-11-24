package cn.com.sinosoft.ess.protal.payment;

public class PaymentConfig {
	//商户号，上线时务必将测试商户号替换为正式商户号
	public static String PARTNER = "1900000109";
	//密钥
	public static String KEY = "8934e7d15453e97507ef794cf7b0519d";
	//交易完成后跳转的URL
	public static String RETURN_URL = "http://localhost:9003/online/sale/investmentlinked/paymentResult";
	//接收财付通通知的URL
	public static String NOTIFY_URL = "http://localhost:9003/online/sale/investmentlinked/paymentResult";
	//财付通支付请求URL
	public static String GATE_URL ="https://gw.tenpay.com/gateway/pay.htm";
	/*系统可选参数*/
	//签名方式
	public static String SIGN_TYPE = "MD5";
	//接口版本
	public static String SERVICE_VERSION = "1.0";
	//字符集
	public static String INPUT_CHARSET = "UTF-8";
	//密钥序号
	public static String SIGN_KEY_INDEX = "1";
	//币种
	public static String FEE_TYPE = "1";
}

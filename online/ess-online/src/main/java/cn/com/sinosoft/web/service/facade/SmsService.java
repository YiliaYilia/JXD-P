package cn.com.sinosoft.web.service.facade;

/**
 * 短信服务接口
 * @author Yunxia.Guo
 *
 */
public interface SmsService {
	/**
	 * 向指定的移动电话发送短信息。
	 * 
	 * @param phoneNo 接受短信息的移动电话号码。
	 * @param message 要发送的信息。
	 */
	void send(String phoneNo, String message);
}

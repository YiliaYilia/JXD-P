package cn.com.sinosoft.exception.mail;

/**
 * 描述：<br>
 * 作者：zhangminghua <br>
 * 修改日期：2013-12-11下午6:19:38 <br>
 * E-mail:  <br>
 */
public class SendMailException extends Exception {
	/**
	 * MailException.java 
	 */
	private static final long serialVersionUID = 1L;

	public SendMailException() {
		super();
	}

	public SendMailException(String msg) {
		super(msg);
	}

	public SendMailException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public SendMailException(Throwable cause) {
		super(cause);
	}
}

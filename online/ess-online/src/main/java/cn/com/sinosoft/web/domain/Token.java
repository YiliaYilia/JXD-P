package cn.com.sinosoft.web.domain;

import com.oldmutual.util.TokenUtil;

/**
 * 
 * @author Yunxia.Guo
 *
 */
public class Token {
	private static Token token;
	private static TokenUtil tokenUtil = new TokenUtil();
	private String accessToken;
	private int expiresIn;
	private String ticket;

	private Token() {
	}

	public Token(String accessToken, String ticket) {
		this.accessToken = accessToken;
		this.ticket = ticket;
	}

	public static Token getInstance(String accessToken, int expiresIn) {
		return new Token(tokenUtil.getAccessToken(), tokenUtil.getTicket());
	}

	public static Token getInstance(String accessToken) {
		return new Token(tokenUtil.getAccessToken(), tokenUtil.getTicket());
	}

	public static Token getInstance() {
		return new Token(tokenUtil.getAccessToken(), tokenUtil.getTicket());
	}

	public static void destroy() {
		token = null;
	}

	public static Token getToken() {
		return new Token(tokenUtil.getAccessToken(), tokenUtil.getTicket());
	}

	public String getAccessToken() {
		return tokenUtil.getAccessToken();
	}

	private void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return this.expiresIn;
	}

	private void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getTicket() {
		return tokenUtil.getTicket();
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	private void startDaemon() {
		TokenCheckThread thread = new TokenCheckThread();
		thread.setExpiresTime(this.expiresIn);
		Thread t = new Thread(thread);
		t.start();
	}

	public static void main(String[] args) {
		TokenUtil tokenUtil = new TokenUtil();
		System.out.println(tokenUtil.getAccessToken());
	}
}

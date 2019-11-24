package cn.com.sinosoft.web.domain;


public class TokenCheckThread implements Runnable {
	
	 private int expiresTime;

	public void setExpiresTime(int expiresIn){
		expiresTime = expiresIn;
	}
	
	public void run() {
		try {
			Thread.sleep(1000*expiresTime);
			if(Token.getToken()!=null){
				Token.destroy();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

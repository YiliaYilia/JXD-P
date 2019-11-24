package cn.com.sinosoft.domain.yinbaotongWKB;

public class Accounts {
	private String AccountCount;//交费帐户个数 

	public String getAccountCount() {
		return AccountCount;
	}

	public void setAccountCount(String accountCount) {
		AccountCount = accountCount;
	}

	public Accounts(String accountCount) {
		super();
		AccountCount = accountCount;
	}

	public Accounts() {
		super();
	}
	
}

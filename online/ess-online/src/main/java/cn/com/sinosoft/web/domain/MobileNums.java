package cn.com.sinosoft.web.domain;

import java.util.List;

public class MobileNums{
	private List<String> MobileNum;
	
	public MobileNums() {
		super();
	}

	public MobileNums(List<String> mobileNum) {
		super();
		MobileNum = mobileNum;
	}

	public List<String> getMobileNum() {
		return MobileNum;
	}

	public void setMobileNum(List<String> mobileNum) {
		MobileNum = mobileNum;
	}
}

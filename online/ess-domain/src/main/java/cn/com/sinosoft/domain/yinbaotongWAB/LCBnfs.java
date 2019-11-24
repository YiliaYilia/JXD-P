package cn.com.sinosoft.domain.yinbaotongWAB;

import java.util.List;


public class LCBnfs {
	private String LCBnfCount; //受益人个数
	private List<LCBnf> LCBnf; //受益人信息
	
	public String getLCBnfCount() {
		return LCBnfCount;
	}
	public void setLCBnfCount(String lCBnfCount) {
		LCBnfCount = lCBnfCount;
	}
	public List<LCBnf> getLCBnf() {
		return LCBnf;
	}
	public void setLCBnf(List<LCBnf> lCBnf) {
		LCBnf = lCBnf;
	}
	public LCBnfs(String lCBnfCount,
			List<cn.com.sinosoft.domain.yinbaotongWAB.LCBnf> lCBnf) {
		super();
		LCBnfCount = lCBnfCount;
		LCBnf = lCBnf;
	}
	public LCBnfs(){
		super();
	}
	
}

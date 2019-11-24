package cn.com.sinosoft.domain.yinbaotongWKB;
/**
 * 险种受益人信息
 * @author lwy
 */
public class LCBnfs {
	private String LCBnfCount;//受益人个数
	private LCBnf LCBnf;//受益人信息
	
	public LCBnfs() {
		super();
	}
	public LCBnfs(String lCBnfCount, LCBnf lCBnf) {
		super();
		LCBnfCount = lCBnfCount;
		LCBnf = lCBnf;
	}
	public String getLCBnfCount() {
		return LCBnfCount;
	}
	public void setLCBnfCount(String lCBnfCount) {
		LCBnfCount = lCBnfCount;
	}
	public LCBnf getLCBnf() {
		return LCBnf;
	}
	public void setLCBnf(LCBnf lCBnf) {
		LCBnf = lCBnf;
	}
	
}

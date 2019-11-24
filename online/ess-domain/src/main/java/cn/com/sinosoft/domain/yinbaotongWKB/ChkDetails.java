package cn.com.sinosoft.domain.yinbaotongWKB;

import java.util.List;

public class ChkDetails {
	private String chkDetailCount;//对账的保单数量
	private List<ChkDetail> ChkDetail;//需要对账的保单实体
	public String getChkDetailCount() {
		return chkDetailCount;
	}
	public void setChkDetailCount(String chkDetailCount) {
		this.chkDetailCount = chkDetailCount;
	}
	public List<ChkDetail> getChkDetail() {
		return ChkDetail;
	}
	public void setChkDetail(List<ChkDetail> chkDetail) {
		this.ChkDetail = chkDetail;
	}
	public ChkDetails() {
		super();
	}
	public ChkDetails(String chkDetailCount, List<ChkDetail> chkDetail) {
		super();
		this.chkDetailCount = chkDetailCount;
		this.ChkDetail = chkDetail;
	}
	
}

package cn.com.sinosoft.domain.yinbaotongWKB;

import java.util.List;

public class Risks {
	private int RiskCount;//险种个数
	private List<Risk> risk;
	
	public Risks() {
		super();
	}
	public Risks(int riskCount, List<Risk>  risk) {
		super();
		RiskCount = riskCount;
		this.risk = risk;
	}
	public int getRiskCount() {
		return RiskCount;
	}
	public void setRiskCount(int riskCount) {
		RiskCount = riskCount;
	}
	public List<Risk> getRisk() {
		return risk;
	}
	public void setRisk(List<Risk> risk) {
		this.risk = risk;
	}

	
}

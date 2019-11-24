package cn.com.sinosoft.domain.yinbaotongWAB;

public class Risks {
	private int RiskCount;//险种个数
	private Risk Risk;
	
	public Risks() {
		super();
	}
	public Risks(int riskCount, Risk risk) {
		super();
		RiskCount = riskCount;
		Risk = risk;
	}
	public int getRiskCount() {
		return RiskCount;
	}
	public void setRiskCount(int riskCount) {
		RiskCount = riskCount;
	}
	public Risk getRisk() {
		return Risk;
	}
	public void setRisk(Risk risk) {
		Risk = risk;
	}
	
}

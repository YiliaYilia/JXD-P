package cn.com.sinosoft.ess.protal.model.insure;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


/**
 * 描述：保单信息<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-12上午11:03:43 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
//@XmlType(name="Body")
public class LCContReq {
	private String proposalContNo;			//保单号 
	private String polApplyDate;			//投保日期
	private String getPolMode;				//保单递送方式
	private String healthNotice;			//健康告知(N/Y)
	private String contractEffDate;			//客户指定生效日期，若无指定请置空
	private String disCount;				//保费折扣，6折
	private String referrer;				//推荐人姓名/会员号/营销代码
	private String reMobile;				//推荐人手机号
	private LCAppntReq LCAppnt;				//投保人信息
	private List<LCInsuredReq> LCInsureds;	//被保人信息
	private List<LCBnfReq> LCBnfs;			//受益人信息
	private List<RiskReq> risks;			//责任
	
	@XmlElement(name="Risk")
	public List<RiskReq> getRisks() {
		return risks;
	}

	public void setRisks(List<RiskReq> risks) {
		this.risks = risks;
	}

	@XmlElement(name="ProposalPrtNo")
	public String getProposalContNo() {
		return proposalContNo;
	}
	public void setProposalContNo(String proposalContNo) {
		this.proposalContNo = proposalContNo;
	}
	
	@XmlElement(name="PolApplyDate")
	public String getPolApplyDate() {
		return polApplyDate;
	}
	public void setPolApplyDate(String polApplyDate) {
		this.polApplyDate = polApplyDate;
	}
	
	@XmlElement(name="GetPolMode")
	public String getGetPolMode() {
		return getPolMode;
	}
	public void setGetPolMode(String getPolMode) {
		this.getPolMode = getPolMode;
	}
	
	@XmlElement(name="HealthNotice")
	public String getHealthNotice() {
		return healthNotice;
	}
	public void setHealthNotice(String healthNotice) {
		this.healthNotice = healthNotice;
	}
	
	@XmlElement(name="Appnt")
	public LCAppntReq getLCAppnt() {
		return LCAppnt;
	}
	public void setLCAppnt(LCAppntReq lCAppnt) {
		LCAppnt = lCAppnt;
	}
	
	//@XmlElementWrapper(name = "LCInsureds") 
    @XmlElement(name = "Insured") 
	public List<LCInsuredReq> getLCInsureds() {
		return LCInsureds;
	}
	public void setLCInsureds(List<LCInsuredReq> lCInsureds) {
		LCInsureds = lCInsureds;
	}
	
	//@XmlElementWrapper(name = "LCBnfs") 
    @XmlElement(name = "Bnf") 
	public List<LCBnfReq> getLCBnfs() {
		return LCBnfs;
	}
	public void setLCBnfs(List<LCBnfReq> lCBnfs) {
		LCBnfs = lCBnfs;
	}

	@XmlElement(name = "ContractEffDate") 
	public String getContractEffDate() {
		return contractEffDate;
	}

	public void setContractEffDate(String contractEffDate) {
		this.contractEffDate = contractEffDate;
	}

	@XmlElement(name = "DisCount")
	public String getDisCount() {
		return disCount;
	}

	public void setDisCount(String disCount) {
		this.disCount = disCount;
	}

	@XmlElement(name = "Referrer") 
	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	@XmlElement(name = "ReMobile")
	public String getReMobile() {
		return reMobile;
	}

	public void setReMobile(String reMobile) {
		this.reMobile = reMobile;
	}
}

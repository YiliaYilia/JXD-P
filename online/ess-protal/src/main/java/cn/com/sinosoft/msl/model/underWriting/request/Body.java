package cn.com.sinosoft.msl.model.underWriting.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"tranSchnl","aPPChannel","zoneNo","proposalPrtNo","polApplyDate","contractEffDate","disCount","beneficType","applicant","insured",
		"beneficiary"})
public class Body {

	/*渠道代码*/
	private String tranSchnl="";
	/*来源代码，移动端：Mini Site，PC端：Web site*/
	private String aPPChannel="";
	/*地区编码,保单签署地，所属省代码*/
	private String zoneNo="";
	/*订单号*/
	private String proposalPrtNo="";
	/*投保日期*/
	private String polApplyDate="";
	/*客户指定生效日期，若无指定请置空*/
	private String contractEffDate="";
	/*保费折扣*/
	private String disCount="";
	/*受益人是否法定*/
	private String beneficType="";
	/*投保人*/
	private Applicant applicant;
	/*被保人*/
	private List<Insured> insured;
	/*受益人*/
	private List<Beneficiary> beneficiary;
	
	@XmlElement(name="TranSchnl")
	public String getTranSchnl() {
		return tranSchnl;
	}
	public void setTranSchnl(String tranSchnl) {
		this.tranSchnl = tranSchnl;
	}
	@XmlElement(name="APPChannel")
	public String getaPPChannel() {
		return aPPChannel;
	}
	public void setaPPChannel(String aPPChannel) {
		this.aPPChannel = aPPChannel;
	}
	@XmlElement(name="ZoneNo")
	public String getZoneNo() {
		return zoneNo;
	}
	
	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}
	@XmlElement(name="ProposalPrtNo")
	public String getProposalPrtNo() {
		return proposalPrtNo;
	}
	public void setProposalPrtNo(String proposalPrtNo) {
		this.proposalPrtNo = proposalPrtNo;
	}
	@XmlElement(name="PolApplyDate")
	public String getPolApplyDate() {
		return polApplyDate;
	}
	public void setPolApplyDate(String polApplyDate) {
		this.polApplyDate = polApplyDate;
	}
	@XmlElement(name="ContractEffDate")
	public String getContractEffDate() {
		return contractEffDate;
	}
	public void setContractEffDate(String contractEffDate) {
		this.contractEffDate = contractEffDate;
	}
	@XmlElement(name="DisCount")
	public String getDisCount() {
		return disCount;
	}
	
	public void setDisCount(String disCount) {
		this.disCount = disCount;
	}
	@XmlElement(name="BeneficType")
	public String getBeneficType() {
		return beneficType;
	}
	public void setBeneficType(String beneficType) {
		this.beneficType = beneficType;
	}
	
	@XmlElement(name="Appnt")
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	@XmlElement(name="Insured")
	public List<Insured> getInsured() {
		return insured;
	}
	public void setInsured(List<Insured> insured) {
		this.insured = insured;
	}
	@XmlElement(name="Bnf")
	public List<Beneficiary> getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(List<Beneficiary> beneficiary) {
		this.beneficiary = beneficiary;
	}
	
	
	
}

package cn.com.sinosoft.msl.model.underWriting.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder={"contNo","transNo","proposalPrtNo"})
public class Body {

	/*保单号*/
	private String contNo;
	/*交易流水号*/
	private String transNo;
	/*订单号*/
	private String proposalPrtNo;

	@XmlElement(name="ContNo")
	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	@XmlElement(name="TransNo")
	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	@XmlElement(name="ProposalPrtNo")
	public String getProposalPrtNo() {
		return proposalPrtNo;
	}

	public void setProposalPrtNo(String proposalPrtNo) {
		this.proposalPrtNo = proposalPrtNo;
	}
	
	
}

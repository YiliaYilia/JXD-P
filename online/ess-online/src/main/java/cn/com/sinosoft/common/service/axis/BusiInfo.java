package cn.com.sinosoft.common.service.axis;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BUSIINFO")
public class BusiInfo {
	private  String business;
	private  String docid;
	private  String imagepages;
	private  String proteam;
	private  String insuredid;
	private  String policyid;
	private  String insuredname;
	private  String clerk;
	private  String way;
	private  String guidangtime;
	private  String orgid;
	private  String clerkOrgId;
	private  String claimappid;
	private  String policyappid;
	
	public BusiInfo() {
	}
	public BusiInfo(String business, String docid, String imagepages,
			String proteam, String insuredid, String policyid,
			String insuredname, String clerk, String way, String guidangtime,
			String orgid, String clerkOrgId) {
		super();
		this.business = business;
		this.docid = docid;
		this.imagepages = imagepages;
		this.proteam = proteam;
		this.insuredid = insuredid;
		this.policyid = policyid;
		this.insuredname = insuredname;
		this.clerk = clerk;
		this.way = way;
		this.guidangtime = guidangtime;
		this.orgid = orgid;
		this.clerkOrgId = clerkOrgId;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getImagepages() {
		return imagepages;
	}
	public void setImagepages(String imagepages) {
		this.imagepages = imagepages;
	}
	public String getProteam() {
		return proteam;
	}
	public void setProteam(String proteam) {
		this.proteam = proteam;
	}
	public String getInsuredid() {
		return insuredid;
	}
	public void setInsuredid(String insuredid) {
		this.insuredid = insuredid;
	}
	public String getPolicyid() {
		return policyid;
	}
	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}
	public String getInsuredname() {
		return insuredname;
	}
	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	public String getClerk() {
		return clerk;
	}
	public void setClerk(String clerk) {
		this.clerk = clerk;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getGuidangtime() {
		return guidangtime;
	}
	public void setGuidangtime(String guidangtime) {
		this.guidangtime = guidangtime;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getClerkOrgId() {
		return clerkOrgId;
	}
	public void setClerkOrgId(String clerkOrgId) {
		this.clerkOrgId = clerkOrgId;
	}
	public String getClaimappid() {
		return claimappid;
	}
	public void setClaimappid(String claimappid) {
		this.claimappid = claimappid;
	}
	public String getPolicyappid() {
		return policyappid;
	}
	public void setPolicyappid(String policyappid) {
		this.policyappid = policyappid;
	}
	

}

package cn.com.sinosoft.dto.sell;

import java.util.Date;
import java.util.List;

public class PolicyDto {
	private String total;
	private List<PolicyRow> rows;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<PolicyRow> getRows() {
		return rows;
	}
	public void setRows(List<PolicyRow> rows) {
		this.rows = rows;
	}
	
	public static class PolicyRow{
		private String policyno;
		private String applicantcode;
		private String policycode;
		private String prodoctname;
		private Date insuretime;
		private String applicantname;
		private String insuredname;
		private Date takeeffecttime;
		private Date deadlinetime;
		private Double sumpremium; //总保费
		private Double sumamount; //总保额
		private String status;
		private String condition;
		private String productname;
		private Double sumbasepremium;
		private String flowno; //
		private String preferentialcode;
		private String agentcode;
		private String brno;
		private String deptid;
		private String bankaccountnumber;
		
		
		


		public String getBankaccountnumber() {
			return bankaccountnumber;
		}

		public void setBankaccountnumber(String bankaccountnumber) {
			this.bankaccountnumber = bankaccountnumber;
		}

		public String getPolicyno() {
			return policyno;
		}

		public void setPolicyno(String policyno) {
			this.policyno = policyno;
		}

		public String getApplicantcode() {
			return applicantcode;
		}

		public void setApplicantcode(String applicantcode) {
			this.applicantcode = applicantcode;
		}

		public String getPolicycode() {
			return policycode;
		}

		public void setPolicycode(String policycode) {
			this.policycode = policycode;
		}

		public String getProdoctname() {
			return prodoctname;
		}

		public void setProdoctname(String prodoctname) {
			this.prodoctname = prodoctname;
		}

		public Date getInsuretime() {
			return insuretime;
		}

		public void setInsuretime(Date insuretime) {
			this.insuretime = insuretime;
		}

		public String getApplicantname() {
			return applicantname;
		}

		public void setApplicantname(String applicantname) {
			this.applicantname = applicantname;
		}

		public String getInsuredname() {
			return insuredname;
		}

		public void setInsuredname(String insuredname) {
			this.insuredname = insuredname;
		}

		public Date getTakeeffecttime() {
			return takeeffecttime;
		}

		public void setTakeeffecttime(Date takeeffecttime) {
			this.takeeffecttime = takeeffecttime;
		}

		public Date getDeadlinetime() {
			return deadlinetime;
		}

		public void setDeadlinetime(Date deadlinetime) {
			this.deadlinetime = deadlinetime;
		}

		public Double getSumamount() {
			return sumamount;
		}

		public void setSumamount(Double sumamount) {
			this.sumamount = sumamount;
		}

		public Double getSumpremium() {
			return sumpremium;
		}

		public void setSumpremium(Double sumpremium) {
			this.sumpremium = sumpremium;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;	
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		public Double getSumbasepremium() {
			return sumbasepremium;
		}

		public void setSumbasepremium(Double sumbasepremium) {
			this.sumbasepremium = sumbasepremium;
		}

		public String getFlowno() {
			return flowno;
		}

		public void setFlowno(String flowno) {
			this.flowno = flowno;
		}

		public String getPreferentialcode() {
			return preferentialcode;
		}

		public void setPreferentialcode(String preferentialcode) {
			this.preferentialcode = preferentialcode;
		}

		public String getAgentcode() {
			return agentcode;
		}

		public void setAgentcode(String agentcode) {
			this.agentcode = agentcode;
		}

		public String getBrno() {
			return brno;
		}

		public void setBrno(String brno) {
			this.brno = brno;
		}

		public String getDeptid() {
			return deptid;
		}

		public void setDeptid(String deptid) {
			this.deptid = deptid;
		}
		
	}
}
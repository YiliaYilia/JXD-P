package cn.com.sinosoft.dto.sell;

import java.util.Date;
import java.util.List;
import java.util.Set;

import cn.com.sinosoft.domain.sell.GePolicy;

public class OrderDto {
	private String total;
	private List<OrderRow> rows;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<OrderRow> getRows() {
		return rows;
	}
	public void setRows(List<OrderRow> rows) {
		this.rows = rows;
	}
	
	public static class OrderRow{
		private String orderno;
		private String ordercode;
		private String paystatus;
		private String status; //对账状态
		private String coreproductcode;//产品编号
		private Date paytime;
		private Date createdate;
		private String distributionstatus;
		private String recipientname;
		private String healthflag;
		private Date submittime;//创建时间
		private String applicantname;//投保人姓名
		private String policyno;
		private String productname;
		private String circpaymentno;
		private double orderamount;
		private String gatewayrno;
		private String policyStatus; //保单状态
		private String agentCode; //推荐码
		private String preferentialCode; //活动码
		private String deptid;
		
		
		public String getOrderno() {
			return orderno;
		}
		public void setOrderno(String orderno) {
			this.orderno = orderno;
		}
		public String getOrdercode() {
			return ordercode;
		}
		public void setOrdercode(String ordercode) {
			this.ordercode = ordercode;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getPaystatus() {
			return paystatus;
		}
		public void setPaystatus(String paystatus) {
			this.paystatus = paystatus;
		}
		public Date getPaytime() {
			return paytime;
		}
		public void setPaytime(Date paytime) {
			this.paytime = paytime;
		}
		public Date getCreatedate() {
			return createdate;
		}
		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}
		public String getDistributionstatus() {
			return distributionstatus;
		}
		public void setDistributionstatus(String distributionstatus) {
			this.distributionstatus = distributionstatus;
		}
		public String getRecipientname() {
			return recipientname;
		}
		public void setRecipientname(String recipientname) {
			this.recipientname = recipientname;
		}
		public double getOrderamount() {
			return orderamount;
		}
		public void setOrderamount(double orderamount) {
			this.orderamount = orderamount;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getCoreproductcode() {
			return coreproductcode;
		}
		public void setCoreproductcode(String coreproductcode) {
			this.coreproductcode = coreproductcode;
		}
		public String getHealthflag() {
			return healthflag;
		}
		public void setHealthflag(String healthflag) {
			this.healthflag = healthflag;
		}
		
		public Date getSubmittime() {
			return submittime;
		}
		public void setSubmittime(Date submittime) {
			this.submittime = submittime;
		}
		public String getApplicantname() {
			return applicantname;
		}
		public void setApplicantname(String applicantname) {
			this.applicantname = applicantname;
		}
		public String getPolicyno() {
			return policyno;
		}
		public void setPolicyno(String policyno) {
			this.policyno = policyno;
		}
		public String getCircpaymentno() {
			return circpaymentno;
		}
		public void setCircpaymentno(String circpaymentno) {
			this.circpaymentno = circpaymentno;
		}
		public String getGatewayrno() {
			return gatewayrno;
		}
		public void setGatewayrno(String gatewayrno) {
			this.gatewayrno = gatewayrno;
		}
		public String getPolicyStatus() {
			return policyStatus;
		}
		public void setPolicyStatus(String policyStatus) {
			this.policyStatus = policyStatus;
		}
		public String getAgentCode() {
			return agentCode;
		}
		public void setAgentCode(String agentCode) {
			this.agentCode = agentCode;
		}
		public String getPreferentialCode() {
			return preferentialCode;
		}
		public void setPreferentialCode(String preferentialCode) {
			this.preferentialCode = preferentialCode;
		}
		public String getDeptid() {
			return deptid;
		}
		public void setDeptid(String deptid) {
			this.deptid = deptid;
		}
		
	}
}

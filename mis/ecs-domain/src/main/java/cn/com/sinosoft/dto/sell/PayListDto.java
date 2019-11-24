package cn.com.sinosoft.dto.sell;

import java.util.Date;
import java.util.List;


public class PayListDto {
	private String total;
	private List<PayListRow> rows;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<PayListRow> getRows() {
		return rows;
	}
	public void setRows(List<PayListRow> rows) {
		this.rows = rows;
	}
	public static class PayListRow{
		private String id;//主键
		private String orderid;//订单号
		private String microordercode;//微信订单号
		private String activecode;//活动码
		private String channelcode;//渠道编码
		private String paytype;//支付方式
		private String mount;//金额
		private Date paytime;//支付时间
		private String isback;//是否退款
		private String remark;//备注
		private String bank; //
		private String bankaccountnumber; //
		private String applicantname;//投保人姓名
		private String policyno; //保单号
		private String productname; //产品名称
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getOrderid() {
			return orderid;
		}
		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}
		public String getActivecode() {
			return activecode;
		}
		public void setActivecode(String activecode) {
			this.activecode = activecode;
		}
		public String getChannelcode() {
			return channelcode;
		}
		public void setChannelcode(String channelcode) {
			this.channelcode = channelcode;
		}
		public String getPaytype() {
			return paytype;
		}
		public void setPaytype(String paytype) {
			this.paytype = paytype;
		}
		public String getMount() {
			return mount;
		}
		public void setMount(String mount) {
			this.mount = mount;
		}
		public Date getPaytime() {
			return paytime;
		}
		public void setPaytime(Date paytime) {
			this.paytime = paytime;
		}
		public String getIsback() {
			return isback;
		}
		public void setIsback(String isback) {
			this.isback = isback;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getMicroordercode() {
			return microordercode;
		}
		public void setMicroordercode(String microordercode) {
			this.microordercode = microordercode;
		}
		public String getBank() {
			return bank;
		}
		public void setBank(String bank) {
			this.bank = bank;
		}
		public String getBankaccountnumber() {
			return bankaccountnumber;
		}
		public void setBankaccountnumber(String bankaccountnumber) {
			this.bankaccountnumber = bankaccountnumber;
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
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		
		
	}
}

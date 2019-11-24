package cn.com.sinosoft.dto.system;

import java.util.List;

public class GeAccountSwitchForm {
	private String total;
	private List<GeAccountSwitchRow> rows;
	
	public String getTotal() {
		return total;
	}



	public void setTotal(String total) {
		this.total = total;
	}



	public List<GeAccountSwitchRow> getRows() {
		return rows;
	}



	public void setRows(List<GeAccountSwitchRow> rows) {
		this.rows = rows;
	}
	
	public static class GeAccountSwitchRow{
		private String policynum;// 保单号
		private String productName;//险种名称
		private String accountName;// 账户名称
		private String switchratio;// 修改比例
		private String makedate;// 操作时间
		
		public String getPolicynum() {
			return policynum;
		}
		public void setPolicynum(String policynum) {
			this.policynum = policynum;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public String getSwitchratio() {
			return switchratio;
		}
		public void setSwitchratio(String switchratio) {
			this.switchratio = switchratio;
		}
		public String getMakedate() {
			return makedate;
		}
		public void setMakedate(String makedate) {
			this.makedate = makedate;
		}
		
	}
}

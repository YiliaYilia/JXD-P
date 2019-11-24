package cn.com.sinosoft.dto.sell;

import java.util.Date;
import java.util.List;


public class InvestmentDto {
	private String total;
	private List<InvestmentRow> rows;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<InvestmentRow> getRows() {
		return rows;
	}

	public void setRows(List<InvestmentRow> rows) {
		this.rows = rows;
	}

	public static class InvestmentRow{
		
		private String ID;		
		private String policyNo;  //保单号
		private String applicantName;//投保人
		private String accountBank; //开户行
		private String bankCardId;	//银行卡号
		private Date createTime; //操作时间
		private String amount;	//追加金额
		
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public String getPolicyNo() {
			return policyNo;
		}
		public void setPolicyNo(String policyNo) {
			this.policyNo = policyNo;
		}
		public String getApplicantName() {
			return applicantName;
		}
		public void setApplicantName(String applicantName) {
			this.applicantName = applicantName;
		}
		public String getAccountBank() {
			return accountBank;
		}
		public void setAccountBank(String accountBank) {
			this.accountBank = accountBank;
		}
		public String getBankCardId() {
			return bankCardId;
		}
		public void setBankCardId(String bankCardId) {
			this.bankCardId = bankCardId;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		
	}
}

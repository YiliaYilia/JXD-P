package cn.com.sinosoft.dto.sell;

import java.util.Date;
import java.util.List;

import cn.com.sinosoft.dto.sell.AccountDto.AccountRow;

public class BankchangeDto {
	  private String total;
	  private List<BankchangeRow> rows;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<BankchangeRow> getRows() {
		return rows;
	}
	public void setRows(List<BankchangeRow> rows) {
		this.rows = rows;
	}
	
	public static class BankchangeRow{
		private String id;
		private String policyno;// 保单号
		private String bank;// 银行名称
		private String bankcode;// 银行编码
		private String bankaccountnumber;// 银行账号
		private String bankProvince;// 开户行省
		private String bankCity;// 开户行市
		private String applicantname;// 投保人姓名
		private String bankC;// 新的银行名称
		private String bankaccountnumberC;// 新的银行账号
		private Date updateTime;// 修改时间
		private String modifyc;// 修改状态
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPolicyno() {
			return policyno;
		}
		public void setPolicyno(String policyno) {
			this.policyno = policyno;
		}
		public String getBank() {
			return bank;
		}
		public void setBank(String bank) {
			this.bank = bank;
		}
		public String getBankcode() {
			return bankcode;
		}
		public void setBankcode(String bankcode) {
			this.bankcode = bankcode;
		}
		public String getBankaccountnumber() {
			return bankaccountnumber;
		}
		public void setBankaccountnumber(String bankaccountnumber) {
			this.bankaccountnumber = bankaccountnumber;
		}
		public String getBankProvince() {
			return bankProvince;
		}
		public void setBankProvince(String bankProvince) {
			this.bankProvince = bankProvince;
		}
		public String getBankCity() {
			return bankCity;
		}
		public void setBankCity(String bankCity) {
			this.bankCity = bankCity;
		}
		public String getApplicantname() {
			return applicantname;
		}
		public void setApplicantname(String applicantname) {
			this.applicantname = applicantname;
		}
		public String getBankC() {
			return bankC;
		}
		public void setBankC(String bankC) {
			this.bankC = bankC;
		}
		public String getBankaccountnumberC() {
			return bankaccountnumberC;
		}
		public void setBankaccountnumberC(String bankaccountnumberC) {
			this.bankaccountnumberC = bankaccountnumberC;
		}
		public Date getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}
		public String getModifyc() {
			return modifyc;
		}
		public void setModifyc(String modifyc) {
			this.modifyc = modifyc;
		}
 }
	  
}

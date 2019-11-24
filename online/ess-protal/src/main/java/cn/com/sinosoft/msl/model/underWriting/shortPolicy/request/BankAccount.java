package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;
/**
 * 转账信息实体
 * @author guilong
 *
 */
public class BankAccount {
	
	private String acctName;
	private String acctNo;
	private String bankCity;
	private String bankCode;
	private String bankName;
	private String bankProvince;
	
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankProvince() {
		return bankProvince;
	}
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	
	public BankAccount(String acctName, String acctNo, String bankCity,
			String bankCode, String bankName, String bankProvince) {
		super();
		this.acctName = acctName;
		this.acctNo = acctNo;
		this.bankCity = bankCity;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.bankProvince = bankProvince;
	}
	
	public BankAccount() {  
        super(); 
    } 
}

package cn.com.sinosoft.web.domain;
/**
 * 描述  续期保单银行信息实体
 * @author fenghj
 *
 */
public class RenewalPolicyPaymentRecords {

	private String dueDate;  //应交日期
	private String payDate;  //实付日期
	private String deductBank; //扣费银行
	private String accountNumber; //银行账号
	private String payAmount; //支付保费
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getDeductBank() {
		return deductBank;
	}
	public void setDeductBank(String deductBank) {
		this.deductBank = deductBank;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	
	
}

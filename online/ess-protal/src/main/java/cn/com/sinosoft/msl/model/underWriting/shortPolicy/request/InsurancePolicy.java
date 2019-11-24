package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;

import java.io.Serializable;
import java.util.List;

public class InsurancePolicy implements Serializable{
	
	private static final long serialVersionUID = 287757364L;
	
	private Header header;//响应头
	private InsuraPerson holder;//投保人
	private InsuraPerson insured;//被保人
	private InsuraPerson advisor;//推荐人 
	private Beneficiary benef;//受益人
	private ExtraAttrs extraAttrs;
	private Product product;//产品ID
	private BankAccount bankAccount;//转账信息实体
	private Agreement agreement;//投保须知实体
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public InsuraPerson getHolder() {
		return holder;
	}
	public void setHolder(InsuraPerson holder) {
		this.holder = holder;
	}
	public InsuraPerson getInsured() {
		return insured;
	}
	public void setInsured(InsuraPerson insured) {
		this.insured = insured;
	}
	public InsuraPerson getAdvisor() {
		return advisor;
	}
	public void setAdvisor(InsuraPerson advisor) {
		this.advisor = advisor;
	}
	public Beneficiary getBenef() {
		return benef;
	}
	public void setBenef(Beneficiary benef) {
		this.benef = benef;
	}
	public ExtraAttrs getExtraAttrs() {
		return extraAttrs;
	}
	public void setExtraAttrs(ExtraAttrs extraAttrs) {
		this.extraAttrs = extraAttrs;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public Agreement getAgreement() {
		return agreement;
	}
	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}
	
}

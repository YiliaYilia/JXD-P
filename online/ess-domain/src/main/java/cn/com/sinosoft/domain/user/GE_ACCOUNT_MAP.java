package cn.com.sinosoft.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GE_ACCOUNT_MAP")
public class GE_ACCOUNT_MAP implements Serializable{
	private String account_id;//通过getProductInvestmentAccount接口查询到的账号id
	private String account_code;//saveSwitchPolicy接口支持的账号代码
	@Id
	@Column(name = "ACCOUNT_ID",unique = true, nullable = false)
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	@Column(name = "ACCOUNT_CODE")
	public String getAccount_code() {
		return account_code;
	}
	public void setAccount_code(String account_code) {
		this.account_code = account_code;
	}
}

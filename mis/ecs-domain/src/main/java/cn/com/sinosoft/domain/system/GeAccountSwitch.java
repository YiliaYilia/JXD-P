package cn.com.sinosoft.domain.system;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "GE_ACCOUNT_SWITCH")
public class GeAccountSwitch implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String id;// 主键
	private String policynum;// 保单号
	private String productName;//险种名称
	private String accountName;// 账户名称
	private String switchratio;// 修改比例
	private String makedate;// 操作时间
	private String starttime; //开始时间
	private String endtime;//结束时间

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	@Column(name = "ACCOUNT_NAME")
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name = "SWITCHRATIO")
	public String getSwitchratio() {
		return switchratio;
	}

	public void setSwitchratio(String switchratio) {
		this.switchratio = switchratio;
	}
	
	@Column(name = "POLICYNUM")
	public String getPolicynum() {
		return policynum;
	}

	public void setPolicynum(String policynum) {
		this.policynum = policynum;
	}

	@Column(name = "MAKEDATE")
	public String getMakedate() {
		return makedate;
	}

	public void setMakedate(String makedate) {
		this.makedate = makedate;
	}
	@Column(name = "PRODUCT_NAME")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "STARTTIME")
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Column(name = "ENDTIME")
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	
}

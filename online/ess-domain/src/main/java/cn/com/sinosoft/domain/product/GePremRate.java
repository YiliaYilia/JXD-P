package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GE_PREMRATE")
public class GePremRate implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String id;// 主键
	private String riskcode;//主险代码
	private String periodUnit;//保险期间单位
	private String effDate;//保险期间范围最小值
	private String endDate;//保险期间范围最大值
	private String prem;// 费率表对应保费
	private String premUnit;// 费率表保费单位
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "PREMRATENO", unique = true, nullable = false)
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "RISKCODE")
	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}
	@Column(name = "PERIODUNIT")
	public String getPeriodUnit() {
		return periodUnit;
	}

	public void setPeriodUnit(String periodUnit) {
		this.periodUnit = periodUnit;
	}
	@Column(name = "EFFDATE")
	public String getEffDate() {
		return effDate;
	}

	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}
	@Column(name = "ENDDATE")
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Column(name = "PREM")
	public String getPrem() {
		return prem;
	}

	public void setPrem(String prem) {
		this.prem = prem;
	}
	@Column(name = "PREMUNIT")
	public String getPremUnit() {
		return premUnit;
	}

	public void setPremUnit(String premUnit) {
		this.premUnit = premUnit;
	}
	
}

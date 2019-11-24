package cn.com.sinosoft.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ge_policycodeconfig")
public class GePolicyCodeConfig  implements java.io.Serializable{

	private String id;
	private String productcode;
	private String prefix1;//前缀1
	private String prefix2;//前缀2
	private String threetofive;//三至五位
	private String sixtoten;//六至十位
	private String threetofivefixed;//三至五位是否固定
	private String value5;
	
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

	@Column(name = "PRODUCTCODE")
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	
	@Column(name = "PREFIX1")
	public String getPrefix1() {
		return prefix1;
	}
	public void setPrefix1(String prefix1) {
		this.prefix1 = prefix1;
	}
	@Column(name = "PREFIX2")
	public String getPrefix2() {
		return prefix2;
	}
	public void setPrefix2(String prefix2) {
		this.prefix2 = prefix2;
	}
	@Column(name = "THREETOFIVE")
	public String getThreetofive() {
		return threetofive;
	}
	public void setThreetofive(String threetofive) {
		this.threetofive = threetofive;
	}
	@Column(name = "SIXTOTEN")
	public String getSixtoten() {
		return sixtoten;
	}
	public void setSixtoten(String sixtoten) {
		this.sixtoten = sixtoten;
	}
	@Column(name = "THREETOFIVEFIXED")
	public String getThreetofivefixed() {
		return threetofivefixed;
	}
	public void setThreetofivefixed(String threetofivefixed) {
		this.threetofivefixed = threetofivefixed;
	}
	@Column(name = "VALUE5")
	public String getValue5() {
		return value5;
	}
	public void setValue5(String value5) {
		this.value5 = value5;
	}
	
	
}

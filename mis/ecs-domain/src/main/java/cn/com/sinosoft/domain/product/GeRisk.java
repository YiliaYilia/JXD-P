package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * GeRisk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_risk")
public class GeRisk implements java.io.Serializable {

	// Fields

	private String riskcode;
	private String riskname;
	private String risksimplename;
	private String coreriskcode;
	private String riskmark;
	private String businessarea;
	private String operator;
	private Date createtime;
	
	private List<GeDuty> geDutys = new ArrayList<GeDuty>(0);

	// Constructors

	/** default constructor */
	public GeRisk() {
	}

	/** minimal constructor */
	public GeRisk(String riskcode, String riskname, String risksimplename,
			String riskmark, String businessarea, String operator,
			Date createtime) {
		this.riskcode = riskcode;
		this.riskname = riskname;
		this.risksimplename = risksimplename;
		this.riskmark = riskmark;
		this.businessarea = businessarea;
		this.operator = operator;
		this.createtime = createtime;
	}

	/** full constructor */
	public GeRisk(String riskcode, String riskname, String risksimplename,
			String coreriskcode, String riskmark, String businessarea,
			String operator, Date createtime) {
		this.riskcode = riskcode;
		this.riskname = riskname;
		this.risksimplename = risksimplename;
		this.coreriskcode = coreriskcode;
		this.riskmark = riskmark;
		this.businessarea = businessarea;
		this.operator = operator;
		this.createtime = createtime;
	}

	// Property accessors
	@Id
	@Column(name = "RISKCODE", unique = true, nullable = false, length = 50)
	public String getRiskcode() {
		return this.riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	@Column(name = "RISKNAME", nullable = false)
	public String getRiskname() {
		return this.riskname;
	}

	public void setRiskname(String riskname) {
		this.riskname = riskname;
	}

	@Column(name = "RISKSIMPLENAME", nullable = false)
	public String getRisksimplename() {
		return this.risksimplename;
	}

	public void setRisksimplename(String risksimplename) {
		this.risksimplename = risksimplename;
	}

	@Column(name = "CORERISKCODE", length = 50)
	public String getCoreriskcode() {
		return this.coreriskcode;
	}

	public void setCoreriskcode(String coreriskcode) {
		this.coreriskcode = coreriskcode;
	}

	@Column(name = "RISKMARK", nullable = false, length = 50)
	public String getRiskmark() {
		return this.riskmark;
	}

	public void setRiskmark(String riskmark) {
		this.riskmark = riskmark;
	}

	@Column(name = "BUSINESSAREA", nullable = false, length = 50)
	public String getBusinessarea() {
		return this.businessarea;
	}

	public void setBusinessarea(String businessarea) {
		this.businessarea = businessarea;
	}

	@Column(name = "OPERATOR", nullable = false, length = 50)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "CREATETIME", nullable = false, length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="geRisk")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	public List<GeDuty> getGeDutys() {
		return geDutys;
	}

	public void setGeDutys(List<GeDuty> geDutys) {
		this.geDutys = geDutys;
	}
	

}
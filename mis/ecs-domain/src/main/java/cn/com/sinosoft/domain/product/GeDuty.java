package cn.com.sinosoft.domain.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeDuty entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_duty")
public class GeDuty implements java.io.Serializable {

	// Fields

	private String dutyno;
	private String dutycode;
	private String dutyname;
	private String dutysimplename;
	private String businessarea;
	private String operator;
	private Date createtime;
	
	private GeRisk geRisk;

	// Constructors

	/** default constructor */
	public GeDuty() {
	}

	/** minimal constructor */
	public GeDuty(String dutyno, String dutycode, String dutyname,
			String dutysimplename, String businessarea) {
		this.dutyno = dutyno;
		this.dutycode = dutycode;
		this.dutyname = dutyname;
		this.dutysimplename = dutysimplename;
		this.businessarea = businessarea;
	}

	/** full constructor */
	public GeDuty(String dutyno, String dutycode, String dutyname,
			String dutysimplename, String businessarea,
			String operator, Date createtime) {
		this.dutyno = dutyno;
		this.dutycode = dutycode;
		this.dutyname = dutyname;
		this.dutysimplename = dutysimplename;
		this.businessarea = businessarea;
		this.operator = operator;
		this.createtime = createtime;
	}

	// Property accessors
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "DUTYNO",nullable = false, length = 255)
	public String getDutyno() {
		return this.dutyno;
	}

	public void setDutyno(String dutyno) {
		this.dutyno = dutyno;
	}

	@Column(name = "DUTYCODE", nullable = false, length = 50)
	public String getDutycode() {
		return this.dutycode;
	}

	public void setDutycode(String dutycode) {
		this.dutycode = dutycode;
	}

	@Column(name = "DUTYNAME", nullable = false)
	public String getDutyname() {
		return this.dutyname;
	}

	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}

	@Column(name = "DUTYSIMPLENAME", nullable = false)
	public String getDutysimplename() {
		return this.dutysimplename;
	}

	public void setDutysimplename(String dutysimplename) {
		this.dutysimplename = dutysimplename;
	}

	@Column(name = "BUSINESSAREA", nullable = false, length = 50)
	public String getBusinessarea() {
		return this.businessarea;
	}

	public void setBusinessarea(String businessarea) {
		this.businessarea = businessarea;
	}

	@Column(name = "OPERATOR", length = 50)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	
	@Column(name = "CREATETIME", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@ManyToOne
	@JoinColumn(name = "RISKCODE")
	public GeRisk getGeRisk() {
		return geRisk;
	}

	public void setGeRisk(GeRisk geRisk) {
		this.geRisk = geRisk;
	}

}
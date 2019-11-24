package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeRiskSurvey entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_risk_survey")
public class GeRiskSurvey implements java.io.Serializable {

	// Fields

	private String risksurveyno;
	private String risksurveyname;
	private String operator;
	private Date createtime;
	private GeProductMain geProductMain;
	private List<GeRiskSurveySubject> geRiskSurveySubjects = new ArrayList<GeRiskSurveySubject>(0);
	
//	private Set<GeRiskSurveySubject> geRiskSurveySubject = new HashSet<GeRiskSurveySubject>(0);

	// Constructors

	/** default constructor */
	public GeRiskSurvey() {
	}

	
	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "RISKSURVEYNO", unique = true, nullable = false)
	public String getRisksurveyno() {
		return this.risksurveyno;
	}

	public void setRisksurveyno(String risksurveyno) {
		this.risksurveyno = risksurveyno;
	}


	@Column(name = "RISKSURVEYNAME", nullable = false)
	public String getRisksurveyname() {
		return this.risksurveyname;
	}

	public void setRisksurveyname(String risksurveyname) {
		this.risksurveyname = risksurveyname;
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

	@OneToMany(mappedBy="geRiskSurvey")
	@Cascade(value={CascadeType.DELETE,CascadeType.SAVE_UPDATE})
	@OrderBy("topicno ASC")
	public List<GeRiskSurveySubject> getGeRiskSurveySubjects() {
		return geRiskSurveySubjects;
	}

	public void setGeRiskSurveySubjects(
			List<GeRiskSurveySubject> geRiskSurveySubjects) {
		this.geRiskSurveySubjects = geRiskSurveySubjects;
	}

	@ManyToOne
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

//	@OneToMany(mappedBy="geRiskSurvey",targetEntity=cn.com.sinosoft.domain.product.GeRiskSurveySubject.class)
//	@Cascade(value={CascadeType.ALL})
//	public Set<GeRiskSurveySubject> getGeRiskSurveySubject() {
//		return geRiskSurveySubject;
//	}
//
//
//	public void setGeRiskSurveySubject(Set<GeRiskSurveySubject> geRiskSurveySubject) {
//		this.geRiskSurveySubject = geRiskSurveySubject;
//	}

	
	
	

}
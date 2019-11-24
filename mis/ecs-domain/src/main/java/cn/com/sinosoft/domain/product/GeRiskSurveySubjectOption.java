package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeRiskSurveySubjectOption entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_risk_survey_subject_option")
public class GeRiskSurveySubjectOption implements java.io.Serializable {

	// Fields

	private String optionno;
	private String serialo;
	private String optioncontent;
	private String optionscore;
	
//	private GeRiskSurvey geRiskSurvey;
	private GeRiskSurveySubject geRiskSurveySubject;
	
	// Constructors

	/** default constructor */
	public GeRiskSurveySubjectOption() {
	}

	/** full constructor */
	public GeRiskSurveySubjectOption(String optionno,
			String serialo, String optioncontent,
			String optionscore) {
		this.optionno = optionno;
		this.serialo = serialo;
		this.optioncontent = optioncontent;
		this.optionscore = optionscore;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "OPTIONNO", unique = true, nullable = false, length = 50)
	public String getOptionno() {
		return this.optionno;
	}

	public void setOptionno(String optionno) {
		this.optionno = optionno;
	}

	@Column(name = "SERIALO")
//	@Column(name = "SERIALO", nullable = false, length = 2)
	public String getSerialo() {
		return this.serialo;
	}

	public void setSerialo(String serialo) {
		this.serialo = serialo;
	}

	@Column(name = "OPTIONCONTENT", nullable = false, length = 500)
	public String getOptioncontent() {
		return this.optioncontent;
	}

	public void setOptioncontent(String optioncontent) {
		this.optioncontent = optioncontent;
	}

	
	@Column(name = "OPTIONSCORE", nullable = false, length = 10)
	public String getOptionscore() {
		return this.optionscore;
	}

	public void setOptionscore(String optionscore) {
		this.optionscore = optionscore;
	}

	@ManyToOne(targetEntity=cn.com.sinosoft.domain.product.GeRiskSurveySubject.class)
	@JoinColumn(name="RISKSURVEYSUBJECTNO")
	public GeRiskSurveySubject getGeRiskSurveySubject() {
		return geRiskSurveySubject;
	}

	public void setGeRiskSurveySubject(GeRiskSurveySubject geRiskSurveySubject) {
		this.geRiskSurveySubject = geRiskSurveySubject;
	}

}
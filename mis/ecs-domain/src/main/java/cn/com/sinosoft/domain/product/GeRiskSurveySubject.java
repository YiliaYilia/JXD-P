package cn.com.sinosoft.domain.product;

import java.util.ArrayList;
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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import cn.com.sinosoft.domain.product.GeRiskSurvey;

/**
 * GeRiskSurveySubject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_risk_survey_subject")
public class GeRiskSurveySubject implements java.io.Serializable {

	// Fields

	private String risksurveysubjectno;
	private String isanswer;
	private String topic;
	private String topicno;
	
	
	
	private GeRiskSurvey geRiskSurvey;
 	private List<GeRiskSurveySubjectOption> geRiskSurveySubjectOptions = new ArrayList<GeRiskSurveySubjectOption>() ;
	// Constructors

	/** default constructor */
	public GeRiskSurveySubject() {
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "RISKSURVEYSUBJECTNO", unique = true, nullable = false)
	public String getRisksurveysubjectno() {
		return this.risksurveysubjectno;
	}

	public void setRisksurveysubjectno(String risksurveysubjectno) {
		this.risksurveysubjectno = risksurveysubjectno;
	}

	@Column(name = "ISANSWER", length = 2)
	public String getIsanswer() {
		return this.isanswer;
	}

	public void setIsanswer(String isanswer) {
		this.isanswer = isanswer;
	}

	@Column(name = "TOPIC", nullable = false, length = 1000)
	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@Column(name = "TOPICNO", nullable = true, length = 10)
//	@Column(name = "TOPICNO", nullable = false, length = 10)
	public String getTopicno() {
		return topicno;
	}
	public void setTopicno(String topicno) {
		this.topicno = topicno;
	}

	@ManyToOne(targetEntity=cn.com.sinosoft.domain.product.GeRiskSurvey.class)
	@JoinColumn(name="RISKSURVEYNO")
	public GeRiskSurvey getGeRiskSurvey() {
		return geRiskSurvey;
	}

	public void setGeRiskSurvey(GeRiskSurvey geRiskSurvey) {
		this.geRiskSurvey = geRiskSurvey;
	}

	@OneToMany(mappedBy="geRiskSurveySubject")
	@Cascade(value={CascadeType.DELETE,CascadeType.SAVE_UPDATE})
	public List<GeRiskSurveySubjectOption> getGeRiskSurveySubjectOptions() {
		return geRiskSurveySubjectOptions;
	}

	public void setGeRiskSurveySubjectOptions(
			List<GeRiskSurveySubjectOption> geRiskSurveySubjectOptions) {
		this.geRiskSurveySubjectOptions = geRiskSurveySubjectOptions;
	}
}
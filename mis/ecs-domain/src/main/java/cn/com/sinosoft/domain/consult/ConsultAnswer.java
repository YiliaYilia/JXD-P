package cn.com.sinosoft.domain.consult;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * ConsultAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CONSULT_ANSWER", schema = "MIS")
public class ConsultAnswer implements java.io.Serializable {

	// Fields

	private String consultAnswerId;
	private String usersId;
	private String username;
	private Date date;
	private String content;
	private String consultId;

	// Constructors

	/** default constructor */
	public ConsultAnswer() {
	}

	/** minimal constructor */
	public ConsultAnswer(String consultId) {
		this.consultId = consultId;
	}

	/** full constructor */
	public ConsultAnswer(String usersId, String username, Date date, String content, String consultId) {
		this.usersId = usersId;
		this.username = username;
		this.date = date;
		this.content = content;
		this.consultId = consultId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CONSULT_ANSWER_ID", unique = true, nullable = false, length = 32)
	public String getConsultAnswerId() {
		return this.consultAnswerId;
	}

	public void setConsultAnswerId(String consultAnswerId) {
		this.consultAnswerId = consultAnswerId;
	}

	@Column(name = "USERS_ID", length = 32)
	public String getUsersId() {
		return this.usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", length = 7)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "CONTENT", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CONSULT_ID", nullable = false, length = 32)
	public String getConsultId() {
		return this.consultId;
	}

	public void setConsultId(String consultId) {
		this.consultId = consultId;
	}

}
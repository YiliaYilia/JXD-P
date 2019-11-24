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
 * MessageAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MESSAGE_ANSWER", schema = "MIS")
public class MessageAnswer implements java.io.Serializable {

	// Fields

	private String messageAnswerId;
	private String content;
	private Date date;
	private String username;
	private String usersId;
	private String messageId;

	// Constructors

	/** default constructor */
	public MessageAnswer() {
	}

	/** minimal constructor */
	public MessageAnswer(String messageId) {
		this.messageId = messageId;
	}

	/** full constructor */
	public MessageAnswer(String content, Date date, String username, String usersId, String messageId) {
		this.content = content;
		this.date = date;
		this.username = username;
		this.usersId = usersId;
		this.messageId = messageId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MESSAGE_ANSWER_ID", unique = true, nullable = false, length = 32)
	public String getMessageAnswerId() {
		return this.messageAnswerId;
	}

	public void setMessageAnswerId(String messageAnswerId) {
		this.messageAnswerId = messageAnswerId;
	}

	@Column(name = "CONTENT", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", length = 7)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "USERS_ID", length = 32)
	public String getUsersId() {
		return this.usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	@Column(name = "MESSAGE_ID", nullable = false, length = 32)
	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}
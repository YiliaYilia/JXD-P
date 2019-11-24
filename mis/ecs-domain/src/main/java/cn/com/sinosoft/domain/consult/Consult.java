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
 * Consult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CONSULT", schema = "MIS")
public class Consult implements java.io.Serializable {

	// Fields

	private String consultId;
	private String title;
	private String content;
	private String usersId;
	private String consultTypeId;
	private Date date;
	private String fixPhone;
	private String phone;
	private String email;
	private String status;
	private String isChecked;

	// Constructors

	/** default constructor */
	public Consult() {
	}

	/** full constructor */
	public Consult(String title, String content, String usersId, String consultTypeId, Date date, String fixPhone,
			String phone, String email, String status, String isChecked) {
		this.title = title;
		this.content = content;
		this.usersId = usersId;
		this.consultTypeId = consultTypeId;
		this.date = date;
		this.fixPhone = fixPhone;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.isChecked = isChecked;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CONSULT_ID", unique = true, nullable = false, length = 32)
	public String getConsultId() {
		return this.consultId;
	}

	public void setConsultId(String consultId) {
		this.consultId = consultId;
	}

	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "CONTENT", length = 2000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "USERS_ID", length = 32)
	public String getUsersId() {
		return this.usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	@Column(name = "CONSULT_TYPE_ID", length = 32)
	public String getConsultTypeId() {
		return this.consultTypeId;
	}

	public void setConsultTypeId(String consultTypeId) {
		this.consultTypeId = consultTypeId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", length = 7)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "FIX_PHONE", length = 13)
	public String getFixPhone() {
		return this.fixPhone;
	}

	public void setFixPhone(String fixPhone) {
		this.fixPhone = fixPhone;
	}

	@Column(name = "PHONE", length = 13)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "IS_CHECKED", length = 1)
	public String getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

}
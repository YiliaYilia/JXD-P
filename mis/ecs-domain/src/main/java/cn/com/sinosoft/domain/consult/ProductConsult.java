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
 * ProductConsult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PRODUCT_CONSULT", schema = "MIS")
public class ProductConsult implements java.io.Serializable {

	// Fields

	private String productConsultId;
	private String productId;
	private String username;
	private String userId;
	private String content;
	private String status;
	private Date date;
	private String model;
	private String isChecked;
	private String sex;
	private Date birthday;
	private String email;
	private String phone;
	private String replyType;

	// Constructors

	/** default constructor */
	public ProductConsult() {
	}

	/** full constructor */
	public ProductConsult(String productId, String username, String userId, String content, String status, Date date,
			String model, String isChecked, String sex, Date birthday, String email, String phone, String replyType) {
		this.productId = productId;
		this.username = username;
		this.userId = userId;
		this.content = content;
		this.status = status;
		this.date = date;
		this.model = model;
		this.isChecked = isChecked;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.replyType = replyType;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PRODUCT_CONSULT_ID", unique = true, nullable = false, length = 32)
	public String getProductConsultId() {
		return this.productConsultId;
	}

	public void setProductConsultId(String productConsultId) {
		this.productConsultId = productConsultId;
	}

	@Column(name = "PRODUCT_ID", length = 32)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "USER_ID", length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "CONTENT", length = 100)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", length = 7)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "MODEL", length = 32)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "IS_CHECKED", length = 1)
	public String getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	@Column(name = "SEX", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", length = 7)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PHONE", length = 13)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "REPLY_TYPE", length = 1)
	public String getReplyType() {
		return this.replyType;
	}

	public void setReplyType(String replyType) {
		this.replyType = replyType;
	}

}
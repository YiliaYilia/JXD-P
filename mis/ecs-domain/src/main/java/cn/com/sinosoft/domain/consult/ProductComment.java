package cn.com.sinosoft.domain.consult;

import java.math.BigDecimal;
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
 * ProductComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PRODUCT_COMMENT", schema = "MIS")
public class ProductComment implements java.io.Serializable {

	// Fields

	private String productCommentId;
	private String productId;
	private String content;
	private String status;
	private Date date;
	private String userId;
	private String satisfactionModel;
	private String isAnonymity;
	private String isChecked;
	private String username;
	private BigDecimal commentScore;

	// Constructors

	/** default constructor */
	public ProductComment() {
	}

	/** full constructor */
	public ProductComment(String productId, String content, String status, Date date, String userId,
			String satisfactionModel, String isAnonymity, String isChecked, String username, BigDecimal commentScore) {
		this.productId = productId;
		this.content = content;
		this.status = status;
		this.date = date;
		this.userId = userId;
		this.satisfactionModel = satisfactionModel;
		this.isAnonymity = isAnonymity;
		this.isChecked = isChecked;
		this.username = username;
		this.commentScore = commentScore;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PRODUCT_COMMENT_ID", unique = true, nullable = false, length = 32)
	public String getProductCommentId() {
		return this.productCommentId;
	}

	public void setProductCommentId(String productCommentId) {
		this.productCommentId = productCommentId;
	}

	@Column(name = "PRODUCT_ID", length = 32)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "CONTENT", length = 2000)
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

	@Column(name = "USER_ID", length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "SATISFACTION_MODEL", length = 2)
	public String getSatisfactionModel() {
		return this.satisfactionModel;
	}

	public void setSatisfactionModel(String satisfactionModel) {
		this.satisfactionModel = satisfactionModel;
	}

	@Column(name = "IS_ANONYMITY", length = 1)
	public String getIsAnonymity() {
		return this.isAnonymity;
	}

	public void setIsAnonymity(String isAnonymity) {
		this.isAnonymity = isAnonymity;
	}

	@Column(name = "IS_CHECKED", length = 1)
	public String getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "COMMENT_SCORE", precision = 22, scale = 0)
	public BigDecimal getCommentScore() {
		return this.commentScore;
	}

	public void setCommentScore(BigDecimal commentScore) {
		this.commentScore = commentScore;
	}

}
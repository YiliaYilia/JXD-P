package cn.com.sinosoft.domain.consult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ProductConsultConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PRODUCT_CONSULT_CONFIG", schema = "MIS")
public class ProductConsultConfig implements java.io.Serializable {

	// Fields

	private String productConsultConfigId;
	private String productId;
	private String isUsername;
	private String isSex;
	private String isBirthdate;
	private String isPhone;
	private String isEmail;
	private String isContent;
	private String isAnswerType;
	private String isReply;
	private String isCheckedCode;
	private String isConsultType;
	private String operateId;
	private String operateDate;

	// Constructors

	/** default constructor */
	public ProductConsultConfig() {
	}

	/** full constructor */
	public ProductConsultConfig(String productId, String isUsername, String isSex, String isBirthdate, String isPhone,
			String isEmail, String isContent, String isAnswerType, String isReply, String isCheckedCode,
			String isConsultType, String operateId, String operateDate) {
		this.productId = productId;
		this.isUsername = isUsername;
		this.isSex = isSex;
		this.isBirthdate = isBirthdate;
		this.isPhone = isPhone;
		this.isEmail = isEmail;
		this.isContent = isContent;
		this.isAnswerType = isAnswerType;
		this.isReply = isReply;
		this.isCheckedCode = isCheckedCode;
		this.isConsultType = isConsultType;
		this.operateId = operateId;
		this.operateDate = operateDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PRODUCT_CONSULT_CONFIG_ID", unique = true, nullable = false, length = 32)
	public String getProductConsultConfigId() {
		return this.productConsultConfigId;
	}

	public void setProductConsultConfigId(String productConsultConfigId) {
		this.productConsultConfigId = productConsultConfigId;
	}

	@Column(name = "PRODUCT_ID", length = 32)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "IS_USERNAME", length = 1)
	public String getIsUsername() {
		return this.isUsername;
	}

	public void setIsUsername(String isUsername) {
		this.isUsername = isUsername;
	}

	@Column(name = "IS_SEX", length = 1)
	public String getIsSex() {
		return this.isSex;
	}

	public void setIsSex(String isSex) {
		this.isSex = isSex;
	}

	@Column(name = "IS_BIRTHDATE", length = 1)
	public String getIsBirthdate() {
		return this.isBirthdate;
	}

	public void setIsBirthdate(String isBirthdate) {
		this.isBirthdate = isBirthdate;
	}

	@Column(name = "IS_PHONE", length = 1)
	public String getIsPhone() {
		return this.isPhone;
	}

	public void setIsPhone(String isPhone) {
		this.isPhone = isPhone;
	}

	@Column(name = "IS_EMAIL", length = 1)
	public String getIsEmail() {
		return this.isEmail;
	}

	public void setIsEmail(String isEmail) {
		this.isEmail = isEmail;
	}

	@Column(name = "IS_CONTENT", length = 1)
	public String getIsContent() {
		return this.isContent;
	}

	public void setIsContent(String isContent) {
		this.isContent = isContent;
	}

	@Column(name = "IS_ANSWER_TYPE", length = 1)
	public String getIsAnswerType() {
		return this.isAnswerType;
	}

	public void setIsAnswerType(String isAnswerType) {
		this.isAnswerType = isAnswerType;
	}

	@Column(name = "IS_REPLY", length = 1)
	public String getIsReply() {
		return this.isReply;
	}

	public void setIsReply(String isReply) {
		this.isReply = isReply;
	}

	@Column(name = "IS_CHECKED_CODE", length = 1)
	public String getIsCheckedCode() {
		return this.isCheckedCode;
	}

	public void setIsCheckedCode(String isCheckedCode) {
		this.isCheckedCode = isCheckedCode;
	}

	@Column(name = "IS_CONSULT_TYPE", length = 1)
	public String getIsConsultType() {
		return this.isConsultType;
	}

	public void setIsConsultType(String isConsultType) {
		this.isConsultType = isConsultType;
	}

	@Column(name = "OPERATE_ID", length = 32)
	public String getOperateId() {
		return this.operateId;
	}

	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}

	@Column(name = "OPERATE_DATE")
	public String getOperateDate() {
		return this.operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

}
package cn.com.sinosoft.domain.consult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * MessageConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MESSAGE_CONFIG", schema = "MIS")
public class MessageConfig implements java.io.Serializable {

	// Fields

	private String messageConfigId;
	private String isVisitor;
	private String isTitle;
	private String isContent;
	private String isUsername;
	private String isSex;
	private String isArea;
	private String isPhone;
	private String isEmail;
	private String isCheckedCode;
	private String isWho;
	private String operateId;
	private String operateDate;
	private String isAnswer;

	// Constructors

	/** default constructor */
	public MessageConfig() {
	}

	/** full constructor */
	public MessageConfig(String isVisitor, String isTitle, String isContent, String isUsername, String isSex,
			String isArea, String isPhone, String isEmail, String isCheckedCode, String isWho, String operateId,
			String operateDate, String isAnswer) {
		this.isVisitor = isVisitor;
		this.isTitle = isTitle;
		this.isContent = isContent;
		this.isUsername = isUsername;
		this.isSex = isSex;
		this.isArea = isArea;
		this.isPhone = isPhone;
		this.isEmail = isEmail;
		this.isCheckedCode = isCheckedCode;
		this.isWho = isWho;
		this.operateId = operateId;
		this.operateDate = operateDate;
		this.isAnswer = isAnswer;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MESSAGE_CONFIG_ID", unique = true, nullable = false, length = 32)
	public String getMessageConfigId() {
		return this.messageConfigId;
	}

	public void setMessageConfigId(String messageConfigId) {
		this.messageConfigId = messageConfigId;
	}

	@Column(name = "IS_VISITOR", length = 1)
	public String getIsVisitor() {
		return this.isVisitor;
	}

	public void setIsVisitor(String isVisitor) {
		this.isVisitor = isVisitor;
	}

	@Column(name = "IS_TITLE", length = 1)
	public String getIsTitle() {
		return this.isTitle;
	}

	public void setIsTitle(String isTitle) {
		this.isTitle = isTitle;
	}

	@Column(name = "IS_CONTENT", length = 1)
	public String getIsContent() {
		return this.isContent;
	}

	public void setIsContent(String isContent) {
		this.isContent = isContent;
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

	@Column(name = "IS_AREA", length = 1)
	public String getIsArea() {
		return this.isArea;
	}

	public void setIsArea(String isArea) {
		this.isArea = isArea;
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

	@Column(name = "IS_CHECKED_CODE", length = 1)
	public String getIsCheckedCode() {
		return this.isCheckedCode;
	}

	public void setIsCheckedCode(String isCheckedCode) {
		this.isCheckedCode = isCheckedCode;
	}

	@Column(name = "IS_WHO", length = 1)
	public String getIsWho() {
		return this.isWho;
	}

	public void setIsWho(String isWho) {
		this.isWho = isWho;
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

	@Column(name = "IS_ANSWER", length = 1)
	public String getIsAnswer() {
		return this.isAnswer;
	}

	public void setIsAnswer(String isAnswer) {
		this.isAnswer = isAnswer;
	}

}
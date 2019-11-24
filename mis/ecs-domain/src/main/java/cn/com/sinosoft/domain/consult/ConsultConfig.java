package cn.com.sinosoft.domain.consult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ConsultConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CONSULT_CONFIG", schema = "MIS")
public class ConsultConfig implements java.io.Serializable {

	// Fields

	private String consultConfigId;
	private String isUsername;
	private String isTitle;
	private String isContent;
	private String isFixPhone;
	private String isPhone;
	private String isEmail;
	private String isAdviceType;
	private String isCheckedCode;
	private String operateId;
	private String operateDate;

	// Constructors

	/** default constructor */
	public ConsultConfig() {
	}

	/** full constructor */
	public ConsultConfig(String isUsername, String isTitle, String isContent, String isFixPhone, String isPhone,
			String isEmail, String isAdviceType, String isCheckedCode, String operateId, String operateDate) {
		this.isUsername = isUsername;
		this.isTitle = isTitle;
		this.isContent = isContent;
		this.isFixPhone = isFixPhone;
		this.isPhone = isPhone;
		this.isEmail = isEmail;
		this.isAdviceType = isAdviceType;
		this.isCheckedCode = isCheckedCode;
		this.operateId = operateId;
		this.operateDate = operateDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CONSULT_CONFIG_ID", unique = true, nullable = false, length = 32)
	public String getConsultConfigId() {
		return this.consultConfigId;
	}

	public void setConsultConfigId(String consultConfigId) {
		this.consultConfigId = consultConfigId;
	}

	@Column(name = "IS_USERNAME", length = 1)
	public String getIsUsername() {
		return this.isUsername;
	}

	public void setIsUsername(String isUsername) {
		this.isUsername = isUsername;
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

	@Column(name = "IS_FIX_PHONE", length = 1)
	public String getIsFixPhone() {
		return this.isFixPhone;
	}

	public void setIsFixPhone(String isFixPhone) {
		this.isFixPhone = isFixPhone;
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

	@Column(name = "IS_ADVICE_TYPE", length = 1)
	public String getIsAdviceType() {
		return this.isAdviceType;
	}

	public void setIsAdviceType(String isAdviceType) {
		this.isAdviceType = isAdviceType;
	}

	@Column(name = "IS_CHECKED_CODE", length = 1)
	public String getIsCheckedCode() {
		return this.isCheckedCode;
	}

	public void setIsCheckedCode(String isCheckedCode) {
		this.isCheckedCode = isCheckedCode;
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
package cn.com.sinosoft.domain.consult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ComplainConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "COMPLAIN_CONFIG", schema = "MIS")
public class ComplainConfig implements java.io.Serializable {

	// Fields

	private String complainConfigId;
	private String isProposalNo;
	private String isComplainType;
	private String isComplainContent;
	private String operateId;
	private String operateDate;
	private String isCheckedCode;

	// Constructors

	/** default constructor */
	public ComplainConfig() {
	}

	/** full constructor */
	public ComplainConfig(String isProposalNo, String isComplainType, String isComplainContent, String operateId,
			String operateDate, String isCheckedCode) {
		this.isProposalNo = isProposalNo;
		this.isComplainType = isComplainType;
		this.isComplainContent = isComplainContent;
		this.operateId = operateId;
		this.operateDate = operateDate;
		this.isCheckedCode = isCheckedCode;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COMPLAIN_CONFIG_ID", unique = true, nullable = false, length = 32)
	public String getComplainConfigId() {
		return this.complainConfigId;
	}

	public void setComplainConfigId(String complainConfigId) {
		this.complainConfigId = complainConfigId;
	}

	@Column(name = "IS_PROPOSAL_NO", length = 1)
	public String getIsProposalNo() {
		return this.isProposalNo;
	}

	public void setIsProposalNo(String isProposalNo) {
		this.isProposalNo = isProposalNo;
	}

	@Column(name = "IS_COMPLAIN_TYPE", length = 1)
	public String getIsComplainType() {
		return this.isComplainType;
	}

	public void setIsComplainType(String isComplainType) {
		this.isComplainType = isComplainType;
	}

	@Column(name = "IS_COMPLAIN_CONTENT", length = 1)
	public String getIsComplainContent() {
		return this.isComplainContent;
	}

	public void setIsComplainContent(String isComplainContent) {
		this.isComplainContent = isComplainContent;
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

	@Column(name = "IS_CHECKED_CODE", length = 1)
	public String getIsCheckedCode() {
		return this.isCheckedCode;
	}

	public void setIsCheckedCode(String isCheckedCode) {
		this.isCheckedCode = isCheckedCode;
	}

}
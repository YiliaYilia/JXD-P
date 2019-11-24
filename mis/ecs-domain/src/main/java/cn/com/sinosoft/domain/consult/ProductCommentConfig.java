package cn.com.sinosoft.domain.consult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ProductCommentConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PRODUCT_COMMENT_CONFIG", schema = "MIS")
public class ProductCommentConfig implements java.io.Serializable {

	// Fields

	private String productCommentConfigId;
	private String productId;
	private String isContent;
	private String selectScoreType;
	private String isCheckedCode;
	private String operateId;
	private String operateDate;
	private String isAnswer;

	// Constructors

	/** default constructor */
	public ProductCommentConfig() {
	}

	/** full constructor */
	public ProductCommentConfig(String productId, String isContent, String selectScoreType, String isCheckedCode,
			String operateId, String operateDate, String isAnswer) {
		this.productId = productId;
		this.isContent = isContent;
		this.selectScoreType = selectScoreType;
		this.isCheckedCode = isCheckedCode;
		this.operateId = operateId;
		this.operateDate = operateDate;
		this.isAnswer = isAnswer;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PRODUCT_COMMENT_CONFIG_ID", unique = true, nullable = false, length = 32)
	public String getProductCommentConfigId() {
		return this.productCommentConfigId;
	}

	public void setProductCommentConfigId(String productCommentConfigId) {
		this.productCommentConfigId = productCommentConfigId;
	}

	@Column(name = "PRODUCT_ID", length = 32)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "IS_CONTENT", length = 1)
	public String getIsContent() {
		return this.isContent;
	}

	public void setIsContent(String isContent) {
		this.isContent = isContent;
	}

	@Column(name = "SELECT_SCORE_TYPE", length = 50)
	public String getSelectScoreType() {
		return this.selectScoreType;
	}

	public void setSelectScoreType(String selectScoreType) {
		this.selectScoreType = selectScoreType;
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

	@Column(name = "IS_ANSWER", length = 1)
	public String getIsAnswer() {
		return this.isAnswer;
	}

	public void setIsAnswer(String isAnswer) {
		this.isAnswer = isAnswer;
	}

}
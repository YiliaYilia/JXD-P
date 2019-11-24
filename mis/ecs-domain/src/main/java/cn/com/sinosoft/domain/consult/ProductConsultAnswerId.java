package cn.com.sinosoft.domain.consult;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductConsultAnswerId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ProductConsultAnswerId implements java.io.Serializable {

	// Fields

	private String productConsultAnswerId;
	private String content;
	private String productConsultId;
	private Date date;
	private String userId;

	// Constructors

	/** default constructor */
	public ProductConsultAnswerId() {
	}

	/** full constructor */
	public ProductConsultAnswerId(String productConsultAnswerId, String content, String productConsultId, Date date,
			String userId) {
		this.productConsultAnswerId = productConsultAnswerId;
		this.content = content;
		this.productConsultId = productConsultId;
		this.date = date;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "PRODUCT_CONSULT_ANSWER_ID", length = 32)
	public String getProductConsultAnswerId() {
		return this.productConsultAnswerId;
	}

	public void setProductConsultAnswerId(String productConsultAnswerId) {
		this.productConsultAnswerId = productConsultAnswerId;
	}

	@Column(name = "CONTENT", length = 2000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "PRODUCT_CONSULT_ID", length = 32)
	public String getProductConsultId() {
		return this.productConsultId;
	}

	public void setProductConsultId(String productConsultId) {
		this.productConsultId = productConsultId;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductConsultAnswerId))
			return false;
		ProductConsultAnswerId castOther = (ProductConsultAnswerId) other;

		return ((this.getProductConsultAnswerId() == castOther.getProductConsultAnswerId()) || (this
				.getProductConsultAnswerId() != null && castOther.getProductConsultAnswerId() != null && this
				.getProductConsultAnswerId().equals(castOther.getProductConsultAnswerId())))
				&& ((this.getContent() == castOther.getContent()) || (this.getContent() != null
						&& castOther.getContent() != null && this.getContent().equals(castOther.getContent())))
				&& ((this.getProductConsultId() == castOther.getProductConsultId()) || (this.getProductConsultId() != null
						&& castOther.getProductConsultId() != null && this.getProductConsultId().equals(
						castOther.getProductConsultId())))
				&& ((this.getDate() == castOther.getDate()) || (this.getDate() != null && castOther.getDate() != null && this
						.getDate().equals(castOther.getDate())))
				&& ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductConsultAnswerId() == null ? 0 : this.getProductConsultAnswerId().hashCode());
		result = 37 * result + (getContent() == null ? 0 : this.getContent().hashCode());
		result = 37 * result + (getProductConsultId() == null ? 0 : this.getProductConsultId().hashCode());
		result = 37 * result + (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}
package cn.com.sinosoft.domain.consult;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ProductConsultAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PRODUCT_CONSULT_ANSWER", schema = "MIS")
public class ProductConsultAnswer implements java.io.Serializable {

	// Fields

	private ProductConsultAnswerId id;

	// Constructors

	/** default constructor */
	public ProductConsultAnswer() {
	}

	/** full constructor */
	public ProductConsultAnswer(ProductConsultAnswerId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "productConsultAnswerId", column = @Column(name = "PRODUCT_CONSULT_ANSWER_ID", length = 32)),
			@AttributeOverride(name = "content", column = @Column(name = "CONTENT", length = 2000)),
			@AttributeOverride(name = "productConsultId", column = @Column(name = "PRODUCT_CONSULT_ID", length = 32)),
			@AttributeOverride(name = "date", column = @Column(name = "DATE", length = 7)),
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", length = 32)) })
	public ProductConsultAnswerId getId() {
		return this.id;
	}

	public void setId(ProductConsultAnswerId id) {
		this.id = id;
	}

}
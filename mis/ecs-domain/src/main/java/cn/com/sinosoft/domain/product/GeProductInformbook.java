package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeProductInformbook entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_product_informbook")
public class GeProductInformbook implements java.io.Serializable {

	// Fields

	private String productinformbookno;
	private String informorder;
	private String informcontent;
	private String informoption;

	private GeProductMain geProductMain;
	// Constructors

	/** default constructor */
	public GeProductInformbook() {
	}

	/** full constructor */
	public GeProductInformbook(String productinformbookno, String informorder, String informcontent,
			String informoption) {
		this.productinformbookno = productinformbookno;
		this.informorder = informorder;
		this.informcontent = informcontent;
		this.informoption = informoption;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "PRODUCTINFORMBOOKNO", unique = true, nullable = false)
	public String getProductinformbookno() {
		return this.productinformbookno;
	}

	public void setProductinformbookno(String productinformbookno) {
		this.productinformbookno = productinformbookno;
	}

	@Column(name = "INFORMORDER", nullable = false, length = 2)
	public String getInformorder() {
		return this.informorder;
	}

	public void setInformorder(String informorder) {
		this.informorder = informorder;
	}

	@Column(name = "INFORMCONTENT", nullable = false, length = 65535)
	public String getInformcontent() {
		return this.informcontent;
	}

	public void setInformcontent(String informcontent) {
		this.informcontent = informcontent;
	}

	@Column(name = "INFORMOPTION", nullable = false, length = 1)
	public String getInformoption() {
		return this.informoption;
	}

	public void setInformoption(String informoption) {
		this.informoption = informoption;
	}

	@ManyToOne
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

}
package cn.com.sinosoft.domain.sale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="GE_PRODUCTCODE")
public class GE_ProductcodeOTM implements java.io.Serializable  {
	private String id;
	private String code;
	private String pdfname;
	private String pdfnamec;
	@Id
	@GenericGenerator(name = "idGenerator",strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="PDFNAME")
	public String getPdfname() {
		return pdfname;
	}
	public void setPdfname(String pdfname) {
		this.pdfname = pdfname;
	}
	@Column(name="pdfnamec")
	public String getPdfnamec() {
		return pdfnamec;
	}
	public void setPdfnamec(String pdfnamec) {
		this.pdfnamec = pdfnamec;
	}
	public GE_ProductcodeOTM(String id, String code, String pdfname, String pdfnamec) {
		super();
		this.id = id;
		this.code = code;
		this.pdfname = pdfname;
		this.pdfnamec=pdfnamec;
	}
	public GE_ProductcodeOTM() {
		super();
	}
	
	
	
}

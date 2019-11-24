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
 * GeProdutyExtend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_produty_extend")
public class GeProdutyExtend implements java.io.Serializable {

	// Fields

	private String attributeno;
	private String attributename;
	private String attributetype;
	private String attributetypevalue;
	private String attributevalue;
	private String maxvalue;
	private String minvalue;
	
	private GeProductduty geProductduty;

	// Constructors

	/** default constructor */
	public GeProdutyExtend() {
	}

	/** minimal constructor */
	public GeProdutyExtend(String attributeno) {
		this.attributeno = attributeno;
	}

	/** full constructor */
	public GeProdutyExtend(String attributeno, String attributename,
			String attributetype, String attributetypevalue,
			String attributevalue, String maxvalue,
			String minvalue) {
		this.attributeno = attributeno;
		this.attributename = attributename;
		this.attributetype = attributetype;
		this.attributetypevalue = attributetypevalue;
		this.attributevalue = attributevalue;
		this.maxvalue = maxvalue;
		this.minvalue = minvalue;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ATTRIBUTENO", unique = true, nullable = false)
	public String getAttributeno() {
		return this.attributeno;
	}

	public void setAttributeno(String attributeno) {
		this.attributeno = attributeno;
	}

	@Column(name = "ATTRIBUTENAME", length = 50)
	public String getAttributename() {
		return this.attributename;
	}

	public void setAttributename(String attributename) {
		this.attributename = attributename;
	}

	@Column(name = "ATTRIBUTETYPE", length = 50)
	public String getAttributetype() {
		return this.attributetype;
	}

	public void setAttributetype(String attributetype) {
		this.attributetype = attributetype;
	}

	@Column(name = "ATTRIBUTETYPEVALUE", length = 50)
	public String getAttributetypevalue() {
		return this.attributetypevalue;
	}

	public void setAttributetypevalue(String attributetypevalue) {
		this.attributetypevalue = attributetypevalue;
	}

	@Column(name = "ATTRIBUTEVALUE", length = 50)
	public String getAttributevalue() {
		return this.attributevalue;
	}

	public void setAttributevalue(String attributevalue) {
		this.attributevalue = attributevalue;
	}
	
	@Column(name = "MAXVALUE", length = 50)
	public String getMaxvalue() {
		return this.maxvalue;
	}

	public void setMaxvalue(String maxvalue) {
		this.maxvalue = maxvalue;
	}

	@Column(name = "MINVALUE", length = 50)
	public String getMinvalue() {
		return this.minvalue;
	}

	public void setMinvalue(String minvalue) {
		this.minvalue = minvalue;
	}

	@ManyToOne
	@JoinColumn(name="PRODUCTDUTYNO")
	public GeProductduty getGeProductduty() {
		return geProductduty;
	}

	public void setGeProductduty(GeProductduty geProductduty) {
		this.geProductduty = geProductduty;
	}
	

}
package cn.com.sinosoft.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeResourcesIcon entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_resources_icon")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GeResourcesIcon implements java.io.Serializable {

	// Fields

	private String resourcesiconid;
	private String resourcesiconpath;

	// Constructors

	/** default constructor */
	public GeResourcesIcon() {
	}

	/** minimal constructor */
	public GeResourcesIcon(String resourcesiconid) {
		this.resourcesiconid = resourcesiconid;
	}

	/** full constructor */
	public GeResourcesIcon(String resourcesiconid, String resourcesiconpath) {
		this.resourcesiconid = resourcesiconid;
		this.resourcesiconpath = resourcesiconpath;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "RESOURCESICONID", unique = true, nullable = false)
	public String getResourcesiconid() {
		return this.resourcesiconid;
	}

	public void setResourcesiconid(String resourcesiconid) {
		this.resourcesiconid = resourcesiconid;
	}

	@Column(name = "RESOURCESICONPATH")
	public String getResourcesiconpath() {
		return this.resourcesiconpath;
	}

	public void setResourcesiconpath(String resourcesiconpath) {
		this.resourcesiconpath = resourcesiconpath;
	}

}
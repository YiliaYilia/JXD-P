package cn.com.sinosoft.domain.system;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * GeResources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_resources")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GeResources implements java.io.Serializable {

	// Fields

	private String resourcesid;
	private String resourcesname;
	private String resourcestype;
	private String resourceslinktype;
	private String resourcesparent;
	private String resourcescontent;
	private String resourcesdesc;
	private String resourcesstyle;
	private String resourcescode;
	
	private Set<GePermission> gePermissions = new HashSet<GePermission>(0);
	private GeResourcesIcon geResourcesIcon;

	// Constructors

	/** default constructor */
	public GeResources() {
	}

	/** minimal constructor */
	public GeResources(String resourcesid, String resourcesname,
			String resourcestype, String resourcesparent) {
		this.resourcesid = resourcesid;
		this.resourcesname = resourcesname;
		this.resourcestype = resourcestype;
		this.resourcesparent = resourcesparent;
	}

	/** full constructor */
	public GeResources(String resourcesid, String resourcesname,
			String resourcestype, String resourceslinktype,
			String resourcesparent, String resourcescontent,
			String resourcesdesc, String resourcesstyle) {
		this.resourcesid = resourcesid;
		this.resourcesname = resourcesname;
		this.resourcestype = resourcestype;
		this.resourceslinktype = resourceslinktype;
		this.resourcesparent = resourcesparent;
		this.resourcescontent = resourcescontent;
		this.resourcesdesc = resourcesdesc;
		this.resourcesstyle = resourcesstyle;
	}

	// Property accessors
	@Id
	@Column(name = "RESOURCESID", unique = true, nullable = false)
	public String getResourcesid() {
		return this.resourcesid;
	}

	public void setResourcesid(String resourcesid) {
		this.resourcesid = resourcesid;
	}

	@Column(name = "RESOURCESNAME", nullable = false)
	public String getResourcesname() {
		return this.resourcesname;
	}

	public void setResourcesname(String resourcesname) {
		this.resourcesname = resourcesname;
	}

	@Column(name = "RESOURCESTYPE", nullable = false, length = 50)
	public String getResourcestype() {
		return this.resourcestype;
	}

	public void setResourcestype(String resourcestype) {
		this.resourcestype = resourcestype;
	}

	@Column(name = "RESOURCESLINKTYPE", length = 50)
	public String getResourceslinktype() {
		return this.resourceslinktype;
	}

	public void setResourceslinktype(String resourceslinktype) {
		this.resourceslinktype = resourceslinktype;
	}

	@Column(name = "RESOURCESPARENT", nullable = false)
	public String getResourcesparent() {
		return this.resourcesparent;
	}

	public void setResourcesparent(String resourcesparent) {
		this.resourcesparent = resourcesparent;
	}

	@Column(name = "RESOURCESCONTENT")
	public String getResourcescontent() {
		return this.resourcescontent;
	}

	public void setResourcescontent(String resourcescontent) {
		this.resourcescontent = resourcescontent;
	}

	@Column(name = "RESOURCESDESC", length = 500)
	public String getResourcesdesc() {
		return this.resourcesdesc;
	}

	public void setResourcesdesc(String resourcesdesc) {
		this.resourcesdesc = resourcesdesc;
	}

	@Column(name = "RESOURCESSTYLE")
	public String getResourcesstyle() {
		return this.resourcesstyle;
	}

	public void setResourcesstyle(String resourcesstyle) {
		this.resourcesstyle = resourcesstyle;
	}
	
	

	@Column(name = "RESOURCESCODE", nullable = false)
	public String getResourcescode() {
		return resourcescode;
	}

	public void setResourcescode(String resourcescode) {
		this.resourcescode = resourcescode;
	}

	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="geResources")
	public Set<GePermission> getGePermissions() {
		return gePermissions;
	}

	public void setGePermissions(Set<GePermission> gePermissions) {
		this.gePermissions = gePermissions;
	}
	
	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="RESOURCESICONID")
	public GeResourcesIcon getGeResourcesIcon() {
		return geResourcesIcon;
	}

	public void setGeResourcesIcon(GeResourcesIcon geResourcesIcon) {
		this.geResourcesIcon = geResourcesIcon;
	}
	
	

}
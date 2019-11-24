package cn.com.sinosoft.domain.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * GePermission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_permission")
public class GePermission implements java.io.Serializable {

	// Fields

	private String permissionid;
	private String permissionname;
	private String permissiondatadesc;
	private Date permissioncreatetime;
	private String operatorname;
	private Set<GeRole> geRoles = new HashSet<GeRole>(0);
	private Set<GeResources> geResources = new HashSet<GeResources>(0);
   
	// Constructors

	/** default constructor */
	public GePermission() {
	}

	/** minimal constructor */
	public GePermission(String permissionid, String permissionname,
			Date createtime) {
		this.permissionid = permissionid;
		this.permissionname = permissionname;
		this.permissioncreatetime = createtime;
	}

	/** full constructor */
	public GePermission(String permissionid, String permissionname,
			String permissiondesc, Date createtime) {
		this.permissionid = permissionid;
		this.permissionname = permissionname;
		this.permissiondatadesc = permissiondesc;
		this.permissioncreatetime = createtime;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "PERMISSIONID", unique = true, nullable = false)
	public String getPermissionid() {
		return this.permissionid;
	}

	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid;
	}

	@Column(name = "PERMISSIONNAME", nullable = false)
	public String getPermissionname() {
		return this.permissionname;
	}

	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}

	@Column(name = "PERMISSIONDESC")
	public String getPermissiondatadesc() {
		return this.permissiondatadesc;
	}

	public void setPermissiondatadesc(String permissiondesc) {
		this.permissiondatadesc = permissiondesc;
	}

//	
	@Column(name = "CREATETIME", nullable = false, length = 8)
	public Date getPermissioncreatetime() {
		return this.permissioncreatetime;
	}

	public void setPermissioncreatetime(Date createtime) {
		this.permissioncreatetime = createtime;
	}
	
	@Column(name = "OPERATORNAME", nullable = false)
	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="gePermissions")
	public Set<GeRole> getGeRoles() {
		return geRoles;
	}

	public void setGeRoles(Set<GeRole> geRoles) {
		this.geRoles = geRoles;
	}

	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinTable(name="ge_permission_resources",joinColumns={@JoinColumn(name="PERMISSIONID")},
			inverseJoinColumns={@JoinColumn(name="RESOURCESID")})
	@OrderBy("resourcesid ASC")
	public Set<GeResources> getGeResources() {
		return geResources;
	}

	public void setGeResources(Set<GeResources> geResources) {
		this.geResources = geResources;
	}

	
	
	

}
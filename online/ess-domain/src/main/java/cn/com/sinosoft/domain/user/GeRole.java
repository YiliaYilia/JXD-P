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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * GeRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_role")
public class GeRole implements java.io.Serializable {

	// Fields

	private String roleid;
	private String rolename;
	private String roledesc;
	private Date createtime;
	private String operatorname;
	private Set<GeUser> geUsers = new HashSet<GeUser>(0);
	private Set<GeUsergroup> geUsergroups = new HashSet<GeUsergroup>(0);
	private Set<GePermission> gePermissions = new HashSet<GePermission>(0);

	// Constructors

	/** default constructor */
	public GeRole() {
	}

	/** minimal constructor */
	public GeRole(String roleid, String rolename, Date createtime) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.createtime = createtime;
	}

	/** full constructor */
	public GeRole(String roleid, String rolename, String roledesc,
			Date createtime) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.roledesc = roledesc;
		this.createtime = createtime;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ROLEID", unique = true, nullable = false)
	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	@Column(name = "ROLENAME", nullable = false)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "ROLEDESC", length = 500)
	public String getRoledesc() {
		return this.roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	
	@Column(name = "CREATETIME", nullable = false, length = 8)
	public Date getCreatetime() {
		return this.createtime;
	}

	
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	
	
	@Column(name = "OPERATORNAME", length = 50)
	public String getOperatorname() {
		return operatorname;
	}

	

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="geRoles")
	public Set<GeUser> getGeUsers() {
		return geUsers;
	}

	public void setGeUsers(Set<GeUser> geUsers) {
		this.geUsers = geUsers;
	}
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="geRoles")
	public Set<GeUsergroup> getGeUsergroups() {
		return geUsergroups;
	}

	public void setGeUsergroups(Set<GeUsergroup> geUsergroups) {
		this.geUsergroups = geUsergroups;
	}

	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(name="ge_role_permission",joinColumns={@JoinColumn(name="ROLEID")},
			inverseJoinColumns={@JoinColumn(name="PERMISSIONID")})
	public Set<GePermission> getGePermissions() {
		return gePermissions;
	}

	public void setGePermissions(Set<GePermission> gePermissions) {
		this.gePermissions = gePermissions;
	}
	
	
	

}
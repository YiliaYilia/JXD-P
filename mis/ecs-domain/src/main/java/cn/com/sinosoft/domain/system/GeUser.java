package cn.com.sinosoft.domain.system;

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
 * GeUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_user")
public class GeUser implements java.io.Serializable {


	private String userid;
	private String username;
	private String password;
	private String usertype;
	private String email;
	private String sex;
	private String phone;
	private String state;
	private Date createtime;
	private String operatorname;

	private Set<GeDepartment> geDepartments = new HashSet<GeDepartment>(0);
	private Set<GeUsergroup> geUsergroups = new HashSet<GeUsergroup>(0);
	private Set<GeRole> geRoles = new HashSet<GeRole>(0);
	
	// Constructors

	/** default constructor */
	public GeUser() {
	}

	/** minimal constructor */
	public GeUser(String userid, String username, String password,
			String state, Date createtime) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.state = state;
		this.createtime = createtime;
	}

	/** full constructor */
	public GeUser(String userid, String depid, String username,
			String password, String usertype, String email, String sex,
			String phone, String state, Date createtime) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.email = email;
		this.sex = sex;
		this.phone = phone;
		this.state = state;
		this.createtime = createtime;
	}

	// Property accessors
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "USERID", unique = true, nullable = false)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "USERNAME", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USERTYPE")
	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "SEX")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "PHONE")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "STATE", nullable = false, length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "CREATETIME", nullable = false, length = 8)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(name="ge_user_usergroup",joinColumns={@JoinColumn(name="USERID")},
		inverseJoinColumns={@JoinColumn(name ="USERGROUPID")})
	public Set<GeUsergroup> getGeUsergroups() {
		return geUsergroups;
	}

	public void setGeUsergroups(Set<GeUsergroup> geUsergroups) {
		this.geUsergroups = geUsergroups;
	}
	
	@ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(name="ge_user_role" , joinColumns={@JoinColumn(name="USERID")},
			inverseJoinColumns={@JoinColumn(name="ROLEID")})
	public Set<GeRole> getGeRoles() {
		return geRoles;
	}

	public void setGeRoles(Set<GeRole> geRoles) {
		this.geRoles = geRoles;
	}
	
	@Column(name = "OPERATORNAME")
	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	@ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(name="ge_user_dep" , joinColumns={@JoinColumn(name="USERID")},
			inverseJoinColumns={@JoinColumn(name="DEPTID")})
	public Set<GeDepartment> getGeDepartments() {
		return geDepartments;
	}

	public void setGeDepartments(Set<GeDepartment> geDepartments) {
		this.geDepartments = geDepartments;
	}
}
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
 * GeUsergroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ge_usergroup")
public class GeUsergroup implements java.io.Serializable {

	// Fields

	private String usergroupid;
	private String usergroupname;
	private String usergroupdesc;
	private String operatorname;
	private Date createtime;
	private Set<GeUser> geUsers = new HashSet<GeUser>(0);
	private Set<GeRole> geRoles = new HashSet<GeRole>(0);
	

	// Constructors

	/** default constructor */
	public GeUsergroup() {
	}

	/** minimal constructor */
	public GeUsergroup(String usergroupid, String usergroupname, Date createtime) {
		this.usergroupid = usergroupid;
		this.usergroupname = usergroupname;
		this.createtime = createtime;
	}

	/** full constructor */
	public GeUsergroup(String usergroupid, String usergroupname,
			String usergroupdesc, Date createtime) {
		this.usergroupid = usergroupid;
		this.usergroupname = usergroupname;
		this.usergroupdesc = usergroupdesc;
		this.createtime = createtime;
	}
	
	// Property accessors
	//dengyu 更新于12月20日：uuid自动生成ID字段
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "USERGROUPID", unique = true, nullable = false)
	public String getUsergroupid() {
		return this.usergroupid;
	}

	public void setUsergroupid(String usergroupid) {
		this.usergroupid = usergroupid;
	}

	@Column(name = "USERGROUPNAME", nullable = false)
	public String getUsergroupname() {
		return this.usergroupname;
	}

	public void setUsergroupname(String usergroupname) {
		this.usergroupname = usergroupname;
	}

	@Column(name = "USERGROUPDESC", length = 500)
	public String getUsergroupdesc() {
		return this.usergroupdesc;
	}

	public void setUsergroupdesc(String usergroupdesc) {
		this.usergroupdesc = usergroupdesc;
	}
	
	@Column(name = "OPERATORNAME", length = 50)
	public String getOperatorname() {
		return operatorname;
	}
	
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	@Column(name = "CREATETIME", nullable = false, length = 8)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="geUsergroups")
	public Set<GeUser> getGeUsers() {
		return geUsers;
	}

	public void setGeUsers(Set<GeUser> geUsers) {
		this.geUsers = geUsers;
	}
	
	@ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(name="ge_usergroup_role" , joinColumns={@JoinColumn(name="USERGROUPID")},
			inverseJoinColumns={@JoinColumn(name="ROLEID")})
	public Set<GeRole> getGeRoles() {
		return geRoles;
	}

	public void setGeRoles(Set<GeRole> geRoles) {
		this.geRoles = geRoles;
	}
	

}
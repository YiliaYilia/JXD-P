// default package
// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。
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

import org.hibernate.annotations.GenericGenerator;

/**
 * POJO类GeDepartment
 */
@Entity
@Table(name = "GE_DEPARTMENT")
public class GeDepartment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性机构编号 */
	private String deptid;

	/** 属性机构名称 */
	private String deptname;

	/** 属性机构编码 */
	private String deptCode;

	/** 属性父权限编号 */
	private String parentid;

	/** 属性联系地址 */
	private String contactAddress;

	/** 属性办公电话 */
	private String officePhone;

	/** 属性邮政编码 */
	private String zipCode;

	/** 属性根 */
	private String root;

	/** 机构类型*/
	private String organType;


	private Set<GeUser> geUsers = new HashSet<GeUser>(0);
	
	/**
	 * 类GeDepartment的默认构造方法
	 */
	public GeDepartment() {
	}

	/**
	 * 属性机构编号的getter方法
	 */
	@Id
	@Column(name = "DEPTID", unique = true, nullable = false)
	public String getDeptid() {
		return this.deptid;
	}

	/**
	 * 属性机构编号的setter方法
	 */
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name = "DEPTCODE")
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 属性机构名称的getter方法
	 */

	@Column(name = "DEPTNAME")
	public String getDeptname() {
		return this.deptname;
	}

	/**
	 * 属性机构名称的setter方法
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	/**
	 * 属性父权限编号的getter方法
	 */

	@Column(name = "PARENTID")
	public String getParentid() {
		return this.parentid;
	}

	/**
	 * 属性父权限编号的setter方法
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	/**
	 * 属性联系地址的getter方法
	 */

	@Column(name = "CONTACTADDRESS")
	public String getContactAddress() {
		return this.contactAddress;
	}

	/**
	 * 属性联系地址的setter方法
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	/**
	 * 属性办公电话的getter方法
	 */

	@Column(name = "OFFICEPHONE")
	public String getOfficePhone() {
		return this.officePhone;
	}

	/**
	 * 属性办公电话的setter方法
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	/**
	 * 属性根的getter方法
	 */
	@Column(name = "ROOT")
	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	/**
	 * 属性邮政编码的getter方法
	 */

	@Column(name = "ZIPCODE")
	public String getZipCode() {
		return this.zipCode;
	}

	/**
	 * 属性邮政编码的setter方法
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * 组织机构类型
	 */
	@Column(name = "ORGANTYPE")
	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}


	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="geDepartments")
	public Set<GeUser> getGeUsers() {
		return geUsers;
	}

	public void setGeUsers(Set<GeUser> geUsers) {
		this.geUsers = geUsers;
	}

}

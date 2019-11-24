package cn.com.sinosoft.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 个人信息变更报表实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "changeMineData")
public class ChangeMineData implements Serializable{
	private String coustomerid;// 客户号
	private String name;// 客户姓名
	private String email;// 邮箱
	private String postcode;// 邮编
	private String address;// 地址
	private String mobile;// 手机
	@Id
	@Column(name = "COUSTOMERID", unique = true, nullable = false)
	public String getCoustomerid() {
		return coustomerid;
	}
	public void setCoustomerid(String coustomerid) {
		this.coustomerid = coustomerid;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "POSTCODE")
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}

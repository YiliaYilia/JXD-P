package cn.com.sinosoft.web.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"systemCode","serviceCode","user","password"})  
public class PublicInfo{
	private String systemCode;
	private String serviceCode;
	private String user;
	private String password;
	
	public PublicInfo() {
		super();
	}
	public PublicInfo(String systemCode, String serviceCode, String user,
			String password) {
		super();
		this.systemCode = systemCode;
		this.serviceCode = serviceCode;
		this.user = user;
		this.password = password;
	}
	@XmlElement(name="systemCode")
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	@XmlElement(name="serviceCode")
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	@XmlElement(name="user")
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@XmlElement(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

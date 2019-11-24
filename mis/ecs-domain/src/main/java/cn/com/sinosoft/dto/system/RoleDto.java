/**
 * File Name:RoleDto.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月22日下午6:58:58
 */
package cn.com.sinosoft.dto.system;

import java.util.Date;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月22日下午6:58:58 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class RoleDto {
	private String roleid;
	private String rolename;
	private String roledesc;
	private Date createtime;
	private String operatorname;
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoledesc() {
		return roledesc;
	}
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	
	
}

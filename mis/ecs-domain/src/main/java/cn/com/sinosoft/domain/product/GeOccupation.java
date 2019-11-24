/**
 * File Name:GeOccupation.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月9日上午10:27:25
 */
package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月9日上午10:27:25 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Entity
@Table(name = "ge_occupation")
public class GeOccupation implements java.io.Serializable{
	private String occupationcode;
	private String occupationname;
	private String poccupationcode;
	private String note;
	
	@Id
	@Column(name = "OCCUPATIONCODE", unique = true, nullable = false)
	public String getOccupationcode() {
		return occupationcode;
	}
	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}
	@Column(name = "OCCUPATIONNAME", nullable = true, length = 255)
	public String getOccupationname() {
		return occupationname;
	}
	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
	}
	@Column(name = "POCCUPATIONCODE", nullable = true, length = 255)
	public String getPoccupationcode() {
		return poccupationcode;
	}
	public void setPoccupationcode(String poccupationcode) {
		this.poccupationcode = poccupationcode;
	}
	@Column(name = "NOTE", nullable = false, length = 255)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	

}

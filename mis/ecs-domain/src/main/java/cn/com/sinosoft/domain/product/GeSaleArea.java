/**
 * File Name:GeSaleArea.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月9日上午10:04:46
 */
package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**描述：服务区域<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月9日上午10:04:46 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Entity
@Table(name = "ge_sale_area")
public class GeSaleArea  implements java.io.Serializable {
	private String gno;
	private String gid;
	private String pgid;
	private String gname;
	private String note;
	private GeProductMain geProductMain;
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "GNO", unique = true, nullable = false)
	public String getGno() {
		return gno;
	}
	public void setGno(String gno) {
		this.gno = gno;
	}
	@Column(name = "GID", unique = true, nullable = false)
	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	@Column(name = "PGID", nullable = true, length = 255)
	public String getPgid() {
		return pgid;
	}
	public void setPgid(String pgid) {
		this.pgid = pgid;
	}
	@Column(name = "GNAME", nullable = true, length = 255)
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	@Column(name = "NOTE", nullable = true, length = 255)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COREPRODUCTCODE")
	public GeProductMain getGeProductMain() {
		return geProductMain;
	}

	public void setGeProductMain(GeProductMain geProductMain) {
		this.geProductMain = geProductMain;
	}

}

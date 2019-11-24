package cn.com.sinosoft.domain.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



/**
 * POJO类GeArea
 */
/**描述：区域信息实体类<br>
 * 作者：dengjiaxing <br>
 * 修改日期：2013-12-20下午08:20:56 <br>
 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
 */
@Entity
@Table(name = "GE_AREA")
public class GeArea implements java.io.Serializable {

	/** 属性产品组合ID(电子商务ID) */
	private String gid;
	
	private String pgid;

	/** 属性gname */
	private String gname;

	/** 属性pgid */
	//private String pgid;

	/** 属性TYPE */
	private Date createTime;

	/** 属性note */
	private String note;
	
	private GeArea parentArea;
	
	private List<GeArea> childs = new ArrayList<GeArea>(0);

	/**
	 * 类GeArea的默认构造方法
	 */
	public GeArea() {
	}

	/**
	 * 属性产品组合ID(电子商务ID)的getter方法
	 */
	@Id
	@Column(name = "GID")
	@OrderBy("gid ASC")
	public String getGid() {
		return this.gid;
	}

	/**
	 * 属性产品组合ID(电子商务ID)的setter方法
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}

	/**
	 * 属性gname的getter方法
	 */

	@Column(name = "GNAME")
	public String getGname() {
		return this.gname;
	}

	/**
	 * 属性gname的setter方法
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}

	/**
	 * 属性pgid的getter方法
	 */

	/*@Column(name = "PGID")
	public String getPgid() {
		return this.pgid;
	}*/

	/**
	 * 属性pgid的setter方法
	 */
	/*public void setPgid(String pgid) {
		this.pgid = pgid;
	}*/

	/**
	 * 属性CREATETIME的getter方法
	 */

	@Column(name = "CREATETIME")
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 属性TYPE的setter方法
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * 属性note的getter方法
	 */

	@Column(name = "NOTE")
	public String getNote() {
		return this.note;
	}

	/**
	 * 属性note的setter方法
	 */
	public void setNote(String note) {
		this.note = note;
	}

	
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="parentArea")
	@Cascade(value=CascadeType.ALL)
	@OrderBy("gid ASC")
	public List<GeArea> getChilds() {
		return childs;
	}
	
	@ManyToOne
	@JoinColumn(name="PGID")
	@NotFound(action=NotFoundAction.IGNORE)
	public GeArea getParentArea() {
		return parentArea;
	}

	public void setParentArea(GeArea parentArea) {
		this.parentArea = parentArea;
	}


	public void setChilds(List<GeArea> childs) {
		this.childs = childs;
	}

	@Transient
	public String getPgid() {
		return pgid;
	}

	public void setPgid(String pgid) {
		this.pgid = pgid;
	}

	
	
	
	

	
}

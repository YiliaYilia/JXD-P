package cn.com.sinosoft.dto.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**描述：区域树<br>
 * 作者：dengjiaxing <br>
 * 修改日期：2013-12-20下午08:21:22 <br>
 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
 */
public class AreaTree {
	private String id;
	private String text;
	private String state;
	private String parentId;
	/**是否是叶子结点*/
	private String isLeaf; 
	private boolean checkbox = false;
	
	/** 属性产品组合ID(电子商务ID) */
	private String gid;
	/** 属性gname */
	private String gname;
	/** 属性pgid */
	private String pgid;
	/** 属性createTime */
	private Date createTime;
	/** 属性note */
	private String note;
	
	private List<AreaTree> children = new ArrayList<AreaTree>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 类GeArea的默认构造方法
	 */
	public AreaTree() {
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getPgid() {
		return pgid;
	}
	public void setPgid(String pgid) {
		this.pgid = pgid;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<AreaTree> getChildren() {
		return children;
	}
	public void setChildren(List<AreaTree> children) {
		this.children = children;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	

	

}

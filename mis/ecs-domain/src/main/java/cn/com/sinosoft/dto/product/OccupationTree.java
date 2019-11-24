/**
 * File Name:GeOccupation.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月9日上午10:27:25
 */
package cn.com.sinosoft.dto.product;


/**
 * 职业 树
 * 描述：职业 树<br>
 * 作者：lihengjun <br>
 * 修改日期：2014年1月13日上午10:25:34 <br>
 * E-mail: lihengjun@sinosoft.com.cn <br>
 */
public class OccupationTree {
	
	private String id;
	private String text;
	private String state;
	/** 是否是叶子结点 */
	private String isLeaf;
	
	private String parentId;
	/** 标记是否选中 */
	private boolean checked = false;
	
	
	private String occupationcode;
	private String occupationname;
	private String poccupationcode;
	private String note;
	
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
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getOccupationcode() {
		return occupationcode;
	}
	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}
	public String getOccupationname() {
		return occupationname;
	}
	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
	}
	public String getPoccupationcode() {
		return poccupationcode;
	}
	public void setPoccupationcode(String poccupationcode) {
		this.poccupationcode = poccupationcode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}

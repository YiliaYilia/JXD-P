/**
 * File Name:Page.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午4:15:19
 */
package cn.com.sinosoft.core.hibernate;

import java.io.Serializable;
import java.util.List;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午4:15:19 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class Page<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_PAGE_SIZE = 20;
	private int pageSize; //第几页
	private int pageNo;		//一页显示多少数据
	private int total;		//数据总量
	private List<T> data;	//查出的数据
	
	
	

	public Page(int pageNo) {
		this(DEFAULT_PAGE_SIZE,pageNo);
	}
	
	public Page(int pageSize, int pageNo) {
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.total = total;
	}
	
	
	public Page(int pageSize, int pageNo, int total, List data) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.total = total;
		this.data = data;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getTotalPageCount(){
		if(this.total % this.pageSize==0){
			return this.total/ this.pageSize;
		}
		else{
			return this.total/ this.pageSize +1;
		}
	}
	
	
	
	

}

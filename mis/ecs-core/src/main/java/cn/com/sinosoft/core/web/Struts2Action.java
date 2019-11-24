/**
 * File Name:Struts2Action.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月17日下午2:12:28
 */
package cn.com.sinosoft.core.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**描述：struts 工具类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月17日下午2:12:28 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class Struts2Action extends ActionSupport {
	public int page;
	public int rows;
	
	/**
	 * 方法名称: getHttpSession<br>
	 * 描述：获取session对象
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:12:45
	 * @return
	 */
	public HttpSession getHttpSession(){
		return getHttpServletRequest().getSession();
	}
	
	/**
	 * 方法名称: getHttpSession<br>
	 * 描述：获取session对象
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:12:55
	 * @param flag
	 * @return
	 */
	public HttpSession getHttpSession(boolean flag){
		return getHttpServletRequest().getSession(flag);
	}
	
	/**
	 * 方法名称: getHttpServletRequest<br>
	 * 描述：获取request对象
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:13:06
	 * @return
	 */
	public HttpServletRequest getHttpServletRequest(){
		return ServletActionContext.getRequest();
	}
	/**
	 * 方法名称: getHttpServletResponse<br>
	 * 描述：获取response对象
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:13:18
	 * @return
	 */
	public HttpServletResponse getHttpServletResponse(){
		return ServletActionContext.getResponse();
	}
	/**
	 * 方法名称: getServletContext<br>
	 * 描述：获取servletContext对象
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:13:30
	 * @return
	 */
	public ServletContext getServletContext(){
		return ServletActionContext.getServletContext();
	}
	
	/**
	 * 方法名称: setRequestAttribute<br>
	 * 描述：设置request 属性
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午1:28:44
	 * @param name
	 * @param value
	 */
	public void setRequestAttribute(String name,Object value){
		this.getHttpServletRequest().setAttribute(name, value);
	}

	/**
	 * 方法名称: getParameter<br>
	 * 描述：获取参数
	 * 作者: honghui
	 * 修改日期：2014年1月2日下午1:43:40
	 * @param name
	 * @return
	 */
	public String getParameter(String name){
		return this.getHttpServletRequest().getParameter(name);
	}
	
	/**
	 * 方法名称: render<br>
	 * 描述：返回给浏览器
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:40:57
	 * @param text
	 * @param contentType
	 */
	public void render(String text, String contentType){
	    HttpServletResponse response;
	    try{
	      response = getHttpServletResponse();
	      response.setContentType(contentType);
	      response.getWriter().write(text);
	      response.getWriter().flush();
	    } 
	    catch (IOException e) {
	      throw new IllegalStateException(e);
	    }
	}
	
	/**
	 * 方法名称: renderText<br>
	 * 描述：返回普通文本浏览器
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:41:21
	 * @param text
	 */
	public void renderText(String text){
	    render(text, "text/plain;charset=UTF-8");
	}
	
	/**
	 * 方法名称: renderHtml<br>
	 * 描述：返回HTML格式浏览器
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:41:46
	 * @param text
	 */
	public void renderHtml(String text){
	    render(text, "text/html;charset=UTF-8");
	}

	/**
	 * 方法名称: renderXML<br>
	 * 描述：返回XML格式浏览器
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:42:17
	 * @param text
	 */
	public void renderXML(String text){
	    render(text, "text/xml;charset=UTF-8");
	}
	
	
	/**
	 * 方法名称: renderJson<br>
	 * 描述：返回JSON格式数据
	 * 作者: honghui
	 * 修改日期：2013年12月22日下午5:21:00
	 * @param text
	 */
	public void renderJson(String text){
		render(text,"text/json;charset=UTF-8");
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
	
	
	
	
	
	
	
	



	
}

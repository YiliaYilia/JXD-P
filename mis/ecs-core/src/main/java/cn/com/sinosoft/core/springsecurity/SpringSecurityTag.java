/**
 * File Name:SpringSecurityTag.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月19日上午10:58:33
 */
package cn.com.sinosoft.core.springsecurity;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**描述：springsecurity 标签，主要控制功能<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月19日上午10:58:33 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class SpringSecurityTag extends TagSupport {
	/**权限，可以为多个以","隔开*/
	private String permission;
	/**权限描述*/
	private String desc;
	
	/**
	 * 方法名称：doStartTag <br>
	 * 描述：开始处理标签 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月19日上午11:03:56 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag() 
	 * @return
	 * @throws JspException
	 */
	public int doStartTag() throws JspException{
		 String[] pers = permission.split(",");
		 boolean boo = SpringSecurityUtil.hasAnyRole(pers);
		 if(boo){
			 return EVAL_BODY_INCLUDE;
		 }
		 else{
			 return SKIP_BODY;
		 }
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}

/**
 * File Name:SpringSecurityTag.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月19日上午10:58:33
 */
package cn.com.sinosoft.core.springsecurity;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.security.core.GrantedAuthority;

/**描述：springsecurity 标签，主要控制功能<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月19日上午10:58:33 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class SpringSecurityScriptTag extends TagSupport {
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
	public int doEndTag() throws JspException{
		//获取用户拥有的权限
		if(SpringSecurityUtil.getAuthentication() == null){
			return SKIP_BODY;
		}
		Collection<GrantedAuthority> grantedAuthorityList = SpringSecurityUtil.getAuthentication().getAuthorities();
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript' >");
		sb.append("function Auth(){ ");
		sb.append("var map_ = new Object(); ");
		Iterator<GrantedAuthority> it = grantedAuthorityList.iterator();
		while(it.hasNext()){
			GrantedAuthority authority = it.next();
			sb.append("map_['"+authority.getAuthority()+"']='"+authority.getAuthority()+"'; ");
		}
		sb.append("map_.access = function(key){ ");
		sb.append("if(typeof(map_[key+'']) == 'undefined'){ return false;}");
		sb.append("else{ return true;}}; ");
		sb.append(" return map_;}");
		sb.append(" var auth = new Auth();");
		sb.append("</script>");
		try {
			pageContext.getOut().println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
		
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

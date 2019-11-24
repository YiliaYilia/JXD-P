/**
 * File Name:ECSAuthenticationFilter.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午8:45:32
 */
package cn.com.sinosoft.permission.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**描述：ECS后台登陆过滤器<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午8:45:32 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class ECSAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	
	
	/**页面输入用户名文本框name属性*/
	private String userPropertyName;
	/**页面输入密码文本框name属性*/
	private String passwordPropertyName;
	/**页面输入验证码文本框name属性*/
	private String authcodePropertyName;
	
	public ECSAuthenticationFilter(String interceptPath){
		super(interceptPath);
	}
	
	/**方法名称：attemptAuthentication <br>
	 * 描述：拦截，需要做认证 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午8:50:27 
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	 * @param request
	 * @param response
	 * @return
	 * @throws AuthenticationException
	 */
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		String userName = request.getParameter(userPropertyName);
		String password = request.getParameter(passwordPropertyName);
		String authcode = request.getParameter(authcodePropertyName);
		
		HttpSession session = request.getSession(false);
		 
		/**如果配置了验证码，就要对其进行验证*/
		if(authcode != null){
			if(session.getAttribute("code") != null){
				String code = String.valueOf(session.getAttribute("code"));
				if(!code.equals(authcode)){
					throw new UsernameNotFoundException("验证码错误");
				}
			}
			else{
				throw new UsernameNotFoundException("验证码错误");
			}
		}
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, password);
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));

		Authentication authentication = this.getAuthenticationManager().authenticate(authRequest);
        return authentication;
	}

	public String getUserPropertyName() {
		return userPropertyName;
	}

	public void setUserPropertyName(String userPropertyName) {
		this.userPropertyName = userPropertyName;
	}

	public String getPasswordPropertyName() {
		return passwordPropertyName;
	}

	public void setPasswordPropertyName(String passwordPropertyName) {
		this.passwordPropertyName = passwordPropertyName;
	}

	public String getAuthcodePropertyName() {
		return authcodePropertyName;
	}

	public void setAuthcodePropertyName(String authcodePropertyName) {
		this.authcodePropertyName = authcodePropertyName;
	}
	
	
	
	
	

	
	
}

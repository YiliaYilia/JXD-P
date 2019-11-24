/**
 * File Name:UTFEncodeFilter.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月24日下午1:24:50
 */
package cn.com.sinosoft.core.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**描述：在spring中，filter都默认继承OncePerRequestFilter
 * 	OncePerRequestFilter顾名思义，他能够确保在一次请求只通过一次filter，而不需要重复执行
 * 如，servlet2.3与servlet2.4也有一定差异为了兼容各种不同的运行环境和版本，
 * 默认filter继承OncePerRequestFilter是一个比较稳妥的选择<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月24日下午1:24:50 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class EncodeFilter extends OncePerRequestFilter{
	private String encoding;
	

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}


	/**方法名称：doFilterInternal <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月24日下午1:26:08 
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain) 
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(encoding != null){
			request.setCharacterEncoding(this.encoding);
		}
		filterChain.doFilter(request, response);
	}

}

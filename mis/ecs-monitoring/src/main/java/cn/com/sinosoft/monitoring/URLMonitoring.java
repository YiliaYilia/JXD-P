/**
 * File Name:URLMonitoring.java
 * @Description: 
 * Copyright Sinosoft Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月17日下午2:41:10
 */
package cn.com.sinosoft.monitoring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

/**描述：url请求监控<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月17日下午2:41:10 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class URLMonitoring implements Filter{
	//进行匹配URL
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	/**方法名称：init <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月17日下午2:43:30 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig) 
	 * @param filterConfig
	 * @throws ServletException
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	/**方法名称：doFilter <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月17日下午2:43:30 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain) 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String url = httpServletRequest.getServletPath();
		String compiledUrlPattern = "/system/userLogin";
		//if(urlMatcher.pathMatchesUrl(compiledUrlPattern, url)){
		if(true){
			//<wanhonghui> 不能删除，这里作为日志标识符
			StopWatch stopWatch = new Slf4JStopWatch("<wanhonghui>"+url);
			//stopWatch.setTimeThreshold(1*1000L);
			chain.doFilter(request, response);
			stopWatch.stop();
		}
		else{
			chain.doFilter(request, response);
		}
		
	}

	/**方法名称：destroy <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月17日下午2:43:30 
	 * @see javax.servlet.Filter#destroy() 
	 */
	public void destroy() {
		
		
	}

}

package cn.com.sinosoft.web.util;

import javax.servlet.ServletContext;

/**
 * 
 * @author GHY
 *
 */
public final class ContextUtil {

	private ServletContext servletContext;

	public static ServletContext getServletContext() {
		return getInstance().servletContext;
	}

	public static final ContextUtil getInstance() {
		return instance;
	}

	private static final ContextUtil instance = new ContextUtil();

	public void init(ServletContext servletContext) {
		this.servletContext = servletContext;
		servletContext.setAttribute("path", servletContext.getRealPath("/"));
	}

	public void cleanup() {
		servletContext = null;
	}
}

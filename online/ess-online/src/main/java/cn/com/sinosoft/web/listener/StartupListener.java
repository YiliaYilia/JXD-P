package cn.com.sinosoft.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.com.sinosoft.web.util.ContextUtil;

/**
 * 启动socket监听
 * 
 * @author GHY
 */
public class StartupListener implements ServletContextListener {

	private TokenSocketServer tokenSocketServer;

	public void contextDestroyed(ServletContextEvent event) {
		ContextUtil.getInstance().cleanup();
		if (tokenSocketServer != null && tokenSocketServer.isInterrupted()) {
			tokenSocketServer.closeSocket();
			tokenSocketServer.interrupt();
		}
	}

	public void contextInitialized(ServletContextEvent event) {
		javax.servlet.ServletContext servletContext = event.getServletContext();
		ContextUtil.getInstance().init(servletContext);
		if (tokenSocketServer == null) {
			tokenSocketServer = new TokenSocketServer();
			tokenSocketServer.start();// servlet上下文初始化时启动socket服务端线程
		}
	}
}

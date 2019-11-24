package cn.com.sinosoft.web.listener;

import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.service.impl.PayServiceImpl;
/**
 * 启动socket服务
 * @author GHY
 */
public class TokenSocketServer extends Thread {
	public static Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);
	private ServerSocket serverSocket;  
	
	public void run(){
		try {
			while(!this.isInterrupted()){//线程未中断执行循环
				Socket socket = serverSocket.accept();//从连接请求队列中取出一个连接
				if(socket != null){
					ProcessSocketData processSocketData = new ProcessSocketData(socket);
					processSocketData.start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TokenSocketServer() {
		try {
			if(serverSocket == null){
				serverSocket = new ServerSocket(7777);
			}
			logger.info("## socket服务启动");
		} catch (Exception e) {
			logger.error("##服务启动异常："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void closeSocket(){
		try {
		    if(serverSocket!=null)serverSocket.close();
		    logger.info("##关闭socket服务");
		} catch (Exception e) {
			logger.error("关闭socket服务异常："+e.getMessage());
			e.printStackTrace();
		}
	}
}

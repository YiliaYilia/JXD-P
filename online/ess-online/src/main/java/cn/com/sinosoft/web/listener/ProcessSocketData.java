package cn.com.sinosoft.web.listener;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.web.domain.Token;
import cn.com.sinosoft.web.util.ContextUtil;

/**
 * 处理请求socket信息
 * 
 * @author GHY
 */
public class ProcessSocketData extends Thread {
	public static Logger logger = LoggerFactory.getLogger(ProcessSocketData.class);
	private PrintWriter out;
	private Socket socket;
	private DataInputStream dis;
	private FileOutputStream fos = null;
	private byte[] inputByte = null;
	private int length = 0;

	public ProcessSocketData(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			logger.info("#New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
			dis = new DataInputStream(socket.getInputStream());
			out = new PrintWriter(socket.getOutputStream(), true);
			String tag = getString(dis,5);//请求标识
			logger.info("# 请求标识："+tag);
			if("token".equals(tag)){
				//获取token值
				Token token = Token.getInstance();
				String accessToken = "";
				if (token == null) {
					logger.error("##获取token值为空");
				} else {
					accessToken = token.getAccessToken();
				}
				Map<String, String> tokenTicketTemp = new HashMap<String, String>();
				tokenTicketTemp.put("accessToken", accessToken);
				tokenTicketTemp.put("ticket", token.getTicket());
				JSONObject tokenTicket = JSONObject.fromObject(tokenTicketTemp);
				logger.info("返回给客户端信息："+tokenTicket.toString());
				out.write(tokenTicket.toString());
			} else {
				logger.info("#Receive picture start");
				String path =ContextUtil.getServletContext().getAttribute("path")+"/picture/"+tag.substring(2, 5)+getString(dis,Integer.parseInt(tag.substring(0, 2))-5);
				logger.info("#picture path :"+path+".jpg");
				fos = new FileOutputStream(new File(path+".jpg"));
				inputByte = new byte[1024];
				while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
					fos.write(inputByte, 0, length);
					fos.flush();
				}
				logger.info("#Receive picture end");
			}
			
		} catch (Exception e) {
			logger.error("##服务请求异常：" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (fos != null)
					fos.close();
				if (dis != null)
					dis.close();
				if (socket != null)
					socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取信息标识 信息中前6个字符为标识
	 * @param dis
	 * @return
	 * @throws Exception
	 */
	private String getString(DataInputStream dis,int i) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] language = new byte[i];
		int len = dis.read(language, 0, i);
		outStream.write(language, 0, len);
		byte[] data = outStream.toByteArray();// 网页的二进制数据
		outStream.close();
		return new String(data);
	}
	
}

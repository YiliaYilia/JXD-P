package cn.com.sinosoft.web.listener.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取token值
 * @author GHY
 */
public class SocketClient {
	public static Logger logger = LoggerFactory.getLogger(SocketClient.class);
	
	public static Map<String,String> send(){
		String result="";
		Socket sock = null;
		DataOutputStream dos = null;
		Map<String,String> resultMap= new HashMap<String,String>();
		try {
			sock = new Socket("127.0.0.1", 7777);
			dos = new DataOutputStream(sock.getOutputStream());
			dos.write("token".getBytes(), 0, 5);
	        //响应报文
	        byte[] datas=readInputStream(sock.getInputStream());
	        result=new String(datas);
	        logger.info("###响应报文： "+result);
	        JSONObject  jasonObject = JSONObject.fromObject(result);
	        resultMap = (Map)jasonObject;
		        
		} catch (Exception e) {
			logger.error("##socket获取token异常："+e.getMessage()+" socket返回数据："+result);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (dos != null)
					dos.close();
				if(sock != null)
					sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		if(result != null && result.length()>12){
//			result = result.substring(12, result.length());
//		}
		return resultMap;
	}
	
	/**
     * 从输入流中读取数据
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len = inStream.read(buffer)) !=-1 ){
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();//网页的二进制数据
        outStream.close();
        inStream.close();
        return data;
    }
//    public static void main(String[] args) {
//    	
//    	System.out.println(Class.class.getClass().getResource("/").getPath());
//    	SocketClient.send();
//	}
    
}

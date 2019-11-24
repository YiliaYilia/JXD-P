package cn.com.sinosoft.web.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
//import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.ess.protal.common.ConfigProp;
import cn.com.sinosoft.web.domain.Message;
import cn.com.sinosoft.web.domain.Messages;
import cn.com.sinosoft.web.domain.MobileNums;
import cn.com.sinosoft.web.domain.PublicInfo;
import cn.com.sinosoft.web.domain.TXLife;

public class MessageUtil {
	
	public static Logger logger = LoggerFactory.getLogger(MessageUtil.class);
	
	
	/**
	 * 实体转xml报文
	 * @param clazz 实体类所属Class
	 * @param t 实体
	 * @return
	 */
	public static  <T> String beanToXML(Class<T> clazz,T t){
		String str = ""; 
		try{
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
		    StringWriter sw = new StringWriter();
		    marshaller.marshal(t, sw);
		    str = sw.toString();
		}catch (JAXBException e) {
			logger.info("xml格式转换失败");
	        e.printStackTrace();  
	    }  
		return str;
	}
	
	
	 /**
	  * 报文转实体
	  * @param xml 报文
	  * @param clazz 实体类所属Class
	  * @return
	  */
	 public static<T> T XMLStringToBean(String xml,Class<T> clazz){
		 T t = null;
		 try{
	         JAXBContext context = JAXBContext.newInstance(clazz);  
	         Unmarshaller unmarshaller = context.createUnmarshaller();  
	         t = (T)unmarshaller.unmarshal(new StringReader(xml));
	     }catch (JAXBException e) {  
	    	 e.printStackTrace();  
	     } 
		 return t;
	 }
	 
	/**
	 * 报文阶段首字母的大小写转换
	 * @param xml 报文内容
	 * @param flag true:转大写 false:转小写
	 * @return
	 */
	public static String A2aOra2A(String xml,boolean flag){
		String[] strs = xml.split("<");
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		if(flag){
			for(int i=2;i<strs.length;i++){
				sb.append("<");
				char chr = strs[i].charAt(0);
				if(Character.isLetter(chr)){//如果是字母
					sb.append(Character.toUpperCase(chr)).append(strs[i].substring(1));
				}else{//如果非字母
					sb.append(chr).append(Character.toUpperCase(strs[i].charAt(1))).append(strs[i].substring(2));
				}
			}
		}else{
			for(int i=2;i<strs.length;i++){
				sb.append("<");
				char chr = strs[i].charAt(0);
				if(Character.isLetter(chr)){//如果是字母
					sb.append(Character.toLowerCase(chr)).append(strs[i].substring(1));
				}else{//如果非字母
					sb.append(chr).append(Character.toLowerCase(strs[i].charAt(1))).append(strs[i].substring(2));
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 向指定位置发送报文
	 * @param xmlStr
	 * @param url
	 * @return
	 */
	public static String sendXml(String xmlStr,String url){
		logger.info("发送内容: "+xmlStr);
		logger.info("发送路径："+url);
		RequestEntity entity = null;
		String xml = null;
        try {
			entity = new StringRequestEntity(xmlStr, "text/xml","GBK");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
        PostMethod post = new PostMethod(url);//请求地址
        post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
        post.setRequestEntity(entity);//这里添加xml字符串
        // 指定请求内容的类型
        post.setRequestHeader("Content-type", "text/xml; charset=GBK");
        HttpClient httpclient = new HttpClient();//创建 HttpClient 的实例
        int result;
        try {
        result = httpclient.executeMethod(post);
        logger.info("Response status code: " + result);//返回200为成功
        logger.info("返回内容："+post.getResponseBodyAsString());//返回的内容
        xml = A2aOra2A(post.getResponseBodyAsString(),false);
        post.releaseConnection();//释放连接
        } catch (HttpException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
		return xml;
	}
	
	
	public static String sendMessage(String No,String msg){
		String result = "";
		try{
			List<String> MobileNum = new ArrayList<String>();
			MobileNum.add(No);
			MobileNums mobileNums = new MobileNums(MobileNum);
			Message message = new Message();
			message.setMobileNums(mobileNums);
			message.setMessageId("0000010618");
			message.setMessTopic("");
			message.setSendData(msg);
			message.setDataType("1");
			message.setSendWay("0");
			message.setUnitCode("01");
			message.setDealOrder("0");
			PublicInfo publicInfo = new PublicInfo();
			publicInfo.setSystemCode("TST");
			publicInfo.setServiceCode("IT002");
			publicInfo.setUser("B83030F38883E26B9EF52938C69CF6CE");
			publicInfo.setPassword("25D55AD283AA400AF464C76D713C07AD");
			Messages messages = new Messages();
			messages.setMessage(message);
			messages.setPublicInfo(publicInfo);
			String xml = A2aOra2A(beanToXML(Messages.class,messages),true);
			String u = DataCoverter.byteArrayToHexString(DataCoverter.encodeByMD5("CBS".getBytes()));
			String p = DataCoverter.byteArrayToHexString(DataCoverter.encodeByMD5("cbs".getBytes()));
			String messageUrl = ConfigProp.getString("messageUrl");
			System.out.println("user:"+u);
			System.out.println("password:"+p);
			//String jspUrl = "http://cnbjaps2.om-bsam.cn:8080/sms/interface/SysSendMsg.jsp?userName=" + u + "&password=" + p;
			String jspUrl = messageUrl+"?userName="+ u + "&password=" + p;
			String responseXml = A2aOra2A(sendXml(xml, jspUrl),false);
			TXLife txlife = XMLStringToBean(responseXml,TXLife.class);
			String transResult = txlife.getTransResult();
			if(transResult.equals("1")){
				result = "success";
			}else{
				result = txlife.getErrMsg();
			}
		}catch(Exception e){
			result = "error";
			logger.error("发送短信异常："+e);
			e.printStackTrace();
		}finally{
			return result;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		sendMessage("18518204383","Hello World");
	}
	
	/*//发短信
	@Test
	public void 发短信(){
		System.out.println(sendMessage("15313196733","鹏总吉祥"));
//		String responseXml = "<?xml version=\"1.0\" encoding=\"GBK\"?><TXLife><TransResult>1</TransResult><ErrSource>SMS</ErrSource><ErrMsg>提交成功</ErrMsg></TXLife>";
//		responseXml = A2aOra2A(responseXml,false);
//		TXLife txlife = XMLStringToBean(responseXml,TXLife.class);
//		String transResult = txlife.getTransResult();
//		System.out.println(transResult);
	}
	*/
}

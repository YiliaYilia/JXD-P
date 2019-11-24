package cn.com.sinosoft.ess.protal.policydownload;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.utils.PropertityUtil;
import cn.com.sinosoft.ess.protal.model.PolicyDownloadData;

import com.indigopacific.customagent.IDGWebServiceClient;
/**
 * 描述 ： 电子保单下载
 * 作者： wufuxing 
 * 修改日期：2014-4-9 18:30:22
 */
public class PolicyDownload {
	private final static Logger logger = LoggerFactory.getLogger(PolicyDownload.class);
	//properties文件属性名称
	/**WebService地址*/
	private static final String POLICY_DOWNLOAD_IP = "PolicyDownloadIP";
	/**WebService 名称空间*/
	private static final String POLICY_DOWNLOAD_PORT = "PolicyDownloadPort";
		
	private static String POLICYDOWNLOADIP=null;
	private static String POLICYDOWNLOADPORT=null;
	static{
		//读取文件初始化保单下载接口信息参数
		PropertityUtil.init("config/portal.properties");
		POLICYDOWNLOADIP = PropertityUtil.get(PolicyDownload.POLICY_DOWNLOAD_IP);
		POLICYDOWNLOADPORT = PropertityUtil.get(PolicyDownload.POLICY_DOWNLOAD_PORT);
	}
	/*
	 * 调保单接口
	 * 返回保单文件的文件流
	 * */
	public InputStream getPolicyPdf(PolicyDownloadData pdd ){
		InputStream returnIs = null;
		try {
			String requestXML= marshal(pdd);
			logger.info(requestXML);
			InputStream is = new ByteArrayInputStream(requestXML.getBytes("UTF-8"));
			returnIs = IDGWebServiceClient.invokeIDG(is,POLICYDOWNLOADIP,POLICYDOWNLOADPORT);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnIs;
	}
	/*
	 * 将保单号转成xml格式 的字符串
	 * 
	 * */
	public static String marshal(Object object)
			throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());  
	    Marshaller marshaller = jaxbContext.createMarshaller(); 
	    // 指定XML 头一行信息不生成
	    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); 
	    // 设定XML投头的格式
	    marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    //设置编码
	    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
	    // 用来指定是否使用换行和缩排对已编组XML数据进行格式化的属性名称   
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	    
	    OutputStream outputStream = new ByteArrayOutputStream();
	    marshaller.marshal(object,outputStream); 
		return outputStream.toString();
	}
}

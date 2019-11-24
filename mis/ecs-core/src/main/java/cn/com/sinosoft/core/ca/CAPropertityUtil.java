package cn.com.sinosoft.core.ca;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;

/**描述：获取CA配置文件中信息<br>
 * 作者：dengjiaxing <br>
 * 修改日期：2014-1-13下午05:21:54 <br>
 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
 */
public class CAPropertityUtil {
	private static  CAPropertityUtil urlPropertityUtil= new CAPropertityUtil();
	private static Properties properties= null;
	private CAPropertityUtil(){}
	
	static{
		InputStream is = CAPropertityUtil.class.getClassLoader().getResourceAsStream("config/CA.properties");
		properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 方法名称: get<br>
	 * 描述：通过key获取资源文件中的value
	 * 作者: wanhonghui
	 * 修改日期：2013年8月31日上午9:35:30
	 * @param key
	 * @return 返回value值
	 */
	public static String get(String key){
		return properties.get(key)==null?null:properties.get(key).toString();
	}

}

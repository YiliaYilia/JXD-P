/**
 * File Name:MonitoringAppender.java
 * @Description: 
 * Copyright Sinosoft Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月17日下午4:26:20
 */
package cn.com.sinosoft.monitoring.loggerAppender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月17日下午4:26:20 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class MonitoringAppender extends AppenderSkeleton{

	/**方法名称：close <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月17日下午4:27:07 
	 * @see org.apache.log4j.Appender#close() 
	 */
	public void close() {
		// TODO Auto-generated method stub
		
	}

	/**方法名称：requiresLayout <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月17日下午4:27:07 
	 * @see org.apache.log4j.Appender#requiresLayout() 
	 * @return
	 */
	public boolean requiresLayout() {
		// TODO Auto-generated method stub
		return false;
	}

	/**方法名称：append <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2014年1月17日下午4:27:07 
	 * @see org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent) 
	 * @param arg0
	 */
	@Override
	protected void append(LoggingEvent event) {
		// TODO Auto-generated method stub
		String mess = event.getMessage().toString();
		String[] s = mess.split("<wanhonghui>");
		if(s.length >=2){
			for (int i = 1; i < s.length; i++) {
				System.out.println(s[i].replaceAll("\\s{1,}", "-"));
			}
		}
	}

}

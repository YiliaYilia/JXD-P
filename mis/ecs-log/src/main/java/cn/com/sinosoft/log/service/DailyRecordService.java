/**
 * File Name:DailyRecordService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月27日下午3:17:31
 */
package cn.com.sinosoft.log.service;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeDailyRecord;

/**描述：日常操作记录服务类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月27日下午3:17:31 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface DailyRecordService {
	
	/**
	 * 方法名称: addDailyRecord<br>
	 * 描述：添加记录
	 * 作者: honghui
	 * 修改日期：2013年12月27日下午3:19:05
	 * @param geDailyRecord
	 */
	public void addDailyRecord(GeDailyRecord geDailyRecord);
	
	/**
	 * 方法名称: getRolesByName<br>
	 * 描述：分页获取操作日志
	 * 作者: honghui
	 * 修改日期：2013年12月27日下午4:12:11
	 * @param startTime
	 * @param endTime
	 * @param operatorName
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<GeDailyRecord> getRolesByName(String startTime,String endTime,String operatorName,int pageNumber,int pageSize);
}

/**
 * File Name:DailyRecordServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月27日下午3:19:39
 */
package cn.com.sinosoft.log.service.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.DateUtils;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.system.GeDailyRecord;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.log.service.DailyRecordService;

/**描述：日常操作记录服务类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月27日下午3:19:39 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Component
public class DailyRecordServiceImpl extends GenericHibernateDao<GeDailyRecord,String> implements DailyRecordService {

	/**方法名称：addDailyRecord <br>
	 * 描述： 添加记录<br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月27日下午3:19:39 
	 * @see cn.com.sinosoft.log.service.DailyRecordService#addDailyRecord(cn.com.sinosoft.domain.system.GeDailyRecord) 
	 * @param geDailyRecord
	 */
	public void addDailyRecord(GeDailyRecord geDailyRecord) {
		super.save(geDailyRecord);
	}

	
	public Page<GeDailyRecord> getRolesByName(String startTime,String endTime,String operatorName,int pageNumber,int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		if(!StringUtils.isEmpty(operatorName)){
			queryRule.addLike("operatorName", "%"+operatorName+"%");
		}
		if(!StringUtils.isEmpty(startTime)){
			Date start = DateUtils.toDate(startTime+" 00:00:00", DateUtils.YYYY_MM_DD_HMS);
			queryRule.addGreaterEqual("createTime", start);
		}
		if(!StringUtils.isEmpty(endTime)){
			Date end = DateUtils.toDate(endTime+" 23:59:59", DateUtils.YYYY_MM_DD_HMS);
			queryRule.addLessEqual("createTime", end);
		}
		queryRule.addDescOrder("createTime");
		return this.find(entityClass, queryRule, pageNumber, pageSize);
	}
}

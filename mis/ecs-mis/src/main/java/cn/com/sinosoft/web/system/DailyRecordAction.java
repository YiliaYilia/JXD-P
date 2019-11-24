/**
 * File Name:GeDailyRecordAction.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月27日下午3:59:42
 */
package cn.com.sinosoft.web.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GeDailyRecord;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.dto.system.RoleDto;
import cn.com.sinosoft.log.service.DailyRecordService;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月27日下午3:59:42 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class DailyRecordAction extends Struts2Action{
	@Autowired
	private DailyRecordService dailyRecordService;
	
	
	@Action(value="dailyRecordPage")
	public String  jumpDailyRecordPage(){
		
		return "/page/main/record";
	}
	
	@Action(value="getDailyRecord")
	public void getDailyRecord(){
		String startTime  =getHttpServletRequest().getParameter("startTime");
		String endTime = getHttpServletRequest().getParameter("endTime");
		String operatorName =getHttpServletRequest().getParameter("operatorName");
		Page<GeDailyRecord> recordPage = dailyRecordService.getRolesByName(startTime, endTime, operatorName, page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		List<GeDailyRecord> dailyRecords = recordPage.getData();
		map.put("total", recordPage.getTotal());
		map.put("rows", dailyRecords);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(map,jsonConfig));
	}

}

/**
 * File Name:SpringSecurityTag.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月19日上午10:58:33
 */
package cn.com.sinosoft.config.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.sinosoft.config.service.DictDataService;
import cn.com.sinosoft.config.service.DictTypeService;
import cn.com.sinosoft.domain.system.GeDictData;
import cn.com.sinosoft.domain.system.GeDictType;
import cn.com.sinosoft.dto.system.DictForScriptTag;
import edu.emory.mathcs.backport.java.util.Collections;

/**
 * 描述：数据字典标签<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月19日上午10:58:33 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */

public class DictTagCodeToContent extends TagSupport {

	/**
	 * 字典类型code
	 */
	private String typeCode = "";

	/**
	 * 方法名称：doEndTag <br>
	 * 描述：开始处理标签 <br>
	 * 作者：liyang <br>
	 * 修改日期：2013年12月19日上午11:03:56
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 * @return
	 * @throws JspException
	 */
	public int doEndTag() throws JspException {
		WebApplicationContext wc = WebApplicationContextUtils
				.getRequiredWebApplicationContext(pageContext
						.getServletContext());
		DictTypeService dictTypeService = (DictTypeService) wc
				.getBean(DictTypeService.class);
		String[] typeCodes = null;
		if (typeCode.contains(",")) {
			typeCodes = typeCode.split(",");
		} else {
			typeCodes = new String[1];
			typeCodes[0] = typeCode;
		}
		List<GeDictType> types = new ArrayList<GeDictType>();
		for (String code : typeCodes) {
			types.add(dictTypeService.findTypeByCode(code));
		}
		StringBuffer sb = new StringBuffer();
		List<DictForScriptTag> resultList = new ArrayList<DictForScriptTag>();
		if (types.size() > 0) {
			for (GeDictType geDictType : types) {
				Set<GeDictData> temp = geDictType.getGeDictDatas();
				Iterator<GeDictData> iterator = temp.iterator();
				while (iterator.hasNext()) {
					GeDictData geDictData = iterator.next();
					DictForScriptTag tag = new DictForScriptTag();
					BeanUtils.copyProperties(geDictData, tag);
					BeanUtils.copyProperties(geDictType, tag);
					resultList.add(tag);
				}
			}
			JsonConfig config = new JsonConfig();
			config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			sb.append("<script type=\"text/javascript\">");
			sb.append("var result = '';");
			sb.append("function dictTrans(dictCode,dictType){");
			sb.append("if(result==''){");
			sb.append("result = "
					+ JSONArray.fromObject(resultList, config).toString() + ";");
			sb.append("}");
			sb.append("result = eval(result);");
			sb.append("for(var i = 0;i<result.length;i++){");
			sb.append("if(result[i].dicttypecode==dictType&&result[i].dictdatacode==dictCode){");
			sb.append("return result[i].dictdataname;");
			sb.append("}}return \"\";");
			sb.append("};");
			sb.append("function dictReload(ctx,dictType){");
			sb.append("$.ajax({async:false,url:ctx+'/system/dictReload',data:{'dictType':dictType,'temp':new Date().getTime()},success:function(data){data = eval(data);result=data.result;}});");
			sb.append("}");
			sb.append(" </script>");
		}
		try {
			pageContext.getOut().println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
}

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
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.sinosoft.config.service.DictDataService;
import cn.com.sinosoft.config.service.DictTypeService;
import cn.com.sinosoft.domain.system.GeDictData;
import cn.com.sinosoft.domain.system.GeDictType;

/**描述：数据字典标签<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月19日上午10:58:33 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */

public class DictTag extends TagSupport {
	
	/**字典名称*/
	private String typeCode="";
	/**id选择器*/
	private String id="";
	/**class选择器*/
	private String clazz="";
	/**name 属性*/
	private String name="";
	/**样式*/
	private String style="";
	/**选择默认选项的值*/
	private String defaultValue="";
	/**组件类型*/
	private String type="select";
	/**
	 * 字典代码
	 */
	private String dictCode="";
	
	private boolean pleaseChoose = false;
	
	private int brNumber = 0;
	/**
	 * 方法名称：doStartTag <br>
	 * 描述：开始处理标签 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月19日上午11:03:56 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag() 
	 * @return
	 * @throws JspException
	 */
	public int doEndTag() throws JspException{
		 WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext());
		 DictTypeService dictTypeService = (DictTypeService)wc.getBean(DictTypeService.class);
		 DictDataService dictDataService = (DictDataService)wc.getBean(DictDataService.class);
		 GeDictType geDictType = dictTypeService.findDictTypeByCode(typeCode);
		 StringBuffer sb = new StringBuffer();
		 if("radio".equalsIgnoreCase(type)){
			 if(geDictType != null){
					Set<GeDictData> geDictDatas = geDictType.getGeDictDatas();
					if(geDictDatas != null){
						for(GeDictData data : geDictDatas){
							if(data.getDictdatacode().equals(defaultValue)){
								sb.append("<input type='radio' id='"+id+"' class='"+clazz+"' style='"+style+"' name='"+name+"'  checked='checked' value='"+data.getDictdatacode()+"'>"+data.getDictdataname());
							}
							else{
								sb.append("<input type='radio'  id='"+id+"' class='"+clazz+"' style='"+style+"' name='"+name+"'  value='"+data.getDictdatacode()+"'>"+data.getDictdataname());
							}
						}
					}
			 }
			
		 }
		 else if("select".equalsIgnoreCase(type)){
			 sb.append("<SELECT");
			 sb.append(" id='"+id+"'");
			 sb.append(" class='"+clazz+"'");
			 sb.append(" style='"+style+"'");
			 sb.append(" name='"+name+"' >");
			if(geDictType != null){
				Set<GeDictData> geDictDatas = geDictType.getGeDictDatas();
				if(geDictDatas != null){
					if(pleaseChoose){
						sb.append("<option value=''>请选择</option>");
					}
					for(GeDictData data : geDictDatas){
						if(data.getDictdatacode().equals(defaultValue)){
							sb.append("<option value='"+data.getDictdatacode()+"' selected='selected'>"+data.getDictdataname()+"</option>");
						}
						else{
							sb.append("<option value='"+data.getDictdatacode()+"'>"+data.getDictdataname()+"</option>");
						}
					}
				}
			}
			sb.append(" </SELECT>");
		 } else if("span".equalsIgnoreCase(type)){
			 sb.append("<SPAN");
			 sb.append(" id='"+id+"'");
			 sb.append(" class='"+clazz+"'");
			 sb.append(" style='"+style+"'");
			 sb.append(" name='"+name+"' >");
			if(geDictType != null){
				String name = dictDataService.findDictByCode(dictCode, geDictType.getDicttypeid()).getDictdataname();
				sb.append(name);
			}
			sb.append(" </SPAN>");
		 }
		 else if("checkbox".equalsIgnoreCase(type)){
			 if(geDictType != null){
					Set<GeDictData> geDictDatas = geDictType.getGeDictDatas();
					int br = 0;
					if(geDictDatas != null){
						for(GeDictData data : geDictDatas){
							br++;
							String[] defval = defaultValue.split(",");
							boolean boo = false;
							for(String def:defval){
								if(data.getDictdatacode().equals(def)){
									boo = true;
								}
							}
							if(boo){
								sb.append("<input type='checkbox' id='"+id+"' class='"+clazz+"' style='"+style+"' name='"+name+"'  checked='checked' value='"+data.getDictdatacode()+"'>"+data.getDictdataname());
								
							}
							else{
								sb.append("<input type='checkbox'  id='"+id+"' class='"+clazz+"' style='"+style+"' name='"+name+"'  value='"+data.getDictdatacode()+"'>"+data.getDictdataname());
							}
							if(br == brNumber){
								sb.append("<br>");
								br =0;
							}
							
						}
					}
			 }
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public boolean isPleaseChoose() {
		return pleaseChoose;
	}

	public void setPleaseChoose(boolean pleaseChoose) {
		this.pleaseChoose = pleaseChoose;
	}

	public int getBrNumber() {
		return brNumber;
	}

	public void setBrNumber(int brNumber) {
		this.brNumber = brNumber;
	}


	
	
	
	
}

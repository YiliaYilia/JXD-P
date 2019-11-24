package cn.com.sinosoft.web.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.config.service.DictDataService;
import cn.com.sinosoft.config.service.TemplateService;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GeDictData;
import cn.com.sinosoft.domain.system.GeTemplate;
import cn.com.sinosoft.dto.system.DictType;
import cn.com.sinosoft.dto.system.TemplateData;
import cn.com.sinosoft.dto.system.TemplateData.tempData;

public class TmplateAction extends Struts2Action {

	private static final long serialVersionUID = 5461290569937677542L;

	@Autowired
	private TemplateService templateService;
	@Autowired
	private DictDataService dictDataService;

	private String tempid;  //模板id
	private String getmpids; // 模板ids
	private String tempname; // 模板名称
	private String funcode; //功能code
	private String tempcontent; // 模板内容
	private String typecode; //模板类型code
	private String funtype;   //功能名称（添加/修改）
	private String newtempname; //新的模板名称
	
	
	
	public String getFuncode() {
		return funcode;
	}
	public void setFuncode(String funcode) {
		this.funcode = funcode;
	}
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public String getFuntype() {
		return funtype;
	}
	public void setFuntype(String funtype) {
		this.funtype = funtype;
	}
	public String getNewtempname() {
		return newtempname;
	}
	public void setNewtempname(String newtempname) {
		this.newtempname = newtempname;
	}
	public String getTempid() {
		return tempid;
	}
	public void setTempid(String tempid) {
		this.tempid = tempid;
	}
	public String getGetmpids() {
		return getmpids;
	}
	public void setGetmpids(String getmpids) {
		this.getmpids = getmpids;
	}
	public String getTempname() {
		return tempname;
	}
	public void setTempname(String tempname) {
		this.tempname = tempname;
	}
	
	public String getTempcontent() {
		return tempcontent;
	}
	public void setTempcontent(String tempcontent) {
		this.tempcontent = tempcontent;
	}

	/**
	 * 跳转到短信模板页面
	 * @return
	 */
	@Action(value = "template")
	public String jumpTmplate() {
		return "/page/main/systemtemplate";
	}

	/**
	 * 修改短息模板
	 * 
	 * @return
	 */
	@Action(value = "updateTemplate")
	public void updateNoteTemplate() {
		String result = "fail";

		if (validataContent("UPDATE")) {
			GeTemplate geTemplate = templateService.getGeTemplateByID(tempid);
			if (geTemplate != null) {
				boolean isRight = false;
				if(!geTemplate.getTempname().equals(tempname) || !geTemplate.getFunctioncode().equals(funcode) || !geTemplate.getTypecode().equals(typecode)){
					isRight = templateService.existTemplate(tempname, funcode, typecode);
				}
				if(!isRight){
					GeDictData function = dictDataService.findDictDataByDictDataCode(funcode);
					GeDictData type = dictDataService.findDictDataByDictDataCode(typecode);
					if(null != type && null != function){
						geTemplate.setTempcontent(tempcontent);
						geTemplate.setTempname(tempname);
						geTemplate.setOperatopname(SpringSecurityUtil.getCurrentUserName());
						geTemplate.setFunctioncode(funcode);
						geTemplate.setTypecode(typecode);
						templateService.updateTemplate(geTemplate);
						result = "success";
					}
				} 
			} 
		} 
		renderText(result);
	}

	/**
	 * 删除短信模板
	 */
	@Action(value = "deleteTemplate")
	public void deleteNoteTemplate() {
		String[] ids = getmpids.split(",");
		String result = "";
		for (String string : ids) {
			templateService.deleteTemplate(string);
			result = "success";
		}
		renderText(result);
	}

	/**
	 * 添加短信模板
	 */
	@Action(value = "addTemplate")
	public void addNoteTemplate() {
		String result = "fail";
		if(validataContent("ADD")){
			try {
				if(!templateService.existTemplate(tempname, funcode, typecode)){
					GeDictData function = dictDataService.findDictDataByDictDataCode(funcode);
					GeDictData type = dictDataService.findDictDataByDictDataCode(typecode);
					if(null !=  type && null != function){
						GeTemplate geTemplate = new GeTemplate();
						geTemplate.setCreateTime(new Date());
						geTemplate.setTempcontent(tempcontent);
						geTemplate.setTempname(tempname);
						geTemplate.setOperatopname(SpringSecurityUtil.getCurrentUserName());
						geTemplate.setFunctioncode(funcode);
						geTemplate.setTypecode(typecode);
						templateService.saveTemplate(geTemplate);
						result = "success";
					}
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		renderText(result);
	}

	/**
	 * 搜索短信模板（根据模板名称模糊查询）
	 * @return
	 */
	@Action(value = "searchTmplate")
	public String searchNoteTmplateList() {
		GeTemplate geTemplate = new GeTemplate();
		if(null != tempname && !"".equals(tempname)){
			tempname = "%" + tempname + "%";
		}
		Page<GeTemplate> page = templateService.findAllTemplateByTempName(super.getPage(), super.getRows(), tempname);
		TemplateData tempdata = new TemplateData();
		tempdata.setTotal(String.valueOf(page.getTotal()));
		List<tempData> rows = new ArrayList<TemplateData.tempData>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (GeTemplate data : (List<GeTemplate>)page.getData()) {
			tempData temp = new tempData();
			temp.setTempid(data.getGetempid());
			temp.setTempcontent(data.getTempcontent());
			temp.setTempname(data.getTempname());
			temp.setCreateTime((sdf.format(data.getCreateTime())));
			temp.setOperatopname(data.getOperatopname());
			temp.setFunctioncode(data.getFunctioncode());
			temp.setTypecode(data.getTypecode());
			rows.add(temp);
		}
		tempdata.setRows(rows);
		String result = JSONObject.fromObject(tempdata).toString();
		super.render(result, "text/json;charset=UTF-8");
		return null;
	}
	
	/***
	 * 判断该模板名称是否已经存在
	 * @return
	 */
	@Action(value = "exitsTmplate")
	public String exitsTemplate(){
		Map<String, String> result = new HashMap<String, String>();
		if(funtype.equals("UPDATE")){
			GeTemplate geTemplate = templateService.getGeTemplateByID(tempid);
			if(geTemplate == null){
				result.put("error", "模板不存在");
			} else {
				if(geTemplate.getTempname().equals(tempname) && geTemplate.getFunctioncode().equals(funcode) && geTemplate.getTypecode().equals(typecode)){
					result.put("ok", "");
				} else {
					boolean isRight = templateService.existTemplate(tempname, funcode, typecode);
					if(isRight){
						result.put("error", "模板已经存在");
					} else {
						result.put("ok", "");
					}
				}
			}
		} else {
			boolean isRight = templateService.existTemplate(tempname, funcode, typecode);
			if(isRight){
				result.put("error", "模板已经存在");
			} else {
				result.put("ok", "");
			}
		}
		renderJson(JSONObject.fromObject(result).toString());
		return null;
	}
	
	/**
	 * 验证所填写内容是否为空
	 * 
	 * @return
	 */
	private boolean validataContent(String type) {
		if(tempname == null || tempname.equals("")){
			return false;
		}
		if(typecode == null || typecode.equals("")){
			return false;
		}
		if(funcode == null || funcode.equals("")){
			return false;
		}
		if(tempcontent == null || tempcontent.equals("")){
			return false;
		}
		if(type.equals("UPDATE") && (tempid == null || tempid.equals(""))){
			return false;
		}
		return true;
	}
}

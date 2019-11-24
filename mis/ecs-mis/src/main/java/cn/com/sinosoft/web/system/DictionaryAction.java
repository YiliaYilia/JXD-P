package cn.com.sinosoft.web.system;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.config.service.DictDataService;
import cn.com.sinosoft.config.service.DictTypeService;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GeDictData;
import cn.com.sinosoft.domain.system.GeDictType;
import cn.com.sinosoft.dto.system.DictData;
import cn.com.sinosoft.dto.system.DictData.DictDataRow;
import cn.com.sinosoft.dto.system.DictForScriptTag;
import cn.com.sinosoft.dto.system.DictType;
import cn.com.sinosoft.dto.system.DictTypeForPage;
import cn.com.sinosoft.dto.system.DictTypeForPage.DictTypeRow;

/**
 * 描述： 字典管理Aciton<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-18下午06:40:25 <br>
 * E-mail: <br>
 */
public class DictionaryAction extends Struts2Action {

	/**
	 * DictionaryAction.java
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private DictDataService dictDataService;

	@Autowired
	private DictTypeService dictTypeService;

	/**
	 * 方法名称: jumpDictDataManagementPage<br>
	 * 描述： 作者: liyang 修改日期：2013-12-19下午02:14:29
	 * 
	 * @return
	 */
	@Action(value = "dictDataManagement")
	public String jumpDictDataManagementPage() {
		return "/page/main/dictManage";
	}

	@Action(value = "dictDataTypeManagement")
	public String jumpDictTypeManagementPage() {
		return "/page/main/dictTypeManage";
	}

	/**
	 * 方法名称: 查找所有字典类型转换成json返回给页面展示<br>
	 * 描述： 作者: liyang 修改日期：2013-12-19下午06:01:26
	 * 
	 * @return
	 */
	@Action(value = "findAllDictType")
	public String findAllDictType() {

		List<GeDictType> dictTypes = dictTypeService.findAllDictType();
		List<DictType> ds = new ArrayList<DictType>();
		StringBuilder sb = new StringBuilder();
		for (GeDictType dictType : dictTypes) {
			DictType dt = new DictType();
			dt.setId(dictType.getDicttypeid());
			dt.setText(dictType.getDicttypename());
			sb.append(dictType.getDicttypename());
			dt.setDesc(sb.toString());
			sb.delete(0, sb.length());
			ds.add(dt);
		}

		String result = JSONArray.fromObject(ds).toString();
		super.render(result, "text/json;charset=UTF-8");
		return null;
	}

	/**
	 * 方法名称: 保存数据字典<br>
	 * 描述： 作者: liyang 修改日期：2013-12-19下午07:36:18
	 * 
	 * @return
	 */
	@Action(value = "saveDictData")
	public String saveDictData() {
		String dictDataCode = getHttpServletRequest().getParameter("dictDataCode");
		String dictTypeID = getHttpServletRequest().getParameter("dictTypeID");
		String dictDataDesc = getHttpServletRequest().getParameter("dictDataDesc");
		String dictDataName = getHttpServletRequest().getParameter("dictDataName");
		String dictDataID = getHttpServletRequest().getParameter("dictDataID");
		
		try {
			dictDataCode = new String (dictDataCode.getBytes("iso-8859-1"), "UTF-8") ;
			dictTypeID = new String (dictTypeID.getBytes("iso-8859-1"), "UTF-8") ;
			dictDataDesc = new String (dictDataDesc.getBytes("iso-8859-1"), "UTF-8") ;
			dictDataName = new String (dictDataName.getBytes("iso-8859-1"), "UTF-8") ;
			dictDataID = new String (dictDataID.getBytes("iso-8859-1"), "UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return null;
		}

		GeDictData dictData = null;
		String type = "save";
		String result = "保存成功";
		// 是否修改保存
		if (dictDataID != null && !"".equals(dictDataID)) {
			dictData = dictDataService.findDictDataByID(dictDataID);
			type = "update";
			result = "修改成功";
		} else {
			// 新建保存
			dictData = new GeDictData();
		}
		GeDictType dictType = dictTypeService.findDictTypeById(dictTypeID);
		dictData.setDictdatadesc(dictDataDesc);
		dictData.setDictdatacode(dictDataCode);
		dictData.setDictdataname(dictDataName);
		dictData.setGeDictType(dictType);
		dictData.setCreatetime(new Date());
		dictData.setOperatorname(SpringSecurityUtil.getCurrentUserName());

		dictDataService.saveOrUpdateDictData(dictData, type);

		super.render("{\"success\":true,\"value\":\"" + result + "\"}",
				"text/json;charset=UTF-8");

		return null;
	}

	/**
	 * 方法名称: deleteDictDatas<br>
	 * 描述：删除一个或多个数据字典 作者: liyang 修改日期：2013-12-19下午08:36:54
	 * 
	 * @return
	 */
	@Action(value = "deleteDictDatas")
	public String deleteDictDatas() {

		String manyIds = getHttpServletRequest().getParameter("deleteIds");
		List<String> ids = new ArrayList<String>();
		if (manyIds.contains(",")) {
			String[] temp = manyIds.split(",");
			for (String str : temp) {
				ids.add(str);
			}
		} else {
			ids.add(manyIds);
		}

		dictDataService.deleteDictDatas(ids);

		return null;
	}

	/**
	 * 方法名称: editDictData<br>
	 * 描述：修改 作者: liyang 修改日期：2013-12-20上午10:12:15
	 * 
	 * @return
	 */
	@Action(value = "editDictData")
	public String editDictData() {

		String editId = getHttpServletRequest().getParameter("editId");
		if (editId != null && !"".equals(editId)) {
			GeDictData geDictData = dictDataService.findDictDataByID(editId);

			super.render(
					"{\"success\":true,\"dictdataid\":\""
							+ geDictData.getDictdataid()
							+ "\",\"dicttypeid\":\""
							+ geDictData.getGeDictType().getDicttypeid()
							+ "\",\"dictdataname\":\""
							+ geDictData.getDictdataname()
							+ "\",\"dictdatadesc\":\""
							+ geDictData.getDictdatadesc()
							+ "\",\"dictdatacode\":\""
							+ geDictData.getDictdatacode() + "\"}",
					"text/json;charset=UTF-8");
		}

		return null;
	}

	/**
	 * 方法名称: searchDictData<br>
	 * 描述：搜索数据字典 作者: liyang 修改日期：2013-12-20下午04:38:05
	 * 
	 * @return
	 */
	@Action(value = "searchDictData")
	public String searchDictData() {
		String dictTypeID = getHttpServletRequest().getParameter("dictTypeID");
		Page<GeDictData> pageObj = null;
		if (dictTypeID == null || "".equals(dictTypeID)) {
			pageObj = dictDataService.findAllDictData(super.page, super.rows);
		} else {
			pageObj = dictDataService.findDictDataByTypeID(dictTypeID,
					super.page, super.rows);
		}
		DictData dictData = new DictData();
		dictData.setTotal(pageObj.getTotal() + "");
		List<DictDataRow> listRows = new ArrayList<DictDataRow>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (GeDictData data : (List<GeDictData>) pageObj.getData()) {
			DictDataRow row = new DictDataRow();
			BeanUtils.copyProperties(data, row);
			row.setDicttypecode(data.getGeDictType().getDicttypecode());
			row.setDicttypename(data.getGeDictType().getDicttypename());
			row.setCreatetimestr(sdf.format(data.getCreatetime()));
			listRows.add(row);
		}
		dictData.setRows(listRows);
		String result = JSONObject.fromObject(dictData).toString();
		super.render(result, "text/json;charset=UTF-8");
		return null;
	}

	// 字典类型管理
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 方法名称: searchDictTypeData<br>
	 * 描述：分页查找字典类型 作者: liyang 修改日期：2013-12-23下午02:19:51
	 * 
	 * @return
	 */
	@Action(value = "searchDictTypeData")
	public String searchDictTypeData() {
		String dictTypeName = getHttpServletRequest().getParameter(
				"dictTypeName");

		Page<GeDictType> pageObj = null;
		if (dictTypeName == null || "".equals(dictTypeName)) {
			pageObj = dictTypeService.findAllDictType(super.page, super.rows);
		} else {
			pageObj = dictTypeService.findDictTypeByTypeName(dictTypeName,
					super.page, super.rows);
		}
		DictTypeForPage dictTypeForPage = new DictTypeForPage();
		dictTypeForPage.setTotal(pageObj.getTotal() + "");
		List<DictTypeRow> listRows = new ArrayList<DictTypeRow>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (GeDictType data : (List<GeDictType>) pageObj.getData()) {
			DictTypeRow row = new DictTypeRow();
			BeanUtils.copyProperties(data, row);
			row.setCreatetimestr(sdf.format(data.getCreatetime()));
			listRows.add(row);
		}
		dictTypeForPage.setRows(listRows);
		String result = JSONObject.fromObject(dictTypeForPage).toString();
		super.render(result, "text/json;charset=UTF-8");
		return null;
	}

	/**
	 * 方法名称: saveDictTypeData<br>
	 * 描述：保存数据字典类型 作者: liyang 修改日期：2013-12-23下午04:50:40
	 * 
	 * @return
	 */
	@Action(value = "saveDictTypeData")
	public String saveDictTypeData() {
		
		String dictTypeCode = getHttpServletRequest().getParameter("dictTypeCode");
		String dictTypeName = getHttpServletRequest().getParameter("dictTypeName");
		String dictTypeID = getHttpServletRequest().getParameter("dictTypeID");
		
		try {
			dictTypeCode = new String (dictTypeCode.getBytes("iso-8859-1"), "UTF-8") ;
			dictTypeName = new String (dictTypeName.getBytes("iso-8859-1"), "UTF-8") ;
			dictTypeID = new String (dictTypeID.getBytes("iso-8859-1"), "UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return null;
		}

		GeDictType dictType = null;
		String type = "save";
		String result = "保存成功";
		// 是否修改保存
		if (dictTypeID != null && !"".equals(dictTypeID)) {
			dictType = dictTypeService.findDictTypeById(dictTypeID);
			type = "update";
			result = "修改成功";
		} else {
			// 新建保存
			dictType = new GeDictType();
		}

		dictType.setDicttypecode(dictTypeCode);
		dictType.setDicttypename(dictTypeName);
		dictType.setCreatetime(new Date());
		dictType.setOperatorname(SpringSecurityUtil.getCurrentUserName());

		dictTypeService.saveOrUpadteDictType(dictType, type);

		super.render("{\"success\":true,\"value\":\"" + result + "\"}",
				"text/json;charset=UTF-8");

		return null;
	}

	/**
	 * 方法名称: editDictTypeData<br>
	 * 描述：编辑数据字典类型 作者: liyang 修改日期：2013-12-23下午05:19:32
	 * 
	 * @return
	 */
	@Action(value = "editDictTypeData")
	public String editDictypeData() {

		String editId = getHttpServletRequest().getParameter("editId");
		if (editId != null && !"".equals(editId)) {
			GeDictType geDictType = dictTypeService.findDictTypeById(editId);

			Map map = new HashMap();
			map.put("success", true);
			map.put("dictTypeID", geDictType.getDicttypeid());
			map.put("dictTypeName", geDictType.getDicttypename());
			map.put("dictTypeCode", geDictType.getDicttypecode());

			super.render(JSONObject.fromObject(map).toString(),
					"text/json;charset=UTF-8");
		}

		return null;
	}

	/**
	 * 方法名称: deleteDictTypeDatas<br>
	 * 描述：删除字典类型 作者: liyang 修改日期：2013-12-23下午05:58:23
	 * 
	 * @return
	 */
	@Action(value = "deleteDictTypeDatas")
	public String deleteDictTypeDatas() {

		String manyIDs = getHttpServletRequest().getParameter("deleteIDs");
		List<String> ids = new ArrayList<String>();
		if (manyIDs.contains(",")) {
			String[] temp = manyIDs.split(",");
			for (String str : temp) {
				ids.add(str);
			}
		} else {
			ids.add(manyIDs);
		}
		dictTypeService.deleteDictTypeDatas(ids);
		return null;
	}

	// 数据字典验证
	// //////////////////////////////////////////////////////////////////

	/**
	 * 方法名称: existDictData<br>
	 * 描述：验证数据字典是否存在 作者: liyang 修改日期：2013-12-24下午02:07:42
	 * 
	 * @return
	 */
	@Action(value = "existDictData")
	public String existDictData() {
		Map<String, String> result = new HashMap<String, String>();
		String dictDataCodeAuth = getHttpServletRequest().getParameter(
				"dictDataCodeAuth");
		String dictTypeID = getHttpServletRequest().getParameter("dicttypeid");
		String operateType = getHttpServletRequest()
				.getParameter("operateType");
		String oldCode = getHttpServletRequest().getParameter("oldCode");
		String oldID = getHttpServletRequest().getParameter("oldID");
		// 如果名字和原来一样并且是修改操作，不验证
		if (operateType != null && "UPDATE".equals(operateType)
				&& oldCode != null && dictDataCodeAuth != null
				&& dictDataCodeAuth.equals(oldCode) && dictTypeID != null
				&& oldID != null && oldID.equals(dictTypeID)) {
			result.put("ok", "");
		} else {
			if (dictTypeID == null || "".equals(dictTypeID)) {
				result.put("error", "请选择所属类型");
			} else {
				boolean ifExist = dictDataService.ifExistByTypeAndDataCode(
						dictTypeID, dictDataCodeAuth);
				if (ifExist) {
					result.put("error", "字典已经存在");
				} else {
					result.put("ok", "");
				}
			}
		}
		renderJson(JSONObject.fromObject(result).toString());
		return null;
	}

	// 验证数据字典类型
	// //////////////////////////////////////////////////////////////

	/**
	 * 方法名称: existDictType<br>
	 * 描述：数据字典类型是否存在 作者: liyang 修改日期：2013-12-24下午05:29:02
	 * 
	 * @return
	 */
	@Action(value = "existDictType")
	public String existDictType() {
		Map<String, String> result = new HashMap<String, String>();
		String dictTypeCode = getHttpServletRequest().getParameter(
				"dictTypeCodeAuth");
		String oldCode = getHttpServletRequest().getParameter("oldCode");
		String operateType = getHttpServletRequest()
				.getParameter("operateType");

		if (operateType != null && "UPDATE".equals(operateType)
				&& oldCode != null && dictTypeCode != null
				&& oldCode.equals(dictTypeCode)) {
			result.put("ok", "");
		} else {
			boolean exist = dictTypeService.ifExistDictType(dictTypeCode);
			if (exist) {
				result.put("error", "类型代码已经存在");
			} else {
				result.put("ok", "");
			}
		}
		renderJson(JSONObject.fromObject(result).toString());
		return null;
	}

	/**
	 * 方法名称: dictReload<br>
	 * 描述：重新载入标签 作者: liyang 修改日期：2013-12-30下午05:29:02
	 * 
	 * @return
	 */
	@Action(value = "dictReload")
	public String dictReload() {
		String typeCode = getHttpServletRequest().getParameter("dictType");
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
			String result =  JSONArray.fromObject(resultList, config).toString();
			super.renderJson("{\"result\":"+result+"}");
		}
		return null;
	}

}

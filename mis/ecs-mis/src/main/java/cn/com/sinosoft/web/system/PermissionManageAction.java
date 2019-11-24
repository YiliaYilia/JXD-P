package cn.com.sinosoft.web.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.permission.service.PermissionService;
import cn.com.sinosoft.permission.service.ResourceService;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GePermission;
import cn.com.sinosoft.dto.system.PermissionData;
import cn.com.sinosoft.dto.system.PermissionData.PermissionDataRow;
import cn.com.sinosoft.domain.system.GeResources;

/**
 * 描述： 权限管理Aciton<br>
 * 作者：liaojiping <br>
 * 修改日期：2013-12-19下午07:40:25 <br>
 * E-mail: <br>
 */
public class PermissionManageAction extends Struts2Action{
	private List<GeResources> geResources;
	@Autowired
	private PermissionService PermissionDataService;
	@Autowired
	private ResourceService resourceService;
	
	private GePermission gePermission;
	
	public List<GeResources> getGeResources() {
		return geResources;
	}
	public void setGeResources(List<GeResources> geResources) {
		this.geResources = geResources;
	}
	public GePermission getGePermission() {
		return gePermission;
	}
	public void setGePermission(GePermission gePermission) {
		this.gePermission = gePermission;
	}
	/**
	 * 方法名称: jumpPermissionManagementPage<br>
	 * 描述： 显示权限管理页面
	 * 作者: liaojiping 
	 * 修改日期：2013-12-19下午08:00:29
	 * @return
	 */
	@Action(value = "permission")
	public String jumpPermissionManagementPage() {
		return "/page/main/permissionManage";
	}
	
	/**
	 * 方法名称: jumpAddOrUpdatePage<br>
	 * 描述： 显示添加或修改权限页面
	 * 作者: liaojiping 
	 * 修改日期：2013-12-25下午18:20:29
	 * @return
	 */
	@Action(value="permissionOperate")
	public String jumpAddOrUpdatePage(){
		if("ADD".equals(this.getHttpServletRequest().getParameter("operate"))){
			List<GeResources> resources = resourceService.getGeResourcesAll();
			this.getHttpServletRequest().setAttribute("opeartype", "ADD");
			this.getHttpServletRequest().setAttribute("resources",resources);
		}
		else if("UPDATE".equals(this.getHttpServletRequest().getParameter("operate"))){
			
			GePermission permission = PermissionDataService.findPermissionDataByID(gePermission.getPermissionid());
			//获取自己拥有的资源
			List<GeResources> owerResources = new ArrayList<GeResources>(permission.getGeResources());
			//获取所有的资源
			List<GeResources> resources = resourceService.getGeResourcesAll();
			//移除自己的资源，就是未拥有的资源
			resources.removeAll(owerResources);
			this.getHttpServletRequest().setAttribute("owerResources",owerResources);
			this.getHttpServletRequest().setAttribute("resources",resources);
			this.getHttpServletRequest().setAttribute("gePermission", permission);
			this.getHttpServletRequest().setAttribute("opeartype", "UPDATE");
			
		}
		return "/page/main/permission-operate";
	}
	
	/**
	 * 方法名称:savePermissionData <br>
	 * 描述：保存权限资源
	 * 作者: liajiping
	 * 修改日期：2013-12-25下午18:30:18
	 * @return
	 */
	
	@Action(value="savePermissionData")
	public String savePermissionData(){
		String permissionName = getHttpServletRequest().getParameter("permissionName");
		String permissionDataDesc = getHttpServletRequest().getParameter("permissionDataDesc");
		String permissionId = getHttpServletRequest().getParameter("permissionId");
		GePermission permissionData = null;
		String type="save";
		String result = "保存成功";
		if(permissionId!=null&&!"".equals(permissionId)){
			permissionData = PermissionDataService.findPermissionDataByID(permissionId);
			type="update";
			result = "修改成功";
		}else if("".equals(permissionName)|| "".equals(permissionDataDesc)){
			super.render("{\"success\":false}", "text/json;charset=UTF-8");
		}else{
			permissionData = new GePermission();
		}

		permissionData.setPermissiondatadesc(permissionDataDesc);
		permissionData.setPermissionname(permissionName);
		permissionData.setOperatorname(SpringSecurityUtil.getCurrentUserName());
		permissionData.setPermissioncreatetime(new Date());
		PermissionDataService.saveOrUpdatePermissionData(permissionData,type);
		super.render("{\"success\":true,\"value\":\""+result+"\"}", "text/json;charset=UTF-8");
		return null;
	}
	
	/**
	 * 方法名称: deletepermissionDatas<br>
	 * 描述：删除一个或多个权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-19下午08:36:54
	 * @return
	 */
	@Action(value="deletePermissionDatas")
	public void deletePermissionDatas(){
		
		String manyIds = getHttpServletRequest().getParameter("deleteIds");
		List<String> ids = new ArrayList<String>();
		if(manyIds.contains(",")){
			String[] temp = manyIds.split(",");
			for(String str:temp){
				ids.add(str);
			}
		}else{
			ids.add(manyIds);
		}
		PermissionDataService.deletePermission(ids);
		renderText("SUCCESS");
	}
	
	/**
	 * 方法名称: editPermissionData<br>
	 * 描述：修改权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-20上午10:12:15
	 * @return
	 */
	@Action(value="editPermissionData")
	public String editPermissionData(){
		String editId = getHttpServletRequest().getParameter("editId");
		if (editId != null && !"".equals(editId)) {
			GePermission permissionData = PermissionDataService.findPermissionDataByID(editId);
			super.render(
					"{\"success\":true,\"permissionid\":\""		
							+ permissionData.getPermissionid() + "\",\"permissionname\":\""
							+ permissionData.getPermissionname()
							+ "\",\"permissiondatadesc\":\""
							+ permissionData.getPermissiondatadesc()
							+ "\",\"permissioncreatetime\":\""
							+ permissionData.getPermissioncreatetime() + "\"}",
					"text/json;charset=UTF-8");
		}
		return null;
	}
	
	/**
	 * 方法名称: searchPermissionData<br>
	 * 描述：显示所有权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-20上午10:12:15
	 * @return
	 */
	@Action(value="searchPermissionData")
	public String searchPermissionData(){
		String pagestr = getHttpServletRequest().getParameter("page");
		String rowsstr = getHttpServletRequest().getParameter("rows");
		
		Map<String,Integer> page = new HashMap<String,Integer>();
		page.put("page", new Integer(pagestr));
		page.put("rows", new Integer(rowsstr));
		
		String permissionName = getHttpServletRequest().getParameter("permissionnameSearch");
		
		Page pageObj = null;
		if(permissionName==null||"".equals(permissionName)){
			pageObj = PermissionDataService.findAllPermissionData(page);
		}else {
			pageObj = PermissionDataService.findPermissionDataByName(permissionName, page);
		}
		PermissionData permissionData = new PermissionData();
		permissionData.setTotal(pageObj.getTotal() + "");
		List<PermissionDataRow> listRows = new ArrayList<PermissionDataRow>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (GePermission data : (List<GePermission>)pageObj.getData()) {
			PermissionDataRow row = new PermissionDataRow();
			BeanUtils.copyProperties(data, row);
			row.setCreatetimeformat(sdf.format(row.getPermissioncreatetime()));
			listRows.add(row);
		}
		permissionData.setRows(listRows);
		String result = JSONObject.fromObject(permissionData).toString();
		super.render(result, "text/json;charset=UTF-8");
		return null;
	}	
	
	/**
	 * 方法名称: existPermission<br>
	 * 描述：校验权限名称
	 * 作者: liaojiping
	 * 修改日期：2013-12-25上午10:12:15
	 * @return
	 */
	@Action(value="existPermission")
	public void existPermission(){
		
		Map<String, String> result = new HashMap<String, String>();
		String permissionName=getHttpServletRequest().getParameter("permissionname");
		if("ADD".equals(getHttpServletRequest().getParameter("operate"))){
			boolean boo = PermissionDataService.existPermissionName(permissionName);
			if(boo){ //存在
				result.put("error", "权限已经存在");
			}
			else{//不存在
				result.put("ok", "");
			}
		}
		else{
			result.put("ok", "");
		}
		renderText(JSONObject.fromObject(result).toString());
	}
	
	/**
	 * 方法名称: addOrUpdatePermission<br>
	 * 描述：添加或修改权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-25下午16:12:15
	 * @return
	 */
	@Action(value="addOrUpdatePermission")
	public void addOrUpdatePermission(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if("ADD".equals(getHttpServletRequest().getParameter("operate"))){
			if(geResources != null){
				gePermission.setGeResources(new HashSet<GeResources>(geResources));
			}
			gePermission.setPermissioncreatetime(new Date());
			gePermission.setOperatorname(SpringSecurityUtil.getCurrentUserName());
			PermissionDataService.addPermission(gePermission);
		}
		else if("UPDATE".equals(getHttpServletRequest().getParameter("operate"))){
			//PermissionDataService.deletePermissionHaveResource(gePermission.getPermissionid());
			
			GePermission permission = PermissionDataService.get(gePermission.getPermissionid());
			
			Set<GeResources> res = new HashSet<GeResources>();
			if(geResources != null){
				res.addAll(geResources);
			}
			permission.setPermissiondatadesc(gePermission.getPermissiondatadesc());
		//	System.out.println("GePermission permission"+permission.getPermissiondatadesc());
			permission.setPermissioncreatetime(new Date());
			permission.setOperatorname(SpringSecurityUtil.getCurrentUserName());
		
			PermissionDataService.updatePermission(permission,res);
		}
		renderText("SUCCESS");
	}
}

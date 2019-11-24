/**
 * File Name:RoleAction.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月22日下午4:56:28
 */
package cn.com.sinosoft.web.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GePermission;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.dto.system.RoleDto;
import cn.com.sinosoft.permission.service.PermissionService;
import cn.com.sinosoft.permission.service.RoleService;

/**描述：角色请求处理类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月22日下午4:56:28 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class RoleAction extends Struts2Action{
	private GeRole geRole;
	private List<GePermission> gePermissions;
	private String[] roleids;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 方法名称: jumpRolePage<br>
	 * 描述：跳转到角色管理页面
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:22:48
	 * @return
	 */
	@Action(value="roleManager")
	public String  jumpRolePage(){
		
		return "/page/main/role";
	}
	
	/**
	 * 方法名称: getRoles<br>
	 * 描述：分页获取角色
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:23:02
	 */
	@Action(value="getRoles")
	public void getRoles(){
		String rolename ="";
		if(geRole != null){
			rolename = geRole.getRolename();
		}
		Page<GeRole> rolePage = roleService.getRolesByName(rolename, page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		List<RoleDto> roleDtos = new ArrayList<RoleDto>();
		List<GeRole> roles = rolePage.getData();
		for(GeRole role:roles){
			RoleDto roleDto = new RoleDto();
			BeanUtils.copyProperties(role, roleDto);
			roleDtos.add(roleDto);
		}
		map.put("total", rolePage.getTotal());
		map.put("rows", roleDtos);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(map,jsonConfig));
	}
	
	/**
	 * 方法名称: jumpAddOrUpdatePage<br>
	 * 描述：跳转到角色操作页面（添加、修改）
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:23:15
	 * @return
	 */
	@Action(value="roleOperate")
	public String jumpAddOrUpdatePage(){
		if("ADD".equals(this.getHttpServletRequest().getParameter("operate"))){
			List<GePermission> permissions = permissionService.findAllPermissionData();
			this.getHttpServletRequest().setAttribute("opeartype", "ADD");
			this.getHttpServletRequest().setAttribute("permissions",permissions);
		}
		else if("UPDATE".equals(this.getHttpServletRequest().getParameter("operate"))){
			GeRole role = roleService.get(geRole.getRoleid());
			Set<GePermission> permiss = role.getGePermissions();
			//获取自己拥有的权限
			List<GePermission> owerPermissions = new ArrayList<GePermission>();
			if(permiss!= null){
				owerPermissions.addAll(permiss);
			}
			//获取所有的权限
			List<GePermission> permissions = permissionService.findAllPermissionData();
			//移除自己的权限，就是未拥有的权限
			if(permissions != null && owerPermissions!= null){
				permissions.removeAll(owerPermissions);
			}
			
			this.getHttpServletRequest().setAttribute("owerPermissions",owerPermissions);
			this.getHttpServletRequest().setAttribute("permissions",permissions);
			this.getHttpServletRequest().setAttribute("role", role);
			this.getHttpServletRequest().setAttribute("opeartype", "UPDATE");
			
		}
		return "/page/main/role-operate";
	}
	
	/**
	 * 方法名称: existRole<br>
	 * 描述：查看角色是否存在
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:23:31
	 */
	@Action(value="existRole")
	public void existRole(){
		
		Map<String, String> result = new HashMap<String, String>();
		if("ADD".equals(getHttpServletRequest().getParameter("operate"))){
			boolean boo = roleService.existRoleName(geRole.getRolename());
			if(boo){ //存在
				result.put("error", "角色已经存在");
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
	 * 方法名称: addOrUpdateRole<br>
	 * 描述：添加或者修改角色
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:23:53
	 */
	@Action(value="addOrUpdateRole")
	public void addOrUpdateRole(){
		if("ADD".equals(getHttpServletRequest().getParameter("operate"))){
			if(gePermissions != null){
				geRole.setGePermissions(new HashSet<GePermission>(gePermissions));
			}
			geRole.setCreatetime(new Date());
			geRole.setOperatorname(SpringSecurityUtil.getCurrentUserName());
			roleService.addRole(geRole);
		}
		else if("UPDATE".equals(getHttpServletRequest().getParameter("operate"))){
		
			GeRole role = roleService.get(geRole.getRoleid());
			Set<GePermission> pers = new HashSet<GePermission>();
			if(gePermissions != null){
				pers.addAll(gePermissions);
			}
			role.setRoledesc(geRole.getRoledesc());
			role.setCreatetime(new Date());
			role.setOperatorname(SpringSecurityUtil.getCurrentUserName());
			roleService.updateRole(role,pers);
		}
		renderText("SUCCESS");
	}
	/**
	 * 方法名称: deleteRole<br>
	 * 描述：删除角色
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:24:07
	 */
	@Action(value="deleteRole")
	public void deleteRole(){
		if(roleids != null){
			roleService.deleteRole(roleids);
		}
		renderText("SUCCESS");
	}

	public GeRole getGeRole() {
		return geRole;
	}

	public void setGeRole(GeRole geRole) {
		this.geRole = geRole;
	}

	public List<GePermission> getGePermissions() {
		return gePermissions;
	}

	public void setGePermissions(List<GePermission> gePermissions) {
		this.gePermissions = gePermissions;
	}

	public String[] getRoleids() {
		return roleids;
	}

	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}



	
	
	
	

}

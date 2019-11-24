/**
 * File Name:ResourceAction.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月18日下午12:32:05
 */
package cn.com.sinosoft.web.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.fckeditor.response.GetResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GePermission;
import cn.com.sinosoft.domain.system.GeResources;
import cn.com.sinosoft.domain.system.GeResourcesIcon;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.domain.system.GeUsergroup;
import cn.com.sinosoft.dto.system.ECSUser;
import cn.com.sinosoft.dto.system.ResourcesTree;
import cn.com.sinosoft.dto.system.ResourcesTree.Attribute;
import cn.com.sinosoft.permission.service.PermissionService;
import cn.com.sinosoft.permission.service.ResourceIconService;
import cn.com.sinosoft.permission.service.ResourceService;
import cn.com.sinosoft.user.service.UserService;

/**描述：资源请求处理类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月18日下午12:32:05 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class ResourceAction  extends Struts2Action{
	private GeResources geResources;
	private GeResourcesIcon geResourcesIcon;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private ResourceIconService resourceIconService;
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private UserService userService;
	/**
	 * 方法名称: jumpResourceListPage<br>
	 * 描述：跳转到资源列表页面
	 * 作者: honghui
	 * 修改日期：2013年12月18日下午12:33:31
	 * @return 返回视图
	 */
	@Action(value="resourceManager")
	public String jumpResourceListPage(){
		List<GeResources> resources = resourceService.getGeResourcesAll();
		List<ResourcesTree> resourcesTrees = new ArrayList<ResourcesTree>();
		for(GeResources resource:resources){
			ResourcesTree tree = new ResourcesTree();
			tree.setId(resource.getResourcescode());
			tree.setParentId(resource.getResourcesparent());
			tree.setText(resource.getResourcesname());
			
			BeanUtils.copyProperties(resource, tree);
			
			
			GeResourcesIcon geResourcesIcon = resource.getGeResourcesIcon() ;
			if(geResourcesIcon != null){
				tree.setIconCls("icon-treeImg"+geResourcesIcon.getResourcesiconid());
				tree.setResourcesiconpath(getServletContext().getContextPath()+geResourcesIcon.getResourcesiconpath());
				tree.setResourcesiconid(geResourcesIcon.getResourcesiconid());
			}
			Attribute attribute = new Attribute();
			attribute.setUrl(getServletContext().getContextPath()+resource.getResourcescontent());
			tree.setAttributes(attribute);
			resourcesTrees.add(tree);
		}
		getHttpServletRequest().setAttribute("resourceTree", JSONArray.fromObject(resourcesTrees).toString());
		
		
		return  "/page/main/resource";
	}
	
	/**
	 * 方法名称: jumpaDDoRUpdateResourcePage<br>
	 * 描述：
	 * 作者: honghui
	 * 修改日期：2013年12月28日下午1:51:20
	 * @return
	 */
	@Action(value="jumpaDDoRUpdateResourcePage")
	public String jumpaDDoRUpdateResourcePage(){
		
		getHttpServletRequest().setAttribute("resourceIcons", resourceIconService.geResourcesIconsAll());
		return "page/main/resource-operate";
	}
	/**
	 * 方法名称: getResourceTree<br>
	 * 描述：获取资源树(主要是显示在添加/修改 权限 关联的资源树)
	 * 作者: liaojiping
	 * 修改日期：2013-12-25下午07:57:42
	 */
	@Action(value="getResourceTree")
	public void getResourceTree(){
		List<GeResources> resources = resourceService.getGeResourcesAll();
		List<ResourcesTree> resourcesTrees = new ArrayList<ResourcesTree>();
		if("UPDATE".equals(this.getHttpServletRequest().getParameter("operate"))){
			String permissionid = this.getHttpServletRequest().getParameter("permissionid");
			GePermission permission = permissionService.get(permissionid);
			Set<GeResources> geResources = permission.getGeResources();
			for(GeResources resource:resources){
				ResourcesTree tree = new ResourcesTree();
				tree.setId(resource.getResourcescode());
				tree.setParentId(resource.getResourcesparent());
				tree.setText(resource.getResourcesname());
				BeanUtils.copyProperties(resource, tree);
				if(isExistResource(geResources, resource.getResourcesid())){
					tree.setChecked(true);
				}
				else{
					tree.setChecked(false);
				}
				GeResourcesIcon geResourcesIcon = resource.getGeResourcesIcon() ;
				if(geResourcesIcon != null){
					tree.setResourcesiconpath(getServletContext().getContextPath()+geResourcesIcon.getResourcesiconpath());
					tree.setResourcesiconid(geResourcesIcon.getResourcesiconid());
				}
				Attribute attribute = new Attribute();
				attribute.setUrl(getServletContext().getContextPath()+resource.getResourcescontent());
				tree.setAttributes(attribute);
				resourcesTrees.add(tree);
			}
		}
		else{
			for(GeResources resource:resources){
				ResourcesTree tree = new ResourcesTree();
				tree.setId(resource.getResourcescode());
				tree.setParentId(resource.getResourcesparent());
				tree.setText(resource.getResourcesname());
				if(geResourcesIcon != null){
					tree.setIconCls("icon-treeImg"+geResourcesIcon.getResourcesiconid());
				}
				BeanUtils.copyProperties(resource, tree);
				
				
				GeResourcesIcon geResourcesIcon = resource.getGeResourcesIcon() ;
				if(geResourcesIcon != null){
					
					tree.setResourcesiconpath(getServletContext().getContextPath()+geResourcesIcon.getResourcesiconpath());
					tree.setResourcesiconid(geResourcesIcon.getResourcesiconid());
				}
				Attribute attribute = new Attribute();
				attribute.setUrl(getServletContext().getContextPath()+resource.getResourcescontent());
				tree.setAttributes(attribute);
				resourcesTrees.add(tree);
			}
		}
		
		renderJson(JSONArray.fromObject(resourcesTrees).toString());
	}
	
	/**
	 * 方法名称: isExistResource<br>
	 * 描述：查询修改权限所拥有的资源
	 * 作者: liaojiping
	 * 修改日期：2013-12-25下午08:28:16
	 * @param geResources
	 * @param resourceid
	 * @return
	 */
	
	private boolean isExistResource(Set<GeResources> geResources,String resourceid){
		Iterator<GeResources> iterator = geResources.iterator();
		while(iterator.hasNext()){
			if(resourceid.equals(iterator.next().getResourcesid())){
				return true;
			}
		}
		return false;
	}
	/**
	 * 方法名称: addResource<br>
	 * 描述：添加或者更新资源
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:21:58
	 */
	@Action(value="addUpdateResource")
	public void addResource(){
		if("ADD".equals(getHttpServletRequest().getParameter("opeartype"))){
			geResources.setGeResourcesIcon(geResourcesIcon);
			geResources.setResourcesid(geResources.getResourcescode());
			resourceService.addGeResources(geResources);
			renderText("ADD_SUCCESS"); 
		}
		else{
			geResources.setGeResourcesIcon(geResourcesIcon);
			geResources.setResourcesid(geResources.getResourcescode());
			resourceService.updateGeResources(geResources);
			renderText("UPDATE_SUCCESS"); 
		}
		
	}
	
	/**
	 * 方法名称: deleteResource<br>
	 * 描述：删除资源
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:22:13
	 */
	@Action(value="deleteResource")
	public void deleteResource(){
		resourceService.deleteGeResources(geResources.getResourcesid());
		renderText("DEL_SUCCESS"); 
	}
	
	/**
	 * 方法名称: existResource<br>
	 * 描述：查看资源是否存在
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:22:26
	 */
	@Action(value="existResource")
	public void existResource(){
		Map<String, String> result = new HashMap<String, String>();
		if("ADD".equals(getHttpServletRequest().getParameter("opeartype"))){
			boolean boo = resourceService.existResources(geResources.getResourcescode());
			if(boo){ //存在
				result.put("error", "资源已经存在");
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
	 * 方法名称: getRosourceNavTree<br>
	 * 描述：获取资源导航树
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午4:52:36
	 */
	@Action(value="resourceNavTree")
	public void getResourceNavTree(){
		ECSUser user = SpringSecurityUtil.getCurrentUser();
		//获取根菜单
		GeResources firstResource = resourceService.getResource(this.getHttpServletRequest().getParameter("resourcesid"));
		if("admin".equals(user.getGeUser().getUsertype())){ //如果是超级管理员，直接查询所有的菜单资源
			
			if(firstResource != null){
				List<GeResources> allResources = resourceService.getGeResourcesAll(); //获取所有的资源
				List<GeResources> childResources = getChildResourceByParenResource(firstResource,allResources);
				List<ResourcesTree> resourcesTrees = new ArrayList<ResourcesTree>();
				for(GeResources resource:childResources){
					ResourcesTree tree = new ResourcesTree();
					GeResourcesIcon icon = resource.getGeResourcesIcon();
					if(icon != null){
						tree.setIconCls("icon-treeImg"+icon.getResourcesiconid());
					}
					tree.setId(resource.getResourcescode());
					tree.setParentId(resource.getResourcesparent());
					tree.setText(resource.getResourcesname());
					Attribute attribute = new Attribute();
					attribute.setUrl(getServletContext().getContextPath()+resource.getResourcescontent());
					tree.setAttributes(attribute);
					resourcesTrees.add(tree);
				}
				renderJson(JSONArray.fromObject(resourcesTrees).toString());
			}
			else{
				renderJson("{}");
			}
			
		}
		else{
			GeUser geUser = userService.getGeUserById(user.getGeUser().getUserid());
			//获取用户拥有的角色
			Set<GeRole> geRoles = geUser.getGeRoles();
			Set<GeResources> userResources = new HashSet<GeResources>(); //获取用户拥有的资源
			for(GeRole role:geRoles){ //用户-角色-权限-资源
				Set<GePermission> gePermissions = role.getGePermissions();
				for(GePermission permission:gePermissions){
					Set<GeResources> permissionResource  = permission.getGeResources();
					userResources.addAll(permissionResource);
				}
			}
			//获取用户拥有组
			Set<GeUsergroup> geUsergroups = geUser.getGeUsergroups();
			for(GeUsergroup userGourp:geUsergroups){//用户-用户组-角色-权限-资源
				Set<GeRole> userRoles = userGourp.getGeRoles();
				for(GeRole role:userRoles){ 
					Set<GePermission> gePermissions = role.getGePermissions();
					for(GePermission permission:gePermissions){
						Set<GeResources> permissionResource = permission.getGeResources();
						userResources.addAll(permissionResource);
					}
				}
			}
			userResources = getUniqueResources(userResources); //用户拥有的角色
			List<GeResources> allResources = new ArrayList<GeResources>(userResources);
			List<GeResources> childResources = getChildResourceByParenResource(firstResource,allResources);
			
			/**以下是构造资源树所需要的json*/
			List<ResourcesTree> resourcesTrees = new ArrayList<ResourcesTree>();
			for(GeResources resource:childResources){
				ResourcesTree tree = new ResourcesTree();
				GeResourcesIcon icon = resource.getGeResourcesIcon();
				if(icon != null){
					tree.setIconCls("icon-treeImg"+icon.getResourcesiconid());
				}
				
				tree.setId(resource.getResourcescode());
				tree.setParentId(resource.getResourcesparent());
				tree.setText(resource.getResourcesname());
				Attribute attribute = new Attribute();
				attribute.setUrl(getServletContext().getContextPath()+resource.getResourcescontent());
				tree.setAttributes(attribute);
				resourcesTrees.add(tree);
			}
			renderJson(JSONArray.fromObject(resourcesTrees).toString());
		}
		
	}
	
	
	/**
	 * 方法名称: getChildResourceByParenResource<br>
	 * 描述：获取父资源下面的所有子资源
	 * 作者: honghui
	 * 修改日期：2013年12月29日下午5:07:56
	 * @param parentResources
	 * @return
	 */
	public List<GeResources> getChildResourceByParenResource(GeResources parentResources,List<GeResources> allResources){
		List<GeResources> childResources = new ArrayList<GeResources>();
		for(GeResources resource:allResources){
			if(resource.getResourcesid().startsWith(parentResources.getResourcesid()+"_") && "M".equals(resource.getResourcestype())){
				childResources.add(resource);
			}
		}
		return childResources;
	}
	
	

	
	/**
	 * 方法名称: getUniqueResources<br>
	 * 描述：返回唯一的资源列表
	 * 作者: honghui
	 * 修改日期：2013年12月26日下午5:26:10
	 * @param resources
	 * @return
	 */
	private Set<GeResources> getUniqueResources(Set<GeResources> resources){
		Iterator<GeResources> it = resources.iterator();
		Map<String, GeResources> map = new HashMap<String, GeResources>();//主要是去除重复资源
		while(it.hasNext()){
			GeResources res = it.next();
			if(!map.containsKey(res.getResourcesid()) && "M".equals(res.getResourcestype())){
				map.put(res.getResourcesid(), res);
			}
		}
		Collection<GeResources> uniqueResources =  map.values();
		return new HashSet<GeResources>(uniqueResources);
	}
	

	public GeResources getGeResources() {
		return geResources;
	}

	public void setGeResources(GeResources geResources) {
		this.geResources = geResources;
	}

	public GeResourcesIcon getGeResourcesIcon() {
		return geResourcesIcon;
	}

	public void setGeResourcesIcon(GeResourcesIcon geResourcesIcon) {
		this.geResourcesIcon = geResourcesIcon;
	}


	
	
	
	
	
	
	
}

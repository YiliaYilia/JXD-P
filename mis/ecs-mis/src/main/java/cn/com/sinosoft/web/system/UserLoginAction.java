/**
 * File Name:UserLoginAction.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月17日上午11:26:35
 */
package cn.com.sinosoft.web.system;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.convention.annotation.Action;
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
import cn.com.sinosoft.permission.service.ResourceService;
import cn.com.sinosoft.user.service.UserService;

/**描述：处理用户登陆请求<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月17日上午11:26:35 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class UserLoginAction extends Struts2Action{
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private UserService userService;
	
	@Action(value="userLogin")
	public String doUserLogin(){
		ECSUser user = SpringSecurityUtil.getCurrentUser();
		HttpSession session = getHttpSession();
		session.setAttribute("user", user);
		List<GeResources> geResources =null;
		
		GeResources firstResource = null; //选择默认的根节点
		if("admin".equals(user.getGeUser().getUsertype())){ //如果是超级管理员，直接查询所有的菜单资源
			//获取根菜单
			geResources = resourceService.getGeResourcesRoot(); //获取根节点
			//展示菜单项
			if(geResources != null && geResources.size()>0){
				firstResource = geResources.get(0); 
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
				getHttpServletRequest().setAttribute("childResources", JSONArray.fromObject(resourcesTrees).toString());
			}
			else{
				getHttpServletRequest().setAttribute("childResources", "{}");
			}
		}
		else{ //普通管理员
			//展示菜单项
			GeUser geUser = userService.getGeUserById(SpringSecurityUtil.<ECSUser>getCurrentUser().getGeUser().getUserid());
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
			
			geResources =getRootResources(allResources); //默认根节点
			//展示菜单项
			if(geResources != null && geResources.size()>0){
				firstResource = geResources.get(0);
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
				getHttpServletRequest().setAttribute("childResources", JSONArray.fromObject(resourcesTrees).toString());
			}
			else{
				getHttpServletRequest().setAttribute("childResources", "{}");
			}
			
		}
		String serverName = this.getHttpServletRequest().getServerName();
		this.setRequestAttribute("serverName", serverName);
		String serverInfo = this.getServletContext().getServerInfo();
		this.setRequestAttribute("serverInfo", serverInfo);
		getHttpServletRequest().setAttribute("rootResources", geResources);
		
		String deployPath = this.getServletContext().getRealPath("/");
		this.setRequestAttribute("deployPath", deployPath);
		
		
		DecimalFormat df = new DecimalFormat("0.00") ;
		
		long totalMem = Runtime.getRuntime().totalMemory();
		String total = df.format(totalMem/1000000)+"M";
		
		
		long freeMem = Runtime.getRuntime().freeMemory();
		String free = df.format(freeMem/1000000)+"M";
		
		this.setRequestAttribute("total", total);
		this.setRequestAttribute("free", free);
		
		//OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		
		//String osName = osmb.getName()+" 版本 "+osmb.getVersion(); //操作系统
		String osName = System.getProperty("os.name");  
		
		String vmVersion = System.getProperty("java.version");  
		 this.setRequestAttribute("vmVersion", vmVersion);
		//int Processors =  osmb.getAvailableProcessors();
		//this.setRequestAttribute("Processors", Processors);
		
		 //String PhysicalMemory =  osmb.getTotalPhysicalMemorySize()/(1024*1024)+"M";
		// this.setRequestAttribute("PhysicalMemory", PhysicalMemory);
		 
		// String freePhysicalMemorySize = osmb.getFreePhysicalMemorySize() /(1024*1024)+"M"; 
		 
		 
		 //this.setRequestAttribute("freePhysicalMemorySize", freePhysicalMemorySize);
		this.setRequestAttribute("osName", osName);
		return "/page/main/index";
	}
	
	/**
	 * 方法名称: removeRootResource<br>
	 * 描述：移除根节点
	 * 作者: honghui
	 * 修改日期：2013年12月29日下午4:32:11
	 * @param geResources
	 * @param rootResources
	 */
	public void removeRootResource(List<GeResources> geResources,GeResources rootResources){
		for(int i=0;i<geResources.size();i++){
			GeResources resource = geResources.get(i);
			if(rootResources.getResourcesid().equals(resource.getResourcesid())){
				geResources.remove(i);
			}
		}
	}
	
	/**
	 * 方法名称: getRootResources<br>
	 * 描述：获取默认根节点
	 * 作者: honghui
	 * 修改日期：2013年12月29日下午4:56:07
	 * @param resources
	 * @return
	 */
	public List<GeResources> getRootResources(List<GeResources> resources){
		List<GeResources> rootGeResources = new ArrayList<GeResources>();
		for(GeResources resource:resources){
			if("M".equalsIgnoreCase(resource.getResourcestype()) && "0".equalsIgnoreCase(resource.getResourcesparent())){
				rootGeResources.add(resource);
			}
		}
		return rootGeResources;
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
	
	
}

/**
 * File Name:ECSUserDetailsServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午8:55:35
 */
package cn.com.sinosoft.permission.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.com.sinosoft.domain.system.GePermission;
import cn.com.sinosoft.domain.system.GeResources;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.domain.system.GeUsergroup;
import cn.com.sinosoft.dto.system.ECSUser;
import cn.com.sinosoft.permission.service.ResourceService;
import cn.com.sinosoft.user.service.UserService;

/**描述：用户详细信息<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午8:55:35 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class ECSUserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceService resourceService;
	/**方法名称：loadUserByUsername <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午8:56:13 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String) 
	 * @param userName 
	 * @return
	 * @throws UsernameNotFoundException
	 * @throws DataAccessException
	 */
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		GeUser geUser = userService.getGeUserByName(userName);
		if(geUser == null){
			throw new UsernameNotFoundException("用户不存在");
		}
		Set<GrantedAuthority>  authorities = getCurrentAuthoritys(geUser);
		//-- mini-web示例中无以下属性, 暂时全部设为true. --//
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		ECSUser securityUser = new ECSUser(geUser,userName, geUser.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		return securityUser;
	}
	
	/**
	 * 方法名称: getCurrentAuthoritys<br>
	 * 描述：用户拥有的权限
	 * 作者: honghui
	 * 修改日期：2013年12月17日上午11:08:30
	 * @param geUser
	 * @return
	 */
	private Set<GrantedAuthority> getCurrentAuthoritys(GeUser geUser){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		List<GeResources> geResourcesAll = resourceService.getGeResourcesAll();
		if("admin".equals(geUser.getUsertype())){//超级管理员
			
			for(GeResources resource:geResourcesAll){
				GrantedAuthority grantedAuthority =  new GrantedAuthorityImpl(resource.getResourcescode());
				authorities.add(grantedAuthority);
			}
		}
		else{
			//获取用户拥有的角色
			Set<GeRole> geRoles = geUser.getGeRoles();
			Set<GeResources> userResources = new HashSet<GeResources>();
			for(GeRole role:geRoles){ //用户-角色-权限-资源
				Set<GePermission> gePermissions = role.getGePermissions();
				for(GePermission permission:gePermissions){
					Set<GeResources> geResources = permission.getGeResources();
					userResources.addAll(geResources);
				}
			}
			//获取用户拥有组
			Set<GeUsergroup> geUsergroups = geUser.getGeUsergroups();
			for(GeUsergroup userGourp:geUsergroups){//用户-用户组-角色-权限-资源
				Set<GeRole> userRoles = userGourp.getGeRoles();
				for(GeRole role:userRoles){ 
					Set<GePermission> gePermissions = role.getGePermissions();
					for(GePermission permission:gePermissions){
						Set<GeResources> geResources = permission.getGeResources();
						userResources.addAll(geResources);
					}
				}
			}
			userResources = getUniqueResources(userResources); //用户拥有的角色
			for(GeResources resource:userResources){
				GrantedAuthority grantedAuthority =  new GrantedAuthorityImpl(resource.getResourcescode());
				authorities.add(grantedAuthority);
			}
			
		}
		return authorities;
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
			if(!map.containsKey(res.getResourcesid())){
				map.put(res.getResourcesid(), res);
			}
		}
		Collection<GeResources> uniqueResources =  map.values();
		return new HashSet<GeResources>(uniqueResources);
	}
	
	
}

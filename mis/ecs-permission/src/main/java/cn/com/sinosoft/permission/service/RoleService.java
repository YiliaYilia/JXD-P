/**
 * File Name:RoleService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月22日下午5:22:40
 */
package cn.com.sinosoft.permission.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GePermission;
import cn.com.sinosoft.domain.system.GeRole;

/**描述：角色业务处理<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月22日下午5:22:40 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface RoleService {
	/**
	 * 方法名称: getRolesByName<br>
	 * 描述：通过名称获取角色
	 * 作者: honghui
	 * 修改日期：2013年12月22日下午5:24:22
	 * @param roleName
	 * @return
	 */
	public Page<GeRole> getRolesByName(String roleName,int pageNumber,int pageSize);
	
	/**
	 * 方法名称: existRoleName<br>
	 * 描述：查看角色名称是否存在
	 * 作者: honghui
	 * 修改日期：2013年12月23日下午7:06:40
	 * @param roleName
	 * @return
	 */
	public boolean existRoleName(String roleName);
	
	/**
	 * 方法名称: addRole<br>
	 * 描述：添加角色
	 * 作者: honghui
	 * 修改日期：2013年12月23日下午9:51:57
	 * @param geRole
	 */
	public void addRole(GeRole geRole);
	
	/***
	 * 方法名称: get<br>
	 * 描述： 通过主键获取实体
	 * 作者: honghui
	 * 修改日期：2013年12月24日上午10:13:35
	 * @param pk
	 * @return
	 */
	public GeRole get(String pk);
	
	/**
	 * 方法名称: deleteRoleHavePermission<br>
	 * 描述：删除用户拥有的角色
	 * 作者: honghui
	 * 修改日期：2013年12月24日上午10:41:09
	 * @param pk
	 */
	public void deleteRoleHavePermission(String pk);
	
	/**
	 * 方法名称: updateRole<br>
	 * 描述：修改角色
	 * 作者: honghui
	 * 修改日期：2013年12月24日上午10:48:07
	 * @param role
	 */
	public void updateRole(GeRole role,Set<GePermission> permissions);
	
	/**
	 * 方法名称: deleteRole<br>
	 * 描述：删除角色
	 * 作者: honghui
	 * 修改日期：2013年12月24日上午10:51:36
	 * @param ids
	 */
	public void deleteRole(String... ids);

	/**
	 * 方法名称：findAllRole<br>
	 * 描述：获得所有角色<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午2:59:23<br>
	 * @return
	 */
	public List<GeRole> findAllRole();
}

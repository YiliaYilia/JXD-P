/**
 * File Name:RoleServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月22日下午5:24:46
 */
package cn.com.sinosoft.permission.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GePermission;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.permission.service.RoleService;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月22日下午5:24:46 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Component
public class RoleServiceImpl extends GenericHibernateDao<GeRole, String> implements RoleService {

	/**方法名称：getRolesByName <br>
	 * 描述：通过名称获取角色 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月22日下午5:24:46 
	 * @see cn.com.sinosoft.permission.service.RoleService#getRolesByName(java.lang.String) 
	 * @param roleName
	 * @return
	 */
	public Page<GeRole> getRolesByName(String roleName,int pageNumber,int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addLike("rolename", "%"+roleName+"%");
		queryRule.addDescOrder("createtime");
		return this.find(entityClass, queryRule, pageNumber, pageSize);
	}

	/**方法名称：roleNameExist <br>
	 * 描述：查看角色名称是否存在 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月23日下午7:07:23 
	 * @see cn.com.sinosoft.permission.service.RoleService#roleNameExist(java.lang.String) 
	 * @param roleName
	 * @return
	 */
	public boolean existRoleName(String roleName) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("rolename", roleName);
		return this.exists(queryRule);
	}

	/**方法名称：addRole <br>
	 * 描述：添加角色 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月23日下午9:52:30 
	 * @see cn.com.sinosoft.permission.service.RoleService#addRole(cn.com.sinosoft.domain.system.GeRole) 
	 * @param geRole
	 */
	@ECSOperator(operator="添加角色")
	public void addRole(GeRole geRole) {
		this.save(geRole);
	}

	/**方法名称：get <br>
	 * 描述： 通过主键获取实体<br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月24日上午10:13:54 
	 * @see cn.com.sinosoft.permission.service.RoleService#get(java.io.Serializable) 
	 * @param pk
	 * @return
	 */
	public GeRole get(String pk) {
		return super.get(pk);
	}

	/**方法名称：deleteRoleHavePermission <br>
	 * 描述：删除角色拥有的权限 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月24日上午10:41:28 
	 * @see cn.com.sinosoft.permission.service.RoleService#deleteRoleHavePermission(java.lang.String) 
	 * @param pk
	 */
	public void deleteRoleHavePermission(String pk) {
		GeRole role = get(pk);
		
		Set<GePermission> permissions = role.getGePermissions();
		List<GePermission> owerPermissions = new ArrayList<GePermission>();
		if(permissions != null){
			owerPermissions.addAll(permissions);
		}
		for(GePermission permission:owerPermissions){
			permission.getGeRoles().remove(role);
			role.getGePermissions().remove(permission);
		}
	}

	/**方法名称：updateRole <br>
	 * 描述：修改角色 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月24日上午10:48:34 
	 * @see cn.com.sinosoft.permission.service.RoleService#updateRole(cn.com.sinosoft.domain.system.GeRole) 
	 * @param role
	 */
	@ECSOperator(operator="修改角色")
	public void updateRole(GeRole role,Set<GePermission> permissions) {
		deleteRoleHavePermission(role.getRoleid());
		role.setGePermissions(permissions);
		super.update(role);
	}

	/**方法名称：deleteRole <br>
	 * 描述： 删除角色<br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月24日上午10:51:49 
	 * @see cn.com.sinosoft.permission.service.RoleService#deleteRole(java.lang.String[]) 
	 * @param ids
	 */
	@ECSOperator(operator="删除角色")
	public void deleteRole(String... ids) {
		for(String id:ids){
			GeRole role = get(id);
			Set<GePermission> permissions = role.getGePermissions();
			List<GePermission> owerPermissions = new ArrayList<GePermission>();
			if(permissions != null){
				owerPermissions.addAll(permissions);
			}
			for(GePermission permission:owerPermissions){
				permission.getGeRoles().remove(role);
				role.getGePermissions().remove(permission);
			}
			delete(role);
		}
	}

	/**
	 * 方法名称：findAllRole<br>
	 * 描述：获得所有角色<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午3:01:52<br>
	 * @see cn.com.sinosoft.permission.service.RoleService#findAllRole()
	 * @return
	 */
	public List<GeRole> findAllRole() {
		return super.getAll(entityClass, false);
	}
}

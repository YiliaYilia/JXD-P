/**
 * File Name:GEUserServiceImpl.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午11:29:16
 */
package cn.com.sinosoft.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.domain.system.GeUsergroup;
import cn.com.sinosoft.user.service.UserService;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午11:29:16 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Component
public class UserServiceImpl extends GenericHibernateDao<GeUser, String> implements UserService {

	/**方法名称：getGeUserByName <br>
	 * 描述： 通过用户名查询实体<br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午11:29:16 
	 * @see cn.com.sinosoft.user.service.impl.UserService#getGeUserByName(java.lang.String) 
	 * @param userName
	 * @return
	 */
	public GeUser getGeUserByName(String userName) {
		return this.findUnique("username", userName);
	}
	
	/**
	 * 方法名称：getGeUserByName<br>
	 * 描述：根据用户名分页查询用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午4:06:02<br>
	 * @see cn.com.sinosoft.user.service.UserService#getGeUserByName(java.lang.String, int, int)
	 * @param userName
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<GeUser> getGeUserByName(String userName,int pageNumber,int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addLike("username", "%"+userName+"%");
		queryRule.addDescOrder("createtime");
		return this.find(entityClass,queryRule, pageNumber, pageSize);
	}
	
	/**
	 * 方法名称：getGeUserById<br>
	 * 描述：根据id查询用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午3:08:35<br>
	 * @see cn.com.sinosoft.user.service.UserService#getGeUserById(java.lang.String)
	 * @param id
	 * @return
	 */
	public GeUser getGeUserById(String id) {
		return super.get(id);
	}

	/**
	 * 方法名称：findAllGeUser<br>
	 * 描述：查询得到所有用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月19日下午7:18:06<br>
	 * @see cn.com.sinosoft.user.service.UserService#findAllGeUser()
	 * @return
	 */
	public List<GeUser> findAllGeUser() {
		return this.getAll(entityClass, false);
	}

	/**
	 * 方法名称：addGeUser<br>
	 * 描述：新建用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月23日下午5:19:36<br>
	 * @see cn.com.sinosoft.user.service.UserService#newGeUser(cn.com.sinosoft.domain.system.GeUser)
	 * @param geUser
	 */
	@ECSOperator(operator="添加用户")
	public void addGeUser(GeUser geUser) {
		super.save(geUser);
	}

	/**
	 * 方法名称：updateGeUser<br>
	 * 描述：更新用户信息<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月23日下午5:19:49<br>
	 * @see cn.com.sinosoft.user.service.UserService#updateGeUser(cn.com.sinosoft.domain.system.GeUser)
	 * @param geUser
	 */
	@ECSOperator(operator="修改用户")
	public void updateGeUser(GeUser geUser,Set<GeRole> roles,Set<GeUsergroup> usergroups,Set<GeDepartment> departments) {
		deleteRoleAndGroupByUser(geUser.getUserid());
		geUser.setGeRoles(roles);
		geUser.setGeUsergroups(usergroups);
		geUser.setGeDepartments(departments);
		super.update(geUser);
	}

	/**
	 * 方法名称：deleteGeUser<br>
	 * 描述：删除用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月23日下午5:19:58<br>
	 * @see cn.com.sinosoft.user.service.UserService#deleteGeUser(cn.com.sinosoft.domain.system.GeUser)
	 * @param geUser
	 */
	@ECSOperator(operator="删除用户")
	public void deleteGeUser(String id) {
		super.delete(super.get(id));
	}
	
	/**
	 * 方法名称：deleteRoleAndGroupByUser<br>
	 * 描述：删除用户拥有的角色和所属用户组以及机构<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月25日下午4:08:30<br>
	 * @see cn.com.sinosoft.user.service.UserService#deleteRoleAndGroupByUser(java.lang.String)
	 * @param pk
	 */
	@ECSOperator(operator="删除用户拥有的角色和所属用户组以及机构")
	public void deleteRoleAndGroupByUser(String pk) {
		GeUser user = get(pk);
		Set<GeRole> roles = user.getGeRoles();
		Set<GeUsergroup> usergroups = user.getGeUsergroups();
		Set<GeDepartment> departments = user.getGeDepartments();
		List<GeRole> geRoles = new ArrayList<GeRole>(roles);
		for (GeRole geRole : geRoles) {
			geRole.getGeUsers().remove(user);
			user.getGeRoles().remove(geRole);
		}
		List<GeUsergroup> geUsergroups = new ArrayList<GeUsergroup>(usergroups);
		for (GeUsergroup geUsergroup : geUsergroups) {
			geUsergroup.getGeUsers().remove(user);
			user.getGeUsergroups().remove(geUsergroup);
		}
		List<GeDepartment> geDepartments = new ArrayList<GeDepartment>(departments);
		for (GeDepartment geDepartment : geDepartments) {
			geDepartment.getGeUsers().remove(user);
			user.getGeDepartments().remove(geDepartment);
		}
	}
}

/**
 * File Name:GEUserService.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午11:26:22
 */
package cn.com.sinosoft.user.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.domain.system.GeUsergroup;

/**描述：后台用户业务处理类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午11:26:22 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface UserService {
	/**
	 * 方法名称: getGeUserByName<br>
	 * 描述：通过用户名查询用户
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午11:28:53
	 * @param userName
	 * @return
	 */
	public GeUser getGeUserByName(String userName);
	
	/**
	 * 方法名称：getGeUserByName<br>
	 * 描述：根据用户名分页查询用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午4:05:32<br>
	 * @param userName
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<GeUser> getGeUserByName(String userName,int pageNumber,int pageSize);

	/**
	 * 方法名称：getGeUserById<br>
	 * 描述：根据id查询用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午3:07:57<br>
	 * @param id
	 * @return
	 */
	public GeUser getGeUserById(String id);

	/**
	 * 方法名称：findAllGeUser<br>
	 * 描述：查询得到所有用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月19日下午7:13:13<br>
	 * @return
	 */
	public List<GeUser> findAllGeUser();
	
	/**
	 * 方法名称：newGeUser<br>
	 * 描述：新增用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月23日下午5:17:57<br>
	 * @param geUser
	 */
	public void addGeUser(GeUser geUser);
	
	/**
	 * 方法名称：updateGeUser<br>
	 * 描述：更新用户信息<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月23日下午5:18:10<br>
	 * @param geUser
	 */
	public void updateGeUser(GeUser geUser,Set<GeRole> roles,Set<GeUsergroup> usergroups,Set<GeDepartment> departments);
	
	/**
	 * 方法名称：deleteGeUser<br>
	 * 描述：删除用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月23日下午5:18:25<br>
	 * @param geUser
	 */
	public void deleteGeUser(String id);
	
	/**
	 * 方法名称：deleteRoleAndGroupByUser<br>
	 * 描述：删除用户拥有的角色和所属用户组<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月25日下午4:06:48<br>
	 * @param pk 用户ID
	 */
	public void deleteRoleAndGroupByUser(String pk);
}

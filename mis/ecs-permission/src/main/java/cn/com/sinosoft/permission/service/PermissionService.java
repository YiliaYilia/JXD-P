package cn.com.sinosoft.permission.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GePermission;
import cn.com.sinosoft.domain.system.GeResources;

/**
 * 描述：权限管理业务处理接口<br>
 * 作者：liaojiping <br>
 * 修改日期：2013-12-19下午07:47:59 <br>
 * E-mail: <br>
 */
public interface PermissionService {
	/**
	 * 方法名称:findAllPermissionData<br>
	 * 描述：查找所有权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-20下午07:25:38
	 * @return
	 */
	public Page findAllPermissionData(Map<String,Integer> page);
	/**
	 * 方法名称: findAllPermissionData<br>
	 * 描述：查找所有权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-25下午08:41:03
	 * @return
	 */
	public List<GePermission> findAllPermissionData();
	/**
	 * 方法名称: saveOrUpdatePermissionData<br>
	 * 描述：保存或更新权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-19下午07:26:48
	 * @param 
	 */
	public void saveOrUpdatePermissionData(GePermission gePermissionData,String type);

	/**
	 * 方法名称: deletePermissionDatas<br>
	 * 描述：通过id批量删除权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-19下午08:38:21
	 * @param 
	 */
	public void deletePermissionDatas(List<String> ids);

	/**
	 * 方法名称: findPermissionDataByID<br>
	 * 描述：通过ID查找权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-20上午10:11:10
	 * @param 
	 * @return
	 */
	public Page findPermissionDataByID(String ID,Map<String,Integer> page);
	/**
	 * 方法名称：deletePermission <br>
	 * 描述： <br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:45:07 
	 * @see cn.com.sinosoft.permission.service.PermissionService#deletePermission(java.lang.String[]) 
	 * @param ids
	 */
	public void deletePermission(List<String> ids);
	
	/**
	 * 方法名称：permissionNameExist <br>
	 * 描述： 查看权限名称是否存在<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:43:25 
	 * @see cn.com.sinosoft.permission.service.PermissionService#existPermissionName(java.lang.String) 
	 * @param permissionName
	 * @return
	 */
	public boolean existPermissionName(String permissionName);
	/**
	 * 方法名称：updatePermission <br>
	 * 描述： 更新权限<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:43:05 
	 * @see cn.com.sinosoft.permission.service.PermissionService#updatePermission(cn.com.sinosoft.domain.system.GePermission) 
	 * @param permission
	 */
	public void updatePermission(GePermission permission,Set<GeResources> res);
	/**
	 * 方法名称：get <br>
	 * 描述： 通过ID查找权限<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:42:37 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#get(java.io.Serializable) 
	 * @param pk
	 * @return
	 */
	public GePermission get(String pk);
	/**
	 * 方法名称：deletePermissionHaveResource <br>
	 * 描述： <br>
	 * 作者：user <br>
	 * 修改日期：2013-12-25下午07:44:10 
	 * @see cn.com.sinosoft.permission.service.PermissionService#deletePermissionHaveResource(java.lang.String) 
	 * @param pk
	 */
	public void deletePermissionHaveResource(String pk);
	/**
	 * 方法名称: addPermission<br>
	 * 描述：增加权限对象
	 * 作者: liaojiping
	 * 修改日期：2013-12-25下午08:32:54
	 * @param gePermission
	 */
	public void addPermission(GePermission gePermission);
	/**
	 * 方法名称: findPermissionDataByID<br>
	 * 描述：通过ID查找权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-25下午08:33:12
	 * @param id
	 * @return
	 */
	public GePermission findPermissionDataByID(String id);
	/**
	 * 方法名称: findPermissionDataByName<br>
	 * 描述：
	 * 作者: liaojiping
	 * 修改日期：2013-12-25下午08:33:46
	 * @param name
	 * @param page
	 * @return
	 */
	public Page findPermissionDataByName(String name,Map<String,Integer> page);
}

package cn.com.sinosoft.permission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import cn.com.sinosoft.permission.service.PermissionService;
import cn.com.sinosoft.domain.system.GePermission;
import cn.com.sinosoft.domain.system.GeResources;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;

/**
 * 描述：权限管理业务处理实现类<br>
 * 作者：liaojiping <br>
 * 修改日期：2013-12-19下午07:50:10 <br>
 * E-mail: <br>
 */
@Component
public class PermissionServiceImpl extends GenericHibernateDao<GePermission, String> implements PermissionService{
	
	/**
	 * 方法名称: findAllPermissionData<br>
	 * 描述：查找所有权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-25下午08:41:03
	 * @return
	 */
	public List<GePermission> findAllPermissionData(){
		return this.getAll(entityClass, false);
	}
	/**
	 * 方法名称：findAllPermissionData<br>
	 * 描述：查找所有权限数据  <br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-19上午11:26:35 
	 * @see cn.com.sinosoft.PermissionService.service.PermissionDataService#findAllPermissionData() 
	 * @return
	 */
	public Page findAllPermissionData(Map<String,Integer> page) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addIsNotNull("permissionid");
		queryRule.addDescOrder("permissioncreatetime");
		return this.find(queryRule, page.get("page"), page.get("rows"));
	}
	/**
	 * 方法名称: saveOrUpdatePermissionData<br>
	 * 描述：保存或更新权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-19下午07:26:48
	 * @param 
	 */
	
	@ECSOperator(operator="保存或更新权限")
	public void saveOrUpdatePermissionData(GePermission gePermissionData,String type) {
		// TODO Auto-generated method stub
		if("update".equals(type)){
			super.update(gePermissionData);
		}else {
			super.save(gePermissionData);
		}
	}
	/**
	 * 方法名称: deletePermissionDatas<br>
	 * 描述：通过id批量删除权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-19下午08:38:21
	 * @param 
	 */
	
	@ECSOperator(operator="删除权限")
	public void deletePermissionDatas(List<String> ids) {
		// TODO Auto-generated method stub
		List<GePermission> permissionDatas = new ArrayList<GePermission>();
		for(String id:ids){
			permissionDatas.add(super.get(id));
		}
		super.deleteAll(permissionDatas);
	}
	/**
	 * 方法名称: findPermissionDataByID<br>
	 * 描述：通过ID查找权限
	 * 作者: liaojiping
	 * 修改日期：2013-12-20上午10:11:10
	 * @param 
	 * @return
	 */
	public GePermission findPermissionDataByID(String id){
		return super.get(id);
	}
	
	/**
	 * 方法名称：findPermissionDataByID <br>
	 * 描述： 通过ID查找权限<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:40:50 
	 * @see cn.com.sinosoft.permission.service.PermissionService#findPermissionDataByID(java.lang.String, java.util.Map) 
	 * @param ID
	 * @param page
	 * @return
	 */
	public Page findPermissionDataByID(String ID,Map<String,Integer> page){
	    QueryRule queryRule = QueryRule.getInstance();
	    queryRule.addEqual("gePermission.permissionid", ID);
	    return super.find(queryRule,page.get("page"),page.get("rows"));

	}
	
	/**
	 * 方法名称：findPermissionDataByName <br>
	 * 描述：通过权限名查找 <br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:41:33 
	 * @see cn.com.sinosoft.permission.service.PermissionService#findPermissionDataByName(java.lang.String, java.util.Map) 
	 * @param name
	 * @param page
	 * @return
	 */
	public Page findPermissionDataByName(String name, Map<String, Integer> page) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addLike("permissionname", "%"+name+"%");
		return super.find(queryRule,page.get("page"),page.get("rows")); 
	}
    
	/**
	 * 方法名称：addPermission <br>
	 * 描述： <br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:42:16 
	 * @see cn.com.sinosoft.permission.service.PermissionService#addPermission(cn.com.sinosoft.domain.system.GePermission) 
	 * @param gePermission
	 */
	
	@ECSOperator(operator="添加权限")
	public void addPermission(GePermission gePermission){
		this.save(gePermission);
	}
	
	/**
	 * 方法名称：get <br>
	 * 描述： 通过ID查找权限<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:42:37 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#get(java.io.Serializable) 
	 * @param pk
	 * @return
	 */
	public GePermission get(String pk) {
		return super.get(pk);
	}
	
	/**
	 * 方法名称：updatePermission <br>
	 * 描述： 更新权限<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:43:05 
	 * @see cn.com.sinosoft.permission.service.PermissionService#updatePermission(cn.com.sinosoft.domain.system.GePermission) 
	 * @param permission
	 */
	
	@ECSOperator(operator="更新权限")
	public void updatePermission(GePermission permission,Set<GeResources> res){
	//	PermissionDataService.deletePermissionHaveResource(permission.getPermissionid());
		deletePermissionHaveResource(permission.getPermissionid());
		permission.setGeResources(res);
		super.update(permission);
	}
	
	/**
	 * 方法名称：permissionNameExist <br>
	 * 描述： 查看权限名称是否存在<br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:43:25 
	 * @see cn.com.sinosoft.permission.service.PermissionService#permissionNameExist(java.lang.String) 
	 * @param permissionName
	 * @return
	 */
	public boolean existPermissionName(String permissionName){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("permissionname", permissionName);
		return this.exists(queryRule);
	}
	
	/**
	 * 方法名称：deletePermissionHaveResource <br>
	 * 描述： <br>
	 * 作者：user <br>
	 * 修改日期：2013-12-25下午07:44:10 
	 * @see cn.com.sinosoft.permission.service.PermissionService#deletePermissionHaveResource(java.lang.String) 
	 * @param pk
	 */
	public void deletePermissionHaveResource(String pk){
		GePermission permission = get(pk);
		System.out.println("deletePermissionHaveResource=========="+permission);
		List<GeResources> owerResources = new ArrayList<GeResources>(permission.getGeResources());
		for(GeResources resource:owerResources){
			resource.getGePermissions().remove(permission);
			permission.getGeResources().remove(resource);
		}
	}
	
	/**
	 * 方法名称：deletePermission <br>
	 * 描述： <br>
	 * 作者：liaojiping <br>
	 * 修改日期：2013-12-25下午07:45:07 
	 * @see cn.com.sinosoft.permission.service.PermissionService#deletePermission(java.lang.String[]) 
	 * @param ids
	 */
	@ECSOperator(operator="删除权限")
	public void deletePermission(List<String> ids){
		for(String id:ids){
			GePermission permission = get(id);
			Set<GeResources> resources = permission.getGeResources();
			List<GeResources> owerResources = new ArrayList<GeResources>();
			if(resources != null){
				owerResources.addAll(resources);
			}
			for(GeResources resource:owerResources){
				resource.getGePermissions().remove(permission);
				permission.getGeResources().remove(resource);
			}
			delete(permission);
		}
	}
}

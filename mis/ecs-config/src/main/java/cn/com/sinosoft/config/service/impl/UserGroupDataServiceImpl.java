package cn.com.sinosoft.config.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.config.service.UserGroupService;
import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.domain.system.GeUsergroup;

/**
 * 描述：用户组管理业务处理实现类<br>
 * 作者：dengyu <br>
 * 修改日期：2013-12-18下午06:40:25 <br>
 * E-mail: 253168963@qq.com<br>
 */
@Component
public class UserGroupDataServiceImpl  extends GenericHibernateDao<GeUsergroup, String> implements UserGroupService {
	/**
	 * 方法名称：findUserGroupDateByID <br>
	 * 描述： 通过ID查询用户组<br>
	 * 作者：dengyu <br>
	 * 修改日期：2013年12月25日下午7:46:28 
	 * @see cn.com.sinosoft.config.service.UserGroupService#findUserGroupDateByID(java.lang.String) 
	 * @param id
	 * @return
	 */
	public GeUsergroup findUserGroupDateByID(String id) {
		return super.get(id);
	}
	/**
	 * 方法名称：saveOrUpdateUserGroupData <br>
	 * 描述： 保存或更新用户组<br>
	 * 作者：dengyu <br>
	 * 修改日期：2013年12月25日下午7:46:32 
	 * @see cn.com.sinosoft.config.service.UserGroupService#saveOrUpdateUserGroupData(cn.com.sinosoft.domain.system.GeUsergroup, java.lang.String) 
	 * @param geUsergroup
	 * @param type
	 */
	@ECSOperator(operator="保存或更新用户组")
	public void saveOrUpdateUserGroupData(GeUsergroup geUsergroup,Set<GeRole> roles,String type) {
		if("update".equals(type)){
			deleteGroupHaveRoles(geUsergroup.getUsergroupid());
			geUsergroup.setGeRoles(roles);
			super.update(geUsergroup);
		}else {
			super.save(geUsergroup);
		}
	}
	/**
	 * 方法名称：deleteUserGroupDatas <br>
	 * 描述： 删除用户组<br>
	 * 作者：dengyu <br>
	 * 修改日期：2013年12月25日下午7:46:37 
	 * @see cn.com.sinosoft.config.service.UserGroupService#deleteUserGroupDatas(java.util.List) 
	 * @param ids
	 */
	@ECSOperator(operator="删除用户组")
	public void deleteUserGroupDatas(List<String> ids) {
		List<GeUsergroup> usergroupDatas = new ArrayList<GeUsergroup>();
		for(String id:ids){
			usergroupDatas.add(super.get(id));
		}
		super.deleteAll(usergroupDatas);
	}
	
	/**
	 * 方法名称：findAllUserGroupDate <br>
	 * 描述： 查询所有用户组<br>
	 * 作者：dengyu <br>
	 * 修改日期：2013年12月25日下午7:46:42 
	 * @see cn.com.sinosoft.config.service.UserGroupService#findAllUserGroupDate(java.util.Map) 
	 * @param page
	 * @return
	 */
	public Page findAllUserGroupDate(Map<String,Integer> page) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addIsNotNull("usergroupid");
		queryRule.addDescOrder("createtime");
		return this.find(queryRule, page.get("page"), page.get("rows"));
	}
	/**
	 * 方法名称：findUserGroupDateByName <br>
	 * 描述： 通过用户组名查询用户组<br>
	 * 作者：dengyu <br>
	 * 修改日期：2013年12月25日下午7:46:47 
	 * @see cn.com.sinosoft.config.service.UserGroupService#findUserGroupDateByName(java.lang.String, java.util.Map) 
	 * @param Name
	 * @param page
	 * @return
	 */
	public Page findUserGroupDateByName(String Name,Map<String,Integer> page) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addLike("usergroupname", "%"+Name+"%");
		return super.find(queryRule,page.get("page"),page.get("rows"));
	}
	/**
	 * 方法名称：deleteGroupHaveRoles <br>
	 * 描述： 删除用户组关联的权限<br>
	 * 作者：dengyu <br>
	 * 修改日期：2013年12月25日下午7:46:52 
	 * @see cn.com.sinosoft.config.service.UserGroupService#deleteGroupHaveRoles(java.lang.String) 
	 * @param pk
	 */
	public void deleteGroupHaveRoles(String pk){
		GeUsergroup group = get(pk);
		
		Set<GeRole> roles = group.getGeRoles();
		List<GeRole> owerRoles = new ArrayList<GeRole>();
		if(roles != null){
			owerRoles.addAll(roles);
		}
		for(GeRole role:owerRoles){
			role.getGeUsergroups().remove(group);
			group.getGeRoles().remove(role);
		}
	}
	/**
	 * 方法名称：existGroupName <br>
	 * 描述：判断用户组名是否存在 <br>
	 * 作者：dengyu <br>
	 * 修改日期：2013年12月25日下午7:46:56 
	 * @see cn.com.sinosoft.config.service.UserGroupService#groupNameExist(java.lang.String) 
	 * @param groupName
	 * @return
	 */
	public boolean existGroupName(String groupName) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("usergroupname", groupName);
		return this.exists(queryRule);
	}
	/**
	 * 方法名称：findAllUserGroupDate<br>
	 * 描述：获取所有用户组数据<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午2:50:59<br>
	 * @see cn.com.sinosoft.config.service.UserGroupService#findAllUserGroupDate()
	 * @return
	 */
	public List<GeUsergroup> findAllUserGroupDate() {
		return super.getAll(entityClass, false);
	}
}

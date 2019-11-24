package cn.com.sinosoft.config.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.domain.system.GeUsergroup;

/**
 * 描述：用户组管理业务处理接口<br>
 * 作者：dengyu <br>
 * 修改日期：2013-12-18下午06:40:25 <br>
 * E-mail: 253168963@qq.com<br>
 */
public interface UserGroupService {
	/**
	 * 方法名称: findUserGroupDateByID<br>
	 * 描述：通过ID查询用户组
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:45:41
	 * @param id
	 * @return
	 */
	public GeUsergroup findUserGroupDateByID(String id);
	/**
	 * 方法名称: saveOrUpdateUserGroupData<br>
	 * 描述：保存/修改用户组
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:45:46
	 * @param geUsergroup
	 * @param type
	 */
	public void saveOrUpdateUserGroupData(GeUsergroup geUsergroup,Set<GeRole> roles,String type);
	/**
	 * 方法名称: deleteUserGroupDatas<br>
	 * 描述：删除用户组
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:45:52
	 * @param ids
	 */
	public void deleteUserGroupDatas(List<String> ids);
	/**
	 * 方法名称: findAllUserGroupDate<br>
	 * 描述：查询所有用户组
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:45:56
	 * @param page
	 * @return
	 */
	public Page findAllUserGroupDate(Map<String,Integer> page);
	/**
	 * 方法名称: findUserGroupDateByName<br>
	 * 描述：通过用户组名查询用户组
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:46:02
	 * @param Name
	 * @param page
	 * @return
	 */
	public Page findUserGroupDateByName(String Name,Map<String,Integer> page);
	/**
	 * 方法名称: deleteGroupHaveRoles<br>
	 * 描述：删除用户组关联的权限
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:46:08
	 * @param pk
	 */
	public void deleteGroupHaveRoles(String pk);
	/**
	 * 方法名称: existGroupName<br>
	 * 描述：判断用户组名是否存在
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:46:13
	 * @param groupName
	 * @return
	 */
	public boolean existGroupName(String groupName);
	/**
	 * 方法名称：findAllUserGroupDate<br>
	 * 描述：获取所有用户组数据<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午2:50:17<br>
	 * @return
	 */
	public List<GeUsergroup> findAllUserGroupDate();
	
}

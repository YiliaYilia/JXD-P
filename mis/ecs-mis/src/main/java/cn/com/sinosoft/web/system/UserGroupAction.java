package cn.com.sinosoft.web.system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.config.service.UserGroupService;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.domain.system.GeUsergroup;
import cn.com.sinosoft.dto.system.UserGoutpDate;
import cn.com.sinosoft.dto.system.UserGoutpDate.UserGoutpDateRow;
import cn.com.sinosoft.permission.service.RoleService;

/**
 * 描述： 用户组管理Aciton<br>
 * 作者：dengyu <br>
 * 修改日期：2013-12-18下午06:40:25 <br>
 * E-mail: <br>
 */
public class UserGroupAction extends Struts2Action {
	
	private GeUsergroup geGroup;
	
	private List<GeRole> geRoles;
	
	@Autowired
	private UserGroupService userGroupService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 方法名称: getUserGroup<br>
	 * 描述：
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:43:51
	 * @return
	 */
	@Action(value = "userGroup")
	public String getUserGroup() {
		return "/page/main/userGroup";
	}

	/**
	 * 方法名称: addUserGroupRole<br>
	 * 描述：
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:44:33
	 */
	@Action(value="addUserGroupRole")
	public void addUserGroupRole(){
		if("ADD".equals(getHttpServletRequest().getParameter("operate"))){
			if(geRoles != null){
				geGroup.setGeRoles(new HashSet<GeRole>(geRoles));
			}
			geGroup.setCreatetime(new Date());
			//操作员
			geGroup.setOperatorname(SpringSecurityUtil.getCurrentUserName());
			userGroupService.saveOrUpdateUserGroupData(geGroup, null,"save");
		}
		else if("UPDATE".equals(getHttpServletRequest().getParameter("operate"))){
			GeUsergroup group = userGroupService.findUserGroupDateByID(geGroup.getUsergroupid());
			Set<GeRole> roles = new HashSet<GeRole>();
			if(geRoles != null){
				roles.addAll(geRoles);
				group.setGeRoles(new HashSet<GeRole>(geRoles));
			}
			group.setUsergroupdesc(geGroup.getUsergroupdesc());
			group.setCreatetime(new Date());
			group.setOperatorname(SpringSecurityUtil.getCurrentUserName());
			userGroupService.saveOrUpdateUserGroupData(group,roles, "update");
		}
		renderText("SUCCESS");
	}
	
	/**
	 * 方法名称: deleteUserGroups<br>
	 * 描述：
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:44:05
	 * @return
	 */
	@Action(value = "deleteUserGroups")
	public String deleteUserGroups() {

		String manyIds = getHttpServletRequest().getParameter("deleteIds");
		List<String> ids = new ArrayList<String>();
		if (manyIds.contains(",")) {
			String[] temp = manyIds.split(",");
			for (String str : temp) {
				ids.add(str);
			}
		} else {
			ids.add(manyIds);
		}

		userGroupService.deleteUserGroupDatas(ids);

		return null;
	}

	/**
	 * 方法名称: editUserGroup<br>
	 * 描述：
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:44:11
	 * @return
	 */
	@Action(value = "editUserGroup")
	public String editUserGroup() {

		String editId = getHttpServletRequest().getParameter("editId");
		if (editId != null && !"".equals(editId)) {
			GeUsergroup geUsergroup = userGroupService.findUserGroupDateByID(editId);

			super.render(
					"{\"success\":true,\"usergroupid\":\""		
							+ geUsergroup.getUsergroupid() + "\",\"usergroupname\":\""
							+ geUsergroup.getUsergroupname()
							+ "\",\"usergroupdesc\":\""
							+ geUsergroup.getUsergroupdesc()
							+ "\",\"createtime\":\""
							+ geUsergroup.getCreatetime() + "\"}",
					"text/json;charset=UTF-8");
		}

		return null;
	}
	
	
	/**
	 * 方法名称: searchUserGroupData<br>
	 * 描述：
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:44:16
	 * @return
	 */
	@Action(value="searchUserGroupData")
	public String searchUserGroupData(){
	
		Map<String,Integer> page = new HashMap<String,Integer>();
		page.put("page", super.page);
		page.put("rows", super.rows);
		
		String usergroupname = getHttpServletRequest().getParameter("usergroupnameSearch");
		Page pageObj = null;
		if(usergroupname==null||"".equals(usergroupname)){
			pageObj = userGroupService.findAllUserGroupDate(page);
		}else {
			pageObj = userGroupService.findUserGroupDateByName(usergroupname,page);
		}
		UserGoutpDate userGoutpDate = new UserGoutpDate();
		userGoutpDate.setTotal(pageObj.getTotal() + "");
		List<UserGoutpDateRow> listRows = new ArrayList<UserGoutpDateRow>();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (GeUsergroup data : (List<GeUsergroup>)pageObj.getData()) {
			UserGoutpDateRow row = new UserGoutpDateRow();
			BeanUtils.copyProperties(data, row);
			row.setTimeString(format.format(data.getCreatetime()));
			listRows.add(row);
		}
		userGoutpDate.setRows(listRows);
		String result = JSONObject.fromObject(userGoutpDate).toString();
		super.render(result, "text/json;charset=UTF-8");
		return null;
	}
	
	/**
	 * 方法名称: userGroupRole<br>
	 * 描述：
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:44:22
	 * @return
	 */
	@Action(value="userGroupRole")
	public String userGroupRole(){
		if("ADD".equals(this.getHttpServletRequest().getParameter("operate"))){
			List<GeRole> roles = roleService.findAllRole();
			this.getHttpServletRequest().setAttribute("opeartype", "ADD");
			this.getHttpServletRequest().setAttribute("roles",roles);
		}
		else if("UPDATE".equals(this.getHttpServletRequest().getParameter("operate"))){
			//获取所有的权限
			List<GeRole> roles = roleService.findAllRole();
			GeUsergroup group = userGroupService.findUserGroupDateByID(geGroup.getUsergroupid());
			if(!group.getGeRoles().isEmpty()){
				List<GeRole> owerRoles = new ArrayList<GeRole>(group.getGeRoles());
				//移除自己的权限，就是未拥有的权限
				roles.removeAll(owerRoles);
				this.getHttpServletRequest().setAttribute("owerRoles",owerRoles);
			}
			this.getHttpServletRequest().setAttribute("roles",roles);
			this.getHttpServletRequest().setAttribute("group", group);
			this.getHttpServletRequest().setAttribute("opeartype", "UPDATE");
		}
		return "/page/main/userGroup-operate";
	}
	
	/**
	 * 方法名称: existUserGroup<br>
	 * 描述：
	 * 作者: dengyu
	 * 修改日期：2013年12月25日下午7:44:27
	 */
	@Action(value="existUserGroup")
	public void existUserGroup(){
		
		Map<String, String> result = new HashMap<String, String>();
		if("ADD".equals(getHttpServletRequest().getParameter("operate"))){
			boolean boo = userGroupService.existGroupName(geGroup.getUsergroupname());
			if(boo){ //存在
				result.put("error", "用户组已经存在");
			}
			else{//不存在
				result.put("ok", "");
			}
		}
		else{
			result.put("ok", "");
		}
		renderText(JSONObject.fromObject(result).toString());
	}

	public GeUsergroup getGeGroup() {
		return geGroup;
	}

	public void setGeGroup(GeUsergroup geGroup) {
		this.geGroup = geGroup;
	}

	public List<GeRole> getGeRoles() {
		return geRoles;
	}

	public void setGeRoles(List<GeRole> geRoles) {
		this.geRoles = geRoles;
	}
	
}

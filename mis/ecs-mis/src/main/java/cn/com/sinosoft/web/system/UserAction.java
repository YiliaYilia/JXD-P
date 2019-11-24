package cn.com.sinosoft.web.system;

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

import cn.com.sinosoft.config.service.DictDataService;
import cn.com.sinosoft.config.service.UserGroupService;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.MD5;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeRole;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.domain.system.GeUsergroup;
import cn.com.sinosoft.domain.system.MobileCustomer;
import cn.com.sinosoft.dto.system.MobileUserData;
import cn.com.sinosoft.dto.system.UserData;
import cn.com.sinosoft.dto.system.MobileUserData.MobileUserDataRow;
import cn.com.sinosoft.dto.system.UserData.UserDataRow;
import cn.com.sinosoft.permission.service.RoleService;
import cn.com.sinosoft.user.service.MobileCustomerService;
import cn.com.sinosoft.user.service.UserService;
import cn.com.sinosoft.user.service.impl.UserServiceImpl;

/**
 * 描述：用户管理<br>
 * 作者：Leeyao<br>
 * 修改日期：2013年12月19日下午8:11:21<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
/**描述：<br>
 * 作者：Leeyao<br>
 * 修改日期：2013年12月30日下午2:44:57<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
public class UserAction extends Struts2Action {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	@Autowired
	private DictDataService dictDataService;
	@Autowired
	private UserGroupService userGroupService;
	@Autowired
	private RoleService roleService;
	
	
	private GeUser geUser;
	private List<GeUsergroup> geUsergroups;
	private List<GeRole> geRoles;
	private List<GeDepartment> geDepartments;
	private String isOpenDep;
	
	/**
	 * 方法名称：jumpUserDateManagerPage<br>
	 * 描述：<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月19日下午8:17:27<br>
	 * @return
	 */
	@Action(value = "userDataManager")
	public String jumpUserDateManagerPage() {
		return "/page/main/userManage";
	}
	
	/**
	 * 方法名称：findUserData<br>
	 * 描述：查询用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月23日下午12:17:37<br>
	 */
	@Action(value = "findUserData")
	public void findUserData() {
		String username = "";
		if(geUser != null){
			username = geUser.getUsername();
		}
		Page<GeUser> pageObj = userService.getGeUserByName(username, page, rows);
		UserData userDate = new UserData();
		List<GeUser> users = (List<GeUser>)pageObj.getData();
		userDate.setTotal(pageObj.getTotal() + "");
		List<UserDataRow> rows = new ArrayList<UserDataRow>();
		for (GeUser geUser : users) {
			UserDataRow row = new UserDataRow();
			BeanUtils.copyProperties(geUser, row);
			rows.add(row);
		}
		userDate.setRows(rows);
		String result = JSONObject.fromObject(userDate).toString();
		super.render(result, "text/json;charset=UTF-8");
		System.out.println(result);
	}
	
		
	
	/**
	 * 方法名称：jumpalterUserInfo<br>
	 * 描述：跳转至修改用户信息页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月30日下午7:51:06<br>
	 */
	@Action(value="alterUserInfo")
	public String jumpalterUserInfo(){
		GeUser user = userService.getGeUserById(geUser.getUserid());
		this.getHttpServletRequest().setAttribute("userInfo", user);
		return "/page/main/alterUserInfo";
	}
	
	/**
	 * 方法名称：updateUserInfo<br>
	 * 描述：用户修改个人信息<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月30日下午8:00:32<br>
	 */
	@Action(value="updateUserInfo")
	public void updateUserInfo(){
		GeUser user = userService.getGeUserById(geUser.getUserid());
		Set<GeRole> roles = new HashSet<GeRole>(user.getGeRoles());
		Set<GeUsergroup> usergroups = new HashSet<GeUsergroup>(user.getGeUsergroups());
		Set<GeDepartment> departments = new HashSet<GeDepartment>(user.getGeDepartments());
		if(geUser.getPassword() == null || "".equals(geUser.getPassword())){
			geUser.setPassword(user.getPassword());
		}else{
			geUser.setPassword(MD5.GetMD5Code(geUser.getPassword()).toUpperCase());
		}
		geUser.setState(user.getState());
		geUser.setUsertype(user.getUsertype());
		BeanUtils.copyProperties(geUser, user);
		user.setCreatetime(new Date());
		userService.updateGeUser(user, roles, usergroups, departments);
	}
	
	/**
	 * 方法名称：jumpOperatePage<br>
	 * 描述：跳转至用户操作页面<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日下午4:41:46<br>
	 * @return
	 */
	@Action(value="userOperate")
	public String jumpOperatePage(){
		String operate = this.getHttpServletRequest().getParameter("operate");
		List<GeUsergroup> usergroups = userGroupService.findAllUserGroupDate();
		List<GeRole> roles = roleService.findAllRole();
		if("add".equals(operate)){
			this.getHttpServletRequest().setAttribute("roles", roles);
			this.getHttpServletRequest().setAttribute("opeartype", "add");
			this.getHttpServletRequest().setAttribute("usergroups", usergroups);
		} else {
			GeUser user = userService.getGeUserById(geUser.getUserid());
			List<GeUsergroup> owerUsergroups = new ArrayList<GeUsergroup>(user.getGeUsergroups());
			List<GeRole> owerRoles = new ArrayList<GeRole>(user.getGeRoles());
			usergroups.removeAll(owerUsergroups);
			roles.removeAll(owerRoles);
			this.getHttpServletRequest().setAttribute("roles", roles);
			this.getHttpServletRequest().setAttribute("usergroups", usergroups);
			this.getHttpServletRequest().setAttribute("owerRoles", owerRoles);
			this.getHttpServletRequest().setAttribute("owerUsergroups", owerUsergroups);
			this.getHttpServletRequest().setAttribute("userData", user);
			this.getHttpServletRequest().setAttribute("owerDepartments", user.getGeDepartments());
			if("update".equals(operate)){
				this.getHttpServletRequest().setAttribute("opeartype", "update");
			}else if("see".equals(operate)){
				this.getHttpServletRequest().setAttribute("opeartype", "see");
				return "/page/main/user-details";
			}
		}
		return "/page/main/user-operate";
	}
	
	/**
	 * 方法名称：deleteUserData<br>
	 * 描述：删除用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月24日上午10:16:40<br>
	 */
	@Action(value = "deleteUserData")
	public void deleteUserData() {
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
		for (String id : ids) {
			userService.deleteGeUser(id);
		}
	}
	
	/**
	 * 方法名称：addOrUpdateUser<br>
	 * 描述：添加或修改用户<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月25日下午1:27:35<br>
	 */
	@Action(value="addOrUpdateUser")
	public void addOrUpdateUser(){
		String operate = getHttpServletRequest().getParameter("operate");
		if("add".equals(operate)){
			if(geUsergroups != null){
				geUser.setGeUsergroups(new HashSet<GeUsergroup>(geUsergroups));
			}
			if(geRoles != null){
				geUser.setGeRoles(new HashSet<GeRole>(geRoles));
			}
			if(geDepartments != null){
				geUser.setGeDepartments(new HashSet<GeDepartment>(geDepartments));
			}
			geUser.setPassword(MD5.GetMD5Code(geUser.getPassword()).toUpperCase());
			geUser.setCreatetime(new Date());
			userService.addGeUser(geUser);
		} else if ("update".equals(operate)){
			GeUser user = userService.getGeUserById(geUser.getUserid());
			Set<GeRole> roles = null;
			Set<GeUsergroup> usergroups = null;
			Set<GeDepartment> departments = null;
			if(geUser.getPassword() == null){
				geUser.setPassword(user.getPassword());
			}else{
				geUser.setPassword(MD5.GetMD5Code(geUser.getPassword()).toUpperCase());
			}
			if(geUsergroups != null){
				usergroups = new HashSet<GeUsergroup>(geUsergroups);
			}
			if(geRoles != null){
				roles = new HashSet<GeRole>(geRoles);
			}
			if("no".equals(isOpenDep)){
				departments = new HashSet<GeDepartment>(user.getGeDepartments());
			} else if(geDepartments != null){
				departments = new HashSet<GeDepartment>(geDepartments);
			}
			BeanUtils.copyProperties(geUser, user);
			user.setCreatetime(new Date());
			userService.updateGeUser(user, roles, usergroups, departments);
		}
		renderText("SUCCESS");
	}
	
	/**
	 * 方法名称：existUserName<br>
	 * 描述：验证用户是否已存在<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月25日下午3:45:54<br>
	 */
	@Action(value="existUserName")
	public void existUserName(){
		Map<String, String> result = new HashMap<String, String>();
		if("add".equals(getHttpServletRequest().getParameter("operate"))){
			if(userService.getGeUserByName(geUser.getUsername()) != null){
				result.put("error", "用户已经存在");
			} else {
				result.put("ok", "");
			}
		}
		else{
			result.put("ok", "");
		}
		renderText(JSONObject.fromObject(result).toString());
	}

	public GeUser getGeUser() {
		return geUser;
	}

	public void setGeUser(GeUser geUser) {
		this.geUser = geUser;
	}

	public List<GeUsergroup> getGeUsergroups() {
		return geUsergroups;
	}

	public void setGeUsergroups(List<GeUsergroup> geUsergroups) {
		this.geUsergroups = geUsergroups;
	}

	public List<GeRole> getGeRoles() {
		return geRoles;
	}

	public void setGeRoles(List<GeRole> geRoles) {
		this.geRoles = geRoles;
	}

	public List<GeDepartment> getGeDepartments() {
		return geDepartments;
	}

	public void setGeDepartments(List<GeDepartment> geDepartments) {
		this.geDepartments = geDepartments;
	}

	public String getIsOpenDep() {
		return isOpenDep;
	}

	public void setIsOpenDep(String isOpenDep) {
		this.isOpenDep = isOpenDep;
	}
	public static void main(String[] args) {
		UserAction a = new UserAction();
		a.findUserData();
	}
	
	
}

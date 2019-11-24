package cn.com.sinosoft.web.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.config.service.GeDepartmentService;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.dto.system.OrganTree;
import cn.com.sinosoft.user.service.UserService;

/**
 * 描述：组织机构请求处理<br>
 * 作者：zhongyong <br>
 * 修改日期：2013-12-23下午04:16:46 <br>
 * E-mail:zhongysz0442@sinosoft.com.cn <br>
 */
public class OrganAction extends Struts2Action {
	private static final long serialVersionUID = 6829120086557745633L;

	@Autowired
	private GeDepartmentService geDepartmentService;
	@Autowired
	private UserService userService;

	/**方法名称: organResourceListPage<br>
	 * 描述：查询所有组织机构
	 * 作者: zhongyong 
	 * 修改日期：2013-12-25下午05:54:24
	 * @return
	 */
	@Action(value = "organ")
	public String organResourceListPage() {
		List<GeDepartment> geDepartments = geDepartmentService
				.getGeDepartmentAll();
		List<OrganTree> organTrees = new ArrayList<OrganTree>();
		for (GeDepartment geDepartment : geDepartments) {
			OrganTree tree = new OrganTree();
			tree.setId(geDepartment.getDeptid());
			tree.setDeptCode(geDepartment.getDeptCode());
			tree.setParentId(geDepartment.getParentid());
			tree.setText(geDepartment.getDeptname());
			tree.setDeptid(geDepartment.getDeptid());
			tree.setDeptname(geDepartment.getDeptname());
			tree.setOrganType(geDepartment.getOrganType());
			tree.setContactAddress(geDepartment.getContactAddress());
			tree.setOfficePhone(geDepartment.getOfficePhone());
			tree.setZipCode(geDepartment.getZipCode());
			tree.setRoot(geDepartment.getRoot());
			// BeanUtils.copyProperties(geDepartment,tree);
			organTrees.add(tree);
		}
		getHttpServletRequest().setAttribute("organTrees",
				JSONArray.fromObject(organTrees).toString());

		return "/page/main/organ";
	}
	
	/**
	 * 方法名称：organResource<br>
	 * 描述：获得机构树json数据<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月26日上午11:00:52<br>
	 */
	@Action(value = "organResource")
	public void organResource() {
		List<GeDepartment> geDepartments = geDepartmentService
				.getGeDepartmentAll();
		List<OrganTree> organTrees = new ArrayList<OrganTree>();
		String operate = getHttpServletRequest().getParameter("operate");
		if("add".equals(operate)){
			for (GeDepartment geDepartment : geDepartments) {
				OrganTree tree = new OrganTree();
				tree.setId(geDepartment.getDeptid());
				tree.setParentId(geDepartment.getParentid());
				tree.setText(geDepartment.getDeptname());
				tree.setRoot(geDepartment.getRoot());
				organTrees.add(tree);
			}
		} else {
			String userid = getHttpServletRequest().getParameter("userid");
			GeUser user = userService.getGeUserById(userid);
			Set<GeDepartment> departments = user.getGeDepartments();
			if("update".equals(operate)){
				for (GeDepartment geDepartment : geDepartments) {
					OrganTree tree = new OrganTree();
					tree.setId(geDepartment.getDeptid());
					tree.setParentId(geDepartment.getParentid());
					tree.setText(geDepartment.getDeptname());
					tree.setRoot(geDepartment.getRoot());
					tree.setChecked(isExistDep(departments, geDepartment));
					organTrees.add(tree);
				}
			}else{
				for (GeDepartment geDepartment : departments) {
					OrganTree tree = new OrganTree();
					tree.setId(geDepartment.getDeptid());
					tree.setParentId(geDepartment.getParentid());
					tree.setText(geDepartment.getDeptname());
					tree.setRoot(geDepartment.getRoot());
					organTrees.add(tree);
				}
			}
		}
		renderJson(JSONArray.fromObject(organTrees).toString());
	}
	
	/**
	 * 方法名称：isExistDep<br>
	 * 描述：判断机构是否存在所有机构树中<br>
	 * 作者：Leeyao<br>
	 * 修改日期：2013年12月26日下午4:22:51<br>
	 * @param departments
	 * @param geDepartment
	 * @return
	 */
	private boolean isExistDep(Set<GeDepartment> departments,GeDepartment geDepartment){
		Iterator<GeDepartment> iterator = departments.iterator();
		while (iterator.hasNext()) {
			if(geDepartment.getDeptid().equals(iterator.next().getDeptid())){
				return true;
			}
		}
		return false;
	}
	
	/**方法名称: jumpaDDoRUpdateOrganPage<br>
	 * 描述：组织机构添加修改时在此方法进行跳转页面
	 * 作者: zhongyong 
	 * 修改日期：2013-12-30上午10:08:40
	 * @return
	 */
	@Action(value="jumpaDDoRUpdateOrganPage")
	public String jumpaDDoRUpdateOrganPage(){
		
		return "page/main/organ-operate";
	}
	
	/**方法名称: addUpdateOrgan<br>
	 * 描述：添加或更新组织机构
	 * 作者: zhongyong 
	 * 修改日期：2013-12-25下午05:54:09
	 * @return
	 */
	@Action(value = "addUpdateOrgan")
	public String addUpdateOrgan() {
		String opeartype = getHttpServletRequest().getParameter("opeartype");
		String deptId= getHttpServletRequest().getParameter("deptid");
		String deptCode= getHttpServletRequest().getParameter("deptCode");
		String parentId= getHttpServletRequest().getParameter("parentId");
		String deptname = getHttpServletRequest().getParameter("deptname");
		String contactAddress = getHttpServletRequest().getParameter("contactAddress");
		String officePhone = getHttpServletRequest().getParameter("officePhone");
		String zipCode = getHttpServletRequest().getParameter("zipCode");
		String root = getHttpServletRequest().getParameter("root");
		String organType = getHttpServletRequest().getParameter("organType");
		GeDepartment geDepartment=new GeDepartment();
			if("ADD".equals(opeartype)){ //添加组织机构
				if(isExist(deptCode)){
					renderText("ISEXIST"); 
		    		return null;
				}else{
	        	geDepartment.setDeptid(deptCode.toUpperCase());
	        	geDepartment.setDeptCode(deptCode.toUpperCase());
	        	geDepartment.setParentid(deptId.toUpperCase());
	        	geDepartment.setOrganType(organType);
	        	geDepartment.setDeptname(deptname);
	        	geDepartment.setContactAddress(contactAddress);
	        	geDepartment.setOfficePhone(officePhone);
	        	geDepartment.setZipCode(zipCode);
	        	geDepartment.setRoot(null);
	        	geDepartmentService.saveGeDepartment(geDepartment);
	        	renderText("ADD_SUCCESS"); 
	    		return null;
				}
	        }else{   //修改组织机构
	        	geDepartment.setDeptid(deptCode.toUpperCase());
	        	geDepartment.setDeptCode(deptCode.toUpperCase());
	        	geDepartment.setRoot(root);
	        	if(!"".equals(parentId)){
	        		geDepartment.setParentid(parentId.toUpperCase());
	        	}
	        	geDepartment.setOrganType(organType);
	        	geDepartment.setDeptname(deptname);
	        	geDepartment.setContactAddress(contactAddress);
	        	geDepartment.setOfficePhone(officePhone);
	        	geDepartment.setZipCode(zipCode);
	        	geDepartmentService.saveGeDepartment(geDepartment);
	        	renderText("UPDATE_SUCCESS"); 
	        }
		
		return null;
	}
	
	/**方法名称: delOrgan<br>
	 * 描述：删除组织机构
	 * 作者: zhongyong 
	 * 修改日期：2013-12-25下午05:53:48
	 * @return
	 */
	@Action(value = "delOrgan")
	public String delOrgan(){
		String deptid = getHttpServletRequest().getParameter("deptid");
		geDepartmentService.deleteGeDepartmentById(deptid);
		renderText("DEL_SUCCESS"); 
		return null;
	}

	
	/**方法名称: existDepartment<br>
	 * 描述：查看组织机构是否存在
	 * 作者: zhongyong 
	 * 修改日期：2013-12-25下午05:43:53
	 */
	@Action(value="existDepartment")
	public void existDepartment(){
		Map<String, String> result = new HashMap<String, String>();
		String deptCode="";
		if("ADD".equals(getHttpServletRequest().getParameter("opeartype"))){
			deptCode=getHttpServletRequest().getParameter("deptCode");
			String deptCode1 = deptCode.substring(0, 2).toUpperCase();;
			boolean boo = geDepartmentService.findByDeptCode(deptCode1);
			if(boo){ //存在
				result.put("error", "机构编码已经存在");
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
	
	
	/**
	 * 
	 * 根据前两位判断机构是否重复
	 * @param deptCode
	 * @return
	 */
	public boolean isExist(String deptCode){
		boolean flag=false;
		if(deptCode!=null&&deptCode.length()>0){
			//String deptCode1 = deptCode.substring(0, 2).toUpperCase();
			boolean boo = geDepartmentService.findByDeptCode(deptCode.toUpperCase());
			if(boo){
				flag =  true;
			}else{
				flag =  false;
			}
		}
		return flag;
	}
	
	
}

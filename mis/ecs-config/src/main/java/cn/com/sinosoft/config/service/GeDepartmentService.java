package cn.com.sinosoft.config.service;

import java.util.List;

import cn.com.sinosoft.domain.system.GeDepartment;

/**描述：组织机构或部门业务处理接口<br>
 * 作者：zhongyong <br>
 * 修改日期：2013-12-23下午03:52:19 <br>
 * E-mail:zhongysz0442@sinosoft.com.cn <br> 
 */
public interface GeDepartmentService {

	/**方法名称: saveGeDepartment<br>
	 * 描述：添加组织机构或部门
	 * 作者: zhongyong 
	 * 修改日期：2013-12-23下午03:56:45
	 * @param geDepartment
	 */
	public void saveGeDepartment(GeDepartment geDepartment);
	
	/**方法名称: deleteGeDepartment<br>
	 * 描述：删除组织机构或部门
	 * 作者: zhongyong 
	 * 修改日期：2013-12-23下午03:57:18
	 * @param geDepartment
	 */
	public void deleteGeDepartmentById(String deptid);
	
	/**方法名称: updateGeDepartment<br>
	 * 描述：更新组织机构或部门
	 * 作者: zhongyong 
	 * 修改日期：2013-12-23下午03:57:27
	 * @param geDepartment
	 */
	public void updateGeDepartment(GeDepartment geDepartment);
	
	/**方法名称: getGeDepartmentAll<br>
	 * 描述：查询所有组织机构或部门
	 * 作者: zhongyong 
	 * 修改日期：2013-12-23下午03:57:39
	 * @return
	 */
	public List<GeDepartment> getGeDepartmentAll();
	
	/**方法名称: existDepartment<br>
	 * 描述：检查组织机构是否存在
	 * 作者: zhongyong 
	 * 修改日期：2013-12-25下午05:48:34
	 * @return
	 */
	public boolean findByDeptCode(String deptCode);
	
	/**
	 * 方法名称: fingByOrganType<br>
	 * 描述：根据机构类型，查询机构信息
	 * 作者: yuas
	 * 修改日期：2014年1月14日下午5:27:23
	 * @param organType
	 */
	public List<GeDepartment> fingByOrganType(String organType);
}

package cn.com.sinosoft.ess.config.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.ess.config.service.GeDepartmentService;
import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeDepartment;

/**描述：组织机构或部门业务处理实现类<br>
 * 作者：zhongyong <br>
 * 修改日期：2013-12-23下午03:52:19 <br>
 * E-mail:zhongysz0442@sinosoft.com.cn <br> 
 */
@Component
public class GeDepartmentServiceImpl extends GenericHibernateDao<GeDepartment, String> implements GeDepartmentService{

	/**方法名称：saveGeDepartment <br>
	 * 描述：添加组织机构或部门 <br>
	 * 作者：zhongyong  <br>
	 * 修改日期：2013-12-23下午04:07:08 
	 * @param geDepartment
	 */
	@ECSOperator(operator="添加组织机构或部门")
	public void saveGeDepartment(GeDepartment geDepartment) {
		getHibernateTemplate().saveOrUpdate(geDepartment);
	}

	/**方法名称：deleteGeDepartment <br>
	 * 描述：删除组织机构或部门 <br>
	 * 作者：zhongyong  <br>
	 * 修改日期：2013-12-23下午04:07:59 
	 * @param deptid
	 */
	@ECSOperator(operator="删除组织机构或部门 ")
	public void deleteGeDepartmentById(String deptid) {
		deleteByPK(deptid);
	}

	/**方法名称：updateGeDepartment <br>
	 * 描述：更新组织机构或部门 <br>
	 * 作者：zhongyong  <br>
	 * 修改日期：2013-12-23下午04:08:18 
	 * @param geDepartment
	 */
	@ECSOperator(operator="更新组织机构或部门")
	public void updateGeDepartment(GeDepartment geDepartment) {
		update(geDepartment);
	}

	/**方法名称：getGeDepartmentAll <br>
	 * 描述：查询所有组织机构或部门 <br>
	 * 作者：zhongyong  <br>
	 * 修改日期：2013-12-23下午04:08:36 
	 * @return
	 */
	public List<GeDepartment> getGeDepartmentAll() {
		
		return this.getAll(GeDepartment.class,true);
	}

	/**方法名称: existDepartment<br>
	 * 描述：检查组织机构是否存在
	 * 作者: zhongyong 
	 * 修改日期：2013-12-25下午05:48:34
	 * @return
	 */
	public boolean findByDeptCode(String deptCode1) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("deptid", deptCode1);
		return super.exists(queryRule);
	}

	/**
	 * 方法名称: fingByOrganType<br>
	 * 描述：根据机构类型，查询机构信息
	 * 作者: yuas
	 * 修改日期：2014年1月14日下午5:27:23
	 * @param organType
	 */
	public List<GeDepartment> fingByOrganType(String organType){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("organType", organType);
		return find(queryRule);
	}

	@Override
	public GeDepartment findDepart(String depid) {
	//	String rootDep = findRootDepart().getDeptid();
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addLike("deptid", depid+"%");
	//	queryRule.addEqual("parentid", rootDep);
		return findUnique(queryRule);
	}
	

	public GeDepartment findRootDepart() {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addIsNull("parentid");
		return findUnique(queryRule);
	}
}

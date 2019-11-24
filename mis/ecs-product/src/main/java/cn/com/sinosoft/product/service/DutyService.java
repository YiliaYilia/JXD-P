package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeDuty;

/**
 * 描述：责任业务操作类<br>
 * 作者：yuas <br>
 * 修改日期：2014年1月7日下午3:13:45 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public interface DutyService {

	/**
	 * 方法名称：addDuty <br>
	 * 描述： 添加责任<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:35:30 
	 * @see cn.com.sinosoft.product.service.DutyService#addDuty(cn.com.sinosoft.domain.product.GeDuty) 
	 * @param duty
	 */
	public void addDuty(GeDuty duty);

	/**
	 * 方法名称：updateDuty <br>
	 * 描述：修改责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:35:40 
	 * @see cn.com.sinosoft.product.service.DutyService#updateDuty(cn.com.sinosoft.domain.product.GeDuty) 
	 * @param geDuty
	 */
	public void updateDuty(GeDuty geDuty);

	/**
	 * 方法名称：findDuty <br>
	 * 描述：查询责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:35:50 
	 * @see cn.com.sinosoft.product.service.DutyService#findDuty(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param queryRule
	 * @return
	 */
	public List<GeDuty> findDuty(QueryRule queryRule);

	/**
	 * 方法名称：findDuty <br>
	 * 描述：分页 查询责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:36:13 
	 * @see cn.com.sinosoft.product.service.DutyService#findDuty(cn.com.sinosoft.core.hibernate.QueryRule, int, int) 
	 * @param queryRule
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findDuty(QueryRule queryRule, int pageNo, int pageSize);

	/**
	 * 方法名称：findDutyByDutyCodeAndRiskCode <br>
	 * 描述：查询责任  <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:36:25 
	 * @see cn.com.sinosoft.product.service.DutyService#findDutyByDutyCodeAndRiskCode(java.lang.String, java.lang.String) 
	 * @param dutyCode
	 * @param riskCode
	 * @return
	 */
	public GeDuty findDutyByDutyCodeAndRiskCode(String dutyCode, String riskCode);

	/**
	 * 方法名称：deleteDutyByRiskCode <br>
	 * 描述：删除责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:36:35 
	 * @see cn.com.sinosoft.product.service.DutyService#deleteDutyByRiskCode(java.lang.String) 
	 * @param riskCode
	 */
	public void deleteDutyByRiskCode(String riskCode);

	/**
	 * 方法名称：delete <br>
	 * 描述：查询责任  <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:36:47 
	 * @see cn.com.sinosoft.product.service.DutyService#delete(cn.com.sinosoft.domain.product.GeDuty) 
	 * @param geDuty
	 */
	public void delete(GeDuty geDuty);

	/**
	 * 方法名称：get <br>
	 * 描述： 查询责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:36:52 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#get(java.io.Serializable) 
	 * @param pk
	 * @return
	 */
	public GeDuty get(String pk);

}
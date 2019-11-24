package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeDuty;
import cn.com.sinosoft.product.service.DutyService;

/**
 * 描述：责任业务操作类<br>
 * 作者：yuas <br>
 * 修改日期：2014年1月7日下午3:13:45 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
@Component
public class DutyServiceImpl extends GenericHibernateDao<GeDuty, String>  implements DutyService {

	/**
	 * 方法名称：addDuty <br>
	 * 描述： 添加责任<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:35:30 
	 * @see cn.com.sinosoft.product.service.DutyService#addDuty(cn.com.sinosoft.domain.product.GeDuty) 
	 * @param duty
	 */
	@ECSOperator(operator = "添加责任")
	public void addDuty(GeDuty duty) {
		this.save(duty);
	}

	/**
	 * 方法名称：updateDuty <br>
	 * 描述：修改责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:35:40 
	 * @see cn.com.sinosoft.product.service.DutyService#updateDuty(cn.com.sinosoft.domain.product.GeDuty) 
	 * @param geDuty
	 */
	@ECSOperator(operator = "修改责任")
	public void updateDuty(GeDuty geDuty) {
		GeDuty update = this.get(geDuty.getDutyno());
		BeanUtils.copyProperties(geDuty, update,new String[]{"createtime"});
		this.update(update);
	}

	/**
	 * 方法名称：findDuty <br>
	 * 描述：查询责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:35:50 
	 * @see cn.com.sinosoft.product.service.DutyService#findDuty(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param queryRule
	 * @return
	 */
	public List<GeDuty> findDuty(QueryRule queryRule) {
		return this.find(queryRule);
	}

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
	public Page findDuty(QueryRule queryRule, int pageNo, int pageSize) {
		return this.find(queryRule, pageNo, pageSize);
	}

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
	public GeDuty findDutyByDutyCodeAndRiskCode(String dutyCode, String riskCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("dutyCode", dutyCode);
		queryRule.addEqual("geRisk.riskcode", riskCode);
		List<GeDuty> geDutList = super.find(queryRule);
		if (geDutList.size() > 0) {
			return geDutList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 方法名称：deleteDutyByRiskCode <br>
	 * 描述：删除责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:36:35 
	 * @see cn.com.sinosoft.product.service.DutyService#deleteDutyByRiskCode(java.lang.String) 
	 * @param riskCode
	 */
	@ECSOperator(operator = "删除责任")
	public void deleteDutyByRiskCode(String riskCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("geRisk.riskcode", riskCode);
		List<GeDuty> geDutyList = super.find(queryRule);
		super.deleteAll(geDutyList);
	}

	/**
	 * 方法名称：delete <br>
	 * 描述：查询责任  <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:36:47 
	 * @see cn.com.sinosoft.product.service.DutyService#delete(cn.com.sinosoft.domain.product.GeDuty) 
	 * @param geDuty
	 */
	@ECSOperator(operator = "删除责任")
	public void delete(GeDuty geDuty) {
		super.delete(geDuty);
	}

	/**
	 * 方法名称：get <br>
	 * 描述： 查询责任 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:36:52 
	 * @see cn.com.sinosoft.core.hibernate.GenericHibernateDao#get(java.io.Serializable) 
	 * @param pk
	 * @return
	 */
	public GeDuty get(String pk){
		return super.get(pk);
	}
}

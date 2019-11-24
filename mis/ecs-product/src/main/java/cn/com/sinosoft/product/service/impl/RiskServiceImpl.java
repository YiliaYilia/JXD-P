package cn.com.sinosoft.product.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeDuty;
import cn.com.sinosoft.domain.product.GeRisk;
import cn.com.sinosoft.product.service.DutyService;
import cn.com.sinosoft.product.service.RiskService;

/**
 * 描述：险种业务操作类<br>
 * 作者：yuas <br>
 * 修改日期：2014年1月7日下午3:13:45 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
@Component
public class RiskServiceImpl extends GenericHibernateDao<GeRisk, String>  implements RiskService {
 
	@Autowired
	private DutyService dutyService;
	
	/**
	 * 方法名称：getRiskByPage <br>
	 * 描述： 分页查询险种<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月7日下午3:17:39 
	 * @see cn.com.sinosoft.product.service.RiskService#getRiskByPage(cn.com.sinosoft.domain.product.GeRisk, int, int) 
	 * @param geRisk
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<GeRisk> getRiskByPage(GeRisk geRisk, int page, int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geRisk != null){
			if(!StringUtils.isEmpty(geRisk.getRiskcode())){
				queryRule.addLike("riskcode", "%"+geRisk.getRiskcode()+"%");
			}
			if(!StringUtils.isEmpty(geRisk.getCoreriskcode())){
				queryRule.addLike("coreriskcode", "%"+geRisk.getCoreriskcode()+"%");
			}
			if(!StringUtils.isEmpty(geRisk.getRiskname())){
				queryRule.addLike("riskname", "%"+geRisk.getRiskname()+"%");
			}
			if(!StringUtils.isEmpty(geRisk.getBusinessarea())){
				queryRule.addEqual("businessarea", geRisk.getBusinessarea());
			}
		}
		queryRule.addDescOrder("createtime");
		return this.find(queryRule, page, rows);
	}
	
	/**
	 * 方法名称：updateGeRisk <br>
	 * 描述：修改险种信息 <br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:21:41 
	 * @see cn.com.sinosoft.product.service.RiskService#updateGeRisk(cn.com.sinosoft.domain.product.GeRisk) 
	 * @param geRisk
	 */
	@ECSOperator(operator = "修改险种信息")
	public void updateGeRisk(GeRisk geRisk) {
			GeRisk update = super.findUnique("riskcode", geRisk.getRiskcode());
			List<GeDuty> geDutyList = geRisk.getGeDutys();
			List<GeDuty> existDutyList = update.getGeDutys();
			
			for (GeDuty existDuty:existDutyList) {
				
				boolean existFlag = false;
				
				for (GeDuty geDuty:geDutyList) {
					if (StringUtils.isNotBlank(geDuty.getDutyno())) {
						if (existDuty.getDutyno().equals(geDuty.getDutyno())) {
							existFlag = true;
							break;
						}
					}
				}
				
				if (!existFlag) {
					dutyService.delete(existDuty);
				}
				
			}
			
			for (GeDuty geDuty:geDutyList) {
				geDuty.setBusinessarea(geRisk.getBusinessarea());
				geDuty.setGeRisk(geRisk);
				geDuty.setOperator(geRisk.getOperator());
				if (StringUtils.isNotBlank(geDuty.getDutyno())) { 
					dutyService.updateDuty(geDuty);
				} else {
					geDuty.setCreatetime(new Date());
					dutyService.addDuty(geDuty);
				}
			}
			BeanUtils.copyProperties(geRisk, update, new String[]{"createtime"});
			update.getGeDutys().clear();
			super.update(update);
	}

	/**
	 * 方法名称：addGeRisk <br>
	 * 描述： 添加险种信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:41:38 
	 * @see cn.com.sinosoft.product.service.RiskService#addGeRisk(cn.com.sinosoft.domain.product.GeRisk) 
	 * @param geRisk
	 */
	@ECSOperator(operator = "添加险种信息")
	public void addGeRisk(GeRisk geRisk) {
		this.save(geRisk);
	}

	/**
	 * 方法名称：findGeRiskByQueryRule <br>
	 * 描述： 查询险种信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:42:05 
	 * @see cn.com.sinosoft.product.service.RiskService#findGeRiskByQueryRule(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param queryRule
	 * @return
	 */
	public List<GeRisk> findGeRiskByQueryRule(QueryRule queryRule) {
		return this.find(queryRule);
	}

	/**
	 * 方法名称：findGeRiskByRiskCode <br>
	 * 描述： 查询险种信息<br>
	 * 作者：yuas <br>
	 * 修改日期：2014年1月14日上午9:42:15 
	 * @see cn.com.sinosoft.product.service.RiskService#findGeRiskByRiskCode(java.lang.String) 
	 * @param riskCode
	 * @return
	 */
	public GeRisk findGeRiskByRiskCode(String riskCode) {
		return this.get(riskCode);
	}
	

}

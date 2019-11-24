package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProInsuredOccupation;
import cn.com.sinosoft.domain.product.GeProductInsuredconfig;
import cn.com.sinosoft.product.service.ProInsuredOccupationService;

@Component
public class ProInsuredOccupationServiceImpl extends GenericHibernateDao<GeProInsuredOccupation, String>  implements ProInsuredOccupationService {
	
	
	public List<GeProInsuredOccupation> findByQuery(QueryRule queryRule) {
		return super.find(queryRule);
	}
	/**
	 * 方法名称: findByInsuredConfigno<br>
	 * 描述：根据被保人配置序号查询 已经配置的职业
	 * 作者: partrick
	 * 修改日期：2014年1月13日下午1:38:50
	 * @param insuredconfigno
	 * @return
	 */
	public List<GeProInsuredOccupation> findByInsuredConfigno(String insuredconfigno) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("geProductInsuredconfig.insuredconfigno", insuredconfigno);
		return super.find(queryRule);
	}
	
	/**
	 * 方法名称: addAfterDelete<br>
	 * 描述： 删除旧数据后添加
	 * 作者: lihengjun
	 * 修改日期：2014年1月13日下午3:46:55
	 * @param geProductInsuredconfigDB 需要删除的数据库数据
	 * @param geProductInsuredconfig 需要入库的数据
	 */
	@ECSOperator(operator="删除被保人配置中关联职业,然后添加信息关联职业")
	public void addAfterDelete(GeProductInsuredconfig geProductInsuredconfigDB,GeProductInsuredconfig geProductInsuredconfig) {
		if(geProductInsuredconfigDB!=null){
			List<GeProInsuredOccupation> proInsuredOccupationsDB = geProductInsuredconfigDB.getGeProInsuredOccupations();
			for (int i = 0; proInsuredOccupationsDB!=null&&i < proInsuredOccupationsDB.size(); i++) {
				GeProInsuredOccupation occ = proInsuredOccupationsDB.get(i);
				occ.setGeProductInsuredconfig(null);
				this.delete(occ);
			}
			geProductInsuredconfigDB.setGeProInsuredOccupations(null);
		}
		if(geProductInsuredconfig!=null){
			List<GeProInsuredOccupation> proInsuredOccupations = geProductInsuredconfig.getGeProInsuredOccupations();
			for (int i = 0; proInsuredOccupations!=null&&i < proInsuredOccupations.size(); i++) {
				GeProInsuredOccupation proInsuredOccupation = proInsuredOccupations.get(i);
				
				if(geProductInsuredconfigDB!=null){
					proInsuredOccupation.setGeProductInsuredconfig(geProductInsuredconfigDB);
				}else{
					proInsuredOccupation.setGeProductInsuredconfig(geProductInsuredconfig);
				}
				//this.save(proInsuredOccupation); 统一进行保存
			}
		}
	}
	
	public GeProInsuredOccupation findUnique(QueryRule queryRule) {
		return super.findUnique(queryRule);
	}
	
	public List<GeProInsuredOccupation> getAll() {
		return super.getAll(entityClass);
	}
	@ECSOperator(operator="添加被保人关联职业")
	public void add(GeProInsuredOccupation geProInsuredOccupation) {
		super.save(geProInsuredOccupation);
	}
	@ECSOperator(operator="更新被保人关联职业")
	public void update(GeProInsuredOccupation geProInsuredOccupation) {
		super.update(geProInsuredOccupation);
	}

	public GeProInsuredOccupation get(String pk) {
		return this.get(pk);
	}
	@ECSOperator(operator="删除被保人关联职业")
	public void delete(GeProInsuredOccupation geProInsuredOccupation) {
		super.delete(geProInsuredOccupation);
	}

	
	
}

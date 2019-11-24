package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeOccupation;
import cn.com.sinosoft.domain.product.GeProInsuredOccupation;
import cn.com.sinosoft.domain.product.GeProductInsuredconfig;

public interface ProInsuredOccupationService {
	/**
	 * 方法名称: addAfterDelete<br>
	 * 描述： 删除旧数据后添加
	 * 作者: lihengjun
	 * 修改日期：2014年1月13日下午3:46:55
	 * @param geProductInsuredconfigDB 需要删除的数据库数据
	 * @param geProductInsuredconfig 需要入库的数据
	 */
	public void addAfterDelete(GeProductInsuredconfig geProductInsuredconfigDB,GeProductInsuredconfig geProductInsuredconfig);
	/**
	 * 方法名称: findByInsuredConfigno<br>
	 * 描述：根据被保人配置序号查询 已经配置的职业
	 * 作者: partrick
	 * 修改日期：2014年1月13日下午1:38:50
	 * @param insuredconfigno
	 * @return
	 */
	public List<GeProInsuredOccupation> findByInsuredConfigno(String insuredconfigno) ;
	public List<GeProInsuredOccupation> findByQuery(QueryRule Query);
	
	public GeProInsuredOccupation findUnique(QueryRule queryRule);
	
	public List<GeProInsuredOccupation> getAll() ;

	public void add(GeProInsuredOccupation geOccupation);

	public void update(GeProInsuredOccupation geOccupation);

	public GeProInsuredOccupation get(String pk) ;

	public void delete(GeProInsuredOccupation geOccupation) ;


}
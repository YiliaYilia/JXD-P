package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeOccupation;
import cn.com.sinosoft.dto.product.OccupationTree;

public interface OccupationService {

	/**
	 * 方法名称: findOccupationTree<br>
	 * 描述：根据被保人配置序号 查询 职业树
	 * 作者: lihengjun
	 * 修改日期：2014年1月13日下午1:58:55
	 * @param insuredconfigno
	 * @return
	 */
	public List<OccupationTree> findOccupationTree(String insuredconfigno);
	public List<GeOccupation> findByQuery(QueryRule Query);
	
	public GeOccupation findUnique(QueryRule queryRule);
	
	public List<GeOccupation> getAll() ;

	public void add(GeOccupation geOccupation);

	public void update(GeOccupation geOccupation);

	public GeOccupation get(String pk) ;

	public void delete(GeOccupation geOccupation) ;


}
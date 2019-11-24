package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeProdutyExtend;


public interface ProdutyExtendService {
	
public List<GeProdutyExtend> findByQuery(QueryRule Query);
	
	public void deleteByDutyId(String dutyId);
	
	public void add(GeProdutyExtend allow);
	
	public void update(GeProdutyExtend allow);
	
	public GeProdutyExtend findByPk(String pk);
	
	public void delete(GeProdutyExtend allow);
	
}

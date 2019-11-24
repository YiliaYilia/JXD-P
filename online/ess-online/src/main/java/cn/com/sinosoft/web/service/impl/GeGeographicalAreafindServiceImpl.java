package cn.com.sinosoft.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeGeographicalArea;
import cn.com.sinosoft.web.service.facade.GeGeographicalAreafindService;
@Component
public class GeGeographicalAreafindServiceImpl extends GenericHibernateDao<GeGeographicalArea, Integer> implements GeGeographicalAreafindService {
	private static final Logger log = LoggerFactory.getLogger(GeGeographicalAreafindServiceImpl.class);
	 
	@Override
	public String findArea_code(String area_name ,String area_status) {
		QueryRule query=QueryRule.getInstance();
		query.addEqual("area_name",area_name);
		query.addEqual("area_status",area_status);
		GeGeographicalArea area = super.findUnique(query);
		if(area !=null){
			log.info("省市编码转换成功");
			return area.getArea_code();
		}else{
			return null;
		}
	}

}

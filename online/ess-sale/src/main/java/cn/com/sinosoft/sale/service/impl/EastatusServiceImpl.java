package cn.com.sinosoft.sale.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeEaccoutStatus;
import cn.com.sinosoft.sale.service.EastatusService;

@Component
public class EastatusServiceImpl extends GenericHibernateDao<GeEaccoutStatus,String>  implements EastatusService {

	
	public static Logger logger = LoggerFactory.getLogger(EastatusServiceImpl.class);
	private static SimpleDateFormat dateLine = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@Override
	public GeEaccoutStatus findStatus() {
		String eadate = dateLine.format(new Date());
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("eadate", eadate);
		return super.findUnique(queryRule);
	}
	

	@Override
	public void saveStatus(GeEaccoutStatus eaccoutStatus) {
		super.save(eaccoutStatus);
		
	}

	


	
	
}

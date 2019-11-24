package cn.com.sinosoft.web.service.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.common.service.axis.LifeADTPLocator;
import cn.com.sinosoft.common.service.axis.LifeADTPModel;
import cn.com.sinosoft.common.service.axis.LifeADTPPortType;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.user.GePolicyCodeConfig;
import cn.com.sinosoft.web.service.facade.LifeADTPService;

@Component
public class LifeADTPServiceImpl  extends GenericHibernateDao<GePolicyCodeConfig, String> implements LifeADTPService{
	private static Log logger = LogFactory.getLog(LifeADTPServiceImpl.class);		

	@Override
	public LifeADTPModel getLifeADTP(String policyNo, String amount) throws Exception {
		LifeADTPLocator service = new LifeADTPLocator();
		LifeADTPModel result = new LifeADTPModel();
		try {
			LifeADTPPortType lifeType = service.getLifeADTPHttpSoap11Endpoint();
			logger.info("投资追加："+"保单号："+policyNo+"|追加金额"+amount);
			result =  lifeType.getLifeADTP(policyNo, amount);
		}catch(Exception e){
			logger.error("投资追加",e);
		}
		return result;
	}	
}

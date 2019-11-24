package cn.com.sinosoft.ess.config.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.msl.MslInsuranceRate;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.ess.config.service.MslInsuranceRateService;

@Component
@Service("mslInsuranceRateService")
public class MslInsuranceRateServiceImpl extends GenericHibernateDao<MslInsuranceRate,String> implements MslInsuranceRateService{

//	@Override
//	public double getBasePremium(String prodoctCode, int PayPeriodNumber) {
//	
//		QueryRule queryRule=QueryRule.getInstance();
//		queryRule.addEqual("prodoctCode", prodoctCode);
//		queryRule.addEqual("payPeriodNumber", PayPeriodNumber);
//		MslInsuranceRate rate = super.findUnique(queryRule);
//		return rate == null?null:rate.getBasePremium() ;
//	}

	@Override
	public MslInsuranceRate getSumInsured(String prodoctCode, String number,
			String type) {
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("prodoctCode", prodoctCode);
		queryRule.addEqual("policyPeriodNumber", number);
		queryRule.addEqual("policyPeriodType", type);
		return super.findUnique(queryRule);
	}

}

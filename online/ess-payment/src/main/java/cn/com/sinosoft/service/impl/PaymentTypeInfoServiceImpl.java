package cn.com.sinosoft.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.payment.GePaymentTypeInfo;
import cn.com.sinosoft.service.PaymentTypeInfoService;

@Component
public class PaymentTypeInfoServiceImpl  extends GenericHibernateDao<GePaymentTypeInfo,String> implements PaymentTypeInfoService {

	@Override
	public List<GePaymentTypeInfo> findByLoginWayCode(String loginWay) {
		if(null == loginWay){
			return null;
		}
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("loginWayCode", loginWay);
		return super.find(queryRule);
	}

}

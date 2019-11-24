package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.domain.sale.GeRXinsurancecashvalue;

public interface GeRXinsurancecashvaluefindService {
	GeRXinsurancecashvalue findRXinsurancecashvalue(String paymentperiod,String sex, String insuredage,String endyear);
}

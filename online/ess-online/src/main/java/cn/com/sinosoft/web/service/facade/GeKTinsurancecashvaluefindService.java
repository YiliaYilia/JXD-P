package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.domain.sale.GeKTinsurancecashvalue;

public interface GeKTinsurancecashvaluefindService {
	GeKTinsurancecashvalue findKTinsurancecashvalue(String paymentperiod,String sex, String insuredage,String endyear);
}

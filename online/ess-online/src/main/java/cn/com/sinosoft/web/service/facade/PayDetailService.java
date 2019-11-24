package cn.com.sinosoft.web.service.facade;

import java.util.List;

import cn.com.sinosoft.common.service.axis.PayDeatilModel;

public interface PayDetailService {
	public  List<PayDeatilModel> getPayDetail(String policyNo);
}

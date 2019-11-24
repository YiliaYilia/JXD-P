package cn.com.sinosoft.web.service.facade;

import java.util.List;

import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;

public interface ChangebankfindWechatPolicyService {
  List<GeOrder> findpolicybypolicyNo(String policyNo);
}

package cn.com.sinosoft.product.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.sell.GeAccount;
import cn.com.sinosoft.domain.sell.GeChangepolicy;
@Component
public interface bankQueryService {
 Page<GeChangepolicy> findbank(String policyno,String applicantname,Date starttime,Date endtime,int  pageNo,int pageSize);

 public List<GeChangepolicy> getAllGeChangepolicy(String policyno,String applicantname,Date starttime, Date endtime);
}

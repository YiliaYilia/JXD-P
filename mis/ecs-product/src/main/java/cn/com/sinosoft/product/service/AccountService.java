package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.sell.GeAccount;

public abstract interface AccountService{
	
  public Page<GeAccount> getAccount(GeAccount geAccount, int paramInt1, int paramInt2);
  
  public List<GeAccount> getAllAccount(String ordercode,String applicantname,String productname,String starttime,String endtime);
  
  
}

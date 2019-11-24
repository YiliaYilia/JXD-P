package cn.com.sinosoft.product.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.sell.GeAccount;
import cn.com.sinosoft.product.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceIpml extends GenericHibernateDao<GeAccount, String>
  implements AccountService
{
  public Page<GeAccount> getAccount(GeAccount geAccount, int page, int rows)
  {
    QueryRule queryRule = QueryRule.getInstance(); 
    if(geAccount!=null){
		if(!StringUtils.isEmpty(geAccount.getOrdercode())){
			queryRule.addLike("ordercode", "%"+geAccount.getOrdercode()+"%");
		}
		if(!StringUtils.isEmpty(geAccount.getProductname())){
			queryRule.addLike("productname", "%"+geAccount.getProductname()+"%");
		}
		if(!StringUtils.isEmpty(geAccount.getApplicantname())){
			queryRule.addLike("applicantname", "%"+geAccount.getApplicantname()+"%");
		}
		if(geAccount.getStarttime()!=null&&geAccount.getStarttime().length()>0){
			queryRule.addGreaterEqual("paytime",geAccount.getStarttime()+" 00:00:00");
		}
		if(geAccount.getEndtime()!=null&&geAccount.getEndtime().length()>0){
			queryRule.addLessEqual("paytime",geAccount.getEndtime()+" 23:59:59");
		}
	}
    queryRule.addDescOrder("paytime");
    return find(queryRule, page, rows);
  }

public List<GeAccount> getAllAccount(String ordercode, String applicantname,String productname, String starttime, String endtime) {
	QueryRule queryRule = QueryRule.getInstance();
	if(!StringUtils.isEmpty(ordercode)){
		queryRule.addLike("ordercode", "%"+ordercode+"%");
	}
	if(!StringUtils.isEmpty(applicantname)){
		queryRule.addLike("applicantname", "%"+applicantname+"%");
	}
	if(!StringUtils.isEmpty(productname)){
		queryRule.addEqual("productname", productname);
	}
	if(!StringUtils.isEmpty(starttime)){
		  try {
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
			    Date date = fmt.parse(starttime);
			    queryRule.addGreaterEqual("paytime",date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	if(!StringUtils.isEmpty(endtime)){
		try {
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
			    Date date = fmt.parse(endtime);
			    Calendar calendar = Calendar.getInstance();
			    calendar.setTime(date);
			    calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
			    queryRule.addLessEqual("paytime",calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	queryRule.addDescOrder("paytime");
	return super.find(queryRule);
}
  
  
  
}
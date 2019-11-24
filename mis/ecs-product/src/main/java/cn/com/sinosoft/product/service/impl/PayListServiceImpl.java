package cn.com.sinosoft.product.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.sell.GePayList;
import cn.com.sinosoft.product.service.PayListService;

@Component
public class PayListServiceImpl extends GenericHibernateDao<GePayList,String> implements PayListService {

	public Page<GePayList> getPayList(GePayList gePayList, int page, int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(gePayList != null){
			if(!StringUtils.isEmpty(gePayList.getOrderid())){
				queryRule.addLike("orderid","%"+gePayList.getOrderid());
			}
//			if(!StringUtils.isEmpty(gePayList.getApplicantname())){
//				queryRule.addLike("applicantname","%"+gePayList.getApplicantname());
//			}
//			if(!StringUtils.isEmpty(gePayList.getPolicyno())){
//				queryRule.addLike("policyno","%"+gePayList.getPolicyno());
//			}
			//搜索条件：是否退款
			if(!StringUtils.isEmpty(gePayList.getIsback())){
				queryRule.addLike("isback","%"+gePayList.getIsback());
			}
			if(gePayList.getStarttime()!=null){
				queryRule.addGreaterEqual("paytime",gePayList.getStarttime());
			}
			if(gePayList.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(gePayList.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("paytime",calendar.getTime());
			}
		}
		queryRule.addDescOrder("paytime");
		return this.find(queryRule, page, rows);
	}

	public List<GePayList> getAllPayList(String policyno,String orderid,String applicantname,String isback,String starttime,String endtime) {
		QueryRule queryRule = QueryRule.getInstance();
		if(!StringUtils.isEmpty(policyno)){
			queryRule.addLike("policyno", "%"+policyno+"%");
		}
		if(!StringUtils.isEmpty(orderid)){
			queryRule.addLike("orderid", "%"+orderid+"%");
		}
		if(!StringUtils.isEmpty(applicantname)){
			queryRule.addLike("applicantname", "%"+applicantname+"%");
		}
		if(!StringUtils.isEmpty(isback)){
			queryRule.addEqual("isback", isback);
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

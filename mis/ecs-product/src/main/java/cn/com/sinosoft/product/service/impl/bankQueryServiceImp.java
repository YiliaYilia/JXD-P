package cn.com.sinosoft.product.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sell.GeChangepolicy;
import cn.com.sinosoft.product.service.bankQueryService;
@Component
public class bankQueryServiceImp extends GenericHibernateDao<GeChangepolicy,String> implements bankQueryService {
	
	
	@Override
	public Page<GeChangepolicy> findbank(String policyno, String applicantname, Date starttime, Date endtime,int pageNo, int pageSize) {
		if(endtime!=null){
			Calendar instance = Calendar.getInstance();
			instance.setTime(endtime);
			instance.add(Calendar.DAY_OF_MONTH,1);
			endtime= instance.getTime();
		}
		Date[] translate ={starttime,endtime};
		QueryRule query = QueryRule.getInstance();
		
		if(policyno!=null){
			query.addEqual("policyno", policyno);
		}
		if(applicantname!=null){
			query.addEqual("applicantname", applicantname);
		}
		if(translate[0]!=null&&translate[1]!=null){
			query.addBetween("updateTime",translate);
		}else if(translate[0]!=null){
			query.addGreaterEqual("updateTime",translate[0]);
		}else if(translate[1]!=null){
			query.addLessEqual("updateTime",translate[1]);
		}
		query.addDescOrder("updateTime");
		return super.find(query,pageNo,pageSize);
	}

	@Override
	public List<GeChangepolicy> getAllGeChangepolicy(String policyno, String applicantname, Date starttime, Date endtime) {
		if(endtime!=null){
			Calendar instance = Calendar.getInstance();
			instance.setTime(endtime);
			instance.add(Calendar.DAY_OF_MONTH,1);
			endtime= instance.getTime();
		}
		Date[] translate ={starttime,endtime};
		QueryRule query = QueryRule.getInstance();
		
		if(policyno!=null){
			query.addEqual("policyno", policyno);
		}
		if(applicantname!=null){
			query.addEqual("applicantname", applicantname);
		}
		if(translate[0]!=null&&translate[1]!=null){
			query.addBetween("updateTime",translate);
		}else if(translate[0]!=null){
			query.addGreaterEqual("updateTime",translate[0]);
		}else if(translate[1]!=null){
			query.addLessEqual("updateTime",translate[1]);
		}
		query.addDescOrder("updateTime");
		return super.find(query);
	}

	


	





}
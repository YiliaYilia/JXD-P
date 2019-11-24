package cn.com.sinosoft.user.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.system.GeMobileCustomerChange;
import cn.com.sinosoft.domain.system.MobileCustomer;
import cn.com.sinosoft.user.service.MobileCustomerChangeService;

@Service
public class MobileCustomerChangeServiceImpl extends GenericHibernateDao<GeMobileCustomerChange, String> implements MobileCustomerChangeService {
	
	@SuppressWarnings("unchecked")
	public Page<GeMobileCustomerChange> getAllOfPaging(GeMobileCustomerChange geMobileCustomerChange,int pageNumber, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geMobileCustomerChange!=null){
			if(!StringUtils.isEmpty(geMobileCustomerChange.getIdnumber())){
				queryRule.addLike("idnumber", "%"+geMobileCustomerChange.getIdnumber()+"%");
			}
			if(!StringUtils.isEmpty(geMobileCustomerChange.getName())){
				queryRule.addLike("name", "%"+geMobileCustomerChange.getName()+"%");
			}
			if(!StringUtils.isEmpty(geMobileCustomerChange.getStarttime())){
				queryRule.addGreaterEqual("updatetime", geMobileCustomerChange.getStarttime());
			}
			if(!StringUtils.isEmpty(geMobileCustomerChange.getEndtime())){
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date endTime;
				try {
					endTime = sdf.parse(geMobileCustomerChange.getEndtime());
					calendar.setTime(endTime);
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					String strEndtime = sdf.format(calendar.getTime());
					queryRule.addLessEqual("updatetime", strEndtime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return this.find(entityClass,queryRule, pageNumber, pageSize);
	}

	public List<GeMobileCustomerChange> getAll() {
		return this.getAll(entityClass, false);
	}
	
	
}

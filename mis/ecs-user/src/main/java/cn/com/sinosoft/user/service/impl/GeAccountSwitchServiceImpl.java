package cn.com.sinosoft.user.service.impl;

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
import cn.com.sinosoft.domain.system.GeAccountSwitch;
import cn.com.sinosoft.user.service.GeAccountSwitchService;

@Component
public class GeAccountSwitchServiceImpl extends GenericHibernateDao<GeAccountSwitch, String> implements GeAccountSwitchService {
	
	@SuppressWarnings("unchecked")
	
	
	public Page<GeAccountSwitch> findList(String policynum,int pageNumber, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("policynum", policynum);
		return this.find(entityClass,queryRule, pageNumber, pageSize);
	}

	
	
	public List<GeAccountSwitch> findAll() {
		return super.getAll(entityClass, false);
	}
	
	

	@Override
	public Page<GeAccountSwitch> findList1(GeAccountSwitch geAccountSwitch,
			int pageNumber, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geAccountSwitch!=null){
			if(!StringUtils.isEmpty(geAccountSwitch.getPolicynum())){
				queryRule.addLike("policynum", "%"+geAccountSwitch.getPolicynum()+"%");
			}
			if(!StringUtils.isEmpty(geAccountSwitch.getProductName())){
				queryRule.addLike("productName", "%"+geAccountSwitch.getProductName()+"%");
			}
			if(!StringUtils.isEmpty(geAccountSwitch.getAccountName())){
				queryRule.addLike("accountName", "%"+geAccountSwitch.getAccountName()+"%");
			}
			if(!StringUtils.isEmpty(geAccountSwitch.getStarttime())){
				queryRule.addGreaterEqual("makedate", geAccountSwitch.getStarttime());
			}
			if(!StringUtils.isEmpty(geAccountSwitch.getEndtime())){
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date endTime;
				try {
					endTime = sdf.parse(geAccountSwitch.getEndtime());
					calendar.setTime(endTime);
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					String strEndtime = sdf.format(calendar.getTime());
					queryRule.addLessEqual("makedate", strEndtime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		queryRule.addDescOrder("makedate");
		return this.find(queryRule, pageNumber, pageSize);
	}



	@Override
	public List<GeAccountSwitch> findAll(GeAccountSwitch geAccountSwitch) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geAccountSwitch!=null){
			if(!StringUtils.isEmpty(geAccountSwitch.getPolicynum())){
				queryRule.addLike("policynum", "%"+geAccountSwitch.getPolicynum()+"%");
			}
			if(!StringUtils.isEmpty(geAccountSwitch.getProductName())){
				queryRule.addLike("productName", "%"+geAccountSwitch.getProductName()+"%");
			}
			if(!StringUtils.isEmpty(geAccountSwitch.getAccountName())){
				queryRule.addLike("accountName", "%"+geAccountSwitch.getAccountName()+"%");
			}
			if(geAccountSwitch.getStarttime()!=null){
				queryRule.addGreaterEqual("makedate", geAccountSwitch.getStarttime());
			}
			if(geAccountSwitch.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date endTime;
				try {
					endTime = sdf.parse(geAccountSwitch.getEndtime());
					calendar.setTime(endTime);
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					String strEndtime = sdf.format(calendar.getTime());
					queryRule.addLessEqual("makedate", strEndtime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		queryRule.addDescOrder("makedate");
		return this.find(queryRule);
	}



}

package cn.com.sinosoft.sale.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.sale.service.PolicyService;

@Component
public class PolicyServiceImpl extends GenericHibernateDao<GePolicy, String> implements PolicyService {
	@Override
	public boolean findPolicyByOpenidAndCode(String openId, String preferentialcode) {
		Query query=getSession().createQuery("from GePolicy g where g.preferentialcode='"+preferentialcode+"' and g.openid='"+openId+"' and  policycode is not null");
		return query.list().size()>0;
	}
	private static Logger log = LoggerFactory.getLogger(PolicyServiceImpl.class);

	/**
	 * 银保通对账  查询当天生效的保单
	 * 修改为 不包括银行代扣
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GePolicy> findGePolicyList() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datenow = simpleDateFormat.format(new Date());
		Date now=null;
		try {
			now = simpleDateFormat.parse(datenow);
		} catch (ParseException e) {
			log.info("格式化异常");
			e.printStackTrace();
		}
		Calendar instance = Calendar.getInstance();
		instance.setTime(now);
		instance.set(Calendar.DATE, instance.get(Calendar.DATE) + 1);
		String  yesterday = simpleDateFormat.format(instance.getTime());
		log.info("datenow:"+datenow);
//		datenow = "2017-11-07";  //银保通11-06对账
//		yesterday = "2017-11-08";
//		log.info("yesterday:"+yesterday);
//	Query queryRule = getSession().createQuery("from GePolicy g WHERE g.takeeffecttime between '"+datenow+"' and '"+yesterday+"' and (g.billingtype<>'Y' or g.billingtype is not null)");
	Query queryRule = getSession().createQuery("from GePolicy g WHERE g.takeeffecttime>='"+datenow+"' and g.takeeffecttime<'"+yesterday+"' and (g.billingType<>'Y' or g.billingType is null)");
	List<GePolicy> list = queryRule.list();
//		queryRule.addSql("takeeffecttime between trunc(sysdate) and trunc(sysdate+1)-0.00001 and (billingtype<>'Y' or billingtype is null)");
		log.info("list:"+list.size());
		log.info("时间："+list.get(0).getTakeeffecttime());
		return list;
	}
}

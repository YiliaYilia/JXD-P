package cn.com.sinosoft.user.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.system.DateChangeData;
import cn.com.sinosoft.user.service.DateChangeDataService;

@Component
public class DateChangeDataServiceImpl extends GenericHibernateDao<DateChangeData, String>
		implements DateChangeDataService {
	@SuppressWarnings("unchecked")

	public Page<DateChangeData> findList(DateChangeData dateChangeData, int pageNumber, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		if (dateChangeData != null) {
			if (!StringUtils.isEmpty(dateChangeData.getCardNo())) {
				queryRule.addEqual("cardNo", dateChangeData.getCardNo());
			}
			if (dateChangeData.getStarttime() != null) {
				queryRule.addGreaterEqual("updatetime", dateChangeData.getStarttime());
			}
			if (dateChangeData.getEndtime() != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dateChangeData.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);// 加一天
				queryRule.addLessEqual("updatetime", calendar.getTime());
			}
			queryRule.addDescOrder("updatetime");
		}

		return this.find(entityClass, queryRule, pageNumber, pageSize);

	}

	
	
	
	public List<DateChangeData> findAll() {
		return super.getAll(entityClass, false);
	}


	@Override
	public List<DateChangeData> finList(DateChangeData changeData) {
		QueryRule queryRule = QueryRule.getInstance();
		if (changeData != null) {
			if (!StringUtils.isEmpty(changeData.getCardNo())) {
				queryRule.addEqual("cardNo", changeData.getCardNo());
			}
			if (changeData.getStarttime() != null) {
				queryRule.addGreaterEqual("updatetime", changeData.getStarttime());
			}
			if (changeData.getEndtime() != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(changeData.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);// 加一天
				queryRule.addLessEqual("updatetime", calendar.getTime());
			}
			queryRule.addDescOrder("updatetime");
		}

		return this.find(entityClass, queryRule);
	}
}

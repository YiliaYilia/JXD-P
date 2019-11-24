package cn.com.sinosoft.web.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.user.DateChangeData;
import cn.com.sinosoft.web.service.facade.DateChangeDataService;

@Service
public class DateChangeDataServiceImpl extends GenericHibernateDao<DateChangeData, String> implements DateChangeDataService{
	private final static Logger logger = LoggerFactory.getLogger(DateChangeDataServiceImpl.class);
	public void saveOrUpdate(String propertyName, Object value,DateChangeData dateChangeData){
		DateChangeData temp = this.findUnique(propertyName,value);
		if(temp != null){
			temp.setExpiredDate(dateChangeData.getExpiredDate());//更改日期
			temp.setCardNo(dateChangeData.getCardNo());//更改卡号
			temp.setCardType(dateChangeData.getCardType());//卡类型
			temp.setChangeType(dateChangeData.getChangeType());//变更主体
			temp.setUpdatetime(dateChangeData.getUpdatetime());//更新时间
			temp.setSinoImageFlag(dateChangeData.getSinoImageFlag());//影像上传标志
			this.update(temp);
		}else{
			this.save(dateChangeData);
		}
	}
	
	public void saveImagePath(String propertyName, Object value,DateChangeData dateChangeData,String type){
		DateChangeData temp = this.findUnique(propertyName,value);
		if(temp != null){
			temp.setCoustomerid(dateChangeData.getCoustomerid());//因为约束设置主键
			if(type == null){
				temp.setFront(dateChangeData.getFront());
				temp.setContrary(dateChangeData.getContrary());
			}else {
				if(type.equals("front")){
					temp.setFront(dateChangeData.getFront());
				}else if(type.equals("contrary")){
					temp.setContrary(dateChangeData.getContrary());
				}
			}
			this.update(temp);
		}else{
			this.save(dateChangeData);
		}
	}

	public DateChangeData getOne(String propertyName, Object value) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual(propertyName,value);
		return this.findUnique(queryRule);
	}

	@Override
	public List<DateChangeData> getDateChangeDataByTime(Date startTime,Date endTime,String sinoImageFlag) {
		QueryRule queryRule = QueryRule.getInstance();
		if (!StringUtils.isEmpty(startTime.toString())) {
			queryRule.addGreaterEqual("updatetime", startTime);
		}
		if (!StringUtils.isEmpty(endTime.toString())) {
			/*Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateChangeData.getEndtime());
			calendar.add(Calendar.DAY_OF_MONTH, 1);// 加一天*/
			queryRule.addLessEqual("updatetime", endTime);
		}
		if (!StringUtils.isEmpty(sinoImageFlag)) {
			if("0".equals(sinoImageFlag)){
				queryRule.addIsNull("sinoImageFlag");
			}else{
				queryRule.addEqual("sinoImageFlag", sinoImageFlag);
			}
		}
		queryRule.addDescOrder("updatetime");
		return this.find(queryRule);
	}
}

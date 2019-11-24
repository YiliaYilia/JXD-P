package cn.com.sinosoft.web.service.facade;

import java.util.Date;
import java.util.List;

import cn.com.sinosoft.domain.user.DateChangeData;

public interface DateChangeDataService {

	public abstract void saveOrUpdate(String propertyName, Object value,
			DateChangeData dateChangeData);

	public abstract void saveImagePath(String propertyName, Object value,DateChangeData dateChangeData,String type);
	
	public abstract DateChangeData getOne(String propertyName, Object value);
	
	/**
	 * 根据时间查询证件变更列表
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param sinoImageFlag 是否上传影像系统，1代表对作为投保人的保单进行影像上传，0代表否，2代表作为投被保人的保单均上传
	 * @return
	 */
	public List<DateChangeData> getDateChangeDataByTime(Date startTime,Date endTime,String sinoImageFlag);
}
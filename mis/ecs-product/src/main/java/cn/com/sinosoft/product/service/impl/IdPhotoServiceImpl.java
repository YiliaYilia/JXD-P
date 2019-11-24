package cn.com.sinosoft.product.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Component;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.sell.IdPhotoData;
import cn.com.sinosoft.product.service.IdPhotoService;

@Component
public class IdPhotoServiceImpl extends GenericHibernateDao<IdPhotoData, String> implements IdPhotoService {
	
	private static SimpleDateFormat uploadate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Override
	public Page<IdPhotoData> findList(IdPhotoData idPhotoData, int pageNumber, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		if (idPhotoData != null) {
			if (!StringUtils.isEmpty(idPhotoData.getProposalContNo())) {
				queryRule.addEqual("proposalContNo", idPhotoData.getProposalContNo());
			}
			if (idPhotoData.getStarttime() != null) {
				queryRule.addGreaterEqual("uploadTime", uploadate.format(idPhotoData.getStarttime()));
			}
			if (idPhotoData.getEndtime() != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(idPhotoData.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);// 加一天
				queryRule.addLessEqual("uploadTime", uploadate.format(calendar.getTime()));
			}
		}
		queryRule.addDescOrder("uploadTime");
		return this.find(entityClass, queryRule, pageNumber, pageSize);
	}

	@Override
	public List<IdPhotoData> findAllIdPhoto(IdPhotoData idPhotoData) {
		QueryRule queryRule = QueryRule.getInstance();
		if (idPhotoData != null) {
			if(!StringUtils.isEmpty(idPhotoData.getId())){
				queryRule.addEqual("id", idPhotoData.getId());
			}
			if (!StringUtils.isEmpty(idPhotoData.getProposalContNo())) {
				queryRule.addEqual("proposalContNo", idPhotoData.getProposalContNo());
			}
			if (idPhotoData.getStarttime() != null) {
				queryRule.addGreaterEqual("uploadTime", uploadate.format(idPhotoData.getStarttime()));
			}
			if (idPhotoData.getEndtime() != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(idPhotoData.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);// 加一天
				queryRule.addLessEqual("uploadTime", uploadate.format(calendar.getTime()));
			}
		}
		queryRule.addDescOrder("uploadTime");
		return this.find(entityClass, queryRule);
	}
}

package cn.com.sinosoft.web.service.impl;

import org.springframework.stereotype.Component;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.user.IdPhotoData;
import cn.com.sinosoft.web.service.facade.IdPhotoDataService;

@Component
public class IdPhotoDataServiceImpl extends GenericHibernateDao<IdPhotoData, Integer> implements IdPhotoDataService{

	@Override
	public void saveIdPhotoData(IdPhotoData IdPhotoData) {
		super.save(IdPhotoData);
	}

}

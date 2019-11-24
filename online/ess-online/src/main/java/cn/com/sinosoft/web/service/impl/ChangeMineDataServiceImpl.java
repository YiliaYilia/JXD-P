package cn.com.sinosoft.web.service.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.user.ChangeMineData;
import cn.com.sinosoft.web.service.facade.ChangeMineDataService;
@Service
public class ChangeMineDataServiceImpl extends GenericHibernateDao<ChangeMineData, String> implements ChangeMineDataService {

	public void saveOrUpdate(String propertyName, Object value,
			ChangeMineData changeMineData) {
		ChangeMineData temp = this.findUnique(propertyName,value);
		if(temp != null){
			Session session = this.getSession();
			temp  = (ChangeMineData) session.merge(changeMineData);
			this.update(temp);
		}else{
			this.save(changeMineData);
		}
	}

}

package cn.com.sinosoft.web.service.impl;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.user.GeResources;
import cn.com.sinosoft.web.service.facade.ResourceService;

/**
 * 资源业务处理
 * @author Yunxia.Guo
 *
 */
@Component
public class ResourceServiceImpl extends GenericHibernateDao<GeResources, String> implements ResourceService{  


	@Override
	public GeResources get(String pk){
		return super.get(pk);
	}

}

package cn.com.sinosoft.web.service.impl;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.sale.GeChangepolicy;
import cn.com.sinosoft.web.service.facade.ChangeBanSavebankchangepolicyrService;
@Component
public class ChangeBanSavebankchangepolicyrServiceImpl extends GenericHibernateDao<GeChangepolicy,String> implements ChangeBanSavebankchangepolicyrService {
	@Override
	public void savechangepolicy(GeChangepolicy changepolicy) {
		super.save(changepolicy);
	}


}

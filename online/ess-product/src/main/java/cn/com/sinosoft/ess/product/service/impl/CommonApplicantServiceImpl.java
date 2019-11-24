package cn.com.sinosoft.ess.product.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeCommonApplicant;
import cn.com.sinosoft.ess.product.service.CommonApplicantService;

@Component
public class CommonApplicantServiceImpl extends GenericHibernateDao<GeCommonApplicant, String>  implements CommonApplicantService {

	@Override
	public GeCommonApplicant findComApplicant(String openId ,String idno,String idType) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("openid", openId);
		queryRule.addEqual("idno", idno);
		queryRule.addEqual("idtype", idType);
		return super.findUnique(queryRule);
		//return super.find(queryRule);
	}

	@Override
	public GeCommonApplicant findComApplicant(String openId ,String idno) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("openid", openId);
		queryRule.addEqual("idno", idno);
		return super.findUnique(queryRule);
		//return super.find(queryRule);
	}
	
	@Override
	public void saveComApplicant(GeCommonApplicant commonApplicant) {
		if(commonApplicant!=null){
			QueryRule queryRule = QueryRule.getInstance();
			queryRule.addEqual("openid", commonApplicant.getOpenid());
		    queryRule.addEqual("idno", commonApplicant.getIdno());
		    queryRule.addEqual("idtype", commonApplicant.getIdtype());
		    GeCommonApplicant commapp = super.findUnique(queryRule);
		    commonApplicant.setCreatetime(new Date());
		    if(commapp!=null){
		    	super.delete(commapp);
		    	super.save(commonApplicant);
		    }else{
		    	super.save(commonApplicant);
		    }
		}
	}
	
	@Override
	public List<GeCommonApplicant> findComApplicantListByOpenId(String openId)
	  {
	    QueryRule queryRule = QueryRule.getInstance();
	    queryRule.addEqual("openid", openId);
	    return super.find(queryRule);
	  }
	
}

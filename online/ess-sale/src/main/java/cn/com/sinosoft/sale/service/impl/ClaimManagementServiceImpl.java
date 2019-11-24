package cn.com.sinosoft.sale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GeClaimManagement;
import cn.com.sinosoft.sale.service.ClaimManagementService;

@Component
public class ClaimManagementServiceImpl extends GenericHibernateDao<GeClaimManagement, String> implements ClaimManagementService {

	@Override
	public void saveClaimManagement(GeClaimManagement claimManagement) {
		super.save(claimManagement);		
	}

	@Override
	public boolean isPolicyCode(GeClaimManagement claimManagement) {
		QueryRule queryRule = QueryRule.getInstance();
		String openId = claimManagement.getOpenId();			
		String policyCode = claimManagement.getPolicyCode();		//保单号
		String type = claimManagement.getClaimManagementType();		//索赔类别
		queryRule.addEqual("policyCode", policyCode);
		queryRule.addEqual("openId", openId);
		queryRule.addEqual("claimManagementType", type);
		List<GeClaimManagement> list=super.find(queryRule);
		if(null != list && list.size()>0){
			return false;
		} else {
			//无未处理
			return true;
		}
	}

	@Override
	public List<GeClaimManagement> findClaimList(GeClaimManagement claimManagement) {
		QueryRule queryRule = QueryRule.getInstance();
		String claimManagementNo = claimManagement.getClaimManagementNo();
		if(null != claimManagementNo && !"".equals(null != claimManagementNo) ){
			//通过id查询
			queryRule.addEqual("claimManagementNo", claimManagement.getClaimManagementNo());	
		} else {
			String openId = claimManagement.getOpenId();
			if(openId == null ){
				return new ArrayList<GeClaimManagement>();
			}
			queryRule.addEqual("openId", openId);
		}
		List<GeClaimManagement> claimManagements=super.find(queryRule);
		return claimManagements;
	}
	
}

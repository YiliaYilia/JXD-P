package cn.com.sinosoft.ess.product.service;

import java.util.List;

import cn.com.sinosoft.domain.sale.GeCommonApplicant;

public interface CommonApplicantService {
	
	public GeCommonApplicant findComApplicant(String openId,String idno,String idType);
	
	public GeCommonApplicant findComApplicant(String openId,String idno);
	
	public void saveComApplicant(GeCommonApplicant commonApplicant);
	
	public abstract List<GeCommonApplicant> findComApplicantListByOpenId(String paramString);
}

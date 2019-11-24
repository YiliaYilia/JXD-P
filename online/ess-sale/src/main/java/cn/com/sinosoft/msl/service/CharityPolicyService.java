package cn.com.sinosoft.msl.service;

import java.util.List;

import cn.com.sinosoft.domain.sale.GeChildlist;

public interface CharityPolicyService {

	 List<GeChildlist> findGeChildlist(GeChildlist geChildlist);

	public void updateAmount(GeChildlist geChild);

	List<GeChildlist> findGeChildOne(String identifynumber);

}

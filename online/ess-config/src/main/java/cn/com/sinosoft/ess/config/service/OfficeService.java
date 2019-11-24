package cn.com.sinosoft.ess.config.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.QueryRule;
//import cn.com.sinosoft.domain.msl.local.MslOffice;

public interface OfficeService {
//	/**
//	 * 根据地区行政代码查询服务网店信息
//	 * @param postalCode 地区行政代码
//	 * @return
//	 */
//	public List<MslOffice>  getOfficeInfo(String postalCode);
	
	/**
	 * 查询机构信息表中所有城市编号
	 * @return
	 */
	public List<String> getOfficeCityCode();
}

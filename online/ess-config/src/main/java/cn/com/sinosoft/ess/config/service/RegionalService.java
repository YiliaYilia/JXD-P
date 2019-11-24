package cn.com.sinosoft.ess.config.service;

import java.util.List;
import cn.com.sinosoft.domain.msl.remote.MslRegion;

public interface RegionalService {
	/**
	 * 查询所有省份信息
	 * @return
	 */
	public List<MslRegion> getPronviceList();
	
	/**
	 * 根据机构信息表中城市编码查询省信息
	 * @param cityCode
	 * @return
	 */
	public List<MslRegion> getPronviceList(List<String> cityCode);
	
	/**
	 * 根据省份查询该省下所有市信息
	 * @param provinceCode 省份地区行政代码
	 * @return
	 */
	public List<MslRegion> getCityList(int provinceCode);
	
	/**
	 * 根据机构信息表中城市编码,省份查询该省下所有市信息
	 * @param provinceCode 省份地区行政代码
	 * @param cityCode 机构信息表中所有城市行政代码
	 * @return
	 */
	public List<MslRegion> getCityList(int provinceCode,List<String> cityCode);
	
	/**
	 * 根据市查询该市下所有区信息
	 * @param provinceCode 省份地区行政代码
	 * @return
	 */
	public List<MslRegion> getDistrictList(int cityCode);
	/**
	 * 则通过Baidu提供的省份,查询满足对应第一条城市的记录.
	 * @param pronviceName
	 * @return
	 */
	public MslRegion getRegionByProvinceName(String pronviceName);
	
	/**
	 * 通过Baidu提供的城市,查询满足对应城市的记录
	 * @param cityName
	 * @return
	 */
	public MslRegion getRegionByCityName(String cityName);
}

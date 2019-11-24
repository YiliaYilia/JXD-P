package cn.com.sinosoft.msl.service;

import java.util.List;

import cn.com.sinosoft.domain.msl.remote.MslRegion;

public interface RegionalOfficeService {

	/**
	 * 地区身份城市初始化
	 * 1.查询所有省份列表,用provinceList.addAll(所有省份)方法
	 * 2.创建MslRegion对象,将默认设置省份为"请选择",城市为"请选择". 
	 * @param provinceList 长度为0的集合表示省份
	 * @param type  "address":表示联系地址变更查询省份，"office":表示服务网店查询省份
	 * @return MslRegion对象, 前端页面将会选中默认的省份和城市.
	 */
	MslRegion regionInit(List<MslRegion> provinceList,String type);

}

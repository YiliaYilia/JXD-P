package cn.com.sinosoft.ess.config.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.msl.remote.MslRegion;
import cn.com.sinosoft.ess.config.service.RegionalService;
@Component
@Service("regionalService")
public class RegionalServiceImpl extends GenericHibernateDao<MslRegion,String> implements RegionalService {
	
	@Autowired
	private SessionFactory interfaceSessionFactory;
	/**
	 * 查询所有省份信息
	 * @return
	 */
	@Override
	public List<MslRegion> getPronviceList() {
		ResourceBundle rb = ResourceBundle.getBundle("config/config");
		if("0".equals(rb.getString("isDebug"))){
			super.setSessionFactory(interfaceSessionFactory);
		}
		SQLQuery sqlquery=getSession().createSQLQuery("select distinct PROV_CD,PROV_NM from TWRK_ADMIN_DIVISION order by PROV_CD");
		List list=sqlquery.list();
		List<MslRegion> msgRegionList = new ArrayList<MslRegion>();
		MslRegion msgRegion =null;
		for(int i=0;i<list.size();i++){
			Object[] temp= (Object[]) list.get(i);
			msgRegion=new  MslRegion();
			msgRegion.setProvinceCode(Integer.parseInt(temp[0].toString()));
			msgRegion.setProvinceName(temp[1].toString());
			msgRegionList.add(msgRegion);
		}
		return msgRegionList ;
	}
	
	
	public List<MslRegion> getPronviceList(List<String> cityCode){
		
		ResourceBundle rb = ResourceBundle.getBundle("config/config");
		if("0".equals(rb.getString("isDebug"))){
			super.setSessionFactory(interfaceSessionFactory);
		}
		String sql="select distinct PROV_CD,PROV_NM from TWRK_ADMIN_DIVISION where CITY_CD in (";
		int size=cityCode.size();
		for(int i=0;i<size;i++){
			if(i==size-1){
				sql += "?";
				break;
			}
			sql += "?,";
		}
		sql	+=" ) order by PROV_CD";
		SQLQuery sqlquery=getSession().createSQLQuery(sql);
		for(int i=0;i<size;i++){
			sqlquery.setInteger(i, Integer.parseInt(cityCode.get(i)));
		}
		List list=sqlquery.list();
		List<MslRegion> msgRegionList = new ArrayList<MslRegion>();
		MslRegion msgRegion =null;
		for(int i=0;i<list.size();i++){
			Object[] temp= (Object[]) list.get(i);
			msgRegion=new  MslRegion();
			msgRegion.setProvinceCode(Integer.parseInt(temp[0].toString()));
			msgRegion.setProvinceName(temp[1].toString());
			msgRegionList.add(msgRegion);
		}
		return msgRegionList ;
	}
	/**
	 * 根据省份查询该省下所有市信息
	 * @param provinceCode 省份地区行政代码
	 * @return
	 */
	@Override
	public List<MslRegion> getCityList(int provinceCode) {
		ResourceBundle rb = ResourceBundle.getBundle("config/config");
		if("0".equals(rb.getString("isDebug"))){
			super.setSessionFactory(interfaceSessionFactory);
		}
		
		String	sql="select distinct CITY_CD,CITY_NM from TWRK_ADMIN_DIVISION where PROV_CD= ? order by CITY_CD";
		SQLQuery sqlquery=getSession().createSQLQuery(sql);
		sqlquery.setInteger(0, provinceCode);
		List list=sqlquery.list();
		List<MslRegion> msgRegionList = new ArrayList<MslRegion>();
		MslRegion msgRegion =null;
		for(int i=0;i<list.size();i++){
			Object[] temp= (Object[]) list.get(i);
			msgRegion=new  MslRegion();
			msgRegion.setCityCode(Integer.parseInt(temp[0].toString()));
			msgRegion.setCityName(temp[1].toString());
			msgRegionList.add(msgRegion);
		}
		
		return  msgRegionList;
	}
	
	@Override
	public List<MslRegion> getCityList(int provinceCode, List<String> cityCode) {
		ResourceBundle rb = ResourceBundle.getBundle("config/config");
		if("0".equals(rb.getString("isDebug"))){
			super.setSessionFactory(interfaceSessionFactory);
		}
		String sql="select distinct CITY_CD,CITY_NM from TWRK_ADMIN_DIVISION where PROV_CD= ?  and CITY_CD in (";
		int size=cityCode.size();
		for(int i=0;i<size;i++){
			if(i==size-1){
				sql += "?";
				break;
			}
			sql += "?,";
		}
		sql	+=" ) order by CITY_CD";
		SQLQuery sqlquery=getSession().createSQLQuery(sql);
		sqlquery.setInteger(0, provinceCode);
		for(int i=1;i<=size;i++){
			sqlquery.setInteger(i, Integer.parseInt(cityCode.get(i-1)));
		}
		List list=sqlquery.list();
		List<MslRegion> msgRegionList = new ArrayList<MslRegion>();
		MslRegion msgRegion =null;
		for(int i=0;i<list.size();i++){
			Object[] temp= (Object[]) list.get(i);
			msgRegion=new  MslRegion();
			msgRegion.setCityCode(Integer.parseInt(temp[0].toString()));
			msgRegion.setCityName(temp[1].toString());
			msgRegionList.add(msgRegion);
		}
		
		return  msgRegionList;
	}
	

	/**
	 * 则通过Baidu提供的省份,查询满足对应第一条城市的记录.
	 * @param pronviceName
	 * @return
	 */
	@Override
	public MslRegion getRegionByProvinceName(String pronviceName) {
		ResourceBundle rb = ResourceBundle.getBundle("config/config");
		if("0".equals(rb.getString("isDebug"))){
			super.setSessionFactory(interfaceSessionFactory);
		}
		QueryRule queryRule= QueryRule.getInstance();
		queryRule.addEqual("provinceName", pronviceName);
		List<MslRegion> list=super.find(queryRule);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 通过Baidu提供的城市,查询满足对应城市的记录
	 * @param cityName
	 * @return
	 */
	@Override
	public MslRegion getRegionByCityName(String cityName) {
		ResourceBundle rb = ResourceBundle.getBundle("config/config");
		if("0".equals(rb.getString("isDebug"))){
			super.setSessionFactory(interfaceSessionFactory);
		}
		QueryRule queryRule= QueryRule.getInstance();
		queryRule.addLike("cityName", "%"+cityName.replace("市","")+"%");
		List<MslRegion> list=super.find(queryRule);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public List<MslRegion> getDistrictList(int cityCode) {
		ResourceBundle rb = ResourceBundle.getBundle("config/config");
		if("0".equals(rb.getString("isDebug"))){
			super.setSessionFactory(interfaceSessionFactory);
		}
		String sql="select distinct CNTY_CD,CNTY_NM from TWRK_ADMIN_DIVISION order by CNTY_CD";
		if(!"".equals(cityCode)){
			sql="select distinct CNTY_CD,CNTY_NM from TWRK_ADMIN_DIVISION where CITY_CD = ?  order by CNTY_CD";
		}
		SQLQuery sqlquery=getSession().createSQLQuery(sql);
		sqlquery.setInteger(0, cityCode);
		List list=sqlquery.list();
		List<MslRegion> msgRegionList = new ArrayList<MslRegion>();
		MslRegion msgRegion =null;
		for(int i=0;i<list.size();i++){
			Object[] temp= (Object[]) list.get(i);
			msgRegion=new  MslRegion();
			msgRegion.setCountyCode(Integer.parseInt(temp[0].toString()));
			msgRegion.setCountyName(temp[1].toString());
			msgRegionList.add(msgRegion);
		}
		return  msgRegionList;
	}

	

}

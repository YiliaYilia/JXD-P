package cn.com.sinosoft.ess.config.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.msl.local.MslOffice;
import cn.com.sinosoft.ess.config.service.OfficeService;

@Component
@Service("officeService")
public class OfficeServiceImpl  extends GenericHibernateDao<MslOffice,String> implements OfficeService {

//	/**
//	 * 根据地区行政代码查询服务网店信息
//	 * @param postalCode 地区行政代码
//	 * @return
//	 */
//	@Override
//	public List<MslOffice> getOfficeInfo(String postalCode) {
//		QueryRule queryRule=QueryRule.getInstance();
//		queryRule.addEqual("zoneNo", postalCode);
//		return super.find(queryRule);
//	}
	
	@Override
	public List<String> getOfficeCityCode() {
		List<String> cityCodeList=new ArrayList<String>();
		String sql="select distinct CITY_CD from  MSL_Office_Info ";
		SQLQuery sqlquery=getSession().createSQLQuery(sql);
		List list=sqlquery.list();
		for(int i=0;i<list.size();i++){
			Object temp= (Object) list.get(i);
			cityCodeList.add((String)temp);
		}
		return cityCodeList;
	}

}

package cn.com.sinosoft.msl.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.sale.GeChildlist;
import cn.com.sinosoft.msl.service.CharityPolicyService;
@Component
public class CharityPolicyServiceImpl  extends GenericHibernateDao<GeChildlist, String>  implements CharityPolicyService {

	@Override
	public List<GeChildlist> findGeChildlist(GeChildlist geChildlist) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String mounth = (cal.get(Calendar.MONTH) + 1)+"";
		if(mounth.length()<2){
			mounth="0"+(cal.get(Calendar.MONTH) + 1)+"-";
		}else{
			mounth = (cal.get(Calendar.MONTH) + 1)+"-";
		}
		String day = cal.get(Calendar.DATE)+"";
		if(day.length()<2){
			day = "0"+cal.get(Calendar.DATE)+"";
		}else{
			day = cal.get(Calendar.DATE)+"";
		}
		String yearE="";
		String yearS="" ;
		QueryRule queryRule = QueryRule.getInstance();
		if(geChildlist!=null){
			if(!StringUtils.isEmpty(geChildlist.getSex())){
				queryRule.addEqual("sex", geChildlist.getSex());
			}
			if(geChildlist.getAge()!=null){
				if(geChildlist.getAge()==3){
					yearE = (year-3)+"-";
					yearS = (year-18)+"-";
					queryRule.addGreaterThan("birthday", yearS+mounth+day);
					queryRule.addLessEqual("birthday", yearE+mounth+day);
				}else{
					 yearE = (year-geChildlist.getAge())+"-";
					 yearS = (year-geChildlist.getAge()-1)+"-";
					queryRule.addGreaterThan("birthday", yearS+mounth+day);
					queryRule.addLessEqual("birthday", yearE+mounth+day);
				}
			}
			if(!StringUtils.isEmpty(geChildlist.getProvince())){
				queryRule.addLike("province", "%"+geChildlist.getProvince()+"%");
			}
		HttpSession session = ServletActionContext.getRequest().getSession();
		GeChildlist geChild = (GeChildlist) session.getAttribute("childInfo");
		if(!StringUtils.isEmpty(geChild.getApplicantinsuredno())){
			queryRule.addNotEqual("applicantinsuredno", geChild.getApplicantinsuredno());
		}
		}
		queryRule.addLessEqual("amount", 499999.99);
		return this.find(queryRule);
	}

	@Override
	public void updateAmount(GeChildlist geChild) {
		this.update(geChild);
	}

	@Override
	public List<GeChildlist> findGeChildOne(String identifynumber) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("identifynumber", identifynumber);
		return this.find(queryRule);
	}


}

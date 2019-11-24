package cn.com.sinosoft.product.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.product.GeInvestment;
import cn.com.sinosoft.product.service.InvestmentService;

@Component
public class InvestmentServiceImpl extends GenericHibernateDao<GeInvestment, String> implements InvestmentService{
	
	/**
	 * 分页查询追加投资
	 */
	@Override
	public Page<GeInvestment> getInvestmentList(GeInvestment geInvestment,int page,int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geInvestment!=null){
			if(!StringUtils.isEmpty(geInvestment.getPolicyNo())){
				queryRule.addLike("policyNo", "%"+geInvestment.getPolicyNo()+"%");
			}
			if(!StringUtils.isEmpty(geInvestment.getApplicantName())){
				queryRule.addLike("applicantName", "%"+geInvestment.getApplicantName()+"%");
			}
			if(geInvestment.getStartTime()!=null){
				queryRule.addGreaterEqual("createTime",geInvestment.getStartTime());
			}
			if(geInvestment.getEndTime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(geInvestment.getEndTime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("createTime",calendar.getTime());
			}
		}
		queryRule.addDescOrder("createTime");
		return this.find(queryRule, page, rows);
	}

	/**
	 * 查询追加投资信息  不分页 导出excel时调用
	 */
	@Override
	public List<GeInvestment> getAllInvestment(GeInvestment geInvestment){
		QueryRule queryRule = QueryRule.getInstance();
		if(geInvestment!=null){
			if(!StringUtils.isEmpty(geInvestment.getPolicyNo())){
				queryRule.addLike("policyNo", "%"+geInvestment.getPolicyNo()+"%");
			}
			if(!StringUtils.isEmpty(geInvestment.getApplicantName())){
				queryRule.addLike("applicantName", "%"+geInvestment.getApplicantName()+"%");
			}
			if(geInvestment.getStartTime()!=null){
				queryRule.addGreaterEqual("createTime",geInvestment.getStartTime());
			}
			if(geInvestment.getEndTime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(geInvestment.getEndTime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("createTime",calendar.getTime());
			}
		}
		queryRule.addDescOrder("createTime");
		return super.find(queryRule);
	}


}

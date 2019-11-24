package cn.com.sinosoft.sale.service.impl;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GePremRate;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.sale.service.PremCalculateService;
import cn.com.sinosoft.util.ArithmeticUtil;

/**
 * 前台输入天数超过30天，匹配单位M，重新计算period值
 * @author guilong
 *
 */
@Component
@Service("premCalculateService")
public class PremCalculateServiceImpl extends GenericHibernateDao<GePremRate, String> implements PremCalculateService  {
	
	/**
	 * @author guilong
	 * 根据保险期间和投保份数计算总保费
	 * @param copies 保险份数，默认为1  ，period  最小一天，最长一年（前台保险期间未选，默认为7天）,periodUnit（天数不超过30单位D，超过30单位为M）
	 * @return
	 */
	public void getSumPrem(GePolicy gePolicy,int copies,int period,String periodUnit){
		if(copies == 0){
			copies = 1;
		}
		String prem = getPolicyPremByPeriod(period,periodUnit);
		String sumPrem = ArithmeticUtil.mul(Double.parseDouble(prem),String.valueOf(copies),2).toString();
		gePolicy.setSumbasepremium(Double.parseDouble(sumPrem));
		gePolicy.setSumpremium(Double.parseDouble(sumPrem));
	}
	
	
	/**
	 * @author guilong
	 *根据保险期间计算险种保费（单张保单）
	 *@param period  最小一天，最长一年（前台保险期间未选，默认为7天）,periodUnit（天数不超过30单位D，超过30单位为M）
	 *@return
	 */
	public String getPolicyPremByPeriod(int period,String periodUnit) {
		QueryRule queryRule =QueryRule.getInstance();
		if(period == 0){
			queryRule.addEqual("periodUnit", "D");
			queryRule.addEqual("effDate", "7");
		}
		if(periodUnit==null || periodUnit.equals("")){
			return "0.00";
		}
		if(periodUnit.equals("M")){
			if(period > 12){
				return "0.00";
			}
			queryRule.addEqual("periodUnit", periodUnit);
			queryRule.addEqual("effDate", String.valueOf(period));
		}if(periodUnit.equals("D")){
			period = convertEffDate(period);
			queryRule.addEqual("periodUnit", periodUnit);
			queryRule.addEqual("effDate", String.valueOf(period));
		}
		List<GePremRate> premRateList = super.find(queryRule);
		if(premRateList.size()==1){
			GePremRate premRate = premRateList.get(0);
			return premRate.getPrem();
		}
		return "0.00";
	}
	
	public int convertEffDate(int period){
		if(period==1){
			period = 0;
		}else if(period>1 && period<=3){
			period = 1;
		}else if(period>3 && period<=7){
			period = 3;
		}else if(period>7 && period<=14){
			period = 7;
		}else{
			period = 14;
		}
		return period;
	}
	
	/**
	 * @author guilong
	 * 获得标准的保险期间及单位（不足30天以period作为天数，periodUnit单位为D；超过30天，重新计算保险期间，periodUnit单位为M。默认为7天 ）
	 */
	public String getStandardPeriod(int period){
		String standardPeriod = "";
		if(period == 0){
			standardPeriod = 7+"&"+"D";
		}if(period > 0 && period <= 30){
			standardPeriod = String.valueOf(period)+"&"+"D";
		}else{
			period = period / 30;
			standardPeriod = String.valueOf(period)+"&"+"M";
		}
		return standardPeriod;
	}
	
	public static void main(String[] args) {
		PremCalculateServiceImpl p = new PremCalculateServiceImpl();
		System.out.println(ArithmeticUtil.mul(Double.parseDouble("12.5"),String.valueOf(7),2).toString());
	}
	
}

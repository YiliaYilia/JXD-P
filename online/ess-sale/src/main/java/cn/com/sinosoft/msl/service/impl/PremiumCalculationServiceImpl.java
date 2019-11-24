package cn.com.sinosoft.msl.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.domain.msl.MslInsuranceRate;
//import cn.com.sinosoft.domain.msl.MslInsuranceRateCCC;
//import cn.com.sinosoft.domain.msl.MslInsuranceRateCDC;
//import cn.com.sinosoft.domain.msl.MslInsuranceRateNBJ;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GePolicy;
//import cn.com.sinosoft.ess.config.service.MslInsuranceRateCCCService;
//import cn.com.sinosoft.ess.config.service.MslInsuranceRateCDCService;
//import cn.com.sinosoft.ess.config.service.MslInsuranceRateNBJService;
import cn.com.sinosoft.ess.config.service.MslInsuranceRateService;
import cn.com.sinosoft.msl.service.PremiumCalculationService;

@Component
@Service("premiumCalculationService")
public class PremiumCalculationServiceImpl implements PremiumCalculationService{

	public static Logger logger = LoggerFactory.getLogger(PremiumCalculationServiceImpl.class);
	
//	@Autowired
//	private  MslInsuranceRateCCCService  mslInsuranceRateCCCService ;
//	@Autowired
//	private  MslInsuranceRateCDCService  mslInsuranceRateCDCService ;
//	@Autowired
//	private  MslInsuranceRateNBJService  mslInsuranceRateNBJService ;
	@Autowired
	private  MslInsuranceRateService mslInsuranceRateService;
	
	@Override
	public void calculate(GePolicy gePolicy,GeApplicantInsured applicant) {
		

		String  prodoctCode =gePolicy.getProdoctcode();
		
		if("TATIANB02".equals(prodoctCode)||"TATIANB02".equals(prodoctCode)||"TATIANB02".equals(prodoctCode)){
			String policyterm =gePolicy.getPolicyterm();
			dealWithProductPACTH(gePolicy, policyterm, prodoctCode);
			   return ;
		}else{
//			Date  birth=  applicant.getBirthday() ;
//			int payYear =Integer.parseInt(gePolicy.getPayYear());
//			int age =  birthToAge(birth) ;
//			int sex =  Integer.parseInt(applicant.getSex()) ;
//			if("CCC".equals(prodoctCode)){
//				dealWithProductCCC(gePolicy, age, sex, payYear);
//			    return ;
//			}
//			if("CDC".equals(prodoctCode)){
//				dealWithProductCDC(gePolicy, age, sex, payYear);
//			    return ;
//			}
//			if("NBJ".equals(prodoctCode)){
//				dealWithProductNBJ(gePolicy, age, sex, payYear);
//			    return ;
//			}
		}
	    	
	}

	private void dealWithProductPACTH(GePolicy gePolicy, String payYear,
			String prodoctCode) {
	    String     type= gePolicy.getPolicytermtype() ;
	    if(prodoctCode==null||type==null||payYear==null){
	    	return ;
	    }
	    MslInsuranceRate rate = mslInsuranceRateService.getSumInsured(prodoctCode, payYear,type);
		double   basePremium = rate.getBasePremium();
		double   baseAmount  = rate.getBaseAmount() ;
		sumBasepremium(gePolicy, basePremium, baseAmount); 
		logger.info("网销产品保费试算成功："+prodoctCode);
	}

//	private void dealWithProductNBJ(GePolicy gePolicy, int age, int sex,
//			int payYear) {
//		MslInsuranceRateNBJ rateNBJ =mslInsuranceRateNBJService.getSumInsured(
//				sex,
//				payYear,
//				age
//				);
//		double   basePremium = rateNBJ.getBasePremium();
//		double   baseAmount  = rateNBJ.getBaseAmount() ;
//		sumBasepremium(gePolicy, basePremium, baseAmount); 
//		logger.info("线下热销产品保费试算成功："+gePolicy.getProdoctcode());
//	}
//
//	private void dealWithProductCDC(GePolicy gePolicy, int age, int sex,
//			int payYear) {
//		MslInsuranceRateCDC rateCDC =mslInsuranceRateCDCService.getSumInsured(
//				sex,
//				payYear,
//				age
//				);
//		double   basePremium = rateCDC.getBasePremium();
//		double   baseAmount  = rateCDC.getBaseAmount() ;
//		sumBasepremium(gePolicy, basePremium, baseAmount);
//		logger.info("线下热销产品保费试算成功："+gePolicy.getProdoctcode());
//	}
//
//	private void dealWithProductCCC(GePolicy gePolicy, int age, int sex,
//			int payYear) {
//		MslInsuranceRateCCC rateCCC = mslInsuranceRateCCCService.getSumInsured(
//				sex,
//				payYear,
//				age
//				);
//		double   basePremium = rateCCC.getBasePremium();
//		double   baseAmount  = rateCCC.getBaseAmount() ;
//		sumBasepremium(gePolicy, basePremium, baseAmount);
//		logger.info("线下热销产品保费试算成功："+gePolicy.getProdoctcode());
//	}

	private void sumBasepremium(GePolicy gePolicy, double basePremium,
			double baseAmount) {
		double sumbasepremium = basePremium * gePolicy.getSumamount()/baseAmount ;
		gePolicy.setSumbasepremium(sumbasepremium);
	}
//	
//	/*  
//	 * 根据生日日期计算周岁
//	 */
//	private  int birthToAge(Date birth) {
//		Calendar  caNow = Calendar.getInstance() ;
//		Calendar  caOld = Calendar.getInstance() ;
//		          caOld.setTime(birth) ;
//		  int age  = caNow.get(Calendar.YEAR)  - caOld.get(Calendar.YEAR) ;
//		  int month= caNow.get(Calendar.MONTH) - caOld.get(Calendar.MONTH) ;
//		  int day  = caNow.get(Calendar.DAY_OF_MONTH) - caOld.get(Calendar.DAY_OF_MONTH) ;
//		   if(month < 0  ){
//			   age -- ;
//		   }else if( month ==0 && day < 0){
//			   age -- ;
//		   }
//		   logger.info("根据生日日期计算周岁成功："+age+"周岁");
//		   return   age  ;
//	}
//	
//	
//	public void setMslInsuranceRateCCCService(
//			MslInsuranceRateCCCService mslInsuranceRateCCCService) {
//		this.mslInsuranceRateCCCService = mslInsuranceRateCCCService;
//	}
//
//	public void setMslInsuranceRateCDCService(
//			MslInsuranceRateCDCService mslInsuranceRateCDCService) {
//		this.mslInsuranceRateCDCService = mslInsuranceRateCDCService;
//	}
//
//	public void setMslInsuranceRateNBJService(
//			MslInsuranceRateNBJService mslInsuranceRateNBJService) {
//		this.mslInsuranceRateNBJService = mslInsuranceRateNBJService;
//	}
//
	public void setMslInsuranceRateService(
			MslInsuranceRateService mslInsuranceRateService) {
		this.mslInsuranceRateService = mslInsuranceRateService;
	}	
	
}

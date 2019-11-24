package cn.com.sinosoft.web.msl.sales;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.msl.service.PremiumCalculationService;
import cn.com.sinosoft.web.msl.BaseAction;

/**
 * 描述：各产品保费试算<br>
 * 作者：CaryXu <br>
 * 修改日期：2015年4月30日 12:39:41 <br>
 * E-mail: Xukaizhen@sinosoft.com.cn <br>
 */
@ParentPackage(value = "ECS-STRUTS")
public class PremiumCalculationAction extends BaseAction{
	
	public static Logger logger = LoggerFactory.getLogger(PremiumCalculationAction.class);
	
	
	@Autowired
	private PremiumCalculationService premiumCalculationService;
	
	private GePolicy policy;
	
	private GeApplicantInsured applicantInsured;
	/**
	 * 计算保费
	 * @return
	 */
	@Action(value = "calculate", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public  String calculate(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PremiumCalculationAction.calculate:"+sessionId);
			/**
			 * 1.调用保费试算Service
			 * 2.返回的policy设置保费字段
			 */
			premiumCalculationService.calculate(policy, applicantInsured);
			//根据页面传输过来的产品编码和保险期间来算保费
		} catch (Exception e) {
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		// TODO Auto-generated method stub
		
	}
	
	public void setPremiumCalculationService(
			PremiumCalculationService premiumCalculationService) {
		this.premiumCalculationService = premiumCalculationService;
	}

	public GePolicy getPolicy() {
		return policy;
	}
	
	public void setPolicy(GePolicy policy) {
		this.policy = policy;
	}

	public GeApplicantInsured getApplicantInsured() {
		return applicantInsured;
	}

	public void setApplicantInsured(GeApplicantInsured applicantInsured) {
		this.applicantInsured = applicantInsured;
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
}

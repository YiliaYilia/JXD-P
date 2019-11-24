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

import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.sale.service.PremCalculateService;
import cn.com.sinosoft.web.msl.BaseAction;

/**
 * 描述：产品保费试算<br>
 * 作者：
 * 修改日期：
 * E-mail: 
 */
@ParentPackage(value = "ECS-STRUTS")
public class ShortPremiumCalculationAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	public static Logger logger = LoggerFactory.getLogger(ShortPremiumCalculationAction.class);
	
	@Autowired
	private PremCalculateService premCalculateService;

	private GePolicy policy;
	
	/**
	 * 计算保费
	 * @return
	 */
	@Action(value = "shortCalculate", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public String calculate(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PremiumCalculationAction.calculate:"+sessionId);
			/**
			 * 1.调用保费试算Service
			 * 2.返回的policy设置保费字段
			 */
			String productCode = policy.getProdoctcode();
			int copies = Integer.parseInt(policy.getUnitcount());
			if(!"TATIANB02".equals(productCode)){
				return ERROR;
			}
			String standardPeriod = premCalculateService.getStandardPeriod(Integer.parseInt(policy.getPolicyterm()));
			String[] standardPeriodArry = standardPeriod.split("&");
			if(copies >= 0 && copies < 11){
				premCalculateService.getSumPrem(policy,Integer.parseInt(policy.getUnitcount()),Integer.parseInt(standardPeriodArry[0]), standardPeriodArry[1]);
			}else{
				logger.info("PremiumCalculationAction.calculate: 保费测算输入保险份数为不合法输入");
				throw new Exception();
			}
			session.put("InsurePolicy.PolicyI", policy);
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
	
	/**
	 * 赠险保存保单信息
	 * @return
	 */
	@Action(value = "gratisCalculate", results = {
			@Result(name="success",type="json"),
			@Result(name="fail",type="json")
			})
	public String gratisCalculate(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PremiumCalculationAction.gratisCalculate:"+sessionId);
			/**
			 * 1.调用保费试算Service
			 * 2.返回的policy设置保费字段
			 */
			String productCode = policy.getProdoctcode();
			if(!"TATIANB02".equals(productCode)){
				return ERROR;
			}
			policy.setSumbasepremium(Double.parseDouble("0"));
			policy.setSumpremium(Double.parseDouble("0"));
			session.put("InsurePolicy.PolicyI", policy);
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
	
	
	/**
	 * 进入投、被保人信息录入页
	 * @return
	 */
	@Action(value = "fill", results = {
	@Result(name="success", location="/WEB-INF/jsp/sales/fill.jsp")
	})
	public String fill(){
		String sessionId=request.getSession().getId();
		try {
			logger.info("PremiumCalculationAction.fill: "+sessionId);
			resultBusiness(true);
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
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public void setPremCalculateService(PremCalculateService premCalculateService) {
		this.premCalculateService = premCalculateService;
	}

	public GePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(GePolicy policy) {
		this.policy = policy;
	}

}

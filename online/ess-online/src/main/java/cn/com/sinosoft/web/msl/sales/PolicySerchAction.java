package cn.com.sinosoft.web.msl.sales;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.ess.product.service.PolicySearchService;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;

@ParentPackage(value = "ECS-STRUTS")
public class PolicySerchAction extends BaseAction{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = LoggerFactory.getLogger(PolicySerchAction.class);

	@Autowired
	private PolicySearchService pss;
	
	private GePolicy gePolicy;
	
	//保单列表
	@Action(value="findCharityPolicy", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/policylist.jsp")
			})
	public String findCharityPolicy(){
		WeiXinServiceImpl weixin = new WeiXinServiceImpl();
		String OpenId  = weixin.getOpenId(request);
		if(OpenId!=null&&OpenId.length()>0){
			System.out.println("===openid="+OpenId);
			logger.info("前台查询openId="+OpenId);
			//String openId = "test";
			List<GePolicy> policyList = pss.getPolicy(OpenId);
			request.setAttribute("policyList",policyList);
		}else{
			logger.info("前台查询保单获取openId失败");
		}
		return SUCCESS;
	}

	//保单详细
	@Action(value="findCharityInfo", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/policyinfo.jsp")
			})
	public String findCharityInfo(){
		String policyCode = request.getParameter("policycode");
		if(policyCode!=null&&policyCode.length()>0){
			logger.info("根据保单号"+policyCode+"进行查询");
			gePolicy = pss.getPolicyInfo(policyCode);
			request.setAttribute("gePolicy",gePolicy);
		}
		return SUCCESS;
	}
	
	
	
	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		// TODO Auto-generated method stub
		
	}
}

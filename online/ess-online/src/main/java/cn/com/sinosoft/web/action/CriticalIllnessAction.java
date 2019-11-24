package cn.com.sinosoft.web.action;

import java.text.ParseException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.BasicQuery;
import cn.com.sinosoft.common.service.axis.QueryModel;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.ess.product.common.Data;
import cn.com.sinosoft.sale.service.PolicyMobileService;
import cn.com.sinosoft.web.service.facade.ClientBindService;
import cn.com.sinosoft.web.service.facade.PolicyBasicQueryService;
import cn.com.sinosoft.web.service.facade.PolicyListQueryService;

/**
 * 重疾绿通
 * @author Yunxia.Guo
 *
 */
public class CriticalIllnessAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(PolicyQueryAction.class);
	@Autowired
	private ClientBindService clientBindService;
	@Autowired
	private PolicyMobileService policyMobileService;
	@Autowired
	private PolicyListQueryService policyListQueryService;
	@Autowired
	private PolicyBasicQueryService policyBasicQueryService;
	
	
	/**
	 * 只针对长险
	 * @return
	 */
	@Action(value="getCriticalIll")
	public String getPolicyBasic(){
		String criticalIllFlag = "";
		try{
			String OpenID = this.getHttpServletRequest().getParameter("OpenID");
			//String OpenID = "oipGbs6aOJCQcO0jGszXYVdAmp_I"; //gyx
		    logger.info("用户OPenId===="+OpenID);
			this.getHttpServletRequest().getSession().setAttribute("OpenID", OpenID);
			if(Data.hasValue(OpenID) && clientBindService.checkOpenID(OpenID).size()>0){
				List<GeMobileCustomer> mcList = policyMobileService.getOrderByNo(OpenID);
				//如果一个openID绑定多个客户，则只取一个以长险为主
				GeMobileCustomer geMobileCustomer = null;
				for(GeMobileCustomer temp:mcList){
					String coustomerid = temp.getCoustomerid();
					if(!(coustomerid.startsWith("C") && coustomerid.length() == 12)){//排除短险
						geMobileCustomer = temp;
						break;
					}
				}
				//查询该客户保单列表
				QueryModel[] policyList = null;
				policyList = policyListQueryService.depacketizeQuery(policyList,geMobileCustomer.getName(), geMobileCustomer.getIdtype(), geMobileCustomer.getIdnumber());
				if(policyList.length > 0){
					criticalIllFlag = criticalIllSort(policyList);
					logger.info("name:"+geMobileCustomer.getName()+",idtype:"+geMobileCustomer.getIdtype()+",idnumber:"+geMobileCustomer.getIdnumber()+",criticalIllFlag:"+criticalIllFlag);
				}
			}else{
				this.setRequestAttribute("OpenID", OpenID);
				return "../page/index";
			}
		}catch (Exception e) {
			logger.info("重疾绿通分类失败，原因："+e.getMessage());
		}
		this.setRequestAttribute("criticalIllFlag", criticalIllFlag);
		return "../page/criticalIll";
	}
	
	/**
	 * 重疾绿通分类标志，分为三类：
	 * 1.银保经代渠道 重疾险  一年期以上产品 标准保费超过5000元（含）或保额30万以上（含）:瑞享安康（2018年1月1日以后生效的）、康泰金生（2018年1月1日以后生效的）
	 * 2、高净值产品 保额600万以上（含）:瑞享金生(2019年1月1日以后生效的)、康泰金生（2018年1月1日以后生效的）
	 * 3.网销渠道 重疾险 一年期以上产品 保额50万以上（含） :瑞盈(2019年1月1日以后生效的)、瑞兴(2019年1月1日以后生效的)
	 * ur17200对分类条件进行了修改：
	 * 1.银保经代渠道和直销渠道 重疾险  一年期以上产品 标准保费超过5000元（含）或保额30万以上（含）:瑞享安康、康泰金生、乐享安康
	 * 2、高净值产品 保额300万以上（含）:瑞享金生
	 * 3.网销渠道 重疾险 一年期以上产品 保额50万以上（含） :瑞盈、瑞兴、多倍宝宝、完美童年
	 * @return
	 * @throws ParseException 
	 */
	private String criticalIllSort(QueryModel[] policyList) throws Exception{
		String criticalIllFlag = null;
		//高净值产品累计保额
		Float assuredSum = 0f;
		//遍历保单列表
		BasicQuery policyBasic;
		for(QueryModel policy:policyList){
			policyBasic = policyBasicQueryService.policyBasicQuery(policy.getPolicyNum());
			if("0".equals(policyBasic.getCode().toString())){
				String policyChannel = null;
				if(policyBasic.getPolicyChannel() != null && !"".equals(policyBasic.getPolicyChannel())){
					policyChannel = policyBasic.getPolicyChannel();
				}
				String productType = null;
				if(policyBasic.getProductType() != null && !"".equals(policyBasic.getProductType())){
					productType = policyBasic.getProductType();
				}
				String productCode = null;
				if(policyBasic.getProductCode() != null && !"".equals(policyBasic.getProductCode())){
					productCode = policyBasic.getProductCode();
				}
				Integer term = null;
				if(policyBasic.getTerm() != null && !"".equals(policyBasic.getTerm())){
					term = Integer.parseInt(policyBasic.getTerm());
				}
				Float standardPremium = null;
				if(policyBasic.getStandardPremium() != null && !"".equals(policyBasic.getStandardPremium())){
					standardPremium = Float.parseFloat(policyBasic.getStandardPremium().replace(",", ""));
				}
				Float assured = null;
				if(policyBasic.getAssured() != null && !"".equals(policyBasic.getAssured())){
					assured = Float.parseFloat(policyBasic.getAssured().replace(",", ""));
				}
				if(criticalIllFlag == null 
						&& (policyChannel != null && ("银保".equals(policyChannel) || "经代".equals(policyChannel) || "直销".equals(policyChannel)))
						&& (productType != null && "重疾".equals(productType))
						&& (productCode != null && ("RUIXANKANG".equals(productCode) || "TAKANGT".equals(productCode) 
								|| "LXANKANG".equals(productCode) || "XINKB-CI".equals(productCode)))
						&& (term != null && term>1)
						&& (standardPremium != null && standardPremium>=5000 || assured != null && assured>=300000)){
					criticalIllFlag = "01";
				}
				if(productType != null && productCode != null 
						&& ("RUIXIANGJS".equals(productCode) || "TAKANGT".equals(productCode)) 
						&& assured != null){
					assuredSum = assuredSum + assured;
					logger.info("assuredSum:" + assuredSum);
					if(assuredSum>=3000000){
						criticalIllFlag = "02";
						break;
					}
				}
				if(criticalIllFlag == null 
						&& policyChannel != null && "网销".equals(policyChannel)
						&& (productType != null && "重疾".equals(productType))
						&& (productCode != null && ("RUIYING-CI".equals(productCode) || "RUIXING-CI".equals(productCode)
								|| "TAMULCHD".equals(productCode) || "TAWANMEICH".equals(productCode)))
						&& (term != null && term>1)
						&& (assured != null && assured>=500000)){
					criticalIllFlag = "03";
				}
			}
		}
		return criticalIllFlag;
	}
}

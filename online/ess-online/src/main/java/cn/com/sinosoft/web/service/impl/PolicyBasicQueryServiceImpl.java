package cn.com.sinosoft.web.service.impl;

import cn.com.sinosoft.web.service.facade.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.*;
import org.apache.commons.logging.*;
import cn.com.sinosoft.common.service.axis.*;
import cn.com.sinosoft.web.util.*;
import net.sf.json.*;

@Service
public class PolicyBasicQueryServiceImpl implements PolicyBasicQueryService {

	private static Log logger = LogFactory.getLog(PolicyBasicQueryServiceImpl.class);
	
	
	/**
	 * 查询保单基本信息(长险)
	 * @param policyNo 保单号
	 * @return 接口返回消息
	 */
	public BasicQuery policyBasicQuery(String policyNo){
		PolicyBasicQueryLocator service = new PolicyBasicQueryLocator();
		BasicQuery result = new BasicQuery();
		try {
			PolicyBasicQueryPortType portType = service.getPolicyBasicQueryHttpSoap11Endpoint();
			result =  portType.getPolBasicQuery(policyNo);
			String bankCardId = result.getBankCardID();
			if(!StringUtils.isBlank(bankCardId) && bankCardId.length()>=10){
				bankCardId = StringUtils.overlay(bankCardId, StringUtils.repeat("*",bankCardId.length()-10), 6, bankCardId.length()-4);
				result.setBankCardID(bankCardId);
			}
			String accountBank = result.getAccountBank();
			if(accountBank != null && !"".equals(accountBank) && accountBank.contains("-")){
				accountBank = accountBank.split("-")[1];
				result.setAccountBank(accountBank);
			}
		}catch(Exception e){
			logger.error("长险获取保单信息异常",e);
		}
		return result;
	}
	

	/**
	 * 查询保单基本信息(短险)
	 * @param policyNo 保单号
	 * @return 接口返回消息
	 */
	public BasicQuery ShortPolicyBasic(String policyNo){
		JSONClientUtil client = new JSONClientUtil();
		BasicQuery basicQuery = new BasicQuery(); 
		basicQuery.setCode(1);
		String param = "contNo="+policyNo;
		try {
			JSONObject result = (JSONObject)client.send("contract", param).get("contract");
			if(result != null){
				logger.info("短险获取保单信息成功");
				basicQuery.setCode(0);//返回状态
				basicQuery.setAssured(result.get("amnt").toString());//保额
				basicQuery.setAssuredName(result.get("insuredName").toString());//被保人
				basicQuery.setInceptionDate(result.get("cvalidate").toString());//生效日期
				basicQuery.setInsuranceType(result.get("contPlanType").toString());//险种类型
				basicQuery.setPartyCode(result.get("appntNo").toString());//投保人客户号
				basicQuery.setPolicyNum(result.get("contNo").toString());//保单号
				basicQuery.setPolName(result.get("appntName").toString());//投保人
				basicQuery.setProductCode(result.get("contPlanCode").toString());//险种代码
				basicQuery.setProductName(result.get("contPlanName").toString());//险种名称
				basicQuery.setTerm(result.get("period").toString());//保障期间(带单位)
				JSONArray extraProductList = (JSONArray)result.get("riskList");
				if(extraProductList != null){
					String[] extraProduct = new String[extraProductList.size()];
					JSONObject jsonExtraProduct = null;
					for(int i = 0;i<extraProductList.size();i++){
						jsonExtraProduct = (JSONObject)extraProductList.get(i);
						extraProduct[i] = jsonExtraProduct.get("riskName").toString();
					}
					basicQuery.setExtraProductName(extraProduct);//附加险
				}
			}
		} catch (Exception e) {
			logger.error("短险获取保单信息异常",e);
		}		
		return basicQuery;
	}
}

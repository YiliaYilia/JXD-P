package cn.com.sinosoft.web.service.impl;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.common.service.axis.PolListQueryInterfaceLocator;
import cn.com.sinosoft.common.service.axis.PolListQueryInterfacePortType;
import cn.com.sinosoft.common.service.axis.PolicyInformation;
import cn.com.sinosoft.common.service.axis.QueryModel;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.user.GePolicyCodeConfig;
import cn.com.sinosoft.web.entity.IDTypeEntity;
import cn.com.sinosoft.web.service.facade.PolicyListQueryService;
import cn.com.sinosoft.web.util.JSONClientUtil;

@Component
public class PolicyListQueryServiceImpl  extends GenericHibernateDao<GePolicyCodeConfig, String> implements PolicyListQueryService{
	private static Log logger = LogFactory.getLog(PolicyListQueryServiceImpl.class);		

	/**
	 * 功能：工具方法-合并保单列表
	 * @param policyListLocal
	 * @param policyListIn
	 * @return
	 */
	public QueryModel[] addPolicyList(QueryModel[] policyListLocal,QueryModel[] policyListIn){
		QueryModel[] tempPolicyList = null;
		if(policyListLocal == null){
			tempPolicyList = policyListIn;
		}else if(policyListIn != null && policyListIn.length>0) {
			tempPolicyList = new QueryModel[policyListLocal.length+policyListIn.length];
		    System.arraycopy(policyListLocal, 0, tempPolicyList, 0, policyListLocal.length);
		    System.arraycopy(policyListIn, 0, tempPolicyList, policyListLocal.length, policyListIn.length);
		}else{
			tempPolicyList = policyListLocal;
		}
		return tempPolicyList;
	}
	
	/**
	 * 功能：拼装保单列表
	 * 描述：按条件查询长险&短险‘保单列表’并与当前‘保单列表’合并
	 * 作者： ZhangTiancong
	 * @param localQM	当前保单列表
	 * @param name		姓名
	 * @param cardType	证件类型
	 * @param cardNum	证件号
	 */
	public QueryModel[] depacketizeQuery(QueryModel[] localQM,String name,String cardType,String cardNum){
		PolicyInformation  policyInformation = policyListQuery(name,cardType,cardNum);
		localQM = addPolicyList(localQM,shortPolicyListQuery(name,cardType,cardNum));
			if("0".equals(policyInformation.getCode().toString())){
				QueryModel[] model = policyInformation.getModel();
				String outlog = "user:"+name+"/"+cardType+"/"+cardNum+"|sucess!policyNum=0";
				if(model != null){
					outlog = "user:"+name+"/"+cardType+"/"+cardNum+"|sucess!policyNum="+model.length;
				}
				logger.info("长险保单列表查询核心成功："+outlog);
				return addPolicyList(localQM,model);
			}else{
				logger.info("长险保单列表查询核心返回失败："+"user:"+name+"/"+cardType+"/"+cardNum+"|"+policyInformation.getMessage());
				return localQM;
			}
	}
	/**
	 * 功能：拼装保单列表
	 * 描述：按条件查询长险&短险‘保单列表’并与当前‘保单列表’合并
	 * 作者： LiuWenkang
	 * @param localQM	当前保单列表
	 * @param name		姓名
	 * @param cardType	证件类型
	 * @param cardNum	证件号
	 * @param partyCode	客户号
	 * @param roleCode	角色 null时则默认为查询投保人；POLICY-HOL 投保人；LIFE-ASSD 被保人
	 */
	public QueryModel[] depacketizeQuery(QueryModel[] localQM,String name,String cardType,String cardNum,String partyCode,String roleCode){
		PolicyInformation  policyInformation = policyListQuery(partyCode,roleCode);
		localQM = addPolicyList(localQM,shortPolicyListQuery(name,cardType,cardNum));
		if("0".equals(policyInformation.getCode().toString())){
			QueryModel[] model = policyInformation.getModel();
			String outlog = "user:"+name+"/"+cardType+"/"+cardNum+"|sucess!policyNum=0";
			if(model != null){
				outlog = "user:"+name+"/"+cardType+"/"+cardNum+"/"+partyCode+"|sucess!policyNum="+model.length;
			}
			logger.info("长险保单列表查询核心成功："+outlog);
			return addPolicyList(localQM,model);
		}else{
			logger.info("长险保单列表查询核心返回失败："+"user:"+name+"/"+cardType+"/"+cardNum+"/"+partyCode+"|"+policyInformation.getMessage());
			return localQM;
		}
	}
		
	/**
	 * 功能：查询保单列表接口(长险)
	 * 描述：接口查询用户保单列表
	 * 作者： ZhangTiancong
	 * @param name		姓名
	 * @param cardType	证件类型
	 * @param cardNum	证件号
	 * @return 报文实体
	 */
	public PolicyInformation policyListQuery(String name,String cardType,String cardNum){
		cardType = IDTypeEntity.formatIDType("saveType","longType",cardType);
		PolListQueryInterfaceLocator service = new PolListQueryInterfaceLocator();
		PolicyInformation result = new PolicyInformation();
		try {
			PolListQueryInterfacePortType portType = service.getPolListQueryInterfaceHttpSoap11Endpoint();
			logger.info("查询长险保单列表："+"user="+name+"|"+cardType+"|"+cardNum);
			result =  portType.getPolicyDetail(name, cardType, cardNum);
		}catch(Exception e){
			logger.error("长险获取保单列表异常",e);
		}
		return result;
	}

	/**
	 * 功能：查询保单列表接口(长险)
	 * 描述：接口查询用户保单列表
	 * 作者： LiuWenkang
	 * @param name	partyCode	客户号
	 * @return 报文实体
	 */
	public PolicyInformation policyListQuery(String partyCode,String roleCode){
 		logger.info("根据用户客户号查询保单列表："+"客户号="+partyCode+"角色="+roleCode);
		PolListQueryInterfaceLocator service = new PolListQueryInterfaceLocator();
		PolicyInformation result = new PolicyInformation();
		try {
			PolListQueryInterfacePortType portType = service.getPolListQueryInterfaceHttpSoap11Endpoint();
			result =  portType.getPolicyDetailByPatryCode(partyCode,roleCode);
		}catch(Exception e){
			logger.error("长险获取保单列表异常",e);
		}
		return result;
	}
	
	/**
	 * 功能：查询保单列表接口(短险)
	 * 描述：JSON查询用户保单列表
	 * 作者： ZhangTiancong
	 * @param name		姓名
	 * @param cardType	证件类型
	 * @param cardNum	证件号
	 * @return 	保单列表
	 */
	public QueryModel[] shortPolicyListQuery(String name,String cardType,String cardNum){
		cardType = IDTypeEntity.formatIDType("saveType","shortType",cardType);
		QueryModel[] queryModel =new QueryModel[0];
		JSONClientUtil client = new JSONClientUtil();
		String param = "name="+name+"&idType="+cardType+"&idNo="+cardNum;
		try {
			logger.info("查询短险保单列表：参数="+param);
			JSONArray result = (JSONArray)client.send("contractList", param).get("contractList");
			
			if(result != null){
				logger.info("查询短险保单列表：结果="+result.toString());
				queryModel = new QueryModel[result.size()];
				for(int i = 0;i<result.size();i++){
					JSONObject jsonObject = (JSONObject)result.get(i);
					queryModel[i] = new QueryModel();
					queryModel[i].setProductName(jsonObject.get("contPlanName").toString());
					queryModel[i].setProductCode(jsonObject.get("contPlanCode").toString());
					queryModel[i].setPolicyStatus(jsonObject.get("state").toString());
					queryModel[i].setPolicyNum(jsonObject.get("contNo").toString());
					queryModel[i].setInceptionDate(jsonObject.get("cvalidate").toString());
				}
			} else{
				logger.info("查询短险保单列表：结果=null");
			}
		} catch (Exception e) {
			logger.error("短险获取保单列表异常",e);
		}
		return queryModel;
	}	
}

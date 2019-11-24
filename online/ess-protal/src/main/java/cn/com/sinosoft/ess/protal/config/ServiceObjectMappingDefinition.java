/**
 * File Name:ServiceTypeMappingDefinition.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-11下午04:25:54
 */
package cn.com.sinosoft.ess.protal.config;

import java.util.HashMap;
import java.util.Map;

import cn.com.sinosoft.ess.protal.model.TranDataEntity;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.TranDataBill;
import cn.com.sinosoft.ess.protal.model.DailyBills.response.TranDataBillRes;
import cn.com.sinosoft.ess.protal.model.bank.request.TranDataYB;
import cn.com.sinosoft.ess.protal.model.insure.ResTranData;
import cn.com.sinosoft.ess.protal.model.insure.TranDataReq;
import cn.com.sinosoft.ess.protal.model.revoke.request.TranDataCD;
import cn.com.sinosoft.ess.protal.model.revoke.response.TranDataCDRes;

/**描述：用于定义不同的请求方法对应的SOAP报文对象<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-11下午04:25:54 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public class ServiceObjectMappingDefinition {
	
	public static Map<String,MappingObject> serviceObjectMapping = new HashMap<String,MappingObject>();

	static{
		//map key:交易类型  value: 
			//requestObjectClass 请求报文对象Class  X
			//resultObjectClass 响应报文对象Class V
			//resultEntityClass 响应实体对象Class  X
		serviceObjectMapping.put(ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_1.tradeType(), new MappingObject(TranDataReq.class,ResTranData.class,TranDataEntity.class,false,false));
		serviceObjectMapping.put(ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_2.tradeType(), new MappingObject(TranDataYB.class,ResTranData.class,TranDataEntity.class,false,false));
		serviceObjectMapping.put(ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_3.tradeType(), new MappingObject(TranDataBill.class,TranDataBillRes.class,TranDataEntity.class,false,false));
		serviceObjectMapping.put(ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_4.tradeType(), new MappingObject(TranDataCD.class,TranDataCDRes.class,TranDataEntity.class,false,false));
	}
}

package cn.com.sinosoft.web.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.common.service.axis.PayDeatilModel;
import cn.com.sinosoft.common.service.axis.PolPayDetailLocator;
import cn.com.sinosoft.common.service.axis.PolPayDetailPortType;
import cn.com.sinosoft.web.service.facade.PayDetailService;
@Component
public class PayDetailServiceImpl  implements PayDetailService {
	private static Log logger = LogFactory.getLog(PayDetailServiceImpl.class);	
	
	/**
	 * 向核心查询缴费明细
	 */
	@Override
	public List<PayDeatilModel> getPayDetail(String policyNo) {
		PolPayDetailLocator service = new PolPayDetailLocator();
		List<PayDeatilModel> result = new ArrayList<PayDeatilModel>();
		try {
			PolPayDetailPortType portType = service.getPolPayDetailHttpSoap11Endpoint();
			logger.info("向查询缴费明细，保单号"+policyNo);
			logger.info("缴费明细返回内容:");
			PayDeatilModel resultTemp[] =portType.getPolDetail(policyNo);
			if(resultTemp!=null&&resultTemp.length>0){
				for(int i=0;i<resultTemp.length;i++){
					String transactionType = translateType(resultTemp[i].getTransactionType());
					logger.info(i+1+"：");
					logger.info("transactionDate:"+resultTemp[i].getTransactionDate()+",amount:"+resultTemp[i].getAmount()+",transactionType:"+resultTemp[i].getTransactionType()
							+",bankbrachcode:"+resultTemp[i].getBankbrachcode()+",bankcode:"+resultTemp[i].getBankcode()+",generateDate:"+resultTemp[i].getGenerateDate()+",fileOutDate:"+
							resultTemp[i].getFileOutDate()+",fileInDate:"+resultTemp[i].getFileInDate()+",errCode:"+resultTemp[i].getErrCode()+",errDesc:"+resultTemp[i].getErrDesc());
					resultTemp[i].setTransactionType(transactionType);
//					logger.info(resultTemp[i].getAmount());
					if(resultTemp[i].getErrCode().equals("0")){
					logger.info("成功记录，加入列表。");
						result.add(resultTemp[i]);
					}else{
						logger.info("异常记录，移除。");
					}
				} 
//				result = Arrays.asList(resultTemp);
			}else{
				logger.info("缴费明细返回内容为空");
			}
		} catch (Exception e) {
			logger.error("查询缴费明细异常，保单号"+policyNo);
			e.printStackTrace();
		}
		return result;
	} 
	
	
	
	
	/**
	 * transactionType翻译
	 * 
	 */
	
	public String translateType(String transactionType){
		String result="";
		if(transactionType!=null && transactionType.length()!=0){
			transactionType = transactionType.trim();
			if(transactionType.equals("IP")){
				result="首期保费";
			}
			else if(transactionType.equals("PM")){
				result="续期保费";
			}
			else if(transactionType.equals("ATP")){
				result="追加保费";
			}
			else if(transactionType.equals("RTP")){
				result="定期追加";
			}
			else if(transactionType.equals("0")){
				result="初始追加";
			}
			else if(transactionType.equals("LP")){
				result="保单贷款";
			}
			else if(transactionType.equals("PS")){
				result="部分支取";
			}
			else if(transactionType.equals("LR")){
				result="保单还款";
			}
			else if(transactionType.equals("WD")){
				result="保单分红";
			}
			else if(transactionType.equals("AR")){
				result="保单减保";
			}
			else if(transactionType.equals("CLM")){
				result="理赔金额";
			}
			else if(transactionType.equals("MA")){
				result="满期给付";
			}
			else if(transactionType.equals("RM")){
				result="复效保费";
			}
			else if(transactionType.equals("FS")){
				result="退保金额";
			}else{
				result=transactionType;
			}
		}
		return result;
	}
//	public static void main(String[] args) {
//		List<PayDeatilModel> a = new PayDetailServiceImpl().getPayDetail("");
//		System.out.println("====="+a.size());
//	}
}

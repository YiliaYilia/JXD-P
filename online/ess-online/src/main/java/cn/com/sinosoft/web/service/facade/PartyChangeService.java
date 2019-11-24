package cn.com.sinosoft.web.service.facade;

import java.util.Map;

import cn.com.sinosoft.common.service.axis.*;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

/**
 * <p>Title: PartyChangeService</p>
 * <p>Description:个人信息变更</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company:sinosoft</p>
 * @author ztc
 * @version 1.0
 */
public interface PartyChangeService {
	/**
	 * 个人信息变更
	 * @param pcm 个人信息实体
	 * @return 接口返回消息
	 */
	PartyChangeReturnModel PartyChange(PartyChangeModel pcm);

	/*
	* 调用核心进行微信信息查询
	* @param CoustomerId 客户号
	* @return 接口返回对象
	* */
	PartyChangeModel WeChatQuery(String customerId);
	
	/**
	 * 个人信息查询
	 * @param policyNum 保单号
	 * @return 接口返回对象
	 */
	RoleQueryModel RoleQuery(String policyNum);

	/**
	 * 
	 * @param partyCode
	 * @param taxTpye
	 * @param operate
	 * @param callBy
	 * @return
	 */
	CRSInterfaceModel dealPartyTaxType(String partyCode, String taxType,
			String operate, String callBy,String country);

	String identityOCR(String partyCode, String partyType, String cardNo, String type,
			MultiPartRequestWrapper req, String identityOCRUrl, String identityImageTempPath);

	Boolean copyPicture(String oldFilePathFront, String newFilePathFront,String filePath); 
	
	//public String savePicture(String partyCode, String partyType,String cardNo, String type,String filePath,
	//		MultiPartRequestWrapper req);
	
	/**
	 * 通过客户号校验证件有效期
	 * @param partyCode
	 * @return
	 */
	public Map<String, String> expiredDateCheck(String partyCode);
}

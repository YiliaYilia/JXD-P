package cn.com.sinosoft.msl.service.shortPolicy;

import java.io.StringReader;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.SOAPConstants;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.msl.model.soap.SoapCenterResponse;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsurancePolicy;

import com.omgd.ec.ws.Agreement;
import com.omgd.ec.ws.AppRequest;
import com.omgd.ec.ws.BankAccount;
import com.omgd.ec.ws.DoApp;
import com.omgd.ec.ws.DoAppE;
import com.omgd.ec.ws.DoAppResponse;
import com.omgd.ec.ws.DoAppResponseE;
import com.omgd.ec.ws.Entry_type0;
import com.omgd.ec.ws.ExtraAttrs_type0;
import com.omgd.ec.ws.Holder;
import com.omgd.ec.ws.Insured;
import com.omgd.ec.ws.Policy;
import com.omgd.ec.ws.Product;
import com.omgd.ec.ws.TransRequHeader;
import com.omgd.ec.ws.TransServiceEndpointServiceStub;

/**
 * 描述：网销在线投保和承保的接口<br>
 * 作者：guilong <br>
 * 修改日期：2015-07-03 14:02:22 <br>
 * E-mail: zhaogl13759@sinosoft.com.cn <br>
 */
public class SalesPolicyService {
	
	private static final Logger logger = LoggerFactory.getLogger(SalesPolicyService.class);
	
	/**
	 * 核保接口调用方法
	 * @param policy
	 * @return
	 * @throws BaseException
	 * @throws JAXBException
	 */
	public static DoAppResponse underWriting(InsurancePolicy policy) throws BaseException, JAXBException {
		DoAppResponse response = null;
		DoAppE doAppE = Axis2Entity.returnEntity(policy);  
		DoAppResponseE respE = InterfaceAssemblyService.underWriting(doAppE);
		if(respE != null){
			response = respE.getDoAppResponse();
		}
		return response;
	} 

	/**
	 * 承保接口调用方法
	 * @param policy
	 * @return
	 * @throws BaseException
	 * @throws JAXBException
	 */
	public static DoAppResponse blewWriting(InsurancePolicy policy) throws BaseException, JAXBException {
		DoAppResponse response = null;
		DoAppE doAppE = Axis2Entity.returnEntity(policy); 
		DoAppResponseE respE = InterfaceAssemblyService.blewWriting(doAppE);
		if(respE != null){
			response = respE.getDoAppResponse();
		}
		return response;
	}
	
	/**
	 * 核保,承保测试方法
	 * @throws ParseException
	 * @throws RemoteException
	 */
	
	public static Map<String,String> XMLStringToBean(){  
		SoapCenterResponse response = null;
		Map<String,String> returnMap = new HashMap<String,String>();
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><response>" +
        		"<contract><contNo>TG00003239</contNo><contUrl>https://elife.oldmutual-guodian.com/contracts/accdtinquire</contUrl>" +
        		"<effDate>2015-06-25T00:00:00+08:00</effDate><orderNo>A00011840721</orderNo></contract>" +
        		"<header><channelId>SHCCB1</channelId><transNo>2015062493424</transNo></header>" +
        		"<holderIdNo>310104195612202823</holderIdNo><holderIdType>A</holderIdType><holderName>顾****</holderName>" +
        		"<returnCode>0</returnCode>" +
        		"</response>";  
        try {  
            JAXBContext context = JAXBContext.newInstance(SoapCenterResponse.class);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            response = (SoapCenterResponse)unmarshaller.unmarshal(new StringReader(xmlStr));  
            returnMap.put("returnCode", response.getReturnCode());
            returnMap.put("orderNo", response.getContract().getOrderNo());
            returnMap.put("contNo", response.getContract().getContNo());
            System.out.println(response.getHolderName());  
            System.out.println(response.getContract().getContUrl());
            System.out.println(DateAndTime.convertDateToString(response.getContract().getEffDate(),"yyyy-MM-dd HH:mm:ss"));
        } catch (JAXBException e) {  
            e.printStackTrace();  
        } 
        return returnMap;
    } 
	
	public static void main(String[] args) throws ParseException, RemoteException {
		TransServiceEndpointServiceStub _stub = null;
		DoAppE doAppE = new DoAppE();
		DoApp doApp = new DoApp();
		AppRequest appRequest = new AppRequest();
			Agreement agreement = new Agreement();
				agreement.setAppPrompt(true);
				agreement.setDebitAuth(false);
				agreement.setProductSummary(true);
			appRequest.setAgreement(agreement);
			Calendar calendar = Calendar.getInstance();
			System.out.println(calendar.getTime());
			
			TransRequHeader header = new TransRequHeader();
				header.setChannelId("WECHAT01");
				header.setTransDate(calendar);
				header.setTransNo("2014571500189");
			appRequest.setHeader(header);
			
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			System.out.println(calendar.getTime());
			Holder holder = new Holder();
			OMFactory fac = OMAbstractFactory.getOMFactory();
			 OMNamespace omNs = fac.createOMNamespace("" , "" );
             //调用服务端的方法
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 
			 Calendar calendarR = Calendar.getInstance();
			 calendarR.setTime(sdf.parse("1989-09-24"));
			 
				holder.setBirthday(calendarR);
				holder.setGender("M");
				holder.setIdNo("11010219890924231X");
				holder.setIdType("A");
				holder.setMobile("18201452355");
				holder.setName("张三");
				holder.setOccupationCode("A1001_1");
				holder.setProvince("110100");
				holder.setRelationWithInsured("0");
				holder.setWorkType("A10");
			appRequest.setHolder(holder);
				
			Product product = new Product();
				product.setAutoRenewInd(false);
				product.setBillingAmt(1.20);
				product.setCode("TATIANB02");
				product.setName("瑞泰瑞驰交通工具意外伤害保险");
				
				product.setEffDate(calendar);
				product.setPeriod(1);
					Policy[] policyArry = new Policy[1];
					Policy policy = new Policy();
						policy.setCode("BPA-PT");
						policy.setEffDate(calendar);
						policy.setName("dddd");
						
						ExtraAttrs_type0 extraAttrs_type0 = new ExtraAttrs_type0();
						Entry_type0 entry = new Entry_type0();
						
						entry.setKey("unit");
						entry.setValue("1");
						Entry_type0[] entryArry = {
								entry
						};
						extraAttrs_type0.setEntry(entryArry);
						policy.setExtraAttrs(extraAttrs_type0);
						
						policy.setPeriod(1);
						policy.setPeriodUnit("D");
						policy.setPremTerm(0);
						policy.setPremType("0");
						policy.setPremium(1.20);
						policy.setSumins(350000.00);
						policyArry[0] = policy;
				product.setPolicy(policyArry);
				product.setPeriodUnit("D");
				product.setPremTerm("0");
				product.setPremType("0");
				product.setPremium(1.20);
				product.setSumins(350000.00);
				
			BankAccount bankAccount = new BankAccount();
			bankAccount.setAcctName("张三");
			bankAccount.setAcctNo("NA");
			bankAccount.setBankCode("080012");	
			
				appRequest.setProduct(product);
				appRequest.setBankAccount(bankAccount);
			doApp.setRequest(appRequest);
		doAppE.setDoApp(doApp);
		
		try {
			_stub = new TransServiceEndpointServiceStub();
			String channelId = "WECHAT01";
			String md5password = "4ba034b3f84de0cbef89d710d1d25ab6";
			OMFactory omFactory = OMAbstractFactory.getOMFactory();
			OMElement soapHeader = omFactory.createOMElement("ServiceAuthenticator",
			"http://ws.ec.omgd.com/", "");
			soapHeader.setText(channelId+"&"+md5password);
			OMNamespace ns = omFactory.createOMNamespace("http://schemas.xmlsoap.org/soap/envelope/","SOAPENV");
			OMAttribute omattribute = omFactory.createOMAttribute("actor", ns,
			SOAPConstants.URI_SOAP_1_2_ROLE_NEXT);
			soapHeader.addAttribute(omattribute);
			_stub._getServiceClient().addHeader(soapHeader);
			
			System.out.println(doAppE.getDoApp().getRequest().getHeader());
			
			DoAppResponseE ge = _stub.doApp(doAppE);
				
			System.out.println("returncode:"+ge.getDoAppResponse().getResponse().getReturnCode());
			System.out.println("returnMsg:"+ge.getDoAppResponse().getResponse().getReturnMsg());
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package cn.com.sinosoft.ess.protal.webservice;




import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.utils.PropertityUtil;
import cn.com.sinosoft.ess.protal.common.PortalProp;
import cn.com.sinosoft.ess.protal.util.XMLUtil;

import com.omgd.ec.ws.DoAppE;
import com.omgd.ec.ws.DoAppResponseE;
import com.omgd.ec.ws.TransServiceEndpointServiceStub;

/**
 * 描述：基于AXIS2的WebService客户端调用<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-6上午09:09:28 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br>
 */
public class Axis2ClientUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(Axis2ClientUtils.class);
	
	//properties文件属性名称
	/**WebService地址*/
	private static final String PRO_NAME_BANCASSURANCE_WEBSERVICE_URL = "BancassuranceWebServiceURL";
	/**WebService 名称空间*/
	private static final String PRO_NAME_BANCASSURANCE_WEBSERVICE_NAMESPACE = "BancassuranceWebServiceNamespace";
	
	//WebService
	private static String BASIC_HTTP_BINDING_SERVICE_ADDRESS = null;
	private static String BASIC_HTTP_BINDING_SERVICE_NAMESPACE = null;
	
	static{
		//读取文件初始化WebService参数
		PropertityUtil.init("config/portal.properties");
		BASIC_HTTP_BINDING_SERVICE_ADDRESS = PropertityUtil.get(Axis2ClientUtils.PRO_NAME_BANCASSURANCE_WEBSERVICE_URL);
		BASIC_HTTP_BINDING_SERVICE_NAMESPACE = PropertityUtil.get(Axis2ClientUtils.PRO_NAME_BANCASSURANCE_WEBSERVICE_NAMESPACE);
	}
	
	/**
	 * 方法名称: callBancassuranceRemoteService<br>
	 * 描述：调用银保远程接口服务
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6下午04:49:42
	 * @param method 远程方法名称
	 * @param requsetXML XML请求报文
	 * @return XML响应报文
	 */
	public static String callBancassuranceRemoteService(String method,String requestXML){
		try {
		
			logger.info("请求报文：{}",XMLUtil.formatXML(requestXML));
		} catch (Exception e1) {
			logger.error("格式化请求报文出错:",e1);
			e1.printStackTrace();
		}
		
		//String responseXML = "<?xml version=\"1.0\" encoding=\"GBK\"?><TranData><Head><Flag>0</Flag><Desc>交易成功!</Desc></Head></TranData>";
		String responseXML = (String)callRemoteService(BASIC_HTTP_BINDING_SERVICE_ADDRESS, BASIC_HTTP_BINDING_SERVICE_NAMESPACE,method, new Object[]{requestXML}, new Class[]{String.class});
		//String responseXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TranData><Head><TranDate>20130101</TranDate></Head><Body><Appnt><Name>appntName</Name></Appnt><LCBnfs><Bnf><Name>name</Name></Bnf></LCBnfs><ProposalPrtNo>proposalContNo</ProposalPrtNo></Body></TranData>";
		//String responseXML = "<?xml version=\"1.0\" encoding=\"GBK\"?><TranData><Head><Flag>0</Flag><Desc>交易成功!</Desc></Head></TranData>";
		//String responseXML = "<?xml version=\"1.0\" encoding=\"GBK\"?><TranData><Head><Desc>交易成功就是滴!</Desc><!--更过分过分--><Flag>0</Flag></Head><Body><AccTimeFlag>AccTimeFlag</AccTimeFlag><AgentCode>sad</AgentCode><AgentCom>123</AgentCom><AgentComName>的方法大幅度</AgentComName><AgentGrpCode>sda</AgentGrpCode><AgentGrpName>xc</AgentGrpName><AgentManageCode>32</AgentManageCode><AgentName>312</AgentName><Amnt>21</Amnt><AmntText>123</AmntText><AppCom>AppCom</AppCom><AppComFlag>AppComFlag</AppComFlag><AppTellCode>AppTellCode</AppTellCode><AppTellText>AppTellText</AppTellText><AutoPayFlag>sa</AutoPayFlag><AXAAgentCode>123</AXAAgentCode><BankAccNo>123</BankAccNo><BankManagerCode>1</BankManagerCode><BankManagerName>1</BankManagerName><ComCode>ComCode</ComCode><ComLocation>ComLocation</ComLocation><ComName>ComName</ComName><ComPhone>ComPhone</ComPhone><ComZipCode>ComZipCode</ComZipCode><ContNo>201210210214110</ContNo><ContractEffDate>ContractEffDate</ContractEffDate><ContractEndDate>ContractEndDate</ContractEndDate><ContractNo>ContractNo</ContractNo><FirstAddPrem>1</FirstAddPrem><GetIntv>asd</GetIntv><HighPremFlag>HighPremFlag</HighPremFlag><InsuCom>InsuCom</InsuCom><InsuComFlag>InsuComFlag</InsuComFlag><Appnt><Address>address</Address><Birthday>birthday</Birthday><Email>email</Email><Phone>homephone</Phone><IDNo>identifynumber</IDNo><IDType>identifytype</IDType><RelaToInsured>insrelationapp</RelaToInsured><MaritalStatus>marriage</MaritalStatus><Mobile>mobile</Mobile><Name>appntName</Name><Nationality>EstSalary</Nationality><JobCode>occupationcode</JobCode><Sex>sex</Sex><Stature>stature</Stature><GovtTermDate>visaExpDate</GovtTermDate><Weight>weight</Weight><ZipCode>zipcode</ZipCode></Appnt><Bnf><Birthday>benbirthday</Birthday><BeneficType>beneficType</BeneficType><IDNo>benidnumber</IDNo><IDType>benidtype</IDType><Name>benname</Name><Grade>benorder</Grade><Lot>benrate</Lot><RelaToInsured>benrelationtopins</RelaToInsured><Sex>bensex</Sex><Type>bentype</Type><GovtTermDate>govtTermDate</GovtTermDate></Bnf><Insured><Address>address</Address><Birthday>birthday</Birthday><CustomerNo>customerNo</CustomerNo><Email>email</Email><Phone>homephone</Phone><IDNo>identifynumber</IDNo><IDType>identifytype</IDType><MaritalStatus>marriage</MaritalStatus><Mobile>mobile</Mobile><Name>appntName</Name><Nationality>EstSalary</Nationality><JobCode>occupationcode</JobCode><Sex>sex</Sex><Stature>stature</Stature><GovtTermDate>visaExpDate</GovtTermDate><Weight>weight</Weight><ZipCode>zipcode</ZipCode></Insured><LoanAccountNo>LoanAccountNo</LoanAccountNo><LoanProductCode>LoanAmount</LoanProductCode><LoanEndDate>LoanEndDate</LoanEndDate><LoanProductCode>LoanProductCode</LoanProductCode><LoanStartDate>LoanStartDate</LoanStartDate><NodeNo>NodeNo</NodeNo><PayOutStart>12</PayOutStart><Prem>2</Prem><PremText>234</PremText><ProposalPrtNo>1111</ProposalPrtNo><RenewalPermit>123</RenewalPermit><Risk><AddAmnt>addAmnt</AddAmnt><AddPrem>addPrem</AddPrem><Amnt>amnt</Amnt><InsuYear>insuYear</InsuYear><InsuYearFlag>insuYearFlag</InsuYearFlag><MainRiskCode>mainRiskCode</MainRiskCode><Mult>mult</Mult><PayEndYear>payEndYear</PayEndYear><PayEndYearFlag>payEndYearFlag</PayEndYearFlag><PayIntv>payIntv</PayIntv><Prem>prem</Prem><RiskCode>riskCode</RiskCode><TranRiskCode>tranRiskCode</TranRiskCode><AutoPayFlag>AutoPayFlag</AutoPayFlag><BonusGetMode>BonusGetMode</BonusGetMode><CashValues><CashValue><Cash>5555-55</Cash><EndYear>00-99</EndYear></CashValue></CashValues><CostDate>CostDate</CostDate><CostIntv>CostIntv</CostIntv><FullBonusGetMode>FullBonusGetMode</FullBonusGetMode><GetAccName>GetAccName</GetAccName><GetBankAccNo>GetBankAccNo</GetBankAccNo><GetBankCode>GetBankCode</GetBankCode><GetIntv>GetIntv</GetIntv><GetStartDate>GetStartDate</GetStartDate><GetYear>GetYear</GetYear><GetYearFlag>GetYearFlag</GetYearFlag><PayEndDate>PayEndDate</PayEndDate><PayToDate>PayToDate</PayToDate><SubFlag>SubFlag</SubFlag></Risk><TellCode>TellCode</TellCode><TellText>TellText</TellText><TellerFlag>TellerFlag</TellerFlag><TellerFlag>TellerName</TellerFlag><TellerNo>12121</TellerNo><TransChnl>0</TransChnl><TransNo>222</TransNo><AgentComName>xczczcxx</AgentComName></Body></TranData>";
		//String responseXML = "<?xml version=\"1.0\" encoding=\"GBK\"?><TranData><Head><Desc>交易成功</Desc><Flag>0</Flag></Head><Body><AccTimeFlag>AccTimeFlag</AccTimeFlag><AgentCode>sad</AgentCode><AgentCom>123</AgentCom><AgentComName>sdfsdf</AgentComName><AgentGrpCode>sda</AgentGrpCode><AgentGrpName>xc</AgentGrpName><AgentManageCode>32</AgentManageCode><AgentName>312</AgentName><Amnt>21</Amnt><AmntText>123</AmntText><AppCom>AppCom</AppCom><AppComFlag>AppComFlag</AppComFlag><AppTellCode>AppTellCode</AppTellCode><AppTellText>AppTellText</AppTellText><AutoPayFlag>sa</AutoPayFlag><AXAAgentCode>123</AXAAgentCode><BankAccNo>123</BankAccNo><BankManagerCode>1</BankManagerCode><BankManagerName>1</BankManagerName><ComCode>ComCode</ComCode><ComLocation>ComLocation</ComLocation><ComName>ComName</ComName><ComPhone>ComPhone</ComPhone><ComZipCode>ComZipCode</ComZipCode><ContNo>201210210214110</ContNo><ContractEffDate>ContractEffDate</ContractEffDate><ContractEndDate>ContractEndDate</ContractEndDate><ContractNo>ContractNo</ContractNo><FirstAddPrem>1</FirstAddPrem><GetIntv>asd</GetIntv><HighPremFlag>HighPremFlag</HighPremFlag><InsuCom>InsuCom</InsuCom><InsuComFlag>InsuComFlag</InsuComFlag><Appnt><Address>address</Address><Birthday>birthday</Birthday><Email>email</Email><Phone>homephone</Phone><IDNo>identifynumber</IDNo><IDType>identifytype</IDType><RelaToInsured>insrelationapp</RelaToInsured><MaritalStatus>marriage</MaritalStatus><Mobile>mobile</Mobile><Name>appntName</Name><Nationality>EstSalary</Nationality><JobCode>occupationcode</JobCode><Sex>sex</Sex><Stature>stature</Stature><GovtTermDate>visaExpDate</GovtTermDate><Weight>weight</Weight><ZipCode>zipcode</ZipCode></Appnt><Bnf><Birthday>benbirthday</Birthday><BeneficType>beneficType</BeneficType><IDNo>benidnumber</IDNo><IDType>benidtype</IDType><Name>benname</Name><Grade>benorder</Grade><Lot>benrate</Lot><RelaToInsured>benrelationtopins</RelaToInsured><Sex>bensex</Sex><Type>bentype</Type><GovtTermDate>govtTermDate</GovtTermDate></Bnf><Insured><Address>address</Address><Birthday>birthday</Birthday><CustomerNo>customerNo</CustomerNo><Email>email</Email><Phone>homephone</Phone><IDNo>identifynumber</IDNo><IDType>identifytype</IDType><MaritalStatus>marriage</MaritalStatus><Mobile>mobile</Mobile><Name>appntName</Name><Nationality>EstSalary</Nationality><JobCode>occupationcode</JobCode><Sex>sex</Sex><Stature>stature</Stature><GovtTermDate>visaExpDate</GovtTermDate><Weight>weight</Weight><ZipCode>zipcode</ZipCode></Insured><LoanAccountNo>LoanAccountNo</LoanAccountNo><LoanProductCode>LoanAmount</LoanProductCode><LoanEndDate>LoanEndDate</LoanEndDate><LoanProductCode>LoanProductCode</LoanProductCode><LoanStartDate>LoanStartDate</LoanStartDate><NodeNo>NodeNo</NodeNo><PayOutStart>12</PayOutStart><Prem>2</Prem><PremText>234</PremText><ProposalPrtNo>1111</ProposalPrtNo><RenewalPermit>123</RenewalPermit><Risk><AddAmnt>addAmnt</AddAmnt><AddPrem>addPrem</AddPrem><Amnt>amnt</Amnt><InsuYear>insuYear</InsuYear><InsuYearFlag>insuYearFlag</InsuYearFlag><MainRiskCode>mainRiskCode</MainRiskCode><Mult>mult</Mult><PayEndYear>payEndYear</PayEndYear><PayEndYearFlag>payEndYearFlag</PayEndYearFlag><PayIntv>payIntv</PayIntv><Prem>prem</Prem><RiskCode>riskCode</RiskCode><TranRiskCode>tranRiskCode</TranRiskCode><AccountList>AccountList</AccountList><AutoPayFlag>AutoPayFlag</AutoPayFlag><BonusGetMode>BonusGetMode</BonusGetMode><CashValues><CashValue><Cash>5555-55</Cash><EndYear>00-99</EndYear></CashValue></CashValues><CostDate>CostDate</CostDate><CostIntv>CostIntv</CostIntv><FullBonusGetMode>FullBonusGetMode</FullBonusGetMode><GetAccName>GetAccName</GetAccName><GetBankAccNo>GetBankAccNo</GetBankAccNo><GetBankCode>GetBankCode</GetBankCode><GetIntv>GetIntv</GetIntv><GetStartDate>GetStartDate</GetStartDate><GetYear>GetYear</GetYear><GetYearFlag>GetYearFlag</GetYearFlag><PayEndDate>PayEndDate</PayEndDate><PayToDate>PayToDate</PayToDate><SubFlag>SubFlag</SubFlag></Risk><TellCode>TellCode</TellCode><TellText>TellText</TellText><TellerFlag>TellerFlag</TellerFlag><TellerFlag>TellerName</TellerFlag><TellerNo>12121</TellerNo><TransChnl>0</TransChnl><TransNo>222</TransNo><AgentComName>xczczcxx</AgentComName></Body></TranData>";
		
		// 日终对账响应报文
		//String responseXML = "<?xml version=\"1.0\" encoding=\"GBK\"?><TranData><Head> <Flag>0</Flag><!--交易结果代码,0成功，1失败--><Desc>交易成功！</Desc><!--交易结果描述--></Head><Body><Count>748</Count><!--总条数--><Detail> <ContNo>101-1578034</ContNo> <!--保单号--><Prem>15000000</Prem> <!--保费，单位分--> </Detail><Detail> <ContNo>101-1578042</ContNo> <!--保单号--><Prem>5000000</Prem><!--保费，单位分--> </Detail> </Body></TranData>";
		try {
			logger.info("响应报文：{}",XMLUtil.formatXML(responseXML));
		} catch (Exception e1) {
			logger.error("格式化响应报文出错:",e1);
			e1.printStackTrace();
		}
		return responseXML;
	}
	
	/**
	 * 方法名称: callBancassuranceRemoteService<br>
	 * 描述：调用银保远程接口服务
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6上午09:09:36
	 * @param method 远程方法名称
	 * @param parameters 参数列表
	 * @param returnClasses 返回值类型
	 * @return 服务方返回值
	 */
	public static Object callBancassuranceRemoteService(String method,Object[] parameters,@SuppressWarnings("rawtypes") Class[] returnClasses){
		logger.info("请求方法名称：{},请求参数：{},返回值类型：{}" ,method,parameters,returnClasses);
		return callRemoteService(BASIC_HTTP_BINDING_SERVICE_ADDRESS, BASIC_HTTP_BINDING_SERVICE_NAMESPACE, method, parameters, returnClasses);
	}
	
	/**
	 * 方法名称: callRemoteService<br>
	 * 描述：调用远程WebService方法接口
	 * 作者: wangpengfei
	 * 修改日期：2014-3-6上午09:09:36
	 * @param webServiceURL 远程WebService地址
	 * @param webServiceNamespace 远程WebService名称空间
	 * @param method 远程方法名称
	 * @param parameters 参数列表
	 * @param returnClasses 返回值类型
	 * @return 服务方返回值
	 */
	public static Object callRemoteService(String webServiceURL,String webServiceNamespace,String method,Object[] parameters,@SuppressWarnings("rawtypes") Class[] returnClasses){
		Object result = null;
		// 使用RPC方式调用WebService  
		 RPCServiceClient serviceClient = null;
		try {
			serviceClient = new RPCServiceClient();
		} catch (AxisFault e) {
			logger.error("AxisFault:",e);
			e.printStackTrace();
		}  
		Options options = serviceClient.getOptions();  
		// 指定调用WebService的URL  
		EndpointReference targetEPR = new EndpointReference(webServiceURL);
		options.setTo(targetEPR);  
		// 指定要调用的远程方法及WSDL文件的命名空间.....  
		QName opAddEntry = new QName(webServiceNamespace,method);  
		try {
			// invokeBlocking方法有三个参数，其中第一个参数的类型是QName对象，表示要调用的方法名；  
			// 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；  
			// 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。  
			// 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}  
			// 如果被调用的WebService方法没有返回值，应使用RPCServiceClient类的invokeRobust方法，  
			// 该方法只有两个参数，它们的含义与invokeBlocking方法的前两个参数的含义相同  
		result = serviceClient.invokeBlocking(opAddEntry,parameters, returnClasses)[0];
		
			
		} catch (AxisFault e) {
			logger.error("AxisFault:",e);
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static DoAppResponseE callRemoteService(DoAppE doAppE){
		TransServiceEndpointServiceStub _stub = null;
		DoAppResponseE ge = null;
		try {
			_stub = new TransServiceEndpointServiceStub();
			String channelId = PortalProp.getString("shortPolicyChannelId");
			String md5password = PortalProp.getString("shortPolicyChannelPassword");
			/*String channelId = "WECHAT01";
			String md5password = "4ba034b3f84de0cbef89d710d1d25ab6";*/
			OMFactory omFactory = OMAbstractFactory.getOMFactory();
			OMElement soapHeader = omFactory.createOMElement("ServiceAuthenticator",
			"http://ws.ec.omgd.com/", "");
			soapHeader.setText(channelId+"&"+md5password);
			OMNamespace ns = omFactory.createOMNamespace("http://schemas.xmlsoap.org/soap/envelope/","SOAPENV");
			OMAttribute omattribute = omFactory.createOMAttribute("actor", ns,
			SOAPConstants.URI_SOAP_1_2_ROLE_NEXT);
			soapHeader.addAttribute(omattribute);
			_stub._getServiceClient().addHeader(soapHeader);
			try {
				ge = _stub.doApp(doAppE);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ge;
	}
	
}

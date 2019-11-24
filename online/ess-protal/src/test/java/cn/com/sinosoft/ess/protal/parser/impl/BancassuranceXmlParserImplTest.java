/**
 * File Name:BancassuranceXmlParserImplTest.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-10上午09:57:07
 */
package cn.com.sinosoft.ess.protal.parser.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import cn.com.sinosoft.ess.protal.model.BaseInfo;
import cn.com.sinosoft.ess.protal.model.LCAppnt;
import cn.com.sinosoft.ess.protal.model.LCBnf;
import cn.com.sinosoft.ess.protal.model.LCCont;
import cn.com.sinosoft.ess.protal.model.TranData;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.BaseInfoBill;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.BillNum;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.Detail;
import cn.com.sinosoft.ess.protal.model.DailyBills.request.TranDataBill;
import cn.com.sinosoft.ess.protal.model.DailyBills.response.TranDataBillRes;
import cn.com.sinosoft.ess.protal.model.bank.request.BaseInfoYB;
import cn.com.sinosoft.ess.protal.model.bank.request.LCContYB;
import cn.com.sinosoft.ess.protal.model.bank.request.TranDataYB;
import cn.com.sinosoft.ess.protal.model.insure.BaseInfoReq;
import cn.com.sinosoft.ess.protal.model.insure.CashValue;
import cn.com.sinosoft.ess.protal.model.insure.CashValueList;
import cn.com.sinosoft.ess.protal.model.insure.LCAppntReq;
import cn.com.sinosoft.ess.protal.model.insure.LCBnfReq;
import cn.com.sinosoft.ess.protal.model.insure.LCContReq;
import cn.com.sinosoft.ess.protal.model.insure.LCInsuredReq;
import cn.com.sinosoft.ess.protal.model.insure.ResBaseInfo;
import cn.com.sinosoft.ess.protal.model.insure.ResContInfo;
import cn.com.sinosoft.ess.protal.model.insure.ResRisk;
import cn.com.sinosoft.ess.protal.model.insure.ResTranData;
import cn.com.sinosoft.ess.protal.model.insure.RiskReq;
import cn.com.sinosoft.ess.protal.model.insure.TranDataReq;
import cn.com.sinosoft.ess.protal.model.revoke.request.BaseInfoCD;
import cn.com.sinosoft.ess.protal.model.revoke.request.GuaranteeSlip;
import cn.com.sinosoft.ess.protal.model.revoke.request.TranDataCD;
import cn.com.sinosoft.ess.protal.model.revoke.response.TranDataCDRes;

/**描述：<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-10上午09:57:07 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public class BancassuranceXmlParserImplTest extends TestCase{
	
	SimpleDateFormat tranDate = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat tranTime = new SimpleDateFormat("HHmmss");
	Date date = new Date();
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	
	/**
	 * 方法名称: testInsureMarshal<br>
	 * 描述：核保报文组装
	 * 作者: GHY
	 * 修改日期：2014-3-12下午08:08:58
	 * @throws Exception
	 */
	public void testInsureMarshal() throws Exception{
        TranDataReq tranData = new TranDataReq();  
        
        BaseInfoReq baseInfo = new BaseInfoReq();
        
        //head
        baseInfo.setBankDate("20130101");
        baseInfo.setBankTime("bankTime");
        baseInfo.setBankCode("bankCode");
        baseInfo.setZoneNo("zoneNo");
        baseInfo.setTransrNo("transrNo");
        baseInfo.setFunctionFlag("functionFlag");
        baseInfo.setTellerNo("tellerNo");
        baseInfo.setTranSchnl("tranSchnl");
        
		tranData.setBaseInfo(baseInfo );
		
		
		//保单信息
        LCContReq lCCont = new LCContReq();
        lCCont.setProposalContNo("ProposalPrtNo");
        lCCont.setPolApplyDate("polApplyDate");
        lCCont.setGetPolMode("getPolMode");
        lCCont.setHealthNotice("healthNotice");
        lCCont.setContractEffDate("contractEffDate");
        lCCont.setDisCount("disCount");
        lCCont.setReferrer("referrer");
        lCCont.setReMobile("reMobile");
        
        //投保人信息
        LCAppntReq lCAppnt = new LCAppntReq();
        lCAppnt.setName("appntName");
        lCAppnt.setSex("sex");
        lCAppnt.setBirthday("birthday");
        lCAppnt.setIdentifytype("identifytype");
        lCAppnt.setIdentifynumber("identifynumber");
        lCAppnt.setVisaExpDate("visaExpDate");
        lCAppnt.setOccupationcode("occupationcode");
        lCAppnt.setNationality("EstSalary");
        lCAppnt.setStature("stature");
        lCAppnt.setWeight("weight");
        lCAppnt.setMarriage("marriage");
        lCAppnt.setMobile("mobile");
        lCAppnt.setzipCode("zipcode");
        lCAppnt.setAddress("address");
        lCAppnt.setHomephone("homephone");
        lCAppnt.setEmail("email");
        lCAppnt.setInsrelationapp("insrelationapp");
		lCCont.setLCAppnt(lCAppnt);
		
		//被保人信息
		List<LCInsuredReq> LCInsureds = new ArrayList<LCInsuredReq>();
		LCInsuredReq e = new LCInsuredReq();
		e.setCustomerNo("customerNo");
        e.setName("appntName");
        e.setSex("sex");
        e.setBirthday("birthday");
        e.setIdentifytype("identifytype");
        e.setIdentifynumber("identifynumber");
        e.setVisaExpDate("visaExpDate");
        e.setOccupationcode("occupationcode");
        e.setNationality("EstSalary");
        e.setStature("stature");
        e.setWeight("weight");
        e.setMobile("mobile");
        e.setMarriage("marriage");
        e.setzipCode("zipcode");
        e.setAddress("address");
        e.setHomephone("homephone");
        e.setEmail("email");
		LCInsureds.add(e);
		lCCont.setLCInsureds(LCInsureds);
		
		//险种信息
		List<RiskReq> risks = new ArrayList<RiskReq>();
		RiskReq risk = new RiskReq();
		risk.setRiskCode("riskCode");
		risk.setMainRiskCode("mainRiskCode");
		risk.setTranRiskCode("tranRiskCode");
		risk.setPrem("prem");
		risk.setMult("mult");
		risk.setAmnt("amnt");
		risk.setPayIntv("payIntv");
		risk.setInsuYearFlag("insuYearFlag");
		risk.setInsuYear("insuYear");
		risk.setPayEndYearFlag("payEndYearFlag");
		risk.setPayEndYear("payEndYear");
		risk.setGetIntv("getIntv");
		risk.setBonusGetMode("bonusGetMode");
		risks.add(risk);
		lCCont.setRisks(risks);
		
		
		//受益人信息
		List<LCBnfReq> lCBnfs = new ArrayList<LCBnfReq>();
		LCBnfReq o = new LCBnfReq();
		o.setBentype("bentype");
		o.setBenorder("benorder");
		o.setBenname("benname");
		o.setBenbirthday("benbirthday");
		o.setBensex("bensex");
		o.setBenidtype("benidtype");
		o.setBenidnumber("benidnumber");
		o.setGovtTermDate("govtTermDate");
		o.setBenrate("benrate");
		o.setBenrelationtopins("benrelationtopins");
		o.setBeneficType("beneficType");
		lCBnfs.add(o);
		lCCont.setLCBnfs(lCBnfs);
		tranData.setlCCont(lCCont);
       
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		String result = bancassuranceXmlParserImpl.marshal(tranData);
		System.out.println(result);
	}

	public void testMarshal() throws Exception{
        TranData tranData = new TranData();  
        
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setBankDate("20130101");
        
		tranData.setBaseInfo(baseInfo );
		
        LCCont lCCont = new LCCont();
        lCCont.setProposalContNo("proposalContNo");
        
        LCAppnt lCAppnt = new LCAppnt();
        lCAppnt.setAppntName("appntName");
		lCCont.setLCAppnt(lCAppnt);
        
		List<LCBnf> lCBnfs = new ArrayList<LCBnf>();
		
		LCBnf o = new LCBnf();
		o.setName("name");
		lCBnfs.add(o);
		
		lCCont.setLCBnfs(lCBnfs);
		
		tranData.setlCCont(lCCont);
		
		
       
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		String result = bancassuranceXmlParserImpl.marshal(tranData);
		System.out.println(result);
	}
	public void testUnmarshal() throws Exception{
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TranData><Head><TranDate>20130101</TranDate></Head><Body><Appnt><Name>appntName</Name></Appnt><LCBnfs><Bnf><Name>name</Name></Bnf></LCBnfs><ProposalPrtNo>proposalContNo</ProposalPrtNo></Body></TranData>";
		
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		TranData object = (TranData)bancassuranceXmlParserImpl.unmarshal(xml, TranData.class);
		System.out.println(object.getBaseInfo().getBankDate());
		//and print other properties
	}
	
	
	
	// 当日撤单请求报文 测试
	public void testTranDataCD() throws Exception{
		
		TranDataCD tranDataCD = new TranDataCD();
		
		BaseInfoCD baseInfo = new BaseInfoCD();
		baseInfo.setBankCode("00000");	
		baseInfo.setFuncFlag("测试编码");
		baseInfo.setTranCom("321");
		baseInfo.setTranDate(tranDate.format(date)+"");
		baseInfo.setTranNo("354654");
		baseInfo.setTranSchnl("12");
		baseInfo.setTranTime(tranTime.format(date)+"");
		baseInfo.setZoneNo("324534578654");
		tranDataCD.setBaseInfo(baseInfo);
		
		GuaranteeSlip guaranteeSlip = new GuaranteeSlip();
		
		guaranteeSlip.setContNo("239086758493758593");
		tranDataCD.setGuaranteeSlip(guaranteeSlip);
       
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		String result = bancassuranceXmlParserImpl.marshal(tranDataCD);
		System.out.println("=======当日撤单请求报文============");
		System.out.println(result);
	}
	
	// 银保通签单交易请求报文 
	public void testTranDataYB() throws Exception{
		TranDataYB tranDataYB = new TranDataYB();
		
		BaseInfoYB baseInfoYB = new BaseInfoYB();
		baseInfoYB.setBankCode("013");
		baseInfoYB.setFuncFlag("98728454382764");
		baseInfoYB.setTranCom("013");
		baseInfoYB.setTranDate(tranDate.format(date)+"");
		baseInfoYB.setTranNo("0000000000008343");
		baseInfoYB.setTranSchnl("11");
		baseInfoYB.setTranTime(tranTime.format(date)+"");
		baseInfoYB.setZoneNo("102000");
		
		tranDataYB.setBaseInfoYB(baseInfoYB);
		
		LCContYB lCContYB = new LCContYB();
		lCContYB.setContNo("410-0079849");
		lCContYB.setContPrtNo("20030000000000000405");
		lCContYB.setOldTranNo("0000000000008351");
		lCContYB.setProposalPrtNo("10030000000000004413");
		
		tranDataYB.setlCContYB(lCContYB);
		
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		String result = bancassuranceXmlParserImpl.marshal(tranDataYB);
		System.out.println("=======银保通签单交易请求报文============");
		System.out.println(result);
		
	}
	
	//当日撤单应答报文
	public void testTranDataCDRes() throws Exception{
		String xml = "<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"yes\"?><TranData><Head><Flag>0</Flag><Desc>交易成功！</Desc></Head></TranData>";
		//String XMLCode = new String(xml.getBytes(),"UTF-8");
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		TranDataCDRes object = (TranDataCDRes)bancassuranceXmlParserImpl.unmarshal(xml, TranDataCDRes.class);
		System.out.println("==========当日撤单应答报文==========");
		System.out.println(object.getBaseInfoCDRes().getDesc());
		System.out.println(object.getBaseInfoCDRes().getFlag());
		//and print other properties
	}
	
	// 当日撤单应答报文
	/*public void testTranDataCDRess() throws Exception{
		TranDataCDRes tranDataCDRes = new TranDataCDRes();
		
		BaseInfoCDRes baseInfoCDRes = new BaseInfoCDRes();
		baseInfoCDRes.setDesc("交易成功！");
		baseInfoCDRes.setFlag("0");
		tranDataCDRes.setBaseInfoCDRes(baseInfoCDRes);
		
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		String result = bancassuranceXmlParserImpl.marshal(tranDataCDRes);
		System.out.println("=======银保通签单交易请求报文============");
		System.out.println(result);
		
	}*/
	
	//日终对账请求报文
	public void testTranDataBill() throws Exception{
		
		TranDataBill tranDataBill = new TranDataBill();
		
		BaseInfoBill baseInfoBill = new BaseInfoBill();
		baseInfoBill.setBankCode("013");
		baseInfoBill.setFuncFlag("84843788902947");
		baseInfoBill.setTranCom("013");
		baseInfoBill.setTranDate(tranDate.format(date)+"");
		baseInfoBill.setTranNo("0000000000008343");
		baseInfoBill.setTranSchnl("11");
		baseInfoBill.setTranTime(tranTime.format(date)+"");
		baseInfoBill.setZoneNo("102000");
		
		tranDataBill.setBaseInfoBill(baseInfoBill);
		
		BillNum billNum = new BillNum();
		List<Detail> detailList = new ArrayList<Detail>();
		Detail detail = new Detail();
		detail.setContNo("101-1578034");
		detail.setPrem("15000000");
		
		Detail detail1 = new Detail();
		detail1.setContNo("101-1578042");
		detail1.setPrem("5000000");
		
		detailList.add(detail);
		detailList.add(detail1);
		
		billNum.setDetail(detailList);
		
		billNum.setCount("748");
		
		tranDataBill.setBillNum(billNum);
		
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		String result = bancassuranceXmlParserImpl.marshal(tranDataBill);
		System.out.println("=======日终对账请求报文============");
		System.out.println(result);
		
	}
	
	
	//日终对账应答报文
	public void testTranDataBillRes() throws Exception{
		String xml = "<?xml version=\"1.0\" encoding=\"GBK\"?><TranData><Head> <Flag>0</Flag><!--交易结果代码,0成功，1失败--><Desc>交易成功！</Desc><!--交易结果描述--></Head><Body><Count>748</Count><!--总条数--><Detail> <ContNo>101-1578034</ContNo> <!--保单号--><Prem>15000000</Prem> <!--保费，单位分--> </Detail><Detail> <ContNo>101-1578042</ContNo> <!--保单号--><Prem>5000000</Prem><!--保费，单位分--> </Detail> </Body></TranData>";
		
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		TranDataBillRes object = (TranDataBillRes)bancassuranceXmlParserImpl.unmarshal(xml, TranDataBillRes.class);
		System.out.println("==========日终对账应答报文==========");
		System.out.println(object.getBaseInfoBillRes().getDesc());
		System.out.println(object.getBaseInfoBillRes().getFlag());
		System.out.println(object.getBillNum().getCount());
		System.out.println(object.getBillNum().getDetail().get(0).getContNo());
		System.out.println(object.getBillNum().getDetail().get(0).getPrem());
		
		//and print other properties
	}
	/**银保通返回报文测试类*/
	public void testRes() throws Exception{
		String xml = "<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"yes\"?><TranData><Head><Desc>交易成功</Desc><Flag>0</Flag></Head><Body><AccTimeFlag>AccTimeFlag</AccTimeFlag><AgentCode>sad</AgentCode><Appnt><Address>address</Address><Birthday>birthday</Birthday></Appnt><Bnf><Birthday>benbirthday</Birthday><BeneficType>beneficType</BeneficType></Bnf><Insured><Address>address</Address><Birthday>birthday</Birthday></Insured><Risk><AddAmnt>addAmnt</AddAmnt><AddPrem>addPrem</AddPrem><Amnt>amnt</Amnt><CashValues><CashValue><Cash>5555-55</Cash><EndYear>00-99</EndYear></CashValue></CashValues></Risk></Body></TranData>";
		String xxx =testResInsur();
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		ResTranData object = (ResTranData)bancassuranceXmlParserImpl.unmarshal(xml, ResTranData.class);
        ResContInfo contInfo = new ResContInfo();//保单信息
    	 LCAppntReq lca = new LCAppntReq();
    	 List<LCInsuredReq> LCInsureds;	//被保人信息
    	 LCInsuredReq e = new LCInsuredReq();
    	 List<LCBnfReq> bnf = new ArrayList<LCBnfReq>();//受益人信息
    	 LCBnfReq o = new LCBnfReq();
    	 List<ResRisk> risks = new ArrayList<ResRisk>();//险种
    	 ResRisk risk = new ResRisk();
    	 List<CashValueList> cvl =  new ArrayList<CashValueList>();
	 	CashValueList cl = new  CashValueList();
	 	CashValue cv = new CashValue();
	 	cvl.add(cl);
    	 risks.add(risk);
		System.out.println("==========银保通返回报文==========");
		System.out.println(object.getBaseInfo().getDesc());
		System.out.println(object.getBaseInfo().getFlag());
		System.out.println(object.getContInfo().getAccTimeFlag());
		System.out.println(object.getContInfo().getAgentCode());
		System.out.println(object.getContInfo().getLCAppnt().getAddress());
		System.out.println(object.getContInfo().getLCAppnt().getBirthday());
		System.out.println(object.getContInfo().getLCBnfs());
		System.out.println(o.getBeneficType());
		System.out.println(e.getAddress());
		System.out.println(e.getBirthday());
		System.out.println(risk.getAmnt());
		System.out.println(cl.getCashValue());
		System.out.println(cv.getCash());
		System.out.println(cv.getEndYear());
        
	}
	
	
	public String  testResInsur() throws Exception{
		ResTranData tranData = new ResTranData();  
        ResBaseInfo baseInfo = new ResBaseInfo();
        baseInfo.setFlag("0");
        baseInfo.setDesc("交易成功");
        ResContInfo contInfo = new ResContInfo();//保单信息
		tranData.setBaseInfo(baseInfo);
		tranData.setContInfo(contInfo);
		
		contInfo.setTransChnl("12");	
		contInfo.setTransChnl("0");
		contInfo.setContNo("201210210214110");
		contInfo.setTransNo("222");
        contInfo.setAgentCom("1212");
        contInfo.setProposalPrtNo("1111");
        contInfo.setTellerNo("12121");
        contInfo.setBankManagerCode("1");
        contInfo.setBankManagerName("1");
        contInfo.setAgentManageCode("32");
        contInfo.setPrem("2");
        contInfo.setFirstAddPrem("1");
        contInfo.setPremText("234");
        contInfo.setAmnt("21");
        contInfo.setAmntText("123");
        contInfo.setRenewalPermit("123");
        contInfo.setBankAccNo("123");
        contInfo.setGetIntv("asd");
        contInfo.setPayOutStart("12");
        contInfo.setAutoPayFlag("sa");
        contInfo.setAxaAgentCode("123");
        contInfo.setAgentCode("sad");
        contInfo.setAgentName("312");
        contInfo.setAgentGrpCode("sda");
        contInfo.setAgentGrpName("xc");
        contInfo.setAgentCom("123");
        contInfo.setAgentComName("sdfsdf");
        contInfo.setZoneNo("xczczcxx");
        contInfo.setNodeNo("NodeNo");
        contInfo.setTellerFlag("TellerFlag");
        contInfo.setTellerName("TellerName");
        contInfo.setComCode("ComCode");
        contInfo.setComLocation("ComLocation");
        contInfo.setComName("ComName");
        contInfo.setComZipCode("ComZipCode");
        contInfo.setComPhone("ComPhone");
        contInfo.setAccTimeFlag("AccTimeFlag");
        contInfo.setContractNo("ContractNo");
        contInfo.setLoanAccountNo("LoanAccountNo");
        contInfo.setLoanProductCode("LoanProductCode");
        contInfo.setLoanAmount("LoanAmount");
        contInfo.setLoanStartDate("LoanStartDate");
        contInfo.setLoanEndDate("LoanEndDate");
        contInfo.setContractEffDate("ContractEffDate");
        contInfo.setContractEndDate("ContractEndDate");
        contInfo.setHighPremFlag("HighPremFlag");
        contInfo.setTellCode("TellCode");
        contInfo.setTellText("TellText");
        contInfo.setAppTellCode("AppTellCode");
        contInfo.setAppTellText("AppTellText");
        contInfo.setAppComFlag("AppComFlag");
        contInfo.setAppCom("AppCom");
        contInfo.setInsuComFlag("InsuComFlag");
        contInfo.setInsuCom("InsuCom");
        
      //投保人信息
        LCAppntReq lCAppnt = new LCAppntReq();
        lCAppnt.setName("appntName");
        lCAppnt.setSex("sex");
        lCAppnt.setBirthday("birthday");
        lCAppnt.setIdentifytype("identifytype");
        lCAppnt.setIdentifynumber("identifynumber");
        lCAppnt.setVisaExpDate("visaExpDate");
        lCAppnt.setOccupationcode("occupationcode");
        lCAppnt.setNationality("EstSalary");
        lCAppnt.setStature("stature");
        lCAppnt.setWeight("weight");
        lCAppnt.setMarriage("marriage");
        lCAppnt.setMobile("mobile");
        lCAppnt.setAddress("address");
        lCAppnt.setzipCode("zipcode");
        lCAppnt.setAddress("address");
        lCAppnt.setHomephone("homephone");
        lCAppnt.setEmail("email");
        lCAppnt.setInsrelationapp("insrelationapp");
		contInfo.setLCAppnt(lCAppnt);
		
		//被保人信息
		List<LCInsuredReq> LCInsureds = new ArrayList<LCInsuredReq>();
		LCInsuredReq e = new LCInsuredReq();
		e.setCustomerNo("customerNo");
        e.setName("appntName");
        e.setSex("sex");
        e.setBirthday("birthday");
        e.setIdentifytype("identifytype");
        e.setIdentifynumber("identifynumber");
        e.setVisaExpDate("visaExpDate");
        e.setOccupationcode("occupationcode");
        e.setNationality("EstSalary");
        e.setStature("stature");
        e.setWeight("weight");
        e.setMobile("mobile");
        e.setMarriage("marriage");
        e.setAddress("address");
        e.setzipCode("zipcode");
        e.setAddress("address");
        e.setHomephone("homephone");
        e.setEmail("email");
		LCInsureds.add(e);
		contInfo.setLCInsureds(LCInsureds);
		//险种信息
        List<ResRisk> resRsk =new ArrayList<ResRisk>();
        ResRisk risk = new ResRisk();
        risk.setRiskCode("riskCode");
		risk.setMainRiskCode("mainRiskCode");
		risk.setTranRiskCode("tranRiskCode");
		risk.setPrem("prem");
		risk.setMult("mult");
		risk.setAmnt("amnt");
		risk.setPayIntv("payIntv");
		risk.setInsuYearFlag("insuYearFlag");
		risk.setInsuYear("insuYear");
		risk.setPayEndYearFlag("payEndYearFlag");
		risk.setPayEndYear("payEndYear");
		
		risk.setPayEndDate("PayEndDate");
		risk.setCostIntv("CostIntv");
		risk.setCostDate("CostDate");
		risk.setPayToDate("PayToDate");
		risk.setGetYearFlag("GetYearFlag");
		risk.setGetStartDate("GetStartDate");
		risk.setGetYear("GetYear");
		risk.setGetIntv("GetIntv");
		risk.setGetBankCode("GetBankCode");
		risk.setGetBankAccNo("GetBankAccNo");
		risk.setGetAccName("GetAccName");
		risk.setAutoPayFlag("AutoPayFlag");
		risk.setBonusGetMode("BonusGetMode");
		risk.setSubFlag("SubFlag");
		risk.setFullBonusGetMode("FullBonusGetMode");
		risk.setAccountList("AccountList");
		//CashValue cv = new CashValue();
		List<CashValueList> cvl =  new ArrayList<CashValueList>();
		CashValueList cl = new  CashValueList();
		CashValue cv = new CashValue();
		cv.setCash("5555-55");
		cv.setEndYear("00-99");
		//cl.setCashValue(cv);
		cvl.add(cl);
		/**for(int i=0;i<10;i++){
			cv.setCash("11");
			cv.setEndYear("12312czxczxczx");
			cvl.add(cv);
		}*/
		risk.setCashValues(cvl);
        resRsk.add(risk);
        contInfo.setRisks(resRsk);
      //受益人信息
		List<LCBnfReq> lCBnfs = new ArrayList<LCBnfReq>();
		LCBnfReq o = new LCBnfReq();
		LCBnfReq o1 = new LCBnfReq();
		o.setBentype("bentype");
		o.setBenorder("benorder");
		o.setBenname("benname");
		o.setBenbirthday("benbirthday");
		o.setBensex("bensex");
		o.setBenidtype("benidtype");
		o.setBenidnumber("benidnumber");
		o.setGovtTermDate("govtTermDate");
		o.setBenrate("benrate");
		o.setBenrelationtopins("benrelationtopins");
		o.setBeneficType("beneficType");
		o1.setBeneficiaryno("beneficiaryno");
		o1.setBentype("bentype");
		o1.setBenorder("benorder");
		o1.setBenname("benname");
		o1.setBenbirthday("benbirthday");
		o1.setBensex("bensex");
		o1.setBenidtype("benidtype");
		o1.setBenidnumber("benidnumber");
		o1.setGovtTermDate("govtTermDate");
		o1.setBenrate("benrate");
		o1.setBenrelationtopins("benrelationtopins");
		o1.setBeneficType("beneficType");
		lCBnfs.add(o);
		//lCBnfs.add(o1);
		contInfo.setLCBnfs(lCBnfs);
		BancassuranceXmlParserImpl bancassuranceXmlParserImpl = new BancassuranceXmlParserImpl();
		String result = bancassuranceXmlParserImpl.marshal(tranData);
		System.out.println(result);
		return result;
	}
	
}

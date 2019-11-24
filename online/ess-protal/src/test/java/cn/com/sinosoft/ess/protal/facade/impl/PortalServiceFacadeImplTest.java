///**
// * File Name:PortalServiceFacadeImplTest.java
// * @Description: 
// * Copyright 2014 Sinosoft Company Ltd.
// * @author:wangpengfei
// * @version:v1.0
// * Createdate:2014-3-11下午05:12:00
// */
//package cn.com.sinosoft.ess.protal.facade.impl;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import junit.framework.TestCase;
//import cn.com.sinosoft.ess.protal.config.ServiceTradeTypeEnum;
//import cn.com.sinosoft.ess.protal.facade.AcordServiceContext;
//import cn.com.sinosoft.ess.protal.model.BaseInfo;
//import cn.com.sinosoft.ess.protal.model.LCAppnt;
//import cn.com.sinosoft.ess.protal.model.LCBnf;
//import cn.com.sinosoft.ess.protal.model.LCCont;
//import cn.com.sinosoft.ess.protal.model.TranData;
//import cn.com.sinosoft.ess.protal.model.DailyBills.request.BaseInfoBill;
//import cn.com.sinosoft.ess.protal.model.DailyBills.request.BillNum;
//import cn.com.sinosoft.ess.protal.model.DailyBills.request.Detail;
//import cn.com.sinosoft.ess.protal.model.DailyBills.request.TranDataBill;
//import cn.com.sinosoft.ess.protal.model.DailyBills.response.TranDataBillRes;
//import cn.com.sinosoft.ess.protal.model.bank.request.BaseInfoYB;
//import cn.com.sinosoft.ess.protal.model.bank.request.LCContYB;
//import cn.com.sinosoft.ess.protal.model.bank.request.TranDataYB;
//import cn.com.sinosoft.ess.protal.model.insure.BaseInfoReq;
//import cn.com.sinosoft.ess.protal.model.insure.CashValue;
//import cn.com.sinosoft.ess.protal.model.insure.LCAppntReq;
//import cn.com.sinosoft.ess.protal.model.insure.LCBnfReq;
//import cn.com.sinosoft.ess.protal.model.insure.LCContReq;
//import cn.com.sinosoft.ess.protal.model.insure.LCInsuredReq;
//import cn.com.sinosoft.ess.protal.model.insure.ResContInfo;
//import cn.com.sinosoft.ess.protal.model.insure.ResTranData;
//import cn.com.sinosoft.ess.protal.model.insure.RiskReq;
//import cn.com.sinosoft.ess.protal.model.insure.TranDataReq;
//import cn.com.sinosoft.ess.protal.model.revoke.request.BaseInfoCD;
//import cn.com.sinosoft.ess.protal.model.revoke.request.GuaranteeSlip;
//import cn.com.sinosoft.ess.protal.model.revoke.request.TranDataCD;
//import cn.com.sinosoft.ess.protal.model.revoke.response.TranDataCDRes;
//
///**描述：<br>
// * 作者：wangpengfei <br>
// * 修改日期：2014-3-11下午05:12:00 <br>
// * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
// */
//public class PortalServiceFacadeImplTest extends TestCase{
//	SimpleDateFormat tranDate = new SimpleDateFormat("yyyyMMdd");
//	SimpleDateFormat tranTime = new SimpleDateFormat("HHmmss");
//	Date date = new Date();
//			
//	public void testSendObjectToBancassurance(){
//		
//		//String resultXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TranData><Head><TranDate>20130101</TranDate></Head><Body><Appnt><Name>appntName</Name></Appnt><LCBnfs><Bnf><Name>name</Name></Bnf></LCBnfs><ProposalPrtNo>proposalContNo</ProposalPrtNo></Body></TranData>";
//		
//		TranData tranData = new TranData();  
//	        
//        BaseInfo baseInfo = new BaseInfo();
//        baseInfo.setBankDate("20130101");
//        
//        tranData.setBaseInfo(baseInfo );
//		
//        LCCont lCCont = new LCCont();
//        lCCont.setProposalContNo("proposalContNo");
//        
//        LCAppnt lCAppnt = new LCAppnt();
//        lCAppnt.setAppntName("appntName");
//		lCCont.setLCAppnt(lCAppnt);
//        
//		List<LCBnf> lCBnfs = new ArrayList<LCBnf>();
//		
//		LCBnf o = new LCBnf();
//		o.setName("name");
//		lCBnfs.add(o);
//		
//		lCCont.setLCBnfs(lCBnfs);
//		
//		tranData.setlCCont(lCCont);
//		
//		PortalServiceFacadeImpl PortalServiceFacadeImpl = new PortalServiceFacadeImpl();
//		String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_1.tradeType();
//		Object requestObject = tranData;
//		AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
//		AcordServiceContext r = PortalServiceFacadeImpl.sendObjectToBancassurance(acordServiceContext );
//		
//		TranData t = (TranData)r.getResultObject();
//		System.out.println("<TranData><TranData>"+t.getBaseInfo().getBankDate());
//	}
//	
//	
//	// 当日撤单请求报文及应答报文测试
//	public void testTranDataCD() throws Exception{
//		TranDataCD tranDataCD = new TranDataCD();
//		
//		BaseInfoCD baseInfo = new BaseInfoCD();
//		baseInfo.setBankCode("00000");	
//		baseInfo.setFuncFlag("123456");
//		baseInfo.setTranCom("321");
//		baseInfo.setTranDate(tranDate.format(date)+"");
//		baseInfo.setTranNo("354654");
//		baseInfo.setTranSchnl("12");
//		baseInfo.setTranTime(tranTime.format(date)+"");
//		baseInfo.setZoneNo("324534578654");
//		tranDataCD.setBaseInfo(baseInfo);
//		
//		GuaranteeSlip guaranteeSlip = new GuaranteeSlip();
//		
//		guaranteeSlip.setContNo("239086758493758593");
//		tranDataCD.setGuaranteeSlip(guaranteeSlip);
//       
//		System.out.println("=======当日撤单请求报文及应答报文测试============");
//
//
//		PortalServiceFacadeImpl PortalServiceFacadeImpl = new PortalServiceFacadeImpl();
//		String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_4.tradeType();
//		Object requestObject = tranDataCD;
//		AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
//		AcordServiceContext r = PortalServiceFacadeImpl.sendObjectToBancassurance(acordServiceContext );
//		
//		TranDataCDRes tranDataCDRes = (TranDataCDRes)r.getResultObject();
//		System.out.println("==<Desc>"+tranDataCDRes.getBaseInfoCDRes().getDesc()+"</Desc>==");
//		System.out.println("==<Flag>"+tranDataCDRes.getBaseInfoCDRes().getFlag()+"</Flag>==");
//		//System.out.println("==<Desc>"+tranDataCDRes.getBaseInfoCDRes().getDesc()+"</Desc>==");
//	}
//	
//	// 日终对账请求报文及日终对账应答报文测试
//	public void testTranDataBill() throws Exception{
//		TranDataBill tranDataBill = new TranDataBill();
//		
//		BaseInfoBill baseInfoBill = new BaseInfoBill();
//		baseInfoBill.setBankCode("013");
//		baseInfoBill.setFuncFlag("84843788902947");
//		baseInfoBill.setTranCom("013");
//		baseInfoBill.setTranDate(tranDate.format(date)+"");
//		baseInfoBill.setTranNo("0000000000008343");
//		baseInfoBill.setTranSchnl("11");
//		baseInfoBill.setTranTime(tranTime.format(date)+"");
//		baseInfoBill.setZoneNo("102000");
//		
//		tranDataBill.setBaseInfoBill(baseInfoBill);
//		
//		BillNum billNum = new BillNum();
//		List<Detail> detailList = new ArrayList<Detail>();
//		Detail detail = new Detail();
//		detail.setContNo("101-1578034");
//		detail.setPrem("15000000");
//		
//		Detail detail1 = new Detail();
//		detail1.setContNo("101-1578042");
//		detail1.setPrem("5000000");
//		
//		detailList.add(detail);
//		detailList.add(detail1);
//		
//		billNum.setDetail(detailList);
//		
//		billNum.setCount("748");
//		
//		tranDataBill.setBillNum(billNum);
//		
//		System.out.println("=======日终对账请求报文及日终对账应答报文测试============");
//
//		PortalServiceFacadeImpl PortalServiceFacadeImpl = new PortalServiceFacadeImpl();
//		String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_3.tradeType();
//		Object requestObject = tranDataBill;
//		AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
//		AcordServiceContext r = PortalServiceFacadeImpl.sendObjectToBancassurance(acordServiceContext );
//		
//		TranDataBillRes tranDataBillRes = (TranDataBillRes)r.getResultObject();
//		System.out.println("==<Desc>"+tranDataBillRes.getBaseInfoBillRes().getDesc()+"</Desc>==");
//		System.out.println("==<Flag>"+tranDataBillRes.getBaseInfoBillRes().getFlag()+"</Flag>==");
//		System.out.println("==<Count>"+tranDataBillRes.getBillNum().getCount()+"</Count>");
//		System.out.println("==<ContNo>"+tranDataBillRes.getBillNum().getDetail().get(0).getContNo()+"</ContNo>");
//		System.out.println("==<Prem>"+tranDataBillRes.getBillNum().getDetail().get(0).getPrem()+"</Prem>");
//	}
//	
//	
//	
//	/**
//	 * ghy
//	 * 核保请求以及响应
//	 */
//	public void testInsureMarshal() throws Exception{
//		DateFormat format = new SimpleDateFormat("yyyyMMdd");
//	    String date = format.format(new Date());
//	    
//	    DateFormat format1 = new SimpleDateFormat("hhddss");
//	    String  time= format1.format(new Date());
//	    
//		TranDataReq tranData = new TranDataReq();  
//        BaseInfoReq baseInfo = new BaseInfoReq();
//        
//        //head
//        baseInfo.setBankDate(date);
//        baseInfo.setBankTime(time);
//        baseInfo.setTransrNo("50461195");				//流水号
//        baseInfo.setZoneNo("01105");					//地区编码
//        baseInfo.setTellerNo("013");					//交易单位(银行/农信社/经代公司),013电商平台
//        baseInfo.setBankCode("013");					//银行代码 如：011工行，012广发,013电商平台
//        baseInfo.setFunctionFlag("");					//交易代码
//        baseInfo.setTranSchnl("11");					//渠道代码,11电商渠道
//        
//		tranData.setBaseInfo(baseInfo );
//		
//		
//		//保单信息
//        LCContReq lCCont = new LCContReq();
//        lCCont.setProposalContNo("2014021250461195");	//投保单(印刷)号
//        lCCont.setPolApplyDate(date);					//投保日期
//        lCCont.setGetPolMode("8");						//保单递送方式
//        lCCont.setHealthNotice("N");					//健康告知(N/Y)
//        lCCont.setContractEffDate("date");				//客户指定生效日期，若无指定请置空
//        lCCont.setDisCount("6");						//保费折扣，6折		
//        lCCont.setReferrer("referrer");					//推荐人姓名/会员号/营销代码
//        lCCont.setReMobile("");							//推荐人手机号
//        
//        //投保人信息
//        LCAppntReq lCAppnt = new LCAppntReq();
//        lCAppnt.setName("张慰春");				
//        lCAppnt.setSex("F");
//        lCAppnt.setBirthday("19630226");
//        lCAppnt.setIdentifytype("0");
//        lCAppnt.setVisaExpDate("");						//证件有效期
//        lCAppnt.setIdentifynumber("320402630226312");
//        lCAppnt.setOccupationcode("1601001");
//        lCAppnt.setNationality("156");					//国籍
//        lCAppnt.setyIncome("");							//投保人年均收入（单位：万）
//        lCAppnt.setStature("");							//身高(cm)  空值
//        lCAppnt.setWeight("");							//体重(g)  空值
//        lCAppnt.setMarriage("");						//婚否(N/Y) 空值
//        lCAppnt.setAddress("江苏省（市、区）常州市天宁区县（区）丽宝第花苑4丙601");
//        lCAppnt.setzipCode("100000");
//        lCAppnt.setMobile("13813663639");
//        lCAppnt.setHomephone("");
//        lCAppnt.setEmail("dinna.zhang@icbc-axa.cpm");
//        lCAppnt.setInsrelationapp("8");
//		lCCont.setLCAppnt(lCAppnt);
//		
//		//被保人信息
//		List<LCInsuredReq> LCInsureds = new ArrayList<LCInsuredReq>();
//		LCInsuredReq e = new LCInsuredReq();
//		e.setName("张慰春");				
//        e.setSex("F");
//        e.setBirthday("19630226");
//        e.setIdentifytype("0");
//        e.setVisaExpDate("");						//证件有效期
//        e.setIdentifynumber("320402630226312");
//        e.setOccupationcode("");					//职业代码
//        e.setNationality("156");					//国籍
//        e.setyIncome("");							//投保人年均收入（单位：万）
//        e.setStature("");							//身高(cm)  空值
//        e.setWeight("");							//体重(g)  空值
//        e.setMarriage("");							//婚否(N/Y) 空值
//        e.setAddress("江苏省（市、区）常州市天宁区县（区）丽宝第花苑4丙601");
//        e.setzipCode("100000");
//        e.setMobile("13813663639");
//        e.setHomephone("");
//        e.setEmail("dinna.zhang@icbc-axa.cpm");
//		LCInsureds.add(e);
//		lCCont.setLCInsureds(LCInsureds);
//		
//		//受益人信息
//		List<LCBnfReq> lCBnfs = new ArrayList<LCBnfReq>();
//		LCBnfReq o = new LCBnfReq();
//		o.setBentype("1");							//受益人类别
//		o.setBenorder("1");							//受益顺序
//		o.setBenname("周宁");						//姓名
//		o.setBensex("M");					
//		o.setBenbirthday("19890624");
//		o.setBenidtype("0");						//证件类型
//		o.setGovtTermDate("");						//证件期限
//		o.setBenidnumber("32040219890624311X");
//		o.setBenrate("100");						//受益人比例
//		o.setBenrelationtopins("3");				//与被保人关系
//		o.setBeneficType("N");						//受益人是否法定
//		lCBnfs.add(o);
//		lCCont.setLCBnfs(lCBnfs);
//		
//		//险种信息
//		List<RiskReq> risks = new ArrayList<RiskReq>();
//		RiskReq risk = new RiskReq();
//		risk.setRiskCode("AA");						//险种代码
//		risk.setMainRiskCode("AA");					//主险险种代码
//		risk.setPrem("2100");						//保险费(分)
//		risk.setMult("1");							//投保份数
//		risk.setAmnt("50000000");					//保额(分)
//		risk.setPayIntv("5");						//缴费频次
//		risk.setInsuYearFlag("4");					//保险年期年龄标志
//		risk.setInsuYear("365");					//保险年期年龄	
//		risk.setPayEndYearFlag("5");				//缴费年期年龄标志
//		risk.setPayEndYear("105");					//缴费年期年龄
//		risk.setGetIntv("10");						//生存金处理方式
//		risk.setBonusGetMode("1");					//红利处理方式
//		risks.add(risk);
//		lCCont.setRisks(risks);
//		
//		tranData.setlCCont(lCCont);
//		
//		
//		System.out.println("// 银保通核保交易请求报文 及银保通返回报文 响应报文测试");
//		PortalServiceFacadeImpl PortalServiceFacadeImpl = new PortalServiceFacadeImpl();
//		String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_1.tradeType();
//		Object requestObject = tranData;
//		AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
//		AcordServiceContext r = PortalServiceFacadeImpl.sendObjectToBancassurance(acordServiceContext );
//		
//		ResTranData resTranDataTbl = (ResTranData)r.getResultObject();
//		ResContInfo rbi = resTranDataTbl.getContInfo();
//		System.out.println("<Flag>"+resTranDataTbl.getBaseInfo().getFlag()+"</Flag>");
//		System.out.println("<Desc>"+resTranDataTbl.getBaseInfo().getDesc()+"</Desc>");
//		System.out.println("<TransChnl>"+rbi.getTransChnl()+"</TransChnl>");
//		System.out.println("<ContNo>"+rbi.getContNo()+"</ContNo>");
//		System.out.println("<TransNo>"+rbi.getTransNo()+"</TransNo>");
//		System.out.println("<ProposalPrtNo>"+rbi.getProposalPrtNo()+"</ProposalPrtNo>");
//		System.out.println("<TellerNo>"+rbi.getTellerNo()+"</TellerNo>");
//		System.out.println("<BankManagerCode>"+rbi.getBankManagerCode()+"</BankManagerCode>");
//		System.out.println("<BankManagerName>"+rbi.getBankManagerName()+"</BankManagerName>");
//		System.out.println("<AgentManageCode>"+rbi.getAgentManageCode()+"</AgentManageCode>");
//		System.out.println("<Prem>"+rbi.getPrem()+"</Prem>");
//		System.out.println("<FirstAddPrem>"+rbi.getFirstAddPrem()+"</FirstAddPrem>");
//		System.out.println("<PremText>"+rbi.getPremText()+"</PremText>");
//		System.out.println("<Amnt>"+rbi.getAmnt()+"</Amnt>");
//		System.out.println("<AmntText>"+rbi.getAmntText()+"</AmntText>");
//		System.out.println("<RenewalPermit>"+rbi.getRenewalPermit()+"</RenewalPermit>");
//		System.out.println("<BankAccNo>"+rbi.getBankAccNo()+"</BankAccNo>");
//		System.out.println("<GetIntv>"+rbi.getGetIntv()+"</GetIntv>");
//		System.out.println("<PayOutStart>"+rbi.getPayOutStart()+"</PayOutStart>");
//		System.out.println("<AutoPayFlag>"+rbi.getAutoPayFlag()+"</AutoPayFlag>");
//		System.out.println("<AXAAgentCode>"+rbi.getAxaAgentCode()+"</AXAAgentCode>");
//		System.out.println("<AgentCode>"+rbi.getAgentCode()+"</AgentCode>");
//		System.out.println("<AgentName>"+rbi.getAgentName()+"</AgentName>");
//		System.out.println("<AgentGrpCode>"+rbi.getAgentGrpCode()+"</AgentGrpCode>");
//		System.out.println("<AgentGrpName>"+rbi.getAgentGrpName()+"</AgentGrpName>");
//		System.out.println("<AgentCom>"+rbi.getAgentCom()+"</AgentCom>");
//		System.out.println("<AgentComName>"+rbi.getAgentComName()+"</AgentComName>");
//		System.out.println("<ZoneNo>"+rbi.getZoneNo()+"</ZoneNo>");
//		System.out.println("<NodeNo>"+rbi.getNodeNo()+"</NodeNo>");
//		System.out.println("<TellerFlag>"+rbi.getTellerFlag()+"</TellerFlag>");
//		System.out.println("<TellerName>"+rbi.getTellerName()+"</TellerName>");
//		System.out.println("<ComCode>"+rbi.getComCode()+"</ComCode>");
//		System.out.println("<ComLocation>"+rbi.getComLocation()+"</ComLocation>");
//		System.out.println("<ComName>"+rbi.getComName()+"</ComName>");
//		System.out.println("<ComZipCode>"+rbi.getComZipCode()+"</ComZipCode>");
//		System.out.println("<ComPhone>"+rbi.getComPhone()+"</ComPhone>");
//		System.out.println("<AccTimeFlag>"+rbi.getAccTimeFlag()+"</AccTimeFlag>");
//		System.out.println("<ContractNo>"+rbi.getContractNo()+"</ContractNo>");
//		System.out.println("<LoanAccountNo>"+rbi.getLoanAccountNo()+"</LoanAccountNo>");
//		System.out.println("<LoanProductCode>"+rbi.getLoanProductCode()+"</LoanProductCode>");
//		System.out.println("<LoanAmount>"+rbi.getLoanAmount()+"</LoanAmount>");
//		System.out.println("<LoanStartDate>"+rbi.getLoanStartDate()+"</LoanStartDate>");
//		System.out.println("<LoanEndDate>"+rbi.getLoanEndDate()+"</LoanEndDate>");
//		System.out.println("<ContractEffDate>"+rbi.getContractEffDate()+"</ContractEffDate>");
//		System.out.println("<ContractEndDate>"+rbi.getContractEndDate()+"</ContractEndDate>");
//		System.out.println("<HighPremFlag>"+rbi.getHighPremFlag()+"</HighPremFlag>");
//		System.out.println("<TellCode>"+rbi.getTellCode()+"</TellCode>");
//		System.out.println("<TellText>"+rbi.getTellText()+"</TellText>");
//		System.out.println("<AppTellCode>"+rbi.getAppTellCode()+"</AppTellCode>");
//		System.out.println("<AppTellText>"+rbi.getAppTellText()+"</AppTellText>");
//		System.out.println("<AppComFlag>"+rbi.getAppComFlag()+"</AppComFlag>");
//		System.out.println("<AppCom>"+rbi.getAppCom()+"</AppCom>");
//		System.out.println("<InsuComFlag>"+rbi.getInsuComFlag()+"</InsuComFlag>");
//		System.out.println("<InsuCom>"+rbi.getInsuCom()+"</InsuCom>");
//		
//		/*System.out.println("<AgentCom>"+resTranDataTbl.getContInfo().getAgentCom()+"</AgentCom>");
//		System.out.println("<Beneficiaryno()>"+resTranDataTbl.getContInfo().getLCBnfs().get(0).getBeneficiaryno()+"</Beneficiaryno()>");
//		System.out.println("<BankManagerCode>"+resTranDataTbl.getContInfo().getBankManagerCode()+"</BankManagerCode>");
//		System.out.println("<ComCode>"+resTranDataTbl.getContInfo().getComCode()+"</ComCode>");
//		System.out.println("<InsuCom>"+resTranDataTbl.getContInfo().getInsuCom()+"</InsuCom>");
//		System.out.println("<Homephone>"+resTranDataTbl.getContInfo().getLCInsureds().get(0).getHomephone()+"</Homephone>");*/
//		//账户信息
//		List<CashValue> list = rbi.getRisks().get(0).getCashValues().get(0).getCashValue();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println();
//			System.out.println("<CashValues><CashValue><EndYear>"+list.get(i).getEndYear()+"</EndYear><Cash>"+list.get(i).getCash()+"</Cash></CashValue></CashValues>");
//		}
//	}
//	
//	// 银保通签单交易请求报文  及 响应报文测试
//	public void testTranDataYB() throws Exception{
//		TranDataYB tranDataYB = new TranDataYB();
//		
//		BaseInfoYB baseInfoYB = new BaseInfoYB();
//		baseInfoYB.setBankCode("013");
//		baseInfoYB.setFuncFlag("98728454382764");
//		baseInfoYB.setTranCom("013");
//		baseInfoYB.setTranDate(tranDate.format(date)+"");
//		baseInfoYB.setTranNo("0000000000008343");
//		baseInfoYB.setTranSchnl("11");
//		baseInfoYB.setTranTime(tranTime.format(date)+"");
//		baseInfoYB.setZoneNo("102000");
//		
//		tranDataYB.setBaseInfoYB(baseInfoYB);
//		
//		LCContYB lCContYB = new LCContYB();
//		lCContYB.setContNo("410-0079849");
//		lCContYB.setContPrtNo("20030000000000000405");
//		lCContYB.setOldTranNo("0000000000008351");
//		lCContYB.setProposalPrtNo("10030000000000004413");
//		
//		tranDataYB.setlCContYB(lCContYB);
//		
//		PortalServiceFacadeImpl PortalServiceFacadeImpl = new PortalServiceFacadeImpl();
//		
//		String funcFlag = ServiceTradeTypeEnum.TRANDATA_HEAD_FUNCFLAG_1.tradeType();
//		Object requestObject = tranDataYB;
//		AcordServiceContext acordServiceContext = new AcordServiceContext(funcFlag, requestObject);
//		AcordServiceContext r = PortalServiceFacadeImpl.sendObjectToBancassurance(acordServiceContext );
//		
//		ResTranData resTranDataTbl = (ResTranData)r.getResultObject();
//		System.out.println("==<Desc>"+resTranDataTbl.getBaseInfo().getDesc()+"</Desc>");
//		System.out.println("==<Flag>"+resTranDataTbl.getBaseInfo().getFlag()+"</Flag>");
//		System.out.println("==<AgentCom>"+resTranDataTbl.getContInfo().getAgentCom()+"</AgentCom>==");
//		System.out.println("==<Amnt>"+resTranDataTbl.getContInfo().getAmnt()+"</Amnt>==");
//		//System.out.println("==<Cash>"+resTranDataTbl.getContInfo().getRisks().get(0).getCashValues().get(0).getCashValue().get(0).getCash()+"</Cash>==");
//		//System.out.println("==<EndYear>"+resTranDataTbl.getContInfo().getRisks().get(0).getCashValues().get(0).getCashValue().get(0).getEndYear()+"</EndYear>==");
//		System.out.println("==<Beneficiaryno()>"+resTranDataTbl.getContInfo().getLCBnfs().get(0).getBeneficiaryno()+"</Beneficiaryno()>==");
//		System.out.println("==<BankManagerCode>"+resTranDataTbl.getContInfo().getBankManagerCode()+"</BankManagerCode>==");
//		System.out.println("==<ComCode>"+resTranDataTbl.getContInfo().getComCode()+"</ComCode>==");
//		System.out.println("==<InsuCom>"+resTranDataTbl.getContInfo().getInsuCom()+"</InsuCom>==");
//		System.out.println("==<Homephone>"+resTranDataTbl.getContInfo().getLCInsureds().get(0).getHomephone()+"</Homephone>==");
//		System.out.println(resTranDataTbl.getContInfo().getRisks().get(0).getAccountList());
//		System.out.println(resTranDataTbl.getContInfo().getLCInsureds().get(0).getCustomerNo());
//		System.out.println(resTranDataTbl.getContInfo().getLCInsureds().get(0).getVisaExpDate());
//	}
//	
//	
//}

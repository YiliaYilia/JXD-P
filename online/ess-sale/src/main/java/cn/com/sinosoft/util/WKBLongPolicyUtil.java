package cn.com.sinosoft.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.domain.yinbaotongWKB.Accounts;
import cn.com.sinosoft.domain.yinbaotongWKB.BaseInfo;
import cn.com.sinosoft.domain.yinbaotongWKB.ChkDetail;
import cn.com.sinosoft.domain.yinbaotongWKB.ChkDetails;
import cn.com.sinosoft.domain.yinbaotongWKB.DailyBalance;
import cn.com.sinosoft.domain.yinbaotongWKB.LCAppnt;
import cn.com.sinosoft.domain.yinbaotongWKB.LCBnfs;
import cn.com.sinosoft.domain.yinbaotongWKB.LCCont;
import cn.com.sinosoft.domain.yinbaotongWKB.LCInsured;
import cn.com.sinosoft.domain.yinbaotongWKB.LCInsureds;
import cn.com.sinosoft.domain.yinbaotongWKB.Risk;
import cn.com.sinosoft.domain.yinbaotongWKB.Risks;
import cn.com.sinosoft.domain.yinbaotongWKB.TranData;
import cn.com.sinosoft.domain.yinbaotongWKB.TranRequest;

public class WKBLongPolicyUtil {
	
	public static Logger logger = LoggerFactory.getLogger(WKBLongPolicyUtil.class);
	
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	/**
	 * 实体转xml报文
	 * @param clazz 实体类所属Class
	 * @param t 实体
	 * @return
	 */
	public static  <T> String beanToXML(Class<T> clazz,T t){
		String str = ""; 
		try{
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
		    StringWriter sw = new StringWriter();
		    marshaller.marshal(t, sw);
		    str = sw.toString();
		}catch (JAXBException e) {
			logger.info("xml格式转换失败");
	        e.printStackTrace();  
	    }  
		return str;
	}
	
	
	 /**
	  * 报文转实体
	  * @param xml 报文
	  * @param clazz 实体类所属Class
	  * @return
	  */
	 public static<T> T XMLStringToBean(String xml,Class<T> clazz){
		 T t = null;
		 try{
	         JAXBContext context = JAXBContext.newInstance(clazz);  
	         Unmarshaller unmarshaller = context.createUnmarshaller();  
	         t = (T)unmarshaller.unmarshal(new StringReader(xml));
	     }catch (JAXBException e) {  
	    	 e.printStackTrace();  
	     } 
		 return t;
	 }
	 
	/**
	 * 报文阶段首字母的大小写转换
	 * @param xml 报文内容
	 * @param flag true:转大写 false:转小写
	 * @return
	 */
	public static String A2aOra2A(String xml,boolean flag){
		String[] strs = xml.split("<");
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		if(flag){
			for(int i=2;i<strs.length;i++){
				sb.append("<");
				char chr = strs[i].charAt(0);
				if(Character.isLetter(chr)){//如果是字母
					sb.append(Character.toUpperCase(chr)).append(strs[i].substring(1));
				}else{//如果非字母
					sb.append(chr).append(Character.toUpperCase(strs[i].charAt(1))).append(strs[i].substring(2));
				}
			}
		}else{
			for(int i=2;i<strs.length;i++){
				sb.append("<");
				char chr = strs[i].charAt(0);
				if(Character.isLetter(chr)){//如果是字母
					sb.append(Character.toLowerCase(chr)).append(strs[i].substring(1));
				}else{//如果非字母
					sb.append(chr).append(Character.toLowerCase(strs[i].charAt(1))).append(strs[i].substring(2));
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 向指定位置发送报文
	 * @param xmlStr
	 * @param url
	 * @return
	 */
	public static String sendXml(String xmlStr,String url){
		logger.info("发送内容: "+xmlStr);
		RequestEntity entity = null;
		String xml = null;
        try {
			entity = new StringRequestEntity(xmlStr, "text/xml","GBK");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
        PostMethod post = new PostMethod(url);//请求地址
        post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
        post.setRequestEntity(entity);//这里添加xml字符串
        // 指定请求内容的类型
        post.setRequestHeader("Content-type", "text/xml; charset=GBK");
        HttpClient httpclient = new HttpClient();//创建 HttpClient 的实例
        int result;
        try {
        result = httpclient.executeMethod(post);
        logger.info("Response status code: " + result);//返回200为成功
        logger.info("返回内容："+post.getResponseBodyAsString());//返回的内容
        xml = A2aOra2A(post.getResponseBodyAsString(),false);
        post.releaseConnection();//释放连接
        } catch (HttpException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
		return xml;
	}
	/**
	 * 调用试算接口
	 * @param birthday
	 * @param sex
	 * @param amnt
	 * @return
	 */
	public static List<String> calculate(String birthday,String sex,String amnt,String url,String unitcount,String brNo){
		String insuYearFlag =null;
		String insuYear = null;
		if(unitcount.equals("1")){
			 insuYearFlag = "4";
			 insuYear = "30";
		}else if(unitcount.equals("2")){
			insuYearFlag = "2";
			 insuYear = "80";
		}
		List<String> result = new ArrayList<String>();
		String TransrNo = getTransrNo();
		//拼报文
		LCBnfs lcbnfs = new LCBnfs("0",null);
		Accounts acconuts = new Accounts("1");
		List<Risk> risk = new  ArrayList<Risk>();
		risk.add(new Risk("TAWENKB-R","TAWENKB-R","017","1",amnt,"","20150506","","0.00","","1","",null,"","","4","10","","","","",insuYearFlag,insuYear,"","","","","","","","",acconuts,"N","N","Y","N",lcbnfs));
		risk.add(new Risk("WKBAR","TAWENKB-R","017","1",amnt,"","20150506","","0.00","","1","",null,"","","4","10","","","","",insuYearFlag,insuYear,"","","","","","","","",acconuts,"N","N","Y","N",lcbnfs));
		Risks risks = new Risks(2,risk);
		LCInsured lCInsured = new LCInsured("","林四",sex,birthday,"O","999999","","","","",null,"","","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公","310013","","","","","Y","SF",risks);
		LCAppnt lcAppnt = new LCAppnt("","林三","M","19831029","O","999888","20100501","20300501","","","","13957171471","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公寓","310013","","","linlei101291@sina.com","","120000.00","240000.00","0","CN",null,null,"SF");
		LCInsureds lcInsureds = new LCInsureds("1",lCInsured);
		BaseInfo BaseInfo = new BaseInfo("20150506",sdf.format(new Date()),"803","MSG01",brNo,"00000",TransrNo,"102","RT","","1","","","");
		LCCont LCCont = new LCCont("",TransrNo,"20150506","开心保包","MSG01","888888","1","1","","","4","8","","","","","","","RMB","","","","Y","","","","",lcAppnt,lcInsureds);
		TranRequest TranRequest = new TranRequest(BaseInfo,LCCont,null,null);
		TranData tranData = new TranData(TranRequest,null);
		String xmlStr = beanToXML(TranData.class,tranData);
		xmlStr = A2aOra2A(xmlStr,true);
		//发报文并接收
		String responeXml = sendXml(xmlStr,url);
		TranData respone = XMLStringToBean(A2aOra2A(responeXml,false),TranData.class);
		if(respone.gettranRequest().getRetData().getFlag().equals("1")){
			result.add(respone.gettranRequest().getlCCont().getPrem());
			result.add(respone.gettranRequest().getlCCont().getlCInsureds().getlCInsured().getRisks().getRisk().get(0).getPrem());
			result.add(respone.gettranRequest().getlCCont().getlCInsureds().getlCInsured().getRisks().getRisk().get(1).getPrem());
			return result;
		}else{
			result.add(respone.gettranRequest().getRetData().getDesc());
			return result;
		}
	}
	
	public static List<String> calculate(String birthday,String sex,String amnt,String url,String unitcount){
		String insuYearFlag =null;
		String insuYear = null;
		if(unitcount.equals("1")){
			 insuYearFlag = "4";
			 insuYear = "30";
		}else if(unitcount.equals("2")){
			insuYearFlag = "2";
			 insuYear = "80";
		}
		List<String> result = new ArrayList<String>();
		String TransrNo = getTransrNo();
		//拼报文
		LCBnfs lcbnfs = new LCBnfs("0",null);
		Accounts acconuts = new Accounts("1");
		List<Risk> risk = new  ArrayList<Risk>();
		risk.add(new Risk("TAWENKB-R","TAWENKB-R","017","1",amnt,"","20150506","","0.00","","1","",null,"","","4","10","","","","",insuYearFlag,insuYear,"","","","","","","","",acconuts,"N","N","Y","N",lcbnfs));
		risk.add(new Risk("WKBAR","TAWENKB-R","017","1",amnt,"","20150506","","0.00","","1","",null,"","","4","10","","","","",insuYearFlag,insuYear,"","","","","","","","",acconuts,"N","N","Y","N",lcbnfs));
		Risks risks = new Risks(2,risk);
		LCInsured lCInsured = new LCInsured("","林四",sex,birthday,"O","999999","","","","",null,"","","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公","310013","","","","","Y","SF",risks);
		LCAppnt lcAppnt = new LCAppnt("","林三","M","19831029","O","999888","20100501","20300501","","","","13957171471","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公寓","310013","","","linlei101291@sina.com","","120000.00","240000.00","0","CN",null,null,"SF");
		LCInsureds lcInsureds = new LCInsureds("1",lCInsured);
		BaseInfo BaseInfo = new BaseInfo("20150506",sdf.format(new Date()),"803","MSG01","A0000","00000",TransrNo,"102","RT","","1","","","");
		LCCont LCCont = new LCCont("",TransrNo,"20150506","开心保包","MSG01","888888","1","1","","","4","8","","","","","","","RMB","","","","Y","","","","",lcAppnt,lcInsureds);
		TranRequest TranRequest = new TranRequest(BaseInfo,LCCont,null,null);
		TranData tranData = new TranData(TranRequest,null);
		String xmlStr = beanToXML(TranData.class,tranData);
		xmlStr = A2aOra2A(xmlStr,true);
		//发报文并接收
		String responeXml = sendXml(xmlStr,url);
		TranData respone = XMLStringToBean(A2aOra2A(responeXml,false),TranData.class);
		if(respone.gettranRequest().getRetData().getFlag().equals("1")){
			result.add(respone.gettranRequest().getlCCont().getPrem());
			result.add(respone.gettranRequest().getlCCont().getlCInsureds().getlCInsured().getRisks().getRisk().get(0).getPrem());
			result.add(respone.gettranRequest().getlCCont().getlCInsureds().getlCInsured().getRisks().getRisk().get(1).getPrem());
			return result;
		}else{
			result.add(respone.gettranRequest().getRetData().getDesc());
			return result;
		}
	}
	
	public static String getTransrNo(){
		//计算交易流水号
		long now = System.currentTimeMillis();//获取当前毫秒时间戳
		String num = RandomStringUtils.random(3, false, true);//获取一个三位随机数
		String TransrNo = now+num;//交易流水号
		return TransrNo;
	}
	
	
	/**
	 * 填充默认信息
	 * @param risk
	 * @param lCInsured
	 * @param lcAppnt
	 * @param flag 102核保试算，100承保
	 * @return
	 */
	public static TranData padding(List<Risk> risk,LCInsured lCInsured,LCAppnt lcAppnt,LCCont lCCont,BaseInfo baseInfo){
		String TransrNo = getTransrNo();
		//补充被保险人险种信息默认值
		Accounts accounts = new Accounts("1");
		LCBnfs lcbnfs = new LCBnfs("0",null);
		for(Risk t:risk){
			t.setLCBnfs(lcbnfs);
			t.setAccounts(accounts);
//			t.setRiskCode("WENJIAXING");
//			t.setMainRiskCode("WENJIAXING");
			t.setBankRiskCode("017");
			t.setRiskType("1");
			t.setRate("");
			t.setRank("");
			t.setMult("");
			t.setPayIntv("1");//年缴
			t.setCostIntv("");
			t.setCostDate("");
			t.setYears("");
			t.setSpecContent("");
			t.setPayEndYearFlag("4");//缴费方式年
			t.setPayEndYear("10");//缴费期间
			t.setPayoutStart("");
			t.setPayoutEnd("");
			t.setGetYearFlag("");
			t.setGetYear("");
//			t.setInsuYearFlag("4"); //保障期限标志
//			t.setInsuYear("30");// 保障期限
			t.setGetIntv("");
			t.setGetBankCode("");
			t.setGetBankAccNo("");
			t.setGetAccName("");
			t.setAutoPayFlag("");
			t.setBonusPayMode("");
			t.setSubFlag("");
			t.setBonusGetMode("");
			t.setFinanceIndicator("N");
			t.setBeneficiaryIndicator("Y");
			t.setOccupationFlag("N");
			t.setHealthFlag("N");
			t.setCValiDate("");//生效日期为空，待返回
		}
		Risks risks = new Risks(2,risk);
		//补充被保人信息
		lCInsured.setPartyKey("");
		lCInsured.setIDEffDate("");
		lCInsured.setIDExpDate("");
		lCInsured.setJobCode("");
		lCInsured.setNationality("");
		lCInsured.setHomePhone("");
		lCInsured.setInsureCompanyPhone("");
		lCInsured.setInsuredMobile("");
		lCInsured.setHomeAddress(lcAppnt.getHomeAddress());
		lCInsured.setHomeZipCode("310013");
		lCInsured.setMailAddress("");
		lCInsured.setMailZipCode("");
		lCInsured.setEmail("");
		lCInsured.setRelaToMain("");
		//lCInsured.setRelaToAppnt("CH");//与投保人关系
		lCInsured.setAppntInsuredSame("Y");//投被保人是否同一人
		lCInsured.setRisks(risks);
		//补充投保人信息
		lcAppnt.setAppntPartyKey("");
		lcAppnt.setIDEffDate("");
		lcAppnt.setIDExpDate("");
		lcAppnt.setNationality("");
		lcAppnt.setAppntPhone("");
		lcAppnt.setAppntOfficePhone("");
		lcAppnt.setHomeZipCode("310013");//默认邮编
		lcAppnt.setMailAddress("");
		lcAppnt.setMailZipCode("");
		lcAppnt.setJobCode("");
		lcAppnt.setFamilyEstSalary("240000.00");//家庭年收入
		lcAppnt.setEstAnnualSalary("120000.00");//年收入
		lcAppnt.setLiveZone("0");//默认城镇
		//lcAppnt.setRelaToInsured("PA");//与被保人关系
		lcAppnt.setAddressState("");//省可为空
		lcAppnt.setCity("");//城市可为空
		lcAppnt.setAddressStateTC("CN");//国家为中国
		LCInsureds lcInsureds = new LCInsureds("1",lCInsured);//被保险人数量为1
		//保单信息
		lCCont.setContNo("");//保单号
		lCCont.setProposalContNo(TransrNo);//投保书号
		lCCont.setPolApplyDate(df.format(new Date()));
//		lCCont.setAccName("");
		lCCont.setPayIntv("1");//年交
		lCCont.setPayMode("1");
		//lCCont.setAccBankCode("MSG01");//保费
//		if(lCCont.getAccBankCode() == null || "".equals(lCCont.getAccBankCode().trim())){
//			lCCont.setAccBankCode("MSG01");
//		}
		lCCont.setEffDate("");
		lCCont.setExPayMode("4");
		lCCont.setGetPolMode("8");
		lCCont.setSpecContent("");
		lCCont.setPrtNo("");
		lCCont.setTempFeeNo("");
		lCCont.setAgentCode("");
		lCCont.setAgentGroup("");
		lCCont.setAgentName("");
		lCCont.setCurrencyTypeCode("RMB");
		lCCont.setCashEXF("");
		lCCont.setInvestDateInd("");
		lCCont.setPremOffsetMethod("");
		lCCont.setlCAppnt(lcAppnt);
		lCCont.setlCInsureds(lcInsureds);
		//基本信息
		baseInfo.setBankDate(df.format(new Date()));
		baseInfo.setBankTime(sdf.format(new Date()));
		baseInfo.setBankCode("803");
		baseInfo.setTellerNo("00000");
		baseInfo.setTransrNo(TransrNo);
		//baseInfo.setFunctionFlag(flag);
		baseInfo.setInsuID("RT");
		baseInfo.setOperator("");
		baseInfo.setSourceType("1");
		baseInfo.setBkSaleName("");
		baseInfo.setBkSaleCode("");
		baseInfo.setBkSaleCertNo("");
//		if(lCCont.getBankAccNo()==null||lCCont.getBankAccNo().equals("")){
//			lCCont.setBankAccNo("888888");//续保银行
//			lCCont.setRenewalPermit("N");//续保标志
//		}else{
			lCCont.setRenewalPermit("Y");//续保标志
//		}
		//baseInfo.setActyNo(ActyNo);//优惠活动码
		TranRequest TranRequest = new TranRequest(baseInfo,lCCont,null,null);
		TranData tranData = new TranData(TranRequest,null);
		return tranData;
	}
	
	
	/**
	 * 核保接口
	 * @param url 地址
	 * @param risk 被保险人险种信息
	 * @param lCInsured 被保人信息
	 * @param lcAppnt 投保人信息
	 * @return
	 */
	public static String underwriting(String url,List<Risk> risk,LCInsured lCInsured,LCAppnt lcAppnt,LCCont lCCont,BaseInfo baseInfo){
		baseInfo.setFunctionFlag("102");
		TranData tranData = padding(risk,lCInsured,lcAppnt,lCCont,baseInfo);
		String xmlStr = beanToXML(TranData.class,tranData);
		xmlStr = A2aOra2A(xmlStr,true);
		//发报文并接收
		String responeXml = sendXml(xmlStr,url);
		TranData respone = XMLStringToBean(A2aOra2A(responeXml,false),TranData.class);
		if(respone.gettranRequest().getRetData().getFlag().equals("1")){
			return "1";
		}else if(respone.gettranRequest().getRetData().getFlag().equals("2")){
			return "2";
		}else{
			return respone.gettranRequest().getRetData().getDesc();
		}
	}
	
	
	
	/**
	 * 调用承保接口
	 * @param url 接口地址
	 * @param risk 被保险人险种信息
	 * @param lCInsured 被保人信息
	 * @param lcAppnt 投保人信息
	 * @return flag 1成功 0失败
	 */
	public static Map<String,String> approved(String url,List<Risk> risk,LCInsured lCInsured,LCAppnt lcAppnt,LCCont lCCont,BaseInfo baseInfo){
		Map<String,String> map = new HashMap<String,String>();
		baseInfo.setFunctionFlag("100");
		TranData tranData = padding(risk,lCInsured,lcAppnt,lCCont,baseInfo);
		String xmlStr = beanToXML(TranData.class,tranData);
		xmlStr = A2aOra2A(xmlStr,true);
		//发报文并接收
		String responeXml = sendXml(xmlStr,url);
		TranData respone = XMLStringToBean(A2aOra2A(responeXml,false),TranData.class);
		if(respone.gettranRequest().getRetData().getFlag().equals("1")){
			String policycode = respone.gettranRequest().getlCCont().getContNo();//保单号
			String takeeffecttime = respone.gettranRequest().getlCCont().getcValiDate();//保单生效日期
			String filowno = respone.gettranRequest().getRetData().getTransrNo();//交易流水号
			map.put("policycode", policycode);
			map.put("takeeffecttime", takeeffecttime);
			map.put("filowno", filowno);
			map.put("flag","1");
		}else{
			String desc = respone.gettranRequest().getRetData().getDesc();
			map.put("flag","0");
			map.put("desc", desc);
		}
		return map;
		
	}
	
	/**
	 * 对账接口
	 * @param chkDetails 需要对账的保单
	 * 
	 * @return
	 */
	public static String check(ChkDetails chkDetails,String url){
		ChkDetail chkDetail = chkDetails.getChkDetail().get(0);//取出第一张保单;
		String bankDate = chkDetail.getTranDate();//投保日期
		BaseInfo baseInfo = new BaseInfo();
		baseInfo.setBankDate(bankDate);//银行交易日期
		baseInfo.setBankCode("803");//银行代码
		baseInfo.setZoneNo("MSG01");//地区代码
		baseInfo.setBrNo("A0000");//网点代码
		//baseInfo.setBankNode("MSG01");
		baseInfo.setTellerNo("");//柜员代码
		baseInfo.setTransrNo(getTransrNo());//交易流水号 
		baseInfo.setFunctionFlag("806");
		baseInfo.setInsuID("RT");
		baseInfo.setBalanceFlag("1");
		TranRequest tranRequest = new TranRequest();
		tranRequest.setBaseInfo(baseInfo);
		tranRequest.setChkDetails(chkDetails);
		TranData tranData = new TranData();
		tranData.settranRequest(tranRequest);
		String request = A2aOra2A(beanToXML(TranData.class,tranData), true);
		String respone = A2aOra2A(sendXml(request,url),false);
		DailyBalance dailyBalance = XMLStringToBean(respone, DailyBalance.class);
		String flag = dailyBalance.getFlag();
		if(flag==null){//对账失败
			TranData data = XMLStringToBean(respone, TranData.class);
			return data.gettranRequest().getRetData().getDesc();
		}else{
			return flag;
		}
	}

	
//	@Test
//	public void 对账(){
//		List<ChkDetail> ChkDetail = new ArrayList<ChkDetail>();
//		ChkDetails chkDetails = new ChkDetails();
//		String chkDetailCount = "1";
//		//张婕的保单
////		ChkDetail chkDetail1 = new ChkDetail();
////		chkDetail1.setBankCode("803");//银行代码
////		chkDetail1.setTranDate("20150730");//保单日期
////		chkDetail1.setZoneNo("MSG01");
////		chkDetail1.setBrNo("MSG01");
////		chkDetail1.setFuncFlag("100");//承保后的单子
////		chkDetail1.setTransrNo("1438244886871869");//承保时的流水号
////		chkDetail1.setPolNo("TN00002053");//承保的保单号
////		chkDetail1.setTranAmnt("360.00");//保费
////		chkDetail1.setConfirmFlag("1");//标志
//		
//		//黄又强的保单
////		ChkDetail chkDetail2 = new ChkDetail();
////		chkDetail2.setBankCode("803");//银行代码
////		chkDetail2.setTranDate("20150730");//保单日期
////		chkDetail2.setZoneNo("MSG01");
////		chkDetail2.setBrNo("MSG01");
////		chkDetail2.setFuncFlag("100");//承保后的单子
////		chkDetail2.setTransrNo("1438210307578296");//承保时的流水号
////		chkDetail2.setPolNo("TN00002037");//承保的保单号
////		chkDetail2.setTranAmnt("180.00");//保费
////		chkDetail2.setConfirmFlag("1");//标志
//		
//		//李文宇的保单
////		ChkDetail chkDetail3 = new ChkDetail();
////		chkDetail3.setBankCode("803");//银行代码
////		chkDetail3.setTranDate("20150729");//保单日期
////		chkDetail3.setZoneNo("MSG01");
////		chkDetail3.setBrNo("MSG01");
////		chkDetail3.setFuncFlag("100");//承保后的单子
////		chkDetail3.setTransrNo("1438143120412411");//承保时的流水号
////		chkDetail3.setPolNo("TN00002033");//承保的保单号
////		chkDetail3.setTranAmnt("180.00");//保费
////		chkDetail3.setConfirmFlag("1");//标志
//		
////		ChkDetail.add(chkDetail1);
////		ChkDetail.add(chkDetail2);
////		ChkDetail.add(chkDetail3);
//		
//		ChkDetail chkDetail = new ChkDetail();
//		chkDetail.setBankCode("803");//银行代码
//		chkDetail.setTranDate("20150906");//投保日期
//		chkDetail.setZoneNo("MSG01");
//		chkDetail.setBrNo("A0000");
//		chkDetail.setFuncFlag("100");//承保后的单子
//		chkDetail.setTransrNo("1441528611915387");//承保时的流水号
//		chkDetail.setPolNo("TN00002665");//承保的保单号
//		chkDetail.setTranAmnt("80.00");//保费
//		chkDetail.setConfirmFlag("1");//标志
//		
//		ChkDetail.add(chkDetail);
//		
//		chkDetails.setChkDetailCount(chkDetailCount);
//		chkDetails.setChkDetail(ChkDetail);
//		//System.out.println(check(chkDetails,"http://elifeb2bl.oldmutual-guodian.com/front/HTTPService"));//生产
//		System.out.println(check(chkDetails,"http://10.46.101.95:8080/pre/HTTPService"));//测试
//	}
	
	
//	//核保测试
//	public void hebao(){
//		List<Risk> risk =new ArrayList<Risk>();
//		Risk risk1 = new Risk();//被保险人险种信息
//		Risk risk2 = new Risk();//被保险人险种信息
//		risk1.setRiskCode("TAWENKB-R");
//		risk1.setMainRiskCode("TAWENKB-R");
//		risk1.setCValiDate("20160523");//生效日期
//		risk1.setAmnt("100000.00");//保额
//		risk1.setPrem("890.00");//保费
//		risk1.setInsuYearFlag("4");//保障期间标志
//		risk1.setInsuYear("30");//保障期间
//		risk2.setRiskCode("WKBAR");
//		risk2.setMainRiskCode("TAWENKB-R");
//		risk2.setCValiDate("20160523");//生效日期
//		risk2.setAmnt("100000.00");//保额
//		risk2.setPrem("840.00");//保费
//		risk2.setInsuYearFlag("4");//保障期间标志
//		risk2.setInsuYear("30");//保障期间
//		risk.add(risk1);
//		risk.add(risk2);
//		
//		LCInsured lCInsured = new LCInsured();//被保人信息
//		lCInsured.setName("李文宇");//被保人姓名
//		lCInsured.setBirthday("19800101");//被保人生日
//		lCInsured.setSex("M");//被保人性别
//		lCInsured.setIDType("I");//被保人证件类型
//		lCInsured.setIDNo("320101198001010693");//被保人证件号
//		LCAppnt lcAppnt = new LCAppnt();//投保人信息
//		lcAppnt.setAppntName("李文宇");//投保人姓名
//		lcAppnt.setAppntSex("M");//投保人性别
//		lcAppnt.setAppntIDType("I");//投保人证件类型
//		lcAppnt.setAppntIDNo("320101198001010693");//投保人证件号
//		lcAppnt.setAppntBirthday("19800101");//投保人生日
//		lcAppnt.setAppntMobile("13520222603");//投保人手机
//		lcAppnt.setEmail("1248999386@qq.com");//投保人邮箱
//		lcAppnt.setHomeAddress("北京市海淀区中关村");
//		LCCont lCCont = new LCCont();
//		lCInsured.setRelaToAppnt("SF");//与投保人关系(子女)
//		lcAppnt.setRelaToInsured("SF");//与被保人关系(父母)
//		lCCont.setAccBankCode("MSG01");  //银行编码
//		BaseInfo baseInfo = new BaseInfo();
//		baseInfo.setZoneNo("MSG01");
//		baseInfo.setBrNo("A0000");
//		
//		lCCont.setBillingType("Y");//是否银行代扣
//		lCCont.setBankBranchName("test");//分行名称
//		lCCont.setBankProvince("beijing");//开户行省
//		lCCont.setBankCity("beijing");//开户市
//		lCCont.setAccName("李文宇");//持卡人姓名
//		
//		System.out.println(underwriting("http://10.46.104.246:9900/front/HTTPService",risk, lCInsured, lcAppnt,lCCont,baseInfo));
//	}
//	
//	//试算测试
//	public void shisuan(){
//		System.out.println(calculate("19900112","M","500000.00","http://10.46.104.246:9900/front/HTTPService","1"));
//	}
//	
//	//承保测试
//	public void chengbao(){
//		List<Risk> risk =new ArrayList<Risk>();
//		Risk risk1 = new Risk();//被保险人险种信息
//		Risk risk2 = new Risk();//被保险人险种信息
//		risk1.setRiskCode("TAWENKB-R");
//		risk1.setMainRiskCode("TAWENKB-R");
//		risk1.setCValiDate("20160523");//生效日期
//		risk1.setAmnt("100000.00");//保额
//		risk1.setPrem("80.00");//保费
//		risk1.setInsuYearFlag("4");//保障期间标志
//		risk1.setInsuYear("30");//保障期间
//		risk2.setRiskCode("WKBAR");
//		risk2.setMainRiskCode("TAWENKB-R");
//		risk2.setCValiDate("20160523");//生效日期
//		risk2.setAmnt("100000.00");//保额
//		risk2.setPrem("80.00");//保费
//		risk2.setInsuYearFlag("4");//保障期间标志
//		risk2.setInsuYear("30");//保障期间
//		risk.add(risk1);
//		risk.add(risk2);
//		LCInsured lCInsured = new LCInsured();//被保人信息
//		lCInsured.setName("张伟");//被保人姓名
//		lCInsured.setBirthday("20130112");//被保人生日
//		lCInsured.setSex("M");//被保人性别
//		lCInsured.setIDType("O");//被保人证件类型
//		lCInsured.setIDNo("998883");//被保人证件号
//		LCAppnt lcAppnt = new LCAppnt();//投保人信息
//		lcAppnt.setAppntName("张婕");//投保人姓名
//		lcAppnt.setAppntSex("F");//投保人性别
//		lcAppnt.setAppntIDType("I");//投保人证件类型
//		lcAppnt.setAppntIDNo("110112198109039789");//投保人证件号
//		lcAppnt.setAppntBirthday("19810903");//投保人生日
//		lcAppnt.setAppntMobile("18501718555");//投保人手机
//		lcAppnt.setEmail("1248999386@qq.com");//投保人邮箱
//		lcAppnt.setHomeAddress("上海浦东灵山路600弄4号501");
//		LCCont lCCont = new LCCont();
//		lCInsured.setRelaToAppnt("CR");//与投保人关系(子女)
//		lcAppnt.setRelaToInsured("CR");//与被保人关系(父母)
//		lCCont.setAccBankCode("MSG02");
//		BaseInfo baseInfo = new BaseInfo();
//		baseInfo.setZoneNo("MSG02");
//		baseInfo.setBrNo("A0000");
//		baseInfo.setActyNo("");
//		
////		lCCont.setBillingType("Y");//是否银行代扣
////		lCCont.setBankBranchName("test");//分行名称
////		lCCont.setBankProvince("beijing");//开户行省
////		lCCont.setBankCity("beijing");//开户市
//		System.out.println(approved("http://10.46.104.246:9900/front/HTTPService",risk, lCInsured, lcAppnt,lCCont,baseInfo));//测试
//		//System.out.println(approved("http://elifeb2bl.oldmutual-guodian.com/front/HTTPService",risk, lCInsured, lcAppnt,lCCont,""));//生产
//	}
//	
//	public static void main(String[] args) {
//		WKBLongPolicyUtil a =new WKBLongPolicyUtil();
//		 a.hebao();
//		a.shisuan();
		//a.chengbao();
//		String url="http://10.46.101.95:8080/pre/HTTPService";
//		sendXml("<?xml version=\"1.0\" encoding=\"GBK\"?><TranData><TranRequest><BaseInfo><BankCode>803</BankCode><BankDate>20150506</BankDate><BankTime>16:28:57</BankTime><BkSaleCertNo></BkSaleCertNo><BkSaleCode></BkSaleCode><BkSaleName></BkSaleName><BrNo>A0000</BrNo><FunctionFlag>102</FunctionFlag><InsuID>RT</InsuID><Operator></Operator><SourceType>1</SourceType><TellerNo>00000</TellerNo><TransrNo>1446539337689657</TransrNo><ZoneNo>MSG01</ZoneNo></BaseInfo><LCCont><AccBankCode>MSG01</AccBankCode><AccName>开心保包</AccName><AgentCode></AgentCode><AgentGroup></AgentGroup><AgentName></AgentName><BankAccNo>888888</BankAccNo><CashEXF></CashEXF><ContNo></ContNo><CurrencyTypeCode>RMB</CurrencyTypeCode><EffDate></EffDate><ExPayMode>4</ExPayMode><GetPolMode>8</GetPolMode><InvestDateInd></InvestDateInd><PayIntv>1</PayIntv><PayMode>1</PayMode><PolApplyDate>20150506</PolApplyDate><PremOffsetMethod></PremOffsetMethod><ProposalContNo>1446539337689657</ProposalContNo><PrtNo></PrtNo><RenewalPermit>Y</RenewalPermit><SpecContent></SpecContent><SumPrem></SumPrem><TempFeeNo></TempFeeNo><LCAppnt><AddressStateTC>CN</AddressStateTC><AppntBirthday>19831029</AppntBirthday><AppntIDNo>999888</AppntIDNo><AppntIDType>O</AppntIDType><AppntMobile>13957171471</AppntMobile><AppntName>林三</AppntName><AppntOfficePhone></AppntOfficePhone><AppntPartyKey></AppntPartyKey><AppntPhone></AppntPhone><AppntSex>M</AppntSex><Email>linlei101291@sina.com</Email><EstAnnualSalary>120000.00</EstAnnualSalary><FamilyEstSalary>240000.00</FamilyEstSalary><HomeAddress>浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公寓</HomeAddress><HomeZipCode>310013</HomeZipCode><IDEffDate>20100501</IDEffDate><IDExpDate>20300501</IDExpDate><JobCode></JobCode><LiveZone>0</LiveZone><MailAddress></MailAddress><MailZipCode></MailZipCode><Nationality></Nationality><RelaToInsured>PA</RelaToInsured></LCAppnt><LCInsureds><LCInsuredCount>1</LCInsuredCount><LCInsured><AppntInsuredSame>N</AppntInsuredSame><Birthday>19900112</Birthday><Email></Email><HomeAddress>浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公</HomeAddress><HomeZipCode>310013</HomeZipCode><IDEffDate></IDEffDate><IDExpDate></IDExpDate><IDNo>999999</IDNo><IDType>O</IDType><InsureCompanyPhone></InsureCompanyPhone><InsuredMobile></InsuredMobile><JobCode></JobCode><MailAddress></MailAddress><MailZipCode></MailZipCode><Name>林四</Name><Nationality></Nationality><PartyKey></PartyKey><RelaToAppnt>CH</RelaToAppnt><RelaToMain></RelaToMain><Risks><Risk><Accounts><AccountCount>1</AccountCount></Accounts><Amnt>100000.00</Amnt><AutoPayFlag></AutoPayFlag><BankRiskCode>017</BankRiskCode><BeneficiaryIndicator>Y</BeneficiaryIndicator><BonusGetMode></BonusGetMode><BonusPayMode></BonusPayMode><CValiDate>20150506</CValiDate><CostIntv></CostIntv><FinanceIndicator>N</FinanceIndicator><GetAccName></GetAccName><GetBankAccNo></GetBankAccNo><GetBankCode></GetBankCode><GetIntv></GetIntv><GetYear></GetYear><GetYearFlag></GetYearFlag><HealthFlag>N</HealthFlag><InsuYear>30</InsuYear><InsuYearFlag>4</InsuYearFlag><LCBnfs><LCBnfCount>0</LCBnfCount></LCBnfs><MainRiskCode>TAWENKB-R</MainRiskCode><Mult></Mult><OccupationFlag>N</OccupationFlag><PayEndYear>10</PayEndYear><PayEndYearFlag>4</PayEndYearFlag><PayIntv>1</PayIntv><PayoutEnd></PayoutEnd><PayoutStart></PayoutStart><Prem>0.00</Prem><Rank></Rank><Rate></Rate><RiskCode>TAWENKB-R</RiskCode><RiskType>1</RiskType><SpecContent></SpecContent><SubFlag></SubFlag><Years></Years></Risk><Risk><Accounts><AccountCount>1</AccountCount></Accounts><Amnt>100000.00</Amnt><AutoPayFlag></AutoPayFlag><BankRiskCode>017</BankRiskCode><BeneficiaryIndicator>Y</BeneficiaryIndicator><BonusGetMode></BonusGetMode><BonusPayMode></BonusPayMode><CValiDate>20150506</CValiDate><CostIntv></CostIntv><FinanceIndicator>N</FinanceIndicator><GetAccName></GetAccName><GetBankAccNo></GetBankAccNo><GetBankCode></GetBankCode><GetIntv></GetIntv><GetYear></GetYear><GetYearFlag></GetYearFlag><HealthFlag>N</HealthFlag><InsuYear>30</InsuYear><InsuYearFlag>4</InsuYearFlag><LCBnfs><LCBnfCount>0</LCBnfCount></LCBnfs><MainRiskCode>TAWENKB-R</MainRiskCode><Mult></Mult><OccupationFlag>N</OccupationFlag><PayEndYear>10</PayEndYear><PayEndYearFlag>4</PayEndYearFlag><PayIntv>1</PayIntv><PayoutEnd></PayoutEnd><PayoutStart></PayoutStart><Prem>0.00</Prem><Rank></Rank><Rate></Rate><RiskCode>WKBAR</RiskCode><RiskType>1</RiskType><SpecContent></SpecContent><SubFlag></SubFlag><Years></Years></Risk><RiskCount>2</RiskCount></Risks><Sex>M</Sex></LCInsured></LCInsureds></LCCont></TranRequest></TranData>",url);
//	}
}

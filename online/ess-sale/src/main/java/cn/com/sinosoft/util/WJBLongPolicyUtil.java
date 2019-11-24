package cn.com.sinosoft.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

import cn.com.sinosoft.domain.yinbaotong.Accounts;
import cn.com.sinosoft.domain.yinbaotong.BaseInfo;
import cn.com.sinosoft.domain.yinbaotong.ChkDetail;
import cn.com.sinosoft.domain.yinbaotong.ChkDetails;
import cn.com.sinosoft.domain.yinbaotong.DailyBalance;
import cn.com.sinosoft.domain.yinbaotong.LCAppnt;
import cn.com.sinosoft.domain.yinbaotong.LCBnfs;
import cn.com.sinosoft.domain.yinbaotong.LCCont;
import cn.com.sinosoft.domain.yinbaotong.LCInsured;
import cn.com.sinosoft.domain.yinbaotong.LCInsureds;
import cn.com.sinosoft.domain.yinbaotong.Risk;
import cn.com.sinosoft.domain.yinbaotong.Risks;
import cn.com.sinosoft.domain.yinbaotong.TranData;
import cn.com.sinosoft.domain.yinbaotong.TranRequest;

public class WJBLongPolicyUtil {
	
	public static Logger logger = LoggerFactory.getLogger(WJBLongPolicyUtil.class);
	
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
	public static String calculate(String birthday,String sex,String identifynumber,String amnt,String url,String brNo,String payment_time,String insuYearFlag){
		String TransrNo = getTransrNo();
		String InsuYear = null;
		if("4".equals(insuYearFlag)){
			InsuYear = "30";
		}else if("2".equals(insuYearFlag)){
			InsuYear = "75";
		}
		//拼报文 
		LCBnfs lcbnfs = new LCBnfs("0",null);
		Accounts acconuts = new Accounts("1");
		Risk risk = new Risk("WENJIABAO","WENJIABAO","","1",amnt,"","20150506","","0.00","","1","",null,"","","4",payment_time,"","","","",insuYearFlag,InsuYear,"","","","","","","","",acconuts,"N","N","Y","N",lcbnfs);
		Risks risks = new Risks(1,risk);
//		LCInsured lCInsured = new LCInsured("","林四",sex,birthday,"O",IDNo,"","",jobCode,"","","","","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公","310013","","","","","Y","SF","CHN","ZJ","HZ","1",risks);
		LCInsured lCInsured = new LCInsured("","林四",sex,birthday,"O","777777","","","","","","","","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公","310013","","","","","Y","SF","CHN","ZJ","HZ","1",risks);
//		LCAppnt lcAppnt = new LCAppnt("","林四",sex,birthday,"O","999888","20100501","21300501","","","","13957171471","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公寓","310013","","","linlei101291@sina.com",jobCode,"120000.00","240000.00","0","CHN","ZJ","HZ","SF","1");
		LCAppnt lcAppnt = new LCAppnt("","林四",sex,birthday,"O","999888","20100501","21300501","","","","13957171471","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公寓","310013","","","linlei101291@sina.com","","120000.00","240000.00","0","CHN","ZJ","HZ","SF","1");
		LCInsureds lcInsureds = new LCInsureds("1",lCInsured);
		BaseInfo BaseInfo = new BaseInfo("20150506",sdf.format(new Date()),"803","MSG01",brNo,"00000",TransrNo,"102","RT","","1","","","");
//		LCCont LCCont = new LCCont("",TransrNo,"20150506","开心保包","MSG01","888888","1","1","","","4","8",yfCode,"","","","","","RMB","","","","Y","","","",lcAppnt,lcInsureds);
		LCCont LCCont = new LCCont("",TransrNo,"20150506","开心保包","MSG01","888888","1","1","","","4","8","N","","","","","","RMB","","","","Y","","","",lcAppnt,lcInsureds);
		TranRequest TranRequest = new TranRequest(BaseInfo,LCCont,null,null);
		TranData tranData = new TranData(TranRequest,null);
		String xmlStr = beanToXML(TranData.class,tranData);
		xmlStr = A2aOra2A(xmlStr,true);
		//发报文并接收
		String responeXml = sendXml(xmlStr,url);
		TranData respone = XMLStringToBean(A2aOra2A(responeXml,false),TranData.class);
		if(respone.gettranRequest().getRetData().getFlag().equals("1")){
			return respone.gettranRequest().getlCCont().getlCInsureds().getlCInsured().getRisks().getRisk().getPrem();
		}else{
			return respone.gettranRequest().getRetData().getDesc();
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
	public static TranData padding(Risk risk,LCInsured lCInsured,LCAppnt lcAppnt,LCCont lCCont,BaseInfo baseInfo,String insuYearFlag,String payEndYear){
		String InsuYear = null;
		if("4".equals(insuYearFlag)){
			InsuYear = "30";
		}else if("2".equals(insuYearFlag)){
			InsuYear = "75";
		}
		String TransrNo = getTransrNo();
		//补充被保险人险种信息默认值
		Accounts accounts = new Accounts("1");
		LCBnfs lcbnfs = new LCBnfs("0",null);
		risk.setLCBnfs(lcbnfs);
		risk.setAccounts(accounts);
		risk.setRiskCode("WENJIABAO");
		risk.setMainRiskCode("WENJIABAO");
		risk.setBankRiskCode("");
		risk.setRiskType("1");
		risk.setRate("");
		risk.setRank("");
		risk.setMult("");
		risk.setPayIntv("1");//年缴
		risk.setCostIntv("");
		risk.setCostDate("");
		risk.setYears("");
		risk.setSpecContent("");
		risk.setPayEndYearFlag("4");//缴费方式 年
		risk.setPayEndYear(payEndYear);//缴费期间
		risk.setPayoutStart("");
		risk.setPayoutEnd("");
		risk.setGetYearFlag("");
		risk.setGetYear("");
		risk.setInsuYearFlag(insuYearFlag);
		risk.setInsuYear(InsuYear); 
		risk.setGetIntv("");
		risk.setGetBankCode("");
		risk.setGetBankAccNo("");
		risk.setGetAccName("");
		risk.setAutoPayFlag("");
		risk.setBonusPayMode("");
		risk.setSubFlag("");
		risk.setBonusGetMode("");
		risk.setFinanceIndicator("N");
		risk.setBeneficiaryIndicator("Y");
		risk.setOccupationFlag("N");
		risk.setHealthFlag("N");
		risk.setCValiDate("");//生效日期为空，待返回
		Risks risks = new Risks(1,risk);
		//补充被保人信息
		lCInsured.setPartyKey("");
		lCInsured.setIDEffDate("");
		lCInsured.setIDExpDate("");
		lCInsured.setNationality("");
		lCInsured.setHomePhone("");
		lCInsured.setInsureCompanyPhone("");
		lCInsured.setInsuredMobile("");
		lCInsured.setAddressStateTC("CHN"); //被保人国家 CN中国
		lCInsured.setHomeZipCode("310013");
		lCInsured.setMailAddress("");
		lCInsured.setMailZipCode("");
		lCInsured.setEmail("");
		lCInsured.setRelaToMain("");
		lCInsured.setAppntInsuredSame("Y");//投被保人是否同一人
		lCInsured.setRisks(risks);
		lCInsured.setTaxPayer("1");
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
		lcAppnt.setFamilyEstSalary("240000.00");//家庭年收入
		lcAppnt.setEstAnnualSalary("120000.00");//年收入
		lcAppnt.setLiveZone("0");//默认城镇
		lcAppnt.setAddressStateTC("CHN");//国家为中国
		lcAppnt.setTaxPayer("1");
		LCInsureds lcInsureds = new LCInsureds("1",lCInsured);//被保险人数量为1
		//保单信息
		lCCont.setContNo("");//保单号
		lCCont.setProposalContNo(TransrNo);//投保书号
		lCCont.setPolApplyDate(df.format(new Date()));
		lCCont.setPayIntv("1");//年交
		lCCont.setPayMode("1");
		lCCont.setEffDate("");
		lCCont.setExPayMode("4");
		lCCont.setGetPolMode("8");
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
		baseInfo.setInsuID("RT");
		baseInfo.setOperator("");
		baseInfo.setSourceType("1");
		baseInfo.setBkSaleName("");
		baseInfo.setBkSaleCode("");
		baseInfo.setBkSaleCertNo("");
			
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
	public static String underwriting(String url,Risk risk,LCInsured lCInsured,LCAppnt lcAppnt,LCCont lCCont,BaseInfo baseInfo,String insuYearFlag,String payEndYear){
		baseInfo.setFunctionFlag("102");
		TranData tranData = padding(risk,lCInsured,lcAppnt,lCCont,baseInfo,insuYearFlag,payEndYear);
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
	public static Map<String,String> approved(String url,Risk risk,LCInsured lCInsured,LCAppnt lcAppnt,LCCont lCCont,BaseInfo baseInfo,String payEndYearFlag, String payEndYear){
		Map<String,String> map = new HashMap<String,String>();
		baseInfo.setFunctionFlag("100");
		TranData tranData = padding(risk,lCInsured,lcAppnt,lCCont,baseInfo,payEndYearFlag,payEndYear);
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
	
//	
//	//核保测试
//	public void hebao(){
//		Risk risk = new Risk();//被保险人险种信息
//		risk.setCValiDate("20150720");//生效日期
//		risk.setAmnt("100000.00");//保额
//		risk.setPrem("80.00");//保费
//		LCInsured lCInsured = new LCInsured();//被保人信息
//		lCInsured.setName("张伟");//被保人姓名
//		lCInsured.setBirthday("19900112");//被保人生日
//		lCInsured.setSex("M");//被保人性别
//		lCInsured.setIDType("O");//被保人证件类型
//		lCInsured.setIDNo("998883");//被保人证件号
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
//		lCInsured.setRelaToAppnt("CR");//与投保人关系(子女)
//		lcAppnt.setRelaToInsured("CR");//与被保人关系(父母)
//		lCCont.setAccBankCode("MSG01");
//		BaseInfo baseInfo = new BaseInfo();
//		baseInfo.setZoneNo("MSG01");
//		baseInfo.setBrNo("A0000");
//		System.out.println(underwriting("http://10.46.101.95:8080/pre/HTTPService",risk, lCInsured, lcAppnt,lCCont,baseInfo));
//	}
//	
	//试算测试
//	@Test
//	public void shisuan(){
//		System.out.println(calculate("19920822","M","142727199208224516","100000.00","http://10.46.101.95:8080/pre/HTTPService","A0000", "3", "4"));
//	}
//	
//	//承保测试
//	public void chengbao(){
//		Risk risk = new Risk();//被保险人险种信息
//		risk.setAmnt("100000.00");//保额
//		risk.setPrem("80.00");//保费
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
//		System.out.println(approved("http://10.46.101.95:8080/pre/HTTPService",risk, lCInsured, lcAppnt,lCCont,baseInfo));//测试
//		//System.out.println(approved("http://elifeb2bl.oldmutual-guodian.com/front/HTTPService",risk, lCInsured, lcAppnt,lCCont,""));//生产
//	}
	
//	public static void main(String[] args) {
//		WJXLongPolicyUtil a =new WJXLongPolicyUtil();
		// TODO Auto-generated method stub
		//a.hebao();
		//a.hebao();
		//a.chengbao();
//	}
}

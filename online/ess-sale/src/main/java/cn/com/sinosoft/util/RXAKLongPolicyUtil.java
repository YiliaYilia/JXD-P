package cn.com.sinosoft.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import cn.com.sinosoft.domain.yinbaotongWAB.Accounts;
import cn.com.sinosoft.domain.yinbaotongWAB.BaseInfo;
import cn.com.sinosoft.domain.yinbaotongWAB.LCAppnt;
import cn.com.sinosoft.domain.yinbaotongWAB.LCBnfs;
import cn.com.sinosoft.domain.yinbaotongWAB.LCCont;
import cn.com.sinosoft.domain.yinbaotongWAB.LCInsured;
import cn.com.sinosoft.domain.yinbaotongWAB.LCInsureds;
import cn.com.sinosoft.domain.yinbaotongWAB.Risk;
import cn.com.sinosoft.domain.yinbaotongWAB.Risks;
import cn.com.sinosoft.domain.yinbaotongWAB.TranData;
import cn.com.sinosoft.domain.yinbaotongWAB.TranRequest;

public class RXAKLongPolicyUtil {
	
	public static Logger logger = LoggerFactory.getLogger(RXAKLongPolicyUtil.class);
	
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	 
	/**
	 * 调用试算接口
	 * @param birthday
	 * @param sex
	 * @param amnt
	 * @return
	 */
	public static String calculate(String birthday,String sex,String amnt,String url,String brNo,String PayEndYear,String RelaToAppnt){
		String PayIntv = null;
		String PayEndYearFlag = null;
		if("0".equals(PayEndYear)){//趸交
			PayIntv="0";
			PayEndYearFlag="1";
		}else{//年交
			PayIntv="1";
			PayEndYearFlag="4";
		}
		String TransrNo = getTransrNo();
		//拼报文 
		LCBnfs lcbnfs = new LCBnfs("0",null);
		Accounts acconuts = new Accounts("1");
		Risk risk = new Risk("RUIXANKANG","RUIXANKANG","","1",amnt,"","20150506","","0.00","",PayIntv,"",null,"","",PayEndYearFlag,PayEndYear,"","","","","1","106","","","","","","","","",acconuts,"N","N","Y","N",lcbnfs);
		Risks risks = new Risks(1,risk);
		LCInsured lCInsured = new LCInsured("","林四",sex,birthday,"O","999999","","","","","","","","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公","","","","","","Y",RelaToAppnt,"CHN","ZJ","HZ","1",risks);
		LCAppnt lcAppnt = new LCAppnt("","林四",sex,"19850101","O","999888","20100501","21300501","","","","13957171471","浙江省（市、区）杭州市西湖区县（区）竞舟路西鉴枫景公寓","","","","linlei101291@sina.com","","0","0","","CHN","ZJ","HZ",RelaToAppnt,"1");
		LCInsureds lcInsureds = new LCInsureds("1",lCInsured);
		BaseInfo BaseInfo = new BaseInfo("20150506",sdf.format(new Date()),"803","MSG01",brNo,"00000",TransrNo,"102","RT","","1","","","");
		LCCont LCCont = new LCCont("",TransrNo,"20150506","开心保包","MSG01","888888","1","1","","","4","8","","","","","","","RMB","","","","Y","","","",lcAppnt,lcInsureds);
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
	public static TranData padding(Risk risk,LCInsured lCInsured,LCAppnt lcAppnt,LCCont lCCont,BaseInfo baseInfo,LCBnfs lcbnfs ,String payEndYear){
		String PayIntv = null;
		String PayEndYearFlag = null;
		if("0".equals(payEndYear)){//趸交
			PayIntv="0";
			PayEndYearFlag="1";
		}else{//年交
			PayIntv="1";
			PayEndYearFlag="4";
		}
		String TransrNo = getTransrNo();
		//补充被保险人险种信息默认值
		Accounts accounts = new Accounts("1");
		risk.setLCBnfs(lcbnfs);
		risk.setAccounts(accounts);
		risk.setRiskCode("RUIXANKANG");
		risk.setMainRiskCode("RUIXANKANG");
		risk.setBankRiskCode("");
		risk.setRiskType("1");
		risk.setRate("");
		risk.setRank("");
		risk.setMult("");
		risk.setPayIntv(PayIntv);//年缴1   趸交0
		risk.setCostIntv("");
		risk.setCostDate("");
		risk.setYears("");
		risk.setSpecContent("");
		risk.setPayEndYearFlag(PayEndYearFlag);//缴费方式 年
		risk.setPayEndYear(payEndYear);//缴费期间 
		risk.setPayoutStart("");
		risk.setPayoutEnd("");
		risk.setGetYearFlag("");
		risk.setGetYear("");
		risk.setInsuYearFlag("1");
		risk.setInsuYear("106"); 
		risk.setGetIntv("");
		risk.setGetBankCode("");
		risk.setGetBankAccNo("");
		risk.setGetAccName("");
		risk.setAutoPayFlag("");
		risk.setBonusPayMode("");
		risk.setSubFlag("");
		risk.setBonusGetMode("");
		risk.setFinanceIndicator("N");
		risk.setOccupationFlag("N");
		risk.setHealthFlag("N");
		risk.setCValiDate("");//生效日期为空，待返回
		Risks risks = new Risks(1,risk);
		//补充被保人信息
		lCInsured.setPartyKey("");
		lCInsured.setIDEffDate("");
		lCInsured.setNationality("");
		lCInsured.setHomePhone("");
		lCInsured.setInsureCompanyPhone("");
		lCInsured.setAddressStateTC("CHN"); //被保人国家 CHN中国
		lCInsured.setHomeZipCode("");
		lCInsured.setMailAddress("");
		lCInsured.setMailZipCode("");
		lCInsured.setRelaToMain("");
		lCInsured.setRisks(risks);
		lCInsured.setTaxPayer("1");//纳税标识
		//补充投保人信息
		lcAppnt.setAppntPartyKey("");
		lcAppnt.setIDEffDate("");
		lcAppnt.setNationality("");
		lcAppnt.setAppntPhone("");
		lcAppnt.setAppntOfficePhone("");
		lcAppnt.setHomeZipCode("");//默认邮编
		lcAppnt.setMailAddress("");
		lcAppnt.setMailZipCode("");
		lcAppnt.setFamilyEstSalary("0");//家庭年收入
		lcAppnt.setEstAnnualSalary("0");//年收入
		lcAppnt.setLiveZone("");//客户类型
		lcAppnt.setAddressStateTC("CHN");//国家为中国
		lcAppnt.setTaxPayer("1"); //纳税标识
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
	public static String underwriting(String url,Risk risk,LCInsured lCInsured,LCAppnt lcAppnt,LCCont lCCont,BaseInfo baseInfo,LCBnfs lcbnfs,String payEndYear){
		baseInfo.setFunctionFlag("102");
		TranData tranData = padding(risk,lCInsured,lcAppnt,lCCont,baseInfo, lcbnfs, payEndYear);
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
}

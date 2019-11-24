package cn.com.sinosoft.web.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

//import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.common.PaymentConfigProp;
import cn.com.sinosoft.web.service.impl.EaccoutServiceImpl;
import cn.com.sinosoft.web.weixin.MyX509TrustManager;

/**
 * 涉及金钱的相关类
 * @author lwy
 *
 */
public class FundUtil {
	private static final Random random = new Random();
	private static final DecimalFormat decimalFormat = new DecimalFormat("000");
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
	private static Logger log = LoggerFactory.getLogger(FundUtil.class);

    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getTimeStamp() {
  		return String.valueOf(System.currentTimeMillis() / 1000);
  	}
    
	public static String getMerchantOrderNo(Date date){
		return format.format(date)+decimalFormat.format(random.nextInt(1000));
	}

	
	public static class Bill{
		private String date;//﻿交易时间
		private String appId;//公众账号ID
		private String mch_id;//商户号
		private String subMch_id;//子商户号
		private String device_info;//设备号
		private String weiXinOrderNo;//微信订单号
		private String mchOrderNo;//商户订单号
		private String userId;//用户标识
		private String type;//交易类型
		private String status;//交易状态
		private String bank;//付款银行
		private String currency;//货币种类
		private String amount;//总金额
		private String envelopeAmount;//企业红包金额
		private String name;//商品名称
		private String packet;//商户数据包
		private String poundage;//手续费
		private String rate;//费率
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getAppId() {
			return appId;
		}
		public void setAppId(String appId) {
			this.appId = appId;
		}
		public String getMch_id() {
			return mch_id;
		}
		public void setMch_id(String mch_id) {
			this.mch_id = mch_id;
		}
		public String getSubMch_id() {
			return subMch_id;
		}
		public void setSubMch_id(String subMch_id) {
			this.subMch_id = subMch_id;
		}
		public String getDevice_info() {
			return device_info;
		}
		public void setDevice_info(String device_info) {
			this.device_info = device_info;
		}
		public String getWeiXinOrderNo() {
			return weiXinOrderNo;
		}
		public void setWeiXinOrderNo(String weiXinOrderNo) {
			this.weiXinOrderNo = weiXinOrderNo;
		}
		public String getMchOrderNo() {
			return mchOrderNo;
		}
		public void setMchOrderNo(String mchOrderNo) {
			this.mchOrderNo = mchOrderNo;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getBank() {
			return bank;
		}
		public void setBank(String bank) {
			this.bank = bank;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getEnvelopeAmount() {
			return envelopeAmount;
		}
		public void setEnvelopeAmount(String envelopeAmount) {
			this.envelopeAmount = envelopeAmount;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPacket() {
			return packet;
		}
		public void setPacket(String packet) {
			this.packet = packet;
		}
		public String getPoundage() {
			return poundage;
		}
		public void setPoundage(String poundage) {
			this.poundage = poundage;
		}
		public String getRate() {
			return rate;
		}
		public void setRate(String rate) {
			this.rate = rate;
		}
	}
	
	/*@Test
	public void 微信对账(){
		String appId = PaymentConfigProp.getString("weixin_Appid");
		String mch_id = PaymentConfigProp.getString("weixin_Mch_id");//商户号
		String key = PaymentConfigProp.getString("weixin_key");//密钥
		//System.out.println(sendXml(appId, date, type, mch_id, key));
		SimpleDateFormat sp = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date(System.currentTimeMillis()-1000*60*60*24);//昨天日期date型
		String date = sp.format(d);//获取昨天日期
		List<Bill> bills = analyze(sendXml(appId, date, "SUCCESS", mch_id, key));
		for(Bill bill:bills){
			System.out.println(bill.getMchOrderNo() + "  " + bill.getUserId());
		}
	}*/
	
	
	
	/**
	 * 向腾讯发送微信对账的请求
	 * @param appId
	 * @param date 需要查询的交易时间 格式yyyymmdd
	 * @param type 	ALL，返回当日所有订单信息，默认值 SUCCESS，返回当日成功支付的订单  REFUND，返回当日退款订单
	 * @param mch_id  商户号
	 * @param key
	 * @return 需要解析的字符串
	 */
	public static String sendXml(String appId,String date,String type,String mch_id,String key){
		//地址
		String nonce_str = UUID.randomUUID().toString().substring(8);
		String requestUrl = "https://api.mch.weixin.qq.com/pay/downloadbill";
		String parameters = "appid="+appId+"&bill_date="+date+"&bill_type="+type+"&mch_id="+mch_id+"&nonce_str="+nonce_str+"&key="+key;
		String sign = MD5Util.MD5Encode(parameters, "gbk").toLowerCase();
		
		//格式化xml数据
		String xml = "<xml>"
				+ "<appid>"+appId+"</appid>"
				+ "<bill_date>"+date+"</bill_date>"
				+ "<bill_type>"+type+"</bill_type>"
				+ "<mch_id>"+mch_id+"</mch_id>"
				+ "<nonce_str>"+nonce_str+"</nonce_str>"
				+ "<sign>"+sign+"</sign>"
				+ "</xml>";
		StringBuffer buffer = new StringBuffer();
		try {
            // 创建 SSLContext 对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述 SSLContext 对象中得到 SSLSocketFactory 对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            
            // 设置请求方式（GET/POST）
            conn.setRequestMethod("GET");
            
            // 当 outputStr 不为 null 时，向输出流写数据
            if (null != xml) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(xml.getBytes("UTF-8"));
                outputStream.close();
            }
            
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            log.info("微信接口返回内容:"+buffer.toString());
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
        } catch (ConnectException ce) {
            log.info("微信接口连接超时：{}");
            ce.printStackTrace();
        } catch (Exception e) {
        	log.info("微信接口连接异常：{}");
        	e.printStackTrace();
        }
		
		return buffer.toString();
	}
	
	
	public static List<Bill> analyze(String str){
		List<Bill> bills = new ArrayList<Bill>();
		String[] strs = str.split("%");//长度为记录数的字符串数组
		try{
			for(int i=0;i<strs.length-1;i++){//去掉总交易单数等不必要的数据
				String[] temp = strs[i].split(",");
				Bill bill = new Bill();
				if(i==0){
					bill.setDate(temp[17].split("`")[1]);//费率`2015-07-24 15:49:05
					bill.setAppId(temp[18].substring(1));
					bill.setMch_id(temp[19].substring(1));
					bill.setSubMch_id(temp[20].substring(1));
					bill.setDevice_info(temp[21].substring(1));
					bill.setWeiXinOrderNo(temp[22].substring(1));
					bill.setMchOrderNo(temp[23].substring(1));
					bill.setUserId(temp[24].substring(1));
					bill.setType(temp[25].substring(1));
					bill.setStatus(temp[26].substring(1));
					bill.setBank(temp[27].substring(1));
					bill.setCurrency(temp[28].substring(1));
					bill.setAmount(temp[29].substring(1));
					bill.setEnvelopeAmount(temp[30].substring(1));
					bill.setName(temp[31].substring(1));
					bill.setPacket(temp[32].substring(1));
					bill.setPoundage(temp[33].substring(1));
					bill.setRate(temp[34].substring(1)+"%");
				}else{
					bill.setDate(temp[0].substring(1));
					bill.setAppId(temp[1].substring(1));
					bill.setMch_id(temp[2].substring(1));
					bill.setSubMch_id(temp[3].substring(1));
					bill.setDevice_info(temp[4].substring(1));
					bill.setWeiXinOrderNo(temp[5].substring(1));
					bill.setMchOrderNo(temp[6].substring(1));
					bill.setUserId(temp[7].substring(1));
					bill.setType(temp[8].substring(1));
					bill.setStatus(temp[9].substring(1));
					bill.setBank(temp[10].substring(1));
					bill.setCurrency(temp[11].substring(1));
					bill.setAmount(temp[12].substring(1));
					bill.setEnvelopeAmount(temp[13].substring(1));
					bill.setName(temp[14].substring(1));
					bill.setPacket(temp[15].substring(1));
					bill.setPoundage(temp[16].substring(1));
					bill.setRate(temp[17].substring(1)+"%");
				}
				bills.add(bill);
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return bills;
	}
}

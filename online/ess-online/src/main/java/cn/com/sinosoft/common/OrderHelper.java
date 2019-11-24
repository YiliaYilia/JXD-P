package cn.com.sinosoft.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;

import cn.com.sinosoft.ess.protal.common.DateAndTime;

public class OrderHelper {
	private static OrderHelper orderHelper =new OrderHelper();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");//至毫秒
	/**
	 * 获取订单号
	 * @param platform 平台：RT表示瑞泰
	 * @param channel 渠道：000：标准成长卫士，001：优惠活动成长卫士，002：赠险成长卫士，003：赠险仅捐款，100：标准天天保
	 * @return
	 */
	public static synchronized String getOrderNumber(String platform,String channel){
		String num = RandomStringUtils.random(4, false, true);//获取一个四位随机数
		String orderNumber=platform+channel+sdf.format(new Date())+num;//平台+渠道+时间+随机数
		return orderNumber;
	}
	
	public static synchronized String getOrderNumber(String platform) {
		String datestr = DateAndTime.getCurrentDateTime("yyMMddHHmmssSSS");
		String num = RandomStringUtils.random(4, false, true);
		String orderNumber = platform + datestr + num;
		return orderNumber;
	}
	
	private OrderHelper(){
		
	}
	public OrderHelper getOrderHelper(){
		return orderHelper;
	}
	/**
	 * 方法名称: getTransNo<br>
	 * 描述：获取交易流水号
	 * 作者: chendogjun
	 * 修改日期：2014年7月1日下午3:32:02
	 * @param tranCom 公司
	 * @param tranSchnl 渠道
	 * @return
	 */
	public static synchronized String getTransNo(String tranCom,String tranSchnl){
	    String num = RandomStringUtils.random(4, false, true);
	    String transNo = tranCom + sdf.format(new Date()) + num;
	    return transNo;
	}

}

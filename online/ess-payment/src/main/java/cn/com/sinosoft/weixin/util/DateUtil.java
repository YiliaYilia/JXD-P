package cn.com.sinosoft.weixin.util;



import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	
	private static final DateFormat dateFormatTenpay = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	
	private static final DateFormat dateFormat1 = new SimpleDateFormat(
			"yyyyMMdd");
	
	private static final DateFormat dateFormat2 = new SimpleDateFormat(
			"HHmmss");
	
	private static final DecimalFormat decimalFormat = new DecimalFormat("000");
	
	private static final DecimalFormat amtFormat = new DecimalFormat("#.00");
	
	private static final Random random = new Random();

	public static synchronized String generatorTransSerialNumber() {
		return dateFormat.format(new Date())
				+ decimalFormat.format(random.nextInt(1000));
	}
	
	public static String generatorDate() {
		return dateFormat1.format(new Date());
	}
	
	public static String generatorTime() {
		return dateFormat2.format(new Date());
	}
	
	public static String generatorDateTime() {
		return dateFormatTenpay.format(new Date());
	}

	public static String formatMaxNo(String no){
		int payno = Integer.valueOf(no)+1;
		no=String.valueOf(payno);
		int n = 8-String.valueOf(payno).length();
		for (int i = 0; i < n; i++) {
			no = 0+no;
		}
		return no;
	}
	

	public static String formatPayNum(String amt){
		amt = amtFormat.format(Double.valueOf(amt)).replace(".", "");
		return amt;
	}
}

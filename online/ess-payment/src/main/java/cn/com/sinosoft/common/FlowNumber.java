package cn.com.sinosoft.common;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FlowNumber {
	private static final DecimalFormat decimalFormat = new DecimalFormat("00000000");
	private static final SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
	private static final Random random = new Random();

	public static String  getFlowNo(){
		return format.format(new Date())+decimalFormat.format(random.nextInt(100000000));//交易流水号
	}
	
	public static void main(String[] args) {
		System.out.println(getFlowNo());
	}
}

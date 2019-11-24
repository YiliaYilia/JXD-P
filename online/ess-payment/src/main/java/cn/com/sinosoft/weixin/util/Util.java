package cn.com.sinosoft.weixin.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Util {
	private static final Random random = new Random();
	private static final DecimalFormat decimalFormat = new DecimalFormat("000");
	private static final SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
	   

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
	
    public static void main(String args[]){
    	SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间  
    	  
        String nowtime = d.format(new Date());// 按以上格式 将当前时间转换成字符串  
  
        System.out.println("当前时间：" + nowtime);  
        String testtime = "2015-06-01 02:00:00";// 测试时间  
        System.out.println("测试时间：" + testtime);  
  
        try {  
            long result = (d.parse(nowtime).getTime() - d.parse(testtime)  
                    .getTime()) / 60000;// 当前时间减去测试时间  
                                        // 这个的除以1000得到秒，相应的60000得到分，3600000得到小时  
            System.out.println("当前时间减去测试时间=" + result + "分钟");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
    }
    
    
    
}

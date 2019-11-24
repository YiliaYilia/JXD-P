package cn.com.sinosoft.util;

import java.math.BigDecimal;

public class ArithmeticUtil {
	/**  
     * 提供精确的小数位四舍五入处理。  
     *  
     * @param v  
     *            需要四舍五入的数字  
     * @param scale  
     *            小数点后保留几位  
     * @return 四舍五入后的结果  
     */
	 public static BigDecimal round(double v, int scale) {   
	        if (scale < 0) {   
	            throw new IllegalArgumentException(   
	                    "The scale must be a positive integer or zero");   
	        }   
	        BigDecimal b = new BigDecimal(v);   
	        BigDecimal one = new BigDecimal("1");   
	        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);   
	    } 
	 /**  
	     * 提供精确的乘法运算。 保留scale 位小数  
	     *  
	     * @param v1  
	     *            被乘数  
	     * @param v2  
	     *            乘数  
	     * @return 两个参数的积  
	     */   
	    public static BigDecimal mul(double v1, String v2,int scale) {   
	        BigDecimal b1 = new BigDecimal(Double.toString(v1));   
	        BigDecimal b2 = new BigDecimal(v2);   
	        return  round(b1.multiply(b2).doubleValue(),scale);   
	    }  
}

/**
 * File Name:DateUtils.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月27日下午4:05:33
 */
package cn.com.sinosoft.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月27日下午4:05:33 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class DateUtils {
	public static final String  DEFAULT = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HMS ="yyyy-MM-dd HH:mm:ss";
	public static DateFormat dateFormat = null;
	
	public static Date toDate(String val){
		return toDate(val,DEFAULT);
	}
	
	public static Date toDate(String val,String format){
		SimpleDateFormat sf = new SimpleDateFormat(format);
		try {
			return sf.parse(val);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}
	
	
	/**方法名称: format<br>
	 * 描述：格式化日期
	 * 作者: dengjiaxing
	 * 修改日期：2014-1-9下午01:27:49
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format) {
		
		String result = "";
		try {
			if (date != null) {
				dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	
	/**方法名称: getAge<br>
	 * 描述：根据出生日期算年纪
	 * 作者: dengjiaxing
	 * 修改日期：2014-1-12下午09:06:54
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public  String getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                "出生日期小于现在当前");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH)+1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                //monthNow>monthBirth
                age--;
            }
        }
        return age +"";
    } 
}

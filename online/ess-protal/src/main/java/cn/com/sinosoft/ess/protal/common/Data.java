/**
 * Data.java
 * 
 * 功  能：常用方法管理
 * 类  名：Data
 * 
 * ver		变更日		公司				变更人			变更内容
 * ------------------------------------------------------------
 * V1.00	2010-01-01	sinosoft		sinosoft		
 * 
 * Copyright (c) 2008, 2009 Sinosoft Co.,Ltd. All Rights Reserved.
 */

package cn.com.sinosoft.ess.protal.common;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 常用方法管理 ■ 判断值是否不为空值 ■ 过滤跨站脚本关键字 ■ 读取网页内容 ■ 获取项目物理路径 ■ 全角转半角 ■ 半角转全角 ■ 收集页面参数 ■
 * GB2312编码转换成Unicode编码 ■ Unicode编码转换成GB2312编码 ■ 打印1维数组 ■ 打印2维数组
 * 
 * @author sinosoft
 * @version 1.0 2009-10-27 新建
 */

public final class Data {

	private Data() {
	}

	/**
	 * 判断值是否不为空值
	 * 
	 * @param value
	 *            被判断的值
	 * @return true-value不为空值，false-value为空值
	 */
	public static boolean hasValue(String value) {
		if (value == null || value.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 过滤跨站脚本关键字
	 * 
	 * @param src
	 *            输入的字符串
	 * @return 过滤后的字符串
	 */
	public static String filterStr(String src) {
		if (Data.hasValue(src)) {
			src = src.replaceAll("<", "");
			src = src.replaceAll(">", "");
			src = src.replaceAll("'", "");
			src = src.replaceAll("&", "＆");
			src = src.replaceAll("#", "＃");
			src = src.replaceAll("%", "％");
			src = src.replaceAll("\"", "");
			src = src.trim();
			return src;
		} else {
			return "";
		}
	}

	/**
	 * 读取网页内容
	 * 
	 * @param str
	 *            网页地址，例：http://wwww.baidu.com
	 * @return 网页内容
	 * @throws java.io.IOException
	 */
	public static String getHtmlCodeByURL(String str)
			throws java.io.IOException {
		URL url = new URL(str);
		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		InputStream in = urlConnection.getInputStream();
		byte[] data = new byte[in.available()];
		in.read(data);
		return new String(data);
	}

	/**
	 * 获取项目物理路径
	 * 
	 * @return 项目路径
	 * @throws Exception
	 *             未找到路径
	 */
	public static String getProjectLocalPath()
			throws UnsupportedEncodingException {
		String path = Data.class.getResource("").getFile();
		path = URLDecoder.decode(path, "UTF-8");
		path = path.substring(0, path.lastIndexOf("/WEB-INF"));
		String temp = path.substring(0, 5);
		if ("file:".equalsIgnoreCase(temp)) {
			path = path.substring(5);
		}
		return path;
	}

	/**
	 * 半角转全角 半角空格为32，全角空格为12288 其他字符半角(33-126)与全角(65281-65374)的对应关系为：相差65248
	 * 
	 * @param src
	 *            待转换的字符串
	 * @return 转换后的全角字符串
	 */
	public static String toSBC(String src) {
		char[] c = src.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 32) {
				c[i] = 12288;
			} else if (c[i] >= 33 && c[i] <= 126) {
				c[i] += 65248;
			}
		}
		return new String(c);
	}

	/**
	 * 全角转半角 半角空格为32，全角空格为12288 其他字符半角(33-126)与全角(65281-65374)的对应关系为：相差65248
	 * 
	 * @param src
	 *            待转换的字符串
	 * @return 转换后的半角字符串
	 */
	public static String toDBC(String src) {
		char[] c = src.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = 32;
			} else if (c[i] >= 65281 && c[i] <= 65374) {
				c[i] -= 65248;
			}
		}
		return new String(c);
	}

	/**
	 * 收集页面参数
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return session和request中的所有参数
	 */
	public static IndexMap getParameters(HttpServletRequest request) {
		IndexMap hm = new IndexMap();
		Enumeration en = null;
		HttpSession session = request.getSession();
		if (request != null) {
			en = request.getParameterNames();
			while (en.hasMoreElements()) {
				String tempName = (String) en.nextElement();
				hm.put(tempName, filterStr(request.getParameter(tempName)));
			}
		}
		if (session != null) {
			en = session.getAttributeNames();
			while (en.hasMoreElements()) {
				String tempName = (String) en.nextElement();
				hm.put(tempName, session.getAttribute(tempName));
			}
		}
		return hm;
	}

	/**
	 * Unicode编码转换成GB2312编码
	 * 
	 * @param src
	 *            Unicode编码的字符串
	 * @return GB2312编码的字符串
	 * @throws UnsupportedEncodingException
	 *             编码转换错误
	 */
	public static String UnicodeToGB(String src)
			throws UnsupportedEncodingException {
		if (Data.hasValue(src)) {
			return new String(src.getBytes("ISO-8859-1"), "GB2312");
		} else {
			return src;
		}
	}

	/**
	 * GB2312编码转换成Unicode编码
	 * 
	 * @param src
	 *            GB2312编码的字符串
	 * @return Unicode编码的字符串
	 * @throws UnsupportedEncodingException
	 *             编码转换错误
	 */
	public static String GBToUnicode(String src)
			throws UnsupportedEncodingException {
		if (Data.hasValue(src)) {
			return new String(src.getBytes("GB2312"), "ISO-8859-1");
		} else {
			return src;
		}
	}

	public static void printArray1(String[] src) {
		System.out.println("============start，每一个元素之后接一个结束标志^==============");
		if (src == null) {
			System.out.println("src=null");
			return;
		}
		for (int i = 0; i < src.length; i++) {
			System.out.print(src[i] + "^");
		}
		System.out
				.println("\n========================end============================");
	}

	public static void printArray2(String[][] src) {
		System.out.println("============start，每一个元素之后接一个结束标志^==============");
		if (src == null) {
			System.out.println("src=null");
			return;
		}
		for (int i = 0; i < src.length; i++) {
			for (int j = 0; j < src[i].length; j++) {
				System.out.print(src[i][j] + "^");
			}
			System.out.println();
		}
		System.out
				.println("========================end============================");
	}
	
	/**
	 * 百分数转换
	 * @param Str 待转换字符串
	 * @return
	 */
	public static String String2Percent(String str) {
		BigDecimal bd = new BigDecimal(str);
		String percent = bd.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "%";
		return percent;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Data.String2Percent("3"));
	}
}

package cn.com.sinosoft.web.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.CharUtils;

/**
 * 
 * 身份证号码检验器。校验规则执行国家质量技术监督局于1999年7月1日实施的GB11643-1999《公民身份号码》中对18位身份证标准所做的规定。
 * 号码的结构和表示形式 1、号码的结构
 * 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
 * 2、地址码 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。 3、出生日期码
 * 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。YYYYMMDD 4、顺序码
 * 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配给女性。 5、校验码
 * (1)十七位数字本体码加权求和公式 S = Ai * Wi, i = 2, ... , 18 Y = mod(S, 11) i:
 * 表示号码字符从右至左包括校验码字符在内的位置序号 Ai:表示第i位置上的身份证号码字符值 Wi:表示第i位置上的加权因子 i: 18 17 16 15
 * 14 13 12 11 10 9 8 7 6 5 4 3 2 1 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 1
 * (2)校验码字符值的计算 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2
 * 
 * @author 
 */
public final class IdNumberValidator {
	
	/**
	 * 校验给定的身份证号是否有效。会从证件号位数，是否含无效字符，出生日期码及校验码几方面加以验证。
	 * 如果给定的身份证号是15位或18位长
	 *  出生日期 ，及校验位（只对18位证号检查）均正确时返回True，否则返回False。 
	 * @param idNumber  受检身份证号
	 * @return boolean  
	 */
	public static boolean verify(String idNumber) {
		
		if (idNumber == null)
			return false;
		if (idNumber.length() != 15 && idNumber.length() != 18)
			return false;
		for (int i = 0; i < idNumber.length(); i++) {
			char c = idNumber.charAt(i);
			if (i < 17 && !CharUtils.isAsciiNumeric(c))
				return false;
		}
		idNumber = idNumber.toUpperCase();
		
		if (idNumber.length() == 18 && idNumber.charAt(17) != 'X' && !CharUtils.isAsciiNumeric(idNumber.charAt(17)))
			return false;

		String dateStr = idNumber.length() == 18 ? idNumber.substring(6, 14) : idNumber.substring(6, 12);

		return isValidDate(dateStr) && verifyCheckDigit(idNumber);
	}

	/**
	 * 校验给定的身份证号的出生日期码所代表的日期与给定的出生日期是否相同。
	 * 如果birthDate为Null，
	 * 或者身份证号的出生日期码所代表的日期与给定的出生日期相同时返回True，否则返回False 
	 * @param idNumber 受检身份证号
	 * @param birthDate 出生日期
	 * @return boolean   
	 */
	public static boolean verify(String idNumber, Date birthDate) {
		if (idNumber == null ||idNumber.equals(""))
			return false;
		if (birthDate == null)
			return true;
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		if (idNumber.length() == 18) {
			String yearStr = idNumber.substring(6, 10);
			String monthStr = idNumber.substring(10, 12);
			String dateStr = idNumber.substring(12, 14);
			try {
				return (Integer.parseInt(dateStr) == date) && (Integer.parseInt(monthStr) == month) && (Integer.parseInt(yearStr) == year);
			} catch (Exception e) {
				return false;
			}
		} else if (idNumber.length() == 15) {
			String yearStr = idNumber.substring(6, 8);
			String monthStr = idNumber.substring(8, 10);
			String dateStr = idNumber.substring(10, 12);
			try {
				return (Integer.parseInt(dateStr) == date) && (Integer.parseInt(monthStr) == month) && (Integer.parseInt(yearStr) == (year % 100));
			} catch (Exception e) {
				return false;
			}
		}

		return false;
	}

	/**
	 * 校验给定的身份证号的顺序码所揭示的性别是否与给定的性别相同。
	 * 如果顺序码为奇数应为男性，为偶数应为女性
	 * 如果身份证号的顺序码所揭示的性别与给定的性别相同时返回True，否则返回False。
	 * @param idNumber 受检身份证号
	 * @param gender  性别
	 * @return boolean 
	 */
	public static boolean verify(String idType,String idNumber, String sex) {
		if (idNumber == null ||idNumber.equals("")){
			return false;
		}
		if (idNumber.length() != 18 && idNumber.length() != 15){
			return false;
		}
		int g = idNumber.length() == 18 ? idNumber.charAt(16) : idNumber.charAt(14);
		return ("F".equals(sex) && ((g % 2) == 0)) || ("M".equals(sex) && ((g % 2) == 1));
	}

	/**
	 * 检验给定身份证号的地址码是否是给定的行政区划代码。
	 * 如果regionalCode不是6位长，返回True；如果idNumber前6位与regionalCode相同，返回True；否则返回False
	 * @param idNumber 受检身份证号
	 * @param regionalCode 6位行政区划代码
	 * @return  
	 */
	public static boolean verify(String idNumber, String regionalCode) {
		if (idNumber == null)
			return false;
		if (regionalCode == null || regionalCode.length() != 6)
			return true;
		return idNumber.startsWith(regionalCode);
	}

	/**
	 * 检验给定身份证号的校验码是否正确。
	 * 如果是15位证号，或者是校验码正确的18位证号返回True；否则返回False。
	 * @param idNumber 受检身份证号
	 * @return 
	 */
	public static boolean verifyCheckDigit(String idNumber) {
		if (idNumber == null)
			return false;
		if (idNumber.length() == 15)
			return true;

		if (idNumber.length() == 18) {
			char checkDigit = idNumber.charAt(17);
			return checkDigit == checkDigit(idNumber.toCharArray());
		}

		return false;
	}

	/**
	 *  将15位身份证号转换为18位证号。将15位证号的日期码由6位改为8位，即由XXMMDD改为为19XXMMDD。
	 *  如果personIDCode是15位证号，则返回对应的18位身份证号；否则返回personIDCode。
	 * @param personIDCode
	 *           
	 * @return 
	 */
	public static String transferTo18Bit(String personIDCode) {
		if (personIDCode == null || personIDCode.trim().length() != 15) {
			return personIDCode;
		}
		char[] id15 = personIDCode.trim().toCharArray();
		char[] id18 = new char[18];
		for (int i = 0; i < 6; i++)
			id18[i] = id15[i];
		for (int i = 6; i < 15; i++)
			id18[i + 2] = id15[i];
		id18[6] = '1';
		id18[7] = '9';
		id18[17] = checkDigit(id18);
		return String.valueOf(id18);
	}

	/**
	 * 将18位身份证号转换为15位证号。将18位证号的日期码由8位改为6位，即由19XXMMDD改为为XXMMDD。
	 * 如果personIDCode是19XX年出生的18位证号，则返回对应的15位身份证号；否则返回personIDCode
	 * @param personIDCode
	 * @return 
	 */
	public static String transferTo15Bit(String personIDCode) {
		if (personIDCode == null || personIDCode.trim().length() != 18) {
			return personIDCode;
		}
		char[] id18 = personIDCode.trim().toCharArray();
		if (id18[6] == '1' && id18[7] == '9') {
			char[] id15 = new char[15];
			for (int i = 0; i < 6; i++)
				id15[i] = id18[i];
			for (int i = 8; i < 17; i++)
				id15[i - 2] = id18[i];
			return String.valueOf(id15);
		} else
			return personIDCode;

	}

	protected static char checkDigit(char[] id18) {
		char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' }; // 11个

		int sum = 0;
		for (int i = 0; i < 17; i++) {
			sum = sum + CharUtils.toIntValue(id18[i]) * wi(i);
		}
		int index = sum % 11;

		return code[index];
	}

	protected static int wi(int index) {
		if (index > 17 || index < 0)
			throw new IllegalArgumentException("index out of bound");
		int n = 17 - index;
		return (1 << n) % 11;
	}

	private static boolean isValidDate(String dateString) {
		if (dateString == null)
			return false;
		String pattern = "yyyyMMdd";
		if (dateString.length() == 6)
			pattern = "yyMMdd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			Date birthDate = dateFormat.parse(dateString);
			String birthDateStr = dateFormat.format(birthDate);
			return birthDateStr.equals(dateString);
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 
	 * @param idNumber
	 * @return  
	 */
	public static Date idNumber2BirthDate(String idNumber) {
		Calendar cal = Calendar.getInstance();
		if(idNumber.length()==18){
			int yearStr = Integer.parseInt(idNumber.substring(6, 10));
			int monthStr = Integer.parseInt(idNumber.substring(10, 12)) - 1;
			int dateStr = Integer.parseInt(idNumber.substring(12, 14));
			cal.set(yearStr, monthStr, dateStr);
		}else if(idNumber.length()==15){
			int year = Integer.parseInt(idNumber.substring(6, 8));
			int yearStr = year + 1900;
			int monthStr = Integer.parseInt(idNumber.substring(8, 10)) - 1;
			int dateStr = Integer.parseInt(idNumber.substring(10, 12));
			cal.set(yearStr, monthStr, dateStr);
		}
		return DateUtil.getDayStart(cal.getTime());
	}

	/**
	 * 
	 * @param idNumber
	 * @return Owner's Actual Gender
	 */
	public static String getSexFromCard(String idNumber) {
		String inputStr = idNumber.toUpperCase().toString();
		int sex;
		if (inputStr.length() == 18) {
			sex = inputStr.charAt(16);
			if (sex % 2 == 0) {
				return  "F";
			} else {
				return "M";
			}
		} else {
			sex = inputStr.charAt(14);
			if (sex % 2 == 0) {
				return "F";
			} else {
				return "M";
			}
		}
	}
	
	public static String lowerToUpper(String idNumber){
		if ( idNumber.length() == 15 || idNumber.length() == 18 ){
			if ( idNumber.endsWith("x") ){
				idNumber = idNumber.toUpperCase();
			}
		}
		return idNumber;
	}
	
}

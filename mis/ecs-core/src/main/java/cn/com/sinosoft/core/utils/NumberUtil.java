package cn.com.sinosoft.core.utils;
import java.text.DecimalFormat;
import java.text.ParseException;

/**描述：数字工具类<br>
 * 作者：CaryXu <br>
 * 修改日期：2015年3月11日 12:22:40 <br>
 * E-mail: XuKaizhen@sinosoft.com.cn <br> 
 */
public class NumberUtil {
	
	public static final String PATTERN_MONEY = "#,##0.00";
	
	public static final String PATTERN_DOUBLE = "#0.00";

    /**
     * 格式数字类型
     *
     * @param f
     *            float
     * @param sacl
     *            int
     * @return String
     */
    public static String formatNumber(double f, String pattern) {
        java.text.DecimalFormat num = new DecimalFormat(pattern);
        return num.format(f);
    }
    
    /**
     * 格式化为钱格式显示如：1,234,555.00
     *
     * @param money
     *            double
     * @return String
     */
    public static String formatMoney(double money) {
        return formatNumber(money, PATTERN_MONEY);
    }
    
    public static String formatMoney(String money) {
        return formatNumber(money, PATTERN_MONEY);
    }

    public static String indexUpStr(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }
        String tmstr = "";
        tmstr = str.substring(0, 1);
        tmstr = tmstr.toUpperCase();
        tmstr += str.substring(1);
        return tmstr;
    }

    /**
     * 根据分隔符,将数字字符转换成整型数组
     *
     * @param str
     *            String
     * @param regex
     *            String
     * @return int[]
     */
    public static int[] toIntsByRegex(String str, String regex) {
        if (str == null || "".equals(str.trim()))
            return null;
        String[] tms = str.split(regex);
        int[] tmi = new int[tms.length];
        for (int i = 0; i < tms.length; i++) {
            tmi[i] = Integer.parseInt(tms[i]);
        }
        return tmi;
    }

    public static int[] toInts(String str) {
        return toIntsByRegex(str, ",");
    }

    /**
     * 将格式化的数字还原，如：1,234,567.00——>1234567.00
     *
     * @param formattedNumber
     * @return parseString
     */
    public static String formatNumber(String formattedNumber, String pattern) {
        java.text.DecimalFormat num = new DecimalFormat();

        String parseString = "";
        try {
            parseString = formatNumber(Double.parseDouble(num.parse(
                    formattedNumber).toString()), pattern);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parseString;
    }

    public static void main(String[] args) throws ParseException {
    	System.out.println(formatMoney(1234523455.1));
        System.out.println(formatNumber(5234556, NumberUtil.PATTERN_MONEY));
        System.out.println(formatMoney("9999999.1"));
        System.out.println(formatNumber("0", NumberUtil.PATTERN_MONEY));
        System.out.println(formatNumber("99,999,999.00", NumberUtil.PATTERN_DOUBLE));
    }

}

package cn.com.sinosoft.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 描述：MD5加密工具类<br>
 * 作者：Leeyao<br>
 * 修改日期：2013年12月25日下午8:39:14<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
public class MD5 {
    
    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    /**
     * 方法名称：byteToString<br>
     * 描述：转换字节数组为16进制字串 即MD5码<br>
     * 作者：Leeyao<br>
     * 修改日期：2013年12月25日下午8:42:29<br>
     * @param bByte
     * @return
     */
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    /**
     * 方法名称：GetMD5Code<br>
     * 描述：对字符串进行MD5加密<br>
     * 作者：Leeyao<br>
     * 修改日期：2013年12月25日下午8:40:57<br>
     * @param strObj String 要加密的字符串
     * @return String 加密后的MD5字符串
     */
    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
}

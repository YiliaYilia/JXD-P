package cn.com.sinosoft.web.util;

//FrontEnd Plus GUI for JAD
//DeCompiled : DataCoverter.class

 
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataCoverter
{

 public static String HexCode[] = {
     "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
     "A", "B", "C", "D", "E", "F"
 };

 public DataCoverter()
 {
 }

 public static byte[] intToBytes(int data)
 {
     byte b[] = new byte[4];
     for(int i = 0; i < 4; i++)
         b[i] = (byte)(data >>> 24 - i * 8);

     return b;
 }

 public static int bytesToInt(byte data[], int offset)
 {
     byte b[] = new byte[4];
     System.arraycopy(data, offset, b, 0, 4);
     return bytesToInt(b);
 }

 public static int bytesToInt(byte data[])
 {
     int temp = 0;
     int a = 0;
     for(int i = 0; i < 4; i++)
     {
         a <<= 8;
         temp = data[i] & 0xff;
         a |= temp;
     }

     return a;
 }

 public static byte[] longToBytes(long data)
 {
     byte b[] = new byte[8];
     for(int i = 0; i < 8; i++)
         b[i] = (byte)(int)(data >>> 56 - i * 8);

     return b;
 }

 public static long bytesToLong(byte data[], int offset)
 {
     byte b[] = new byte[8];
     System.arraycopy(data, offset, b, 0, 8);
     return bytesToLong(b);
 }

 public static long bytesToLong(byte data[])
 {
     long temp = 0L;
     long a = 0L;
     for(int i = 0; i < 8; i++)
     {
         a <<= 8;
         temp = data[i] & 0xff;
         a |= temp;
     }

     return a;
 }

 public static String decode(byte buf[], int offset, int length, int coding)
 {
     String str = null;
     try
     {
         if(coding == 0)
             str = new String(buf, offset, length, "US-ASCII");
         else
         if(coding == 8)
             str = new String(buf, offset, length, "UTF-16BE");
         else
         if(coding == 15)
             str = new String(buf, offset, length, "gb2312");
     }
     catch(UnsupportedEncodingException e)
     {
         e.printStackTrace();
         return null;
     }
     return str;
 }

 public static byte[] encode(String str, int coding)
 {
     byte buf[] = (byte[])null;
     if(str == null)
         return buf;
     try
     {
         if(coding == 0)
             buf = str.getBytes("US-ASCII");
         else
         if(coding == 8)
             buf = str.getBytes("UTF-16BE");
         else
         if(coding == 15)
             buf = str.getBytes("gb2312");
     }
     catch(UnsupportedEncodingException e)
     {
         e.printStackTrace();
         return null;
     }
     return buf;
 }

 public static String byteArrayToHexString(byte b[])
 {
     StringBuilder sb = new StringBuilder();
     for(int i = 0; i < b.length; i++)
         sb = sb.append(byteToHexString(b[i]));

     return sb.toString();
 }

 public static String byteToHexString(byte b)
 {
     int n = b;
     if(n < 0)
         n += 256;
     int d1 = n / 16;
     int d2 = n % 16;
     return (new StringBuilder(String.valueOf(HexCode[d1]))).append(HexCode[d2]).toString();
 }

 public static String byteArrayToBinaryString(byte b[])
 {
     StringBuilder sb = new StringBuilder();
     for(int i = 0; i < b.length; i++)
         sb = sb.append(byteToBinaryString(b[i]));

     return sb.toString();
 }

 public static String byteToBinaryString(byte b)
 {
     int n = b;
     if(n < 0)
         n += 256;
     StringBuilder sb = new StringBuilder(8);
     for(; n > 0; n >>= 1)
         sb = sb.append(n % 2);

     for(; sb.length() < sb.capacity(); sb = sb.append("0"));
     return sb.reverse().toString();
 }

 public static byte[] encodeByMD5(byte a[])
 {
     byte b[] = (byte[])null;
     try
     {
         MessageDigest md5 = MessageDigest.getInstance("MD5");
         b = md5.digest(a);
     }
     catch(NoSuchAlgorithmException e)
     {
         e.printStackTrace();
         return null;
     }
     return b;
 }

 public static byte[] MD5Encoding(byte a[])
 {
     byte digest[] = (byte[])null;
     try
     {
         MessageDigest md = MessageDigest.getInstance("MD5");
         md.update(a);
         digest = md.digest();
     }
     catch(NoSuchAlgorithmException e)
     {
         e.printStackTrace();
         return null;
     }
     return digest;
 }

 public static void main(String args[])
 {
     byte a[] = longToBytes(0xffffffff80000001L);
     for(int i = 0; i < a.length; i++)
         System.out.println(a[i]);

     System.out.println(bytesToLong(a) == 0xffffffff80000001L);
     byte b[] = encode("\u6211\u4EEC\u662F\u5BB3\u866B", 8);
     for(int i = 0; i < b.length; i++)
         System.out.println(b[i]);

     String c = decode(b, 0, b.length, 8);
     System.out.println(c);
     System.out.println((new StringBuilder("....")).append(bytesToLong(longToBytes(0xb3a4997f1d3bc21L))).append(" ...").append(0x80000000).toString());
     System.out.println("".getBytes().length);
 }

}
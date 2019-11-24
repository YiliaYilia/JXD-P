package cn.com.sinosoft.ess.protal.payment;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.util.ResourceBundle;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import cn.com.sinosoft.core.utils.PropertityUtil;

import com.icbc.crypto.utils.TripleDesCryptFileInputKey;


/**  
 * 3DES加密工具类  
 */  
public class CryptoUtil {   
    // 加解密统一使用的编码方式   
    private final static String encoding = "utf-8";   
  
    /**  
     * 3DES加密  
     *   
     * @param plainText 普通文本
     * @param key 密钥
     * @param iv 向量
     * @return 密文
     * @throws InvalidAlgorithmParameterException 
     * @throws Exception 
     * @throws Exception   
     */  

    public static String TripleDesEncode(String plainText,String key,String iv) throws Exception {   
    	 Key deskey = null;   
         DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());   
         SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");   
         deskey = keyfactory.generateSecret(spec);   
         Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
         IvParameterSpec ips = new IvParameterSpec(iv.getBytes());   
         //cipher.init(Cipher.ENCRYPT_MODE, deskey,ips);
         cipher.init(Cipher.ENCRYPT_MODE, deskey);
         byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));   
         return TripleDesCryptFileInputKey.Ascii2Text(encryptData);

    } 
    
    public static String TripleDesEncode(String plainText) throws Exception {
    	//读取加密配置文件中密钥
    	PropertityUtil.init("config/pwd.properties");
    	String keyStr = PropertityUtil.get("key");
    	return TripleDesEncode(plainText,keyStr,"");
    }
  
    /**  
     * 3DES解密  
     *   
     * @param encryptText 加密文本  
     * @param key 密钥
     * @param iv 向量
     * @return 明文
     * @throws Exception  
     */  

    public static String TripleDesDecode(String encryptText,String key,String iv) throws Exception {   
    	 Key deskey = null;   
         DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());   
         SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");   
         deskey = keyfactory.generateSecret(spec);   
         Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
         IvParameterSpec ips = new IvParameterSpec(iv.getBytes()); 
         cipher.init(Cipher.DECRYPT_MODE, deskey);  
         //cipher.init(Cipher.DECRYPT_MODE, deskey, ips);   
         byte[] bytes = new byte[encryptText.getBytes().length/2];
         TripleDesCryptFileInputKey.Text2Ascii(encryptText.getBytes(), bytes);
         byte[] decryptData = cipher.doFinal(bytes);
         return new String(decryptData, encoding);  
    }
    public static String TripleDesDecode(String plainText) throws Exception {
    	PropertityUtil.init("config/pwd.properties");
    	String keyStr = PropertityUtil.get("key");
    	return TripleDesDecode(plainText,keyStr,"");
    }
    
    public static String MD5(String hashCode){
    	return MD5(hashCode,"utf-8");
    	
    }
    public static String MD5(String hashCode,String enc){
		try{
			java.security.MessageDigest alga=java.security.MessageDigest.getInstance("MD5");//15λ
			alga.update(hashCode.getBytes(enc));
			byte[] digesta=alga.digest();		
			hashCode = TripleDesCryptFileInputKey.Ascii2Text(digesta);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return hashCode;
    }
    

    
    public static void main(String[] args) throws Exception {  
        String data="Test1111";  
        String str5 = TripleDesEncode(data);  
        System.out.println(str5);

        String str6 = TripleDesDecode(str5);  
        System.out.println();
        System.out.println(str6);  
        
    }  

}  
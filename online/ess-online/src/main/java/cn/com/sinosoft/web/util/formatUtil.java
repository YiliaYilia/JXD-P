//package cn.com.sinosoft.web.util;
//
//import java.lang.reflect.Field;
//import java.net.URLEncoder;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.junit.Test;
//
//import cn.com.sinosoft.web.weixin.Contracts;
//
//
//public class formatUtil {
//	public static <T> String change(Class clazz,T t) throws Exception{
//		StringBuilder builder = new StringBuilder();//准备拼接字符串
//		Field[] fields = clazz.getDeclaredFields();
//		for(Field field:fields){
//			String name = field.getName();//字段名
//			field.setAccessible(true);
//			String type = field.getType().getName();
//			if(type.equals(java.lang.String.class.getName())){//如果字段是String类型
//				String value = strChange((String)field.get(t));//字段值
//				builder.append(name+"="+value+"&");
//			}else if(type.equals(java.lang.Integer.class.getName())||type.equals("int")){
//				int value = field.getInt(t);
//				builder.append(name+"="+value+"&");
//			}
//		}
//		builder.deleteCharAt(builder.length()-1);//删除最后一位的&
//		return builder.toString();
//		
//	}
//	
//	
//	public static String strChange(String str){
//		String value = null;
//		boolean flag = isChineseChar(str);
//		if(flag){
//			value = URLEncoder.encode(str);
//		}else{
//			value = str;
//		}
//		return value;
//	}
//	public static boolean isChineseChar(String str){
//        boolean temp = false;
//        Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
//        Matcher m=p.matcher(str); 
//        if(m.find()){ 
//            temp =  true;
//        }
//        return temp;
//    }
//	@Test
//	public void fun() throws Exception{
//		Contracts contracts = new Contracts();
//		contracts.setName("王道坤");
//		contracts.setIdType("I");
//		contracts.setIdNo("23010319730610243X");
//		String str = change(contracts.getClass(),contracts);
//		System.out.println(str);
//	}
//	
//}

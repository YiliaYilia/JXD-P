package cn.com.sinosoft.ess.protal.service;

import java.util.Vector;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DealCloginP {  
    
    /* 
     * 将一个list集合封装成json数据后 
     * 它是以字符串的形式发送的!!! 
     */  
    public static String toJson( CwResP bean  ) {  
        //Vector<CwResP> list = new Vector<CwResP>();  
        JSONArray json = new JSONArray().fromObject(bean);  
        String jon = json.toString();  
        return jon;  
        /* 
         * jon的结果为一下形式 
         * []为集合的识别符 
         * {}为类的识别符 
         * [{"address":"xian","name":"xiaohun"}] 
         */  
    }  

        public static CloginP getBean(String json) {  
            //服务端传来的json数据是集合封装成的所以用JSONArray解析  
            JSONArray arr = new JSONArray().fromObject(json);  
            //准备存放解析后的数据集合  
            Vector<CloginP> list = new Vector<CloginP>();  
            //由于是集合所以循环取出每一个集合内的类  
            for (int i = 0; i < arr.size(); i++) {  
                /* 
                 * 将JSONArray的单一属性转换为Object等待转换Javabean 
                 * 经过这一步后数据就分解成多个 
                 * {"address":"xian","name":"xiaohun"} 
                 */  
                JSONObject obj = new JSONObject().fromObject(arr.getJSONObject(i));  
                //将json数据自动的转变成javabean  
                Object object = obj.toBean(obj, CloginP.class);  
                CloginP info = (CloginP) object;  
            
                list.add(info);  
            }  
            return list.get(0);  
        } 
        public static void main(String[] args) {
        	CwResP a = new CwResP();  
            a.setSuccessFlag("1");  
            a.setErrMsg("系统出错");
        	String jsonStr = toJson(a);//返回json格式方法
        	System.out.println(jsonStr);
        	CloginP v = getBean(jsonStr);//接收json格式返回报文处理方法 
        	
        		 System.out.println(v.getSuccessFlag());
        		 System.out.println(v.getErrMsg());
        	 
    	}
}  
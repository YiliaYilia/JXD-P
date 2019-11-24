package cn.com.sinosoft.web.weixin;
/**access_token的作用时间为2个小时
 * */
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

//import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.web.domain.Data;
import cn.com.sinosoft.web.domain.TemplateData;
import cn.com.sinosoft.web.domain.Token;
import cn.com.sinosoft.web.domain.WxTemplate;
import cn.com.sinosoft.web.util.CommonUtil;
import cn.com.sinosoft.web.util.WeixinUtil;
import net.sf.json.JSONObject;

public class WeiXin {
	private static Logger log = LoggerFactory.getLogger(WeiXin.class);
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(WeiXin.class.getResourceAsStream("App.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	@Test
	public void fun(){
		//String openId = "oipGbs1ygVGqlXzioB6K4E-IESRU";//张伟的openId
		String openId = "oipGbsw8KVmbm2rifsYmPv3v8RWo";//李文宇的openId
		String appId = getId("AppId");//应用ID
		String appSecret = getId("AppSecret");//应用密钥
		String template_id = getId("template_id");//模板id
		Token token = CommonUtil.getToken(appId, appSecret);
        String access_token = token.getAccessToken();
		getUserData(access_token, openId);//获取用户信息
		//String url = "";//详情登陆页
		WxTemplate temp = production(template_id,openId);//获取模板
		pushTemplateMessages(access_token,temp);//发送模板消息
	}
	public static String getId(String str){
		return pro.getProperty(str);
	}
	
	//调用微信接口根据code获取用户id,其中request为针对自定义菜单打开的url中的回调地址所发的请求
	public static String getOpenId(HttpServletRequest req,String appId, String appSecret){
		String code = req.getParameter("code");//获取code
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appId+"&secret="+appSecret+"&code="+code+"&grant_type=authorization_code";
		JSONObject json = CommonUtil.httpsRequest(url, "GET", null);
		String openId = (String)json.get("openid");
		return openId;
	}
	//调用微信接口根据openId获取用户的信息，返回值未设，可提取需要信息创建javaBean
	public static void getUserData(String access_token, String openId){
        String user = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openId+"&lang=zh_CN";
		JSONObject userData = CommonUtil.httpsRequest(user, "GET", null);
		int subscribe = (Integer)userData.get("subscribe");//用户是否关注 1为关注 0为未关注
		String nickname = (String)userData.get("nickname");//用户昵称
		int sex = (Integer) userData.get("sex");//性别 1男 2女
		String language = (String)userData.get("language");//用户的语言，简体中文为zh_CN
		String country = (String)userData.get("country");//所在国家
		String province = (String)userData.get("province");//用户所在的省份，或直辖市
		String city = (String)userData.get("city");//如果province为直辖市，这里会取得所在区，如：海淀、朝阳
        String headimgurl = (String)userData.get("headimgurl");//用户头像所属url
        int subscribe_time = (Integer)userData.get("subscribe_time");//用户最近一次的关注时间，秒为单位的时间戳。
        System.out.println(subscribe+" "+nickname+" "+subscribe_time);
	}
	//生成模板对象，需根据业务覆写
	public static WxTemplate production(String template_id,String openId){
		WxTemplate temp = new WxTemplate();
        Data data = new Data();
        TemplateData first = new TemplateData();
        first.setColor("#000000");
        first.setValue("***标题***");
        TemplateData keyword1 = new TemplateData();
        keyword1.setColor("#000000");
        keyword1.setValue("在此输入id");
        TemplateData keyword2 = new TemplateData();
        keyword2.setColor("#000000");
        keyword2.setValue("绑定的账号");
        TemplateData keyword3 = new TemplateData();
        keyword3.setColor("#000000");  
        keyword3.setValue("开通的功能");  
        TemplateData remark = new TemplateData();
        remark.setColor("#000000");  
        remark.setValue("另外的备注");  

        data.setFirst(first);
        data.setKeyword1(keyword1);
        data.setKeyword2(keyword2);
        data.setKeyword3(keyword3);
        data.setRemark(remark);
        temp.setTouser(openId);
        temp.setTemplate_id(template_id);//模板id
        //temp.setUrl(url);//发送事件结果反馈地址参见TempServlet
        temp.setTopcolor("#173177");
        temp.setData(data);
        
        return temp;
	}
	//发送模板消息
	public static JSONObject pushTemplateMessages(String access_token,WxTemplate temp){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
        String jsonString = JSONObject.fromObject(temp).toString();
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonString);
        int result = 0;
        if (null != jsonObject) {
             if (0 != jsonObject.getInt("errcode")) {
                 result = jsonObject.getInt("errcode");  
                 log.error("错误 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
             }  
         }
        log.info("模板消息发送结果："+result);
        /* 返回结果示例：{
           "errcode":0,
           "errmsg":"ok",
           "msgid":200228332
       	} */
        return jsonObject;
	}
}

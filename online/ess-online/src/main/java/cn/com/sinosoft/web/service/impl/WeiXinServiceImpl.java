package cn.com.sinosoft.web.service.impl;
/**
 * access_token的作用时间为2个小时
 * 其实这是工具类而非service
 * */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.web.domain.Data;
import cn.com.sinosoft.web.domain.TemplateData;
import cn.com.sinosoft.web.domain.Token;
import cn.com.sinosoft.web.domain.WxTemplate;
import cn.com.sinosoft.web.entity.WeiXinUserEntity;
import cn.com.sinosoft.web.util.CommonUtil;
import cn.com.sinosoft.web.util.WeixinUtil;


public class WeiXinServiceImpl {
	private static Logger log = LoggerFactory.getLogger(WeiXinServiceImpl.class);
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(WeiXinServiceImpl.class.getResourceAsStream("/config/App.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getId(String str){
		return pro.getProperty(str);
	}
	
	/**
	 * 发送消息
	 * @param openID
	 * @param message
	 */
	public void sendMessage(String openID,String message){
		Token token = Token.getInstance();
        String access_token = token.getAccessToken();
        WeiXinUserEntity weixinUser = new WeiXinUserEntity();
        weixinUser.setJSON(getUserData(access_token, openID));//获取用户信息
		WxTemplate temp = production(getId("template_id"),openID,message,weixinUser.getNickname());//获取模板
		pushTemplateMessages(access_token,temp);//发送模板消息
	}
	
	
	/**
	 * 获取媒体文件
	 * @param mediaId 
	 * @param savePath 文件本地路径
	 * @param fileName 文件名
	 * @return 文件的展示路径
	 */
	public static String downloadMedia(String mediaId, String savePath,String fileName) {
		Token token = Token.getInstance();
        String accessToken = token.getAccessToken();
		String mediaPath = null;
		// 拼接请求地址
		String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 根据内容类型获取扩展名
			String fileExt = CommonUtil.getFileExt(conn.getHeaderField("Content-Type"));
			String filePath = savePath + fileName + fileExt;
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			File file=new File(filePath);
			if(!file.exists())    
			{    
			    try {    
			        file.createNewFile();    
			    } catch (IOException e) {    
			        e.printStackTrace();    
			    }    
			}
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();
			conn.disconnect();
			mediaPath= getId("mediaPath")+fileName + fileExt;
			String info = String.format("下载媒体文件成功，requestUrl="+requestUrl+",filePath=" + mediaPath);
			log.info(info);
		} catch (Exception e) {
			e.printStackTrace();
			String error = String.format("下载媒体文件失败：%s", e);
			log.error(error);
		}
		return mediaPath;
	}
	
	
	
	
	//调用微信接口根据code获取用户id,其中request为针对自定义菜单打开的url中的回调地址所发的请求
	public static String getOpenId(HttpServletRequest req){
		log.info("微信接口获取openid开始");
		String code = req.getParameter("code");//获取code
		log.info("获取用户code："+code);
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+getId("AppId")+"&secret="+getId("AppSecret")+"&code="+code+"&grant_type=authorization_code";
		log.info("向微信请求的带参数地址："+url);
		JSONObject json = CommonUtil.httpsRequest(url, "GET", null);
		log.info("微信返回json："+json);
		String openId = (String)json.get("openid");
		log.info("已获取OpenID：  "+openId);
		return openId;
	}
	
	//调用微信接口根据access_token获取JSTicket
	public static String getTicket(String access_token){
		log.info("微信接口获取ticket···");
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi";
		log.info("获取ticket向微信请求参数地址:"+url);
		JSONObject json = CommonUtil.httpsRequest(url, "GET", null);
		log.info("获取ticket微信返回json:"+json);
		String errcode = json.getString("errcode");
		String errmsg = json.getString("errmsg");
		String ticket = (String)json.get("ticket");
		if(!errcode.equals("0")){
			ticket=null;
		}
		log.info("已获取ticket"+ticket+"  errcode:  "+errcode+"  errmsg:  "+errmsg);
		return ticket;
	}
	
	//调用微信接口根据openId获取用户的信息，返回值未设，可提取需要信息创建javaBean
	public JSONObject getUserData(String access_token, String openId){
        String user = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openId+"&lang=zh_CN";
		return CommonUtil.httpsRequest(user, "GET", null);
	}
	
	//生成模板对象，需根据业务覆写
	public static WxTemplate production(String template_id,String openId,String message,String userName){
		WxTemplate temp = new WxTemplate();
        Data data = new Data();
        TemplateData first = new TemplateData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        first.setColor("#000000");
        first.setValue("您好，您已成功注册瑞泰人寿。");
        TemplateData keyword1 = new TemplateData();
        keyword1.setColor("#000000");
        keyword1.setValue(userName);
        TemplateData keyword2 = new TemplateData();
        keyword2.setColor("#000000");
        keyword2.setValue(df.format(new Date()));
        TemplateData remark = new TemplateData();
        remark.setColor("#000000");  
        remark.setValue(message);  

        data.setFirst(first);
        data.setKeyword1(keyword1);
        data.setKeyword2(keyword2);
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
	
	/**
     * 根据路径上传文件到微信服务器(临时)
     * @param fileType 文件类型
     * @param filePath 文件路径
     * @param accessToken 接口访问凭证
     * @return JSONObject
     * @throws Exception
	 * 上传的媒体文件限制
     * 图片（image）:1MB，支持JPG格式
     * 语音（voice）：2MB，播放长度不超过60s，支持AMR格式
     * 视频（video）：10MB，支持MP4格式
     * 普通文件（file）：10MB
     */
    public static JSONObject send(String fileType, String filePath,String accessToken) throws Exception {  
        String result = null;  
        File file = new File(filePath);  
        if (!file.exists() || !file.isFile()) {  
            throw new IOException("文件不存在");  
        }
        URL urlObj = new URL("http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+ accessToken + "&type="+fileType+"");  
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();  
        con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式  
        con.setDoInput(true);  
        con.setDoOutput(true);  
        con.setUseCaches(false); // post方式不能使用缓存  
        // 设置请求头信息  
        con.setRequestProperty("Connection", "Keep-Alive");  
        con.setRequestProperty("Charset", "UTF-8");  
        // 设置边界  
        String BOUNDARY = "----------" + System.currentTimeMillis();  
        con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+ BOUNDARY);  
        // 请求正文信息  
        // 第一部分：  
        StringBuilder sb = new StringBuilder();  
        sb.append("--"); // 必须多两道线  
        sb.append(BOUNDARY);  
        sb.append("\r\n");  
        sb.append("Content-Disposition: form-data;name=\"file\";filename=\""+ file.getName() + "\"\r\n");  
        sb.append("Content-Type:application/octet-stream\r\n\r\n");  
        byte[] head = sb.toString().getBytes("utf-8");  
        // 获得输出流  
        OutputStream out = new DataOutputStream(con.getOutputStream());  
        // 输出表头  
        out.write(head);  
        // 文件正文部分  
        // 把文件已流文件的方式 推入到url中  
        DataInputStream in = new DataInputStream(new FileInputStream(file));  
        int bytes = 0;  
        byte[] bufferOut = new byte[1024];  
        while ((bytes = in.read(bufferOut)) != -1) {  
        out.write(bufferOut, 0, bytes);  
        }  
        in.close();  
        // 结尾部分  
        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
        out.write(foot);  
        out.flush();  
        out.close();  
        StringBuffer buffer = new StringBuffer();  
        BufferedReader reader = null;  
        try {  
        // 定义BufferedReader输入流来读取URL的响应  
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
        String line = null;  
        while ((line = reader.readLine()) != null) {  
        buffer.append(line);  
        }  
        if(result==null){  
        result = buffer.toString();  
        }  
        } catch (IOException e) {  
        System.out.println("发送POST请求出现异常！" + e);  
        e.printStackTrace();  
        throw new IOException("数据读取异常");  
        } finally {  
        if(reader!=null){  
        reader.close();  
        }  
        }  
        JSONObject jsonObject = JSONObject.fromObject(result);  
        return jsonObject;  
    }
	
    
    
    /**
     * 向指定用户发送客服消息
     * @param accessToken
     * @param openId
     * @param content 消息内容
     * @return
     */
    public boolean pushServiceMessage(String openId,String content){
    	Token token = Token.getToken();
        String access_token = token.getAccessToken();
		boolean result = false;
		JSONObject jsonObject = null;
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+access_token;
		String jsonData = "{\"touser\":\""+openId+"\",\"msgtype\":\"text\",\"text\":{\"content\":\""+content+"\"}}";
		jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", jsonData);
		if(jsonObject!=null){
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if(errorCode == 0){
				result = true;
				log.info("发送客服消息成功 errcode:"+errorCode+", errorMsg:"+errorMsg);
			}else{
				log.error("发送客服消息失败 errcode:"+errorCode+", errorMsg:"+errorMsg);
			}
		}
		return result;
	}
    
    
    public static void main(String[] args) {
    	new WeiXinServiceImpl().pushServiceMessage("oipGbs-sFsZubcHxoxFs0iNPaAHo", "您好！您的保单LP00001234投资账户资产转移已于2015-4-1申请成功");
	}
	
}

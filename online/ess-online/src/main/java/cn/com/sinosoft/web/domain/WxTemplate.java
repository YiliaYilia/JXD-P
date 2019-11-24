package cn.com.sinosoft.web.domain;




//模板消息封装类
public class WxTemplate {  
    private String template_id;//模板id
    private String touser;//用户的openId
    //private String url;//URL置空，则在发送后，点击模板消息会进入一个空白页面（ios），或无法点击（android）。
    private String topcolor;//颜色
    private Data data;//模板消息字段的集合封装
      
    public String getTemplate_id() {  
        return template_id;  
    }  
    public void setTemplate_id(String template_id) {  
        this.template_id = template_id;  
    }  
    public String getTouser() {  
        return touser;  
    }  
    public void setTouser(String touser) {  
        this.touser = touser;  
    }  
//    public String getUrl() {  
//        return url;  
//    }  
//    public void setUrl(String url) {  
//        this.url = url;  
//    }  
    public String getTopcolor() {  
        return topcolor;  
    }  
    public void setTopcolor(String topcolor) {  
        this.topcolor = topcolor;  
    }
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}  
}  

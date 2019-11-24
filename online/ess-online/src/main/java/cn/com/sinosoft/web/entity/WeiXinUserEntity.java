package cn.com.sinosoft.web.entity;

import net.sf.json.JSONObject;

public class WeiXinUserEntity {
	private Integer	subscribe;		//用户是否关注 1为关注 0为未关注
	private String	nickname;		//用户昵称
	private Integer	sex;			//性别 1男 2女
	private String 	language;		//用户的语言，简体中文为zh_CN
	private String 	country;		//所在国家
	private String 	province;		//用户所在的省份，或直辖市
	private String 	city;			//如果province为直辖市，这里会取得所在区，如：海淀、朝阳
	private String 	headimgurl;		//用户头像所属url
	private Integer	subscribe_time;	//用户最近一次的关注时间，秒为单位的时间戳。
	
	
	
	public Integer getSubscribe(){
		return this.subscribe;		
	}
	
	public void setSubscribe(Integer subscribe){
		this.subscribe = subscribe;
	}
	
	public String getNickname(){
		return this.nickname;		
	}
	
	public void setNickname(String nickname){
		this.nickname = nickname;
	}
	
	public Integer getSex(){
		return this.sex;		
	}
	
	public void setSex(Integer sex){
		this.sex = sex;
	}
	
	public String getLanguage(){
		return this.language;		
	}
	
	public void setLanguage(String language){
		this.language = language;
	}
	
	public String getCountry(){
		return this.country;		
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
	public String getProvince(){
		return this.province;		
	}
	
	public void setProvince(String province){
		this.province = province;
	}
	
	public String getCity(){
		return this.city;		
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getHeadimgurl(){
		return this.headimgurl;		
	}
	
	public void setHeadimgurl(String headimgurl){
		this.headimgurl = headimgurl;
	}
	
	public Integer getSubscribe_time(){
		return this.subscribe_time;		
	}
	
	public void setSubscribe_time(Integer subscribe_time){
		this.subscribe_time = subscribe_time;
	}
	
	public void setJSON(JSONObject userData){
		subscribe = (Integer)userData.get("subscribe");
		nickname = (String)userData.get("nickname");
		sex = (Integer) userData.get("sex");
		language = (String)userData.get("language");
		country = (String)userData.get("country");
		province = (String)userData.get("province");
		city = (String)userData.get("city");
        headimgurl = (String)userData.get("headimgurl");
        subscribe_time = (Integer)userData.get("subscribe_time");
	}
}

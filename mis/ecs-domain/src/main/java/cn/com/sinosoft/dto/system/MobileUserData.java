package cn.com.sinosoft.dto.system;

import java.util.List;


public class MobileUserData {
	private String total;
	private List<MobileUserDataRow> rows;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<MobileUserDataRow> getRows() {
		return rows;
	}

	public void setRows(List<MobileUserDataRow> rows) {
		this.rows = rows;
	}

	public static class MobileUserDataRow {
		private String id;// 主键          	
		private String coustomerid;// 客户号	
		private String name;// 客户姓名      	
		private String idtype;// 证件类型    	
		private String idnumber;// 证件号码  	
		private String sex;// 性别 M/F     	
		private String birthday;// 生日    	
		private String email;// 邮箱       	
		private String address;// 地址     	
		private String postcode;// 邮编    	
		private String telphone;// 电话    	
		private String mobile;// 手机      	
		private String state;// 用户状态     	
		private String password;// 密码    
	    private String microid;// 微信号    
		private String creattime;//创建（绑定）时间
		private String updatetime;//修改时间
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getCoustomerid() {
			return coustomerid;
		}
		public void setCoustomerid(String coustomerid) {
			this.coustomerid = coustomerid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getIdtype() {
			return idtype;
		}
		public void setIdtype(String idtype) {
			this.idtype = idtype;
		}
		public String getIdnumber() {
			return idnumber;
		}
		public void setIdnumber(String idnumber) {
			this.idnumber = idnumber;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
		public String getTelphone() {
			return telphone;
		}
		public void setTelphone(String telphone) {
			this.telphone = telphone;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMicroid() {
			return microid;
		}
		public void setMicroid(String microid) {
			this.microid = microid;
		}
		public String getCreattime() {
			return creattime;
		}
		public void setCreattime(String creattime) {
			this.creattime = creattime;
		}
		public String getUpdatetime() {
			return updatetime;
		}
		public void setUpdatetime(String updatetime) {
			this.updatetime = updatetime;
		}
	    
	}
}

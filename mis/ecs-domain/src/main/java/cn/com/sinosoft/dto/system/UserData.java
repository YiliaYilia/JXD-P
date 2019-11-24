package cn.com.sinosoft.dto.system;

import java.util.Date;
import java.util.List;

/**
 * 描述：用户管理<br>
 * 作者：Leeyao<br>
 * 修改日期：2013年12月19日下午7:59:37<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
public class UserData {
	private String total;
	private List<UserDataRow> rows;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<UserDataRow> getRows() {
		return rows;
	}

	public void setRows(List<UserDataRow> rows) {
		this.rows = rows;
	}

	public static class UserDataRow {
		private String userid;
		private String username;
		private String usertype;
		private String email;
		private String sex;
		private String phone;
		private String state;
		private String operatorname;
		private Date createtime;
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUsertype() {
			return usertype;
		}
		public void setUsertype(String usertype) {
			this.usertype = usertype;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getOperatorname() {
			return operatorname;
		}
		public void setOperatorname(String operatorname) {
			this.operatorname = operatorname;
		}
		public Date getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}
		
	}
}

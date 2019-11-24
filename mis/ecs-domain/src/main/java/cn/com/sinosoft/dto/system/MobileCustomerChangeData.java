package cn.com.sinosoft.dto.system;

import java.util.List;


public class MobileCustomerChangeData {
	private String total;
	private List<MobileCustomerChangeDataRow> rows;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<MobileCustomerChangeDataRow> getRows() {
		return rows;
	}

	public void setRows(List<MobileCustomerChangeDataRow> rows) {
		this.rows = rows;
	}

	public static class MobileCustomerChangeDataRow {
		private String id;// 主键          	
		private String coustomerid;// 客户号	
		private String name;// 客户姓名      	
		private String idtype;// 证件类型    	
		private String idnumber;// 证件号码  	
		private String email;// 邮箱       	
		private String address;// 地址     	
		private String postcode;// 邮编  
		private String mobile;// 手机      	
		private String updatetime;//修改时间
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
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getUpdatetime() {
			return updatetime;
		}
		public void setUpdatetime(String updatetime) {
			this.updatetime = updatetime;
		}
	}
}

package cn.com.sinosoft.dto.system;

import java.util.Date;
import java.util.List;


public class PermissionData {
	private String total;
	private List<PermissionDataRow> rows;
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}


	public List<PermissionDataRow> getRows() {
		return rows;
	}

	public void setRows(List<PermissionDataRow> rows) {
		this.rows = rows;
	}

	public static class PermissionDataRow {
		private String permissionid;
		private String permissionname;
		private String permissiondatadesc;
		private Date permissioncreatetime;
		private String operatorname;
		private String createtimeformat;
		
		public String getOperatorname() {
			return operatorname;
		}
		public void setOperatorname(String operatorname) {
			this.operatorname = operatorname;
		}
		public String getCreatetimeformat() {
		
			return createtimeformat;
		}
		public void setCreatetimeformat(String createtimeformat) {
			this.createtimeformat = createtimeformat;
		}
		public String getPermissionid() {
			return permissionid;
		}
		public void setPermissionid(String permissionid) {
			this.permissionid = permissionid;
		}
		public String getPermissionname() {
			return permissionname;
		}
		public void setPermissionname(String permissionname) {
			this.permissionname = permissionname;
		}
		public String getPermissiondatadesc() {
			return permissiondatadesc;
		}
		public void setPermissiondatadesc(String permissiondesc) {
			this.permissiondatadesc = permissiondesc;
		}
		public Date getPermissioncreatetime() {
			return permissioncreatetime;
		}
		public void setPermissioncreatetime(Date permissioncreatetime) {
			this.permissioncreatetime = permissioncreatetime;
		}
	}
}

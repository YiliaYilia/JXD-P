package cn.com.sinosoft.dto.system;

import java.util.Date;
import java.util.List;
/**
 * 描述：用户组DTO<br>
 * 作者：dengyu <br>
 * 修改日期：2013-12-18下午06:40:25 <br>
 * E-mail: <br>
 */
public class UserGoutpDate {
	private String total;
	private List<UserGoutpDateRow> rows;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<UserGoutpDateRow> getRows() {
		return rows;
	}
	public void setRows(List<UserGoutpDateRow> rows) {
		this.rows = rows;
	}

	public static class UserGoutpDateRow{
		private String usergroupid;
		private String usergroupname;
		private String usergroupdesc;
		private String operatorname;
		private Date creatime;
		private String timeString; 
		
		public String getUsergroupid() {
			return usergroupid;
		}
		public void setUsergroupid(String usergroupid) {
			this.usergroupid = usergroupid;
		}
		public String getUsergroupname() {
			return usergroupname;
		}
		public void setUsergroupname(String usergroupname) {
			this.usergroupname = usergroupname;
		}
		public String getUsergroupdesc() {
			return usergroupdesc;
		}
		public void setUsergroupdesc(String usergroupdesc) {
			this.usergroupdesc = usergroupdesc;
		}
		public String getOperatorname() {
			return operatorname;
		}
		public void setOperatorname(String operatorname) {
			this.operatorname = operatorname;
		}
		public Date getCreatime() {
			return creatime;
		}
		public void setCreatime(Date creatime) {
			this.creatime = creatime;
		}
		public String getTimeString() {
			return timeString;
		}
		public void setTimeString(String timeString) {
			this.timeString = timeString;
		}
	}
}

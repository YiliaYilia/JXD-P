package cn.com.sinosoft.dto.system;

import java.util.Date;
import java.util.List;



public class DateChangeForm {
	private String total;
	private List<DateChangeFormRow> rows;
	
	public String getTotal() {
		return total;
	}



	public void setTotal(String total) {
		this.total = total;
	}



	public List<DateChangeFormRow> getRows() {
		return rows;
	}



	public void setRows(List<DateChangeFormRow> rows) {
		this.rows = rows;
	}
	
	
	public static class DateChangeFormRow {
		private String coustomerid;// 客户号
		private String changeType;//变更主体
		private String cardType;// 证件类型
		private String cardNo;// 证件号码
		private String expiredDate;// 证件有效期
		private String front;// 证件图片（正）
		private String contrary;// 证件图片（反）
		private Date updatetime;//变更主体
		
		public String getCoustomerid() {
			return coustomerid;
		}
		public void setCoustomerid(String coustomerid) {
			this.coustomerid = coustomerid;
		}
		public String getCardType() {
			return cardType;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}
		public String getCardNo() {
			return cardNo;
		}
		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}
		public String getExpiredDate() {
			return expiredDate;
		}
		public void setExpiredDate(String expiredDate) {
			this.expiredDate = expiredDate;
		}
		public String getFront() {
			return front;
		}
		public void setFront(String front) {
			this.front = front;
		}
		public String getContrary() {
			return contrary;
		}
		public void setContrary(String contrary) {
			this.contrary = contrary;
		}
		public String getChangeType() {
			return changeType;
		}
		public void setChangeType(String changeType) {
			this.changeType = changeType;
		}
		public Date getUpdatetime() {
			return updatetime;
		}
		public void setUpdatetime(Date updatetime) {
			this.updatetime = updatetime;
		}
		
	}
}

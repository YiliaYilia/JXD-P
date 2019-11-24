package cn.com.sinosoft.domain.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 证件有效期变更报表实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "DateChangeData")
public class DateChangeData implements Serializable {
	private static final long serialVersionUID = 1L;
	private String coustomerid;// 客户号
	private String name;// 客户姓名
	private String cardType;// 证件类型
	private String cardNo;// 证件号码
	private String expiredDate;// 证件有效期
	private String front;// 证件图片（正）
	private String contrary;// 证件图片（反）
	private String changeType;//变更主体
	private Date updatetime;//更新时间
	private String sinoImageFlag;//上传影像系统标志，1代表上传影像系统

	@Id
	@Column(name = "COUSTOMERID", unique = true, nullable = false)
	public String getCoustomerid() {
		return coustomerid;
	}

	public void setCoustomerid(String id) {
		this.coustomerid = id;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "CARDTYPE")
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	@Column(name = "CARDNO")
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Column(name = "EXPIREDDATE")
	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	@Column(name = "FROUT")
	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}
	@Column(name = "CONTRARY")
	public String getContrary() {
		return contrary;
	}

	public void setContrary(String contrary) {
		this.contrary = contrary;
	}
	@Column(name = "CHANGETYPE")
	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	@Column(name="UPDATETIME")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Column(name="SINOIMAGEFLAG")
	public String getSinoImageFlag() {
		return sinoImageFlag;
	}

	public void setSinoImageFlag(String sinoImageFlag) {
		this.sinoImageFlag = sinoImageFlag;
	}

	
}

package cn.com.sinosoft.domain.sell;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GE_PAYLIST")
public class GePayList implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//以下变量与具体的表相关
	private String id;//主键
	private String orderid;//订单号
	private String microordercode;//微信订单号
	private String activecode;//活动码
	private String channelcode;//渠道编码
	private String paytype;//支付方式
	private String mount;//金额
	private Date paytime;//支付时间
	private String isback;//是否退款
	private String remark;//备注
//	private String applicantname;//投保人姓名
//	private String policyno;
//	private String productname;
	private Date starttime;
	private Date endtime;
	
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ID", nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "ORDERID")
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	@Column(name = "ACTIVECODE")
	public String getActivecode() {
		return activecode;
	}
	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}
	
	@Column(name = "CHANNELCODE")
	public String getChannelcode() {
		return channelcode;
	}
	public void setChannelcode(String channelcode) {
		this.channelcode = channelcode;
	}
	
	@Column(name = "PAYTYPE")
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	
	@Column(name = "MOUNT")
	public String getMount() {
		return mount;
	}
	public void setMount(String mount) {
		this.mount = mount;
	}
	
	@Column(name = "PAYTIME")
	
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	
	@Column(name = "ISBACK")
	public String getIsback() {
		return isback;
	}
	public void setIsback(String isback) {
		this.isback = isback;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "MICROORDERCODE")
	public String getMicroordercode() {
		return microordercode;
	}
	public void setMicroordercode(String microordercode) {
		this.microordercode = microordercode;
	}
	@Column(name = "STARTTIME")
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	@Column(name = "ENDTIME")
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
//	@Column(name = "APPLICANTNAME")
//	public String getApplicantname() {
//		return applicantname;
//	}
//	public void setApplicantname(String applicantname) {
//		this.applicantname = applicantname;
//	}
//	
//	@Column(name = "POLICYNO")
//	public String getPolicyno() {
//		return policyno;
//	}
//	public void setPolicyno(String policyno) {
//		this.policyno = policyno;
//	}
//	
//	@Column(name = "productname")
//	public String getProductname() {
//		return productname;
//	}
//	public void setProductname(String productname) {
//		this.productname = productname;
//	}

	
	
	
	
}
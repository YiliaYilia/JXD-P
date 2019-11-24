package cn.com.sinosoft.domain.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="ge_paymentTypeInfo")
public class GePaymentTypeInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6172642212354227487L;
	
	private String serialNo;
	private String loginWayCode;
	private String loginWayName;
	private String payTypeCode;
	private String payTypeName;
	private String payTypedescription;
	private String paymentPlatformCode;
	private String paymentPlatformName;
	private String productCode;
	private String productName;
	
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "serialNo")
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	@Column(name = "loginWayCode")
	public String getLoginWayCode() {
		return loginWayCode;
	}
	public void setLoginWayCode(String loginWayCode) {
		this.loginWayCode = loginWayCode;
	}
	
	@Column(name = "loginWayName")
	public String getLoginWayName() {
		return loginWayName;
	}
	public void setLoginWayName(String loginWayName) {
		this.loginWayName = loginWayName;
	}
	
	@Column(name = "payTypeCode")
	public String getPayTypeCode() {
		return payTypeCode;
	}
	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}
	
	@Column(name = "payTypeName")
	public String getPayTypeName() {
		return payTypeName;
	}
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	@Column(name = "payTypedescription")
	public String getPayTypedescription() {
		return payTypedescription;
	}
	public void setPayTypedescription(String payTypedescription) {
		this.payTypedescription = payTypedescription;
	}
	@Column(name = "paymentPlatformCode")
	public String getPaymentPlatformCode() {
		return paymentPlatformCode;
	}
	public void setPaymentPlatformCode(String paymentPlatformCode) {
		this.paymentPlatformCode = paymentPlatformCode;
	}
	
	@Column(name = "paymentPlatformName")
	public String getPaymentPlatformName() {
		return paymentPlatformName;
	}
	public void setPaymentPlatformName(String paymentPlatformName) {
		this.paymentPlatformName = paymentPlatformName;
	}
	
	@Column(name = "productCode")
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@Column(name = "productName")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}

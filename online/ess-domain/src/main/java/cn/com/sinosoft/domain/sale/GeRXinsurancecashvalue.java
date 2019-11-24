package cn.com.sinosoft.domain.sale;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "ge_rx_insurancecashvalue")
public class GeRXinsurancecashvalue implements Serializable {
	
	private String id;
	private String paymentperiod;		//交费期间
	private String sex;					//性别
	private String insuredage;			//报保年龄
	private String endyear;				//保单年度末
	private String cashvalue;			//现金价值
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "paymentperiod")
	public String getPaymentperiod() {
		return paymentperiod;
	}
	public void setPaymentperiod(String paymentperiod) {
		this.paymentperiod = paymentperiod;
	}
	
	@Column(name = "sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name = "insuredage")
	public String getInsuredage() {
		return insuredage;
	}
	public void setInsuredage(String insuredage) {
		this.insuredage = insuredage;
	}
	
	@Column(name = "endyear")
	public String getEndyear() {
		return endyear;
	}
	public void setEndyear(String endyear) {
		this.endyear = endyear;
	}
	
	@Column(name = "cashvalue")
	public String getCashvalue() {
		return cashvalue;
	}
	public void setCashvalue(String cashvalue) {
		this.cashvalue = cashvalue;
	}
	
	

}

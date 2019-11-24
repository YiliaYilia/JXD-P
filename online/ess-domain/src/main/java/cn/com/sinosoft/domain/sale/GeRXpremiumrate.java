package cn.com.sinosoft.domain.sale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ge_rx_premiumrate")
public class GeRXpremiumrate implements java.io.Serializable{
	
	private String id;
	private String insuredage; //投保年龄
	private String m_single;   //保费男性趸交
	private String f_single;   //保费女性趸交
	private String m_3years;   //男性交费期3年
	private String f_3years;   //女性交费期3年
	private String m_5years;   
	private String f_5years;
	private String m_10years;
	private String f_10years;
	private String m_20years;
	private String f_20years;
	
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
	
	@Column(name = "insuredage")
	public String getInsuredage() {
		return insuredage;
	}
	public void setInsuredage(String insuredage) {
		this.insuredage = insuredage;
	}
	
	@Column(name = "m_single")
	public String getM_single() {
		return m_single;
	}
	public void setM_single(String m_single) {
		this.m_single = m_single;
	}
	
	@Column(name = "f_single")
	public String getF_single() {
		return f_single;
	}
	public void setF_single(String f_single) {
		this.f_single = f_single;
	}
	
	@Column(name = "m_3years")
	public String getM_3years() {
		return m_3years;
	}
	public void setM_3years(String m_3years) {
		this.m_3years = m_3years;
	}
	
	@Column(name = "f_3years")
	public String getF_3years() {
		return f_3years;
	}
	public void setF_3years(String f_3years) {
		this.f_3years = f_3years;
	}
	
	@Column(name = "m_5years")
	public String getM_5years() {
		return m_5years;
	}
	public void setM_5years(String m_5years) {
		this.m_5years = m_5years;
	}
	
	@Column(name = "f_5years")
	public String getF_5years() {
		return f_5years;
	}
	public void setF_5years(String f_5years) {
		this.f_5years = f_5years;
	}
	
	@Column(name = "m_10years")
	public String getM_10years() {
		return m_10years;
	}
	public void setM_10years(String m_10years) {
		this.m_10years = m_10years;
	}
	
	@Column(name = "f_10years")
	public String getF_10years() {
		return f_10years;
	}
	public void setF_10years(String f_10years) {
		this.f_10years = f_10years;
	}
	
	@Column(name = "m_20years")
	public String getM_20years() {
		return m_20years;
	}
	public void setM_20years(String m_20years) {
		this.m_20years = m_20years;
	}
	
	@Column(name = "f_20years")
	public String getF_20years() {
		return f_20years;
	}
	public void setF_20years(String f_20years) {
		this.f_20years = f_20years;
	}
	
	
	

}

package cn.com.sinosoft.domain.sale;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "GE_EACCOUTSTATUS")
public class GeEaccoutStatus  implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String eadate;
	private String ybtstatus;
	private String wxstatus;
	
	
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "eadate")
	public String getEadate() {
		return eadate;
	}
	public void setEadate(String eadate) {
		this.eadate = eadate;
	}
	
	@Column(name = "ybtstatus")
	public String getYbtstatus() {
		return ybtstatus;
	}
	public void setYbtstatus(String ybtstatus) {
		this.ybtstatus = ybtstatus;
	}
	
	@Column(name = "wxstatus")
	public String getWxstatus() {
		return wxstatus;
	}
	public void setWxstatus(String wxstatus) {
		this.wxstatus = wxstatus;
	}
	
	
	
	
}

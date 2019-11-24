package cn.com.sinosoft.domain.sell;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 */
@Entity
@Table(name = "ge_holiday")
public class GeHoliday implements java.io.Serializable {
	
	private String id;
	private Date holidaydate;
	private String holidaydesc;
	private int holidaytype;
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getHolidaydate() {
		return holidaydate;
	}
	@Column(name = "HOLIDAYDATE", nullable = false, length = 8)
	public void setHolidaydate(Date holidaydate) {
		this.holidaydate = holidaydate;
	}
	@Column(name = "HOLIDAYDESC", length = 500)
	public String getHolidaydesc() {
		return holidaydesc;
	}
	public void setHolidaydesc(String holidaydesc) {
		this.holidaydesc = holidaydesc;
	}
	@Column(name = "HOLIDAYTYPE", length = 2)
	public int getHolidaytype() {
		return holidaytype;
	}
	public void setHolidaytype(int holidaytype) {
		this.holidaytype = holidaytype;
	}
	
}
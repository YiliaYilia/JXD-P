package cn.com.sinosoft.domain.sale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ge_geographical_area")
public class GeGeographicalArea implements java.io.Serializable{
	
	private String id;
	private String area_code;
	private String area_name;
	private String area_status; //1为省份 2为城市
	
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
	
	@Column(name = "area_code")
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	
	@Column(name = "area_name")
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	
	@Column(name = "area_status")
	public String getArea_status() {
		return area_status;
	}
	public void setArea_status(String area_status) {
		this.area_status = area_status;
	}
	
}

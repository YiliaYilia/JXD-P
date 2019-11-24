package cn.com.sinosoft.domain.dictonary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GE_DICTONARY")
public class GeDictonary implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String id;// 主键
	private String key;//字典数据键
	private String value;//字典数据值
	private String type;//字典数据类型
	private String fkey;//外部关联字段
	private String extend1;// 扩展字段1
	private String extend2;// 扩展字段2
	
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
	@Column(name = "KEY")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	@Column(name = "VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Column(name = "FKEY")
	public String getFkey() {
		return fkey;
	}

	public void setFkey(String fkey) {
		this.fkey = fkey;
	}
	@Column(name = "EXTEND1")
	public String getExtend1() {
		return extend1;
	}

	public void setPrem(String extend1) {
		this.extend1 = extend1;
	}
	@Column(name = "EXTEND2")
	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
		
}


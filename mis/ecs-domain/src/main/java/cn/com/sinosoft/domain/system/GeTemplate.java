package cn.com.sinosoft.domain.system;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 短信模板
 * @author yangqidu
 */
@Entity
@Table(name = "ge_system_template")
public class GeTemplate implements java.io.Serializable {
	
	private static final long serialVersionUID = -2658755616433062421L;
	
	private String getempid;
	private String tempname;
	private String tempcontent;
	private String functioncode;    //功能code
	private String typecode;        //类型code
	private Date createTime;
	private String operatopname;
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "GETEMPID", unique = true, nullable = false)
	public String getGetempid() {
		return getempid;
	}
	public void setGetempid(String getempid) {
		this.getempid = getempid;
	}
	@Column(name = "TEMPNAME", nullable = false)
	public String getTempname() {
		return tempname;
	}
	public void setTempname(String tempname) {
		this.tempname = tempname;
	}
	@Column(name = "TEMPCONTENT", nullable = false)
	public String getTempcontent() {
		return tempcontent;
	}
	public void setTempcontent(String tempcontent) {
		this.tempcontent = tempcontent;
	}
	@Column(name = "OPERATORNAME", nullable = false)
	public String getOperatopname() {
		return operatopname;
	}
	public void setOperatopname(String operatopname) {
		this.operatopname = operatopname;
	}
	@Column(name = "FUNCTIONCODE", nullable = false)
	public String getFunctioncode() {
		return functioncode;
	}
	public void setFunctioncode(String functioncode) {
		this.functioncode = functioncode;
	}
	@Column(name = "TEMPTYPECODE", nullable = false)
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	@Column(name = "CREATETIME", nullable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}

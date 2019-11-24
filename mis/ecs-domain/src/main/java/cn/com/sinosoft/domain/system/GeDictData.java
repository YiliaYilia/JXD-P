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
 * 描述：ge_dict_data实体类<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-19上午11:08:54 <br>
 * E-mail:  <br>
 */
@Entity
@Table(name = "ge_dict_data")
public class GeDictData implements java.io.Serializable {

	private String dictdataid;
	private GeDictType geDictType;
	private String dictdatacode;
	private String dictdatadesc;
	private String dictdataname;
	private Date createtime;
	private String operatorname;
	
	
	@Column(name = "CREATETIME", nullable = false)	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Column(name = "OPERATORNAME", nullable = false)	
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "DICTDATAID", unique = true, nullable = false)
	public String getDictdataid() {
		return dictdataid;
	}
	public void setDictdataid(String dictdataid) {
		this.dictdataid = dictdataid;
	}
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="DICTTYPEID")
	public GeDictType getGeDictType() {
		return geDictType;
	}
	public void setGeDictType(GeDictType geDictType) {
		this.geDictType = geDictType;
	}
	@Column(name = "DICTDATACODE", nullable = false)
	public String getDictdatacode() {
		return dictdatacode;
	}
	public void setDictdatacode(String dictdatacode) {
		this.dictdatacode = dictdatacode;
	}
	@Column(name = "DICTDATADESC", nullable = true)
	public String getDictdatadesc() {
		return dictdatadesc;
	}
	public void setDictdatadesc(String dictdatadesc) {
		this.dictdatadesc = dictdatadesc;
	}
	@Column(name = "DICTDATANAME", nullable = false)
	public String getDictdataname() {
		return dictdataname;
	}
	public void setDictdataname(String dictdataname) {
		this.dictdataname = dictdataname;
	}
	
	
}

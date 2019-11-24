package cn.com.sinosoft.domain.system;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 描述：ge_dict_type实体类<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-19上午11:09:15 <br>
 * E-mail:  <br>
 */
@Entity
@Table(name = "ge_dict_type")
public class GeDictType implements java.io.Serializable {


	private String dicttypeid;
	private String dicttypecode;
	private String dicttypename;
	private Date createtime;
	private String operatorname;
	private Set<GeDictData> geDictDatas = new HashSet<GeDictData>(0);
	
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
	@Column(name = "DICTTYPEID", unique = true, nullable = false)
	public String getDicttypeid() {
		return dicttypeid;
	}
	public void setDicttypeid(String dicttypeid) {
		this.dicttypeid = dicttypeid;
	}
	@Column(name = "DICTTYPECODE", nullable = false)
	public String getDicttypecode() {
		return dicttypecode;
	}
	public void setDicttypecode(String dicttypecode) {
		this.dicttypecode = dicttypecode;
	}
	@Column(name = "DICTTYPENAME", nullable = false)
	public String getDicttypename() {
		return dicttypename;
	}
	public void setDicttypename(String dicttypename) {
		this.dicttypename = dicttypename;
	}
	/**
	 * 方法名称: getGeDictDatas<br>
	 * 描述：删除类型级联删除字典数据
	 * 作者: liyang
	 * 修改日期：2013-12-26上午11:00:36
	 * @return
	 */
	@OneToMany(cascade={CascadeType.MERGE,CascadeType.REMOVE},fetch=FetchType.LAZY,mappedBy="geDictType")
	@OrderBy("dictdatacode ASC")
	public Set<GeDictData> getGeDictDatas() {
		return geDictDatas;
	}
	public void setGeDictDatas(Set<GeDictData> geDictDatas) {
		this.geDictDatas = geDictDatas;
	}
	
	
}


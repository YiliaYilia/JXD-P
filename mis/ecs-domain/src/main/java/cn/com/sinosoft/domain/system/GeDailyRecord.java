package cn.com.sinosoft.domain.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 描述：系统日志实体类<br>
 * 作者：yelinfang <br>
 * 修改日期：2013-12-24上午11:21:51 <br>
 * E-mail: <br>
 */
@Entity
@Table(name = "ge_daily_record")
public class GeDailyRecord implements Serializable {
	private String recordId;
	private String operatorName;
	private String recordType;
	private String description;
	private Date   createTime;
	private String expendTime;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "RECORDID", unique = true, nullable = false)
	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	@Column(name = "OPERATORNAME", nullable = false)
	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	@Column(name = "CREATETIME", nullable = false)
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "EXPENGTIME", nullable = false)
	public String getExpendTime() {
		return expendTime;
	}
	public void setExpendTime(String expendTime) {
		this.expendTime = expendTime;
	}

	@Column(name = "RECORDTYPE", nullable = false)
	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package cn.com.sinosoft.domain.consult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * DictionaryData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DICTIONARY_DATA", schema = "MIS")
public class DictionaryData implements java.io.Serializable {

	// Fields

	private String dictionaryDataId;
	private String dictionaryDataType;
	private String dictionaryDataName;
	private String dictionaryDataDesc;

	// Constructors

	/** default constructor */
	public DictionaryData() {
	}

	/** full constructor */
	public DictionaryData(String dictionaryDataType, String dictionaryDataName, String dictionaryDataDesc) {
		this.dictionaryDataType = dictionaryDataType;
		this.dictionaryDataName = dictionaryDataName;
		this.dictionaryDataDesc = dictionaryDataDesc;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DICTIONARY_DATA_ID", unique = true, nullable = false, length = 32)
	public String getDictionaryDataId() {
		return this.dictionaryDataId;
	}

	public void setDictionaryDataId(String dictionaryDataId) {
		this.dictionaryDataId = dictionaryDataId;
	}

	@Column(name = "DICTIONARY_DATA_TYPE", length = 20)
	public String getDictionaryDataType() {
		return this.dictionaryDataType;
	}

	public void setDictionaryDataType(String dictionaryDataType) {
		this.dictionaryDataType = dictionaryDataType;
	}

	@Column(name = "DICTIONARY_DATA_NAME", length = 50)
	public String getDictionaryDataName() {
		return this.dictionaryDataName;
	}

	public void setDictionaryDataName(String dictionaryDataName) {
		this.dictionaryDataName = dictionaryDataName;
	}

	@Column(name = "DICTIONARY_DATA__DESC")
	public String getDictionaryDataDesc() {
		return this.dictionaryDataDesc;
	}

	public void setDictionaryDataDesc(String dictionaryDataDesc) {
		this.dictionaryDataDesc = dictionaryDataDesc;
	}

}
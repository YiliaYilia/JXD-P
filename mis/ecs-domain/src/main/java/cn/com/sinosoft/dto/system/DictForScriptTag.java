package cn.com.sinosoft.dto.system;

/**
 * 描述：给script标签用的DTO<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-26上午10:11:29 <br>
 * E-mail:  <br>
 */
public class DictForScriptTag {

	private String dictdatacode;
	private String dictdataname;
	private String dicttypecode;
	
	public String getDicttypecode() {
		return dicttypecode;
	}
	public void setDicttypecode(String dicttypecode) {
		this.dicttypecode = dicttypecode;
	}
	public String getDictdataname() {
		return dictdataname;
	}
	public void setDictdataname(String dictdataname) {
		this.dictdataname = dictdataname;
	}
	public String getDictdatacode() {
		return dictdatacode;
	}
	public void setDictdatacode(String dictdatacode) {
		this.dictdatacode = dictdatacode;
	}
	
}

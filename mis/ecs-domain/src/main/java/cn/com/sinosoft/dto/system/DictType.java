package cn.com.sinosoft.dto.system;

/**
 * 描述：新建字典自动完成下拉框DTO<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-19下午06:49:22 <br>
 * E-mail: liyang12087@sinosoft.com.cn <br>
 */
public class DictType {

	private String id;
	private String text;
	private String desc;
	private String createdatestr;
	private String operatorname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCreatedatestr() {
		return createdatestr;
	}
	public void setCreatedatestr(String createdatestr) {
		this.createdatestr = createdatestr;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	
	
	
}

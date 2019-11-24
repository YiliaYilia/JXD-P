package cn.com.sinosoft.dto.system;

/**
 * 描述：机构类型<br>
 * 作者：zhongyong <br>
 * 修改日期：2013-12-24下午04:58:35 <br>
 * E-mail:zhongysz0442@sinosoft.com.cn <br>
 */
public class DepartmentType {
	private String id;
	private String text;
	private String organtypename;
	private String organtypedesc;

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

	public String getOrgantypename() {
		return organtypename;
	}

	public void setOrgantypename(String organtypename) {
		this.organtypename = organtypename;
	}

	public String getOrgantypedesc() {
		return organtypedesc;
	}

	public void setOrgantypedesc(String organtypedesc) {
		this.organtypedesc = organtypedesc;
	}

}

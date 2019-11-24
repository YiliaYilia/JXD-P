package cn.com.sinosoft.dto.system;

/**
 * 描述：权限树<br>
 * 作者：honghui <br>
 * 修改日期：2013年9月23日下午11:28:16 <br>
 * E-mail:wanhonghui@sinosoft.com.cn  <br>
 */
public class ResourcesTree {
	private String id;
	private String text;
	private String state;
	/**是否是叶子结点*/
	private String isLeaf; 
	/**图标*/
	private String iconCls;
	
	private boolean checked = false;
	
	private String parentId;
	
	private String resourcesid;
	private String resourcesname;
	private String resourcestype;
	private String resourceslinktype;
	private String resourcesparent;
	private String resourcescontent;
	private String resourcesdesc;
	private String resourcesstyle;
	private String resourcescode;
	private String resourcesiconpath;
	private String resourcesiconid;
	
	
	private Object attributes;
	public static class Attribute{
		private String url;
		private String level;
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}
		
		
	}
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public Object getAttributes() {
		return attributes;
	}
	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getResourcesid() {
		return resourcesid;
	}
	public void setResourcesid(String resourcesid) {
		this.resourcesid = resourcesid;
	}
	public String getResourcesname() {
		return resourcesname;
	}
	public void setResourcesname(String resourcesname) {
		this.resourcesname = resourcesname;
	}
	public String getResourcestype() {
		return resourcestype;
	}
	public void setResourcestype(String resourcestype) {
		this.resourcestype = resourcestype;
	}
	public String getResourceslinktype() {
		return resourceslinktype;
	}
	public void setResourceslinktype(String resourceslinktype) {
		this.resourceslinktype = resourceslinktype;
	}
	public String getResourcesparent() {
		return resourcesparent;
	}
	public void setResourcesparent(String resourcesparent) {
		this.resourcesparent = resourcesparent;
	}
	public String getResourcescontent() {
		return resourcescontent;
	}
	public void setResourcescontent(String resourcescontent) {
		this.resourcescontent = resourcescontent;
	}
	public String getResourcesdesc() {
		return resourcesdesc;
	}
	public void setResourcesdesc(String resourcesdesc) {
		this.resourcesdesc = resourcesdesc;
	}
	public String getResourcesstyle() {
		return resourcesstyle;
	}
	public void setResourcesstyle(String resourcesstyle) {
		this.resourcesstyle = resourcesstyle;
	}
	public String getResourcescode() {
		return resourcescode;
	}
	public void setResourcescode(String resourcescode) {
		this.resourcescode = resourcescode;
	}
	public String getResourcesiconpath() {
		return resourcesiconpath;
	}
	public void setResourcesiconpath(String resourcesiconpath) {
		this.resourcesiconpath = resourcesiconpath;
	}
	public String getResourcesiconid() {
		return resourcesiconid;
	}
	public void setResourcesiconid(String resourcesiconid) {
		this.resourcesiconid = resourcesiconid;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	 
	
	
	
}

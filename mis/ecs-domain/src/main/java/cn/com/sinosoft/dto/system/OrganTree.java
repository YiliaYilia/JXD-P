package cn.com.sinosoft.dto.system;

public class OrganTree {
	private String id;
	private String text;
	private String state;
	/** 是否是叶子结点 */
	private String isLeaf;
	
	/** 标记是否选中 */
	private boolean checked = false;

	/** 机构或部门编号 */
	private String deptid;
	/** 父权限编号 */
	private String parentId;
	/** 名称 */
	private String deptname;
	/** 机构编码 */
	private String deptCode;
	/** 关联属性类型 */
	private String organType;
	/** 地址 */
	private String contactAddress;
	/** 办公电话 */
	private String officePhone;
	/** 邮政编号 */
	private String zipCode;
	/** 根属性 */
	private String root;
	
	private Object attributes;
	
	public static class Attribute{
		private String gid;
		private String pgid;
		private String gname;
		private String note;
		
		public String getGid() {
			return gid;
		}
		public void setGid(String gid) {
			this.gid = gid;
		}
		public String getPgid() {
			return pgid;
		}
		public void setPgid(String pgid) {
			this.pgid = pgid;
		}
		public String getGname() {
			return gname;
		}
		public void setGname(String gname) {
			this.gname = gname;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
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

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}
}

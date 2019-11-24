package cn.com.sinosoft.dto.system;

/**
 * 描述：权限树<br>
 * 作者：honghui <br>
 * 修改日期：2013年9月23日下午11:28:16 <br>
 * E-mail:wanhonghui@sinosoft.com.cn  <br>
 */
public class UserAllTree {
	private String id;
	private String text;
	private String parentId;
	/**是否是叶子结点*/
	private String isLeaf;
	private String userType;
	private String userdesc;
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserdesc() {
		return userdesc;
	}
	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}
}

package cn.com.sinosoft.dto.product;

/**
 * 描述：产品属性树<br>
 * 作者：liaojiping <br>
 * 修改日期：2014-1-2上午09:18:20 <br>
 * E-mail: <br>
 */
public class ProductAttrTree {
	private String id;
	private String text;
	private String state;
	/**是否是叶子节点*/
	private String isLeaf;
	private String parentId;
	
	private String productattrid;
	private String productattrname;
    private Long seqindex;
    private String attrdesc;
    private String attrnoteinfo;
    private String attrparent;

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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getProductattrid() {
		return productattrid;
	}
	public void setProductattrid(String productattrid) {
		this.productattrid = productattrid;
	}
	public String getProductattrname() {
		return productattrname;
	}
	public void setProductattrname(String productattrname) {
		this.productattrname = productattrname;
	}
	public Long getSeqindex() {
		return seqindex;
	}
	public void setSeqindex(Long seqindex) {
		this.seqindex = seqindex;
	}
	public String getAttrdesc() {
		return attrdesc;
	}
	public void setAttrdesc(String attrdesc) {
		this.attrdesc = attrdesc;
	}
	public String getAttrnoteinfo() {
		return attrnoteinfo;
	}
	public void setAttrnoteinfo(String attrnoteinfo) {
		this.attrnoteinfo = attrnoteinfo;
	}
	public String getAttrparent() {
		return attrparent;
	}
	public void setAttrparent(String attrparent) {
		this.attrparent = attrparent;
	}
	
}

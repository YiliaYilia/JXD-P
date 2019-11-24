package cn.com.sinosoft.web.weixin;
/**保单列表请求参数封装类
 * */
public class Contracts {
	/*
	投保人证件类型
	A	身份证
	B	护照
	C	军官证
	D	驾照
	H	出生证明
	I	其他
	K	台胞证
	*/
	private String idType;
	private String idNo;//投保人证件号
	private String name;//投保人姓名
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

package cn.com.sinosoft.ess.protal.model;


/**
 * 描述：银保通承保交易数据<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月15日下午1:35:44 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public class TranDataEntity {
	
	/**基本头信息*/
	private BaseInfo baseInfo;
	/**保单信息*/
	private LCCont lCCont;
	
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	
	public LCCont getlCCont() {
		return lCCont;
	}
	
	public void setlCCont(LCCont lCCont) {
		this.lCCont = lCCont;
	}
	
	
}

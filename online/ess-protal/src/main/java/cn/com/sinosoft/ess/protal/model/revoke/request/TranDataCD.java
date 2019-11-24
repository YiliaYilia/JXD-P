package cn.com.sinosoft.ess.protal.model.revoke.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="TranData")
public class TranDataCD {
	/**
	 * 描述：当日撤单请求<br>
	 * 作者：lishixiu <br>
	 * 修改日期：2014年3月11日下午16:03:44 <br>
	 * E-mail: lishixiu14015@sinosoft.com.cn <br>
	 */
	
	// 基本头信息
	private BaseInfoCD baseInfo;
	
	// 撤单信息
	private GuaranteeSlip guaranteeSlip;
	
	@XmlElement(name="Head")
	public BaseInfoCD getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfoCD baseInfo) {
		this.baseInfo = baseInfo;
	}

	@XmlElement(name="Body")
	public GuaranteeSlip getGuaranteeSlip() {
		return guaranteeSlip;
	}

	public void setGuaranteeSlip(GuaranteeSlip guaranteeSlip) {
		this.guaranteeSlip = guaranteeSlip;
	}
	
	
}

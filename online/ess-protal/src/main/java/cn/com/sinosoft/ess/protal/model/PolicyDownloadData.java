package cn.com.sinosoft.ess.protal.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 描述：电子保单下载<br>
 * 作者：wufuxing <br>
 * 修改日期：2014年4月9日下午18:00:00 <br>
 * E-mail: wufuxing@sinosoft.com.cn <br>
 */
@XmlRootElement(name="Data")
public class PolicyDownloadData {
	private String policyno ;

	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
}

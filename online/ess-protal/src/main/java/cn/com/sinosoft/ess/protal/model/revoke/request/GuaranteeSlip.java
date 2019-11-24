/**
 * File Name:GuaranteeSlip.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:shixiu
 * @version:v1.0
 * Createdate:2014-3-11下午04:34:37
 */
package cn.com.sinosoft.ess.protal.model.revoke.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**描述：测单保单号<br>
 * 作者：shixiu <br>
 * 修改日期：2014-3-11下午04:34:37 <br>
 * E-mail: lishixiu14015@sinosoft.com.cn <br> 
 */

@XmlType(name="Body")
public class GuaranteeSlip {
	// 保单号
	private String contNo;
	@XmlElement(name="ContNo")
	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

}

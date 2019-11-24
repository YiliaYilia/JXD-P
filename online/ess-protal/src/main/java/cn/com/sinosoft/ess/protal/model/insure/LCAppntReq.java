package cn.com.sinosoft.ess.protal.model.insure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cn.com.sinosoft.ess.protal.model.insure.base.LCAppntInsuredTbl;

/**
 * 描述：请求投保人信息<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-11下午04:36:22 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
@XmlType(name="Appnt")
public class LCAppntReq extends LCAppntInsuredTbl{
	
	private String yIncome ;				//年收入 默认为空
	
	@XmlElement(name="EstSalary")					
	public String getyIncome() {
		return yIncome;
	}
	public void setyIncome(String yIncome) {
		this.yIncome = yIncome;
	}			
	
	public LCAppntReq() {
		// TODO Auto-generated constructor stub
	}
}

package cn.com.sinosoft.ess.protal.model.insure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cn.com.sinosoft.ess.protal.model.insure.base.LCAppntInsuredTbl;

/**
 * 描述：被保人<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-12上午10:13:14 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
@XmlType(name="Insured")
public class LCInsuredReq extends LCAppntInsuredTbl{
	
	
	private String yIncome ;				//年收入 默认为空
	
	@XmlElement(name="EstSalary")					
	public String getyIncome() {
		return yIncome;
	}
	public void setyIncome(String yIncome) {
		this.yIncome = yIncome;
	}			
	
	public LCInsuredReq() {
		// TODO Auto-generated constructor stub
	}
	
}

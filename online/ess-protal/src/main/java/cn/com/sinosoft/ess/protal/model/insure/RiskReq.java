package cn.com.sinosoft.ess.protal.model.insure;

import javax.xml.bind.annotation.XmlElement;

import cn.com.sinosoft.ess.protal.model.insure.base.RiskTbl;



/**
 * 描述：请求险种信息<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-12下午02:37:09 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
//@XmlType(name="Risk")
public class RiskReq extends RiskTbl{
	
	private String getIntv;			//生存金处理方式
	private String bonusGetMode;	//红利处理方式
	
	public RiskReq() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name="GetIntv")
	public String getGetIntv() {
		return getIntv;
	}
	
	public void setGetIntv(String getIntv) {
		this.getIntv = getIntv;
	}

	
	@XmlElement(name="BonusGetMode")
	public String getBonusGetMode() {
		return bonusGetMode;
	}

	public void setBonusGetMode(String bonusGetMode) {
		this.bonusGetMode = bonusGetMode;
	}
	
	
	
}

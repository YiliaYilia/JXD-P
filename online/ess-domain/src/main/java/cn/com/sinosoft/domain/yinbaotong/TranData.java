package cn.com.sinosoft.domain.yinbaotong;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"tranRequest","chkDetails","baseInfo","dailyBalance"})  
public class TranData {
	private TranRequest tranRequest;
	private ChkDetails chkDetails;
	private BaseInfo baseInfo;//基本信息
	private DailyBalance dailyBalance;
	
	@XmlElement(name="tranRequest")
	public TranRequest gettranRequest() {
		return tranRequest;
	}

	public void settranRequest(TranRequest tranRequest) {
		this.tranRequest = tranRequest;
	}

	@XmlElement(name="chkDetails")
	public ChkDetails getchkDetails() {
		return chkDetails;
	}

	public void setchkDetails(ChkDetails chkDetails) {
		this.chkDetails = chkDetails;
	}
	
	public TranData() {
		super();
	}

	public TranData(TranRequest tranRequest, ChkDetails chkDetails) {
		super();
		this.tranRequest = tranRequest;
		this.chkDetails = chkDetails;
	}
	
	@XmlElement(name="baseInfo")
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	@XmlElement(name="dailyBalance")
	public DailyBalance getDailyBalance() {
		return dailyBalance;
	}

	public void setDailyBalance(DailyBalance dailyBalance) {
		this.dailyBalance = dailyBalance;
	}
	
	
}

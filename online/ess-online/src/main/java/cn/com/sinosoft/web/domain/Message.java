package cn.com.sinosoft.web.domain;


public class Message{
	private String messageId;
	private MobileNums mobileNums;
	private String messTopic;
	private String sendData;
	private String dataType;
	private String sendWay;
	private String unitCode;
	private String dealOrder;
	
	public Message() {
		super();
	}
	public Message(String messageId, MobileNums mobileNums,
			String messTopic, String sendData, String dataType,
			String sendWay, String unitCode, String dealOrder) {
		super();
		this.messageId = messageId;
		this.mobileNums = mobileNums;
		this.messTopic = messTopic;
		this.sendData = sendData;
		this.dataType = dataType;
		this.sendWay = sendWay;
		this.unitCode = unitCode;
		this.dealOrder = dealOrder;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public MobileNums getMobileNums() {
		return mobileNums;
	}
	public void setMobileNums(MobileNums mobileNums) {
		this.mobileNums = mobileNums;
	}
	public String getMessTopic() {
		return messTopic;
	}
	public void setMessTopic(String messTopic) {
		this.messTopic = messTopic;
	}
	public String getSendData() {
		return sendData;
	}
	public void setSendData(String sendData) {
		this.sendData = sendData;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getSendWay() {
		return sendWay;
	}
	public void setSendWay(String sendWay) {
		this.sendWay = sendWay;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getDealOrder() {
		return dealOrder;
	}
	public void setDealOrder(String dealOrder) {
		this.dealOrder = dealOrder;
	}
	
}

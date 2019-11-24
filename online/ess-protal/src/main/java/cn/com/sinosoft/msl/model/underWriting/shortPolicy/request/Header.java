package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;

import java.util.Date;
/**
 * 发送、返回报文header节点
 * @author guilong
 *
 */
public class Header {
	private String channelId;
    private String chnlTransNo;
    private Date transDate;
    private String transNo;
    private String userId;
  
    public Header(String channelId, Date transDate, String transNo) {  
        super();  
        this.channelId = channelId;  
        this.transDate = transDate;
        this.transNo = transNo;  
    }   
  
    public Header() {  
        super();  
    }

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChnlTransNo() {
		return chnlTransNo;
	}

	public void setChnlTransNo(String chnlTransNo) {
		this.chnlTransNo = chnlTransNo;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	} 
}

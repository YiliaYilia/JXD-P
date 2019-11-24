package cn.com.sinosoft.msl.model.underWriting.shortPolicy.response;

import java.util.Date;
/**
 * 返回报文contract节点
 * @author guilong
 *
 */
public class Contract {
	private String contNo;  
	private String contUrl;  
    private Date effDate;
    private String orderNo; 
  
	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	public String getContUrl() {
		return contUrl;
	}

	public void setContUrl(String contUrl) {
		this.contUrl = contUrl;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}  
	
	public Contract(String contNo, String contUrl, Date effDate,
			String orderNo) {
		super();
		this.contNo = contNo;
		this.contUrl = contUrl;
		this.effDate = effDate;
		this.orderNo = orderNo;
	}
    
    public Contract() {  
        super();  
    }
}

package cn.com.sinosoft.msl.model.soap;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.response.Contract;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Header;
@XmlRootElement(name="response")
@XmlType(propOrder = { "contract", "header", "holderIdNo", "holderIdType", "holderName","returnCode"})
public class SoapCenterResponse {
	
		private Contract contract;  
		@XmlElement(name="contract")
	    public Contract getContract() {  
	        return contract;  
	    }  
	  
	    public void setContract(Contract contract) {  
	        this.contract = contract;  
	    } 
		
	    private Header header;  
		@XmlElement(name="header")
	    public Header getHeader() {  
	        return header;  
	    }  
	  
	    public void setHeader(Header header) {  
	        this.header = header;  
	    }
	    
		private String holderIdNo;
	    @XmlElement(name="holderIdNo")  
	    public String getHolderIdNo() {  
	        return holderIdNo;  
	    }  
	  
	    public void setHolderIdNo(String holderIdNo) {  
	        this.holderIdNo = holderIdNo;  
	    } 
	    
	    private String holderIdType;
	    @XmlElement(name="holderIdType")
	    public String getHolderIdType() {
			return holderIdType;
		}

		public void setHolderIdType(String holderIdType) {
			this.holderIdType = holderIdType;
		}

		private String holderName;
		@XmlElement(name="holderName")
		public String getHolderName() {
			return holderName;
		}

		public void setHolderName(String holderName) {
			this.holderName = holderName;
		}

		private String returnCode;
		@XmlElement(name="returnCode")
		public String getReturnCode() {
			return returnCode;
		}

		public void setReturnCode(String returnCode) {
			this.returnCode = returnCode;
		}  
	  
		public SoapCenterResponse(Contract contract, String holderIdNo,
				String holderIdType, String holderName, String returnCode) {
			super();
			this.contract = contract;
			this.holderIdNo = holderIdNo;
			this.holderIdType = holderIdType;
			this.holderName = holderName;
			this.returnCode = returnCode;
		}
	  
	    //无参够着函数一定需要，否则JXBContext无法正常解析。  
	    public SoapCenterResponse() {  
	        super();  
	    }

    public static void XMLStringToBean(){  
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><response>" +
        		"<contract><contNo>TG00003239</contNo><contUrl>https://elife.oldmutual-guodian.com/contracts/accdtinquire</contUrl>" +
        		"<effDate>2015-06-25T00:00:00+08:00</effDate><orderNo>A00011840721</orderNo></contract>" +
        		"<header><channelId>SHCCB1</channelId><transNo>2015062493424</transNo></header>" +
        		"<holderIdNo>310104195612202823</holderIdNo><holderIdType>A</holderIdType><holderName>顾****</holderName>" +
        		"<returnCode>0</returnCode>" +
        		"</response>";  
        try {  
            JAXBContext context = JAXBContext.newInstance(SoapCenterResponse.class);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            SoapCenterResponse response = (SoapCenterResponse)unmarshaller.unmarshal(new StringReader(xmlStr));  
            System.out.println(response.getHolderName());  
            System.out.println(response.getContract().getContUrl());
            System.out.println(DateAndTime.convertDateToString(response.getContract().getEffDate(),"yyyy-MM-dd HH:mm:ss"));
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
    } 
    public static void main(String[] args) {
    	XMLStringToBean();
	}
}
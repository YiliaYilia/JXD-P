package cn.com.sinosoft.common.service.axis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "soapenv:Envelope")
public class RequestEntity {
	@XmlAttribute(name="xmlns:soapenv")
    protected String soapenv="http://schemas.xmlsoap.org/soap/envelope/";
    @XmlAttribute(name="xmlns:xsi")
    protected String xsi="http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name="xmlns:xsd")
    protected String xsd="http://www.w3.org/2001/XMLSchema";
    @XmlElement(required = true,name="soapenv:Body")
    private RequestBody body;

    
	public RequestEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public RequestEntity(RequestBody body) {
		super();
		this.body = body;
	}


	public String getSoapenv() {
		return soapenv;
	}

	public void setSoapenv(String soapenv) {
		this.soapenv = soapenv;
	}

	public String getXsi() {
		return xsi;
	}

	public void setXsi(String xsi) {
		this.xsi = xsi;
	}

	public String getXsd() {
		return xsd;
	}

	public void setXsd(String xsd) {
		this.xsd = xsd;
	}

	public RequestBody getBody() {
		return body;
	}

	public void setBody(RequestBody body) {
		this.body = body;
	}
	

}

package cn.com.sinosoft.common.service.axis;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;

public class JsonDataModel {
	private String country;
	private String nation;
	private String idType;
	
	private static TypeDesc typeDesc =
	        new TypeDesc(JsonDataModel.class, true);

	static {
	    typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "JsonDataModel"));
	    ElementDesc elemField = new ElementDesc();
	    elemField.setFieldName("country");
	    elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "country"));
	    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	    elemField.setMinOccurs(0);
	    elemField.setNillable(true);
	    typeDesc.addFieldDesc(elemField);
	    elemField = new org.apache.axis.description.ElementDesc();
	    elemField.setFieldName("nation");
	    elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "nation"));
	    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	    elemField.setMinOccurs(0);
	    elemField.setNillable(true);
	    typeDesc.addFieldDesc(elemField);
	    elemField = new org.apache.axis.description.ElementDesc();
	    elemField.setFieldName("idType");
	    elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "IDType"));
	    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	    elemField.setMinOccurs(0);
	    elemField.setNillable(true);
	    typeDesc.addFieldDesc(elemField);
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	public static TypeDesc getTypeDesc() {
		return typeDesc;
	}

	
	/**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }
	
}

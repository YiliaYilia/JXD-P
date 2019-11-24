/**
 * PersonalInfoMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PersonalInfoMsg  implements java.io.Serializable {
    private cn.com.sinosoft.common.service.axis.Xmlheader header;

    private cn.com.sinosoft.common.service.axis.PersonalInfoVO body;

    public PersonalInfoMsg() {
    }

    public PersonalInfoMsg(
           cn.com.sinosoft.common.service.axis.Xmlheader header,
           cn.com.sinosoft.common.service.axis.PersonalInfoVO body) {
           this.header = header;
           this.body = body;
    }


    /**
     * Gets the header value for this PersonalInfoMsg.
     * 
     * @return header
     */
    public cn.com.sinosoft.common.service.axis.Xmlheader getHeader() {
        return header;
    }


    /**
     * Sets the header value for this PersonalInfoMsg.
     * 
     * @param header
     */
    public void setHeader(cn.com.sinosoft.common.service.axis.Xmlheader header) {
        this.header = header;
    }


    /**
     * Gets the body value for this PersonalInfoMsg.
     * 
     * @return body
     */
    public cn.com.sinosoft.common.service.axis.PersonalInfoVO getBody() {
        return body;
    }


    /**
     * Sets the body value for this PersonalInfoMsg.
     * 
     * @param body
     */
    public void setBody(cn.com.sinosoft.common.service.axis.PersonalInfoVO body) {
        this.body = body;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PersonalInfoMsg)) return false;
        PersonalInfoMsg other = (PersonalInfoMsg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              this.header.equals(other.getHeader()))) &&
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getHeader() != null) {
            _hashCode += getHeader().hashCode();
        }
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PersonalInfoMsg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PersonalInfoMsg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("header");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "Header"));
        elemField.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "xmlheader"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "Body"));
        elemField.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PersonalInfoVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
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

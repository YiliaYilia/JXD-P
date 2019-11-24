/**
 * PSAccountVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PSAccountVO  implements java.io.Serializable {
    private java.lang.String ivmtAcctID;

    private java.lang.String surrenderValue;

    public PSAccountVO() {
    }

    public PSAccountVO(
           java.lang.String ivmtAcctID,
           java.lang.String surrenderValue) {
           this.ivmtAcctID = ivmtAcctID;
           this.surrenderValue = surrenderValue;
    }


    /**
     * Gets the ivmtAcctID value for this PSAccountVO.
     * 
     * @return ivmtAcctID
     */
    public java.lang.String getIvmtAcctID() {
        return ivmtAcctID;
    }


    /**
     * Sets the ivmtAcctID value for this PSAccountVO.
     * 
     * @param ivmtAcctID
     */
    public void setIvmtAcctID(java.lang.String ivmtAcctID) {
        this.ivmtAcctID = ivmtAcctID;
    }


    /**
     * Gets the surrenderValue value for this PSAccountVO.
     * 
     * @return surrenderValue
     */
    public java.lang.String getSurrenderValue() {
        return surrenderValue;
    }


    /**
     * Sets the surrenderValue value for this PSAccountVO.
     * 
     * @param surrenderValue
     */
    public void setSurrenderValue(java.lang.String surrenderValue) {
        this.surrenderValue = surrenderValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PSAccountVO)) return false;
        PSAccountVO other = (PSAccountVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ivmtAcctID==null && other.getIvmtAcctID()==null) || 
             (this.ivmtAcctID!=null &&
              this.ivmtAcctID.equals(other.getIvmtAcctID()))) &&
            ((this.surrenderValue==null && other.getSurrenderValue()==null) || 
             (this.surrenderValue!=null &&
              this.surrenderValue.equals(other.getSurrenderValue())));
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
        if (getIvmtAcctID() != null) {
            _hashCode += getIvmtAcctID().hashCode();
        }
        if (getSurrenderValue() != null) {
            _hashCode += getSurrenderValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PSAccountVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PSAccountVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("surrenderValue");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SurrenderValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

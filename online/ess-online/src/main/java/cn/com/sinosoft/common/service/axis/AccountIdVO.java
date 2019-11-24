/**
 * AccountIdVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class AccountIdVO  implements java.io.Serializable {
    private java.lang.String ivmtAcctName;

    private java.lang.String ivmtAcctCode;

    public AccountIdVO() {
    }

    public AccountIdVO(
           java.lang.String ivmtAcctName,
           java.lang.String ivmtAcctCode) {
           this.ivmtAcctName = ivmtAcctName;
           this.ivmtAcctCode = ivmtAcctCode;
    }


    /**
     * Gets the ivmtAcctName value for this AccountIdVO.
     * 
     * @return ivmtAcctName
     */
    public java.lang.String getIvmtAcctName() {
        return ivmtAcctName;
    }


    /**
     * Sets the ivmtAcctName value for this AccountIdVO.
     * 
     * @param ivmtAcctName
     */
    public void setIvmtAcctName(java.lang.String ivmtAcctName) {
        this.ivmtAcctName = ivmtAcctName;
    }


    /**
     * Gets the ivmtAcctCode value for this AccountIdVO.
     * 
     * @return ivmtAcctCode
     */
    public java.lang.String getIvmtAcctCode() {
        return ivmtAcctCode;
    }


    /**
     * Sets the ivmtAcctCode value for this AccountIdVO.
     * 
     * @param ivmtAcctCode
     */
    public void setIvmtAcctCode(java.lang.String ivmtAcctCode) {
        this.ivmtAcctCode = ivmtAcctCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountIdVO)) return false;
        AccountIdVO other = (AccountIdVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ivmtAcctName==null && other.getIvmtAcctName()==null) || 
             (this.ivmtAcctName!=null &&
              this.ivmtAcctName.equals(other.getIvmtAcctName()))) &&
            ((this.ivmtAcctCode==null && other.getIvmtAcctCode()==null) || 
             (this.ivmtAcctCode!=null &&
              this.ivmtAcctCode.equals(other.getIvmtAcctCode())));
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
        if (getIvmtAcctName() != null) {
            _hashCode += getIvmtAcctName().hashCode();
        }
        if (getIvmtAcctCode() != null) {
            _hashCode += getIvmtAcctCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountIdVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountIdVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctCode");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctCode"));
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

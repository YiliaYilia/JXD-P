/**
 * AccountValueVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class AccountValueVO  implements java.io.Serializable {
    private java.lang.String insuredAcctID;

    private java.lang.String acctValue;

    public AccountValueVO() {
    }

    public AccountValueVO(
           java.lang.String insuredAcctID,
           java.lang.String acctValue) {
           this.insuredAcctID = insuredAcctID;
           this.acctValue = acctValue;
    }


    /**
     * Gets the insuredAcctID value for this AccountValueVO.
     * 
     * @return insuredAcctID
     */
    public java.lang.String getInsuredAcctID() {
        return insuredAcctID;
    }


    /**
     * Sets the insuredAcctID value for this AccountValueVO.
     * 
     * @param insuredAcctID
     */
    public void setInsuredAcctID(java.lang.String insuredAcctID) {
        this.insuredAcctID = insuredAcctID;
    }


    /**
     * Gets the acctValue value for this AccountValueVO.
     * 
     * @return acctValue
     */
    public java.lang.String getAcctValue() {
        return acctValue;
    }


    /**
     * Sets the acctValue value for this AccountValueVO.
     * 
     * @param acctValue
     */
    public void setAcctValue(java.lang.String acctValue) {
        this.acctValue = acctValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountValueVO)) return false;
        AccountValueVO other = (AccountValueVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.insuredAcctID==null && other.getInsuredAcctID()==null) || 
             (this.insuredAcctID!=null &&
              this.insuredAcctID.equals(other.getInsuredAcctID()))) &&
            ((this.acctValue==null && other.getAcctValue()==null) || 
             (this.acctValue!=null &&
              this.acctValue.equals(other.getAcctValue())));
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
        if (getInsuredAcctID() != null) {
            _hashCode += getInsuredAcctID().hashCode();
        }
        if (getAcctValue() != null) {
            _hashCode += getAcctValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountValueVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountValueVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredAcctID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "InsuredAcctID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acctValue");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AcctValue"));
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

/**
 * TopupAccountVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class TopupAccountVO  implements java.io.Serializable {
    private java.lang.String ivmtAcctID;

    private java.lang.String topUpAmt;

    public TopupAccountVO() {
    }

    public TopupAccountVO(
           java.lang.String ivmtAcctID,
           java.lang.String topUpAmt) {
           this.ivmtAcctID = ivmtAcctID;
           this.topUpAmt = topUpAmt;
    }


    /**
     * Gets the ivmtAcctID value for this TopupAccountVO.
     * 
     * @return ivmtAcctID
     */
    public java.lang.String getIvmtAcctID() {
        return ivmtAcctID;
    }


    /**
     * Sets the ivmtAcctID value for this TopupAccountVO.
     * 
     * @param ivmtAcctID
     */
    public void setIvmtAcctID(java.lang.String ivmtAcctID) {
        this.ivmtAcctID = ivmtAcctID;
    }


    /**
     * Gets the topUpAmt value for this TopupAccountVO.
     * 
     * @return topUpAmt
     */
    public java.lang.String getTopUpAmt() {
        return topUpAmt;
    }


    /**
     * Sets the topUpAmt value for this TopupAccountVO.
     * 
     * @param topUpAmt
     */
    public void setTopUpAmt(java.lang.String topUpAmt) {
        this.topUpAmt = topUpAmt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TopupAccountVO)) return false;
        TopupAccountVO other = (TopupAccountVO) obj;
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
            ((this.topUpAmt==null && other.getTopUpAmt()==null) || 
             (this.topUpAmt!=null &&
              this.topUpAmt.equals(other.getTopUpAmt())));
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
        if (getTopUpAmt() != null) {
            _hashCode += getTopUpAmt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TopupAccountVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "TopupAccountVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("topUpAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "TopUpAmt"));
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

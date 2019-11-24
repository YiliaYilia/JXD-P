/**
 * SwitchAccountVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class SwitchAccountVO  implements java.io.Serializable {
    private java.lang.String ivmtAcctID;

    private java.lang.String switchRatio;

    public SwitchAccountVO() {
    }

    public SwitchAccountVO(
           java.lang.String ivmtAcctID,
           java.lang.String switchRatio) {
           this.ivmtAcctID = ivmtAcctID;
           this.switchRatio = switchRatio;
    }


    /**
     * Gets the ivmtAcctID value for this SwitchAccountVO.
     * 
     * @return ivmtAcctID
     */
    public java.lang.String getIvmtAcctID() {
        return ivmtAcctID;
    }


    /**
     * Sets the ivmtAcctID value for this SwitchAccountVO.
     * 
     * @param ivmtAcctID
     */
    public void setIvmtAcctID(java.lang.String ivmtAcctID) {
        this.ivmtAcctID = ivmtAcctID;
    }


    /**
     * Gets the switchRatio value for this SwitchAccountVO.
     * 
     * @return switchRatio
     */
    public java.lang.String getSwitchRatio() {
        return switchRatio;
    }


    /**
     * Sets the switchRatio value for this SwitchAccountVO.
     * 
     * @param switchRatio
     */
    public void setSwitchRatio(java.lang.String switchRatio) {
        this.switchRatio = switchRatio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SwitchAccountVO)) return false;
        SwitchAccountVO other = (SwitchAccountVO) obj;
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
            ((this.switchRatio==null && other.getSwitchRatio()==null) || 
             (this.switchRatio!=null &&
              this.switchRatio.equals(other.getSwitchRatio())));
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
        if (getSwitchRatio() != null) {
            _hashCode += getSwitchRatio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SwitchAccountVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "SwitchAccountVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("switchRatio");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SwitchRatio"));
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

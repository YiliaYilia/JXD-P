/**
 * POSRider.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class POSRider  implements java.io.Serializable {
    private java.lang.String riderStatus;

    private java.lang.String riderDate;

    public POSRider() {
    }

    public POSRider(
           java.lang.String riderStatus,
           java.lang.String riderDate) {
           this.riderStatus = riderStatus;
           this.riderDate = riderDate;
    }


    /**
     * Gets the riderStatus value for this POSRider.
     * 
     * @return riderStatus
     */
    public java.lang.String getRiderStatus() {
        return riderStatus;
    }


    /**
     * Sets the riderStatus value for this POSRider.
     * 
     * @param riderStatus
     */
    public void setRiderStatus(java.lang.String riderStatus) {
        this.riderStatus = riderStatus;
    }


    /**
     * Gets the riderDate value for this POSRider.
     * 
     * @return riderDate
     */
    public java.lang.String getRiderDate() {
        return riderDate;
    }


    /**
     * Sets the riderDate value for this POSRider.
     * 
     * @param riderDate
     */
    public void setRiderDate(java.lang.String riderDate) {
        this.riderDate = riderDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POSRider)) return false;
        POSRider other = (POSRider) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.riderStatus==null && other.getRiderStatus()==null) || 
             (this.riderStatus!=null &&
              this.riderStatus.equals(other.getRiderStatus()))) &&
            ((this.riderDate==null && other.getRiderDate()==null) || 
             (this.riderDate!=null &&
              this.riderDate.equals(other.getRiderDate())));
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
        if (getRiderStatus() != null) {
            _hashCode += getRiderStatus().hashCode();
        }
        if (getRiderDate() != null) {
            _hashCode += getRiderDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POSRider.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "POSRider"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riderStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "RiderStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riderDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "RiderDate"));
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

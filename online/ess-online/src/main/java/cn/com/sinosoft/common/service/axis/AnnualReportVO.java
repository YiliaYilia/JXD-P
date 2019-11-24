/**
 * AnnualReportVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class AnnualReportVO  implements java.io.Serializable {
    private java.lang.String policyNbr;

    private java.lang.String annualRepName;

    private java.lang.String annualRepID;

    private java.lang.String annualRepPeriod;

    public AnnualReportVO() {
    }

    public AnnualReportVO(
           java.lang.String policyNbr,
           java.lang.String annualRepName,
           java.lang.String annualRepID,
           java.lang.String annualRepPeriod) {
           this.policyNbr = policyNbr;
           this.annualRepName = annualRepName;
           this.annualRepID = annualRepID;
           this.annualRepPeriod = annualRepPeriod;
    }


    /**
     * Gets the policyNbr value for this AnnualReportVO.
     * 
     * @return policyNbr
     */
    public java.lang.String getPolicyNbr() {
        return policyNbr;
    }


    /**
     * Sets the policyNbr value for this AnnualReportVO.
     * 
     * @param policyNbr
     */
    public void setPolicyNbr(java.lang.String policyNbr) {
        this.policyNbr = policyNbr;
    }


    /**
     * Gets the annualRepName value for this AnnualReportVO.
     * 
     * @return annualRepName
     */
    public java.lang.String getAnnualRepName() {
        return annualRepName;
    }


    /**
     * Sets the annualRepName value for this AnnualReportVO.
     * 
     * @param annualRepName
     */
    public void setAnnualRepName(java.lang.String annualRepName) {
        this.annualRepName = annualRepName;
    }


    /**
     * Gets the annualRepID value for this AnnualReportVO.
     * 
     * @return annualRepID
     */
    public java.lang.String getAnnualRepID() {
        return annualRepID;
    }


    /**
     * Sets the annualRepID value for this AnnualReportVO.
     * 
     * @param annualRepID
     */
    public void setAnnualRepID(java.lang.String annualRepID) {
        this.annualRepID = annualRepID;
    }


    /**
     * Gets the annualRepPeriod value for this AnnualReportVO.
     * 
     * @return annualRepPeriod
     */
    public java.lang.String getAnnualRepPeriod() {
        return annualRepPeriod;
    }


    /**
     * Sets the annualRepPeriod value for this AnnualReportVO.
     * 
     * @param annualRepPeriod
     */
    public void setAnnualRepPeriod(java.lang.String annualRepPeriod) {
        this.annualRepPeriod = annualRepPeriod;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnnualReportVO)) return false;
        AnnualReportVO other = (AnnualReportVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.policyNbr==null && other.getPolicyNbr()==null) || 
             (this.policyNbr!=null &&
              this.policyNbr.equals(other.getPolicyNbr()))) &&
            ((this.annualRepName==null && other.getAnnualRepName()==null) || 
             (this.annualRepName!=null &&
              this.annualRepName.equals(other.getAnnualRepName()))) &&
            ((this.annualRepID==null && other.getAnnualRepID()==null) || 
             (this.annualRepID!=null &&
              this.annualRepID.equals(other.getAnnualRepID()))) &&
            ((this.annualRepPeriod==null && other.getAnnualRepPeriod()==null) || 
             (this.annualRepPeriod!=null &&
              this.annualRepPeriod.equals(other.getAnnualRepPeriod())));
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
        if (getPolicyNbr() != null) {
            _hashCode += getPolicyNbr().hashCode();
        }
        if (getAnnualRepName() != null) {
            _hashCode += getAnnualRepName().hashCode();
        }
        if (getAnnualRepID() != null) {
            _hashCode += getAnnualRepID().hashCode();
        }
        if (getAnnualRepPeriod() != null) {
            _hashCode += getAnnualRepPeriod().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnnualReportVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualReportVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annualRepName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualRepName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annualRepID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualRepID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annualRepPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualRepPeriod"));
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

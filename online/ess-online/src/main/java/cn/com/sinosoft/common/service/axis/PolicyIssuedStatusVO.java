/**
 * PolicyIssuedStatusVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PolicyIssuedStatusVO  implements java.io.Serializable {
    private java.lang.String policyHolderName;

    private java.lang.String productName;

    private java.lang.String appPolicyStatus;

    private java.lang.String clientNbr;

    private java.lang.String productCode;

    public PolicyIssuedStatusVO() {
    }

    public PolicyIssuedStatusVO(
           java.lang.String policyHolderName,
           java.lang.String productName,
           java.lang.String appPolicyStatus,
           java.lang.String clientNbr,
           java.lang.String productCode) {
           this.policyHolderName = policyHolderName;
           this.productName = productName;
           this.appPolicyStatus = appPolicyStatus;
           this.clientNbr = clientNbr;
           this.productCode = productCode;
    }


    /**
     * Gets the policyHolderName value for this PolicyIssuedStatusVO.
     * 
     * @return policyHolderName
     */
    public java.lang.String getPolicyHolderName() {
        return policyHolderName;
    }


    /**
     * Sets the policyHolderName value for this PolicyIssuedStatusVO.
     * 
     * @param policyHolderName
     */
    public void setPolicyHolderName(java.lang.String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }


    /**
     * Gets the productName value for this PolicyIssuedStatusVO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this PolicyIssuedStatusVO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the appPolicyStatus value for this PolicyIssuedStatusVO.
     * 
     * @return appPolicyStatus
     */
    public java.lang.String getAppPolicyStatus() {
        return appPolicyStatus;
    }


    /**
     * Sets the appPolicyStatus value for this PolicyIssuedStatusVO.
     * 
     * @param appPolicyStatus
     */
    public void setAppPolicyStatus(java.lang.String appPolicyStatus) {
        this.appPolicyStatus = appPolicyStatus;
    }


    /**
     * Gets the clientNbr value for this PolicyIssuedStatusVO.
     * 
     * @return clientNbr
     */
    public java.lang.String getClientNbr() {
        return clientNbr;
    }


    /**
     * Sets the clientNbr value for this PolicyIssuedStatusVO.
     * 
     * @param clientNbr
     */
    public void setClientNbr(java.lang.String clientNbr) {
        this.clientNbr = clientNbr;
    }


    /**
     * Gets the productCode value for this PolicyIssuedStatusVO.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this PolicyIssuedStatusVO.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyIssuedStatusVO)) return false;
        PolicyIssuedStatusVO other = (PolicyIssuedStatusVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.policyHolderName==null && other.getPolicyHolderName()==null) || 
             (this.policyHolderName!=null &&
              this.policyHolderName.equals(other.getPolicyHolderName()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.appPolicyStatus==null && other.getAppPolicyStatus()==null) || 
             (this.appPolicyStatus!=null &&
              this.appPolicyStatus.equals(other.getAppPolicyStatus()))) &&
            ((this.clientNbr==null && other.getClientNbr()==null) || 
             (this.clientNbr!=null &&
              this.clientNbr.equals(other.getClientNbr()))) &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode())));
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
        if (getPolicyHolderName() != null) {
            _hashCode += getPolicyHolderName().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getAppPolicyStatus() != null) {
            _hashCode += getAppPolicyStatus().hashCode();
        }
        if (getClientNbr() != null) {
            _hashCode += getClientNbr().hashCode();
        }
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyIssuedStatusVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyIssuedStatusVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolderName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyHolderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appPolicyStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AppPolicyStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ClientNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCode");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductCode"));
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

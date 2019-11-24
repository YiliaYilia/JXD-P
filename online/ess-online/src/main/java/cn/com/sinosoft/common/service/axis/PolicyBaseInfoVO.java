/**
 * PolicyBaseInfoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PolicyBaseInfoVO  implements java.io.Serializable {
    private java.lang.String policyHolderName;

    private java.lang.String policyNbr;

    private java.lang.String productName;

    private java.lang.String effectiveDate;

    private java.lang.String investmentValue;

    private java.lang.String clientNbr;

    private java.lang.String productCode;

    private java.lang.String lob;

    public PolicyBaseInfoVO() {
    }

    public PolicyBaseInfoVO(
           java.lang.String policyHolderName,
           java.lang.String policyNbr,
           java.lang.String productName,
           java.lang.String effectiveDate,
           java.lang.String investmentValue,
           java.lang.String clientNbr,
           java.lang.String productCode,
           java.lang.String lob) {
           this.policyHolderName = policyHolderName;
           this.policyNbr = policyNbr;
           this.productName = productName;
           this.effectiveDate = effectiveDate;
           this.investmentValue = investmentValue;
           this.clientNbr = clientNbr;
           this.productCode = productCode;
           this.lob = lob;
    }


    /**
     * Gets the policyHolderName value for this PolicyBaseInfoVO.
     * 
     * @return policyHolderName
     */
    public java.lang.String getPolicyHolderName() {
        return policyHolderName;
    }


    /**
     * Sets the policyHolderName value for this PolicyBaseInfoVO.
     * 
     * @param policyHolderName
     */
    public void setPolicyHolderName(java.lang.String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }


    /**
     * Gets the policyNbr value for this PolicyBaseInfoVO.
     * 
     * @return policyNbr
     */
    public java.lang.String getPolicyNbr() {
        return policyNbr;
    }


    /**
     * Sets the policyNbr value for this PolicyBaseInfoVO.
     * 
     * @param policyNbr
     */
    public void setPolicyNbr(java.lang.String policyNbr) {
        this.policyNbr = policyNbr;
    }


    /**
     * Gets the productName value for this PolicyBaseInfoVO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this PolicyBaseInfoVO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the effectiveDate value for this PolicyBaseInfoVO.
     * 
     * @return effectiveDate
     */
    public java.lang.String getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this PolicyBaseInfoVO.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.lang.String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the investmentValue value for this PolicyBaseInfoVO.
     * 
     * @return investmentValue
     */
    public java.lang.String getInvestmentValue() {
        return investmentValue;
    }


    /**
     * Sets the investmentValue value for this PolicyBaseInfoVO.
     * 
     * @param investmentValue
     */
    public void setInvestmentValue(java.lang.String investmentValue) {
        this.investmentValue = investmentValue;
    }


    /**
     * Gets the clientNbr value for this PolicyBaseInfoVO.
     * 
     * @return clientNbr
     */
    public java.lang.String getClientNbr() {
        return clientNbr;
    }


    /**
     * Sets the clientNbr value for this PolicyBaseInfoVO.
     * 
     * @param clientNbr
     */
    public void setClientNbr(java.lang.String clientNbr) {
        this.clientNbr = clientNbr;
    }


    /**
     * Gets the productCode value for this PolicyBaseInfoVO.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this PolicyBaseInfoVO.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the lob value for this PolicyBaseInfoVO.
     * 
     * @return lob
     */
    public java.lang.String getLob() {
        return lob;
    }


    /**
     * Sets the lob value for this PolicyBaseInfoVO.
     * 
     * @param lob
     */
    public void setLob(java.lang.String lob) {
        this.lob = lob;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyBaseInfoVO)) return false;
        PolicyBaseInfoVO other = (PolicyBaseInfoVO) obj;
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
            ((this.policyNbr==null && other.getPolicyNbr()==null) || 
             (this.policyNbr!=null &&
              this.policyNbr.equals(other.getPolicyNbr()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.investmentValue==null && other.getInvestmentValue()==null) || 
             (this.investmentValue!=null &&
              this.investmentValue.equals(other.getInvestmentValue()))) &&
            ((this.clientNbr==null && other.getClientNbr()==null) || 
             (this.clientNbr!=null &&
              this.clientNbr.equals(other.getClientNbr()))) &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            ((this.lob==null && other.getLob()==null) || 
             (this.lob!=null &&
              this.lob.equals(other.getLob())));
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
        if (getPolicyNbr() != null) {
            _hashCode += getPolicyNbr().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getInvestmentValue() != null) {
            _hashCode += getInvestmentValue().hashCode();
        }
        if (getClientNbr() != null) {
            _hashCode += getClientNbr().hashCode();
        }
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        if (getLob() != null) {
            _hashCode += getLob().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyBaseInfoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolderName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyHolderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyNbr"));
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
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "EffectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("investmentValue");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "InvestmentValue"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lob");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "Lob"));
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

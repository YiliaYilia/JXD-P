/**
 * QueryModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class QueryModel  implements java.io.Serializable {
    private java.lang.String inceptionDate;

    private java.lang.String policyNum;

    private java.lang.String policyStatus;

    private java.lang.String productCode;

    private java.lang.String productName;

    public QueryModel() {
    }

    public QueryModel(
           java.lang.String inceptionDate,
           java.lang.String policyNum,
           java.lang.String policyStatus,
           java.lang.String productCode,
           java.lang.String productName) {
           this.inceptionDate = inceptionDate;
           this.policyNum = policyNum;
           this.policyStatus = policyStatus;
           this.productCode = productCode;
           this.productName = productName;
    }


    /**
     * Gets the inceptionDate value for this QueryModel.
     * 
     * @return inceptionDate
     */
    public java.lang.String getInceptionDate() {
        return inceptionDate;
    }


    /**
     * Sets the inceptionDate value for this QueryModel.
     * 
     * @param inceptionDate
     */
    public void setInceptionDate(java.lang.String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }


    /**
     * Gets the policyNum value for this QueryModel.
     * 
     * @return policyNum
     */
    public java.lang.String getPolicyNum() {
        return policyNum;
    }


    /**
     * Sets the policyNum value for this QueryModel.
     * 
     * @param policyNum
     */
    public void setPolicyNum(java.lang.String policyNum) {
        this.policyNum = policyNum;
    }


    /**
     * Gets the policyStatus value for this QueryModel.
     * 
     * @return policyStatus
     */
    public java.lang.String getPolicyStatus() {
        return policyStatus;
    }


    /**
     * Sets the policyStatus value for this QueryModel.
     * 
     * @param policyStatus
     */
    public void setPolicyStatus(java.lang.String policyStatus) {
        this.policyStatus = policyStatus;
    }


    /**
     * Gets the productCode value for this QueryModel.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this QueryModel.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the productName value for this QueryModel.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this QueryModel.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryModel)) return false;
        QueryModel other = (QueryModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inceptionDate==null && other.getInceptionDate()==null) || 
             (this.inceptionDate!=null &&
              this.inceptionDate.equals(other.getInceptionDate()))) &&
            ((this.policyNum==null && other.getPolicyNum()==null) || 
             (this.policyNum!=null &&
              this.policyNum.equals(other.getPolicyNum()))) &&
            ((this.policyStatus==null && other.getPolicyStatus()==null) || 
             (this.policyStatus!=null &&
              this.policyStatus.equals(other.getPolicyStatus()))) &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName())));
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
        if (getInceptionDate() != null) {
            _hashCode += getInceptionDate().hashCode();
        }
        if (getPolicyNum() != null) {
            _hashCode += getPolicyNum().hashCode();
        }
        if (getPolicyStatus() != null) {
            _hashCode += getPolicyStatus().hashCode();
        }
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "QueryModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inceptionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "inceptionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "policyNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "policyStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "productCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "productName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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

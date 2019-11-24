/**
 * ProductRulesVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class ProductRulesVO  implements java.io.Serializable {
    private java.lang.String productName;

    private java.lang.String productCode;

    private cn.com.sinosoft.common.service.axis.AccountIdVO[] accountVO;

    private java.lang.String posTransactionFlag;

    public ProductRulesVO() {
    }

    public ProductRulesVO(
           java.lang.String productName,
           java.lang.String productCode,
           cn.com.sinosoft.common.service.axis.AccountIdVO[] accountVO,
           java.lang.String posTransactionFlag) {
           this.productName = productName;
           this.productCode = productCode;
           this.accountVO = accountVO;
           this.posTransactionFlag = posTransactionFlag;
    }


    /**
     * Gets the productName value for this ProductRulesVO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this ProductRulesVO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the productCode value for this ProductRulesVO.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this ProductRulesVO.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the accountVO value for this ProductRulesVO.
     * 
     * @return accountVO
     */
    public cn.com.sinosoft.common.service.axis.AccountIdVO[] getAccountVO() {
        return accountVO;
    }


    /**
     * Sets the accountVO value for this ProductRulesVO.
     * 
     * @param accountVO
     */
    public void setAccountVO(cn.com.sinosoft.common.service.axis.AccountIdVO[] accountVO) {
        this.accountVO = accountVO;
    }


    /**
     * Gets the posTransactionFlag value for this ProductRulesVO.
     * 
     * @return posTransactionFlag
     */
    public java.lang.String getPosTransactionFlag() {
        return posTransactionFlag;
    }


    /**
     * Sets the posTransactionFlag value for this ProductRulesVO.
     * 
     * @param posTransactionFlag
     */
    public void setPosTransactionFlag(java.lang.String posTransactionFlag) {
        this.posTransactionFlag = posTransactionFlag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductRulesVO)) return false;
        ProductRulesVO other = (ProductRulesVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            ((this.accountVO==null && other.getAccountVO()==null) || 
             (this.accountVO!=null &&
              java.util.Arrays.equals(this.accountVO, other.getAccountVO()))) &&
            ((this.posTransactionFlag==null && other.getPosTransactionFlag()==null) || 
             (this.posTransactionFlag!=null &&
              this.posTransactionFlag.equals(other.getPosTransactionFlag())));
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
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        if (getAccountVO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccountVO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccountVO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPosTransactionFlag() != null) {
            _hashCode += getPosTransactionFlag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductRulesVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductRulesVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductName"));
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
        elemField.setFieldName("accountVO");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountIdVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountIdVO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posTransactionFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PosTransactionFlag"));
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

/**
 * GetPremiumPayDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class GetPremiumPayDetail  implements java.io.Serializable {
    private String operator;

    private String systemCode;

    private String policyCode;

    private String paymentReferenceNo;

    private String dueDate;

    public GetPremiumPayDetail() {
    }

    public GetPremiumPayDetail(
           String operator,
           String systemCode,
           String policyCode,
           String paymentReferenceNo,
           String dueDate) {
           this.operator = operator;
           this.systemCode = systemCode;
           this.policyCode = policyCode;
           this.paymentReferenceNo = paymentReferenceNo;
           this.dueDate = dueDate;
    }


    /**
     * Gets the operator value for this GetPremiumPayDetail.
     * 
     * @return operator
     */
    public String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this GetPremiumPayDetail.
     * 
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }


    /**
     * Gets the systemCode value for this GetPremiumPayDetail.
     * 
     * @return systemCode
     */
    public String getSystemCode() {
        return systemCode;
    }


    /**
     * Sets the systemCode value for this GetPremiumPayDetail.
     * 
     * @param systemCode
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }


    /**
     * Gets the policyCode value for this GetPremiumPayDetail.
     * 
     * @return policyCode
     */
    public String getPolicyCode() {
        return policyCode;
    }


    /**
     * Sets the policyCode value for this GetPremiumPayDetail.
     * 
     * @param policyCode
     */
    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }


    /**
     * Gets the paymentReferenceNo value for this GetPremiumPayDetail.
     * 
     * @return paymentReferenceNo
     */
    public String getPaymentReferenceNo() {
        return paymentReferenceNo;
    }


    /**
     * Sets the paymentReferenceNo value for this GetPremiumPayDetail.
     * 
     * @param paymentReferenceNo
     */
    public void setPaymentReferenceNo(String paymentReferenceNo) {
        this.paymentReferenceNo = paymentReferenceNo;
    }


    /**
     * Gets the dueDate value for this GetPremiumPayDetail.
     * 
     * @return dueDate
     */
    public String getDueDate() {
        return dueDate;
    }


    /**
     * Sets the dueDate value for this GetPremiumPayDetail.
     * 
     * @param dueDate
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetPremiumPayDetail)) return false;
        GetPremiumPayDetail other = (GetPremiumPayDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operator==null && other.getOperator()==null) || 
             (this.operator!=null &&
              this.operator.equals(other.getOperator()))) &&
            ((this.systemCode==null && other.getSystemCode()==null) || 
             (this.systemCode!=null &&
              this.systemCode.equals(other.getSystemCode()))) &&
            ((this.policyCode==null && other.getPolicyCode()==null) || 
             (this.policyCode!=null &&
              this.policyCode.equals(other.getPolicyCode()))) &&
            ((this.paymentReferenceNo==null && other.getPaymentReferenceNo()==null) || 
             (this.paymentReferenceNo!=null &&
              this.paymentReferenceNo.equals(other.getPaymentReferenceNo()))) &&
            ((this.dueDate==null && other.getDueDate()==null) || 
             (this.dueDate!=null &&
              this.dueDate.equals(other.getDueDate())));
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
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        if (getSystemCode() != null) {
            _hashCode += getSystemCode().hashCode();
        }
        if (getPolicyCode() != null) {
            _hashCode += getPolicyCode().hashCode();
        }
        if (getPaymentReferenceNo() != null) {
            _hashCode += getPaymentReferenceNo().hashCode();
        }
        if (getDueDate() != null) {
            _hashCode += getDueDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPremiumPayDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.sinosoft.com", ">getPremiumPayDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "operator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "systemCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "policyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentReferenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "paymentReferenceNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "dueDate"));
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
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

/**
 * DoPremiumPay.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class DoPremiumPay  implements java.io.Serializable {
    private String operator;

    private String systemCode;

    private String policyCode;

    private String paymentReferenceNo;

    private String dueDate;

    private String payDate;

    private String payAmount;

    private String bankBranchCode;

    private String bankAccountNumber;

    private String online_pay_code;

    public DoPremiumPay() {
    }

    public DoPremiumPay(
           String operator,
           String systemCode,
           String policyCode,
           String paymentReferenceNo,
           String dueDate,
           String payDate,
           String payAmount,
           String bankBranchCode,
           String bankAccountNumber,
           String online_pay_code) {
           this.operator = operator;
           this.systemCode = systemCode;
           this.policyCode = policyCode;
           this.paymentReferenceNo = paymentReferenceNo;
           this.dueDate = dueDate;
           this.payDate = payDate;
           this.payAmount = payAmount;
           this.bankBranchCode = bankBranchCode;
           this.bankAccountNumber = bankAccountNumber;
           this.online_pay_code = online_pay_code;
    }


    /**
     * Gets the operator value for this DoPremiumPay.
     * 
     * @return operator
     */
    public String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this DoPremiumPay.
     * 
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }


    /**
     * Gets the systemCode value for this DoPremiumPay.
     * 
     * @return systemCode
     */
    public String getSystemCode() {
        return systemCode;
    }


    /**
     * Sets the systemCode value for this DoPremiumPay.
     * 
     * @param systemCode
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }


    /**
     * Gets the policyCode value for this DoPremiumPay.
     * 
     * @return policyCode
     */
    public String getPolicyCode() {
        return policyCode;
    }


    /**
     * Sets the policyCode value for this DoPremiumPay.
     * 
     * @param policyCode
     */
    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }


    /**
     * Gets the paymentReferenceNo value for this DoPremiumPay.
     * 
     * @return paymentReferenceNo
     */
    public String getPaymentReferenceNo() {
        return paymentReferenceNo;
    }


    /**
     * Sets the paymentReferenceNo value for this DoPremiumPay.
     * 
     * @param paymentReferenceNo
     */
    public void setPaymentReferenceNo(String paymentReferenceNo) {
        this.paymentReferenceNo = paymentReferenceNo;
    }


    /**
     * Gets the dueDate value for this DoPremiumPay.
     * 
     * @return dueDate
     */
    public String getDueDate() {
        return dueDate;
    }


    /**
     * Sets the dueDate value for this DoPremiumPay.
     * 
     * @param dueDate
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }


    /**
     * Gets the payDate value for this DoPremiumPay.
     * 
     * @return payDate
     */
    public String getPayDate() {
        return payDate;
    }


    /**
     * Sets the payDate value for this DoPremiumPay.
     * 
     * @param payDate
     */
    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }


    /**
     * Gets the payAmount value for this DoPremiumPay.
     * 
     * @return payAmount
     */
    public String getPayAmount() {
        return payAmount;
    }


    /**
     * Sets the payAmount value for this DoPremiumPay.
     * 
     * @param payAmount
     */
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }


    /**
     * Gets the bankBranchCode value for this DoPremiumPay.
     * 
     * @return bankBranchCode
     */
    public String getBankBranchCode() {
        return bankBranchCode;
    }


    /**
     * Sets the bankBranchCode value for this DoPremiumPay.
     * 
     * @param bankBranchCode
     */
    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }


    /**
     * Gets the bankAccountNumber value for this DoPremiumPay.
     * 
     * @return bankAccountNumber
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }


    /**
     * Sets the bankAccountNumber value for this DoPremiumPay.
     * 
     * @param bankAccountNumber
     */
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }


    /**
     * Gets the online_pay_code value for this DoPremiumPay.
     * 
     * @return online_pay_code
     */
    public String getOnline_pay_code() {
        return online_pay_code;
    }


    /**
     * Sets the online_pay_code value for this DoPremiumPay.
     * 
     * @param online_pay_code
     */
    public void setOnline_pay_code(String online_pay_code) {
        this.online_pay_code = online_pay_code;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof DoPremiumPay)) return false;
        DoPremiumPay other = (DoPremiumPay) obj;
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
              this.dueDate.equals(other.getDueDate()))) &&
            ((this.payDate==null && other.getPayDate()==null) || 
             (this.payDate!=null &&
              this.payDate.equals(other.getPayDate()))) &&
            ((this.payAmount==null && other.getPayAmount()==null) || 
             (this.payAmount!=null &&
              this.payAmount.equals(other.getPayAmount()))) &&
            ((this.bankBranchCode==null && other.getBankBranchCode()==null) || 
             (this.bankBranchCode!=null &&
              this.bankBranchCode.equals(other.getBankBranchCode()))) &&
            ((this.bankAccountNumber==null && other.getBankAccountNumber()==null) || 
             (this.bankAccountNumber!=null &&
              this.bankAccountNumber.equals(other.getBankAccountNumber()))) &&
            ((this.online_pay_code==null && other.getOnline_pay_code()==null) || 
             (this.online_pay_code!=null &&
              this.online_pay_code.equals(other.getOnline_pay_code())));
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
        if (getPayDate() != null) {
            _hashCode += getPayDate().hashCode();
        }
        if (getPayAmount() != null) {
            _hashCode += getPayAmount().hashCode();
        }
        if (getBankBranchCode() != null) {
            _hashCode += getBankBranchCode().hashCode();
        }
        if (getBankAccountNumber() != null) {
            _hashCode += getBankAccountNumber().hashCode();
        }
        if (getOnline_pay_code() != null) {
            _hashCode += getOnline_pay_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoPremiumPay.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.sinosoft.com", ">doPremiumPay"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "payDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "payAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankBranchCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "bankBranchCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankAccountNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "bankAccountNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("online_pay_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "online_pay_code"));
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

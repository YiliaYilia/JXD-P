/**
 * PayDeatilModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PayDeatilModel  implements java.io.Serializable {
    private java.lang.String amount;

    private java.lang.String bankbrachcode;

    private java.lang.String bankcode;

    private java.lang.String errCode;

    private java.lang.String errDesc;

    private java.lang.String fileInDate;

    private java.lang.String fileOutDate;

    private java.lang.String generateDate;

    private java.lang.String transactionDate;

    private java.lang.String transactionType;

    public PayDeatilModel() {
    }

    public PayDeatilModel(
           java.lang.String amount,
           java.lang.String bankbrachcode,
           java.lang.String bankcode,
           java.lang.String errCode,
           java.lang.String errDesc,
           java.lang.String fileInDate,
           java.lang.String fileOutDate,
           java.lang.String generateDate,
           java.lang.String transactionDate,
           java.lang.String transactionType) {
           this.amount = amount;
           this.bankbrachcode = bankbrachcode;
           this.bankcode = bankcode;
           this.errCode = errCode;
           this.errDesc = errDesc;
           this.fileInDate = fileInDate;
           this.fileOutDate = fileOutDate;
           this.generateDate = generateDate;
           this.transactionDate = transactionDate;
           this.transactionType = transactionType;
    }


    /**
     * Gets the amount value for this PayDeatilModel.
     * 
     * @return amount
     */
    public java.lang.String getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this PayDeatilModel.
     * 
     * @param amount
     */
    public void setAmount(java.lang.String amount) {
        this.amount = amount;
    }


    /**
     * Gets the bankbrachcode value for this PayDeatilModel.
     * 
     * @return bankbrachcode
     */
    public java.lang.String getBankbrachcode() {
        return bankbrachcode;
    }


    /**
     * Sets the bankbrachcode value for this PayDeatilModel.
     * 
     * @param bankbrachcode
     */
    public void setBankbrachcode(java.lang.String bankbrachcode) {
        this.bankbrachcode = bankbrachcode;
    }


    /**
     * Gets the bankcode value for this PayDeatilModel.
     * 
     * @return bankcode
     */
    public java.lang.String getBankcode() {
        return bankcode;
    }


    /**
     * Sets the bankcode value for this PayDeatilModel.
     * 
     * @param bankcode
     */
    public void setBankcode(java.lang.String bankcode) {
        this.bankcode = bankcode;
    }


    /**
     * Gets the errCode value for this PayDeatilModel.
     * 
     * @return errCode
     */
    public java.lang.String getErrCode() {
        return errCode;
    }


    /**
     * Sets the errCode value for this PayDeatilModel.
     * 
     * @param errCode
     */
    public void setErrCode(java.lang.String errCode) {
        this.errCode = errCode;
    }


    /**
     * Gets the errDesc value for this PayDeatilModel.
     * 
     * @return errDesc
     */
    public java.lang.String getErrDesc() {
        return errDesc;
    }


    /**
     * Sets the errDesc value for this PayDeatilModel.
     * 
     * @param errDesc
     */
    public void setErrDesc(java.lang.String errDesc) {
        this.errDesc = errDesc;
    }


    /**
     * Gets the fileInDate value for this PayDeatilModel.
     * 
     * @return fileInDate
     */
    public java.lang.String getFileInDate() {
        return fileInDate;
    }


    /**
     * Sets the fileInDate value for this PayDeatilModel.
     * 
     * @param fileInDate
     */
    public void setFileInDate(java.lang.String fileInDate) {
        this.fileInDate = fileInDate;
    }


    /**
     * Gets the fileOutDate value for this PayDeatilModel.
     * 
     * @return fileOutDate
     */
    public java.lang.String getFileOutDate() {
        return fileOutDate;
    }


    /**
     * Sets the fileOutDate value for this PayDeatilModel.
     * 
     * @param fileOutDate
     */
    public void setFileOutDate(java.lang.String fileOutDate) {
        this.fileOutDate = fileOutDate;
    }


    /**
     * Gets the generateDate value for this PayDeatilModel.
     * 
     * @return generateDate
     */
    public java.lang.String getGenerateDate() {
        return generateDate;
    }


    /**
     * Sets the generateDate value for this PayDeatilModel.
     * 
     * @param generateDate
     */
    public void setGenerateDate(java.lang.String generateDate) {
        this.generateDate = generateDate;
    }


    /**
     * Gets the transactionDate value for this PayDeatilModel.
     * 
     * @return transactionDate
     */
    public java.lang.String getTransactionDate() {
        return transactionDate;
    }


    /**
     * Sets the transactionDate value for this PayDeatilModel.
     * 
     * @param transactionDate
     */
    public void setTransactionDate(java.lang.String transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * Gets the transactionType value for this PayDeatilModel.
     * 
     * @return transactionType
     */
    public java.lang.String getTransactionType() {
        return transactionType;
    }


    /**
     * Sets the transactionType value for this PayDeatilModel.
     * 
     * @param transactionType
     */
    public void setTransactionType(java.lang.String transactionType) {
        this.transactionType = transactionType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PayDeatilModel)) return false;
        PayDeatilModel other = (PayDeatilModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.bankbrachcode==null && other.getBankbrachcode()==null) || 
             (this.bankbrachcode!=null &&
              this.bankbrachcode.equals(other.getBankbrachcode()))) &&
            ((this.bankcode==null && other.getBankcode()==null) || 
             (this.bankcode!=null &&
              this.bankcode.equals(other.getBankcode()))) &&
            ((this.errCode==null && other.getErrCode()==null) || 
             (this.errCode!=null &&
              this.errCode.equals(other.getErrCode()))) &&
            ((this.errDesc==null && other.getErrDesc()==null) || 
             (this.errDesc!=null &&
              this.errDesc.equals(other.getErrDesc()))) &&
            ((this.fileInDate==null && other.getFileInDate()==null) || 
             (this.fileInDate!=null &&
              this.fileInDate.equals(other.getFileInDate()))) &&
            ((this.fileOutDate==null && other.getFileOutDate()==null) || 
             (this.fileOutDate!=null &&
              this.fileOutDate.equals(other.getFileOutDate()))) &&
            ((this.generateDate==null && other.getGenerateDate()==null) || 
             (this.generateDate!=null &&
              this.generateDate.equals(other.getGenerateDate()))) &&
            ((this.transactionDate==null && other.getTransactionDate()==null) || 
             (this.transactionDate!=null &&
              this.transactionDate.equals(other.getTransactionDate()))) &&
            ((this.transactionType==null && other.getTransactionType()==null) || 
             (this.transactionType!=null &&
              this.transactionType.equals(other.getTransactionType())));
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
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getBankbrachcode() != null) {
            _hashCode += getBankbrachcode().hashCode();
        }
        if (getBankcode() != null) {
            _hashCode += getBankcode().hashCode();
        }
        if (getErrCode() != null) {
            _hashCode += getErrCode().hashCode();
        }
        if (getErrDesc() != null) {
            _hashCode += getErrDesc().hashCode();
        }
        if (getFileInDate() != null) {
            _hashCode += getFileInDate().hashCode();
        }
        if (getFileOutDate() != null) {
            _hashCode += getFileOutDate().hashCode();
        }
        if (getGenerateDate() != null) {
            _hashCode += getGenerateDate().hashCode();
        }
        if (getTransactionDate() != null) {
            _hashCode += getTransactionDate().hashCode();
        }
        if (getTransactionType() != null) {
            _hashCode += getTransactionType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PayDeatilModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "PayDeatilModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankbrachcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "bankbrachcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "bankcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "errCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "errDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileInDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "fileInDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileOutDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "fileOutDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "generateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "transactionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "transactionType"));
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

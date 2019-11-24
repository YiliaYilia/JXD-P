/**
 * WeChatQueryModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class WeChatQueryModel  implements java.io.Serializable {
    private java.lang.Integer code;

    private java.lang.String contenct;

    private java.lang.String expireDate;

    private java.lang.String inceptionDate;

    private java.lang.String polCoverNoteNum;

    private java.lang.String polStatus;

    private java.lang.String policyNum;

    private java.lang.String transferGUID;

    public WeChatQueryModel() {
    }

    public WeChatQueryModel(
           java.lang.Integer code,
           java.lang.String contenct,
           java.lang.String expireDate,
           java.lang.String inceptionDate,
           java.lang.String polCoverNoteNum,
           java.lang.String polStatus,
           java.lang.String policyNum,
           java.lang.String transferGUID) {
           this.code = code;
           this.contenct = contenct;
           this.expireDate = expireDate;
           this.inceptionDate = inceptionDate;
           this.polCoverNoteNum = polCoverNoteNum;
           this.polStatus = polStatus;
           this.policyNum = policyNum;
           this.transferGUID = transferGUID;
    }


    /**
     * Gets the code value for this WeChatQueryModel.
     * 
     * @return code
     */
    public java.lang.Integer getCode() {
        return code;
    }


    /**
     * Sets the code value for this WeChatQueryModel.
     * 
     * @param code
     */
    public void setCode(java.lang.Integer code) {
        this.code = code;
    }


    /**
     * Gets the contenct value for this WeChatQueryModel.
     * 
     * @return contenct
     */
    public java.lang.String getContenct() {
        return contenct;
    }


    /**
     * Sets the contenct value for this WeChatQueryModel.
     * 
     * @param contenct
     */
    public void setContenct(java.lang.String contenct) {
        this.contenct = contenct;
    }


    /**
     * Gets the expireDate value for this WeChatQueryModel.
     * 
     * @return expireDate
     */
    public java.lang.String getExpireDate() {
        return expireDate;
    }


    /**
     * Sets the expireDate value for this WeChatQueryModel.
     * 
     * @param expireDate
     */
    public void setExpireDate(java.lang.String expireDate) {
        this.expireDate = expireDate;
    }


    /**
     * Gets the inceptionDate value for this WeChatQueryModel.
     * 
     * @return inceptionDate
     */
    public java.lang.String getInceptionDate() {
        return inceptionDate;
    }


    /**
     * Sets the inceptionDate value for this WeChatQueryModel.
     * 
     * @param inceptionDate
     */
    public void setInceptionDate(java.lang.String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }


    /**
     * Gets the polCoverNoteNum value for this WeChatQueryModel.
     * 
     * @return polCoverNoteNum
     */
    public java.lang.String getPolCoverNoteNum() {
        return polCoverNoteNum;
    }


    /**
     * Sets the polCoverNoteNum value for this WeChatQueryModel.
     * 
     * @param polCoverNoteNum
     */
    public void setPolCoverNoteNum(java.lang.String polCoverNoteNum) {
        this.polCoverNoteNum = polCoverNoteNum;
    }


    /**
     * Gets the polStatus value for this WeChatQueryModel.
     * 
     * @return polStatus
     */
    public java.lang.String getPolStatus() {
        return polStatus;
    }


    /**
     * Sets the polStatus value for this WeChatQueryModel.
     * 
     * @param polStatus
     */
    public void setPolStatus(java.lang.String polStatus) {
        this.polStatus = polStatus;
    }


    /**
     * Gets the policyNum value for this WeChatQueryModel.
     * 
     * @return policyNum
     */
    public java.lang.String getPolicyNum() {
        return policyNum;
    }


    /**
     * Sets the policyNum value for this WeChatQueryModel.
     * 
     * @param policyNum
     */
    public void setPolicyNum(java.lang.String policyNum) {
        this.policyNum = policyNum;
    }


    /**
     * Gets the transferGUID value for this WeChatQueryModel.
     * 
     * @return transferGUID
     */
    public java.lang.String getTransferGUID() {
        return transferGUID;
    }


    /**
     * Sets the transferGUID value for this WeChatQueryModel.
     * 
     * @param transferGUID
     */
    public void setTransferGUID(java.lang.String transferGUID) {
        this.transferGUID = transferGUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WeChatQueryModel)) return false;
        WeChatQueryModel other = (WeChatQueryModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.contenct==null && other.getContenct()==null) || 
             (this.contenct!=null &&
              this.contenct.equals(other.getContenct()))) &&
            ((this.expireDate==null && other.getExpireDate()==null) || 
             (this.expireDate!=null &&
              this.expireDate.equals(other.getExpireDate()))) &&
            ((this.inceptionDate==null && other.getInceptionDate()==null) || 
             (this.inceptionDate!=null &&
              this.inceptionDate.equals(other.getInceptionDate()))) &&
            ((this.polCoverNoteNum==null && other.getPolCoverNoteNum()==null) || 
             (this.polCoverNoteNum!=null &&
              this.polCoverNoteNum.equals(other.getPolCoverNoteNum()))) &&
            ((this.polStatus==null && other.getPolStatus()==null) || 
             (this.polStatus!=null &&
              this.polStatus.equals(other.getPolStatus()))) &&
            ((this.policyNum==null && other.getPolicyNum()==null) || 
             (this.policyNum!=null &&
              this.policyNum.equals(other.getPolicyNum()))) &&
            ((this.transferGUID==null && other.getTransferGUID()==null) || 
             (this.transferGUID!=null &&
              this.transferGUID.equals(other.getTransferGUID())));
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
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getContenct() != null) {
            _hashCode += getContenct().hashCode();
        }
        if (getExpireDate() != null) {
            _hashCode += getExpireDate().hashCode();
        }
        if (getInceptionDate() != null) {
            _hashCode += getInceptionDate().hashCode();
        }
        if (getPolCoverNoteNum() != null) {
            _hashCode += getPolCoverNoteNum().hashCode();
        }
        if (getPolStatus() != null) {
            _hashCode += getPolStatus().hashCode();
        }
        if (getPolicyNum() != null) {
            _hashCode += getPolicyNum().hashCode();
        }
        if (getTransferGUID() != null) {
            _hashCode += getTransferGUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WeChatQueryModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "WeChatQueryModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenct");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "contenct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expireDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "expireDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inceptionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "inceptionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("polCoverNoteNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "polCoverNoteNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("polStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "polStatus"));
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
        elemField.setFieldName("transferGUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "transferGUID"));
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

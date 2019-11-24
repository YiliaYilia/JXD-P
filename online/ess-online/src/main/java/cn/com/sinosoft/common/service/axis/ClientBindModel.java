/**
 * ClientBindModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class ClientBindModel  implements java.io.Serializable {
    private java.lang.String birthDate;

    private java.lang.Integer code;

    private java.lang.String contactAddress;

    private java.lang.String contactNo;

    private java.lang.String contenct;

    private java.lang.String email;

    private java.lang.Boolean flag;

    private java.lang.String idNo;

    private java.lang.String idType;

    private java.lang.String partyCode;

    private java.lang.String partyName;

    private java.lang.String postalcode;

    private java.lang.String sex;

    public ClientBindModel() {
    }

    public ClientBindModel(
           java.lang.String birthDate,
           java.lang.Integer code,
           java.lang.String contactAddress,
           java.lang.String contactNo,
           java.lang.String contenct,
           java.lang.String email,
           java.lang.Boolean flag,
           java.lang.String idNo,
           java.lang.String idType,
           java.lang.String partyCode,
           java.lang.String partyName,
           java.lang.String postalcode,
           java.lang.String sex) {
           this.birthDate = birthDate;
           this.code = code;
           this.contactAddress = contactAddress;
           this.contactNo = contactNo;
           this.contenct = contenct;
           this.email = email;
           this.flag = flag;
           this.idNo = idNo;
           this.idType = idType;
           this.partyCode = partyCode;
           this.partyName = partyName;
           this.postalcode = postalcode;
           this.sex = sex;
    }


    /**
     * Gets the birthDate value for this ClientBindModel.
     * 
     * @return birthDate
     */
    public java.lang.String getBirthDate() {
        return birthDate;
    }


    /**
     * Sets the birthDate value for this ClientBindModel.
     * 
     * @param birthDate
     */
    public void setBirthDate(java.lang.String birthDate) {
        this.birthDate = birthDate;
    }


    /**
     * Gets the code value for this ClientBindModel.
     * 
     * @return code
     */
    public java.lang.Integer getCode() {
        return code;
    }


    /**
     * Sets the code value for this ClientBindModel.
     * 
     * @param code
     */
    public void setCode(java.lang.Integer code) {
        this.code = code;
    }


    /**
     * Gets the contactAddress value for this ClientBindModel.
     * 
     * @return contactAddress
     */
    public java.lang.String getContactAddress() {
        return contactAddress;
    }


    /**
     * Sets the contactAddress value for this ClientBindModel.
     * 
     * @param contactAddress
     */
    public void setContactAddress(java.lang.String contactAddress) {
        this.contactAddress = contactAddress;
    }


    /**
     * Gets the contactNo value for this ClientBindModel.
     * 
     * @return contactNo
     */
    public java.lang.String getContactNo() {
        return contactNo;
    }


    /**
     * Sets the contactNo value for this ClientBindModel.
     * 
     * @param contactNo
     */
    public void setContactNo(java.lang.String contactNo) {
        this.contactNo = contactNo;
    }


    /**
     * Gets the contenct value for this ClientBindModel.
     * 
     * @return contenct
     */
    public java.lang.String getContenct() {
        return contenct;
    }


    /**
     * Sets the contenct value for this ClientBindModel.
     * 
     * @param contenct
     */
    public void setContenct(java.lang.String contenct) {
        this.contenct = contenct;
    }


    /**
     * Gets the email value for this ClientBindModel.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ClientBindModel.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the flag value for this ClientBindModel.
     * 
     * @return flag
     */
    public java.lang.Boolean getFlag() {
        return flag;
    }


    /**
     * Sets the flag value for this ClientBindModel.
     * 
     * @param flag
     */
    public void setFlag(java.lang.Boolean flag) {
        this.flag = flag;
    }


    /**
     * Gets the idNo value for this ClientBindModel.
     * 
     * @return idNo
     */
    public java.lang.String getIdNo() {
        return idNo;
    }


    /**
     * Sets the idNo value for this ClientBindModel.
     * 
     * @param idNo
     */
    public void setIdNo(java.lang.String idNo) {
        this.idNo = idNo;
    }


    /**
     * Gets the idType value for this ClientBindModel.
     * 
     * @return idType
     */
    public java.lang.String getIdType() {
        return idType;
    }


    /**
     * Sets the idType value for this ClientBindModel.
     * 
     * @param idType
     */
    public void setIdType(java.lang.String idType) {
        this.idType = idType;
    }


    /**
     * Gets the partyCode value for this ClientBindModel.
     * 
     * @return partyCode
     */
    public java.lang.String getPartyCode() {
        return partyCode;
    }


    /**
     * Sets the partyCode value for this ClientBindModel.
     * 
     * @param partyCode
     */
    public void setPartyCode(java.lang.String partyCode) {
        this.partyCode = partyCode;
    }


    /**
     * Gets the partyName value for this ClientBindModel.
     * 
     * @return partyName
     */
    public java.lang.String getPartyName() {
        return partyName;
    }


    /**
     * Sets the partyName value for this ClientBindModel.
     * 
     * @param partyName
     */
    public void setPartyName(java.lang.String partyName) {
        this.partyName = partyName;
    }


    /**
     * Gets the postalcode value for this ClientBindModel.
     * 
     * @return postalcode
     */
    public java.lang.String getPostalcode() {
        return postalcode;
    }


    /**
     * Sets the postalcode value for this ClientBindModel.
     * 
     * @param postalcode
     */
    public void setPostalcode(java.lang.String postalcode) {
        this.postalcode = postalcode;
    }


    /**
     * Gets the sex value for this ClientBindModel.
     * 
     * @return sex
     */
    public java.lang.String getSex() {
        return sex;
    }


    /**
     * Sets the sex value for this ClientBindModel.
     * 
     * @param sex
     */
    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClientBindModel)) return false;
        ClientBindModel other = (ClientBindModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.birthDate==null && other.getBirthDate()==null) || 
             (this.birthDate!=null &&
              this.birthDate.equals(other.getBirthDate()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.contactAddress==null && other.getContactAddress()==null) || 
             (this.contactAddress!=null &&
              this.contactAddress.equals(other.getContactAddress()))) &&
            ((this.contactNo==null && other.getContactNo()==null) || 
             (this.contactNo!=null &&
              this.contactNo.equals(other.getContactNo()))) &&
            ((this.contenct==null && other.getContenct()==null) || 
             (this.contenct!=null &&
              this.contenct.equals(other.getContenct()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.flag==null && other.getFlag()==null) || 
             (this.flag!=null &&
              this.flag.equals(other.getFlag()))) &&
            ((this.idNo==null && other.getIdNo()==null) || 
             (this.idNo!=null &&
              this.idNo.equals(other.getIdNo()))) &&
            ((this.idType==null && other.getIdType()==null) || 
             (this.idType!=null &&
              this.idType.equals(other.getIdType()))) &&
            ((this.partyCode==null && other.getPartyCode()==null) || 
             (this.partyCode!=null &&
              this.partyCode.equals(other.getPartyCode()))) &&
            ((this.partyName==null && other.getPartyName()==null) || 
             (this.partyName!=null &&
              this.partyName.equals(other.getPartyName()))) &&
            ((this.postalcode==null && other.getPostalcode()==null) || 
             (this.postalcode!=null &&
              this.postalcode.equals(other.getPostalcode()))) &&
            ((this.sex==null && other.getSex()==null) || 
             (this.sex!=null &&
              this.sex.equals(other.getSex())));
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
        if (getBirthDate() != null) {
            _hashCode += getBirthDate().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getContactAddress() != null) {
            _hashCode += getContactAddress().hashCode();
        }
        if (getContactNo() != null) {
            _hashCode += getContactNo().hashCode();
        }
        if (getContenct() != null) {
            _hashCode += getContenct().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFlag() != null) {
            _hashCode += getFlag().hashCode();
        }
        if (getIdNo() != null) {
            _hashCode += getIdNo().hashCode();
        }
        if (getIdType() != null) {
            _hashCode += getIdType().hashCode();
        }
        if (getPartyCode() != null) {
            _hashCode += getPartyCode().hashCode();
        }
        if (getPartyName() != null) {
            _hashCode += getPartyName().hashCode();
        }
        if (getPostalcode() != null) {
            _hashCode += getPostalcode().hashCode();
        }
        if (getSex() != null) {
            _hashCode += getSex().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClientBindModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "ClientBindModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "birthDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "contactAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "contactNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenct");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "contenct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "flag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "idNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "idType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "partyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "partyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postalcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "postalcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sex");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "sex"));
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

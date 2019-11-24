/**
 * ClientBindModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.user.service.axis;

public class ClientBindModel  implements java.io.Serializable {
    private String birthDate;

    private Integer code;

    private String contactAddress;

    private String contactNo;

    private String contenct;

    private String email;

    private Boolean flag;

    private String idNo;

    private String idType;

    private String partyCode;

    private String partyName;

    private String postalcode;

    private String sex;

    public ClientBindModel() {
    }

    public ClientBindModel(
           String birthDate,
           Integer code,
           String contactAddress,
           String contactNo,
           String contenct,
           String email,
           Boolean flag,
           String idNo,
           String idType,
           String partyCode,
           String partyName,
           String postalcode,
           String sex) {
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
    public String getBirthDate() {
        return birthDate;
    }


    /**
     * Sets the birthDate value for this ClientBindModel.
     *
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    /**
     * Gets the code value for this ClientBindModel.
     *
     * @return code
     */
    public Integer getCode() {
        return code;
    }


    /**
     * Sets the code value for this ClientBindModel.
     *
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }


    /**
     * Gets the contactAddress value for this ClientBindModel.
     *
     * @return contactAddress
     */
    public String getContactAddress() {
        return contactAddress;
    }


    /**
     * Sets the contactAddress value for this ClientBindModel.
     *
     * @param contactAddress
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }


    /**
     * Gets the contactNo value for this ClientBindModel.
     *
     * @return contactNo
     */
    public String getContactNo() {
        return contactNo;
    }


    /**
     * Sets the contactNo value for this ClientBindModel.
     *
     * @param contactNo
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


    /**
     * Gets the contenct value for this ClientBindModel.
     *
     * @return contenct
     */
    public String getContenct() {
        return contenct;
    }


    /**
     * Sets the contenct value for this ClientBindModel.
     *
     * @param contenct
     */
    public void setContenct(String contenct) {
        this.contenct = contenct;
    }


    /**
     * Gets the email value for this ClientBindModel.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ClientBindModel.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the flag value for this ClientBindModel.
     *
     * @return flag
     */
    public Boolean getFlag() {
        return flag;
    }


    /**
     * Sets the flag value for this ClientBindModel.
     *
     * @param flag
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }


    /**
     * Gets the idNo value for this ClientBindModel.
     *
     * @return idNo
     */
    public String getIdNo() {
        return idNo;
    }


    /**
     * Sets the idNo value for this ClientBindModel.
     *
     * @param idNo
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }


    /**
     * Gets the idType value for this ClientBindModel.
     *
     * @return idType
     */
    public String getIdType() {
        return idType;
    }


    /**
     * Sets the idType value for this ClientBindModel.
     *
     * @param idType
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }


    /**
     * Gets the partyCode value for this ClientBindModel.
     *
     * @return partyCode
     */
    public String getPartyCode() {
        return partyCode;
    }


    /**
     * Sets the partyCode value for this ClientBindModel.
     *
     * @param partyCode
     */
    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }


    /**
     * Gets the partyName value for this ClientBindModel.
     *
     * @return partyName
     */
    public String getPartyName() {
        return partyName;
    }


    /**
     * Sets the partyName value for this ClientBindModel.
     *
     * @param partyName
     */
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }


    /**
     * Gets the postalcode value for this ClientBindModel.
     *
     * @return postalcode
     */
    public String getPostalcode() {
        return postalcode;
    }


    /**
     * Sets the postalcode value for this ClientBindModel.
     *
     * @param postalcode
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }


    /**
     * Gets the sex value for this ClientBindModel.
     *
     * @return sex
     */
    public String getSex() {
        return sex;
    }


    /**
     * Sets the sex value for this ClientBindModel.
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
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

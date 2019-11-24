/**
 * LinkWebSoap_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class LinkWebSoap_BindingStub extends org.apache.axis.client.Stub implements cn.com.sinosoft.common.service.axis.LinkWebSoap_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[36];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("login");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "LoginMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.LoginMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "loginResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getsp_createNBWithOut1stPremium");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "theInput"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getsp_createNBWithOut1stPremiumResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyBaseInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PolicyBaseInfoMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyBaseInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyBaseInfoForDist");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForDistMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyBaseInfoForDistResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyDetailMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PolicyDetailMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("revisionPinCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "oldPass"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "newPass"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "comfirmNewPass"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "revisionPinCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveTopUpPolicy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "ivmtAcctType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "topValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "acctList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfTopupAccountVO"), cn.com.sinosoft.common.service.axis.TopupAccountVO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "TopupAccountVO"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "saveTopUpPolicyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyAssessment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyAssessmentMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PolicyAssessmentMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyAssessmentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyTransactionInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "startDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "endDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "lob"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyTransactionMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PolicyTransactionMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyTransactionInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersonalInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "role"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PersonalInfoMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PersonalInfoMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPersonalInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("savePersonalInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "role"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "personalInfoVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("com.skandia.linkwebService", "PersonalInfoVO"), cn.com.sinosoft.common.service.axis.PersonalInfoVO.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "savePersonalInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTopUpPolicy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "TopUpPolicyMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.TopUpPolicyMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getTopUpPolicyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveSwitchPolicy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "alSwitch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfSwitchAccountVO"), cn.com.sinosoft.common.service.axis.SwitchAccountVO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SwitchAccountVO"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "saveSwitchPolicyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveAuthorizedDistributor");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "baseInfoAuthorizeYN"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "transRecordAuthorizeYN"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "saveAuthorizedDistributorResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("savePsByAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "amtOrPercent"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "surrenderValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPSAccountVO"), cn.com.sinosoft.common.service.axis.PSAccountVO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PSAccountVO"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "savePsByAccountResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("savePartialSurrender");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "amtOrPercent"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "surrenderValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "reason"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "savePartialSurrenderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSurrenderPolicy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "SurrenderDetailMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.SurrenderDetailMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getSurrenderPolicyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPerformanceRep1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "productCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "alIvmtAcctID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "String"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "startDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "endDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PerformanceRep1Msg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PerformanceRep1Msg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPerformanceRep1Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveSurrenderPolicy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "reason"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "saveSurrenderPolicyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnualReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualReportMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.AnnualReportMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getAnnualReportResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doPrintAnnualReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "annulRepID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "doPrintAnnualReportMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.DoPrintAnnualReportMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "doPrintAnnualReportResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProductList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ProductMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getProductListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProductInvestmentAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "productCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductInvestmentAccountMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ProductInvestmentAccountMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getProductInvestmentAccountResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPerformanceRep2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "productCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "ivmtAcctID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "startDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "endDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PerformanceRep2Msg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PerformanceRep2Msg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPerformanceRep2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUnitPrice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "productCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitPriceMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.UnitPriceMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getUnitPriceResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyIssuedStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyIssuedStatusMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PolicyIssuedStatusMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyIssuedStatusResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getClaimSettlement");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ClaimSettlementMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ClaimSettlementMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getClaimSettlementResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getChangedPolicy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ChangedPolicyMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ChangedPolicyMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getChangedPolicyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSubDistributorsList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorsListMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.SubDistributorsListMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getSubDistributorsListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSubDistributorPolicyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "distributorCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorPolicyInfoMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getSubDistributorPolicyInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCommission");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "startDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "endDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.CommissionMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getCommissionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCommissions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "distributorCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.CommissionMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getCommissionsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("logout");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ReturnMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "logoutResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyBaseInfoForFA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "clientNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForFAMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyBaseInfoForFAResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyTransactionDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "policyNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.skandia.linkwebService", "transactionSeqNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "TransactionDetailMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.TransactionDetailMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyTransactionDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProductRules");
        oper.setReturnType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductRulesMsg"));
        oper.setReturnClass(cn.com.sinosoft.common.service.axis.ProductRulesMsg.class);
        oper.setReturnQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getProductRulesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

    }

    public LinkWebSoap_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public LinkWebSoap_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public LinkWebSoap_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountIdVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AccountIdVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountValueVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AccountValueVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AccountVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualReportMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AnnualReportMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualReportVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AnnualReportVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfAccountIdVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AccountIdVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountIdVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountIdVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfAccountValueVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AccountValueVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountValueVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountValueVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfAccountVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AccountVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfAnnualReportVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.AnnualReportVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualReportVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "AnnualReportVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfClaimSettlementVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ClaimSettlementVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ClaimSettlementVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "ClaimSettlementVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfCommissionDetailVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.CommissionDetailVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionDetailVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionDetailVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfCommissionVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.CommissionVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfInvestmentFundVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.InvestmentFundVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "InvestmentFundVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "InvestmentFundVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPartialSurrenderVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PartialSurrenderVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PartialSurrenderVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "PartialSurrenderVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPolicyAssessmentVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyAssessmentVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyAssessmentVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyAssessmentVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPolicyBaseInfoForDistVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForDistVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForDistVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPolicyBaseInfoForFAVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForFAVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForFAVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPolicyBaseInfoVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPolicyIssuedStatusVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyIssuedStatusVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyIssuedStatusVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyIssuedStatusVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPolicyTransactionVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyTransactionVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyTransactionVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyTransactionVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPOSRider");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.POSRider[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "POSRider");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "POSRider");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPOSVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.POSVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "POSVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "POSVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfProductRulesVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ProductRulesVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductRulesVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductRulesVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfProductVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ProductVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfPSAccountVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PSAccountVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PSAccountVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "PSAccountVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "String");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfSubDistributorBaseVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SubDistributorBaseVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorBaseVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorBaseVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfSubDistributorPolicyInfoVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorPolicyInfoVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorPolicyInfoVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfSwitchAccountVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SwitchAccountVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SwitchAccountVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "SwitchAccountVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfTopupAccountVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.TopupAccountVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "TopupAccountVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "TopupAccountVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfTransactionVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.TransactionVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "TransactionVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "TransactionVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ArrayOfUnitPriceVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.UnitPriceVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitPriceVO");
            qName2 = new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitPriceVO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ChangedPolicyMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ChangedPolicyMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ClaimSettlementMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ClaimSettlementMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ClaimSettlementVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ClaimSettlementVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionDetailVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.CommissionDetailVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.CommissionMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.CommissionVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "doPrintAnnualReportMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.DoPrintAnnualReportMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "InvestmentAcctValueVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.InvestmentAcctValueVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "InvestmentFundVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.InvestmentFundVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "LoginMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.LoginMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "LoginVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.LoginVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PartialSurrenderVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PartialSurrenderVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PerformanceRep1Msg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PerformanceRep1Msg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PerformanceRep2Msg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PerformanceRep2Msg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PersonalInfoMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PersonalInfoMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PersonalInfoVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PersonalInfoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyAssessmentMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyAssessmentMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyAssessmentVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyAssessmentVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForDistMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForDistVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForFAMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoForFAVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyBaseInfoVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyBaseInfoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyDetailMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyDetailMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyDetailVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyDetailVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyIssuedStatusMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyIssuedStatusMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyIssuedStatusVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyIssuedStatusVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyTransactionMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyTransactionMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyTransactionVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PolicyTransactionVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "POSRider");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.POSRider.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "POSVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.POSVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductInvestmentAccountMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ProductInvestmentAccountMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ProductMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductRulesMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ProductRulesMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductRulesVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ProductRulesVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ProductVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "PSAccountVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.PSAccountVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "ReturnMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.ReturnMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorBaseVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SubDistributorBaseVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorPolicyInfoMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorPolicyInfoVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorsListMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SubDistributorsListMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SurrenderDetailMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SurrenderDetailMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SurrenderDetailVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SurrenderDetailVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "SwitchAccountVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.SwitchAccountVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "TopupAccountVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.TopupAccountVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "TopUpPolicyMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.TopUpPolicyMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "TopUpVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.TopUpVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "TransactionDetailMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.TransactionDetailMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "TransactionDetailVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.TransactionDetailVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "TransactionVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.TransactionVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitPriceMsg");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.UnitPriceMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitPriceVO");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.UnitPriceVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("com.skandia.linkwebService", "xmlheader");
            cachedSerQNames.add(qName);
            cls = cn.com.sinosoft.common.service.axis.Xmlheader.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public cn.com.sinosoft.common.service.axis.LoginMsg login(java.lang.String clientNbr, java.lang.String password) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/login");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "login"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientNbr, password});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.LoginMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.LoginMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.LoginMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg getsp_createNBWithOut1StPremium(java.lang.String sessionId, java.lang.String theInput) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getsp_createNBWithOut1stPremium");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getsp_createNBWithOut1stPremium"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, theInput});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PolicyBaseInfoMsg getPolicyBaseInfo(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPolicyBaseInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyBaseInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PolicyBaseInfoMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PolicyBaseInfoMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PolicyBaseInfoMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistMsg getPolicyBaseInfoForDist(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPolicyBaseInfoForDist");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyBaseInfoForDist"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PolicyBaseInfoForDistMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PolicyDetailMsg getPolicyDetail(java.lang.String sessionId, java.lang.String policyNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPolicyDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PolicyDetailMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PolicyDetailMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PolicyDetailMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg revisionPinCode(java.lang.String sessionId, java.lang.String clientNbr, java.lang.String oldPass, java.lang.String newPass, java.lang.String comfirmNewPass) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/revisionPinCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "revisionPinCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr, oldPass, newPass, comfirmNewPass});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg saveTopUpPolicy(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String ivmtAcctType, java.lang.String topValue, cn.com.sinosoft.common.service.axis.TopupAccountVO[] acctList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/saveTopUpPolicy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "saveTopUpPolicy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, ivmtAcctType, topValue, acctList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PolicyAssessmentMsg getPolicyAssessment(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String date) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPolicyAssessment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyAssessment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, date});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PolicyAssessmentMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PolicyAssessmentMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PolicyAssessmentMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PolicyTransactionMsg getPolicyTransactionInfo(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String startDate, java.lang.String endDate, java.lang.String lob) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPolicyTransactionInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyTransactionInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, startDate, endDate, lob});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PolicyTransactionMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PolicyTransactionMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PolicyTransactionMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PersonalInfoMsg getPersonalInfo(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String role) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPersonalInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPersonalInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, role});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PersonalInfoMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PersonalInfoMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PersonalInfoMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg savePersonalInfo(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String role, cn.com.sinosoft.common.service.axis.PersonalInfoVO personalInfoVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/savePersonalInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "savePersonalInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, role, personalInfoVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.TopUpPolicyMsg getTopUpPolicy(java.lang.String sessionId, java.lang.String policyNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getTopUpPolicy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getTopUpPolicy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.TopUpPolicyMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.TopUpPolicyMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.TopUpPolicyMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg saveSwitchPolicy(java.lang.String sessionId, java.lang.String policyNbr, cn.com.sinosoft.common.service.axis.SwitchAccountVO[] alSwitch) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/saveSwitchPolicy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "saveSwitchPolicy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, alSwitch});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg saveAuthorizedDistributor(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String baseInfoAuthorizeYN, java.lang.String transRecordAuthorizeYN) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/saveAuthorizedDistributor");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "saveAuthorizedDistributor"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, baseInfoAuthorizeYN, transRecordAuthorizeYN});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg savePsByAccount(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String amtOrPercent, cn.com.sinosoft.common.service.axis.PSAccountVO[] surrenderValue) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/savePsByAccount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "savePsByAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, amtOrPercent, surrenderValue});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg savePartialSurrender(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String amtOrPercent, java.lang.String surrenderValue, java.lang.String reason) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/savePartialSurrender");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "savePartialSurrender"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, amtOrPercent, surrenderValue, reason});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.SurrenderDetailMsg getSurrenderPolicy(java.lang.String sessionId, java.lang.String policyNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getSurrenderPolicy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getSurrenderPolicy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.SurrenderDetailMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.SurrenderDetailMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.SurrenderDetailMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PerformanceRep1Msg getPerformanceRep1(java.lang.String sessionId, java.lang.String productCode, java.lang.String[] alIvmtAcctID, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPerformanceRep1");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPerformanceRep1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, productCode, alIvmtAcctID, startDate, endDate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PerformanceRep1Msg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PerformanceRep1Msg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PerformanceRep1Msg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg saveSurrenderPolicy(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String reason) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/saveSurrenderPolicy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "saveSurrenderPolicy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, reason});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.AnnualReportMsg getAnnualReport(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getAnnualReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getAnnualReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.AnnualReportMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.AnnualReportMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.AnnualReportMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.DoPrintAnnualReportMsg doPrintAnnualReport(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String annulRepID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/doPrintAnnualReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "doPrintAnnualReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, annulRepID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.DoPrintAnnualReportMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.DoPrintAnnualReportMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.DoPrintAnnualReportMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ProductMsg getProductList(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getProductList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getProductList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ProductMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ProductMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ProductMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ProductInvestmentAccountMsg getProductInvestmentAccount(java.lang.String sessionId, java.lang.String productCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getProductInvestmentAccount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getProductInvestmentAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, productCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ProductInvestmentAccountMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ProductInvestmentAccountMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ProductInvestmentAccountMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PerformanceRep2Msg getPerformanceRep2(java.lang.String sessionId, java.lang.String productCode, java.lang.String ivmtAcctID, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPerformanceRep2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPerformanceRep2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, productCode, ivmtAcctID, startDate, endDate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PerformanceRep2Msg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PerformanceRep2Msg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PerformanceRep2Msg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.UnitPriceMsg getUnitPrice(java.lang.String sessionId, java.lang.String productCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getUnitPrice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getUnitPrice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, productCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.UnitPriceMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.UnitPriceMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.UnitPriceMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PolicyIssuedStatusMsg getPolicyIssuedStatus(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPolicyIssuedStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyIssuedStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PolicyIssuedStatusMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PolicyIssuedStatusMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PolicyIssuedStatusMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ClaimSettlementMsg getClaimSettlement(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getClaimSettlement");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getClaimSettlement"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ClaimSettlementMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ClaimSettlementMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ClaimSettlementMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ChangedPolicyMsg getChangedPolicy(java.lang.String sessionId, java.lang.String policyNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getChangedPolicy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getChangedPolicy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ChangedPolicyMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ChangedPolicyMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ChangedPolicyMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.SubDistributorsListMsg getSubDistributorsList(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getSubDistributorsList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getSubDistributorsList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.SubDistributorsListMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.SubDistributorsListMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.SubDistributorsListMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoMsg getSubDistributorPolicyInfo(java.lang.String sessionId, java.lang.String distributorCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getSubDistributorPolicyInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getSubDistributorPolicyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, distributorCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.SubDistributorPolicyInfoMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.CommissionMsg getCommission(java.lang.String sessionId, java.lang.String clientNbr, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getCommission");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getCommission"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr, startDate, endDate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.CommissionMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.CommissionMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.CommissionMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.CommissionMsg getCommissions(java.lang.String sessionId, java.lang.String distributorCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getCommissions");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getCommissions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, distributorCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.CommissionMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.CommissionMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.CommissionMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ReturnMsg logout(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/logout");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "logout"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ReturnMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ReturnMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAMsg getPolicyBaseInfoForFA(java.lang.String sessionId, java.lang.String clientNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPolicyBaseInfoForFA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyBaseInfoForFA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, clientNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.PolicyBaseInfoForFAMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.TransactionDetailMsg getPolicyTransactionDetail(java.lang.String sessionId, java.lang.String policyNbr, java.lang.String transactionSeqNbr) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getPolicyTransactionDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getPolicyTransactionDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, policyNbr, transactionSeqNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.TransactionDetailMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.TransactionDetailMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.TransactionDetailMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.com.sinosoft.common.service.axis.ProductRulesMsg getProductRules() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("com.skandia.linkwebService/getProductRules");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("com.skandia.linkwebService", "getProductRules"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.sinosoft.common.service.axis.ProductRulesMsg) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.sinosoft.common.service.axis.ProductRulesMsg) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.sinosoft.common.service.axis.ProductRulesMsg.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}

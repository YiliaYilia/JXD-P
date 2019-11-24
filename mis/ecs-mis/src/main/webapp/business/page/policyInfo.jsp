<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/business/js/policy/policyInfo.js"></script>
<dict:script typeCode="SEX,IDTYPE,applicantAndInsured,RELACTIONTOINSURED,BeneficiaryTYPE"></dict:script>
<title>保单详情</title>

<script type="text/javascript">
	//基本信息
	policyInfo.basicData = [
            	{"name": "流水号", "group": "基本信息", "value": "${policy.flowno }"},
            	{"name": "保单号", "group": "基本信息", "value": "${policy.policycode }"},
            	{"name": "投保日期", "group": "基本信息", "value": "${policy.insuretime }"},
            	{"name": "生效日期", "group": "基本信息", "value": "${policy.takeeffecttime }"},
            	{"name": "截止日期", "group": "基本信息", "value": "${policy.deadlinetime }"},
            	{"name": "份数", "group": "基本信息", "value": "${policy.unitcount }"},
            	{"name": "保险期间", "group": "基本信息", "value": "${policy.policyterm }"},
            	{"name": "总保额", "group": "基本信息", "value": "${policy.sumamount }"},
            	{"name": "保费", "group": "基本信息", "value": "${policy.sumbasepremium }"},
            	{"name": "核保状态", "group": "基本信息", "value": dictTrans1("${policy.status }",'STATUS')},
            	{"name": "更新日期", "group": "基本信息", "value": "${policy.updatetime }"},
            	{"name": "续保银行", "group": "基本信息", "value": "${policy.bank }"},
            	{"name": "银行卡号", "group": "基本信息", "value": "${policy.bankaccountnumber }"},
            ];
	//投保人信息
	policyInfo.applicantData = [
				{"name": "姓名", "group": "${applicant.name }", "value": "${applicant.name }"},
				{"name": "性别", "group": "${applicant.name }", "value": dictTrans("${applicant.sex }",'SEX')},
				{"name": "出生日期", "group": "${applicant.name }", "value": "${applicant.birthday }"},
				{"name": "证件类型", "group": "${applicant.name }", "value": dictTrans("${applicant.identifytype }",'IDTYPE')},
				{"name": "证件号码", "group": "${applicant.name }", "value": "${applicant.identifynumber }"},
				{"name": "邮政编码", "group": "${applicant.name }", "value": "${applicant.zipcode }"},
				{"name": "手机", "group": "${applicant.name }", "value": "${applicant.mobile }"},
				{"name": "电子邮箱", "group": "${applicant.name }", "value": "${applicant.email }"},
				{"name": "家庭住址", "group": "${applicant.name }", "value": "${applicant.address }"},
				{"name": "备注", "group": "${applicant.name }", "value": "${applicant.remark }"}
			];
	//被保人信息
	<c:forEach items="${insureds }" var="insured">
		policyInfo.insuredData.push(
   				{"name": "姓名", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": "${insured.name }"},
   				{"name": "与投保人关系", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": dictTrans("${insured.insrelationapp}",'applicantAndInsured')},
				{"name": "性别", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": dictTrans("${insured.sex }",'SEX')},
				{"name": "出生日期", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": "${insured.birthday }"},
				{"name": "证件类型", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": dictTrans("${insured.identifytype }",'IDTYPE')},
				{"name": "证件号码", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": "${insured.identifynumber }"},
				{"name": "邮政编码", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": "${insured.zipcode }"},
				{"name": "手机", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": "${insured.mobile }"},
				{"name": "电子邮箱", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": "${insured.email }"},
				{"name": "家庭住址", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": "${insured.address }"},
				{"name": "备注", "group": "${insured.name } (证件号：${insured.identifynumber })", "value": "${insured.remark }"}
			);
	</c:forEach>
	//受益人信息
	<c:forEach items="${beneficiaries }" var="beneficiary">
		policyInfo.beneficiaryData.push(
   				{"name": "姓名", "group": "${beneficiary.benname } (证件号：${beneficiary.benidnumber })", "value": "${beneficiary.benname }"},
   				{"name": "与主被保人关系", "group": "${beneficiary.benname } (证件号：${beneficiary.benidnumber })", "value": dictTrans("${beneficiary.benrelationtopins }",'relactiontoinsured')}
			);
	</c:forEach>
	policyInfo.agentData = [
				{"name": "代码", "group": "代理人信息", "value": "${policy.agentcode }"},
				{"name": "姓名", "group": "代理人信息", "value": "${policy.agentname }"},
				{"name": "所属机构", "group": "代理人信息", "value": "${policy.departmentname }"}
	        ];
	$(document).ready(function(){
		//标记tab页是否打开过
		var isOpen = [false,false,false,false,false];
		$('#policyInfo').tabs({
			onSelect: function(title,index){
				if(!isOpen[index]){
					if(index == 0){
						policyInfo.loadBasic();
					}
					if(index == 1){
						policyInfo.loadApplicant();
					}
					if(index == 2){
						policyInfo.loadInsureds();
					}
					if(index == 3){
						policyInfo.loadBeneficiary();
					}
					if(index == 4){
						policyInfo.loadAgent();
					}
					isOpen[index] = true;
				}
			}
		});
	});
</script>
</head>
<body>
<div id="policyInfo" class="easyui-tabs" data-options="tabPosition:'top',fit:true,plain:true,border:false" >
	<div title="基本信息" data-options="fit:true">
		<table class="easyui-propertygrid" id="basic"></table>
	</div>
	<div title="投保人信息" data-options="fit:true">
		<table class="easyui-propertygrid" id="applicant"></table>
	</div>
	<div title="被保人信息" data-options="fit:true">
		<table class="easyui-propertygrid" id="insureds"></table>
	</div>
	<!-- <div title="受益人信息" data-options="fit:true">
		<table class="easyui-propertygrid" id="beneficiaries"></table>
	</div> -->
	<div title="代理人信息" data-options="fit:true">
		<table class="easyui-propertygrid" id="agent"></table>
	</div>
</div>
</body>
</html>
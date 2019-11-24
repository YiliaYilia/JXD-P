<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保单配置</title>
</head>
<body>

<!-- 弹出操作菜单项 -->
<div id="riskDutyMenu" class="easyui-menu" style="width:110px;display: none" data-options="onClick:riskDuty.selectMenu">
   	<div data-options="iconCls:'icon-add',name:'editRiskDutyMenu'" >险种责任配置</div>
   	 
</div>
<div id="riskMenu" class="easyui-menu" style="width:110px;display: none" data-options="onClick:riskDuty.selectMenu">
   	<div data-options="iconCls:'icon-add',name:'editRiskMenu'" >编辑产品险种</div>
   	<div data-options="iconCls:'icon-remove',name:'delRiskMenu'">删除产品险种</div> 
</div>

<div id="dutyMenu" class="easyui-menu" style="width:110px;display: none" data-options="onClick:riskDuty.selectMenu">
	<div data-options="iconCls:'icon-edit',name:'editDutyMenu'">编辑产品责任</div>
   	<div data-options="iconCls:'icon-remove',name:'delDutyMenu'">删除产品责任</div>
</div>

	
<div id="productInfoConfigTab" class="easyui-tabs" data-options="fit:true,tabPosition:'left',headerWidth:110">   

		<input type="hidden" name="coreproductcode" id="coreproductcode" value="${geProductMain.coreproductcode }" />
		<input type="hidden" name="businessarea" id="businessarea" value="${geProductMain.businessarea }" />
		<input type="hidden" name="geProductInsuredconfig.insuredconfigno" id="geProductInsuredconfig.insuredconfigno" value="${geProductInsuredconfig.insuredconfigno }" />
		
	   	<div title="险种责任配置" style="padding:20px;font-size: 13px;">
	   		<div>
	    		<table>
	    			<tr>
	    				<td valign="top">
	    					<div style="width: 420px;">
					    		<fieldset style="height: 100%">
								<legend>产品险种责任树</legend> 
									<ul id="riskButyTree" class="easyui-tree"></ul>
								</fieldset>
							</div>
	    				</td>
	    				<td valign="top">
	    					<div style="width: 480px;height: 580px;">
					    		<fieldset >
								<legend>险种责任信息</legend> 
									<iframe id="riskDutyInfo"  style="ovherflow-x:hidden;height:480px;width:100%;" name="riskDutyInfo"  frameborder="0" scrolling="auto"></iframe>
								</fieldset>
							</div>
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
	    </div>
	    
	    <div title="投保人配置" style="padding:20px;font-size: 13px;" class="applicantContentDiv">
	    <form action="${ctx }/system/product/saveOrUpdateApplicantConfig" method="post" id="applicantform" >
	    	<input type="hidden"  name="geProductApplicantconfig.appageflag" id="geProductApplicantconfig.appageflag" value="${geProductApplicantconfig.appageflag }" />
	    	<div style="width: 600px;">
	    		<fieldset>
					<legend>基本配置</legend>
	    			<table width="100%" cellpadding="1" cellspacing="1" border="0">
  						<c:if test="${not empty policyApplicantConfigBaseInfoList }">
	    					<c:set var="appInfoCount" value="0"></c:set>
	    					<c:forEach var="appDictData1" items="${policyApplicantConfigBaseInfoList}" varStatus="appStatus" step="2">
	    						<tr>
	    							<c:forEach var="appDictData2" items="${policyApplicantConfigBaseInfoList}" begin="${appStatus.index}" end="${appStatus.index+1}">
<!-- 		    						五要素必填 -->
			    						<c:if test="${appInfoCount<=4 }">
			    							<td width="100">
			    								<input type="checkbox" class="inputDataClass" name="geProductApplicantconfig.app${appDictData2.dictdatacode }" id="geProductApplicantconfig.app${appDictData2.dictdatacode }"  value="2" checked="checked"  onclick="return false;" >${appDictData2.dictdataname}:
			    							</td>
						    				<td width="200">
						    					<input type="checkbox" checked="checked" id="geProductApplicantconfig.app${appDictData2.dictdatacode}.value"   onclick="return false;"  >必填
						    				</td>
			    						</c:if>
<!-- 		    						非必填选项 -->
		    							<c:if test="${appInfoCount>4 }">
			    							<td width="100">
			    								<input type="checkbox" class="inputDataClass"  name="geProductApplicantconfig.app${appDictData2.dictdatacode }" id="geProductApplicantconfig.app${appDictData2.dictdatacode }" 
			    								
			    									onclick="bdpz.showRequeriedIterm(this,'appeficiary')"
				    								<c:set var="appMapKey" value="app${appDictData2.dictdatacode }" ></c:set>
				    								<c:choose>
			    										<c:when test="${empty geProductApplicantconfigMap }"></c:when>
			    										<c:when test="${geProductApplicantconfigMap[appMapKey]=='1'||geProductApplicantconfigMap[appMapKey]=='2'}"> checked="checked" value="${geProductApplicantconfigMap[appMapKey] }" </c:when>
			    										<c:otherwise></c:otherwise>
			    									</c:choose>
			    								/>${appDictData2.dictdataname}:
			    							</td>
						    				<td width="200">
						    					<input type="checkbox" id="geProductApplicantconfig.app${appDictData2.dictdatacode }.value" onclick="bdpz.changeValue(this)" 
						    						<c:choose>
			    										<c:when test="${empty geProductApplicantconfigMap }"></c:when>
			    										<c:when test="${empty geProductApplicantconfigMap[appMapKey] }"> disabled="disabled" </c:when>
			    										<c:when test="${geProductApplicantconfigMap[appMapKey]=='2'}"> checked="checked" </c:when>
			    										<c:otherwise></c:otherwise>
			    									</c:choose>
						    					/>必填
						    				</td>
		    							</c:if>
		    							<c:set var="appInfoCount" value="${appInfoCount+1 }"></c:set>
	    							</c:forEach>
	    						</tr>
	    					</c:forEach>
	    				</c:if>
	    			</table>
	    		</fieldset>
	    	</div>
	    	<br>
	    	<div style="width: 600px;">
				<fieldset>
					<legend>配置年龄区间</legend>
					
					<div style="height: 25px;">
						指定年龄区间
						<input type="checkbox" id="applicant_ageScopeCheckBox" name="applicant_ageScopeCheckBox"
 							<c:if test="${geProductApplicantconfig.appageflag!='0'}">
								checked="checked" 
							</c:if> 
				 		onclick="bdpz.show(this,'applicant');" />
					</div>
					<table width="100%" cellpadding="1" cellspacing="1" border="0" id="applicant_ageScopeTable">
	    				<tr>
	    					<td>
	    						起始时间：
	    						<input type="text" name="geProductApplicantconfig.appagestart" value="${geProductApplicantconfig.appagestart }" style="width: 30px">
	    						<dict:select typeCode="TIMETYPE" pleaseChoose="true" name="geProductApplicantconfig.appagestartattr" id="appagestartattr" defaultValue="${geProductApplicantconfig.appagestartattr }" style="width: 70px;height:22px;"></dict:select>
	    						终止时间：
	    						<input type="text" name="geProductApplicantconfig.appageend" value="${geProductApplicantconfig.appageend }" style="width: 30px">
	    						<dict:select typeCode="TIMETYPE" pleaseChoose="true" name="geProductApplicantconfig.appageendattr" id="appageendattr"  defaultValue="${geProductApplicantconfig.appageendattr}"  style="width: 70px;height:22px;"></dict:select>
	    					</td>
	    				</tr>
	    			</table>
	    			
				</fieldset>
	    	</div>
	    	<br>
	    	<div style="width: 600px;">
				<fieldset>
					<legend>性别配置</legend>
					<table width="100%" cellpadding="1" cellspacing="1" border="0">
	    				<tr>
	    					<td>
	    						<dict:checkbox type="checkbox" clazz="inputDataClass"  typeCode="SEX" name="geProductApplicantconfig.appsexconfig" defaultValue="${geProductApplicantconfig.appsexconfig}" ></dict:checkbox>
	    					</td>
	    				</tr>
	    			</table>
				</fieldset>
	    	</div>
	    	<br>
	    	<div style="width: 600px;">
				<fieldset>
					<legend>证件类型配置</legend>
					<table width="100%" cellpadding="1" cellspacing="1" border="0">
	    				<tr>
	    					<td>
	    						<dict:checkbox type="checkbox" typeCode="IDTYPE" clazz="inputDataClass" name="geProductApplicantconfig.appidtypeconfig"  defaultValue="${geProductApplicantconfig.appidtypeconfig}" brNumber="5"></dict:checkbox>
	    					</td>
	    				</tr>
	    			</table>
				</fieldset>
	    	</div>
    	    <a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-save'"  onclick="bdpz.submitform('applicant');">保存</a>
   			<a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-reload'"  onclick="bdpz.resetform('applicant');">重置</a>
	    </form>
	    </div>
	    <div title="被保人配置" style="padding:20px;font-size: 13px;" class="insuredContentDiv">
		    <form action="${ctx }/system/product/saveOrUpdateInsuredConfig" method="post" id="insuredform">
		    	<input type="hidden"  name="geProductInsuredconfig.insageflag" id="geProductInsuredconfig.insageflag" value="${geProductInsuredconfig.insageflag }" />
		    <div style="width: 600px;">
		    <fieldset>
			<legend>基本配置</legend>
				<table width="100%" cellpadding="1" cellspacing="1" border="0">
	   				<c:if test="${not empty policyInsuredConfigBaseInfoList }">
		   				<c:set var="insInfoCount" value="0"></c:set>
		   				<c:forEach var="insDictData1" items="${policyInsuredConfigBaseInfoList}" varStatus="insStatus" step="2">
		   					<tr>
		   						<c:forEach var="insDictData2" items="${policyInsuredConfigBaseInfoList}" begin="${insStatus.index}" end="${insStatus.index+1}">
		<!-- 		    						五要素必填 -->
		    						<c:if test="${insInfoCount<=4 }">
		    							<td width="150">
		    								<input type="checkbox" class="inputDataClass" name="geProductInsuredconfig.ins${insDictData2.dictdatacode }" id="geProductInsuredconfig.ins${insDictData2.dictdatacode }"  value="2" checked="checked"  onclick="return false;" >${insDictData2.dictdataname}:
		    							</td>
					    				<td width="200">
					    					<input type="checkbox" checked="checked" id="geProductInsuredconfig.ins${insDictData2.dictdatacode}.value"   onclick="return false;"  >必填
					    				</td>
		    						</c:if>
		<!-- 		    						非必填选项 -->
		    						<c:if test="${insInfoCount>4 }">
		    							<td width="150">
		    								<input type="checkbox" class="inputDataClass"  name="geProductInsuredconfig.ins${insDictData2.dictdatacode }" id="geProductInsuredconfig.ins${insDictData2.dictdatacode }" 
		    								
		    									onclick="bdpz.showRequeriedIterm(this,'insured')"
			    								<c:set var="insMapKey" value="ins${insDictData2.dictdatacode }" ></c:set>
			    								<c:choose>
		    										<c:when test="${empty geProductInsuredconfigMap }"></c:when>
		    										<c:when test="${geProductInsuredconfigMap[insMapKey]=='1'||geProductInsuredconfigMap[insMapKey]=='2'}"> checked="checked" value="${geProductInsuredconfigMap[insMapKey] }" </c:when>
		    										<c:otherwise></c:otherwise>
		    									</c:choose>
		    								/>${insDictData2.dictdataname}:
		    							</td>
		    							
					    				<td width="200">
					    					<input type="checkbox" id="geProductInsuredconfig.ins${insDictData2.dictdatacode }.value" onclick="bdpz.changeValue(this)" 
					    						<c:choose>
		    										<c:when test="${empty geProductInsuredconfigMap }"></c:when>
		    										<c:when test="${empty geProductInsuredconfigMap[insMapKey] }"> disabled="disabled" </c:when>
		    										<c:when test="${geProductInsuredconfigMap[insMapKey]=='2'}"> checked="checked" </c:when>
		    										<c:otherwise></c:otherwise>
		    									</c:choose>
					    					/>必填
					    				</td>
		    						</c:if>
		    						<c:set var="insInfoCount" value="${insInfoCount+1 }"></c:set>
		   						</c:forEach>
		   					</tr>
		   				</c:forEach>
		   			</c:if>
		    	</table>
		    </fieldset>
		    </div>
		    <div style="width: 600px;">
			    <br>
				<fieldset>
					<legend>配置年龄区间</legend>
					<div style="height: 25px;">
							指定年龄区间<input type="checkbox" id="insured_ageScopeCheckBox" name="insured_ageScopeCheckBox" 
							<c:if test="${geProductInsuredconfig.insageflag!='0'}">
								checked="checked" 
							</c:if>
							onclick="bdpz.show(this,'insured');" />
					</div>
					<table width="100%" cellpadding="1" cellspacing="1" border="0" id="insured_ageScopeTable">
	    				<tr>
	    					<td>
	    						起始时间：
	    						<input type="text" name="geProductInsuredconfig.inagestart" value="${geProductInsuredconfig.inagestart }" style="width: 30px">
	    						<dict:select typeCode="TIMETYPE" pleaseChoose="true" name="geProductInsuredconfig.inagestartattr" id="inagestartattr" defaultValue="${geProductInsuredconfig.inagestartattr }" style="width: 70px;height:22px;"></dict:select>
	    						终止时间：
	    						<input type="text" name="geProductInsuredconfig.inageend" value="${geProductInsuredconfig.inageend }" style="width: 30px">
	    						<dict:select typeCode="TIMETYPE" pleaseChoose="true" name="geProductInsuredconfig.inageendattr" id="inageendattr"  defaultValue="${geProductInsuredconfig.inageendattr }"  style="width: 70px;height:22px;"></dict:select>
	
	    					</td>
	    				</tr>
	    			</table>
				</fieldset>
		    </div>
		    	<div style="width: 600px;">
			    <br>
					<fieldset>
						<legend>性别配置</legend>
						<table width="100%" cellpadding="1" cellspacing="1" border="0">
		    				<tr>
		    					<td>
		    						<dict:checkbox type="checkbox" clazz="inputDataClass"  typeCode="SEX" name="geProductInsuredconfig.inssexconfig" defaultValue="${geProductInsuredconfig.inssexconfig }" ></dict:checkbox>
		    					</td>
		    				</tr>
		    			</table>
					</fieldset>
		    	</div>
		    	<div style="width: 600px;">
			    	<br>
					<fieldset>
						<legend>证件类型配置</legend>
						<table width="100%" cellpadding="1" cellspacing="1" border="0">
		    				<tr>
		    					<td>
		    						<dict:checkbox type="checkbox" typeCode="IDTYPE"  clazz="inputDataClass"  name="geProductInsuredconfig.insidtypeconfig"  defaultValue="${geProductInsuredconfig.insidtypeconfig}" brNumber="5"></dict:checkbox>
		    					</td>
		    				</tr>
		    			</table>
					</fieldset>
		    	</div>
 	   	    	<div style="width: 600px;display: none;" id="insuredinsrelationtoappconfigDiv" >
			    	<br>
					<fieldset>
						<legend>与被保人关系配置</legend>
						<table width="100%" cellpadding="1" cellspacing="1" border="0">
		    				<tr>
		    					<td>
		    						<dict:checkbox type="checkbox" typeCode="applicantAndInsured"  clazz="inputDataClass"  name="geProductInsuredconfig.insrelationtoappconfig" defaultValue="${geProductInsuredconfig.insrelationtoappconfig }"  brNumber="5"></dict:checkbox>
		    					</td>
		    				</tr>
		    			</table>
					</fieldset>
		    	</div>	
 		   	    <div style="width: 600px;display: none;" id="insuredfinsrelationtoappconfigDiv" >
			    	<br>
					<fieldset>
						<legend>与主被保人关系配置</legend>
						<table width="100%" cellpadding="1" cellspacing="1" border="0">
		    				<tr>
		    					<td>
		    						<dict:checkbox type="checkbox" typeCode="applicantAndInsured"  clazz="inputDataClass"  name="geProductInsuredconfig.finsrelationtoappconfig" defaultValue="${geProductInsuredconfig.finsrelationtoappconfig }"  brNumber="5"></dict:checkbox>
		    					</td>
		    				</tr>
		    			</table>
					</fieldset>
		    	</div>
		    	<div style="width: 600px;display: none;" id="geProductInsuredconfig.insoccupation_div" >
			    	<br>
					<fieldset>
<!-- 					style="background:transparent;border:0;width: 0px" -->
						<legend>职业类别配置<input type="text" id="occupationType" name="occupationType"  style="background:transparent;border:0;width: 0px"  /></legend>
						<ul id="OccupationTree" class="easyui-tree"></ul>
					</fieldset>
		    	</div>
		    	<br>	    
	    	    <a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-save'"  onclick="bdpz.submitform('insured');">保存</a>
	   			<a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-reload'"  onclick="bdpz.resetform('insured');">重置</a>
		    </form>
	    </div>
	    
	    <c:if test="${geProductMain.issupportbeneficiary=='1'}">
		    <div title="受益人配置" style="padding:20px;font-size: 13px;"  class="beneficiaryContentDiv">
		    <form action="${ctx }/system/product/saveOrUpdateBeneficiaryConfig" method="post" id="beneficiaryform">
			    	<div style="width: 600px;">
		    		<fieldset>
						<legend>基本配置</legend>
			    		<table width="100%" cellpadding="1" cellspacing="1" border="0">
			    			<c:if test="${not empty policyBeneficiaryConfigBaseInfoList }">
			    				<c:set var="benInfoCount" value="0"></c:set>
			    				<c:forEach var="benDictData1" items="${policyBeneficiaryConfigBaseInfoList}" varStatus="benStatus" step="2">
			    					<tr>
			    						<c:forEach var="benDictData2" items="${policyBeneficiaryConfigBaseInfoList}" begin="${benStatus.index}" end="${benStatus.index+1}">
		<!-- 		    						五要素必填 -->
				    						<c:if test="${benInfoCount<=4 }">
				    							<td width="150">
				    								<input type="checkbox" class="inputDataClass" name="geProductBeneficiaryconfig.ben${benDictData2.dictdatacode }" id="geProductBeneficiaryconfig.ben${benDictData2.dictdatacode }"  value="2" checked="checked"  onclick="return false;" >${benDictData2.dictdataname}:
				    							</td>
							    				<td width="200">
							    					<input type="checkbox" checked="checked" id="geProductBeneficiaryconfig.ben${benDictData2.dictdatacode}.value"   onclick="return false;"  >必填
							    				</td>
				    						</c:if>
		<!-- 		    						非必填选项 -->
				    						<c:if test="${benInfoCount>4 }">
				    							<td width="150">
				    								<input type="checkbox" class="inputDataClass"  name="geProductBeneficiaryconfig.ben${benDictData2.dictdatacode }" id="geProductBeneficiaryconfig.ben${benDictData2.dictdatacode }" 
				    								
				    									onclick="bdpz.showRequeriedIterm(this,'beneficiary')"
					    								<c:set var="benMapKey" value="ben${benDictData2.dictdatacode }" ></c:set>
					    								<c:choose>
				    										<c:when test="${empty geProductBeneficiaryconfigMap }"></c:when>
				    										<c:when test="${geProductBeneficiaryconfigMap[benMapKey]=='1'||geProductBeneficiaryconfigMap[benMapKey]=='2'}"> checked="checked" value="${geProductBeneficiaryconfigMap[benMapKey] }" </c:when>
				    										<c:otherwise></c:otherwise>
				    									</c:choose>
				    								/>${benDictData2.dictdataname}:
				    							</td>
							    				<td width="200">
							    					<input type="checkbox" id="geProductBeneficiaryconfig.ben${benDictData2.dictdatacode }.value" onclick="bdpz.changeValue(this)" 
							    						<c:choose>
				    										<c:when test="${empty geProductBeneficiaryconfigMap }"></c:when>
				    										<c:when test="${empty geProductBeneficiaryconfigMap[benMapKey] }"> disabled="disabled" </c:when>
				    										<c:when test="${geProductBeneficiaryconfigMap[benMapKey]=='2'}"> checked="checked" </c:when>
				    										<c:otherwise></c:otherwise>
				    									</c:choose>
							    					/>必填
							    				</td>
				    						</c:if>
				    						<c:set var="benInfoCount" value="${benInfoCount+1 }"></c:set>
			    						</c:forEach>
			    					</tr>
			    				</c:forEach>
			    			</c:if>
			    		</table>
		    		</fieldset>
		    	</div>
		    	<br>
		    	<div style="width: 600px;">
					<fieldset>
						<legend>性别配置</legend>
						<table width="100%" cellpadding="1" cellspacing="1" border="0">
		    				<tr>
		    					<td>
		    						<dict:checkbox type="checkbox" clazz="inputDataClass"  typeCode="SEX" name="geProductBeneficiaryconfig.bensexconfig" defaultValue="${geProductBeneficiaryconfig.bensexconfig }" ></dict:checkbox>
		    					</td>
		    				</tr>
		    			</table>
					</fieldset>
		    	</div>
		    	<br>
		    	<div style="width: 600px;">
					<fieldset>
						<legend>证件类型配置</legend>
						<table width="100%" cellpadding="1" cellspacing="1" border="0">
		    				<tr>
		    					<td>
		    						<dict:checkbox type="checkbox" typeCode="IDTYPE"  clazz="inputDataClass"  name="geProductBeneficiaryconfig.benidtypeconfig"  defaultValue="${geProductBeneficiaryconfig.benidtypeconfig}" brNumber="5"></dict:checkbox>
		    					</td>
		    				</tr>
		    			</table>
					</fieldset>
		    	</div>
		    	<br>
   	    		<div style="width: 600px;display: none;" id="beneficiaryrelationtopinsDiv" >
					<fieldset>
						<legend>与被保人关系配置</legend>
						<table width="100%" cellpadding="1" cellspacing="1" border="0">
		    				<tr>
		    					<td>
		    						<dict:checkbox type="checkbox" typeCode="RELACTIONTOINSURED"  clazz="inputDataClass"  name="geProductBeneficiaryconfig.benrelationtopinsconfig" defaultValue="${geProductBeneficiaryconfig.benrelationtopinsconfig }"  brNumber="5"></dict:checkbox>
		    					</td>
		    				</tr>
		    			</table>
					</fieldset>
		    	</div>	
	    	    <a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-save'"  onclick="bdpz.submitform('beneficiary');">保存</a>
    			<a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-reload'"  onclick="bdpz.resetform('beneficiary');">重置</a>
		    </form>	    
		    </div>
	    
	    </c:if>
	    <c:if test="${geProductMain.issupportemergency=='1' }">
		    <div title="紧急联系人配置" style="padding:20px;font-size: 13px;" class="emergencyContentDiv">
		    <form action="${ctx }/system/product/saveOrUpdateEmergencyConfig"  method="post" id="emergencyform">
	    		<div style="width: 600px;">
	    		<fieldset>
	    		<table width="100%" cellpadding="1" cellspacing="1" border="0">
	    			<tr>
	    	    		<td width="100">
	    					<input type="checkbox" checked="checked" class="inputDataClass" onclick="return false;" id="geProductEmergencyConfig.emername"  name="geProductEmergencyConfig.emername" value="2" >姓名:
	    				</td>
	    				<td width="200">
	    					<input type="checkbox" id="geProductEmergencyConfig.emername.value"  name="geProductEmergencyConfig.emername.value" checked="checked" onclick="bdpz.changeValue(this)">必填
	    				</td>
	    				
	    				<td>
		    				<input type="checkbox"  class="inputDataClass" id="geProductEmergencyConfig.mobile"  name="geProductEmergencyConfig.mobile" value="0" onclick="bdpz.showRequeriedIterm(this)"> 移动电话:
		    			</td>
		    			<td>
		    				<input type="checkbox" id="geProductEmergencyConfig.mobile.value"  name="geProductEmergencyConfig.mobile.value" disabled="disabled" onclick="bdpz.changeValue(this)">必填
		    			</td>
	    			</tr>
	    			<tr>
	    				<td>
	    					<input type="checkbox"  class="inputDataClass" id="geProductEmergencyConfig.emeremail" name="geProductEmergencyConfig.emeremail" value="0" onclick="bdpz.showRequeriedIterm(this)">电子邮箱:
	    				</td>
	    				<td>
	    					<input type="checkbox"  id="geProductEmergencyConfig.emeremail.value" name="geProductEmergencyConfig.emeremail.value" disabled="disabled" onclick="bdpz.changeValue(this)">必填
	    				</td>
	    				<td>
	    					&nbsp;
	    				</td>
	    				<td>
	    					&nbsp;
	    				</td>
	    			</tr>    			
	    			
	    		</table>
	    		</fieldset>
	    		</div>
		    	    <a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-save'"  onclick="bdpz.submitform('emergency');">保存</a>
	    			<a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-reload'"  onclick="bdpz.resetform('emergency');">重置</a>
		    </form>	    
		    </div>	    
	    </c:if>
	    
	    <div title="收件人配置" style="padding:20px;font-size: 13px;" class="addresseeContentDiv">
	    <form action="${ctx }/system/product/saveOrUpdateAddresseeConfig" method="post" id="addresseeform">
    		<div style="width: 600px;">
    		<fieldset>
    		<table width="100%" cellpadding="1" cellspacing="1" border="0">
    			<tr>
    	    		<td width="100">
    					<input type="checkbox" checked="checked" class="inputDataClass" onclick="return false;" id="geAddresseeConfig.consigneename" value="2" name="geAddresseeConfig.consigneename">姓名:
    				</td>
    				<td width="200">
    					<input type="checkbox" checked="checked" onclick="return false;"  id="geAddresseeConfig.consigneename.value" name="geAddresseeConfig.consigneename.value"　>必填
    				</td>
    				
    				<td>
	    				<input type="checkbox" checked="checked" class="inputDataClass" onclick="return false;" id="geAddresseeConfig.telephone" value="2"  name="geAddresseeConfig.telephone">联系电话:
	    			</td>
	    			<td>
	    				<input type="checkbox" checked="checked" onclick="return false;"  id="geAddresseeConfig.telephone.value" name="geAddresseeConfig.telephone.value">必填
	    			</td>
    			</tr>
    			<tr>
    				<td>
    					<input type="checkbox" checked="checked"  class="inputDataClass" onclick="return false;" id="geAddresseeConfig.consigneeaddress" value="2"  name="geAddresseeConfig.consigneeaddress">收件地址:
    				</td>
    				<td>
    					<input type="checkbox" checked="checked" onclick="return false;"  id="geAddresseeConfig.consigneeaddress.value" name="geAddresseeConfig.consigneeaddress.value" >必填
    				</td>
    				<td>
    					<input type="checkbox" checked="checked"   class="inputDataClass" onclick="return false;" id="geAddresseeConfig.zipcode" value="2"  name="geAddresseeConfig.zipcode">邮政编码:
    				</td>
    				<td>
    				    <input type="checkbox" checked="checked" onclick="return false;"  id="geAddresseeConfig.zipcode.value" name="geAddresseeConfig.zipcode.value" >必填
    				</td>
    			</tr>    			
    			
    			<tr>
    				<td>
    					<input type="checkbox" class="inputDataClass" onclick="bdpz.showRequeriedIterm(this)" id="geAddresseeConfig.fixedphone" value="0"  name="geAddresseeConfig.fixedphone">固定电话:
    				</td>
    				<td>
    					<input type="checkbox"  onclick="bdpz.changeValue(this)" id="geAddresseeConfig.fixedphone.value" name="geAddresseeConfig.fixedphone.value" disabled="disabled">必填
    				</td>
    				<td>
    					<input type="checkbox" class="inputDataClass" onclick="bdpz.showRequeriedIterm(this)" id="geAddresseeConfig.province" value="0"  name="geAddresseeConfig.province">省:
    				</td>
    				<td>
    					<input type="checkbox"  onclick="bdpz.changeValue(this)" id="geAddresseeConfig.province.value" name="geAddresseeConfig.province.value" disabled="disabled">必填
    				</td>
    			</tr>    			
    			
    			<tr>
    				<td>
    					<input type="checkbox" class="inputDataClass" onclick="bdpz.showRequeriedIterm(this)" id="geAddresseeConfig.city" value="0"  name="geAddresseeConfig.city">市:
    				</td>
    				<td>
    					<input type="checkbox" onclick="bdpz.changeValue(this)"  id="geAddresseeConfig.city.value" name="geAddresseeConfig.city.value" disabled="disabled">必填
    				</td>
    				<td>
    					<input type="checkbox" class="inputDataClass" onclick="bdpz.showRequeriedIterm(this)" id="geAddresseeConfig.county" value="0"  name="geAddresseeConfig.county">区/县:
    				</td>
    				<td>
    					<input type="checkbox"  onclick="bdpz.changeValue(this)" id="geAddresseeConfig.county.value" name="geAddresseeConfig.county.value" disabled="disabled">必填
    				</td>
    			</tr>    			
    			
    			<tr>
    				<td>
    					<input type="checkbox" class="inputDataClass" onclick="bdpz.showRequeriedIterm(this)" id="geAddresseeConfig.email" value="0"  name="geAddresseeConfig.email">电子邮箱:
    				</td>
    				<td>
    					<input type="checkbox"  onclick="bdpz.changeValue(this)" id="geAddresseeConfig.email.value" name="geAddresseeConfig.email.value" disabled="disabled">必填
    				</td>
    				<td>
    					<input type="checkbox" class="inputDataClass" onclick="bdpz.showRequeriedIterm(this)"  id="geAddresseeConfig.consigneeconfig" value="0" name="geAddresseeConfig.consigneeconfig">配送信息:
    				</td>
    				<td>
    					<input type="checkbox" onclick="bdpz.changeValue(this)"  id="geAddresseeConfig.consigneeconfig.value" name="geAddresseeConfig.consigneeconfig.value" disabled="disabled">必填
    				</td>
    			</tr>    			


    			<tr>
    				<td>
    					<input type="checkbox" class="inputDataClass" onclick="bdpz.showRequeriedIterm(this)"  id="geAddresseeConfig.remark" value="0" name="geAddresseeConfig.remark">备注:
    				</td>
    				<td>
    					<input type="checkbox" onclick="bdpz.changeValue(this)"  id="geAddresseeConfig.remark.value" name="geAddresseeConfig.remark.value" disabled="disabled">必填
    				</td>
    				<td>
    					&nbsp;
    				</td>
    				<td>
    					&nbsp;
    				</td>
    			</tr>
    			
    		</table>
    		</fieldset>
    		</div>
   
	    	    <a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-save'"  onclick="bdpz.submitform('addressee');">保存</a>
    			<a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-reload'"  onclick="bdpz.resetform('addressee');">重置</a>
	    </form>	    
	    </div>
</div>

<!-- 弹出添加操作窗口 --> 
<div id="riskButy_add_window" style="width: 260px;height: 480px;display: none;background-color: #DDEDDC;font-size: 15px;padding: 10px;">   
<script type="text/javascript">
var bdpz = new BdpzPage();
bdpz.ctx="${ctx}";
var riskDuty = new RiskDuty();
riskDuty.ctx="${ctx}";
$(document).ready(function(){
	initializeRiskDuty();
	initializeData();
	riskDuty.initCheckRiskDuty();
	bdpz.initPage();
	//投保人  被保人   是否指定年龄区间
	bdpz.changeAgeScope($("input[id='geProductApplicantconfig.appageflag']").get(0),"applicant","${geProductApplicantconfig.appageflag }"!="0");
	bdpz.changeAgeScope($("input[id='geProductInsuredconfig.insageflag']").get(0),"insured","${geProductInsuredconfig.insageflag }"!="0");
	
	policyConfigLoadCount++;
	//该方法在elements.jsp 记录加载保单配置加载次数,为了刷新每次点击刷新本页面
	loadPolicyConfig();
});


/**
 * 初始化时选中 险种或者责任的操作
 */
 function loadRightClicked(item){
	var node = $('#riskButyTree').tree('getSelected');	
	var id = node.id;
	var idArr = id.split("#");
	var type = idArr[0];
	id = idArr[1];
	var param = "?type="+type+"&riskNo="+id+"&dutyNo="+id+"&operation=edit";
	if(item.name=='editRiskMenu'){
		$("#riskDutyInfo").attr("src","${ctx}/system/product/checkOrEditRiskDuty"+param);
	}else if(item.name=='delRiskMenu'){
		riskDuty.delRiskOrDuty(node);
	}else if(item.name=='editDutyMenu'){
		$("#riskDutyInfo").attr("src","${ctx}/system/product/checkOrEditRiskDuty"+param);
	}else if(item.name=='delDutyMenu'){
		riskDuty.delRiskOrDuty(node);
	}
};





function initializeRiskDuty(){
	var coreproductcode = $("#coreproductcode").val();
	var businessarea = $("#businessarea").val();
	var data = "coreproductcode=" + coreproductcode + "&businessarea=" + businessarea + "&date="+new Date();;
	
	$.ajax({
		type:"POST",
		url:"${ctx}/system/product/queryRiskDutyTree?date="+new Date(),
		data:data,
		success:function(data){
			
			$('#riskButyTree').tree({    
				data: convert(data),
				animate:true,
				lines:true,
				checkbox:false,
				onContextMenu:function(event,node){ //弹出菜单按钮
					
					RiskDuty.checkNode = node;
					var id = node.id;
					var divStr = "";
					if(id.indexOf("product#") > -1){
						divStr = "#riskDutyMenu";
					}else if(id.indexOf("risk#") > -1){
						divStr = "#riskMenu";
					}else if(id.indexOf("duty#") > -1){
						divStr = "#dutyMenu";
					}
					
			    	event.preventDefault();
					// select the node
					$('#riskButyTree').tree('select', node.target);
					// display context menu
					
					$(divStr).menu('show', {
						left: event.pageX,
						top: event.pageY
					});
					
			    }
			});
			
			$('#riskButyTree').tree('expandAll');
			
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}

/**
 * 初始化紧急联系人与收件人
 */
function initializeData (){
	
	if("${geProductMain.issupportemergency}"=="1"){
		//紧急联系人配置初始化
		var emerName = '${geProductEmergencyConfigDB.emername}';
		if(emerName==2){
			$("input[id='geProductEmergencyConfig.emername']").attr("checked",true);
			document.getElementById("geProductEmergencyConfig.emername.value").disabled = false;
			$("input[id='geProductEmergencyConfig.emername.value']").attr("checked",true);
			$("input[id='geProductEmergencyConfig.emername']").attr("value","2");
		}else if(emerName==1){
			$("input[id='geProductEmergencyConfig.emername']").attr("checked", true);
			document.getElementById("geProductEmergencyConfig.emername.value").disabled = false;
			$("input[id='geProductEmergencyConfig.emername']").attr("value","1");
		}	
		
		var emerMobile = '${geProductEmergencyConfigDB.mobile}';
		if(emerMobile==2){
			$("input[id='geProductEmergencyConfig.mobile']").attr("checked",true);
			document.getElementById("geProductEmergencyConfig.mobile.value").disabled = false;
			$("input[id='geProductEmergencyConfig.mobile.value']").attr("checked",true);
			$("input[id='geProductEmergencyConfig.mobile']").attr("value","2");
		}else if(emerMobile==1){
			$("input[id='geProductEmergencyConfig.mobile']").attr("checked", true);
			document.getElementById("geProductEmergencyConfig.mobile.value").disabled = false;
			$("input[id='geProductEmergencyConfig.mobile']").attr("value","1");
		}	
		
		var emerEmail = '${geProductEmergencyConfigDB.emeremail}';
		if(emerEmail==2){
			$("input[id='geProductEmergencyConfig.emeremail']").attr("checked",true);
			document.getElementById("geProductEmergencyConfig.emeremail.value").disabled = false;
			$("input[id='geProductEmergencyConfig.emeremail.value']").attr("checked",true);
			$("input[id='geProductEmergencyConfig.emeremail']").attr("value","2");
		}else if(emerEmail==1){
			$("input[id='geProductEmergencyConfig.emeremail']").attr("checked", true);
			document.getElementById("geProductEmergencyConfig.emeremail.value").disabled = false;
			$("input[id='geProductEmergencyConfig.emeremail']").attr("value","1");
		}	
	}
	
	
	//收件人配置
	var fixedPhone = '${geAddresseeConfigDB.fixedphone}';
	if(fixedPhone==2){
		$("input[id='geAddresseeConfig.fixedphone']").attr("checked",true);
		document.getElementById("geAddresseeConfig.fixedphone.value").disabled = false;
		$("input[id='geAddresseeConfig.fixedphone.value']").attr("checked",true);
		$("input[id='geAddresseeConfig.fixedphone']").attr("value","2");
	}else if(fixedPhone==1){
		$("input[id='geAddresseeConfig.fixedphone']").attr("checked", true);
		document.getElementById("geAddresseeConfig.fixedphone.value").disabled = false;
		$("input[id='geAddresseeConfig.fixedphone']").attr("value","1");
	}
	
	var province =  '${geAddresseeConfigDB.province}';
	if(province==2){
		$("input[id='geAddresseeConfig.province']").attr("checked",true);
		document.getElementById("geAddresseeConfig.province.value").disabled = false;
		$("input[id='geAddresseeConfig.province.value']").attr("checked",true);
		$("input[id='geAddresseeConfig.province']").attr("value","2");
	}else if(province==1){
		$("input[id='geAddresseeConfig.province']").attr("checked", true);
		document.getElementById("geAddresseeConfig.province.value").disabled = false;
		$("input[id='geAddresseeConfig.province']").attr("value","1");
	}
	
	
	var city = '${geAddresseeConfigDB.city}';
	if(city==2){
		$("input[id='geAddresseeConfig.city']").attr("checked",true);
		document.getElementById("geAddresseeConfig.city.value").disabled = false;
		$("input[id='geAddresseeConfig.city.value']").attr("checked",true);
		$("input[id='geAddresseeConfig.city']").attr("value","2");
	}else if(city==1){
		$("input[id='geAddresseeConfig.city']").attr("checked", true);
		document.getElementById("geAddresseeConfig.city.value").disabled = false;
		$("input[id='geAddresseeConfig.city']").attr("value","1");
	}
	

	var county = '${geAddresseeConfigDB.county}';
		if(county==2){
			$("input[id='geAddresseeConfig.county']").attr("checked",true);
			document.getElementById("geAddresseeConfig.county.value").disabled = false;
			$("input[id='geAddresseeConfig.county.value']").attr("checked",true);
			$("input[id='geAddresseeConfig.county']").attr("value","2");
		}else if(county==1){
			$("input[id='geAddresseeConfig.county']").attr("checked", true);
			document.getElementById("geAddresseeConfig.county.value").disabled = false;
			$("input[id='geAddresseeConfig.county']").attr("value","1");
		}
		
		var email = '${geAddresseeConfigDB.email}';
		if(email==2){
			$("input[id='geAddresseeConfig.email']").attr("checked",true);
			document.getElementById("geAddresseeConfig.email.value").disabled = false;
			$("input[id='geAddresseeConfig.email.value']").attr("checked",true);
			$("input[id='geAddresseeConfig.email']").attr("value","2");
		}else if(email==1){
			$("input[id='geAddresseeConfig.email']").attr("checked", true);
			document.getElementById("geAddresseeConfig.email.value").disabled = false;
			$("input[id='geAddresseeConfig.email']").attr("value","1");
		}
		
		
		var consigneeConfig = '${geAddresseeConfigDB.consigneeconfig}';
		if(consigneeConfig==2){
			$("input[id='geAddresseeConfig.consigneeconfig']").attr("checked",true);
			document.getElementById("geAddresseeConfig.consigneeconfig.value").disabled = false;
			$("input[id='geAddresseeConfig.consigneeconfig.value']").attr("checked",true);
			$("input[id='geAddresseeConfig.consigneeconfig']").attr("value","2");
		}else if(consigneeConfig==1){
			$("input[id='geAddresseeConfig.consigneeconfig']").attr("checked", true);
			document.getElementById("geAddresseeConfig.consigneeconfig.value").disabled = false;
			$("input[id='geAddresseeConfig.consigneeconfig']").attr("value","1");
		}
		
		var remark = '${geAddresseeConfigDB.remark}';
		if(remark==2){
			$("input[id='geAddresseeConfig.remark']").attr("checked",true);
			document.getElementById("geAddresseeConfig.remark.value").disabled = false;
			$("input[id='geAddresseeConfig.remark.value']").attr("checked",true);
			$("input[id='geAddresseeConfig.remark']").attr("value","2");
		}else if(remark==1){
			$("input[id='geAddresseeConfig.remark']").attr("checked", true);
			document.getElementById("geAddresseeConfig.remark.value").disabled = false;
			$("input[id='geAddresseeConfig.remark']").attr("value","1");
		}
	
	
}


</script>
</body>
</html>
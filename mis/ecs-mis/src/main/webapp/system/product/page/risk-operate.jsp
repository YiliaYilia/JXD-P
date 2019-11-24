<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/product/js/risk.js"></script>

<style>
	body{
		font-size: 13px;
		font-family:Simsun;
	}
	input, select {
 	width:200px;
 }
</style>
<dict:script typeCode="BUSINESSAREA"></dict:script>
</head>
<body>
<script type="text/javascript">


$(document).ready(function(){
	risk.ctx='${ctx}';
	risk.formValidate();

	if($('#opeartype').val() == 'VIEW'){
		$("input").each(function(){
			 $(this).attr("readonly","readonly");
			 //$(this).css("border",0);
			 //$(this).css("background","transparent");
		}); 
		
		$("select").each(function(i,e){
			  $(this).attr("disabled","disabled");
			  $(this).css("display","none");
			  
			  var obj = $(e);
			  var text = obj.find("option:selected").text();
			  $(this).before(text);
		}); 
		
	}
	
	if($('#opeartype').val() == 'ADD'){
		$("#showCode").hide();
	}
	
	
});



		
</script>

	
	
	
	<div id="risk_operate" class="easyui-tabs" data-options="border:false,plain:true" style="width:620px;height:330px;"> 
			<div title="险种信息" style="overflow:hidden;" data-options="singleSelect:true" > 
			<fieldset>
			<legend><strong>险种信息:</strong></legend>
			<form  name="addUpdateRiskForm" id="addUpdateRiskForm" autocomplete="off" enctype="multipart/form-data" data-validator-option="{theme: 'yellow_right',timely:1}">
				<table style="margin-top: 5px;" >
					<tr>
						<td class="tabLeft" nowrap>险种代码： </td>
						<td class="" width="400px">
							<input type="text" id="showCode" value="${geRisk.riskcode }" readonly='readonly'/>
					  		<input value="${geRisk.riskcode }" <c:if test="${geRisk.riskcode != null }">type="hidden"</c:if> 
					  		<c:if test="${geRisk.riskcode == null }">type="text"</c:if> name="geRisk.riskcode" id="riskcode">
						</td>
					</tr>
					<tr>
						<td class="tabLeft" nowrap>险种名称：</td>
						<td class="" >
							<input type="text" id="riskname" name="geRisk.riskname"  value="${geRisk.riskname}" />
						</td>
					</tr>
					<tr>
						<td class="tabLeft" nowrap>险种简称：</td>
						<td class="" >
							<input type="text" id="risksimplename" name="geRisk.risksimplename"  value="${geRisk.risksimplename}" />
						</td>
					</tr>
					<tr>
						<td class="tabLeft" nowrap>核心险种代码： </td>
						<td class="" >
							<input type="text" id="coreriskcode" name="geRisk.coreriskcode"  value="${geRisk.coreriskcode}" />
						</td>
					</tr>
					<tr>
						<td class="tabLeft" nowrap>主附险标志：</td>
						<td class="" >
							<select id="riskmark" name="geRisk.riskmark" class="selectDataClass">
									<option value="01" ${geRisk.riskmark == "01" ? "selected" : ""}>是</option>
									<option value="02" ${geRisk.riskmark == "02" ? "selected" : ""}>否</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="tabLeft" nowrap>业务领域：</td>
						<td class="" >
							<c:if test="${geRisk.businessarea == null }">
								<dict:select typeCode="BUSINESSAREA" style="width: 155px;" defaultValue="" name="geRisk.businessarea" id="businessarea"></dict:select>
							</c:if>
							<c:if test="${geRisk.businessarea != null }">
								<dict:select typeCode="BUSINESSAREA" style="width: 155px;" defaultValue="${geRisk.businessarea }" name="geRisk.businessarea" id="businessarea"></dict:select>
							</c:if>
						</td>
					</tr>		
				</table>
			</form>	
			</fieldset>
			</div>
					<div title="责任信息">
					<fieldset>
					<legend><strong>责任信息:</strong></legend>
					<form  name="addUpdateDutyForm" id="addUpdateDutyForm" autocomplete="off" enctype="multipart/form-data" data-validator-option="{theme: 'yellow_right',timely:1}">
					<table id="addDutyTable" <c:if test="${opeartype != 'VIEW'}"> style="padding-left: 45px;"</c:if> <c:if test="${opeartype == 'VIEW'}"> style="padding-left: 87px;"</c:if>>
					<c:if test="${geRisk == null || geRisk.geDutys == null || fn:length(geRisk.geDutys) == 0}">
						<tr>
							
							<td>代码:</td>
							<td>
								<input type="hidden" id="dutyNo0"style="width:50px;" name="serialNo0" value="" />
								<input type="text" id="dutyCode0" data-rule="required;riskrule;uniqueDutyCode" style="width:50px;" name="dutyCode0" value="" />
							</td>
							<td>名称:</td>
							<td>
								<input type="text" id="dutyName0" data-rule="required;riskrule;" style="width:100px;" name="dutyName0" value="" />
							</td>
							<td>简称:</td>
							<td>
								<input type="text" id="simpleName0" data-rule="required;riskrule;" style="width:100px;" name="simpleName0" value="" />
							</td>
							
							<c:if test="${opeartype != 'VIEW'}">
							<td style="padding-left:90px; ">
								<input type="button" value="添加" onclick="$('#addDutyTable tbody').append($('#dutyMedol table tbody').html().replace(/[#]/g,Math.uuidFast()));">
							</td>
							</c:if>
						</tr>
					</c:if>
		    		<c:forEach items="${geRisk.geDutys }" var="geDuty" varStatus="dutyIndex">
		    			<tr>
							<td>代码:</td>
							<td>
								<input type="hidden" id="serialNo${dutyIndex.index+1 }" name="serialNo${dutyIndex.index+1 }" value="${geDuty.dutyno}" />
								<input type="text" id="dutyCode${dutyIndex.index+1 }" data-rule="required;riskrule;uniqueDutyCode" style="width:50px;" name="dutyCode${dutyIndex.index+1 }" value="${geDuty.dutycode}" />
										
							</td>
							<td>名称:</td>
							<td>
								<input type="text" id="dutyName${dutyIndex.index+1 }" data-rule="required;riskrule" style="width:100px;" name="dutyName${dutyIndex.index+1 }" value="${geDuty.dutyname}" />
							</td>
							<td>简称:</td>
							<td>
								<input type="text" id="simpleName${dutyIndex.index+1 }" data-rule="required;riskrule" style="width:100px;" name="simpleName${dutyIndex.index+1 }" value="${geDuty.dutysimplename}" />
							</td>
							
							<c:if test="${opeartype != 'VIEW'}">
								<c:if test="${dutyIndex.index==0 }">
			    				<td style="padding-left:90px; ">
			    					<input " type="button" value="添加" onclick="$('#addDutyTable tbody').append($('#dutyMedol table tbody').html().replace(/[#]/g,Math.uuidFast()));">
			    				</td>
			    				</c:if>
			    				<c:if test="${dutyIndex.index>0 }">
			    				<td style="padding-left:90px; ">
			    					<input type="button" value="删除" onclick="$(this).parent().parent().remove();">
			    				</td>
			    				</c:if>
							</c:if>
		    			</tr>
		    		
		    			</c:forEach>	
						
					</table>
					</form>
					</fieldset>
			</div>
		</div>
		
		<div style="padding-top: 10px;" align="center">
			<c:if test="${opeartype != 'VIEW'}">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"  onclick="$('#addUpdateRiskForm').submit();">保存</a>
			</c:if>
		    
		    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#risk_operator_window').window('close');">关闭</a>  
		</div>
		
		<!-- 操作类型：删除、修改，不能删除该隐藏域 -->
		<input type="hidden" value="${opeartype }" id="opeartype" name="opeartype">
   	

<div id="dutyMedol" style="display: none;">
	<table>
		<td>代码:</td>
		<td>
			<input type="hidden" id="dutyNo#" name="serialNo0" value="" />
			<input type="text" id="dutyCode#" data-rule="required;riskrule;uniqueDutyCode" style="width:50px;" name="dutyCode#" value="" />
		</td>
		<td>名称:</td>
		<td>
			<input type="text" id="dutyName#" data-rule="required;riskrule;" style="width:100px;" name="dutyName#" value="" />
		</td>
		<td>简称:</td>
		<td>
			<input type="text" id="simpleName#" data-rule="required;riskrule;" style="width:100px;" name="simpleName#" value="" />
		</td>
		
		<td style="padding-left:90px; ">
			<input type="button" value="删除" onclick="$(this).parent().parent().remove();">
		</td>
	</table>
</div>
</body>
</html>
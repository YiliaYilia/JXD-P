<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>

<style type="text/css">
/* 		.n-invalid {border: 1px solid red;} */
		 td{
		 	vertical-align:top;
		 }
/* 		#productTable td{ */
/* 			vertical-align:top; */
/* 		} */
		.td_head{
		}
		.insuredTable_title{
		    color: #616161;
		    font-weight: bold;
		    height: 15px;
		    text-align:center;
		    background-color:#E9F8FF;
		 }
		 .insuredTable_body{
		    color: #616161;
		    height: 20px;
		    text-align:left;
		    padding-left:5px;
		 }
	</style>
</head>
<body>

	<form id="dutyFrmInput" action="${ctx}/system/product/updateDutyInfo" method="post" autocomplete="off">
		<div id="mainContent">
			<table id="mainContentTable" align="center" style="font-size:9pt;width:95%;padding-top:15px;" cellpadding="0" cellspacing="0" border="0">
				<tr  height="30px">
					<td class="td_head" width="30%" nowrap>责任名称：</td>
					<td class="td_body" width="50%"><input type="text" id="geProductduty.productdutyname" name="geProductduty.productdutyname" class="inputDataClass" value="${geProductduty.productdutyname}" /></td>
				</tr>
				<tr height="30px">
					<td class="td_head" width="30%" nowrap>显示顺序：</td>
					<td class="td_body" width="50%"><input type="text"  id="geProductduty.seqindex" name="geProductduty.seqindex" class="inputDataClass" value="${geProductduty.seqindex}" /></td>
				</tr>
				
				<tr height="30px">
					<td class="td_head" width="30%" nowrap>是否销售：</td>
					<td class="td_body" width="50%">
						<c:choose>
							<c:when test="${operation =='check' }">
								<c:if test="${geProductduty.saleflag==1}">是</c:if>
								<c:if test="${geProductduty.saleflag==0}">否</c:if>
							</c:when>
							<c:when test="${operation =='edit' }">
								<select name="geProductduty.saleflag" id="geProductduty.saleflag" class="selectDataClass">
									<option value="">请选择</option>
									<option value="1" <c:if test="${geProductduty.saleflag==1}">selected="selected"</c:if> >是</option>
									<option value="0" <c:if test="${geProductduty.saleflag==0}">selected="selected"</c:if> >否</option>
								</select>
							
							</c:when>
						</c:choose>
					</td>
				</tr>
				<tr height="30px">
					<td class="td_head" width="30%" nowrap>保额配置：</td>
					<td class="td_body" width="70%">
						<div style="padding-top:5px;width:485px;">
								<table border="1" cellspacing="0" cellpadding="0" id="insuredTable">
									<tr>
										<td class="insuredTable_title" width="30px" valign="middle">&nbsp;</td>
										<td class="insuredTable_title" width="100px" valign="middle">保额</td>
										<td class="insuredTable_title" width="100px" valign="middle">单位</td>
									</tr>
									<c:set var="insuredCount" value="0"></c:set>
									<c:forEach items="${geProductduty.geProdutyExtends}"  var="geProdutyExtends" step="1" varStatus="status">
										<tr height="20px" id="insuredTableTr_${status.index}">
											<td class="insuredTable_body" width="20px" valign="top" nowrap>
												<input id="check${status.index}" type="checkbox" class="checkBoxDataClass"  name="checkChild" value="insuredTableTr_${status.index}" />
											</td>
											<td class="insuredTable_body" width="100px" valign="top" nowrap>
												<input type="hidden" id="geProductduty.geProdutyExtends[${status.index}].attributeno" name="geProductduty.geProdutyExtends[${status.index}].attributeno" /> 
												<input type="hidden" id="geProductduty.geProdutyExtends[${status.index}].attributename" name="geProductduty.geProdutyExtends[${status.index}].attributename" value="保额" /> 
												<input type="hidden" id="geProductduty.geProdutyExtends[${status.index}].attributetype" name="geProductduty.geProdutyExtends[${status.index}].attributetype" value="dutyInsuredUnit" />
												<input maxlength="25" type="text" data-rule="required;integer[+0]" class="inputDataClass" id="geProductduty.geProdutyExtends[${status.index}].attributevalue" name="geProductduty.geProdutyExtends[${status.index}].attributevalue" style="width:70px;" value="${geProdutyExtends.attributevalue}" /> 
											</td>
											<td class="insuredTable_body" width="100px" valign="top" nowrap>
												<select class="selectDataClass" id="geProductduty.geProdutyExtends[${status.index}].attributetypevalue" name="geProductduty.geProdutyExtends[${status.index}].attributetypevalue" style="width:100px;">
													<c:forEach items="${duty_insured_unit_typeList}" var="duty_insured_unit" step="1" varStatus="status">
														<option value="${duty_insured_unit.dictdatacode}" ${geProdutyExtends.attributetypevalue == duty_insured_unit.dictdatacode ?"selected":""}>${duty_insured_unit.dictdataname}</option>
													</c:forEach>
												</select>
											</td>
									 	 </tr>
									 	 <span id="comChecked" style="color:#FF9000;font-weight:bold;"></span>
									 	 <c:set var="insuredCount" value="${insuredCount+1}"></c:set>
									</c:forEach>
									
								</table>
								<input type="hidden" id="insuredCount" value="${insuredCount}" />
								<input type="hidden" id="insuredMaxNumber" value="${insuredCount}" />
								
								
								<table border="0" cellspacing="0" cellpadding="0" id="btnTable"  >
								 	 <tr height="20px" >
										<td class="insuredTable_body" width="20px" valign="top" nowrap>
										</td>
										<td class="insuredTable_body" width="100px" valign="top" nowrap>
										</td>
										<td class="insuredTable_body" width="100px" valign="top" nowrap>
											<div style="padding-top: 5px;text-align: center;" >
											    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="addInsured();">添加</a>  
											    <a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delInsured();">删除</a>  
											</div>
										</td>
								 	 </tr>
								</table>
							</div>
					</td>
				</tr>
			</table>
		
			<input type="hidden" name="geProductduty.productdutyno" value="${geProductduty.productdutyno}">
			<input type="hidden" name="dutyNo" value="${geProductduty.productdutyno}">
			<input type="hidden" name="operation" id="operation" value="${operation}">
			<input type="hidden" name="type" value="${type}">
		
			<c:choose>
				<c:when test="${operation =='check' }">

				</c:when>
				<c:when test="${operation =='edit' }">
					<div style="padding-top: 30px;text-align: center;" class="RiskItem">
					    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#dutyFrmInput').submit();">保存</a>  
					</div>
				</c:when>
			</c:choose>
		</div>
	</form>
	
	

	<table border="0" cellspacing="0" cellpadding="0" style="display: none;" >
		<tr height="20px" id="insuredTableTr_%{status.index}" class="insuredTableTrDemoClass" >
			<td class="insuredTable_body" width="20px" valign="top" nowrap>
				<input id="check%{status.index}" type="checkbox"  name="checkChild" value="insuredTableTr_%{status.index}" />
			</td>
			<td class="insuredTable_body" width="100px" valign="top" nowrap>
				<input type="hidden" id="geProductduty.geProdutyExtends[%{status.index}].attributeno" name="geProductduty.geProdutyExtends[%{status.index}].attributeno" /> 
				<input type="hidden" id="geProductduty.geProdutyExtends[%{status.index}].attributename" name="geProductduty.geProdutyExtends[%{status.index}].attributename" value="保额" /> 
				<input type="hidden" id="geProductduty.geProdutyExtends[%{status.index}].attributetype" name="geProductduty.geProdutyExtends[%{status.index}].attributetype" value="givePriceType" />
				<input type="hidden" id="geProductduty.geProdutyExtends[%{status.index}].geProductduty.productdutyno" name="geProductduty.geProdutyExtends[%{status.index}].geProductduty.productdutyno" value="${geProductduty.productdutyno}" />  
				<input maxlength="25" data-rule="required;integer[+0];" type="text" id="geProductduty.geProdutyExtends[%{status.index}].attributevalue" name="geProductduty.geProdutyExtends[%{status.index}].attributevalue" style="width:70px;" value="" /> 
			</td>
			<td class="insuredTable_body" width="100px" valign="top" nowrap>
				<select id="geProductduty.geProdutyExtends[%{status.index}].attributetypevalue" style="width:100%" name="geProductduty.geProdutyExtends[%{status.index}].attributetypevalue" >
					<c:forEach items="${duty_insured_unit_typeList}" var="duty_insured_unit" step="1" varStatus="status">
						<option value="${duty_insured_unit.dictdatacode}" >${duty_insured_unit.dictdataname}</option>
					</c:forEach>
				</select>
			</td>
	 	 </tr>
	</table>
	
	<c:choose>
		<c:when test="${operation =='check' }">
			<script type="text/javascript">
				$(function(){
					initPageForCheck();
				});
			
			</script>
		</c:when>
		<c:when test="${operation =='edit' }">
			<script type="text/javascript">
				$(function(){
					initPageForEdit();
				});
			
			</script>
		</c:when>
	</c:choose>
	
<script type="text/javascript">
function submitForm(){
	$('#dutyFrmInput').submit();
}
function initPageForEdit(){
	if($("#insuredCount").val()==0){
		addInsured();
	}
	
	$('#dutyFrmInput').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
		},
		fields:{//那些字段要加入到规则中
			"geProductduty.productdutyname":{
				rule:"required;"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			"geProductduty.saleflag":{
				rule:"required;"
			},
			"geProductduty.seqindex":{
				rule:"required;integer[+0]"
			}
		},
		valid: function(form){ //验证成功
			doSubmit();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
}

function initPageForCheck(){
	//只读
	$(".inputDataClass").css("border","0");
	$(".inputDataClass").css("border-bottom","0 solid black");
	$(".inputDataClass").css("background","transparent");	
	$(".inputDataClass").attr("readonly",true);	
	$(".selectDataClass").attr("disabled",true);
	$(".selectDataClass").css("display","none");
	$(".selectDataClass").each(function(i,e){
		var obj = $(e);
		var text = obj.find("option:selected").text();
		obj.after(text);
		obj.parent().css("text-align","center");
	});
	$(".checkBoxDataClass").hide();
	$("#btnTable").hide();
	/**
	$("#mainContent").find("input[type='text']").each(function(index,dom){
		var obj = $(dom);
		obj.css("background","transparent");
	});
	*/
}
/**
 * 添加保额
 */
function addInsured(){
	var insuredCount = parseInt($("#insuredCount").val());
	var insuredMaxNumber = parseInt($("#insuredMaxNumber").val());
	var insuredTrHtml = $(".insuredTableTrDemoClass").parent().clone();
	var tableObj = $("#insuredTable");
	var lastTrObj = tableObj.find("tr").last();
	var nextTrNumber = insuredMaxNumber+1;
	insuredTrHtml = insuredTrHtml.html().replace(/%{status.index}/g,nextTrNumber);
	insuredTrHtml = $(insuredTrHtml).removeAttr("class");
	lastTrObj.after(insuredTrHtml);
	insuredCount = insuredCount+1;
	$("#insuredCount").val(insuredCount);
	$("#insuredMaxNumber").val(insuredMaxNumber+1);
	
}

/**
 * 删除保额
 */
function delInsured(){
	var insuredCount = parseInt($("#insuredCount").val());
	var insuredMaxNumber = parseInt($("#insuredMaxNumber").val());
	var allCheckedObj = $("input:checked");
	var delNumber = allCheckedObj.length;
	if(delNumber==insuredCount){
		$.messager.alert('提示','不能删除全部');
		return false;
	}else if(allCheckedObj.length==0){
		return false;
	}
	
	allCheckedObj.each(function(index,dom){
		$("#"+dom.value).remove();
	});
	
	
	var tableObj = $("#insuredTable");
	var lastTrObj = tableObj.find("tr").last();
	insuredMaxNumber = parseInt(lastTrObj.get(0).id.replace("insuredTableTr_",""));
	insuredCount = insuredCount-delNumber;
	$("#insuredCount").val(insuredCount);
	$("#insuredMaxNumber").val(insuredMaxNumber);
	
}

/**
 *  提交表单
 */
function doSubmit(){
	$("#insuredTable").find("tr").each(function(index,dom){
		//将tr 中 input 修改name 按照顺序排序 修改
		$(dom).find("input,select").each(function(i,d){
			var name = d.name;
			var nameArr = name.split(".");
			if(nameArr.length>=3){
				var finalName = nameArr[0]+".geProdutyExtends["+(index-1)+"]";
				for ( var j = 2; j < nameArr.length; j++) {
					finalName = finalName+"."+nameArr[j];
				}
				d.name = finalName;
			}
		});
		
	});
	
	
	var formObj = $("#dutyFrmInput");
	var params = formObj.serialize();
	
	$.ajax({
		type:"POST",
		url:formObj.attr("action"),
		data:params,
		success:function(data){
			if(data.resultCode==="success"){
				//alert("保存成功");
				window.parent.initializeRiskDuty();
				formObj.attr("action","${ctx}/system/product/checkOrEditRiskDuty");
				$("#operation").val("check");
				formObj.get(0).submit();
			}else{
				$.messager.alert('系统异常',data.resultInfo);
			} 
			
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}

</script>
</body>
</html>
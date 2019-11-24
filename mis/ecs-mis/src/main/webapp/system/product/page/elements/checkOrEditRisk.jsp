<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>

<style>
	.organItem{
		padding-top: 10px;
	}
/* 	.n-invalid {border: 1px solid red;} */
</style>

</head>
<body>
	
	
	<form name="frmInput" id="frmInput" action="${ctx}/system/product/updateRiskInfo" method="post">
		<div id="mainContent">
			<table id="mainContentTable" align="center" style="font-size:9pt;width:95%;padding-top:15px;" cellpadding="0" cellspacing="0" border="0">
				<tr  height="30px">
					<td class="td_head" width="30%" nowrap>险种名称：</td>
					<td class="td_body" width="50%"><input type="text" id="geProductrisk.productriskname" name="geProductrisk.productriskname" class="inputDataClass" value="${geProductrisk.productriskname}" /></td>
				</tr>
				<tr height="30px">
					<td class="td_head" width="30%" nowrap>显示顺序：</td>
					<td class="td_body" width="50%"><input type="text" id="geProductrisk.seqindex" name="geProductrisk.seqindex" class="inputDataClass" value="${geProductrisk.seqindex}" /></td>
				</tr>
				<tr height="30px">
					<td class="td_head" width="30%" nowrap>是否显示责任：</td>
					<td class="td_body" width="50%">
						<c:choose>
							<c:when test="${operation =='check' }">
								<c:if test="${geProductrisk.isshowproductduty==1}">是</c:if>
								<c:if test="${geProductrisk.isshowproductduty==0}">否</c:if>
							</c:when>
							<c:when test="${operation =='edit' }">
								<select name="geProductrisk.isshowproductduty" id="geProductrisk.isshowproductduty" class="selectDataClass">
									<option value="" >请选择</option>
									<option value="1" <c:if test="${geProductrisk.isshowproductduty==1}">selected="selected"</c:if>  >是</option>
									<option value="0" <c:if test="${geProductrisk.isshowproductduty==0}">selected="selected"</c:if> >否</option>
								</select>
							
							</c:when>
						</c:choose>
					</td>
				</tr>
				<tr height="30px">
					<td class="td_head" width="30%" nowrap>是否销售：</td>
					<td class="td_body" width="50%">
						<c:choose>
							<c:when test="${operation =='check' }">
								<c:if test="${geProductrisk.saleflag==1}">是</c:if>
								<c:if test="${geProductrisk.saleflag==0}">否</c:if>
							</c:when>
							<c:when test="${operation =='edit' }">
								<select name="geProductrisk.saleflag" id="geProductrisk.saleflag" class="selectDataClass">
									<option value="">请选择</option>
									<option value="1" <c:if test="${geProductrisk.saleflag==1}">selected="selected"</c:if> >是</option>
									<option value="0" <c:if test="${geProductrisk.saleflag==0}">selected="selected"</c:if> >否</option>
								</select>
							
							</c:when>
						</c:choose>
					</td>
				</tr>
			
			</table>
		
			<input type="hidden" name="geProductrisk.productriskno" value="${geProductrisk.productriskno}">
			<input type="hidden" name="riskNo" value="${geProductrisk.productriskno}">
			<input type="hidden" name="operation" id="operation" value="${operation}">
			<input type="hidden" name="type" value="${type}">
		
		
		
			<c:choose>
				<c:when test="${operation =='check' }">

				</c:when>
				<c:when test="${operation =='edit' }">
					<div style="padding-top: 20px;text-align: center;" class="RiskItem">
					    <a  class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#frmInput').submit();">保存</a>  
					</div>
				</c:when>
			</c:choose>
		</div>
	</form>
	
	
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

function initPageForEdit(){
	$('#frmInput').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
		},
		fields:{//那些字段要加入到规则中
			"geProductrisk.productriskname":{
				rule:"required;"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			"geProductrisk.saleflag":{
				rule:"required;"
			},
			"geProductrisk.seqindex":{
				rule:"required;integer[+0]"
			},
			"geProductrisk.isshowproductduty":{
				rule:"required;"
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
	/**
	
	$("#mainContent").find("input[type='text']").each(function(index,dom){
		var obj = $(dom);
		obj.css("background","transparent");
	});
	*/
	
}

function doSubmit(){
	var formObj = $("#frmInput");
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>理赔详情</title>
<style>
		.imgList {width:60px;height:60px;margin-right:5%;}
		#imgbox-overlay {position: fixed;top: 0;	left: 0;width: 100%;height: 100%;background: #000;z-index: 80;opacity:0.5;display:none;}
		#imgbox-wrap {position: absolute;top: 0;left: 0;z-index: 90;width: 100%;height: 100%;display:none;}
		#imgbox-wrap img{display:block;margin:auto;height:100%;}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		var state = $("#state1").val();
		if(state=="01"||state=="02"){
			 document.getElementById("div2").style.display="block";
			 document.getElementById("div3").style.display="block";
		}
		if(state=="04"){
			 document.getElementById("div4").style.display="block";
		}
		if(state=="03"){
			document.getElementById("div6").style.display="block";
		}
	});
	
	//取消按钮  返回理赔列表
	function cancel(){
		window.location.href ="${ctx }/business/claimList";
	}
	
	//退回按钮、录入退回原因，保存后进入理赔列表
	function sendBack(){
		var value = document.getElementById("div1").style.display;
		var state = $("#state1").val();
		if(state=="01"||state=="02"){
			if(value=="none"){
	             document.getElementById("div1").style.display="block";
			 }else{
				 document.getElementById("div1").style.display="none";
			 }
		}else{
			alert("已提交以及已报案状态的数据，可以进行退回操作。");
		}
	}
	
	//验证退回原因是否为空
	function remarkCheck(){
		var remark = $("#remark").val();
		if(remark==null||remark==""){
			alert("退回的原因不能为空");
		}else{
			if(confirm("确认要退回吗？")){
				frm.submit();
			}
		}
	}
	
	//审核中按钮  改变状态
	function audit(){
		var claimManagementNo = $("#claimManagementNo").val();
		if(confirm("确认要审核吗？")){
			window.location.href ="${ctx }/business/claimAudit?claimManagementNo="+claimManagementNo;
		}
	}
	
	//完成按钮 录入理赔额   状态改为“已完成”
	function finish(){
		var value = document.getElementById("div5").style.display;
		var state = $("#state1").val();
		if(state=="04"){
			if(value=="none"){
	            document.getElementById("div5").style.display="block";
			 }else{
				 document.getElementById("div5").style.display="none";
			 }  
		}else{
			alert("审核中状态的数据，可以进行完成操作");
		}
	}
	
	//验证理赔额是否为空
	function amountCheck(){
		if(amCheck()){
			if(confirm("确认完成吗？")){
				frm1.submit();
			}
		}
	}
	
	//验证输入的理赔额
	function amCheck(){
		var zeAmount = /^\d+(\.\d+)?$/;//正数和两位小数
		var amount = $("#amount").val();
		if(amount==null||amount==""){
			alert("输入的理赔额不能为空");
			return false;
		}
		if(!zeAmount.test(amount)){
			alert("理赔额不符合要求");
			return false;
		}
		return true;
	}
	
	$(function () {
  		$(".imgList").click(function(){
  			$("#imgbox-overlay").show();
  			$("#imgbox-wrap").show();
  			$(".img-overlay").prop("src",$(this).attr("src"));
  		});
  		$(".img-overlay").click(function(){
  			$("#imgbox-overlay").hide();
  			$("#imgbox-wrap").hide();
  		});
	});
	
	//理赔资料导出
	function exportData(){
		//理赔ID
		var claimManagementNo = $("#claimManagementNo").val();
		window.location.href ="${ctx }/business/exportData?claimManagementNo="+claimManagementNo;
	}
</script>

</head>
<body>
<form action="">
<input type="hidden" id="insrelationApp1" name="insrelationApp1" value="${geClaimManagement.insrelationApp }">
<input type="hidden" id="claimManagementType1" name="claimManagementType1" value="${geClaimManagement.claimManagementType }">
<input type="hidden" id="isInsure1" name="isInsure1" value="${geClaimManagement.isInsure }">
<input type="hidden" id="state1" name="state1" value="${geClaimManagement.state }">
<input type="hidden" id="startDate1" name="startDate1" value="${geClaimManagement.startDate }">
<input type="hidden" id="insureDate1" name="insureDate1" value="${geClaimManagement.insureDate }">
<input type="hidden" id="claimManagementNo" name="claimManagementNo" value="${geClaimManagement.claimManagementNo }">
<input type="hidden" id="commitType1" name="commitType1" value="${geClaimManagement.commitType }">
</form>
<div id="claimInfo" class="easyui-tabs" data-options="tabPosition:'top',fit:true,plain:true,border:false" >
	<div title="基本信息" data-options="fit:true">
		<table class="easyui-propertygrid" id="basic">
			<tr>
				<td></td>
				<td>保险单号</td>
				<td>${geClaimManagement.policyCode }</td>
			</tr>
			<tr>
				<td></td>
				<td>申请人</td>
				<td>${geClaimManagement.name }</td>
			</tr>
			<tr>
				<td></td>
				<td>与被保险人关系</td>
				<td id="insrelationApp"></td>
			</tr>
			<tr>
				<td></td>
				<td>索赔类别</td>
				<td id="claimManagementType"></td>
			</tr>
			<tr>
				<td></td>
				<td>被保险人出险日期</td>
				<td id="startDate"></td>
			</tr>
			<tr>
				<td></td>
				<td>被保险人出险原因</td>
				<td>${geClaimManagement.startCause }</td>
			</tr>
			<tr>
				<td></td>
				<td>被保险人当前职业</td>
				<td>${geClaimManagement.occupation }</td>
			</tr>
			<tr>
				<td></td>
				<td>报案人联系电话</td>
				<td>${geClaimManagement.phone }</td>
			</tr>
			<tr>
				<td></td>
				<td>被保险人是否在其他公司有人身保险</td>
				<td id="isInsure"></td>
			</tr>
			<c:if test="${geClaimManagement.isInsure == 'Y'}">
				<tr>
					<td></td>
					<td>公司名称</td>
					<td>${geClaimManagement.corporationName }</td>
				</tr>
				<tr>
					<td></td>
					<td>投保日期</td>
					<td id="insureDate"></td>
				</tr>
				<tr>
					<td></td>
					<td>购买险种名称及保额</td>
					<td>${geClaimManagement.insuranceInfo }</td>
				</tr>
			</c:if>
			
			<tr>
				<td></td>
				<td>提交方式</td>
				<td id="commitType"></td>
			</tr>
			
			<tr>
				<td></td>
				<td>状态</td>
				<td id="state"></td>
			</tr><c:if test="${geClaimManagement.state=='05' }"><tr>
				<td></td>
				<td>理赔额</td>
				<td>${geClaimManagement.amount }</td>
			</tr></c:if><tr>
				<td></td>
				<td>理赔资料 <br>
					<c:if test="${geClaimManagement.state != '01'}">
						<input type="button" value="资料导出" onclick="exportData();"/>
					</c:if>
				</td>
				<td>
					<div style="width:100%; height:100%; overflow-y:scroll;">
				   		<c:forEach items="${geClaimRider }" var="claimRider">
							<img src="${claimRider.riderPath }" class="imgList"></img>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
			<table id="button">
			    <tr><td colspan="4">
			        <div style="display: none" id="div1">
			           <form name="frm" action="${ctx }/business/claimSendBack" method="post">
			                                               请输入退回原因：<br>
			               <textarea rows="4%" cols="50%" name="remark" id="remark"></textarea><br>
			               <input type="button" value="确定" onclick="remarkCheck();">&nbsp;&nbsp;
			               <input type="reset" value="重置">
			           </form>
			        </div>
			        <div style="display: none" id="div6">
			                                        退回原因：<br>
			             <textarea rows="4%" cols="50%" readonly="readonly" disabled="disabled">${geClaimManagement.remark }</textarea>
			        </div>
			        </td>
			    </tr><tr>
			        <td><div id="div2" style="display: none"><input type="button" value="退回" onclick="sendBack();"></div></td>
			        <td><div id="div3" style="display: none"><input type="button" value="审核中" onclick="audit();"></div></td>
			        <td><div id="div4" style="display: none"><input type="button" value="完成" onclick="finish();"></div></td>
			    </tr><tr><td colspan="4">
			        <div style="display: none" id="div5">
			          <form name="frm1" action="${ctx }/business/claimFinish?claimManagementNo=${geClaimManagement.claimManagementNo }" method="post">
			                                         请输入理赔额：<br>
			              <input type="text" name="amount" id="amount" ><br>
			              <input type="button" value="确定" onclick="amountCheck();">&nbsp;&nbsp;
			              <input type="reset" value="重置">              
			          </form>
			        </div>
			    </td>
			    </tr>
			</table>
	</div>
</div>
<div id="imgbox-overlay"></div>
	<div id="imgbox-wrap"><img class="img-overlay"/></div>
</body>
<script>
	var insrelationApp = $("#insrelationApp1").val(); 
	var claimManagementType = $("#claimManagementType1").val();
	var isInsure = $("#isInsure1").val();
	var state = $("#state1").val();
	var startDate = $("#startDate1").val();
	var insureDate = $("#insureDate1").val();
	var commitType = $("#commitType1").val();
	if(claimManagementType=="1"){
		$('#claimManagementType').html('住院津贴');
	}
	if(claimManagementType=="2"){
		$('#claimManagementType').html('医疗报销');
	}
	if(claimManagementType=="3"){
		$('#claimManagementType').html('重大疾病');
	}
	if(claimManagementType=="4"){
		$('#claimManagementType').html('伤残');
	}
	if(claimManagementType=="5"){
		$('#claimManagementType').html('身故');
	}
	if(insrelationApp=="SF"){
		$('#insrelationApp').html('本人');
	}
	if(insrelationApp=="FA"){
		$('#insrelationApp').html('父亲');
	}
	if(insrelationApp=="MO"){
		$('#insrelationApp').html('母亲');
	}
	if(isInsure=="Y"){
		$('#isInsure').html('是');
	}
	if(isInsure=="N"){
		$('#isInsure').html('否');
	}
	if(state=="01"){
		$('#state').html('已报案');
	}
	if(state=="02"){
		$('#state').html('已提交');
	}
	if(state=="03"){
		$('#state').html('已退回');
	}
	if(state=="04"){
		$('#state').html('审核中');
	}
	if(state=="05"){
		$('#state').html('已完成');
	}
	if(commitType=="01"){
		$('#commitType').html('柜台提交');
	}	
	if(commitType=="02"){
		$('#commitType').html('微信提交');
	}
	if(commitType=="03"){
		$('#commitType').html('邮箱提交');
	}
	$('#startDate').html(startDate.substring(0,10));
	$('#insureDate').html(insureDate.substring(0,10));
</script>
</html>
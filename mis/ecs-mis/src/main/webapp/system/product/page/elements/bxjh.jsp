<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险计划</title>

</head>
<body>
<script type="text/javascript" src="${ctx }/common/js/uuid.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/elements/bxjh.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#bxjhTab').tabs({    
	    border:false,    
	    onSelect:function(title){    
	        if(title=='保存提交'){
	        	$('#addUpdateBXJHForm1').submit();
	        }
	        return false;
	    }
	
	});
	var bxjh = new BXJH();
	bxjh.ctx="${ctx}";
	bxjh.validator("${geProductMain.coreproductcode}");
});

</script>

<div id="bxjhTab" class="easyui-tabs" data-options="fit:true,tabPosition:'left',headerWidth:100">   
	
	    <div title="计划信息" style="padding:20px;font-size: 13px;">
	    	<form name="addUpdateBXJHForm1" id="addUpdateBXJHForm1" autocomplete="off">
	    	<div style="width: 800px;">
	    		<fieldset>
					<legend>计划配置</legend>
					<c:set var="temp_plan" value="${null }"></c:set>
					<c:forEach items="${geProductMain.geInsurancePlans }" var="insurancePlan" begin="0" end="1">
						<c:set var="temp_plan" value="${insurancePlan }"></c:set>
					</c:forEach>
					<table cellpadding="2" cellspacing="2">
					<c:if test="${temp_plan == null }">
						<tr >
							<td align="right">
								保险计划名称:
							</td>
							<td>
								<input name="planname" id="planname" type="text"  style="width: 120px;" maxlength="100" >
							</td>
							<td align="right">
								初始费用:
							</td>
							<td>
								<dict:select typeCode="IDC" name="initialcosttype" id="initialcosttype" pleaseChoose="true" ></dict:select>
								<input type="text" name="initialcost" id="initialcost" maxlength="10"  style="width: 50px;" onkeyup="this.value =this.value.replace(/[^\d]/g, '')">
							</td>
						</tr>
						
						
						<tr>
							<td align="right">
								投资方式:
							</td>
							<td>
								<dict:checkbox type="checkbox" typeCode="InvestmentStyle" name="investment" id="" ></dict:checkbox>
							</td>
							<td align="right">
								缴费方式:
							</td>
							<td>
								<dict:checkbox type="checkbox" typeCode="PaymentWay" name="paytype" id="" ></dict:checkbox>
							</td>
						</tr>
					</c:if>
					<c:if test="${temp_plan != null }">
						<tr >
							<td align="right">
								保险计划名称:
							</td>
							<td>
								<input name="planname" id="planname" type="text"  style="width: 120px;" maxlength="100" value="${temp_plan.planname }">
							</td>
							<td align="right">
								初始费用:
							</td>
							<td>
								<dict:select typeCode="IDC" name="initialcosttype" id="initialcosttype" pleaseChoose="true" defaultValue="${temp_plan.initialcosttype }"></dict:select>
								<input type="text" name="initialcost" id="initialcost" maxlength="10"  style="width: 50px;" onkeyup="this.value =this.value.replace(/[^0123456789\\.]/g, '')" value="${temp_plan.initialcost }">
							</td>
						</tr>
						
						
						<tr>
							<td align="right">
								投资方式:
							</td>
							<td>
								<dict:checkbox type="checkbox" typeCode="InvestmentStyle" name="investment" id="" defaultValue="${temp_plan.investment }"></dict:checkbox>
							</td>
							<td align="right">
								缴费方式:
							</td>
							<td>
								<dict:checkbox type="checkbox" typeCode="PaymentWay" name="paytype" id="" defaultValue="${temp_plan.paytype }"></dict:checkbox>
							</td>
						</tr>
					</c:if>
						
							
					</table>
					
				</fieldset>
			</div>
			</form>
	    </div>
	    
	    <div title="账户配置" style="padding:20px;font-size: 13px;">  
	   	 <form name="addUpdateBXJHForm2"  id="addUpdateBXJHForm2" autocomplete="off">
	    	<div style="width: 800px;">
	    		<fieldset>
					<legend>账号配置</legend>
					
		    		<table cellpadding="2" cellspacing="2" id="accoutTable">
		    		<c:if test="${temp_plan == null }">
		    			<tr>
		    				<td align="right">
								账号编号:
							</td>
							<td width="300">
								<input type="text" name="accountcode" id="accountcode1" maxlength="100" >
							</td>
							<td align="right">
								账号名称:
							</td>
							<td>
								<input type="text" name="accountname" id="accountname1" maxlength="50" >
							</td>
							
							
		    				<td>
		    					<input type="button" value="添加" onclick="$('#accoutTable tbody').append($('#accountMedol table tbody').html().replace(/[#]/g,Math.uuidFast()));">
		    				</td>
		    				
		    			</tr>
		    		</c:if>
		    		<c:forEach items="${geProductMain.geInsurancePlans }" var="plan" begin="0" end="1">
		    			<c:forEach items="${plan.geInsurancePlanAccounts }" var="account" varStatus="accountIndex">
		    			<tr>
		    				<td align="right">
								账号编号:
							</td>
							<td width="300">
								<input type="text" name="accountcode" id="accountcode${accountIndex.index+1 }" maxlength="100" value="${account.accountcode }">
							</td>
							<td align="right">
								账号名称:
							</td>
							<td>
								<input type="text" name="accountname" id="accountname${accountIndex.index+1 }" maxlength="50" value="${account.accountname }">
							</td>
							
							
							<c:if test="${accountIndex.index==0 }">
		    				<td>
		    					<input type="button" value="添加" onclick="$('#accoutTable tbody').append($('#accountMedol table tbody').html().replace(/[#]/g,Math.uuidFast()));">
		    				</td>
		    				</c:if>
		    				<c:if test="${accountIndex.index>0 }">
		    				<td>
		    					<input type="button" value="删除" onclick="$(this).parent().parent().remove();">
		    				</td>
		    				</c:if>
		    				
		    			</tr>
		    			</c:forEach>
		    			</c:forEach>
		    		</table>
		    		
		    	</fieldset>
	    	</div>
	    	</form>
	    </div>
	    
	     <div title="账户分值" style="padding:20px;font-size: 13px;">  
	     	<div style="width: 1000px;">
	     	 <form name="addUpdateBXJHForm3"  id="addUpdateBXJHForm3" autocomplete="off">
	    		<fieldset>
					<legend>账户分值配置</legend>
					<table id="accoutScoreTable">
					<c:if test="${temp_plan == null }">
						<tr>
							<td>分值范围:</td>
							<td>
								
								<input type="text" style="width: 50px" name="minscore"  id="minscore1"  onkeyup="this.value =this.value.replace(/[^\d]/g, '')">
								-
								<input type="text" style="width: 50px" name="maxscore" id="maxscore1" onkeyup="this.value =this.value.replace(/[^\d]/g, '')">
							</td>
							<td>承受能力编码:</td>
							<td>
								<input type="text" name="capacitycode" id="capacitycode1" style="width: 50px">
							</td>
							<td>承受能力名称:</td>
							<td>
								<input type="text" name="capacityname" id="capacityname1" style="width: 150px">
							</td>
							<td>包含账户:</td>
							<td>
								<input type="text" name="accounts" id="accounts1" style="width: 150px">
							</td>
							<td>
								<input type="button" value="添加" onclick="$('#accoutScoreTable tbody').append($('#accountScoreMedol table tbody').html().replace(/[#]/g,Math.uuidFast()));">
							</td>
						</tr>
					</c:if>
					<c:forEach items="${geProductMain.geInsurancePlans }" var="plan" begin="0" end="1">
		    			<c:forEach items="${plan.geInsurancePlanAccountScores }" var="score" varStatus="scoreIndex">
		    			<tr>
							<td>分值范围:</td>
							<td>
								
								<input type="text" style="width: 50px" name="minscore" value="${score.minscore }"  id="minscore${scoreIndex.index+1 }"  onkeyup="this.value =this.value.replace(/[^\d]/g, '')">
								-
								<input type="text" style="width: 50px" name="maxscore" value="${score.maxscore }" id="maxscore${scoreIndex.index+1 }" onkeyup="this.value =this.value.replace(/[^\d]/g, '')">
							</td>
							<td>承受能力编码:</td>
							<td>
								<input type="text" name="capacitycode" value="${score.capacitycode }" id="capacitycode${scoreIndex.index+1 }" style="width: 50px">
							</td>
							<td>承受能力名称:</td>
							<td>
								<input type="text" name="capacityname" value="${score.capacityname }" id="capacityname${scoreIndex.index+1 }" style="width: 150px">
							</td>
							<td>包含账户:</td>
							<td>
								<input type="text" name="accounts" value="${score.accounts }"  id="accounts${scoreIndex.index+1 }" style="width: 150px">
							</td>
							
							
							<c:if test="${scoreIndex.index==0 }">
		    				<td>
		    					<input type="button" value="添加" onclick="$('#accoutScoreTable tbody').append($('#accountScoreMedol table tbody').html().replace(/[#]/g,Math.uuidFast()));">
		    				</td>
		    				</c:if>
		    				<c:if test="${scoreIndex.index>0 }">
		    				<td>
		    					<input type="button" value="删除" onclick="$(this).parent().parent().remove();">
		    				</td>
		    				</c:if>
		    				
		    			</tr>
		    			</c:forEach>
		    			</c:forEach>	
						
					</table>
				</fieldset>
				</form>
			</div>
	     </div>
	    
	    <div title="保存提交" style="padding:20px;font-size: 13px;">
	    	<div id="show"></div>
	    </div>

</div>



<!-- 账户模型定义 -->
<div id="accountMedol" style="display: none;">
	<table>
	<tr>
 		<td align="right">
			账号编号:
		</td>
		<td width="100">
			<input type="text" name="accountcode" id="accountcode#" maxlength="100">
		</td>
		<td align="right">
			账号名称:
		</td>
		<td>
			<input type="text" name="accountname" id="accountname#" maxlength="50">
		</td>
		<td>
			<input type="button" value="删除" onclick="$(this).parent().parent().remove();">
		</td>
	</tr>
	</table>
	
</div>

<div id="accountScoreMedol" style="display: none;">
	<table>
		<tr>
			<td>分值范围:</td>
			<td>
				<input type="text" style="width: 50px" name="minscore"  id="minscore#"  onkeyup="this.value =this.value.replace(/[^\d]/g, '')">
				-
				<input type="text" style="width: 50px" name="maxscore" id="maxscore#" onkeyup="this.value =this.value.replace(/[^\d]/g, '')">
			</td>
			<td>承受能力编码:</td>
			<td>
				<input type="text" name="capacitycode" id="capacitycode#" style="width: 50px">
			</td>
			<td>承受能力名称:</td>
			<td>
				<input type="text" name="capacityname" id="capacityname#" style="width: 150px">
			</td>
			<td>包含账户:</td>
			<td>
				<input type="text" name="accounts" id="accounts#" style="width: 150px">
			</td>
			<td>
				<input type="button" value="删除" onclick="$(this).parent().parent().remove();">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
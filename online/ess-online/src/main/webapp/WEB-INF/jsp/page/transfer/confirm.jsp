<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
  <title>确认投保-瑞泰人寿</title>
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<link href="<%=request.getContextPath()%>/global/page/css/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/>	
<!--  	<script src="<%=request.getContextPath()%>/resources/js/page/confirm.js?${random}"></script>-->
	
	<script src="<%=request.getContextPath() %>/resources/lib/component/form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
<!-- 	工具类 -->
	<script src="<%=request.getContextPath()%>/resources/lib/utils/dateUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/idCardUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/stringUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/js/page/area.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/resources/js/page/trafill.js?${random}"></script>
  </head>
  	<style>
  		.cbox{display:block;width:25px;height:25px;border:1px solid #000;background:#fff;text-align:center;float:left;}
  		.cbox.checked{background:#fff;}
 		.cbox.checked:after{content:"√"
 		}
 	</style>
  <body onload="yuedu()">
  	<div class="headnav">
  		<div class="menu" >填写信息</div>
  		<div class="menu" style="color:#fff;">确认投保</div>
  		<div class="menu">在线缴费</div>
  		<s:iterator value="#request.order.policys" var="policy">
			<s:iterator value="#policy.applicantInsureds" var="applicant">
			</s:iterator>
		</s:iterator>
  	</div>
  	<div class="policy_holder">投保人信息、被保险人信息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;</td>
  			<td  style="float:left;width:100%">${applicant.name }</td>
  		</tr>
  		<tr>
  			<td  colspan="2" style="text-align:center;">&nbsp;&nbsp;与投保人关系：</td>
  			<td  style="float:left; align:center;">本人</td>
  		<tr>
  		<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;">证件类型：</td>
  			<td  style="float:left;width:100%">
  					${strIDtype}
  				</td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;">证件号码：</td>
  			<td  style="float:left;width:100%">${applicant.identifynumber}</td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td  style="float:left;width:100%">
				${strSex}
			</td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;">出生日期：</td>
  			<td  style="float:left;width:100%">${strBirthday}</td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;">手机号码：</td>
  			<td  style="float:left;width:100%">${applicant.mobile}</td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;">电子邮箱：</td>
  			<td  style="float:left;width:100%">${applicant.email}</td>
  		</tr>
  <%--  	<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;">通讯地址：</td>
  			<td  style="float:left;width:100%">
	  			${applicant.address}
  			</td>
  		</tr>  --%>
  		<tr>
  			<td  colspan=2 style="text-align:center;"></td>
  			<td  style="float:left;width:100%">&nbsp;</td>
  		</tr>
<%--   		<tr>
  			<td  style="color:red; float:right;">&nbsp;</td>
  			<td  style="text-align:center;">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
  			<td  style="float:left;width:100%">${applicant.zipcode}</td>
  		</tr> --%>
  	</table>
  	</div>
 	<div class="policy_holder">受益人信息</div>
  	<div class="center_fill">
  	<div class="choose">
  		<table  class="msg">
  		<tr>
  			<td style="color:red; float:right;">&nbsp;</td>
  			<td style="text-align:left;width: 40%">受益人</td>
  			<td style="float:left;width:100%">法定</td>
  		</tr>
  	</table>
  	</div>
  	</div>
  	<div class="policy_holder">推荐人信息</div>
  	<div class="center_fill">
  	<div class="choose">
  	<table  class="msg">
  	<!--  	<tr>
  			<td    style="text-align:left;width:40%">推荐人姓名</td>
  			<td   style="float:left;width:100%">${policy.agentname}</td>
  		</tr>
  		-->
  		<tr>
  			<td    style="text-align:left;">推荐人编码</td>
  			<td   style="float:left;width:100%">${policy.agentcode}</td>
  		</tr>
  	</table>
  	
  	</div>
  	
  	<table class="agree">
  		<tr>
  			<td width=10%;>
  			<input style="width:30px;height:30px;opacity:0;" id="isSure" type="checkbox" name="checkbox"/>
  			<div class="cbox" id="check" onclick="this.className=/checked/ig.test(this.className)?this.className.replace('checked',''):(this.className+' checked')">
  			</div>
  			<td width=90%;>
  			我已阅读<a href="<%=request.getContextPath()%>/global/global/pdf/know_t/web/pdf/know.pdf">《投保须知及客户声明》、</a>
  			<a href="<%=request.getContextPath()%>/global/global/pdf/clause_t/web/pdf/clause.pdf">《瑞泰天天保公共交通工具意外伤害保险合同条款》</a>
  			理解并同意其全部内容</td>
  		</tr>
  	</table>
  	<div id="toInsureSubmit" onclick="goApply();" class="notice_btn">下一步：在线支付</div>
  	<jsp:include page="../../common/common-modal.jsp"></jsp:include>
  	<jsp:include page="../../common/footer.jsp"></jsp:include>
  </body>
<script type="text/javascript">
$("#check").click(function(){
	if(document.getElementById("isSure").checked==true){
		 document.getElementById("isSure").checked=false;
	}else{
		 document.getElementById("isSure").checked=true;	
	}
})


function goApply(){
	var flag = document.getElementById("isSure").checked;
	if(flag){
		modal_loading();
		//校验通过后提交
		$.ajax({
			type:"POST",
			url:contentRootPath+"/msl/sales/insureShortPolicySubmit",
			data:{
				"policy.prodoctcode":"TATIANB02"
			},
			dataType:"json",
			success:function(data){
				 if(data.resultSuccess){
					 modal_loading('hide');
					//支付
					window.location.href =contentRootPath+'/msl/sales/pay';
				
					 
				 }else{
					 if(data.resultCode == 2000){
						 	if(data.resultDescription == null || data.resultDescription ==''){
						 		alert('核保异常');
						 	}else{
						 		alert(data.resultDescription);
						 	}
						   modal_loading('hide');
							return;
						}else{
							alert("系统繁忙：" + data.resultCode);
							modal_loading('hide');
							return;
						}
					   modal_loading('hide');
				 }
			}
		});
			modal_loading('hide');
	}else{
		alert('请您阅读《投保须知》、《投保提示》、《瑞泰天天保公共交通工具意外伤害保险合同条款》。');
		return;
	}
	
}

function yuedu(){
	 if(document.getElementById("checkbox").checked==true){
		 alert(document.getElementById("check").style.content);
		document.getElementById("check").className='cbox checked';
		 
	 }
}
</script>
</html>

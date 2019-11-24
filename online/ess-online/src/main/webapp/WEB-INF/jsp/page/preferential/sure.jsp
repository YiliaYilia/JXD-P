<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML>
<html>
  <head>
  <title>确认投保-瑞泰人寿</title>
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/>
  </head>
  </head>
  
  <body>
  	<div class="nav">
  		<div class="menu" >填写信息</div>
  		<div class="menu">健康告知</div>
  		<div class="menu" style="color:#fff;">确认投保</div>
  		<div class="menu">在线缴费</div>
  	</div>
  	<div class="policy_holder">投&nbsp;保&nbsp;人&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td  style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  			<td  style="float:left;width:100%">&nbsp;${applicantInsured.name}</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">证件类型：</td>
  			<td  style="float:left;width:100%">&nbsp;${identifytype1}</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">证件号码：</td>
  			<td  style="float:left;width:100%">&nbsp;${applicantInsured.identifynumber}</td>
  		</tr>
  		
  		<tr>
  			<td  style="text-align:center;">出生日期：</td>
  			<td  style="float:left;width:100%">&nbsp;${birthday1}</td>
  		</tr><tr>
  			<td  style="text-align:center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td  style="float:left;width:60%">
				&nbsp;${sex1}
			</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">手机号码：</td>
  			<td  style="float:left;width:100%">&nbsp;${applicantInsured.mobile}</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">电子邮箱：</td>
  			<td  style="float:left;width:100%">&nbsp;${applicantInsured.email}</td>
  		</tr>
  		<tr>
  			<td  style="text-align:center;">通讯地址：</td>
  			<td  style="float:left;width:100%">
	  		&nbsp;${applicantInsured.address}
  			</td>
  		</tr>
  	</table>
  	</div>
  	
  	<div class="policy_holder">被&nbsp;保&nbsp;人&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td  style="text-align:center;">与投保人关系：</td>
  			<td  style="float:left; align:center;">${insrelationapp}</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  			<td   style="float:left;width:100%">&nbsp;${recognizee.name}</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;">证件类型：</td>
  			<td   style="float:left;width:100%">&nbsp;${identifytype2}</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;">证件号码：</td>
  			<td   style="float:left;width:100%">&nbsp;${recognizee.identifynumber}</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;width:40%">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td   style="float:left;width:100%">&nbsp;${sex2}</td>
  		</tr>
  		<tr>
  			<td   style="text-align:center;">出生日期：</td>
  			<td   style="float:left;width:100%">&nbsp;${birthday2}</td>
  		</tr>
  	</table>
  	</div>
  	<div class="policy_holder">续保选择</div>
  	<div class="center_fill">
  	<div class="choose">
  		<table  class="msg">
  		<tr>
  			<td colspan="2" style="text-align: left;">
  			申请续保至被保险人25岁</td>
  		</tr>
  		<tr>
  			<td   style="text-align:left;width:40%">续保缴费银行</td>
  			<td   style="float:left;width:100%">&nbsp;${policy.bank}</td>
  		</tr>
  		<tr>
  			<td    style="text-align:left;">续保缴费账号</td>
  			<td   style="float:left;width:100%">&nbsp;${policy.bankAccountNumber}</td>
  		</tr>
  	</table>
  	</div>
  	</div>
  	<div class="policy_holder">推荐人信息</div>
  	<div class="center_fill">
  	<div class="choose">
  	<table  class="msg">
  		<tr>
  			<td   style="text-align:left;">推荐人编码</td>
  			<td   style="float:left;width:100%">&nbsp;${policy.agentcode}</td>
  		</tr>
  	</table>
  	
  	</div>
  	</div>
  	
  	<div class="agree">
  		<input id="checkbox" type="checkbox" name="checkbox"/>我已阅读<a href="<%=request.getContextPath()%>/global/global/pdf/know/web/viewer.html">《投保提示、投保须知、客户声明及自动转账授权声明》、</a><a href="<%=request.getContextPath()%>/global/global/pdf/clause/web/viewer.html">《瑞泰成长卫士少儿重大疾病保险条款》</a>理解并同意其全部内容
  	</div>
  	<div class="notice_btn" onclick="underwriting();">下一步：在线支付</div>
  	<jsp:include page="../../common/footer.jsp"></jsp:include>
  </body>
	<script type="text/javascript">
	
	  //核保
	  function underwriting(){
		  var flag = document.getElementById("checkbox").checked;
		  if(flag){
			  $.ajax({
				   type:"POST",
				   url:contentRootPath+"/msl/sales/longPolicyInsureSubmit",
				   data:{
				   },
				   dataType:"json",
				   success:function(data){
					   if(data.flag=="0"){
						   alert("核保成功，测试环境跳过支付");
						   //window.location.href =contentRootPath+'/msl/sales/pay';
						   window.location.href =contentRootPath+'/msl/sales/toSuccess?source=changxian';
					   }else if(data.flag=="1"){
						   alert(data.content);
					   }
					}
				});  
		  }else{
			  alert("请您阅读《投保须知》、《投保提示》、《瑞泰成长卫士少儿重大疾病保险条款》。");
			  return;
		  }

	  }
	</script>
</html>

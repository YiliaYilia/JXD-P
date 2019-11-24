<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>确认投保-瑞泰人寿</title>
<%@ include file="../../common/meta.jsp"%>
<%@ include file="../../common/rels.jsp"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/uinew/css/style-font.css">

<style>
	
	.grace-info-tl {
		font-size: 2em;
	}
	.grace-form {
		font-size: 1.7em;
	}

	.grace-applicant-info {
		font-size: 1.2em;
	}
	.choose-con2 {
		font-size: 1.6em;
	}
	.grace-form .pull-left {
		width: 30%;
	}
	.grace-form .pull-right {
		width: 70%;
	}
		.checkbox_div{width: 90%;margin: 20px 5%;line-height: 20px;}
		.checkbox_div input[type='checkbox']{display:none;} 
		.checkbox_div .checkbox{width: 15px;height: 15px;border: 1px solid #535353;float: left;margin: 2px 5px auto auto;}
		.checkbox_div .checked_img{border: #535353 solid;border-width:2px 2px 0 0;width: 10px;height: 10px;position:absolute;
		transform:rotate(135deg);-webkit-transform:rotate(135deg);-ms-transform:rotate(135deg);display: inline-block;margin: 2px auto auto 2.5px;display:none;}
	.grace-applicant-info li {
    font-size: 1.42em;
	}
	</style>
</head>
</head>
<body  onload="backshow()">
	<div class="grace-head"></div>
	<ul class="grace-top-menu">
		<li>填写信息</li>
		<li>健康告知</li>
		<li class="menu-select">确认投保</li>
		<li>在线缴费</li>
	</ul>
	<div class="grace-info-tl" style="border: none;">投保人信息</div>
	<ul class="grace-form">
		<li>
			<div class="pull-left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
				:</div>
			<div class="pull-right">${applicantInsured.name}</div>
		</li>
		<li>
			<div class="pull-left">证件类型 :</div>
			<div class="pull-right">${identifytype1}</div>
		</li>
		<li>
			<div class="pull-left">出生日期 :</div>
			<div class="pull-right">${applicantInsured.identifynumber}</div>
		</li>
		<li>
			<div class="pull-left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别
				:</div>
			<div class="pull-right">${sex1}</div>
		</li>
		<li>
			<div class="pull-left">手机号码 :</div>
			<div class="pull-right">${applicantInsured.mobile}</div>
		</li>
		<li>
			<div class="pull-left">电子邮箱 :</div>
			<div class="pull-right">${applicantInsured.email}</div>
		</li>
		<li>
			<div class="pull-left">通讯地址 :</div>
			<div class="pull-right">${applicantInsured.address}</div>
		</li>
	</ul>
	<div class="grace-info-tl" style="border: none;">被保人信息</div>
	<ul class="grace-form">
		<li>
			<div class="pull-left" >与投保人关系 :</div>
			<div class="pull-right" >${insrelationapp}</div>
		</li>
		<li>
			<div class="pull-left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
				:</div>
			<div class="pull-right">${recognizee.name}</div>
		</li>
		<li>
			<div class="pull-left">证件类型 :</div>
			<div class="pull-right">${identifytype2}</div>
		</li>
		<li>
			<div class="pull-left">证件号码 :</div>
			<div class="pull-right">${recognizee.identifynumber}</div>
		</li>
		<li>
			<div class="pull-left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别
				:</div>
			<div class="pull-right">${sex2}</div>
		</li>
		<li>
			<div class="pull-left">出生日期 :</div>
			<div class="pull-right">${birthday2}</div>
		</li>
	</ul>
	<div class="grace-info-tl" style="border: none;">受益人信息</div>
	<ul class="grace-applicant-info" >
		<li>受益人</li>
		<li>被保险人本人</li>
	</ul>


	<%
		if (request.getAttribute("flag").equals("1")) {
	%>
	<div class="grace-info-tl" style="border: none;">续保选择</div>
	<ul class="grace-applicant-info">
		<li>续保缴费银行</li>
		<li><c:if test="${policy.bankBranchCode eq '130102'}">工商银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100103'}">农业银行</c:if>
							<c:if test="${policy.bankBranchCode eq '130104'}">中国银行</c:if>
							<c:if test="${policy.bankBranchCode eq '130105'}">建设银行</c:if>
							<c:if test="${policy.bankBranchCode eq '130302'}">中信银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100303'}">光大银行</c:if>
							<!--<c:if test="${policy.bankBranchCode eq '100304'}">华夏银行</c:if>-->
							<!--<c:if test="${policy.bankBranchCode eq '100305'}">民生银行</c:if>-->
							<c:if test="${policy.bankBranchCode eq '100307'}">平安银行</c:if>
							<c:if test="${policy.bankBranchCode eq '130308'}">招商银行</c:if>
							<!--<c:if test="${policy.bankBranchCode eq '100309'}">兴业银行</c:if>-->
							<c:if test="${policy.bankBranchCode eq '100310'}">浦发银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100306'}">广发银行</c:if>
							<c:if test="${policy.bankBranchCode eq '090004'}">中信银行信用卡</c:if>
							<c:if test="${policy.bankBranchCode eq '100403'}">邮政储蓄银行</c:if>
							<c:if test="${policy.bankBranchCode eq '100301'}">交通银行</c:if>
						</li>
	</ul>
	<ul class="grace-applicant-info">
		<li>续保缴费账号</li>
		<li>${policy.bankAccountNumber}</li> 
	</ul>
	<%
		}
	%>
	<%
		if (request.getAttribute("flag1").equals("1")) {
	%>
	<div class="grace-info-tl" style="border: none;">推荐人信息</div>
	<ul class="grace-applicant-info">
		<li>推荐人编码</li>
		<li>${policy.agentcode}</li>
	</ul>
	<%
		}
	%>

	<div class="choose-con2">
		<form>
			<input type="checkbox" id="checkboxsure" style="width: 25px;height: 25px;
"/>
			<div class="checkbox" >
  			<span class="checked_img"> 我已阅读<a href="<%=request.getContextPath()%>/global/global/pdf/know/web/pdf/know.pdf">《人身保险投保提示、人身保险产品风险提示书、投保须知、客户声明及自动转账授权声明》、</a>
			<a href="<%=request.getContextPath()%>/global/global/pdf/clause/web/pdf/clause.pdf">《瑞泰成长卫士少儿重大疾病保险条款》</a>，理解并同意其全部内容。我已阅读并认可上述文件中关于最高累计保额的规定，如出现超保额投保，本人授权瑞泰人寿将超保额投保的保单做全额退保处理。
		</span>
  		</div>
		</form>
	</div>
	<div class="next-button" style="margin-bottom: 90px;padding-bottom: 90px;">
		<img src="<%=request.getContextPath()%>/uinew/images/nextbutton.jpg"
			width="100%" alt="" onclick="underwriting()" />
	</div>
			<div class="footer footer-fixed">
		<img src="<%=request.getContextPath()%>/uinew/images/bottom-line.jpg"
			alt="" />
	</div>
		
<!-- 	<div class="notice_btn" onclick="underwriting();">下一步：在线支付</div> -->
	
  	<script src="<%=request.getContextPath() %>/resources/lib/common/main.js?${random}"></script>
 	<script src="<%=request.getContextPath() %>/resources/lib/component/modal.js"></script>
  	<!--
  	<jsp:include page="../../common/common-modal.jsp"></jsp:include>
  			-->
		
<!-- 		提示框 -->
		<div class="modal fade" data-rule="alert" id="modal_alert">
			<div class="modal-dialog alert">
				<div class="modal-header clearfix"><span data-title="modal">提示信息</span><a type="button" class="close" data-dismiss="modal"></a></div>
				<div class="modal-content" data-content="modal"></div>
				<div class="modal-footer">
					<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
				</div>
			</div>
		</div>
		
<!-- 		提示框 -->
		<div class="modal fade" data-rule="notice" id="modal_notice">
			<div class="modal-dialog alert">
				<div class="modal-header clearfix"><span data-title="modal">提示信息</span></div>
				<div class="modal-content" data-content="modal"></div>
				<div class="modal-footer"></div>
			</div>
		</div>
				
 <!-- 		对话框 -->
		<div class="modal fade" data-rule="dialog">
			<div class="modal-dialog alert">
				<div class="modal-header clearfix">提示信息</div>
				<div class="modal-content" data-content="modal"></div>
				<div class="modal-footer">
					<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok">确定</a>
					<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel">取消</a>
				</div>
			</div>
		</div>
		
		<!-- 		支付选择对话框 -->
<!-- 		<div class="modal fade" data-rule="dialog"> -->
<!-- 			<div class="modal-dialog alert"> -->
<!-- 				<div class="modal-header clearfix">提示信息</div> -->
<!-- 				<div class="modal-content" data-content="modal"></div> -->
<!-- 				<div class="modal-footer"> -->
<!-- 					<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok">已完成付款</a> -->
<!-- 					<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel">选择其他支付方式</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
<!-- 		加载等待框 -->
		<div class="modal fade" data-rule="loading" id="modal_loading">
			<div class="modal-dialog loading">
				<div class="modal-content" data-content="modal"  style="height: 0;border: 0;">
					<p class="loader8">加载中......</p>
				</div>
			</div>
		</div>
		<script>
		
// 			modal_alert('内容XXX');
// 			modal_alert('内容XXX',function(){
// 				//TODO
// 			});
// 			modal_alert({
// 				content:'内容XXX',
// 				btn:'确定'
// 			});
// 			modal_alert({
// 				content:'内容XXX',
// 				btn:'确定',
// 				title:'标题',
// 				callback:function(){
// 					//TODO
// 				}
// 			});

// 			modal_dialog('内容XXX',function(){
// 				//TODO  
// 				//okBtn Function
// 			},function(){
// 				//TODO  
// 				//cancelBtn Function
// 			});

//			开启加载浮层
//			modal_loading();

//			关闭加载浮层
//			modal_loading('hide');

		</script>

</body>
<script type="text/javascript">
	
	$(".checkbox").click(function(){
		if($(this).prev().prop("checked")==false){
			$(this).find(".checked_img").show();
			$(this).prev().prop("checked",true);
		}else{
			$(this).find(".checked_img").hide();
			$(this).prev().prop("checked",false);
		}
	});	
	
	
	  //核保
	  function underwriting(){
	  		 modal_loading();
		  var flag = document.getElementById("checkboxsure").checked;
		  
		  if(!flag){
			  alert("请您阅读《投保须知》、《投保声明》、《瑞泰成长卫士少儿重大疾病保险条款》。");
			  modal_loading('hide');
			  return;
		  }else if('${recognizee.name}'=='${applicantInsured.name}'){
			  alert("投被保人的姓名不能一致");
			  modal_loading('hide');
			  return;
		  }else{
		  modal_loading();
			  $.ajax({
				   type:"POST",
				   url:contentRootPath+"/msl/sales/longPolicyInsureSubmit",
				   data:{
				   },
				   dataType:"json",
				   success:function(data){
					   if(data.flag=="0"){
						   document.getElementById("checkboxsure").checked=false;
// 						  window.location.href =contentRootPath+'/msl/sales/pay';
 						  window.location.href =contentRootPath+'/msl/sales/toTestSuccess?source=changxian';
					   }else if(data.flag=="1"){
						   alert(data.content);
						   modal_loading('hide');
					   }
					}
				});   
		  }
	  }
	
	function backshow(){
		var checked = $("#checkboxsure").prop("checked");
		if(checked){
			$("#checkboxsure").next().find(".checked_img").show();
		}
	  }
	
</script>
</html>

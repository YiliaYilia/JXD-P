<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<%@ include file="../../common/rels.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>自助理赔申请</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport"/>
<meta name="format-detection" content="telephone=no" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/compensation/compensation.css" type="text/css"></link>
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/compensation/stepone.js"></script>
<script type="text/javascript">
	function fillStepone() {
		var policyCode = $('#policyCode').val();
		var claimManagementType = $('#claimManagementType').val();
		if (!check()) {
			return;
		}
		$.ajax({
			type : "POST",
			url : "${ctx}/msl/sales/isPolicyCodeAction",
			data : {
				"policyCode" : policyCode,
				"claimManagementType" : claimManagementType
			},
			dataType : "json",
			success : function(data) {
				if (data.flag == 'true') {
					//无未处理
					$("#creator").submit();
				} else {
					var flag = confirm("有未结案的相同保单号及索赔类别的报案,确定继续？");
					if (flag) {
						$("#creator").submit();
					} else {
						window.location.href = "${ctx}/msl/sales/menuClaimAction";
					}
				}
			}
		});
	}
</script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/uinew/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/uinew/css/style-font.css">
</head>
<body class="gray">
	<div class="grace-head"></div>

	<!--阶段标识区域-->
	<ul class="grace-top-menu2">
		<li class="menu-select">1.填写申请</li>
		<li>2.上传资料</li>
		<li>3.完成</li>
	</ul>
	<!--填写投保信息区域-->

	<div class="panel-collapse collapse in cardcontent">

		<form
			action="<%=request.getContextPath()%>/msl/sales/fillSteponeClaimAction"
			method="post" id="creator" name="creator"
			enctype="multipart/form-data">
			<ul class="grace-form">
				<li>
					<div class="pull-left">保险单号 :</div>
					<div class="pull-right">
						<select class="form-control" id="policyCode" name="geClaimManagement.policyCode">
							<c:forEach var="policy" items="${policyList}">
								<option value="${policy.policyNum}">${policy.policyNum}</option>
							</c:forEach>
						</select>
					</div>
				</li>
				<li>
					<div class="pull-left">申请人 :</div>
					<div class="pull-right">
						<input type="text" id="name" name="geClaimManagement.name"
							type="text" value="" />
					</div>
				</li>
				<li>
					<div class="pull-left" style="width:35%">与被保险人关系 :</div>
					<div class="pull-right" style="width:65%;">
						<select class="form-control" id="insrelationApp"
							name="geClaimManagement.insrelationApp">
							<option value="SF">本人</option>
							<option value="FA">父亲</option>
							<option value="MO">母亲</option>
						</select>
					</div>
				</li>

				<li>
					<div class="pull-left">索赔类别 :</div>
					<div class="pull-right">
						<select class="form-control" id="claimManagementType"
							name="geClaimManagement.claimManagementType">
							<option value="">请选择</option>
							<option value="1">住院津贴</option>
							<option value="2">医疗报销</option>
							<option value="3">重大疾病</option>
							<option value="4">伤残</option>
							<option value="5">身故</option>
						</select>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<!-- 按钮区域 -->
	<div class="next-button" onclick="fillStepone()">
		<img src="${ctx}/uinew/images/button.jpg" width="100%" alt="" />
	</div>
	<div class="footer footer-fixed ">
		<img src="${ctx}/uinew/images/bottom-line.jpg" alt="" width="100%" />
	</div>
	<jsp:include page="../../common/common-modal.jsp"></jsp:include>
</body>
<script type="text/javascript">
 	 <c:if test="${Contenct!=null}">
		$(document).ready(function(){
			alert('${Contenct}');
			window.location.href="<%=request.getContextPath()%>/msl/sales/menuClaimAction";
		});	
	</c:if>
</script>
</html>
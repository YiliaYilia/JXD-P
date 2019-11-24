<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript">
	function back() {
		 var title = $('.tabs-inner').children("span").text();
		window.parent.$('#mainTab').tabs('close',title); 
		//window.location.href = '../system/GeChannelForm'; 
	}

	$(function() {
		$(".imgList").click(function() {
			$("#imgbox-overlay").show();
			$("#imgbox-wrap").show();
			$(".img-overlay").prop("src", $(this).attr("src"));
		});
		$(".img-overlay").click(function() {
			$("#imgbox-overlay").hide();
			$("#imgbox-wrap").hide();
		});
	});
</script>
<style>
.imgList {
	width: 60px;
	height: 60px;
	margin-right: 5%;
}

#imgbox-overlay {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	z-index: 80;
	opacity: 0.5;
	display: none;
}

#imgbox-wrap {
	position: absolute;
	top: 0;
	left: 0;
	z-index: 90;
	width: 100%;
	height: 100%;
	display: none;
}

#imgbox-wrap img {
	display: block;
	margin: auto;
	height: 100%;
}
</style>
</head>
<body>
	<input type="hidden" id="code" name="code" value="">
	<div id="imgbox-overlay"></div>
	<div id="imgbox-wrap">
		<img class="img-overlay" />
	</div>
	<div id="claimInfo" class="easyui-tabs"
		data-options="tabPosition:'top',fit:true,plain:true,border:false">
		<c:if test="${logo==null }">
			<div title="渠道详情" data-options="fit:true">
				<table class="easyui-propertygrid" id="basic">
					<tr>
						<td></td>
						<td>产品名称</td>
						<td><dict:span dictCode="${geChannel.policyName }"
								typeCode="LONGPRODUCTNAME" type="span"></dict:span></td>
					</tr>
					<tr>
						<td></td>
						<td>机构名称</td>
						<td><c:forEach items="${geDepartments}" var="geDepartment">
								<c:if test="${geChannel.deptCode == geDepartment.deptCode}">${geDepartment.deptname}</c:if>
							</c:forEach></td>
					</tr>
					<tr>
						<td></td>
						<td>合作伙伴代码</td>
						<td>${geChannel.channelCode }</td>
					</tr>
					<tr>
						<td></td>
						<td>合作伙伴名称</td>
						<td>${geChannel.channelName }</td>
					</tr>
					<tr>
						<td></td>
						<td>产品链接</td>
						<td>
							<input style="width: 100%;" type="text" disabled="disabled" value="${geChannel.policyUrl }">
						</td>
					</tr>
					<tr>
						<td></td>
						<td>首页图片</td>
						<td>
							<div style="width: 100%; height: 100%; overflow-y: scroll;">
								<img src="${geChannel.imgUrl }" alt="产品图" class="imgList" />
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>产品二维码图片</td>
						<td>
							<div style="width: 100%; height: 100%; overflow-y: scroll;">
								<img src="${geChannel.policyMatrix }" alt="二维码图" class="imgList" />
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>推荐人是否必填</td>
						<td><c:if test="${geChannel.isAgentcode == '1'}">必填</c:if> <c:if
								test="${geChannel.isAgentcode == '0'}">可选</c:if></td>
					</tr>
				</table>
			</div>
		</c:if>
		<c:if test="${logo=='1' }">
			<div title="增加渠道信息" data-options="fit:true">
				<form name="addForm" action="../system/addGeChannelData"
					method="post" enctype="multipart/form-data">
					<table class="easyui-propertygrid" id="basic">
						<tr>
							<td></td>
							<td>产品名称</td>
							<td><dict:select id="policyName" typeCode="LONGPRODUCTNAME"
									pleaseChoose="true" name="geChannel.policyName"
									style="width: 200px;height:22px;"></dict:select></td>
						</tr>
						<tr>
							<td></td>
							<td>机构名称</td>
							<td><select id="deptCode" name="geChannel.deptCode"
								onchange="deptCodeCheck();">
									<option value="">请选择</option>
									<c:forEach items="${geDepartments}" var="geDepartment">
										<option value="${geDepartment.deptCode}">${geDepartment.deptname}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td>合作伙伴代码</td>
							<td><input id="channelCode" type="text"
								name="geChannel.channelCode" onchange="channelCodeCheck();" /></td>
						</tr>
						<tr>
							<td></td>
							<td>合作伙伴名称</td>
							<td><input type="text" id="channelName"
								name="geChannel.channelName" onchange="channelNameCheck();" /></td>
						</tr>
						<tr>
							<td></td>
							<td>首页图片路径</td>
							<td><input type="file" name="file" id="file"></td>
						</tr>
						<tr>
							<td></td>
							<td>推荐人是否必填</td>
							<td><input type="radio" name="geChannel.isAgentcode"
								value="1" />必填 <input type="radio" name="geChannel.isAgentcode"
								checked="checked" value="0" />可选</td>
						</tr>
					</table>
					
					<input type="button" value="返回" onclick="back();"> <input
						type="button" value="提交" onclick="addCheck();"> <input
						type="reset" value="重置">

				</form>
			</div>
		</c:if>
		<c:if test="${logo=='2' }">
			<div title="修改渠道信息" data-options="fit:true">
				<form name="updateForm" action="../system/updateGeChannelData"
					method="post" enctype="multipart/form-data">
					<table class="easyui-propertygrid" id="basic">
						<tr>
							<td></td>
							<td>产品名称</td>
							<td><input type="hidden" id="id" name="geChannel.id"
								value="${geChannel.id }" /> <dict:select id="policyName"
									typeCode="LONGPRODUCTNAME"
									defaultValue="${geChannel.policyName }" pleaseChoose="true"
									name="geChannel.policyName" style="width: 200px;height:22px;"></dict:select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>机构名称</td>
							<td><select id="deptCode" name="geChannel.deptCode"
								onchange="deptCodeCheck();">
									<option value="">请选择</option>
									<c:forEach items="${geDepartments}" var="geDepartment">
										<option
											<c:if test="${geChannel.deptCode == geDepartment.deptCode}">selected="selected"</c:if>
											value="${geDepartment.deptCode}">${geDepartment.deptname}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td>合作伙伴代码</td>
							<td><input disabled="disabled" type="text"
								value="${geChannel.channelCode }" /> <input type="hidden"
								id="channelCode" name="geChannel.channelCode"
								value="${geChannel.channelCode }"></td>
						</tr>
						<tr>
							<td></td>
							<td>合作伙伴名称</td>
							<td><input id="channelName" type="text"
								name="geChannel.channelName" value="${geChannel.channelName }"
								onchange="channelNameCheck();" /></td>
						</tr>
						<tr>
							<td></td>
							<td>首页图片路径</td>
							<td><input type="file" name="file" id="file"
								value="${geChannel.imgUrl }"> <input type="hidden"
								name="geChannel.imgUrl" value="${geChannel.imgUrl }" /></td>
						</tr>
						<tr>
							<td></td>
							<td>推荐人是否必填</td>
							<td><input type="radio" name="geChannel.isAgentcode"
								<c:if test="${geChannel.isAgentcode == '1'}">checked="checked"</c:if>
								value="1" />必填 <input type="radio" name="geChannel.isAgentcode"
								<c:if test="${geChannel.isAgentcode == '0'}">checked="checked"</c:if>
								value="0" />可选</td>
						</tr>
					</table>

					<input type="button" value="返回" onclick="back();"> <input
						type="button" value="提交" onclick="updateCheck();"> <input
						type="reset" value="重置">

				</form>
			</div>
		</c:if>
	</div>
</body>
<script type="text/javascript">
	function submitCheck1() {
		var policyName = $("#policyName").val();//产品名称
		var deptCode = $("#deptCode").val();//机构名称
		var channelCode = $("#channelCode").val();//合作伙伴代码
		var channelName = $("#channelName").val();//合作伙伴名称
		var file = $("#file").val();//首页图片路径
		var regcode = /^[a-zA-Z0-9]+$/;
		if (policyName == "" || policyName == null) {
			alert("产品名称不能为空");
			return false;
		}
		if (deptCode == "" || deptCode == null) {
			alert("机构名称不能为空");
			return false;
		}
		if (!regcode.test(channelCode)) {
			alert("合作伙伴代码为5~15位字母和数字");
			return false;
		}
		if (channelCode.length > 15 || channelCode.length < 5) {
			alert("合作伙伴代码为5~15位字母和数字");
			return false;
		}
		if (channelName == "" || channelName == null) {
			alert("合作伙伴名称不能为空");
			return false;
		}
		//if(file==""||file==null){
		//alert("首页图片路径不能为空");
		//return false;
		//}
		return true;
	}

	function submitCheck() {
		var policyName = $("#policyName").val();//产品名称
		var deptCode = $("#deptCode").val();//机构名称
		var channelCode = $("#channelCode").val();//合作伙伴代码
		var channelName = $("#channelName").val();//合作伙伴名称
		var file = $("#file").val();//首页图片路径
		var regcode = /^[a-zA-Z0-9]+$/;
		if (policyName == "" || policyName == null) {
			alert("产品名称不能为空");
			return false;
		}
		if (deptCode == "" || deptCode == null) {
			alert("机构名称不能为空");
			return false;
		}
		if (!regcode.test(channelCode)) {
			alert("合作伙伴代码为5~15位字母和数字");
			return false;
		}
		if (channelCode.length > 15 || channelCode.length < 5) {
			alert("合作伙伴代码为5~15位字母和数字");
			return false;
		}
		if (channelName == "" || channelName == null) {
			alert("合作伙伴名称不能为空");
			return false;
		}
		if (file == "" || file == null) {
			alert("首页图片路径不能为空");
			return false;
		}
		return true;
	}

	function addCheck() {
		if (submitCheck()) {
			var policyName = $("#policyName").val();//产品名称
			var channelCode = $("#channelCode").val();//合作伙伴代码
			$.ajax({
				type : "POST",
				url : "${ctx}/system/addCheck",
				data : {
					"policyName" : policyName,
					"channelCode" : channelCode
				},
				dataType : "json",
				success : function(res) {
					if (res.info == "1") {
						alert("此产品中已有该合作伙伴代码");
						return;
					}
					if (res.mes == "3") {
						alert("机构中无此合作伙伴");
						return;
					} else {
							ECSINFO.showAddSuccess();
							addForm.submit();
					}
				},
				error : function() {
					alert('验证异常');
					return;
				}
			});

		}
	}

	function updateCheck() {
		if (submitCheck1()) {
			var policyName = $("#policyName").val();//产品名称
			var channelCode = $("#channelCode").val();//合作伙伴代码
			var id = $("#id").val();//id
			$.ajax({
				type : "POST",
				url : "${ctx}/system/addCheck",
				data : {
					"policyName" : policyName,
					"channelCode" : channelCode,
					"id" : id
				},
				dataType : "json",
				success : function(res) {
					if (res.info == "1") {
						alert("此产品中已有该合作伙伴代码");
						return;
					}
					if (res.mes == "3") {
						alert("机构中无此合作伙伴");
						return;
					} else {
							ECSINFO.showUpdateSuccess();
							updateForm.submit();
					}
				},
				error : function() {
					alert('验证异常');
					return;
				}
			});
		}
	}

	function policyNameCheck() {
		var policyName = $("#policyName").val();//产品名称
		if (policyName == "" || policyName == null) {
			alert("产品名称不能为空");
			return false;
		}
		return true;
	}

	function deptCodeCheck() {
		var deptCode = $("#deptCode").val();//机构名称
		if (deptCode == "" || deptCode == null) {
			alert("机构名称不能为空");
			return false;
		}
		return true;
	}

	function channelCodeCheckTest() {
		var channelCode = $("#channelCode").val();//合作伙伴代码
		var regcode = /^[a-zA-Z0-9]+$/;
		if (!regcode.test(channelCode)) {
			alert("合作伙伴代码为5~15位字母和数字");
			return false;
		}
		if (channelCode.length > 15 || channelCode.length < 5) {
			alert("合作伙伴代码为5~15位字母和数字");
			return false;
		}
		return true;
	}
	function channelCodeCheck() {
		var policyName = $("#policyName").val();//产品名称
		var channelCode = $("#channelCode").val();//合作伙伴代码
		if (!policyNameCheck()) {
			return;
		}
		if (channelCodeCheckTest()) {
			$.ajax({
				type : "POST",
				url : "${ctx}/system/addCheck",
				data : {
					"policyName" : policyName,
					"channelCode" : channelCode
				},
				dataType : "json",
				success : function(res) {
					if (res.info == "1") {
						alert("此产品中已有该合作伙伴代码");
						return;
					}
					if (res.mes == "3") {
						alert("机构中无此合作伙伴");
						return;
					} else {
						return;
					}
				},
				error : function() {
					alert('验证异常');
					return;
				}
			});
		}
	}

	function channelNameCheck() {
		var channelName = $("#channelName").val();//合作伙伴名称
		if (channelName == "" || channelName == null) {
			alert("合作伙伴名称不能为空");
			return false;
		}
	}
</script>
</html>
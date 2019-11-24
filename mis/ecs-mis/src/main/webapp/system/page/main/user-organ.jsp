<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机构树</title>
<script type="text/javascript" src="${ctx }/system/js/organ/organTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/easyui-extend.js"></script>
<style type="text/css">
</style>
</head>
<body>
	<div title="所属机构" style="background-color: #FFFFFF;height:95%;padding-left: 30px;padding-top: 10px;">
		<ul id="organ" class="easyui-tree"></ul>
	</div>
	<script type="text/javascript">
		$("document").ready(function(){
			var userid = $("#userid").val();
			var operate = $("#operate").val();
			var data = "operate="+operate;
			var checkbox = operate != undefined;
			if(operate == 'add'){
			}else{
				data = data + "&userid="+userid;
			}
			$.ajax({
				type:"POST",
				url:"${ctx}/system/organResource",
				data:data,
				success:function(data){
					$('#organ').tree({    
						data: convert(data),
						animate:true,
						lines:true,
						checkbox:checkbox
					});
					if(checkbox != true){
						$('#organ').tree('expandAll');
					}
				},
				error:function (XMLHttpRequest, textStatus, errorThrown){
					$.messager.alert('系统异常','系统异常,请稍后再试');
				}
			});
		});
		
	</script>
</body>
</html>
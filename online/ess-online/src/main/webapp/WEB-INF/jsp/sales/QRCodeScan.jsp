<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
<%@ include file="../common/rels.jsp"%>
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	var wait=setInterval(function() { 
		checkSuccess();
	}, 1000); 
	
	function  checkSuccess(){
		$.ajax({
			type : "POST",
			url : contentRootPath + "/msl/sales/paySuccess",
			data : {},
			dataType : "json",
			success : function(data) {
				if(data.succeed){
					clearTimeout(wait);
					window.location.href =contentRootPath+"/msl/sales/waiting";
				}
			}
		});
	}
}); 
</script>
<body>
<img  style="height:300px;width:300px" src="${ctx}/msl/sales/QRCodeInit" />  
</body>
</html>
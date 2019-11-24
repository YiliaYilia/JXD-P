<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/page/common.jsp" %>

<script type="text/javascript">
	 var result = "<%=request.getAttribute("text")%>";
	 if(result!="null"){
		 if(result=="success"){
			 alert("上传成功" );
		 }else{
			 alert("上传失败");
		 }
		 
	 }
	 
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>名单上传</title>
</head>
<body onload="checkText();">
 <form action="../business/upload" method="post" enctype="multipart/form-data"> 
        选择文件<input type="file" name="file" id="file"> 
       <input type="submit" value="上传">
   </form>
</body>


</html>
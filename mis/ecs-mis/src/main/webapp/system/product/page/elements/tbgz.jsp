<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/product/js/elements/tbgz.js"></script>
<title>投保告知</title>
</head>
<body>
<table id="tbgzOptions" width="100%"></table>
<script type="text/javascript">
	tbgz.coreproductcode = '${coreproductcode }';
	$(document).ready(function(){
		tbgz.createDataGrid();
	});
</script>
<div id="tbgz_operate_window" style="display: none;background-color:white;overflow:hidden;"></div>
</body>
</html>
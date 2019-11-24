<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="core" %>
<%@ taglib prefix="fmt" uri="fmt" %>
<%@ taglib prefix="fn" uri="fn" %>
<%@ taglib prefix="auth" uri="springsecurity" %>
<%@ taglib prefix="dict" uri="dict" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<link rel="stylesheet" type="text/css" href="${ctx }/common/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx }/common/css/niceValidate/jquery.validator.css">
<link rel="stylesheet" type="text/css" href="${ctx }/common/css/themes/default/easyui.css">
<script type="text/javascript" src="${ctx }/common/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx }/common/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }/common/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx }/common/js/jquery.validator.js"></script>
<script type="text/javascript" src="${ctx }/common/js/zh_CN.js"></script>
<script type="text/javascript" src="${ctx }/common/js/open.js"></script>

<!-- my97日历空控件 -->
<script type="text/javascript" src="${ctx }/common/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="${ctx }/system/js/language/ecs_zh.js"></script>
<script type="text/javascript" src="${ctx }/system/js/easyui-extend.js"></script>
<!-- 加入js权限校验 用法 var auth = new Auth(); auth.access('权限编码'); -->
<auth:script></auth:script>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="core" %>
<%@ taglib prefix="fmt" uri="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="dict" uri="dict" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${ctx}/common/css/niceValidate/jquery.validator.css">

<script type="text/javascript" src="${ctx}/common/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx}/common/js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/common/js/validate/additional-methods.js"></script>
<script type="text/javascript" src="${ctx}/common/js/validate/messages_zh.js"></script>

<%@ include file="/common/page/common.jsp"%>
<c:if test="${Contenct!=null}">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="${ctx}/global/js/layer/layer.min.js"></script>
<script type="text/javascript">  
layer.alert('${Contenct}', 12); 
</script>
</c:if>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品详情配置页面</title>
<script type="text/javascript" src="${ctx }/common/js/fckeditor/fckeditor.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/elements/bdpz.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/elements/occupationTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/common/js/json2.min.js"></script>
<script type="text/javascript" src="${ctx }/common/js/jquery.form2json.js"></script>

<script type="text/javascript" src="${ctx }/system/product/js/elements/elements.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/elements/tbgz.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/risk/riskDuty.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/risk/riskDutyTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/elements/productBaseInfo.js"></script>
<script type="text/javascript" src="${ctx }/common/js/uuid.js"></script>
<script type="text/javascript" src="${ctx }/system/js/easyui-extend.js"></script>
<script type="text/javascript">
$(function(){
	$('#productConfitTab').tabs({    
	    onSelect:function(title){ 
	    	//alert(policyConfigLoadCount);
	        if(title=='保单配置'){
	        	if(policyConfigLoadCount>0){
	        	//.panel('refresh');
	        		var policyConfigTabNameObj=$("#policyConfigTabName");
	        		if(policyConfigTabNameObj.length>0){
		        		$('#productConfitTab').tabs('getTab',policyConfigTabNameObj.val()).panel('refresh');
	        		}
	        	}
	        }
	        return false;
	    }
	
	});
	
	
});
var policyConfigLoadCount = 0;//
function loadPolicyConfig(){
	policyConfigLoadCount++;
}
function message(message){
	elementsUtil.message(message);
}
</script>

</head>
<body>
	<div id="productConfitTab" class="easyui-tabs" data-options="tabPosition:'top',fit:true" >
		<div title="产品基本配置" data-options="fit:true,href:'${ctx }/system/product/productBaseInfo?coreproductcode=${geProductMain.coreproductcode}',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#productConfitTab').tabs('getTab','产品基本配置').panel('refresh');}}]">  
		</div>
				
				
				 
    
			<c:forEach items="${elements}" var="element">
				<c:if test="${element.webflowpageelementcode=='BFSS' }">
						<div title="${element.webflowpageelementname }" lable="保费试算配置" data-options="href:'${ctx }/system/product/bfss?coreproductcode=${geProductMain.coreproductcode}&elementcode=${element.webflowpageelementcode }',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#productConfitTab').tabs('getTab','${element.webflowpageelementname }').panel('refresh');}}] ">  
						</div>
				</c:if>
				<c:if test="${element.webflowpageelementcode=='FXPGWJ' }">
						<div title="${element.webflowpageelementname }" lable="风险评估问卷" data-options="href:'${ctx }/system/product/fxpgwj?coreproductcode=${geProductMain.coreproductcode}',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#productConfitTab').tabs('getTab','${element.webflowpageelementname }').panel('refresh');}}]">  
						</div>
				</c:if>
				<c:if test="${element.webflowpageelementcode=='BXJH' }">
						<div title="${element.webflowpageelementname }" lable="保险计划" data-options="href:'${ctx }/system/product/bxjh?coreproductcode=${geProductMain.coreproductcode}',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#productConfitTab').tabs('getTab','${element.webflowpageelementname }').panel('refresh');}}]">  
						</div>
				</c:if>
				<c:if test="${element.webflowpageelementcode=='BDPZ' }">
						<div title="${element.webflowpageelementname }" lable="保单配置" data-options="href:'${ctx }/system/product/bdpz?coreproductcode=${geProductMain.coreproductcode}',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#productConfitTab').tabs('getTab','${element.webflowpageelementname }').panel('refresh');}}]">  
						</div>
						<input type="hidden" id="policyConfigTabName" value="${element.webflowpageelementname }" />
				</c:if>
				<c:if test="${element.webflowpageelementcode=='FLSM' }">
						<div title="${element.webflowpageelementname }" lable="法律声明" data-options="href:'${ctx }/system/product/flsm?coreproductcode=${geProductMain.coreproductcode}&elementcode=${element.webflowpageelementcode }',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#productConfitTab').tabs('getTab','${element.webflowpageelementname }').panel('refresh');}}]">  
						</div>
				</c:if>
				<c:if test="${element.webflowpageelementcode=='TBGZ' }">
						<div title="${element.webflowpageelementname }" lable="投保告知" data-options="href:'${ctx }/system/product/tbgz?coreproductcode=${geProductMain.coreproductcode}',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#tbgzOptions').datagrid('load');$('#tbgzOptions').datagrid('clearChecked');}}]">  
						</div>
				</c:if>
				<c:if test="${element.webflowpageelementcode=='TBSM' }">
						<div title="${element.webflowpageelementname }" lable="投保声明" data-options="href:'${ctx }/system/product/tbsm?coreproductcode=${geProductMain.coreproductcode}&elementcode=${element.webflowpageelementcode }',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#productConfitTab').tabs('getTab','${element.webflowpageelementname }').panel('refresh');}}]">  
						</div>
				</c:if>
			
			</c:forEach>
		
		<div title="总览" data-options="href:'${ctx }/system/product/zl?coreproductcode=${geProductMain.coreproductcode}',tools:[{iconCls:'icon-mini-refresh',handler:function(){$('#productConfitTab').tabs('getTab','总览').panel('refresh');}}]">  
		</div>
	</div>
	

</body>
</html>
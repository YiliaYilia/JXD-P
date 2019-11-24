/**
 * 根据枚举类型和枚举值获取枚举信息对页面元素Select框添加Option值
 * @param elementId
 * @param dataCode
 * @param dataCodeType
 */
function dataDictionaryAssignment(elementId, dataCodeType, dataCode) {
	$.ajax({
		 type: "POST",
		 url:contextPath + "/dataDictionary/findGeCodeByCodeAndCodeType.do",
	     dataType: "json",
	     cache: false,
	     data:{"dataCode": dataCode, "codeType":dataCodeType},
	     success:function(data){
	    	 for (var i = 0; i < data.geCodeList.length; i++) {
	    		 geCode = data.geCodeList[i];
	    		 if (i == 0) {
	    			 $("#" + elementId).append("<option value='" + geCode.id.codeCode + "' selected='selected'>" + geCode.codeCName + "</option>");
	    		 } else {
	    			 $("#" + elementId).append("<option value='" + geCode.id.codeCode + "'>" + geCode.codeCName + "</option>");
	    		 }
	    		 
	    	 }
	    }	
	});
}

/**
 * 
 * @param bussinessObj 业务对象
 * @param filedName 字段名字
 * @param elementId 页面元素ID
 * @param dataCodeType 数据类型
 * @param dataCode 数据代码
 */
function dataDictionaryAssignment(bussinessObj, filedName, elementId, dataCodeType, dataCode) {
	$.ajax({
		 type: "POST",
		 url:contextPath + "/dataDictionary/findGeCodeByCodeAndCodeType.do",
	     dataType: "json",
	     cache: false,
	     data:{"dataCode": dataCode, "codeType":dataCodeType},
	     success:function(data){
	    	 for (var i = 0; i < data.geCodeList.length; i++) {
	    		 geCode = data.geCodeList[i];
	    		 if (i == 0) {
	    			 bussinessObj[filedName] = geCode.id.codeCode;
	    		 }
	    		 $("#" + elementId).append("<option value='" + geCode.id.codeCode + "'>" + geCode.codeCName + "</option>");
	    	 }
	    }	
	});
}
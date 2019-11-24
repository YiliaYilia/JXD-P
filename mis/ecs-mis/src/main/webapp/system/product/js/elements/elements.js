var Elements = function(){};

/**
 * 其他配置(法律声明)
 * @param configType
 */
Elements.prototype.saveOtherConfig = function(configType){
	$("#"+configType+"_configcontent").val(FCKeditorAPI.GetInstance(configType).GetData());
    $("#"+configType).submit();
};

/**
 * 提示消息
 * @param manage
 */
Elements.prototype.message = function(message){
	if(message == true){
		ECSINFO.showAddSuccess();
	}else{
		ECSINFO.alert_system_error();
	}
};

var elementsUtil = new Elements();
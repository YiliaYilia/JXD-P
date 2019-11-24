function validateForm(ctx){
	$('#riskEvalueForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			risksurveyname: [/^[^<>]+$/, '不能出现<>字符'] //自定义EL表达式]
		},
		fields:{//那些字段要加入到规则中
			"riskEvalueName":{
				rule:"required;risksurveyname",
				tip: "不能出现<>字符"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			
			"topic":{
				rule:"required"
			},
		
			"optiondesc":{
				rule:"required"
			},
			"score":{
				rule:"required"
			}
		    
		},
		valid: function(form){ //验证成功
			var name = $("#riskEvalueName").val().replace(/\s+/g,"");//风险评估名称
			var topics = $(".topicClass");
			var data= "";
			data = "geRiskSurveys[0].risksurveyname="+name;
		
			for(var i=0;i<topics.length;i++){
				var topicNumber = $(topics[i]).children("input[name='topicno']").val();//题号
				var topicContext =  $(topics[i]).children("input[name='topic']").val();//提名
			//	var isanswer =   $(topics[i]).children("input[name='isanswer']:checked");//是否必答
				var isanswer = $(topics[i]).children("input[name='isanswer']").attr("checked");
				if(isanswer){
					isanswer = 1;
				}
				else{
					isanswer = 0;
				}
				data = data+'&geRiskSurveys[0].geRiskSurveySubjects['+i+'].topicno='+topicNumber
					+'&geRiskSurveys[0].geRiskSurveySubjects['+i+'].topic='+topicContext
					+'&geRiskSurveys[0].geRiskSurveySubjects['+i+'].isanswer='+isanswer;
			
				var topicArea =  $(topics[i]).children(".topic_option_div");
				var options = $(topicArea).children();
				for(var j=0;j<options.length;j++){//遍历各个题目下的选项、选项描述、分值
					var option = options[j];
					var optionNumber = $(option).children("input[name='serialo']").val();
					var optionValue =  $(option).children("input[name='optiondesc']").val();
					var optionScore = $(option).children("input[name='score']").val();
					//var optionVal = optionNumber+"-"+optionValue+"-"+optionScore+",";
					//optionVals += optionVal;
					data = data+'&geRiskSurveys[0].geRiskSurveySubjects['+i+'].geRiskSurveySubjectOptions['+j+'].serialo='+optionNumber
					+'&geRiskSurveys[0].geRiskSurveySubjects['+i+'].geRiskSurveySubjectOptions['+j+'].optioncontent='+optionValue
					+'&geRiskSurveys[0].geRiskSurveySubjects['+i+'].geRiskSurveySubjectOptions['+j+'].optionscore='+optionScore;
				}
		    }
		   data=data+"&coreproductcode="+$("#coreproductcode").val();
		   data = data.replace(/%/g, '％');
		   data = data+"&date="+new Date();
		    $.ajax({
		    	type:"POST",
		        url: ctx+"/system/product/doFxpgwj",
		        data:data,
		    	success:function(data){
		    		$("#productRiskSurveyTab").tabs('select',"风险评估配置");
		    		ECSINFO.showAddSuccess();
				},
				error:function (XMLHttpRequest, textStatus, errorThrown){
					ECSINFO.alert_system_error();
				}
		    });
			return false;
		},
		invalid: function(form){//验证失败
			$("#productRiskSurveyTab").tabs('select',"风险评估配置");
			return false;
		}
	});
}

var serialos = ["A","B","C","D","E","F",
                "G","H","I","J","K","L",
                "M","N","O","P","Q","R",
                "S","T","U","V","W","X","Y","Z"];
/**
*添加新题选项
*/
function addTopicOption(that){
	var _this = that;
	var currTopicSer = $(_this).prev().prev().prev().val(); //题号
	var currTopicOptionArea = $(_this).next().next().next();//当前该题选项的区域
	var optionNumber =currTopicOptionArea.children().length;  //目前共有多少选项
	if(optionNumber>25){
		alert("选项最多为24个");
		return ;
	}
	var serial = serialos[optionNumber];
	var currTopicOptionModel =$("#topic_option_model").html().replace("topicOption_model","topicOption_"+currTopicSer+"_"+serial).replace(/[#]/g,Math.random());
	currTopicOptionArea.append(currTopicOptionModel);
	$(".topicOption_"+currTopicSer+"_"+serial).children("strong").html(serial+"、");
	$(".topicOption_"+currTopicSer+"_"+serial).children("strong").next().val(serial);
   
}

/**
*删除新题选项
*/
function delTopicOption(that){
	
	var _this = that;
	var topicOption = $(_this).parent();
	var topicOptionArea = $(_this).parent().parent();
	topicOption.remove();
	var topicOptions = topicOptionArea.children();
	var currTopicSer = $(_this).parent().parent().prev().prev().prev().prev().prev().prev().val();
	for(var i =0;i<topicOptions.length;i++){
		var _topicOption = topicOptions[i];
		var serial = serialos[i];
		$(_topicOption).attr("class","topicOption_"+currTopicSer+"_"+serial);
		$(_topicOption).children("strong").html(serial+"、");
		$(_topicOption).children("strong").next().val(serial);
	}
}

/**
*添加新题
*/
function addTopic(){
	var currTopicModel = $("#topic_div_model").html().replace("topic_model","topicClass").replace(/[#]/g,Math.random());  //替换提根节点 class 属性
	var currTopicSer = $("#topics").length;
	$("#topics").append(currTopicModel);
	var topic = $("#topics").children("div").last();
	var length = $("#topics").children().size();
	topic.children("strong").html(length+"、");
	topic.children("strong").prev().val(length);
}

/**
*删除新题
*/
function delTopic(that){
	var _this = that;
	var topic = $(_this).parent();
	topic.remove();
	var topics = $("#topics").children();
	for(var i =0;i<topics.length;i++){
		var _topic = topics[i];
		$(_topic).children("strong").html((i+1)+"、");
		$(_topic).children("strong").prev().val((i+1));
	}
}


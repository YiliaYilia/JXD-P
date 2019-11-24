<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>风险评估问卷</title>
</head>
<body>
<script type="text/javascript" src="${ctx }/common/js/uuid.js"></script>
<script type="text/javascript" src="${ctx }/system/product/js/elements/fxpgwj.js"></script>
<script type="text/javascript" >
$(document).ready(function(){
	$('#productRiskSurveyTab').tabs({
		  border:false,    
		    onSelect:function(title){    
		        if(title=='保存提交'){
		        	$('#riskEvalueForm').submit();
		        }
		        return false;
		    }    
	});
	validateForm('${ctx}');
});
</script>
<div id="productRiskSurveyTab" class="easyui-tabs" data-options="fit:true,tabPosition:'left',headerWidth:100">
	<div title="风险评估配置" style="padding:20px;font-size: 13px;"> 
	<form name="riskEvalueForm" id="riskEvalueForm" autocomplete="off"> 
		<input type="hidden" id="coreproductcode" value="${geProductMain.coreproductcode}">
	  	<div style="width: 800px;">
	  	 <c:set var="riskname" value="${null}"></c:set>
			<c:forEach items="${geProductMain.geRiskSurveys }" var="risksurveyvalue" begin="0" end="1">
				<c:set var="riskname" value="${risksurveyvalue }"></c:set>
			</c:forEach>
	  		<fieldset>
			<legend>风险评估基本配置</legend>
				<div>
					风险评估名称:<input type="text" name="riskEvalueName" id="riskEvalueName" value="${riskname.risksurveyname }">
				</div>
			</fieldset>
			<br>
			<fieldset>
			<legend>风险评估问卷配置 <input type="button"  value="添加问题" onclick="addTopic();"></legend>
			    <div id="topics">
			    <c:forEach items="${geProductMain.geRiskSurveys }" var="risksurvey" begin="0" end="1">
	       		  <c:forEach items="${risksurvey.geRiskSurveySubjects }" var="risksubject" varStatus="subjectStatus">
					<div class="topicClass">
						<input type="hidden" style="border: 0;" value="${risksubject.topicno }" name="topicno"><!-- 题序列 如1、2、3 -->
						<strong>${risksubject.topicno }、</strong><!-- 题显示序列 -->
						<input type="text"  maxlength="500" style="width: 350px;" name="topic" id="topic${subjectStatus.index}" value="${risksubject.topic }" onkeyup="this.value =this.value.replace(/[\\^\\&]/g, '')" ><!-- 题目 -->
						<input type="button" value="添加问题选项" class="addOption" onclick="addTopicOption(this);">
						<input type="button" value="删除该问题" class="delOption" onclick="delTopic(this);">
						<input type="checkbox" <c:if test="${risksubject.isanswer eq '1'}">checked="checked"</c:if> value="Y" id="isanswer" name="isanswer">是否必答     <!-- 是否必答 -->
						<div class="topic_option_div"> <!-- 题选项区域 -->
						<c:forEach items="${risksubject.geRiskSurveySubjectOptions }" var="options" varStatus="optionStatus">
							<div class="topicOption_model" style="margin-left: 20px;"><br>
								<strong class="topic_option">${options.serialo }、</strong>
								<input type="hidden"  name="serialo" value="${options.serialo }"><!-- 题选项序号 -->
								<input type="text"  maxlength="500" style="width: 300px;" name="optiondesc" id="optiondesc${optionStatus.index} }"value="${options.optioncontent }" onkeyup="this.value =this.value.replace(/[\\^\\&]/g, '')"><!-- 题选项详细 -->
								选项分值：<input class="option_score_class"type="text"  maxlength="10" style="width: 100px;" name="score" id="score${optionStatus.index} }" value="${options.optionscore }" onkeyup="this.value =this.value.replace(/[\\^\\&]/g, '')">
								<input type="button" value="删除问题选项" class="delOption" onclick="delTopicOption(this);">
							</div>
						</c:forEach>	
						</div>
						<br><br>
					</div>
				  </c:forEach>
				</c:forEach>
			</div>
			
			</fieldset>
			</div>
			</form>
		</div>
		<div title="保存提交" style="padding:20px;font-size: 13px;"></div>
	</div>


<!-- 模板 -->
<div style="display: none;">
<div id="topic_div_model">
	<div class="topic_model">
		<input type="hidden" style="border: 0;" name="topicno" ><!-- 题序列 如1、2、3 -->
		<strong></strong><!-- 题显示序列 -->
		<input type="text"  maxlength="500" style="width: 350px;" name="topic"  id="topic#" onkeyup="this.value =this.value.replace(/[\\^\\&]/g, '')" ><!-- 题目 -->
		<input type="button" value="添加问题选项" class="addOption" onclick="addTopicOption(this);" >
		<input type="button" value="删除该问题" class="delOption" onclick="delTopic(this);">
		<input type="checkbox" checked="checked" value="Y" id="isanswer" name="isanswer">是否必答     <!-- 是否必答 -->
		<div class="topic_option_div"> <!-- 题选项区域 -->
		</div>
		<br><br>
	</div>
</div>
<div id="topic_option_model">
	<div class="topicOption_model" style="margin-left: 20px;"><br>
		<strong class="topic_option"></strong>
		<input type="hidden"  name="serialo"><!-- 题选项序号 -->
		<input type="text"  maxlength="500" style="width: 300px;" name="optiondesc" id="optiondesc#" onkeyup="this.value =this.value.replace(/[\\^\\&]/g, '')"><!-- 题选项详细 -->
		选项分值：<input type="text"  maxlength="10" style="width: 100px;" name="score" id="score#" onkeyup="this.value =this.value.replace(/[\\^\\&]/g, '')">
		<input type="button" value="删除问题选项" class="delOption" onclick="delTopicOption(this);">
		</div>
	</div>
</div>
</body>
</html>
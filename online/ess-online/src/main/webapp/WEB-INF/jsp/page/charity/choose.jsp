<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
%>

<!DOCTYPE HTML">
<html>
  <head>
    <title>国电资本控股</title>
    <%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
    
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/charity/insurant.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	

  </head>
  	<style>
  		.cbox{display:block;width:30px;height:30px;border:1px solid #000;background:#fff;text-align:center;float:left;}
  		.cbox.checked{background:#fff;}
 		.cbox.checked:after{content:"√"}
 	</style>
  
  <body onload="yuedu()">
    	<div id="head">捐赠选择</div>
    	<img src="<%=request.getContextPath()%>/resources/image/charity/choose.jpg"/>
    	<div class="ensure">
    	<div class="cbox checked" id="check" onclick="this.className=/checked/ig.test(this.className)?this.className.replace('checked',''):(this.className+' checked')">
  		</div>
  		<input style="width:1px;height:1px;opacity:0;"  onclick="visible()" type=checkbox   id="checkbox"  checked/>
    	少儿重疾保障捐赠</div>
    	<div id="agree" >
    		<table >
    			<tr>
    			<td style="font-size:1.2em;width:10%;">
  				<input style="width:1px;height:1px;opacity:0;" id="checkbox1" type="checkbox" name="checkbox"/>
  				<div class="cbox" id="check1" onclick="this.className=/checked/ig.test(this.className)?this.className.replace('checked',''):(this.className+' checked')">
  				</div></td>
  				<td style="font-size:1.2em;width:90%;";>
  				我已阅读<a href="<%=request.getContextPath()%>/global/global/pdf/know/web/viewer.html">《投保须知》、</a><a href="<%=request.getContextPath()%>/global/global/pdf/promp/web/viewer.html">《投保提示》、
  				</a><a href="<%=request.getContextPath()%>/global/global/pdf/clause/web/viewer.html">《瑞泰成长卫士少儿重大疾病保险条款》</a>
  				理解并同意其全部内容</td>
  				</tr>
  			</table>
  		</div>
  		
  		<div class="ensure">
  			<div class="cbox checked" id="check2" onclick="this.className=/checked/ig.test(this.className)?this.className.replace('checked',''):(this.className+' checked')"></div>
  			<input  style="width:1px;height:1px;opacity:0;" type=checkbox  id="checkbox2" checked/>助学捐赠（助学金/爱心书库）</div>
  		<p class="note">注：无论您选择少儿重疾或助学金捐赠（不包括爱心书库金捐赠）,我司均将为您捐赠的儿童再捐赠一份意外伤害及意外伤害医疗保障</p>
  		<div class="bottom">
 		<form action="<%=request.getContextPath()%>/msl/sales/policyCalculate" method="post" id="baseForm" name="form1">
			<input type="hidden" id="donationFlag" name="donationFlag" value="0" />  		
			<input type="hidden" id="helpStudyFlag" name="helpStudyFlag" value="0" />  		
		</form>
   				<div class="bottom_btn" onclick="dosubmit();">下一步<span style="font-size:0.8em">(填写捐赠信息)</span></div>
   		</div>
   		<div class="clear"></div>
   		<jsp:include page="../../common/charityfoot.jsp"></jsp:include>
  </body>
  <script>
	 
		$("#check").click(function(){
			if(document.getElementById("checkbox").checked==true){
				 document.getElementById("checkbox").checked=false;
			}else{
				 document.getElementById("checkbox").checked=true;	
			}
			 var checkbox = document.getElementById('checkbox').checked;
			 var div=document.getElementById('agree');
			 if(checkbox) {
	  			 div.style.display="";
	  			 }else
	  			 {div.style.display="none";}
		});
		$("#check1").click(function(){
			if(document.getElementById("checkbox1").checked==true){
				 document.getElementById("checkbox1").checked=false;
			}else{
				 document.getElementById("checkbox1").checked=true;	
			}
		}); 
		$("#check2").click(function(){
			if(document.getElementById("checkbox2").checked==true){
				 document.getElementById("checkbox2").checked=false;
			}else{
				 document.getElementById("checkbox2").checked=true;	
			}
		}); 
  		 function dosubmit(){
  			 var donation = document.getElementById("checkbox").checked;
  			 var helpStudy = document.getElementById("checkbox2").checked;
  			 var flag = document.getElementById("checkbox1").checked;
  			 if(donation){
  					$('#donationFlag').val("1");
  			 }else{
  				 $('#donationFlag').val("0");
  			 }
  			 if(helpStudy){
  					$('#helpStudyFlag').val("1");
  			 }else{
  				 $('#helpStudyFlag').val("0");
  			 }
  			 if(!donation && !helpStudy){
  				alert("请勾选捐赠类型");
  				return;
  			 }
  			 if(donation){
  			 if(flag){
  				/* document.getElementById("checkbox1").checked=false; */
  				 $("#baseForm").submit();
  			 }else{
  				 alert("请您阅读《投保须知》、《投保提示》、《瑞泰成长卫士少儿重大疾病保险条款》。");
  				 return;
  			 }
  			 }else{
  				 $("#baseForm").submit(); 
  			 }
  			 
  			 
  	  }
  		 function goback(){
  			  history.go(-1);
  		  }
  		 
 		function yuedu(){
 			 if(document.getElementById("checkbox").checked==true){
 				document.getElementById("check").className='cbox checked';
 				document.getElementById('agree').style.display="";
 			 }else{
 				document.getElementById("check").className='cbox';
 				document.getElementById('agree').style.display='none';
 			 }
 			 if(document.getElementById("checkbox1").checked==true){
 				document.getElementById("check1").className='cbox checked';
 			 }else{
 				document.getElementById("check1").className='cbox';
 			 }
 			 if(document.getElementById("checkbox2").checked==true){
 				document.getElementById("check2").className='cbox checked';
 			 }else{
 				document.getElementById("check2").className='cbox';
 			 }
 		}
  </script>
</html>

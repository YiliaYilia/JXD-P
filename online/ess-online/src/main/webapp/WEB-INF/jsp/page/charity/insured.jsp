<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	 var result = "<%=request.getAttribute("text")%>";
		 if(result=="1"){
			 alert("已无可捐赠的对象！" );
		 } 	 
</script>
<!DOCTYPE HTML>
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
  		.cbox{display:block;width:25px;height:25px;border:1px solid #000;background:#fff;float:left;}
  		.cbox.checked{background:#fff;}
 		.cbox.checked:after{content:"√"}
 		</style>
  <body>
    	<div id="head">被捐赠儿童随机匹配</div>
    	<div  class="detail">
    		<div class="left_detail"><img  id="photo" class="photo" src="<%=request.getContextPath()%>${matchpeople.imageurl}" /></div>
    		<div class="right_detail" >
    			<ul >
    				<li>姓名：<span id="name">${matchpeople.name}</span></li>
    				<li>性别：<span id="sex">${sex}</span></li>
    				<li>年龄：<span id="age">${matchpeople.age}</span></li>
    				<li>出生日期：<span id="birthday">${matchpeople.birthday}</span></li>
    				<li>地区：<span id="address">${matchpeople.province}</span></li>
    			</ul>
    		</div>
    	</div>
    		<div style="font-size:20px;line-height:40px;margin:0 2%;margin-top:10px;">简介：<span id="remark">${matchpeople.remark}</span></div>
    	<div class="table">
    	<table style="width:80%;margin:20px auto;">
    	<tr>
    		<td  colspan=2 >
    			<div class="notice">告知：此被捐赠儿童的监护人已授权您为其捐赠。</div>
    		</td>
    	</tr>
    	<tr>
    		<td style="float:left;">
    		<input style="width:1px;height:1px;opacity:0;" id="checkbox" type="checkbox" name="checkbox"/>
  			<div class="cbox" id="check" onclick="this.className=/checked/ig.test(this.className)?this.className.replace('checked',''):(this.className+' checked')">
  			</div></td>
    		<td style="float:right;font-size:1.5em;">是否选择其他被捐赠对象</td>
    	</tr>
    		<tr>
   				<td width=40%;style="float:left;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
   				<td width=60%;>
   					<select style="font-size:1.1em;height:35px;width:60%;float:right;" id="geChildlist.sex" name="geChildlist.sex">
   						<option  value="">全选</option>
   						<option value="M">男</option>
   						<option value="F">女</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td style="float:left;">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
   				<td style="float:right;">
   					<select style="font-size:1.1em;height:35px;width:60%;float:right;" id="geChildlist.age" name="geChildlist.age">
   						<option value="">全部</option>
   						<option value="0">0岁</option>
   						<option value="1">1岁</option>
   						<option value="2">2岁</option>
   						<option value="3">3岁~18岁</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td style="float:left;">省&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份：</td>
   				<td style="float:right;">
   					<select style="font-size:1.1em;height:35px;width:60%;float:right;" id="geChildlist.province" name="geChildlist.province">
   						<option value="">全选</option>
   						<option value="北京">北京</option>
   						<option value="上海">上海</option>
   						<option value="天津">天津</option>
   						<option value="重庆">重庆</option>
   						<option value="河北">河北</option>
   						<option value="山西">山西</option>
   						<option value="内蒙古">内蒙古</option>
   						<option value="辽宁">辽宁</option>
   						<option value="吉林">吉林</option>
   						<option value="黑龙江">黑龙江</option>
   						<option value="江苏">江苏</option>
   						<option value="安徽">安徽</option>
   						<option value="浙江">浙江</option>
   						<option value="福建">福建</option>
   						<option value="江西">江西</option>
   						<option value="山东">山东</option>
   						<option value="河南">河南</option>
   						<option value="湖北">湖北</option>
   						<option value="湖南">湖南</option>
   						<option value="广东">广东</option>
   						<option value="广西">广西</option>
   						<option value="海南">海南</option>
   						<option value="四川">四川</option>
   						<option value="贵州">贵州</option>
   						<option value="云南">云南</option>
   						<option value="西藏">西藏</option>
   						<option value="陕西">陕西</option>
   						<option value="甘肃">甘肃</option>
   						<option value="宁夏">宁夏</option>
   						<option value="青海">青海</option>
   						<option value="新疆">新疆</option>
   						<option value="香港">香港</option>
   						<option value="澳门">澳门</option>
   						<option value="台湾">台湾</option>
   					</select>
   				</td>
   			</tr>
   		</table>
   		</div>
   		<div class="bottom">
   		<div class="btn" onclick="doMatch();">重&nbsp;新&nbsp;匹&nbsp;配</div>
   		<form action="<%=request.getContextPath()%>/msl/sales/policyChoice" method="post" id="insuredForm" name="form1"></form>
   		<div class="bottom_btn" onclick="dosubmit();">下&nbsp;一&nbsp;步<font style="font-size:0.8em">(捐赠选择)</font></div>
   		</div>
   		<jsp:include page="../../common/charityfoot.jsp"></jsp:include>
   		
  </body>
  <script>
   	$("#check").click(function(){
		if(document.getElementById("checkbox").checked==true){
			 document.getElementById("checkbox").checked=false;
		}else{
			 document.getElementById("checkbox").checked=true;	
		}
	}); 
	 function doMatch(){
		  var flag = document.getElementById("checkbox").checked;
		  var sex = document.getElementById("geChildlist.sex").value;
		  var age = document.getElementById("geChildlist.age").value;
		  var prov = document.getElementById("geChildlist.province").value;
		  var result = "<%=request.getAttribute("text")%>";
			 if(result=="1"){
				 alert("已无其他可捐赠的对象！" );
				 return;
			 } 	 
		  if(flag){
			  $.ajax({
				   type:"POST",
				   url:contentRootPath+"/msl/sales/otherMatchRecognizee",
				   data:{
					   "geChildlist.sex" : sex, 
					   "geChildlist.age" : age,
					   "geChildlist.province" : prov
				   },
				   dataType:"json",
				   success:function(data){
					   if(data.name==""){
						    alert("无符合此选择的捐赠对象");
						}else{
							var imageurl = data.imageurl;
							var imagesrc = contentRootPath+imageurl;
							document.getElementById("photo").src=imagesrc;
							$('span').html('');
							$('#name').html(data.name);
							$('#age').html(data.age);
							var sex="";
							if(data.sex=="M"){
								sex="男";
							}else if(data.sex=="F"){
								sex="女";
							}
							$('#sex').html(sex);
							$('#birthday').html(data.birthday);
							$('#address').html(data.province);
							$('#remark').html(data.remark);
							
						}
					}
				});  
		  }else{
			  alert("请勾选是否选择其他被捐赠对象");
			  return;
		  }
	  }
	  function goback(){
		  history.go(-1);
	  }
	  function dosubmit(){
		  var result = "<%=request.getAttribute("text")%>";
			 if(result=="1"){
				 alert("已无可捐赠的对象！" );
				 return;
			 } 	 
		  document.getElementById("checkbox").checked=false;
		  $("#insuredForm").submit();
  }
  </script>
</html>

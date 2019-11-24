<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0" name="viewport" />
		<meta name="format-detection" content="telephone=no" />
		<title>康泰金生重大疾病保险</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/calculator/main.css" />
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.1.min.js"></script>
		<script>
			$(function(){
				var w = document.documentElement.clientWidth;
				if(980 < w){
					w = 980;
				}
				var height = w*1775/1000;
				$(".content").height(height);
				$(window).resize(function(){
					var w = document.documentElement.clientWidth;
					if(980 < w){
						w = 980;
					}
					var height = w*1775/1000;
					$(".content").height(height);
				})
				$(".sex").click(function(){
					var val = "M";
					var index = $(".sex").index($(this));
					$(".sex").each(function(i){
						if(index == i){
							$(this).addClass("sex_check");
						}else{
							$(this).removeClass("sex_check");
						}
					})
					if(0 == index){
						//男
						val = "M";
					}else{
						//女
						val = "F";
					}
					$(this).parent().find("input").val(val);
				})
			})
		</script>
	</head>
	<body onload="backshow()">
		<div class="main_wrap">
			<img src="<%=request.getContextPath() %>/resources/image/calculator/kt0.jpg" class="big_img"/>
			<img src="<%=request.getContextPath() %>/resources/image/calculator/kt1.jpg" class="big_img"/>
			<img src="<%=request.getContextPath() %>/resources/image/calculator/kt2.jpg" class="big_img"/>
			<img src="<%=request.getContextPath() %>/resources/image/calculator/kt3.jpg" class="big_img"/>
			<img src="<%=request.getContextPath() %>/resources/image/calculator/kt4.jpg" class="big_img"/>
			<div class="content">
				<p class="title">康泰金生重大疾病<br/>保险计划</p>
				<table style="margin-top:10%;height:18%">
					<tr>
						<td>姓名：</td>
						<td><input type="text" id="xingming" name="xingming" onchange="xingming();"/></td>
					</tr>
					<tr>
						<td>
							年龄：
						</td>
						<td class="second_td">
							<select id="insuredage" name="insuredage" onchange="changeIdNo();">
								<script language="javascript">
									for(var i=0;i<=70;i++) document.write('<option value="'+i+'">'+i+'岁</option>'); 
								</script>
							</select>
						</td>
					</tr>
					<tr>
						<td class="thrid_td">
							性别：
						</td>
						<td class="forth_td">
							<input type="hidden" value="M" id="sex" name="sex" />
							<span class="sex sex_check" >男</span>
							<span class="sex" style="float: right;" >女</span>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							年期：
						</td>
						<td class="second_td" >
							<select id="period" name="period" onchange="changeIdNo();">
								<option value="1">趸交</option>
  								<option value="3">3年</option>
  								<option value="5">5年</option>
  								<option value="10">10年</option>
  								<option value="20">20年</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="thrid_td">
							保额：
						</td>
						<td >
							<input type="text" id="coverage" name="coverage" onblur="changeIdNo();"/>
						</td>
						<td>
							万
						</td>
					</tr>
					<tr>
						<td colspan="2"><div class="btn" id="divM">立即测算</div></td>
					</tr>
				</table>
			</div>
		</div>
	</body>
	<script>
	 $(document).ready(function(){
         $("#divM").click(function () {
        	var xingming = document.getElementById("xingming").value;  
        	var insuredage = document.getElementById("insuredage").value;  //投保年龄
       		var sex = document.getElementById("sex").value;				//性别
       		var period = document.getElementById("period").value;		//年期
       		var coverage = document.getElementById("coverage").value;	//投保金额 单位万
       		if(xingming == "" || xingming.length==0 || xingming == null){
    			document.getElementById("xingming").value = ""; //清空文本框  
    			alert("请输入投保人姓名");
    			return false;
       		}else if(insuredage!=null && sex!=null && period!=null && coverage !="" && coverage!=null){
        		window.location.href="<%=request.getContextPath()%>/action/KTresult?xingming="+xingming+"&insuredage="+insuredage+"&sex="+sex+"&period="+period+"&coverage="+coverage+"";
        	}else{
        		alert("请填写保额!");
        	}   
        });
     });
	 
	 function xingming(){
		 var xingming = document.getElementById("xingming").value;  
		 if(xingming == "" || xingming.length==0 || xingming == null){
			document.getElementById("xingming").value = ""; //清空文本框  
			alert("请输入投保人姓名");
			return false;
		}else if(!/^[a-zA-Z]{3,20}$/.test(xingming)&&!/^[\u4e00-\u9fa5]{1,5}$/.test(xingming)){
			document.getElementById("xingming").value = ""; //清空文本框  
			alert("请输入正确的投保人姓名");
			return false;
		}
	 }
	 
	 
	//页面回显
	function backshow(){
		var insuredage = document.getElementById("insuredage").value;//投保年龄
		var sex = document.getElementById("sex").value;//性别
		var period = document.getElementById("period").value;//年期
		var coverage = document.getElementById("coverage").value;//保额
		$("#insuredage").val(insuredage);
		$("#sex").val(sex);
		$("#period").val(period);
		$("#coverage").val(coverage);
		if(coverage != "" && coverage.length>0){
			changeIdNo();
		}
	}
	 
	 function changeIdNo(){
			var insuredage = document.getElementById("insuredage").value;//投保年龄
			var period = document.getElementById("period").value;//年期
			var coverage = document.getElementById("coverage").value;//保额;
			var coverage1 = parseFloat(coverage)*10000; //单位改为元
			if(insuredage>50 && period == 20 ){
				period = document.getElementById("period").value="1";
				alert("50岁以上不能分20期!");
				return false;
			}	 
			else if(insuredage>60 && (period == 20 || period == 10)){
				period = document.getElementById("period").value="1";
				alert("60岁以上不能分10期与20期!");
				return false;
			}
			else if(insuredage>65 && period != 1){
				period = document.getElementById("period").value="1";
				alert("65岁以上只能趸交!");
				return false;
			}
			else if(coverage==null||coverage.length==0){
				 return false;
		  	}
			else if(isNaN(coverage)){
				document.getElementById("coverage").value="";
				alert("请输入正确的保额");
				return false;
			}
		  	else if(coverage1%1000 != 0){
		  		document.getElementById("coverage").value="";
				alert("保额必须为1000的整数倍！");
				return false;
			}
		  	else if(coverage1 < 1000){
		  		document.getElementById("coverage").value="";
				alert("最低保额为1000！");
				return false;
		    }
		  	else if(insuredage<18 && coverage>600){
		  		document.getElementById("coverage").value="";
		  		alert("18岁以下最高保额为600万");
				return false;
		  	}
	 }

  	</script>
</html>

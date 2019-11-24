<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>康泰现金价值表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/calculator/result.css"/>
	<script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.1.min.js"></script>
  </head>
  <body style="background:#ffffff;">
  		<h3>康泰金生重大疾病终身保险利益测算表（单位：元）</h3>
    	<table class="xjjz">
    		<thead>
	    		<tr>
	    			<td>保单年度末</td>
	    			<td>被保人年龄</td>
	    			<td>累计缴纳保费</td>
	    			<td>身故保险金</td>
	    			<td>重大疾病保险金</td>
	    			<td>轻症疾病保险金</td>
	    			<td>保单现金价值</td>
	    		</tr>
    		</thead>
    		<tbody>
    			<script language="javascript">	
    				var map = <%=request.getAttribute("map")%>; //获取后台json数据
    				var j = 1;
					for(var i=<%=session.getAttribute("insuredage")%>+1;i<107;i++){
						document.write('<tr id="'+j+'"><td>'+j+'</td><td>'+i+'</td><td></td><td></td><td></td><td></td><td></td></tr>'); //动态生成所有的tr td
						$("#"+j+" td:nth-child(7)").text(Math.round(map[i]));     //给第7列的td动态赋值
						j++;
					}
					//根据年期判断3 4 列写多少行
					if(<%=session.getAttribute("period").equals("1")%>){
						for(var a=1;a<2;a++){
							$("#"+a+" td:nth-child(3)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000));
							$("#"+a+" td:nth-child(4)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000*1.2));
						}	
						for(var a=2;a<18;a++){
							$("#"+a+" td:nth-child(4)").text(Math.round(<%=session.getAttribute("startPremium")%>*1*10000*1.2));
						}
					}else if(<%=session.getAttribute("period").equals("3")%>){
						for(var a=1;a<4;a++){
						 	$("#"+a+"  td:nth-child(3)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000));
							$("#"+a+"  td:nth-child(4)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000*1.2));
						}
						for(var a=4;a<18;a++){
							$("#"+a+" td:nth-child(4)").text(Math.round(<%=session.getAttribute("startPremium")%>*3*10000*1.2));
						}
					}else if(<%=session.getAttribute("period").equals("5")%>){						
						for(var a=1;a<6;a++){
							$("#"+a+"  td:nth-child(3)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000));
							$("#"+a+"  td:nth-child(4)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000*1.2));
						}
						for(var a=6;a<18;a++){
							$("#"+a+" td:nth-child(4)").text(Math.round(<%=session.getAttribute("startPremium")%>*5*10000*1.2));
						}
					}else if(<%=session.getAttribute("period").equals("10")%>){
						for(var a=1;a<11;a++){ 
							$("#"+a+"  td:nth-child(3)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000));
							$("#"+a+"  td:nth-child(4)").text(Math.round(Math.round(<%=session.getAttribute("startPremium")%>*a*10000*1.2)));
						}
						for(var a=11;a<18;a++){
							$("#"+a+" td:nth-child(4)").text(Math.round(<%=session.getAttribute("startPremium")%>*10*10000*1.2));
						}
					}else if(<%=session.getAttribute("period").equals("20")%>){
						for(var a=1;a<21;a++){
							$("#"+a+"  td:nth-child(3)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000));
							$("#"+a+"  td:nth-child(4)").text(Math.round(<%=session.getAttribute("startPremium")%>*a*10000*1.2));
						}
					}
					//如果投保年龄小于18岁 第4列从18岁开始 以后都写保额     年龄满18岁 第4列都写保额
					if(<%=session.getAttribute("insuredage")%>+1 < 18){
						for(var a = 18-<%=session.getAttribute("insuredage")%>;a<107;a++){ 
							$("#"+a+"  td:nth-child(4)").text(Math.round(<%=session.getAttribute("coverage")%>*10000));
						}
					}else{
						$("tbody tr td:nth-child(4)").text(Math.round(<%=session.getAttribute("coverage")%>*10000));
					}
					
					$("tbody tr td:nth-child(5)").text(Math.round(<%=session.getAttribute("coverage")%>*10000));     		//给第5列的td动态赋值
					$("tbody tr td:nth-child(6)").text(Math.round(<%=session.getAttribute("coverage")%>*10000*0.25));     //给第6列的td动态赋值
				</script>
    		</tbody>
    	</table>
  </body>
</html>
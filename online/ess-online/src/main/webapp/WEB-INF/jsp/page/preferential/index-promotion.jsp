<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
  <title>瑞泰人寿</title>
	<%@ include file="../../common/meta.jsp"%>
	<%@ include file="../../common/rels.jsp"%>
	<link href="<%=request.getContextPath()%>/global/global/css/common.css?${random}" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}" rel="stylesheet"/>
	
	<script src="<%=request.getContextPath() %>/resources/lib/component/form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
<!-- 	日期控件 -->
	<link href="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/css/mobiscroll.core-2.0.3.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/css/mobiscroll.android-2.0.css" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/mobiscroll.core-2.0.3.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/mobiscroll.android-2.0.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/mobiscroll.select-2.0.2.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/mobiscroll.datetime-2.0.3.js" type="text/javascript"></script>
<!-- 	工具类 -->
	<script src="<%=request.getContextPath()%>/resources/lib/utils/dateUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/idCardUtils.js?${random}" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/utils/stringUtils.js?${random}" type="text/javascript"></script>
	
	<script src="<%=request.getContextPath()%>/resources/resources/js/sales/fill.js?${random}"></script>
  </head>

  <body onload="dataSelect();">
   		<img class="img" src="<%=request.getContextPath()%>/global/global/images/home_1.jpg"/>
   		<div class="content">瑞泰成长卫士少儿重大疾病保险</div>
   		
   		<div class="center">
   		<form action="<%=request.getContextPath()%>/msl/sales/longPolicyInsure" method="post" id="baseForm" name="form1">
   		<table class="table">
   		<td colspan="2" style="text-align:center;" >请填写被保险人信息</td></tr> 
   			<tr>
   				<td width=30% style="text-align:center;">出生日期：</td>
   				<td width=70% >
   					<select class="dateselect1" id="year" name=YYYY onchange="YYYYMM(this.value);trial();">
					</select>年
					<select class="dateselect2" id="mon" name=MM onchange="MMDD(this.value);trial();">
					</select>月
					<select class="dateselect3" id="day" name=DD onchange="trial();">
					</select>日
   				</td>
   			</tr>
   			<tr>
   				<td style="text-align: center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
   				<td >
   					<select style="font-size:1.0em;width:35%;height:34px;" id="recognizee.sex" name="recognizee.sex" onChange="trial();">
   						<option value="M">男</option>
   						<option value="F">女</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td  style="text-align: center;">投保份数：</td>
   				<td  ><select id="count" style="font-size:1.1em;width:35%;height:34px;" onChange="trial();">
   						<option>1</option>
   						<option>2</option>
   						<option>3</option>
   						<option>4</option>
   						<option>5</option>
   					</select>份</td>
   			</tr>
   			<tr>
   				<td style="text-align: center;">保障期限：</td>
   				<td >1年</td>
   			</tr>
   			<tr>
   				<td style="text-align: center;">保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额：</td>
   				<td ><span id="coverage" style="color: red;">100000.00</span>元</td>
   			</tr>
   			
   			<td width=30% style="text-align:center;">优惠码：</td>
   				<td width=70% ><input type="text" name="policy.preferentialcode" id="policy.preferentialcode"/>	</td>
   			<tr>
   				<td style="text-align: center;">应付金额：</td>
   				<td><span><span id="sumbasepremium" style="color:red;font-size: 1.3"></span>元</span></td>
   			</tr>
   			<!-- <input type="hidden" id="start" name="start" readonly="readonly" onChange="trial();"/> -->
   			<input type="hidden" id="recognizee.birthday" name="recognizee.birthday" value='${recognizee.birthday}'>
   			<%-- <input type="hidden" id="recognizee.sex" name="recognizee.sex" value='${recognizee.sex}'> --%>
   			<input type="hidden" id="policy.sumamount" name="policy.sumamount" value='${policy.sumamount}'>
   			<input type="hidden" id="policy.sumbasepremium" name="policy.sumbasepremium" value='${policy.sumbasepremium}'>
   		</table>
   		</form>
		  <div class="btn" onclick="dosubmit();">立&nbsp;即&nbsp;投&nbsp;保</div>
   		</div>
   		<div class="info"style="margin-top:30px;">
   			<div class="left">1.产品特色</div> 
   			<div class="right">+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div> 
   			<div class="clear"></div>
   		</div>
		<div class="info_hid" style="display: none;">
   			<img/ src="<%=request.getContextPath()%>/global/global/images/growup_item.png">
   		</div>
		
		
   		<div class="info">
   			<div class="left">2.投保须知 </div> 
   			<div class="right">+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div> 
   			<div class="clear"></div>
   		</div>
		<div class="info_hid" style="display: none;">
   			<img/ src="<%=request.getContextPath()%>/global/global/images/growup_content.jpg">
   		</div>
		
		
   		<div class="info">
   			<div class="left">3.投保案例 </div> 
   			<div class="right">+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div> 
   			<div class="clear"></div>
   		</div>
		<div class="info_hid" style="display: none;">
   			<img/ src="<%=request.getContextPath()%>/global/global/images/growup_plan.png">
   		</div>
   		
		
		
		
   		<jsp:include page="../../common/common-modal.jsp"></jsp:include>
   		<jsp:include page="../../common/footer.jsp"></jsp:include>
   		
  </body>
<script type="text/javascript">
	$(".info").click(function(){
		$(".info_hid").css("display","none");
		$(this).next().css("display","block");  			
 		});
		var count = 1;
		var amntFormat = "";
		var sumpremium = "";
	  //保费试算
	  function trial(){
		  $("#coverage").html($("#count").val()*10+"0000.00");
		  $("#sumbasepremium").text(amntFormat);
		  var sex = $('#recognizee.sex').val();//取得性别
		  sex = document.getElementById("recognizee.sex").value
		  //var birthday = $("#year").val()+'年'+$("#mon").val()+'月'+$("#day").val()+'日';//取得生日
		  //var date = new Date(Date.parse(birthday.replace('年','-').replace('月','-').replace('日','')));
		  var birthday = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();//取得生日
		  var date = new Date(Date.parse(birthday));
		  var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000);
		  count = Number($("#count").val());//取得份数
		  sumpremium = 100000.00*count
		  if(birthday!=""&&birthday!=null&&count!=null&&count!=""&&sex!=""&&sex!=null&&age>=30&&age<=6570){
			  $.ajax({
				   type:"POST",
				   url:contentRootPath+"/msl/sales/longPolicyCalculate",
				   data:{
					   "recognizee.birthday":birthday,
					   "recognizee.sex":sex,
					   "policy.sumamount":sumpremium
				   },
				   dataType:"json",
				   success:function(data){
						var inputAmnt=Number(data.policy.sumbasepremium).toFixed(2);
					    amntFormat=outputmoney(inputAmnt);
					    amntFormat=changeAmount(amntFormat);
					    $("#sumbasepremium").text(amntFormat);
					    modal_loading('hide');
					}
				}); 
		  }
	  }
	  //计算优惠后的保费      
	  function changeAmount(value){
		  var birthday = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();
		  var age = GetAgeByBrithday(birthday);
		  if(age<=2){
			  value= value*1-15;
		  }else if(age<=17){
			  value= value*1-10;
		  }
		  return value;
	  }
	  
	  
	  //计算年龄
	  function GetAgeByBrithday(birthday) {
			var age = -1;
			var today = new Date();
			var todayYear = today.getFullYear();
			var todayMonth = today.getMonth() + 1;
			var todayDay = today.getDate();
			var birthday1 = birthday.split("-");
				birthdayYear = parseInt(birthday1[0]);
				birthdayMonth = parseInt(birthday1[1]);
				birthdayDay = parseInt(birthday1[2]);
				if (todayYear - birthdayYear < 0) {
					alert("出生日期选择错误!");
				} else {
					if (todayMonth * 1 - birthdayMonth * 1 < 0) {
						age = (todayYear * 1 - birthdayYear * 1) - 1;
					} else {
						if (todayDay - birthdayDay >= 0) {//alert(thisDay+'-'+brithd+"_ddd");
							age = (todayYear * 1 - birthdayYear * 1);
						} else {
							age = (todayYear * 1 - birthdayYear * 1) - 1;
						}
					}
				}
				return age * 1;
		}
	  
	  //提交表单准备投保
	  function dosubmit(){
		  var birthday = $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();//取得生日
		  var date = new Date(Date.parse(birthday));
		  var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000);
		  if(birthday==""||birthday.length==0){
			  alert("请选择被保险人生日"); 
			  return false;
		  }else if(age<=30||age>=6570){
			  alert("被保险人的年龄限制为30天~18周岁");
			  return false;
		  }else if(amntFormat=='0.00'){
			  alert("保费为空");
			  return false;
		  }else{
			  document.getElementById("recognizee.birthday").value = birthday;
			  document.getElementById("policy.sumamount").value = sumpremium;//保额
			  document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
			  $("#baseForm").submit();
		  }
		  
	  }
	  
	  
	  function outputmoney(number) {
			number = number.replace(/\,/g, "");
			if(isNaN(number) || number == ""){
				return "";
			}
			number = Math.round(number * 100) / 100;
		    if (number < 0){
		    	return '-' + outputdollars(Math.floor(Math.abs(number) - 0) + '') + outputcents(Math.abs(number) - 0);
		    }
		    else{
		    	return outputdollars(Math.floor(number - 0) + '') + outputcents(number - 0);
		    }
		}

		//格式化金额
		function outputdollars(number) {
		    if (number.length <= 3){
		    	return (number == '' ? '0' : number);
		    }else {
		        var mod = number.length % 3;
		        var output = (mod == 0 ? '' : (number.substring(0, mod)));
		        for (var i = 0; i < Math.floor(number.length / 3); i++) {
		            if ((mod == 0) && (i == 0)){
		            	output += number.substring(mod + 3 * i, mod + 3 * i + 3);
		            }
		            else{
		            	output += ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
		            }
		        }
		        return (output);
		    }
		}
		function outputcents(amount) {
		    amount = Math.round(((amount) - Math.floor(amount)) * 100);
		    return (amount < 10 ? '.0' + amount : '.' + amount);
		}
</script>

<script>
function dataSelect()
{
strYYYY = document.form1.YYYY.outerHTML;
strMM = document.form1.MM.outerHTML;
strDD = document.form1.DD.outerHTML;
MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
//先给年下拉框赋内容
var y = new Date().getFullYear();
var str = strYYYY.substring(0, strYYYY.length - 9);
for (var i = (y-99); i < (y+1); i++) //以今年为准，前30年，后30年
{
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
document.form1.YYYY.outerHTML = str +"</select>";
//赋月份的下拉框
var str = strMM.substring(0, strMM.length - 9);

for (var i = 1; i < 13; i++)
{
if(i<10){i="0"+i}
str += "<option value='" + i + "'> " + i  + "</option>\r\n";
}
document.form1.MM.outerHTML = str +"</select>";
document.form1.YYYY.value = y;
var MMtep= new Date().getMonth() + 1;
if(MMtep<10){MMtep="0"+MMtep}
document.form1.MM.value =MMtep;
var n = MonHead[new Date().getMonth()];
if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;
writeDay(n); //赋日期下拉框
document.form1.DD.value = new Date().getDate();
}
function YYYYMM(str) //年发生变化时日期发生变化(主要是判断闰平年)
{
var MMvalue = document.form1.MM.options[document.form1.MM.selectedIndex].value;
if (MMvalue == ""){DD.outerHTML = strDD; return;}
var n = MonHead[MMvalue - 1];
if (MMvalue ==2 && IsPinYear(str)) n++;
writeDay(n)
}
function MMDD(str) //月发生变化时日期联动
{
var YYYYvalue = document.form1.YYYY.options[document.form1.YYYY.selectedIndex].value;
if (str == ""){DD.outerHTML = strDD; return;}
var n = MonHead[str - 1];
if (str ==2 && IsPinYear(YYYYvalue)) n++;
writeDay(n)
}
function writeDay(n) //据条件写日期的下拉框
{
var s = strDD.substring(0, strDD.length - 9);
for (var i=1; i<(n+1); i++){
if(i<10){i="0"+i}
s += "<option value='" + i + "'> " + i + "</option>\r\n";
}
document.form1.DD.outerHTML = s +"</select>";
}
function IsPinYear(year)//判断是否闰平年
{ return(0 == year%4 && (year0 !=0 || year%400 == 0))}
</script>

</html>

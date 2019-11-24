<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML>
<html>
  <head>
  <title>投保信息-瑞泰人寿</title>
 
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
	<script src="<%=request.getContextPath()%>/resources/js/page/area.js?${random}"></script>
  </head>
  <body onload="dataSelect();init();select();">
  	<div class="nav">
  		<div class="menu" style="color:#fff;">填写信息</div>
  		<div class="menu">健康告知</div>
  		<div class="menu">确认投保</div>
  		<div class="menu">在线缴费</div>
  	</div>
  	<form action="<%=request.getContextPath()%>/msl/sales/longPolicyInsureInput" method="post" id="creator" name="creator" enctype="multipart/form-data">
  	<div class="policy_holder">投&nbsp;保&nbsp;人&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.name" name="applicantInsured.name" value="${applicantInsured.name}"/></td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">证件类型：</td>
  			<td  style="float:left;width:100%">
				<select id="applicantInsured.identifytype" name="applicantInsured.identifytype" >
						<option value="I">身份证</option>
						<option value="P">护照</option>
						<option value="S">军官证/士兵证</option>
						<option value="M">回乡证</option>
						<option value="O">户口本</option>
						<option value="H">港澳通行证</option>
						<option value="T">台胞证</option>
				</select>
			<%-- <input type=text name="applicantInsured.identifytype" value="${applicantInsured.identifytype}"/> --%>
			</td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">证件号码：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.identifynumber" name="applicantInsured.identifynumber" onchange="changeBirth();"/></td>
  		</tr>
  		
  		
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">出生日期：</td>
 			<td >
	 			<select style="font-size:0.8em;width:30%;height:34px;" id="year" name=YYYY onchange="YYYYMM(this.value);">
				</select><span style="font-size:0.8em">年</span>
				<select style="font-size:0.8em;width:20%;height:34px" id="mon" name=MM onchange="MMDD(this.value);">
				</select><span style="font-size:0.8em">月</span>
				<select style="font-size:0.8em;width:20%;height:34px;" id="day" name=DD>
				</select><span style="font-size:0.8em">日</span>
 			</td>
 			<input type="hidden" id="applicantInsured.birthday" name="applicantInsured.birthday" value="${applicantInsured.birthday}" />
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td >
				<select style="font-size:1.0em;width:35%;height:34px;" id="applicantInsured.sex" name="applicantInsured.sex">
					<option value="M">男</option>
					<option value="F">女</option>
				</select>
   			</td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">手机号码：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.mobile" name="applicantInsured.mobile" value="${applicantInsured.mobile}"/></td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">电子邮箱：</td>
  			<td  style="float:left;width:100%"><input type=text id="applicantInsured.email" name="applicantInsured.email" value="${applicantInsured.email}"/></td>
  		</tr>
  		<tr>
  			<td  style="color:red; float:right;">*</td>
  			<td  style="text-align:center;">通讯地址：</td>
  			<td  style="float:left;width:100%">
	  			<select style="width:35%;" name="province" onchange ="select();"></select>
	  			<select style="width:55%;  margin-left:5%" name="city" onchange = "select();" ></select>
  			</td>
  		</tr>
  		<tr>
  			<td  colspan=2 style="text-align:center;"></td>
  			<td  style="float:left;width:100%">
				<div contenteditable="true" style="width:100%; height:auto;min-height: 40px; outline: 0; border:1px solid grey;
			 	word-wrap: break-word; overflow-x: hidden;overflow-y: auto;margin-top:10px;background-color: #fff;word-break:break-all"
			  	id="address" />
				</div>
  			</td>
			<input type="hidden" id="applicantInsured.address" name="applicantInsured.address" value="${applicantInsured.address}" />  		
  		</tr>
  	</table>
  	</div>
  	
  	<div class="policy_holder">被&nbsp;保&nbsp;人&nbsp;信&nbsp;息</div>
  	<div class="center_fill">
  	<table class="msg">
  		<tr>
  			<td colspan="2" style="text-align:center;">与投保人关系：</td>
  			<td  style="float:left; align:center;width:50%">
				<select style="width:100%" id="recognizee.insrelationapp" name="recognizee.insrelationapp">
					<option value="CH">子女</option>
<!-- 					<option value="PA">父母</option>
					<option value="EM">雇佣</option>
					<option value="SF">本人</option>
					<option value="ES">法定</option>
					<option value="GF">（外）祖父母</option> -->
				</select>
			</td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">*</td>
  			<td style="text-align:center;width:40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
  			<td style="float:left;width:100%"><input type=text id="recognizee.name" name="recognizee.name" value="${recognizee.name}"/></td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">*</td>
  			<td style="text-align:center;">证件类型：</td>
  			<td  style="float:left;width:100%">
				<select id="recognizee.identifytype" name="recognizee.identifytype" >
						<option value="I">身份证</option>
						<option value="P">护照</option>
						<option value="S">军官证/士兵证</option>
						<option value="M">回乡证</option>
						<option value="O">户口本</option>
						<option value="H">港澳通行证</option>
						<option value="T">台胞证</option>
					</select>
			</td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">*</td>
  			<td style="text-align:center;">证件号码：</td>
  			<td style="float:left;width:100%"><input type=text id="recognizee.identifynumber" name="recognizee.identifynumber" value="${recognizee.identifynumber}" /></td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">&nbsp;</td>
  			<td style="text-align:center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  			<td style="float:left;width:100%">&nbsp;${sex}</td>
  		</tr>
  		<tr>
  			<td style="color:red; float:right;">&nbsp;</td>
  			<td style="text-align:center;">出生日期：</td>
  			<td style="float:left;width:100%">&nbsp;${birthday}</td>
  		</tr>
  	</table>
  	</div>
  	<div class="policy_holder">续保选择</div>
  	<div class="center_fill">
  	<div class="choose">
  		<table  class="msg">
  		<tr>
  			<td colspan="2" style="text-align: left;"><input style="width:30px;height:30px;" type="checkbox"  id="renewalflag" />
  			<input type="hidden" id="policy.renewalflag" name="policy.renewalflag">
  			申请续保至被保险人25岁</td>
  		</tr>
  		<tr>
  			<td   style="text-align:left;width:40%">续保缴费银行</td>
  			<td   style="float:left;width:100%"><input type=text id="policy.bank" name="policy.bank" value="${policy.bank}"/></td>
  		</tr>
  		<tr>
  			<td   style="text-align:left;">续保缴费账号</td>
  			<td   style="float:left;width:100%"><input type=text id="policy.bankAccountNumber" name="policy.bankAccountNumber" value="${policy.bankAccountNumber}"/></td>
  		</tr>
  	</table>
  	</div>
  	</div>
  	<div class="policy_holder">推荐人信息</div>
  	<div class="center_fill">
  	<div class="choose">
  	<table  class="msg">
  		<tr>
  			<td   style="text-align:left;">推荐人编码</td>
  			<td   style="float:left;width:100%"><input type=text id="policy.agentcode" name="policy.agentcode" value="${policy.agentcode}"/></td>
  		</tr>
  	</table>
  	
  	</div>
  	</div>
  	   	<div class="notice_btn" onclick="save()">下一步：健康告知</div>
  	 
  	</form>
  	<jsp:include page="../../common/footer.jsp"></jsp:include>
  </body> 	
  <script type="text/javascript">
 		//保存投被保人信息并将页面跳转至健康告知
 		function save(){
 			//校验
 			if(!check()){
 				return;
 			}
 			var flag = document.getElementById("renewalflag").checked;//续保标志
 			if(flag){
 				document.getElementById("policy.renewalflag").value = "1";
 			}else{
 				document.getElementById("policy.renewalflag").value = "2";
 			}
 			var address = document.getElementById("address").innerHTML;
 			var br =  $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();//取得生日
 			document.getElementById("applicantInsured.address").value = address;
 			document.getElementById("applicantInsured.birthday").value = br;
 			$("#creator").submit();
 		}
 		
 		//身份证算生日
 		function getBirth(value) {
            var year = "1900";
            var month = "1";
            var day = "1";
            if (value.length == 15) {
                year = "19" + value.substr(6, 2);
                month = value.substr(8, 2);
                day = value.substr(10, 2);
            } else if (value.length == 18) {
                year = value.substr(6, 4);
                month = value.substr(10, 2);
                day = value.substr(12, 2);
            } else {
                return "";
            }
            newDate = new Date(year, month - 1, day);
            if (newDate.toString() == "NaN") {
                return "";
            }
            else {
                var start =  year + "-" + month + "-" + day;
                return start;
            }
        }
 		
 		
 		function changeBirth(){
 			var value = getObj("applicantInsured.identifynumber");
 			  var year = "1900";
 	            var month = "1";
 	            var day = "1";
 	            if (value.length == 15) {
 	                year = "19" + value.substr(6, 2);
 	                month = value.substr(8, 2);
 	                day = value.substr(10, 2);
 	            } else if (value.length == 18) {
 	                year = value.substr(6, 4);
 	                month = value.substr(10, 2);
 	                day = value.substr(12, 2);
 	            } else {
 	                return;
 	            }
 	            newDate = new Date(year, month - 1, day);
 	            if (newDate.toString() == "NaN") {
 	                return;
 	            }
 	            else {
 	            	var sex = getSex(value);
 	            	document.getElementById("applicantInsured.sex").value = sex;
 	                document.getElementById("year").value = year;
 	                document.getElementById("mon").value = month;
 	                document.getElementById("day").value = day;
 	            }
 		}
		
 		
 		function getSex(value){
 			if (parseInt(value.substr(16, 1)) % 2 == 1) {
 				return "M";
			} else {
				return "F"; 
			} 
 		}
 		
 		
 		//取页面上的值
 		function getObj(id){
 			return document.getElementById(id).value;
 		}
	  	
 		//校验其它证件
 		function check(value,type){
 			var result="";
 			var length=value.length;
 			if(type=="P"){
 				if(length <3){
 					alert('护照号码不得小于3个字符');
 					return false;
 				}
 			}
 			if(type=="M"){
 				if(length <8){
 					alert('港澳回乡证号码不得小于8个字符');
 					return false;
 				}
 			}
 			if(type=="T"){
 				if(length <8){
 					alert('台胞证号码不得小于8个字符');
 					return false;
 				}
 			}
 			if(type=="O"){
 				if(length <3){
 					alert('户口本号码不得小于3个字符');
 					return false;
 				}
 			}
 			if(type=="S"){
 				if(length <10||length >18){
 					alert('军官证或士兵证号码应在10到18个字符之间');
 					return false;
 				}
 			}
 			return true;
 		}
 		
 		
 		//校验
 		function check(){
 			var applicantInsuredname = getObj("applicantInsured.name");//投保人姓名
 			var applicantInsuredidentifytype = getObj('applicantInsured.identifytype');//投保人证件类型
 			var applicantInsuredidentifynumber = getObj("applicantInsured.identifynumber");//投保人证件号
 			var adress = document.getElementById("address").innerHTML;//投保人地址
 			var recognizeeidentifynumber = getObj("recognizee.identifynumber");//被保人证件号
 			var re =  /^[A-Z u4E00-u9FA5]+$/;//校验姓名的正则
 			var ree = /^\d{15}(\d{2}(x|X|\d))?$/;//校验身份证号的正则
 			var age = parseInt(new Date().getFullYear()) - parseInt(applicantInsuredidentifynumber.substring(6,10));//投保人年龄
 			if(applicantInsuredname==""||applicantInsuredname.length==0){
 				alert("请输入投保人姓名");
 				return false;
 			}else if(applicantInsuredname.length<2){
 				alert("请输入正确的投保人姓名");
 				return false;
 			}
 			if(applicantInsuredidentifytype == 'I'){
 				if(applicantInsuredidentifynumber.length!=15&&applicantInsuredidentifynumber.length!=18){
 					alert("请输入正确的身份证号");
 	 				return false;
 				}else if(!ree.test(applicantInsuredidentifynumber)){
 					alert("请输入正确的身份证号");
 	 				return false;
 				}
 				var start = getBirth(applicantInsuredidentifynumber);
 				var br =  $("#year").val()+"-"+$("#mon").val()+"-"+$("#day").val();//取得生日
 				if(start!=br){
 					alert("投保人身份证号与生日不相符");
 	 				return false;
 				}else if(getSex(applicantInsuredidentifynumber)!=getObj("applicantInsured.sex")){
 					alert("投保人身份证号与性别不相符");
 	 				return false;
 				}else if(age<18){
 					alert("投保人需大于18周岁");
 	 				return false;
 				}
 			}else{
 				if(applicantInsuredidentifynumber==""||applicantInsuredidentifynumber.length==0){
 					alert("请输入投保人证件号");
 	 				return false;
 				}else if(!check(applicantInsuredidentifytype,applicantInsuredidentifynumber)){
 	 				return false;
 				}
 			}
 			//校验手机
 			var phone = getObj("applicantInsured.mobile");
 			var re1 = /^0?1[3|7|5|8][0-9]\d{8}$/;
 		  	if(!re1.test(phone)){
 		  		alert("请输入正确的手机号码");
				return false;
 		 	}
 			
 		  	//校验投保人生日
 		  	var birthday = $("#year").val();
 			var age =  parseInt(new Date().getFullYear()) - parseInt(birthday);
 			if(age<18){
 				alert("投保人年龄须在18以上");
 				return false;
 			}
 		  	
 		  	//校验邮箱
 		  	var email=getObj("applicantInsured.email");
 			var re2 =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
 			if(email.length==0||email==""){
 				alert("请输入您的电子邮箱");
 				return false;
 			}else if(!re2.test(email)){
 				alert("电子邮箱有误,请核对后输入");
 				return false;
 			}
 			
 			if(adress==""||adress.length==0){
 				alert("请输入地址");
	 			return false;
 			}else if(adress.length<8){
 				alert("请输入有效的地址");
 				return false;
 			}
 			
 			
 			//校验续保标识
 			var flag = document.getElementById("renewalflag").checked;//续保标志
 			var bankAccountNumber = getObj("policy.bankAccountNumber");
			var bankName = getObj("policy.bank");
 			if(flag){
 				if(bankName.lengh==0||bankName==""||bankAccountNumber.lengh==0||bankAccountNumber==""){
 					alert("如果您选择续保，请填写续保银行及账号");
 					return false;
 				}
 			}else{
 				if(bankName.lengh>0||bankAccountNumber.lengh>0){
 					alert("请您先选择续保，再填写续保银行及账号");
 					return false;
 				}
 			}
 			
 			
 			if(getObj("recognizee.identifytype") == 'I'){
 				if(recognizeeidentifynumber.length!=15&&recognizeeidentifynumber.length!=18){
 					alert("请输入正确的被保人身份证号");
 	 				return false;
 				}else if(!ree.test(recognizeeidentifynumber)){
 					alert("请输入正确的被保人身份证号");
 	 				return false;
 				}
 				var start = getBirth(recognizeeidentifynumber);
 				var br =  '${birthday}';
 				var birthday = br.replace('年','-').replace('月','-').replace('日','');
 				if(start!=birthday){
 					alert("被保人身份证号与生日不相符");
 	 				return false;
 				}else if(getSex(applicantInsuredidentifynumber)!=getObj("applicantInsured.sex")){
 					alert("被保人身份证号与性别不相符");
 	 				return false;
 				}
 			}else{
 				if(recognizeeidentifynumber.length==""||recognizeeidentifynumber.length==0){
 					alert("请输入被保人证件号");
 	 				return false;
 				}else if(!check(getObj("recognizee.identifytype"),recognizeeidentifynumber)){
 	 				return false;
 				}
 			}
 			
			
 			
 			return true;
 		}
 		
 		
 //日期控制
function dataSelect()
{
	strYYYY = document.creator.YYYY.outerHTML;
	strMM = document.creator.MM.outerHTML;
	strDD = document.creator.DD.outerHTML;
	MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	//先给年下拉框赋内容
	var y = new Date().getFullYear();
	var str = strYYYY.substring(0, strYYYY.length - 9);
	for (var i = (y-99); i < (y+1); i++) //以今年为准，前30年，后30年
	{
	str += "<option value='" + i + "'> " + i  + "</option>\r\n";
	}
	document.creator.YYYY.outerHTML = str +"</select>";
	//赋月份的下拉框
	var str = strMM.substring(0, strMM.length - 9);
	
	for (var i = 1; i < 13; i++)
	{
	if(i<10){i="0"+i}
	str += "<option value='" + i + "'> " + i  + "</option>\r\n";
	}
	document.creator.MM.outerHTML = str +"</select>";
	document.creator.YYYY.value = y;
	var MMtep= new Date().getMonth() + 1;
	if(MMtep<10){MMtep="0"+MMtep}
	document.creator.MM.value =MMtep;
	var n = MonHead[new Date().getMonth()];
	if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;
	writeDay(n); //赋日期下拉框
	document.creator.DD.value = new Date().getDate();
}

function YYYYMM(str) //年发生变化时日期发生变化(主要是判断闰平年)
{
	var MMvalue = document.creator.MM.options[document.creator.MM.selectedIndex].value;
	if (MMvalue == ""){DD.outerHTML = strDD; return;}
	var n = MonHead[MMvalue - 1];
	if (MMvalue ==2 && IsPinYear(str)) n++;
	writeDay(n)
}
function MMDD(str) //月发生变化时日期联动
{
	var YYYYvalue = document.creator.YYYY.options[document.creator.YYYY.selectedIndex].value;
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
	document.creator.DD.outerHTML = s +"</select>";
}
function IsPinYear(year)//判断是否闰平年
{ return(0 == year%4 && (year0 !=0 || year%400 == 0))}


</script>
</html>

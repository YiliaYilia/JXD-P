<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>投保信息-瑞泰人寿</title>
<%@ include file="../../common/meta.jsp"%>
<%@ include file="../../common/rels.jsp"%>
<link
	href="<%=request.getContextPath()%>/global/global/css/common.css?${random}"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/global/global/css/sale.css?${random}"
	rel="stylesheet" />

<script
	src="<%=request.getContextPath()%>/resources/lib/component/form.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/jquery/validate/jquery.validator.js?${random}"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/jquery/validate/local/zh_CN.js?${random}"></script>
<!-- 	日期控件 -->
<link
	href="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/css/mobiscroll.core-2.0.3.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/css/mobiscroll.android-2.0.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/mobiscroll.core-2.0.3.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/mobiscroll.android-2.0.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/mobiscroll.select-2.0.2.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/jquery/mobiscroll/mobiscroll.datetime-2.0.3.js"
	type="text/javascript"></script>
<!-- 	工具类 -->
<script
	src="<%=request.getContextPath()%>/resources/lib/utils/dateUtils.js?${random}"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/utils/idCardUtils.js?${random}"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/lib/utils/stringUtils.js?${random}"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/page/area.js?${random}"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/page/fill.js?${random}"></script>
<%-- <script src="<%=request.getContextPath()%>/resources/js/page/trafill.js?${random}"></script> --%>
</head>
<body onLoad="dataSelect();">
	<div class="headnav">
		<div class="menu" style="color: #fff;">填写信息</div>
		
		<div class="menu">确认投保</div>
		<div class="menu">在线缴费</div>
	</div>
	<form action="" method="post" name="creator" enctype="multipart/form-data">
		<div class="policy_holder">投保人信息、被保险人信息</div>
		<div class="center_fill">
			<table class="msg">
				<tr>
					<td style="color: red; float: right;">*</td>
					<td style="text-align: center; width: 40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
					<td style="float: left; width: 100%"><input type=text
						id="name" name="applicantInsured.name" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">与投保人关系：&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td style="float: left; align: center;">本人</td>
					<input type=hidden id="relationship"
						name="applicantInsured.insrelationapp" value="0" />
				</tr>
				<tr>
					<td style="color: red; float: right;">*</td>
					<td style="text-align: center;">证件类型：</td>
					<td style="float: left; width: 100%"><select id="idtype"
						name="applicantInsured.identifytype">
							<option value="A">身份证</option>
							<option value="B">护照</option>
							<option value="C">军官证</option>
							<!-- <option value="H">出生证明</option> -->
							<option value="L">士兵证</option>
							<option value="N">港澳通行证</option>
							<option value="Q">港澳台回乡证</option>
							<!-- <option value="D">驾照</option> -->
							<option value="K">台胞证</option>
					</select></td>
				</tr>
				
				<tr>
					<td style="color: red; float: right;">*</td>
					<td style="text-align: center;">证件号码：</td>
					<td style="float: left; width: 100%">
					<input type=text id="identifynumber" name="applicantInsured.identifynumber" onchange="changeBirth();"/>
					</td>
				</tr>
				
				<tr>
					<td style="color: red; float: right;">*</td>
					<td style="text-align: center;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
					<td style="float: left; width: 100%">
					<select id="sex" name="applicantInsured.sex">
							<option value="M">男</option>
							<option value="F">女</option>
					</select></td>
				</tr>
				
				<tr>
					<td style="color: red; float: right;">*</td>
					<td style="text-align: center;">出生日期：</td>
					<td style="float: left; width: 100%">
						<select style="font-size:0.8em;width:30%;height:34px;" id="year" name=YYYY onchange="YYYYMM(this.value);">
						</select><span style="font-size:0.8em">年</span>
						<select style="font-size:0.8em;width:20%;height:34px" id="mon" name=MM onchange="MMDD(this.value);">
						</select><span style="font-size:0.8em">月</span>
						<select style="font-size:0.8em;width:20%;height:34px;" id="day" name=DD>
						</select><span style="font-size:0.8em">日</span>
					</td>
					<input type=hidden id="birthday" name="applicantInsured.birthday"/>
					<input type=hidden id="age" />
				</tr>
				
				<tr>
					<td style="color: red; float: right;">*</td>
					<td style="text-align: center;">手机号码：</td>
					<td style="float: left; width: 100%"><input type=text
						id="mobile" name="applicantInsured.mobile" /></td>
				</tr>
				
				<tr>
					<td style="color: red; float: right;">*</td>
					<td style="text-align: center;">电子邮箱：</td>
					<td style="float: left; width: 100%"><input type=text
						id="email" name="applicantInsured.email" /></td>
				</tr>
				
			<%-- 	 <tr>
					<td style="color: red; float: right;">*</td>
					<td style="text-align: center;">通讯地址：</td>
					<td style="float: left; width: 100%"><select id="province"
						style="width: 35%;" name="applicantInsured.province"
						onchange="select();"></select> <select id="city"
						style="width: 55%; margin-left: 5%" name="applicantInsured.city"
						onchange="select();"></select></td>
				</tr>
				<tr>
					<td  style="color:red; float:right;">&nbsp;</td>
	  				<td  colspan=2 width=100%><input type="text" id="showAaddress"></input></td>
	  				<div overflow-x: hidden id="address" />
					<input type="hidden" id="applicantInsured.address" name="applicantInsured.address" value="${applicantInsured.address}" /> 		
  				</tr> --%>
			</table>
		</div>
	<div class="policy_holder">受益人信息</div>
  	<div class="center_fill">
  	<div class="choose">
  		<table  class="msg">
  		<tr>
  			<td style="color:red; float:right;">&nbsp;</td>
  			<td style="text-align:left;width: 40%">受益人</td>
  			<td style="float:left;width:100%">法定</td>
  		</tr>
  	</table>
  	</div>
  	</div>
		<div class="policy_holder">推荐人信息</div>
		<div class="center_fill">
			<div class="choose">
				<table class="msg">
				<!--  <tr>
						<td style="text-align: left; width: 40%">推荐人姓名</td>
						<td style="float: left; width: 100%"><input type=text
							id="advisorname" name="policy.agentname" /></td>
					</tr>
					-->
					
					<tr>
						<td style="text-align: left;">推荐人编码</td>
						<td style="float: left; width: 100%"><input type=text
							id="advisorcode" name="policy.agentcode" />
						<input type=hidden
							id="advisorname" name="policy.agentname" />	
							<input type="hidden" id="deptid" name="deptid">
							<input type="hidden" id="deptidFlag" name="deptidFlag" value="0">
						</td>
					</tr>
				</table>

			</div>
		</div>
		<a id="toConfirm"><div class="notice_btn">下一步：确认投保</div></a>

	</form>
	<jsp:include page="../../common/common-modal.jsp"></jsp:include>
	<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">

	function changeBirth(){
		var value = document.getElementById("identifynumber").value;
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
            document.getElementById("year").value = year;
            document.getElementById("mon").value = month;
            document.getElementById("day").value = day;
        }
        
	}
	
	//日期控制
	function dataSelect(){
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
		var YYYYvalue = document.creator.YYYY.options[document.creator.YYYY.selectedIndex].value;
		if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;
		writeDay(n); //赋日期下拉框
		var nowDay=new Date().getDate()+"";
		if(nowDay.length<2){
			document.getElementById("day").value="0"+new Date().getDate();
		}else{
			document.getElementById("day").value=new Date().getDate();
		}
		
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
		YYYYvalue = document.creator.YYYY.options[document.creator.YYYY.selectedIndex].value;
		if (str == ""){DD.outerHTML = strDD; return;}
		var n = MonHead[str - 1];
		if (str ==2 && IsPinYear(YYYYvalue)) n++;
		writeDay(n)
	}
	
	function writeDay(n) //据条件写日期的下拉框
	{
		var s = strDD.substring(0, strDD.length - 9);
		for (var i=1; i<(n+1); i++){
			if(i<10){
				s += "<option value='0" + i + "'> " +"0"+ i + "</option>\r\n";
			}else{
				s += "<option value='" + i + "'> " + i + "</option>\r\n";
			}
		}
		document.creator.DD.outerHTML = s +"</select>";
	}
	
	function IsPinYear(year)//判断是否闰平年
	{
		 return(0 == year%4 && (year !=0 || year%400 == 0))
    }
	
</script>
</html>

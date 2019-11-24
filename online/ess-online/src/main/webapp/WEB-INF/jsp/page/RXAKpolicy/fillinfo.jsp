﻿﻿﻿﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ page import="cn.com.sinosoft.web.domain.MakeTicketSignature"%>
<%@ include file="../../common/taglibs.jsp"%>
<% 
request.setCharacterEncoding("UTF-8");
// String url= "https://weixin.oldmutual-guodian.com/onlineApp/msl/sales/rxakFill";
String url= "http://testweixin.oldmutual-guodian.com/online/msl/sales/rxakFill";
if(request.getQueryString()!=null){
	url = url+"?"+request.getQueryString();
}
MakeTicketSignature mts = new MakeTicketSignature();
String isAgentCode = (String)session.getAttribute("isAgentCode")==null?"":(String)session.getAttribute("isAgentCode");
String age = (String)session.getAttribute("age")==null?"":(String)session.getAttribute("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/rxak/rxak.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/wkb/wkb.css" type="text/css"></link>
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/rxak/rxakJobCode.js?v=1"></script>
<script src="<%=request.getContextPath()%>/resources/js/rxak/rxakArea.js?v=1"></script>
<script src="<%=request.getContextPath()%>/resources/js/rxak/rxakInfo.js?v=3"></script>
<jsp:include page="../../common/Mobiscroll.jsp"></jsp:include>
<title>瑞享安康</title>
</head>
<body onload="init_job();init_area();backshow();">
<div class="wjb">
<!--标题区域-->
  	<div class="nav txt16">
  		<div class="menu" style="color:#fff;">填写信息</div>
  		<div class="menu">确认信息</div>
  		<div class="menu">如实告知</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
  	<!-- 正文区域 -->
  	<form action="<%=request.getContextPath()%>/msl/sales/RXAKInsureInput" method="post" id="creator" name="creator">
  	<section class="fillinfo_wrap fillinfo_top">
  	
  	<div class="title">理财顾问信息</div>
  		<table class="txt16" >
			<tr>
  				<td width="35%" class="noberder" style="text-indent: 5%;" >
  				<c:if test="${isAgentCode=='1'}"><span class="must">*</span></c:if>
  				理财顾问<br/>&emsp;&nbsp;&nbsp;编码：</td>
  				<td width="65%" class="noberder">
  					<input type="text" style="width: 65%;font-size:1.2em;" id="policy.agentcode" name="policy.agentcode" value="${policy.agentcode}" onblur="onchangeArea();"/>
  					<input type="hidden" id="policy.deptid" name="policy.deptid" value="${policy.deptid}"/>
					<c:if test="${isAgentCode=='0'}"><span style="padding-left: 0px;width: 30%;">（选填）</span></c:if>
  				</td>
  			</tr>
		</table>
		
  	<div class="title" style="margin: 15px auto 20px auto;">投保人信息</div>
  	<c:if test="${!empty comAppList}">
		<table class="common_info txt14">
			<tr>
  				<td colspan="5">
 					<span>常用投保人</span>
  				</td>
	  		</tr>
		<c:forEach var="comAppList" items="${comAppList}"> 
	  		<tr>
  				<td width="20%" align="left">
					<div class="checkbox_div txt14" style="margin: 0;">
			 			<input class="comChoose" type="checkbox" id ="comChoose" name=""/>
			 			<div class="checkbox checkboxCom"><span class="checked_img"></span></div> 
			 			<input class="comName" type="hidden" name="comName" value="${comAppList.name}" >
				 		<input class="comIdno" type="hidden" name="comIdno" value="${comAppList.idno}" >
				 		<input class="comMobile" type="hidden" name="comMobile" value="${comAppList.mobile}" >
				 		<input class="comEmail" type="hidden" name="comEmail" value="${comAppList.email}" >
			 		</div>
			 		<span>${comAppList.name}</span>
				</td>
	  			</tr>
		</c:forEach>
		</table>
	</c:if>
	<table>
 			<tr>
 				<td width="35%" class="left" style="text-indent:5%;"><span class="must">*</span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
 				<td width="65%">
 					<input id="applicantInsured.name" name="applicantInsured.name" type="text" value="${applicantInsured.name}" onblur="saveData();"/>
 				</td>
 			</tr>
 			<tr>
  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>职&emsp;&emsp;业：</td>
 				<td>
 					<div class="addr_div">
 						<div class="select_div">
 							<select id="applicantInsured_industry" name="applicantInsured_industry" class="txt14"></select> 
 						</div>
 						<div class="select_div">
 							<select id="applicantInsured_job" name="applicantInsured_job" class="txt14"></select> 	
 						</div>	
 					</div>
 				</td>
  		</tr>
  		<tr>
  			<td class="txt14" style="text-indent:5%"><span class="must">*</span>证件类型：</td>
 				<td>
 					<select id="applicantInsured.identifytype" name="applicantInsured.identifytype" class="txt14">
  					<option value="I">身份证</option>
  					<option value="O">户口薄</option>
 					</select> 	
 				</td>
  		</tr>
 			<tr>
 				<td width="35%" class="left" style="text-indent:5%;"><span class="must">*</span>证件号码：</td>
 				<td>
 					<input type="text" id="applicantInsured.identifynumber" name="applicantInsured.identifynumber" value="${applicantInsured.identifynumber}" onchange="onchangeAppIdNo();" onblur="saveData();"/>
 				</td>
 			</tr>
  			<tr>
  				<c:if test="${age < 18}">
  					<td width="35%" class="left" style="text-indent:5%;"><span class="must">*</span>性&emsp;&emsp;别：</td>
 					<td>
 						<select id="applicantInsuredSex_min" name="applicantInsuredSex_min" class="txt14">
	  					 	<option value="M">男</option>
	  					    <option value="F">女</option>
	  					</select> 	
 					</td>
 				</c:if>
 				<c:if test="${age >= 18}">
 					<td class="left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
 					<td>
 						<input type="text" id="applicantInsuredSex_max" name="applicantInsuredSex_max" readonly="readonly" value="${sex}" style="background: #E9E9E9"/>
 					</td>
 				</c:if>
 				<input type="hidden" id="applicantInsured.sex" name="applicantInsured.sex" value='${applicantInsured.sex}'/>
 			</tr>
 			<tr>
 				<c:if test="${age < 18}">
 					<td width="35%" class="left" style="text-indent:5%;"><span class="must">*</span>出生日期：</td>
 					<td>
 						<input type="text" id="applicantInsuredBirthday_min" class="birthdayDate" name="applicantInsuredBirthday_min" />
 					</td>
 				</c:if>
 				<c:if test="${age >= 18}">
 					<td class="left">出生日期：</td>
 					<td>
 						<input type="text" id="applicantInsuredBirthday_max" class="birthdayDate" name="applicantInsuredBirthday_max" value="${birthday}" readonly="readonly" style="background: #E9E9E9"/>
 					</td>
 				</c:if>
 				<input type="hidden" id="applicantInsured.birthday" name="applicantInsured.birthday" value='${applicantInsured.birthday}'/>
 			</tr>
 			<tr>
 				<td class="txt14" style="text-indent:5%"><span class="must">*</span>证件有效<br/>&emsp;&nbsp;&nbsp;止期：</td>
 				<td>
 					<input type="text" id="idPhotoData.applicantInsured_endTime" name="idPhotoData.applicantInsured_endTime" value='${idPhotoData.applicantInsured_endTime}' onchange="clickAppIdTime();"/>
 					<div class="checkbox_div txt14" id="commonApp">
 					<input type="checkbox"/>
 					<div class="checkbox applicantInsured_endTime"><span class="checked_img"></span></div>
 					长期有效
 					</div>
 				</td>
 			</tr>
 			
 			<tr>
    		<td class="txt14" style="text-indent:5%"><span class="must">*</span>证件正面照：</td>
    		<td><img id="idPhotoData.applicantInsured_frontal" name="idPhotoData.applicantInsured_frontal" src="" style="width:90%;height:90%;text-align:center"></td>	
    	</tr>
    	<tr>
    		<td class="txt14" style="text-indent:5%"><span class="must">*</span>证件反面照：</td>
    		<td><img id="idPhotoData.applicantInsured_reverse" name="idPhotoData.applicantInsured_reverse" src="" style="width:90%;height:90%;text-align:center"></td>	
    	</tr>
		<tr>
			<td class="left" style="text-indent:5%;"><span class="must">*</span>手机号码：</td>
			<td><input type="text" id="applicantInsured.mobile" name="applicantInsured.mobile" value="${applicantInsured.mobile}"  onblur="saveData();"/></td>
		</tr>
		<tr>
			<td class="left" style="text-indent:5%;"><span class="must">*</span>电子邮箱：</td>
			<td><input type="text" id="applicantInsured.email" name="applicantInsured.email" value="${applicantInsured.email}"  onblur="saveData();"/></td>
		</tr>
		<tr>
			<td width="35%" class="left" style="text-indent:5%;"><span class="must">*</span>国&emsp;&emsp;籍：</td>
			<td>
				<select id="nationality" name="nationality" class="txt14">
					 <option value="CHN">中国</option>
					 <option value="ORTER">其他</option>
				</select> 	
			</td>
		</tr>
		<tr>
			<td class="noberder left" style="text-indent:5%;"><span class="must">*</span>通讯地址：</td>
			<td class="noberder">
				<div class="addr_div">
					<div class="select_div">
 						<select name="applicantInsured_province" id="applicantInsured_province"></select>
					</div>
					<div class="select_div">
						<select name="applicantInsured_city" id="applicantInsured_city"></select>
					</div>
				</div>
				<div class="input_div">
					<input id="applicantInsured_area" name="applicantInsured_area" type="text" style="width:65%" value='${applicantInsured.area}' onblur="saveData();"/>
					<span>区/县</span>
				</div>
				
				<div class="input_div" id="app_town" style="display: none;">
  					<input id="applicantInsured_town" style="width:65%" type="text"/>
  					<span>镇/街道</span>
  				</div>
  				<div class="input_div" id="app_village" style="display: none;">
	  				<input id="applicantInsured_village" style="width:65%" type="text"/>
	  				<span id="app_community" style="display: none;">村/社区</span>
	  				<span id="app_doorNumber" style="display: none;">村/社区（门牌号）</span>
  				</div>
  						
				<div class="addr_div">
					<input id="applicantInsured_address" name="applicantInsured_address" type="text" style="margin:5px auto" placeholder="请填写详细地址" onblur="saveData();"/>
				</div>
				<input type="hidden" id="applicantInsured.address" name="applicantInsured.address" value="${applicantInsured.address}"/>
				<input type="hidden" id="recognizee.address" name="recognizee.address" value="${recognizee.address}" />
			</td>
		</tr>
	</table>
	<div class="checkbox_div txt14" id="commonApp">
		<input type="checkbox" id ="commonApplicant.flag" name="commonApplicant.flag"/>
		<div class="checkbox"><span class="checked_img"></span></div> 
	</div>
	<span class="makeComApp">作为常用投保人</span>
	<div class="clear"></div>
	<div class="title">被保险人信息</div>
		<table>
			<c:if test="${age >= 18}">
				<tr>
					<td class="noberder left">被保险人：</td><td width="65%" class="noberder">被保险人与投保人为同一人</td>
				</tr>
			</c:if>
			<c:if test="${age < 18}">
				<tr>
					<td class="left">与投保人关系：</td><td width="65%">父母</td>
				</tr>
  				<tr>
	  				<td width="35%" class="left" style="text-indent:5%;"><span class="must">*</span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
	  				<td width="65%"><input id="recognizee.name" name="recognizee.name" type="text" value="${recognizee.name}"/></td>
  				</tr>
  				<tr>
	  				<td class="txt14" style="text-indent:5%"><span class="must">*</span>职&emsp;&emsp;业：</td>
  					<td>
	  					<div class="addr_div">
	  						<div class="select_div">
	  							<select id="recognizee_industry" name="recognizee_industry" class="txt14"></select> 
	  						</div>
	  						<div class="select_div">
	  							<select id="recognizee_job" name="recognizee_job" class="txt14"></select> 	
	  						</div>	
	  					</div>
  					</td>
	  			</tr>
	  			<tr>
  					<td class="left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
  					<td><input type="text" id="recognizee.sex" name="recognizee.sex" readonly="readonly" value="${sex}" style="background: #E9E9E9"/></td>
  				</tr>
  				<tr>
  					<td class="left">出生日期：</td>
  					<td><input type="text" id="recognizee.birthday" class="birthdayDate" name="recognizee.birthday" value="${birthday}" readonly="readonly" style="background: #E9E9E9"/></td>
  				</tr>
	  			<tr>
	  				<td class="txt14" style="text-indent:5%"><span class="must">*</span>证件类型：</td>
  					<td>
  						<select id="recognizee.identifytype" name="recognizee.identifytype" class="txt14">
	  					 	<option value="I">身份证</option>
	  					 	<option value="O">户口薄</option>
  						</select> 	
  					</td>
	  			</tr>
  				<tr>
  					<td width="35%" class="left" style="text-indent:5%;"><span class="must">*</span>证件号码：</td>
  					<td>
  						<input type="text" id="recognizee.identifynumber" name="recognizee.identifynumber"  value="${recognizee.identifynumber}"/>
  					</td>
  				</tr>
  				<tr>
  					<td class="txt14" style="text-indent:5%"><span class="must">*</span>证件有效<br/>&emsp;&nbsp;&nbsp;止期：</td>
  					<td>
  						<input type="text" id="idPhotoData.recognizee_endTime" name="idPhotoData.recognizee_endTime" value="${idPhotoData.recognizee_endTime}" onchange="clickRecIdTime();"/>
  						<div class="checkbox_div txt14" id="commonApp">
 						<input type="checkbox"/>
 						<div class="checkbox recognizee_endTime"><span class="checked_img"></span></div>
 						长期有效
 						</div>
 					</td>
  				</tr>
  				
  				<tr>
	    			<td class="txt14" style="text-indent:5%"><span class="must">*</span>证件正面照：</td>
	    			<td><img id="idPhotoData.recognizee_frontal" name="idPhotoData.recognizee_frontal" src="" style="width:90%;height:90%;text-align:center"></td>	
	    		</tr>
	    		<tr>
	    			<td class="txt14" style="text-indent:5%"><span class="must">*</span>证件反面照：</td>
	    			<td><img id="idPhotoData.recognizee_reverse" name="idPhotoData.recognizee_reverse" src="" style="width:90%;height:90%;text-align:center"></td>	
	    		</tr>
  				<tr>
  					<td class="left" style="text-indent:5%;"><span class="must">*</span>手机号码：</td>
  					<td><input type="text" id="recognizee.mobile" name="recognizee.mobile" value="${recognizee.mobile}"/></td>
  				</tr>
  				<tr>
  					<td class="left" style="text-indent:5%;"><span class="must"></span>电子邮箱：</td>
  					<td><input type="text" id="recognizee.email" name="recognizee.email" value="${recognizee.email}"/></td>
  				</tr>
  				
  				<tr>
  					<td class="noberder left" style="text-indent:5%;"><span class="must">*</span>通讯地址：</td>
  					<td class="noberder">
  						<div class="addr_div">
  							<div class="select_div">
		  						<select name="recognizee_province" id="recognizee_province"></select>
	  						</div>
	  						<div class="select_div">
	  							<select name="recognizee_city" id="recognizee_city"></select>
  							</div>
  						</div>
  						<div class="input_div"><input id="recognizee_area" name="recognizee_area" type="text" style="width:65%"/><span>区/县</span></div>
  						
  						<div class="input_div" id="rec_town" style="display: none;">
  							<input id="recognizee_town" style="width:65%" type="text"/>
  							<span>镇/街道</span>
  						</div>
  						<div class="input_div" id="rec_village" style="display: none;">
	  						<input id="recognizee_village" style="width:65%" type="text"/>
	  						<span id="rec_community" style="display: none;">村/社区</span>
	  						<span id="rec_doorNumber" style="display: none;">村/社区（门牌号）</span>
  						</div>
  						
  						<div class="addr_div"><input id="recognizee_address" name="recognizee_address" type="text" style="margin:5px auto" placeholder="请填写详细地址"/></div>
  					</td>
  				</tr>
			</c:if>
		</table>
		<c:if test="${age < 18}">
		<div class="checkbox_div txt14" id="commonApp">
			<input type="checkbox" id ="" name=""/>
		<div class="checkbox useApplicantInsured_address"><span class="checked_img"></span></div> 
		</div>
		<span class="makeComApp">使用投保人通讯地址</span>
		</c:if>
	<div class="title">受益人信息</div>
	<table>
		<tr>
			<td class="noberder" style="text-indent: 5%"><span class="must">*</span>身故保险金<br/>&emsp;&nbsp;&nbsp;受益人：</td>
			<td class="noberder" width="65%">
				<select id="policy.islegalflag" name="policy.islegalflag" onchange="changeBnf();">
					<option value="2">法定</option>
					<option value="3">指定</option>
				</select>
			</td>
		</tr>
	</table>
  	<div id="beneficiaryId" style="display:none;">
		<table>
			<tr>
				<td><span style="color:red;float: left;margin-left: 17%;">温馨提示:</span></td>
				<td><span style="color:red;font-size:70%">指定受益人默认都是第1顺序受益人，最多指定3名，各受益人的受益比例之和需要为100%，受益人与被保险人的关系只能是父母、配偶、子女。</span></td>
			</tr>
			<tr>
				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>受益人个数：</td>
				<td width="65%">
					<select id="lCBnfCount" name="lCBnfCount" onchange="changeBnfNum();">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</td>
			</tr>
			<tbody id="tb1">
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>受益人一姓名：</td>
					<td><input type="text" id="policy.bnfName1" name="policy.bnfName1"/></td>
				</tr>
				<tr>
		  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件类型：</td>
	  				<td>
	  					<select id="lcbnf.IDType" name="lcbnf.IDType" class="txt14" value="${lcbnf.IDType}">
	  					 	<option value="I">身份证</option>
	  					 	<option value="O">户口薄</option>
	  					</select> 	
	  				</td>
		  		</tr>
		  		<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件有效<br/>&emsp;&nbsp;&nbsp;止期：</td>
	  				<td>
	  					<input type="text" id="lcbnf.IDExpDate" name="lcbnf.IDExpDate" value="${lcbnf.IDExpDate}" onchange="clickBnf1IdTime();"/>
	  					<div class="checkbox_div txt14" id="commonApp">
 						<input type="checkbox"/>
 						<div class="checkbox IDExpDate"><span class="checked_img"></span></div>
 						长期有效
 						</div>
	  				</td>
	  			</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件号码：</td>
					<td><input type="text" id="policy.bnfIDNo1" name="policy.bnfIDNo1" value="${policy.bnfIDNo1}" onchange="onchangeBnfIdNo();"/></td>
				</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>性&emsp;&emsp;别：</td>
					<td>
						<select id="policy.bnfSex1" name="policy.bnfSex1" class="txt14">
	  					 	<option value="M">男</option>
	  					    <option value="F">女</option>
	  					</select> 	
					</td>
				</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>出生日期：</td>
					<td><input type="text" id="policy.bnfBirthday1" name="policy.bnfBirthday1" value="${policy.bnfBirthday1}"/></td>
				</tr>
				<tr>
	  				<td class="left" style="text-indent: 5%;"><span class="must">*</span>手机号码：</td>
	  				<td><input type="text" id="lcbnf.BnfMobile" name="lcbnf.BnfMobile" value="${lcbnf.BnfMobile}"/></td>
	  			</tr>
				<tr>
	  				<td style="text-indent: 5%;"><span class="must">*</span>通讯地址：</td>
	  				<td>
	  					<div class="addr_div">
	  						<div class="select_div">
			  					<select name="lCBnf_province" id="lCBnf_province"></select>
		  					</div>
		  					<div class="select_div">
		  						<select name="lCBnf_city" id="lCBnf_city"></select>
	  						</div>
	  					</div>
	  					<div class="input_div">
		  						<input id="lCBnf_conty" name="lCBnf_conty" type="text" style="width:65%"/>
		  						<span>区/县</span>
	  					</div>
	  					
	  					<div class="input_div" id="lbf_town" style="display: none;">
  							<input id="lCBnf_town" style="width:65%" type="text"/>
  							<span>镇/街道</span>
  						</div>
  						<div class="input_div" id="lbf_village" style="display: none;">
	  						<input id="lCBnf_village" style="width:65%" type="text"/>
	  						<span id="lbf_community" style="display: none;">村/社区</span>
	  						<span id="lbf_doorNumber" style="display: none;">村/社区（门牌号）</span>
  						</div>
	  					
	  					<div class="addr_div"><input id="lCBnf_address" name="lCBnf_address" type="text" style="margin:5px auto" placeholder="请填写详细地址"/></div>
	  					<input type="hidden" id="lcbnf.Address" name="lcbnf.Address" value="${lcbnf.Address}"/>
	  				</td>
	  			</tr>
	  			<tr>
		  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>职&emsp;&emsp;业：</td>
	  				<td>
	  					<div class="addr_div">
	  						<div class="select_div">
	  							<select id="lCBnf_industry" name="lCBnf_industry" class="txt14"></select> 
	  						</div>
	  						<div class="select_div">
	  							<select id="lCBnf_job" name="lCBnf_job" class="txt14"></select> 	
	  						</div>	
	  					</div>
	  				</td>
		  		</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>与被保人关系：</td>
					<td>
						<select id="policy.relationToInsured1" name="policy.relationToInsured1">
							<option value="">请选择</option>
							<option value="PA">父母</option>
							<option value="SP">配偶</option>
							<option value="CH">子女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><span style="display: block;float: left;margin-left: 17%;">受益顺序：</span></td>
					<td>第一顺序受益人</td>
				</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>受益比例：</td>
					<td><input type="text" style="width:20%" id="policy.bnfLot1" name="policy.bnfLot1"/>%</td>
				</tr>
			</tbody>
			<tbody id="tb2" style="display:none;">
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>受益人二姓名：</td>
					<td><input type="text" id="policy.bnfName2" name="policy.bnfName2"/></td>
				</tr>
				<tr>
		  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件类型：</td>
	  				<td>
	  					<select id="lcbnf2.IDType" name="lcbnf2.IDType" class="txt14">
	  					 	<option value="I">身份证</option>
	  					 	<option value="O">户口薄</option>
	  					</select> 	
	  				</td>
		  		</tr>
		  		<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件有效<br/>&emsp;&nbsp;&nbsp;止期：</td>
	  				<td>
	  					<input type="text" id="lcbnf2.IDExpDate" name="lcbnf2.IDExpDate" value="${lcbnf2.IDExpDate}" onchange="clickBnf2IdTime();"/>
	  					<div class="checkbox_div txt14" id="commonApp">
 						<input type="checkbox"/>
 						<div class="checkbox IDExpDate2"><span class="checked_img"></span></div>
 						长期有效
 						</div>
	  				</td>
	  			</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件号码：</td>
					<td><input type="text" id="policy.bnfIDNo2" name="policy.bnfIDNo2" value="${policy.bnfIDNo2}" onchange="onchangeBnf2IdNo();"/></td>
				</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>性&emsp;&emsp;别：</td>
					<td>
						<select id="policy.bnfSex2" name="policy.bnfSex2" class="txt14">
	  					 	<option value="M">男</option>
	  					    <option value="F">女</option>
	  					</select>
	  				</td>
				</tr>
				<tr>
					<td><span style="display: block;float:left;margin-left: 17%;">出生日期：</span></td>
					<td><input type="text" id="policy.bnfBirthday2" name="policy.bnfBirthday2" value="${policy.bnfBirthday2}"/></td>
				</tr>
				<tr>
	  				<td class="left" style="text-indent: 5%;"><span class="must">*</span>手机号码：</td>
	  				<td><input type="text" id="lcbnf2.BnfMobile" name="lcbnf2.BnfMobile" value="${lcbnf2.BnfMobile}"/></td>
	  			</tr>
				<tr>
	  				<td style="text-indent: 5%;"><span class="must">*</span>通讯地址：</td>
	  				<td>
	  					<div class="addr_div">
	  						<div class="select_div">
			  					<select name="lCBnf2_province" id="lCBnf2_province"></select>
		  					</div>
		  					<div class="select_div">
		  						<select name="lCBnf2_city" id="lCBnf2_city"></select>
	  						</div>
	  					</div>
	  					<div class="input_div">
		  						<input id="lCBnf2_conty" name="lCBnf2_conty" type="text" style="width:65%"/>
		  						<span>区/县</span>
	  					</div>
	  					
	  					<div class="input_div" id="lbf2_town" style="display: none;">
  							<input id="lCBnf2_town" style="width:65%" type="text"/>
  							<span>镇/街道</span>
  						</div>
  						<div class="input_div" id="lbf2_village" style="display: none;">
	  						<input id="lCBnf2_village" style="width:65%" type="text"/>
	  						<span id="lbf2_community" style="display: none;">村/社区</span>
	  						<span id="lbf2_doorNumber" style="display: none;">村/社区（门牌号）</span>
  						</div>
	  					
	  					<div class="addr_div"><input id="lCBnf2_address" name="lCBnf2_address" type="text" style="margin:5px auto" placeholder="请填写详细地址"/></div>
	  					<input type="hidden" id="lcbnf2.Address" name="lcbnf2.Address" value="${lcbnf2.Address}"/>
	  				</td>
	  			</tr>
	  			<tr>
		  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>职&emsp;&emsp;业：</td>
	  				<td>
	  					<div class="addr_div">
	  						<div class="select_div">
	  							<select id="lCBnf2_industry" name="lCBnf2_industry" class="txt14"></select> 
	  						</div>
	  						<div class="select_div">
	  							<select id="lCBnf2_job" name="lCBnf2_job" class="txt14"></select> 	
	  						</div>	
	  					</div>
	  				</td>
		  		</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>与被保人关系：</td>
					<td>
						<select id="policy.relationToInsured2" name="policy.relationToInsured2">
							<option value="">请选择</option>
							<option value="PA">父母</option>
							<option value="SP">配偶</option>
							<option value="CH">子女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><span style="display: block;float: left;margin-left: 17%;">受益顺序：</span></td>
					<td>第一顺序受益人</td>
				</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>受益比例：</td>
					<td><input type="text" style="width:20%" id="policy.bnfLot2" name="policy.bnfLot2"/>%</td>
				</tr>
			</tbody>
			<tbody id="tb3" style="display:none;">
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>受益人三姓名：</td>
					<td><input type="text" id="policy.bnfName3" name="policy.bnfName3"/></td>
				</tr>
				<tr>
		  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件类型：</td>
	  				<td>
	  					<select id="lcbnf3.IDType" name="lcbnf3.IDType" class="txt14">
	  					 	<option value="I">身份证</option>
	  					 	<option value="O">户口薄</option>
	  					</select> 	
	  				</td>
		  		</tr>
		  		<tr>
	  				<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件有效<br/>&emsp;&nbsp;&nbsp;止期：</td>
	  				<td>
	  					<input type="text" id="lcbnf3.IDExpDate" name="lcbnf3.IDExpDate" value="${lcbnf3.IDExpDate}" onchange="clickBnf3IdTime();"/>
	  					<div class="checkbox_div txt14" id="commonApp">
 						<input type="checkbox"/>
 						<div class="checkbox IDExpDate3"><span class="checked_img"></span></div>
 						长期有效
 						</div>
	  				</td>
	  			</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>证件号码：</td>
					<td><input type="text" id="policy.bnfIDNo3" name="policy.bnfIDNo3" value="${policy.bnfIDNo3}" onchange="onchangeBnf3IdNo();"/></td>
				</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>性&emsp;&emsp;别：</td>
					<td>
						<select id="policy.bnfSex3" name="policy.bnfSex3" class="txt14">
	  					 	<option value="M">男</option>
	  					    <option value="F">女</option>
	  					</select>
					</td>
				</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>出生日期：</td>
					<td><input type="text" id="policy.bnfBirthday3" name="policy.bnfBirthday3" readonly="readonly" value="${policy.bnfBirthday3}"/></td>
				</tr>
				<tr>
	  				<td class="left" style="text-indent: 5%;"><span class="must">*</span>手机号码：</td>
	  				<td><input type="text" id="lcbnf3.BnfMobile" name="lcbnf3.BnfMobile" value="${lcbnf3.BnfMobile}"/></td>
	  			</tr>
				<tr>
	  				<td style="text-indent: 5%;"><span class="must">*</span>通讯地址：</td>
	  				<td>
	  					<div class="addr_div">
	  						<div class="select_div">
			  					<select name="lCBnf3_province" id="lCBnf3_province"></select>
		  					</div>
		  					<div class="select_div">
		  						<select name="lCBnf3_city" id="lCBnf3_city"></select>
	  						</div>
	  					</div>
	  					<div class="input_div">
		  						<input id="lCBnf3_conty" name="lCBnf3_conty" type="text" style="width:65%"/>
		  						<span>区/县</span>
	  					</div>
	  					
	  					<div class="input_div" id="lbf3_town" style="display: none;">
  							<input id="lCBnf3_town" style="width:65%" type="text"/>
  							<span>镇/街道</span>
  						</div>
  						<div class="input_div" id="lbf3_village" style="display: none;">
	  						<input id="lCBnf3_village" style="width:65%" type="text"/>
	  						<span id="lbf3_community" style="display: none;">村/社区</span>
	  						<span id="lbf3_doorNumber" style="display: none;">村/社区（门牌号）</span>
  						</div>
	  					
	  					
	  					<div class="addr_div"><input id="lCBnf3_address" name="lCBnf3_address" type="text" style="margin:5px auto" placeholder="请填写详细地址"/></div>
	  					<input type="hidden" id="lcbnf3.Address" name="lcbnf3.Address" value="${lcbnf3.Address}"/>
	  				</td>
	  			</tr>
	  			<tr>
		  			<td class="txt14" style="text-indent: 5%"><span class="must">*</span>职&emsp;&emsp;业：</td>
	  				<td>
	  					<div class="addr_div">
	  						<div class="select_div">
	  							<select id="lCBnf3_industry" name="lCBnf3_industry" class="txt14"></select> 
	  						</div>
	  						<div class="select_div">
	  							<select id="lCBnf3_job" name="lCBnf3_job" class="txt14"></select> 	
	  						</div>	
	  					</div>
	  				</td>
		  		</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>与被保人关系：</td>
					<td>
						<select id="policy.relationToInsured3" name="policy.relationToInsured3">
							<option value="">请选择</option>
							<option value="PA">父母</option>
							<option value="SP">配偶</option>
							<option value="CH">子女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><span style="display: block;float: left;margin-left: 17%;">受益顺序：</span></td>
					<td>第一顺序受益人</td>
				</tr>
				<tr>
					<td class="txt14" style="text-indent: 5%"><span class="must">*</span>受益比例：</td>
					<td><input type="text" style="width:20%" id="policy.bnfLot3" name="policy.bnfLot3"/>%</td>
				</tr>
			</tbody>
		</table>
	</div>	
  	<div class="title">缴费信息</div>
	<div class="radio_div" id="bankcheck">
	    <table  class="txt16">
		 	<tr>
				<td class="noberder" style="text-indent: 5%">缴费方式：</td>
				<td class="noberder" width="65%">银行代扣</td>
			</tr>
		</table>
	</div>
	<div class="title">声明信息</div>
	<div class="info_table txt14">
 		<table>
	  		<tr>
		 		<td colspan="2" style="text-indent:0;height:25px;" class="noberder">本人声明：</td>
			</tr>
			<tr>
				<td class="noberder" style="height:25px;">
					<input type="radio" id="checkboxsure"  style="display:none;" name="paytaxes"/>
		  			<div class="checkbox_a" style="border-radius:50%;margin-right:5px;" ><span class="checked_img"></span></div>
		  		</td>
				<td class="noberder" style="height:25px;">本人仅为中国大陆税收居民</td>
			</tr>
			<tr>
				<td class="noberder" style="height:25px;" valign="top">
					<input type="radio" id="checkboxsure" style="display:none;" name="paytaxes"/>
		  			<div class="checkbox_a" style="border-radius:50%;margin-right:5px;"><span class="checked_img"></span></div>
		  		</td>
				<td class="noberder" style="height:25px;">仅为非居民，或既是中国大陆税收居民又是其他税收管辖区居民<br/></td>
			</tr>
			<tr>
				<td  colspan="2" style="text-indent:0;" class="noberder">&#9670;本人确认上述税收居民身份信息真实、准确和完整，且当信息发生变化时，将在30日内通知贵公司，否则本人承担由此造成的不利后果。<br/></td>
			</tr>
			<tr>
				<td  colspan="2" style="text-indent:0;height:25px;" class="noberder"><br/>温馨提示：<br/></td>
			</tr>
			<tr id="reminderAB">
				<td  colspan="2" style="text-indent:0;" class="noberder">1、中国税收居民是指在中国境内有住所，或者无住所而在境内居住满一年的个人，不含港澳台地区，因此我司又称中国大陆税收居民……<a onclick="showAll();" style="color:blue;">&nbsp;&nbsp;显示更多</a></td>
			</tr>
			<tr id="remindertotalOne" style="display:none;">
				<td  colspan="2" style="text-indent:0;" class="noberder">1、中国税收居民是指在中国境内有住所，或者无住所而在境内居住满一年的个人，不含港澳台地区，因此我司又称中国大陆税收居民。在中国境内有住所是指因户籍、家庭、经济利益关系而在中国境内习惯性居住。在境内居住满一年，是指在一个纳税年度中在中国境内居住365日。临时离境的，不扣减日数。临时离境，是指在一个纳税年度中一次不超过30日或者多次累计不超过90日的离境。</td>
			</tr>
			<tr id="remindertotalTwo" style="display:none;">
				<td  colspan="2" style="text-indent:0;" class="noberder">2、非居民是指中国大陆税收居民以外的个人、企业和其他组织、但不包括政府机构、国际组织、中央银行、金融机构或者在证券市场上市交易的公司及其关联机构。前述证券市场是指被所在地政府认可和监管的证券市场。其他辖区税收居民个人有关判定依据及纳税人识别号相关信息请参见国家税务总局网站（www.chinatax.gov.cn）。</td>
			</tr>
		</table>
		<input type="hidden" id="img1" name="img1" value="N"/>
		<input type="hidden" id="img2" name="img2" value="N"/>
		<input type="hidden" id="img3" name="img3" value="N"/>
		<input type="hidden" id="img4" name="img4" value="N"/>
	</div>
	</section>
  	</form>	
	<!-- 按钮区域 -->
   	<section class="btn_wrap">
   		<div class="one_btn txt22" onclick="save();">下一步</div>
   	</section>
   	<div class="footer">
		<div class="img_div"><img class="logoimg" src="<%=request.getContextPath()%>/global/global/images/logo.png"></div>
		<div class="addr_div txt10">
			<div class="foot_span">客户服务专线：4008109339</div>
			<div class="foot_span">网址：www.oldmutual-chnenergy.com</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
</body>
<script>
	$(".checkbox").click(function(){
		if($(this).prev().prop("checked")==false){
			$(this).find(".checked_img").show();
			$(this).prev().prop("checked",true);
		}else{
			$(this).find(".checked_img").hide();
			$(this).prev().prop("checked",false);
		}
	});
	$(".checkbox_a").click(function(){
		$(".checkbox_a").find(".checked_img").hide();
		$(".checkbox_a").prev().prop("checked",false);
		if($(this).prev().prop("checked")==false){
			$(this).find(".checked_img").show();
			$(this).prev().prop("checked",true);
		}
	});
</script>
<script type="text/javascript">
	brNo1="${brNo}";
	isAgentCode ="${isAgentCode}";	//推荐人是否必填
	recognizeeAge ="${age}"; //被保人年龄
	recognizeeSex ="${sex}"; //被保人性别
	recognizeeBirthday ="${birthday}"; //被保人生日
	
	function backshow(){
		var agentCode = sessionStorage.getItem("agentCode");
		var applicantInsuredname = sessionStorage.getItem("applicantInsuredname"); 
		var applicantInsured_industry = sessionStorage.getItem("applicantInsured_industry"); 
		var applicantInsured_job = sessionStorage.getItem("applicantInsured_job"); 
		var applicantInsuredidentifytype = sessionStorage.getItem("applicantInsuredidentifytype"); 
		var applicantInsuredidentifynumber = sessionStorage.getItem("applicantInsuredidentifynumber"); 
		var idPhotoDataApplicantInsured_endTime = sessionStorage.getItem("idPhotoDataApplicantInsured_endTime"); 
		var applicantInsuredMobile = sessionStorage.getItem("applicantInsuredMobile"); 
		var applicantInsuredEmail = sessionStorage.getItem("applicantInsuredEmail"); 
		var applicantInsured_area = sessionStorage.getItem("applicantInsured_area"); 
		var applicantInsured_address = sessionStorage.getItem("applicantInsured_address"); 
		if(agentCode!=null){
			document.getElementById("policy.agentcode").value = agentCode; 
			onchangeArea();
		}
		document.getElementById("applicantInsured.name").value = applicantInsuredname; 
		if(applicantInsured_industry!= null && applicantInsured_industry!="" && applicantInsured_industry != 'null'){
			document.getElementById("applicantInsured_industry").value = applicantInsured_industry; 
			var s_industry=document.getElementById("applicantInsured_industry"); 
			var obj = document.getElementById("applicantInsured_job");
			var index=s_industry.selectedIndex-1; //序号，取当前选中选项的序号 
			var str="0_"+index.toString();
			if(dsy.Exists(str)){
				ar = dsy.Items[str];
				for(i=0;i<ar.length;i++){
					obj.options.add(new Option(ar[i],ar[i])); 
				}
			}
			if(applicantInsured_job!=null && applicantInsured_job!="" & applicantInsured_job!='null'){
				document.getElementById("applicantInsured_job").value = applicantInsured_job; 
			}
		}
		if(applicantInsuredidentifytype!=null){
			document.getElementById("applicantInsured.identifytype").value = applicantInsuredidentifytype; 
		}
		document.getElementById("applicantInsured.identifynumber").value = applicantInsuredidentifynumber; 
		document.getElementById("idPhotoData.applicantInsured_endTime").value = idPhotoDataApplicantInsured_endTime; 
		document.getElementById("applicantInsured.mobile").value = applicantInsuredMobile; 
		document.getElementById("applicantInsured.email").value = applicantInsuredEmail; 
		document.getElementById("applicantInsured_area").value = applicantInsured_area; 
		document.getElementById("applicantInsured_address").value = applicantInsured_address; 
		if(recognizeeAge<18){
			document.getElementById("applicantInsuredSex_min").value = applicantInsuredSex_min; 
			document.getElementById("applicantInsuredBirthday_min").value = applicantInsuredBirthday_min; 
		}
	}
	
	//保存投被保人信息并将页面跳转至健康告知
	function save(){
		var agentCode = getObj("policy.agentcode");
		//校验
		if(!check()){
			return false;
		}
		
		//移除disabled属性
		$("#applicantInsured_province").removeAttr("disabled");
		$("#applicantInsured_city").removeAttr("disabled");
		//给投保人性别 生日 赋值
		if(recognizeeAge>=18){	
			var br = getObj("applicantInsuredBirthday_max");
			var sex =  getObj("applicantInsuredSex_max")=="男"?"M":"F";
			document.getElementById("applicantInsured.birthday").value = br; 
			document.getElementById("applicantInsured.sex").value = sex; 
		}else if(recognizeeAge<18){
			var br = getObj("applicantInsuredBirthday_min");
			var sex =  getObj("applicantInsuredSex_min");
			document.getElementById("applicantInsured.birthday").value = br; 
			document.getElementById("applicantInsured.sex").value = sex; 
		}
		
		if(brNo1=='A0000'||brNo1==null||brNo1.length==0){
			if(agentCode!=null&&agentCode.length>0){
				var flag=false;
				$.ajax({
					type:"POST",
					url:"<%=request.getContextPath() %>/msl/sales/existDepart",
					data:"agentCode="+agentCode,
					dataType:"json",
					success:function(data){
					if(data.flag=="0"){
						document.getElementById("policy.deptid").value=data.content;
						$("#creator").submit();
					}else if(data.flag=="1")
						alert(data.content);
					}
				});   
				if(!flag){
					return false;
				}else{
					$("#creator").submit();
				}
			}else{
				$("#creator").submit();
			}
		}
	}
	
	//常用投保人按钮	
	$(".checkboxCom").click(function(){
		if($(this).prev().prop("checked")){
			var name = $(this).parent("div").find(".comName").val();
			var idno = $(this).parent("div").find(".comIdno").val();
			var mobile = $(this).parent("div").find(".comMobile").val();
			var email = $(this).parent("div").find(".comEmail").val();
			document.getElementById("applicantInsured.name").value=name;
			document.getElementById("applicantInsured.mobile").value=mobile;
			document.getElementById("applicantInsured.email").value=email;
			document.getElementById("applicantInsured.identifynumber").value=idno;
		}else{
			document.getElementById("applicantInsured.name").value="";
			document.getElementById("applicantInsured.mobile").value="";
			document.getElementById("applicantInsured.email").value="";
			document.getElementById("applicantInsured.identifynumber").value="";
		}
// 		$("#commonApp").toggle();
// 		$(".makeComApp").toggle();
	});
	
	//投保人证件有效止期长期
	$(".applicantInsured_endTime").click(function(){
		if($(this).prev().prop("checked")){
			//把选择框改为
			document.getElementById("idPhotoData.applicantInsured_endTime").value="长期有效";
		}else{
			document.getElementById("idPhotoData.applicantInsured_endTime").value="";
		}
	});
	
	//被保人证件有效止期长期
	$(".recognizee_endTime").click(function(){
		if($(this).prev().prop("checked")){
			//把选择框改为
			document.getElementById("idPhotoData.recognizee_endTime").value="长期有效";
		}else{
			document.getElementById("idPhotoData.recognizee_endTime").value="";
		}
	});
	
	$(".IDExpDate3").click(function(){
		if($(this).prev().prop("checked")){
			//把选择框改为
			document.getElementById("lcbnf3.IDExpDate").value="长期有效";
		}else{
			document.getElementById("lcbnf3.IDExpDate").value="";
		}
	});
	$(".IDExpDate2").click(function(){
		if($(this).prev().prop("checked")){
			//把选择框改为
			document.getElementById("lcbnf2.IDExpDate").value="长期有效";
		}else{
			document.getElementById("lcbnf2.IDExpDate").value="";
		}
	});
	$(".IDExpDate").click(function(){
		if($(this).prev().prop("checked")){
			//把选择框改为
			document.getElementById("lcbnf.IDExpDate").value="长期有效";
		}else{
			document.getElementById("lcbnf.IDExpDate").value="";
		}
	});
	
	//使用投保人通讯地址
	$(".useApplicantInsured_address").click(function(){
		if($(this).prev().prop("checked")){
			var applicantInsured_province = getObj("applicantInsured_province");//投保人 省
			var applicantInsured_city = getObj("applicantInsured_city");//投保人 市
			var applicantInsured_area = getObj("applicantInsured_area");//投保人  区/县
			var applicantInsured_address = getObj("applicantInsured_address");//投保人 详细地址
			//校验投保人地址是否合法
			if(!checkAddress(applicantInsured_province,applicantInsured_city,applicantInsured_area,applicantInsured_address,"投保人")){
				$(this).find(".checked_img").hide();
				$(this).prev().prop("checked",false);
				return false;
			}
			if(prohibit == "HZ" || prohibit == "GZ" || prohibit=="XA"){
				var applicantInsured_town = getObj("applicantInsured_town");//投保人  镇/街道
				var applicantInsured_village = getObj("applicantInsured_village");//投保人 村/社区
				if(!checkTownAndVillage(applicantInsured_town,applicantInsured_village,"投保人")){
					$(this).find(".checked_img").hide();
					$(this).prev().prop("checked",false);
					return false;
				}
				if(prohibit == "HZ" || prohibit == "GZ"){
					var applicantInsured_address = applicantInsured_town+"镇/街道"+applicantInsured_village+"村/社区"+applicantInsured_address;
				}else if(prohibit == "XA"){
					document.getElementById("recognizee_town").value=applicantInsured_town;
					document.getElementById("recognizee_village").value=applicantInsured_village;
				}
			}
			
			var obj = document.getElementById("recognizee_city");
			if(applicantInsured_province!= null && applicantInsured_province!="" && applicantInsured_province != 'null'){
				document.getElementById("recognizee_province").value=applicantInsured_province;
				var s_province=document.getElementById("recognizee_province"); 
				var index=s_province.selectedIndex-1; //序号，取当前选中选项的序号 
				var str="0_"+index.toString();
				if(dsy_area.Exists(str)){
					ar = dsy_area.Items[str];
					for(i=0;i<ar.length;i++){
						obj.options.add(new Option(ar[i],ar[i])); 
					}
				}
				if(applicantInsured_city!=null && applicantInsured_city!="" & applicantInsured_city!='null'){
					document.getElementById("recognizee_city").value=applicantInsured_city; 
				}
			}
			document.getElementById("recognizee_area").value=applicantInsured_area;
			document.getElementById("recognizee_address").value=applicantInsured_address;
		}else{
			init_recArea();
			document.getElementById("recognizee_area").value="";
			document.getElementById("recognizee_address").value="";
		}
	});
	
	
	//根据推荐人编码锁定投保人省市	
	function onchangeArea(){
		var agentCode = getObj("policy.agentcode");
		//未销售地区
		prohibit = agentCode.substring(0,2).toUpperCase();
		if(prohibit == "CQ"){
			document.getElementById("policy.agentcode").value="";
			document.getElementById("policy.agentcode").focus();
			alert("该产品未开始在重庆地区销售");
			return false;
		}
		//默认全部隐藏
		document.getElementById("app_town").style.display="none"; 
		document.getElementById("app_village").style.display="none"; 
		document.getElementById("app_doorNumber").style.display="none"; 
		document.getElementById("app_community").style.display="none"; 
		if(recognizeeAge < 18){
			document.getElementById("rec_town").style.display="none"; 
			document.getElementById("rec_village").style.display="none"; 
			document.getElementById("rec_community").style.display="none"; 
			document.getElementById("rec_doorNumber").style.display="none"; 
		}		
		document.getElementById("lbf_town").style.display="none"; 
		document.getElementById("lbf_village").style.display="none"; 
		document.getElementById("lbf_community").style.display="none"; 
		document.getElementById("lbf_doorNumber").style.display="none"; 
		document.getElementById("lbf2_town").style.display="none"; 
		document.getElementById("lbf2_village").style.display="none"; 
		document.getElementById("lbf2_community").style.display="none"; 
		document.getElementById("lbf2_doorNumber").style.display="none"; 
		document.getElementById("lbf3_town").style.display="none"; 
		document.getElementById("lbf3_village").style.display="none"; 
		document.getElementById("lbf3_community").style.display="none"; 
		document.getElementById("lbf3_doorNumber").style.display="none"; 
		//浙江HZ 广州GZ 投保人地址到社区   
		if(prohibit == "HZ" || prohibit == "GZ"){
			document.getElementById("app_town").style.display="block"; 
			document.getElementById("app_village").style.display="block"; 
			document.getElementById("app_community").style.display=""; 
		}else if(prohibit == "XA"){//陕西XA 投保人.被保险人、受益人 地址到门牌号 
			document.getElementById("app_town").style.display="block"; 
			document.getElementById("app_village").style.display="block"; 
			document.getElementById("app_doorNumber").style.display="";  
			if(recognizeeAge < 18){
				document.getElementById("rec_town").style.display="block"; 
				document.getElementById("rec_village").style.display="block"; 
				document.getElementById("rec_doorNumber").style.display=""; 
			}	
			document.getElementById("lbf_town").style.display="block"; 
			document.getElementById("lbf_village").style.display="block"; 
			document.getElementById("lbf_doorNumber").style.display=""; 
			document.getElementById("lbf2_town").style.display="block"; 
			document.getElementById("lbf2_village").style.display="block"; 
			document.getElementById("lbf2_doorNumber").style.display=""; 
			document.getElementById("lbf3_town").style.display="block"; 
			document.getElementById("lbf3_village").style.display="block"; 
			document.getElementById("lbf3_doorNumber").style.display=""; 
		}
		
		if(agentCode!=null&&agentCode.length>0){
			$.ajax({
				type:"POST",
				url:"<%=request.getContextPath()%>/msl/sales/rxakDepartToArea",
				data:"agentCode="+agentCode,
				dataType:"json",
				success:function(data){
					sessionStorage.setItem("agentCode", agentCode);
					//移除disabled属性
					$("#applicantInsured_province").removeAttr("disabled");
					$("#applicantInsured_city").removeAttr("disabled");
					//移除市里的数据
					var obj = document.getElementById("applicantInsured_city");
	 				document.getElementById("applicantInsured_city").options.length = 0;  
					
					if(data.flag=="0"){//锁定省市
						var stateName = data.stateName;
						var cityName = data.cityName;
						if(stateName!= null && stateName!="" && stateName != 'null'){
							document.getElementById("applicantInsured_province").value = stateName;
							$("#applicantInsured_province").attr("disabled","disabled");
							var s_province=document.getElementById("applicantInsured_province"); 
							var index=s_province.selectedIndex-1; //序号，取当前选中选项的序号 
							var str="0_"+index.toString();
							if(dsy_area.Exists(str)){
					       	    ar = dsy_area.Items[str];
					       		for(i=0;i<ar.length;i++){
									obj.options.add(new Option(ar[i],ar[i])); 
					     	    }
				     	    }
				     	    if(cityName!=null && cityName!="" & cityName!='null'){
								document.getElementById("applicantInsured_city").value = cityName; 
								$("#applicantInsured_city").attr("disabled","disabled");
							}
						}
					}else if(data.flag=="1"){//锁定省
						var stateName = data.stateName;
						if(stateName!= null && stateName!="" && stateName != 'null'){
							document.getElementById("applicantInsured_province").value = stateName;
							$("#applicantInsured_province").attr("disabled","disabled");
							var s_province=document.getElementById("applicantInsured_province"); 
							var index=s_province.selectedIndex-1; //序号，取当前选中选项的序号 
							var str="0_"+index.toString();
							if(dsy_area.Exists(str)){
					       	    ar = dsy_area.Items[str];
					       		for(i=0;i<ar.length;i++){
									obj.options.add(new Option(ar[i],ar[i])); 
					     	    }
					     	    $('#applicantInsured_city option[value="市/区"]').remove(); 
					     	    $('#applicantInsured_city option[value="深圳市"]').remove();
				     	    }
						}
					}else if(data.flag=="2"){
						alert(data.content);	
					}
				}
			});   
		}
	} 
	
	function IdentityCodeValid(code,type,str){var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};var tip="";var pass=true;if(!code||!/(^\d{15}$)|(^\d{17}(\d|X)$)/.test(code)){if(type){tip=str+"身份证号格式错误"}else{tip="被保险人身份证号格式错误"}pass=false}if(!city[code.substr(0,2)]){if(type){tip="身份证地址编码错误"}else{tip="被保人身份证地址编码错误"}pass=false}else{if(code.length==18){code=code.split('');var factor=[7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2];var parity=[1,0,'X',9,8,7,6,5,4,3,2];var sum=0;var ai=0;var wi=0;for(var i=0;i<17;i++){ai=code[i];wi=factor[i];sum+=ai*wi}var last=parity[sum%11];if(parity[sum%11]!=code[17]){if(type){tip=str+"身份证校验位错误"}else{tip="被保人身份证校验位错误"}pass=false}}}if(!pass)alert(tip);return pass}
	
	function getSex(value){
		if (parseInt(value.substr(16, 1)) % 2 == 1) {
			return "M";
		} else {
			return "F"; 
		} 
	}
	
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
	
	function getObj(id){
		return document.getElementById(id).value;
	}
	
	function checkName(name,type){
		if(name==""||name.length==0){
			alert("请输入"+type+"姓名");
			return false;
		}else if(!/^[a-zA-Z ]{3,20}$/.test(name)&&!/^[\u4e00-\u9fa5]{2,10}$/.test(name)){
			alert("请输入正确的"+type+"姓名");
			return false;
		}else{
			return true;
		}	
	}
	
	function checkJob(industry,job,type){
		if(industry=="行业分类"||job=="职业类型"){
			alert("请选择"+type+"的职业类型");
			return false;
		}
		else{
			return true;
		}
	}
	
	function check1(value,type){
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
	
	function checkIdNo(idNo,idType,type){
		if(idType == 'I'){//校验身份证号
			if(idNo==""||idNo.length==0){
				alert("请输入"+type+"身证件号");
				return false;
			}else if(!IdentityCodeValid(idNo,true,type)){
				return false;
			}else{
				return true;
			}
		}else{//校验其它证件
			if(idNo==""||idNo.length==0){
				alert("请输入"+type+"证件号");
				return false;
			}else if(!check1(idNo,idType)){
				return false;
			}else{
				return true;
			}
		}
	}
	
	function checkIdTime(idTime,str){
		if(idTime=="" || idTime == null || idTime.length == 0){
			alert("请选择"+str+"证件有效止期");
			return false;
		}else{
			return true;
		}	
	}
	
	function checkMobile(mobile,str){
  		var re1 = /^0?1[3|7|5|8][0-9]\d{8}$/;
  	  	if(!re1.test(mobile)){
  	  		alert("请输入正确的"+str+"手机号码");
  			return false;
  	 	}else{
			return true;
		}
  	}
  	
	function checkEmail(email,str){
		var re2 =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(email.length==0||email==""){
			alert("请输入"+str+"的电子邮箱");
			return false;
		}else if(!re2.test(email)){
			alert(str+"电子邮箱有误,请核对后输入");
			return false;
		}else{
			return true;
		}
	}
	
	function checkTownAndVillage(town,village,str){
		if(town==""|| town.length==0){
			alert("请输入"+str+"镇/街道信息");
			return false;
		}else if(village=="" || village==null || village.length==0){
			alert("请输入"+str+"村/社区信息");
			return false;
		}else if(town.length<2){
			alert("请输入"+str+"镇/街道有效地址");
			return false;
		}else if(village.length<2){
			alert("请输入"+str+"村/社区有效地址");
			return false;
		}else{
			return true;
		}
	}
	
	function checkAddress(province,city,area,address,str){
		var re3 = /[\u4e00-\u9fa5]|[a-zA-Z]/; 
		if(province=="省/市"||city=="市/区"){
			alert("请选择"+str+"通讯地址");
			return false;
		}else if(area==""|| area.length==0){
			alert("请输入"+str+"区/县信息");
			return false;
		}else if(address=="" || address==null || address.length==0){
			alert("请输入"+str+"详细地址");
			return false;
		}
		if(prohibit == "HZ" || prohibit == "GZ" || prohibit == "XA"){
			var regMin = 2;
		}else{
			var regMin = 10;
		}
		if(address.length<regMin||address.length>40){
			alert("请输入"+str+"有效地址");
			return false;
		}else if(!re3.test(address+area)){
			alert("请输入"+str+"有效地址");
			return false;
		}else{
			return true;
		}
	}	
	
	function checkBr(idType,idNo,birthday,sex,str){
		if(birthday=="" || birthday==null || birthday.length==0){
			alert("请选择"+str+"出生日期");
			return false;
		}
		if(idType== "I"){
			var sex1 = getSex(idNo);
			if(sex!=sex1){
				alert(str+"身份证号与性别不相符");
				return false;
			}
			var br = getBirth(idNo);
			if(br!=birthday){
				alert(str+"身份证号与出生日期不相符");
				return false;
			}
		}else{
			return true;
		}
	}
	function checkRelationToInsured(relationToInsured,str){
		if(relationToInsured=="" || relationToInsured.length==0 || relationToInsured == null){
			alert("请选择"+str+"与被保险人关系");
			return false;
		}
		else{
			return true;
		}
	}
	
	function checkBnfLot(BnfLot,str){
		var regBnfLot = /^\d{1,2}$/;
		if(!regBnfLot.test(BnfLot) && BnfLot != 100){
			alert("请输入正确的"+str+"的受益比例");
			return false;
		}
		else{
			return true;
		}
	}
	
	
	function downloadMedia(media_id,type){
  		$.ajax({
  			type : "post",
  			url :'<%=request.getContextPath()%>/msl/sales/RXAKMedia',
  			dataType : "json",
  			async : false,
  			data : {
  				"type" : type,
  				"media_id" : media_id
  			},
  			success : function(data) {
  				if(data.flag=="1"){//成功
  				  	if(type=="app_front"){
  				  	 	$("#img1").val("Y");	
  				  	}else if(type=="app_contrary"){
  				 	 	$("#img2").val("Y");	
  				  	}else if(type=="rec_front"){
  				 	 	$("#img3").val("Y");	
  				  	}else if(type=="rec_contrary"){
  				 	 	$("#img4").val("Y");	
  				  	}
  				alert(data.content);
  			}else{
  				alert(data.content);
  				}
  			}
  		});
	}
	
	function onchangeAppIdNo(){
		var idType = getObj("applicantInsured.identifytype");
		if(idType=="I"){
			var idNo= getObj("applicantInsured.identifynumber");
			if(!checkIdNo(idNo,idType,"投保人")){return false;}
			var sex = getSex(idNo);
			var br = getBirth(idNo);
			document.getElementById("applicantInsuredBirthday_min").value=br;
			var obj = document.getElementById("applicantInsuredSex_min");
  			document.getElementById("applicantInsuredSex_min").options.length = 0;  
  			if(sex == 'M'){
  				obj.add(new Option("男","M"));
  			}else if(sex == 'F'){
  				obj.add(new Option("女","F"));
  			}
		}
	}
	
	function onchangeBnf3IdNo(){
		var idType = getObj("lcbnf3.IDType");
		if(idType=="I"){
			var idNo= getObj("policy.bnfIDNo3");
			if(!checkIdNo(idNo,idType,"受益人三")){return false;}
			var sex = getSex(idNo);
			var br = getBirth(idNo);
			document.getElementById("policy.bnfBirthday3").value=br;
			var obj = document.getElementById("policy.bnfSex3");
  			document.getElementById("policy.bnfSex3").options.length = 0;  
  			if(sex == 'M'){
  				obj.add(new Option("男","M"));
  			}else if(sex == 'F'){
  				obj.add(new Option("女","F"));
  			}
		}
	}
	function onchangeBnf2IdNo(){
		var idType = getObj("lcbnf2.IDType");
		if(idType=="I"){
			var idNo= getObj("policy.bnfIDNo2");
			if(!checkIdNo(idNo,idType,"受益人二")){return false;}
			var sex = getSex(idNo);
			var br = getBirth(idNo);
			document.getElementById("policy.bnfBirthday2").value=br;
			var obj = document.getElementById("policy.bnfSex2");
  			document.getElementById("policy.bnfSex2").options.length = 0;  
  			if(sex == 'M'){
  				obj.add(new Option("男","M"));
  			}else if(sex == 'F'){
  				obj.add(new Option("女","F"));
  			}
		}
	}
	function onchangeBnfIdNo(){
		var idType = getObj("lcbnf.IDType");
		if(idType=="I"){
			var idNo= getObj("policy.bnfIDNo1");
			if(!checkIdNo(idNo,idType,"受益人一")){return false;}
			var sex = getSex(idNo);
			var br = getBirth(idNo);
			document.getElementById("policy.bnfBirthday1").value=br;
			var obj = document.getElementById("policy.bnfSex1");
  			document.getElementById("policy.bnfSex1").options.length = 0;  
  			if(sex == 'M'){
  				obj.add(new Option("男","M"));
  			}else if(sex == 'F'){
  				obj.add(new Option("女","F"));
  			}
		}
	}
	
	function clickAppIdTime(){
		//删除长期有效选项
		$(".applicantInsured_endTime").find(".checked_img").hide();
		$(".applicantInsured_endTime").prev().prop("checked",false);
	}
	
	function clickRecIdTime(){
		//删除长期有效选项
		$(".recognizee_endTime").find(".checked_img").hide();
		$(".recognizee_endTime").prev().prop("checked",false);
	}
	
	function clickBnf3IdTime(){
		//删除长期有效选项
		$(".IDExpDate3").find(".checked_img").hide();
		$(".IDExpDate3").prev().prop("checked",false);
	}
	function clickBnf2IdTime(){
		//删除长期有效选项
		$(".IDExpDate2").find(".checked_img").hide();
		$(".IDExpDate2").prev().prop("checked",false);
	}
	function clickBnf1IdTime(){
		//删除长期有效选项
		$(".IDExpDate").find(".checked_img").hide();
		$(".IDExpDate").prev().prop("checked",false);
	}
</script>
<script type="text/javascript">
	//mobiscroll初始化
	$(function () {
		var demo, theme, mode, display, lang;
		demo = 'date';
    	theme = 'wp',
   		mode = 'scroller',
		display = 'modal',
		dateFormat= 'yy-mm-dd',
		lang = 'zh';
		$('.demo-cont').hide();
		$("#demo_cont_" + demo).show();
		init();
		function init() {
			init_Time("applicantInsuredBirthday_min");
			init_EndTime("idPhotoData.applicantInsured_endTime");
			init_EndTime("idPhotoData.recognizee_endTime");
			init_EndTime("lcbnf.IDExpDate");
			init_EndTime("lcbnf2.IDExpDate");
			init_EndTime("lcbnf3.IDExpDate");
			init_Time("policy.bnfBirthday1");
			init_Time("policy.bnfBirthday2");
			init_Time("policy.bnfBirthday3");
			
		}  
		function init_Time(id){
			var ids = document.getElementById(id);
			$(ids).mobiscroll().date({
            	theme: theme,     
                mode: mode,       
                display: display, 
                lang: lang,     
				"height": 90,
           		dateFormat:dateFormat,
           		startYear:1949,
           		endYear:2050,
			});
		}
		function init_EndTime(id){
			var ids = document.getElementById(id);
			$(ids).mobiscroll().date({
            	theme: theme,     
                mode: mode,       
                display: display, 
                lang: lang,     
				"height": 90,
           		dateFormat:dateFormat,
           		minDate:new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()),
//            		startYear:new Date().getFullYear(),
           		endYear:2050,
			});
		}
	});
	
	
</script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
wx.config({
	//开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    debug: false,
  	//必填，公众号的唯一标识
    appId: '<%=mts.getAppid()%>', 
 	//必填，生成签名的时间戳
    timestamp: <%=mts.getTimestamp()%>,
 	//必填，生成签名的随机串
    nonceStr: '<%=mts.getNoncestr()%>',
 	//必填，签名，由jsapi_ticket获取
    signature: '<%=mts.getSignature(url)%>',
 	//必填，需要使用的JS接口列表，所有JS接口列表见附录2
    jsApiList: [
      'checkJsApi',
      'chooseImage',
      'previewImage',
      'uploadImage',
      'downloadImage',
      'closeWindow'
    ]
});

wx.ready(function () {
	  var imageFrontId = null;
	  var imageContraryId = null;
	  
	document.getElementById('idPhotoData.applicantInsured_frontal').onclick = function(){   //给元素增加点击事件
		wx.chooseImage({
			success: function (res) {
	    	imageFrontId = res.localIds[0];
	       	uploadMedia(imageFrontId,"app_front");
	       	document.getElementById("idPhotoData.applicantInsured_frontal").src=imageFrontId;
	      }
	    });
	  };
	  document.getElementById('idPhotoData.applicantInsured_reverse').onclick = function () {
		    wx.chooseImage({
		      success: function (res) {
		    	imageContraryId = res.localIds[0];
		    	uploadMedia(imageContraryId,"app_contrary");
		    	document.getElementById("idPhotoData.applicantInsured_reverse").src=imageContraryId;
		      }
		    });
		  };
		  
		  
		   document.getElementById('idPhotoData.recognizee_frontal').onclick = function () {
		    wx.chooseImage({
		      success: function (res) {
		    	imageContraryId = res.localIds[0];
		    	uploadMedia(imageContraryId,"rec_front");
		    	document.getElementById("idPhotoData.recognizee_frontal").src=imageContraryId;
		      }
		    });
		  };
		  
		   document.getElementById('idPhotoData.recognizee_reverse').onclick = function () {
		    wx.chooseImage({
		      success: function (res) {
		    	imageContraryId = res.localIds[0];
		    	uploadMedia(imageContraryId,"rec_contrary");
		    	document.getElementById("idPhotoData.recognizee_reverse").src=imageContraryId;
		      }
		    });
		  };
		  
		  
	//选择以后直接上传图片
	function uploadMedia(media_id,type){
		wx.uploadImage({
	        localId: media_id,
	        success: function (res) {
            var media_id = res.serverId;
            downloadMedia(media_id,type);
	        },
	   });
	}

});	
	
wx.error(function (res) {
	});
</script>
</html>
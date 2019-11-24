	<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>瑞享安康</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
 	<meta name="format-detection" content="telephone=no"/>
 	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/wjx/wjx.css" type="text/css"></link>
 	<script src="<%=request.getContextPath()%>/resources/js/rxak/rxakBankArea.js"></script>
	<!-- 暂时  -->
 	<script src="<%=request.getContextPath() %>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
  </head>
  <body onload="backshow();init();">
  	<!--标题区域-->
  	<div class="nav txt16">
  		<div class="menu">填写信息</div>
  		<div class="menu">确认信息</div>
  		<div class="menu" style="color:#fff;">如实告知</div>
  		<div class="menu">在线缴费</div>
  		<div class="clear"></div>
  	</div>
   	<section class="notice_wrap">
   		<p style="font-weight:bold;">被保险人生活习惯告知：</p>
			<p class="two_lev">
			1、被保险人目前是否吸烟？<br/>
			2、目前是否饮酒？<br/>
			3、是否使用成瘾药物如镇静安眠药、迷幻药，吸食或注射毒品？<br/>
			4、是否有危险嗜好或从事危险活动，如赛车、赛马、滑雪、攀岩、蹦极、潜水、跳水、拳击、武术、摔跤、探险或特技活动及其他高风险活动？<br/>
			</p>
			
			<p style="color:black;">您是否存在以上情况的一种或多种？</p>
	 		<form action="">
	 			<p class="txt16"><input type="radio" name="yes_life" value="Y"/><span class="radio_img" name="radio_img_life"></span>是</p>
	 			<p class="txt16"><input type="radio" name="yes_life" value="N"/><span class="radio_img" name="radio_img_life"></span>否</p>
	 		</form>
	 		<br/>
			<p style="font-weight:bold;">财务及保险经历告知：</p>
			<p class="two_lev">
			1、投保人是否在银行有贷款或向其他人有借贷？<br/>
			2、被保险人在其他保险公司正在申请和已生效的人寿保险
				<select id="otherLifeSum">
					<option value="0">请选择</option>
					<option value="0_100">0-100万</option>
					<option value="100_200">100-200万</option>
					<option value="200_300">200-300万</option>
					<option value="300">300万以上</option>
				</select>
					万元、重大疾病保险
				<select id="otherDiseaseSum">
					<option value="0">请选择</option>
					<option value="0_50">0-50万</option>
					<option value="50_100">50-100万</option>
					<option value="100">100万以上</option>
				</select>
					万元<br/>
			3、被保险人是否曾被保险公司拒保、延期承保、加费或任何形式的修改承保、或解除过保险合同？是否曾经申请过人身保险或重大疾病保险理赔？<br/>
 			</p>
 			
 			<p style="color:black;">您是否存在以上情况的一种或多种？</p>
	 		<form action="">
	 			<p class="txt16"><input type="radio" name="yes_finance" value="Y"/><span class="radio_img" name="radio_img_finance"></span>是</p>
	 			<p class="txt16"><input type="radio" name="yes_finance" value="N"/><span class="radio_img" name="radio_img_finance"></span>否</p>
	 		</form>
 			<br/>
 			<p style="font-weight:bold;">被保险人健康告知：</p>
 			<p class="two_lev">
 			1、近期诊治：在过去六个月内是否做过诊断性检查如X光、超声波、CT、心电图、活体检查、验血、验尿、宫颈涂片、乳腺检查、乳腺X光检查以及是否接受过医生的诊察、治疗、用药、手术？<br/>
 			2、是否曾患有或正在患有或被告知患有下列症状、疾病或因此而接受治疗？<br/>
 				A. 反复头晕、反复头痛、晕厥、胸闷、心慌、气急、不能平卧、口唇发紫、淤血、鼻出血、反复牙龈出血、呕血、咳血、浮肿、腹痛、便血、血尿、尿蛋白、肿块、黄疸、声嘶、关节红肿或酸痛；或曾在过去六个月内持续一周以上出现下列症状：体重下降、食欲不振、盗汗、腹泻、淋巴结肿大或皮肤溃烂；<br/>
 				B. 高血压、风湿性心脏病、冠心病、心绞痛、心肌梗塞、肺心病、心肌炎、先天性心脏病、心瓣膜疾病、传导阻滞、心律失常、动脉瘤、下肢静脉曲张及其他心脏或血管疾病；<br/>
 				C. 肺炎、支气管炎、肺气肿、哮喘、支气管扩张、肺结核、肺大泡、胸膜炎、气胸、尘肺或其他呼吸系统疾病；<br/>
 				D. 消化性溃疡或出血、食道静脉曲张、脾大、肠梗阻、结肠炎、肝炎、肝炎病毒携带、肝硬化、脂肪肝、血吸虫肝病、胆石症、胰腺炎或其他消化系统疾病；<br/>
 				E. 尿路结石或感染、肾病、肾衰竭、肾盂积水、继发性高血压、多囊肾、急慢性肾炎等疾病；<br/>
 				F. 癌症、白血病、肿瘤、肿物、囊肿、息肉等；<br/>
 				G. 何杰金氏病、再生障碍性贫血、白血病、血友病、紫癜、脾脏疾病或其他血液系统疾病，或被建议不宜献血；<br/>
 				H. 甲状腺疾病、糖尿病、甲状旁腺疾病、高脂血症、痛风或其他内分泌系统或代谢性疾病；<br/>
				I. 精神分裂症、抑郁症、神经官能性疾病、脑膜炎、脑炎、神经麻痹、瘫痪、中风、帕金森氏病、多发性硬化脑外伤后综合症、癫痫或其他神经系统疾病或精神疾病；<br/>
				J. 红斑狼疮、硬皮病、类风湿性关节病、脊髓疾病、多发性硬化、重症肌无力、椎间盘凸出、肌肉、骨骼、关节疾病或结缔组织疾病；<br/>
				K. 职业病、特殊物质过敏、中毒（铅、汞、农药、煤气等）后遗症；<br/>
				L. 眼、耳、鼻、咽、喉或口腔疾病；<br/>
				M. 梅毒、淋病、非淋菌性尿道炎等性传播疾病；您及您的配偶是否曾接受艾滋病毒（HIV）的检验（如有请提供检查结果）；<br/>
				N. 是否还有以上未述及的症状、疾病或接受治疗。<br/>
			3、身体残疾状况：有无智能障碍，是否失明、聋哑、跛行、小儿麻痹后遗症；有无五官、脊柱、胸廓、四肢、手指、足趾畸形或功能障碍；有无言语、咀嚼、视力、听力、嗅觉、运动及中枢神经系统机能障碍？<br/>
			4、您的家属是否曾患有高血压、肾病、心脏病、肝肾囊肿、肝硬化、糖尿病、白血病、结核病、多发性硬化症、癌症或曾被发现为乙肝病毒携带者或其他肝炎及病毒携带者？<br/>
			5、妇女适用<br/>
				A. 现在是否怀孕？ <br/>
				B. 是否曾有任何乳腺或妇科病症或分娩前后综合症？<br/>
				C. 是否曾被建议做重复的宫颈涂片、乳腺检查、乳腺X光检查或乳腺活体检查？<br/>
				D. 是否曾因月经不调而就诊？<br/>
				E. 是否曾因性传播疾病或其他女性生殖器官疾病而就诊？<br/>
				F. 本人或家庭成员中，是否曾有人患过乳癌？<br/>
			</p>
 			<p style="color:black;">您是否存在以上情况的一种或多种？</p>
	 		<form action="">
	 			<p class="txt16"><input type="radio" name="yes_healthy" value="Y"/><span class="radio_img" name="radio_img_healthy"></span>是</p>
	 			<p class="txt16"><input type="radio" name="yes_healthy" value="N"/><span class="radio_img" name="radio_img_healthy"></span>否</p>
	 		</form>
	 	</section>
		<section class="fillinfo_wrap">
			<div class="title" style="margin: 15px auto 20px auto;">缴费信息</div>
		 	<div class="pay_info">
  			<table class="txt16">
  			<tr>
				<td class="noberder left" width="35%">投保人<br/>&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
				<td width="65%" class="noberder">${applicantInsured.name}</td>
			</tr>
  			
			<tr class="renew">
			<td class="noberder" style="text-indent: 5%;"><span class="must">*</span>缴费银行：</td>
			<td class="noberder">
				<select id="policy.bank" name="policy.bank"  style="width: 95%;" class="bank">
					<option value="130102">工商银行</option>
					<option value="100103">农业银行</option>
 					<option value="130104">中国银行</option>
 					<option value="130105">建设银行</option>
					<option value="130308">招商银行</option>
<!-- 				<option value="100305">民生银行</option> -->
					<option value="100307">平安银行</option>
					<option value="100310">浦发银行</option>
					<!--<option value="100309">兴业银行</option>-->
					<option value="100303">光大银行</option>
					<!--<option value="100304">华夏银行</option>-->
					<option value="100306">广发银行</option>
<!-- 				<option value="100302">中信银行</option> -->
					<!-- <option value="090004">中信银行信用卡</option>  -->
					<option value="100403">邮政储蓄银行</option>
					<option value="100301">交通银行</option>
				</select>
			</td>
		</tr>
		<tr class="renew">
					 <td  class="noberder" style="text-indent: 5%;" ><span class="must">*</span>开户行所<br/>&nbsp;&nbsp;&nbsp;在&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地：</td>
			<td class="noberder">
				<select style="width: 35%;" name="bankProvinceAddress" id="bankProvinceAddress" onchange="select();" ></select><span>省</span>
				<select style="width: 40%;" name="bankCityAddress" id="bankCityAddress" onchange="select();"></select><span>市</span>
				<input type="hidden" id="policy.bankProvince" name="policy.bankProvince" value="${policy.bankProvince}"/> 
				<input type="hidden" id="policy.bankCity" name="policy.bankCity" value="${policy.bankCity}" />
			</td>
		</tr>
		<tr class="paymentno">
			<td class="noberder" width="35%" style="text-indent: 5%;height: 40px;"><span class="must">*</span>银行账号：</td>
			<td class="noberder" width="65%" style="height: 40px;">
				<input type="text" placeholder="填写投保人的银行账号" style="width: 95%;font-size: 0.875em;" class="bankAccountNumber"  id="policy.bankAccountNumber" name="policy.bankAccountNumber" value="${policy.bankAccountNumber}"/>
			</td>
		</tr>
		</table>
			    <div class="state_div txt14">
						<p>
						<img src="<%=request.getContextPath()%>/resources/image/wjx/star.png"/>
						投保人声明及授权：我同意授权瑞泰人寿根据保险合同约定的保费金额和交费方式委托银行从上述账户划款。如果我提供的账户是凭印鉴或密码支取，则我将同意并授权委托银行在划转保险费时免于核对该账户中的印鉴或密码。
						</p>
				</div>
  			</div>
	 	</section>
	  <!-- 按钮区域 -->
   	<section class="btn_wrap">
   		<div class="one_btn txt24" onclick="confirm()">提交</div>
   	</section>
   	<div class="footer">
		<div class="img_div"><img class="logoimg" src="<%=request.getContextPath() %>/global/global/images/logo.png"></div>
		<div class="addr_div txt10">
			<div class="foot_span">客户服务专线：4008109339</div>
			<div class="foot_span">网址：www.oldmutual-chnenergy.com</div>
		</div>
	<div class="clear"></div>
	</div>
  </body>
  <script>
  	$("[name='radio_img_life']").click(function(){
		if($(this).prev().prop("checked")==false){
			$("[name='radio_img_life']").removeClass("current_radio");
			$(this).addClass("current_radio");
			$(this).prev().prop("checked",true);
		}
	});
	
	$("[name='radio_img_finance']").click(function(){
		if($(this).prev().prop("checked")==false){
			$("[name='radio_img_finance']").removeClass("current_radio");
			$(this).addClass("current_radio");
			$(this).prev().prop("checked",true);
		}
	});
	
	
	$("[name='radio_img_healthy']").click(function(){
		if($(this).prev().prop("checked")==false){
			$("[name='radio_img_healthy']").removeClass("current_radio");
			$(this).addClass("current_radio");
			$(this).prev().prop("checked",true);
		}
	});
	
	function backshow(){
		if($("#no").prop("checked")==true){
		$("#no").next().addClass("current_radio");
		}
	}
	function confirm(){
		var yes_life_val=$('input:radio[name="yes_life"]:checked').val();
		if(yes_life_val==null || yes_life_val.length == 0){
        	alert("请选择被保险人生活习惯告知");
        	return false;
   		}
   		var otherLifeSum = $("#otherLifeSum").val();
   		var otherDiseaseSum = $("#otherDiseaseSum").val();
   		if(otherLifeSum == "0"){
   			alert("请选择被保险人在其他保险公司正在申请和已生效的人寿保险金额");
   			return false;
   		}
   		if(otherDiseaseSum == "0"){
   			alert("请选择被保险人在其他保险公司正在申请和已生效的重大疾病保险金额");
   			return false;
   		}
   		if(otherLifeSum == "300" || otherDiseaseSum == "100"){
   			alert("非常抱歉，您填写的投保告知存在异常，请通过其他方式投保，详询客服专线：4008109339，谢谢！ ");
   			return false;
   		}
   		
        var yes_finance_val=$('input:radio[name="yes_finance"]:checked').val();
		if(yes_finance_val==null || yes_finance_val.length == 0){
        	alert("请选择财务及保险经历告知");
        	return false;
   		}   
   		
        var yes_healthy_val=$('input:radio[name="yes_healthy"]:checked').val();
		if(yes_healthy_val==null || yes_healthy_val.length == 0){
        	alert("请选择被保险人健康告知");
        	return false;
   		}
   		   
		if(yes_life_val == 0 || yes_finance_val==0 || yes_healthy_val == 0){
			alert("请选择是或否");
		}else{
			if(yes_life_val == "Y" || yes_finance_val=="Y" || yes_healthy_val =="Y"){
				alert("非常抱歉，您填写的投保告知存在异常，请通过其他方式投保，详询客服专线：4008109339，谢谢！ ");
			}else{
				var bank =  document.getElementById("policy.bank").value;
				var bankProvince = document.getElementById("policy.bankProvince").value;
				var bankCity = document.getElementById("policy.bankCity").value;
				var bankAccountNumber = document.getElementById("policy.bankAccountNumber").value;
				if(bank==null||bank.length==0||bankProvince==null||bankProvince.length==0||bankCity==null||bankCity.length==0||bankAccountNumber==null||bankAccountNumber.length==0){
					alert("请填写缴费信息");
					return false;
				}
				else{
					$.ajax({
						type:"POST",
						url:"<%=request.getContextPath()%>/msl/sales/RXAKinsureSubmit",
						data:{
							"policy_bank":bank,
				   			"policy_bankProvince":bankProvince,
				   			"policy_bankCity":bankCity,
				   			"policy_bankAccountNumber":bankAccountNumber
						},
						dataType:"json",
				   		success:function(data){
							if(data.flag=="2"){
						 	window.location.href ='<%=request.getContextPath()%>/msl/sales/RXAKToBankSuccess';
					   		}else{
					   			alert(data.content);
					   		}
						}
					});
				}
			}
		}
	}
  </script>
</html>


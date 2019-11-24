/**
 * 校验
 */	
function check(){
	
	var agentCode = getObj("policy.agentcode");		//推荐码
	var reg =  /^[a-zA-Z0-9]+$/;
	var applicantInsuredname = getObj("applicantInsured.name");//投保人姓名
	var applicantInsured_industry = $("#applicantInsured_industry").val(); //投保人行业
	var applicantInsured_job = $("#applicantInsured_job").val(); //投保人职业
	var applicantInsuredidentifytype = getObj("applicantInsured.identifytype");//投保人证件类型
	var applicantInsuredidentifynumber = getObj("applicantInsured.identifynumber");//投保人证件号
	if(recognizeeAge<18){
		var applicantInsuredSex_min = getObj("applicantInsuredSex_min");	//投保人性别     (被保人小于18岁)
		var applicantInsuredBirthday_min = getObj("applicantInsuredBirthday_min");	//投保人出生日期     (被保人小于18岁) yy-mm-dd
	}
	var idPhotoDataApplicantInsured_endTime = getObj("idPhotoData.applicantInsured_endTime");//投保人证件有效期
	var applicantInsuredMobile = getObj("applicantInsured.mobile");//投保人手机号
	var applicantInsuredEmail = getObj("applicantInsured.email");//投保人电子邮箱
	var nationality = getObj("nationality"); //国籍
	var applicantInsured_province = getObj("applicantInsured_province");//投保人 省
	var applicantInsured_city = getObj("applicantInsured_city");//投保人 市
	var applicantInsured_area = getObj("applicantInsured_area");//投保人  区/县
	var applicantInsured_address = getObj("applicantInsured_address");//投保人 详细地址
	var applicantInsured_town = getObj("applicantInsured_town");//投保人  镇/街道
	var applicantInsured_village = getObj("applicantInsured_village");//投保人 村/社区
	//投保人通讯地址赋值
	var regExp = /<\/?[^>]+>/gi; 
	if(prohibit == "HZ" || prohibit == "GZ" || prohibit == "XA"){
		//校验
		if(!checkTownAndVillage(applicantInsured_town,applicantInsured_village,"投保人")){return false;}
		if(prohibit == "XA"){
			var appAddress = applicantInsured_province+applicantInsured_city+applicantInsured_area+"区/县"+applicantInsured_town+"镇/街道"+applicantInsured_village+"村/社区（门牌号）"+applicantInsured_address;
		}else{
			var appAddress = applicantInsured_province+applicantInsured_city+applicantInsured_area+"区/县"+applicantInsured_town+"镇/街道"+applicantInsured_village+"村/社区"+applicantInsured_address;
		}
	}else{
		var appAddress = applicantInsured_province+applicantInsured_city+applicantInsured_area+"区/县"+applicantInsured_address;
	}
	var address1 =  appAddress.replace(regExp,""); 	
	document.getElementById("applicantInsured.address").value = address1; 
	document.getElementById("recognizee.address").value = address1; 
	//推荐人校验
	if(isAgentCode=="1"){
		if(agentCode==null||agentCode.length==0){
			alert("请输入理财顾问编码");
			return false;
		}
	}
	//推荐人编码校验,推荐人编码为选填，填写了则判断brno是否为专属连接，不为专属链接推荐人编码为5到15位，为专属链接15位以下
	if(isAgentCode==1||agentCode!=""&&agentCode.length>0){
		if(brNo1=='A0000'||brNo1==null||brNo1.length==0){
			if(agentCode!=""||agentCode.length!=0){
				if(!reg.test(agentCode)){
					alert("推荐人编码为5~15位的字母和数字，请重新输入！");
					return false;
				}else if(agentCode.length>15||agentCode.length<5){
					alert("推荐人编码为5~15位的字母和数字，请重新输入！");
					return false;
				}
			}
		}else{
			if(!reg.test(agentCode)){
				alert("推荐人编码为15位以内的字母和数字，请重新输入！");
				return false;
			}else if(agentCode.length>15){
				alert("推荐人编码为15位以内的字母和数字，请重新输入！");
				return false;
			}
		} 
	}
	//投保人姓名校验	
	if(!checkName(applicantInsuredname,"投保人")){return false;}
	//投保人职业校验
	if(!checkJob(applicantInsured_industry,applicantInsured_job,"投保人")){return false;}
	//投保人身份证号校验
	if(!checkIdNo(applicantInsuredidentifynumber,applicantInsuredidentifytype,"投保人")){return false;}
	//投保人性别校验   出生日期
	if(recognizeeAge<18){
		if(applicantInsuredBirthday_min=="" || applicantInsuredBirthday_min==null || applicantInsuredBirthday_min.length==0){
			alert("请选择投保人出生日期");
			return false;
		}
		if(applicantInsuredidentifytype== "I"){
			var sex = getSex(applicantInsuredidentifynumber);
			if(sex!=applicantInsuredSex_min){
				alert("投保人身份证号与性别不相符");
				return false;
			}
			var br = getBirth(applicantInsuredidentifynumber);
			if(br!=applicantInsuredBirthday_min){
				alert("投保人身份证号与出生日期不相符");
				return false;
			}
		}
	}else{
		if(applicantInsuredidentifytype== "I"){
			var sex = getSex(applicantInsuredidentifynumber);
			var sex1 = recognizeeSex=="男"?"M":"F";
			if(sex!=sex1){
				alert("投保人身份证号与性别不相符");
				return false;
			}
			var br = getBirth(applicantInsuredidentifynumber);
			if(br!=recognizeeBirthday){
				alert("投保人身份证号与出生日期不相符");
				return false;
			}
		}
	}
	//投保人证件有效期校验
	if(!checkIdTime(idPhotoDataApplicantInsured_endTime,"投保人")){return false;}
	//投保人手机号校验
	if(!checkMobile(applicantInsuredMobile,"投保人")){return false;}
	//投保人电子邮箱校验
	if(!checkEmail(applicantInsuredEmail,"投保人")){return false;}
	if(nationality!="CHN"){
		alert("根据国家《非居民金融账户涉税信息尽职调查管理办法》涉税信息收集及尽职调查相关要求，本平台暂不支持具有境外国家/地区（包含港、澳、台）税收居民身份的客户投保，请致电客服电话400-810-9339或至瑞泰人寿营业网点咨询投保。感谢您的理解与配合。");
		return false;
	}
	//投保人通信地址校验
	if(!checkAddress(applicantInsured_province,applicantInsured_city,applicantInsured_area,applicantInsured_address,"投保人")){return false;}
	//被保险人校验 年龄大于18岁为本人不校验
	if(recognizeeAge<18){
		var recognizeeName = getObj("recognizee.name");//被保人姓名
		var recognizee_industry = $("#recognizee_industry").val(); //被保人行业
		var recognizee_job = $("#recognizee_job").val(); //被保人职业
		var recognizeeIdentifytype = getObj("recognizee.identifytype");//被保人证件类型
		var recognizeeIdentifynumber = getObj("recognizee.identifynumber");//被保人证件号
		var idPhotoDataRecognizee_endTime = getObj("idPhotoData.recognizee_endTime");//被保人证件有效期
		var recognizeeMobile = getObj("recognizee.mobile");//被保人手机号
		var recognizeeEmail = getObj("recognizee.email");//被保人电子邮箱
		var recognizee_province = getObj("recognizee_province");//被保人 省
		var recognizee_city = getObj("recognizee_city");//被保人 市
		var recognizee_area = getObj("recognizee_area");//被保人  区/县
		var recognizee_address = getObj("recognizee_address");//被保人 详细地址
		var recognizee_town = getObj("recognizee_town");//投保人  镇/街道
		var recognizee_village = getObj("recognizee_village");//投保人 村/社区
		var regExp = /<\/?[^>]+>/gi; 
		if(prohibit == "XA"){
			//校验
			if(!checkTownAndVillage(recognizee_town,recognizee_village,"被保险人")){return false;}
			var appAddress = recognizee_province+recognizee_city+recognizee_area+"区/县"+recognizee_town+"镇/街道"+recognizee_village+"村/社区（门牌号）"+recognizee_address;
		}else{
			var appAddress = recognizee_province+recognizee_city+recognizee_area+"区/县"+recognizee_address;
		}
		var address1 =  appAddress.replace(regExp,""); 	
		document.getElementById("recognizee.address").value = address1; 
		//被保人姓名校验
		if(!checkName(recognizeeName,"被保险人")){return false;}
		//投保人职业校验
		if(!checkJob(recognizee_industry,recognizee_job,"被保险人")){return false;}
		//被保险人证件号码校验
		if(!checkIdNo(recognizeeIdentifynumber,recognizeeIdentifytype,"被保险人")){return false;}
		//被保险人身份证号 与 性别 出生日期校验
		if(recognizeeIdentifytype== "I"){
			var sex = getSex(recognizeeIdentifynumber);
			var sex1 = recognizeeSex=="男"?"M":"F";
			if(sex!=sex1){
				alert("被保险人身份证号与性别不相符");
				return false;
			}
			var br = getBirth(recognizeeIdentifynumber);
			if(br!=recognizeeBirthday){
				alert("被保险人身份证号与出生日期不相符");
				return false;
			}
		}
		//被保险人证件有效期校验
		if(!checkIdTime(idPhotoDataRecognizee_endTime,"被保险人")){return false;}
		//被保险人手机号校验
		if(!checkMobile(recognizeeMobile,"被保险人")){return false;}
		//被保险人电子邮箱校验
		var l =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(recognizeeEmail.length==0||recognizeeEmail==""){
			//可以不填写
		}else if(!l.test(recognizeeEmail)){
			alert("被保险人电子邮箱有误,请核对后输入");
			return false;
		}
		//被保险人通信地址校验
		if(!checkAddress(recognizee_province,recognizee_city,recognizee_area,recognizee_address,"被保险人")){return false;}
	}else{
		document.getElementById("recognizee.address").value = address1; 
	}
	//受益人
	var policyIslegalflag = getObj("policy.islegalflag");//受益人 法定2  指定3
	var policyLCBnfCount = getObj("lCBnfCount");//受益人个数
	//指定受益人校验
	if(policyIslegalflag=="3"){
		if(policyLCBnfCount=="1"){//1个指定受益人
			if(!checkBnf1()){return false;}
		}else if(policyLCBnfCount=="2"){
			if(!checkBnf1()){return false;}
			if(!checkBnf2()){return false;}
		}else if(policyLCBnfCount=="3"){
			if(!checkBnf1()){return false;}
			if(!checkBnf2()){return false;}
			if(!checkBnf3()){return false;}
		}
	}
	//校验受益比例
	var $bnfLot1 = getObj("policy.bnfLot1")=="" ? 0 : parseInt(getObj("policy.bnfLot1"));
	var $bnfLot2 = getObj("policy.bnfLot2")=="" ? 0 : parseInt(getObj("policy.bnfLot2"));
	var $bnfLot3 = getObj("policy.bnfLot3")=="" ? 0 : parseInt(getObj("policy.bnfLot3"));
	if(policyIslegalflag == "3" && $bnfLot1+$bnfLot2+$bnfLot3 != 100){
		alert("各受益人的受益比例之和需要为100%");
		return false;
	}
	//证件照
	if(recognizeeAge<18){
		//校验被保人
		if($("#img3").val()=="N" || $("#img4").val()=="N"){
			alert("请上传被保险人证件照");
			return false;
		}
	}
	//投保人证件照校验
	if($("#img1").val()=="N" || $("#img2").val()=="N"){
		alert("请上传投保人证件照");
		return false;
	}
	
	//声明
	var flag = document.getElementById("checkboxsure").checked; 
	if(!flag){
		alert("本渠道暂不支持除“仅为中国大陆税收居民”以外的其他国家（地区）税收居民进行投保，请致电客服电话4008109339或至瑞泰人寿营业网点办理投保，感谢您的理解与配合。");
		return false;
	}else{
		return true;
	}
}

function checkBnf3(){
	var policyBnfName3 = getObj("policy.bnfName3");
	var lCBnf3IDExpDate = getObj("lcbnf3.IDExpDate");
	var lCBnf3IDType = getObj("lcbnf3.IDType");
	var policyBnfIDNo3 = getObj("policy.bnfIDNo3");
	var policyBnfSex3 = getObj("policy.bnfSex3");
	var policyBnfBirthday3 = getObj("policy.bnfBirthday3");
	var lCBnf3BnfMobile = getObj("lcbnf3.BnfMobile");
	var lCBnf3_province = getObj("lCBnf3_province");
	var	lCBnf3_city = getObj("lCBnf3_city");
	var	lCBnf3_conty = getObj("lCBnf3_conty");
	var	lCBnf3_address = getObj("lCBnf3_address");
	var	lCBnf3_industry = getObj("lCBnf3_industry");
	var	lCBnf3_job = getObj("lCBnf3_job");
	var	policyRelationToInsured3 = getObj("policy.relationToInsured3");
	var	policyBnfLot3 = getObj("policy.bnfLot3");
	var regExp = /<\/?[^>]+>/gi; 
	var	lCBnf3_town = getObj("lCBnf3_town");
	var	lCBnf3_village = getObj("lCBnf3_village");
	if(prohibit == "XA"){
		//校验
		if(!checkTownAndVillage(lCBnf3_town,lCBnf3_village,"指定受益人三")){return false;}
		var appAddress = lCBnf3_province+lCBnf3_city+lCBnf3_conty+"区/县"+lCBnf3_town+"镇/街道"+lCBnf3_village+"村/社区（门牌号）"+lCBnf3_address;
	}else{
		var appAddress = lCBnf3_province+lCBnf3_city+lCBnf3_conty+"区/县"+lCBnf3_address;
	}
	var address1 =  appAddress.replace(regExp,""); 	
	document.getElementById("lcbnf3.Address").value = address1; 
	if(!checkName(policyBnfName3,"指定受益人三")){
		return false;
	}else if(!checkIdTime(lCBnf3IDExpDate,"指定受益人三")){
		return false;
	}else if(!checkIdNo(policyBnfIDNo3,lCBnf3IDType,"指定受益人三")){
		return false;
	}else if(!checkBr(lCBnf3IDType,policyBnfIDNo3,policyBnfBirthday3,policyBnfSex3,"指定受益人三")){
		return false;
	}else if(!checkMobile(lCBnf3BnfMobile,"指定受益人三")){
		return false;
	}else if(!checkAddress(lCBnf3_province,lCBnf3_city,lCBnf3_conty,lCBnf3_address,"指定受益人三")){
		return false;
	}else if(!checkJob(lCBnf3_industry,lCBnf3_job,"指定受益人三")){
		return false;
	}else if(!checkRelationToInsured(policyRelationToInsured3,"指定受益人三")){
		return false;
	}else if(!checkBnfLot(policyBnfLot3,"指定受益人三")){
		return false;
	}else{
		return true;
	}
}

function checkBnf2(){
	var policyBnfName2 = getObj("policy.bnfName2");
	var lCBnf2IDExpDate = getObj("lcbnf2.IDExpDate");
	var lCBnf2IDType = getObj("lcbnf2.IDType");
	var policyBnfIDNo2 = getObj("policy.bnfIDNo2");
	var policyBnfSex2 = getObj("policy.bnfSex2");
	var policyBnfBirthday2 = getObj("policy.bnfBirthday2");
	var lCBnf2BnfMobile = getObj("lcbnf2.BnfMobile");
	var lCBnf2_province = getObj("lCBnf2_province");
	var	lCBnf2_city = getObj("lCBnf2_city");
	var	lCBnf2_conty = getObj("lCBnf2_conty");
	var	lCBnf2_address = getObj("lCBnf2_address");
	var	lCBnf2_industry = getObj("lCBnf2_industry");
	var	lCBnf2_job = getObj("lCBnf2_job");
	var	policyRelationToInsured2 = getObj("policy.relationToInsured2");
	var	policyBnfLot2 = getObj("policy.bnfLot2");
	var regExp = /<\/?[^>]+>/gi; 
	var	lCBnf2_town = getObj("lCBnf2_town");
	var	lCBnf2_village = getObj("lCBnf2_village");
	if(prohibit == "XA"){
		//校验
		if(!checkTownAndVillage(lCBnf2_town,lCBnf2_village,"指定受益人二")){return false;}
		var appAddress = lCBnf2_province+lCBnf2_city+lCBnf2_conty+"区/县"+lCBnf2_town+"镇/街道"+lCBnf2_village+"村/社区（门牌号）"+lCBnf2_address;
	}else{
		var appAddress = lCBnf2_province+lCBnf2_city+lCBnf2_conty+"区/县"+lCBnf2_address;
	}
	var address1 =  appAddress.replace(regExp,""); 	
	document.getElementById("lcbnf2.Address").value = address1; 
	if(!checkName(policyBnfName2,"指定受益人二")){
		return false;
	}else if(!checkIdTime(lCBnf2IDExpDate,"指定受益人二")){
		return false;
	}else if(!checkIdNo(policyBnfIDNo2,lCBnf2IDType,"指定受益人二")){
		return false;
	}else if(!checkBr(lCBnf2IDType,policyBnfIDNo2,policyBnfBirthday2,policyBnfSex2,"指定受益人二")){
		return false;
	}else if(!checkMobile(lCBnf2BnfMobile,"指定受益人二")){
		return false;
	}else if(!checkAddress(lCBnf2_province,lCBnf2_city,lCBnf2_conty,lCBnf2_address,"指定受益人二")){
		return false;
	}else if(!checkJob(lCBnf2_industry,lCBnf2_job,"指定受益人二")){
		return false;
	}else if(!checkRelationToInsured(policyRelationToInsured2,"指定受益人二")){
		return false;
	}else if(!checkBnfLot(policyBnfLot2,"指定受益人二")){
		return false;
	}else{
		return true;
	}
}

function checkBnf1(){
	var policyBnfName1 = getObj("policy.bnfName1");//受益人1姓名
	var lCBnfIDExpDate = getObj("lcbnf.IDExpDate");//受益人1证件有效期
	var lCBnfIDType = getObj("lcbnf.IDType");//受益人1证件类型
	var policyBnfIDNo1 = getObj("policy.bnfIDNo1");//受益人1证件号
	var policyBnfSex1 = getObj("policy.bnfSex1");//受益人1性别
	var policyBnfBirthday1 = getObj("policy.bnfBirthday1");//受益人1出生日期
	var lCBnfBnfMobile = getObj("lcbnf.BnfMobile");//受益人1手机号
	var lCBnf_province = getObj("lCBnf_province");
	var	lCBnf_city = getObj("lCBnf_city");
	var	lCBnf_conty = getObj("lCBnf_conty");
	var	lCBnf_address = getObj("lCBnf_address");
	var	lCBnf_industry = getObj("lCBnf_industry");
	var	lCBnf_job = getObj("lCBnf_job");
	var	policyRelationToInsured1 = getObj("policy.relationToInsured1");
	var	policyBnfLot1 = getObj("policy.bnfLot1");
	var regExp = /<\/?[^>]+>/gi; 
	var	lCBnf_town = getObj("lCBnf_town");
	var	lCBnf_village = getObj("lCBnf_village");
	if(prohibit == "XA"){
		//校验
		if(!checkTownAndVillage(lCBnf_town,lCBnf_village,"指定受益人一")){return false;}
		var appAddress = lCBnf_province+lCBnf_city+lCBnf_conty+"区/县"+lCBnf_town+"镇/街道"+lCBnf_village+"村/社区（门牌号）"+lCBnf_address;
	}else{
		var appAddress = lCBnf_province+lCBnf_city+lCBnf_conty+"区/县"+lCBnf_address;
	}
	var address1 =  appAddress.replace(regExp,""); 	
	document.getElementById("lcbnf.Address").value = address1; 
	if(!checkName(policyBnfName1,"指定受益人一")){
		return false;
	}else if(!checkIdTime(lCBnfIDExpDate,"指定受益人一")){
		return false;
	}else if(!checkIdNo(policyBnfIDNo1,lCBnfIDType,"指定受益人一")){
		return false;
	}else if(!checkBr(lCBnfIDType,policyBnfIDNo1,policyBnfBirthday1,policyBnfSex1,"指定受益人一")){
		return false;
	}else if(!checkMobile(lCBnfBnfMobile,"指定受益人一")){
		return false;
	}else if(!checkAddress(lCBnf_province,lCBnf_city,lCBnf_conty,lCBnf_address,"指定受益人一")){
		return false;
	}else if(!checkJob(lCBnf_industry,lCBnf_job,"指定受益人一")){
		return false;
	}else if(!checkRelationToInsured(policyRelationToInsured1,"指定受益人一")){
		return false;
	}else if(!checkBnfLot(policyBnfLot1,"指定受益人一")){
		return false;
	}else{
		return true;
	}
}

/**指定受益人显示*/ 	
function changeBnf(){
	var $bnfFlag = getObj("policy.islegalflag");
	if($bnfFlag == "3"){
		$("#beneficiaryId").show();
	}else{
		$("#beneficiaryId").hide();
	}
}

/**根据指定受益人数显示输入框*/
function changeBnfNum(){
	var $bnfNum = getObj("lCBnfCount");
	if($bnfNum == "2"){
		$("#tb2").show();
		$("#tb3").hide();
	}else if($bnfNum == "3"){
		$("#tb2").show();
		$("#tb3").show();
	}else{
		$("#tb2").hide();
		$("#tb3").hide();
	}
}	
/**失去焦点做数据存储*/
function saveData(){
	var applicantInsuredname = getObj("applicantInsured.name");//投保人姓名
	var applicantInsured_industry = $("#applicantInsured_industry").val(); //投保人行业
	var applicantInsured_job = $("#applicantInsured_job").val(); //投保人职业
	var applicantInsuredidentifytype = getObj("applicantInsured.identifytype");//投保人证件类型
	var applicantInsuredidentifynumber = getObj("applicantInsured.identifynumber");//投保人证件号
	if(recognizeeAge<18){
		var applicantInsuredSex_min = getObj("applicantInsuredSex_min");	//投保人性别     (被保人小于18岁)
		var applicantInsuredBirthday_min = getObj("applicantInsuredBirthday_min");	//投保人出生日期     (被保人小于18岁) yy-mm-dd
		sessionStorage.setItem("applicantInsuredSex_min", applicantInsuredSex_min); 
		sessionStorage.setItem("applicantInsuredBirthday_min", applicantInsuredBirthday_min); 
	}
	var idPhotoDataApplicantInsured_endTime = getObj("idPhotoData.applicantInsured_endTime");//投保人证件有效期
	var applicantInsuredMobile = getObj("applicantInsured.mobile");//投保人手机号
	var applicantInsuredEmail = getObj("applicantInsured.email");//投保人电子邮箱
	var applicantInsured_area = getObj("applicantInsured_area");//投保人  区/县
	var applicantInsured_address = getObj("applicantInsured_address");//投保人 详细地址
	sessionStorage.setItem("applicantInsuredname", applicantInsuredname); 
	sessionStorage.setItem("applicantInsured_industry", applicantInsured_industry); 
	sessionStorage.setItem("applicantInsured_job", applicantInsured_job); 
	sessionStorage.setItem("applicantInsuredidentifytype", applicantInsuredidentifytype); 
	sessionStorage.setItem("applicantInsuredidentifynumber", applicantInsuredidentifynumber); 
	sessionStorage.setItem("idPhotoDataApplicantInsured_endTime", idPhotoDataApplicantInsured_endTime); 
	sessionStorage.setItem("applicantInsuredMobile", applicantInsuredMobile); 
	sessionStorage.setItem("applicantInsuredEmail", applicantInsuredEmail); 
	sessionStorage.setItem("applicantInsured_area", applicantInsured_area); 
	sessionStorage.setItem("applicantInsured_address", applicantInsured_address); 
	
}
function showAll(){
	$("#reminderAB").hide();
	$("#remindertotalOne").show();
	$("#remindertotalTwo").show();
}

function init_symbol(id){
	var ids = document.getElementById(id);
	return ids;
}
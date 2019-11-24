  	$(".radio_img").click(function(){
  		if($("#isAuthorization").prop("checked")){
  			$("#isAuthorization").prop("checked",false);
		    $(this).css("background-position-y","-29px");
	     }else{
	    	 $("#isAuthorization").prop("checked",true);
		     $(this).css("background-position-y","0");
	     }
	});
 
  
  	function account(){
       var a=document.getElementById("count").value;
       var b=100000
       document.getElementById("coverage").value=Number(a*b).toFixed(2);
 	} 
  	function choose(){
  		var card=document.getElementById("applicantInsured.identifytype").value;
  		if(card=="I"){
  			document.getElementById("message").style.display="none";
  		}else
  		{document.getElementById("message").style.display="";
  		 /*document.getElementById("birthday").value=document.getElementById("applicantInsured.birthday").value;*/
  		 }
  	}
  $("#check").click(function(){
		if(document.getElementById("renewalflag").checked==true){
			 document.getElementById("renewalflag").checked=false;
		}else{
			 document.getElementById("renewalflag").checked=true;	
		}
	}); 
	$(".continue").click(function(){
		if(document.getElementById("ischarity").style.display==""){
			document.getElementById("ischarity").style.display="none";
		}
		else
		 {
		document.getElementById("ischarity").style.display="";
		}
	})

  $("#check1").click(function(){
		if(document.getElementById("stipend").checked==true){
			 document.getElementById("stipend").checked=false;
			 $("#help_text").css("display","none");
			 $("#help_text").attr("value","");
			  document.getElementById("policy.stipend").value=""; 
		}else{
			 document.getElementById("stipend").checked=true;
			 $("#help_text").css("display","");
			
		}
	});
	
  $("#check2").click(function(){
		if(document.getElementById("bookmoney").checked==true){
			 document.getElementById("bookmoney").checked=false;
			 $("#book_text").css("display","none");
			 $("#book_text").attr("value",""); 
			 document.getElementById("policy.bookmoney").value=""; 
			
		}else{
			 document.getElementById("bookmoney").checked=true;
			 $("#book_text").css("display","");	
			
			 
		}
	});
  </script>
  <script type="text/javascript">
  	$("#plus").click(function(){
  		 if($("#count").val()*1<3){
  			$("#count").val($("#count").val()*1+1);
  			account();
  			trial();
  		}
  	});
  	$("#min").click(function(){
  		if($("#count").val()*1>1){
  			$("#count").val($("#count").val()*1-1);
  			account();
  			trial();
  		}
  	});
  
  	$(".stipend").click(function(){
 		var stipendFlag = document.getElementById("stipend").checked;//捐赠助学金标志
		if(!stipendFlag){
			 alert("请先勾选捐赠助学金");
			 return false;
		}
	}); 
 	
 	$(".bookmoney").click(function(){
		var bookmoneyFlag = document.getElementById("bookmoney").checked;//捐赠爱心书库标志
		if(!bookmoneyFlag){
			 alert("请先勾捐赠爱心书库");
			 return false;
		}
	}); 
  	
  	function save(){
  			modal_loading();
			//校验
			if(!check()){
				modal_loading('hide');
				return;
			}
			
			var flag = document.getElementById("renewalflag").checked;//续保标志
			if(flag){
				document.getElementById("policy.renewalflag").value = "1";
			}else{
				document.getElementById("policy.renewalflag").value = "2";
			}
			var stipendFlag = document.getElementById("stipend").checked;//捐赠助学金标志
			var bookmoneyFlag = document.getElementById("bookmoney").checked;//捐赠爱心书库标志
			var isAuthorizationFlag = document.getElementById("isAuthorization").checked;//授权标志
			var stipend = document.getElementById("policy.stipend").value;//捐赠助学金
			var bookmoney = document.getElementById("policy.bookmoney").value;//捐赠爱心书库
			var   su   =   /^[0-9]*[1-9][0-9]*$/;
			var  helpStudyFlag = $("#helpStudyFlag").val();
			if(bookmoneyFlag){
				if(bookmoney==""||bookmoney.length==0){
	 				alert("请填写捐赠爱心书库金额");
	 				return false;
	 			}
			}
			if(bookmoney.length>0 && !bookmoneyFlag){
				alert("请勾选捐赠爱心书库");
				return false;
			}
			if(bookmoney.length>0 && !su.test(bookmoney) ){
				alert("只能输入整数");
				return false;
			}
			if(stipendFlag){
				if(stipend==""||stipend.length==0){
	 				alert("请填写捐赠助学金金额");
	 				modal_loading('hide');
	 				return false;
	 			}
			}
			if(stipend.length>0 && !stipendFlag){
				alert("请勾选捐赠助学金");
				modal_loading('hide');
				return false;
			}
			if(stipend.length>0 && !su.test(stipend) ){
				alert("只能输入整数");
				modal_loading('hide');
				return false;
			}
			if(stipendFlag || bookmoneyFlag){
				if(!isAuthorizationFlag){
					alert("请勾选您已授权我司代为捐赠助学金或爱心书库金");
					modal_loading('hide');
					return false;	
					
				}
			}
			if(helpStudyFlag=='1'){
				if(!stipendFlag && !bookmoneyFlag){
						alert("助学金或爱心书库金至少选择一份捐赠");
						modal_loading('hide');
						return false;	
				}
			}
			trial1();
		
		}
  	 function trial1(){
		  count = Number($("#count").val());//取得份数
		  sumpremium = 100000.00*count;
		  if(count>=1&&count<=3){
			  $.ajax({
				   type:"POST",
				   url:contentRootPath+"/msl/sales/charityPolicyCalculate",
				   data:{
					   "policy.sumamount":sumpremium
				   },
				   dataType:"json",
				   success:function(data){
						var inputAmnt=Number(data.sumbasepremium).toFixed(2);
					    amntFormat=outputmoney(inputAmnt);
					    $("#sumbasepremium").val(amntFormat);
						document.getElementById("policy.sumamount").value = sumpremium;//保额						
						var birthday =  $("#birthday").val().replace("年","-").replace("月","-").replace("日","");
						document.getElementById("applicantInsured.birthday").value = birthday;
						$("#creator").submit();
					}
				}); 
		  }else{
			  count = Number($("#count").val());//取得份数
				sumpremium = 100000.00*count;
				document.getElementById("policy.sumamount").value = sumpremium;//保额
				var  sumpre = $("#sumbasepremium").val();
				var inputAmnt=Number(sumpre).toFixed(2);
				amntFormat=outputmoney(inputAmnt);
				//document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
				var birthday =  $("#birthday").val().replace("年","-").replace("月","-").replace("日","");
				document.getElementById("applicantInsured.birthday").value = birthday;
				$("#creator").submit();
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
		
		
		function changeBirth(){
			var value = document.getElementById("applicantInsured.identifynumber").value;
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
	            	document.getElementById("birthday").value = year+"年"+month+"月"+day+"日";
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
				if(length <10){
					alert('军官证或士兵证号码应在10到18个字符之间');
					return false;
				}
				if(length >18){
					alert('军官证或士兵证号码应在10到18个字符之间');
					return false;
				}
			}
			return true;
		}
		
		
		//校验
		function check(){
			var applicantInsuredname = document.getElementById("applicantInsured.name").value;//投保人姓名
			var applicantInsuredidentifytype = document.getElementById("applicantInsured.identifytype").value;//投保人证件类型
			var applicantInsuredidentifynumber =document.getElementById("applicantInsured.identifynumber").value;//投保人证件号
			var adress = document.getElementById("applicantInsured.address").value;
			var re =  /^[A-Z u4E00-u9FA5]+$/;//校验姓名的正则
			var ree = /^\d{15}(\d{2}(x|X|\d))?$/;//校验身份证号的正则
			var age = parseInt(new Date().getFullYear()) - parseInt(applicantInsuredidentifynumber.substring(6,10));//投保人年龄
			if(applicantInsuredname==""||applicantInsuredname.length==0){
				alert("请输入投保人姓名");
				return false;
			}
		 	var yw = /^[a-zA-Z ]{3,8}$/;
			var zw = /^[\u4e00-\u9fa5]{2,4}$/;
			if(yw.test(applicantInsuredname)|| zw.test(applicantInsuredname)){
			}else{
				alert("您输入的投保人姓名格式不正确！");
				return false;
			}
			if(applicantInsuredidentifytype == 'I'){
				if(applicantInsuredidentifynumber.length!=15&&applicantInsuredidentifynumber.length!=18){
					alert("您输入的证件号码有误");
	 				return false;
				}else if(!ree.test(applicantInsuredidentifynumber)){
					alert("您输入的证件号码有误");
	 				return false;
				}
				var start = getBirth(applicantInsuredidentifynumber);
				var br =  $("#birthday").val().replace("年","-").replace("月","-").replace("日","");//取得生日
				if(start!=br){
					alert("您输入的证件号码有误");
	 				return false;
				}else if(getSex(applicantInsuredidentifynumber)!=document.getElementById("applicantInsured.sex").value){
					alert("您输入的证件号码有误");
	 				return false;
				}else if(age<18){
					alert("投保人需大于18周岁");
	 				return false;
				}
			}else{
				if(applicantInsuredidentifynumber==""||applicantInsuredidentifynumber.length==0){
					alert("请输入投保人证件号");
	 				return false;
				}else if(!check1(applicantInsuredidentifynumber,applicantInsuredidentifytype)){
	 				return false;
				}
			}
			//校验手机
			var phone = document.getElementById("applicantInsured.mobile").value;
			var re1 = /^0?1[3|7|5|8][0-9]\d{8}$/;
		  	if(!re1.test(phone)){
		  		alert("请输入正确的手机号码");
			return false;
		 	}
			
		  	//校验投保人生日
		  	/* var birthday = $("#birthday").val().replace("年","-").replace("月","-").replace("日","");//取得生日
		  	var date = new Date(Date.parse(birthday));
		  	var age = (new Date().getTime() - date.getTime())/(24 * 60 * 60 * 1000); */
		 	
		  	var birthday = $("#year").val();
			var age =  parseInt(new Date().getFullYear()) - parseInt(birthday);
			if(age<18){
				alert("投保人年龄须在18以上");
				return false;
			}
			
			//校验邮箱
 		  	var email=document.getElementById("applicantInsured.email").value;
 			var re2 =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
 			if(email.length==0||email==""){
 				alert("请输入您的电子邮箱");
 				return false;
 			}else if(!re2.test(email)){
 				alert("电子邮箱有误,请核对后输入");
 				return false;
 			}
			//校验投保人地址
			if(adress==""||adress.length==0){
				alert("请输入地址");
 			return false;
			}else if(adress.length<8){
				alert("请输入有效的地址");
				return false;
			}
			
			return true;
		}
		 //保费试算
		  function trial(){
			  count = Number($("#count").val());//取得份数
			  sumpremium = 100000.00*count;
			  if(count!=null&&count!=""){
				  $.ajax({
					   type:"POST",
					   url:contentRootPath+"/msl/sales/charityPolicyCalculate",
					   data:{
						   "policy.sumamount":sumpremium
					   },
					   dataType:"json",
					   success:function(data){
							var inputAmnt=Number(data.sumbasepremium).toFixed(2);
						    amntFormat=outputmoney(inputAmnt);
						    $("#sumbasepremium").val(amntFormat);
						    document.getElementById("policy.sumbasepremium").value = amntFormat;//保费
						    modal_loading('hide');
						  
							var birthday2 =  data.prodoctcode;
							if(birthday2!=null&&birthday2.length>0){
								document.getElementById("applicantInsured.birthday").value=birthday2;
								document.getElementById("birthday").value=birthday2;
							} 
							//回显份数
					  		var unicount =  data.unitcount
					   		if(unicount != '' &&  unicount != null){
					   			$("#count").val(data.unitcount);
					   			trial();
					   		}
						}
					}); 
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
		function show(){
			
			var  donationFlag = $("#donationFlag").val();
			var  helpStudyFlag = $("#helpStudyFlag").val();
			var  sumpremium = $("#sumpremium").val();
			var inputAmnt=Number(sumpremium).toFixed(2);
		    amntFormat=outputmoney(inputAmnt);
			if(donationFlag=='1'){
				$('#isCharity').show();
				$('#isTrial').show();
				$('#count').val('3');
				trial();
			} else if(donationFlag=="0"){
				document.getElementById("policy.sumbasepremium").value =0;//保费
			}
			
			if(helpStudyFlag=='1'){
				$('#isHelp').show();
			}
		}
		function yuedu(){
		 if(document.getElementById("renewalflag").checked==true){
				document.getElementById("check").className='cbox checked';
				$("#ischarity").css("display","");
			 }
			 if(document.getElementById("stipend").checked==true){
				document.getElementById("check1").className='cbox checked';
				$("#help_text").css("display","");
			 }
			 if(document.getElementById("bookmoney").checked==true){
				document.getElementById("check2").className='cbox checked';
				 $("#book_text").css("display","");	
				 
			 }
			 if(document.getElementById("isAuthorization").checked==true){
				 $(".radio_img").css("background-position-y","0");
				 $("this").prop("checked",true);
			 }
			choose();
		}

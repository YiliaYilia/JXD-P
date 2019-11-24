var UserInfo = function(){};
UserInfo.prototype.ctx = null;

/**
 * 隐藏或显示密码输入框
 */
UserInfo.prototype.opPwdInput = function(operate){
	if(operate == 'hide'){
		$('#pwdinput').hide();
		$('#password').attr("name","");
		$('#againpwd').attr("name","");
		$('#againpwdinput').hide();
		$('#canclerepwd').hide();
		$('#repwdbtn').show();
	} else {
		$('#pwdinput').show();
		$('#password').attr("name","geUser.password");
		$('#againpwd').attr("name","againpwd");
		$('#againpwdinput').show();
		$('#canclerepwd').show();
		$('#repwdbtn').hide();
	}
};

/**
 * 用户操作页面表单验证
 */
UserInfo.prototype.formValidate = function(){
	$('#userManageForm').validator({
		theme: 'blue',
		timely:1,
		rules:{
			username : [/^[^<>]+$/, '不能包含<>字符'],
			againpwd : function(element, param, field) {
				if(element.value != $("#password").val()){
					return '两次输入的密码不一致';
				} else {
					return true;
				}
			},
			phone: function(element, param, field) {
				if(/^1[3458]\d{9}$/.test(element.value)){
					return true;
				} else if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(element.value)){
					return true;
				} else {
					return '不是有效的电话号码';
				}
		    }
		},
		fields:{
			"geUser.username":{
				rule:"required;length[2~15];username;remote[../system/existUserName, operate];",
				tip: "不能包含<>字符"
			},
			"geUser.password":{
				rule:"required;password;",
				tip:"由6到16位字母或数字组成"
			},
			"againpwd":{
				rule:"required;againpwd;",
				tip:"请再次确认密码"
			},
			"geUser.email":{
				rule:"email;",
				tip:"电子邮箱"
			},
			"geUser.phone":{
				rule:"phone;",
				tip:"手机或固定电话（区号-电话号）"
			}
			
		},
		valid: function(form){ //验证成功
			userInfo.alterUserIfo();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
};

UserInfo.prototype.alterUserIfo = function(){
	var username = $("#username").val();
	var password = $("#password").val();
	var email = $("#email").val();
	var sex = $("input[name='geUser.sex']:checked").val();
	var phone = $("#phone").val();
	var userid = $("#userid").val();
	
	var data = "geUser.username="+username+
	   "&geUser.email="+email+
	   "&geUser.sex="+sex+
	   "&geUser.phone="+phone+
	   "&geUser.operatorname="+username+
	   "&geUser.userid="+userid;
	if($("#pwdinput:hidden").html() == undefined){
		data = data + "&geUser.password="+password;
	}
	$.ajax({
		type:"POST",
		url:this.ctx+"/system/updateUserInfo",
		data:data,
		success:function(data){
			$('#alterUserInfo_windows').window('close');
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
};
/** 保单配置JS方法 */

var BdpzPage = function(){};
BdpzPage.prototype.ctx = null;
//需要进行表单验证的是元素数组
BdpzPage.prototype.formValidatorArray = new Array();

/**
 * 初始化页面
 */
BdpzPage.prototype.initPage = function(){
	//初始化 受益人，被保人  各种关系显示,被保人职业显示
	this.initPageShowContent();
	//表单验证
	this.initFormValidator();
};
/**
 * 初始化每个表单的验证
 */
BdpzPage.prototype.initFormValidator = function(){
	var thisObj = this;
	//公共配置
	var globalConfig = {
			ignore: ':hidden',
			theme: 'yellow_right',//主题
			timely:true,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
			valid: function(form){ //验证成功
				var type = form.id.replace("form","");
				if(type=="insured"){
					
					/**
					var occupation_treeDom = document.getElementById("occupationType");
					var res = $(form).data("validator").test(occupation_treeDom,"occRequiredIfChecked");
					$('input[name="occupationType"]').trigger("validate");
					*/
					var insoccupation = document.getElementById("geProductInsuredconfig.insoccupation");
					if(insoccupation!=null&&insoccupation.checked){//如果职业被选中
						var nodes = $('#OccupationTree').tree('getChecked');//选中的数据
						if(nodes==null||nodes.length<1){
							$(form).validator('showMsg', '#occupationType', {
								type: "error",
								msg: "职业类别不能为空"
							});
							return false;
						}else{
							$(form).validator('hideMsg', '#occupationType');
						}
					}
						
					thisObj.doSubmitForm(form);//提交表单
				}else{
					thisObj.doSubmitForm(form);//提交表单
				}
				
				return false;
			},
			invalid: function(form){//验证失败
				return false;
			}
			
	};
	//遍历查找每个form,查询是否需要验证
	$("form").each(function(index,dom){
		var type = dom.id.replace("form","");
		var formConfig = null;
		if(type==="applicant"){//投保人
			thisObj.formValidatorArray.push(type);//该表单需要验证
			formConfig = {
					rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
					},
					fields:{//那些字段要加入到规则中
						"geProductApplicantconfig.appagestart":{
							rule:"required;integer[+0]"
						},
						"geProductApplicantconfig.appageend":{
							rule:"required;integer[+0]"
						},
						"geProductApplicantconfig.appagestartattr":{
							rule:"required"
						},
						"geProductApplicantconfig.appageendattr":{
							rule:"required"
						}
					}
			};
		}else if(type==="insured"){
			thisObj.formValidatorArray.push(type);//该表单需要验证
			formConfig = {
					rules:{ 
						occRequiredIfChecked:function(el, param, field){
							var insoccupation = document.getElementById("geProductInsuredconfig.insoccupation");
							if(insoccupation!=null&&insoccupation.checked){//如果职业被选中
								var nodes = $('#OccupationTree').tree('getChecked');//选中的数据
								if(nodes==null||nodes.length<1){
									return "职业类别不能为空,请选择";
								}
							}
						},
						mobile1: function(element, param, field) {
							 return  '请检查手机号格式';
						}
					},
					fields:{//那些字段要加入到规则中
						"geProductInsuredconfig.inagestart":{
							rule:"required;integer[+0]"
						},
						"geProductInsuredconfig.inageend":{
							rule:"required;integer[+0]"
						},
						"geProductInsuredconfig.inssexconfig":{
							rule:"checked"
						},
						"geProductInsuredconfig.insidtypeconfig":{
							rule:"checked"
						},
						"geProductInsuredconfig.insrelationtoappconfig":{
							rule:"checked"
						},
						"geProductInsuredconfig.finsrelationtoappconfig":{
							rule:"checked"
						},
						"geProductInsuredconfig.inagestartattr":{
							rule:"required"
						},
						"geProductInsuredconfig.inageendattr":{
							rule:"required"
						},
						"occupationType":{
							rule:'occRequiredIfChecked'
						}
					}
			};
		}else if(type==="beneficiary"){
			thisObj.formValidatorArray.push(type);//该表单需要验证
			formConfig = {
					rules:{},
					fields:{//那些字段要加入到规则中
						"geProductBeneficiaryconfig.bensexconfig":{
							rule:"checked"
						},
						"geProductBeneficiaryconfig.benidtypeconfig":{
							rule:"checked"
						},
						"geProductInsuredconfig.insrelationtoappconfig":{
							rule:"checked"
						},
						"geProductBeneficiaryconfig.benrelationtopinsconfig":{
							rule:"checked"
						}
					}
			};
		}
		
		if(formConfig!=null){//如果不为空,启动表单验证
			/**
			$(dom).find(".easyui-linkbutton").each(function(i,e){
				if(i==0){
					//style="background:transparent;border:0;width: 0px"
					$(e).html('<input type="submit" value="保存" />');
					$(e).removeAttr("onclick");
				}
			});

			*/
			var config = $.extend({},globalConfig,formConfig);
			thisObj.startFormValidator(dom, config);
		}
	});
	
};
/**
 * 启动验证
 * @param formDom 表单对象
 */
BdpzPage.prototype.startFormValidator = function(formDom,config){
	$(formDom).validator(config);
};

/**
 * 组装数据为json
 */
BdpzPage.prototype.formData2Json = function(className){
	var data ={};
	$("."+className+"ContentDiv").find(".inputDataClass").each(function(index,dom){
		var key = dom.name;
		var value = dom.value;		
		if(data.hasOwnProperty(key)){
			data[key] = data[key]+","+value;
		}else{
			data[key] = value;
		}
	});
	return data;
};
/**
 * 提交表单
 * @param type 表单类型
 */
BdpzPage.prototype.submitform = function (type){
	var thisObj = this;
	var formId = type+'form';
	var formObj = $("#"+formId);
	var formDom = document.getElementById(formId);
	var needToValidator = false;
	for ( var e in thisObj.formValidatorArray) {
		if(thisObj.formValidatorArray[e]===type){
			needToValidator = true;
			break;
		}
	}
	if(needToValidator){//需要验证,直接提交,由niceValidator 验证
		//formDom.submit();
		/*
		var submitObj = $(formDom).find("input[type='submit']");
		if(submitObj.length<1){
			$(formDom).append('<input type="submit" style="display:none;" />');
		}else{
			submitObj.
		}
		*/
		$(formDom).trigger("validate");//触发表单验证
	}else{
		thisObj.doSubmitForm(formDom);
	}
};



/**
 * 提交表单数据
 * @param dom 表单
 */
BdpzPage.prototype.doSubmitForm = function(dom){
	var type = dom.id.replace("form", "").replace("Form", "");
	var coreproductcode =  $("#coreproductcode").val();
	
	var formObj = $(dom);
	var url = formObj.attr("action");
	var otherData = null;
	//投保人
	if(type=="applicant"){
		
	}else if(type=="beneficiary"){
		
	}else if(type=="insured"){
		var insoccupation = document.getElementById("geProductInsuredconfig.insoccupation");
		if(insoccupation!=null&&insoccupation.checked){//如果职业被选中
			var nodes = $('#OccupationTree').tree('getChecked');//选中的数据
			otherData = {};
			for ( var i = 0; i < nodes.length; i++) {
				otherData["geProductInsuredconfig.geProInsuredOccupations["+i+"].occupationcode"] = nodes[i].id;
			}
		}
	}
	//json object 表单数据
	var jsonData = formObj.serializeObject();
	//增加产品代码
	jsonData["geProductMain.coreproductcode"] = coreproductcode;
	jsonData["coreproductcode"] = coreproductcode;
	
	if(otherData!=null){//追加到表单数据中
		jsonData = $.extend(jsonData,otherData);
	}
	
	$.ajax({
		type:"POST",
		url:url,
		data:jsonData,
		success:function(data){
			if(data.resultCode=="success"){
				$.messager.alert("提示","保存成功!");
			}else{
				$.messager.alert("提示","保存失败!");
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			ECSINFO.alert_system_error();
		}
	});
};


/**
 * 点击触发其他是否显示
 * @param obj
 * @param type
 */
BdpzPage.prototype.show = function (obj,type){
	
	if(type=="beneficiary"){//受益人
		//设置被保人关系是否显示
		if(obj!=null&&obj.name=='geProductBeneficiaryconfig.benrelationtopins'){
			if(obj.checked){	 
				$("#"+type+"relationtopinsDiv").show();
				this.setElementDisabledInDiv(type+"relationtopinsDiv",false);
			}else{
				$("#"+type+"relationtopinsDiv").hide();
				this.setElementDisabledInDiv(type+"relationtopinsDiv",true);
			}
		}
	}else if(type=="insured"){//被保人
		if(obj!=null){
			if(obj.name=="geProductInsuredconfig.insrelationtoapp"){
				if(obj.checked){	 
					$("#insuredinsrelationtoappconfigDiv").show();
					this.setElementDisabledInDiv("insuredinsrelationtoappconfigDiv",false);
				}else{
					$("#insuredinsrelationtoappconfigDiv").hide();
					this.setElementDisabledInDiv("insuredinsrelationtoappconfigDiv",true);
				}
			}else if(obj.name=="geProductInsuredconfig.insismoreins"){
				if(obj.checked){	 
					$("#insuredfinsrelationtoappconfigDiv").show();
					this.setElementDisabledInDiv("insuredfinsrelationtoappconfigDiv",false);
				}else{
					$("#insuredfinsrelationtoappconfigDiv").hide();
					this.setElementDisabledInDiv("insuredfinsrelationtoappconfigDiv",true);
				}
			}else if(obj.name=="insured_ageScopeCheckBox"){
				this.changeAgeScope(obj, type,obj.checked);
			}else if(obj.name=="geProductInsuredconfig.insoccupation"){
				this.showOccupation(obj, type);
			}
		}
	}else if(type=="applicant"){//投保人
		if(obj!=null){
			if(obj.name=="applicant_ageScopeCheckBox"){
				this.changeAgeScope(obj, type,obj.checked);
			}
		}
	}
		
};
/**
 * 显示 年龄范围,改变值
 * @param obj 对象
 * @param type 类型
 * @param isShow 是否显示
 */
BdpzPage.prototype.changeAgeScope = function(obj,type,isShow){
	var firstLetterToUpperCase = type.charAt(0).toUpperCase()+type.substring(1);
	var firstThreeLetter = type.substring(0, 3);
	var idValue = "geProduct"+firstLetterToUpperCase+"config."+firstThreeLetter+"ageflag";
	var ageScopeTable = type+"_ageScopeTable";
	if(obj!=null){
		if(isShow){//显示,需要指定年龄区间
			$(obj).attr("checked",true);
			document.getElementById(idValue).value = "1";
			$("#"+ageScopeTable).show();
			this.setElementDisabledInDiv(ageScopeTable,false);
		}else{
			$(obj).attr("checked",false);
			document.getElementById(idValue).value = "0";
			$("#"+ageScopeTable).hide();
			this.setElementDisabledInDiv(ageScopeTable,true);
		}
	}
	
};
/**
 * 设置div下所有表单元素 是否disabled
 * @param id div的id
 * @param disabled true or false
 */
BdpzPage.prototype.setElementDisabledInDiv = function(id,disabled){
	var divDom = document.getElementById(id);//使用原始取dom,防止id中带 .
	$(divDom).find("input,select,checkbox,textarea,radio").each(function(index,dom){
		$(dom).attr("disabled",disabled);
	});
	
};
/**
 * 设置显示职业
 */
BdpzPage.prototype.showOccupation = function(obj,type){
	if(obj!=null){
		var divDom = document.getElementById(obj.name+"_div");
		if(obj.checked){
			this.loadOccupationTree(obj);
			$(divDom).show();
		}else{
			$(divDom).hide();
		}
	}
	
};
/**
 * 加载职业树
 * @param obj
 */
BdpzPage.prototype.loadOccupationTree = function(obj){
	var thisObj = this;
	
	var insuredconfigno = document.getElementById("geProductInsuredconfig.insuredconfigno").value;
	
	$.ajax({
		type:"POST",
		url:thisObj.ctx +"/system/product/getOccupationTree",
		data:{"insuredconfigno":insuredconfigno},
		success:function(data){
			$('#OccupationTree').tree({
				data: OccupationTree.convert(data),
				animate:true,
				lines:true,
				checkbox:true,
				onCheck:function(node,checked){
					if(checked){
						$("#insuredform").validator('hideMsg', '#occupationType');
					}else{
						
					}
					
				}
			});
			
			//if(obj!=null&&obj.checked){
				//$('#OccupationTree').tree('expandAll');
			//}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});	
};
/**
 *  显示必填复选框
 */
BdpzPage.prototype.showRequeriedIterm = function(obj,type){
	//点击触发其他是否显示
	this.show(obj,type);
	
	if(obj.checked){
		obj.value = "1";
		document.getElementById(obj.id+".value").disabled = false;
	}else{
		obj.value = "0";
		document.getElementById(obj.id+".value").checked = false;
		document.getElementById(obj.id+".value").disabled = true;
	}
};


/**
 * 初始化 受益人，被保人  各种关系显示
 */
BdpzPage.prototype.initPageShowContent=function(){
	//设置受益人,被保人 中      与他人关系是否显示
	this.show(document.getElementById("geProductBeneficiaryconfig.benrelationtopins"),"beneficiary");
	this.show(document.getElementById("geProductInsuredconfig.insrelationtoapp"),"insured");
	this.show(document.getElementById("geProductInsuredconfig.insismoreins"),"insured");
	this.show(document.getElementById("geProductInsuredconfig.insoccupation"),"insured");
	
};
/**
 * 点击必填，设置值
 */
BdpzPage.prototype.changeValue=function(obj){
	
	var requiredId = obj.id.replace(".value","");
	if(obj.checked){
		document.getElementById(requiredId).value = "2";
	}else{
		document.getElementById(requiredId).value = "1";
	}
};

/**
 * 表单重置
 */
BdpzPage.prototype.resetform=function(type){
	var formDom = document.getElementById(type+"form");
	formDom.reset();
};

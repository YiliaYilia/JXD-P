var BXJH = function(){};
BXJH.prototype.ctx = "";
BXJH.prototype.validator = function(productCode){
	var that = this;
	$('#addUpdateBXJHForm1').validator({
			theme: 'yellow_right',//主题
			timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
			rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
				planname: [/^[^<>]+$/, '不能出现<>字符'] //自定义EL表达式
			},
			fields:{//那些字段要加入到规则中
				"planname":{
					rule:"required;planname",
					tip: "不能出现<>字符"
				    //ok: "成功后显示"
				    //msg: {required: "全名必填!"}  覆盖默认的提示文字
				}
			
			},
			valid: function(form){ //验证成功
				$('#addUpdateBXJHForm2').submit();
				return false;
			},
			invalid: function(form){//验证失败
				$("#bxjhTab").tabs('select',"计划信息");
				return false;
			}
			
		});
		
		
		$('#addUpdateBXJHForm2').validator({
			theme: 'yellow_right',//主题
			timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
			rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
				unique:function(element, param, field){ //自定义方法规则
					var accountcodes=$('input[name^=accountcode]'); //查询
					var owerId= $(element).attr("id");
					for(var i=1;i<accountcodes.length;i++){
						var code = accountcodes[i-1];
						if($(code).attr("id") != owerId){
							if($(element).val().replace(/\s+/g,"") == $(code).val().replace(/\s+/g,"")){
								return {'error':'账户编号已存在'};
							}
						}
					}
					return true;
					
				}
			},
			fields:{//那些字段要加入到规则中
				"accountcode":{
					rule:"required;unique"
				},
				"accountname":{
					rule:"required"
				}
			
			},
			valid: function(form){ //验证成功
				$('#addUpdateBXJHForm3').submit();
				return false;
			},
			invalid: function(form){//验证失败
				$("#bxjhTab").tabs('select',"账户配置");
				return false;
			}
			
		});
		
		
		
		$('#addUpdateBXJHForm3').validator({
			theme: 'yellow_right',//主题
			timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
			rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
				scorerequired:function(element, param, field){ 
					var maxid = $(element).attr("id");
					var maxscore = $(element).val().replace(/\s+/g,"");
					var minscore = $("#"+maxid.replace("maxscore","minscore")).val().replace(/\s+/g,"");
					if(maxscore == "" || minscore == ""){
						return {'error':'分值不能为空'};
					}
					else{
						return true;
					}
				},
				tip:function(){
					return true;
				}
			},
			fields:{//那些字段要加入到规则中
				"maxscore":{
					rule:"scorerequired"
				},
				"capacitycode":{
					rule:"required"
				},
				"capacityname":{
					rule:"required"
				},
				"accounts":{
					rule:"tip",
					tip: "多个账户用,隔开"
				}
				
			
			},
			valid: function(form){ //验证成功
				$("#bxjhTab").tabs('select',"账户分值");
				var data = "";
				var planname = $("#planname").val().replace(/\s+/g,"");
				var initialcosttype = $("#initialcosttype").val().replace(/\s+/g,"");
				var initialcost = $("#initialcost").val().replace(/\s+/g,"");
				var paytypes = $('input[name="paytype"]:checked');
				var investments = $('input[name="investment"]:checked');
				var paytype = "";
				var investment = "";
				for(var i=0;i<paytypes.length;i++){
					paytype = paytype+$(paytypes[i]).val();
					if(i != paytypes.length-1){
						paytype = paytype+",";
					}
				}
				for(var i=0;i<investments.length;i++){
					investment = investment+$(investments[i]).val();
					if(i != investments.length-1){
						investment = investment+",";
					}
				}
				data = data+"&geInsurancePlans[0].planname="+planname;
				data = data+"&geInsurancePlans[0].initialcosttype="+initialcosttype;
				data = data+"&geInsurancePlans[0].initialcost="+initialcost;
				data = data+"&geInsurancePlans[0].paytype="+paytype;
				data = data+"&geInsurancePlans[0].investment="+investment;
				
				
				var accountcodes=$('input[name^=accountcode]'); //查询
				
				for(var i=1;i<accountcodes.length;i++){
					var account = accountcodes[i-1];
					var tr = $(account).parents('td').parents('tr');
					var accountcode = $(tr).find("input[name='accountcode']").val().replace(/\s+/g,"");
					var accountname = $(tr).find("input[name='accountname']").val().replace(/\s+/g,"");
					var index = i-1;
					data = data+"&geInsurancePlanAccounts["+index+"].accountcode="+accountcode;
					data = data+"&geInsurancePlanAccounts["+index+"].accountname="+accountname;
				}
				
				var scores = $('input[name^=maxscore]'); //查询
				for(var i=1;i<scores.length;i++){
					var score = scores[i-1];
					var tr = $(score).parents('td').parents('tr');
					var maxscore= $(tr).find("input[name='maxscore']").val().replace(/\s+/g,"");
					var minscore= $(tr).find("input[name='minscore']").val().replace(/\s+/g,"");
					var capacitycode =  $(tr).find("input[name='capacitycode']").val().replace(/\s+/g,"");
					var capacityname =  $(tr).find("input[name='capacityname']").val().replace(/\s+/g,"");
					var accounts = $(tr).find("input[name='accounts']").val().replace(/\s+/g,"");
					var index = i-1;
					data = data+"&geInsurancePlanAccountScores["+index+"].maxscore="+maxscore;
					data = data+"&geInsurancePlanAccountScores["+index+"].minscore="+minscore;
					data = data+"&geInsurancePlanAccountScores["+index+"].capacitycode="+capacitycode;
					data = data+"&geInsurancePlanAccountScores["+index+"].capacityname="+capacityname;
					data = data+"&geInsurancePlanAccountScores["+index+"].accounts="+accounts;
				}
				
				data=data+"&coreproductcode="+productCode;
				data = data+ "&date="+new Date();
				$.ajax({
					type:"POST",
					url:that.ctx+"/system/product/doBxjh",
					data:data,
					success:function(data){
						ECSINFO.showAddSuccess();
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						ECSINFO.alert_system_error();
					}
				});
				return false;
			},
			invalid: function(form){//验证失败
				$("#bxjhTab").tabs('select',"账户分值");
				return false;
			}
			
		});
	  
}



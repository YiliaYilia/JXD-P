var PolicyInfo = function() {};
PolicyInfo.prototype.basicData = [];
PolicyInfo.prototype.applicantData = [];
PolicyInfo.prototype.insuredData = [];
PolicyInfo.prototype.beneficiaryData = [];
PolicyInfo.prototype.agentData = [];

/**
 * 加载保单基本信息
 */
PolicyInfo.prototype.loadBasic = function(){
	$('#basic').propertygrid({
		fit:true,
		fitColumns:true,
        showGroup: true,
		columns: [[
		            { title: "基本信息", field: "name",width:15 },
		            { title: "", field: "value",width:80 }
		        ]]
	});
    $('#basic').propertygrid('loadData', this.basicData);
};

/**
 * 加载投保人信息
 */
PolicyInfo.prototype.loadApplicant = function(){
	$('#applicant').propertygrid({
		fit:true,
		fitColumns:true,
        showGroup: true,
		columns: [[
		            { title: "投保人信息", field: "name",width:15 },
		            { title: "", field: "value",width:80 }
		        ]]
	});
    $('#applicant').propertygrid('loadData', this.applicantData);
};

/**
 * 加载被保人信息
 */
PolicyInfo.prototype.loadInsureds = function(){
	$('#insureds').propertygrid({
		fit:true,
		fitColumns:true,
		showGroup: true,
		columns: [[
		           { title: "被保人信息", field: "name",width:15 },
		           { title: "", field: "value",width:80 }
		           ]]
	});
	$('#insureds').propertygrid('loadData', this.insuredData);
};

/**
 * 加载受益人信息
 */
PolicyInfo.prototype.loadBeneficiary = function(){
	$('#beneficiaries').propertygrid({
		fit:true,
		fitColumns:true,
		showGroup: true,
		columns: [[
		           { title: "受益人信息", field: "name",width:15 },
		           { title: "", field: "value",width:80 }
		           ]]
	});
	$('#beneficiaries').propertygrid('loadData', this.beneficiaryData);
};

/**
 * 加载代理人信息
 */
PolicyInfo.prototype.loadAgent = function(){
	$('#agent').propertygrid({
		fit:true,
		fitColumns:true,
		showGroup: true,
		columns: [[
		           { title: "代理人信息", field: "name",width:15 },
		           { title: "", field: "value",width:80 }
		           ]]
	});
	$('#agent').propertygrid('loadData', this.agentData);
};

var _result = '';
function dictTrans1(dictCode,dictType){
	if(_result==''){
		_result = [
		          {"dictdatacode":"1","dictdataname":"核保成功","dicttypecode":"STATUS"},
		          {"dictdatacode":"2","dictdataname":"核保失败","dicttypecode":"STATUS"},
		          {"dictdatacode":"3","dictdataname":"承保成功","dicttypecode":"STATUS"},
		          {"dictdatacode":"4","dictdataname":"承保失败","dicttypecode":"STATUS"}
		          ];
	}
	_result = eval(_result);
	for(var i = 0;i<_result.length;i++){
		if(_result[i].dicttypecode==dictType&&_result[i].dictdatacode==dictCode){
			return _result[i].dictdataname;
		}
	}
	return "";
};
function dictReload(ctx,dictType){$.ajax({async:false,url:ctx+'/system/dictReload',data:{'dictType':dictType,'temp':new Date().getTime()},success:function(data){data = eval(data);_result=data._result;}});} 



var policyInfo = new PolicyInfo();
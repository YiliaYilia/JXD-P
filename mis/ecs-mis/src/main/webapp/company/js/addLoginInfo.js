var tree={
	setting:{
		check: {
			enable: true,
			chkStyle: "radio",
//			chkboxType: { "Y": "p", "N": "ps" }
			radioType: "all"
		},
		view: {
    		showLine: true,
    		dblClickExpand: true,
    		showIcon: true,
    		fontCss : {color:"gray"}
    	},
        data:{
        	key:{
        		name:"comBranchName",
        		checked: "isChecked"
        	},
        	simpleData:{
        		enable: true,
        		idKey:"comBranchId",
        		pIdKey:"comParentBranchNo",
        		rootPId: 0
        	},
        	
        },
        
	},
	root:function(){
		$("#button").unbind("click");
		$("#button").bind("click",function(){
			
			$("#showTreeDiv").window({
				width : 440,
				height : 440,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				iconCls : 'icon-edit'

			});
			$("#showTreeDiv").css("display","block");
			$.post("/mis/company/getAllCompanyTree",null,function(data){
				$("#showTreeDiv").css("display","block");
				$.fn.zTree.init($("#tree"),tree.setting, data);
				
			});
		});
		$("#sureCompany").unbind("click");
		$("#sureCompany").bind("click",function(){
			var treeObj=$.fn.zTree.getZTreeObj("tree");
			var nodes=treeObj.getCheckedNodes(true);
			$("#companyBranch").val(nodes[(nodes.length-1)].comBranchName);
			$("#comBranchId_1").val(nodes[(nodes.length-1)].comBranchId);
			$("#showTreeDiv").window('close');
			$("#showTreeDiv").css("display","none");
		});
		
	}
};
function copyLoginName(){
	$("#detailLoginName").val($("#infoLoginName").val());
}
function submit(){
	copyLoginName();
	$('#form').form('submit',{
		url:ctx+"/company/addLoginInfo",
		success:function(data){
			if(data==1){
			$.messager.show({  	
				  title:'My Title',  	
				  msg:'保存企业经办人成功，发送邮件成功',  	
				  timeout:5000,  	
				  showType:'slide'  
				}); 
			$("#form").form('clear');
			}
		}
	});
	$("#password").prop('disabled',true);
}
function formValidate(){
	var that = this;
	$('#form').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){
				/*var codeAuth = $("#dictDataCode").val();
				var v = $('#addUpdateDictDataForm').validator().data('validator');
				if(""!=codeAuth){
					return $.ajax({
						url:"../system/existDictData?temp="+new Date().getTime(),
						async:false,
						data:{
							"oldCode":$('#oldCode').val(),
							"oldID":$('#oldID').val(),
							"operateType":$('#operateType').val(),
							"dicttypeid":$("#dicttypeid-cbx").combobox('getValue'),
							"dictDataCodeAuth":codeAuth
						},
						success:function(result){
							return result;
						}
					});
				}*/
			}
		},
		fields:{//那些字段要加入到规则中
			"loginMail":{
				rule:"required;unique",
				tip: "建议填写英文或缩写"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			"infoLoginName":{
				rule:"required",
				tip: "该代码的中文内容"
			}
		},
		valid: function(form){ //验证成功
			dict.saveDictData();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
}


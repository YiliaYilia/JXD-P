var BankManage = function(){};


/**
 * 自定义工具栏
 */
BankManage.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar table tr').append("<td></td>");
	$('#searchBar table').appendTo('.datagrid-toolbar table tr td:last');
};
/**
 * 创建表格
 */
BankManage.prototype.createDataGrid = function(){
	this.initToolBar();
	$('#bankData').datagrid({
		url : this.ctx+'/business/searchBankData',
		pageSize:20,
		pageList:[15,20,25,30],
		toolbar : this.toolbar,
		pagination : true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		checkbox:true,
		width:$("#bankData").width(),
		columns : [ [{
            field : 'bankID',
            title : 'ID',
            hidden:true
        },
		{
			checkbox:true
		},{
			field : 'bankcode',
			title : '银行编码 ',
			width : ($("#bankData").width() * 0.2)
		}, {
			field : 'bankname',
			title : '付方银行 ',
			width : ($("#bankData").width() * 0.2)
		}, {
			field : 'paychannel',
			title : '支付渠道',
			width : ($("#bankData").width() * 0.2)
		}, {
			field : 'singlelmt',
			title : '单账户单笔限额',
			width : ($("#bankData").width() * 0.2)
		} , {
			field : 'daylmt',
			title : '单账户单日限额',
			width : ($("#bankData").width() * 0.2)
		},{
            field : 'status',
            title : '可用状态',
            width : ($("#bankData").width() * 0.2)
        },{
              field : 'createtime',
              title : '创建时间',
              width : ($("#bankData").width() * 0.2)
        },{
           field : 'updatetime',
           title : '更新时间',
           width : ($("#bankData").width() * 0.2)
        } ] ]
	});

	this.initOwnToolBar();
};

BankManage.exp =  {
		text : '导出',
		iconCls : 'icon-undo',
		handler : function() {
			var bankCodeID = $("#searchBankCode").val();
        	var bankNameID = $("#searchBankName").val();
        	var selections = $("#bankData").datagrid('getSelections');
        	var seleteIds = "";
            if(selections.length >= 1){
                var bankId = "";
                $(selections).each(function(index,selection){
                    selection = eval(selection);
                    bankId += selection.bankID+",";
                });
                seleteIds = bankId.substring(0,bankId.length-1);
            }
			window.location.href='../business/expBank?seleteIds='+seleteIds+'&bankCodeID='+bankCodeID+'&bankNameID='+bankNameID;
		}
};
BankManage.imp =  {
		text : '导入',
		iconCls : 'icon-redo',
		handler : function() {
			bankManage.formUpload();
			$("#file").val("");
		    $('#upload_window').show();
            $('#upload_window').window({
                width : 450,
                height : 180,
                modal : true,
                resizable:false,
                collapsible : false,
                minimizable : false,
                maximizable : false,
                iconCls : 'icon-redo',
                onClose:bankManage.close2,
                title : ECSINFO.exp
            });
        }
};
BankManage.prototype.formUpload = function(){
	var that = this;
	$('#uploadForm').validator({
		theme: 'yellow_right',//主题
		timely:1,
		valid: function(form){ //验证成功
			bankManage.uploadData();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
};
BankManage.download =  {
		text : '模板下载',
		iconCls : 'icon-tip',
		handler : function() {
			window.location.href='../business/download';
		}
};
BankManage.add =  {
		text : '插入',
		iconCls : 'icon-add',
		handler : function() {
		    bankManage.formValidate();
			$("#bankID").val("");
			$('#operateType').val("save");
			$("#addbankcode").val("");
			$("#addbankname").val("");
			$("#addpaychannel").val("");
			$("#addsinglelmt").val("");
			$('#adddaylmt').val("");
			$('#addstatus option:selected').val();
			$('#bankData_add_window').show();
			$('#bankData_add_window').window({
				width : 450,
				height : 250,
				modal : true,
			    resizable:false,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				iconCls : 'icon-add',
				onClose:bankManage.close,
				title : ECSINFO.add
			});
		}
};

BankManage.update =  {
		text : '修改',
		iconCls : 'icon-edit',
		handler : function() {
            bankManage.formValidate();
            $('#operateType').val("update");
            var selections = $("#bankData").datagrid('getSelections');
            if(selections.length == 1){
                $('#bankData_add_window').show();
                $('#bankData_add_window').window({
                    width : 450,
                    height : 250,
                    modal : true,
                    resizable:false,
                    collapsible : false,
                    minimizable : false,
                    maximizable : false,
                    onClose:bankManage.close,
                    iconCls : 'icon-edit',
                    title : ECSINFO.update
                });
                $(selections).each(function(index,selection){
                    selection = eval(selection);
                    var bankID = selection.bankID;
                    $("#bankID").val(bankID);
                    $.ajax({
                        url:"../business/editBankData",
                        data:{"bankID":bankID},
                        success:function(result){
                            result = eval(result);
                            if(result.success){
                                $("#addbankcode").val(result.bankcode);
                                $("#addbankname").val(result.bankname);
                                $("#addpaychannel").val(result.paychannel);
                                $("#addsinglelmt").val(result.singlelmt);
                                $("#adddaylmt").val(result.daylmt);
                                $("#addstatus").val(result.status);
                            }else{
                                ECSINFO.alert_system_error();
                            }
                        }
                    });

                });

            }else{
                ECSINFO.alert_update_unique();
            }
			}
};

BankManage.del =  {
		text : '删除',
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#bankData").datagrid('getSelections');
                if(selections.length >= 1){
                    var bankId = "";
                    $(selections).each(function(index,selection){
                        selection = eval(selection);
                        bankId += selection.bankID+",";
                    });
                    var deleteIds = bankId.substring(0,bankId.length-1);
                    ECSINFO.confirm_delete(function(){
                        $.ajax({
                            url:'../business/deleteBankDatas?temp='+new Date().getTime(),
                            data:{"deleteIds":deleteIds},
                            success:function(){
                                ECSINFO.showDeleteSuccess();
                                bankManage.reloadGrid();
                            }
                        });
                    });
                }else{
                    ECSINFO.alert_delete_requried();
                }
        }
};


/**
 * 工具栏
 */
BankManage.prototype.toolbar = [];
BankManage.prototype.initToolBar = function(){
	if(auth.access('RULE_BUSINESSDATA_BANKMANAGE')){
		this.toolbar.push(BankManage.exp);
		this.toolbar.push("-");
	}
	if(auth.access('RULE_BUSINESSDATA_BANKMANAGE')){
        this.toolbar.push(BankManage.add);
        this.toolbar.push("-");
    }
    if(auth.access('RULE_BUSINESSDATA_BANKMANAGE')){
        this.toolbar.push(BankManage.update);
        this.toolbar.push("-");
    }
    if(auth.access('RULE_BUSINESSDATA_BANKMANAGE')){
        this.toolbar.push(BankManage.del);
        this.toolbar.push("-");
    }
    if(auth.access('RULE_BUSINESSDATA_BANKMANAGE')){
            this.toolbar.push(BankManage.imp);
            this.toolbar.push("-");
    }
    if(auth.access('RULE_BUSINESSDATA_BANKMANAGE')){
            this.toolbar.push(BankManage.download);
            this.toolbar.push("-");
    }
};


BankManage.prototype.close = function(){
	$('#addUpdateBankDataForm').validator('destroy');
};
BankManage.prototype.close2 = function(){
	$('#uploadForm').validator('destroy');
	$("#file").val("");
};
BankManage.prototype.close1 = function(){
	$('#bankData_add_window').window('close');
};

BankManage.prototype.close3 = function(){
	$('#upload_window').window('close');
};
/**
 * 搜索数据字典
 */
BankManage.prototype.searchbankdata = function(){
	var bankCodeID = $("#searchBankCode").val();
	var bankNameID = $("#searchBankName").val();
	$("#bankData").datagrid('load',{'bankCodeID':bankCodeID,'bankNameID':bankNameID});
};

BankManage.prototype.formValidate = function(){
	$('#addUpdateBankDataForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段

		fields:{//那些字段要加入到规则中
			"bankcode":{
				rule:"required",
				tip: "必填"
			},
			"bankname":{
				rule:"required",
				tip: "必填"
			},
			"paychannel":{
                rule:"required",
                tip: "必填"
            },
            "singlelmt":{
                rule:"required",
                tip: "必填"
            },
            "daylmt":{
                rule:"required",
                tip: "必填"
            },
            "status":{
                rule:"required",
                tip: "必填(Y/N)"
            }
		},
		valid: function(form){ //验证成功
			bankManage.saveBankData();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
};

BankManage.prototype.reloadGrid=function(){
	var bankCodeID = $("#searchBankCode").val();
    var bankNameID = $("#searchBankName").val();
    $("#bankData").datagrid('reload',{'bankCodeID':bankCodeID,'bankNameID':bankNameID});
};
BankManage.prototype.saveBankData = function(){
    var bankID = $("#bankID").val();
    var operateType = $('#operateType').val();
	var bankname = $("#addbankname").val();
	var bankcode = $("#addbankcode").val();
	var paychannel = $("#addpaychannel").val();
	var singlelmt = $("#addsinglelmt").val();
	var daylmt = $("#adddaylmt").val();
	var status = $("#addstatus option:selected").val();

	$.ajax({
		url:this.ctx+'/business/saveBankData',
		dataType:"json",
		data:{"bankID":bankID,"bankname":bankname,"bankcode":bankcode,"paychannel":paychannel,"singlelmt":singlelmt,"daylmt":daylmt,"status":status,"operateType":operateType},
		success:function(data){
			bankManage.close1();
			data = eval(data);
			if(data.success){
			    ECSINFO.showAddSuccess();
				bankManage.reloadGrid();
			}else{
				ECSINFO.alert_insert_repeat();
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
		    ECSINFO.alert_system_error();
        }
	});
};

BankManage.prototype.uploadData = function(){
     var fileName =  $("#file")[0].files[0];//js 获取文件对象
     console.log(fileName);
     if(fileName !== undefined){
           var file_typename =   fileName.name.substring(fileName.name.lastIndexOf('.'));
           if (file_typename === '.xlsx' || file_typename === '.xls') {
//                UpladFile(fileName);
                var form = new FormData(); // FormData 对象
                form.append("file", fileName); // 文件对象
                $.ajax({
                    url: this.ctx+'/business/uploadBankExcel',                      //url地址
                    type: 'POST',
                    data:form,// 上传formdata封装的数据
//                    dataType: 'JSON',
                    cache: false,                  // 不缓存
                    processData: false,        // jQuery不要去处理发送的数据
                    contentType: false,         // jQuery不要去设置Content-Type请求头
                    success:function (data) {
                        //成功回调
                        if(data.success){
                            bankManage.close3();
                            ECSINFO.showAddSuccess();
                            bankManage.reloadGrid();
                            $("#file").val("");
                        }else{
                            ECSINFO.alert_repeat();
                            $("#file").val("");
                        }
                    },
                   error:function (XMLHttpRequest, textStatus, errorThrown){
                        $("#file").val("");
                        ECSINFO.alert_system_error();
                   }
                });
           }else {
                alert("请选择正确的文件类型！")
                $("#file").val("");
            }
        }else{
            console.log("请选择正确的文件！")
            $("#file").val("");
        }
};

var bankManage = new BankManage();




















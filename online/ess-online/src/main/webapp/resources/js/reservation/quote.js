$(document).ready(function(){
    $('.quote-gender-it').on(tap,function(){
    	var $this 		= $(this);
      	
	  	if(!$this.hasClass('active')){
		  	$this.addClass('active');
		  	$this.siblings().removeClass('active');
		  	
		  	$('#gender').val($this.attr('value'));
	  	}
      	return false;
    });
   
    
	var $province = $('select#dropDownMenu');
	
	var $city = $('select#city');
	// 下拉菜单
	// 省
	$province.on('change', function() {
		changeCity();
		$province.removeAttr("disabled");
		$city.removeAttr("disabled");
	});

	$city.on('change', function() {
		$province.removeAttr("disabled");
		$city.removeAttr("disabled");
	});
	$('#reservateInput').on('click',function(){
		reservateInput() ;
	});
  
	$('#backProduct').on('click',function(){
		$('#formProduct').submit() ;
	});

    //年龄变化发请求
    $('#age').on('change', function() {
		changePayPeriod();
	});
    
    //拖动轴初始化 
	$('#money').range();
	//$('#payDate').range();
	
    //加载完页面根据年龄发请求初始化缴费期间
	initPayPeriod() ;
	
	$('#fillForm').validator({
		timely:false,
		stopOnError :true,
		rules:{
			name:function(el){
				var name = el.value;
				
				if(name.length < 2){
					return false;
				}
				
				return this.test(el, 'cn_en');
			},
			select:function(el,params,field){
				var value = $(el).val();
				
				if(value == "-1" || value == ""){
					return false;
				}
				
				return true;
			},
			agree:function(el){
				return $(el).is(':checked');
			}
		},
		messages: {
			en_cn:'请输入正确的姓名',
			name:'请输入正确的姓名',
			select:'请选择{0}',
			date:'日期格式错误',
			mobile:'请输入正确的手机号码',
			agree:'请仔细阅读条款并同意条款内容'
		},
		fields:{
			'#name':						'被保人姓名:name',
			'#age':						{display:'被保险人年龄',			must:true,		rule:'select'},
			'#gender':					'性别:required',
			'#phone':					'手机号码:required,mobile',
			'inputRegion.province':	{display:'被保人常住地-省',		must:true,		rule:'select'},
			'#city':						{display:'被保人常住地-市',		must:true,		rule:'select'},
			'#money':					{display:'保障金额',					must:true,		rule:'select'},
			'#payDate':					{display:'缴费期限',					must:true,		rule:'select'},
		},
		msgMaker:function(){
			return "";
		}
	}).on('valid.field', function(e, result, me){
//		校验通过后的处理
	}).on('invalid.field', function(e, result, me){
//		校验不通过后的处理
		modal_alert(result.msg);
	});
});

function changePayPeriod(){
	var productCode =$('#prodoctcode').val();
	if(productCode=="CCC"){
		return ;
	}
	modal_loading();
	initPayPeriod() ;
} 

function initPayPeriod(){
	var age = $('#age').val();
	var productCode =$('#prodoctcode').val();
	console.log('::'+age+"::"+productCode);
	
	if(productCode==null||productCode==""){
		modal_loading('hide');
		return ;
	}
	if(age==null||age==""){
		modal_loading('hide');
		return ;
	}
	
	var $payDate =$('#payDate');
	var input = {
	    "policy.prodoctcode":productCode,
	    "inputAge":age
	};
	
	
	$.ajax({
		type : "POST",
		async : true,
		url : contentRootPath + "/reservation/ehoPayPeriod",
		data : input,
		dataType : "json",
		success : function(data) {
	   		if(data.resultSuccess){
				var html = '';
				var periodList = data.periodList;
				for (var i = 0; i < periodList.length; i++) {
					if(productCode!="NBJ"){
						html += '<option value=' + periodList[i] + '>' + periodList[i] + '年</option>';
					}else{
						var v =periodList[i] ;
						var op ="" ;
						if(v=="0"){
							op ='<option value=' + v + '>'+ '趸缴</option>';
						}else if(v=="-18"){
					    	op ='<option value=' + v + '>'+ '缴至18周岁</option>';
					    }else{
					    	op= '<option value=' + v + '>' + periodList[i] + '年</option>';
					    }
						html += op ;
					}
				}
				$payDate.empty();
				$payDate.html(html);
				
			    //拖动轴初始化 
				$('#payDate').range();
				modal_loading('hide');
				return;
		    }
		   if(data.resultCode == 2101){
			   modal_loading('hide');
			   modal_alert(data.resultDescription);
				return;
			}
		   modal_loading('hide');
		   modal_alert("系统繁忙：" + data.resultCode);
		       return;
		},
		error : function(data) {
			modal_loading('hide');
		}
	});
	
}

function reservateInput(){

	var productCode =$('#prodoctcode').val();
	var name = $('#name').val();
	var sex = $('.col-sm-12.quote-gender-it.active p').text() ;
	if('女'==sex){
		sex='0';
	}
	if('男'==sex){
		sex='1';
	}
	var age = $('#age option:selected').val();
	var phone = $('#phone').val();
	var province = $('#dropDownMenu  option:selected').text();//取省
	var city = $('#city option:selected').text();
	
	
	var address =province + city ;
	var money = $('#money option:selected').val();
	var payDate = $('#payDate option:selected').val();
	console.log("产品编号："+productCode+":"+name+":"+sex+":"+age+":"+phone+":"+address+":"+money+":"+payDate);
	
	$('#fillForm').validSubmit(function(valid){
		
		//校验不通过返回
		if(!valid){
			return;
		}
		//等待提示框
		modal_loading();
		var input = {
	        "applicantInsured.name":name,
		    "policy.prodoctcode":productCode,
		    "applicantInsured.sex":sex,
		    "inputAge":age,
		    "applicantInsured.mobile":phone,
		    "applicantInsured.address":address,
		    "policy.sumamount":money,
		    "policy.payYear":payDate
		};
		$.ajax({
			type : "POST",
			async : true,
			url : contentRootPath + "/reservation/reservateInput",
			data : input,
			dataType : "json",
			success : function(data) {
		   		if(data.resultSuccess){
		   			//关闭等待提示框
		   			modal_loading('hide');
		   			window.location.href = contentRootPath+"/reservation/reservateResult";	
					//alert("试算完成");
		   			console.log("试算完成");
					return;
			    }
			   if(data.resultCode == 2101){
				   modal_loading('hide');
				   modal_alert(data.resultDescription);
					return;
				}
			   modal_loading('hide');
			   modal_alert("系统繁忙：" + data.resultCode);
			       return;
			},
			error : function(data) {
			}
		});	
	});
}

function changeCity() {
	var provinceCode=$('select#dropDownMenu option:selected').val();
	if(provinceCode == "" || provinceCode == null){
		$('select#city').empty();
		$('select#city').html("<option value=''>请选择</option>");
		return false;
	}
	if (provinceCode != "" && provinceCode != null) {
		inputRegion = {
			'inputRegion.provinceCode' : provinceCode,
			'type' : 'office'
		};
		
		modal_loading();
		$.ajax({
			type : "POST",
			async : true,
			url : contentRootPath + "/wechat/regionalCity",
			data : inputRegion,
			dataType : "json",
			success : function(data) {
				if ("9000" == data.resultCode) {
					modal_loading('hide');
					modal_alert({
						content : "系统繁忙：9000",
						btn : '确定'
					});
					return false;
				}
				if ("2008" == data.resultCode) {
					modal_loading('hide');
					modal_alert({
						content : '长时间未进行操作，请重新进入',
						btn : '确定'
					});
					return false;
				}
				
				var html = '<option value="">请选择</option>';
				var cityList = data.cityList;
				for (var i = 0; i < cityList.length; i++) {
					html += '<option value=' + cityList[i].cityCode + '>' + cityList[i].cityName + '</option>';
				}
				
				modal_loading('hide');
				$('select#city').empty();
				$('select#city').html(html);
			},
			error : function(data) {
				modal_loading('hide');
				// 不跳转
				modal_alert({
					content : "系统繁忙：9001",
					btn : '确定'
				});
			}
		});
	}
} 
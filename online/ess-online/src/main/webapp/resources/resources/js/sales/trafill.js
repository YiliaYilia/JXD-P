var d;
var start;

$(document).ready(function split(){
	
	
	var date = new Date();
	var systemTime = $("#systemTime").val();
	var start1 = $("#start1").val();
	var starts =  $("#start").val();
	var ends =  $("#end").val();
	$('#start').scroller({
    	preset: 'date',
    	headerText: '请选择日期',
    	theme: 'android',
    	display: 'modal',
    	"width": 130,
		"height": 90,
    	mode: 'scroller',
    	dateOrder: 'yy mm dd',
    	setText: '确定',
    	cancelText: '取消',
    	minDate: date.addDate('d',1),
    	maxDate: date.addDate('d',365),
    	formatResult: function(d){
    		$('#start').data('rdate',d);
    		starts = dateFormatsuan(d);
    		if(starts!=null&&starts!=''&&ends!=null&&ends!=''){
    			//alert(dateDiffInDays(starts,ends));
    			$("#p_days").val(dateDiffInDays(starts,ends));
    			
    		}
    		return dateFormat(d);
    		
    	},
    	onSelect:function(){
    		changestart();
		}
    });
	$('#end').scroller({
    	preset: 'date',
    	headerText: '请选择日期',
    	theme: 'android',
    	display: 'modal',
    	"width": 130,
		"height": 90,
    	mode: 'scroller',
    	dateOrder: 'yy mm dd',
    	setText: '确定',
    	cancelText: '取消',
    	minDate: date.addDate('d',8),
    	maxDate: date.addDate('d',365+8),
    	formatResult: function(d){
    		$('#end').data('rdate',d);
    		ends = dateFormatsuan(d);
    		if(starts!=null&&starts!=''&&ends!=null&&ends!=''){
    		//	alert(dateDiffInDays(starts,ends));
    			//if(dateDiffInDays(starts,ends)<1){
    			//	modal_alert("提示信息");
    			//	return false;
    		//	}else if(dateDiffInDays(starts,ends)>30){
    		//		modal_alert("提示信息");
    		//		return false;
    		//	}else{
    				$("#p_days").val(dateDiffInDays(starts,ends));
    		//	}
    		}
    		return dateFormat(d);
    	},
    	onSelect:function(){
    		changestart();
		}
    });
	initDate1 = date.parseDate(systemTime);
	start1 = date.parseDate(start1);
	var initDate;
    var isBack = $("#isBack").val();
    if(isBack==0){
    	initDate = initDate1.addDate('d',1);
    }else{
    	initDate = start1;
    }
    $('#start').val(initDate.formatDate('yyyy年MM月dd日'));
    var dateList = [];
    dateList.push(initDate.getFullYear());
    dateList.push(initDate.getMonth());
    dateList.push(initDate.getDate());
    $('#start').data('rdate',dateList);
    changestart();

	var payPeriodNumber = $("#inputPeriodNum").val().split('_');
	var policyterm1=payPeriodNumber[0];
	var policytermtype = payPeriodNumber[1];
	var str;
	if(policytermtype=='年'){
		str = (d.getFullYear()+parseInt(policyterm1))+"年"+(d.getMonth()+1)+"月"+(d.getDate())+"日";
		$("#endtime").text(str);
	}
	if(policytermtype=='天'){
		d = +d + policyterm1*(1000*60*60*24);
		d = new Date(d);
		var month = d.getMonth()+1;
		var day = d.getDate();
		str = (d.getFullYear())+"年"+month+"月"+day+"日";
		$("#endtime").text(str);
	}

});

function changestart(){
	var startDate = $('#start').data('rdate');
	
	var policyterm = $("#inputPeriodNum").val();
	var policytermList = policyterm.split('_');
	var policyterm1 = policytermList[0];
	var policytermtype = policytermList[1];
	
	var endDate = new Date(startDate[0],startDate[1],startDate[2]);
	
	if(policytermtype === 'Y'){
		endDate = endDate.addDate('y',policyterm1);
	}
	if(policytermtype === 'M'){
		endDate = endDate.addDate('m',policyterm1);
	}
	if(policytermtype === 'D'){
		endDate = endDate.addDate('d',policyterm1);
	}
	
	$("#endtime").text(dateFormatNum(endDate.getFullYear(),endDate.getMonth() + 1,endDate.getDate()));
}


var dateFm = ['年','月','日'];
var dateFmsuan = ['-','-','-'];

function dateFormat(d){
	var out = '';
	for (var i = 0; i < d.length; i++) {
		var n = d[i];
		if(i == 1 || i == 2){
			if(i == 1){
				n++;
			}
			if(n < 10){
				n = '0'+n;
			}
		}
		out += n + dateFm[i];
	}
	return out;
	alert(out);
}
function dateFormatsuan(d){
	var out = '';
	for (var i = 0; i < d.length; i++) {
		var n = d[i];
		if(i == 1 || i == 2){
			if(i == 1){
				n++;
			}
			if(n < 10){
				n = '0'+n;
			}
		}
		out += n + dateFmsuan[i];
	}
	out = out.substring(0, out.length-1);
	return out;
}
function dateFormatNum(y,m,d){
	var out = '';
	out += y + dateFm[0];
	out += m + dateFm[1];
	out += d + dateFm[2];
	return out;
}
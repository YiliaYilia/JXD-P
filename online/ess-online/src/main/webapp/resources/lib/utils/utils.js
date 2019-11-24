/***
 *判断是否为IE浏览器
 * @returns {Boolean}
 */
function isIE() {
	if(document.all) return true;
	return false;
}

function getElementsByClassName(n) {
    var el = [],
        _el = document.getElementsByTagName('*');
    for (var i=0; i<_el.length; i++ ) {
       if (_el[i].className == n ) {
           el[el.length] = _el[i];
        }
   }
   return el;
}

/**
 * 活动对象的所有属性
 * @param obj
 * @param choice
 */
function  hasProperties(obj, choice) {
	 document.writeln("<hr />"); 	
	 for (var property in obj) {
		if (choice != null) {
			
			if (choice instanceof RegExp) {
				if (choice.test(property)) {
					document.writeln(property);
				}
			} else {
				if (property.toLowerCase().indexOf(choice.toLowerCase()) > -1) {
					document.writeln(property);
				}
			}
			
		} else {
			document.writeln(property);
		}
		
	}
	document.writeln("<hr />"); 
}

/***
 * 将javaScript对象转化成JSON串
 */
function toJSON(obj,exceptVar){
	if (obj) {
		switch(obj.constructor){
		    case Object:
		        var str = "{";   
		        for(var o in obj){ 
		        	if(o == exceptVar){
		        		continue;
		        	}
		        	var tempstr = arguments.callee(obj[o],exceptVar);
		        	if ("0" == tempstr) {
		        		alert(o + ":" + tempstr);
		        	}
		        	if(tempstr!=null&&tempstr!=""){ 
		        		str += o + ":" + tempstr +",";   
		            }
		        }   
		        if(str.substr(str.length-1) == ",")   
		            str = str.substr(0,str.length -1);   
		        return str + "}";   
		        break;   
		    case Array:               
		        var str = "[";   
		        for(var o in obj){ 
		        	if(o == exceptVar){
		        		continue;
		        	}
		        	var tempstr = arguments.callee(obj[o],exceptVar); 
		        	if(tempstr!=null&&tempstr!=""){ 
		            str += tempstr +",";   
		            }  
		        }   
		        if(str.substr(str.length-1) == ",")   
		            str = str.substr(0,str.length -1);   
		        return str + "]";   
		        break;   
		    case Boolean:   
		        return "\"" + obj.toString() + "\"";   
		        break;   
		    case Date:   
		        return "\"" + obj.toString() + "\"";   
		        break;   
		    case Function:   
		    	return "";
		        break;   
		    case Number:
		        return "\"" + obj.toString() + "\"";   
		        break; 
		    case String:   
		        return "\"" + obj.toString() + "\"";   
		        break;       
		}
	} else {
		switch(typeof obj) {
		case 'number':
			return "\"" + obj.toString() + "\""; 
		 default:
			 return "";
		}
	}
}

/**
 * 输出对象并换行
 */
document.writeln = function(obj) {
	document.write(obj + "<br />");
 };


/**
 * 获取文字在指定容器中的宽度
 * 
 * str 待计算宽度文字
 * srcEl 目标容器
 * 
 * @returns 文字宽度
 * 
 * added：汪晔
 */
function getTextWidth(str,srcEl){
	var text_span = $('#text_width_aclc');
	text_span.show();
	if(text_span.length == 0){
		$('body').append($('<span id="text_width_aclc" style="visibility:hidden;"></span>'));
	}
	text_span = $('#text_width_aclc');
	var font_attr = ['font-size','font-weight','font-family','font-style'];
	for(var i=0 ; i< font_attr.length ; i++){
		text_span.css(font_attr[i],srcEl.css(font_attr[i]));
	}
	
	text_span.text(str);
	var width = text_span.width();
	text_span.hide();
	return width;
}

function objExistInArray(array,obj){
	return indexOfArray(array,obj) != -1;
}

function indexOfArray(array,obj){
	for(var i = 0;i<array.length;i++){
        if(array[i] == obj){
           return i;
         }
     }
     return -1;
}

function clear(array){
	array.length = 0;
}

function insert(array,index, obj){
	if(index >= 0){
		array.splice(index, 0, obj);
	}
}
function remove(array,index){
	if(index >= 0){
		array.splice(index, 1);
	}
}
function removeObj(array, obj){
	var index = array.indexOf(obj);
	if(index >= 0){
		remove(array,index);
	}
}

var OS = function(){
	var userAgent = navigator.userAgent,
	names = {
        ios: 'iOS',
        android: 'Android',
        webos: 'webOS',
        blackberry: 'BlackBerry',
        rimTablet: 'RIMTablet',
        mac: 'MacOS',
        win: 'Windows',
        linux: 'Linux',
        bada: 'Bada',
        other: 'Other'
    },
    prefixes = {
        ios: 'i(?:Pad|Phone|Pod)(?:.*)CPU(?: iPhone)? OS ',
        android: '(Android |HTC_|Silk/)',
        blackberry: 'BlackBerry(?:.*)Version\/',
        rimTablet: 'RIM Tablet OS ',
        webos: '(?:webOS|hpwOS)\/',
        bada: 'Bada\/'
    },
    name,
    version = '',
    i, prefix, match, item, is;
    
	this.is = function(osname){
		if(osname == name){
			return true;
		}else{
			return false;
		}
	}
	
	for (i in prefixes) {
        if (prefixes.hasOwnProperty(i)) {
            prefix = prefixes[i];

            match = userAgent.match(new RegExp('(?:'+prefix+')([^\\s;]+)'));
            if (match) {
                name = names[i];
                break;
            }
        }
    }
	
	if (!name) {
        name = names[(userAgent.toLowerCase().match(/mac|win|linux/) || ['other'])[0]];
    }
	
	this.name = name;
    this.version = version;
    
    this.names = names;
}

var Browser = function(){
	var userAgent = navigator.userAgent.toLowerCase();
	this.version = (userAgent.match( /.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/ ) || [0,'0'])[1];
	this.safari = /webkit/.test( userAgent ) && /safari/.test( userAgent ) && !/chrome/.test( userAgent );
	this.chrome = /webkit/.test( userAgent ) && /chrome/.test( userAgent );
	this.opera = /opera/.test( userAgent );
	this.msie = /msie/.test( userAgent ) && !/opera/.test( userAgent );
	this.mozilla = /mozilla/.test( userAgent ) && !/(compatible|webkit)/.test( userAgent );
}

if(!window.browser){
	window.browser = new Browser();
}
if(!window.os){
	window.os = new OS();
}

function setInputType(input,type){
	if(type == 'number'){
		input.attr({
			'onkeypress':'var k=event.keyCode; return k>=48&&k<=57 ',
			'onpaste':'return !clipboardData.getData("text").match(/\D/)',
			'ondragenter':'return false',
			'style':'ime-mode:Disabled'
		})
	}
}

function setInputRule(input){
	if(isIE()){
		var el = input[0];
		if(el){
			el.onkeypress = function(){TextValidate("input",this,event);};
			el.onkeyup = function(){TextValidate("inputup",this,event);}
			el.onpaste = function(){TextValidate("paste",this,event);}
			el.ondrag = function(){TextValidate("drop",this,event);}
			el.ondragenter = function(){TextValidate("drop",this,event);}
			el.ondragover = function(){TextValidate("drop",this,event);}
		}
	}else{
		input.attr({
			'onkeypress':'TextValidate("input",this,event);',
			'onkeyup':'TextValidate("inputup",this,event);',
			'onpaste':'TextValidate("paste",this,event);',
			'ondrag':'TextValidate("drop",this,event);',
			'ondragenter':'TextValidate("drop",this,event);',
			'ondragover':'TextValidate("drop",this,event);'
		})
	}
}
function TextValidate(type,el,event) {
	event = event || window.event;
	var pos = getCursorPos(el);
    var code;
    var character;
    var regText;
    
//    regText = "[\\{,\\},\\\[,\\\],\\*,\\&,\\\\,\\/,\\?,\\|,\\:,\\<,\\>,\",\']";
    
    //除了#-（）以外的所有特殊字符（括号为中文括号）
    regText = "[~!@$%^&*_+`=\\[\\]\\{}|;\'\":,\.\/<>?！￥…—、‘’“”；：，。《》（）【】？·]";
    
    if (type == "input" || type == "inputup") {
    	if(window.event){
    		code = window.event.keyCode;    		
    	}else{
    		code = arguments.callee.caller.arguments[0].which;
    	}
    }
    else if (type == "paste") {
    	if(window.clipboardData){
    		code = window.clipboardData.getData('text');
    	}
    }
//    else if (type == "drop") {
//        code = event.dataTransfer.getData('text');
//    }
    var character = String.fromCharCode(code);
    var regInput = new RegExp(regText);
    if (type == "input") {
        if (regInput.test(character)) {
            if (document.all) {
                window.event.returnValue = false;
            }
            else {
                arguments.callee.caller.arguments[0].preventDefault();
            }
        }
    }
    var regAll = new RegExp(regText,'g');
    if( type == "inputup"){
    	if(regAll.test(el.value)){
    		pos--;
    		el.value = el.value.replace(regAll,'');
    	}
    }
    
    if( type == "paste"){
    	if (window.clipboardData){
    		if(txt.test(code)){
    			window.event.returnValue = false;
        	}
    	} else {
    		el.value = el.value.replace(regAll,'');
    	}
    }
    //禁止拖入文本
    if(type == "drop"){
    	event.returnValue = false;
    }
    
    setCursorPos(el,pos);
}

function getCursorPos(obj) 
{
	if(document.selection){
		obj.focus();
		var currentRange = document.selection.createRange();
		
		var workRange=currentRange.duplicate();
		obj.select();
		var allRange=document.selection.createRange();
		var pos=0;
		while(workRange.compareEndPoints("StartToStart",allRange)>0)
		{
			workRange.moveStart("character",-1);
			pos++;
		}
		currentRange.select();
		return pos;
	}else if(window.getSelection()){
		return obj.selectionStart;
	}
}
function setCursorPos(obj,pos)
{
	if(document.selection){
		var rng =obj.createTextRange();
		rng.moveStart('character',pos);
		rng.collapse(true);
		rng.select();
	}else if(window.getSelection()){
		obj.selectionStart = pos;
		obj.selectionEnd = pos;
	}
}

function startLoad(container){
	var loadId = 'loadMask';
	
	var loadMask = container.find('#' + loadId); 
	if(loadMask.length == 0){
		loadMask = $('<div></div>');
		loadMask.attr('id',loadId);
		loadMask.addClass('load_mask');
		container.append(loadMask);
	}
	loadMask.css('display','block');
	container.css('overflow','hidden');
}

function endLoad(container){
	var loadId = 'loadMask';
	var loadMask = container.find('#' + loadId);
	if(loadMask.length == 0){
		return;
	}
	loadMask.css('display','none');
	container.css('overflow','initial');
}

function isIe6(){
	return browser.msie && browser.version == "6.0";
}

function functionExcute(func,time){
	if(isIe6()){
		var t = 1;
		if(time){
			t = time;
		}
		setTimeout(function(){
			func();
		},t);
	}else{
		func();
	}
}


function hideAllSelect(){
	var t=document.getElementsByTagName("select");
	for (var i=0;i<t.length ;i++ )
	{
		t[i].style.visibility="hidden";
	}
}

function showAllSelect(){
	var t=document.getElementsByTagName("select");
	for (var i=0;i<t.length ;i++ )
	{
		t[i].style.visibility="visible";
	}
}

function isMobile(){
	return os.is(os.names.ios) || os.is(os.names.android);
}

//写cookies
function setCookie(name,value)
{
	var Days = 30;
	var exp = new Date(); 
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
}
//读取cookies
function getCookie(name)
{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	
	if(arr=document.cookie.match(reg)){ 
		return unescape(arr[2]);
	}
	else {
		return null;
	}
}
//删除cookies
function delCookie(name)
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=getCookie(name);
	if(cval!=null){ 
		document.cookie= name + "="+cval+";expires="+exp.toGMTString();
	}
}

//针对旧版浏览器没有console.log方法导致报错的处理
(function(host) {
	var hasConsole = function(){
		return window.console && window.console.log;
	};
	
	var console;
	if(!hasConsole()){
		console = {
			log:function(obj){
				//emptyFn 仅仅为了使调用console.log方法不报错，如果有需要，可以加上alert方法
				//alert(obj);
			}
		};
		window.console = console;
	}
})(window);
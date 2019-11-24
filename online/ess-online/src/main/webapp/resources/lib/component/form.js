+function($){
	
	/**
	 * 增加额外的jquery方法，表单触发验证，验证通过后直接提交表单，不需要再次点击按钮
	 * callback  回调方法： 	a) 方法未定义，则默认在验证通过后提交表单
	 * 							   		b) 方法已定义，则验证通过后执行callback，后续代码在callback中执行
	 */
	$.fn.validSubmit = function(callback){
		this.each(function(){
			var $this = $(this);
			
			if(callback){
				$this.trigger('validate').isValid(callback);
			}else{
				$this.trigger('validate').isValid(function(v){
					if(v){
						$this.submit();
					}
				});
			}
		});
	};
	
}(jQuery);

+function($){
	var Sms = function(element,options){
		this.$element 	= $(element);
		this.options 	= options;
		this.sending 	= false;
		this.seed 		= -1;
		this.step 		= this.options.resend;
	};
	
	Sms.DEFAULTS = {
		resend 		: 60	,
		initStr 		: '点击发送验证码',
		sendingStr	: '%s秒后再次发送'
	};
	
	Sms.prototype.send = function(argument){
		if(this.sending){
			return;
		}
		
		this.sending = true;
		this.disable(true);
		var that = this;
		var dtd = argument.dtd;
		var success = argument.success;
		var fail = argument.fail;
		dtd.done(function(data){
			that.seed = setInterval(function(){
				that.step -- ;
				
				var text = that.options.sendingStr.replace('%s',that.step);
				that.setText(text);
				
				if(that.step < 0){
					that.reset();
				}
			},1000);
			
			if(success){
				success(data);
			}
		});
		dtd.fail(function(){
			if(fail){
				fail();
			}
		});
	};
	
	Sms.prototype.reset = function(){
		clearInterval(this.seed);
		
		this.sending 	= false;
		this.seed 		= -1;
		this.step 		= this.options.resend;
		this.disable(false);
		
		this.setText(this.options.initStr);
	};
	
	Sms.prototype.disable = function(disable){
		if(disable){
			this.$element.css('cursor','default');
			this.$element.attr('disabled' , 'disabled');
		}else{
			this.$element.css('cursor','pointer');
			this.$element.removeAttr('disabled');
		}
	};
	
	Sms.prototype.setText = function(text){
		if(this.$element.is('input')){
			this.$element.val(text);
		}else{
			this.$element.text(text);
		}
	};
	
	$.fn.smsSend = function(option,sendarg){
		this.each(function(){
			var $this = $(this);
			
			var data = $this.data('sms');
			
			var options = $.extend({},Sms.DEFAULTS, typeof option == 'object' && option);
			
			if (!data){
				$this.data('sms', (data = new Sms(this, options)));
			}
			
			if (typeof option == 'string') {
				data[option]();
			} else{
				data.send(sendarg);
			}
		});
	};
	
}(jQuery);

/**
 * 定义表单对象(可能是表单，也可能只是一个字段集合)
 */
var Form = function($form){
	if($form){
		this.initForm($form);
	}
};

/**
 * 根据传入的form初始化对象
 * @param $form 
 */
Form.prototype.initForm = function($form){
	var that = this;
	$form.find('input,select').each(function(){
		if(this.type === 'file' || this.type === 'button'){
			return;	
		}
		
		var name = this.name.split('.').pop();
		
		if(name == ""){
			return;
		}
		that.addParam(new Param(name,$(this)));
	});
};

/**
 * 添加表单字段 
 * @param param  字段对象
 */
Form.prototype.addParam = function(param){
	this[param.name] = param;
};

/**
 * 清空表单填写的内容
 */
Form.prototype.clearForm = function(){
	this.loopParam(function(value , index){
		value.set('');
	});
};

/**
 * 从数据对象填充到表单
 * @param data  数据对象
 */
Form.prototype.fillForm = function(data,trans){
	if(typeof data == 'undefined'){
		return;
	}
	this.loopParam(function(el , index){
		
		var i = index;
		
		if(trans && trans[index]){
			
			if(typeof trans[index] == 'string'){
				i = trans[index];
			}else if(typeof trans[index] == 'object'){
				i = trans[index].name;
				data[i] = trans[index].parse(data[i]);
			}
		}
		
		if(typeof data[i] != 'undefined'){
			el.set(data[i]);
		}
	});
};

/**
 * 表单提交
 */
Form.prototype.submit = function(){
	var el = null ,form = null;
	for(var i in this){
		el = this[i];
		if(this.isParam(el)){
			break;
		}
	}
	if(el){
		form = el.getForm();
	}
	
	if(form){
		form.submit();
	}
};

Form.prototype.loopParam = function(callback){
	for(var i in this){
		if(this.hasOwnProperty(i)){
			if(callback){
				callback(this[i],i);
			}
		}
	}
};

/**
 * 判断是否为字段
 * @param el		form对象属性
 */
Form.prototype.isParam = function(el){
	 return (typeof el == 'object') && el.objectName && el.objectName == "param";
};

/**
 * 将form对象解析为数据对象
 * @param extra 额外参数
 * @returns 数据对象
 */
Form.prototype.parse = function(extra){
	var data = {};
	this.loopParam(function(el , name){
		data[name] = el.get();
	});
	if(extra){
		data = $.extend({}, extra ,data);
	}
	
	return data;
};

/**
 * 定义参数对象
 */

var Param = function(name,$input){
	this.name = name;
	this.input = $input;
	this.objectName = 'param';
};

/**
 * 给对象字段对应的输入区域赋值
 */
Param.prototype.set = function(value){
	if(this.input.data($.formUtil.comName)){
		this.input.data($.formUtil.comName).set(value);
	}else{
		if(this.input.is('select') && value == ''){
			this.input[0].selectedIndex = 0;
		}else{
			this.input.val(value);
		}
	}
	//触发验证
	this.validate();
	this.input.trigger('change.param.set');
};

/**
 * 给清空对象字段对应的输入区域
 */
Param.prototype.reset = function(){
	this.set('');
};

/**
 * select字段默认赋值
 */
Param.prototype.initValue = function(){
	return this.input.attr('initalvalue');
};

/**
 * 对象字段对应的输入区域取值
 */
Param.prototype.get = function(){
	if(this.input.data($.formUtil.comName)){
		return this.input.data($.formUtil.comName).get();
	}else{
		return this.input.val();
	}
};

/**
 * 获取对象字段对应的输入区域id
 */
Param.prototype.getId = function(){
	return this.input.attr('id');
};

/**
 * 禁用对象变量对应的输入区域
 * 
 * 禁用之后将不会提交该字段
 */
Param.prototype.disable = function(disable){
	if(this.input.data($.formUtil.comName)){
		this.input.data($.formUtil.comName).disable(disable);
	}else{
		if(disable){
			this.input.attr('disabled','disabled');
			this.input.addClass('disabled');
		}else{
			this.input.removeAttr('disabled');
			this.input.removeClass('disabled');
		}
	}
};
/**
 * 只读对象字段对应的输入区域
 */
Param.prototype.readonly = function(readonly){
	var com = this.input.data($.formUtil.comName);
	
	if(com){
		com.readonly(readonly);
	}else{
		var readAttr = 'readonly';
		if(this.input.is('select')){
			readAttr = 'disabled';
		}
		if(readonly){
			this.input.attr(readAttr,readAttr);
			this.input.addClass(readAttr);
		}else{
			this.input.removeAttr(readAttr);
			this.input.removeClass(readAttr);
		}
	}
};

/**
 * 定位焦点到对象字段对应的输入区域
 */
Param.prototype.focus = function(){
	if(this.input.data($.formUtil.comName)){
		this.input.data($.formUtil.comName).focus(val);
	}else{
		if(this.input.attr('disabled') == undefined && this.input.attr('readonly') == undefined){
			if(this.input[0].type != 'hidden'){
				this.input.focus();
			}
		}	
	}
};

/**
 * 隐藏对象字段对应的输入区域
 */
Param.prototype.hide = function(){
	this.getParent().addClass('hide');
};

/**
 * 显示对象字段对应的输入区域
 */
Param.prototype.show = function(){
	this.getParent().removeClass('hide');
};

/**
 * 获取对象字段对应的输入区域外框
 */
Param.prototype.getParent = function(){
	return this.input.parents('.form-col');
};

/**
 * 触发对象字段对应的输入区域校验方法
 */
Param.prototype.validate = function(){
	if(!this.ignore){
		this.input.trigger("validate");
	}
};

/**
 * 对象字段是否校验通过
 */
Param.prototype.isValid = function(){
	return this.input.isValid();
};

/**
 * 对象字段校验消息隐藏
 */
Param.prototype.hideMsg = function(){
	this.getForm().validator( "hideMsg", this.input);
	this.input.removeClass('error');
};

/**
 * 对象字段是否校验通过
 */
Param.prototype.setIgnore = function(ignore){
	this.ignore = ignore;
	this.input[ignore ? 'addClass':'removeClass']('ignore');
};

/**
 * 为字段绑定事件
 */
Param.prototype.bind = function(event,func){
	this.input.on(event,func);
};
/**
 * 为字段触发绑定的事件
 */
Param.prototype.trigger = function(event){
	this.input.trigger(event);
};
/**
 * select获取选中文字
 */
Param.prototype.getText = function(){
	if(this.input.is('select')){
		return this.input.find("option:selected").text();
	}else{
		return this.val();
	}
};

Param.prototype.getForm = function(){
	return this.input.parents('form');
};

/**
 * 更新select
 */
Param.prototype.update = function(opts,pleaseChoose,chooseName){
	if(this.input.is('select')){
		this.input.empty();
		
		var html = '';
		
		if(!chooseName){
			chooseName = '请选择';
		}
		
		if(pleaseChoose){
			html += '<option value="">'+chooseName+'</option>';
		}
		
		for(var i = 0 ; i < opts.length ; i++){
			html += '<option value="'+opts[i].value+'">'+opts[i].name+'</option>';
		}
		
		this.input.html(html);
	}
};

/**
 * 该字段是否为必填
 */
Param.prototype.isRequired = function(){
	return this.input.attr('mustinput') === 'true'; 
};

/**
 * 为该字段安装插件
 * plugin : 插件名
 * conf : 插件配置
 */
Param.prototype.setup = function(plugin,conf){
	if($.fn[plugin]){
		this.input[plugin](conf);
	}
};

/*通用方法*/

+function($){
	$.formUtil = $.formUtil || {
		version: '1.0.1',
		comName : 'formComponent',
		/**
		 * 拼接参数
		 */
		joinName : function(){
			var name = '';
			for(var i = 0 ; i < arguments.length ; i++){
				name += arguments[i];
				if(i < arguments.length - 1){
					name += '_';
				}
			}
			return name;
		},
		joinArrayName : function(role,name,index){
			return role + '[' + index + '].'+name;
		}
	};
}(jQuery);

/*字段增强插件定义*/

+function($){
	
	/**
	 * 性别选择增强
	 * 
	 * 在多个相同角色存在时，由于radio name 相同导致多个角色的性别选择互斥
	 * 
	 * 额外增加了一个input[type="text"]用于保存性别值以及表单提交
	 * 
	 * 通过该控件在radio和input之间建立联系。
	 * */
	
	function Gender(input ,conf){
		var self = this,
			radio = input.parent().find('input:radio');
		
		var role = radio[0].name.split('_')[0];
		
		radio.attr('name',$.formUtil.joinName(role,'gender',radio_index));
		
		radio_index ++ ;
		
		radio.next('label').click(function(){
			var ra = $(this).prev('input:radio');
			ra.attr('checked','checked');
			input.val(ra.val());
		});
		radio.click(function(){
			input.val($(this).val());
			input.blur();
		});

		function focus(){
			var sexy = radio;
			document.body.scrollTop = (sexy.position().top-20);
			document.documentElement.scrollTop = (sexy.position().top-20); 
		}
		
		input.hide();
		
		$.extend(self, {  
			getInput: function(){
				return input;	
			},
			get: function(){
				return input.val();
			},
			set: function(value){
				if(value){
					for(var i = 0 ; i< radio.length ; i++){
						if(radio[i].value == value){
							radio.eq(i).attr('checked','checked');
						}
					}
					input.val(value);
				}else{
					radio.removeAttr('checked');
					input.val('');
				}
				input.blur();
			},
			focus:function(){
				focus();
			},
			disable: function(disable){
				if(disable){
					radio.attr('disabled','disabled');
				}else{
					radio.removeAttr('disabled');
				}
			}
		});
	}
	
	$.fn.gender = function(conf) {
		// already installed
		if (this.data($.formUtil.comName)) { return this; } 
		// extend configuration with globals
		conf = $.extend(true, {}, {debug:false}, conf);		
		
		var els = [];
		
		this.each(function() {				
			var el = new Gender($(this), $.extend(true, {}, conf));		 
			el.getInput().data($.formUtil.comName, el);
			els.push(el);	
		});		
		
		return els; 	
	};
}(jQuery);

+function($){
	
	/**
	 * 生日选择控件
	 * 
	 * */
	var Birthday = function(input ,options){
		this.$element = $(input);
		this.options = options;
		this.disabled = false;
		
		
		var that = this;
		
		this.$element.on('click',function(){
			if(that.disabled){
				return;
			}
			WdatePicker({
				minDate:that.options.min, 
	  			maxDate:that.options.max,
	  			onpicked:function(){
	  				that.$element.trigger("validate");
	  			}
	  		});
		});
	};
	
	Birthday.prototype.get = function(){
		return this.$element.val();
	};
	Birthday.prototype.set = function(value){
		this.$element.val(value);
	};
	Birthday.prototype.focus = function(){
		this.$element.focus();
	};
	Birthday.prototype.disable = function(disabled){
		this.disabled = disabled;
		
		if(disabled){
			this.$element.attr('disabled','disabled');
			this.$element.addClass('disabled');
		}else{
			this.$element.removeAttr('disabled');
			this.$element.removeClass('disabled');
		}
	};
	Birthday.prototype.readonly = function(readonly){
		this.disabled = readonly;
	};
	
	$.fn.birthday = function(option) {
		return this.each(function() {
			var $this = $(this);
			var data = $this.data($.formUtil.comName);
			var options = $.extend({}, {debug:false} ,typeof option == 'object' && option);

			if (!data){
				$this.data($.formUtil.comName, (data = new Birthday(this, options)));
			}
			
			if (typeof option == 'string') {
				data[option]();
			}
		});
	};
}(jQuery);
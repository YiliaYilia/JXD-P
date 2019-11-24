
(function($) {
	$.fn.extend({
		/**
		 * 将表单数据转换为obj
		 * ,如果有重复name,value值以逗号分隔
		 * @returns 表单域值的Object
		 */
		serializeObject : function() {
			if (this.length > 1) {
				return false;
			}
			var arr = this.serializeArray();
			var obj = new Object();
			$.each(arr, function(k, v) {
				if(obj.hasOwnProperty(v.name)&&obj[v.name]!=null&&obj[v.name]!=""){
					obj[v.name] = obj[v.name]+","+v.value;
				}else{
					obj[v.name] = v.value;
				}
			});
			return obj;
		},
		/**
		 * 将表单数据转换为json
		 * @returns
		 */
		form2json : function() {
			return JSON.stringify(this.serializeObject());
		}
	});
})(jQuery);
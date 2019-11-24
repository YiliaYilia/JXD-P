$(function(){
				$.extend($.fn.tree.methods,{
					getCheckedExt: function(jq){
						var checked = $(jq).tree("getChecked");                     //获取选中的选项 也就是打钩的 
//						var checkbox2 = $(jq).find("span.tree-checkbox2").parent(); //获取实心的选项 也就是实心方块的 
//						$.each(checkbox2,function(){
//							var node = $.extend({}, $.data(this, "tree-node"), {
//								target : this
//							});
//							checked.push(node);
//						});
						return checked;
					}
				});
})
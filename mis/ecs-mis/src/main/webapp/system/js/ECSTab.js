var ECSTab = function(){};
ECSTab.prototype.reload = false;

CreateTab = function(title,id,url){
	var tab  = new ECSTab();
	tab.reload = true;
	tab.addTab(title, id, url);
}
/**
 * 选择菜单树，添加tab页
 * @param title
 * @param id
 * @param url
 */
ECSTab.prototype.addTab = function(title,id,url){
	var exists = $("#mainTab").tabs('exists',title);
	
	if(!exists){
		$("#mainTab").tabs('add',{
			id:id,
			title:title,
			content:'<iframe id="'+title+'" src="'+url+'" width="100%" height="99%" align="top" scrolling="auto" frameborder="0"></iframe>',
			closable:true,
			onBeforeOpen:function(){
				//ajaxLoading();
			}
		});
		$("#"+title).load(function(){ 
			//ajaxLoadEnd();
	    }); 
	}
	else{
		var tab = $("#mainTab").tabs('getTab',title);
		this.updateTab(url, tab,title);
		$("#"+title).load(function(){ 
			//ajaxLoadEnd();
	    }); 
		$("#mainTab").tabs('select',title);
	}
}


ECSTab.prototype.updateTab=function(url,tab,title) {
    /*$("#mainTab").tabs('update', {
        tab: tab,
        options: {
          href: url
        }
    });*/
	if(this.reload){
		 tab.panel('refresh');
		 $("#"+title).attr("src",url);
	}
	else{
		 tab.panel('refresh');
	}
    
}

ECSTab.prototype.flushTab=function(){
	var tab = $('#mainTab').tabs('getSelected');
	 tab.panel('refresh');
}



function ajaxLoading(){
    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
    $("<div class=\"datagrid-mask-msg\">数据加载中...</div>").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true)) / 2,top:($(window).height()) / 2});
 }
 function ajaxLoadEnd(){
     $(".datagrid-mask").remove();
     $(".datagrid-mask-msg").remove();            
}

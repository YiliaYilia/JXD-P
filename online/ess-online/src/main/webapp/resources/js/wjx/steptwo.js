$(function () {
	function init() {
		var year=new Date().getFullYear();
		$(".date_input").mobiscroll().date({
			theme: theme,     
			mode: mode,      
			display: display, 
			lang: lang,   
			"height": 90,
			dateFormat:dateFormat,
			startYear:1900,
			endYear : year
		});
		
		
	}    
	var demo, theme, mode, display, lang,dateFormat,endtime;
		demo = 'date';
		theme = 'android',
		mode = 'scroller',
		display = 'modal',
		dateFormat= 'yy年mm月dd日',
		
		lang = 'zh';

		$('.demo-cont').hide();
		$("#demo_cont_" + demo).show();
		init();
});
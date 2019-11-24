$(document).ready(function(){
	$('#buyPAC').on('click',function(){
		$("#productcode").val('PAC');
		$("#from").submit();
	});
	
	$('#buyPAH').on('click',function(){
		$("#productcode").val('PAH');
		$("#from").submit();
	});
	
	$('#buyPAT').on('click',function(){
		$("#productcode").val('PAT');
		$("#from").submit();
	});
});
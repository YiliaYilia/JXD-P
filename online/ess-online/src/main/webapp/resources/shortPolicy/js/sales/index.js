$(document).ready(function(){
	$('#buyPAC').on('click',function(){
		$("#productcode").val('PAC');
		$("#from").submit();
	});
});
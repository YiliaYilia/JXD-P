$(document).ready(function(){
	$('#codeCCC').on('click',function(){
		checkCodeCCC() ;
	});
	$('#codeCDC').on('click',function(){
		checkCodeCDC() ;
	});
	$('#codeNBJ').on('click',function(){
		checkCodeNBJ() ;
	});
});

function checkCodeCCC(){
    $('#formCCC').submit();
}
function checkCodeCDC(){
	$('#formCDC').submit();
}
function checkCodeNBJ(){
	$('#formNBJ').submit();
}
 function isNumber(str) {
	 if ( /^(\+|-)?(0|[1-9]\d*)(\.\d*[1-9])?$/.test(str)) {
		 return   true;
	 } else {
		 return   false;
	 }
}
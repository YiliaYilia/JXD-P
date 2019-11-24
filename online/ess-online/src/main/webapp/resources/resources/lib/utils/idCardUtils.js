function IdCardUtils() {}
IdCardUtils.prototype = {
	isValidateCard : false,
	validateMessage : "",
	area : {11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"},
	CHINA_ID_MIN_LENGTH : 15,
    /** 中国公民身份证号码最大长度。 */
    CHINA_ID_MAX_LENGTH : 18
    
};
var area = {11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};
var twFirstCode = {};
var hkFirstCode = {};

/**
 * 身份证号码检查
 * 
 * @param idCard
 * @returns
 */
function validateCard(idCard){ 
	idCard = idCard.trim();
	var info= "" ;
	if((!/^\d{17}(\d|x)$/i.test(idCard)) && (!/^\d{14}(\d|x)$/i.test(idCard))) {
		return "请输入正确的证件号码";	
	}
	
	if(idCard.length == 15){
		idCard = conver15CardTo18(idCard);
	}
	
	if(idCard.length == 18){ 
		idCard=idCard.replace(/x$/i,"a"); 
		if(area[parseInt(idCard.substr(0,2))]== null) {
			return "您的身份证地区非法"; 
		}
		var birthDate_str = idCard.substr(6,4)+"-"+Number(idCard.substr(10,2))+"-"+Number(idCard.substr(12,2)); 
		var birthDate_date = new Date().parseDate(birthDate_str);
		if (birthDate_str != (birthDate_date.getFullYear() + "-"+ (birthDate_date.getMonth() + 1 ) + "-" + birthDate_date.getDate()))  {
			return "身份证的出生日期非法"; 
		}
		var iSum = 0 ;
		
		for(var i = 17; i>=0; i --) {
			iSum += (Math.pow(2,i) % 11) * parseInt(idCard.charAt(17 - i), 11) ;	
		}
		
		if (iSum % 11 != 1) {
			return "输入的身份证号非法";	
		}
		
		return "true"; 
	} else if(idCard.length == 15) {
		return "true";
	} else {
		return "输入的身份证号非法";
	}
} 

/**
 * 将15位身份证号码转换为18位
 * 
 * @param idCard
 *            15位身份编码
 * @return 18位身份编码
 */
function conver15CardTo18(idCard){
	if(idCard.length == 15){
    	var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
        var idCardTemp = 0, i;
        idCard = idCard.substr(0, 6) + '19' + idCard.substr(6, idCard.length - 6);
       	for(i = 0; i < 17; i ++){
       		idCardTemp += idCard.substr(i, 1) * arrInt[i];
        }
       	idCard += arrCh[idCardTemp % 11];
        return idCard;
     }
     return idCard;
}

/**
 * 返回有效生日
 * @param idCard
 * @return
 */
/*
function birthDateByIdCard(idCard) {
	 var id = String(idCard);
	 var birthday = null;
	 if (validateCard(id) == "true") {
		 if(id.length==15){
			 birthday = new Date(id.substr(6,2), id.substr(8,2) - 1, id.substr(10,2));
		 } else if(id.length==18){
			 birthday = new Date(id.slice(6,10), id.slice(10,12) - 1, id.slice(12,14));
		 }
	 }
	 return birthday;
}
*/

/**
 * 返回有效生日
 * @param idCard
 * @return
 */
function birthDateByIdCard(idCard) {
	 var id = String(idCard);
	 var birthday = null;
	 if (validateCard(id) == "true") {
		 if(id.length == 15){
			 birthday = new Date(id.substr(6,2), id.substr(8,2) - 1, id.substr(10,2));
		 } else if(id.length ==18){
			 birthday = new Date(id.slice(6,10), id.slice(10,12) - 1, id.slice(12,14));
		 }
	 }
	 return birthday;
}

/** 
 * 通过身份证判断是男是女 
 * @param idCard 15/18位身份证号码  
 * @return '1'-男、'2'-女、'3'-不详
 */ 
function genderByIdCard(idCard){  
    idCard = idCard.trim();// 对身份证号码做处理。去除头尾空格。
    var gender = "3";
    if (idCard.length == 15) {
        idCard = conver15CardTo18(idCard);
    }
    var sCardNum = idCard.substring(16, 17);
    if (parseInt(sCardNum) % 2 != 0) {
    	gender = "1";
    } else {
    	gender = "2";
    }
    return gender;
}
/*
*  全国二级城市联动 js版
*  与数据库表 ge_geographical_area 对应 修改省市时注意表中数据同步更新
*/
var dsy_area = new Dsy();
dsy_area.add("0",["北京市","上海市","重庆市","广东省","江苏省","浙江省","陕西省","湖北省"]);
dsy_area.add("0_0",["北京市"]);
dsy_area.add("0_1",["上海市"]);
dsy_area.add("0_2",["重庆市"]);
dsy_area.add("0_3",["广州市","深圳市","清远市","韶关市","河源市","梅州市","潮州市","汕头市","揭阳市","汕尾市","惠州市","东莞市","珠海市","中山市","江门市","佛山市","肇庆市","云浮市","阳江市","茂名市","湛江市"]);
dsy_area.add("0_4",["南京市","徐州市","连云港市","宿迁市","淮安市","盐城市","扬州市","泰州市","南通市","镇江市","常州市","无锡市","苏州市"]);
dsy_area.add("0_5",["杭州市","湖州市","嘉兴市","舟山市","绍兴市","衢州市","金华市","台州市","温州市","丽水市"]);
dsy_area.add("0_6",["西安市","延安市","铜川市","渭南市","咸阳市","宝鸡市","汉中市","榆林市","安康市","商洛市"]);
dsy_area.add("0_7",["武汉市","十堰市","襄樊市","荆门市","孝感市","黄冈市","鄂州市","黄石市","咸宁市","荆州市","宜昌市","随州市","恩施土家族苗族自治州"]);


//dsy.add("0",["北京市","天津市","上海市","重庆市","河北省","山西省","内蒙古自治区","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西壮族自治区","海南省","四川省","贵州省","云南省","西藏自治区","陕西省","甘肃省","青海省","宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区","台湾省"]);
//dsy.add("0_0",["北京市"]);
//dsy.add("0_1",["天津市"]);
//dsy.add("0_2",["上海市"]);
//dsy.add("0_3",["重庆市"]);
//dsy.add("0_4",["石家庄市","张家口市","承德市","秦皇岛市","唐山市","廊坊市","保定市","衡水市","沧州市","邢台市","邯郸市"]);
//dsy.add("0_5",["太原市","朔州市","大同市","阳泉市","长治市","晋城市","忻州市","晋中市","临汾市","吕梁市","运城市"]);
//dsy.add("0_6",["呼和浩特市","包头市","乌海市","赤峰市","通辽市","呼伦贝尔市","鄂尔多斯市","乌兰察布市","巴彦淖尔市","兴安盟","锡林郭勒盟","阿拉善盟"]);
//dsy.add("0_7",["沈阳市","朝阳市","阜新市","铁岭市","抚顺市","本溪市","辽阳市","鞍山市","丹东市","大连市","营口市","盘锦市","锦州市","葫芦岛市"]);
//dsy.add("0_8",["长春市","白城市","松原市","吉林市","四平市","辽源市","通化市","白山市","延边州"]);
//dsy.add("0_9",["哈尔滨市","齐齐哈尔市","七台河市","黑河市","大庆市","鹤岗市","伊春市","佳木斯市","双鸭山市","鸡西市","牡丹江市","绥化市","大兴安岭地区"]);
//dsy.add("0_10",["南京市","徐州市","连云港市","宿迁市","淮安市","盐城市","扬州市","泰州市","南通市","镇江市","常州市","无锡市","苏州市"]);
//dsy.add("0_11",["杭州市","湖州市","嘉兴市","舟山市","宁波市","绍兴市","衢州市","金华市","台州市","温州市","丽水市"]);
//dsy.add("0_12",["合肥市","宿州市","淮北市","亳州市","阜阳市","蚌埠市","淮南市","滁州市","马鞍山市","芜湖市","铜陵市","安庆市","黄山市","六安市","巢湖市","池州市","宣城市"]);
//dsy.add("0_13",["福州市","南平市","莆田市","三明市","泉州市","厦门市","漳州市","龙岩市","宁德市"]);
//dsy.add("0_14",["南昌市","九江市","景德镇市","鹰潭市","新余市","萍乡市","赣州市","上饶市","抚州市","宜春市","吉安市"]);
//dsy.add("0_15",["济南市","青岛市","聊城市","德州市","东营市","淄博市","潍坊市","烟台市","威海市","日照市","临沂市","枣庄市","济宁市","泰安市","莱芜市","滨州市","菏泽市"]);
//dsy.add("0_16",["郑州市","开封市","三门峡市","洛阳市","焦作市","新乡市","鹤壁市","安阳市","濮阳市","商丘市","许昌市","漯河市","平顶山市","南阳市","信阳市","周口市","驻马店市"]);
//dsy.add("0_17",["武汉市","十堰市","襄樊市","荆门市","孝感市","黄冈市","鄂州市","黄石市","咸宁市","荆州市","宜昌市","随州市","恩施州"]);
//dsy.add("0_18",["长沙市","张家界市","常德市","益阳市","岳阳市","株洲市","湘潭市","衡阳市","郴州市","永州市","邵阳市","怀化市","娄底市","湘西州"]);
//dsy.add("0_19",["广州市","深圳市","清远市","韶关市","河源市","梅州市","潮州市","汕头市","揭阳市","汕尾市","惠州市","东莞市","珠海市","中山市","江门市","佛山市","肇庆市","云浮市","阳江市","茂名市","湛江市"]);
//dsy.add("0_20",["南宁市","桂林市","柳州市","梧州市","贵港市","玉林市","钦州市","北海市","防城港市","崇左市","百色市","河池市","来宾市","贺州市"]);
//dsy.add("0_21",["海口市","三亚市","万宁市"]);
//dsy.add("0_22",["成都市","广元市","绵阳市","德阳市","南充市","广安市","遂宁市","内江市","乐山市","自贡市","泸州市","宜宾市","攀枝花市","巴中市","达州市","资阳市","眉山市","雅安市","阿坝州","甘孜州","凉山州"]);
//dsy.add("0_23",["贵阳市","六盘水市","遵义市","安顺市","毕节地区","铜仁地区","黔东南","黔南","黔西南"]);
//dsy.add("0_24",["昆明市","曲靖市","玉溪市","保山市","昭通市","丽江市","临沧市","普洱市","德宏州","怒江州","迪庆州","大理州","楚雄州","红河州","文山州","西双版纳州"]);
//dsy.add("0_25",["拉萨市","那曲地区","昌都地区","林芝地区","山南地区","日喀则地区","阿里地区"]);
//dsy.add("0_26",["西安市","延安市","铜川市","渭南市","咸阳市","宝鸡市","汉中市","榆林市","安康市","商洛市"]);
//dsy.add("0_27",["兰州市","嘉峪关市","白银市","天水市","金昌市","武威市","酒泉市","张掖市","庆阳市","平凉市","定西市","陇南市","临夏州","甘南州"]);
//dsy.add("0_28",["西宁市","海东地区","海北州","海南州","黄南州","果洛州","玉树州","海西州"]);
//dsy.add("0_29",["银川市","石嘴山市","吴忠市","固原市","中卫市"]);
//dsy.add("0_30",["乌鲁木齐市","克拉玛依市","喀什地区","阿克苏地区","和田地区","吐鲁番地区","哈密地区","克孜勒苏州","博尔塔拉州","昌吉州","巴音郭楞州","伊犁州","塔城地区","阿勒泰地区"]);
//dsy.add("0_31",["香港"]);
//dsy.add("0_32",["澳门"]);
//dsy.add("0_33",["台北市","高雄市","台中市","基隆市","嘉义市","台南市","新竹市"]);
 
var s_area=["applicantInsured_province","applicantInsured_city"];
var recognizee_s=["recognizee_province","recognizee_city"];
var lCBnf_area=["lCBnf_province","lCBnf_city"];
var lCBnf2_area=["lCBnf2_province","lCBnf2_city"];
var lCBnf3_area=["lCBnf3_province","lCBnf3_city"];

var opt0_area = ["省/市","市/区"];//初始值

function init_area(){ //初始化函数
	for(i=0;i<s_area.length-1;i++){
		document.getElementById(s_area[i]).onchange=new Function("change_area("+(i+1)+")");
	}
	change_area(0);
  
	
	for(i=0;i<lCBnf_area.length-1;i++){
		document.getElementById(lCBnf_area[i]).onchange=new Function("lCBnf_change("+(i+1)+")");
	}
	lCBnf_change(0);
	
	for(i=0;i<lCBnf2_area.length-1;i++){
		document.getElementById(lCBnf2_area[i]).onchange=new Function("lCBnf2_change("+(i+1)+")");
	}
	lCBnf2_change(0);
	
	for(i=0;i<lCBnf3_area.length-1;i++){
		document.getElementById(lCBnf3_area[i]).onchange=new Function("lCBnf3_change("+(i+1)+")");
	}
	lCBnf3_change(0);
	if(recognizeeAge<18){
		for(i=0;i<recognizee_s.length-1;i++){
		document.getElementById(recognizee_s[i]).onchange=new Function("recognizee_change("+(i+1)+")");
		}
	recognizee_change(0);
	}

}

function init_recArea(){
	for(i=0;i<recognizee_s.length-1;i++){
		document.getElementById(recognizee_s[i]).onchange=new Function("recognizee_change("+(i+1)+")");
		}
	recognizee_change(0);
}

function lCBnf2_change(v){
	var str="0";
	for(i=0;i<v;i++){
		str+=("_"+(document.getElementById(lCBnf2_area[i]).selectedIndex-1));
	};
	var ss=document.getElementById(lCBnf2_area[v]);
	with(ss){
		length = 0;
		options[0]=new Option(opt0_area[v],opt0_area[v]);
		if(v && document.getElementById(lCBnf2_area[v-1]).selectedIndex>0 || !v){
			if(dsy_area.Exists(str)){
				ar = dsy_area.Items[str];
				for(i=0;i<ar.length;i++){
					options[length]=new Option(ar[i],ar[i]);
				}//end for
				if(v){ options[0].selected = true; 
        			$('#lCBnf2_city option[value="市/区"]').remove(); 
				}
			}
		}//end if v
		if(++v<lCBnf2_area.length){lCBnf2_change(v);}
	}//End with
}

function lCBnf3_change(v){
	var str="0";
	for(i=0;i<v;i++){
		str+=("_"+(document.getElementById(lCBnf3_area[i]).selectedIndex-1));
	};
	var ss=document.getElementById(lCBnf3_area[v]);
	with(ss){
		length = 0;
		options[0]=new Option(opt0_area[v],opt0_area[v]);
		if(v && document.getElementById(lCBnf3_area[v-1]).selectedIndex>0 || !v){
			if(dsy_area.Exists(str)){
				ar = dsy_area.Items[str];
				for(i=0;i<ar.length;i++){
					options[length]=new Option(ar[i],ar[i]);
				}//end for
				if(v){ options[0].selected = true; 
        			$('#lCBnf3_city option[value="市/区"]').remove(); 
				}
			}
		}//end if v
		if(++v<lCBnf3_area.length){lCBnf3_change(v);}
	}//End with
}

function lCBnf_change(v){
	var str="0";
	for(i=0;i<v;i++){
		str+=("_"+(document.getElementById(lCBnf_area[i]).selectedIndex-1));
	};
	var ss=document.getElementById(lCBnf_area[v]);
	with(ss){
		length = 0;
		options[0]=new Option(opt0_area[v],opt0_area[v]);
		if(v && document.getElementById(lCBnf_area[v-1]).selectedIndex>0 || !v){
			if(dsy_area.Exists(str)){
				ar = dsy_area.Items[str];
				for(i=0;i<ar.length;i++){
					options[length]=new Option(ar[i],ar[i]);
				}//end for
				if(v){ options[0].selected = true; 
        			$('#lCBnf_city option[value="市/区"]').remove(); 
				}
			}
		}//end if v
		if(++v<lCBnf_area.length){lCBnf_change(v);}
	}//End with
}


function change_area(v){
	var str="0";
	for(i=0;i<v;i++){
		str+=("_"+(document.getElementById(s_area[i]).selectedIndex-1));
	};
	var ss=document.getElementById(s_area[v]);
	with(ss){
		length = 0;
		options[0]=new Option(opt0_area[v],opt0_area[v]);
		if(v && document.getElementById(s_area[v-1]).selectedIndex>0 || !v){
			if(dsy_area.Exists(str)){
				ar = dsy_area.Items[str];
				for(i=0;i<ar.length;i++){
					options[length]=new Option(ar[i],ar[i]);
				}//end for
				if(v){ options[0].selected = true; 
        			$('#applicantInsured_city option[value="市/区"]').remove(); 
				}
			}
		}//end if v
		if(++v<s_area.length){change_area(v);}
	}//End with
}

function recognizee_change(v){
	var str="0";
	for(i=0;i<v;i++){
		str+=("_"+(document.getElementById(recognizee_s[i]).selectedIndex-1));
	};
	var ss=document.getElementById(recognizee_s[v]);
	with(ss){
		length = 0;
		options[0]=new Option(opt0_area[v],opt0_area[v]);
		if(v && document.getElementById(recognizee_s[v-1]).selectedIndex>0 || !v){
			if(dsy_area.Exists(str)){
				ar = dsy_area.Items[str];
				for(i=0;i<ar.length;i++){
					options[length]=new Option(ar[i],ar[i]);
				}//end for
				if(v){ options[0].selected = true; 
        			$('#recognizee_city option[value="市/区"]').remove(); 
				}
			}
		}//end if v
		if(++v<recognizee_s.length){recognizee_change(v);}
	}//End with
}
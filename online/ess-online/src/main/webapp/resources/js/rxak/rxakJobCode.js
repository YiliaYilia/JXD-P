/*
*  二级职业联动 js版
*  与数据库表 ge_jobCode 对应 修改行业和职业时注意表中数据同步更新
*/

function Dsy(){
	this.Items = {};
}
Dsy.prototype.add = function(id,iArray){
	this.Items[id] = iArray;
}
Dsy.prototype.Exists = function(id){
	if(typeof(this.Items[id]) == "undefined") return false;
	return true;
}
var dsy = new Dsy();
dsy.add("0",["一般职业","家庭管理","其他","旅游业","旅馆业","餐饮业","一般商业","电影业,电视业","高尔夫球场","保龄球馆","球场","游泳池","海水浴场","游乐园(包括动物园)","艺术及学艺人员","娱乐场所","银行,保险,信托,租赁业","自由业","教育机构"]);
dsy.add("0_0",["内勤人员"]);
dsy.add("0_1",["家庭主妇","退休人员"]);
dsy.add("0_2",["待业人员","彩票销售人员"]);
dsy.add("0_3",["一般内勤人员","外务员及导游","旅游景点内的司机"]);
dsy.add("0_4",["经理人员","一般内勤人员","外务员","技工、修理工(非室外高空作业)","客房服务员","清洁工","锅炉工(全自动)"]);
dsy.add("0_5",["经理人员","一般内勤人员","柜台人员、收银员","收帐员","采购人员","厨师(宾馆)","点心师，配菜师","服务人员,领班","厨师(一般饭店酒楼)","厨师长(宾馆)"]);
dsy.add("0_6",["厨具店店员","陶器、瓷器店店员","古董店店员","花卉店店员","米店店员","杂货店店员","个体杂货商","玻璃店店员","国营菜场营业员(菜蛋类)","国营菜场营业员(鱼肉类)","个体果菜商","个体鱼肉商","石材店店员","建材店店员","钢铁材店店员","木材店店员","五金店店员","电器店店员(包括电脑销售)","水电卫生器材店店员","家具店店员","车行营业员(汽车、自行车、摩托车)","车辆器材店店员(不含矿物油)","矿物油店店员","眼镜店店员","眼镜店磨片人员","食品店店员","文具店店员","布店、服装店店员","个体服装商","珠宝店店员","珠宝店珠宝加工人员","当铺店工作人员","药店店员","化学原料店店员","医疗器械店店员","手工艺品店店员","煤气器具店负责人","煤气器具店店员","煤气器具店送货员","煤气器具店装设工","液化气零售店负责人","液化气零售店店员","液化气零售店送货员","液化气零售店液化气分装工","液化气零售店旧货收购人员","超市收银员","超市搬运工(中小型超市)","超市搬运工(大型仓储式超市)","送货员(一般商业)","送货员(建材、石材、钢材、五金或电器)","净水运送人员","旧货收购员"]);
dsy.add("0_7",["制片人","影片商","编剧","一般演员(导演)","配音演员","化妆师","场记","摄影工作人员","灯光及音响效果工作人员","冲片/洗片工作人员","电视记者","机械工/电工","布景搭设人员","电影院售票员","电影院放映及服务人员"]);
dsy.add("0_8",["教练","球场保养及维护工人","球童"]);
dsy.add("0_9",["计分员","柜台人员","机械修护工人","清洁工人"]);
dsy.add("0_10",["负责人","计分员"]);
dsy.add("0_11",["负责人","管理员","教练","售票员","救生员"]);
dsy.add("0_12",["负责人","管理员","售票员"]);
dsy.add("0_13",["负责人","售票员","电动玩具操作员","一般清洁工","兽栏清洁工","动物园兽医","水电机械工"]);
dsy.add("0_14",["作曲、编曲、演奏人员(非娱乐场所表演者)","娱乐场所签约演奏人员","绘画人员","舞蹈演员","艺术雕塑人员","戏剧人员","巡回演出戏剧团体人员","娱乐场所签约歌手","模特"]);
dsy.add("0_15",["咖啡厅工作人员","歌舞厅工作人员","酒吧工作人员","桑拿、温泉浴池工作人员","电子游戏、网吧、陶吧、茶厅工作人员","负责人","调音师","保安人员","桌球房接待人员","寄存处人员","收银员","职业按摩师"]);
dsy.add("0_16",["一般内勤人员","外务员","调查员","现金运送员、司机","收费、征信人员"]);
dsy.add("0_17",["律师"]);
dsy.add("0_18",["学生"]);

var applicantInsured_s=["applicantInsured_industry","applicantInsured_job"];
var recognizeeJob_s=["recognizee_industry","recognizee_job"];
var lCBnf_job=["lCBnf_industry","lCBnf_job"];
var lCBnf2_job=["lCBnf2_industry","lCBnf2_job"];
var lCBnf3_job=["lCBnf3_industry","lCBnf3_job"];

var opt0 = ["行业分类","职业类型"];//初始值
function init_job(){ //初始化函数
	for(i=0;i<applicantInsured_s.length-1;i++){
		document.getElementById(applicantInsured_s[i]).onchange=new Function("applicantInsured_change("+(i+1)+")");
	}
	applicantInsured_change(0);
  
	for(i=0;i<lCBnf_job.length-1;i++){
		document.getElementById(lCBnf_job[i]).onchange=new Function("lCBnfJob_change("+(i+1)+")");
	}
	lCBnfJob_change(0);
	
	for(i=0;i<lCBnf2_job.length-1;i++){
		document.getElementById(lCBnf2_job[i]).onchange=new Function("lCBnfJob2_change("+(i+1)+")");
	}
	lCBnfJob2_change(0);
	
	for(i=0;i<lCBnf3_job.length-1;i++){
		document.getElementById(lCBnf3_job[i]).onchange=new Function("lCBnfJob3_change("+(i+1)+")");
	}
	lCBnfJob3_change(0);
	if(recognizeeAge<18){
	for(i=0;i<recognizeeJob_s.length-1;i++){
		document.getElementById(recognizeeJob_s[i]).onchange=new Function("recognizee_job("+(i+1)+")");
	}
	recognizee_job(0);
	}
}




function lCBnfJob2_change(v){
	  var str="0";
	  for(i=0;i<v;i++){
	    str+=("_"+(document.getElementById(lCBnf2_job[i]).selectedIndex-1));
	  };
	  var ss=document.getElementById(lCBnf2_job[v]);
	  with(ss){
	    length = 0;
	    options[0]=new Option(opt0[v],opt0[v]);
	    if(v && document.getElementById(lCBnf2_job[v-1]).selectedIndex>0 || !v){
	      if(dsy.Exists(str)){
	        ar = dsy.Items[str];
	        for(i=0;i<ar.length;i++){
	          options[length]=new Option(ar[i],ar[i]);
	        }//end for
	        if(v){ options[0].selected = true; 
	        	$('#lCBnf2_job option[value="职业类型"]').remove(); 
	        }
	      }
	    }//end if v
	if(++v<lCBnf2_job.length){lCBnfJob2_change(v);}
}//End with
}

function lCBnfJob3_change(v){
	  var str="0";
	  for(i=0;i<v;i++){
	    str+=("_"+(document.getElementById(lCBnf3_job[i]).selectedIndex-1));
	  };
	  var ss=document.getElementById(lCBnf3_job[v]);
	  with(ss){
	    length = 0;
	    options[0]=new Option(opt0[v],opt0[v]);
	    if(v && document.getElementById(lCBnf3_job[v-1]).selectedIndex>0 || !v){
	      if(dsy.Exists(str)){
	        ar = dsy.Items[str];
	        for(i=0;i<ar.length;i++){
	          options[length]=new Option(ar[i],ar[i]);
	        }//end for
	        if(v){ options[0].selected = true; 
	        	$('#lCBnf3_job option[value="职业类型"]').remove(); 
	        }
	      }
	    }//end if v
	if(++v<lCBnf3_job.length){lCBnfJob3_change(v);}
}//End with
}


function lCBnfJob_change(v){
	  var str="0";
	  for(i=0;i<v;i++){
	    str+=("_"+(document.getElementById(lCBnf_job[i]).selectedIndex-1));
	  };
	  var ss=document.getElementById(lCBnf_job[v]);
	  with(ss){
	    length = 0;
	    options[0]=new Option(opt0[v],opt0[v]);
	    if(v && document.getElementById(lCBnf_job[v-1]).selectedIndex>0 || !v){
	      if(dsy.Exists(str)){
	        ar = dsy.Items[str];
	        for(i=0;i<ar.length;i++){
	          options[length]=new Option(ar[i],ar[i]);
	        }//end for
	        if(v){ options[0].selected = true; 
	        	$('#lCBnf_job option[value="职业类型"]').remove(); 
	        }
	      }
	    }//end if v
	if(++v<lCBnf_job.length){lCBnfJob_change(v);}
  }//End with
}




/**
 * 投保人职业
 */
function applicantInsured_change(v){
	  var str="0";
	  for(i=0;i<v;i++){
	    str+=("_"+(document.getElementById(applicantInsured_s[i]).selectedIndex-1));
	  };
	  var ss=document.getElementById(applicantInsured_s[v]);
	  with(ss){
	    length = 0;
	    options[0]=new Option(opt0[v],opt0[v]);
	    if(v && document.getElementById(applicantInsured_s[v-1]).selectedIndex>0 || !v){
	      if(dsy.Exists(str)){
	        ar = dsy.Items[str];
	        for(i=0;i<ar.length;i++){
	          options[length]=new Option(ar[i],ar[i]);
	        }//end for
	        if(v){ options[0].selected = true; 
	        	$('#applicantInsured_job option[value="职业类型"]').remove(); 
	        }
	      }
	    }//end if v
	if(++v<applicantInsured_s.length){applicantInsured_change(v);}
    }//End with
}

/**
 * 被保人职业
 */
function recognizee_job(v){
	  var str="0";
	  for(i=0;i<v;i++){
	    str+=("_"+(document.getElementById(recognizeeJob_s[i]).selectedIndex-1));
	  };
	  var ss=document.getElementById(recognizeeJob_s[v]);
	  with(ss){
	    length = 0;
	    options[0]=new Option(opt0[v],opt0[v]);
	    if(v && document.getElementById(recognizeeJob_s[v-1]).selectedIndex>0 || !v){
	      if(dsy.Exists(str)){
	        ar = dsy.Items[str];
	        for(i=0;i<ar.length;i++){
	          options[length]=new Option(ar[i],ar[i]);
	        }//end for
	        if(v){ options[0].selected = true; 
	        	$('#recognizee_job option[value="职业类型"]').remove(); 
	        }
	      }
	    }//end if v
	if(++v<recognizeeJob_s.length){recognizee_job(v);}
  }//End with
}
function open2(value){
	if(value==""||value=="undefind"){
		alert("无证件图片");
		return;
	}
	    var str = "";
		var msgw,msgh,bordercolor; 
			msgw=550;
			msgh=450;
			bordercolor="#ffffff";
		var sWidth,sHeight; 
			sWidth=2000;
			sHeight=2300;
		var bgObj=document.createElement("div");
			bgObj.setAttribute('id','bgDiv'); 
			bgObj.setAttribute('onclick','removeObj()'); 
			bgObj.style.position="absolute"; 
			bgObj.style.top="0"; 
			bgObj.style.background="#777"; 
			bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75"; 
			bgObj.style.opacity="0.6"; 
			bgObj.style.left="0"; 
			bgObj.style.width=sWidth + "px"; 
			bgObj.style.height=sHeight + "px"; 
			bgObj.style.zIndex = "10000"; 
			document.body.appendChild(bgObj);
		var msgObj=document.createElement("div") ;
			msgObj.setAttribute("id","msgDiv"); 
			msgObj.setAttribute("align","center"); 
			msgObj.style.background="white"; 
			msgObj.style.position = "fixed"; 
			msgObj.style.left = "35%"; 
			msgObj.style.top = "35%"; 
			msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif"; 
			msgObj.style.marginLeft = "-120px" ; 
			msgObj.style.marginTop = "-200px"; 
			msgObj.style.width = msgw + "px"; 
			msgObj.style.height = msgh + "px"; 
			msgObj.style.textAlign = "left"; 
			msgObj.style.zIndex = "10001"; 
		//	alert("<img src='"+value+"'/>");
			msgObj.innerHTML="<img style='width:100%;height:100%' src='"+value+"'/>";
			document.body.appendChild(msgObj);	
	}
 	function removeObj(){
 	   document.body.removeChild(document.getElementById("bgDiv"));
	   document.body.removeChild(document.getElementById("msgDiv"));
	}
 	
// 	$("bgDiv").click(function(){
// 		 document.body.removeChild(document.getElementById("bgDiv"));
// 		   document.body.removeChild(document.getElementById("msgDiv"));
// 		});
 	
 	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品基本信息</title>
	<script type="text/javascript" src="${ctx }/system/product/js/product.js"></script>
</head>
<body>
	<div id="productInfoConfigTab" class="easyui-tabs" data-options="fit:true,tabPosition:'left',headerWidth:100">   
	    <div title="基本信息" style="padding:20px;font-size: 13px;"> 
		    <form id="productBaseInfo" action="${ctx }/system/product/saveOrUpdateProductInfoConfig" autocomplete="off">
		    	<input type="hidden" name="geProductMain.coreproductcode" id="geProductMain.coreproductcode" value="${geProductMain.coreproductcode}" />
		    	<input type="hidden" name="geProductMain.productname"  value="${geProductMain.productname}" />
		    	<input type="hidden" name="geProductMain.coreproductsimplename"  value="${geProductMain.coreproductsimplename}" />
				<input type="hidden" name="geProductMain.businessarea" value="${geProductMain.businessarea}" />
				<input type="hidden" name="geProductMain.productstatus" value="${geProductMain.productstatus}" />
				<input type="hidden" name="geProductMain.productflow" value="${geProductMain.productflow}" />
				<input type="hidden" name="geProductMain.operatorname" value="${geProductMain.operatorname}" />
		    	
		    	<div style="width: 900px;">
		    		<fieldset>
					<legend>基本信息配置</legend>  
				        <table cellpadding="5" cellspacing="2">
				        	<tr>   
			      				<td align="right">
			      					产品代码:
			      				</td>
			      				<td>
			      					${geProductMain.coreproductcode}
			      				</td>
			      				<td>
			      				&nbsp;
			      				</td>
			       			</tr>
			       			<tr>
			       				<td align="right">
			       					产品全称:
			       				</td>
			       				<td>
			       					${geProductMain.productname}
			       				</td>
			       				<td>
			      				&nbsp;
			      				</td>
			       			</tr>
			       			<tr>
			       				<td align="right">
			       					产品简称:
			       				</td>
			       				<td>
			       					${geProductMain.coreproductsimplename}
			       				</td>
			       				<td>
			      				&nbsp;
			      				</td>
			       			</tr>
			       		<!-- 	
			       			<tr>
			       				<td align="right">
			       					纸质保单配置项:
			       				</td>
			       				<td>
			       					<select id="geProductMain.ispaper" name="geProductMain.ispaper">
										<option value="1" <c:if test="${geProductMain.ispaper eq '1'}">selected</c:if> >显示</option>
										<option value="0" <c:if test="${geProductMain.ispaper eq '0'}">selected</c:if> >不显示</option>
									</select>
			       				</td>
			       				<td>
			      				&nbsp;
			      				</td>
			       			</tr>
			       			<tr>
			       				<td align="right">
			       					是否显示发票:
			       				</td>
			       				<td>
			       					<select id="isinvoice" name="geProductMain.isinvoice">
										<option value="02" <c:if test="${geProductMain.isinvoice eq '02'}">selected</c:if> >显示</option>
										<option value="01" <c:if test="${geProductMain.isinvoice eq '01'}">selected</c:if> >不显示</option>
									</select>
			       				</td>
			       				<td>
			      				&nbsp;
			      				</td>
			       			</tr>
			       			<tr>
			       				<td align="right">
			       					是否限定同业保额:
			       				</td>
			       				<td>
			       					<select id="geProductMain.limitsameindinsuredamount" name="geProductMain.limitsameindinsuredamount" onchange="showContent(this,'1');" >
										<option value="1" <c:if test="${geProductMain.limitsameindinsuredamount eq '1'}">selected</c:if> >是</option>
										<option value="0" <c:if test="${geProductMain.limitsameindinsuredamount eq '0'}">selected</c:if> >否</option>
									</select>
			       				</td>
			       				<td id="geProductMain.limitsameindinsuredamount_extend">
			      					<span id="Islimitsameindinsuredamount">最大同业保额:
			      					<input type="text" style="width: 50px;" data-rule="required;integer[+];"  id="geProductMain.sameindinsuredamountmax" name="geProductMain.sameindinsuredamountmax" style="width:50px;" value="${geProductMain.sameindinsuredamountmax eq '' or geProductMain.sameindinsuredamountmax eq null ? '1' : geProductMain.sameindinsuredamountmax}">
			      					</span>(万元)
			      				</td>
			       			</tr>  -->
			       			<tr>
			       				<td align="right">
			       					紧急联系人标记:
			       				</td>
			       				<td>
			       					<select id="geProductMain.issupportemergency" name="geProductMain.issupportemergency">
										<option value="1" <c:if test="${geProductMain.issupportemergency eq '1'}">selected</c:if> >支持</option>
										<option value="0" <c:if test="${geProductMain.issupportemergency eq '0'}">selected</c:if> >不支持</option>
									</select>
			       				</td>
			       				<td>
			      				&nbsp;
			      				</td>
			       			</tr>
			       			<tr>
			       				<td align="right">
			       					受益人:
			       				</td>
			       				<td>
			       					<select id="geProductMain.issupportbeneficiary" name="geProductMain.issupportbeneficiary" onchange="showContent(this,'1')">
										<option value="0" <c:if test="${geProductMain.issupportbeneficiary eq '0'}">selected</c:if> >法定</option>
										<option value="1" <c:if test="${geProductMain.issupportbeneficiary eq '1'}">selected</c:if> >非法定</option>
									</select>
			       				</td>
			       				<td id="geProductMain.issupportbeneficiary_extend">
			      					<span>
			      						受益人(人数范围):
			      						<input type="text" style="width: 50px;" data-rule="required;integer[+];" onkeyup="this.value =this.value.replace(/[^\d]/g, '')" id="geProductMain.minbeneficiarynum" name="geProductMain.minbeneficiarynum" maxlength="20" value="${geProductMain.minbeneficiarynum }" style='width:50px;'>
										-
										<input type="text" style="width: 50px;" data-rule="required;integer[+];" onkeyup="this.value =this.value.replace(/[^\d]/g, '')" id="geProductMain.maxbeneficiarynum" name="geProductMain.maxbeneficiarynum" maxlength="20" value="${geProductMain.maxbeneficiarynum }" style='width:50px;'>
			      					</span>
			      				</td>
			       			</tr>
			       			<tr>
			       				<td align="right">
			       					是否支持连带被保人:
			       				</td>
			       				<td>
			       					<select  id="geProductMain.issupportpins" name="geProductMain.issupportpins" onchange="showContent(this,'1');" >
										<option value="1" <c:if test="${geProductMain.issupportpins eq '1'}">selected</c:if> >支持</option>
										<option value="0" <c:if test="${geProductMain.issupportpins eq '0'}">selected</c:if> >不支持</option>
									</select>
			       				</td>
			       				<td id="geProductMain.issupportpins_extend">
			      					<span>
			      						被保人(人数范围):
			      						<input type="text" data-rule="required;integer[+];" style="width: 50px;" onkeyup="this.value =this.value.replace(/[^\d]/g, '')" id="geProductMain.minpinsurednum" name="geProductMain.minpinsurednum" style="width:50px;" value="${geProductMain.minpinsurednum eq '' or geProductMain.minpinsurednum eq null ? '1' : geProductMain.minpinsurednum}">
			      						-
			      						<input type="text" data-rule="required;integer[+];" style="width: 50px;" onkeyup="this.value =this.value.replace(/[^\d]/g, '')" id="geProductMain.maxpinsurednum" name="geProductMain.maxpinsurednum" style="width:50px;" value="${geProductMain.maxpinsurednum eq '' or geProductMain.maxpinsurednum eq null ? '1' : geProductMain.maxpinsurednum}">
			      					</span>
			      				</td>
			       			</tr>
			       			<tr>
			       				<td align="right">
									缴费方式:
								</td>
			       				<td>
								<dict:checkbox type="checkbox" typeCode="PaymentWay" name="paytype" id="" defaultValue="${geProductMain.paytype}"></dict:checkbox>
								</td>
			       			</tr>
				        </table>
				       </fieldset>
				     </div>
		    </form>
	    </div>   
	    <div title="扩展信息"  style="overflow:auto;padding:20px;">   
	    	<table  id="periodDataDemo" style="display:none;">
	    		<tr id="periodTrDataDemo">
					<td>缴费年限:</td>
					<td>
						<input type="hidden" name="geProductMain.geProductExtends[%num].geProductMain.coreproductcode" value="${geProductMain.coreproductcode }">
						<input type="hidden" name="geProductMain.geProductExtends[%num].attributename"  value="缴费年限">
						<input type="hidden" name="geProductMain.geProductExtends[%num].attributetype" value="POLICYPERIOD">
						<input type="text" name="geProductMain.geProductExtends[%num].attributevalue"  data-rule="required;integer[+0];" style="width: 50px">
					</td>
					<td>单位:</td>
					<td>
						<dict:select typeCode="POLICYPERIOD" name="geProductMain.geProductExtends[%num].attributetypevalue" id="geProductMain.geProductExtends[%num].attributetypevalues"></dict:select>
						<input type="button"   />
					</td>
				</tr>
				
	    	</table>
	    	<table  id="periodDataDemo2" style="display:none;">
				
				<tr id="periodTrDataDemo2">
					<td>保险期间:</td>
					<td>
						<input type="hidden" name="geProductMain.geProductExtendsPeriods[%num].geProductMain.coreproductcode" value="${geProductMain.coreproductcode }">
						<input type="hidden" name="geProductMain.geProductExtendsPeriods[%num].attributename"  value="保险期间">
						<input type="hidden" name="geProductMain.geProductExtendsPeriods[%num].attributetype" value="INSURANCEPERIOD">
						<input type="text" name="geProductMain.geProductExtendsPeriods[%num].attributevalue"  data-rule="required;integer[+0];" style="width: 50px">
					</td>
					<td>单位:</td>
					<td>
						<dict:select typeCode="INSURANCEPERIOD" name="geProductMain.geProductExtendsPeriods[%num].attributetypevalue" id="geProductMain.geProductExtendsPeriods[%num].attributetypevalues"></dict:select>
						<input type="button"   />
					</td>
				</tr>
	    	</table>
	    	<form id="productExtendInfo" autocomplete="off" >
		    	<div>
		    		<table>
		    			<tr>
		    				<td valign="top">
		    					<div style="width: 400px;">
						    		<fieldset>
									<legend>缴费年限配置</legend> 
		            					<br>
		            					<table id="periodTable">
		            					<c:set var="peroidCount" value="0"></c:set>
		            					<c:forEach items="${peroidList}" var="peroid" step="1" varStatus="status">
											<tr id="peroidContentTr_${status.index}">
												<td>缴费年限:</td>
												<td>
													<input type="hidden" name="geProductMain.geProductExtends[${status.index}].geProductMain.coreproductcode" id="geProductMain.geProductExtends[${status.index}].geProductMain.coreproductcode" value="${geProductMain.coreproductcode }">
													<input type="hidden" name="geProductMain.geProductExtends[${status.index}].attributename" id="geProductMain.geProductExtends[${status.index}].attributename" value="缴费年限">
													<input type="hidden" name="geProductMain.geProductExtends[${status.index}].attributetype" id="geProductMain.geProductExtends[${status.index}].attributetype" value="POLICYPERIOD">
													<input type="text" name="geProductMain.geProductExtends[${status.index}].attributevalue" id="geProductMain.geProductExtends[${status.index}].attributevalue" value="${peroid.attributevalue}" style="width: 50px">
												</td>
												<td>单位:</td>
												<td>
													<dict:select typeCode="POLICYPERIOD" name="geProductMain.geProductExtends[%num].attributetypevalue" id="geProductMain.geProductExtends[%num].attributetypevalue" defaultValue="${peroid.attributetypevalue}"></dict:select>
													<input type="button" 
														<c:choose>
															<c:when test="${status.index==0 }"> 
																value="添加" onclick="addPeriod()"
															</c:when>
															<c:otherwise> value="删除" onclick="delPeriod('${status.index}')"
															</c:otherwise>						
														</c:choose>
													 />
												</td>
											</tr>
											<c:set var="peroidCount" value="${peroidCount+1 }"></c:set>
		            					</c:forEach>
										</table>
		            					<input type="hidden" id="peroidCount" value="${peroidCount }" />
									</fieldset>
								</div>
								
								<div style="width: 400px;">
						    		<fieldset>
									<legend>保险期间配置</legend> 
		            					<br>
		            					<table id="periodTable2">
		            					<c:set var="peroidCount2" value="0"></c:set>
		            					<c:forEach items="${peroidList2}" var="peroid2" step="1" varStatus="status2">
											<tr id="peroidContentTr2_${status2.index}">
												<td>保险期间:</td>
												<td>
													<input type="hidden" name="geProductMain.geProductExtendsPeriods[${status2.index}].geProductMain.coreproductcode" id="geProductMain.geProductExtendsPeriods[${status2.index}].geProductMain.coreproductcode" value="${geProductMain.coreproductcode }">
													<input type="hidden" name="geProductMain.geProductExtendsPeriods[${status2.index}].attributename" id="geProductMain.geProductExtends[${status2.index}].attributename" value="保险期间">
													<input type="hidden" name="geProductMain.geProductExtendsPeriods[${status2.index}].attributetype" id="geProductMain.geProductExtends[${status2.index}].attributetype" value="INSURANCEPERIOD">
													<input type="text" name="geProductMain.geProductExtendsPeriods[${status2.index}].attributevalue" id="geProductMain.geProductExtends[${status2.index}].attributevalue" value="${peroid2.attributevalue}" style="width: 50px">
												</td>
												<td>单位:</td>
												<td>
													<dict:select typeCode="INSURANCEPERIOD" name="geProductMain.geProductExtendsPeriods[${status2.index}].attributetypevalue" id="geProductMain.geProductExtendsPeriods[${status2.index}].attributetypevalue" defaultValue="${peroid2.attributetypevalue}"></dict:select>
													<input type="button" 
														<c:choose>
															<c:when test="${status2.index==0 }"> 
																value="添加" onclick="addPeriod2()"
															</c:when>
															<c:otherwise> value="删除" onclick="delPeriod2('${status2.index}')"
															</c:otherwise>						
														</c:choose>
													 />
												</td>
											</tr>
											<c:set var="peroidCount2" value="${peroidCount2+1 }"></c:set>
		            					</c:forEach>
										</table>
		            					<input type="hidden" id="peroidCount2" value="${peroidCount2 }" />
									</fieldset>
								</div>
								
								
		    				</td>
		    				<td valign="top">
		    					<div style="width: 400px;height: 330px;">
						    		<fieldset>
									<legend>销售区域</legend> 
										<ul id="saleArea" class="easyui-tree" style="width: 380px;height: 300px; overflow: auto;">  
										</ul>
									</fieldset>
								</div>
		    				</td>
		    			</tr>
		    		</table>
		    		<div style="padding-left: 80px;padding-top: 10px;" class="userDataItem">
    					<a class="easyui-linkbutton" style="color: #444" data-options="iconCls:'icon-save'"  onclick="$('#productBaseInfo').submit();">保存</a>
					</div>
		    	</div>
			</form>
			
			
	    </div>   
	      
	</div>  
 
 <script type="text/javascript">
 //保险期间计数器,只会增加,不会减小
 var peroidNumber = parseInt("${peroidCount}");
 var peroidNumber2 = parseInt("${peroidCount2}");
 $(function(){
	 if("${peroidCount}"=="0"){
		 addPeriod("init");
	 }
	 if("${peroidCount2}"=="0"){
		 addPeriod2("init");
	 }
	 
	 //showContent(document.getElementById("geProductMain.limitsameindinsuredamount"),"1");
	 showContent(document.getElementById("geProductMain.issupportbeneficiary"),"1");
	 showContent(document.getElementById("geProductMain.issupportpins"),"1");
	 
	$('#productInfoConfigTab').tabs({    
	    border:false,    
	    onSelect:function(title){    
	        if(title=='保存提交'){
	        	$('#productBaseInfo').submit();
	        }
	        return false;
	    }
	});
	 
	
	$('#productBaseInfo').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		ignore:':hidden',
		rules:{ 
		},
		fields:{
			"geProductMain.ispaper":{rule:"required;"}
		},
		valid: function(form){ //验证成功
			$('#productExtendInfo').submit();
			return false;
		},
		invalid: function(form){//验证失败
			$("#productInfoConfigTab").tabs('select',"基本信息");
			return false;
		}
	});

	$('#productExtendInfo').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		//ignore:':hidden',
		rules:{ 
		},
		fields:{
			"geProductMain.geProductExtends[0].attributevalue":{
				rule:"required;"
			}
		},
		valid: function(form){ //验证成功
			$("#productInfoConfigTab").tabs('select',"扩展信息");
			doSubmit();
			return false;
		},
		invalid: function(form){//验证失败
			$("#productInfoConfigTab").tabs('select',"扩展信息");
			return false;
		}
	});
	
	
	loadSaleAreaTree();
	 
 });
/**
 * 加载服务区域树
 */
 function loadSaleAreaTree(){
	 
	 $.ajax({
			type:"POST",
			url:"${ctx}/system/product/getSaleAreaTree",
			data:{"geProductMain.coreproductcode":"${geProductMain.coreproductcode}"},
			success:function(data){
				$('#saleArea').tree({    
				    data:convertOrganTree(data),
				    animate:true,
					lines:true,
					checkbox:true
				}); 
			},
			error:function (XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('系统异常','系统异常,请稍后再试');
			}
		});
 }
 
 /**
  * 添加保险期间
  */
 function addPeriod(type){
	 peroidNumber++;
	 var numberStr = peroidNumber.toString();
	 var periodDemoTrHtml = $("#periodTrDataDemo").parent().html();
	 
	 periodDemoTrHtml=periodDemoTrHtml.replace(/%num/g,numberStr);
	 var periodDemoTr = $(periodDemoTrHtml);
	 
	 periodDemoTr.attr("id","peroidContentTr_"+peroidNumber);
	 var btn = periodDemoTr.find("input[type='button']");
	 if(type=="init"){
		btn.val("添加");
		btn.removeAttr("onclick");
		btn.on("click",function(){
			addPeriod();
		});
	 }else{
		 btn.val("删除");
		 btn.on("click",function(){
			delPeriod(numberStr);
		 });
	 }
	 $("#periodTable").append(periodDemoTr);
 }
 
 /**
  * 删除保险期间
  */
 function delPeriod(number){
	$("#peroidContentTr_"+number).remove();
 }
 
 
 /**
  * 添加保险期间
  */
 function addPeriod2(type){

	 peroidNumber2++;
	 var numberStr2 = peroidNumber2.toString();
	 var periodDemoTrHtml2 = $("#periodTrDataDemo2").parent().html();
	 
	 periodDemoTrHtml2=periodDemoTrHtml2.replace(/%num/g,numberStr2);
	 var periodDemoTr2 = $(periodDemoTrHtml2);
	 
	 periodDemoTr2.attr("id","peroidContentTr2_"+peroidNumber2);
	 var btn = periodDemoTr2.find("input[type='button']");
	 if(type=="init"){
		btn.val("添加");
		btn.removeAttr("onclick");
		btn.on("click",function(){
			addPeriod2();
		});
	 }else{
		 btn.val("删除");
		 btn.on("click",function(){
			delPeriod2(numberStr2);
		 });
	 }
	 $("#periodTable2").append(periodDemoTr2);
 }
 
 /**
  * 删除保险期间
  */
 function delPeriod2(number){
	$("#peroidContentTr2_"+number).remove();
 }
 
 /**
  * 显示级联的相关内容
  */
 function showContent(dom,showValue){
	 var name = dom.name;
	 var extendTdDom = document.getElementById(name+"_extend");
	 if(dom.value==showValue){
		 $(extendTdDom).show();
	 }else{
		 $(extendTdDom).hide();
	 }
 }
 
 function doSubmit(){

	 var data ="";
	 var saleArea = $("#saleArea").tree('getCheckedExt');
	 if(saleArea.length <= 0){
		 $.messager.alert('提示','请先选择销售区域！');
		 $("#productInfoConfigTab").tabs('select',"扩展信息");
		 return false;
	 }
	 

		
	 for( var i = 0; i < saleArea.length; i++) {
		data = data + "&geSaleAreas["+i+"].gid="+saleArea[i].id;
		data = data + "&geSaleAreas["+i+"].pgid="+saleArea[i].attributes.pgid;
		data = data + "&geSaleAreas["+i+"].gname="+saleArea[i].attributes.gname;
		data = data + "&geSaleAreas["+i+"].geProductMain.coreproductcode=${geProductMain.coreproductcode}";
	 }
	 var paytypes = $('input[name="paytype"]:checked');
	 var paytype = "";
	 for(var i=0;i<paytypes.length;i++){
		paytype = paytype+$(paytypes[i]).val();
		if(i != paytypes.length-1){
			paytype = paytype+",";
		}
	 }
	 
		$("#periodTable").find("tr").each(function(index,dom){
			//将tr 中 input 修改name 按照顺序排序 修改
			$(dom).find("input,select").each(function(i,d){
				var name = d.name;
				var nameArr = name.split(".");
				if(nameArr.length>=3){
					var finalName = nameArr[0]+".geProductExtends["+(index)+"]";
					for ( var j = 2; j < nameArr.length; j++) {
						finalName = finalName+"."+nameArr[j];
					}
					d.name = finalName;
				}
			});
			
		});
		var productBaseInfoObj = $("#productBaseInfo");
		var productExtendInfoObj = $("#productExtendInfo");
		var params = productBaseInfoObj.serialize();
		params+="&"+productExtendInfoObj.serialize();
		params+="&geProductMain.paytype="+paytype;
		
		params+=data;
		
		$.ajax({
			type:"POST",
			url:productBaseInfoObj.attr("action"),
			data:params,
			success:function(data){
				if(data.resultCode==="success"){
					$.messager.alert('提示',"保存成功");
				}else{
					$.messager.alert('系统异常',data.resultInfo);
				} 
			},
			error:function (XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('系统异常','系统异常,请稍后再试');
			}
		});
	 
 }
 </script>
</body>
</html>
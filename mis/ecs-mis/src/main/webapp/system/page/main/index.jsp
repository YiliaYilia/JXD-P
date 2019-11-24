<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/js/ECSTab.js"></script>
<script type="text/javascript" src="${ctx }/common/js/dateUtil.js"></script>
<script type="text/javascript" src="${ctx }/system/js/resource/resourceTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/index/index.js"></script>
<script type="text/javascript" src="${ctx }/system/js/index/userInfo.js"></script>

<style type="text/css">
	.STYLE2 {color: #43860c; font-size: 12px; }
	a:link {font-size:12px; text-decoration:none; color:#43860c;}
	a:visited {font-size:12px; text-decoration:none; color:#43860c;}
	a:hover{font-size:12px; text-decoration:none; color:#FF0000;}
	.tabLeft{
		text-align: right;
		height: 40px;
	}
</style>
<script type="text/javascript">
	$("document").ready(function(){
		var dateUtil = new DateUtil();
		var format = document.getElementById("time").innerHTML;
		document.getElementById("time").innerHTML = dateUtil.format(null,format);
	});
</script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:70px;background-color: #90C94B;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
		  <tr>
		    <td height="9" style="line-height:9px; background-image:url(${ctx }/system/images/main_04.gif)">
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			        <td width="97" height="9" background="${ctx }/system/images/main_01.gif">&nbsp;</td>
			        <td>&nbsp;</td>
			        <td>&nbsp;</td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		  <tr>
		    <td height="47" background="${ctx }/system/images/main_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td width="38" height="47" background="${ctx }/system/images/main_06.gif">&nbsp;</td>
		        <td width="59"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td height="29" background="${ctx }/system/images/main_07.gif">&nbsp;</td>
		          </tr>
		          <tr>
		            <td height="18" background="${ctx }/system/images/main_14.gif">
			            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
			              <tr>
			                <td  style="width:1px;">&nbsp;</td>
			                <td ><span class="STYLE1">${user.geUser.username }</span></td>
			              </tr>
			            </table>
		            </td>
		          </tr>
		        </table></td>
		        <td width="155" background="${ctx }/system/images/main_08.gif">&nbsp;</td>
		        <td>
			        <table width="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr>
			            <td height="23" valign="bottom"><img src="${ctx }/system/images/main_12.gif" width="367" height="23" border="0" usemap="#Map" /></td>
			          </tr>
			        </table>
		        </td>
		        <td width="200" background="${ctx }/system/images/main_11.gif">
			        <table width="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr>
			            <td width="11%" height="23">&nbsp;</td>
			            <td width="89%" valign="bottom"><span class="STYLE1" id="time">日期：yyyy年M月d日 星期W</span></td>
			          </tr>
			        </table>
		        </td>
		      </tr>
		    </table>
		    </td>
		  </tr>
		  <tr>
		    <td height="5" style="line-height:5px; background-image:url(${ctx }/system/images/main_18.gif)">
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			        <td width="180" background="${ctx }/system/images/main_16.gif"  style="line-height:5px;">&nbsp;</td>
			        <td>&nbsp;</td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>
		<map name="Map" id="Map">
			<area shape="rect" coords="3,1,49,22" href="${ctx }" />
			<area shape="rect" coords="52,2,95,21" href="#" onclick="index.goBack();"/>
			<area shape="rect" coords="102,2,144,21" href="#" onclick="index.goTab();" />
			<area shape="rect" coords="150,1,197,22" href="#" onclick="index.flushTab();" />
			<area shape="rect" coords="210,2,304,20" href="#" onclick="index.alterInfo('${user.geUser.userid }');" />
			<%--  onclick="index.alterInfo(${user.geUser.userid });" --%>
			<area shape="rect" coords="314,1,361,23" href="${ctx }/system/logout" />
		</map>
	</div>
	<div data-options="region:'south',border:false" style="height:25px;background-color: #90C94B;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td height="24" background="${ctx }/system/images/main_47.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td width="29" height="24"><img src="${ctx }/system/images/main_45.gif" width="29" height="24" /></td>
		        <td>
			        <table width="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr>
			            <td width="369"><span class="STYLE1">中科软ECS后台管理平台 版本 V5.0</span></td>
			            <td width="814" class="STYLE1">&nbsp;</td>
			            <td width="185" nowrap="nowrap" class="STYLE1"><div align="center"><img src="${ctx }/system/images/main_51.gif" width="12" height="12" /> 如有疑问请与技术人员联系</div></td>
			          </tr>
			        </table>
		        </td>
		        <td width="14"><img src="${ctx }/system/images/main_49.gif" width="14" height="24" /></td>
		      </tr>
		    </table></td>
		  </tr>
		</table>
		 	
	</div>
	<div data-options="region:'west',split:false,title:'管理选项'" style="width:230px;">
		<div class="easyui-layout" style="width:227px;border-bottom: 3px solid #90C94B;" data-options="fit:true">
			<div data-options="region:'north',border:false" style="height:70px;" data-options="fit:true">
				<div >
					<c:forEach items="${rootResources }" var="resource" >
						<div style="width:60px;float: left;padding-left: 12px;">
							<table>
								<tr>
									<td align="center">
										<a href="#" onclick="index.choseModel('${resource.resourcesid}')">
											<img src="${ctx }${resource.geResourcesIcon.resourcesiconpath}" name="Image1" width="32"  border="0"  />
										</a>
									</td>
								</tr>
								<tr>
									<td align="center">
										<a href="#" onclick="index.choseModel('${resource.resourcesid}')">${resource.resourcesname}</a>
									</td>
								</tr>
							</table>
						</div>
					</c:forEach>
					</div>
			</div>
			<div data-options="region:'center',border:false,title:' '" style="vertical-align:0px;" data-options="fit:true">
				<div style="padding-top: 10px;" >
					<div id="menuNav" ></div>
				</div>
			</div>
		</div>
		
	</div>
	<div data-options="region:'center'" style="vertical-align:0px;">
		<div class="easyui-tabs" data-options="fit:true" id="mainTab" >
			<div title="首页" style="padding:10px" id="menuNav_Home">
			
			<table class="easyui-propertygrid" data-options="title:'系统信息',scrollbarSize:0,fitColumns:true,fit:true">   
			    <thead>   
			        <tr>   
			            <th data-options="title:'系统信息',field:'name'">系统信息</th>   
			            <th >系统值</th>   
			        </tr>   
			    </thead>   
			    <tbody>   
			        <tr>
			        	<td></td>
			            <td>操作系统</td>
			            <td>${osName }</td>   
			        </tr> 
			        <tr>
			        	<td></td>
			            <td>HTTP服务器</td>
			            <td>${serverInfo }</td>   
			        </tr> 
			        <tr>
			        	<td></td>
			            <td>虚拟机总内存</td>
			            <td>${total }</td>   
			        </tr>
			        <tr>
			        	<td></td>
			            <td>虚拟机空闲内存</td>
			            <td>${free }</td>   
			        </tr>     
			        <%-- <tr>
			        	<td></td>
			            <td>物理内存</td>
			            <td>${PhysicalMemory }</td>   
			        </tr>  
			        <tr>
			        	<td></td>
			            <td>物理空闲内存</td>
			            <td>${freePhysicalMemorySize }</td>   
			        </tr> --%>
			        <tr>
			        	<td></td>
			            <td>项目部署路径</td>
			            <td>${deployPath }</td>   
			        </tr>
			        <tr>
			        	<td></td>
			            <td>JDK版本</td>
			            <td>${vmVersion }</td>   
			        </tr>
			        
			    </tbody>   
			</table>  
			</div>
		</div>
	</div>
	<div id="alterUserInfo_windows" style="display: none;background-color:white ; font-size: 15px; padding: 10px;overflow:hidden;">
	</div>
	<script type="text/javascript">

		var index = new Index();
		index.ctx= '${ctx}';
		var data = eval('('+'${childResources}'+')');
		//alert(data.toJSONString());
			$('#menuNav').tree({    
			data: convert(data),
			animate:true,
			lines:true,
			onClick:function(node){
				var tid = node.id;
				var isLeaf = $('#'+tid).tree('isLeaf',node.target); //是否是叶子节点
				if(isLeaf){
					var title = node.text;
					var url = node.attributes.url;
					var tab = new ECSTab();
					tab.addTab(title,tid,url);
				}
			}
		});
	</script>
</body>
</html>
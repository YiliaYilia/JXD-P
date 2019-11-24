<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>续期交费查询</title>
	
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-1.10.2.min.js"></script>
<script>
		var subFlag = true;
		var phoneWidth =  parseInt(window.screen.width);
		var phoneScale = phoneWidth/640;
		var ua = navigator.userAgent;
		if (/Android (\d+\.\d+)/.test(ua)){
			var version = parseFloat(RegExp.$1);
			if(version>2.3){
				document.write('<meta name="viewport" content="width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">');
			}else{
				document.write('<meta name="viewport" content="width=640, target-densitydpi=device-dpi">');
			}
		} else {
			document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">');
		}
		
</script>
  	<meta name="format-detection" content="telephone=no"/>
 <link rel="stylesheet" href="../global/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="../global/css/all.css" type="text/css"></link>
    <!-- 引入 -->
	<link href="../global/css/common/main.min.css?${random}" rel="stylesheet"/>
	<link href="../global/css/page/page.min.css?${random}" rel="stylesheet"/>
	<link href="../global/css/animate/animate.css" rel="stylesheet"/>
	<link href="../global/css/animate/loader-ani.css" rel="stylesheet"/>
	
	<script src="../global/lib/jquery/jquery-2.1.3.min.js"></script>
	<script src="../global/lib/common/main.js?${random}"></script>
	
	<script src="../global/lib/component/modal.js"></script>
	
	<script src="../global/lib/jquery/jquery.event.move.js"></script>
	<script src="../global/lib/jquery/jquery.mobile.touch.js"></script>
	<script src="../global/lib/jquery/jquery.event.swipe.js"></script>
	
	<!-- 引入 end-->
    <script type="text/javascript" src="../global/js/jquery/1.9.0/jquery.min.js"></script>
  	<script type="text/javascript" src="../global/js/common.js"></script>
  	
  	  <!-- 引入样式文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/vant@2.2/lib/index.css">
    <!-- 引入 Vue 和 Vant 的 JS 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vant@2.2/lib/vant.min.js"></script>

	<style>
		.list1 {
    width: 100%;
}

.listDetail {
    width: 94%;
    margin: 4% auto 0 auto;
    line-height: 60px;
    background-color: #fff;
    border-radius: 10px;
    border: 1px solid #C6C6C6;
}

.listDetail-title {
    display: flex;
    justify-content: center;
    border-bottom: 1px solid #C6C6C6;
}

.listDetail-title-span1 {
    flex: 1;
    margin-left: 8%;
    font-size: 22px;
}

.listDetail-title-span2 {
    flex: 0 0 20%;
    width: 20%;
    text-align: right;
    font-size: 18px;
}

.listDetail-title-img {
    margin-top: 2.5%;
    margin-left: 2%;
    margin-right: 6%;
    width: 32px;
    height: 32px;
}

.listDetail-content {
    position: relative;
    margin: 10px 0 10px 50px; 
}

.listDetail-content-div-span1 {
    font-size: 20px;
}

.listDetail-content-div-span2 {
    font-size: 20px;
}

.listDetail-content-div-btn {
    height: 40px;
    line-height: 34px;
    padding: 0 20px;
    outline: none;
    border-radius: 6px;
    margin-right: 30%;
    background-color: #fff;
    border: 1px solid #C6C6C6;
}

.listDetail-content-div-btn:last-child {
    margin-right: 0;
}

.listDetail-content-div-img {
    vertical-align: middle;
    margin: 0 5%;
}

.listDetail-content-img {
    position: absolute;
    top: 50%;
    right: 10%;
    margin-top: -50px;
    width: 100px;
    height: 100px;
}
        .van-tabs--card>.van-tabs__wrap {
            height: 50px;
        }

        .van-tabs__nav--card {
            margin: 0;
            border: 1px solid #ccc;
            height: 50px;
        }
    
        .van-tabs__nav--card .van-tab {
            border-right: 1px solid #1A87ED;
        }
    
        .van-tabs__nav--card .van-tab.van-tab--active {
            background-color: #1A87ED;
        }

        .van-tab span {
            line-height: 50px;
            color: #000;
        }
    </style>
</head>

    <body  class="gray">
 <div id="app">   
 		<c:choose>
        <c:when test="${(renewalPolicieListE != null && fn:length(renewalPolicieListE) > 0) || (renewalPolicieListXE != null && fn:length(renewalPolicieListXE) > 0)}">
        <!-- 第一部分：Tab选项卡 -->
        <van-tabs v-model="activeName" type="card">
        
            <van-tab title="续期交费（年交）" name="a">
            <c:choose>
       		 <c:when test="${renewalPolicieListE != null && fn:length(renewalPolicieListE) > 0}">
                <div class="list1">
                    <c:forEach var="renewalE" items="${renewalPolicieListE}"  varStatus="st">
                    <!-- 第一部分 -->
                    <div class="listDetail">
                        <!-- 标题 -->
                        <div class="listDetail-title">
                            <span class="listDetail-title-span1">${renewalE.mainRiskName }</span>
                            <span class="listDetail-title-span2">附加险</span>
                            <img class="listDetail-title-img" src="../global/images/4.png" alt="">
                        </div>
                        <!-- 内容 -->
                        <div class="listDetail-content">
                            <!-- 保单号 -->
                            <div class="listDetail-content-div">
                                <span class="listDetail-content-div-span1">保单号：</span>
                                <span class="listDetail-content-div-span2">${renewalE.policyCode }</span>
                            </div>
                            <!-- 被保险人 -->
                            <div class="listDetail-content-div">
                                <span class="listDetail-content-div-span1">被保险人：</span>
                                <span class="listDetail-content-div-span2">王二小</span>
                            </div>
                            <!-- 应交日期 -->
                            <div class="listDetail-content-div">
                                <span class="listDetail-content-div-span1">应交日期：</span>
                                <span class="listDetail-content-div-span2">2019-05-20</span>
                                <img class="listDetail-content-div-img" src="../global/images/5.png" alt="">
                                <span class="listDetail-content-div-span2">剩余30天</span>
                            </div>
                            <!-- 应交保额 -->
                            <div class="listDetail-content-div">
                                <span class="listDetail-content-div-span1">应交保额：</span>
                                <span class="listDetail-content-div-span2">¥5000元/年</span>
                            </div>
                            <!-- 保单状态 -->
                            <div class="listDetail-content-div">
                                <span class="listDetail-content-div-span1">保单状态：</span>
                                <span class="listDetail-content-div-span2">有效</span>
                            </div>
                            <!-- 提交按钮 -->
                            <div class="listDetail-content-div">
                                <button class="listDetail-content-div-btn">自助交费</button>
                                <button class="listDetail-content-div-btn">交费记录</button>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div> 
                </c:when>
        	  	<c:otherwise>
        			<div class="payment-outer-content-div">
               			 <span class="payment-outer-content-div-span1">无查询保单</span>
            		</div>
        		</c:otherwise>
        	</c:choose>
            </van-tab>
            <van-tab title="续期交费（非年交）" name="b">
            <c:choose>
            <c:when test="${renewalPolicieListXE != null && fn:length(renewalPolicieListXE) > 0}">
                        <div class="list1">
                            <!-- 第一部分 -->
                            <c:forEach var="records" items="${renewalPolicieListXE}"  varStatus="st"> 
                            <div class="listDetail">
                                <!-- 标题 -->
                                <div class="listDetail-title">
                                    <span class="listDetail-title-span1">瑞泰健康之选两全保险</span>
                                    <span class="listDetail-title-span2">附加险</span>
                                    <img class="listDetail-title-img" src="../global/images/4.png" alt="">
                                </div>
                                <!-- 内容 -->
                                <div class="listDetail-content">
                                    <!-- 保单号 -->
                                    <div class="listDetail-content-div">
                                        <span class="listDetail-content-div-span1">保单号：</span>
                                        <span class="listDetail-content-div-span2">TM22308005</span>
                                    </div>
                                    <!-- 被保险人 -->
                                    <div class="listDetail-content-div">
                                        <span class="listDetail-content-div-span1">被保险人：</span>
                                        <span class="listDetail-content-div-span2">王七</span>
                                    </div>
                                    <!-- 应交日期 -->
                                    <div class="listDetail-content-div">
                                        <span class="listDetail-content-div-span1">应交日期：</span>
                                        <span class="listDetail-content-div-span2">2019-03-20</span>
                                        <img class="listDetail-content-div-img" src="../global/images/5.png" alt="">
                                        <span class="listDetail-content-div-span2">剩余30天</span>
                                    </div>
                                    <!-- 应交保额 -->
                                    <div class="listDetail-content-div">
                                        <span class="listDetail-content-div-span1">应交保额：</span>
                                        <span class="listDetail-content-div-span2">¥5000元/年</span>
                                    </div>
                                    <!-- 保单状态 -->
                                    <div class="listDetail-content-div">
                                        <span class="listDetail-content-div-span1">保单状态：</span>
                                        <span class="listDetail-content-div-span2">有效</span>
                                    </div>
                                    <!-- 提交按钮 -->
                                    <div class="listDetail-content-div">
                                        <button class="listDetail-content-div-btn">自助交费</button>
                                        <button class="listDetail-content-div-btn">交费记录</button>
                                    </div>
                                </div>
                            </div>
                           </c:forEach>
                        </div>
                   </c:when>
        			<c:otherwise>
        				<div class="payment-outer-content-div">
                			<span class="payment-outer-content-div-span1">无查询保单</span>
            			</div>
        			</c:otherwise>
        		</c:choose> 
            </van-tab>
        </van-tabs>
        </c:when>
        <c:otherwise>
        	<div class="payment-outer-content-div">
                <span class="payment-outer-content-div-span1">无查询保单</span>
            </div>
        </c:otherwise>
        </c:choose> 
    </div>
<div class="footer footer-fixed" > <img src="../uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>

<script>
        new Vue({
            el: '#app',
            data () {
                return {
                    activeName: 'a', //Tab栏切换
                    tab: 0, //设置Tab栏切换样式
                }
            }
        });
    </script>
</body>
<%@ include file="/page/result.jsp"%>
</html>

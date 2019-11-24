<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<html>
  <head>
    <title>理赔须知</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta name="format-detection" content="telephone=no"/>
 	</head>
  <script type="text/javascript">
  		function affirmClaim(){
  			window.location.href ='${ctx}/msl/sales/isMobileCustomerAction';
  		}
  </script>
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/safe-new.css">
<link rel="stylesheet" type="text/css" href="${ctx}/uinew/css/style-font.css">

<body  class="gray">
  <div class="grace-head"> </div>
           <h2 style="margin-top:60px; text-align:center; color:#c8a154; font-weight:bold;">客户须知 </h2>
  			<div class="panel-collapse collapse in cardcontent info-con" >
             <div class="text-con"> 
             	<p>１、 申请人须符合以下条件之一:<span class="blue">投保人与被保险人为同一人</span>;<span class="blue">投保人为未成年被保险人的父亲或母亲</span>。</p>
				   		<p>２、 目前，可通过微信自助申请理赔的业务范畴，尚仅限于索赔类别为<span class="blue">住院津贴</span>或<span class="blue">医疗报销</span>的案件。其它索赔类别（包括重大疾病、身故、伤残等），微信仅受理理赔报案，理赔申请资料还需书面提交。如有疑问，请您拨打我们的客户服务专线400-810-9339。</p>
				   		<p>３、 申请医疗报销的客户，请您及时将<span class="blue">医疗费用专用收据原件及分割单原件</span>（如已在其它机构报销部分费用）递交给我公司，以便我们能尽快将理赔款支付给您。</p>
				   		<p>４、我们将以收到您“齐全”的索赔资料时间作为理赔受理时间；资料不齐全的，我们会及时通知您。</p>
				   		<p class="remind">反保险欺诈提示：</p>
				   		<p>诚信是保险合同基本原则，涉嫌保险欺诈将承担以下责任：</p>
				   		<p><span class="blue">【刑事责任】</span>进行保险诈骗犯罪活动，可能会受到拘役、有期徒刑，并处罚金或者没收财产的刑事处罚。保险事故的鉴定人、证明人故意提供虚假的证明文件，为他人诈骗提供条件的，以保险诈骗罪的共犯论处。</p>
				   		<p><span class="blue">【行政责任】</span>进行保险诈骗活动，尚不构成犯罪的，可能会受到15日以下拘留、5000元以下罚款的行政处罚；保险事故的鉴定人、证明人故意提供虚假的证明文件，为他人诈骗提供条件的，也会受到相应的行政处罚。</p>
				   		<p><span class="blue">【民事责任】</span>故意或因重大过失未履行如实告知义务，保险公司不承担赔偿或给付保险金的责任。</p>
				   	</div>
            </div>
           <ul class="btn-last"> 
              <li onclick="window.history.back()">取消 </li>
              <li onclick="affirmClaim()">确认提交 </li>
            </ul>
<div class="footer footer-fixed "> <img src="${ctx}/uinew/images/bottom-line.jpg"  alt="" width="100%"/></div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
		<script type="text/x-jQuery-tmpl" id="phoneInfoTpl">
			<div class="page" id="policy-phone">
				<div class="phone">
					<div class="phone-item">
						<img src="${ctx}/resources/image/policy/user.png">
						<label>营销员姓名</label>
						<span>{{agentName}}</span>
					</div>
					<div class="phone-item">
						<img src="${ctx}/resources/image/policy/phone.png">
						<label>联系电话</label>
						<span><a href='tel:{{agentPhone}}'>{{agentPhone}}</a></span>
					</div>
					<div class="phone-item depart">
						<img src="${ctx}/resources/image/policy/shoppingcart.png">
						<label>销售机构</label>
						<span>{{organName}}</span>
					</div>
					<div class="depart-info">
						<p class="depart-item">
							<label>机构地址：</label>
							<span>{{organAddr}}</span>
						</p>
						<p class="depart-item">
							<label>邮政编码：</label>
							<span>{{organZipCode}}</span>
						</p>
						<p class="depart-item">
							<label>联系电话：</label>
							<span><a href='tel:{{organTele}}'>{{organTele}}</a></span>
						</p>
					</div>
				</div>
			</div>
		</script>
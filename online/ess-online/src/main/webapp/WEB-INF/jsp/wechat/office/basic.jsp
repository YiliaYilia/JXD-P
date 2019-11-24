<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/wechat/common/taglibs.jsp"%>
<script type="text/x-jQuery-tmpl" id="officeBasicInfoTpl">
	{{#officeList}}
				<div class="office-item">
						<div class="office-basic row">
							<div class="office-label col-6">网点名称</div>
							<div class="office-name col-16">{{name}}</div>
							<div class="office-folder col-2"><b></b></div>
						</div>
						<div class="office-detail">
							<p class="office-detail-item row">
								<label class="col-8">网点地址：</label>
								<span class="col-16">{{address}}</span>
							</p>
							<p class="office-detail-item row">
								<label class="col-8">邮政编码：</label>
								<span class="col-16">{{postalCode}}</span>
							</p>
							<p class="office-detail-item row">
								<label class="col-8">联系电话：</label>
								<span class="col-16"><a href='tel:{{phone}}'>{{phone}}</a></span>
							</p>
						</div>
					</div>
	{{/officeList}}
</script>

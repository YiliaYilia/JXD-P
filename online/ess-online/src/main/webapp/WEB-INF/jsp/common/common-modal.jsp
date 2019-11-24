<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 		提示框 -->
		<div class="modal fade" data-rule="alert" id="modal_alert">
			<div class="modal-dialog alert">
				<div class="modal-header clearfix"><span data-title="modal">提示信息</span><a type="button" class="close" data-dismiss="modal"></a></div>
				<div class="modal-content" data-content="modal"></div>
				<div class="modal-footer">
					<a class="modal-btn btn" data-dismiss="modal" data-btn="modal">确定</a>
				</div>
			</div>
		</div>
		
<!-- 		提示框 -->
		<div class="modal fade" data-rule="notice" id="modal_notice">
			<div class="modal-dialog alert">
				<div class="modal-header clearfix"><span data-title="modal">提示信息</span></div>
				<div class="modal-content" data-content="modal"></div>
				<div class="modal-footer"></div>
			</div>
		</div>
				
 <!-- 		对话框 -->
		<div class="modal fade" data-rule="dialog">
			<div class="modal-dialog alert">
				<div class="modal-header clearfix">提示信息</div>
				<div class="modal-content" data-content="modal"></div>
				<div class="modal-footer">
					<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok">确定</a>
					<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel">取消</a>
				</div>
			</div>
		</div>
		
		<!-- 		支付选择对话框 -->
<!-- 		<div class="modal fade" data-rule="dialog"> -->
<!-- 			<div class="modal-dialog alert"> -->
<!-- 				<div class="modal-header clearfix">提示信息</div> -->
<!-- 				<div class="modal-content" data-content="modal"></div> -->
<!-- 				<div class="modal-footer"> -->
<!-- 					<a class="modal-btn btn inline" data-dismiss="modal" data-btn="ok">已完成付款</a> -->
<!-- 					<a class="modal-btn btn cancel inline" data-dismiss="modal" data-btn="cancel">选择其他支付方式</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
<!-- 		加载等待框 -->
		<div class="modal fade" data-rule="loading" id="modal_loading">
			<div class="modal-dialog loading">
				<div class="modal-content" data-content="modal">
					<p class="loader8">加载中......</p>
				</div>
			</div>
		</div>
		<script>
		
// 			modal_alert('内容XXX');
// 			modal_alert('内容XXX',function(){
// 				//TODO
// 			});
// 			modal_alert({
// 				content:'内容XXX',
// 				btn:'确定'
// 			});
// 			modal_alert({
// 				content:'内容XXX',
// 				btn:'确定',
// 				title:'标题',
// 				callback:function(){
// 					//TODO
// 				}
// 			});

// 			modal_dialog('内容XXX',function(){
// 				//TODO  
// 				//okBtn Function
// 			},function(){
// 				//TODO  
// 				//cancelBtn Function
// 			});

//			开启加载浮层
//			modal_loading();

//			关闭加载浮层
//			modal_loading('hide');

		</script>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html class="js cssanimations" style="">
<head>
<meta charset="utf-8" />
<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<title>永州生活网</title>
<%@ include file="../common/header"%>
</head>
<body class="am-with-fixed-navbar" style="" onload="reminde()">
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，我们不提供支持。 请升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<%@ include file="../common/nav"%>
	<fieldset>
		<div id="container">
			<form class="am-form" action="/local/event/add" method="post">
				<div class="am-form-group">
					<textarea rows="10" class="" name="text" id="textId"
						placeholder="分享一个。。。时间、地点、人物" required></textarea>
					<input type="hidden" id="picUrl" name="picPath" />
				</div>
				<div class="doc-example">
					<a class="am-btn am-btn-primary" id="upload_button"
						data-am-modal="{target: '#upload-loading',width: 100%, height: 225}"
						style="width: 100%">投稿</a>
				</div>
			</form>
		</div>
	</fieldset>
	<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
		<div class="am-modal-dialog">
			<div class="am-modal-bd">
				<img alt="" src="../assets/money.png">
			</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn" data-am-modal-confirm>土豪!任性!<br />继续上传
				</span> <span class="am-modal-btn" data-am-modal-cancel>小流量<br />右上角浏览器中<br />打开链接上传
				</span>
			</div>
		</div>
	</div>
	<%@ include file="../common/footer"%>

	<!-- 	<script src="../assets/js/plupload/plupload.full.min.js"></script> -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/amazeui.js"></script>
	<!-- 	<script src="../assets/js/upload/JIC.js"></script> -->
	<!-- 	<script src="../assets/js/upload/qiniu.min.js"></script> -->
	<!-- 	<script src="../assets/js/upload/demo.js"></script> -->
	<script type="text/javascript">
		function reminde() {
			// 			$('#my-confirm').modal({
			// 				relatedTarget : this,
			// 				onConfirm : function(options) {

			var preSuffix = location.origin + "/local/send/show/";
			location.href = preSuffix + "form";
			// 				},
			// 				onCancel : function() {
			// 					jump();
			// 				}
			// 			});
		}

		function jump() {
			var preSuffix = location.origin + "/local/send/show/";
			if (window.FileReader) {
				location.href = preSuffix + "compress";
				return;
			}
			location.href = preSuffix + "qn";
		}
	</script>
</body>
</html>
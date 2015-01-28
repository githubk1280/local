<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html class="js cssanimations" style="">
<head>
<meta charset="utf-8" />
<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<title>test-首页</title>
<%@ include file="../common/header"%>
</head>
<body class="am-with-fixed-navbar" style="">
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，我们不提供支持。 请升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<%@ include file="../common/nav"%>
	<form class="am-form" action="/local/event/add" method="post">
		<fieldset>
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
			<br />
			<div class="am-alert am-alert-success" data-am-alert
				style="display: none" id="upload-success">
				<button type="button" class="am-close">&times;</button>
				<p>图片上传成功,可以投稿了</p>
			</div>
			<div class="am-alert am-alert-secondary" data-am-alert
				style="display: none" id="upload-failed">
				<button type="button" class="am-close">&times;</button>
				<p>啊噢，图片上传出了点小故障，请稍后重试</p>
			</div>
			<div class="am-form-group">
				<label for="doc-ipt-file-1">传个图片(可以拍照上传哦)</label> <input type="file"
					id="doc-ipt-file-1">
				<p class="am-form-help">请选择要上传的文件</p>
			</div>
			<div class="am-progress" style="display: none">
				<div class="am-progress-bar" style="width: 0%" id="Progress">40%</div>
			</div>
			<div class="doc-example">
				<img id="source_image" class='img_container' /><img
					id="result_image" class='img_container' />
			</div>
		</fieldset>
	</form>
	<%@ include file="../common/footer"%>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/jquery.min.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.js"></script>
	<script src="../assets/js/upload/demo.js?v=1"></script>
	<!-- 	<script -->
	<!-- 		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/upload/demo.js"></script> -->
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/upload/JIC.js"></script>
</body>
</html>
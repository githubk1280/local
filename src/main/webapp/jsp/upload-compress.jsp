<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html class="js cssanimations" style="">
<head>
<meta charset="utf-8" />
<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<title>永州本地生活网</title>
<%@ include file="../common/header"%>
</head>
<body class="am-with-fixed-navbar" style="">
	<div class="am-header-left am-header-nav">
		<header class="am-header am-header-default " data-am-widget="header">
			<div class="am-header-left am-header-nav">
				<a href="/local/index?openId=${openId}" class=""><i
					class="am-header-icon am-icon-home am-icon-sm"></i></a>
			</div>
			<h1 class="am-header-title">投稿</h1>
			<div class="am-header-right am-header-nav">
				<a href="/local/send/show?openId=${openId}" class=""><i
					class="am-header-icon am-icon-camera" style="font-size: 150%;"></i></a>
			</div>
		</header>
	</div>
	﻿
	<nav data-am-menu-offcanvas="" class="am-menu  am-menu-offcanvas1"
		data-am-widget="menu">
		<div class="am-offcanvas" id="leftNavBars">
			<div class="am-offcanvas-bar am-offcanvas-bar-overlay">
				<ul class="am-menu-nav am-avg-sm-1">
					<li class="am-nav-header">导航栏</li>
					<li class="am-parent am-open"><a href="#c3" class="">信息分享</a>
						<ul class="am-menu-sub am-avg-sm-4 am-collapse am-in">
							<li class=""><a href="##" class="">地方实事</a></li>
							<br />
							<li class=""><a href="##" class="">人文</a></li>
							<br />
							<li class=""><a href="##" class="">众筹</a></li>
						</ul></li>
					<li class="am-parent am-open"><a href="#c3" class="">地方生活</a>
						<ul class="am-menu-sub am-avg-sm-4 am-collapse am-in">
							<li class=""><a href="##" class="">交友</a></li>
							<br />
							<li class=""><a href="##" class="">一起玩</a></li>
							<br />
							<li class=""><a href="##" class="">情感天地</a></li>
						</ul></li>
					<li class=""><a href="##"><span
							class="am-icon-location-arrow"></span> <span
							class="am-navbar-label">找优惠</span></a></li>
					<li class=""><a href="##"><span class="am-icon-user"></span>
							<span class="am-navbar-label">关于我们</span> </a></li>
					<li class=""><a href="##"><span
							class="am-icon-location-arrow"></span> <span
							class="am-navbar-label">联系我们</span> </a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="am-form-group">
		&nbsp;<i class="am-icon-star am-icon-md"></i>右上角点击浏览器打开链接上传更省流量哦!
	</div>
	<div class="am-form-group">
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
			<br />
			<div class="am-form-group">
				<label for="doc-ipt-file-1">传个图片(可以拍照上传哦)</label> <input type="file"
					name="file" id="uploadFileId">
				<p class="am-form-help">请选择要上传的文件</p>
			</div>
			<div class="am-form-group">
				<label for="doc-ipt-file-1">所有稿件经管理员审核后方可发布</label>
			</div>
			<div class="doc-example">
				<img id="source_image" class='img_container' /><img
					id="result_image" class='img_container' />
			</div>
		</fieldset>
	</div>

	<%@ include file="../common/footer"%>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/jquery.min.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/upload/v8/JIC.js"></script>
	<!-- 	<script -->
	<!-- 		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/upload/v9/demo.js"></script> -->
	<%-- 	<script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script> --%>
	<%-- 	<script src="<%=request.getContextPath()%>/assets/js/amazeui.js"></script> --%>
	<%-- 	<script src="<%=request.getContextPath()%>/assets/js/upload/JIC.js"></script> --%>
	<script src="<%=request.getContextPath()%>/assets/js/upload/demo.js"></script>
</body>
</html>
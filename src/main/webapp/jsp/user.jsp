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
	<form action="" class="am-form" data-am-validator>
		<fieldset>
			<legend>个人信息设置</legend>
			<div class="am-form-group">
				<label for="doc-vld-name-2">用户名：</label> <input type="text"
					id="doc-vld-name-2" minlength="3" placeholder="保存后后不可再更改" required />
			</div>

			<div class="am-form-group">
				<label for="doc-vld-age-2">年龄：</label> <input type="number" class=""
					id="doc-vld-age-2" placeholder="输入年龄  18-120" min="18" max="120"
					required />
			</div>

			<div class="am-form-group">
				<label>网站 设置： </label> <label class="am-radio-inline"> <input
					type="radio" value="" name="viewType" required> 图文版
				</label> <label class="am-radio-inline"> <input type="radio"
					name="viewType"> 纯文字版
				</label>
			</div>

			<div class="am-form-group">
				<label>性别： </label> <label class="am-radio-inline"> <input
					type="radio" value="" name="docVlGender" required> 男<i
					class="am-icon-male"></i>
				</label> <label class="am-radio-inline"> <input type="radio"
					name="docVlGender"> 女
				</label> <label class="am-radio-inline"> <input type="radio"
					name="docVlGender"> 其他
				</label>
			</div>

			<div class="am-form-group">
				<label for="doc-select-1">老家</label> <select id="doc-select-1"
					required>
					<option value="dongan">东安</option>
					<option value="lingling">零陵</option>
					<option value="qita">其它</option>
				</select> <span class="am-form-caret"></span>
			</div>

			<div class="am-form-group">
				<label for="doc-vld-name-2">老家哪里</label> <input type="text"
					id="laojia" placeholder="老家哪里（至少 1 个字符）" required />
			</div>

			<button class="am-btn am-btn-secondary" type="submit"
				style="width: 100%">保存</button>
		</fieldset>
	</form>
	﻿
	<div data-am-sticky>
		<header class="am-header am-header-default " data-am-widget="header">
			<div class="am-header-left am-header-nav">
				<a href="/local/index" class=""><i
					class="am-header-icon am-icon-home am-icon-sm"></i></a>
			</div>
			<h1 class="am-header-title">首页</h1>
			<div class="am-header-right am-header-nav">
				<a href="/local/send/show" class=""><i
					class="am-header-icon am-icon-camera" style="font-size: 150%;"></i></a>
			</div>
		</header>
	</div>
	<%@ include file="../common/footer"%>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/jquery.min.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/handlebars.min.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.widgets.helper.js"></script>
</body>
</html>
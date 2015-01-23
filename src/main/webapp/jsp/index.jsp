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
	<header class="am-header am-header-default" data-am-widget="header">
		<div class="am-header-left am-header-nav">
			<a href="#left-link" class=""><i
				class="am-header-icon am-icon-home am-icon-sm"></i></a>
		</div>
		<h1 class="am-header-title">首页</h1>
		<div class="am-header-right am-header-nav">
			<a href="#left-link" class=""><i
				class="am-header-icon am-icon-camera" style="font-size: 150%;"></i></a>
		</div>
	</header>
	<%@ include file="../common/nav"%>
	<div class="am-list-news am-list-news-default"
		data-am-widget="list_news">
		<div class="am-list-news-bd">
			<ul class="am-list">
				<c:forEach items="${events}" var="event">
					<li
						class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-top">
						<div class="am-list-main">
							<h3 class="am-list-item-hd">${event.content }</h3>
							<div class="am-list-item-text"></div>
						</div> <c:if test="${event.pics !=null && event.pics !='' }">
							<div class="am-list-thumb am-u-sm-12">
								<img src="${event.pics }">
							</div>
						</c:if>
						<div class="am-list-thumb am-u-sm-12">
							<fmt:formatDate value="${event.createTime }"
								pattern="yyyy-MM-dd HH:mm:ss" />
							| 来源： ${event.from } ${event.id }
						</div>
						<div class="am-list-thumb am-u-sm-12">
							<a href=""><i class="am-icon-thumbs-o-up am-icon-sm"></i>赞(${event.zanCount })</a>
							<a href=""><i class="am-icon-thumbs-o-down am-icon-sm"></i>Shi(${event.zanCount })</a>
							<a href="http://fontawesome.io/icon/comments-o"><i
								class="am-icon-comments-o am-icon-sm"></i> 评论(20)</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
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
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
<link href="<%=request.getContextPath()%>/assets/css/app.css"
	rel="stylesheet" />
</head>
<body class="am-with-fixed-navbar" style="">
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，我们不提供支持。 请升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<%@ include file="../common/nav"%>
	<div style="margin: 0 10px">
		<h3 style="font-weight: 300;color:black">${event.content}</h3>

	</div>
	<c:if test="${event.pics !=null && event.pics != ''}">
		<div style="margin: 0 10px">
			<a style="color: #999; float: right"
				href="http://7u2mg0.com1.z0.glb.clouddn.com/${event.pics}">点击查看原图</a>
			<br/>
			<img src="http://7u2mg0.com1.z0.glb.clouddn.com/${event.pics}-sy"
				style="border-radius: 9px;">
		</div>
	</c:if>
	<br />
	<div class="ds-thread ds-narrow" id="ds-thread"
		data-thread-key="b0ce9d966e42c53a044d391406bbce0c">
		<div id="ds-reset" class="ds-touch">
			<div class="ds-meta" style="display: none;">
				<a href="javascript:void(0)"
					class="ds-like-thread-button ds-rounded"><span
					class="ds-icon ds-icon-heart"></span> <span
					class="ds-thread-like-text">喜欢</span><span
					class="ds-thread-cancel-like">取消喜欢</span></a><span
					class="ds-like-panel"></span>
			</div>
			<div class="ds-replybox">
				<a class="ds-avatar" href="javascript:void(0);"
					onclick="return false"><img
					src="http://static.duoshuo.com/images/noavatar_default.png" alt=""></a>
				<form method="post">
					<input type="hidden" name="thread_id" value="1163513100117217826">
					<input type="hidden" name="parent_id" value=""> <input
						type="hidden" name="nonce" value="54d5e60b6d2a0">
					<div class="ds-textarea-wrapper ds-rounded-top"
						style="color: white;">
						<textarea name="message" title="Ctrl+Enter快捷提交"
							placeholder="说点什么吧…"></textarea>
						<pre class="ds-hidden-text"></pre>
					</div>
					<div class="ds-post-toolbar">
						<div class="ds-post-options ds-gradient-bg">
							<span class="ds-sync"></span>
						</div>
						<button class="ds-post-button" type="submit">发布</button>
						<!-- 						<div class="ds-toolbar-buttons"> -->
						<!-- 							<a class="ds-toolbar-button ds-add-emote" title="插入表情"></a> -->
						<!-- 						</div> -->
					</div>
				</form>
			</div>
			<div class="ds-rounded" id="ds-hot-posts">
				<div class="ds-header ds-gradient-bg">所有评论</div>
				<ul>
					<li class="ds-post" data-post-id="1163513100117215912"><div
							class="ds-post-self" data-post-id="1163513100117215912"
							data-thread-id="1163513100117217826" data-root-id="0"
							data-source="duoshuo">
							<div class="ds-avatar" data-user-id="9930778">
								<a rel="nofollow author" target="_blank" href=""
									onclick="this.href='http://amui.duoshuo.com/user-url/?user_id=9930778';"
									title="cc"><img
									src="http://static.duoshuo.com/images/noavatar_default.png"
									alt="cc"></a>
							</div>
							<div class="ds-comment-body">
								<div class="ds-comment-header">
									<a class="ds-user-name ds-highlight" data-qqt-account=""
										href="" rel="nofollow" target="_blank" data-user-id="9930778">cc</a>
								</div>
								<p>新闻不错哦</p>
								<div class="ds-comment-footer ds-comment-actions">
									<span class="ds-time" datetime="2014-12-05T14:19:40+08:00"
										title="2014年12月5日 下午2:19:40">2014年12月5日</span><a
										class="ds-post-reply" href="javascript:void(0);"><span
										class="ds-icon ds-icon-reply"></span>回复</a><a
										class="ds-post-likes" href="javascript:void(0);"><span
										class="ds-icon ds-icon-like"></span>顶(2)</a><a
										class="ds-post-repost" href="javascript:void(0);"><span
										class="ds-icon ds-icon-share"></span>转发</a>
								</div>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
	﻿
	<%@ include file="../common/footer"%>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/jquery.min.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.js"></script>
</body>
</html>
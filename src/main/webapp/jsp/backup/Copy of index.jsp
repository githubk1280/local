<%-- <%@ page language="java" contentType="text/html; charset=utf-8" --%>
<%-- 	pageEncoding="utf-8"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html class="js cssanimations" style=""> -->
<!-- <head> -->
<!-- <meta charset="utf-8" /> -->
<!-- <meta content="IE=edge" http-equiv="X-UA-Compatible" /> -->
<!-- <title>test-首页</title> -->
<%-- <%@ include file="../common/header"%> --%>
<!-- <style> -->
/* html,body,.page { */
/* 	height: 100%; */
/* } */

/* #wrapper { */
/* 	position: absolute; */
/* 	top: 49px; */
/* 	bottom: 0; */
/* 	overflow: hidden; */
/* 	margin: 0; */
/* 	width: 100%; */
/* 	padding: 0 8px; */
/* 	background-color: #f8f8f8; */
/* } */

/* .am-list { */
/* 	margin: 0; */
/* } */

/* .am-list>li { */
/* 	background: none; */
/* 	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.8); */
/* } */

/* .pull-action { */
/* 	text-align: center; */
/* 	height: 45px; */
/* 	line-height: 45px; */
/* 	color: #999; */
/* } */

/* .pull-action .am-icon-spin { */
/* 	display: none; */
/* } */

/* .pull-action.loading .am-icon-spin { */
/* 	display: block; */
/* } */

/* .pull-action.loading .pull-label { */
/* 	display: none; */
/* } */
<!-- </style> -->
<!-- </head> -->
<!-- <body class="am-with-fixed-navbar" style="" onload="getFirst()"> -->
<!-- 	<!--[if lte IE 9]> -->
<!-- <p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，我们不提供支持。 请升级浏览器</a> -->
<!--   以获得更好的体验！</p> -->
<!-- <![endif]--> -->
<%-- 	<%@ include file="../common/nav"%> --%>
<!-- 	<div class="doc-example"> -->
<%-- 		<input type="hidden" value="${upStartId}" id="upStartId" /> <input --%>
<%-- 			type="hidden" value="${downStartId}" id="downStartId" /> --%>
<!-- 		<button class="am-btn am-btn-default am-btn-block btn-loading-example" -->
<!-- 			type="button" id="clickMore">点击加载更多</button> -->
<!-- 	</div> -->
<!-- 	<div class="am-list-news am-list-news-default" -->
<!-- 		data-am-widget="list_news"> -->
<!-- 		<div class="am-list-news-bd"> -->
<!-- 			<ul class="am-list" id="allEvents"> -->
			
<!-- 			</ul> -->
<!-- 		</div> -->
<!-- 	</div> -->

<!-- 	<div class="doc-example"> -->
<%-- 		<input type="hidden" value="${upStartId}" id="upStartId" /> <input --%>
<%-- 			type="hidden" value="${downStartId}" id="downStartId" /> --%>
<!-- 		<button class="am-btn am-btn-default am-btn-block btn-loading-example" -->
<!-- 			type="button" id="clickMore">点击加载更多</button> -->
<!-- 	</div> -->

<%-- 	<%@ include file="../common/footer"%> --%>
<!-- 	<script -->
<!-- 		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/jquery.min.js"></script> -->
<!-- 	<script -->
<!-- 		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.js"></script> -->
<!-- 	<script -->
<!-- 		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/handlebars.min.js"></script> -->
<!-- 	<script -->
<!-- 		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.widgets.helper.js"></script> -->
<!-- 	<script type="text/javascript"> -->
// 		function getFirst(){
// 			queryEvent($('#downStartId').val()-1);
// 		}
// 		$('.btn-loading-example').click(
// 			function() {
// 				var $btn = $(this);
// 				var downStartId = $('#downStartId');
// 				$btn.button('loading');
// 				queryEvent(downStartId.val()+1);
// 			});
		
// 		function queryEvent(id){
// 			$.ajax({
// 				type : 'get',
// 				url : '/local/event/ajax/down/'
// 						+ (Number.parseInt(id)+1),
// 				success : function(response) {
// 					var data = JSON.parse(JSON
// 							.parse(response).data);
// 					var parent = $('#allEvents');
// 					if (data && data.length < 1) {
// 						$('#clickMore')[0].innerHTML = '没有更多了,不如发一个<i class="am-header-icon am-icon-camera" style="font-size: 150%;"></i>';
// 						return;
// 					}
// 					$(data)
// 							.each(
// 									function(index,
// 											event) {
// 										var li = '<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-top">'
// 												+ '<div class="am-list-main">'
// 												+ '<h3 class="am-list-item-hd">'
// 												+ event.content
// 												+ '</h3>'
// 												+ '<div class="am-list-item-text"></div>'
// 												+ '</div>';
// 										if (event.pics) {
// 											li += '<div class="am-list-thumb am-u-sm-12">';
// 											li += '<img src="${event.pics }"></div>';
// 										}
// 										li += '<div class="am-list-thumb am-u-sm-12">';
// 										li += event.createTime
// 												+ '| 来源： '
// 												+ event.from
// 												+ event.id
// 												+ '</div>';
// 										li += '<div class="am-list-thumb am-u-sm-12">';
// 										li += '<a href=""><i class="am-icon-thumbs-o-up am-icon-sm"></i>('
// 												+ event.zanCount
// 												+ ')</a>&nbsp';
// 										li += '<a href=""><i class="am-icon-thumbs-o-down am-icon-sm"></i>('
// 												+ event.zanCount
// 												+ ')</a>&nbsp';
// 										li += '<a href="http://fontawesome.io/icon/comments-o"><i class="am-icon-comments-o am-icon-sm"></i> 评论(20)</a></div></li>';
// 										parent
// 												.append(li);
// 										if (index == data.length - 1) {
// 											downStartId
// 													.attr(
// 															'value',
// 															event.id);
// 										}
// 									});
// 					$btn.button('reset');
// 				},
// 				error : function(error) {
// 					$('.btn-loading-example').button('请重试');
// 				},
// 			});
// 		}
<!-- 	</script> -->
<!-- </body> -->
<!-- </html> -->
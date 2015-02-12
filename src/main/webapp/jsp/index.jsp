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
<body class="am-with-fixed-navbar" style="" onload="getFirst()">
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，我们不提供支持。 请升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<%@ include file="../common/nav"%>
	<div class="am-list-news am-list-news-default"
		data-am-widget="list_news">
		<div class="am-list-news-bd">
			<ul class="am-list" id="allEvents">
			</ul>
		</div>
	</div>

	<div class="doc-example">
		<input type="hidden" value="${upStartId}" id="upStartId" /> <input
			type="hidden" value="${downStartId}" id="downStartId" />
		<button class="am-btn am-btn-default am-btn-block btn-loading-example"
			type="button" id="clickMore">点击加载更多</button>
	</div>

	<%@ include file="../common/footer"%>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/jquery.min.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.min.js"></script>
	<script type="text/javascript">
		function loveIt(id) {
			$.ajax({
				type : 'post',
				url : '/local/event/ajax/incr/love/' + id,
				success : function(response) {
					indrLove(id);
				},
				error : function(error) {
					indrLove(id);
				}
			});
		}
		function indrLove(id) {
			var currHtml = $('#love_' + id).html();
			var pattern = /\d+/;
			var num = currHtml.match(pattern);
			var replaceStr = '<i class="am-icon-heart"></i>赞(';
			replaceStr += (parseInt(num) + 1) + ")";
			$('#love_' + id).html(replaceStr);
			$('#love_' + id).click(function(e) {
				e.preventDefault();
			});
		}
		function getFirst() {
			queryEvent($('#downStartId').val());
		}
		$('.btn-loading-example').click(function() {
			var $btn = $(this);
			var downStartId = $('#downStartId');
			$btn.button('loading');
			queryEvent(downStartId.val());
		});
		function cutContent(content) {
			if (content && content.length > 22) {
				content = content.substring(0, 15);
				content += '。。。(详情)';
			}
			return content;
		}
		function forwardTo(id) {
			location.href = location.origin + "/local/event/detail/" + id;
		}
		function queryEvent(id) {
			var btn = $('.btn-loading-example');
			$
					.ajax({
						type : 'get',
						url : '/local/event/ajax/down/' + id,
						success : function(response) {
							var data = JSON.parse(JSON.parse(response).data);
							var parent = $('#allEvents');
							if (data && data.length < 1) {
								$('#clickMore')[0].innerHTML = '没有更多了,不如发一个<i class="am-header-icon am-icon-camera" style="font-size: 150%;"></i>';
								return;
							}
							$(data)
									.each(
											function(index, event) {
												var li = '';
												if (event.pics) {
													li = '<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right">';
													li += '<div class="am-u-sm-8 am-list-main" >'
															+ '<h3 class="am-list-item-hd">'
															+ '<a href="event/detail/'+ event.id+'" style="color: black">'
															+ cutContent(event.content)
															+ '</a></h3>';
													li += '<div class="am-list-item-text" style="color:#999;font-size:12px;margin-bottom: 0.8rem;padding: 0"><br/>';
													li += timeStamp2String(event.createTime);
// 													li += '<a href="javascript:loveIt('
// 															+ event.id
// 															+ ')" style="color:#999" id="love_'
// 															+ event.id
// 															+ '"><i class="am-icon-heart-o"></i>赞('
// 															+ event.zanCount
// 															+ ')</a>'
// 															+ '&nbsp;&nbsp;&nbsp;&nbsp;<a href="event/detail/'+ event.id+'" style="color:#999" id="review_'
// 															+ event.id
// 															+ '"><i class="am-icon-reply"></i>评论(10)</a>';
													li += '</div>';
													li += '</div>';
													li += '<div class="am-u-sm-4 am-list-thumb" onclick="forwardTo('
															+ event.id
															+ ')" style="max-height: 80px;max-width: 100px;">'
															+ '<img src="http://7u2mg0.com1.z0.glb.clouddn.com/'+event.pics+'-small" style="border-radius: 3px;width: 120px;height: 84px" alt=""> </div>';
													li += '</li>';
												} else {
													li = '<li class="am-g am-list-item-thumbed am-list-item-thumb-top">'
															+ '<div class="am-list-main">'
															+ '<h3 class="am-list-item-hd">'
															+ event.content
															+ '</h3><br/>'
															+ '<div class="am-list-item-text"></div>'
															+ '</div>';
													if (event.pics) {
														li += '<div class="am-list-thumb am-u-sm-12">';
														li += '<img src="http://7u2mg0.com1.z0.glb.clouddn.com/'+event.pics+'-sy" style="border-radius: 3px;"></div>';
													}

													li += '<div class="am-u-sm-12" style="color:#999;font-size:12px;margin-bottom: 0.8rem;padding: 0">';
													li += timeStamp2String(event.createTime)
// 															+ '&nbsp;&nbsp;<a href="javascript:loveIt('
// 															+ event.id
// 															+ ')" style="color:#999" id="love_'
// 															+ event.id
// 															+ '"><i class="am-icon-heart-o"></i>赞('
// 															+ event.zanCount
// 															+ ')</a>'
// 															+ '&nbsp;&nbsp;&nbsp;&nbsp;<a href="event/detail/'+ event.id+'" style="color:#999" id="review_'
// 															+ event.id
// 															+ '"><i class="am-icon-reply"></i>评论(10)</a>';
// 													+'&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" style="color:#999" id="view_'
// 															+ event.id
// 															+ '"><i class="am-icon-eye"></i>阅(10)</a>';
													if (event.from
															&& event.from != 'website') {
														li += ' | 来源:'
																+ event.from;
													}
													li += '</div></li>';
												}
												parent.append(li);
												if (index == data.length - 1) {
													$('#downStartId').attr(
															'value', event.id);
												}
											});
							btn.button('reset');
						},
						error : function(error) {
							btn.button('请重试');
						}
					});
		}
		function timeStamp2String(time) {
			var datetime = new Date();
			datetime.setTime(time);
			var year = datetime.getFullYear();
			var month = datetime.getMonth() + 1 < 10 ? "0"
					+ (datetime.getMonth() + 1) : datetime.getMonth() + 1;
			var date = datetime.getDate() < 10 ? "0" + datetime.getDate()
					: datetime.getDate();
			var hour = datetime.getHours() < 10 ? "0" + datetime.getHours()
					: datetime.getHours();
			var minute = datetime.getMinutes() < 10 ? "0"
					+ datetime.getMinutes() : datetime.getMinutes();
			var second = datetime.getSeconds() < 10 ? "0"
					+ datetime.getSeconds() : datetime.getSeconds();
			return year + "-" + month + "-" + date + " " + hour + ":" + minute
					+ ":" + second;
		}
	</script>
</body>
</html>
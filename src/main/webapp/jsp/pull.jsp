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
<style>
    html,
    body,
    .page {
      height: 100%;
    }

    #wrapper {
      position: absolute;
      top: 49px;
      bottom: 0;
      overflow: hidden;
      margin: 0;
      width: 100%;
      padding: 0 8px;
      background-color: #f8f8f8;
    }

    .am-list {
      margin: 0;
    }

    .am-list > li {
      background: none;
      box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.8);
    }

    .pull-action {
      text-align: center;
      height: 45px;
      line-height: 45px;
      color: #999;
    }

    .pull-action .am-icon-spin {
      display: none;
    }

    .pull-action.loading .am-icon-spin {
      display: block;
    }

    .pull-action.loading .pull-label {
      display: none;
    }
  </style>
</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，我们不提供支持。 请升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<div class="page">
		<header data-am-widget="header"
			class="am-header am-header-default am-no-layout">
			<h1 class="am-header-title">同城 - 音乐</h1>
		</header>

		<div id="wrapper" data-am-widget="list_news"
			class="am-list-news am-list-news-default am-no-layout">
			<div class="am-list-news-bd"
				style="transition-timing-function: cubic-bezier(0.1, 0.57, 0.1, 1); -webkit-transition-timing-function: cubic-bezier(0.1, 0.57, 0.1, 1); transition-duration: 0ms; -webkit-transition-duration: 0ms; transform: translate(0px, -45px) translateZ(0px);">
				<div class="pull-action" id="pull-down">
					<span class="am-icon-arrow-down pull-label" id="pull-down-label">
						下拉刷新</span> <span class="am-icon-spinner am-icon-spin"></span>
				</div>
				<ul class="am-list" id="events-list">


					<li class="am-list-item-desced" data-id="23598609"><a
						href="http://www.douban.com/event/23598609/"
						class="am-list-item-hd" target="_blank">南无乐队2015最新专辑《春来了》唱片首发式</a>

						<div class="am-list-item-text">【时间】2015年3月21日 （周六） 21：00
							【地点】北京MAO Livehouse（北京市东城区鼓楼东大街111号） 【票价】预售80/现场100元
							【VIP礼包】预售321元（限十位）
							包含现场门票一张（价值100元），《春来了》实体专辑一张（价值80元），南无周边礼包一份，after party特别邀请涵
							【预购方式】 1、手机购票扫描相册第一张二维码 2、下载黑马LIVE应用APP，直接购买。下载方式： ①直接扫描相册第二张图片
							②在各应用市场直接搜索“黑马票务”获取下载 ———————————————————————— ■关于南无乐队《春来了》首发专场演出

							在每一个春夏秋冬不断更替轮回的日子里，其实我们也在朝着另一个温暖的春天前进。春是万物复苏之时，过去所有陈杂不安在这之前结束，全新的生命又从愉悦中渐渐醒来。古语有云，春分有三候“玄鸟至”“雷电鸣”“春雨来”，所以相对于立春，春分之日更是一年里天上地下最重要的日子。

							在距离2014“南无乐队•分你一半”的新专辑预热专场已经过去的半年时间里，我们一直在收集不同年龄段与不同工作领域朋友们的意见，也在不停的推翻自己，，争取把最好的音频录制版本呈现在载体中，实现对大家的承诺。

							所以无论是未经世事的学生，是朝九晚五的白领工作者，是坚守在生产前线的技术工人，还是每天在为柴米油盐精打细算的主妇，或是已经子孙满堂静享晚年的老人家，我们和你们一样，都经历着为每个明天的早饭和梦想而努力的过程。

							可是这个充满神奇和未解之谜的世界，永远都有17岁的孩子，却不会有人永远17岁。所以，南无只是想和你们，用最简单的方式，让这个还算温暖的春天值得回忆。

							3月21日，春分之时，等你们一起把春“叫”来。 ———————————————————————— ■关于南无乐队

							南无乐队成立于2007年。他们汲取中国文化的根基营养，寻求中西音乐多元的表达手段，创造出富有中国美学韵味、青年幽默特色、中西元素融合的杂交再生品种，这种风格被乐队称之为“南无文艺”。

							南无乐队除了在音乐上拥有独特的魅力以外，其现场表演力、舞台渲染力、舞台外的亲和力也深深吸引着每个年龄段及地域，和各个工作领域的人，可谓是男女通吃，老少皆宜。

							乐队遵循思考之独立、艺术之跨界的“南无文艺”大路线，力求将南无的正能量同时渗透进音乐、表演、写作、设计、绘画等领域，因此南无乐队也是一支中西多元化碰撞与发展的全民乐队。

							作为新全民互动时代的领军人物，南无乐队的作品表达着中国年轻人对于自身与社会生活的深度思考，真诚自然简单不矫情的吟唱出那些潜伏于市井的小故事、大道理，以与时俱进的音乐方式和全民互动的独特现场表现形式获得了不同领域观众的接受、理解与共鸣。

							无论在主流媒体频道，还是万人欢呼的音乐节舞台，又或是面对面的livehouse演出，南无乐队都用他们最真诚的心和热情感染着每一个熟悉或陌生的观众，大家更是以自发的形式将这一股欢乐的正能量带到身边更多的朋友当中去，真正实现了全民南无。

							————————————————————————————— 马上去相册里扫码吧！！！GO GO GO！</div></li>
				</ul>
				<div class="pull-action" id="pull-up">
					<span class="am-icon-arrow-down pull-label" id="pull-up-label">
						上拉加载更多</span> <span class="am-icon-spinner am-icon-spin"></span>
				</div>
			</div>
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
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/handlebars.min.js"></script>
	<script
		src="http://7u2o1z.com1.z0.glb.clouddn.com/assets/js/amazeui.widgets.helper.js"></script>
	<script type="text/javascript">
		$('.btn-loading-example')
				.click(
						function() {
							var $btn = $(this);
							var downStartId = $('#downStartId');
							$btn.button('loading');
							$
									.ajax({
										type : 'get',
										url : '/local/event/ajax/down/'
												+ downStartId.val(),
										success : function(response) {
											var data = JSON.parse(JSON
													.parse(response).data);
											var parent = $('#allEvents');
											if (data && data.length < 1) {
												$('#clickMore')[0].innerHTML = '没有更多了,不如发一个<i class="am-header-icon am-icon-camera" style="font-size: 150%;"></i>';
												return;
											}
											$(data)
													.each(
															function(index,
																	event) {
																var li = '<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-top">'
																		+ '<div class="am-list-main">'
																		+ '<h3 class="am-list-item-hd">'
																		+ event.content
																		+ '</h3>'
																		+ '<div class="am-list-item-text"></div>'
																		+ '</div>';
																if (event.pics) {
																	li += '<div class="am-list-thumb am-u-sm-12">';
																	li += '<img src="${event.pics }"></div>';
																}
																li += '<div class="am-list-thumb am-u-sm-12">';
																li += event.createTime
																		+ '| 来源： '
																		+ event.from
																		+ event.id
																		+ '</div>';
																li += '<div class="am-list-thumb am-u-sm-12">';
																li += '<a href=""><i class="am-icon-thumbs-o-up am-icon-sm"></i>赞('
																		+ event.zanCount
																		+ ')</a>&nbsp';
																li += '<a href=""><i class="am-icon-thumbs-o-down am-icon-sm"></i>Shi('
																		+ event.zanCount
																		+ ')</a>&nbsp';
																li += '<a href="http://fontawesome.io/icon/comments-o"><i class="am-icon-comments-o am-icon-sm"></i> 评论(20)</a></div></li>';
																parent
																		.append(li);
																if (index == data.length - 1) {
																	downStartId
																			.attr(
																					'value',
																					event.id);
																}
															});
											$btn.button('reset');
										},
										error : function(error) {
											$btn.button('请重试');
										},
									});
						});
	</script>
	<script type="text/x-handlebars-template" id="tpi-list-item">
  {{#each this}}
  <li class="am-list-item-desced" data-id="{{id}}">
    <a href="{{alt}}" class="am-list-item-hd" target="_blank">{{title}}</a>

    <div class="am-list-item-text">{{content}}</div>
  </li>
  {{/each}}
</script>
	<script>
		(function($) {
			var EventsList = function(element, options) {
				var $main = $('#wrapper');
				var $list = $main.find('#events-list');
				var $pullDown = $main.find('#pull-down');
				var $pullDownLabel = $main.find('#pull-down-label');
				var $pullUp = $main.find('#pull-up');
				var topOffset = -$pullDown.outerHeight();

				this.compiler = Handlebars.compile($('#tpi-list-item').html());
				this.prev = this.next = this.start = options.params.start;
				this.total = null;

				this.getURL = function(params) {
					var queries = [ 'callback=?' ];
					for ( var key in params) {
						if (key !== 'start') {
							queries.push(key + '=' + params[key]);
						}
					}
					queries.push('start=');
					return options.api + '?' + queries.join('&');
				};

				this.renderList = function(start, type) {
					var _this = this;
					var $el = $pullDown;

					if (type === 'load') {
						$el = $pullUp;
					}

					$.getJSON(this.URL + start).then(function(data) {
						console.log(data);
						_this.total = data.total;
						var html = _this.compiler(data.events);
						if (type === 'refresh') {
							$list.children('li').first().before(html);
						} else if (type === 'load') {
							$list.append(html);
						} else {
							$list.html(html);
						}

						// refresh iScroll
						setTimeout(function() {
							_this.iScroll.refresh();
						}, 100);
					}, function() {
						console.log('Error...')
					}).always(
							function() {
								_this.resetLoading($el);
								if (type !== 'load') {
									_this.iScroll.scrollTo(0, topOffset, 800,
											$.AMUI.iScroll.utils.circular);
								}
							});
				};

				this.setLoading = function($el) {
					$el.addClass('loading');
				};

				this.resetLoading = function($el) {
					$el.removeClass('loading');
				};

				this.init = function() {
					var myScroll = this.iScroll = new $.AMUI.iScroll(
							'#wrapper', {});
					// myScroll.scrollTo(0, topOffset);
					var _this = this;
					var pullFormTop = false;
					var pullStart;

					this.URL = this.getURL(options.params);
					this.renderList(options.params.start);

					myScroll.on('scrollStart', function() {
						if (this.y >= topOffset) {
							pullFormTop = true;
						}

						pullStart = this.y;
						// console.log(this);
					});

					myScroll.on('scrollEnd', function() {
						if (pullFormTop && this.directionY === -1) {
							_this.handlePullDown();
						}
						pullFormTop = false;

						// pull up to load more
						if (pullStart === this.y && (this.directionY === 1)) {
							_this.handlePullUp();
						}
					});
				};

				this.handlePullDown = function() {
					console.log('handle pull down');
					if (this.prev > 0) {
						this.setLoading($pullDown);
						this.prev -= options.params.count;
						this.renderList(this.prev, 'refresh');
					} else {
						console.log('别刷了，没有了');
					}
				};

				this.handlePullUp = function() {
					console.log('handle pull up');
					if (this.next < this.total) {
						this.setLoading($pullUp);
						this.next += options.params.count;
						this.renderList(this.next, 'load');
					} else {
						console.log(this.next);
						// this.iScroll.scrollTo(0, topOffset);
					}
				}
			};

			$(function() {
				var app = new EventsList(null, {
					api : 'https://api.douban.com/v2/event/list',
					params : {
						start : 100,
						type : 'music',
						count : 10,
						loc : 'beijing'
					}
				});
				app.init();
			});

			document.addEventListener('touchmove', function(e) {
				e.preventDefault();
			}, false);
		})(window.jQuery);
	</script>
</body>
</html>
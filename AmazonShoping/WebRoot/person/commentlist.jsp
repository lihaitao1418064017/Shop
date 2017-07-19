
<%@page import="com.shop.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.service.ItemService"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>发表评论</title>

<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="../css/personal.css" rel="stylesheet" type="text/css">
<link href="../css/appstyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../js1/cookie.js"></script>
<script type="text/javascript" src="../js1/commentList.js"></script>
</head>

<body>
	<!--头 -->
	<header>
		<article>
			<div class="mt-logo">
				<!--顶部导航条 -->
				<div class="am-container header">
					<ul class="message-l">
						<div class="topMessage">
							<div class="menu-hd">
								<a href="#" target="_top" class="h" class="h1">亲，请登录</a> <a
									href="#" target="_top">免费注册</a>
							</div>
						</div>
					</ul>
					<ul class="message-r">
						<div class="topMessage home">
							<div class="menu-hd">
								<a href="#" target="_top" class="h">商城首页</a>
							</div>
						</div>
						<div class="topMessage my-shangcheng">
							<div class="menu-hd MyShangcheng">
								<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
							</div>
						</div>
						<div class="topMessage mini-cart">
							<div class="menu-hd">
								<a id="mc-menu-hd" href="#" target="_top"><i
									class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
									id="J_MiniCartNum" class="h">0</strong></a>
							</div>
						</div>
						<div class="topMessage favorite">
							<div class="menu-hd">
								<a href="#" target="_top"><i
									class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
							</div>
					</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logoBig">
						<li><img src="../images/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form>
							<input id="searchInput" name="index_none_header_sysc" type="text"
								placeholder="搜索" autocomplete="off"> <input
								id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
								type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			</div>
		</article>
	</header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="#">首页</a></li>
				<li class="qc"><a href="#">闪购</a></li>
				<li class="qc"><a href="#">限时抢</a></li>
				<li class="qc"><a href="#">团购</a></li>
				<li class="qc last"><a href="#">大包装</a></li>
			</ul>
			<div class="nav-extra">
				<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利 <i
					class="am-icon-angle-right" style="padding-left: 10px;"></i>
			</div>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="user-comment">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">发表评论</strong> / <small>Make&nbsp;Comments</small>
						</div>
					</div>
					<hr />

					<div class="comment-main">

						<%
							Cookie cookies[] = request.getCookies();
									    Cookie sCookie = null;
										String svalue = null;
										String sname = null;
										for (int i = 0; i < cookies.length; i++) { //用一个循环语句遍历刚才建立的Cookie对象数组
											sCookie = cookies[i]; //取出数组中的一个Cookie对象
											sname = sCookie.getName(); //取得这个Cookie的名字
											if (sname.equals("name")) {
												svalue = sCookie.getValue(); //取得这个Cookie的内容
											}
										}
										List<Product> list=ItemService.getSuccessItem(svalue);
										for(int i=0;i<list.size();i++)
										{
						%>
						<div class="comment-list">
							<div class="item-pic">
								<a href="#" class="J_MakePoint"> <img
									src="<%=list.get(i).getPhoto()%>" class="itempic"
									id="image<%=i%>">
								</a>
							</div>

							<div class="item-title">

								<div class="item-name">
									<a href="#">
										<p class="item-basic-info" id="des<%=i%>"><%=list.get(i).getName()%></p>
									</a>
								</div>
								<div class="item-info">
									<div class="info-little">
										<span id="yanse<%=i%>"><%=list.get(i).getTaste()%></span> <span
											id="pack">包装：<%=list.get(i).getPack()%></span>
									</div>
									<div class="item-price">
										价格：<strong id="price<%=i%>"><%=list.get(i).getPrice()%></strong>
									</div>
								</div>
							</div>
							<div class="clear"></div>
							<div class="item-comment">
								<textarea id="text<%=i%>" placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea>
							</div>
							<div class="filePic">
								<input type="file" class="inputPic"
									allowexts="gif,jpeg,jpg,png,bmp" accept="image/*"> <span>晒照片(0/5)</span>
								<img src="../images/image.jpg" alt="">
							</div>
							<div class="item-opinion">
								<li><i class="op1"></i>好评</li>
								<li><i class="op2"></i>中评</li>
								<li><i class="op3"></i>差评</li>
							</div>
						</div>
						<%
							}
						%>
					</div>
					<div class="info-btn">
						<div class="am-btn am-btn-danger" id="fabiao">发表评论</div>
					</div>



				</div>

			</div>
			<script type="text/javascript">
				$(document).ready(function() {
					$(".comment-list .item-opinion li").click(function() {
						$(this).prevAll().children('i').removeClass("active");
						$(this).nextAll().children('i').removeClass("active");
						$(this).children('i').addClass("active");

					});
				})
			</script>




			<!--底部-->
			<div class="footer">
				<div class="footer-hd">
					<p></p>
				</div>
				<div class="footer-bd"></div>
			</div>
		</div>

		<aside class="menu">
			<ul>
				<li class="person"><a href="index.jsp">个人中心</a></li>
				<li class="person"><a href="#">个人资料</a>
					<ul>
						<li><a href="information.jsp">个人信息</a></li>
						<li><a href="safety.jsp">安全设置</a></li>
						<li><a href="address.jsp">收货地址</a></li>
					</ul></li>
				<li class="person"><a href="#">我的交易</a>
					<ul>
						<li><a href="order.jsp">订单管理</a></li>
						<li><a href="change.jsp">退款售后</a></li>
					</ul></li>
				<li class="person"><a href="#">我的资产</a>
					<ul>
						<li><a href="coupon.jsp">优惠券 </a></li>
						<li><a href="bonus.jsp">红包</a></li>
						<li><a href="bill.jsp">账单明细</a></li>
					</ul></li>

				<li class="person"><a href="#">我的小窝</a>
					<ul>
						<li><a href="collection.jsp">收藏</a></li>
						<li><a href="foot.jsp">足迹</a></li>
						<li class="active"><a href="comment.jsp">评价</a></li>
						<li><a href="news.jsp">消息</a></li>
					</ul></li>

			</ul>

		</aside>
	</div>

</body>

</html>
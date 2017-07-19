<%@page import="com.shop.model.*"%>
<%@page import="com.shop.service.ItemService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>订单管理</title>

<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">
<link href="../css/personal.css" rel="stylesheet" type="text/css">
<link href="../css/orstyle.css" rel="stylesheet" type="text/css">
<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../js1/cookie.js"></script>
<script type="text/javascript" src="../js1/order.js"></script>

 


</head>
<body>
	<!--头 -->
	<header> <article>
	<div class="mt-logo">
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">

						<a href="#" target="_top" class="h1">亲，请登录</a> <a href="#"
							target="_top">免费注册</a>
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
						<a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
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
	</article> </header>
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

				<div class="user-order">

					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small>
						</div>
					</div>
					<hr />

					<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

						<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active"><a href="#tab1">所有订单</a></li>
							<li><a href="#tab2">待付款</a></li>
							<li><a href="#tab3">待发货</a></li>
							<li><a href="#tab4">待收货</a></li>
							<li><a href="#tab5">待评价</a></li>
						</ul>

						<div class="am-tabs-bd">

							<!-- 所有订单 -->

							<div class="am-tab-panel am-fade am-in am-active" id="tab1">

								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">

										<!--交易成功-->
										<div class="order-status5">
											<div class="order-title">
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
													List<Product> sureList = ItemService.getSureSuccessItemInfo(svalue);
													
													List<Item> itemList = ItemService.getItemInfos(svalue);
													List<Product> list = ItemService.getSuccessItemInfo(svalue);
													if (list.size() != 0) {
												%>
												<div class="dd-num">
													订单编号：<a href="javascript:;"><%=itemList.get(0).getId()%></a>
												</div>
												<span>成交时间：<%=itemList.get(0).getTime()%></span>
												<!--    <em>店铺：小桔灯</em>-->
												<%
													}
												%>
											</div>


											<div class="order-content">
												<div class="order-left">
													<%
														//获取订单交易成功的

														for (int i = 0; i < list.size(); i++) {
													%>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="<%=list.get(i).getPhoto()%>"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p><%=list.get(i).getName()%></p>
																		<p class="info-little">
																			品牌：<%=list.get(i).getDescriptive()%>
																			<br />包装：<%=list.get(i).getPack()%>
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price"><%=list.get(i).getPrice()%></div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span><span id="sum">3</span>
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation"></div>
														</li>
													</ul>
													<%
														}
													%>



												</div>
												<%
													if (list.size() != 0) {
												%>
												<div class="order-right">
													<!-- <li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li> -->

													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<h3 class="Mystatus" style="color:green;">交易成功</h3>

															</div>
														</li>
														<li class="td td-status">
															<div class="item-status">
																<a href="orderinfo.jsp">订单详情</a>


															</div>
														</li>
														<li class="td td-status">
															<div class="item-status">
																<a href="logistics.jsp">查看物流</a>


															</div>
														</li>


													</div>
												</div>


												<%
													}
												%>
											</div>
										</div>



										<!--交易失败-->
										<div class="order-status0">

											<div class="order-title">
												<%
													List<Product> failList = ItemService.getFailItemInfo(svalue);
													if (failList.size() != 0) {
												%>
												<div class="dd-num">
													订单编号：<a href="javascript:;"><%=itemList.get(itemList.size() - 1).getId()%></a>
												</div>
												<span>成交时间：<%=itemList.get(itemList.size() - 1).getTime()%></span>
												<!--    <em>店铺：小桔灯</em>-->


												<%
													}
												%>
											</div>

											<div class="order-content">
												<div class="order-left">

													<%
														//得到交易失败的产品
														for (int i = 0; i < failList.size(); i++) {
													%>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="<%=failList.get(i).getPhoto()%>"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p><%=failList.get(0).getName()%></p>
																		<p class="info-little">
																			品牌：<%=failList.get(i).getDescriptive()%>
																			<br />包装：<%=failList.get(i).getPack()%>
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price"><%=failList.get(i).getPrice()%></div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span><span id="sum">2</span>
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation"></div>
														</li>
													</ul>
													<%
														}
													%>



												</div>
												<%
													if (failList.size() != 0) {
												%>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：116.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">交易关闭</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu" id="delete">删除订单</div>
														</li>
													</div>
												</div>

												<%
													}
												%>
											</div>
										</div>

										<!--待发货-->
										<div class="order-status2">
											<!-- <div class="order-title">
												<div class="dd-num">
													订单编号：<a href="javascript:;">1601430111111111111</a>
												</div>
												<span>成交时间：2015-12-20</span>
												   <em>店铺：小桔灯</em>
											</div>
											<div class="order-content">
												<div class="order-left">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">

															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款</a>
															</div>
														</li>
													</ul>
												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">买家已付款</p>
																<p class="order-info">
																	<a href="orderinfo.jsp">订单详情</a>
																</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu">提醒发货</div>
														</li>
													</div>
												</div>
											</div> -->
										</div>

										<!--不同状态订单-->
										<div class="order-status3">
											<!-- <div class="order-title">
												<div class="dd-num">
													订单编号：<a href="javascript:;">1601430</a>
												</div>
												<span>成交时间：2015-12-20</span>
												   <em>店铺：小桔灯</em>
											</div> -->
											<div class="order-content">
												<div class="order-left">
													<!-- <ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款/退货</a>
															</div>
														</li>
													</ul> -->

													<!-- <ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款/退货</a>
															</div>
														</li>
													</ul> -->

												</div>
												<div class="order-right">
													<!-- <li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">卖家已发货</p>
																<p class="order-info">
																	<a href="orderinfo.jsp">订单详情</a>
																</p>
																<p class="order-info">
																	<a href="logistics.jsp">查看物流</a>
																</p>
																<p class="order-info">
																	<a href="#">延长收货</a>
																</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu" id="querenshouhuo">确认收货</div>
														</li>
													</div> -->
												</div>
											</div>

										</div>

									</div>

								</div>

							</div>

							<!--代付款  -->

							<div class="am-tab-panel am-fade" id="tab2">

								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>



								<div class="order-main">
									<div class="order-list">
										<div class="order-status1">


											<div class="order-title">
												<%
													if (failList.size() != 0) {
												%>
												<div class="dd-num">
													订单编号：<a href="javascript:;"><%=failList.get(0).getId()%></a>
												</div>
												<span>成交时间：<%=itemList.get(0).getTime()%></span> <em>店铺：小桔灯111111</em>
												<%
													}
												%>
											</div>
											<div class="order-content">
												<div class="order-left">
													<%
														//待发货产品
														for (int i = 0; i < failList.size(); i++) {
													%>


													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="<%=failList.get(i).getPhoto()%>"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p><%=failList.get(i).getName()%></p>
																		<p class="info-little">
																			品牌：
																			<%=failList.get(i).getDescriptive()%>
																			<br />包装：<%=failList.get(i).getPack()%>
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price"><%=failList.get(i).getPrice()%></div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation"></div>
														</li>
													</ul>
													<%
														}
													%>
													<!-- <ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation"></div>
														</li>
													</ul> -->

													<!-- <ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation"></div>
														</li>
													</ul> -->
												</div>
												<div class="order-right">

													<%
														if (failList.size() != 0) {
													%>
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">等待买家付款</p>
																<p class="order-info">
																	<a href="#">取消订单</a>
																</p>

															</div>
														</li>
														<li class="td td-change"><a href="../home/pays.jsp">
																<div class="am-btn am-btn-danger anniu">一键支付</div>
														</a></li>
													</div>
													<%
														}
													%>
												</div>

											</div>
										</div>
									</div>

								</div>
							</div>

							<!--代发货  -->


							<div class="am-tab-panel am-fade" id="tab3">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
										<div class="order-status2">
											<div class="order-title">
											
											<%
											if(list.size()!=0)
											{
											%>
												<div class="dd-num">
													订单编号：<%=itemList.get(0).getId()%>
													<a href="javascript:;"> </a>
												</div>
												<span>成交时间：<%=itemList.get(0).getTime()%></span>
												<!--    <em>店铺：小桔灯</em>-->
												<%
												
											}
												%>
											</div>
											<div class="order-content">
												<div class="order-left">

													<%
														for (int i = 0; i < list.size(); i++) {
													%>
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="<%=list.get(i).getPhoto()%>"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p><%=list.get(i).getName()%></p>
																		<p class="info-little">
																			<%=list.get(i).getType()%>
																			<br />包装：<%=list.get(i).getPack()%>
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price"><%=list.get(i).getPrice()%></div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款</a>
															</div>
														</li>
													</ul>
													<%
														}
													%>
													<!-- <ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款</a>
															</div>
														</li>
													</ul> -->

													<!-- 			<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款</a>
															</div>
														</li>
													</ul> -->
												</div>
												<div class="order-right">
												<%if(list.size()!=0)
													{
													
													%>
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">买家已付款</p>
																<p class="order-info">
																	<a href="orderinfo.jsp">订单详情</a>
																</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu" id="tixingfahuo">提醒发货</div>
														</li>
													</div>
													<%
													}%>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<!--待收货  -->

							<div class="am-tab-panel am-fade" id="tab4">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
										<div class="order-status3">
											<div class="order-title">
											<%if(list.size()!=0)
												{%>
												<div class="dd-num">
													订单编号：<a href="javascript:;"><%=list.get(0).getId()%></a>
												</div>
												<span>成交时间：<%=list.get(0).getShopTime()%></span>
												<!--    <em>店铺：小桔灯</em>-->
											<%} %>
											</div>
											<div class="order-content">
												<div class="order-left">
													<%
														for (int i = 0; i < list.size(); i++) {
													%>
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="<%=list.get(i).getPhoto()%>"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p><%=list.get(i).getName()%></p>
																		<p class="info-little">
																			<%=list.get(i).getType()%>
																			<br />包装：<%=list.get(i).getPack()%>
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price"><%=list.get(i).getPrice()%></div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款/退货</a>
															</div>
														</li>
													</ul>
													<%
														}
													%>
													<!-- <ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款/退货</a>
															</div>
														</li>
													</ul> -->

												</div>
												<div class="order-right">
												<%if(list.size()!=0){
													%>
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">卖家已发货</p>
																<p class="order-info">
																	<a href="orderinfo.jsp">订单详情</a>
																</p>
																<p class="order-info">
																	<a href="logistics.jsp">查看物流</a>
																</p>
																<p class="order-info">
																	<a href="#">延长收货</a>
																</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu"
																id="querenshouhuo">确认收货</div>
														</li>
													</div>
													<%
													}%>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<!-- 代评价 -->

							<div class="am-tab-panel am-fade" id="tab5">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>
								<%
									
								%>
								<div class="order-main">
									<div class="order-list">
										<!--不同状态的订单	-->
										<div class="order-status4">
											<div class="order-title">
												<%
													if (sureList.size() != 0) {
												%>
												<div class="dd-num">
													订单编号：<a href="javascript:;">1601430</a>
												</div>
												<span>成交时间：2015-12-20</span>
												<%
													}
												%>
											</div>
											<div class="order-content">
												<div class="order-left">
													<%
														for (int i = 0; i < sureList.size(); i++) {
													%>
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="<%=sureList.get(i).getPhoto()%>"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p><%=sureList.get(i).getName()%></p>
																		<p class="info-little">
																			品牌：<%=sureList.get(i).getType()%><br />包装：<%=sureList.get(i).getPack()%>
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price"><%=sureList.get(i).getPrice()%></div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款/退货</a>
															</div>
														</li>
													</ul>
													<%
														}
													%>
												</div>
												<div class="order-right">
												
												<%
													if (sureList.size() != 0) {
												%>
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">交易成功</p>
																<p class="order-info">
																	<a href="orderinfo.jsp">订单详情</a>
																</p>
																<p class="order-info">
																	<a href="logistics.jsp">查看物流</a>
																</p>
															</div>
														</li>
														<li class="td td-change"><a href="commentlist.jsp">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
														</a></li>
													</div>
													<%
													}%>
												</div>
											</div>
										</div>


										<div class="order-status4">
											<div class="order-title">
												<!-- <div class="dd-num">
													订单编号：<a href="javascript:;">1601430</a>
												</div>
												<span>成交时间：2015-12-20</span> -->
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">
													<!-- <ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款/退货</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款/退货</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.jsp">退款/退货</a>
															</div>
														</li>
													</ul> -->


												</div>
												<div class="order-right">
													<!-- <li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">交易成功</p>
																<p class="order-info">
																	<a href="orderinfo.jsp">订单详情</a>
																</p>
																<p class="order-info">
																	<a href="logistics.jsp">查看物流</a>
																</p>
															</div>
														</li>
														<li class="td td-change"><a href="commentlist.jsp">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
														</a></li>
													</div>-->
												</div> 
											</div>
										</div>


									</div>

								</div>

							</div>
						</div>

					</div>
				</div>
			</div>
			<!--底部-->
			<div class="footer">
				<div class="footer-hd">
					<p></p>
				</div>
				<div class="footer-bd">
					<p></p>
				</div>

			</div>
		</div>
		<aside class="menu">
		<ul>
			<li class="person"><a href="index.jsp">个人中心</a></li>
			<li class="person"><a href="#">个人资料</a>
				<ul>
					<li><a href="information.jsp">个人信息</a></li>
					<li><a href="safety.jsp">安全设置</a></li>
					<li><a href="address.html">收货地址</a></li>
				</ul></li>
			<li class="person"><a href="#">我的交易</a>
				<ul>
					<li class="active"><a href="order.jsp">订单管理</a></li>
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
					<li><a href="foot.html">足迹</a></li>
					<li><a href="comment.jsp">评价</a></li>
					<li><a href="news.jsp">消息</a></li>
				</ul></li>

		</ul>

		</aside>
	</div>

</body>

</html>

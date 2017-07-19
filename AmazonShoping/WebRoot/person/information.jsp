<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>个人资料</title>

<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="../css/personal.css" rel="stylesheet" type="text/css">
<link href="../css/infstyle.css" rel="stylesheet" type="text/css">
<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"
	type="text/javascript"></script>
	
<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"
	type="text/javascript"></script>
	
<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../js1/information.js"></script>

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
								<a href="#" target="_top" class="h">亲，请登录</a> <a href="#"
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

				<div class="user-info">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small>
						</div>
					</div>
					<hr />

					<!--头像 -->
					<div class="user-infoPic">

						<div class="filePic">
							<input type="file" class="inputPic"
								allowexts="gif,jpeg,jpg,png,bmp" accept="image/*"> <img
								class="am-circle am-img-thumbnail"
								src="../images/getAvatar.do.jpg" alt="" />
						</div>

						<p class="am-form-help">头像</p>

						<div class="info-m">
							<div id="user_name">
								<b>用户名：<i>小叮当</i></b>
							</div>
							<div class="u-level">
								<span class="rank r2"> <s class="vip1"></s><a
									class="classes" href="#">铜牌会员</a>
								</span>
							</div>
							<div class="u-safety">
								<a href="safety.jsp"> 账户安全 <span class="u-profile"><i
										class="bc_ee0000" style="width: 60px;" width="0">60分</i></span>
								</a>
							</div>
						</div>
					</div>

					<!--个人信息 -->
					<div class="info-main">
						<form class="am-form am-form-horizontal">

							<div class="am-form-group">
								<label for="user-name2" class="am-form-label">昵称</label>
								<div class="am-form-content">
									<input type="text" class="nickname" id="user-name2"
										placeholder="nickname">

								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-form-label">姓名</label>
								<div class="am-form-content">
									<input type="text" id="user-name2" class="name"
										placeholder="name">

								</div>
							</div>

							<div class="am-form-group">
								<label class="am-form-label">性别</label>
								<div class="am-form-content sex">
									<label class="am-radio-inline"> <input type="radio"
										name="radio10" value="男" data-am-ucheck> 男
									</label> <label class="am-radio-inline"> <input type="radio"
										name="radio10" value="女" data-am-ucheck> 女
									</label> <label class="am-radio-inline"> <input type="radio"
										name="radio10" value="secret" data-am-ucheck> 保密
									</label>
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-birth" class="am-form-label">生日</label>
								<div class="am-form-content birth">
									<div class="birth-select">
										<select class="oYear" data-am-selected>
											<option value="2001">2001</option>
											<option value="2000">2000</option>
											<option value="1999">1999</option>
											<option value="1998">1998</option>
											<option value="1997">1997</option>
											<option value="1996">1996</option>
										</select> <em>年</em>
									</div>
									<div class="birth-select2">
										<select class="oMonth" data-am-selected>
											<option value="12">12</option>
											<option value="11">11</option>
											<option value="10">10</option>
											<option value="9">9</option>
											<option value="8">8</option>
											<option value="7">7</option>
											<option value="6">6</option>
										</select> <em>月</em>
									</div>
									<div class="birth-select2">
										<select class="oDay" data-am-selected>
											<option value="31">31</option>
											<option value="30">30</option>
											<option value="29">29</option>
											<option value="28">28</option>
											<option value="27">27</option>
											<option value="26">26</option>
											<option value="25">25</option>
											<option value="24">24</option>

										</select> <em>日</em>
									</div>
								</div>

							</div>
							<div class="am-form-group">
								<label for="user-phone" class="am-form-label">电话</label>
								<div class="am-form-content">
									<input id="user-phone" class="telephone"
										placeholder="telephonenumber" type="text">

								</div>
							</div>
							<div class="am-form-group">
								<label for="user-email" class="am-form-label">电子邮件</label>
								<div class="am-form-content">
									<input id="user-email" placeholder="Email" class="email"
										type="email">

								</div>
							</div>
							<div class="am-form-group address">
								<label for="user-address" class="am-form-label">收货地址</label>
								<div class="am-form-content address">
									<a href="address.jsp">
										<p class="new-mu_l2cw">
											<span class="province">湖北</span>省 <span class="city">武汉</span>市
											<span class="dist">洪山</span>区 <span class="street">雄楚大道666号(中南财经政法大学)</span>
											<span class="am-icon-angle-right"></span>
										</p>
									</a>

								</div>
							</div>
							<div class="am-form-group safety">
								<label for="user-safety" class="am-form-label">账号安全</label>
								<div class="am-form-content safety">
									<a href="safety.jsp"> <span class="am-icon-angle-right"></span>

									</a>

								</div>
							</div>
							<div class="info-btn">
								<div class="am-btn am-btn-danger">
									<span id="update">保存修改</span>
								</div>
							</div>
							<script>
								
							</script>
						</form>
					</div>

				</div>

			</div>
			<!--底部-->
			<div class="footer">
				<div class="footer-hd">
					<p>
						<a href="#"></a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
							href="#">支付宝</a> <b>|</b> <a href="#"></a>
					</p>
				</div>
				<div class="footer-bd">
					<p>
						<a href="#"></a> <a href="#"></a> <a href="#">联系我们</a> <a href="#"></a>
						<em>© <a href="http://www.cssmoban.com/" target="_blank"
							title="模板之家">模板之家</a> - Collect from <a
							href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
					</p>
				</div>
			</div>
		</div>

		<aside class="menu">
			<ul>
				<li class="person"><a href="index.jsp">个人中心</a></li>
				<li class="person"><a href="#">个人资料</a>
					<ul>
						<li class="active"><a href="information.jsp">个人信息</a></li>
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
						<li><a href="comment.jsp">评价</a></li>
						<li><a href="news.jsp">消息</a></li>
					</ul></li>

			</ul>

		</aside>
	</div>

</body>

</html>
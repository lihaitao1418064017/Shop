
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
		<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>
	<script>
		$(function() {
			$('#register').click(function(){
				doRegister();
			})
			
			
			
		$(document).keypress(function(event) {
			switch (event.keyCode) {
			case 13:
				doRegister();
				break;
			case 27:
				doClear();
				break;
			}
		})
	
		
		function doRegister(){
			var name = $('#email').val();
			var password = $('#password').val();
			var passwordRepeat=$('#passwordRepeat').val();
			if(password!=passwordRepeat||password===""||password===""||name==="")
			{
					alert("密码输入不一致！");
			}else{
			var data={"email":name,"password":password};
			var method="RegisterForShop";
			$.ajax(
			{
			     url:"../warehouseserver/"+method,
			     type:"POST",
			     daType:"json",
			     data:data,
			     success:function(json)
			     {
			        var success = json.success;
                    var message = json.message;
                    var object = json.object;
                    if (!success) {
                        // 显示服务端操作失败返回的消息
                          alert(message);
                    } else {
                    	alert("注册成功");
                        var cval=getCookie("name");
  					
  					 
  					    var exp = new Date(); 
  					    exp.setTime(exp.getTime() - 1); 
  				
  					    document.cookie= "name" + "="+cval+";expires="+exp.toGMTString();
                    	setCookie("name",name,24);
                        // 处理服务端操作成功返回的json数据
                       window.location.href="home.jsp";
                    }
			     },
			     error:function()
			     {
			       alert("网络连接失败，无法获取服务器数据！");
			     }
			})
			}
			}
		
})
	function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + expires+";path=/";
	}
		//获取cookie  
		function getCookie(cname) {
			var name = cname + "=";
			var ca = document.cookie.split(';');
			for (var i = 0; i < ca.length; i++) {
				var c = ca[i].trim();
				if (c.indexOf(name) == 0)
					return c.substring(name.length, c.length);
			}
			return "";
		}	
		
		
	
	</script>

	<body>

		<div class="login-boxtitle">
			<a href="home/demo.html"><img alt="" src="../images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="../images/big.jpg" /></div>
				<div class="login-box">

						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="">邮箱注册</a></li>
								<li><a href="">手机号注册</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
									<form method="post">
										
							   <div class="user-email">
										<label for="email"><i class="am-icon-envelope-o"></i></label>
										<input type="email" name="" id="email" placeholder="请输入邮箱账号">
                 </div>										
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="" id="password" placeholder="设置密码">
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="" id="passwordRepeat" placeholder="确认密码">
                 </div>	
                 
                 </form>
                 
								 <div class="login-links">
										<label for="reader-me">
											<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
							  	</div>
										<div class="am-cf">
											<input type="submit" name=""   id="register" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>

								</div>

								<div class="am-tab-panel">
									<form method="post">
                 <div class="user-phone">
								    <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
								    <input type="tel" name="" id="phone" placeholder="请输入手机号">
                 </div>																			
										<div class="verification">
											<label for="code"><i class="am-icon-code-fork"></i></label>
											<input type="tel" name="" id="code" placeholder="请输入验证码">
											<a class="btn" href="javascript:void(0);" onclick="sendMobileCode();" id="sendMobileCode">
												<span id="dyMobileButton">获取</span></a>
										</div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="" id="password" placeholder="设置密码">
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="" id="passwordRepeat" placeholder="确认密码">
                 </div>	
									</form>
								 <div class="login-links">
										<label for="reader-me">
											<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
							  	</div>
										<div class="am-cf">
											<input type="submit" id="register" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>
								
									<hr>
								</div>

								<script>
									$(function() {
									    $('#doc-my-tabs').tabs();
									  })
								</script>

							</div>
						</div>

				</div>
			</div>
			
					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# "></a>
								<b>|</b>
								<a href="# ">商城首页</a>
								<b>|</b>
								<a href="# ">支付宝</a>
								<b>|</b>
								<a href="# "></a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="# "></a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# "></a>
								<em>©  <a href="http://www.cssmoban.com/" target="_blank" title="模板之家"></a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank"></a></em>
							</p>
						</div>
					</div>
	</body>

</html>
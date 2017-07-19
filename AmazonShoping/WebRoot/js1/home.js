//获得登录页面获得url中的数据
$(function() {

	var email = getCookie("name");
	$('#h').html("欢迎登录!" + email);
	$('.r').html("|请退出");
	getHotProduct();// 获取热卖商品
	getActivityProduct();
	clickOrderProduct();

})
// 设置cookie
function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + expires;
}
// 获取cookie
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






// 删除cookies
function delCookie(name) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString()
				+ "";
}
/**
 * 获取普通商品信息
 */
function clickOrderProduct() {
	//点击产品跳转 到指定页面
	for(var i=1;i<7;i++)
		{
		$('#t'+i).click(function(){
				var src = $(this).attr('src');
				var str = src.toString();
				window.location.href = "introduction.jsp?a="
						+ str + "";
			
		})
		}

}

/**
 * 获取活动商品信息
 */
function getActivityProduct() {
	var isHot = "activity";
	var data = {
		"isHot" : isHot
	}
	var method = "GetActivityProduct";
	$.ajax({
		url : "../warehouseserver/" + method,
		type : "POST",
		daType : "json",
		data : data,
		success : function(json) {
			var success = json.success;
			var message = json.message;
			var object = json.object;
			if (!success) {
				// 处理失败获取服务器端数据失败的情况
				alert("绑定失败");

			} else {
				for (var i = 0; i < object.length; i++) {
					$('#ac' + i).attr('src', object[i].photo);
				}

				var i = 0;
				for (i = 0; i < object.length; i++) {
					//点击图片跳转到指定产品页面
					$('#ac' + i).click(
							function() {
								var src = $(this).attr('src');
								var str = src.toString();
								window.location.href = "introduction.jsp?a="
										+ str + "";
							})

				}

			}
		},
		error : function() {
			alert("网络连接失败");
		}

	})

}
/**
 * 获取热卖商品
 * 
 */
function getHotProduct() {

	var isHot = "is";
	var data = {
		"isHot" : isHot
	}
	var method = "GetHotProduct";
	$.ajax({
		url : "../warehouseserver/" + method,
		type : "POST",
		daType : "json",
		data : data,
		success : function(json) {
			var success = json.success;
			var message = json.message;
			var object = json.object;
			if (!success) {
				// 处理失败获取服务器端数据失败的情况
				alert("绑定失败");

			} else {
				for (var i = 0; i < object.length; i++) {
					$('#remai' + i).attr('src', object[i].photo);
				}
				
				var i = 0;
				for (i = 0; i < object.length; i++) {
					
					//点击图片跳转到指定产品页面
					$('#remai' + i).click(
							function() {
								var src = $(this).attr('src');
								var str = src.toString();
								
								window.location.href = "introduction.jsp?a="
										+ str + "";
							})

				}

				
				
				
				

			}
		},
		error : function() {
			alert("网络连接失败");
		}

	})

}

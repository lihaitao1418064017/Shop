
$(function() {
	//设置收货地址
	setAddress();
	//设置总价信息
	setTotalPrice();
	
})
/**
 * 设置收货地址
 */

function setAddress(){
	var name = getCookie('name');
	$('.h1').html("欢迎登录" + name);

	var data = {
		"user_email" : name
	}
	var method = "GetUserReceiveAddress";
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
				alert("获取信息失败");

			} else {
				$('#shouhuoren').html(object[0].receive_user);
				$("#telephone").html(object[0].user_telephone);
				$('#shouhuodizhi').html("收货地址："+object[0].province+" "+object[0].city+""+object[0].area)
			}

		},
		error : function() {
			alert("网络连接失败");
		}

	})
}
/**
 * 设置总价信息
 */
function setTotalPrice(){
	var name = getCookie('name');

	var data = {
		"name" : name
	}
	var method = "GetItemInfo";
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
				alert("获取信息失败");

			} else {
				$('#zongjia').html("  ¥ "+object[object.length-1].totalPrice);
			}

		},
		error : function() {
			alert("网络连接失败");
		}

	})
}


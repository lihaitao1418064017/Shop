$(function() {
	var name = getCookie('name');
	$('.h1').html("欢迎登录" + name);
	allItemTotalPrice();
	tixingfahuo();
	querenshouhuo();
	deleteCloseItem();

})

// 设置所有订单中交易成功的总价
function allItemTotalPrice() {
	var itemPrice = $('.item-price').html();
	var sum = $('#sum').html();
	$('.item-amount').html(itemPrice * sum * 2);
}
// 提醒发货
function tixingfahuo() {
	$('#tixingfahuo').click(function() {
		alert("提醒成功");
	})

}
// 确认收货
function querenshouhuo() {
	var name = getCookie('name');
	$('#querenshouhuo').click(function() {

		var method = "SureItemSuccessAction";
		var data = {
			"name" : name
		}
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
					window.location.reload(true);
				}
			},
			error : function() {
				alert("网络连接失败");
			}
		})
	})

}

function deleteCloseItem() {
	var name = getCookie('name');
	$('#delete').click(function() {

		var method = "DeleteFailItem";
		var data = {
			"name" : name
		}
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
					window.location.reload(true);
				}
			},
			error : function() {
				alert("网络连接失败");
			}
		})
	})

}
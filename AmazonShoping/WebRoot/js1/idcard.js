$(function() {
	var email = getCookie('name');
	$('.h').html('欢迎' + email);

	$('#save').click(function() {

		var user_name = $('#user-name').val();
		var idCard = $('#user-IDcard').val();
		var method = "UpdateUserIdCard";
		var data = {
			"user_name" : user_name,
			"user_email" : email,
			"idCard" : idCard
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
					alert("绑定失败");

				} else {
					alert("认证成功");
					$('#user-name').val('');
					 $('#user-IDcard').val('');
					$('#start').attr('class', 'step-2 step');
					$('#over').attr('class', 'step-1 step');

				}
			},
			error : function() {
				alert("网络连接失败");
			}

		})

	})

})
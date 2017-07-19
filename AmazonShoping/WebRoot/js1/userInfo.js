$(function(){
	var name=getCookie("name");
	var method="GetUserInfo";
	var data={
			"user_email":name,
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
				$('#user-phone').html("********error");
				
			} else {
				$('#user-phone').html(object.user_telephone);
				$('#user-info').html(object.user_telephone);
			}
		},
		error : function() { 
			alert("网络连接失败");
		}

	})

	
	
	
})

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
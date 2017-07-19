$(function() {
	
	var email = getCookie("name");
	$('.h').html("欢迎"+email);
	var method = "GetUserInfo";
	var data={
			"user_email":email
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
				alert(message + "信息显示失败");

			} else {
				$('#user-phone').val(object.user_telephone);
				$('.name').val(object.user_name);
				$('input:radio:checked').val(object.user_sex);
				$('.nickname').val(object.user_petName);
				$('.email').val(object.user_email);
			}
		},
		error : function() { 
			alert("网络连接失败");
		}

	})
	
	
	
	$('#update').click(function() {
		var email = getCookie("name");
		
		var year=$(".oYear").find('option:checked').val();
		var month=$(".oMonth").find("option:checked").val();
		var day=$(".oDay").find("option:checked").val();
		var telephone = $('#user-phone').val();
		var name = $('.name').val();
		var sex = $('input:radio:checked').val();
		var nickname = $('.nickname').val();
		var newemail = $('.email').val();
		var data = {
			"user_email" : email,
			"user_telephone" : telephone,
			"user_name" : name,
			"user_sex" : sex,
			"user_petName" : nickname,
			"user_new_email" : newemail,
			"user_birthday":year+"-"+month+"-"+day+"-1-1-1"
		};
		var method = "UpdateUserInfo";
		$.ajax({
			url : "../warehouseserver/" + method,
			type : "POST",
			daType : "json",
			data : data,
			success : function(json) {
				var success = json.success;
				var message = json.message;
				 var object = json.object;
				alert(success);
				if (!success) {
					// 处理失败获取服务器端数据失败的情况
					alert(message + "修改失败");

				} else {
					
					alert(object.user_petName);
					$('#user-phone').val(object.user_telephone);
					$('.name').val(object.user_name);
					$('input:radio:checked').val(object.user_sex);
					$('.nickname').val(object.user_petName);
					$('.email').val(object.user_email);
					    var cval=getCookie("name");
					    var exp = new Date(); 
					    exp.setTime(exp.getTime() - 1); 
					    document.cookie= "name" + "="+cval+";expires="+exp.toGMTString()+";path=/";
					    setCookie("name",newemail,24);
					alert("更新个人信息成功");
				}
			},
			error : function() { 
				alert("网络连接失败");
			}

		})

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

function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + expires+";path=/";
}

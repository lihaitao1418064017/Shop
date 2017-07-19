$(function() {
				$("#updatePass").click(function() {
					
					var email = getCookie("name");
					var new_password = $('#user-new-password').val();
					var old_password = $('#user-old-password').val();
					
					
					var data = {
						"user_email" : email,
						"user_new_password" : new_password,
						"user_old_password" : old_password
					};

					//请求接口
					var method = "UpdateUserPassword";

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
								
								
								alert("更新密码成功");
								window.location.href = "../home/login.jsp";
							}
						},
						error : function() {
							alert("网络连接失败");
						}
					})
				})

			})
	
	
	
	
	
	
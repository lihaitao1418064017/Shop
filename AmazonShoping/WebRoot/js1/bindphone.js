$(function() {
	
	/**
	 * 验证旧手机
	 */
	// x上限，y下限
	var x = 9999;
	var y = 1000;
	var rand = parseInt(Math.random() * (x - y + 1) + y);
	//获取验证码
	$('#code1').click(function() {
		var starttime = new Date("2017/11/20");
		// 利用定时函数，并赋一个值inter，作为清除定时函数时用的参数
		var inter = setInterval(function() {
			var nowtime = new Date();
			var time = starttime - nowtime;

			var seconds = parseInt(time / 1000 % 60) + 10;
			if (seconds != 10) {
				$('#code1').html(seconds + "秒");
			} else {
				alert("code: " + rand);
				$('#code1').html("重新获取");
				// 清除定时函数
				clearInterval(inter);
			}

		}, 1000);
	})
	/**
	 * 判断旧手机验证码是否正确
	 */
	$('#user-new-phone').click(function(){
		var code=$('#user-code').val();
		if(rand!=code)
			{
				$('#codeC1').show();
			}
		else{
			$('#codeC1').hide();
		}
	})
	
	
	/**
	 * 验证新手机
	 */

	// x上限，y下限
	var x = 9999;
	var y = 1000;
	var rand1 = parseInt(Math.random() * (x - y + 1) + y);
	//获取验证码
	$('#code2').click(function() {
		var starttime = new Date("2017/11/20");
		// 利用定时函数，并赋一个值inter，作为清除定时函数时用的参数
		var inter = setInterval(function() {
			var nowtime = new Date();
			var time = starttime - nowtime;

			var seconds = parseInt(time / 1000 % 60) + 10;
			if (seconds != 10) {
				$('#code2').html(seconds + "秒");
			} else {
				alert("code: " + rand1);
				$('#code2').html("重新获取");
				// 清除定时函数
				clearInterval(inter);
			}

		}, 1000);
	})
	/**
	 * 判断新手机验证码是否正确
	 */
	$('#save').click(function(){
		var code=$('#user-new-code').val();
		var newPhone=$('#user-new-phone').val();
		var name=getCookie('name');
		
		if(rand1!=code)
			{
				$('#codeC2').show();
			}
		else{
			$('#codeC2').hide();
			var data={
					"user_email":name,
					"newPhone":newPhone
			}
			var method="UpdateUserPhone";
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
						alert("绑定成功");
						$('#start').attr('class','step-2 step');
						$('#over').attr('class','step-1 step');
						
					}
				},
				error : function() { 
					alert("网络连接失败");
				}

			})

			
			
			
		}
		
		
		
		
		
	})
	
	/*
	//判断验证码是否正确并添加信息提示
	$("#user-password,#user-confirm-password").click(function() {
		var code = $('#user-code').val();
		var codes = parseInt(code);
		var tishi = $('.tishi');
		if (codes != rand) {
			if (code == "") {
				tishi.html("***请填写验证码***");
				tishi.show();
			} else if (codes != rand) {
				tishi.html("***验证码错误***");
				tishi.show();
			} else {
				tishi.hide();
			}
		} else {
			tishi.hide();
		}
	})
	//发送到服务器端并保存用户信息
	$('#save').click(function() {
		var p1 = $('#user-confirm-password').val();
		var p2 = $('#user-password').val();
		var code = $('#user-code').val();
		var codes = parseInt(code);
		
		if (p1 != p2) {
			$(".config").show();
		} else if(p1==p2&&codes==rand) {
			//如果密码和验证码没有错误
			$('.config').hide();
			//为用户更新或添加支付密码
		var name=getCookie("name");
		var data={
				"user_email":name,
				"payPassword":p2
		}
		var method="UpdatePayPassword";
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
					
					alert("验证成功");
				}
			},
			error : function() { 
				alert("网络连接失败");
			}

		})
		
			
			
			
			
		}
		
		

	})
*/
})
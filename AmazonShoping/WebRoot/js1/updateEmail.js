$(function() {
	
	/**
	 * 验证新email
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
	 * 判断验证码成功并且保存到服务器端
	 */
	$('#save').click(function(){
		var old_email=getCookie('name');
		var code=$('#user-code').val();
		if(rand!=code)
			{
				$('#codeC1').show();
			}
		else{
			$('#codeC1').hide();
			var new_email=$("#user-email").val();
			var old_email=getCookie('name');
			var method="UpdateUserEmail";
			var data={
					"user_email":old_email,
					"user_new_email":new_email
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
						alert("验证失败");
						
					} else {
						alert("验证成功");
						clearCookie();
						setCookie('name',new_email,24);
						$("#user-email").val('');
						$('#user-code').val('');
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
			
})		
function clearCookie()
{
	 var cval=getCookie("name");
	   var exp = new Date(); 
	    exp.setTime(exp.getTime() - 1); 
	   document.cookie= "name" + "="+cval+";expires="+exp.toGMTString()+";path=/";	
}
//设置cookie
function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + expires;
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

$(function() {
	var name = getCookie('name');
	$('.h1').html("欢迎登录：" + name);
	getItemInfo();
	submitProduct();

})
// 请求产品信息
function getItemInfo() {
	var name = getCookie('name');
	method = "GetSuccessItemInfo";

	var data = {
		'name' : name
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
				// 提交评价信息

				$('#fabiao').click(function() {
					var arr = [];
					for (var i = 0; i < object.length; i++) {
						arr[i] = $('#text' + i).val();
						method = "AddCommentList";
						var data = {
							"name" : getCookie('name'),
							"content" : arr[i],
							'i':i
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

								} 
							},
						})

					}
						window.location.href="comment.jsp";
				})

			}
		},
		error : function() {
			alert("网络连接失败");
		}
	})

}

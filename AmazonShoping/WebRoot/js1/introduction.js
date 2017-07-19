$(function(){
	var url=window.location.toString()	;
	var name=getCookie('name');
	
	
	$('.h').html("欢迎登录："+name);
	
	var str=getIndex(url);
	var method="GetProductInfoMinute";
	var data={
			"photo":str
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
				$('#bigPhoto1').attr('src',object.photo);
				$('#bigPhoto1').attr('rel',object.photo);
				$('#small').attr('src',object.photo);
				
				$('.sys_item_price').html(object.price);
				$('#proName').html(object.descriptive);
				$('#month').html(object.monthSum);
				$('#total').html(object.totalSum);
				$('#kouwei').html(object.taste);
				$('#baozhuang').html(object.pack);
				$('.sys_item_mktprice').html(object.oldPrice);
				$('#pinjia').html(object.evaluate);
				$('#per').html(object.preferential);
				$('.stock').html(object.sum);
				
				$('.type').html("类型: "+object.type);
				$('.des').html("描述: "+object.descriptive);
				$('.eat').html("使用方法: "+object.eatWay);
				$('.pack').html("包装类型: "+object.pack);
				$('.per').html("优惠: "+object.preferential);
				$('.shopTime').html("生产时期: "+object.shopTime);
				$('.taste').html("口味: "+object.taste);
				
				$('#big').attr('src',object.photo);
				$('.tuijian').attr('src',object.photo);
				$('#ms').html(object.descriptive);
				
			}
		},
		error : function() {
			alert("网络连接失败");
		}

	})
	
	$('#LikBuy').click(function(){
		
		
		var name=getCookie('name');
		var productName=$('#bigPhoto1').attr('src');
		var data={
				"name":name,
				"productName":productName,
				"status":0
		}
		var method="AddItemInfo";
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
				
					window.location.href="pay.jsp";
				}
			},
			error : function() {
				alert("网络连接失败");
			}

		})
		
	})
	
	
	
})

//获取url中的参数值
function getIndex(url)
	{
		var i=url.indexOf("=");
		var str=url.substring(i+1,url.length);
		return str;
	}
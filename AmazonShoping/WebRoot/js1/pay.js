$(function() {
	var name = getCookie('name');
	$('.h1').html("欢迎登录" + name);
	getUserAddress();
		//设置快寄公司	
	for(var i=1;i<=5;i++){
		$('#li'+i).click(function() {
			$('.pay-logis').html($(this).html());
		})
		
	}
	//添加新地址
	addAddress();
	
	//计算价格
    getCal();
    /*
     * 点击提交订单时设置应付总价和会计公司
     */
    setT();
	
})
/**
 * 
 * 获取用户收货地址
 */
function getUserAddress()
{
	var name = getCookie('name');
	var data = {
			"user_email" : name
		}
		var method = "GetUserReceiveAddress";
		$
				.ajax({
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

							var i;
							for (i = 0; i < object.length; i++) {
								var address = $('<li id="def'
										+ i
										+ '" class="user-addresslist"><span class="new-option-r" id="shezhi'
										+ i
										+ '"><i class="am-icon-check-circle"></i>默认地址</span><p class="new-tit new-p-re">姓名：<span class="new-txt'
										+ i
										+ '">小叮当</span> <span class="new-txt-rd2'
										+ i
										+ '">159****1622</span></p><div class="new-mu_l2a new-p-re"><p class="new-mu_l2cw"><span class="title">地址：</span> <span class="province'
										+ i
										+ '"></span><span class="city'
										+ i
										+ '"></span> <span class="dist'
										+ i
										+ '"></span> <span class="street'
										+ i
										+ '"></span></p></div><div class="new-addr-btn"><a href="#"><i class="am-icon-edit"></i>编辑</a> <span class="new-addr-bar">|</span> <i class="am-icon-trash"></i><span class="shanchu" id="del"><a href=#>删除</a></span></div></li> ');
								$('#ul').append(address);

								$('#del').attr('id', object[i].id);
								// 设置图片样式的类
								$('#def0').attr('class',
										'user-addresslist defaultAddr');
								$('#shezhi0').html('默认地址');

								if (i != 0) {
									$('#shezhi' + i).html('设为默认');
									$('#def' + i).attr('class', 'user-addresslist');
								}
								// 选定地址
								$('#def' + i)
										.click(
												function() {
													for (var j = 0; j < object.length; j++) {
														$('#def' + j).attr('class',
																'user-addresslist')
													}
													$(this)
															.attr('class',
																	'user-addresslist defaultAddr');
												})

								// 姓名
								$('.new-txt' + i).html(object[i].receive_user);
								// 电话
								$('.new-txt-rd2' + i).html(
										"电话: " + object[i].receive_telephone);
								// 省
								$('.province' + i).html(object[i].province);
								// 市
								$('.city' + i).html(object[i].city);
								// 区
								$('.dist' + i).html(object[i].area);
								// 详细地址
								$('.street' + i).html(object[i].minute_address);
								
								//确认的收货地址
								$('.street1').html(object[i].province+" "+object[i].city+" "+object[i].area);
								$('.buy-user').html(object[i].receive_user);
								$('.buy-phone').html(object[i].receive_telephone);
							}

							
						}
					},
					error : function() {
						alert("网络连接失败");
					}

				})
				}
/*
 * 点击提交订单时设置应付总价和会计公司
 */
function setT(){
	
	$('#J_Go').click(function(){
		
		var name=getCookie('name');
		var company=$('.pay-logis').text();
		var zongjia=$('#zongq').html();
		alert(name);
	    var data={
	    		"address":company,
	    		"user_email":name,
	    		"totalPrice":zongjia,
	    		"typeStatus": '1'
	    }
		var method="UpdateSendCompany";
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
					window.location.href="success.jsp";
					
					}
			},
			error : function() {
				
				alert("网络连接失败");
			}

		})
	})
	
	
}
/**
 * 
 * 添加用户收货地址
 */
function addAddress(){
	$('#save').click(function(){
	     var telephone=$("#user-phone").val();
	     var name=$('#user-name').val();
	     
	     var address=$('#user-intro').val();
	     
	     var pro=$('#p').find("option:selected").text();
	     var city=$('#c').find("option:selected").text();
	     var area=$('#a').find("option:selected").text();
	     
	     var method="AddUserReceiveAddress";
	     var data={
	    			"phone":telephone,
	    			"name":name,
	    			"address":address,
	    			"province":pro,
	    			"city":city,
	    			"area":area,
	    			"user_email":getCookie("name")
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
	 				alert("添加 信息失败");
	 				
	 			} else {
	 				alert('添加成功');
	 				window.location.reload();
	 				
	 			}
	 		},
	 		error : function() { 
	 			alert("网络连接失败");
	 		}

	 	})
	
	})
	
}


/**
 * 
 * 计算价格
 */
function getCal() {
	$('#jia').click(function() {
		var sum = parseInt($('#danjia').html().toString());
		var s = parseInt($('#sum').val().toString());
		$('#zongjia').html(sum * (s + 1));
		var sum1 = parseInt($('#zongjia').html().toString());
		$('#zong').html(sum1  );
		$('#zongq').html(sum1  - 53);
	})
	$('#jian').click(function() {
		
		var sum = parseInt($('#danjia').html().toString());
		var s = parseInt($('#sum').val().toString());
		
		$('#zongjia').html(sum * (s-1));
		
		var sum1 = parseInt($('#zongjia').html().toString());
		$('#zong').html(sum1  );
		if(sum1  - 53<=0)
			{
			$('#zongq').html(0);
			}
		else{
			$('#zongq').html(sum1  - 53);
		}
		
	})
	
	
	
	var sum = parseInt($('#zongjia').html().toString());
	var sum1 = parseInt($('#danjia').html().toString());
	$('#zong').html(sum*3 );
	$('#zongjia').html(sum1*3);
	$('#zongq').html(sum*3   - 53);
	
	
}
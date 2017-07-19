$(function() {
	
	
	var email = getCookie('name');
	$('.h').html('欢迎' + email);
	
	method="GetUserReceiveAddress";
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
				alert("获取信息失败");
				
			} else {
				//制作地址显示卡片
//				alert(object[i].id);	
				var i;
				for(i=0;i<object.length;i++)
					{
					var address=$('<li id="def'+i+'" class="user-addresslist defaultAddr"><span class="new-option-r" id="shezhi'+i+'"><i class="am-icon-check-circle"></i>默认地址</span><p class="new-tit new-p-re">姓名：<span class="new-txt'+i+'">小叮当</span> <span class="new-txt-rd2'+i+'">159****1622</span></p><div class="new-mu_l2a new-p-re"><p class="new-mu_l2cw"><span class="title">地址：</span> <span class="province'+i+'"></span><span class="city'+i+'"></span> <span class="dist'+i+'"></span> <span class="street'+i+'"></span></p></div><div class="new-addr-btn"><a href="#"><i class="am-icon-edit"></i>编辑</a> <span class="new-addr-bar">|</span> <i class="am-icon-trash"></i><span class="shanchu" id="del"><a href=#>删除</a></span></div></li> ');
					$('#ul').append(address);
					
					$('#del').attr('id',object[i].id);
					//设置图片样式的类
					$('#def0').attr('class','user-addresslist defaultAddr')
					$('#shezhi0').html('默认地址');
					
					
					if(i!=0)
						{
					    $('#shezhi'+i).html('设为默认');
						$('#def'+i).attr('class','user-addresslist');
						}
					
					//姓名
					$('.new-txt'+i).html(object[i].receive_user);
					//电话
					$('.new-txt-rd2'+i).html("电话: "+object[i].receive_telephone);
					//省
					$('.province'+i).html(object[i].province);
					//市
					$('.city'+i).html(object[i].city);
					//区
					$('.dist'+i).html(object[i].area);
					//详细地址
					$('.street'+i).html(object[i].minute_address);
				}
				//删除指定的收货地址
				$('.shanchu').click(function(){
					
					var name=$(this).attr('id');
					var name1=parseInt(name);
					var method="RemoveUserReceiveAddress";
					var data={
							"id" :name1
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
								alert("删除失败");
								
							} else {
							alert("删除成功");
							window.location.reload();
								
							}
						},
						error : function() { 
							alert("网络连接失败");
						}

					})
					
				});
				
			}
		},
		error : function() { 
			alert("网络连接失败");
		}

	})
	
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
	$('#cancel').click(function(){
		$("#user-phone").val('');
	      $('#user-name').val('');
	     $('#user-intro').val('');
	     $('#p').find("option:selected").text();
	     $('#c').find("option:selected").text();
	     $('#a').find("option:selected").text();
	})
	
	

})
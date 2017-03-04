/**
 * 动态交互文件
 * cms.js
 * 孙梦海、赵晨宇
 */
$(function(){
	//管理员修改密码登录提示弹出框
	$("#alert").slideDown(800);
	
	//点击图标隐藏弹出框
	$(".fa-close").click(function() {
		$("#alert").slideUp(400);
	});
	//如果不点击5s后自动隐藏弹出框
	setTimeout(function() {
		$("#alert").slideUp(400);
	},5000);
	
	//管理员登录
	$("#login").click(function() {
		$.ajax({
            url: "/cms/login.do",//要请求的服务器url 
            data: {
            	userName: $("#userName").val(),
				passWord: $("#passWord").val(),
            },
            async: true,   //是否为异步请求
            cache: false,  //是否缓存结果
            type: "POST", //请求方式为POST
            dataType: "text",   //服务器返回的数据是什么类型 
            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是text类型) 
            	if(result=="wrong"){
            		alert("用户名或密码错误，请重新登录！");
                }else if(result=="null"){
                	alert("您还没有登录，请先登录！");
                }else {
                	window.location.href="/cms/index.do";
                }
            }
        });
		return false; 
	});
	
	//增加学生，异步提交学生表单
	$("#addStudents").click(function() {
		$.ajax({
            url: "addStudents.do",//要请求的服务器url 
            //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取 
            //data:{method:"ajaxTest",val:value},  
            data: {
            	name: $("#name").val(),
				studentId: $("#studentId").val(),
				sex: $("#sex").val(),
				idCard: $("#idCard").val(),
				age: $("#age").val(),
				birthDay: $("#birthDay").val(),
				
				dorm: $("#dorm").val(),
				homeland: $("#homeland").val(),
				
				qq: $("#qq").val(),
				phoneNumber: $("#phoneNumber").val(),
				
				self: $("#self").val(),
				firstTheme: $("#firstTheme").val(),	
				firstContent: $("#firstContent").val(),
				secondTheme: $("#secondTheme").val(),	
				secondContent: $("#secondContent").val(),
				thirdTheme: $("#thirdTheme").val(),
				thirdContent: $("#thirdContent").val(),	
				fourthTheme: $("#fourthTheme").val(),
				fourthContent: $("#fourthContent").val(),
				
				c: $("#c").val(),
				cplus: $("#cplus").val(),
				java: $("#java").val(),
				dataBase: $("#dataBase").val(),
				dataStructures: $("#dataStructures").val(),
				algorithm: $("#algorithm").val(),
				operateSystem: $("#operateSystem").val(),
				composition: $("#composition").val(),
				network: $("#network").val(),
            },
            async: false,   //是否为异步请求
            cache: false,  //是否缓存结果
            type: "POST", //请求方式为POST
            dataType: "text",   //服务器返回的数据是什么类型 
            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是text类型) 
            	if(result=="success"){
            		if (confirm("添加成功，是否查看学生列表?"))
            		{ 
            			window.location.href="studentsList.do";
            		} 
                }else{
                	alert("添加失败，请重新添加！");
                }
            	$('.addSud [type="text"]:input').val("");
            }
        });
		return false; 
	});
	
	//修改学生基本信息
	$("#updateInfo").click(function() {
		$.ajax({
            url: "updateInfo.do",//要请求的服务器url 
            //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取 
            //data:{method:"ajaxTest",val:value},  
            data: {
            	name: $("#name").val(),
				studentId: $("#studentId").val(),
				sex: $("#sex").val(),
				idCard: $("#idCard").val(),
				age: $("#age").val(),
				birthDay: $("#birthDay").val(),
				dorm: $("#dorm").val(),
				homeland: $("#homeland").val(),
				qq: $("#qq").val(),
				phoneNumber: $("#phoneNumber").val(),
				self: $("#self").val(),
				firstTheme: $("#firstTheme").val(),	
				firstContent: $("#firstContent").val(),
				secondTheme: $("#secondTheme").val(),	
				secondContent: $("#secondContent").val(),
				thirdTheme: $("#thirdTheme").val(),
				thirdContent: $("#thirdContent").val(),	
				fourthTheme: $("#fourthTheme").val(),
				fourthContent: $("#fourthContent").val(),
            },
            async: false,   //是否为异步请求
            cache: false,  //是否缓存结果
            type: "POST", //请求方式为POST
            dataType: "text",   //服务器返回的数据是什么类型 
            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是text类型) 
            	if(result=="success"){
            		if (confirm("修改成功，是否返回学生列表?"))
            		{ 
            			window.location.href="studentsList.do";
            		} 
                }else{
                	alert("修改失败，请重新尝试！");
                }
            }
        });
		return false; 
	});
	
	//修改学生成绩信息
	$("#updateGrade").click(function() {
		$.ajax({
            url: "updateGrade.do",//要请求的服务器url 
            //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取 
            //data:{method:"ajaxTest",val:value},  
            data: {
				studentId: $("#studentId").val(),
				c: $("#c").val(),
				cplus: $("#cplus").val(),
				java: $("#java").val(),
				dataBase: $("#dataBase").val(),
				dataStructures: $("#dataStructures").val(),
				algorithm: $("#algorithm").val(),
				operateSystem: $("#operateSystem").val(),
				composition: $("#composition").val(),
				network: $("#network").val(),
            },
            async: false,   //是否为异步请求
            cache: false,  //是否缓存结果
            type: "POST", //请求方式为POST
            dataType: "text",   //服务器返回的数据是什么类型 
            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是text类型) 
            	if(result=="success"){
            		if (confirm("修改成功，是否返回学生成绩列表?"))
            		{ 
            			window.location.href="studentsGrade.do";
            		} 
                }else{
                	alert("修改失败，请重新尝试！");
                }
            }
        });
		return false; 
	});
	
	//删除学生
	$(".deleteStudents").click(function() {
		var td = $(this).parent();
		var studentId = td.siblings(".studentId").text();
		if (confirm("是否确定删除该学生?")) {
			$.ajax({
	            url: "deleteStudents.do?studentId="+studentId,//要请求的服务器url 
	            async: true,   //是否为异步请求
	            cache: false,  //是否缓存结果
	            type: "POST", //请求方式为POST
	            dataType: "text",   //服务器返回的数据是什么类型 
	            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是text类型) 
	            	if(result=="success"){
	            		alert("删除成功！");
	            		//获取当前页数，并传到跳转servlet
	            		window.location.href="studentsList.do?pageNo="+$("#curPage").text();
	                }else{
	                	alert("删除失败，请重新尝试！");
	                }
	            }
	        });
		}
		
	});
	
	//修改管理员信息
	$("#updateAdmin").click(function() {
		$.ajax({
            url: "updateAdmin.do",//要请求的服务器url 
            //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取 
            //data:{method:"ajaxTest",val:value},  
            data: {
				userName: $("#userName").val(),
				passWord: $("#passWord").val(),
				confirmPassWord: $("#confirmPassWord").val(),
            },
            async: false,   //是否为异步请求
            cache: false,  //是否缓存结果
            type: "POST", //请求方式为POST
            dataType: "text",   //服务器返回的数据是什么类型 
            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是text类型) 
            	if(result=="success"){
            		alert("修改成功，请重新登录！");
            		window.location.href="login.jsp";
                }else if(result=="passwordError"){
                	alert("两次密码不一致，请重新修改！");
                }
                else {
                	alert("修改失败，请重新修改！");
                }
            }
        });
		return false;
	}); 
	
	//复选框实现批量删除学生
	$("#checkAll").click(function() {
		$('[name=items]:checkbox').prop("checked",this.checked);
	});
	$("#deleteAll").click(function() {
		var item = [];
		var hasChecked = false;
		item = $('[name=items]:checkbox');
		for(var i=0;i<item.length;i++) {
			if(item[i].checked) {hasChecked = true;}
		}
		if(hasChecked == false) {
			alert("没有学生被选中，请至少选择一个学生！");
		}
		else {
			var con = confirm("是否确定删除全部选中学生？");
			if(con) {
				//获取选中学生的学号
				var studentsId = [];
				for(var i=0;i<item.length;i++) {
					if(item[i].checked) {
						studentsId.push($(item[i]).parent().next().html());
					}
				}
				$.ajax({
		            url: "deleteAll.do",//要请求的服务器url 
		            data: {"studentsId": studentsId},
		            async: false,   //是否为异步请求
		            cache: false,  //是否缓存结果
		            type: "POST", //请求方式为POST
		            dataType: "text",   //服务器返回的数据是什么类型 
		            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是text类型) 
		            	if(result=="success"){
		            		alert("删除成功！");
		            		//获取当前页数，并传到跳转servlet
		            		window.location.href="studentsList.do?pageNo="+$("#curPage").text();
		                }
		                else {
		                	alert("删除失败，请重新删除！");
		                }
		            }
		        });
			}
		}
	});
	
	$("#search1").click(function() {
		var type = $("#types").val();
		var keyWords = $("#keyWords").val();
		$.ajax({
            url: "studentsSearch.do",//要请求的服务器url 
            data: {
            	"type": type,	//分类类别
            	"keyWords": keyWords,	//具体的筛选信息
            },
            async: false,   //是否为异步请求
            cache: false,  //是否缓存结果
            type: "POST", //请求方式为POST
            dataType: "text",   //服务器返回的数据是什么类型 
            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是text类型) 
            	if(result=="success"){
            		alert("筛选成功！");
                }
                else {
                	alert("筛选失败，请重新输入具体筛选信息！");
                }
            }
        });
		return false;
	});
});
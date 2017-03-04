<!-- 
 /**
 *类描述：
 *@author: 孙梦海
 */ -->
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>学生登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="../css/login.css">
	<link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.css">

  </head>
  
  <body>
    <div class="container">
      <h3><i class="fa fa-skyatlas fa-lg"></i> &nbsp;
      	学生信息管理系统</h3>
      	<div class="case-item">
			<div class="ih-item circle effect1">
				<a href="http://www.cnblogs.com/sunmaer/" target="_blank">
					<div class="spinner"></div>
					<div class="img"><img src="../img/8.png" alt="懒人图库"></div>
				</a>
			</div>
	    </div>
      	<form method="post" action="">
        	<!-- <label for="StudentId">用户名：</label> -->
        	<i class="fa fa-user"></i>
        	<input type="text" id="userName" name="userName" placeholder="用户名"/>
        	<!-- <label for="PassWord">密码：</label> -->
        	<i class="fa fa-lock"></i>
        	<input type="password" id="passWord" name="passWord" placeholder="密码" />
        	<input type="submit" id="login" value="登 录" />
        </form>
    </div> <!-- container -->

    <script src="../js/jquery.min.js"></script>	
    <script src="../js/cms.js"></script>
    <script type="text/javascript">
	   //登录框水平垂直居中
       $(function(){
          var newTop = ($(window).height() - $(".container").height()) / 2;
          $(".container").css("marginTop",newTop);
          $(window).resize(function(){
            var newTop = ($(window).height() - $(".container").height()) / 2;
            $(".container").css("marginTop",newTop);
          });
       });
    </script>
  </body>
</html>

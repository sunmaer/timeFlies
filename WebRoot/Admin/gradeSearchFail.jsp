<!-- 
 /**
 *类描述：
 *@author: 孙梦海
 */ -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息管理系统</title>
  	<meta charset="utf-8"> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/public.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.css">

  </head>
  
  <body>
  	   <%@ include file="/public/header.jsp" %>

       <%@ include file="/public/leftBar.jsp" %>

       <div class="main">
          <p class="url">学生信息 管理中心</p>
          <div class="container">
            <div class="name">
				<span>筛选结果</span>
				<a href="studentsGrade.do"><i class="fa fa-angle-double-left fa-lg"></i> 返回列表</a>
			</div><!-- name -->
			
            <p style="padding-bottom: 10px;line-height: 40px;"> &nbsp;未搜索到相关记录，请重新搜索！ </p>
			<div class="search">
				<form action="gradeSearch.do" method="post">
					<select id="types" name="type">
						<option value="学号" selected> 学号 </option>
						<option value="姓名"> 姓名 </option>
					</select>

					<input type="text" id="keyWords" name="keyWords" placeholder="请输入具体筛选信息">
					<input type="submit" id="search" value="筛选">
					
				</form>
			</div><!-- search -->			

		</div><!-- list -->
            
	<%@ include file="/public/footer.jsp" %>
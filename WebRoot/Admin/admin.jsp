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
				<span>管理员信息</span>
				<a href="studentsList.do"><i class="fa fa-angle-double-left fa-lg"></i> 学生列表</a>
			</div><!-- name -->
			<c:if test="${not empty adminList}">
		    	<c:forEach items="${adminList}" var="admin">
		    		<form action="" class="admin addSud">
						<table></tr>
							<tr>
								<td class="textRight">管理员昵称</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="background-color:#f9f9f9;" disabled="disabled" value="${admin.userName}" id="userName" name="userName"></td>
							</tr>
							<tr>
								<td class="textRight">密码</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" value="${admin.passWord}" id="passWord" name="passWord"></td>
							</tr>
							<tr>
								<td class="textRight">确认密码</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" value="${admin.passWord}" id="confirmPassWord" name="confirmPassWord"></td>
							</tr>
							<tr>
								<td></td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" id="updateAdmin" value="提交"></td>
							</tr>
						</table>
					</form>
		    	</c:forEach>
		    </c:if>
			
            
	<%@ include file="/public/footer.jsp" %>
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
				<span>修改学生信息</span>
				<a href="javascript:;" onClick="javascript:history.back(-1);"><i class="fa fa-angle-double-left fa-lg"></i> 返回</a>
				<!-- <a href="studentsList.do"><i class="fa fa-angle-double-left fa-lg"></i> 返回列表</a> -->
			</div><!-- name -->
			<c:if test="${not empty studentsList}">
		    	<c:forEach items="${studentsList}" var="student">
		    	<form class="addSud" method="post" action="">
				<table>
					<tr><td colspan="6"><strong>&nbsp;&nbsp;&nbsp;&nbsp;学生基本信息</strong></td></tr>
					<tr>
						<td class="textRight">姓名</td>
						<td colspan="2"><input type="text" id="name" name="name" value="${student.name}"></td>
						<td class="textRight">学号</td>
						<td colspan="2"><input type="text" style="background-color:#f9f9f9;" disabled="disabled" id="studentId" name="studentId" value="${student.studentId}"></td>
					</tr>
					<tr>
						<td class="textRight">性别</td>
						<td colspan="2"><input type="text" id="sex" name="sex" value="${student.sex}"></td>
						<td class="textRight">身份证号</td>
						<td colspan="2"><input type="text" id="idCard" name="idCard" value="${student.idCard}"></td>
					</tr>
					<tr>
						<td class="textRight">年龄</td>
						<td colspan="2"><input type="text" id="age" name="age" value="${student.age}"></td>
						<td class="textRight">生日</td>
						<td colspan="2"><input type="text" id="birthDay" name="birthDay" value="${student.birthDay}"></td>
					</tr>
					<tr>
						<td class="textRight">宿舍</td>
						<td colspan="2"><input type="text" id="dorm" name="dorm" value="${student.dorm}"></td>
						<td class="textRight">籍贯</td>
						<td colspan="2"><input type="text" id="homeland" name="homeland" value="${student.homeland}"></td>
					</tr>
					<tr>
						<td class="textRight">QQ</td>
						<td colspan="2"><input type="text" id="qq" name="qq" value="${student.qq}"></td>
						<td class="textRight">手机号码</td>
						<td colspan="2"><input type="text" id="phoneNumber" name="phoneNumber" value="${student.phoneNumber}"></td>
					</tr>
					
					<tr><td colspan="6"><strong>&nbsp;&nbsp;&nbsp;&nbsp;社会经历</strong></td></tr>
					<tr>
						<td class="textRight">个人介绍</td>
						<td colspan="5"><input type="text" id="self" name="self" value="${student.self}"></td>
					</tr>
					<tr>
						<td class="textRight">大一主题</td>
						<td><input type="text" id="firstTheme" name="firstTheme" value="${student.firstTheme}"></td>
						<td class="textRight">经历描述</td>
						<td colspan="3"><input type="text" id="firstContent" name="firstContent" value="${student.firstContent}"></td>
					</tr>
					<tr>
						<td class="textRight">大二主题</td>
						<td><input type="text" id="secondTheme" name="secondTheme" value="${student.secondTheme}"></td>
						<td class="textRight">经历描述</td>
						<td colspan="3"><input type="text" id="secondContent" name="secondContent" value="${student.secondContent}"></td>
					</tr>
					<tr>
						<td class="textRight">大三主题</td>
						<td><input type="text" id="thirdTheme" name="thirdTheme" value="${student.thirdTheme}"></td>
						<td class="textRight">经历描述</td>
						<td colspan="3"><input type="text" id="thirdContent" name="thirdContent" value="${student.thirdContent}"></td>
					</tr>
					<tr>
						<td class="textRight">大四主题</td>
						<td><input type="text" id="fourthTheme" name="fourthTheme" value="${student.fourthTheme}"></td>
						<td class="textRight">经历描述</td>
						<td colspan="3"><input type="text" id="fourthContent" name="fourthContent" value="${student.fourthContent}"></td>
					</tr>
					
					<tr>
						<td></td>
						<td colspan="5">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" id="updateInfo" value="确认修改"></td>
					</tr>
				</table>
		    	</c:forEach>
		    </c:if>

			</form>
            
	<%@ include file="/public/footer.jsp" %>

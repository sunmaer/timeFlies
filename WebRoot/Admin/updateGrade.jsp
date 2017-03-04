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
				<span>修改学生成绩</span>
				<a href="javascript:;" onClick="javascript:history.back(-1);"><i class="fa fa-angle-double-left fa-lg"></i> 返回</a>
				<!-- <a href="studentsList.do"><i class="fa fa-angle-double-left fa-lg"></i> 返回列表</a> -->
			</div><!-- name -->
			<c:if test="${not empty studentsList}">
		    	<c:forEach items="${studentsList}" var="student">
		    	<form class="addSud" method="post" action="">
				<table>
					<tr><td colspan="6"><strong>&nbsp;&nbsp;&nbsp;&nbsp;学生成绩</strong></td></tr>
					<tr>
						<td class="textRight">姓名</td>
						<td><input type="text" style="background-color:#f9f9f9;" disabled="disabled" id="name" name="name" value="${student.name}"></td>
						<td class="textRight">学号</td>
						<td><input type="text" style="background-color:#f9f9f9;" disabled="disabled" id="studentId" name="studentId" value="${student.studentId}"></td>
						<td class="textRight">宿舍</td>
						<td colspan="2"><input type="text" style="background-color:#f9f9f9;" disabled="disabled" id="dorm" name="dorm" value="${student.dorm}"></td>
					</tr>
					<tr>
						<td class="textRight">C语言程序设计</td>
						<td><input type="text" id="c" name="c" value="${student.c}"></td>
						<td class="textRight">C++程序设计</td>
						<td><input type="text" id="cplus" name="cplus" value="${student.cplus}"></td>
						<td class="textRight">JAVA语言程序设计</td>
						<td><input type="text" id="java" name="java" value="${student.java}"></td>
					</tr>
					<tr>
						<td class="textRight">数据库系统概论</td>
						<td><input type="text" id="dataBase" name="dataBase" value="${student.dataBase}"></td>
						<td class="textRight">数据结构</td>
						<td><input type="text" id="dataStructures" name="dataStructures" value="${student.dataStructures}"></td>
						<td class="textRight">算法设计分析</td>
						<td><input type="text" id="algorithm" name="algorithm" value="${student.algorithm}"></td>
					</tr>
					<tr>
						<td class="textRight">操作系统</td>
						<td><input type="text" readonly="readonly" id="operateSystem" name="operateSystem" value="${student.operateSystem}"></td>
						<td class="textRight">计算机组成原理</td>
						<td><input type="text" readonly="readonly" id="composition" name="composition" value="${student.composition}"></td>
						<td class="textRight">计算机网络</td>
						<td><input type="text" readonly="readonly" id="network" name="network" value="${student.network}"></td>
					</tr>
					
					<tr>
						<td></td>
						<td colspan="5">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" id="updateGrade" value="确认修改"></td>
					</tr>
				</table>
		    	</c:forEach>
		    </c:if>

			</form>
            
	<%@ include file="/public/footer.jsp" %>

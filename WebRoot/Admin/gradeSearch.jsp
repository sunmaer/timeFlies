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
			
			<div class="grade list">
				<table>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>C语言</th>
						<th>C++</th>
						<th>JAVA</th>
						<th>数据库</th>
						<th>数据结构</th>
						<th>数据库</th>
						<th>操作系统</th>
						<th>计算机组成原理</th>
						<th>计算机网络</th>
						<th class="action">操作</th>
					</tr>
					<c:if test="${not empty page.data}">
		              <c:forEach items="${page.data}" var="student">
		                <tr>
		                    <td>${student.studentId}</td>
		                    <td>${student.name}</td>
		                    <td>${student.c}</td>
		                    <td>${student.cplus}</td>
		                    <td>${student.java}</td>
		                    <td>${student.dataBase}</td>
		                    <td>${student.dataStructures}</td>
		                    <td>${student.algorithm}</td>
							<td>${student.operateSystem}</td>
							<td>${student.composition}</td>
							<td>${student.network}</td>
							<td>
								<a href="showGrade.do?studentId=${student.studentId}" title="编辑成绩"><i class="fa fa-edit fa-lg"></i></a>
							</td>
		                </tr>
		              </c:forEach>
		        	</c:if>
				</table>
				
			<div class="page">
			        总共 ${page.totalCount} 个记录，共 ${page.totalPage} 页 ，当前第 <span id="curPage">${page.pageNo}</span> 页 | 
               <a href="gradeSearch.do?type=${info.get(0)}&keyWords=${info.get(1)}&pageNo=1">第一页</a> 
               <c:choose>
                   <c:when test="${page.pageNo > 1}">
                       <a href="gradeSearch.do?type=${info.get(0)}&keyWords=${info.get(1)}&pageNo=${page.pageNo-1}">上一页</a>
                   </c:when>
                   <c:otherwise>
                                                                 上一页
                   </c:otherwise>
               </c:choose> 
               <c:choose>
                   <c:when test="${page.pageNo < page.totalPage}">
                   	<a href="gradeSearch.do?type=${info.get(0)}&keyWords=${info.get(1)}&pageNo=${page.pageNo+1}">下一页</a>
                   </c:when>
                   <c:otherwise>
                                                                 下一页
                   </c:otherwise>
               </c:choose> 
               <a href="gradeSearch.do?type=${info.get(0)}&keyWords=${info.get(1)}&pageNo=${page.totalPage}">最末页</a>
			</div>

		</div><!-- list -->
            
	<%@ include file="/public/footer.jsp" %>
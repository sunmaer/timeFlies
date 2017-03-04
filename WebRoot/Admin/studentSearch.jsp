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
				<a href="studentsList.do"><i class="fa fa-angle-double-left fa-lg"></i> 返回列表</a>
			</div><!-- name -->
			
			<div class="list">
				<table>
					<tr>
						<th class="checkbox">
							&nbsp;<input type="checkbox" id="checkAll">&nbsp;
						</th>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>生日</th>
						<th>身份证号</th>
						<th>宿舍</th>
						<th>籍贯</th>
						<th>QQ</th>
						<th>手机号码</th>
						<th class="action">操作</th>
					</tr>
				    <c:if test="${not empty page.data}">
		              <c:forEach items="${page.data}" var="student">
		                <tr>
		                    <td>
								&nbsp;<input type="checkbox" name="items">&nbsp;
							</td>
		                    <td class="studentId">${student.studentId}</td>
		                    <td>${student.name}</td>
		                    <td>${student.sex}</td>
		                    <td>${student.age}</td>
		                    <td>${student.birthDay}</td>
		                    <td>${student.idCard}</td>
		                    <td>${student.dorm}</td>
							<td>${student.homeland}</td>
							<td>${student.phoneNumber}</td>
							<td>${student.qq}</td>
							<td>
								<a href="seeGrade.do?studentId=${student.studentId}" title="查看成绩"><i class="fa fa-file-text-o fa-lg"></i></a><!--
								--><a href="seeInfo.do?studentId=${student.studentId}" title="编辑信息"><i class="fa fa-edit fa-lg"></i></a><!--
								--><a href="javascript:void(0);" class="deleteStudents" title="删除学生"><i class="fa fa-trash-o fa-lg"></i></a>
							</td>
		                </tr>
		              </c:forEach>
		        	</c:if>
				</table>
				
			<button id="deleteAll"><i class="fa fa-trash fa-lg"></i> 删除选中</button>
			<div class="page">
			        总共 ${page.totalCount} 个记录，共 ${page.totalPage} 页 ，当前第 <span id="curPage">${page.pageNo}</span> 页 | 
               <a href="studentsSearch.do?type=${info.get(0)}&keyWords=${info.get(1)}&pageNo=1">第一页</a> 
               <c:choose>
                   <c:when test="${page.pageNo > 1}">
                       <a href="studentsSearch.do?type=${info.get(0)}&keyWords=${info.get(1)}&pageNo=${page.pageNo-1}">上一页</a>
                   </c:when>
                   <c:otherwise>
                                                                 上一页
                   </c:otherwise>
               </c:choose> 
               <c:choose>
                   <c:when test="${page.pageNo < page.totalPage}">
                   	<a href="studentsSearch.do?type=${info.get(0)}&keyWords=${info.get(1)}&pageNo=${page.pageNo+1}">下一页</a>
                   </c:when>
                   <c:otherwise>
                                                                 下一页
                   </c:otherwise>
               </c:choose> 
               <a href="studentsSearch.do?type=${info.get(0)}&keyWords=${info.get(1)}&pageNo=${page.totalPage}">最末页</a>
			</div>

		</div><!-- list -->
            
	<%@ include file="/public/footer.jsp" %>
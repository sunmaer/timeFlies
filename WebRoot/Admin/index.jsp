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
            <div id="alert" class="alert">欢迎，<strong><% out.print( session.getAttribute("userName")); %></strong>! 如果您是第一次登录学生信息管理系统，请点击<a href="showAdmin.do"> 修改密码 </a>更改初始密码。<i class="fa fa-close fa-lg"></i>
            </div><!-- alert -->

            <div class="studentInfo table">
              <h3 class="title">学生统计信息</h3>
              <table>
                <c:if test="${not empty info}">
	        		<tr>
	                  <td>学院系别：</td>
	                  <td><strong>信息学院计算机科学系</strong></td>
	                  <td>学生总数：</td>
	                  <td><strong>${info.get(0)}</strong></td>
	                  <td>男生总数：</td>
	                  <td><strong>${info.get(1)}</strong></td>
	                </tr>
	                <tr>
	                  <td>女生总数：</td>
	                  <td><strong>${info.get(2)}</strong></td>
	                  <td>课程总数：</td>
	                  <td><strong>${info.get(3)}</strong></td>
	                  <td>班级总数：</td>
	                  <td><strong>${info.get(4)}</strong></td>
	                </tr>
		        </c:if>
                
              </table>
            </div><!-- studentInfo -->

            <div class="serverInfo table">
              <h3 class="title">服务器信息</h3>
              <table>
                <tr>
                  <td>版本：</td>
                  <td>1.0</td>
                  <td>MYSQL版本：</td>
                  <td>5.5</td>
                  <td>服务器操作系统：</td>
                  <td> windows server2008 </td>
                </tr>
                <tr>
                  <td>文件上传限制：</td>
                  <td>2M</td>
                  <td>GD库支持：</td>
                  <td>是</td>
                  <td>web服务器：</td>
                  <td> Apache/2.4.10 </td>
                </tr>
              </table>
            </div><!-- serverInfo -->

            <div class="systemInfo table">
              <h3 class="title">系统信息</h3>
              <table>
                <tr>
                  <td>开发人员：</td>
                  <td colspan="5">孙梦海、赵晨宇&nbsp;&nbsp;
                    <a href="http://www.cnblogs.com/sunmaer/" class="cnblog" target="_blank">http://www.cnblogs.com/sunmaer/</a>
                  </td>
                </tr>
                <tr>
                  <td>联系方式：</td>
                  <td colspan="5">
                    <i class="fa fa-qq fa-lg"></i>&nbsp;&nbsp;878131732&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-weixin fa-lg"></i>&nbsp;&nbsp;SMH878131732
                  </td>
                </tr>
                <tr>
                  <td>开发语言：</td>
                  <td colspan="5">JSP</td>
                </tr>
                <tr>
                  <td>开发环境：</td>
                  <td colspan="5">前台：SublimeText3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;后台：Myeclipse + tomcat7.0</td>
                </tr>
                <tr>
                  <td>开发日期：</td>
                  <td colspan="5">2016.11.1-2016.11.31</td>
                </tr>
              </table>
            </div><!-- systemInfo -->
            
	<%@ include file="/public/footer.jsp" %>
<!-- 
 /**
 *类描述：
 *@author: 孙梦海
 */ -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
				<span>添加学生</span>
				<a href="javascript:;" onClick="javascript:history.back(-1);"><i class="fa fa-angle-double-left fa-lg"></i> 返回</a>
				<!-- <a href="studentsList.do"><i class="fa fa-angle-double-left fa-lg"></i> 返回列表</a> -->
			</div><!-- name -->

			<form class="addSud" method="post" action="">
				<table>
					<tr><td colspan="6"><strong>&nbsp;&nbsp;&nbsp;&nbsp;学生基本信息</strong></td></tr>
					<tr>
						<td class="textRight">姓名</td>
						<td colspan="2"><input type="text" id="name" name="name" placeholder="请输入姓名"></td>
						<td class="textRight">学号</td>
						<td colspan="2"><input type="text" id="studentId" name="studentId" placeholder="请输入13位数字学号"></td>
					</tr>
					<tr>
						<td class="textRight">性别</td>
						<td colspan="2"><input type="text" id="sex" name="sex" placeholder="请输入性别"></td>
						<td class="textRight">身份证号</td>
						<td colspan="2"><input type="text" id="idCard" name="idCard" placeholder="请输入身份证号"></td>
					</tr>
					<tr>
						<td class="textRight">年龄</td>
						<td colspan="2"><input type="text" id="age" name="age" placeholder="请输入年龄"></td>
						<td class="textRight">生日</td>
						<td colspan="2"><input type="text" id="birthDay" name="birthDay" placeholder="请输入生日，格式为：2016-01-01"></td>
					</tr>
					<tr>
						<td class="textRight">宿舍</td>
						<td colspan="2"><input type="text" id="dorm" name="dorm" placeholder="请输入宿舍号，例如荟五6363"></td>
						<td class="textRight">籍贯</td>
						<td colspan="2"><input type="text" id="homeland" name="homeland" placeholder="请输入籍贯"></td>
					</tr>
					<tr>
						<td class="textRight">QQ</td>
						<td colspan="2"><input type="text" id="qq" name="qq" placeholder="请输入QQ号"></td>
						<td class="textRight">手机号码</td>
						<td colspan="2"><input type="text" id="phoneNumber" name="phoneNumber" placeholder="请输入11位数字手机号码"></td>
					</tr>
					
					<tr><td colspan="6"><strong>&nbsp;&nbsp;&nbsp;&nbsp;社会经历</strong></td></tr>
					<tr>
						<td class="textRight">个人介绍</td>
						<td colspan="5"><input type="text" id="self" name="self" placeholder="请输入个人介绍"></td>
					</tr>
					<tr>
						<td class="textRight">大一主题</td>
						<td><input type="text" id="firstTheme" name="firstTheme" placeholder="请输入活动主题"></td>
						<td class="textRight">经历描述</td>
						<td colspan="3"><input type="text" id="firstContent" name="firstContent" placeholder="请输入活动描述"></td>
					</tr>
					<tr>
						<td class="textRight">大二主题</td>
						<td><input type="text" id="secondTheme" name="secondTheme" placeholder="请输入活动主题"></td>
						<td class="textRight">经历描述</td>
						<td colspan="3"><input type="text" id="secondContent" name="secondContent" placeholder="请输入活动描述"></td>
					</tr>
					<tr>
						<td class="textRight">大三主题</td>
						<td><input type="text" id="thirdTheme" name="thirdTheme" placeholder="请输入活动主题"></td>
						<td class="textRight">经历描述</td>
						<td colspan="3"><input type="text" id="thirdContent" name="thirdContent" placeholder="请输入活动描述"></td>
					</tr>
					<tr>
						<td class="textRight">大四主题</td>
						<td><input type="text" id="fourthTheme" name="fourthTheme" placeholder="请输入活动主题"></td>
						<td class="textRight">经历描述</td>
						<td colspan="3"><input type="text" id="fourthContent" name="fourthContent" placeholder="请输入活动描述"></td>
					</tr>
					
					<tr><td colspan="6"><strong>&nbsp;&nbsp;&nbsp;&nbsp;学生成绩</strong></td></tr>
					<tr>
						<td class="textRight">C语言程序设计</td>
						<td><input type="text" id="c" name="c" placeholder="请输入0~100内的整数"></td>
						<td class="textRight">C++程序设计</td>
						<td><input type="text" id="cplus" name="cplus" placeholder="请输入0~100内的整数"></td>
						<td class="textRight">JAVA语言程序设计</td>
						<td><input type="text" id="java" name="java" placeholder="请输入0~100内的整数"></td>
					</tr>
					<tr>
						<td class="textRight">数据库系统概论</td>
						<td><input type="text" id="dataBase" name="dataBase" placeholder="请输入0~100内的整数"></td>
						<td class="textRight">数据结构</td>
						<td><input type="text" id="dataStructures" name="dataStructures" placeholder="请输入0~100内的整数"></td>
						<td class="textRight">算法设计分析</td>
						<td><input type="text" id="algorithm" name="algorithm" placeholder="请输入0~100内的整数"></td>
					</tr>
					<tr>
						<td class="textRight">操作系统</td>
						<td><input type="text" id="operateSystem" name="operateSystem" placeholder="请输入0~100内的整数"></td>
						<td class="textRight">计算机组成原理</td>
						<td><input type="text" id="composition" name="composition" placeholder="请输入0~100内的整数"></td>
						<td class="textRight">计算机网络</td>
						<td><input type="text" id="network" name="network" placeholder="请输入0~100内的整数"></td>
					</tr>

					<tr>
						<td></td>
						<td colspan="5">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" id="addStudents" value="提交"></td>
					</tr>
				</table>
			</form>
            
	<%@ include file="/public/footer.jsp" %>
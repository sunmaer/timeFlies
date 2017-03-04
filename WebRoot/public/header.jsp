<!-- 
 /**
 *类描述：
 *@author: 孙梦海
 */ -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
//js关闭当前页面/关闭当前窗口(兼容所有浏览器)
function CloseWebPage(){
	 if (navigator.userAgent.indexOf("MSIE") > 0) {
	  if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
	   window.opener = null;
	   window.close();
	  } else {
	   window.open('', '_top');
	   window.top.close();
	  }
	 }
	 else if (navigator.userAgent.indexOf("Firefox") > 0) {
	  window.location.href = 'about:blank ';
	 } else {
	  window.opener = null;
	  window.open('', '_self', '');
	  window.close();
	 }
	}
</script>
  <header>
  <!-- logo -->
  <a href="index.do" class="logo">
    <i class="fa fa-skyatlas fa-lg" style="color: #fff;"></i> &nbsp;学生信息管理系统
  </a>
   <ul>
     <li><a href="home.do?studentId=2014317200405" target="_blank">前台首页</a></li>
     <li><a href="Admin/addStudents.jsp">添加学生</a></li>
     <li><a href="index.do">使用帮助</a></li>
     <li class="user">
       <a href="javascript:void(0);"><!-- 设置a不可跳转 -->
         <img src="img/1.jpg" alt="用户头像"/>
         <span>您好，<strong><% out.print( session.getAttribute("userName")); %></strong> !</span>
       </a>
       <!-- 下拉菜单 -->
       <div class="dropDown">
         <a href="showAdmin.do">个人中心</a>
         <a href="loginOut.do" onclick="if(confirm('确定注销登录吗?')==false)return false;">注销登录</a>
       </div>
     </li>
     <li><a href="javascript:void(0);" onclick="if(confirm('确定退出登录吗?')==false){return false;}else{CloseWebPage();}">退出登录</a></li>
   </ul>
</header>

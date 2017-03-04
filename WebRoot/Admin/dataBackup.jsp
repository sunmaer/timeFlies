<!-- 
 /**
 *类描述：
 *@author: 孙梦海
 */ -->
<%@ page language="java" import="java.util.*,org.cms.dbo.*" pageEncoding="UTF-8"%>
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
  	   <% 
  	  MySQL my = new MySQL();
  	  String command="cmd /c mysqldump -u "+"root"+" -p"+" "+" "+"coi"+" > "+"d:/info.sql";
  	  //my.load();
  	  my.backup(command);
  	   %>
  	   <%@ include file="/public/header.jsp" %>

       <%@ include file="/public/leftBar.jsp" %>

       <div class="main">
          <p class="url">学生信息 管理中心</p>
          <div class="container">
            <div class="name">
				<span>数据备份</span>
				<a href="dataBackup.jsp"><i class="fa fa-reply"></i> 恢复备份</a>
			</div><!-- name -->

			<div class="list">
				<table>
					<tr>
						<th class="checkbox">
							&nbsp;<input type="checkbox">&nbsp;
						</th>
						<th>数据表名</th>
						<th>类型</th>
						<th>记录数</th>
						<th>数据</th>
						<th>索引</th>
						<th>碎片</th>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>
					<tr>
						<td>
							&nbsp;<input type="checkbox">&nbsp;
						</td>
						<td>admin</td>
						<td>MyISAM</td>
						<td>1</td>
						<td>84</td>
						<td>2048</td>
						<td>0</td>
					</tr>

					
					<tr id="tr1">
						<td colspan="7">数据库占用118KB</td>
					</tr>
					<tr id="tr2">
						<td colspan="7">分卷备份设置</td>
					</tr>
					<tr id="tr3">
						<td colspan="7">
							文件名：<input type="text" placeholder="D20160226T220644">&nbsp;&nbsp; 
							每个分卷文件大小：<input type="text" placeholder="2048"> K
						</td>
					</tr>
				</table>

				<button>确定备份</button>
				<div class="page page-backup"></div>

			</div><!-- list -->
            
	<%@ include file="/public/footer.jsp" %>
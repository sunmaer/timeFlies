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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>时光不老，我们不散</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="short icon" href="img/favicon.ico">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <c:if test="${not empty studentsList}">
		<c:forEach items="${studentsList}" var="student">
        
    <div class="container-fluid">
      <div class="row nav">
        <video autoplay="" loop="" preload="auto">
          <source src="img/Home.mp4"></source>
        </video>

        <div class="mask">
        </div>
		<a name="welcome" id="welcome"></a>
        <div id="mynavbar" class="mynavbar">
          <ul>
            <li>
            	<a href="home.do?#welcome">欢迎</a>
            	<hr />
            </li>
            <li><a href="home.do?#aboutme">关于我</a></li>
            <li><a href="home.do?#skills">专业技能</a></li>
            <li><a href="home.do?#experience">社会经历</a></li>
            <li><a href="home.do?#dream">求职意向</a></li>
            <li><a href="home.do?#all">关于他们</a></li>
          </ul>
        </div>

        <div class="banner">
          <p>当你的才华还撑不起你的野心时</p>
          <p>那你就应该静下心来学习</p>
          <a href="home.do?#aboutme">查看简历</a>
        </div>
      </div>

      <!-- 关于我 -->
      <a name="aboutme" id="aboutme"></a>
      <div class="row bg-about" id="about">
        <div class="wrapper">
          <div class="photo">
            <img src="img/touxiang/${student.studentId}.png" alt="Hello~">
            <div class="info">
              <h2>&nbsp;&nbsp;关于我</h2>
              <hr>
              <p>
                &nbsp;&nbsp;&nbsp;&nbsp;${student.self}
              </p>
            </div>
            
          </div>
          <div class="content">
            <h3 class="title">&nbsp;&nbsp;个人简介</h3>
            <ul>
              <li><p><span class="item">姓名</span><span class="line"></span>${student.name}</p></li>
              <li><p><span class="item">生日</span><span class="line"></span>${student.birthDay}</p></li>
              <li><p><span class="item">学号</span><span class="line"></span>${student.studentId}</p></li>
              <li><p><span class="item">年龄</span><span class="line"></span>${student.age}</p></li>
              <li><p><span class="item">宿舍</span><span class="line"></span>${student.dorm}</p></li>
              <li><p><span class="item">籍贯</span><span class="line"></span>${student.homeland}</p></li>
              <li><p><span class="item">QQ</span><span class="line"></span>${student.qq}</p></li>
              <li><p><span class="item">手机号码</span><span class="line"></span>${student.phoneNumber}</p></li>
              <li><p><span class="item">专业</span><span class="line"></span>计算机科学与技术</p></li>
              <li>
                <p><span class="item">兴趣爱好</span><span class="line"></span>
                  <i class="fa fa-laptop"></i>&nbsp;&nbsp;
                  <i class="fa fa-soccer-ball-o"></i>&nbsp;&nbsp;
                  <i class="fa fa-gamepad"></i>&nbsp;&nbsp;
                  <i class="fa fa-book"></i>&nbsp;&nbsp;
                  <i class="fa fa-spinner fa-pulse"></i>
                </p>
                </li>
            </ul>
          </div>
        </div>
      </div>
      
      <!-- 专业技能 -->
      <a name="skills" id="skills"></a>
      <div class="row bg-skills" id="skills">
        <div class="wrapper">
          <h3 class="title">&nbsp;&nbsp;技能储备</h3>
          <q>更贴近设计师和程序员的技能储备，让我无论从设计初稿到后端功能配合，都能把每一个像素意义发挥到极致。</q>
          <div class="item">
            <span class="type">C语言程序设计</span>
            <div class="progress">
              <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: ${student.c}%">
                <span class="sr-only">${student.c} Complete</span>
              </div>
           </div>
          </div>
          <div class="item">
            <span class="type">C++程序设计</span>
            <div class="progress">
              <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: ${student.cplus}%">
                <span class="sr-only">${student.cplus} Complete</span>
              </div>
           </div>
          </div>
          <div class="item">
            <span class="type">JAVA程序设计</span>
            <div class="progress">
              <div class="progress-bar progress-bar-danger progress-bar-striped active" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: ${student.java}%">
                <span class="sr-only">${student.java} Complete</span>
              </div>
           </div>
          </div>
          <div class="item">
            <span class="type">数据库系统概论</span>
            <div class="progress">
              <div class="progress-bar progress-bar-warning progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: ${student.dataBase}%">
                <span class="sr-only">${student.dataBase} Complete</span>
              </div>
           </div>
          </div>
          <div class="item">
            <span class="type">数据结构</span>
            <div class="progress">
              <div class="progress-bar progress-bar-primary progress-bar-striped active" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: ${student.dataStructures}%">
                <span class="sr-only">${student.dataStructures} Complete</span>
              </div>
           </div>
          </div>
          <div class="item">
            <span class="type">算法设计分析</span>
            <div class="progress">
              <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: ${student.algorithm}%">
                <span class="sr-only">${student.algorithm} Complete</span>
              </div>
           </div>
          </div>
          <div class="item">
            <span class="type">操作系统</span>
            <div class="progress">
              <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: ${student.operateSystem}%">
                <span class="sr-only">${student.operateSystem} Complete</span>
              </div>
           </div>
          </div>
          <div class="item">
            <span class="type">计算机组成原理</span>
            <div class="progress">
              <div class="progress-bar progress-bar-warning progress-bar-striped active" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: ${student.composition}%">
                <span class="sr-only">${student.composition} Complete</span>
              </div>
           </div>
          </div>
          <div class="item">
            <span class="type">计算机网络</span>
            <div class="progress">
              <div class="progress-bar progress-bar-primary progress-bar-striped active" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: ${student.network}%">
                <span class="sr-only">${student.network} Complete</span>
              </div>
           </div>
          </div>

        </div>
      </div>

      <!-- 社会经历 -->
      <a name="experience" id="experience"></a>
      <div class="row bg-experience" id="experience">
        <div class="wrapper">
          <h3 class="title">&nbsp;&nbsp;岁月如歌</h3>
          <q>岁月是一场有去无回的旅行</q>
          <div class="content">
          	<div class="vertical-line"></div>
          	<ul>
          		<li>
          			<div class="left-content">
          				<p class="business-name">${student.firstTheme}</p>
          				<p class="business-content">${student.firstContent}</p>
          			</div>
          			<div class="right-content">
          				<p class="business-time">2014.09 - 2015.01</p>
          			</div>
          			<div class="simboo">
          				<i class="fa fa-institution "></i>
          			</div>
          		</li>
          		<li>
          			<div class="right-content">
          				<p class="business-name">${student.secondTheme}</p>
          				<p class="business-content">${student.secondContent}</p>
          			</div>
          			<div class="left-content">
          				<p class="business-time">2015.02 - 2015.07</p>
          			</div>
          			<div class="simboo">
          				<i class="fa fa-group"></i>
          			</div>
          		</li>
          		<li>
          			<div class="left-content">
          				<p class="business-name">${student.thirdTheme}</p>
          				<p class="business-content">${student.thirdContent}</p>
          			</div>
          			<div class="right-content">
          				<p class="business-time">2015.09 - 2016.01</p>
          			</div>
          			<div class="simboo">
          				<i class="fa fa-cloud"></i>
          			</div>
          		</li>
          		<li>
          			<div class="right-content">
          				<p class="business-name">${student.fourthTheme}</p>
          				<p class="business-content">${student.fourthContent}</p>
          			</div>
          			<div class="left-content">
          				<p class="business-time">2016.02 - 2016.07</p>
          			</div>
          			<div class="simboo">
          				<i class="fa fa-graduation-cap"></i>
          			</div>
          		</li>
          	</ul>
          </div>
        </div>
      </div>

      <!-- 求职意向 -->
      <a name="dream" id="dream"></a>
      <div class="row bg-dream" id="dream">
        <div class="wrapper">
          <h3 class="title">&nbsp;&nbsp;求职意向</h3>
          <div class="row">
            <div class="col-md-4">
              <div class="classify classify-web">
                <p class="classify-title">
                  Web<br>前端工程师
                </p>
                <p class="classify-item">Web前端开发技术</p>
                <p class="classify-item">网站性能优化</p>
                <p class="classify-item">SEO和服务器端的基础知识</p>
                <p class="classify-item">各种自动化部署工具</p>
              </div>
            </div>
            <div class="col-md-4">
              <div class="classify classify-java">
                <p class="classify-title">
                  Java<br>工程师
                </p>
                <p class="classify-item">通用框架技术</p>
                <p class="classify-item">Java语言基础</p>
                <p class="classify-item">Java服务端技术</p>
                <p class="classify-item">Web开发技术</p>
              </div>
            </div>
            <div class="col-md-4">
              <div class="classify classify-android">
                <p class="classify-title">
                  Android<br>工程师
                </p>
                <p class="classify-item">Java语言基础</p>
                <p class="classify-item">Android系统</p>
                <p class="classify-item">手机软件</p>
                <p class="classify-item">手机游戏</p>
              </div>
            </div>
          </div>
          <q>梦想还是要有的，万一实现了呢？</q>
          <div class="row row-company">
            <div class="col-md-2">
              <img src="img/1.png" alt="阿里巴巴">
              <p>阿里巴巴</p>
            </div>
            <div class="col-md-2">
              <img src="img/2.png" alt="腾讯">
              <p>腾讯</p>
            </div>
            <div class="col-md-2">
              <img src="img/3.png" alt="百度">
              <p>百度</p>
            </div>
            <div class="col-md-2">
              <img src="img/4.png" alt="网易">
              <p>网易</p>
            </div>
            <div class="col-md-2">
              <img src="img/5.png" alt="华为">
              <p>华为</p>
            </div>
            <div class="col-md-2">
              <img src="img/6.png" alt="美团点评">
              <p>美团点评</p>
            </div>
          </div>
        </div>
      </div>
      
      <!-- 所有成员 -->
      <a name="all" id="all"></a>
      <div class="row" id="member">
       <h3 class="title">&nbsp;&nbsp;时光不老，我们不散</h3>
       <div class="member">
    	<table>
    		<tr>
    			<td><a href="home.do?studentId=2014317200401"><img  src="img/touxiang/2014317200401.png"></a></td>
                <td><a href="home.do?studentId=2014317200429"><img  src="img/touxiang/2014317200429.png"></a></td>
                <td><a href="home.do?studentId=2014317200430"><img  src="img/touxiang/2014317200430.png"></a></td>
                <td><a href="home.do?studentId=2014317200414"><img  src="img/touxiang/2014317200414.png"></a></td>
                <td><a href="home.do?studentId=2014317200402"><img  src="img/touxiang/2014317200402.png"></a></td>
                <td><a href="home.do?studentId=2014317200412"><img  src="img/touxiang/2014317200412.png"></a></td>
                <td><a href="home.do?studentId=2014317200427"><img  src="img/touxiang/2014317200427.png"></a></td>
                <td><a href="home.do?studentId=2013311200906"><img  src="img/touxiang/2013311200906.png"></a></td>
                <td><a href="home.do?studentId=2014317200428"><img  src="img/touxiang/2014317200428.png"></a></td>
    		</tr>
    		<tr>
    			<td><a href="home.do?studentId=2014317200407"><img  src="img/touxiang/2014317200407.png"></a></td>
                <td><a href="home.do?studentId=2014317200413"><img  src="img/touxiang/2014317200413.png"></a></td>
                <td><a href="home.do?studentId=2014317200421"><img  src="img/touxiang/2014317200421.png"></a></td>
                <td><a href="home.do?studentId=2014317200405"><img  src="img/touxiang/2014317200405.png"></a></td>
                <td><a href="home.do?studentId=2014317200403"><img  src="img/touxiang/2014317200403.png"></a></td>
                <td><a href="home.do?studentId=2014317200431"><img  src="img/touxiang/2014317200431.png"></a></td>
                <td><a href="home.do?studentId=2014317200423"><img  src="img/touxiang/2014317200423.png"></a></td>
                <td><a href="home.do?studentId=2014317200408"><img  src="img/touxiang/2014317200408.png"></a></td>
                <td><a href="home.do?studentId=2014317200417"><img  src="img/touxiang/2014317200417.png"></a></td>   		
            </tr>
    		<tr>
    			<td><a href="home.do?studentId=2014317200406"><img  src="img/touxiang/2014317200406.png"></a></td>
                <td><a href="home.do?studentId=2014317200404"><img  src="img/touxiang/2014317200404.png"></a></td>
                <td><a href="home.do?studentId=2014317200418"><img  src="img/touxiang/2014317200418.png"></a></td>
                <td><a href="home.do?studentId=2014317200426"><img  src="img/touxiang/2014317200426.png"></a></td>
                <td><a href="home.do?studentId=2014317200425"><img  src="img/touxiang/2014317200425.png"></a></td>
                <td><a href="home.do?studentId=2014317200411"><img  src="img/touxiang/2014317200411.png"></a></td>
                <td><a href="home.do?studentId=2014317200409"><img  src="img/touxiang/2014317200409.png"></a></td>
                <td><img  src="img/touxiang/10.png"></td>
                <td><a href="home.do?studentId=2014317200424"><img  src="img/touxiang/2014317200424.png"></a></td>
    		</tr>
    	</table>
      </div>
      
    <!-- 页脚 -->
    <footer>
       <p>Copyright © 2016至今 孙梦海-赵晨宇版权所有</p>
    </footer>
    </div>
    </c:forEach>
    </c:if>
    <!-- 回到顶部按钮 -->
	<div class="button" title="回到顶部"><i class="fa fa-chevron-up fa-lg"></i></div>

    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/index.js"></script>
  </body>
</html>

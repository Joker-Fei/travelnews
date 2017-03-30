<!-- 后台管理页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>旅游资讯网管理平台-首页</title>
<link href="share/images/favicon.ico" rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="share/css/share.css" />
<link rel="stylesheet" type="text/css"
	href="admin/css/default/index.css" />
<link rel="stylesheet" type="text/css"
	href="admin/css/default/share.css" />
<script src="share/js/jquery-1.11.0.min.js"
	type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>

</head>

<body>
	<div class="bezel" id="bezel-id">
		<div class="head">
			<div class="hleft">
				<span class="head-icon">环球旅讯后台管理</span>
			</div>

		<div class="hcenter">
 
        </div>
		
			<div class="hright">
				用户：${sessionScope.loginUser.userName } 您好，欢迎使用使用后台管理！
				<!-- <a class="outLogin" href="#">修改密码</a> -->
				<!-- <a class="outLogin" href="userdetailservlet?op=revisepwd" target="rightFrame">修改密码</a> -->
				<a class="outLogin" href="logoff.jsp">注销</a></span>
			</div>
		</div>
		<div class="center">

			<div class="cleft" id="cleft-id">
				<h4>新闻管理</h4>
				<ul>
					<li class="on"><a href="newstypeservlet?op=list" target="rightFrame">类型管理</a></li>
					<!-- <li><a href="newstypeservlet?op=list" target="rightFrame">类型列表</a></li> -->

					<li ><a href="newsdetailservlet?op=toAdd" target="rightFrame">添加新闻</a></li>
					<li><a href="newsdetailservlet?op=list" target="rightFrame">新闻列表</a></li>
					<li><a href="topnewsdetailservlet?op=toAddTopNews" target="rightFrame">添加头条</a></li>
					<li><a href="topnewsdetailservlet?op=list" target="rightFrame">头条管理</a></li>
				</ul>

				<h4>用户管理</h4>
				<ul>
					<li class="on"><a href="addUser.jsp" target="rightFrame">添加用户</a></li>
					<li><a href="userdetailservlet?op=list" target="rightFrame">用户列表</a></li>
				</ul>
				<h4>酒店管理</h4>
				<ul>
					<li class="on"><a href="hoteltypeservlet?op=list" target="rightFrame">类型管理</a></li>
					<li><a href="hoteldetailservlet?op=toAdd" target="rightFrame">酒店添加</a></li>
					<li><a href="hoteldetailservlet?op=list" target="rightFrame">酒店列表</a></li>
				</ul>
				
				<h4>旅游路线</h4>
				<ul>
					<li class="on"><a href="roadtypeservlet?op=list" target="rightFrame">类型管理</a></li>
					<li><a href="roaddetailservlet?op=toAdd" target="rightFrame">路线添加</a></li>
					<li><a href="roaddetailservlet?op=list" target="rightFrame">路线列表</a></li>
				</ul>
				<h4>游记管理</h4>
				<ul>
					<li class="on"><a href="blogservlet?op=blogdelete" target="rightFrame">审批管理</a></li>
					<!-- <li><a href="roaddetailservlet?op=toAdd" target="rightFrame">路线添加</a></li>
					<li><a href="roaddetailservlet?op=list" target="rightFrame">路线列表</a></li> -->
				</ul>
			</div>
		 <div id="showHideMenu"></div> 
			<div class="rleft">


				<!--   <div class="topMenu">
            	  <ul>
            	   	  <li><a href="javascript:add()">　新增　</a></li>
           	  		  <li><a href="#">　发布　</a></li>
         		      <li><a href="#">　删除　</a></li>
         		      <li><a href="#">　置顶　</a></li>
				  </ul>
            </div> -->

				 


				<iframe name="rightFrame" src="" width="100%" height="100%"
					frameborder="0">
					
					
					</iframe>
				




			</div>
		</div>
		<div class="floot">环球旅游资讯网版权所有</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>旅游资讯网后台管理-登录</title>
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link href="share/css/share.css" rel="stylesheet" type="text/css"/>
<link href="admin/css/default/login.css" rel="stylesheet" type="text/css"  />
<link href="admin/css/default/share.css" rel="stylesheet" type="text/css"  />
</head>

<body id="loginBody">
<div id="pointerOpen" onclick="hideLoginBezel()">开启登录</div>
<div id="loginBezel">
<!-- <div id="loginChildTop" onclick="hideLoginBezel()" title="点击将隐藏登录小窗口">　CMS管理平台</div> -->
<div id="loginChildTop">　<img src="admin/images/logo-right.png" width="57" height="50" align="absbottom"  /> 旅游资讯网管理平台</div>
<div id="loginChildBottom">
<table cellpadding="0" cellspacing="0" width="100%" height="95%" border="0">
<tr>
<td align="right" width="35%">账　号：</td>
<td align="left" width="65%"><input type="text" id="account"  class="inputUP"/></td>
</tr>
<tr>
<td align="right">密　码：</td>
<td align="left"><input type="password" id="pwd" class="inputUP"/></td>
</tr>
<tr>
<td align="right">验证码：</td>
<td align="left"><input type="text" id="checkNum"/>&nbsp;<span id="checkNumResult"><img src="admin/images/checkNum.jpg" id="checkImage" align="absbottom" alt="验证码" title="点击更换验证码" /></span></td>
</tr>
<tr>
<td align="center" colspan="2"><input type="button" onclick="toLogin(this)"  id="toLogin" value="登　录"/> </td>
</tr> 
</table>
</div>
</div>
<script src="share/js/jquery-1.11.0.js"></script>
<script src="admin/js/login.js"></script>
</body>
</html>

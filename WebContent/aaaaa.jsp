<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html> 
<head> 
<title>没登陆</title> 
<link href="css/login1.css" mce_href="css/login1.css" rel="stylesheet" type="text/css" /> 
<script language="javascript" type="text/javascript"> 
var i = 5; 
var intervalid; 
intervalid = setInterval("fun()", 1000); 
function fun() { 
if (i == 0) { 
window.location.href = "http://localhost:8080/travelnews/log.jsp"; 
clearInterval(intervalid); 
} 
document.getElementById("mes").innerHTML = i; 
i--; 
} 
</script> 

</head> 
<body> 
<div id="errorfrm"  style="text-align:center;"> 
<h2><a style="color:red">对不起！您还没登陆~</a></h2> 
<div id="error"> 
<!-- <img src="images/image5.jpg" mce_src="images/image5.jpg" alt="" />  -->
<!-- <p>登陆以后才能写游记！</p>  -->
<p><a style="color:green">将在 <span id="mes">5</span> 秒钟后返回登陆界面！</a></p> 
</div> 
 
</div> 
</body> 
</html>
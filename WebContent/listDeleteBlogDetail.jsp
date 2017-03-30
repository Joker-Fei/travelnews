<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台游记详情</title>

<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>
    <script type="text/javascript" src="js/xheditor_lang/zh-cn.js"></script>

<style type ="text/css"> 
 
a {font-size:14px;
text-decoration:none;
color:white;
/* font-weight:bold; */
} 
</style>
<style type="text/css">
.div1{
/* float:left; */
margin-left:300px;
Margin-bottom:0px;
}
table td
{
word-break: keep-all;
white-space:nowrap;
}</style>
</head>
<body>

<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：游记管理　&gt;&gt;　游记详情　</a> 

	<div class="div1">
	<table width="100%"  border="0px" cellpadding="0" align="center" cellspacing="0">
	
			<tr style="background-color: ${status.index%2==0?'':'#4F4F4F' } ">
			
			<tr>
				<td><a>标题</a></td>
				<td><a href="blogservlet?op=toBlogDetail&id=${blog.id }" target="_blank">${blog.title }</a></td>
			</tr>
			<tr>
				<td></td>		
				<td><img src="http://localhost:8080/travelnews/${blog.imgUrl}"  width="350" height="150" border="0"">
				</td>  
			</tr>
			<tr>
				<td><a>作者</a></td>
				<td><a>${blog.author }</a></td>
			</tr>
			<tr>
				<td><a>发表时间</a></td>
				<td><a>${blog.publishTime }</a></td>
			</tr>
			<tr>
				<td><a>新闻内容</a></td>
				<td>
				<textarea class="xheditor" rows="12" cols="60" name="content">${blog.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><a style="font-size:14px;text-decoration:none;color:#FFAA33;" >操作：</a><a href="blogservlet?op=delete&id=${blog.id }">删除</a>
				<a href="blogservlet?op=blogdelete">返回列表</a></td>
			</tr>

		
	</table>
	</div>

</body>
</html>
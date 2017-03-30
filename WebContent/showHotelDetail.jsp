<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script> -->

<style type="text/css">
	body{
		background-image: url("images/bg_newsDetailList1.jpg");
		background-position:-100px -300px;
	}
	.enableStyle{
		background-color: ;
		color:black;
	}
	.disableStyle{
		background-color: red;
		color: white;
	}
</style>
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
margin-left:200px;
Margin-bottom:0px;
}
table td
{
word-break: keep-all;
white-space:nowrap;
}</style>
</head>
<body>
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：酒店管理　&gt;&gt;　酒店详情　</a>
<form name="myform" method="post" action="hoteldetailservlet?op=batchDelete">
	<div class="div1">
		<table width="100%"  border="0px" cellpadding="0" align="center" cellspacing="0">

		<c:forEach items="${requestScope.hotelDetailList }"  var="hotelDetail" varStatus="status">
<%-- 			<tr style="background-color: ${status.index%2==0?'':'#4F4F4F' } "> --%>
			<tr>
			
				<td>
				</td>
				<td><img src="http://localhost:8080/travelnews/${hotelDetail.imgUrl}"  width="400" height="200" border="0"></td>
			</tr>
			<tr>
				<td><a>酒店名</a></td>
				
<%-- 					<input type="checkbox" name="ids" value="${hotelDetail.id }"/> --%>
<%-- 					${hotelDetail.id } --%>
				<td>${hotelDetail.name }</td>
				
			</tr>
			<tr>
				<td><a>星级</a></td>
				<td>${hotelDetail.typeName }</td>
			</tr>
			<tr>
				<td><a>发布者</a></td>
				<td>${hotelDetail.author }</td>
			</tr>
			<tr>
				<td><a>价格</a></td>
				<td>${hotelDetail.price }</td>
			</tr>
			<tr>
				<td><a>城市</a></td>
				<td>${hotelDetail.city }</td>
			</tr>
			<tr>
				<td><a>网址</a></td>
				<td>${hotelDetail.web }</td>
			</tr>
			<tr>
				<td><a>地址</a></td>
				<td><textarea rows="8" cols="50" name="content">${hotelDetail.address }</textarea></td>
			</tr>
			<tr>
				<td><a>电话</a></td>
				<td>${hotelDetail.phone }</td>
			</tr>
			<tr>
				<td><a>发布时间</a></td>
				<td>${hotelDetail.publishTime }</td>
			</tr>
<%-- 				<td><a href="hoteldetailservlet?op=toHotelDetail&id=${hotelDetail.id }">编辑</a></td> --%>
		 
		</c:forEach>
		<tr>
			<td colspan="4" >
			<td><a href="hoteldetailservlet?op=delete&id=${hotelDetail.id }">删除</a></td>
			</td>
		</tr>
	</table>
	</div>
	</form>
</body>
</html>
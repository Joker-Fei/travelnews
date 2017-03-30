<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游记审核管理</title>
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/listNewsDetail.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
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
 
 <style type="text/css">
.div1{
float:left;
margin-left:30px;
}
.div2{
/* float:right; */
margin-right:10px;
margin-top:30px;
}
</style> 
</head>
<body>
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：游记管理　&gt;&gt;　审批管理　</a>
<div class="div2">
	<tbody>
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>标题</th>
			<!-- <th>图片</th> --> 
			<!-- <th>类型</th> -->
			<th>发布者</th>
			<th>时间</th>
			<th>详情</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.blogList}"  var="blog" varStatus="status">
			<tr style="background-color: ${status.index%2==0?'':'#4F4F4F' } ">
				<td>
				
					${blog.id}
				</td>
				<td nowrap><a href="blogservlet?op=toBlogDetail&id=${blog.id }" target="_blank">${blog.title }</a></td>
<%-- 				<td><img src="http://localhost:8080/travelnews/${hotelDetail.imgUrl}"  width="104" height="118" border="0""></td> --%>
				<%-- <td>${roadDetail.typeName }</td> --%>
				<td nowrap>${blog.author }</td>
				<td nowrap>${blog.publishTime }</td>
				<td nowrap><a href="blogservlet?op=toBlogDetail&id=${blog.id }">详情</a></td>
				<td nowrap><a href="blogservlet?op=delete&id=${blog.id }">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" >
			<!-- 
				<input type="button" value="批量删除" onclick="checkSelected()"/>
			 -->
			<div id="page">
            <ul>
            <li class="first"><a href="blogservlet?op=toBlog&pageNo=1">&nbsp;首页&nbsp;</a></li>
            <li class="upPage"><a href="blogservlet?op=listAllDelete&pageNo=${sessionScope.pageBean.prePage }">&nbsp;上一页&nbsp;</a></li>
            <li class="nextPage"><a href="blogservlet?op=listAllDelete&pageNo=${sessionScope.pageBean.nextPage }">&nbsp;下一页&nbsp;</a></li>
            <li class="lastPage"><a href="blogservlet?op=listAllDelete&pageNo=${sessionScope.pageBean.pageCount }">&nbsp;末页&nbsp;</a></li>
            </ul>
			</td>
		</tr>
        </div>
	</table>
	</tbody>
	</form>
	</div>
</body>
</html>
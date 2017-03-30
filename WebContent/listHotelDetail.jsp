<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻类型列表</title>
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
<!-- <script type="text/javascript">
function checkSelected(){
	var flag=false;
	var ids=document.getElementsByName("ids");
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked){
			flag=true;
			break;
		}
	}
	if(!flag){
		alert("请选择需要删除的数据！");
	}else{
		if(confirm("确定要删除选中的数据吗？")){
			document.myform.submit();
		}
	}
}
function clearForm(){
	document.getElementById("title").value="";
	document.getElementById("content").value="";
	document.getElementById("typeId").value="-1";
	document.getElementById("topper").value="-1";
	document.getElementById("bold").value="-1";
	document.getElementById("color").value="-1";
	document.searchForm.submit();
}
</script> -->
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
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：酒店管理　&gt;&gt;　酒店列表　</a>
<div class="div2">
<form name="myform" method="post" action="hoteldetailservlet?op=batchDelete">
	<tbody>
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>酒店名</th>
<!-- 			<th>图片</th> -->
			<th>星级</th>
			<th>发布者</th>
<!-- 			<th>价格</th> -->
<!-- 			<th>城市</th> -->
<!-- 			<th>地址</th> -->
<!-- 			<th>电话</th> -->
				<th>时间</th>
				<th>详情</th>
				<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.hotelDetailList }"  var="hotelDetail" varStatus="status">
			<tr style="background-color: ${status.index%2==0?'':'#4F4F4F' } ">
				<td>
				
					${hotelDetail.id }
				</td>
				<td nowrap>${hotelDetail.name }</td>
<%-- 				<td><img src="http://localhost:8080/travelnews/${hotelDetail.imgUrl}"  width="104" height="118" border="0""></td> --%>
				<td nowrap>${hotelDetail.typeName }</td>
				<td nowrap>${hotelDetail.author }</td>
<%-- 				<td>${hotelDetail.price }</td> --%>
<%-- 				<td>${hotelDetail.city }</td> --%>
<%-- 				<td>${hotelDetail.address }</td> --%>
<%-- 				<td>${hotelDetail.phone }</td> --%>
				<td nowrap>${hotelDetail.publishTime }</td>
				<td nowrap><a href="hoteldetailservlet?op=toHotelDetail&id=${hotelDetail.id }">详情</a></td>
				<td nowrap><a href="hoteldetailservlet?op=delete&id=${hotelDetail.id }">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"  >
			<!-- 	<input type="button" value="批量删除" onclick="checkSelected()"/> -->
			<div id="page">
            <ul>
            <li class="first"><a href="hoteldetailservlet?op=list&pageNo=1">&nbsp;首页&nbsp;</a></li>
            <li class="upPage"><a href="hoteldetailservlet?op=list&pageNo=${sessionScope.pageBean.prePage }">&nbsp;上一页&nbsp;</a></li>
            <li class="nextPage"><a href="hoteldetailservlet?op=list&pageNo=${sessionScope.pageBean.nextPage }">&nbsp;下一页&nbsp;</a></li>
            <li class="lastPage"><a href="hoteldetailservlet?op=list&pageNo=${sessionScope.pageBean.pageCount }">&nbsp;末页&nbsp;</a></li>
            </ul>
        </div>
				
			</td>
		</tr>
	</table>
	</tbody>
	</form>
	</div>
</body>
</html>
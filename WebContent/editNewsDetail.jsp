<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改新闻</title>
<script src="ckeditor/ckeditor.js"></script>
<script src="ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
margin-left:100px;
Margin-bottom:0px;
}
table td
{
word-break: keep-all;
white-space:nowrap;
}</style>
</head>
<body>
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：新闻管理　&gt;&gt;　新闻编辑　</a>
<div class="div1">
<form action="newsdetailservlet?op=update" method="post">
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<td><a>标题</a></td>
			<td>
				<input type="hidden" name="id" value="${requestScope.newsDetail.id }"/>
				<input type="text" name="title" value="${requestScope.newsDetail.title }"/>
			</td>
		</tr>
		<tr>
			<td><a>发布者</a></td>
			<td><a>${sessionScope.loginUser.userName }</a></td>
		</tr>
		<tr>
			<td><a>新闻类型</a></td>
			<td>
				<select name="typeId">
					<c:forEach items="${requestScope.newsTypeList }" var="newsType">
						<option value="${newsType.id }" ${newsType.id==requestScope.newsDetail.typeId?"selected='selected'":"" }>${newsType.typeName }</option>	
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><a>发布时间</a></td>
			<td><input type="text" name="publishTime" onClick="WdatePicker()" class="Wdate" value="${requestScope.newsDetail.publishTime }"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<a style="text-decoration:none;color:red;font-weight:bold;">置顶：</a><input type="radio" name="topper" value="1" ${requestScope.newsDetail.topper==1?"checked='checked'":"" }/>是
				<input type="radio" name="topper" value="0" ${requestScope.newsDetail.topper==0?"checked='checked'":"" }/>否
				
				<a style="text-decoration:none;color:red;font-weight:bold;">加粗：</a><input type="radio" name="bold" value="1" ${requestScope.newsDetail.bold==1?"checked='checked'":"" }/>是
				<input type="radio" name="bold" value="0" ${requestScope.newsDetail.bold==0?"checked='checked'":"" }/>否
				<a style="text-decoration:none;color:red;font-weight:bold;">颜色：</a>
				<select name="color">
					<option value="0" ${requestScope.newsDetail.color==0?"selected='selected'":"" }>黑色</option>
					<option value="1" ${requestScope.newsDetail.color==1?"selected='selected'":"" }>红色</option>
					<option value="2" ${requestScope.newsDetail.color==2?"selected='selected'":"" }>蓝色</option>
					<option value="3" ${requestScope.newsDetail.color==3?"selected='selected'":"" }>黄色</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><a>新闻内容</a></td>
			<td>
				<textarea rows="10" cols="20" name="content">${requestScope.newsDetail.content }</textarea>
				<script type="text/javascript">
			    	var editor =CKEDITOR.replace('content', {
						uiColor: '#14B8C4'
					});
			    	CKFinder.setupCKEditor( editor, 'ckfinder/' ) ;
			    </script>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="修改新闻"/>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
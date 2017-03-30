<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
  
  
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>
    <script type="text/javascript" src="js/xheditor_lang/zh-cn.js"></script>
  
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
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：旅游路线　&gt;&gt;　路线信息修改　</a></div>
<div class="div1">
<form action="roaddetailservlet?op=update" method="post">
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<td><a>路线名</a></td>
			<td>
				<input type="hidden" name="id" value="${requestScope.roadDetail.id }"/>
				<input style="width:250px;height:25px" type="text" name="roadName" value="${requestScope.roadDetail.roadName }"/>
			</td>
		</tr>
		<tr>
			<td><a>类型</a></td>
			<td>
				<select name="typeId">
					<c:forEach items="${requestScope.roadTypeList }" var="roadType">
						<option value="${roadType.id }" ${roadType.id==requestScope.roadDetail.typeId?"selected='selected'":"" }>${roadType.typeName }</option>	
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><a >发布者</a></td>
			<td><input style="width:250px;height:25px" type="text" name="userName" readonly="readonly" value="${sessionScope.loginUser.userName }"/>
			</td>
		</tr>
		<tr>
			<td><a>价格</a></td>
			<td>
				<input style="width:250px;height:25px" type="text" name="price" value="${requestScope.roadDetail.price }"/>
			</td>
		</tr>
		<tr>
			<td><a>出发地</a></td>
			<td>
				<input style="width:250px;height:25px" type="text" name="goRoad" value="${requestScope.roadDetail.goRoad }"/>
			</td>
		</tr>
		<tr>
			<td><a>返回地</a></td>
			<td>
				<input style="width:250px;height:25px" type="text" name="backRoad" value="${requestScope.roadDetail.backRoad }"/>
			</td>
		</tr>
		<tr>
			<td><a>旅游天数</a></td>
			<td>
				<input style="width:250px;height:25px" type="text" name="days" value="${requestScope.roadDetail.days }"/>
			</td>
		</tr>
		<tr>
			<td><a>旅行社</a></td>
			<td>
				<input style="width:250px;height:25px" type="text" name="agency" value="${requestScope.roadDetail.agency }"/>
			</td>
		</tr>
		<tr>
			<td><a>电话</a></td>
			<td>
				<input style="width:250px;height:25px" type="text" name="phone" value="${requestScope.roadDetail.phone }"/>
			</td>
		</tr>
		<tr>
			<td><a>交通工具</a></td>
			<td>
				<input style="width:250px;height:25px" type="text" name="traffic" value="${requestScope.roadDetail.traffic }"/>
			</td>
		</tr>
		<tr>
			<td><a>关键词</a></td>
			<td>
				<input style="width:250px;height:25px" type="text" name="tag" value="${requestScope.roadDetail.tag }"/>
			</td>
		</tr>
		<tr>
			<td><a>发布时间</a></td>
			<td><input  type="text" name="publishTime" onClick="WdatePicker()" class="Wdate" value="${requestScope.roadDetail.publishTime }"/></td>
		</tr>
	
		<tr>
			<td></td>
			<td>
				<textarea class="xheditor" rows="10" cols="70" name="mainInfo">${requestScope.roadDetail.mainInfo }</textarea>
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
				<input type="submit" value="修改"/>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加旅游线路</title>
<script src="ckeditor/ckeditor.js"></script>
<script src="ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="js/xheditor_lang/zh-cn.js"></script>
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/aNewsDetail.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>


<style type ="text/css"> 
 b {font-size:12px;
text-decoration:none;
color:yellow;
} 
a {font-size:14px;
text-decoration:none;
color:white;
/* font-weight:bold; */
} 
</style>
<style type="text/css">
.div1{
/* float:left; */
margin-left:290px;
Margin-bottom:0px;
}
table td
{
word-break: keep-all;
white-space:nowrap;
}
</style>
<script type="text/javascript">
function display_alert()
  {
  alert("添加成功！")
  }
</script>
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
 <script>
function formCheck33()
   {   
     
     if(document.form1.roadName.value==''){   
   alert("请填写路线名！");   
   document.form1.roadName.focus();   
   return false;}  
    
    if(document.form1.price.value==''){   
   alert("请填写价格！");   
   document.form1.price.focus();   
   return false;}   
 
   if(document.form1.goRoad.value==''){   
   alert("请填写出发地点！");   
   document.form1.goRoad.focus();   
   return false;}

   if(document.form1.backRoad.value==''){   
   alert("请填写返回地点！");   
   document.form1.backRoad.focus();   
   return false;} 

   if(document.form1.days.value==''){   
   alert("行程总天数");   
   document.form1.days.focus();   
   return false;} 

   if(document.form1.agency.value==''){   
   alert("请输入旅行社电话");   
   document.form1.agency.focus();   
   return false;} 

   if(document.form1.traffic.value==''){   
   alert("请输入交通工具!");   
   document.form1.traffic.focus();   
   return false;} 

   if(document.form1.tag.value==''){   
   alert("请输入关键词！");   
   document.form1.tag.focus();   
   return false;} 
   
    }   
</script>
</head>
<body>

<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：旅游路线　&gt;&gt;　路线添加　</a></div>
<form action="roaddetailservlet?op=add" method="post" name="form1" onsubmit="return formCheck33();" >

	<div class="div1">
	
	<table class="right-table" width="70%"  border="0px" cellpadding="0"  cellspacing="0">
		<tr>
			<td><a>路线名</a></td>
			<td><input maxlength="30" style="color:#999999;width:300px;height:25px" type="text" type="text" name="roadName"/><b>请控制在30个字以内 </b></td>
		</tr>
		<tr>
			<td><a>类型</a></td>
			<td>
				<select name="typeId">
					<c:forEach items="${requestScope.roadTypeList }" var="roadType">
						<option value="${roadType.id }">${roadType.typeName }</option>	
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><a>发布者</a></td>
			<td><a style="color:red;">${sessionScope.loginUser.userName }</a>
			</td>
		</tr>
		<tr>
			<td><a>价格</a></td>
			<td><input  style="color:#999999;width:150px;height:25px" type="text" name="price"/><b>RMB/人</b></td>
		</tr>
		<tr>
			<td><a>出发地</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" type="text" name="goRoad"/></td>
		</tr>
		<tr>
			<td><a>返回地</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" type="text" name="backRoad"/></td>
		</tr>
		<tr>
			<td><a>行程总天数</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" type="text" name="days"/><b>天</b></td>
		</tr>
	
		<tr>
			<td><a>旅行社</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" type="text" name="agency"/></td>
		</tr>
		<tr>
			<td><a>电话</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" type="text" name="phone"/></td>
		</tr>
		<tr>
			<td><a>交通工具</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" type="text" name="traffic"/></td>
		</tr>
		<tr>
			<td><a>关键词</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" type="text" name="tag"/><b>吸引游客的旅行路线特色关键词</b></td>
		</tr>
		<tr>
			<td><a>时间</a></td>
			<td><input style="color:#999999;width:150px;height:25px" type="text" name="publishTime" onClick="WdatePicker()" class="Wdate"/></td>
		</tr>
		<tr>
			<td><a>行程总描述</a></td>
			<td>
				<textarea class="xheditor" rows="10" cols="80" name="mainInfo"></textarea>
				
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="添加路线"/>
			</td>
		</tr>
	</table>
</div>
</form>
</body>
</html>
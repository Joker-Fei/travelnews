<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新闻</title>
<script src="ckeditor/ckeditor.js"></script>
<script src="ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="js/xheditor_lang/zh-cn.js"></script>
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/a.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
<script src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript">
    	var editor =CKEDITOR.replace('content', {
			uiColor: '#14B8C4'
		});
    	CKFinder.setupCKEditor( editor, 'ckfinder/' ) ;
    </script>
    <script src="ckfinder/ckfinder.js"></script>

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
 
a {font-size:15px;
text-decoration:none;
color:white;

} 
/*  td { width:80; } */
</style>

<!-- <script type="text/javascript">
function display_alert()
  {
  alert("添加成功！")
  }
</script>
 -->
<!-- Margin-top
Margin-right
Margin-bottom
Margin-left -->
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
}
b {font-size:12px;
text-decoration:none;
color:yellow;
} 
</style>
<script>
function formCheck33()
   {   
     
     if(document.form1.name.value==''){   
   alert("请填写酒店名！");   
   document.form1.name.focus();   
   return false;}  
    
    if(document.form1.imgUrl.value==''){   
   alert("请上传酒店图片！");   
   document.form1.imgUrl.focus();   
   return false;}   
 
   if(document.form1.price.value==''){   
   alert("请填写优惠价格！");   
   document.form1.price.focus();   
   return false;} 
   
   if(document.form1.city.value==''){   
	   alert("请填写酒店所在城市！！");   
	   document.form1.city.focus();   
	   return false;} 
   
   if(document.form1.web.value==''){   
	   alert("请填写酒店预订官网！");   
	   document.form1.phone.focus();   
	   return false;} 
   
   if(document.form1.phone.value==''){   
	   alert("请填写酒店电话！");   
	   document.form1.phone.focus();   
	   return false;} 
   
    }   
</script>
</head>
<body>
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：酒店管理　&gt;&gt;　添加酒店信息　</a>
<form action="hoteldetailservlet?op=add" enctype="multipart/form-data" method="post" name="form1" onsubmit="return formCheck33();" >

	<tbody>
	<div class="div1">
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<td ><a>酒店名</a></td>
			<td><input maxlength="15" style="color:#999999;width:300px;height:25px" type="text" name="name"/> <b>请控制在15个字以内 </b> </td>
		</tr>
		<tr>
			<td><a>图片上传</a></td>
			    <td><input  type="file" name="imgUrl"/></td> 
			<%-- <img type="file"  width=80 height=60 border=0 src='<%=request.getContextPath()%>'/> --%>
		</tr>
		<tr>
			<td><a>发布者</a></td>
			<td><a style="color:red;">${sessionScope.loginUser.userName }</a>
			</td>
		</tr>
		<tr>
			<td><a>酒店类型</a></td>
			<td>
				<select name="typeId">
					<c:forEach items="${requestScope.hotelTypeList }" var="hotelType">
						<option value="${hotelType.id }">${hotelType.typeName }</option>	
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><a>价格</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" name="price"/><b>优惠价格  RMB/天 </b></td>
		</tr>
		<tr>
			<td><a>城市</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" name="city"/><b>请输入酒店所在城市名</b></td>
		</tr>
		<tr>
			<td><a>官网</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" name="web"/><b>请输入酒店预订网址</b></td>
		</tr>
		<tr>
			<td><a>地址</a></td>
			<td><textarea class="xheditor" id="taContent" rows="10"  maxlength="300" onchange="this.value=this.value.substring(0, 300)" onkeydown="this.value=this.value.substring(0, 20)" onkeyup="this.value=this.value.substring(0, 20)" rows="10" cols="60" name="address" style=" font-size:15px; color:#000000;"></textarea></td>
		</tr>
		<tr>
			<td><a>联系电话</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" name="phone"/><b>酒店预订电话</b></td>
		</tr>
		<tr>
			<td><a>时间</a></td>
			<td><input style="color:#999999;width:300px;height:25px" type="text" name="publishTime" onClick="WdatePicker()" class="Wdate"/></td>
		</tr>

		<tr>
			<td colspan="2">
				<input type="submit"value="添加酒店"/> <!-- onclick="display_alert()"  -->
			</td>
		</tr>
	</table>
	</div>
</tbody>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加页面</title>
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/addUser.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	var userPwdMsg="${requestScope.userPwdMsg}";
	if(userPwdMsg!=""){
		alert(userPwdMsg);
	}
</script>
<style type="text/css">
body{
	margin: 0px;
	background-image : url('images/register_bg.jpg');
}
#container{
	margin:0px auto;
	width:500px;
	height:600px;
	margin-top:30px;
}
</style>

</head>
<body>
 <div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：用户管理　&gt;&gt;　用户添加　</a> 
<!-- <div id="container"> -->
<form name="myform" action="userdetailservlet?op=addUser" method="post" onsubmit="return checkForm()">
<tbody>
	<table class="right-table" width="50%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th colspan="3">添加用户页面</th>
		</tr>
		<tr>
			<td>用户名</td>
			<td><input value="至少4个字符" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px" type="text" name="userName" id="userName"/></td>
			<td><div id="userNameMsg"></div></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input value="至少6个字符" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px"  name="userPwd" id="userPwd"/></td>
			<td><div id="userPwdMsg"></div></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input value="请重新输入密码" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px"  name="userRePwd" id="userRePwd"/></td>
			<td><div id="userRePwdMsg"></div></td>
		</tr>
		<tr>
			<td>联系方式</td>
			<td><input value="请输入正确的联系方式" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px" type="text" name="phone" id="phone"/></td>
			<td></td>
		</tr>
		<tr>
			<td>权限</td>
			<td>
				<select name="power">
					<option value="3">普通会员</option>
<!-- 					<option value="2">信息发布员</option> -->
					<option value="1">管理员</option>
				</select>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>状态</td>
			<td>
				<input type="radio" name="status" value="1" checked="checked"/>可用
				<input type="radio" name="status" value="0"/>禁用
			</td>
			<td></td>
		</tr>
		<tr>
			<td>添加时间</td>
			<td>
			<!-- onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分ss秒'})" -->
				<input type="text" name="registerTime" onClick="WdatePicker()" class="Wdate"/>
			</td>
			<td></td>
		</tr>
	
		<tr>
			<td colspan="3">
				<input type="submit" value="添加"/>
				<input type="reset" value="重填"/>
			</td>
		</tr>
	</table>
	</tbody>
</form>
</div>
</body>
</html>
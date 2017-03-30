<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>写游记</title>


<meta name="keywords" content="" />
<meta name="description" content="" />

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width" />

<!--[if lt IE 9]>
<script type="text/javascript" src="layout/plugins/html5.js"></script>
<![endif]-->

<link rel="stylesheet" href="layout/style.css" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=PT+Sans:400,700" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Droid+Serif:400,400italic" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="layout/js/jquery.js"></script>

<!-- PrettyPhoto start -->
<link rel="stylesheet" href="layout/plugins/prettyphoto/css/prettyPhoto.css" type="text/css" />
<script type="text/javascript" src="layout/plugins/prettyphoto/jquery.prettyPhoto.js"></script>
<!-- PrettyPhoto end -->

<!-- jQuery tools start -->
<script type="text/javascript" src="layout/plugins/tools/jquery.tools.min.js"></script>
<!-- jQuery tools end -->

<!-- Calendar start -->
<link rel="stylesheet" href="layout/plugins/calendar/calendar.css" type="text/css" />
<script type="text/javascript" src="layout/plugins/calendar/calendar.js"></script>
<!-- Calendar end -->

<!-- ScrollTo start -->
<script type="text/javascript" src="layout/plugins/scrollto/jquery.scroll.to.min.js"></script>
<!-- ScrollTo end -->

<!-- MediaElements start -->
<link rel="stylesheet" href="layout/plugins/video-audio/mediaelementplayer.css" />
<script src="layout/plugins/video-audio/mediaelement-and-player.js"></script>
<!-- MediaElements end -->

<!-- FlexSlider start -->
<link rel="stylesheet" href="layout/plugins/flexslider/flexslider.css" type="text/css" />
<script type="text/javascript" src="layout/plugins/flexslider/jquery.flexslider-min.js"></script>
<!-- FlexSlider end -->

<!-- iButtons start -->
<link rel="stylesheet" href="layout/plugins/ibuttons/css/jquery.ibutton.css" type="text/css" />
<script type="text/javascript" src="layout/plugins/ibuttons/lib/jquery.ibutton.min.js"></script>
<!-- iButtons end -->

<!-- jQuery Form Plugin start -->
<script type="text/javascript" src="layout/plugins/ajaxform/jquery.form.js"></script>
<!-- jQuery Form Plugin end -->

<script type="text/javascript" src="layout/js/main.js"></script>

<script type="text/javascript">
	jQuery(function () {
	});
</script> 
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>
    <script type="text/javascript" src="js/xheditor_lang/zh-cn.js"></script>
<script>
function formCheck33()
   {   
     
     if(document.form1.tag.value==''){   
   alert("请填写关键词！");   
   document.form1.tag.focus();   
   return false;}  

  
   
    }   
</script>
 
<style>
b {font-size:12px;
text-decoration:none;
color:#9D9D9D;
} 
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="wrapper sticky_footer">
    	<!-- HEADER BEGIN -->
        <header>
            <div id="header">
            	<section class="top">
                	<div class="inner">
                    	<div class="fl">
                        	<div class="block_top_menu">
                            	<ul>
                                <li class="current"><a href="toFirstWeb.jsp">首页</a></li>
                                    <li><a href="aboutus.jsp">关于网站</a></li>
                                    <li><a href="connectus.jsp">联系我们</a></li>
                                </ul>
                            </div>
                        </div>
                        
                        <div class="fr">
                        	<div class="block_top_menu">
                            	<ul>
                                
                                    
                                    <!-- 如果用户登录，就只显示用户信息；若没登陆，则显示“登陆/注册”状态 -->
				<%
					if (session.getAttribute("loginUser") == null)//判断用户名是不是为空
					{
				%>
				<li class="current"><a href="log.jsp">登录</a></li>
				<li><a href="reg.jsp">注册</a></li>
				<%
					} else {
				%>
				
							<li><a>用户：${sessionScope.loginUser.userName } </a></li> 
								<li><a href="userdetail_change.jsp">个人中心</a></li>
							<li>　<a  href="logoff.jsp">注销</a></li>
				
				<%
					}
				%>
                                </ul>
                            </div>
                            
                        </div>
                        
                    	<div class="clearboth"></div>
                    </div>
                </section>
                
            	<section class="bottom">
                	<div class="inner">
                    	<div id="logo_top"><a href="toFirstWeb.jsp"><img src="images/logo.png" alt="BusinessNews" title="环球旅游资讯网" /></a></div>
                        
                        <div class="block_today_date">
                        	<div class="num"><p id="num_top" /></div>
                            <div class="other">
                            	<p class="month_year"><span id="month_top"></span>, <span id="year_top"></span></p>
                                <p id="day_top" class="day" />
                            </div>
                        </div>
                        
                        <div class="fr">
                        	 <div class="block_languages">
                            	<div class="text"><p></p></div>
                         
                                <div class="clearboth"></div>
                            </div> 
                        
                        </div>
                        
                        <div class="clearboth"></div>
                    </div>
                </section>
                
                 <section class="section_main_menu">
                	<div class="inner">
                    	<nav class="main_menu">
                        	<ul>
								<li class="big_dropdowns"><a href="toFirstWeb.jsp">首页</a></li>
								<li class="big_dropdown" data-content="technology"><a href="newsdetailservlet?op=toNewsShow">旅游资讯</a></li>
							  	<li class="big_dropdown" data-content="business"><a href="roaddetailservlet?op=listAll">旅游路线</a></li>
							  	<!-- <li class="big_dropdown" data-content="technology"><a href="technology.html">环球美食</a></li> -->
							  	<li class="big_dropdown" data-content="education"><a href="hoteldetailservlet?op=listWeb">酒店优惠</a></li>
							  
							  	<li><a href="blogservlet?op=listAll">蝉游记</a>
                                	
                                    <ul>
                                    	<li><a href="blogservlet?op=listAll">新鲜蝉游记</a></li>
                                    	<li><a href="blogservlet?op=writealone">写游记</a></li> 
                                    	<li><a href="blogservlet?op=list">我的空间</a></li>
                                    </ul>
                                </li>
                              
                                
                                    <li  class="current_page_item"><a href="messagedetailservlet?op=listAll">结伴游</a> 
                                    <ul>
                                    	<li><a href="messagedetailservlet?op=listAll">找结伴</a></li>
                                    	<li><a href="messagedetailservlet?op=writealone">发结伴</a></li> 
                                    	<li><a href="message_about.jsp">关于结伴游</a></li> 
                                    </ul>
                                </li>
		  		  		  		<li class="big_dropdown"><a href="aboutus.jsp">关于我们</a>
                                	
                                    <ul>
                                    	 <li><a href="adv.jsp">广告合作</a></li>
                                    	<li><a href="connectus.jsp">联系我们</a></li>
                                    </ul>
                                    </li>
							  </ul>
						</nav>
                    </div>
                </section>
                
                 
                
            </div>
        </header>
    	<!-- HEADER END -->
        
        <!-- 博客内容排版 -->
        <div id="content" class="right_sidebar">
        	<div class="inner">
            	<div class="general_content">
                	<div class="main_content">
                    	<div class="block_breadcrumbs">
                        	<div class="text"><p>当前位置:</p></div>
                            
                            <ul>
                            	<li><a href="toFirstWeb.jsp">首页</a></li>
                                <li><a href="blogservlet?op=listAll">蝉游记</a></li>
                                <li>写游记</li>
                            </ul>
                        </div>
                        <!-- 分隔线 -->
                        <div class="separator" style="height:30px;"></div>
                        
  <form action="messagedetailservlet?op=add" method="post" name="form1" onsubmit="return formCheck33();" >
 
	<table class="right-table" width="70%"  border="0px" cellpadding="0"  cellspacing="0">
		<tr>
			<td nowrap><a style="color:#227700;text-decoration:none;">关键词</a></td>
			<td><input maxlength="25" style="width:320px;height:20px" type="text" name="tag"/><b>请控制在25个字以内</b></td>
		</tr>
			 
		<tr>
			<td nowrap><a style="color:#227700;text-decoration:none;">作者</a></td>
			<td><b style="color:black;">${sessionScope.loginUser.userName }</b>
			</td>
		</tr>
		 
		<tr nowrap>
			<td><a style="color:#227700;text-decoration:none;">时间</a></td>
			<td><input type="text" name="publishTime" onClick="WdatePicker()" class="Wdate"/></td>
		</tr>
 
		<tr>
			<td></td>
			<td>
				<textarea  class="xheditor" rows="15" cols="69" name="content"></textarea>
				
			</td>
		</tr>
                        
		<tr>
			<td colspan="2">
			<div class="block_buttons">
				 <input style="margin-left:10px; margin-top:20px" class="general_button standart type_3" type="submit" value="发表"/>
			</div>
			</td>
		</tr>
	</table>
 
</form>
                        
                        <div class="separator" style="height:30px;"></div>
                        
                     
                        
                    </div>
                    
                    <div class="sidebar">
                    	
                                 <!--            博客管理模块 -->
                        <div class="block_popular_posts">
                  
                         <div class="block_sidebar_menu">
                        	<h4><b style="color:green;text-decoration:none;">结伴游管理</b></h4>
                            
                            <ul>
                           		
								<li><a href="messagedetail_add.jsp">发表结伴游</a></li>
								<li><a href="messagedetailservlet?op=list">我的结伴游</a></li>
								<li><a href="userdetail_change.jsp">修改密码</a></li>
								<li><a href="logoff.jsp">退出</a></li>
							</ul>
                    <div class="line_2"></div>
                        </div>
                        
            
                        <div class="block_popular_stuff">
                            <div class="content">
                            	
                           	  <div class="media"><img src="images/guang.png" alt="" /></a></div>
                             
                            </div>
                            <div class="clearboth"></div>
                            
                            <div class="line_2"></div>
                        </div>
                        <div class="block_contacts">
                        	<h4><a style="color:#F75000;text-decoration:none;">联系我们</a></h4>
                            
                            <p class="address">公司地址：青岛市崂山区松岭路</p>
                            <p class="phone">电话: 13061258321</p>
                            <p class="email">E-mail: <a href="mailto:#" target="_blank">huanqiulvyou@163.com</a></p>
                            <p class="web">官网: <a href="toFirstWeb.jsp">www.huanqiunews.com</a></p>
                        </div>
    						  <div class="line_2"></div>
							 
                        </div>
                    </div>
                    
                	<div class="clearboth"></div>
                </div>
            </div>
        </div>
    	<!-- CONTENT END -->
        
        <!-- FOOTER BEGIN -->
      <footer>
            <div id="footer">
            	<section class="top">
                	<div class="inner">
                    	<div id="logo_bottom"><a href="index.html"><img src="images/logo_bottom.png" alt="" /></a></div>
                        
                        <div class="block_to_top">
                        	<a href="#">回到顶部</a>
                        </div>
                    </div>
                </section>
                
            	<section class="middle">
                	<div class="inner">
                    	<div class="line_1"></div>
                        
                        <div class="block_footer_widgets">
                        	<div class="column">
                            	<h3>环球旅讯          影响行业的力量</h3>
                                
                                <div class="block_flickr_footer">
                                  
                                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a> 环球旅讯 是全球领先的旅游商业和科技媒体。</a></br> 
                                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a>我们致力于以独立的新闻态度，关注和报道影响旅游业发展的新趋势、新模式和新科技。</a>
                               
                                </div>
                            </div>
                            
                            <div class="column">
                            	<h3>关键词</h3>
                                
                                <div class="block_tags">
                                	<ul>
                                    	<li><a href="topnewsdetailservlet?op=topNewsEveryday">每日头条</a></li>
                                        <li><a href="newsdetailservlet?op=toNewsType&id=42">境内游资讯</a></li>
                                        <li><a href="newsdetailservlet?op=toNewsType&id=43">境外游资讯</a></li>
                                        <li><a href="newsdetailservlet?op=toNewsType&id=51">交通资讯</a></li>
                                        <li><a href="newsdetailservlet?op=toNewsType&id=54">旅行社资讯</a></li>
                                        <li><a href="newsdetailservlet?op=toNewsType&id=52">景区资讯</a></li>
                                        <li><a href="blogservlet?op=listAll">蝉游记</a></li>
                                        <li><a href="hoteldetailservlet?op=listWeb">酒店优惠</a></li>
                                        <li><a href="roaddetailservlet?op=listAll">旅游路线</a></li>
                                <li><a	href="newsdetailservlet?op=toNewsShow">资讯首页</a></li>
                                      
                                    </ul>
                                </div>
                            </div>
                            
                            <div class="column">
                            	<h3>友情链接</h3>
                                
                                <div class="block_most_read_news">
                                	<div class="article">
                                    	
                                        
                                        <div class="text">
                                        	<p class="title"><a href="#">百度搜索</a>&nbsp&nbsp&nbsp<a href="">谷歌</a>&nbsp&nbsp&nbsp<a href="">网易</a></p>
                                        	<p class="title"><a href="">新浪</a>&nbsp&nbsp&nbsp<a href="">人人网</a>&nbsp&nbsp&nbsp<a href="">58同城</a></p>
                                        	<p class="title"><a href="">搜狗视频</a>&nbsp&nbsp&nbsp<a href="">腾讯</a>&nbsp&nbsp&nbsp<a href="">赶集网</a></p>
                                        	<p class="title"><a href="">PPTV</a>&nbsp&nbsp&nbsp<a href="">乐视TV</a>&nbsp&nbsp&nbsp<a href="">途牛</a></p>
                                        	<p class="title"><a href="">爱奇艺</a>&nbsp&nbsp&nbsp<a href="">电影天堂</a>&nbsp&nbsp&nbsp<a href="">凤凰网</a></p>
                                        	<p class="title"><a href="">天猫商城</a>&nbsp&nbsp&nbsp<a href="">CCTV</a>&nbsp&nbsp&nbsp<a href="">凡客</a></p>
                                          
                                        </div>
                                    </div>
                                 
                                </div>
                            </div>
                            
                            <div class="column">
                            	<h3>联系我们</h3>
                                
                                <div class="block_contact_footer">
                                	<form action="#" />
                                    	<p class="text">我们的官方邮箱是huanqiulvxun@163.com感谢您的建议！</p>
                                        
                                        <div class="clearboth"></div>
                                    </form>
                                </div>
                            </div>
                            
                            <div class="clearboth"></div>
                        </div>
                    </div>
                </section>
                
            	<section class="bottom">
                	<div class="inner">
                    	<div class="line_1"></div>
                        
                        <div class="fr">
                        	<div class="block_menu_footer">
                            	<ul>
                                	<li><a href="newsdetailservlet?op=toNewsShow">旅游资讯</a></li>
                                    <li><a href="roaddetailservlet?op=listAll">旅游路线</a></li>
                                    <li><a href="hoteldetailservlet?op=listWeb">酒店优惠</a></li>
                                    <li><a href="blogservlet?op=listAll">蝉游记</a></li>
                                </ul>
                            </div>
                            
                           
                        </div>
                        
                        <div class="block_copyrights"><p>&copy;2014-2020 环球旅游资讯网版权所有鲁ICP备06070077号　|　业务经营许可证：鲁B2-20110389</p></div>
                    </div>
                </section>
            </div>
        </footer>
        <!-- FOOTER END -->
    </div>
    
    <!-- POPUP BEGIN -->
    <div id="overlay"></div>

    <!-- POPUP END -->
</body>

</html>
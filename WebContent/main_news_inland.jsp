<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../base.jsp"%>

<!DOCTYPE html>
<html>

<head>
<title>境内游资讯</title>

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

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

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
                       <!--      
                            <div class="block_search_top">
                            	<form action="#" />
                                	<div class="field"><input type="text" class="w_def_text" title="请输入关键字" /></div>
                                    <input type="submit" class="button" value="Search" />
                                    
                                    <div class="clearboth"></div>
                                </form>
                            </div> -->
                        </div>
                        
                        <div class="clearboth"></div>
                    </div>
                </section>
                
                 <section class="section_main_menu">
                	<div class="inner">
                    	<nav class="main_menu">
                        		<ul>
								<li class="big_dropdown"><a href="toFirstWeb.jsp">首页</a></li>
								<li class="current_page_item" data-content="technology"><a href="newsdetailservlet?op=toNewsShow">旅游资讯</a></li>
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
                                <li><a href="messagedetailservlet?op=listAll">结伴游</a> 
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
                   
                <section class="section_big_dropdown">
                	<div class="inner">
                  	<div class="block_big_dropdown" data-menu="business">
                        	<div class="content">
                            	<div class="image">
                                	<a href="roaddetailservlet?op=listAll" class="pic"><img src="images/road.jpg" alt="" /></a>
                                    <p><a href="roaddetailservlet?op=listAll">线路推荐</a></p>
                                </div>
                                <div class="line"></div>
                          		<div class="image">
                                	<a href="roaddetailservlet?op=listSearch" class="pic"><img src="images/pic_big_drop_6.jpg" alt="" /></a>
                                    <p><a href="roaddetailservlet?op=listSearch">路线查询</a></p>
                                </div> 
                                <div class="line"></div>
                                
                                <div class="popular_posts">
                                	<div class="title"><p>旅游首选</p></div>
                               <ul>

                                    <c:forEach items="${requestScope.roadDetailList }"  var="roadDetail" begin="1" end="4" varStatus="status">
                                    	<li><a href="roaddetailservlet?op=toRoadDetail&id=${roadDetail.id }" target="_blank"><span>${roadDetail.publishTime}</span>${roadDetail.roadName}</a></li>
                                    	</c:forEach>

                                    </ul>
                                </div>
                                <div class="line"></div>
                                
                                <div class="more">
                                	<div class="title"><p>线路类型</p></div>
                                    <ul>
                                    	<!-- <li><a href="#">Business</a></li>
                                        <li><a href="#">Money</a></li>
                                        <li><a href="#">Isnvestor Programs</a></li> -->
                                        <c:forEach items="${requestScope.roadTypeList }" begin="1" end="4" var="road">
                                        	<li><a href="roaddetailservlet?op=toRoadType&id=${road.id }">${road.typeName} </a></li>
                                        </c:forEach>
                                         <li><a href="roaddetailservlet?op=listAll" style="color:red;">更多>></a></li> 
                                    </ul>
                                    
                                   
                                </div>
                             
                                
                                <div class="clearboth"></div>
                            </div>
                        </div>
                                  
                  
                        
                    	<div class="block_big_dropdown" data-menu="education">
                        	<div class="content">
                            	<div class="image">
                                	<a href="hoteldetailservlet?op=listWeb" class="pic"><img src="images/hotel.png" alt="" /></a>
                                    <p><a href="hoteldetailservlet?op=listWeb">酒店优惠</a></p>
                                </div>
                                <div class="line"></div>
                                <div class="image">
                                	<a href="hoteldetailservlet?op=listSearch" class="pic"><img src="images/pic_big_drop_1.jpg" alt="" /></a>
                                    <p><a href="hoteldetailservlet?op=listSearch">酒店查询</a></p>
                                </div>
                                <div class="line"></div>
                                
                                <div class="popular_posts">
                                	<div class="title"><p>最新发布</p></div>
                                    <ul>
                                    	 <c:forEach items="${requestScope.hotelDetailList }"  var="hotelDetail" begin="1" end="4" varStatus="status">
                                    	<li>
                                    	<a href="hoteldetailservlet?op=toHotelDetailWeb&id=${hotelDetail.id }" target="_blank"><span>${hotelDetail.publishTime}</span>${hotelDetail.name}</a>
                                    	</li>
                                    	</c:forEach>
                                    </ul>
                                </div>
                                <div class="line"></div>
                                
                                <div class="more">
                                	<div class="title"><p>酒店星级入口</p></div>
                                    <ul>
                                      <c:forEach items="${requestScope.hotelTypeList }" begin="0" end="3" var="hotel">                                     	
                                    	<li>	
                                    			<a href="hoteldetailservlet?op=toHotelType&id=${hotel.id }">
                                    			${hotel.typeName}
                                    			</a>
                                    	</li>
                                    	</c:forEach>
                                    	 <li><a href="hoteldetailservlet?op=listWeb" style="color:red;">更多>></a></li>
                                    	
                                    </ul>
                                </div>
                                
                                <div class="clearboth"></div>
                            </div>
                        </div>
                    </div>
              	</section>
                
            <!--                 工具栏资讯类型展示代码 -->
                <section class="section_secondary_menu">
                	<div class="inner">
                    	<nav class="secondary_menu">
                        	<ul>
									<li><a href="topnewsdetailservlet?op=topNewsEveryday">每日头条</a></li>
                        	
                        	<c:forEach items="${requestScope.newsTypeList }" begin="0" end="9" var="nn">  <!-- begin="1" end="5"     -->                               	
                                    	<li>	
                                    			<a href="newsdetailservlet?op=toNewsType&id=${nn.id }">
                                    			${nn.typeName}
                                    			</a>
                                    	</li>
                                    	</c:forEach> 
                          	</ul>
                        </nav>
                        
                        <div class="block_clock">
                        	<p>时间: <span id="time"></span></p>
                        </div>
                    </div>
                </section>
            </div>
        </header>
    	<!-- HEADER END -->
        
        <!-- CONTENT BEGIN -->
        <div id="content" class="right_sidebar">
        	<div class="inner">
            	<div class="general_content">
                    <div class="main_content">
                    	<div class="block_breadcrumbs">
                        	<div class="text"><p>当前位置:</p></div>
                            
                            <ul>
                            	<li><a href="toFirstWeb.jsp">首页</a></li>
                               <li>旅游资讯</li>
                              
                            </ul>
                        </div>
                        <div class="separator" style="height:30px;"></div>
                        
                        <h2><a style="color:#F24024;text-decoration:none;">汇聚全球最新旅讯</a></h2>
                        
                        <p class="general_subtitle">环球旅讯，影响行业的力量。</p>
          
                        <div class="line_2" style="margin:21px 0px 21px;"></div> 
                        
                        
                        <div class="block_topic_news">
                        <c:forEach items="${requestScope.newsDetailList }" var="inNews">
                        	<article class="block_topic_post">
                            	<p class="title"><a href="newsdetailservlet?op=toNewsDetail&id=${inNews.id }" target="_blank">${inNews.title }</a></p>
                                <p class="text">${inNews.publishTime }</p>
                           </article>
                   </c:forEach>
                        </div>
                        
                        <div class="line_2" style="margin:25px 0px 25px;"></div>
                        
                        <div class="block_pager">
                        	<!-- <a href="#" class="prev">Previous</a>
                            <a href="#" class="next">Next</a>
                            
                            <div class="pages">
                            	<ul>
                                	<li class="current"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">6</a></li>
                                </ul>
                            </div>
                            
                            <div class="clearboth"></div> -->
                        </div>
                        
                    </div>
                    
                    
                    
                    <div class="sidebar">
                      <div class="separator" style="height:31px;"></div>
                        
                        <div class="block_popular_posts">
                        	<h4><a style="color:#F24024;text-decoration:none;">资讯TOP</a></h4>
                             
                	 <c:forEach items="${requestScope.topNewsDetailList }" begin="0" end="3" var="topNews">
                        	<div class="article">
								<div class="pic">
									<a href="topnewsdetailservlet?op=toTopNewsDetailWeb&id=${topNews.id }" class="w_hover">
										 <img src="http://localhost:8080/travelnews/${topNews.imgUrl}" height="60" width="60">
										<span></span>
									</a>
								</div>
                                        
								<div class="text">
									<p class="title"><a href="topnewsdetailservlet?op=toTopNewsDetailWeb&id=${topNews.id }">${topNews.title }</a></p>
									<div class="date"><p>${topNews.publishTime }</p></div>
                                   <!--  <div class="icons">
                                    	<ul>
                                        	<li><a href="#" class="views">41</a></li>
                                            <li><a href="#" class="comments">22</a></li>
                                        </ul>
                                    </div> -->
								</div>
							</div>
							<div class="line_3"></div>
                         </c:forEach>   
                           
                            
                        </div>
                        
                        <div class="separator" style="height:31px;"></div>
                               <div class="block_calendar">
                            <div class="calendar" id="calendar_sidebar">
                            </div>
                            
                             <script type="text/javascript">
								var today = new Date();
								var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
								$('#calendar_sidebar').DatePicker({
									flat : true,
									date : date,
									calendars : 1,
									starts : 1,
									locale : {
										days : ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
										daysShort : ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
										daysMin : ['日', '一', '二', '三', '四', '五', '六', '七'],
										months : ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十月', '十二月'],
										monthsShort : ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
										weekMin : 'wk'
									}
								});
							</script>
                            <div class="line_2"></div>
                        </div>
                        
                        <div class="separator" style="height:31px;"></div>
                       <div class="block_popular_stuff">
                        	<h4>广告招商</h4>
                            
                            <div class="content">
                            	<a class="view_all">联系我们:0538-6666666</a>
                            	<div class="media"><img src="images/zhao.jpg" width="80" height="110"/></a></div>
                              
                            </div>
                            <div class="clearboth"></div>
                            
                        </div>
                        
                        <div class="separator" style="height:31px;"></div>
                      
                         <div class="block_contacts">
                        	<h4><a style="color:#F75000;text-decoration:none;">联系我们</a></h4>
                            
                            <p class="address">公司地址：青岛市崂山区松岭路</p>
                            <p class="phone">电话: 13061258321</p>
                            <p class="email">E-mail: <a href="mailto:#" target="_blank">huanqiulvyou@163.com</a></p>
                            <p class="web">官网: <a href="toFirstWeb.jsp">www.huanqiunews.com</a></p>
                        </div>
    						  <div class="line_2"></div>
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
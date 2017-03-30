
                            
                            
                            <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>


<!DOCTYPE html>
<html>

<head>
<title>环球旅讯</title>

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

<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>
    <script type="text/javascript" src="js/xheditor_lang/zh-cn.js"></script>

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
				<!-- <li class="current"><a href="log.jsp" class="open_popup">登录</a></li> -->
				<li><a href="log.jsp" >登录</a></li>
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
                    	<div id="logo_top"><a href="index.html"><img src="images/logo.png" alt="BusinessNews" title="BusinessNews" /></a></div>
                        
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
                            
                            <!-- <div class="block_search_top">
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
                        
                        <article class="block_single_news">
                        	<!-- 图片 -->
                        	<!-- <div class="f_pic"><a href="#"><img src="images/pic_news_post_1.jpg" alt="" /></a></div> -->
                        
                          <p class="title"><a style="color:#227700;text-decoration:none;">${requestScope.newsDetail.title }</a></p>
                        
                           <!--  <p class="subtitle">Many variations of passages of available, but the majority have suffered alteration in some form. Humour, or randomised words which don't look even slightly believable.</p> -->
                            
                            <div class="info">
                                <div class="date"><p>${requestScope.newsDetail.publishTime }</p></div>
                                <div class="author"><p>作者: ${requestScope.newsDetail.author }</p></div>
                                    
                            	<div class="r_part">
                                	<div class="category"><p>${requestScope.newsDetail.typeName }</p></div>
                                    
                                </div>
                            </div>
                            
                            <div class="content">
                            	<p>${requestScope.newsDetail.content }</p>
                               <!--  <blockquote class="full">Going to use a passage you need to be sure there isn't anything embarrassing hidden in the middle of text. established fact that a reader will be distracted by the readable content.</blockquote> -->
                               
                            </div>
                        </article>
                        
                        <div class="separator" style="height:4px;"></div>
                        
                        <div class="block_post_tags">
                        	<p>关键词: ${requestScope.newsDetail.typeName }</p>
                        </div>
                  
                        
                        <div class="line_2" style="margin:5px 0px 30px;"></div>
                        
                      <!--   
                         <div class="line_2" style="margin:5px 0px 28px;"></div>
                        
                        <div class="block_comments">
                        	<h2>4 Comments</h2>
                            
                            <div class="comment">
                            	<div class="userpic"><a href="#"><img src="images/ava_default_1.jpg" alt="" /></a></div>
                                <div class="content">
                                	<p class="name"><a href="#">John Doe</a></p>
                                    <p class="info"><span class="date">Febr 16, 2012 at 4:43 pm</span><a href="#" class="control">Reply</a>p>
                                    <p class="text">Established fact that a reader will be distracted by the readable content of a page. When looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using.</p>
                                </div>
                                <div class="clearboth"></div>
                                <div class="line_3"></div>
                            </div> -->
                            
                            
                          <c:if test="${requestScope.commentList==null }">
												暂无评论
											</c:if>
											
                        <div class="block_comments_type_2">
                        	<h3><a style="color:#F24024;text-decoration:none;">网友评论</a></h3>
                           
										<c:if test="${requestScope.commentList!=null }">
											
												<c:forEach items="${requestScope.commentList}" var="comment">
												 <c:if  test="${sessionScope.loginUser.power==null }"><!-- 判断是不是会员：==3是会员 -->
														   <c:if test="${comment.status==0 }"><!-- 权限是0，表示允许发言 -->
				 											  	
																<div class="comment">
																<div class="userpic"><a href="#"><img src="images/ava_default_1.jpg" alt="" /></a></div>
																<div class="comment_wrap">
																	 <div class="name"><p>用户ID：${comment.userId }</p> </div>
																	 <div class="content"><p>${comment.content }</p></div>
																	
																	 <div class="date"><p>评论时间：${comment.writeTime }</p></div>
																</div>
				 											   <div class="clearboth"></div>
                             									   <div class="line_3"></div>
                              								  </div> 
				  											 </c:if>
			  								   </c:if>  
												
												
													 <c:if  test="${sessionScope.loginUser.power==3 }"><!-- 判断是不是会员：==3是会员 -->
														   <c:if test="${comment.status==0 }"><!-- 权限是0，表示允许发言 -->
				 											  	
																<div class="comment">
																<div class="userpic"><a href="#"><img src="images/ava_default_1.jpg" alt="" /></a></div>
																<div class="comment_wrap">
																	 <div class="name"><p>用户ID：${comment.userId }</p> </div>
																	
																	 <div class="content"><p>${comment.content }</p></div>
																	
																	 <div class="date"><p>评论时间：${comment.writeTime }</p></div>
																</div>
				 											   <div class="clearboth"></div>
                             									   <div class="line_3"></div>
                              								  </div> 
																 
				  											 </c:if>
			  										   	 </c:if>  
														   <c:if  test="${sessionScope.loginUser.power==1 }"><!-- 如果身份==1，即管理员 -->
			  												  <div class="comment">
																<div class="userpic"><a href="#"><img src="images/ava_default_1.jpg" alt="" /></a></div>
																<div class="comment_wrap">
																	 <div class="name"><p>用户ID：${comment.userId }</p> </div>
																	 <div class="content"><p>${comment.content }</p></div>
																	
																	 <div class="date"><p>评论时间：${comment.writeTime }</p>
																	 <p><a href="commentservlet?op=delete&id=${comment.id }&newsId=${requestScope.newsDetail.id }">删除</a></p>
																	 </div>
																</div>
				 											   <div class="clearboth"></div>
                             									   <div class="line_3"></div>
                              								  </div> 
			  												  
			  												  
																	
			  											</c:if>
				
												</c:forEach>
											</table> 
										</c:if>	
											
											
										</p>
                              
                                <div class="clearboth"></div>
                                <div class="line_3"></div>
                            </div>
                              
                            
                            
                        
                        <div class="separator" style="height:30px;"></div>
                        
                        <div class="block_leave_reply">
                        	<h3>评论</h3>
                        	<p class="text"><a href="termofuser.jsp">请遵守《用户条款及隐私协议》</a></p>
                            
   <form method="post" action="commentservlet?op=add" class="w_validation">

  	 <table bord="1">
			<tr>
				<td>姓名：<input type="text" value="${sessionScope.loginUser.userName }"/>密码：<input type="password" value="********"/></td>
			</tr>
			<tr>
				<td><textarea class="xheditor" rows="10" cols="70" name="content"></textarea>
				<input type="hidden" value="${requestScope.newsDetail.id }" name="newsId"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" class="general_button" value="提交" /> </td>
			</tr>
		</table>

   </form>
 </div>
</div>
                    
                    <div class="sidebar">
                    
                        
                      <div class="separator" style="height:31px;"></div>
                             <div class="block_popular_posts">
                        	<h4><a style="color:#F75000;text-decoration:none;">头条精选</a></h4>
                        
                            <c:forEach items="${requestScope.topNewsDetailList }" begin="0" end="3" var="topNews">
                        	<div class="article">
								<div class="pic">
									<a class="w_hover">
										<img src="http://localhost:8080/travelnews/${topNews.imgUrl}" height="60" width="60"/>
										<span></span>
									</a>
								</div>
                                        
								<div class="text">
									<p class="title"><a href="topnewsdetailservlet?op=toTopNewsDetailWeb&id=${topNews.id }">${topNews.title }</a></p>
									<div class="date"><p>${topNews.publishTime }</p></div>
                                    
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
                        	<h4>酒店优惠</h4>
                             <c:forEach items="${requestScope.hotelDetailList }"  var="hotelDetail" varStatus="status" begin="0" end="1" >
                            <div class="content">
                            	<a href="hoteldetailservlet?op=toHotelDetailWeb&id=${hotelDetail.id }" class="view_all">查看详情</a>
                            	<div class="media"><a href="hoteldetailservlet?op=toHotelDetailWeb&id=${hotelDetail.id }"  class="general_pic_hover scale"><img src="http://localhost:8080/travelnews/${hotelDetail.imgUrl}" height="100%" width="100%"></a></div>
                                <p><a href="hoteldetailservlet?op=toHotelDetailWeb&id=${hotelDetail.id }">地址：${hotelDetail.address }</a> </p>
                                <p class="date">${hotelDetail.publishTime }</p>
                            </div>
                            
                            <div class="line_2"></div>
                            </c:forEach>
                            <!-- <div class="info">
                            	<ul>
                                	<li class="comments"><a href="#">100</a></li>
                                    <li class="views"><a href="#">134</a></li>
                                </ul>
                            </div> -->
                            
                            <div class="clearboth"></div>
                            
                            <div class="line_2"></div>
                        </div>
                        
                      	<div class="separator" style="height:31px;"></div>
                       
                        <div class="block_popular_stuff">
                            <div class="content">
                            	
                           	  <div class="media"><img src="images/guang.png" alt="" /></a></div>
                             
                            </div>
                            <div class="clearboth"></div>
                            
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
    </div>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>联系我们 </title>

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
				<!-- <li class="current"><a href="log.jsp" class="open_popup">登录</a></li> -->
				<li class="current"><a href="log.jsp" >登录</a></li>
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
								<li class="big_dropdown"><a href="toFirstWeb.jsp">首页</a></li>
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
                                   <li><a href="messagedetailservlet?op=listAll">结伴游</a> 
                                    <ul>
                                    	<li><a href="messagedetailservlet?op=listAll">找结伴</a></li>
                                    	<li><a href="messagedetailservlet?op=writealone">发结伴</a></li> 
                                    	<li><a href="message_about.jsp">关于结伴游</a></li> 
                                    </ul>
                                </li>
		  		  		  		<li class="current_page_item"><a href="aboutus.jsp">关于我们</a>
                                	
                                    <ul>
                                    	 <li><a href="adv.jsp">广告合作</a></li>
                                    	<li><a href="connectus.jsp">联系我们</a></li>
                                    </ul>
                                    </li>
							  </ul>						</nav>
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
                            	<li><a href="toFirstWeb">首页</a></li>
                                <li>联系我们</li>
                            </ul>
                        </div>
                        <div class="separator" style="height:30px;"></div>
                        
                        <h2>环球资讯网用户服务条款		</h2>
                        
                        <p class="general_subtitle">环球旅讯 是全球领先的旅游商业和科技媒体。 我们致力于以独立的新闻态度，关注和报道影响旅游业发展的新趋势、新模式和新科技。</p>
                        
                        <div class="line_4" style="margin:0px 0px 18px;"></div>
                        
                        <div class="separator" style="height:11px;"></div>
                        
                      <p><a style="color:#F75000;text-decoration:none;">环球资讯网用户服务条款 ：</a></br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</br>
 一、环球资讯网用户服务条款 </br>
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp1. 环球网服务条款的确认和接受 环球网的各项网络服务的所有权和运营权归环球资讯网在线文化传播有限公司所有。环球网依照本服务条款及其不时发布的操作规则提供网络服务，
 此外，用户使用环球网各项分类服务时，用户应当仔细阅读、理解、自愿同意接受本服务条款的全部内容并遵守与该项服务相关的规则与要点。用户必须完全同意所有服务条款并完成注册程序，才能成为环球网的正式用户。</br>
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 2. 服务说明 环球网仅为用户提供网络服务。用户必须自行配备上网的所需设备（如个人电脑、手机、调制解调器或其他必备上网装置）及所需费用（如上网所支付的与此服务有关的电话费用、 网络费用、手机费用等）。 基于环球网所提供的服务的重要性，用户应同意： （1）提供详尽、准确的个人资料。 （2）不断更新注册资料，符合及时、详尽、准确的要求。</br> 
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp3. 网上注册 用户在申请使用环球网网络服务时，必须向环球网提供准确的个人资料，如个人资料有任何变动，必须及时更新。用户一旦注册成功，成为环球网的合法用户，将得到一个密码和用户名。每个用户应当对以其用户名进行的所有活动和事件承担全部责任。 用户在此同意接受环球网通过电子邮件或其他方式向用户发送宣传推广或者其他相关商业信息。 在不对外披露单个用户隐私资料的前提下，环球网有权对整个用户数据库进行分析并对用户数据库进行商业上的利用。</br>
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 4. 用户名、用户密码和安全性 用户将对用户名和密码安全承担全部责任。用户可随时根据提示改变用户的密码。用户不应将其账号、密码转让或出借予他人使用。如用户发现其账号遭他人非法使用或存在安全漏洞的情况，应立即通知环球网。因黑客行为或用户的保管疏忽导致账号、密码遭他人非法使用，环球网不承担任何责任。 如用户注册的免费网络服务的账号在任何连续180日内未实际使用，或者用户注册的收费网络服务的账号在其订购的收费网络服务的服务期满之后连续180日内未实际使用，则环球网有权删除该账号并停止为该用户提供相关的网络服务。</br>
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 5. 用户隐私制度（详细请见《环球网隐私权保护政策》）</br>
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 6. 对用户发布信息的的管理 用户在本环球网发布信息时，必须遵守国家有关法律规定，并承担一切因自己发布信息不当导致的民事、行政或刑事法律责任。用户在在环球网所发布的信息，不得含有以下内容： (1)违反宪法确定的基本原则的； (2)危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的； (3)损害国家荣誉和利益，攻击党和政府的； (4)煽动民族仇恨、民族歧视，破坏民族团结的； (5)破坏国家、地区间友好关系的； (6)违背中华民族传统美德、社会公德、论理道德、以及社会主义精神文明的； (7)破坏国家宗教政策，宣扬邪教和封建迷信的； (8)散布谣言或不实消息，扰乱社会秩序 ，破坏社会稳定的； (9)煽动、组织、教唆恐怖活动、非法集会、结社、游行、示威、聚众扰乱社会秩序的； (10)散布淫秽、色情、赌博、暴力、恐怖或者教唆犯罪的； (11)侮辱或诽谤他人，侵害他人合法权益的； (12)侵犯他人肖像权、姓名权、名誉权、隐私权或其他人身权利的； (13)使用漫骂、辱骂、中伤、恐吓、诅咒等不文明语言的； (14)以非法民间组织名义活动的； (15)含有法律、行政法规禁止的其他内容的 如果用户在环球网发布信息时，不能履行和遵守协议中的规定，为维护本网站的形象、信誉、安全、本网站有权删除用户发布的信息。并对违反协议的用户做出封闭ID，暂时、永久禁止在本网站发布信息的处理。同时保留依法追究当事人法律责任的权利。 用户需独立对自己在网上的行为承担法律责任。若用户的行为不符合上述服务条款，环球网有权做出独立判断立即取消用户服务账号，用户若在环球网上散布和传播反动、色情或其他违反国家法律的信息，环球网的系统记录有可能作为用户违反法律的证据。 环球网不对用户所发布信息的删除或储存失败承担任何责任。环球网有权判定用户的行为是否符合中国法律法规的规定以及环球网服务条款的要求，如果用户违背了中国法律法规的规定或服务条款的规定，环球网有中断对其提供服务的权利。</br>
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 7. 网络服务内容的所有权 环球网定义的网络服务内容包括：环球网提供的文字、软件、声音、图片、录象、图表、广告中的全部内容、电子邮件的全部内容以及环球网为用户提供的其他信息。所有这些内容受版权、商标和/或其它财产所有权法律的保护。所以，用户只能在环球网和相关权利人授权下才能使用这些内容，而不能擅自复制、发布、转载、播放、改编、汇编或以其他方式使用这些内容或将该等内容用于其他任何商业目的。
                        <p>如果您对本资讯网有任何问题或者建议，请发邮件至 <a href="mailto:webvisionss@gmail.com" class="lnk_red" target="_blank">travelnews@163.com</a>.</p>
                        
                        <div class="line_2" style="margin:5px 0px 0px;"></div>
                        
                    </div>
                    
                    <div class="sidebar">
                    	
              
                        <div class="separator" style="height:31px;"></div>
                         <div class="block_contacts">
                        	<h4><a style="color:#F75000;text-decoration:none;">联系我们</a></h4>
                            
                            <p class="address">公司地址：青岛市崂山区松岭路</p>
                            <p class="phone">电话: 13061258321</p>
                            <p class="email">E-mail: <a href="mailto:#" target="_blank">huanqiulvyou@163.com</a></p>
                            <p class="web">官网: <a href="#">www.huanqiunews.com</a></p>
                        </div>
     					 <div class="line_2"></div>
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
                            
                           
                        
                        <div class="block_popular_stuff">
            
                            <div class="content">
                            	
                           	  <div class="media"><img src="images/guang.png" alt="" /></a></div>
                             
                            </div>
                            <div class="clearboth"></div>
                            
                            <div class="line_2"></div>
                        </div>
                        </div>
                        
                    </div>
                    
                	<div class="clearboth"></div>
                </div>
            </div>
        </div>
    	<!-- CONTENT END -->
        
        <!-- FOOTER BEGIN -->
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
    
   
    <!-- POPUP END -->
</body>

</html>
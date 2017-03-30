package com.syf.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syf.entity.Blog;
import com.syf.entity.Comment;
import com.syf.entity.HotelDetail;
import com.syf.entity.HotelType;
import com.syf.entity.NewsDetail;
import com.syf.entity.NewsType;
import com.syf.entity.RoadDetail;
import com.syf.entity.RoadType;
import com.syf.entity.TopNewsDetail;
import com.syf.entity.UserDetail;
import com.syf.service.BlogService;
import com.syf.service.CommentService;
import com.syf.service.HotelDetailService;
import com.syf.service.HotelTypeService;
import com.syf.service.NewsDetailService;
import com.syf.service.NewsTypeService;
import com.syf.service.RoadDetailService;
import com.syf.service.RoadTypeService;
import com.syf.service.TopNewsDetailService;
import com.syf.util.DateUtil;
import com.syf.util.PageBean;

@WebServlet("/NewsDetailServlet")
public class NewsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewsDetailServlet() {
		super();

	}

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("op");
		if ("toAdd".equals(op)) {
			toAdd(request, response);
		} else if ("add".equals(op)) {
			addNewsDetail(request, response);
		} else if ("list".equals(op)) {
			list(request, response);
		} else if ("toNewsDetail".equals(op)) {
			toNewsDetail(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("batchDelete".equals(op)) {
			batchDelete(request, response);
		} else if ("toEdit".equals(op)) {
			toEdit(request, response);
		} else if ("update".equals(op)) {
			update(request, response);
		} else if ("search".equals(op)) {
			search(request, response);
		} else if ("toFirstWeb".equals(op)) {
			toFirstWeb(request, response);
		} else if ("toNewsType".equals(op)) {
			toNewsType(request, response);// 后台根据新闻类型进行查询
		} else if ("toNewsShow".equals(op)) {
			toNewsShow(request, response);
		} else if ("searchweb".equals(op)) {
			searchweb(request, response); // 前端新闻展示页面的搜索功能
		}
	}

	// 新闻展示news_show.jsp页面
	private void toNewsShow(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		NewsDetailService newsDetailService = new NewsDetailService();

		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		// 获取境内游资讯
		List<NewsDetail> inland = newsDetailService.findByTypeId(42);
		// 获取境内游资讯
		List<NewsDetail> foreign = newsDetailService.findByTypeId(43);
		// 获取交通资讯
		List<NewsDetail> traffic = newsDetailService.findByTypeId(51);
		// 获取景区资讯
		List<NewsDetail> jingqu = newsDetailService.findByTypeId(52);
		// 获取旅行社资讯
		List<NewsDetail> lvxingshe = newsDetailService.findByTypeId(54);

		// 热点资讯展示
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		List<TopNewsDetail> topNewsDetailList = topNewsDetailService.findAll();
		request.setAttribute("topNewsDetailList", topNewsDetailList);

		HotelTypeService hotelTypeService = new HotelTypeService();
		List<HotelType> hotelTypeList = hotelTypeService.findAll();
		request.setAttribute("hotelTypeList", hotelTypeList);

		HotelDetailService hotelDetailService = new HotelDetailService();// 前端酒店信息展示
		List<HotelDetail> hotelDetailList = hotelDetailService.findAll();
		request.setAttribute("hotelDetailList", hotelDetailList);

		RoadTypeService roadTypeService = new RoadTypeService();
		List<RoadType> roadTypeList = roadTypeService.findAll();
		request.setAttribute("roadTypeList", roadTypeList);
		// request.getRequestDispatcher("listRoadType.jsp").forward(request,
		// response);

		RoadDetailService roadDetailService = new RoadDetailService();// 前端功能栏旅游路线展示
		List<RoadDetail> roadDetailList = roadDetailService.findAll();
		// for (int i = 0; i < roadDetailList.size(); i++) {
		// System.out.println(roadDetailList.get(0).getTypeName());
		//
		// }

		// RoadTypeService roadTypeService = new RoadTypeService();
		// List<RoadType> roadTypeList = roadTypeService.findAll();
		// request.setAttribute("roadTypeList", roadTypeList);
		request.setAttribute("roadDetailList", roadDetailList);

		String id = request.getParameter("id");
		BlogService blogService = new BlogService();
		Blog blog = blogService.findById(id);

		List<Blog> blogList = blogService.findAll();

		request.setAttribute("blogList", blogList);
		request.setAttribute("blog", blog);

		request.setAttribute("inland", inland);
		request.setAttribute("foreign", foreign);
		request.setAttribute("traffic", traffic);
		request.setAttribute("jingqu", jingqu);
		request.setAttribute("lvxingshe", lvxingshe);
		request.getRequestDispatcher("/news_show.jsp").forward(request,
				response);

	}

	// 根据新闻类型进行查询
	private void toNewsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String typeIdStr = request.getParameter("id");
		int typeId = Integer.parseInt(typeIdStr);
		// NewsDetail newsDetail = new NewsDetail(typeId);
		NewsDetailService newsDetailService = new NewsDetailService();
		// List<NewsDetail> newsDetailList = newsDetailService
		// .findByCondition(newsDetail);
		List<NewsDetail> newsDetailList = newsDetailService
				.findByTypeId(typeId);

		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		// System.out.print(typeIdStr);
		// System.out.print(newsDetailList);
		request.setAttribute("newsDetailList", newsDetailList);

		String id = request.getParameter("id");
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		TopNewsDetail topNewsDetail = topNewsDetailService.findById(id);
		request.setAttribute("topNewsDetail", topNewsDetail);
		List<TopNewsDetail> topNewsDetailList = topNewsDetailService.findAll();
		request.setAttribute("topNewsDetailList", topNewsDetailList);

		HotelTypeService hotelTypeService = new HotelTypeService();
		List<HotelType> hotelTypeList = hotelTypeService.findAll();
		request.setAttribute("hotelTypeList", hotelTypeList);

		HotelDetailService hotelDetailService = new HotelDetailService();// 前端酒店信息展示
		List<HotelDetail> hotelDetailList = hotelDetailService.findAll();
		request.setAttribute("hotelDetailList", hotelDetailList);

		RoadTypeService roadTypeService = new RoadTypeService();
		List<RoadType> roadTypeList = roadTypeService.findAll();
		request.setAttribute("roadTypeList", roadTypeList);

		RoadDetailService roadDetailService = new RoadDetailService();// 前端功能栏旅游路线展示
		List<RoadDetail> roadDetailList = roadDetailService.findAll();
		request.setAttribute("roadDetailList", roadDetailList);

		request.getRequestDispatcher("main_news_inland.jsp").forward(request,
				response);
	}

	// 新闻首页热点展示
	private void toFirstWeb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		NewsDetailService newsDetailService = new NewsDetailService();

		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		// 获取境内游资讯
		List<NewsDetail> inland = newsDetailService.findByTypeId(42);
		// 获取境内游资讯
		List<NewsDetail> foreign = newsDetailService.findByTypeId(43);
		// 获取交通资讯
		List<NewsDetail> traffic = newsDetailService.findByTypeId(51);
		// 获取景区资讯
		List<NewsDetail> jingqu = newsDetailService.findByTypeId(52);
		// 获取旅行社资讯
		List<NewsDetail> lvxingshe = newsDetailService.findByTypeId(54);

		HotelTypeService hotelTypeService = new HotelTypeService();
		List<HotelType> hotelTypeList = hotelTypeService.findAll();
		request.setAttribute("hotelTypeList", hotelTypeList);

		HotelDetailService hotelDetailService = new HotelDetailService();// 前端酒店信息展示
		List<HotelDetail> hotelDetailList = hotelDetailService.findAll();
		request.setAttribute("hotelDetailList", hotelDetailList);

		RoadTypeService roadTypeService = new RoadTypeService();
		List<RoadType> roadTypeList = roadTypeService.findAll();
		request.setAttribute("roadTypeList", roadTypeList);

		// 热点资讯展示
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		List<TopNewsDetail> topNewsDetailList = topNewsDetailService.findAll();
		request.setAttribute("topNewsDetailList", topNewsDetailList);

		RoadDetailService roadDetailService = new RoadDetailService();// 前端功能栏旅游路线展示
		List<RoadDetail> roadDetailList = roadDetailService.findAll();
		// for (int i = 0; i < roadDetailList.size(); i++) {
		// System.out.println(roadDetailList.get(0).getTypeName());
		//
		// }

		// RoadTypeService roadTypeService = new RoadTypeService();
		// List<RoadType> roadTypeList = roadTypeService.findAll();
		// request.setAttribute("roadTypeList", roadTypeList);
		request.setAttribute("roadDetailList", roadDetailList);

		String id = request.getParameter("id");
		BlogService blogService = new BlogService();
		Blog blog = blogService.findById(id);

		List<Blog> blogList = blogService.findAll();

		request.setAttribute("blogList", blogList);
		request.setAttribute("blog", blog);

		request.setAttribute("inland", inland);
		request.setAttribute("foreign", foreign);
		request.setAttribute("traffic", traffic);
		request.setAttribute("jingqu", jingqu);
		request.setAttribute("lvxingshe", lvxingshe);
		request.getRequestDispatcher("/firstweb.jsp")
				.forward(request, response);

	}

	// 新闻更新
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String publishTimeStr = request.getParameter("publishTime");
		String topper = request.getParameter("topper");
		String bold = request.getParameter("bold");
		String color = request.getParameter("color");
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		NewsDetail newsDetail = new NewsDetail(id, title, content,
				loginUser.getId(), typeId, publishTime, topper, bold, color);
		NewsDetailService newsDetailService = new NewsDetailService();
		int result = newsDetailService.update(newsDetail);
		request.getRequestDispatcher("newsdetailservlet?op=list").forward(
				request, response);
	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		NewsDetailService newsDetailService = new NewsDetailService();
		NewsDetail newsDetail = newsDetailService.findById(id);
		request.setAttribute("newsDetail", newsDetail);
		request.getRequestDispatcher("editNewsDetail.jsp").forward(request,
				response);
	}

	// 批量删除
	private void batchDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		NewsDetailService newsDetailService = new NewsDetailService();
		newsDetailService.batchDelete(ids);
		list(request, response);
	}

	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		NewsDetailService newsDetailService = new NewsDetailService();
		newsDetailService.delete(id);
		list(request, response);
	}

	// 新闻详情显示
	private void toNewsDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		NewsDetailService newsDetailService = new NewsDetailService();
		CommentService commentService = new CommentService();
		NewsDetail newsDetail = newsDetailService.findById(id);
		List<Comment> commentList = commentService.findByNewsId(newsDetail
				.getId());
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		request.setAttribute("newsDetail", newsDetail);
		request.setAttribute("commentList", commentList);

		// 前端酒店信息展示
		HotelDetailService hotelDetailService = new HotelDetailService();
		List<HotelDetail> hotelDetailList = hotelDetailService.findAll();
		request.setAttribute("hotelDetailList", hotelDetailList);

		// 热点资讯展示
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		List<TopNewsDetail> topNewsDetailList = topNewsDetailService.findAll();
		request.setAttribute("topNewsDetailList", topNewsDetailList);

		request.getRequestDispatcher("showNewsDetail.jsp").forward(request,
				response);
	}

	// 查询
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String topper = request.getParameter("topper");
		String bold = request.getParameter("bold");
		String color = request.getParameter("color");
		String author = request.getParameter("userName");
		int typeId = Integer.parseInt(typeIdStr);
		NewsDetail newsDetail = new NewsDetail(title, content, author, typeId,
				topper, bold, color);
		NewsDetailService newsDetailService = new NewsDetailService();
		List<NewsDetail> newsDetailList = newsDetailService
				.findByCondition(newsDetail);
		request.setAttribute("newsDetailList", newsDetailList);
		request.setAttribute("newsDetail", newsDetail);

		request.getRequestDispatcher("listNewsDetail.jsp").forward(request,
				response);

	}

	// 前端新闻展示页面的搜索功能
	private void searchweb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);

		String title = request.getParameter("title");

		NewsDetail newsDetail = new NewsDetail(title);
		NewsDetailService newsDetailService = new NewsDetailService();
		List<NewsDetail> newsDetailList = newsDetailService
				.findByCondition2(newsDetail);
		request.setAttribute("newsDetailList", newsDetailList);
		request.setAttribute("newsDetail", newsDetail);

		request.getRequestDispatcher("main_news_inland.jsp").forward(request,
				response);
		// toNewsType(request, response);
	}

	// 新闻列表
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		NewsDetailService newsDetailService = new NewsDetailService();
		// List<NewsDetail> newsDetailList = newsDetailService.findAll();
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoStr != null && !"".equals(pageNoStr)) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		// 统计数量
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute("pageBean");
		if (pageBean == null) {
			pageBean = new PageBean();
			int count = newsDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<NewsDetail> newsDetailList = newsDetailService.findByPage(pageNo,
				PageBean.pageSize);
		request.setAttribute("newsDetailList", newsDetailList);
		request.getRequestDispatcher("listNewsDetail.jsp").forward(request,
				response);

	}

	// 添加新闻
	private void addNewsDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String publishTimeStr = request.getParameter("publishTime");
		String topper = request.getParameter("topper");
		String bold = request.getParameter("bold");
		String color = request.getParameter("color");
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		NewsDetail newsDetail = new NewsDetail(title, content,
				loginUser.getId(), typeId, publishTime, topper, bold, color);
		NewsDetailService newsDetailService = new NewsDetailService();
		int result = newsDetailService.save(newsDetail);
		request.getRequestDispatcher("newsdetailservlet?op=list").forward(
				request, response);

	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("addNewsDetail.jsp").forward(request,
				response);

	}

}

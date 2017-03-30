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

import com.syf.entity.RoadDetail;
import com.syf.entity.RoadType;
import com.syf.entity.UserDetail;
import com.syf.service.RoadDetailService;
import com.syf.service.RoadTypeService;
import com.syf.util.DateUtil;
import com.syf.util.PageBean;

/**
 * Servlet implementation class RoadDetailServlet
 */
@WebServlet("/RoadDetailServlet")
public class RoadDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoadDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 初始化方法
	// 获取类型
	public void init(HttpServletRequest request) {
		RoadTypeService roadTypeService = new RoadTypeService();
		List<RoadType> roadTypeList = roadTypeService.findAll();
		request.setAttribute("roadTypeList", roadTypeList);
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
			addRoadDetail(request, response);
		} else if ("list".equals(op)) {
			list(request, response);// 后台列表
		} else if ("listAll".equals(op)) {
			listAll(request, response);// 前端显示列表
		} else if ("toRoadDetail".equals(op)) {
			toRoadDetail(request, response);
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
		} else if ("toRoadType".equals(op)) {
			toRoadType(request, response);
		} else if ("listSearch".equals(op)) {
			listSearch(request, response);// 前端显示列表
		} else if ("search2".equals(op)) {
			search2(request, response);
		}

	}

	// 前台查询
	private void search2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);

		String roadName = request.getParameter("roadName");
		String typeIdStr = request.getParameter("typeId");
		// String price = request.getParameter("price");
		String goRoad = request.getParameter("goRoad");
		String backRoad = request.getParameter("backRoad");
		// String days = request.getParameter("days");
		// String agency = request.getParameter("agency");
		String traffic = request.getParameter("traffic");
		String tag = request.getParameter("tag");
		int typeId = Integer.parseInt(typeIdStr);
		RoadDetail roadDetail = new RoadDetail(roadName, typeId, goRoad,
				backRoad, traffic, tag);
		RoadDetailService roadDetailService = new RoadDetailService();

		List<RoadDetail> roadDetailList = roadDetailService
				.findByCondition(roadDetail);
		request.setAttribute("roadDetailList", roadDetailList);
		request.setAttribute("roadDetail", roadDetail);

		request.getRequestDispatcher("road_search.jsp").forward(request,
				response);

	}

	// 前端查询页面
	private void listSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);

		RoadDetailService roadDetailService = new RoadDetailService();
		List<RoadDetail> roadDetailList = roadDetailService.findAll();

		RoadTypeService roadTypeService = new RoadTypeService();
		List<RoadType> roadTypeList = roadTypeService.findAll();
		request.setAttribute("roadTypeList", roadTypeList);
		request.setAttribute("roadDetailList", roadDetailList);
		request.getRequestDispatcher("road_search.jsp").forward(request,
				response);

	}

	// 根据路线类型进入酒店详细分类
	private void toRoadType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String typeIdStr = request.getParameter("id");
		int typeId = Integer.parseInt(typeIdStr);
		RoadDetail roadDetail = new RoadDetail(typeId);
		RoadDetailService roadDetailService = new RoadDetailService();
		List<RoadDetail> roadDetailList = roadDetailService
				.findByCondition(roadDetail);
		// HotelDetail hotelDetail = hotelDetailService.findByTypeId(typeId);

		request.setAttribute("roadDetailList", roadDetailList);
		// request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("road_list_all.jsp").forward(request,
				response);
	}

	// 新闻首页热点展示
	// private void toFirstWeb(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// RoadDetailService roadDetailService = new RoadDetailService();
	// // 获取境内游资讯
	// List<RoadDetail> inland = newsDetailService.findByTypeId(42);
	// // 获取境内游资讯
	// List<NewsDetail> foreign = newsDetailService.findByTypeId(43);
	// // 获取交通资讯
	// List<NewsDetail> traffic = newsDetailService.findByTypeId(52);
	// // 获取景区资讯
	// List<NewsDetail> jingqu = newsDetailService.findByTypeId(51);
	//
	// HotelDetailService hotelDetailService = new HotelDetailService();
	// List<HotelDetail> hotelDetailList = hotelDetailService.findAll();
	// request.setAttribute("hotelDetailList", hotelDetailList);
	//
	// request.setAttribute("inland", inland);
	// request.setAttribute("foreign", foreign);
	// request.setAttribute("traffic", traffic);
	// request.setAttribute("inland", inland);
	// request.getRequestDispatcher("/firstweb.jsp")
	// .forward(request, response);
	//
	// }

	// 更新
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String roadName = request.getParameter("roadName");
		String typeIdStr = request.getParameter("typeId");
		String price = request.getParameter("price");
		String goRoad = request.getParameter("goRoad");
		String backRoad = request.getParameter("backRoad");
		String days = request.getParameter("days");
		String agency = request.getParameter("agency");
		String phone = request.getParameter("phone");
		String traffic = request.getParameter("traffic");
		String mainInfo = request.getParameter("mainInfo");
		String tag = request.getParameter("tag");
		String publishTimeStr = request.getParameter("publishTime");
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);

		//
		// RoadDetail roadDetail = new RoadDetail(roadName, typeId,
		// loginUser.getId(), price, goRoad, backRoad, days, agency,
		// phone, traffic, mainInfo, tag, publishTime);

		RoadDetail roadDetail = new RoadDetail(id, roadName, typeId,
				loginUser.getId(), price, goRoad, backRoad, days, agency,
				phone, traffic, mainInfo, tag, publishTime);
		RoadDetailService roadDetailService = new RoadDetailService();
		int result = roadDetailService.update(roadDetail);
		request.getRequestDispatcher("roaddetailservlet?op=list").forward(
				request, response);
	}

	// 编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		RoadDetailService roadDetailService = new RoadDetailService();
		RoadDetail roadDetail = roadDetailService.findById(id);
		request.setAttribute("roadDetail", roadDetail);
		request.getRequestDispatcher("editRoadDetail.jsp").forward(request,
				response);
	}

	// 批量删除
	private void batchDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		RoadDetailService roadDetailService = new RoadDetailService();
		roadDetailService.batchDelete(ids);
		list(request, response);
	}

	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		RoadDetailService roadDetailService = new RoadDetailService();
		roadDetailService.delete(id);
		list(request, response);
	}

	// 新闻详情显示
	private void toRoadDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		RoadDetailService roadDetailService = new RoadDetailService();
		// CommentService commentService = new CommentService();
		RoadDetail roadDetail = roadDetailService.findById(id);
		// List<Comment> commentList = commentService.findByNewsId(newsDetail
		// .getId());
		request.setAttribute("roadDetail", roadDetail);
		// request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("road_detail_show.jsp").forward(request,
				response);
	}

	// 前台查询
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String roadName = request.getParameter("roadName");
		String typeIdStr = request.getParameter("typeId");
		// String price = request.getParameter("price");
		String goRoad = request.getParameter("goRoad");
		String backRoad = request.getParameter("backRoad");
		// String days = request.getParameter("days");
		// String agency = request.getParameter("agency");
		String traffic = request.getParameter("traffic");
		String tag = request.getParameter("tag");
		int typeId = Integer.parseInt(typeIdStr);
		RoadDetail roadDetail = new RoadDetail(roadName, typeId, goRoad,
				backRoad, traffic, tag);
		RoadDetailService roadDetailService = new RoadDetailService();

		List<RoadDetail> roadDetailList = roadDetailService
				.findByCondition(roadDetail);
		request.setAttribute("roadDetailList", roadDetailList);
		request.setAttribute("roadDetail", roadDetail);

		request.getRequestDispatcher("road_list_all.jsp").forward(request,
				response);

	}

	// 后台 列表
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		RoadDetailService roadDetailService = new RoadDetailService();
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
			int count = roadDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		// 分页查询
		List<RoadDetail> roadDetailList = roadDetailService.findByPage(pageNo,
				PageBean.pageSize);
		request.setAttribute("roadDetailList", roadDetailList);
		request.getRequestDispatcher("listRoadDetail.jsp").forward(request,
				response);

	}

	// 前端列表
	private void listAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);

		RoadDetailService roadDetailService = new RoadDetailService();
		List<RoadDetail> roadDetailList = roadDetailService.findAll();

		RoadTypeService roadTypeService = new RoadTypeService();
		List<RoadType> roadTypeList = roadTypeService.findAll();
		request.setAttribute("roadTypeList", roadTypeList);
		request.setAttribute("roadDetailList", roadDetailList);
		request.getRequestDispatcher("road_list_all.jsp").forward(request,
				response);

	}

	// 添加新闻
	private void addRoadDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String roadName = request.getParameter("roadName");
		String typeIdStr = request.getParameter("typeId");
		String price = request.getParameter("price");
		String goRoad = request.getParameter("goRoad");
		String backRoad = request.getParameter("backRoad");
		String days = request.getParameter("days");
		String agency = request.getParameter("agency");
		String phone = request.getParameter("phone");
		String traffic = request.getParameter("traffic");
		String mainInfo = request.getParameter("mainInfo");
		String tag = request.getParameter("tag");
		String publishTimeStr = request.getParameter("publishTime");
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		RoadDetail roadDetail = new RoadDetail(roadName, typeId,
				loginUser.getId(), price, goRoad, backRoad, days, agency,
				phone, traffic, mainInfo, tag, publishTime);
		RoadDetailService roadDetailService = new RoadDetailService();
		int result = roadDetailService.save(roadDetail);
		request.getRequestDispatcher("roaddetailservlet?op=list").forward(
				request, response);

	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("addRoadDetail.jsp").forward(request,
				response);

	}

	// private void toIndex(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// RoadDetailService roadDetailService = new RoadDetailService();
	// // 获取军事新闻
	// List<NewsDetail> inlandnews = newsDetailService.findByTypeId(42);
	//
	// request.setAttribute("inlandnews", inlandnews);
	// request.getRequestDispatcher("/main_news_inland.jsp").forward(request,
	// response);
	//
	// }
	//
	// private void toForeign(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// NewsDetailService newsDetailService = new NewsDetailService();
	//
	// // 获取境内游资讯
	// List<NewsDetail> foreign = newsDetailService.findByTypeId(43);
	//
	// request.setAttribute("foreign", foreign);
	// request.getRequestDispatcher("/main_news_foreign.jsp").forward(request,
	// response);
	// }
}

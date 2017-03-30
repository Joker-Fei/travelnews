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
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.syf.entity.HotelDetail;
import com.syf.entity.HotelType;
import com.syf.entity.UserDetail;
import com.syf.service.HotelDetailService;
import com.syf.service.HotelTypeService;
import com.syf.util.DateUtil;
import com.syf.util.PageBean;

@WebServlet("/HotelDetailServlet")
public class HotelDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HotelDetailServlet() {
		super();
	}

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		HotelTypeService hotelTypeService = new HotelTypeService();
		List<HotelType> hotelTypeList = hotelTypeService.findAll();
		request.setAttribute("hotelTypeList", hotelTypeList);
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
			try {
				addHotelDetail(request, response);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("list".equals(op)) {
			list(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("toHotelDetail".equals(op)) {
			toHotelDetail(request, response);
		} else if ("listWeb".equals(op)) {
			listWeb(request, response);
		} else if ("toHotelDetailWeb".equals(op)) {
			toHotelDetailWeb(request, response);
		} else if ("search".equals(op)) {
			search(request, response);
		} else if ("toFirstWeb".equals(op)) {
			toFirstWeb(request, response);
		} else if ("search2".equals(op)) {
			search2(request, response);
		} else if ("toHotelType".equals(op)) {
			toHotelType(request, response);// 根据酒店类型进入酒店详细分类
		} else if ("listSearch".equals(op)) {
			listSearch(request, response);
		}
		// else if ("delete".equals(op)) {
		// delete(request, response);
		// } else if ("batchDelete".equals(op)) {
		// batchDelete(request, response);
		// } else if ("toEdit".equals(op)) {
		// toEdit(request, response);
		// } else if ("update".equals(op)) {
		// update(request, response);
		// } else if ("search".equals(op)) {
		// search(request, response);
		// } else if ("toIndex".equals(op)) {
		// toIndex(request, response);
	}

	// 首页热点展示
	private void toFirstWeb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);

		HotelDetailService hotelDetailService = new HotelDetailService();
		List<HotelDetail> hotelDetailList = hotelDetailService.findAll();
		request.setAttribute("hotelDetailList", hotelDetailList);
		request.getRequestDispatcher("/firstweb.jsp")
				.forward(request, response);

	}

	private void listWeb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		init(request);

		HotelDetailService hotelDetailService = new HotelDetailService();
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
			int count = hotelDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		// 分页查询
		List<HotelDetail> hotelDetailList = hotelDetailService.findByPage(
				pageNo, PageBean.pageSize);

		// HotelDetailService hotelDetailService = new HotelDetailService();
		// List<HotelDetail> hotelDetailList = hotelDetailService.findAll();
		request.setAttribute("hotelDetailList", hotelDetailList);
		request.getRequestDispatcher("hotel_web_list.jsp").forward(request,
				response);

	}

	private void listSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		init(request);

		HotelDetailService hotelDetailService = new HotelDetailService();
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
			int count = hotelDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		// 分页查询
		List<HotelDetail> hotelDetailList = hotelDetailService.findByPage(
				pageNo, PageBean.pageSize);

		// HotelDetailService hotelDetailService = new HotelDetailService();
		// List<HotelDetail> hotelDetailList = hotelDetailService.findAll();
		request.setAttribute("hotelDetailList", hotelDetailList);
		request.getRequestDispatcher("hotel_search.jsp").forward(request,
				response);

	}

	// // 批量删除
	// private void batchDelete(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// String[] ids = request.getParameterValues("ids");
	// HotelDetailService hotelDetailService = new HotelDetailService();
	// hotelDetailService.batchDelete(ids);
	// list(request, response);
	// }
	//
	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		HotelDetailService hotelDetailService = new HotelDetailService();
		hotelDetailService.delete(id);
		list(request, response);
	}

	// 酒店详情显示
	private void toHotelDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HotelDetailService hotelDetailService = new HotelDetailService();

		HotelDetail hotelDetail = hotelDetailService.findById(id);

		request.setAttribute("hotelDetail", hotelDetail);
		// request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("showHotelDetail.jsp").forward(request,
				response);
	}

	// 根据酒店类型进入酒店详细分类
	private void toHotelType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String typeIdStr = request.getParameter("id");
		int typeId = Integer.parseInt(typeIdStr);
		HotelDetail hotelDetail = new HotelDetail(typeId);
		HotelDetailService hotelDetailService = new HotelDetailService();
		List<HotelDetail> hotelDetailList = hotelDetailService
				.findByCondition(hotelDetail);

		HotelTypeService hotelTypeService = new HotelTypeService();
		List<HotelType> hotelTypeList = hotelTypeService.findAll();
		request.setAttribute("hotelTypeList", hotelTypeList);

		request.setAttribute("hotelDetailList", hotelDetailList);
		request.getRequestDispatcher("hotel_web_list.jsp").forward(request,
				response);
	}

	// 酒店详情显示
	private void toHotelDetailWeb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HotelDetailService hotelDetailService = new HotelDetailService();
		/* CommentService commentService = new CommentService(); */
		HotelDetail hotelDetail = hotelDetailService.findById(id);

		HotelTypeService hotelTypeService = new HotelTypeService();
		List<HotelType> hotelTypeList = hotelTypeService.findAll();
		request.setAttribute("hotelTypeList", hotelTypeList);
		request.setAttribute("hotelDetail", hotelDetail);

		request.getRequestDispatcher("hotel_web_list_detail.jsp").forward(
				request, response);
	}

	// 前端模糊查询
	private void search2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);

		String name = request.getParameter("name");// 酒店名
		String typeIdStr = request.getParameter("typeId");// 酒店类型
		String city = request.getParameter("city");// 城市
		String address = request.getParameter("address");// 地址关键字

		int typeId = Integer.parseInt(typeIdStr);
		HotelDetail hotelDetail = new HotelDetail(name, typeId, city, address);
		HotelDetailService hotelDetailService = new HotelDetailService();
		List<HotelDetail> hotelDetailList = hotelDetailService
				.findByCondition(hotelDetail);
		request.setAttribute("hotelDetailList", hotelDetailList);
		request.setAttribute("hotelDetail", hotelDetail);

		request.getRequestDispatcher("hotel_search.jsp").forward(request,
				response);

	}

	// 前端模糊查询
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String name = request.getParameter("name");// 酒店名
		String typeIdStr = request.getParameter("typeId");// 酒店类型
		String city = request.getParameter("city");// 城市
		String address = request.getParameter("address");// 地址关键字

		int typeId = Integer.parseInt(typeIdStr);
		HotelDetail hotelDetail = new HotelDetail(name, typeId, city, address);
		HotelDetailService hotelDetailService = new HotelDetailService();
		List<HotelDetail> hotelDetailList = hotelDetailService
				.findByCondition(hotelDetail);
		request.setAttribute("hotelDetailList", hotelDetailList);
		request.setAttribute("hotelDetail", hotelDetail);

		request.getRequestDispatcher("hotel_web_list.jsp").forward(request,
				response);

	}

	//
	// // 前端：根据类型进行快速查询酒店信息分类
	// private void searchByType(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// init(request);
	//
	// String typeIdStr = request.getParameter("typeId");// 酒店类型
	//
	// int typeId = Integer.parseInt(typeIdStr);
	// // HotelDetail hotelDetail = new HotelDetail(typeId);
	// HotelDetailService hotelDetailService = new HotelDetailService();
	// List<HotelDetail> hotelDetailList1 = hotelDetailService
	// .findByTypeId(typeId);
	// request.setAttribute("hotelDetailList1", hotelDetailList1);
	// // request.setAttribute("hotelDetail", hotelDetail);
	//
	// request.getRequestDispatcher("firstweb.jsp").forward(request, response);
	//
	// }

	// 酒店列表
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		HotelDetailService hotelDetailService = new HotelDetailService();
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
			int count = hotelDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		// 分页查询
		List<HotelDetail> hotelDetailList = hotelDetailService.findByPage(
				pageNo, PageBean.pageSize);
		request.setAttribute("hotelDetailList", hotelDetailList);
		request.getRequestDispatcher("listHotelDetail.jsp").forward(request,
				response);

	}

	// 添加酒店
	private void addHotelDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SmartUploadException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");

		SmartUpload su = new SmartUpload("utf-8");
		JspFactory _jspxFactory = null;
		PageContext pageContext = null;
		_jspxFactory = JspFactory.getDefaultFactory();
		pageContext = _jspxFactory.getPageContext(this, request, response, "",
				true, 8192, true);
		su.initialize(pageContext);
		su.service(request, response);
		su.setTotalMaxFileSize(100000000);
		su.setAllowedFilesList("gif,jpg,bmp,txt,doc,xls,htm,html,JPG,zip,rar,png");
		// su.setDeniedFilesList("exe,bat,jsp,htm,html,,");

		su.upload();

		com.jspsmart.upload.SmartFile file = su.getFiles().getFile(0);
		Date date = new Date();
		String newName = date.getTime()
				+ file.getFileName().substring(
						file.getFileName().lastIndexOf("."));
		file.saveAs("/upload/" + newName);

		// System.out.println("文件命名              " + "upload/" + newName);

		String name = su.getRequest().getParameter("name");
		String imgUrl = "upload/" + newName;
		String typeIdStr = su.getRequest().getParameter("typeId");
		String price = su.getRequest().getParameter("price");
		String city = su.getRequest().getParameter("city");
		String web = su.getRequest().getParameter("web");
		String address = su.getRequest().getParameter("address");
		String phone = su.getRequest().getParameter("phone");
		String publishTimeStr = su.getRequest().getParameter("publishTime");
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		HotelDetail hotelDetail = new HotelDetail(name, imgUrl,
				loginUser.getId(), typeId, price, city, web, address, phone,
				publishTime);
		HotelDetailService hotelDetailService = new HotelDetailService();
		int result = hotelDetailService.save(hotelDetail);
		request.getRequestDispatcher("hoteldetailservlet?op=list").forward(
				request, response);

	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("addHotelDetail.jsp").forward(request,
				response);

	}

}

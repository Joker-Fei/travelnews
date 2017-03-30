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
import com.syf.entity.Blog;
import com.syf.entity.MessageDetail;
import com.syf.entity.UserDetail;
import com.syf.service.BlogService;
import com.syf.service.MessageDetailService;
import com.syf.util.DateUtil;
import com.syf.util.PageBean;

/**
 * Servlet implementation class BlogServlet
 * 
 * @param <BlogDService>
 */
@WebServlet("/BlogServlet")
public class BlogServlet<BlogDService> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BlogServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		} else if ("writeblog".equals(op)) {
			try {
				writeblog(request, response);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("listAll".equals(op)) {
			listAll(request, response);
		} else if ("list".equals(op)) {
			list(request, response);
		} else if ("writealone".equals(op)) {
			writealone(request, response);// 单独写博客时需要验证
		} else if ("toBlog".equals(op)) {
			toBlog(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("blogdelete".equals(op)) {
			blogdelete(request, response);// 后台游记审核管理
		} else if ("toBlogDetail".equals(op)) {
			toBlogDetail(request, response);// 后台审核时的详细信息
		} else if ("listAllDelete".equals(op)) {
			listAllDelete(request, response);
		}
	}

	private void blogdelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BlogService blogService = new BlogService();

		blogService.delete(id);
		listAllDelete(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		BlogService blogService = new BlogService();
		blogService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		if (loginUser != null) {

			// String id = String.valueOf(loginUser.getId());
			// System.out.print(id);

			// 不同用户登陆后显示各自的博客信息
			String i = Integer.toString(loginUser.getId());

			BlogService blogService = new BlogService();
			List<Blog> blogList = blogService.findAllByUserId(i);

			request.setAttribute("blogList", blogList);
			request.getRequestDispatcher("blog_list.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("aaaaa.jsp")
					.forward(request, response);
		}

	}

	private void writealone(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		if (loginUser != null) {

			// String id = String.valueOf(loginUser.getId());
			// System.out.print(id);

			// 不同用户登陆后显示各自的博客信息
			String i = Integer.toString(loginUser.getId());

			BlogService blogService = new BlogService();
			List<Blog> blogList = blogService.findAllByUserId(i);

			request.setAttribute("blogList", blogList);
			request.getRequestDispatcher("blog_write.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("aaaaa.jsp")
					.forward(request, response);
		}

	}

	// 后台审核管理时的游记详细界面
	private void toBlogDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BlogService blogService = new BlogService();
		Blog blog = blogService.findById(id);

		request.setAttribute("blog", blog);
		request.getRequestDispatcher("/listDeleteBlogDetail.jsp").forward(
				request, response);

	}

	// 前台展示游记详情
	private void toBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		BlogService blogService = new BlogService();
		Blog blog = blogService.findById(id);

		List<Blog> blogList = blogService.findAll();// 向blog_detail_show.jsp页面发送路线类型信息
		request.setAttribute("blogList", blogList);

		request.setAttribute("blog", blog);
		request.getRequestDispatcher("/blog_detail_show.jsp").forward(request,
				response);

	}

	// 游记审核完以后的列表（后台）
	private void listAllDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BlogService blogService = new BlogService();
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
			int count = blogService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		// 分页查询
		List<Blog> blogList = blogService.findByPage(pageNo, PageBean.pageSize);
		request.setAttribute("blogList", blogList);
		request.getRequestDispatcher("listDeleteBlog.jsp").forward(request,
				response);

	}

	// 前台游记列表（不用登陆就可以浏览）
	private void listAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BlogService blogService = new BlogService();
		List<Blog> blogList = blogService.findAll();
		request.setAttribute("blogList", blogList);

		MessageDetailService messageDetailService1 = new MessageDetailService();
		List<MessageDetail> messageDetailList1 = messageDetailService1
				.findAll();
		request.setAttribute("messageDetailList1", messageDetailList1);

		request.getRequestDispatcher("blog_list_all.jsp").forward(request,
				response);

	}

	private void writeblog(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SmartUploadException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		if (loginUser != null) {
			SmartUpload su = new SmartUpload("utf-8");
			JspFactory _jspxFactory = null;
			PageContext pageContext = null;
			_jspxFactory = JspFactory.getDefaultFactory();
			pageContext = _jspxFactory.getPageContext(this, request, response,
					"", true, 8192, true);
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

			String title = su.getRequest().getParameter("title");
			String imgUrl = "upload/" + newName;
			String content = su.getRequest().getParameter("content");
			String publishTimeStr = su.getRequest().getParameter("publishTime");
			String topper = su.getRequest().getParameter("topper");
			String bold = su.getRequest().getParameter("bold");
			String color = su.getRequest().getParameter("color");
			Date publishTime = DateUtil.string2Date(publishTimeStr);
			Blog blog = new Blog(title, imgUrl, content, loginUser.getId(),
					publishTime, topper, bold, color);
			BlogService blogService = new BlogService();
			int result = blogService.save(blog);
			request.getRequestDispatcher("blogservlet?op=list").forward(
					request, response);
		} else {

			request.getRequestDispatcher("aaaaa.jsp")
					.forward(request, response);

		}

	}

	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("blog_write.jsp").forward(request,
				response);

	}

}

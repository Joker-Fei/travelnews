package com.syf.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syf.entity.Blog;
import com.syf.entity.Letter;
import com.syf.entity.MessageDetail;
import com.syf.entity.UserDetail;
import com.syf.service.BlogService;
import com.syf.service.LetterService;
import com.syf.service.MessageDetailService;
import com.syf.service.NewsDetailService;
import com.syf.util.DateUtil;

/**
 * Servlet implementation class MessageDetailServlet
 */
@WebServlet("/MessageDetailServlet")
public class MessageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MessageDetailServlet() {
		super();

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
			addMessageDetail(request, response);
		} else if ("list".equals(op)) {
			list(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("listAll".equals(op)) {
			listAll(request, response);
		} else if ("writealone".equals(op)) {
			writealone(request, response);
		} else if ("toMessageDetail".equals(op)) {
			toMessageDetail(request, response);
		} else if ("toMessageDetailOfMine".equals(op)) {
			toMessageDetailOfMine(request, response);// 我的结伴游详细消息
		}
	}

	// 前台展示游记详情我的空间
	private void toMessageDetailOfMine(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// NewsDetailService newsDetailService = new NewsDetailService();
		// CommentService commentService = new CommentService();
		// NewsDetail newsDetail = newsDetailService.findById(id);
		// List<Comment> commentList = commentService.findByNewsId(newsDetail
		// .getId());
		// NewsTypeService newsTypeService = new NewsTypeService();
		// List<NewsType> newsTypeList = newsTypeService.findAll();
		// request.setAttribute("newsTypeList", newsTypeList);
		// request.setAttribute("newsDetail", newsDetail);
		// request.setAttribute("commentList", commentList);

		String id = request.getParameter("id");
		MessageDetailService messageDetailService = new MessageDetailService();
		LetterService letterService = new LetterService();
		MessageDetail messageDetail = messageDetailService.findById(id);
		List<Letter> letterList = letterService.findByMessageId(messageDetail
				.getId());
		request.setAttribute("letterList", letterList);

		List<MessageDetail> messageDetailList = messageDetailService.findAll();// 向blog_detail_show.jsp页面发送路线类型信息
		request.setAttribute("messageDetailList", messageDetailList);

		request.setAttribute("messageDetail", messageDetail);
		request.getRequestDispatcher("/message_letter_mine.jsp").forward(
				request, response);

	}

	// 前台展示游记详情
	private void toMessageDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MessageDetailService messageDetailService1 = new MessageDetailService();
		List<MessageDetail> messageDetailList1 = messageDetailService1
				.findAll();
		request.setAttribute("messageDetailList1", messageDetailList1);

		String id = request.getParameter("id");
		MessageDetailService messageDetailService = new MessageDetailService();
		LetterService letterService = new LetterService();
		MessageDetail messageDetail = messageDetailService.findById(id);
		List<Letter> letterList = letterService.findByMessageId(messageDetail
				.getId());
		request.setAttribute("letterList", letterList);

		List<MessageDetail> messageDetailList = messageDetailService.findAll();// 向blog_detail_show.jsp页面发送路线类型信息
		request.setAttribute("messageDetailList", messageDetailList);

		request.setAttribute("messageDetail", messageDetail);

		request.getRequestDispatcher("/messagedetail_show.jsp").forward(
				request, response);

	}

	// 用户个人发布结伴游信息
	private void writealone(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		if (loginUser != null) {

			// 不同用户登陆后显示各自的博客信息
			String i = Integer.toString(loginUser.getId());

			MessageDetailService messageDetailService = new MessageDetailService();
			List<MessageDetail> messageDetailList = messageDetailService
					.findAllByUserId(i);

			request.setAttribute("messageDetailList", messageDetailList);
			request.getRequestDispatcher("messagedetail_add.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("aaaaa.jsp")
					.forward(request, response);
		}

	}

	// 前台列表（不用登陆就可以浏览）
	private void listAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		BlogService blogService = new BlogService();
		Blog blog = blogService.findById(id);

		List<Blog> blogList = blogService.findAll();// 向blog_detail_show.jsp页面发送路线类型信息
		request.setAttribute("blogList", blogList);

		request.setAttribute("blog", blog);

		MessageDetailService messageDetailService = new MessageDetailService();
		List<MessageDetail> messageDetailList = messageDetailService.findAll();
		request.setAttribute("messageDetailList", messageDetailList);
		request.getRequestDispatcher("messagedetail_list_all.jsp").forward(
				request, response);

	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("messagedetail_add.jsp").forward(request,
				response);

	}

	// 添加结伴游信息
	private void addMessageDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String tag = request.getParameter("tag");
		String content = request.getParameter("content");
		String publishTimeStr = request.getParameter("publishTime");
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		MessageDetail messageDetail = new MessageDetail(tag, content,
				loginUser.getId(), publishTime);
		MessageDetailService messageDetailService = new MessageDetailService();
		int result = messageDetailService.save(messageDetail);
		request.getRequestDispatcher("messagedetailservlet?op=list").forward(
				request, response);

	}

	// 结伴游列表
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		if (loginUser != null) {

			// 不同用户登陆后显示各自的博客信息
			String i = Integer.toString(loginUser.getId());

			MessageDetailService messageDetailService = new MessageDetailService();
			List<MessageDetail> messageDetailList = messageDetailService
					.findAllByUserId(i);

			request.setAttribute("messageDetailList", messageDetailList);
			request.getRequestDispatcher("messagedetail_list.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("aaaaa.jsp")
					.forward(request, response);
		}

	}

	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		NewsDetailService newsDetailService = new NewsDetailService();
		newsDetailService.delete(id);
	}
}

package com.syf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syf.entity.Comment;
import com.syf.entity.UserDetail;
import com.syf.service.CommentService;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentServlet() {
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
		if ("add".equals(op)) {
			addComment(request, response);
		} else if ("delete".equals(op)) {
			deleteComment(request, response);
		} else if ("changStatus".equals(op)) {
			changStatus(request, response);
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void changStatus(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		CommentService commentService = new CommentService();
		commentService.updateState(id);
		String newsId = request.getParameter("newsId");
		response.sendRedirect("newsdetailservlet?op=toNewsDetail&id=" + newsId
				+ "&t=" + new Date());

	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void deleteComment(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		CommentService commentService = new CommentService();
		commentService.delete(id);
		String newsId = request.getParameter("newsId");
		response.sendRedirect("newsdetailservlet?op=toNewsDetail&id=" + newsId);
	}

	private void addComment(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		UserDetail userDetail = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		if (userDetail == null) {
			response.sendRedirect("aaaaa.jsp");
			// System.out.println("userDetail=====" + userDetail);
		} else if (userDetail.getStatus() == 1) {
			String newsId = request.getParameter("newsId");
			String content = request.getParameter("content");
			Date writeTime = new Date();
			int status = 0;// 默认正常显示
			Comment comment = new Comment(userDetail.getId(),
					Integer.parseInt(newsId), content, writeTime, status);
			CommentService commentService = new CommentService();
			commentService.save(comment);
			PrintWriter out = response.getWriter();
			out.write("<script>alert('评论发表成功');history.back();</script>");
		} else if (userDetail.getStatus() == 0) {
			response.sendRedirect("bbbbb.jsp");
		}
	}

}

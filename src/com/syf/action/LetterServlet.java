package com.syf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syf.entity.Letter;
import com.syf.entity.UserDetail;
import com.syf.service.LetterService;

/**
 * Servlet implementation class LetterServlet
 */
@WebServlet("/LetterServlet")
public class LetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LetterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("add".equals(op)) {
			addLetter(request, response);
		}
		// else if ("delete".equals(op)) {
		// deleteComment(request, response);
		// }
	}

	private void addLetter(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		UserDetail userDetail = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		if (userDetail == null) {
			response.sendRedirect("aaaaa.jsp");
			// System.out.println("userDetail=====" + userDetail);
		} else {
			String messageId = request.getParameter("messageId");
			String content = request.getParameter("content");
			Date writeTime = new Date();
			// int status = 0;// 默认正常显示
			Letter letter = new Letter(userDetail.getId(),
					Integer.parseInt(messageId), content, writeTime);
			LetterService letterService = new LetterService();
			letterService.save(letter);
			PrintWriter out = response.getWriter();
			out.write("<script>alert('私信成功！');history.back();</script>");
		}
	}
}

package com.syf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syf.entity.NewsType;
import com.syf.service.NewsTypeService;

public class NewsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewsTypeServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");// 注意：此处的JSP页面不放在根目录下，Servlet就无法接收到页面传来的数据，因为web.xml配置信息无法覆盖
		if ("add".equals(op)) {
			addNewsType(request, response);
		} else if ("list".equals(op)) {
			listNewsType(request, response);
		} else if ("delete".equals(op)) {
			deleteById(request, response);
		} else if ("listType".equals(op)) {
			listType(request, response);
		}
		/*
		 * else if ("batchDelete".equals(op)) { batchDelete(request, response);
		 * }
		 */
	}

	// 显示列表
	private void listType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		request.getRequestDispatcher("firstweb.jsp").forward(request, response);
	}

	/*
	 * // 批量删除 private void batchDelete(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * String[] ids = request.getParameterValues("ids");// 接收来自网页的Id集合
	 * 
	 * 
	 * for (int i = 0; i < ids.length; i++) { System.out.println(ids[i]); }
	 * 
	 * NewsTypeService newsTypeService = new NewsTypeService();
	 * newsTypeService.batchDelete(ids); // 删除数据后，返回列表 listNewsType(request,
	 * response); }
	 */
	// 根据Id删除数据
	private void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			out.write("<script>alert('密码不能为空');history.back();</script>");
			return;
		}
		int id = Integer.parseInt(idStr);
		NewsTypeService newsTypeService = new NewsTypeService();
		newsTypeService.delete(id);
		// 删除数据后，返回列表
		listNewsType(request, response);
	}

	// 显示列表
	private void listNewsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		request.getRequestDispatcher("listNewsType.jsp").forward(request,
				response);
	}

	// 添加数据类型
	private void addNewsType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		NewsType newsType = new NewsType(typeName);
		NewsTypeService newsTypeService = new NewsTypeService();
		newsTypeService.save(newsType);
		response.sendRedirect("listNewsType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).
	}

}

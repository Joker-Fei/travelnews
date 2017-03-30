package com.syf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syf.entity.RoadType;
import com.syf.service.RoadTypeService;

/**
 * Servlet implementation class RoadTypeServlet
 */
@WebServlet("/RoadTypeServlet")
public class RoadTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoadTypeServlet() {
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

		String op = request.getParameter("op");// 注意：此处的JSP页面不放在根目录下，Servlet就无法接收到页面传来的数据，因为web.xml配置信息无法覆盖
		if ("add".equals(op)) {
			addRoadType(request, response);
		} else if ("list".equals(op)) {
			listRoadType(request, response);
		} else if ("delete".equals(op)) {
			deleteById(request, response);
		}
	}

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
		RoadTypeService roadTypeService = new RoadTypeService();
		roadTypeService.delete(id);
		// 删除数据后，返回列表
		listRoadType(request, response);
	}

	// 显示列表
	private void listRoadType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RoadTypeService roadTypeService = new RoadTypeService();
		List<RoadType> roadTypeList = roadTypeService.findAll();
		request.setAttribute("roadTypeList", roadTypeList);
		request.getRequestDispatcher("listRoadType.jsp").forward(request,
				response);
	}

	// 添加数据类型
	private void addRoadType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		RoadType roadType = new RoadType(typeName);
		RoadTypeService roadTypeService = new RoadTypeService();
		roadTypeService.save(roadType);
		response.sendRedirect("listRoadType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).
	}

}

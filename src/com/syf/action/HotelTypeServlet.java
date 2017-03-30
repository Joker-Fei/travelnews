package com.syf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syf.entity.HotelType;
import com.syf.service.HotelTypeService;

@WebServlet("/HotelTypeServlet")
public class HotelTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HotelTypeServlet() {
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
			addHotelType(request, response);
		} else if ("list".equals(op)) {
			listHotelType(request, response);
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
		HotelTypeService hotelTypeService = new HotelTypeService();
		hotelTypeService.delete(id);
		// 删除数据后，返回列表
		listHotelType(request, response);
	}

	// 显示列表
	private void listHotelType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HotelTypeService hotelTypeService = new HotelTypeService();
		List<HotelType> hotelTypeList = hotelTypeService.findAll();
		request.setAttribute("hotelTypeList", hotelTypeList);
		request.getRequestDispatcher("listHotelType.jsp").forward(request,
				response);
	}

	// 添加数据类型
	private void addHotelType(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String typeName = request.getParameter("typeName");
		HotelType hotelType = new HotelType(typeName);
		HotelTypeService hotelTypeService = new HotelTypeService();
		hotelTypeService.save(hotelType);
		response.sendRedirect("listHotelType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).

	}

}

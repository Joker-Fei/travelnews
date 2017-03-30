package com.syf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syf.entity.UserDetail;
import com.syf.service.UserDetailService;
import com.syf.util.DateUtil;
import com.syf.util.PageBean;

@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public UserDetailServlet() {
		super();
	}

	/**
	 * 处理get请求
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 处理post请求
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");
		if ("register".equals(op)) {
			// 完成注册功能
			register(request, response);
		} else if ("login".equals(op)) {
			// 完成登录功能
			login(request, response);
		} else if ("list".equals(op)) {
			// 显示所有的用户
			list(request, response);
		} else if ("addUser".equals(op)) {
			// 管理员添加用户对象
			addUser(request, response);
		} else if ("search".equals(op)) {
			search(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("toEdit".equals(op)) {
			// 编辑用户
			toEdit(request, response);
		} else if ("update".equals(op)) {
			// 更新操作
			update(request, response);
		} else if ("changeStatus".equals(op)) {
			changeStatus(request, response);
		} else if ("123".equals(op)) {
			ajaxRegister(request, response);// ajax验证注册用户名是否存在
		} else if ("checkPwd".equals(op)) {
			checkPwd(request, response);
		} else if ("changePwd".equals(op)) {
			changePwd(request, response);
		}
	}

	private void changePwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("userPwd");
		UserDetailService userDetailService = new UserDetailService();
		int a = userDetailService.changePwd(id, pwd);
		// 0密码错误，1密码正确
		PrintWriter out = response.getWriter();

		if (a == 1) {

			out.write("<script>alert('密码修改成功');history.back();</script>");

		} else {
			out.write("<script>alert('密码修改失败');history.back();</script>");
		}

	}

	private void checkPwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		UserDetailService userDetailService = new UserDetailService();
		int a = userDetailService.checkPwd(id, pwd);
		// 0密码错误，1密码正确
		if (a == 0) {

			response.getWriter().print(0);// 把这一int值发送给ajax中的result

		} else {
			response.getWriter().print(1);// 把这一个int值发送给ajax中的result
		}
	}

	private String ajaxRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("开始进行ajax校验");
		UserDetail userDetail = null;
		String username = request.getParameter("userName");
		// 从界面获取数据
		// String passPwd = request.getParameter("passPwd");
		UserDetailService userDetailService = new UserDetailService();
		int a = userDetailService.findByUserName(username);
		// System.out.println("a===" + a);
		// 根据用户名到数据库进行查询返回的值，进行判断，如果没用查到数据返回值为null，
		// 说明用户名不存在，那么返回1，不为空说明用户名已经存在，返回0
		if (a == 0) {

			response.getWriter().print(0);// 把这一int值发送给ajax中的result

		} else {
			response.getWriter().print(1);// 把这一个int值发送给ajax中的result
		}
		return null;
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从界面获取数据
		String userName = request.getParameter("iptNickName");
		String userPwd = request.getParameter("t_UserPass");
		UserDetailService userDetailService = new UserDetailService();
		UserDetail loginUser = userDetailService.login(userName, userPwd);
		if (loginUser == null) {
			// 登录失败
			request.setAttribute("errorMsg", "用户名或密码错误！");
			request.getRequestDispatcher("log.jsp").forward(request, response);
		} else {
			// 登录成功
			HttpSession session = request.getSession();
			// 保存登录用户的信息到session中
			session.setAttribute("loginUser", loginUser);
			// 如果权限是3，即该用户是普通会员，则跳转到新闻资讯首页
			if (loginUser.getPower() == 3) {
				request.getRequestDispatcher("toFirstWeb.jsp").forward(request,
						response);
				return;
			}
			request.getRequestDispatcher("web/index.jsp").forward(request,
					response);
		}
	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取数据
		String userName = request.getParameter("iptNickName");
		String userPwd = request.getParameter("t_UserPass");
		String phone = request.getParameter("iptCard");
		// 生成用户对象
		// 注册用户为普通会员（权限为3），状态可用（1），注册时间是当前时间，登陆次数默认为0
		UserDetail userDetail = new UserDetail(userName, userPwd, phone, 3, 1,
				new Date());

		UserDetailService userDetailService = new UserDetailService();
		int result = userDetailService.register(userDetail);
		if (result == 0) {
			// 用户注册失败，跳回原来页面，并提示信息
			request.setAttribute("errorMsg", "用户注册失败，请重试！");
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		} else {
			// 用户注册成功，进入欢迎页面
			request.getRequestDispatcher("log.jsp").forward(request, response);
		}
	}

	/**
	 * 改变状态
	 * 
	 * @param request
	 * @param response
	 */
	private void changeStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			return;
		}
		int id = Integer.parseInt(idStr);
		UserDetailService userDetailService = new UserDetailService();
		userDetailService.changeStatus(id);
	}

	/**
	 * 更新用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从界面获取数据
		UserDetail userDetail = getUserDetail(request, response);
		if (userDetail == null) {
			return;
		}
		UserDetailService userDetailService = new UserDetailService();
		userDetailService.update(userDetail);
		// 添加后，跳转到用户列表页面
		list(request, response);
	}

	/**
	 * 编辑用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			return;
		}
		int id = Integer.parseInt(idStr);
		UserDetailService userDetailService = new UserDetailService();
		UserDetail userDetail = userDetailService.findById(id);
		request.setAttribute("userDetail", userDetail);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null && "".equals(idStr)) {
			return;
		}
		int id = Integer.parseInt(idStr);
		UserDetailService userDetailService = new UserDetailService();
		userDetailService.delete(id);
		// 先删除数据，再更新页码
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute("pageBean");
		if (pageBean != null) {
			int count = userDetailService.count();
			pageBean.setPageCount(count);
			session.setAttribute("pageBean", pageBean);
		}

		list(request, response);

	}

	/**
	 * 多条件查询
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String power = request.getParameter("power");
		String status = request.getParameter("status");
		String startTimeStr = request.getParameter("startTime");
		String endTimeStr = request.getParameter("endTime");

		UserDetailService userDetailService = new UserDetailService();
		UserDetail userDetail = new UserDetail(userName, phone,
				Integer.parseInt(power), Integer.parseInt(status),
				DateUtil.string2DateNull(startTimeStr),
				DateUtil.string2DateNull(endTimeStr));
		List<UserDetail> userList = userDetailService.search(userDetail);
		request.setAttribute("userDetail", userDetail);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("listUser.jsp").forward(request, response);
	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从界面获取数据
		UserDetail userDetail = getUserDetail(request, response);
		if (userDetail == null) {
			return;
		}
		UserDetailService userDetailService = new UserDetailService();
		userDetailService.register(userDetail);

		// 先添加数据，再更新页码
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute("pageBean");
		if (pageBean != null) {
			int count = userDetailService.count();
			pageBean.setPageCount(count);
			session.setAttribute("pageBean", pageBean);
		}

		// 添加后，跳转到用户列表页面
		list(request, response);
	}

	/**
	 * 从界面获取数据,方便用户获得数据（保存用户和修改用户时使用）
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public UserDetail getUserDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserDetail userDetail = null;
		// 从界面获取数据
		String idStr = request.getParameter("id");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userRePwd = request.getParameter("userRePwd");
		if (userPwd == null) {
			// 第一种方式
			// request.setAttribute("userPwdMsg", "密码不能为空");
			// request.getRequestDispatcher("addUser.jsp").forward(request,response);
			// 第二种方式
			out.write("<script>alert('密码不能为空');history.back();</script>");
			return null;
		} else if (!userPwd.equals(userRePwd)) {
			// request.setAttribute("userPwdMsg", "密码和确认密码不一致");
			// request.getRequestDispatcher("addUser.jsp").forward(request,response);
			out.write("<script>alert('密码和确认密码不一致');history.back();</script>");
			return null;
		}
		String phone = request.getParameter("phone");
		String power = request.getParameter("power");
		String status = request.getParameter("status");
		String registerTime = request.getParameter("registerTime");
		int intStatus = 1;
		try {
			intStatus = Integer.parseInt(status);
		} catch (NumberFormatException e) {
		}
		int intPower = 3;
		try {
			intPower = Integer.parseInt(power);
		} catch (NumberFormatException e) {
		}

		if (idStr == null || "".equals(idStr)) {
			// 生成用户对象
			// 注册用户为普通会员（权限为3），状态可用（1），注册时间是当前时间，登陆次数默认为0
			userDetail = new UserDetail(userName, userPwd, phone, intPower,
					intStatus, DateUtil.string2Date(registerTime));
		} else {
			int id = Integer.parseInt(idStr);
			userDetail = new UserDetail(id, userName, userPwd, phone, intPower,
					intStatus, DateUtil.string2Date(registerTime));
		}
		return userDetail;
	}

	/**
	 * 列表显示
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetailService userDetailService = new UserDetailService();
		// 查询所有的
		// List<UserDetail> userList = userDetailService.findAll();
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
			int count = userDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		// 分页查询
		List<UserDetail> userList = userDetailService.findByPage(pageNo,
				PageBean.pageSize);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("listUser.jsp").forward(request, response);

	}

}

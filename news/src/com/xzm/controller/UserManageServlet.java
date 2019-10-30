package com.xzm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzm.service.ICommentService;
import com.xzm.service.IUserService;
import com.xzm.service.impl.CommentServiceImpl;
import com.xzm.service.impl.UserServiceImpl;

public class UserManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String action = request.getParameter("action");
		if ("list".equals(action)) {
			String currentPageString = request.getParameter("page");
			int pageSize = 12;
			int currentPage;
			Map<String, Object> map = null;
			try {
				IUserService userService = new UserServiceImpl();
				if ("".equals(currentPageString) || null == currentPageString) {
					currentPage = 1;
				} else {
					currentPage = Integer.parseInt(currentPageString);
				}
				map = userService.list(pageSize, currentPage);
				request.setAttribute("map", map);
				request.getRequestDispatcher("/WEB-INF/background/user.jsp").forward(request,
						response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.sendRedirect("/WEB-INF/background/error.jsp");
			}
		}else if("delete".equals(action)){
			IUserService userService = new UserServiceImpl();
			String userName = request.getParameter("userName");
			try {
				if(true==userService.delete(userName)){
					response.sendRedirect("user?action=list&page=1");
				}else{
					response.sendRedirect("/WEB-INF/background/error.jsp");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace(); 
				response.sendRedirect("/WEB-INF/background/error.jsp");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

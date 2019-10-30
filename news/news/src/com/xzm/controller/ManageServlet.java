package com.xzm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xzm.model.Users;
import com.xzm.service.IUserService;
import com.xzm.service.impl.UserServiceImpl;

public class ManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute("userName");
		if ("gologin".equals(action)) {
			if(username!=null) {
				Boolean isRoot=(Boolean) session.getAttribute("IsRoot");
				if(isRoot==true) {
					request.getRequestDispatcher("/WEB-INF/background/manage.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/index").forward(request, response);
				}
			}else {
				request.getRequestDispatcher("/index").forward(request, response);				
			}
		}else if ("logout".equals(action)){
			session.invalidate();
			request.getRequestDispatcher("/index").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		IUserService userService = new UserServiceImpl();
		String action = request.getParameter("action");
		Users user = new Users();
		user.setUserName(userName);
		user.setUserPass(userPass);
		if ("login".equals(action)) {
			Users user_result = userService.getByName(user);
			if (user_result!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				session.setMaxInactiveInterval(60 * 15);
				if(user_result.getIsRoot().equals("true")) {
					session.setAttribute("IsRoot", true);
					request.getRequestDispatcher("/WEB-INF/background/manage.jsp").forward(request, response);
				}else {
					session.setAttribute("IsRoot", false);
					request.getRequestDispatcher("/index").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("/index").forward(request, response);
			}
		}else if ("register".equals(action)){
			if(userService.UserIsExist(userName)) {
				request.getRequestDispatcher("/index").forward(request, response);
			}else {
				int result=userService.add(user);
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				session.setMaxInactiveInterval(60 * 15);
				request.getRequestDispatcher("/index").forward(request, response);			
			}
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}

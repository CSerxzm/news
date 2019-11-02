package com.xzm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzm.model.Comment;
import com.xzm.service.ICommentService;
import com.xzm.service.impl.CommentServiceImpl;

public class CommentManageServlet extends HttpServlet {

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
			
			ICommentService commentService = new CommentServiceImpl();
			
			String currentPageString = request.getParameter("page");
			int pageSize = 12;
			int currentPage;
			Map<String, Object> map = null;
			try {
				if ("".equals(currentPageString) || null == currentPageString) {
					currentPage = 1;
				} else {
					currentPage = Integer.parseInt(currentPageString);
				}
				map = commentService.list(pageSize, currentPage);
				request.setAttribute("map", map);
				request.getRequestDispatcher("/WEB-INF/background/comment.jsp").forward(request,
						response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.sendRedirect("/WEB-INF/background/error.jsp");
			}
		}else if("delete".equals(action)){
			
			ICommentService commentService = new CommentServiceImpl();
			
			String commentIdString = request.getParameter("id");
			String commentNewsIdString = request.getParameter("newsId");
			try {
				int commentId = Integer.parseInt(commentIdString);
				int newsId =  Integer.parseInt(commentNewsIdString);
				if(true==commentService.delete(commentId,newsId)){
					response.sendRedirect("comment?action=list&page=1");
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
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

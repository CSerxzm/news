package com.xzm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xzm.model.Category;
import com.xzm.model.Comment;
import com.xzm.model.NewsDetails;
import com.xzm.model.NewsList;
import com.xzm.service.ICategoryService;
import com.xzm.service.ICommentService;
import com.xzm.service.INewsService;
import com.xzm.service.impl.CategoryServiceImpl;
import com.xzm.service.impl.CommentServiceImpl;
import com.xzm.service.impl.NewsServiceImpl;

public class NewsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String action = request.getParameter("action");

		ICategoryService categoryService = new CategoryServiceImpl();
		INewsService newsService = new NewsServiceImpl();
		ICommentService commentService = new CommentServiceImpl();

		if ("look".equals(action)) {
			String newsIdString = request.getParameter("id");
			try {
				Category[] categoryList = categoryService.list();
				request.setAttribute("categoryList", categoryList);
				int newsId = Integer.parseInt(newsIdString);
				NewsDetails newsDetails = null;
				newsDetails = newsService.find(newsId);
				if(null!=newsDetails){
					Comment[] commentLists = commentService.list(newsId);
					request.setAttribute("commentLists", commentLists);
					NewsList[] newsList = newsService.listHot();
					request.setAttribute("newsList", newsList);
					request.setAttribute("newsDetails", newsDetails);
					request.getRequestDispatcher("/WEB-INF/newsDetails.jsp").forward(request,
							response);
				}else{
					request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,
							response);
				}
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
				request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,
						response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String action = request.getParameter("action");
		if ("comment".equals(action)) {
			
			ICommentService commentService = new CommentServiceImpl();
			
			String newsIdString = request.getParameter("newsId");
			String commentContent =  new String(request.getParameter("commentContent").getBytes("ISO-8859-1"),"UTF-8");
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");
		
			if(userName==null) {
				userName="游客";
			}
			try {
				int newsId = Integer.parseInt(newsIdString);
				Comment comment = new Comment();
				comment.setCommentNewsId(newsId);
				comment.setCommentContent(commentContent);
				comment.setCommentUser(userName);
				if(true==commentService.add(comment)){
					response.sendRedirect("news?action=look&id="+newsId);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.sendRedirect("/WEB-INF/error.jsp");
			}
		}
	}

	public void init() throws ServletException {
	}

}

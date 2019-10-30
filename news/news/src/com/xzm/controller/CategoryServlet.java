package com.xzm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzm.model.Category;
import com.xzm.model.NewsList;
import com.xzm.service.ICategoryService;
import com.xzm.service.INewsService;
import com.xzm.service.impl.CategoryServiceImpl;
import com.xzm.service.impl.NewsServiceImpl;

public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String action = request.getParameter("action");
		
		ICategoryService categoryService = new CategoryServiceImpl();
		Category[] categoryList = categoryService.list();
		request.setAttribute("categoryList", categoryList);

		INewsService newsService = new NewsServiceImpl();
		if ("look".equals(action)) {
			String currentPageString = request.getParameter("page");
			String categoryIdString = request.getParameter("id");
			int pageSize = 18;
			int currentPage;
			int newsCategoryId;
			Map<String, Object> map = null;
			try {
				if ("".equals(currentPageString) || null == currentPageString) {
					currentPage = 1;
				} else {
					currentPage = Integer.parseInt(currentPageString);
				}
				newsCategoryId = Integer.parseInt(categoryIdString);
				//null为临时替换
				if(true==categoryService.find(newsCategoryId,null)){
					map = newsService.list(pageSize, currentPage, newsCategoryId);
					map.put("newsCategoryName", null);
					request.setAttribute("map", map);
					NewsList[] newsList = newsService.listHot();
					request.setAttribute("newsList", newsList);
					request.getRequestDispatcher("/WEB-INF/category.jsp").forward(request,
							response);
				}else{
					request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,
							response);
				}
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("error");
				request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,
						response);
			}

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

	}

	public void init() throws ServletException {
		// Put your code here
	}

}

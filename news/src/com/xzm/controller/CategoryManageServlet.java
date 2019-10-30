package com.xzm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzm.model.Category;
import com.xzm.model.News;
import com.xzm.service.ICategoryService;
import com.xzm.service.impl.CategoryServiceImpl;

public class CategoryManageServlet extends HttpServlet {

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
			ICategoryService categoryService = new CategoryServiceImpl();
			Category[] categoryList = categoryService.list();
			request.setAttribute("categoryList",categoryList);
			request.getRequestDispatcher("/WEB-INF/background/category.jsp").forward(request,
					response);
		}else if("goadd".equals(action)){
				request.getRequestDispatcher("/WEB-INF/background/addcategory.jsp").forward(request,
						response);
		}else if("goupdate".equals(action)){
			ICategoryService categoryService = new CategoryServiceImpl();
			String categoryIdString = request
					.getParameter("id");
			int categoryId ;
			try {
				categoryId = Integer.parseInt(categoryIdString);
				Category category = categoryService.find(categoryId);
				request.setAttribute("categoryList", category);
				request.getRequestDispatcher("/WEB-INF/background/updatecategory.jsp").forward(request,
						response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.sendRedirect("/WEB-INF/background/error.jsp");
			}
		}else if("delete".equals(action)){
			ICategoryService categoryService = new CategoryServiceImpl();
			String categoryIdString = request
					.getParameter("id");
			int categoryId ;
			try {
				categoryId = Integer.parseInt(categoryIdString);
				if(true==categoryService.delete(categoryId)){
					response.sendRedirect("category?action=list");
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
		String action = request.getParameter("action");
		if ("add".equals(action)) {
			ICategoryService categoryService = new CategoryServiceImpl();
			String categoryName = new String(request.getParameter("categoryName").getBytes("ISO-8859-1"),"UTF-8");
			String categoryPriorityString = request
					.getParameter("categoryPriority");
			int categoryPriority;
			try {
				categoryPriority = Integer.parseInt(categoryPriorityString);
				Category category = new Category();
				category.setCategoryName(categoryName);
				category.setCategoryPriority(categoryPriority);
				categoryService.add(category);
				response.sendRedirect("category?action=list");
			} catch (NumberFormatException e) {
				response.sendRedirect("/WEB-INF/background/error.jsp");
			}

		}else if("update".equals(action)){
			ICategoryService categoryService = new CategoryServiceImpl();
			String categoryName = new String(request.getParameter("categoryName").getBytes("ISO-8859-1"),"UTF-8");
			String categoryPriorityString = request
					.getParameter("categoryPriority");
			String categoryIdString = request
					.getParameter("categoryId");
			int categoryId;
			int categoryPriority;
			try {
				categoryId  = Integer.parseInt(categoryIdString);
				categoryPriority = Integer.parseInt(categoryPriorityString);
				Category category = new Category();
				category.setId(categoryId);
				category.setCategoryName(categoryName);
				category.setCategoryPriority(categoryPriority);
				if(true==categoryService.update(category)){
					response.sendRedirect("category?action=list");
				}
				else{
					response.sendRedirect("/WEB-INF/background/error.jsp");
				}
			} catch (NumberFormatException e) {
				response.sendRedirect("/WEB-INF/background/error.jsp");
			}
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

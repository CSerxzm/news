package com.xzm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xzm.model.Category;
import com.xzm.model.NewsList;
import com.xzm.model.NewsLists;
import com.xzm.model.PicNews;
import com.xzm.model.TopLineNews;
import com.xzm.service.ICategoryService;
import com.xzm.service.INewsService;
import com.xzm.service.impl.CategoryServiceImpl;
import com.xzm.service.impl.NewsServiceImpl;

public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		ICategoryService categoryService = new CategoryServiceImpl();
		INewsService newsService = new NewsServiceImpl();
		
		boolean newsIsPicture = true;
		List<PicNews> listPicNews = new ArrayList<PicNews>();
		listPicNews= newsService.listPic(newsIsPicture);
		
		boolean newsIsTopLine = true;
		TopLineNews topLineNews = new TopLineNews();
		topLineNews = newsService.getTopLine(newsIsTopLine);
		
		boolean newsIsHot = true;
		List<NewsList> listHotNews = new ArrayList<NewsList>();
		listHotNews = newsService.listHot(newsIsHot);

		Category[]  categoryList = categoryService.list();
		NewsLists[] newsLists = new NewsLists[categoryList.length];
		for (int i = 0; i < categoryList.length; i++) {
			newsLists[i]=new NewsLists(categoryList[i].getId(),categoryList[i].getCategoryName(),newsService.list(categoryList[i].getId()));
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("listPicNews", listPicNews);
		request.setAttribute("topLineNews", topLineNews);
		request.setAttribute("listHotNews", listHotNews);
		request.setAttribute("listNewsLists", newsLists);
		request.getRequestDispatcher("/WEB-INF/index1.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
	}

}

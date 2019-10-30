package com.xzm.service;

import java.util.List;
import java.util.Map;

import com.xzm.model.News;
import com.xzm.model.NewsDetails;
import com.xzm.model.NewsList;
import com.xzm.model.PicNews;
import com.xzm.model.TopLineNews;

public interface INewsService {
	int add(News news);
	NewsList[] list(int newsCategoryId);
	List<PicNews> listPic(boolean newsIsPicture);
	List<NewsList> listHot(boolean newsIsTopLine);
	TopLineNews getTopLine(boolean newsIsTopLine);
	NewsDetails find(int newsId);
	NewsList[] list();
	Map<String, Object> list(int pageSize,int currentPage,int newsCategoryId);
	Map<String, Object> list(int pageSize,int currentPage);
	boolean update(News news);
	boolean delete(int newsId);
	NewsList[] listHot();
	Map<String, Object>  search(int pageSize, int currentPage, int newsCategoryId,
			String newsTitle);
	Map<String, Object> search(int pageSize, int currentPage, String newsTitle);
}

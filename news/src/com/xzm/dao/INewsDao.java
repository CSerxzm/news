package com.xzm.dao;

import java.util.List;

import com.xzm.model.News;

public interface INewsDao {
	int save(News news);
	int delete(int newsId);
	News find(int newsId);
	int update(News news);
	List<News> list();
	List<News> list(int newsCategoryId);
	List<News> listPic(boolean newsIsPicture);
	List<News> listHot(boolean newsIsHot);
	News getTopLine(boolean newsIsTopLine);
	List<News> list( int startRecord,int pageSize,int newsCategoryId);
	List<News> list(int startRecord,int pageSize);
	int countRow(int newsCategoryId);
	int countRow();
	List<News> listHot();
	int countRow(int newsCategoryId, String newsTitle);
	int countRow(String newsTitle);
	List<News> list(int startRecord, int pageSize, int newsCategoryId,
			String newsTitle);
	List<News> list(int startRecord, int pageSize,
			String newsTitle);
	int changeCommentCount(int commentNewsId, String string);
	int changeHitCount(int newsId);
}

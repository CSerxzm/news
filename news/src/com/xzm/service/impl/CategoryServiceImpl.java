package com.xzm.service.impl;

import java.util.List;

import com.xzm.dao.ICategoryDao;
import com.xzm.dao.impl.CategoryDaoImpl;
import com.xzm.model.Category;
import com.xzm.model.NewsList;
import com.xzm.service.ICategoryService;
import com.xzm.service.INewsService;

public class CategoryServiceImpl implements ICategoryService {

	private static ICategoryDao categoryDao = new CategoryDaoImpl();
	private static INewsService newsService = new NewsServiceImpl();
	public boolean add(Category category) {
		int resultId;
		try {
			resultId = categoryDao.save(category);
			if(resultId <1 ){
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Category[] list() {
		List<Category> listCategory = null;
		listCategory = categoryDao.list();
		if(listCategory.size()>0){
			Category[] categoryList = new Category[listCategory.size()];
			for (int i = 0; i < listCategory.size(); i++) {
				categoryList[i]=new Category(listCategory.get(i).getId(),listCategory.get(i).getCategoryName(),listCategory.get(i).getCategoryPriority());
			}
			return categoryList;
		}
		return new Category[0];
	}

	public boolean update(Category category) {
		if(categoryDao.update(category)==1){
			return true;
		}
		return false;
	}

	public Category find(int categoryId) {
		return categoryDao.find(categoryId);
	}

	public boolean delete(int categoryId) {
		NewsList[] newsList = newsService.list(categoryId);
		for(int i =0;i<newsList.length;i++){
			if(false==newsService.delete(newsList[i].getNewsId())){
				return false;
			}
		}
		if(1==categoryDao.delete(categoryId)){
			return true;
		}
		return false;
	}
}

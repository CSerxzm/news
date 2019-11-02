package com.xzm.service;

import com.xzm.model.Category;


public interface ICategoryService {
	boolean add(Category category);
	Category[] list();
	boolean update(Category category);
	Category find(int categoryId);
	boolean delete(int categoryId);	
}

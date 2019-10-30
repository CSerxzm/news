package com.xzm.dao;

import java.util.List;

import com.xzm.model.Category;

public interface ICategoryDao {
	int save(Category category);
	int delete(int categoryId);
	Category find(int categoryId);
	int update(Category category);
	List<Category> list();
}

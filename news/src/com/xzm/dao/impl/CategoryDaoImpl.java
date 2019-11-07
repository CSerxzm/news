package com.xzm.dao.impl;

import java.util.List;

import com.xzm.dao.ICategoryDao;
import com.xzm.model.Category;

public class CategoryDaoImpl extends JDBCDaoSupport<Category> implements
		ICategoryDao {

	public int save(Category category) {
		String saveSql = "insert into t_category(categoryName,categoryPriority) values(?,?)";
		return super.executeInsert(saveSql, category.getCategoryName(),category.getCategoryPriority());
	}

	public int delete(int categoryId) {
		String deleteSql ="delete from t_category where id = ?";
		return super.executeUpdateAndDelete(deleteSql, categoryId);
	}

	public Category find(int categoryId) {
		String findSql = "select * from t_category where id =?";
		return super.executeGet(findSql, Category.class, categoryId);
	}//类名

	public int update(Category category) {
		String updateSql = "update t_category set categoryName=?,categoryPriority=? where id = ?";
		return super.executeUpdateAndDelete(updateSql, category.getCategoryName(),category.getCategoryPriority(),category.getId());
	}

	public List<Category> list() {
		String listSql = "select * from t_category order by categoryPriority";
		return super.executeList(listSql, Category.class);
	}

}

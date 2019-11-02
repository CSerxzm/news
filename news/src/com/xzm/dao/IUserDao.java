package com.xzm.dao;

import java.util.List;

import com.xzm.model.News;
import com.xzm.model.Users;

public interface IUserDao {
	int save(Users user);
	int delete(String userName);
	public int update(Users user);
	Users getByName(String userName);
	List<Users> list();
	int countRow();
	List<Users> list(int startRecord, int pageSize);
}

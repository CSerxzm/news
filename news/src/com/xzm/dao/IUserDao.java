package com.xzm.dao;

import java.util.List;

import com.xzm.model.News;
import com.xzm.model.Users;

public interface IUserDao {
	Users getByName(String userName);
	int save(Users user);//用于注册功能
	
	//后台功能
	int delete(String userName);
	List<Users> list();
	int countRow();
	List<Users> list(int startRecord, int pageSize);
	public int update(Users user);
}

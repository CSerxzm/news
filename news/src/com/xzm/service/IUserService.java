package com.xzm.service;

import java.util.Map;

import com.xzm.model.Comment;
import com.xzm.model.News;
import com.xzm.model.Users;

public interface IUserService {
	Users getByName(Users user);
	Boolean UserIsExist(String userName);
	int add(Users user);
	
	Map<String, Object> list(int pageSize, int currentPage);
	boolean delete(String userName);
}

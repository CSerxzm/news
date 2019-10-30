package com.xzm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xzm.dao.IUserDao;
import com.xzm.dao.impl.UserDaoImpl;
import com.xzm.model.Comment;
import com.xzm.model.Page;
import com.xzm.model.Users;
import com.xzm.service.IUserService;

public class UserServiceImpl implements IUserService {
	private static IUserDao userDao = new UserDaoImpl();
	public Users getByName(Users user) {
		Users userTemp = null;
		userTemp = userDao.getByName(user.getUserName());
		if(userTemp!=null && user.getUserPass().equals(userTemp.getUserPass())){
			return userTemp;
		}
		return null;
	}
	public Boolean UserIsExist(String userName) {
		Users userTemp = null;
		userTemp = userDao.getByName(userName);
		if(userTemp!=null) {
			return true;//已经存在
		}
		return false;
	}
	public int add(Users user) {
		return userDao.save(user);
	}
	
	//后台管理部分
	public Map<String, Object> list(int pageSize, int current) {
		Page pageBean = new Page();
		int allRecords = userDao.countRow();
		int totalPages = pageBean.calculateTotalPage(pageSize, allRecords);
		int currentPage = pageBean.judgeCurrentPageIsLegal(current, totalPages);
		if (currentPage == 0) {
			return null;
		}
		int startRecord = pageBean.calculateCurrentPageStartRecord(pageSize,
				currentPage);
		pageBean.init(allRecords, currentPage, pageSize, totalPages);
		List<Users> users = userDao.list(startRecord, pageSize);
		Users[] userList = new Users[users.size()];
		users.toArray(userList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userList", userList);
		map.put("pageBean", pageBean);
		return map;
	}
	
	public boolean delete(String userName) {
		if(userDao.delete(userName)==1) {
			return true;
		}else {
			return false;
		}
	}

}

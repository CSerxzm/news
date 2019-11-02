package com.xzm.dao.impl;

import java.util.List;

import com.xzm.dao.IUserDao;
import com.xzm.model.Comment;
import com.xzm.model.News;
import com.xzm.model.Users;

public class UserDaoImpl extends JDBCDaoSupport<Users> implements IUserDao {
	
	public int save(Users user) {
		String saveSql = "insert into t_user(userName,userPass) values(?,?)";
		return super.executeInsert(saveSql, user.getUserName(),
				user.getUserPass());
	}

	public int delete(String userName) {
		String deleteSql ="delete from t_user where userName = ?";
		return super.executeUpdateAndDelete(deleteSql, userName);
	}
	
	public Users getByName(String userName) {
		String getByNameSql = "select * from t_user where userName = ?";
		return super.executeGet(getByNameSql, Users.class, userName);
	}
	
	public int update(Users user) {
		String updateSql = "update t_user set userPass=?,isRoot=? where userName =?";
		return super.executeUpdateAndDelete(updateSql, user.getUserPass(),
				user.getIsRoot(),user.getUserName());
	}

	public List<Users> list() {
		String listSql = "select * from t_user";
		return super.executeList(listSql, Users.class);
	}
	
	public int countRow() {
		String getCountSql = "select count(*) from t_user";
		return super.getCountRow(getCountSql);
	}
	
	public List<Users> list(int startRecord, int pageSize) {
		String listSql = "select * from t_user  order by userName desc limit ?,?";
		return super.executeList(listSql,Users.class,startRecord,pageSize);
	}
}

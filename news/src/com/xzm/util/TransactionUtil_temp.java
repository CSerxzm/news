package com.xzm.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class TransactionUtil_temp {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static DataSource ds = DBUtil.getDataSource();


	public static Connection connection() {
		Connection conn = tl.get();
		if (conn == null) {
			try {
				conn = ds.getConnection();
				tl.set(conn); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void start() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = ds.getConnection();
				tl.set(conn);
			}
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback() {
		try {
			Connection conn = tl.get();
			if (conn != null) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void commit() {
		try {
			Connection conn = tl.get();
			if (conn != null){
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void release() {
		try {
			Connection conn = tl.get();
			if (conn != null) {
				conn.close();
				tl.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
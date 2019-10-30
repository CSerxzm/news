package com.xzm.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;


public class DBUtil {

	public static DataSource getDataSource() {
		DataSource ds = null;
		try {
			InputStream in = TransactionUtil.class.getClassLoader()
					.getResourceAsStream("db.properties");
			Properties props = new Properties();
			props.load(in);
			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}

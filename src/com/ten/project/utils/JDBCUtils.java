package com.ten.project.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JDBCUtils {
	
	static DataSource  dataSource;
	
	// 浼戞伅20鍒嗛挓
	static {
		// DriverManager 娉ㄥ唽椹卞姩
		try {
			//1 Properties
			Properties pro = new Properties();
			//2 鍔犺浇鍣�
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//3 load
			pro.load(is);
			dataSource = DruidDataSourceFactory.createDataSource(pro);
			
			
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/*
	 * 提供连接
	 */
	public static Connection getConnection() throws SQLException {
		return  dataSource.getConnection();
	}
	
	
	
	
}

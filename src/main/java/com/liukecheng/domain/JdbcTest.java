package com.liukecheng.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
	
	private static Connection connection; 
	
	private static ResultSet resultSet;
	
	private static PreparedStatement prepareStatement;
	public static void main(String[] args) {
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//传入协议地址和用户名口令，获取链接
			connection = DriverManager.getConnection("jdbc:", "root", "root");
			String querySQL = "";
			prepareStatement = connection.prepareStatement(querySQL);
			
			resultSet = prepareStatement.executeQuery();
			
			//遍历获取数据库数据
			while(resultSet.next()){
				String string = resultSet.getString(0);
				
			}
			
			//若是insert/delete/update操作,完成后要提交事务保存
			connection.commit();
		} catch (Exception e) {
			// 出异常后报错,回滚
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//最终是否怎么样都要关闭这3个对象
			try {
				if(resultSet!=null)resultSet.close();
				
				if(prepareStatement!=null)prepareStatement.close();
				
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}

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
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			
			//����Э���ַ���û��������ȡ����
			connection = DriverManager.getConnection("jdbc:", "root", "root");
			String querySQL = "";
			prepareStatement = connection.prepareStatement(querySQL);
			
			resultSet = prepareStatement.executeQuery();
			
			//������ȡ���ݿ�����
			while(resultSet.next()){
				String string = resultSet.getString(0);
				
			}
			
			//����insert/delete/update����,��ɺ�Ҫ�ύ���񱣴�
			connection.commit();
		} catch (Exception e) {
			// ���쳣�󱨴�,�ع�
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//�����Ƿ���ô����Ҫ�ر���3������
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

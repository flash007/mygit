package com.flash.db.mysql;
import java.sql.*;

public class TestMySQL {
	
	
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String user ="root";
		String pass = "root";
		
		try {
			Class.forName(driver);  //��������
			Connection conn = DriverManager.getConnection(url, user, pass); //�������ݿ�
			if(!conn.isClosed()){
				System.out.println("successed connecting to the Database!");
			}
			
			Statement statement = conn.createStatement(); //Statement ����ִ��sql���
			String sql = "select * from user";  //Ҫִ�е�sql���
			
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println("--------------------------------");
			System.out.println("ִ�н������:");
			
			int id= 0;
			String username=null;
			String password=null;
			
			while(rs.next()){
				id = rs.getInt("id");
				username=rs.getString("username");
				password = rs.getString("password");
				
				System.out.println("id:"+id+",username:"+username+",password:"+password);
			}
			rs.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("sorry, can't find the Driver!");
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}

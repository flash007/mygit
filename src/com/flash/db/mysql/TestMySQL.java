package com.flash.db.mysql;
import java.sql.*;

public class TestMySQL {
	
	
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String user ="root";
		String pass = "root";
		
		try {
			Class.forName(driver);  //加载驱动
			Connection conn = DriverManager.getConnection(url, user, pass); //链接数据库
			if(!conn.isClosed()){
				System.out.println("successed connecting to the Database!");
			}
			
			Statement statement = conn.createStatement(); //Statement 用来执行sql语句
			String sql = "select * from user";  //要执行的sql语句
			
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println("--------------------------------");
			System.out.println("执行结果如下:");
			
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

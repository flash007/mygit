package com.flash.db.mssqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLServer {

	public static void main(String[] args) {
		
		String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		String url = "jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=ees";
		String user ="sa";
		String pass = "";
		
		
		try {
			Class.forName(driver);  //加载驱动
			Connection conn = DriverManager.getConnection(url, user, pass); //链接数据库
			if(!conn.isClosed()){
				System.out.println("successed connecting to the Database!");
			}
			
			Statement statement = conn.createStatement(); //Statement 用来执行sql语句
			String sql = "select * from zd";  //要执行的sql语句
			
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println("--------------------------------");
			System.out.println("执行结果如下:");
			
			//int id= 0;
			//int level=0;
			
			String code=null;
			String value=null;
			//String memo=null;
			
			while(rs.next()){
				//id = rs.getInt("id");
				//level=rs.getInt("level");
				//memo = rs.getString("memo");
				code = rs.getString("code");
				value = rs.getString("value");
				
				//System.out.println("id:"+id+",level:"+level+",memo:"+memo);
				
				System.out.println("code:"+code+",value:"+value);
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

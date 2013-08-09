package com.flash.db.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestOracle {

	
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/oradata1";
		String user ="SYS as sysdba";
		String pass = "clk19870117";
		
		try {
			Class.forName(driver);  //��������
			Connection conn = DriverManager.getConnection(url, user, pass); //�������ݿ�
			if(!conn.isClosed()){
				System.out.println("successed connecting to the Database!");
			}
			
			Statement statement = conn.createStatement(); //Statement ����ִ��sql���
			String sql = "select * from CLK.TEST1";  //Ҫִ�е�sql���
			
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println("--------------------------------");
			System.out.println("ִ�н������:");
			
			int id= 0;
			//int level=0;
			
			//String code=null;
			//String value=null;
			//String memo=null;
			
			while(rs.next()){
				id = rs.getInt("id");
				//level=rs.getInt("level");
				//memo = rs.getString("memo");
				//code = rs.getString("code");
				//value = rs.getString("value");
				
				System.out.println("id:"+id); 
				
				//System.out.println("code:"+code+",value:"+value);
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

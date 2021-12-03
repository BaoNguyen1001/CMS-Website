package conn.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MysqlConnection {
	private static Connection conn = null;
	
	public MysqlConnection () {
		
	}
	
	public static Connection getConnection() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmsdb","root","root");   
		}
		catch(Exception e){
			System.out.println(e);
		}
		return conn;
	}	
	
	public static boolean testConnect() {
		Connection conn = getConnection();
		if (conn == null) return false;
		try {
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from member");  
			ResultSetMetaData rsmd = rs.getMetaData();
		    System.out.println("Total columns: " + rsmd.getColumnCount());
		    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
		      System.out.println(
		          "Column " + i + " [name: " + rsmd.getColumnName(i) + " - type: " + rsmd.getColumnTypeName(i) + "]");
		    }
			conn.close();  
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

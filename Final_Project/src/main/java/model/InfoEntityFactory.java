package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.InfoEntity;
import conn.web.MysqlConnection;

public class InfoEntityFactory {
	
	public static InfoEntity getInfoById(int id) {
		InfoEntity info = new InfoEntity();
		try{
			Connection conn = MysqlConnection.getConnection();
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from member where id = "+id);  
			while (rs.next()) {
				info.setId(rs.getInt(1));
				info.setFirstname(rs.getString(2));
				info.setLastname(rs.getString(3));
				info.setUsername(rs.getString(4));
				info.setPassword(rs.getString(5));
				info.setEmail(rs.getString(7));
				info.setPhone(rs.getString(6));
				info.setDescription(rs.getString(8));
				info.setCreatedDate(rs.getString(9));
				info.setUpdateTime(rs.getString(10));
			}
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	public static InfoEntity updateInfo(InfoEntity info) {
		try{
			Connection conn = MysqlConnection.getConnection();
			Statement stmt=conn.createStatement();  
			String sql = "UPDATE member   "
					+ "SET firstname = '" + info.getFirstname() + "', "
					+ "lastname = '" + info.getLastname() + "',     "
					+ "email = '" + info.getEmail() + "',     "
					+ "phone = '" + info.getPhone() + "',     "
					+ "description = '" + info.getDescription() + "'        "
					+ "WHERE id = '" + String.valueOf(info.getId()) + "';";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			//conn.commit(); // auto commit 
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

}
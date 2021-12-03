package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.InfoEntity;
import conn.web.MysqlConnection;

public class LoginDAO {
	private MysqlConnection db;
	
	private static final String CHECK_LOGIN = "SELECT COUNT(*) FROM member WHERE email = ? AND password = ?;";
	private static final String GET_ID_USER = "SELECT id FROM member WHERE email = ?";
	private static final String GET_FIRSTNAME = "SELECT firstname FROM member WHERE id = ?";
	
	
	public boolean checkLogin(String email, String password) {	
		
		try(Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(CHECK_LOGIN)) {
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int count = rs.getInt(1);
				if(count == 1)
					return true;
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public int getId(String email) {
			
			try(Connection conn = db.getConnection();
					PreparedStatement ps = conn.prepareStatement(GET_ID_USER)) {
				
				ps.setString(1, email);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int id = rs.getInt(1);
					return id;
				}
				
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			return -1;
	}
	
	public boolean loginFirstTime(int id) {
		try(Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_FIRSTNAME)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("firstname") == null) {
					return false;
				}
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
	
}

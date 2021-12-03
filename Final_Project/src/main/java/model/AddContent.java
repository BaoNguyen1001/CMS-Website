package model;

import java.sql.*;
import java.time.LocalDate;

import beans.Content;
import conn.web.MysqlConnection;

public class AddContent {
	
	public int Insert(Content ct) {
		MysqlConnection db = new MysqlConnection();
		Connection conn = db.getConnection();
		PreparedStatement ps= null;
		int result = 0;
		try {
			ps = conn.prepareStatement("INSERT INTO content(title, brief, content, authorid, createDate, updateTime) VALUES (?,?,?,?,?,?)");
			int i = 0;
			ps.setNString(++i, ct.getTitle());
			ps.setNString(++i, ct.getBrief());
			ps.setNString(++i, ct.getContent());
			ps.setInt(++i, ct.getAuthorid());
			ps.setNString(++i, ct.getCreateDateTime());
			ps.setNString(++i, ct.getUpdateDateTime());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
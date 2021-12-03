package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import beans.Content;
import conn.web.MysqlConnection;

public class ContentDAO {
	
	private MysqlConnection db;
	
	private static final String INSERT_CONTENT_SQL = "INSERT INTO content" + "(title, brief, content, createDate, updateTime, sort, authorid)"
			+"(?,?,?,?,?,?,?);";
	private static final String SELECT_CONTENT_BY_ID = "SELECT id, title, brief, content, updateTime FROM content WHERE id = ?;";
	private static final String SELECT_ALL_CONTENT_BY_AUTHORID = "SELECT * FROM content WHERE authorid = ? LIMIT ?, ?;";
	private static final String COUNT_CONTENT_BY_AUTHORID = "Select COUNT(*) as count from content where authorid = ?;";
	private static final String SEARCH_CONTENT_BY_TITLE ="SELECT * FROM content where title like ? and authorid = ? LIMIT ?, ?;";
	private static final String COUNT_SEARCH_CONTENT = "Select COUNT(*) as count from content where title like ? and authorid = ?;";
	

	private static final String UPDATE_CONTENT_SQL = "UPDATE content SET title =?, brief = ?, content =?,"
			+ "updateTime=? WHERE id =?;";
	private static final String DELETE_CONTENT_SQL = "DELETE FROM content WHERE id=?;";

	
	public ContentDAO() {
		db = new MysqlConnection();
	}

	public boolean updateContent(Content content) throws SQLException {
		boolean rowUpdate = false;
		try (Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(UPDATE_CONTENT_SQL)) {
			ps.setString(1, content.getTitle());
			ps.setString(2, content.getBrief());
			ps.setString(3, content.getContent());
			ps.setString(4, content.getUpdateDateTime());
			ps.setInt(5, content.getId());
			System.out.println(ps);
			rowUpdate = ps.executeUpdate() > 0;
		} catch(SQLException e) {
			printSQLException(e);
		}
		return rowUpdate;
	}
	
	public boolean deleteContent(int id) throws SQLException {
		boolean rowDelete = false;
		try (Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(DELETE_CONTENT_SQL)) {
			ps.setInt(1, id);
			System.out.println(ps);
			rowDelete = ps.executeUpdate() > 0;
		} catch(SQLException e) {
			printSQLException(e);
		}
		return rowDelete;
	}
	
	
	
	
	public void insertContent(Content content) throws SQLException{
		try (Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_CONTENT_SQL)) {
			ps.setString(1, content.getTitle());
			ps.setString(2, content.getBrief());
			ps.setString(3, content.getContent());
			ps.setString(4, content.getCreateDateTime());
			ps.setString(5, content.getUpdateDateTime());
			ps.setString(6, "0");
			ps.setInt(7, content.getAuthorid());
			ps.executeUpdate();
		}catch(SQLException e) {
			printSQLException(e);
		}
	}
	
	public Content selectContent(int id) throws SQLException{
		Content content = null;
		try (Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_CONTENT_BY_ID)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int setid = rs.getInt("id");
				String settitle = rs.getString("title");
				String setbrief = rs.getString("brief");
				String setcontent = rs.getString("content");
				content = new Content(setid, settitle, setbrief, setcontent);
			}
		} catch(SQLException e) {
			printSQLException(e);
		}
		return content;
	}
	
	public List<Content> selectAllContent(int authorid, int start, int limit) throws SQLException {
		List<Content> contents = new ArrayList<Content>();
		try (Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CONTENT_BY_AUTHORID)) {
			ps.setInt(1, authorid);
			ps.setInt(2, start);
			ps.setInt(3, limit);
			System.out.println(ps);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int setid = rs.getInt("id");
				String settitle = rs.getString("title");
				String setbrief = rs.getString("brief");
				String setcontent = rs.getString("content");
				String setcreateDateTime = rs.getString("createDate");
				String setupdateDateTime = rs.getString("updateTime");
				String setsort = rs.getString("sort");
				int setauthorid = rs.getInt("authorid");
				Content content = new Content(setid, settitle, setbrief, setcontent, setcreateDateTime,
						setupdateDateTime, setsort, setauthorid);
				contents.add(content);
			}
		} catch(SQLException e) {
			printSQLException(e);
		}
		return contents;
	}

	public int countContentByAuthorId(int authorid) throws SQLException {
		int count = 0;
		try(Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(COUNT_CONTENT_BY_AUTHORID)) {
			ps.setInt(1, authorid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("count");
			}
		}
		return count;
	}
	
	
	public List<Content> seachContentByTitle(String txtSearch, int authorid, int index, int limit) throws SQLException
	{
		List<Content> contents = new ArrayList<Content>();
		try(Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(SEARCH_CONTENT_BY_TITLE)) {
			ps.setString(1,"%"+txtSearch+"%");
			ps.setInt(2, authorid);
			ps.setInt(3, index);
			ps.setInt(4, limit);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				int setid = rs.getInt("id");
				String settitle = rs.getString("title");
				String setbrief = rs.getString("brief");
				String setcontent = rs.getString("content");
				String setcreateDateTime = rs.getString("createDate");
				String setupdateDateTime = rs.getString("updateTime");
				String setsort = rs.getString("sort");
				int setauthorid = rs.getInt("authorid");
				Content content = new Content(setid, settitle, setbrief, setcontent, setcreateDateTime,
						setupdateDateTime, setsort, setauthorid);
				contents.add(content);
			} 
		} catch(SQLException e) {
			printSQLException(e); 
		}
		return contents;
	}
	
	public int countSearchContent(String txtSearch, int authorid) throws SQLException {
		int count = 0;
		try(Connection conn = db.getConnection();
				PreparedStatement ps = conn.prepareStatement(COUNT_SEARCH_CONTENT)) {
			ps.setString(1,"%"+txtSearch+"%");
			ps.setInt(2, authorid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("count");
			}
		}
		return count;
	}
	
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
	
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Register;
import conn.web.MysqlConnection;

public class RegisterDAO {
	private static MysqlConnection db;
	private static final String FIND_USERNAME = "select COUNT(*) as count from member where username = ?";
	private static final String FIND_EMAIL = "select COUNT(*) as count from member where email = ? ";
	private static final String INSERT_REGISTER = "Insert into member(username, email,password) values (?,?,?)";
	
	
	public static boolean checkUsername(Register user){  
		boolean isValid = false;
          
        try {  
            Connection con = db.getConnection();
            PreparedStatement ps=con.prepareStatement(FIND_USERNAME);
            
            ps.setString(1, user.getUserName());
            
            ResultSet rs = ps.executeQuery();
           while(rs.next()) {
        	   if(rs.getInt("count") != 0)
        		   isValid = true;
           }
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return isValid;  
    }  
	public static boolean checkEmail(Register user){  
		boolean isValid = false;
          
        try{  
            Connection con= db.getConnection(); 
            PreparedStatement ps=con.prepareStatement(FIND_EMAIL);
            
            ps.setString(1, user.getEmail());
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	if(rs.getInt("count") != 0)
            		isValid = true;
            }
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return isValid;  
    }  
	
	public static boolean insertRegister(Register user) throws SQLException {
		Connection conn;
		boolean flag = false;
		try {
			conn = db.getConnection();
			
			PreparedStatement pstm = conn.prepareStatement(INSERT_REGISTER);

			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getPassword());
			
			flag = pstm.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return flag;

	}
}

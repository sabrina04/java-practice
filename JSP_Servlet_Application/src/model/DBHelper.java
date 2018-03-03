package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import user.User;

public class DBHelper {
	
	private ResultSet users = null;

	public List<User> getUsers(DataSource dataSource) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		List<User> userList = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			String query = "select * from users";
			users = stmt.executeQuery(query);
			
			while(users.next()) {
				User temp = new User(users.getInt("user_id"), users.getString("user_name"), users.getString("user_email"));
				userList.add(temp);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return userList;
		} finally{
			conn.close();
			stmt.close();
		}
		
		return userList;
	}

	public boolean addUser(User user, DataSource dataSource) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "insert into users (user_name,user_email) values (?,?)";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			return stmt.execute();
		} catch(Exception e){
			e.printStackTrace();
			return false;	
		} finally{
			conn.close();
			stmt.close();
		}
	}

	public User getUser(int user_id, DataSource dataSource) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	    User user = null;
	    try{
	    	conn = dataSource.getConnection();
	    	String Query = "select * from users where user_id=?";
	    	stmt = conn.prepareStatement(Query);
	    	stmt.setInt(1, user_id);
	    	rs = stmt.executeQuery();
	    	String name = null,email = null;
	    	if(rs.next()){
	    		name = rs.getString("user_name");
	    		email = rs.getString("user_email");
	    	}
	    	user = new User(user_id,name,email);
	    	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally{
				conn.close();
				stmt.close();
		    	rs.close();
	    }
	    return user;
	}
	
	public boolean updateUser(User user, DataSource dataSource) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;

	    try{
	    	conn = dataSource.getConnection();
	    	String Query = "update users set user_name=? , user_email=? where user_id=?";
	    	stmt = conn.prepareStatement(Query);
	    	stmt.setString(1, user.getName());
	    	stmt.setString(2, user.getEmail());
	    	stmt.setInt(3, user.getId());
	        return stmt.execute();
	    
	    }finally{
				conn.close();
				stmt.close();
	    }

	}
	
	public boolean deleteUser(int user_id, DataSource dataSource) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		 try{
			 conn = dataSource.getConnection();
			 String query = "delete from users where user_id=?";
			 stmt = conn.prepareStatement(query);
			 stmt.setInt(1, user_id);
			  return stmt.execute();
			 
		 }finally{
				conn.close();
				stmt.close();
		 }
		
	}

}

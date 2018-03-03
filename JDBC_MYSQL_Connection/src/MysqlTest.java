import java.io.*;
import java.sql.*;

public class MysqlTest {
	
	public static void main(String[] args) {
		Connection conn = null;
		String query = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Timestamp time = new Timestamp(00-00-00);
		BufferedWriter output = null;
		
		try {
			Class.forName("com.mysql.jdbc.driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		try {  // establish connection with mysql
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","mysql");
			
			// query to retrieve data
			query = "SELECT * FROM location WHERE timestamp>=? and timestamp<=?";
			stmt = conn.prepareStatement(query);
			stmt.setTimestamp(1, time.valueOf("2017-05-01 00:00:00"));
			stmt.setTimestamp(2, time.valueOf("2017-05-01 23:59:59"));
			rs = stmt.executeQuery();
			
			// create tmp directory if it does not exist then create file data.csv inside tmp directory
			File dir = new File("tmp");
			dir.mkdirs();
			File f = new File(dir + "/data.csv");
			output = new BufferedWriter(new FileWriter(f));
			
			// if record found, write it in the file
			while(rs.next()) {
				String temp = rs.getString(1) +"," + rs.getDouble(2) + "," + rs.getDouble(3) + "," + rs.getDouble(4) + "," + rs.getTimestamp(5)+"\n";
				output.write(temp);
			}
			
			// close database connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try { // close file
			if(output != null)
				output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	public static Database ref;
	private Connection connection;
	
	
	
	private Database(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Database getDatabase(){
		if(ref == null){
			ref = new Database();
		}
		return ref;
	}
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public Connection getConnection(boolean autoCommit){
		try {
			DriverManager.getConnection(DBProperties.HOSTNAME, DBProperties.USERNAME,
					 					DBProperties.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void query(String query) throws SQLException{
		PreparedStatement prep = null;
		ResultSet res = null;
		List<String> result  = new ArrayList<String>();
		try {
			prep = connection.prepareStatement(query);
			res = prep.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (res.next()){
			result.add(res.getString(1));
			
			
		}
	}
	
	public void insert(String data, String table){
		String q = "INSERT INTO '" +
		
	}
	
	
	
	
	
	
	

}

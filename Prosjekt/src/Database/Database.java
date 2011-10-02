package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	public static Database ref;
	private Connection con=null;
    public static final String HOSTNAME = "localhost";
    public static final String USERNAME = "root";
    public static final String DATABASE = "sigurlu_pizza";
    public static final String PASSWORD = "root";
	public static final String PORT = "3306";
	

	
	private Database() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/" + DATABASE + "?user="
                +  USERNAME
                + "&password="
                +  PASSWORD;
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Database getDatabase() throws SQLException{
		if(ref == null){
			ref = new Database();
		}
		return ref;
	}
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void insert(String query) throws SQLException{
		PreparedStatement sporring = con.prepareStatement(query);
		sporring.executeUpdate();
	}

	public ResultSet select(String query) throws SQLException{
		//PreparedStatement prep = null;
		//ResultSet result = null;
		String enavn;
		ResultSet rs = null;
		PreparedStatement sporring = con.prepareStatement(query);
		rs = sporring.executeQuery();

//		try {
//			prep = con.prepareStatement(query);
//			result = prep.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		while (result.next()){
//			result.add(result.getString(1));
//			
//			
//		}
		while(rs.next()){
			enavn = rs.getString("etternavn");
			System.out.println(enavn);
		}
		return rs;
	}
}

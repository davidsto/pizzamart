package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		
		Database db = Database.getDatabase();
		System.out.println("Database kobling er opprettet");
		Connection con = db.getConnection();

		
		System.out.println(db.getConnection());
		System.out.println(db.select("SELECT etternavn FROM ansatt"));
		db.insert("INSERT into ansatt (fornavn, etternavn, adresse, postnr, tlf) values('Per', 'Ludviksen', 'Høgskoloeringen 3', '7050','87654321') ");
		System.out.println(db.select("SELECT etternavn FROM ansatt"));

		con.close();

	}
	
	
	
	
}

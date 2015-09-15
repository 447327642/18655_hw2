package db_Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	//connect to mysql server
	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
		} catch (SQLException e) {
			System.out.println("getConnection exception");
		}
		return conn;
	}


}

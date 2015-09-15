package db_Util;

import java.sql.Connection;
import java.sql.Statement;

public class DBCreate {
	DBManager manager;
	Connection conn;

	public DBCreate() {
		/**
		 * create new database manager to connect when object is constructed
		 */
		manager = new DBManager();
		conn = manager.connect();
	}
	
	/**
	 * create 2 tables in database, publication and authorInfo
	 * publication store detailed info, AuthorInfo store author-publication one to one mapping. 
	 * Since there are co-authors, one article may appear multiple times with different author name 
	 */
	public void createTable() {
		try {
			Statement stmt = conn.createStatement();

			String sql1 = "DROP DATABASE IF EXISTS dblp;";
			String sql2 = "CREATE DATABASE dblp;";
			String sql3 = "USE dblp;";
			String createPubTable1 = "DROP TABLE IF EXISTS publication;";
			String createPubTable2 = "CREATE TABLE publication (id VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "title  VARCHAR(500) NOT NULL," + "author VARCHAR(500) NOT NULL," + "type VARCHAR(50) NOT NULL,"
					+ "editor VARCHAR(100) DEFAULT NULL," + "pages VARCHAR(50) DEFAULT NULL,"
					+ "year VARCHAR(50) DEFAULT NULL," + "volume VARCHAR(50) DEFAULT NULL,"
					+ "journal VARCHAR(500) DEFAULT NULL," + "number VARCHAR(50) DEFAULT NULL,"
					+ "url VARCHAR(500) DEFAULT NULL," + "ee VARCHAR(500) DEFAULT NULL,"
					+ "cdrom VARCHAR(100) DEFAULT NULL," + "publisher VARCHAR(100) DEFAULT NULL,"
					+ "booktitle VARCHAR(100) DEFAULT NULL," + "crossref VARCHAR(100) DEFAULT NULL,"
					+ "address VARCHAR(100) DEFAULT NULL," + "isbn VARCHAR(100) DEFAULT NULL,"
					+ "series VARCHAR(100) DEFAULT NULL," + "school VARCHAR(100) DEFAULT NULL,"
					+ "chapter VARCHAR(100) DEFAULT NULL);";
			String createTable3 = "DROP TABLE IF EXISTS authorInfo;";
			String createTable4 = "CREATE TABLE authorInfo (id VARCHAR(100) NOT NULL, name VARCHAR(100) NOT NULL);";
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			stmt.addBatch(createPubTable1);
			stmt.addBatch(createPubTable2);
			stmt.executeBatch();
			stmt.executeUpdate(createTable3);
			stmt.executeUpdate(createTable4);
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
		}
	}
}

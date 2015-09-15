package db_Util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import xml_parse.Author;
import xml_parse.Publication;

public class DBInsert {
	// Store publication and author list into Mysql database
	DBManager manager;
	Connection conn;

	public DBInsert() {
		/**
		 * create new database manager to connect when object is constructed
		 */
		manager = new DBManager();
		conn = manager.connect();

	}
	/**
	 * insert publicatin info in pubList to Database
	 * @param pubList
	 * @throws Exception
	 */

	public void insertPub(List<Publication> pubList) throws Exception {

		Statement stmt = conn.createStatement();
		String useDB = "USE dblp;";
		stmt.executeUpdate(useDB);
		// insert publication
		for (int m = 0; m < pubList.size(); m++) {
			String temp = "";
			Publication pub = pubList.get(m);
			if (pub.getAuthor().size() > 1) {
				for (String s : pub.getAuthor()) {
					temp = temp.concat(s + ",");
				}
				temp = temp.substring(0, temp.length() - 1);
			} else {
				temp = pub.getAuthor().get(0);
			}

			String sql = "INSERT INTO publication (id,title,author,type,editor,pages,year,volume,journal,number,url,ee,cdrom,publisher,booktitle,crossref,address,isbn,series,school,chapter)"
					// escape double quotes in title
					+ "VALUES(\"" + pub.getKey() + "\"," + "\"" + pub.getTitle().replace("\"", "\\\"") + "\"," 
					+ "\"" + temp + "\"," + "\"" + pub.getType() + "\"," + "\"" + pub.getEditor() + "\"," + "\""
					+ pub.getPages() + "\"," + "\"" + pub.getYear() + "\"," + "\"" + pub.getVolume() + "\"," + "\""
					+ pub.getJournal() + "\"," + "\"" + pub.getNumber() + "\"," + "\"" + pub.getUrl() + "\"," + "\""
					+ pub.getEe() + "\"," + "\"" + pub.getCdrom() + "\"," + "\"" + pub.getPublisher() + "\"," + "\""
					+ pub.getBooktitle() + "\"," + "\"" + pub.getCrossref() + "\"," + "\"" + pub.getAddress() + "\","
					+ "\"" + pub.getIsbn() + "\"," + "\"" + pub.getSeries() + "\"," + "\"" + pub.getSchool() + "\","
					+ "\"" + pub.getChapter() + "\");";
			
			// System.out.println(sql);
			stmt.executeUpdate(sql);

		}

		if (stmt != null) {
			stmt.close();
		}
	}

	/**
	 * insert author into database
	 * @param authorList
	 * @throws Exception
	 */

	public void insertAuth(List<Author> authorList) throws Exception {
		Statement stmt = conn.createStatement();
		String useDB = "USE dblp;";
		stmt.executeUpdate(useDB);
		for (int m = 0; m < authorList.size(); m++) {
			String sql = "INSERT INTO authorInfo (name,id) VALUES(\"" + authorList.get(m).getAuthor() + "\",\""
					+ authorList.get(m).getPubKey() + "\");";
			stmt.executeUpdate(sql);
		}
		if (stmt != null) {
			stmt.close();
		}
	}

}

package driver;

import db_Util.DBQuery;
import xml_parse.XMLParser;
import xml_process.XML_Process;

public class TestCase {

	public static void main(String[] args) {

		// process xml to take 1000 records
		XML_Process process = new XML_Process();
		process.process_xml();

		// parse records into java object, store them in database
		XMLParser parser = new XMLParser();
		parser.parse_xml();

		// test cases, try to query from Database
		try {
			DBQuery query = new DBQuery();
			System.out.println(query.findCoAuthor("Peter Deussen"));
			System.out.println(query.findCoAuthor("Fake Name"));
			System.out.println(query.findPaper("On the Power of Chain Rules in Context Free Grammars."));
			System.out.println(query.findAuthorRecord("Symeon Bozapalidis"));
			System.out.println(query.findKeyword("Power,Parallel Computing"));
			System.out.println(query.findTwoAuthors("Elizabeth Scott", "Adrian Johnstone"));
			System.out.println(query.findTwoAuthors("Elizabeth Scott", "Fake Name"));
			System.out.println(query.findTwoAuthors("Elizabeth Scott", "Peter Deussen"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

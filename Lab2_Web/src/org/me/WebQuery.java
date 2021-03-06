package org.me;

import javax.jws.WebService;
import db_Util.DBQuery;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService()
public class WebQuery {

		//using functions in DBQuery in db_Util package to retrieve info from database
		@WebMethod(action = "webCoAuthor")
		public String webCoAuthor(@WebParam(name = "name") String name) {
			// implement the web service operation here
			try{
				DBQuery query = new DBQuery();
				return query.findCoAuthor(name);
			}catch(Exception e){
				
			}
			return "Error reading database";
		}

		
		@WebMethod(action = "webAuthorRecord")
		public String webAuthorRecord(@WebParam(name = "name") String name) {
			// implement the web service operation here
			try{
				DBQuery query = new DBQuery();
				return query.findAuthorRecord(name);
			}catch(Exception e){
				
			}
			return "Error reading database";
		}
		
		@WebMethod(action = "webPaper")
		public String webPaper(@WebParam(name = "title") String title) {
			// implement the web service operation here
			try{
				DBQuery query = new DBQuery();
				return query.findPaper(title);
			}catch(Exception e){
				
			}
			return "Error reading database";
		}
		
		@WebMethod(action = "webKeyword")
		public String webKeyword(@WebParam(name = "keyword") String keyword) {
			// implement the web service operation here
			try{
				DBQuery query = new DBQuery();
				return query.findKeyword(keyword);
			}catch(Exception e){
				
			}
			return "Error reading database";
		}
		
		@WebMethod(action = "webTwoAuthor")
		public String webTwoAuthor(@WebParam(name = "name1") String name1,@WebParam(name = "name2") String name2) {
			// implement the web service operation here
			try{
				DBQuery query = new DBQuery();
				return query.findTwoAuthors(name1,name2);
			}catch(Exception e){
				
			}
			return "Error reading database";
		}

		
	

}

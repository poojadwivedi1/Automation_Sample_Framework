package com.crm.autodesk.GenericUtility;


import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonfileUtility {
	/**
	 * this method read the dat from json file
	 * @throws Throwable 
	 * @throws ParseException 
	 * @throws IOException 
	 * 
	 */

		
	
public String readDataFromJSON(String key) throws Throwable 
{
//read the data from json file
	FileReader file= new FileReader("C:\\D-drive\\Automation-workspace\\seleniumproject_maven-bck\\src\\main\\resources\\commondata.json");

	//convert the json file into java object
	JSONParser jsonobj=new JSONParser();
	Object jobj=jsonobj.parse(file);
	//upcasting java oj to hashmap
	HashMap map = (HashMap)jobj;
	String value=map.get(key).toString();
	//return the value
	return value;
	
}
}

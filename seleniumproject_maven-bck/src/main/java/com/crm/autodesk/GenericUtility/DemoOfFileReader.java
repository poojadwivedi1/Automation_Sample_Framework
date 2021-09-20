package com.crm.autodesk.GenericUtility;

public class DemoOfFileReader {
	public static void main(String[] args) throws Throwable {
		JsonfileUtility jsonLib=new JsonfileUtility();
		JavaUtility jLib=new JavaUtility();
		String val=jsonLib.readDataFromJSON("url");
		System.out.println(val);
		System.out.println(jLib.getRandomNum());
		
	}

}

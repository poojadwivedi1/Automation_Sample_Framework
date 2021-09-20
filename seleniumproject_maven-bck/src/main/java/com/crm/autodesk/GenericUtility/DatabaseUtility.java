package com.crm.autodesk.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 *    
 * @author pooja
 *
 */

public class DatabaseUtility {
	Connection con=null;
	ResultSet result=null;
	Driver driverRef;
	/**
	 * Connection with database is established
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");
	}
	/**
	 * DB connection is closed
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable 
	{
		con.close();
	}
	public String getDataFromDB(String query,int columnindex) throws Throwable
	{
		String value=null;
		ResultSet result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			value=result.getString(columnindex);
		}
		return value;
	}
	/**
	 * get data from DB and verify
	 * @param Query
	 * @paramcolumnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String getDataFromDB(String query,int columnName,String expData) throws SQLException
	{
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnName).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data varified in database");
			return expData;
		}
		else
		{
			System.out.println(expData + "data not varified");
			return expData;
		}
	}

}

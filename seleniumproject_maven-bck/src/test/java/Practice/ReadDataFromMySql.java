package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ReadDataFromMySql {
public static void main(String[] args) throws Throwable {
	Driver driverref=new Driver();
	DriverManager.deregisterDriver(driverref);
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	Statement stat=con.createStatement();
	String query="Select * from students_info";
	ResultSet result=stat.executeQuery(query);
	while(result.next()) {
		System.out.println(result.getInt(1)+"\t"+result.getString(3)+"\t"+result.getString(4));
	}
	con.close();
}
}

package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromMySql_nonSelect {
	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		DriverManager.deregisterDriver(driverref);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		Statement stat=con.createStatement();
		String query="insert into students_info(regno,firstname,middlename,lastname)values('6','jam','gowda','hasan')";
		int result=stat.executeUpdate(query);
		if(result==1) {
			System.out.println("User is created");
			}else {
				System.out.println("User is not created");
			}
		con.close();
	}

}


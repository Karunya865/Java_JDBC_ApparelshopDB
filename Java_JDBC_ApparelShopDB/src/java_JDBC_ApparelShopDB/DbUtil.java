package java_JDBC_ApparelShopDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public Connection getDBConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","");	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}

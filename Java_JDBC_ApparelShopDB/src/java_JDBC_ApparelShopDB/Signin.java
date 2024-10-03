package java_JDBC_ApparelShopDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Signin {
	Connection con;
	DbUtil db=new DbUtil();
	String qry=null;
	Statement stmt;
	ResultSet rs;
    public Boolean signin(UserDetails u)
    {
    	boolean sts=false;
		 int count=0;
		 try
		 {
			 con=db.getDBConnection();
			 stmt=con.createStatement();
			 count =stmt.executeUpdate("insert into userdetails(name,password) values('"+u.getName()+"','"+u.getPwd()+"')");
			 if(count==1)
				 sts=true;
			 else
				 throw new Exception();
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		return sts;
    }
}

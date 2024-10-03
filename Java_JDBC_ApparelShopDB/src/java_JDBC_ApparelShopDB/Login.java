package java_JDBC_ApparelShopDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Login {
	Connection con;
	DbUtil db=new DbUtil();
	String qry=null;
	Statement stmt;
	ResultSet rs;
	 public Boolean admin(UserDetails u)
     {
    	 if(u.getName().equals("Karu") && u.getPwd().equals("Karu@2005"))
    	 {
    		 return true;
    	 }
    	 else
    	 {
    		 return false;
    	 }
     }
	 public Boolean user(UserDetails u)
	 {
		 boolean sts=false;
		 int count=0;
		 try
		 {
			 con=db.getDBConnection();
			 stmt=con.createStatement();
			 rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM userdetails WHERE name = '" + u.getName() + "' AND password = '" + u.getPwd() + "'");
			 if (rs.next()) {
			        count = rs.getInt("count");

			        // Check the count value and handle accordingly
			        if (count > 0) 
			        {
			        	sts=true;
			            System.out.println("Logged in successfully"); 
			        }    
			       else 
			            throw new Exception();
			  }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		return sts;
	 }

}

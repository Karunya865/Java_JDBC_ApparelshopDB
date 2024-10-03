package java_JDBC_ApparelShopDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Inventory {
	List<Fashions> list=new ArrayList<>();
	Connection con;
	DbUtil db=new DbUtil();
	String qry=null;
	Statement stmt;
	ResultSet rs;
    /*public void add(Fashions f)
    {
   	 list.add(f);
    }*/
	public boolean add(Fashions f)
	{
		
		 boolean sts=false;
		 int count=0;
		 try
		 {
			 con=db.getDBConnection();
			 stmt=con.createStatement();
			 count =stmt.executeUpdate("insert into itemlist(id,name,size,price,color,quantity) values('"+f.getID()+"','"+f.getName()+"','"+f.getSize()+"',"+f.getPrice()+",'"+f.getColor()+"',"+f.getQuantity()+")");
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
    public Fashions search(String id) {
   	 for(Fashions f:list)
   	 {
   		 if(f.getID().equals(id))
   		 {
   			 return f;
   		 }
   			 
   	 }
   	 return null;
    }
    /*public Fashions update(String id,int price)
    {
   	 for(Fashions f:list)
   	 {
   		 if(f.getID().equals(id))
   		 {
   			 f.setPrice(price);
   			 System.out.println("Updated Sucessfully");
   			 return f;
   		 }
   			 
   	 }
   	 return null;
   	 
    }*/
    public boolean update(Fashions f,int c)
	 {
		 boolean sts=false;
		 int count=0;
		 try
		 {
			 con=db.getDBConnection();
			 stmt=con.createStatement();
			 switch(c)
			 {
		         case 1:
		        	 qry = "UPDATE itemlist set name='" + f.getName() + "' where id='" + f.getID()+"'";
		        	 break;
		         case 2:
		        	 qry="UPDATE itemlist set quantity='"+f.getQuantity()+"'where id='"+f.getID()+"'";
		        	 break;
		         case 3:
		        	 qry="UPDATE itemlist set price='"+f.getPrice()+"'where id='"+f.getID()+"'"; 
		        	 break;
			 }
			 count =stmt.executeUpdate(qry);
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
    /*public void remove(String id)
    {
   	 for(Fashions f:list)
   	 {
   		 if(f.getID().equals(id)) {
   			 list.remove(f);
   			 System.out.println("Removed Sucessfully");
   		 }
   	 }
    }*/
    public boolean remove(Fashions f)
	 {
		 boolean sts=false;
		 int count=0;
		 try
		 {
			 con=db.getDBConnection();
			 stmt=con.createStatement();
			 qry="delete from itemlist where id='"+f.getID()+"'";
			 count=stmt.executeUpdate(qry);
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
    /*public void show()
    {
   	 System.out.println(list);
    }*/
    public void show()
	{
		/*for(Book b:l)
		{
			System.out.println(b);
		}*/
		try
		{
			con=db.getDBConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from itemlist");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+rs.getString(5)+" "+rs.getInt(6));
		}
		catch (Exception e)
		{
			System.out.println(e);
			
		}
	}

}

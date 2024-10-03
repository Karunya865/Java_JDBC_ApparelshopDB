package java_JDBC_ApparelShopDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class SortByPrice {
	List<Fashions> fa = new ArrayList<>();
	Connection con;
	DbUtil db=new DbUtil();
	String qry=null;
	Statement stmt;
	public void Psort() {
    try {
    	con=db.getDBConnection();
		stmt=con.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT id, name, size, price, color, quantity FROM itemlist ORDER BY price ASC");
	    while (rs.next()) {
	        String id = rs.getString("id");
	        String name = rs.getString("name");
	        String size = rs.getString("size");
	        int price = rs.getInt("price");
	        String color = rs.getString("color");
	        int quantity = rs.getInt("quantity");

	        fa.add(new Fashions(id, name, size, price, color, quantity));

	    }
	    for (Fashions ele : fa) {
            System.out.println(ele);
        }
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
	}
}

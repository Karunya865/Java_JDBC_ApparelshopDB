package java_JDBC_ApparelShopDB;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
    	Scanner s=new Scanner(System.in);
    	Fashions f=new Fashions();
    	UserDetails u;
    	Inventory in=new Inventory();
    	int op;
    	String p;
        do
        {
          System.out.println("Welcome to Apparel ShopDB");	
          System.out.println("1.Login 2.Signin 3.Logout 4.Exit");	
          op=s.nextInt(); 
          if(op==1)
          {
        	  System.out.println("Enter the Name:");
        	  String n=s.next()+s.nextLine();
        	  String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=-_*]).{8,}$";
              while(true) 
              {
              	System.out.println("Enter Password:");
              	p = s.next()+s.nextLine(); 
              	try 
              	{
              		if (p.matches(regex))
              		{
              			break;
              		} 
              		else 
              		{
              			throw new InvalidPassword("Weak Password!Try again");
                      
              		}
              	} 
              	catch (InvalidPassword e) 
              	{
              
              		System.out.println(e.getMessage());
              	}
              }
        	  u=new UserDetails(n,p);
        	  Login l=new Login();        	  
        	  if(l.admin(u))
        	  {
        		  do {
    				  System.out.println("1.Add 2.Update 3.Remove 4.Show 5.Exit");
    				  System.out.println("Enter the option:");
    				  op=s.nextInt();
    				  switch(op)
    				  {
    				     case 1:
    				    	 System.out.println("Enter the Details:");
    				    	 f=new Fashions();
    				    	 System.out.println("Enter the Name:");
    				    	 String name=s.next()+s.nextLine();
    				    	 System.out.println("Enter the ID:");
    				    	 String id=s.next()+s.nextLine();
    				    	 System.out.println("Enter the Size:");
    				    	 String size=s.next()+s.nextLine();
    				    	 System.out.println("Enter the Price:");
    				    	 int price=(s.nextInt());
    				    	 System.out.println("Enter the Color:");
    				    	 String color=(s.next()+s.nextLine());
    				    	 System.out.println("Enter the Quantity:");
    				    	 int Quantity=(s.nextInt());
    				    	 boolean addsts=in.add(new Fashions(id,name,size,price,color,Quantity));
    							if (addsts)
    								System.out.println("Details Added to DB");
    							else
    								System.out.println("Details could not be added to DB");
    				    	 break;
    				     case 2:
    				    	 System.out.print("\nEnter the id:");
    				    	 String i=s.next()+s.nextLine();
    							f.setID(i);
    							System.out.println("1.Update Name\n2.Update Quantity\n3.Update Price");
    							System.out.println("Enter choice: ");
    							int c=s.nextInt();
    							switch(c)
    							{
    							case 1:
    								System.out.println("Enter Name: ");
    								name=s.next()+s.nextLine();
    								f.setName(name);
    								break;
    							case 2:
    								System.out.println("Enter Quantity: ");
    								Quantity=s.nextInt();
    								f.setQuantity(Quantity);
    								break;
    							case 3:
    								System.out.println("Enter Price: ");
    								price=s.nextInt();
    								f.setPrice(price);
    								break;
    							}
    							boolean updsts=in.update(f,c);
    							if(updsts)
    								System.out.println("Details Updated");
    							else
    								System.out.println("Details could not be updated");
    							break;
    				    	 /*in.update(id,pr);*/
    				     case 3:
    				    	 System.out.println("Enter the id:");
    				    	 id=s.next()+s.nextLine();
    				    	 f.setID(id);
    							boolean dltsts=in.remove(f);
    							if(dltsts)
    								System.out.println("Deleted Sucessfully");
    							else
    								System.out.println("Could not delets");
    				    	 /*in.remove(s.next()+s.nextLine());*/
    				    	 break;
    				     case 4:
    				    	 in.show();
    				    	 break;
    				  }
    			  }while(op!=5);
        	  }
        	  else
        	  {
        		  boolean usersts=l.user(u);
        		  if(usersts)
        		  {
        			  System.out.println("Logged in as User");
        			  int ch;
        			  do 
        			  {
        			      System.out.println("1.Show\n2.Sort by price\n3.Sort by Name\n4.exit");
        			      ch=s.nextInt();
        			      switch(ch)
        			      {
        			             case 1:
        			    	        in.show();
        			    	        break;
        			             case 2:
        			    	        SortByPrice psort=new SortByPrice();
        			    	        psort.Psort();	
        			    	        break;
        			             case 3:	
        			    	        SortByName nsort=new SortByName();
        			    	        nsort.Nsort();	
        			    	        break;
        			      }
        			  }while(ch!=4);  
        		  }
        		  else
        			  System.out.println("Invalid username/Password");
        	  }
          }
          else if(op==2)
          {
        	  System.out.println("Enter the Name:");
        	  String n=s.next()+s.nextLine();
        	  String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=-_]).{8,}$";
              while(true) 
              {
              	System.out.println("\nEnter Password:");
              	p = s.next()+s.nextLine(); 
              	try 
              	{
              		if (p.matches(regex))
              		{
              			break;
              		} 
              		else 
              		{
              			throw new InvalidPassword("Weak Password!try again");
                      
              		}
              	} 
              	catch (InvalidPassword e) 
              	{
              
              		System.out.println(e.getMessage());
              	}
              }
        	  u=new UserDetails(n,p);
        	  Signin si=new Signin();
        	  boolean siginsts=si.signin(u);
        	  if(siginsts)
        		  System.out.println("Signed in Successfully");
        	  else
        		  System.out.println("Unable to Sign in");
          }
          else if(op==3)
          {
        	  System.out.println("Logged out successfully");
          }
        }while(op!=4);
    	s.close();
    }
}

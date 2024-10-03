package java_JDBC_ApparelShopDB;

public class UserDetails {
	private String name;
	private String pwd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public UserDetails()
	{
		
	}
	public UserDetails(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

}

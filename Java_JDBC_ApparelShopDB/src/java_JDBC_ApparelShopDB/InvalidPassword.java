package java_JDBC_ApparelShopDB;

public class InvalidPassword extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public InvalidPassword(String msg) 
	{
		this.message=msg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}

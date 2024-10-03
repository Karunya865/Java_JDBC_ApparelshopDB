package java_JDBC_ApparelShopDB;

public class Fashions {
	private String ID;
    private String Name;
    private String size;
    private int price;
    private String color;
    private int quantity;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Fashions(String id,String name, String size, int price, String color, int qu) {
		super();
		Name = name;
		this.ID=id;
		this.size = size;
		this.price = price;
		this.color = color;
		this.quantity = qu;
	}
  public Fashions()
  {
  	
  }
	public String toString() {
		return "ID=" + ID + ", Name=" + Name + ", size=" + size + ", price=" + price + ", color=" + color
				+ ", Quantity=" + quantity + "";
	}

}

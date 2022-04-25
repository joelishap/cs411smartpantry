public class Item {
	private String name;
	private String brand;
	private double price;
	private int quantity;
	private String expireDate;
	// Attributes of Item from group meeting

	public Item(String n, String b, double p, int q, String e) {
		this.name = n;
		this.brand = b;
		this.price = p;
		this.quantity = q;
		this.expireDate = e;
	}
	// Constructor for Item given specifications

	public String getName() {
		return this.name;
	}
	// get the name of item

	public String getBrand() {
		return this.brand;
	}
	// get the brand of an item

	public int getQuantity() {
		return this.quantity;
	}
	// check quantity of given item

	public void addQuantity(int n) {
		this.quantity = this.quantity + n;
	}
	// method to add to existing item quantity

	public void removeQuantity(int n) {
		this.quantity = this.quantity - n;
	}
	// method to remove to existing item quantity

	public String getExpire() {
		return this.expireDate;
	}
	// method to check expiry date of item

	public String stringFormat() {
		String s = this.name + ", " + this.brand + ", " + this.price + ", " + this.quantity + ", " + this.expireDate;
		return s;
	}
	// create a string to add to the database

//I'm still not too sure what you guys wanted me to do so I outlined a constructor 
//and some very basic methods to check or add to an Item object

}

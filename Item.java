
//import packages to convert input String to Date object
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Item {

	// Attributes of Item
	private String name;
	private String brand;
	private double price;
	private int quantity;
	private LocalDate expireDate;
	String expire;

	// Constructor for Item given specifications
	public Item(String n, String b, double p, int q, String expire) {
		this.name = n;
		this.brand = b;
		this.price = p;
		this.quantity = q;
		this.expire = expire;
	}

	// Get the name of an item
	public String getName() {
		return this.name;
	}

	// Get the brand of an item
	public String getBrand() {
		return this.brand;
	}

	// Get the price of an item
	public double getPrice() {
		return this.price;
	}

	// Set the price of an item
	public void setPrice(double p) {
		this.price = p;
	}

	// Get the quantity of an item
	public int getQuantity() {
		return this.quantity;
	}

	// Method to add to an existing item quantity
	public void addQuantity(int n) {
		this.quantity = this.quantity + n;
	}

	// Method to subtract from an existing item quantity
	public void subtractQuantity(int n) {
		this.quantity = this.quantity - n;
	}

	// Get the expiration date of an item
	public LocalDate getExpire() {
		return this.expireDate;
	}

	// Helper to convert String expireDate into LocalDate object
	private LocalDate stringToDate(String expire) throws Exception {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(expire, dateFormat);
		return date;
	}

	// Helper method to find the number of days until expiration
	public long daysTillExpiration() {
		try {
			this.expireDate = stringToDate(this.expire);
		} catch (Exception e) {
			System.out.println("Issue with string to date converstion.");
		}
		LocalDate currentDate = LocalDate.now();
		return currentDate.until(this.expireDate, ChronoUnit.DAYS);
	}

	// Create a string representation of the item, to add to the database
	public String stringFormat() {
		long daysLeft = daysTillExpiration();
		String s = this.name + ", " + this.brand + ", " + this.price + ", " + this.quantity + ", " + this.expire + ", "
				+ daysLeft;
		return s;
	}

}
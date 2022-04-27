import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import packages to convert input string to Date object (for expire notification)


public class Item {
	private String name;
	private String brand;
	private double price;
	private int quantity;
	private LocalDate expireDate;
	// Attributes of Item from group meeting

	public Item(String n, String b, double p, int q, String expire) {
		this.name = n;
		this.brand = b;
		this.price = p;
		this.quantity = q;
        try{
            this.expireDate = stringToDate(expire);
        } catch(Exception e){
            System.out.println("issue with string to date converstion");
        }
		//try/catch to deal with exception thrown in stringToDate helper
	}
	// Constructor for Item given specifications

	private LocalDate stringToDate(String expire) throws Exception {  
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		LocalDate date = LocalDate.parse(expire, dateFormat);  
		return date;
	}  
	//helper to concert string expire date input from user into date object we can use
	//to calculate days till expiry

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

	public LocalDate getExpire() {
		return this.expireDate;
	}
	// method to check expiry date of item

	public String stringFormat() {
		String s = this.name + ", " + this.brand + ", " + this.price + ", " + this.quantity + ", " + this.expireDate;
		return s;
	}
	// create a string to add to the database

	//finds days till expiration date
	public int daysTillExperiation(){
		LocalDate currentDate = LocalDate.now();
		return currentDate.compareTo(this.expireDate);
	}

}
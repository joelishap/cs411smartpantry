import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ChronoUnit;
//import packages to convert input string to Date object (for expire notification)


public class Item {
	private String name;
	private String brand;
	private double price;
	private int quantity;
	private LocalDate expireDate;
	String expire;
	// Attributes of Item from group meeting

	public Item(String n, String b, double p, int q, String expire) {
		this.name = n;
		this.brand = b;
		this.price = p;
		this.quantity = q;
		this.expire = expire;
        
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
		String s = this.name + ", " + this.brand + ", " + this.price + ", " + this.quantity + ", " + this.expire;
		return s;
	}
	// create a string to add to the database

	//finds days till expiration date
	public long daysTillExperiation(){
		try{
            this.expireDate = stringToDate(this.expire);
        } catch(Exception e){
            System.out.println("issue with string to date converstion");
        }
		LocalDate currentDate = LocalDate.now();
		return currentDate.until(this.expireDate, ChronoUnit.DAYS);
	}

}
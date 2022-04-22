public class Item {
    private String name;        
    private String brand;
    private double price;
    private int quantity;
    private String expireDate;
    //Attributes of Item from group meeting

    public Item(String n, String b, double p, int q, String e){
        this.name = n;
        this.brand = b;
        this.price = p;
        this.quantity = q;
        this.expireDate = e;
    }
    //Constructor for Item given specifications

    public void add(int n){
        this.quantity = this.quantity + n;
    }
    //method to add to existing item quantity

    public String checkExpire(){
        return this.expireDate;
    }
    //method to check expiry date of item

    public int checkQuantity(){
        return this.quantity;
    }
    //check quantity of given item

//I'm still not too sure what you guys wanted me to do so I outlined a constructor 
//and some very basic methods to check or add to an Item object

}

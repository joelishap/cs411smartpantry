import java.io.IOException;

public class main {

	public static void main(String args[]) throws IOException {

		Pantry newPantry = new Pantry();

		Item newItem = new Item("Doritos", "a brand", 4.0, 4, "12/22/2022");
		Pantry.addItem(newItem);

		System.out.println(newItem.daysTillExperiation());
		// read in the inputs from user
		/*String action = args[0]; // add or remove item from pantry
		String item = args[1];
		String brand = args[2];
		double price = Double.valueOf(args[3]);
		int quantity = Integer.valueOf(args[4]);
		String expireDate = args[5];

		// create the item
		Item newItem = new Item(item, brand, price, quantity, expireDate);
		Pantry newPantry = new Pantry();

		if (action.equals("Add")) { // if the user wants to add an item to the pantry
			Pantry.addItem(newItem);

		} else { // if the user wants to remove an item from the pantry
			Pantry.removeItem(newItem);
		}

		System.out.println();

		// display all items in the pantry
		System.out.println("Item, Brand, Price, Quantity, Expiration Date");
		Pantry.printItems();

		// Update the database by creating a new file
		Pantry.newFile();*/

	}
}

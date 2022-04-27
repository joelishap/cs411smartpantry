import java.io.BufferedWriter;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pantry {
	static ArrayList<Item> items = new ArrayList<>();

	public Pantry() {

		// Read from db.txt to create the existing list of items
		try {
			File db = new File("db.txt");
			Scanner reader = new Scanner(db);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				String[] dataSplit = data.split(", ");

				// turn each line of the database into an item
				Item item = new Item(dataSplit[0], dataSplit[1], Double.valueOf(dataSplit[2]),
						Integer.valueOf(dataSplit[3]), dataSplit[4]);

				// add the item into the items arraylist
//				items.add(item);

				// String[0] is ItemName
				// String[1] is Brand
				// String[2] is Price (convert to double)
				// String[3] is quantity (convert to int)
				// String[4] is expiration (convert to Date class)
				// String[5] is DaysTillExperation (lowkey what if we just change this to a
				// method in Item)
				// construct an Item
				// check if this item with this expiration date exists in items
				// if not, add to items
				// if so, increase quantity
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error with db");
			e.printStackTrace();
		}
	}

	// Adds item to items
	public static void addItem(Item item) {

		if (item.getQuantity() != 0) {
			int index = checkItem(item);
			if (index != -1) {
				items.get(index).addQuantity(item.getQuantity());
				System.out.println("Item exists in the pantry, adding quantity");
			} else {
				items.add(item);
				System.out.println("Item does not exist in the pantry, adding item");
			}
		} else {
			System.out.println("Cannot add with a quantity of 0");
		}

	}

	// Removes item from items
	public static void removeItem(Item item) {

		if (item.getQuantity() != 0) {
			int index = checkItem(item);
			if (index != -1) {
				int temp = items.get(index).getQuantity() - item.getQuantity();
				if (temp == 0) {
					items.remove(index);
					System.out.println("All remaining item in pantry used, removing item");
				} else if (temp > 0) {
					items.get(index).removeQuantity(item.getQuantity());
					System.out.println("Removing some quantity of this item");
				} else {
					System.out.println("Not enough in pantry to remove, double check quantity again");
				}
			} else {
				System.out.println("Item does not exist in pantry");
			}
		} else {
			System.out.println("Cannot remove with a quantity of 0");
		}
	}

	// Helper method to check if an item exists
	// if the item exists, return the index of the item in items
	// if the item does not exist, return -1
	private static int checkItem(Item item) {

		for (int i = 0; i < items.size(); i++) {

			String listName = items.get(i).getName();
			String listBrand = items.get(i).getBrand();
			String itemName = item.getName();
			String itemBrand = item.getBrand();

			if ((listName.equals(itemName)) && (listBrand.equals(itemBrand))) {
				return i;
			}
		}
		return -1;
	}

	// Helper method to see if an item exists with a certain expiration date
	private void checkItemDate() {

	}

	// Print all the items in the pantry
	public static void printItems() {
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).stringFormat());
		}
	}

	// creates a new file, fill the file using the items in items arraylist, delete
	// the old database, rename the new file as the database
	public static void newFile() {
		try {
			File tempFile = new File("tempfile.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			for (int i = 0; i < items.size(); i++) {
				writer.write(items.get(i).stringFormat());
				writer.newLine();
			}
			writer.close();

			File db = new File("db.txt");
			db.delete();
			tempFile.renameTo(db);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    }
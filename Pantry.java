import java.io.BufferedWriter;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pantry {
	static ArrayList<Item> items = new ArrayList<>();

	// Create an existing list of items from db.txt
	public Pantry() {

		try {
			File db = new File("db.txt");
			Scanner reader = new Scanner(db);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				String[] dataSplit = data.split(", ");

				Item item = new Item(dataSplit[0], dataSplit[1], Double.valueOf(dataSplit[2]),
						Integer.valueOf(dataSplit[3]), dataSplit[4]);

				items.add(item);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error with db.");
			e.printStackTrace();
		}
	}

	// Add given item to items ArrayList
	public static void addItem(Item item) {

		if (item.getQuantity() != 0) {
			int index = checkItem(item);

			if (index != -1) {
				items.get(index).addQuantity(item.getQuantity());
				items.get(index).setPrice(item.getPrice());
				System.out.println("Item exists in the pantry, adding quantity.");

			} else {
				items.add(item);
				System.out.println("Item does not exist in the pantry, adding item.");
			}

		} else {
			System.out.println("Cannot add with a quantity of 0.");
		}

	}

	// Remove given item from items ArrayList
	public static void removeItem(Item item) {

		if (item.getQuantity() != 0) {
			int index = checkItem(item);
			if (index != -1) {
				int temp = items.get(index).getQuantity() - item.getQuantity();

				if (temp == 0) {
					items.remove(index);
					System.out.println("All remaining item in pantry used, removing item.");

				} else if (temp > 0) {
					items.get(index).subtractQuantity(item.getQuantity());
					System.out.println("Removing some quantity of this item.");

				} else {
					System.out.println("Not enough in pantry to remove, double check quantity again.");
				}

			} else {
				System.out.println("Item does not exist in pantry.");
			}

		} else {
			System.out.println("Cannot remove with a quantity of 0.");
		}
	}

	// Helper method to check if an item exists in the database
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

	// Print all the items in the pantry
	public static void printItems() {
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).stringFormat());
		}
	}

	// Creates a new db.txt file with the updated items ArrayList
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
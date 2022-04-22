import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; 

public class Pantry{
    Item[] items;

    public Pantry(){
        try {
            File db = new File("db.txt");
            Scanner reader = new Scanner(db);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                String[] dataSplit = data.split(", ");
                //String[0] is ItemName
                //String[1] is Brand
                //String[2] is Price (convert to double)
                //String[3] is quantity (convert to int)
                //String[4] is expiration (convert to Date class)
                //String[5] is DaysTillExperation (lowkey what if we just change this to a method in Item)
                //construct an Item
                //check if this item with this expiration date exists in items
                //if not, add to items
                //if so, increase quantity
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error with db");
            e.printStackTrace();
        }
    }
}
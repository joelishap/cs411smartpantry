import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GUI implements ActionListener {

//	private JFrame frame = new JFrame();

	private static JLabel actionLabel;
	private static JTextField actionText;
	private static JLabel itemLabel;
	private static JTextField itemText;
	private static JLabel brandLabel;
	private static JTextField brandText;
	private static JLabel priceLabel;
	private static JTextField priceText;
	private static JLabel quantityLabel;
	private static JTextField quantityText;
	private static JLabel expireDateLabel;
	private static JTextField expireDateText;
	private static JButton button;
	private static JTextPane textPane;
	private static JScrollPane sp;

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

		actionLabel = new JLabel("Action");
		actionLabel.setBounds(10, 20, 80, 25);
		panel.add(actionLabel);

		actionText = new JTextField(20);
		actionText.setBounds(100, 20, 165, 25);
		panel.add(actionText);

		itemLabel = new JLabel("Item Name");
		itemLabel.setBounds(10, 50, 80, 25);
		panel.add(itemLabel);

		itemText = new JTextField(20);
		itemText.setBounds(100, 50, 165, 25);
		panel.add(itemText);

		brandLabel = new JLabel("Item Brand");
		brandLabel.setBounds(10, 80, 80, 25);
		panel.add(brandLabel);

		brandText = new JTextField(20);
		brandText.setBounds(100, 80, 165, 25);
		panel.add(brandText);

		priceLabel = new JLabel("Item Price");
		priceLabel.setBounds(10, 110, 80, 25);
		panel.add(priceLabel);

		priceText = new JTextField(20);
		priceText.setBounds(100, 110, 165, 25);
		panel.add(priceText);

		quantityLabel = new JLabel("Item Quantity");
		quantityLabel.setBounds(10, 140, 80, 25);
		panel.add(quantityLabel);

		quantityText = new JTextField(20);
		quantityText.setBounds(100, 140, 165, 25);
		panel.add(quantityText);

		expireDateLabel = new JLabel("Item Expiration Date");
		expireDateLabel.setBounds(10, 170, 80, 25);
		panel.add(expireDateLabel);

		expireDateText = new JTextField(20);
		expireDateText.setBounds(100, 170, 165, 25);
		panel.add(expireDateText);

		button = new JButton("Enter");
		button.setBounds(10, 200, 80, 25);
		button.addActionListener(new GUI());
		panel.add(button);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = actionText.getText();
		String item = itemText.getText();
		String brand = brandText.getText();
		Double price = Double.valueOf(priceText.getText());
		Integer quantity = Integer.valueOf(quantityText.getText());
		String expireDate = expireDateText.getText();

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
		Pantry.newFile();

	}
}
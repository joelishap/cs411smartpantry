import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

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

	// Create the GUI for users to input information about an item
	public static void main(String[] args) {

		Pantry newPantry = new Pantry();

		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

		actionLabel = new JLabel("Action");
		actionLabel.setBounds(10, 20, 120, 25);
		panel.add(actionLabel);

		actionText = new JTextField(20);
		actionText.setBounds(140, 20, 165, 25);
		panel.add(actionText);

		itemLabel = new JLabel("Item Name");
		itemLabel.setBounds(10, 50, 120, 25);
		panel.add(itemLabel);

		itemText = new JTextField(20);
		itemText.setBounds(140, 50, 165, 25);
		panel.add(itemText);

		brandLabel = new JLabel("Item Brand");
		brandLabel.setBounds(10, 80, 120, 25);
		panel.add(brandLabel);

		brandText = new JTextField(20);
		brandText.setBounds(140, 80, 165, 25);
		panel.add(brandText);

		priceLabel = new JLabel("Item Price");
		priceLabel.setBounds(10, 110, 120, 25);
		panel.add(priceLabel);

		priceText = new JTextField(20);
		priceText.setBounds(140, 110, 165, 25);
		panel.add(priceText);

		quantityLabel = new JLabel("Item Quantity");
		quantityLabel.setBounds(10, 140, 120, 25);
		panel.add(quantityLabel);

		quantityText = new JTextField(20);
		quantityText.setBounds(140, 140, 165, 25);
		panel.add(quantityText);

		expireDateLabel = new JLabel("Item Expiration Date");
		expireDateLabel.setBounds(10, 170, 120, 25);
		panel.add(expireDateLabel);

		expireDateText = new JTextField(20);
		expireDateText.setBounds(140, 170, 165, 25);
		panel.add(expireDateText);

		button = new JButton("Enter");
		button.setBounds(10, 200, 80, 25);
		button.addActionListener(new GUI());
		panel.add(button);

		frame.setVisible(true);
	}

	@Override
	// When the user clicks on the "Enter" button, update the pantry as specified
	// and display the updated pantry
	public void actionPerformed(ActionEvent e) {
		String action = actionText.getText();
		String item = itemText.getText();
		String brand = brandText.getText();
		double price = Double.valueOf(priceText.getText());
		int quantity = Integer.valueOf(quantityText.getText());
		String expireDate = expireDateText.getText();

		Item newItem = new Item(item, brand, price, quantity, expireDate);

		if (action.equals("Add")) {
			Pantry.addItem(newItem);

		} else {
			Pantry.removeItem(newItem);
		}

		System.out.println("Item, Brand, Price, Quantity, Expiration Date, Days until Expiration Date");
		Pantry.printItems();

		Pantry.newFile();
		DisplayPantry.main(null);

	}
}
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class DisplayPantry extends JPanel {

	public DisplayPantry() {
		initialize();
	}

	// Create a frame for the pantry
	public static void showFrame() {
		JPanel panel = new DisplayPantry();
		panel.setOpaque(true);
		JFrame frame = new JFrame("Pantry");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	// Display the text from db.txt in the JTextArea
	private void initialize() {
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		try {
			textArea.read(new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/db.txt"))),
					null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setPreferredSize(new Dimension(500, 200));
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(DisplayPantry::showFrame);
	}
}
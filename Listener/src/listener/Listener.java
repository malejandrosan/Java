package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Listener extends JFrame implements ActionListener {

	static JFrame myFrame;
	static JLabel myLabel;
	static JTextField myTextField;
	static JButton myButton;

	public static void main(String[] args) {

		// Initialize elements
		myFrame = new JFrame("My Title");
		myLabel = new JLabel("This is my JLabel");
		myTextField = new JTextField();
		myButton = new JButton("Submit");

		// Create a listener by creating an instance of this class
		Listener myListener = new Listener();

		// Add listener to myButton
		myButton.addActionListener(myListener);

		// Create panel to store the elements
		JPanel myPanel = new JPanel();

		// Add elements to my panel
		myPanel.add(myLabel);
		myPanel.add(myTextField);
		myPanel.add(myButton);

		// Add panel to frame
		myFrame.add(myPanel);
		
		// Add size to frame
		myFrame.setSize(300, 300);
		
		myFrame.show();

	}

	// If action command received matches with "Submit"
	// Then I will get the text from text field and set it to my label
	// Afterwards, I will clear text field
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		if (s.equals("Submit")) {
			myLabel.setText(myTextField.getText());

			myTextField.setText(" ");
		}

	}

}

// Program will create a simple form that submits values enters and print them
// Form will request name and age 
package matthew.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Form extends JFrame implements ActionListener {

	static JTextField nameTextField;
	static JTextField ageTextField;

	public static void main(String[] args) {

		// Create GUI components
		JFrame myFrame = new JFrame("Personal information");
		JLabel nameLabel = new JLabel("First Name:");
		JLabel ageLabel = new JLabel("Age:");
		nameTextField = new JTextField(12);
		ageTextField = new JTextField(5);
		JButton myButton = new JButton("Submit");

		// Create a listener by instancing this class
		Form myListener = new Form();

		// Add listener to button
		myButton.addActionListener(myListener);

		// Create panel to add components
		JPanel myPanel = new JPanel();

		// Add components to panel
		myPanel.add(nameLabel);
		myPanel.add(nameTextField);
		myPanel.add(ageLabel);
		myPanel.add(ageTextField);
		myPanel.add(myButton);

		// Add panel to frame
		myFrame.add(myPanel);

		// COnfiguring Frame
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.show();
	}

	// When clicking submit it will print the data entered on console
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String name = nameTextField.getText();
		String age = ageTextField.getText();

		if (s.equals("Submit")) {
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);

			if (Integer.parseInt(ageTextField.getText()) > 17) {
				System.out.println("User can vote.");
			} else {
				System.out.println("User cannot vote.");
			}

		}

		// Clear Text Fields
		nameTextField.setText(" ");
		ageTextField.setText(" ");

	}

}

package restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField phoneTextField;
	private JTextField nametextField;

	/**
	 * Create the frame.
	 */
	public Customer() {
		setTitle("Contact Information");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(22, 36, 82, 14);
		contentPane.add(nameLabel);
		
		JLabel phoneLabel = new JLabel("Phone number:");
		phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneLabel.setBounds(22, 89, 85, 14);
		contentPane.add(phoneLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		addressLabel.setBounds(22, 140, 82, 14);
		contentPane.add(addressLabel);
		
		phoneTextField = new JTextField();
		phoneTextField.setHorizontalAlignment(SwingConstants.LEFT);
		phoneTextField.setBounds(146, 86, 168, 20);
		contentPane.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		nametextField = new JTextField();
		nametextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		nametextField.setHorizontalAlignment(SwingConstants.LEFT);
		nametextField.setColumns(10);
		nametextField.setBounds(146, 33, 168, 20);
		contentPane.add(nametextField);
		
		JTextArea addressTextArea = new JTextArea();
		addressTextArea.setWrapStyleWord(true);
		addressTextArea.setToolTipText("");
		addressTextArea.setRows(3);
		addressTextArea.setLineWrap(true);
		addressTextArea.setTabSize(2);
		addressTextArea.setBounds(146, 140, 168, 49);
		contentPane.add(addressTextArea);
		
		
		
		
		
		
		
		
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Name: "+nametextField.getText());
				System.out.println("Phone: "+phoneTextField.getText());
				System.out.println("Address: "+addressTextArea.getText());
				
			}
		});
		submitButton.setBounds(187, 213, 89, 23);
		contentPane.add(submitButton);
	}
	
	
	
	public String getName() {
		return "";
	}
	
	public void setName(String name) {
		
	}
	
	public String getPhone() {
		
		return "";
	}
	
	public void setPhone(String phone) {
		
	}
	
	public String getAddress() {
		
		return "";
	}
	
	public void setAddress(String address) {
		
	}
	
	
	

}

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	
	HashMap<String, String> loginInfoCopy = new HashMap<String, String>();
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("User ID:");
	JLabel userPasswordLabel = new JLabel("User Password:");
	JLabel messageLabel = new JLabel();
	
	public LoginPage(HashMap<String, String> loginInfoOriginal) {
		
		loginInfoCopy = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);//(horizontal,vertical,width,length)
		userPasswordLabel.setBounds(50,150,100,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(150,100,200,25);
		userPasswordField.setBounds(150,150,200,25);
		
		loginButton.setBounds(150,200,100,25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		resetButton.setBounds(250,200,100,25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
		}
		if(e.getSource()==loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(loginInfoCopy.containsKey(userID)) {
				if(loginInfoCopy.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login Successful");
					//frame.dispose();//To close the first login frame after second frame open.
					new WelcomePage(userID);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
		}
	}
}

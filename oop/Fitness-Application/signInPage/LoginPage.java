package signInPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import homePage.HomePage;

public class LoginPage implements ActionListener {
	
	String[] userInfoCopy = new String[7];//Another string array to copy original user data.
	String userID;
	
	JFrame loginFrame = new JFrame("User Login Page");
	JButton refreshButton = new JButton("Refresh");
	JButton loginButton = new JButton("Login"); 
	JButton registerButton = new JButton("Register");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("User ID :");
	JLabel userPasswordLabel = new JLabel("User Password :");
	JLabel userRegisterLabel = new JLabel("Create an Account");
	JLabel messageLabel = new JLabel();
	
	public LoginPage() {
		
		//userInfoCopy = userInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);//(horizontal,vertical,length,width)
		userIDLabel.setForeground(Color.white);
		userPasswordLabel.setBounds(50,150,100,25);
		userPasswordLabel.setForeground(Color.white);
		
		messageLabel.setBounds(125,300,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,20));
		
		userRegisterLabel.setBounds(195,230,200,25);
		userRegisterLabel.setFont(new Font("Consolas",Font.PLAIN,12));
		userRegisterLabel.setForeground(Color.white);
		
		userIDField.setBounds(150,100,200,25);
		userPasswordField.setBounds(150,150,200,25);
		
		loginButton.setBounds(150,200,100,25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		loginButton.setForeground(Color.green);
		loginButton.setBackground(Color.black);
		refreshButton.setBounds(250,200,100,25);
		refreshButton.addActionListener(this);
		refreshButton.setFocusable(false);
		refreshButton.setForeground(Color.green);
		refreshButton.setBackground(Color.black);
		registerButton.setBounds(200,250,100,25);
		registerButton.addActionListener(this);
		registerButton.setFocusable(false);
		registerButton.setForeground(Color.green);
		registerButton.setBackground(Color.black);
		
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(420,420);
		loginFrame.getContentPane().setBackground(new Color(0,76,153));
		loginFrame.setResizable(false);
		
		loginFrame.add(userIDLabel);
		loginFrame.add(userPasswordLabel);
		loginFrame.add(messageLabel);
		loginFrame.add(userRegisterLabel);
		loginFrame.add(userIDField);
		loginFrame.add(userPasswordField);
		loginFrame.add(loginButton);
		loginFrame.add(refreshButton);
		loginFrame.add(registerButton);
		
		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==refreshButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
		}
		if(e.getSource()==registerButton) {
			new RegisterPage();
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
			loginFrame.dispose();//To close the first login frame after second frame open.
		}
		if(e.getSource()==loginButton) {
			if(userIDField.getText().isEmpty() || String.valueOf(userPasswordField.getPassword()).isEmpty()) {
				messageLabel.setForeground(Color.yellow);
				messageLabel.setText("Enter ID and Password !");
			}
			else {
				userID = userIDField.getText();
				String userPassword = String.valueOf(userPasswordField.getPassword());
				PasswordandID passwordandID = new PasswordandID(userID);//Creating instance for PasswordandID class to reach user information.
				File userInfoFile = new File(userID+".txt");
				if(!userInfoFile.exists()) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Username not found !");
				}
				else {
					userInfoCopy = passwordandID.getUserInfo();
					if(userInfoCopy[0].equals(userID)) {
						if(userInfoCopy[1].equals(userPassword)) {
							messageLabel.setForeground(Color.green);
							messageLabel.setText("Login Successful !");
							new HomePage(userInfoCopy);//Sent user info to calculators through home page.
							loginFrame.dispose();//To close the first login frame after second frame open.
							//new welcomePage(userID);//Example to open another screen.
						}
						else {
							messageLabel.setForeground(Color.red);
							messageLabel.setText("Wrong Password !");
						}
					}
					else {
						messageLabel.setForeground(Color.red);
						messageLabel.setText("Username not found !");
					}
				}
			}
		}
	}
	
	//Getter function to reach user ID on another class.
		protected String getUserID() {
			return userID;
	}
	
}

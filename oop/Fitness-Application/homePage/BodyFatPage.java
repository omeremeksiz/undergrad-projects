package homePage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BodyFatPage implements ActionListener {
	
	JFrame bodyFatFrame = new JFrame("Body Fat Calculator");//Creates frame.
	
	int answer1 = 1;
	
	String[] userInfoCopy = new String[7];
	
	/*Text Field Declaration Start*/
	JTextField userNeckField = new JTextField();
	JTextField userWaistField = new JTextField();
	/*Text Field Declaration End*/
	
	/*Label Declaration Start*/
	JLabel userNeckLabel = new JLabel("Neck :");
	JLabel userWaistLabel = new JLabel("Waist :");
	/*Label Declaration End*/
	
	/*Hyperlink Button Declaration Start*/
	JButton linkButton = new JButton("Link");
	/*Hyperlink Button Declaration End*/
	
	/*Info Message Label Declaration Start*/
	JLabel infoLabel = new JLabel();
	/*Info Message Label Declaration End*/
	
	/*Button Declaration Start*/
	JButton calculateButton = new JButton("Calculate");
	JButton refreshButton = new JButton("Refresh");
	/*Button Declaration End*/
	
	/*Home Page Button Declaration Start*/
	JLabel homeButtonLabel = new JLabel("Return Home Page");
	JButton homeButton = new JButton("Home");
	/*Home Page Button Declaration End*/
	
	public BodyFatPage(String[] userInfoOriginal) {
		
		userInfoCopy = userInfoOriginal;
		
		/*Label Configuration Start*/
		userNeckLabel.setBounds(50,150,75,25);
		userNeckLabel.setForeground(Color.white);
		userWaistLabel.setBounds(50,200,75,25);
		userWaistLabel.setForeground(Color.white);
		/*Label Configuration End*/
		
		/*Text Field Configuration Start*/
		userNeckField.setBounds(150,150,200,25);
		userWaistField.setBounds(150,200,200,25);
		/*Text Field Configuration End*/
		
		/*Button Configuration Start*/
		calculateButton.setBounds(150,250,100,25);
		calculateButton.addActionListener(this);
		calculateButton.setFocusable(false);
		calculateButton.setForeground(Color.green);
		calculateButton.setBackground(Color.black);
		refreshButton.setBounds(250,250,100,25);
		refreshButton.addActionListener(this);
		refreshButton.setFocusable(false);
		refreshButton.setForeground(Color.green);
		refreshButton.setBackground(Color.black);
		/*Button Configuration End*/
		
		/*Welcome Text Label Start*/
        infoLabel.setText("<html>The Body Fat Calculator can be used to estimate your total body fat based on specific measurements.<br>"
        		+"<br>"
        		+"Please enter waist and neck circumference.<br>"
        		+ "Click on the link for how to measure.</html>");
        infoLabel.setFont(new Font("Consolas",Font.PLAIN,12));
        infoLabel.setForeground(Color.orange);
        infoLabel.setBounds(75, 10, 300, 90); 
        /*Welcome Text Label End*/
        
        /*Link Button Start*/
        linkButton.addActionListener(this);
        linkButton.setFocusable(false);
        linkButton.setBounds(150,110,100,25);
        linkButton.setForeground(Color.yellow);
        linkButton.setBackground(Color.black);
        linkButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        /*Link Button End*/
        
        /*Home Button Start*/
        homeButtonLabel.setBounds(150,330,200,25);
		homeButtonLabel.setFont(new Font("Consolas",Font.BOLD,12));
		homeButtonLabel.setForeground(Color.white);
		
		homeButton.setBounds(150,300,100,25);
		homeButton.addActionListener(this);
		homeButton.setFocusable(false);
		homeButton.setForeground(Color.green);
		homeButton.setBackground(Color.black);
        /*Home Button End*/
        
		bodyFatFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bodyFatFrame.setSize(420,420);
		bodyFatFrame.setLocationRelativeTo(null);//Set opening location of the frame center of the screen.
		bodyFatFrame.getContentPane().setBackground(new Color(0,76,153));
		
		bodyFatFrame.add(userNeckLabel);
		bodyFatFrame.add(userWaistLabel);
		bodyFatFrame.add(userNeckField);
		bodyFatFrame.add(userWaistField);
		bodyFatFrame.add(calculateButton);
		bodyFatFrame.add(refreshButton);
		bodyFatFrame.add(infoLabel);
		bodyFatFrame.add(linkButton);
		bodyFatFrame.add(homeButtonLabel);
		bodyFatFrame.add(homeButton);
		
		bodyFatFrame.setLayout(null);
		bodyFatFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==linkButton) {
			try {
				Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=t4LYqIxWHQQ").toURI());
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==refreshButton) {
			userNeckField.setText("");
			userWaistField.setText("");
		}
		if(e.getSource()==calculateButton) {
			if(userNeckField.getText().isEmpty() || userWaistField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please, fill the fields !", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
			else {
				/*User Informations Declaration Start*/
				int userNeck = Integer.parseInt(userNeckField.getText());
				int userWaist = Integer.parseInt(userWaistField.getText());
				int userHeight = Integer.parseInt(userInfoCopy[4]);
				String userSex = userInfoCopy[3];
				String text="";
				double result = 0;
				/*User Informations Declaration End*/
				
				/*Body Fat Calculation Algorithm Start*/
				if(userSex.equals("Male")) {
					result = (495/(1.0324-0.19077*(Math.log10(userWaist-userNeck))+0.15456*(Math.log10(userHeight))))-450;
					if(result>=2 && result<=5) {text = "Essential Fat & Dangerously Low ! ";}
					else if (result>=6 && result<=13) {text = "Athletes & Excelent ! ";}
					else if (result>=14 && result<=17) {text = "Fitness & Good ! ";}
					else if (result>=18 && result<=24) {text = "Avarage & Fair ! ";}
					else if(result >= 25){text = "Obese & Dangerously High ! ";}
					else {
						text = "Urgently Contact the Doctor ! ";
						result = 0;
					}
				}
				else {
					result = (495/(1.29579-0.35004*(Math.log10(104+userWaist-userNeck))+0.22100*(Math.log10(userHeight))))-450;
					if(result>=10 && result<=13) {text = "Essential Fat ,Dangerously Low ! ";}
					else if (result>=14 && result<=20) {text = "Athletes ,Excelent ! ";}
					else if (result>=21 && result<=24) {text = "Fitness ,Good ! ";}
					else if (result>=25 && result<=31) {text = "Avarage ,Fair ! ";}
					else if (result >= 32) {text = "Obese ,Dangerously High ! ";}
					else {
						text = "Urgently Contact the Doctor ! ";
						result = 0;
					}
				}
				result = Double.parseDouble(String.format("%.2f", result));//Specify precision of result.
				/*Body Fat Calculation Algorithm End*/
				
				JOptionPane.showMessageDialog(null, text + result , "Body Fat", JOptionPane.INFORMATION_MESSAGE);//Sent user a information message about their result.
			}
		}
		if(e.getSource() == homeButton) {
			answer1 = JOptionPane.showConfirmDialog(null, "Do you want to return Home Page ?","Return Home Page",JOptionPane.YES_NO_OPTION);
			if(answer1==0) {
				new HomePage(userInfoCopy);
				bodyFatFrame.dispose();
				}
		}
	}
}

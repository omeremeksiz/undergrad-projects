package homePage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import signInPage.RegisterPage;

public class BmiPage implements ActionListener {
	
	JFrame bmiFrame = new JFrame("BMI Calculator");//Creates frame.
	
	String[] userInfoCopy = new String[7];
	
	int answer = 1, answer1 = 1;
	
	/*Info Message Label Declaration Start*/
	JLabel infoLabel = new JLabel();
	/*Info Message Label Declaration End*/
	
	/*Result Message Label Declaration Start*/
	JLabel resultLabel = new JLabel();
	/*Result Message Label Declaration End*/
	
	/*Update Message Label Declaration Start*/
	JLabel updateLabel = new JLabel();
	/*Update Message Label Declaration End*/
	
	/*Button Declaration Start*/
	JButton updateButton = new JButton("Update");
	/*Button Declaration End*/
	
	/*Image Icon Declaration Start*/
	ImageIcon logoIcon = new ImageIcon("refresh24.png");
	JLabel iconLabel = new JLabel();
	/*Image Icon Declaration End*/
	
	/*Home Page Button Declaration Start*/
	JLabel homeButtonLabel = new JLabel("Return Home Page");
	JButton homeButton = new JButton("Home");
	/*Home Page Button Declaration End*/
	
	public BmiPage(String[] userInfoOriginal) {
		
		/*Get User Info From Login Page or Register Page Directly Start*/
		userInfoCopy = userInfoOriginal;
		/*Get User Info From Login Page or Register Page Directly Start*/
		
		/*BMI Calculation Algorithm Start*/
		double userWeight = Integer.parseInt(userInfoCopy[5]),userHeight = Integer.parseInt(userInfoCopy[4]);
		double result = userWeight/Math.pow((userHeight/100),2);
		result = Double.parseDouble(String.format("%.3f", result));//Specify precision of result.
		/*BMI Calculation Algorithm End*/
		
		/*Welcome Text Label Start*/
        infoLabel.setText("<html>The Body Mass Index (BMI) Calculator can be used to calculate BMI value and corresponding weight status while taking age into consideration.</html>");
        infoLabel.setFont(new Font("Consolas",Font.PLAIN,12));
        infoLabel.setForeground(Color.orange);
        infoLabel.setBounds(75, 20, 300, 75); 
        /*Welcome Text Label End*/
        
        /*Result Text Label Start*/
        resultLabel.setText("<html>The Body Mass Index : "
        		+ result +"</html>");
        resultLabel.setFont(new Font("Consolas",Font.BOLD,12));
        resultLabel.setForeground(Color.orange);
        resultLabel.setBounds(75, 80, 300, 50);//Add calorie and set horizontal 65 and set width 400.
        /*Result Text Label End*/
        
        /*Update Text Label Start*/
        updateLabel.setText("<html>If you want to update your information to calculate daily calories, press the button and update your information with your user ID and password.</html>");
        updateLabel.setFont(new Font("Consolas",Font.PLAIN,12));
        updateLabel.setForeground(Color.red);
        updateLabel.setBounds(75, 130, 300, 75); 
        /*Update Text Label End*/
        
        /*Update Button Start*/
        updateButton.setBounds(150,220,100,25);
		updateButton.addActionListener(this);
		updateButton.setFocusable(false);
		updateButton.setForeground(Color.yellow);
		updateButton.setBackground(Color.black);
        /*Update Button End*/
		
		/*Locating Icon Start*/
		iconLabel.setIcon(logoIcon);
		Dimension size = iconLabel.getPreferredSize(); //Gets the size of the image
        iconLabel.setBounds(188, 255, size.width, size.height); //Sets the location of the image
		/*Locating Icon End*/
        
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
		
		bmiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bmiFrame.setSize(420,420);
		bmiFrame.setLocationRelativeTo(null);//Set opening location of the frame center of the screen.
		bmiFrame.getContentPane().setBackground(new Color(0,76,153));
		bmiFrame.setResizable(false);
		
		bmiFrame.add(infoLabel);
		bmiFrame.add(resultLabel);
		bmiFrame.add(updateLabel);
		bmiFrame.add(updateButton);
		bmiFrame.add(iconLabel);
		bmiFrame.add(homeButton);
		bmiFrame.add(homeButtonLabel);
		
		bmiFrame.setLayout(null);
		bmiFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == updateButton) {
			answer = JOptionPane.showConfirmDialog(null, "Do you want to update your information ?","UPDATE",JOptionPane.YES_NO_CANCEL_OPTION);
			if(answer==0) {
				new RegisterPage();
				bmiFrame.dispose();//To close the calorie frame after second frame open.
			}
		}
		if(e.getSource() == homeButton) {
			answer1 = JOptionPane.showConfirmDialog(null, "Do you want to return Home Page ?","Return Home Page",JOptionPane.YES_NO_OPTION);
			if(answer1==JOptionPane.YES_OPTION) {
				new HomePage(userInfoCopy);
				bmiFrame.dispose();
				}
		}
	}
}

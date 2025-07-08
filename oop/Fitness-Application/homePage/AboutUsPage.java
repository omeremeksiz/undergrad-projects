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

public class AboutUsPage implements ActionListener {
	
	JFrame aboutFrame = new JFrame("About Us");
	
	String[] userInfoCopy = new String[7];
	
	int answer1 = 0;
	
	/*Info Message Label Declaration Start*/
	JLabel infoLabel = new JLabel();
	/*Info Message Label Declaration End*/
	
	/*Image Icon Declaration Start*/
	ImageIcon logoIcon = new ImageIcon("logo2.png");
	JLabel iconLabel = new JLabel();
	/*Image Icon Declaration End*/
	
	/*Text Title Label Declaration Start*/
	JLabel textTitleLabel = new JLabel();
	/*Text Title Label Declaration End*/
	
	/*Text Label Declaration Start*/
	JLabel textLabel = new JLabel();
	/*Text Label Declaration End*/
	
	/*Second Text Label Declaration Start*/
	JLabel textSecondLabel = new JLabel();
	/*Second Text Label Declaration End*/
	
	/*Home Page Button Declaration Start*/
	JLabel homeButtonLabel = new JLabel("Return Home Page");
	JButton homeButton = new JButton("Home");
	/*Home Page Button Declaration End*/
	
	public AboutUsPage(String[] userInfoOriginal) {
		
		/*Get User Info From Login Page or Register Page Directly Start*/
		userInfoCopy = userInfoOriginal;
		/*Get User Info From Login Page or Register Page Directly Start*/
		
		/*Welcome Text Label Start*/
        infoLabel.setText("<html>No mess, no fuss... welcome to your new home of healthy!</html>");
        infoLabel.setFont(new Font("Consolas",Font.BOLD,13));
        infoLabel.setForeground(Color.magenta);
        infoLabel.setBounds(45, 15, 420, 25); 
        /*Welcome Text Label End*/
        
        /*Locating Icon Start*/
		iconLabel.setIcon(logoIcon);
		Dimension size = iconLabel.getPreferredSize(); //Gets the size of the image
        iconLabel.setBounds(203, 53, size.width, size.height); //Sets the location of the image
		/*Locating Icon End*/
        
        /*Text Title Label Start*/
        textTitleLabel.setText("<html>\" What We Do For Our Users \"</html>");
        textTitleLabel.setFont(new Font("Consolas",Font.BOLD,12));
        textTitleLabel.setForeground(Color.CYAN);
        textTitleLabel.setBounds(160, 140, 320, 25);//Add calorie and set horizontal 65 and set width 400.
        /*Text Title Label End*/
        
        /*Text Label Start*/
        textLabel.setText("<html>Our  fitness app, which we set out to provide services in the field of healthy living, currently become a platform where you can use calculators, ready-made diet programs, consulting services and track your physical fitness data.</html>");
        textLabel.setFont(new Font("Consolas",Font.PLAIN,12));
        textLabel.setForeground(Color.orange);
        textLabel.setBounds(25, 110, 450, 200);//Add calorie and set horizontal 65 and set width 400.
        /*Text Label End*/
        
        /*Second Text Label Start*/
        textSecondLabel.setText("<html>In short,\r\n"
        		+ "We do our best to motivate you to reach your ideal weight in the healthiest way possible!</html>");
        textSecondLabel.setFont(new Font("Consolas",Font.PLAIN,12));
        textSecondLabel.setForeground(Color.orange);
        textSecondLabel.setBounds(23, 225, 450, 100);//Add calorie and set horizontal 65 and set width 400.
        /*Second Text Label End*/
		
		/*Home Button Start*/
        homeButtonLabel.setBounds(195,380,200,25);
		homeButtonLabel.setFont(new Font("Consolas",Font.BOLD,12));
		homeButtonLabel.setForeground(Color.white);
		
		homeButton.setBounds(195,350,100,25);
		homeButton.addActionListener(this);
		homeButton.setFocusable(false);
		homeButton.setForeground(Color.green);
		homeButton.setBackground(Color.black);
        /*Home Button End*/
		
		aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aboutFrame.setSize(500,500);
		aboutFrame.setLocationRelativeTo(null);//Set opening location of the frame center of the screen.
		aboutFrame.getContentPane().setBackground(new Color(0,76,153));
		aboutFrame.setResizable(false);
		
		aboutFrame.add(infoLabel);
		aboutFrame.add(homeButtonLabel);
		aboutFrame.add(homeButton);
		aboutFrame.add(iconLabel);
		aboutFrame.add(textTitleLabel);
		aboutFrame.add(textLabel);
		aboutFrame.add(textSecondLabel);
		
		aboutFrame.setLayout(null);
		aboutFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == homeButton) {
			answer1 = JOptionPane.showConfirmDialog(null, "Do you want to return Home Page ?","Return Home Page",JOptionPane.YES_NO_OPTION);
			if(answer1==JOptionPane.YES_OPTION) {
				new HomePage(userInfoCopy);
				aboutFrame.dispose();
				}
		}
	}
}

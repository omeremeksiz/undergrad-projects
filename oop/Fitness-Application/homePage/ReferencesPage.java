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

public class ReferencesPage implements ActionListener {
	
	JFrame referencesFrame = new JFrame("Referances");
	
	String[] userInfoCopy = new String[7];
	
	int answer1 = 0;
	
	/*Info Message Label Declaration Start*/
	JLabel infoLabel = new JLabel();
	/*Info Message Label Declaration End*/
	
	/*Text Title Label Declaration Start*/
	JLabel textTitleLabel = new JLabel();
	/*Text Title Label Declaration End*/
	
	/*Text Label Declaration Start*/
	JLabel textLabel = new JLabel();
	/*Text Label Declaration End*/
	
	/*User name Label Declaration Start*/
	JLabel nameLabel = new JLabel();
	/*User name Label Declaration End*/
	
	/*References Icon Declaration Start*/
	ImageIcon referencesIcon = new ImageIcon("references.png");
	JLabel referencesLabel = new JLabel();
	/*References Icon Declaration End*/
	
	/*Home Page Button Declaration Start*/
	JLabel homeButtonLabel = new JLabel("Return Home Page");
	JButton homeButton = new JButton("Home");
	/*Home Page Button Declaration End*/
	
	public ReferencesPage(String[] userInfoOriginal) {
		
		/*Get User Info From Login Page or Register Page Directly Start*/
		userInfoCopy = userInfoOriginal;
		/*Get User Info From Login Page or Register Page Directly Start*/
		
		/*Welcome Text Label Start*/
        infoLabel.setText("<html>"+userInfoCopy[0].toUpperCase()+", LISTEN TO US FROM OUR DEAR USERS.</html>");
        infoLabel.setFont(new Font("Consolas",Font.BOLD,13));
        infoLabel.setForeground(Color.magenta);
        infoLabel.setBounds(95, 10, 350, 50); 
        /*Welcome Text Label End*/
        
        /*Text Title Label Start*/
        textTitleLabel.setText("<html>\" I'm younger, does it really matter that much ? \"</html>");
        textTitleLabel.setFont(new Font("Consolas",Font.BOLD,12));
        textTitleLabel.setForeground(Color.CYAN);
        textTitleLabel.setBounds(10, 80, 320, 25);//Add calorie and set horizontal 65 and set width 400.
        /*Text Title Label End*/
		
		/*Locating References Icon Start*/
		referencesLabel.setIcon(referencesIcon);
		Dimension partnerSize = referencesLabel.getPreferredSize(); //Gets the size of the image
        referencesLabel.setBounds(345, 80, partnerSize.width, partnerSize.height); //Sets the location of the image
		/*Locating References Icon End*/
        
        /*Text Label Start*/
        textLabel.setText("<html><br>"
        		+ "\tMy life has changed since i found this amazing healthy living app.<br>"
        		+ "I can complete all my measurements on a single platform using the app.<br>"
        		+ "In this way, I can easily follow all my healthy life measurements without wasting time.<br>"
        		+ "Thanks to this application, I am now healthier and more alive.<br>"
        		+ "In this way, I can spend more time with my family and loved ones.<br>"
        		+ "Thanks again and again to this family.</html>");
        textLabel.setFont(new Font("Consolas",Font.PLAIN,12));
        textLabel.setForeground(Color.orange);
        textLabel.setBounds(20, 105, 320, 200);//Add calorie and set horizontal 65 and set width 400.
        /*Text Label End*/
        
        /*Text Title Label Start*/
        nameLabel.setText("<html>**Ferdi Tayfur**<br>"
        		+ "Date: 01.06.2022</html>");
        nameLabel.setFont(new Font("Consolas",Font.ITALIC,10));
        nameLabel.setForeground(Color.pink);
        nameLabel.setBounds(362, 215, 150, 25);//Add calorie and set horizontal 65 and set width 400.
        /*Text Title Label End*/
		
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
		
		referencesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		referencesFrame.setSize(500,500);
		referencesFrame.setLocationRelativeTo(null);//Set opening location of the frame center of the screen.
		referencesFrame.getContentPane().setBackground(new Color(0,76,153));
		referencesFrame.setResizable(false);
		
		referencesFrame.add(infoLabel);
		referencesFrame.add(textTitleLabel);
		referencesFrame.add(textLabel);
		referencesFrame.add(nameLabel);
		referencesFrame.add(homeButton);
		referencesFrame.add(homeButtonLabel);
		referencesFrame.add(referencesLabel);
		
		referencesFrame.setLayout(null);
		referencesFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == homeButton) {
			answer1 = JOptionPane.showConfirmDialog(null, "Do you want to return Home Page ?","Return Home Page",JOptionPane.YES_NO_OPTION);
			if(answer1==JOptionPane.YES_OPTION) {
				new HomePage(userInfoCopy);
				referencesFrame.dispose();
				}
		}
	}
}

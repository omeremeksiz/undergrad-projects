package homePage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DietsPage implements ActionListener {
	
	JFrame dietsFrame = new JFrame("Diet Programs");
	
	int answer1 = 1;
	
	String[] userInfoCopy = new String[7];
	
	/*Info Message Label Declaration Start*/
	JLabel infoLabel = new JLabel();
	/*Info Message Label Declaration End*/
	
	/*Update Message Label Declaration Start*/
	JLabel updateLabel = new JLabel();
	/*Update Message Label Declaration End*/
	
	/*Hyperlink Button Declaration Start*/
	JButton linkButton = new JButton("Link");
	/*Hyperlink Button Declaration End*/
	
	/*Partner Icon Declaration Start*/
	ImageIcon partnerIcon = new ImageIcon("handshake.png");
	JLabel partnerLabel = new JLabel();
	/*Partner Icon Declaration End*/
	
	/*Image Icon Declaration Start*/
	ImageIcon logoIcon = new ImageIcon("click.png");
	JLabel iconLabel = new JLabel();
	/*Image Icon Declaration End*/
	
	/*Home Page Button Declaration Start*/
	JLabel homeButtonLabel = new JLabel("Return Home Page");
	JButton homeButton = new JButton("Home");
	/*Home Page Button Declaration End*/
	
	public DietsPage(String[] userInfoOriginal) {
		
		/*Get User Info From Login Page or Register Page Directly Start*/
		userInfoCopy = userInfoOriginal;
		/*Get User Info From Login Page or Register Page Directly Start*/
		
		/*Welcome Text Label Start*/
        infoLabel.setText("<html>We happily share the new feature of our website, which emerged as a result of our cooperation with U.S. News & World Report.<br>"
        		+"<br>"
        		+ "By clicking the link below, you can connect to U.S. News & World Report's site and access thousands of ready-made diet programs for free.</html>");
        infoLabel.setFont(new Font("Consolas",Font.PLAIN,12));
        infoLabel.setForeground(Color.orange);
        infoLabel.setBounds(75, 20, 300, 125); 
        /*Welcome Text Label End*/
        
        /*Link Button Start*/
        linkButton.addActionListener(this);
        linkButton.setFocusable(false);
        linkButton.setBounds(150,220,100,25);
        linkButton.setForeground(Color.yellow);
        linkButton.setBackground(Color.black);
        linkButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        /*Link Button End*/
        
        /*Locating Icon Start*/
		iconLabel.setIcon(logoIcon);
		Dimension size = iconLabel.getPreferredSize(); //Gets the size of the image
        iconLabel.setBounds(183, 257, size.width, size.height); //Sets the location of the image
		/*Locating Icon End*/
        
        /*Locating Partner Icon Start*/
		partnerLabel.setIcon(partnerIcon);
		Dimension partnerSize = partnerLabel.getPreferredSize(); //Gets the size of the image
        partnerLabel.setBounds(167, 140, partnerSize.width, partnerSize.height); //Sets the location of the image
		/*Locating Partner Icon End*/
        
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
		
		dietsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dietsFrame.setSize(420,420);
		dietsFrame.setLocationRelativeTo(null);//Set opening location of the frame center of the screen.
		dietsFrame.getContentPane().setBackground(new Color(0,76,153));
		dietsFrame.setResizable(false);
		
		dietsFrame.add(infoLabel);
		dietsFrame.add(linkButton);
		dietsFrame.add(homeButtonLabel);
		dietsFrame.add(homeButton);
		dietsFrame.add(iconLabel);
		dietsFrame.add(partnerLabel);
		
		dietsFrame.setLayout(null);
		dietsFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==linkButton) {
			try {
				Desktop.getDesktop().browse(new URL("https://health.usnews.com/best-diet/best-weight-loss-diets").toURI());
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
		if(e.getSource() == homeButton) {
			answer1 = JOptionPane.showConfirmDialog(null, "Do you want to return Home Page ?","Return Home Page",JOptionPane.YES_NO_OPTION);
			if(answer1==JOptionPane.YES_OPTION) {
				new HomePage(userInfoCopy);
				dietsFrame.dispose();
				}
		}
	}
}

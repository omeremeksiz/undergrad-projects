import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage {
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel();
	
	public WelcomePage(String userID) {
		
		welcomeLabel.setBounds(0,0,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Hello "+userID + "!");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		
		frame.add(welcomeLabel);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}
}

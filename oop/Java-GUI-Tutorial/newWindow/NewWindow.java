package newWindow;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindow {
	
	JFrame frame = new JFrame();//Create frame.
	JLabel label = new JLabel("Hello,World!");//Create label.
	
	public NewWindow() {
		
		label.setBounds(0,0,150,50);//Set label bounds.
		label.setFont(new Font(null,Font.PLAIN,25));//Set label text font.
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.add(label);//Add label to frame.
		frame.setVisible(true);
	}
}

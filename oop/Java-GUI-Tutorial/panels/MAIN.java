package panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MAIN {

	public static void main(String[] args) {
		
		ImageIcon icon = new ImageIcon("images.png");
		
		JLabel label = new JLabel();
		label.setText("Hi!");
		label.setIcon(icon);
		label.setVerticalAlignment(JLabel.CENTER);//Place components top which container in it.
		label.setHorizontalAlignment(JLabel.CENTER);//Place components top which container in it.
		//label.setBounds(0, 0, 75, 75);//Place components specific coordinate in the container. To do this setLayout of container(panel) null.
		
		JPanel redPanel = new JPanel();//Create panel.
		redPanel.setBackground(Color.red);//Set panel background color.
		redPanel.setBounds(0,0,250,250);//Set panel bounds.
		
		JPanel bluePanel = new JPanel();//Create panel.
		bluePanel.setBackground(Color.blue);//Set panel background color.
		bluePanel.setBounds(250,0,250,250);//Set panel bounds.
		
		JPanel greenPanel = new JPanel();//Create panel.
		greenPanel.setBackground(Color.green);//Set panel background color.
		greenPanel.setBounds(0,250,500,250);//Set panel bounds.
		greenPanel.setLayout(new BorderLayout());//Place components in the any container center vertically, left horizontally.
		//Then use setHorizontally set Vertically to place another location in container.
		//greenPanel.setLayout(null);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,750);
		frame.setLayout(null);//To modify frame layout manually otherwise layout modify with default settings.
		frame.setVisible(true);
		greenPanel.add(label);//Add label to panel because panel's functions is containing components.
		frame.add(redPanel);//Add panel to frame.
		frame.add(bluePanel);//Add panel to frame.
		frame.add(greenPanel);//Add panel to frame.
	}

}

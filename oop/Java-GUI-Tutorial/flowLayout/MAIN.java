package flowLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.logging.Handler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MAIN {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();//Creating Frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Set close button to exit.
		frame.setSize(500,500);//Set opening frame size.
		//frame.setLayout(new FlowLayout());
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));//Set layout manager as flow layout and set location and gaps of components.
		
		JPanel panel = new JPanel();//Creating panel.
		panel.setPreferredSize(new Dimension(100,250));//Set panel size.
		panel.setBackground(Color.lightGray);//Set panel background color.
		panel.setLayout(new FlowLayout());//Set FlowLayout of panel's layout manager. 
		
		
		panel.add(new JButton("1"));//Shortcut for adding button to the frame.
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		
		frame.add(panel);//Add panel to frame.
		frame.setVisible(true);//Set frame visible at the end.
	}

}

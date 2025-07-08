package gridLayout;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MAIN {

	public static void main(String[] args) {
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new GridLayout(3,3,10,10));//Set layout manager as GridLayout manager with 9 rows and 1 column.
		//With 10 pixel horizontal space and 10 pixel vertical space between components.
		
		/*JButton button = new JButton();
		frame.add(button);*/
		frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
		frame.add(new JButton("6"));
		frame.add(new JButton("7"));
		frame.add(new JButton("8"));
		frame.add(new JButton("9"));
		
		
		
		frame.setVisible(true);
		
		
		
		
		
	}

}

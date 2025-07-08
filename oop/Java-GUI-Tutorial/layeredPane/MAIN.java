package layeredPane;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class MAIN {

	public static void main(String[] args) {
		
		JLabel label1 = new JLabel();//Create label.
		label1.setOpaque(true);//Display background color of label.
		label1.setBackground(Color.red);//Set background color red.
		label1.setBounds(50,50,200,200);//Set label bound (x,y,horizontal,vertical).
		
		JLabel label2 = new JLabel();//
		label2.setOpaque(true);
		label2.setBackground(Color.green);
		label2.setBounds(100,100,200,200);
		
		JLabel label3 = new JLabel();
		label3.setOpaque(true);
		label3.setBackground(Color.blue);
		label3.setBounds(150,150,200,200);
		
		JLayeredPane layeredPane = new JLayeredPane();//Create JLayeredPane.
		layeredPane.setBounds(0,0,500,500);//Set LayeredPane bounds.
		
		layeredPane.add(label1,Integer.valueOf(0));//Add label to LayeredPane and set the priority of layers.
		//First layer will be the bottom one by default but if we can specify layer priority by manually. 
		//Ex:JLayeredPane.DEFAULT_LAYER = Integer.valueOf(0).
		layeredPane.add(label2,Integer.valueOf(2));
		layeredPane.add(label3,Integer.valueOf(1));
		
		JFrame frame = new JFrame("JLayeredPane");//Create frame.
		frame.add(layeredPane);//Add LayeredPane to frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);//Set layout manager as null.
		frame.setVisible(true);
		
	}

}

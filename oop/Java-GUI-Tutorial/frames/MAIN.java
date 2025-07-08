package frames;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MAIN {

	public static void main(String[] args) {
		JFrame frame = new JFrame();//Creating new frame.
		frame.setTitle("My First Frame");//Set frame title.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Set close button exit instead of hide.
		frame.setResizable(true);//Set resize frame option enable.
		frame.setSize(420,420);//Set frame size.
		frame.setVisible(true);//Set frame visible.
		
		ImageIcon image = new ImageIcon("Vesikalik.jpeg");//Create image icon.
		frame.setIconImage(image.getImage());//Change icon of frame.
		
		//frame.getContentPane().setBackground(Color.green);//Set background color default color.
		frame.getContentPane().setBackground(new Color(20,40,150));//Set background color with rgb values (255,255,255)=(0xFFFFFF).
		
		//MyFrame myFrame = new MyFrame();//Creating frame by creating extra class which contain modification of frame.
	}

}

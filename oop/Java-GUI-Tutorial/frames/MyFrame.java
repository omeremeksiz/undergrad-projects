package frames;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		this.setTitle("My First Frame");//Set frame title.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Set close button exit instead of hide.
		this.setResizable(true);//Set resize frame option enable.
		this.setSize(420,420);//Set frame size.
		this.setVisible(true);//Set frame visible.
		
		ImageIcon image = new ImageIcon("Vesikalik.jpeg");//Create image icon.
		this.setIconImage(image.getImage());//Change icon of frame.
		
		//frame.getContentPane().setBackground(Color.green);//Set background color default color.
		this.getContentPane().setBackground(new Color(20,40,150));//Set background color with rgb values (255,255,255)=(0xFFFFFF).
	}
}

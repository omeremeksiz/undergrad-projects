package keyListener;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements KeyListener {
	
	JLabel label;
	ImageIcon icon;
	
	public MyFrame() {
		
		//icon = new ImageIcon("images.png");
		
		label = new JLabel();
		label.setBounds(0,0,100,100);//Set label bounds since we select layout manager as null.
		//label.setBackground(Color.black);//Set label background color.
		//label.setOpaque(true);//Set label's background color visible.
		label.setIcon(icon);//Add icon to label.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);//Set frame background color.
		this.add(label);
		this.addKeyListener(this);//Add key listener to frame.
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//keyTyped = Invoked when a key is typed. Uses KeyChar, char output.
		switch (e.getKeyChar()) {
			case 'a': label.setLocation(label.getX()-10,label.getY());
				break;
			case 'w': label.setLocation(label.getX(),label.getY()-10);
				break;
			case 's': label.setLocation(label.getX(),label.getY()+10);
				break;
			case 'd': label.setLocation(label.getX()+10,label.getY());
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output.
		switch (e.getKeyCode()) {
		case 37: label.setLocation(label.getX()-10,label.getY());
			break;
		case 38: label.setLocation(label.getX(),label.getY()-10);
			break;
		case 39: label.setLocation(label.getX()+10,label.getY());
			break;
		case 40: label.setLocation(label.getX(),label.getY()+10);
			break;
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//keyReleased = called whenever a button is released.
		System.out.println("You relased key char: "+ e.getKeyChar());
		System.out.println("You relased key code: "+ e.getKeyCode());
	}
	
}

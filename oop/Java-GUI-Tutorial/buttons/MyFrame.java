package buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MyFrame extends JFrame implements ActionListener {
	
	JLabel label;//Declaring label as a global variable.
	JButton button;//Declaring global to use button outside of constructor.
	public MyFrame() {
		
		ImageIcon icon = new ImageIcon("bicon64.png");
		ImageIcon icon2 = new ImageIcon("images.png");
		
		label = new JLabel();
		label.setIcon(icon2);
		label.setBounds(150,250,150,150);
		label.setVisible(false);
		
		button = new JButton();//Creating button.
		button.setBounds(100, 100, 250, 100);//Set button bounds.
		button.addActionListener(this);//Adding action listener to button.
		//button.addActionListener(e -> System.out.println("Hi!"));//Shortcut!!
		button.setText("I'm a button.");//Add text to button.
		button.setFocusable(false);//Get rid of the border outside of the text on the button.
		button.setIcon(icon);//Add icon to button.
		button.setHorizontalTextPosition(JButton.CENTER);//Set text position.
		button.setVerticalTextPosition(JButton.BOTTOM);//Set text position.
		button.setFont(new Font("Comic Sans",Font.BOLD,25));//Set text font.
		button.setForeground(Color.blue);//Set background color.
		button.setBackground(Color.lightGray);//Set background color.
		button.setBorder(BorderFactory.createEtchedBorder());//Add button a border.
		//button.setEnabled(false);//Display button is disabled.
		button.setIconTextGap(0);//Change gap between icon and text.
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(button);
		this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) { 
			label.setVisible(true);
			//System.out.println("Hi!");
			//button.setEnabled(false);//Display button is disabled after press once to bottom.
		}
	}
}

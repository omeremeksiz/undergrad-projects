package labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MAIN {

	public static void main(String[] args) {
		
		ImageIcon image = new ImageIcon("images.png");//Creating image.
		Border border = BorderFactory.createLineBorder(Color.green,3);//Creating border and set color to it.
		
		JLabel label = new JLabel();//Creating label.
		label.setText("Hello, World!");//Set text to label.
		label.setIcon(image);//Set created image to label as a icon.
		label.setHorizontalTextPosition(JLabel.CENTER);//Set text LEFT,CENTER,RIGHT of ImageIcon.
		label.setVerticalTextPosition(JLabel.TOP);//Set text TOP,CENTER,UNDER of ImageIcon.
		label.setForeground(new Color(0x00FF00));//Set text font color.
		label.setFont(new Font("MV Boli",Font.PLAIN,20));//Set font of text.
		label.setIconTextGap(0);//Set gap size of text to image.
		label.setBackground(Color.white);//Set background color.
		label.setOpaque(true);//Display background color.
		label.setBorder(border);//Set label border to created border.
		label.setVerticalAlignment(JLabel.CENTER);//Set icon+text vertically to the center.
		label.setHorizontalAlignment(JLabel.CENTER);//Set icon+text horizontally to the center.
		//label.setBounds(100,100,250,250);//Set x,y position within frame as well as dimension. Static icon.
		
		
		
		//Creating frame to add label component.
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(500,500);
		//frame.setLayout(null);//To modify frame layout manually otherwise layout modify with default settings.
		frame.setVisible(true);
		frame.add(label);//Add label to frame.
		frame.pack();//Frame size automatically fitted with its components directly. 
		//Make sure add all components before using pack method.
	}

}

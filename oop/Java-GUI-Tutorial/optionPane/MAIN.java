package optionPane;

import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MAIN {

	public static void main(String[] args) {
		//***Variations of Message Dialog Boxes***//
		
		//JOptionPane.showMessageDialog(null, "This is some useless info.", "Title", JOptionPane.PLAIN_MESSAGE);
		//JOptionPane.showMessageDialog(null, "This is some useless info.", "Title", JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Is this some useless info ?", "Title", JOptionPane.QUESTION_MESSAGE);
		/*while(true) {
			JOptionPane.showMessageDialog(null, "Bro, this is some useless info !", "Title", JOptionPane.WARNING_MESSAGE);
		}*/ 		
		//JOptionPane.showMessageDialog(null, "Error !", "Title", JOptionPane.ERROR_MESSAGE);
		
		//***Variations of Message Dialog Boxes***//
		
		
		
		//***Variations of Message Dialog Boxes with User can Responds***//
		
		//int answer = JOptionPane.showConfirmDialog(null, "bro, do you even code ?","This is my title",JOptionPane.YES_NO_CANCEL_OPTION);
		//System.out.println(answer);
		//String name = JOptionPane.showInputDialog("What is your name ?");
		//System.out.println("Hello, "+ name);
		
		/*String[] responses = {"No, you're awesome !","Thank, you !","*blush*"};//For change button's messages.
		ImageIcon icon = new ImageIcon("bicon64.png");//For add image to OptionPane.
		JOptionPane.showOptionDialog(null,
				"You are awesome !",
				"Secret Message",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				icon,
				responses,
				0);//To combine all features at one OptionPane.*/
		
		//***Variations of Message Dialog Boxes with User can Responds***//
	}

}

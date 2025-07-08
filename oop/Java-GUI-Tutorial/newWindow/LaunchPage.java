package newWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener {
	
	JFrame frame = new JFrame();//Create frame.
	JButton button = new JButton("New Window");//Create button.
	
	
	public LaunchPage() {
		
		button.setBounds(100,160,200,40);//Set button bounds.
		button.setFocusable(false);//Avoid button border which appear when click. 
		button.addActionListener(this);//Add action to the button.
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);//Set frame layout manager null.
		frame.add(button);//Add button to the frame.
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			frame.dispose();//Close (get rid of) frame and just show new window.
			NewWindow window = new NewWindow();//Create NewWindow object.
			//Actually window object is another frame which include label.
		}
	}
}

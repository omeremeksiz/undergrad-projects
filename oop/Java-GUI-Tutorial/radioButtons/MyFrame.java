package radioButtons;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame implements ActionListener {
	
	/*Define global instances*/
	JRadioButton pizzaButton;
	JRadioButton hamburgerButton;
	JRadioButton hotdogButton;
	ImageIcon pizzaIcon;
	ImageIcon hamburIcon;
	ImageIcon hotdogIcon;
	
	public MyFrame() {
		
		/*Create Icons*/
		pizzaIcon = new ImageIcon("emoji.jpg");
		hamburIcon = new ImageIcon("images.png");
		hotdogIcon = new ImageIcon("bicon64.png");
		
		/*Create Radio Buttons*/
		pizzaButton = new JRadioButton("Pizza");
		hamburgerButton = new JRadioButton("Hamburger");
		hotdogButton = new JRadioButton("Hotdog");
		
		pizzaButton.setFocusable(false);
		hamburgerButton.setFocusable(false);
		hotdogButton.setFocusable(false);
		
		/*Add Action to the Buttons*/
		pizzaButton.addActionListener(this);
		hamburgerButton.addActionListener(this);
		hotdogButton.addActionListener(this);
		
		/*Add Icon to the Radio Buttons instead of Check Box*/
		pizzaButton.setIcon(pizzaIcon);
		hamburgerButton.setIcon(hamburIcon);
		hotdogButton.setIcon(hotdogIcon);
		
		/*Create Group of Radio Buttons which only 1 may be selected.*/
		ButtonGroup group = new ButtonGroup();
		group.add(pizzaButton);
		group.add(hamburgerButton);
		group.add(hotdogButton);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.add(pizzaButton);
		this.add(hamburgerButton);
		this.add(hotdogButton);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pizzaButton) {
			System.out.println("You ordered pizza!");
			/*Make the radio buttons disabled other than selected one. */
			hamburgerButton.setEnabled(false);
			hotdogButton.setEnabled(false);
		}
		if(e.getSource()==hamburgerButton) { 
			System.out.println("You ordered hamburger!");
			pizzaButton.setEnabled(false);
			hotdogButton.setEnabled(false);
		}
		if(e.getSource()==hotdogButton) { 
			System.out.println("You ordered hotdog!");
			pizzaButton.setEnabled(false);
			hamburgerButton.setEnabled(false);
		}
	}

}

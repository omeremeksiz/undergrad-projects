package textFields;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	
	//Define text field and button global so that we can use out of constructor for example in actionPerformed method.
	JTextField textField;
	JButton button;
	
	public MyFrame() {
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setFont(new Font("Consolas",Font.PLAIN,28));//Set font of entered message to  the text box.
		textField.setForeground(new Color(0x00FF00));//Set entered message color of text box as a green.
		textField.setBackground(Color.black);//Set background color of text box as a black.
		textField.setCaretColor(Color.white);//Set caret color as a white because on black background color it is difficult to see.
		textField.setText("Enter Your Name");//Set a default text to your text box before user enter a text.
		//textField.setEditable(false);//Set text field is not usable or editable.
		
		
		button = new JButton("Submit");//Add a button for submission.
		button.addActionListener(this);//Add action to the button.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());//Set layout manager as FlowLayout.
		this.add(textField);//Add text field to frame.
		this.add(button);//Add button to the frame.
		//Important note, we need to add components to frame before packing. 
		this.pack();//Set the frame pack so that the size of frame will adjust to fit the components you add.
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println(textField.getText());//Print submitted message.
			//After submission text field and button can't be use anymore.
			button.setEnabled(false);
			textField.setEditable(false);
		}
	}
	
}

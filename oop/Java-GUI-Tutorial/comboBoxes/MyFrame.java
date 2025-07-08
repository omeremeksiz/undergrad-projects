package comboBoxes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {
	
	JComboBox comboBox;
	
	public MyFrame() {
		
		String[] animals = {"dog","cat","bird"};//Wrapper class must be used while store primitive data types in array.
		
		comboBox = new JComboBox(animals);//Create combo box with reference class.
		comboBox.addActionListener(this);//Add action to the combo box.
		
		//comboBox.setEditable(true);//Set combo box editable.
		//System.out.println(comboBox.getItemCount());//Print number of item of combo box.
		//comboBox.addItem("horse");//Add item horse to the combo box.
		//comboBox.insertItemAt("pig", 0);//Add item pig to the combo box within given index.
		//comboBox.setSelectedIndex(0);//Set selected index 0 so that user always see 0th index first.
		//comboBox.removeItem("cat");//Remove item cat from combo box.
		//comboBox.removeItemAt(0);//Remove item that placed 0th index.
		//comboBox.removeAllItems();//Remove all items in the combo box.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.add(comboBox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comboBox) {
			//System.out.println(comboBox.getSelectedItem());//Print selected item.
			//System.out.println(comboBox.getSelectedIndex());// Print selected item index.
			if(comboBox.getSelectedItem()=="dog")
				System.out.println("You selected dog!");
			else if (comboBox.getSelectedItem()=="cat")
				System.out.println("You selected cat!");
			else
				System.out.println("You selected bird!");
		}
	}
	
}

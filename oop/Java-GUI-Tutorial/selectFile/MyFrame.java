package selectFile;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {

	JButton button;
	
	public MyFrame() {
		
		button = new JButton("Select File");
		button.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.add(button);
		this.pack();
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File("."));//Set current directory to project folder.
			
			//int response = fileChooser.showOpenDialog(null);//Select file to open.
			int response = fileChooser.showSaveDialog(null);//Select file to save.
			
			if(response == JFileChooser.APPROVE_OPTION) //same as response == 1
			{
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
			}
			
		}
		
	}
	
}

package dragDrop;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	DragPanel dragPanel = new DragPanel();
	
	public MyFrame() {
		this.setTitle("Drag & Drop demo");//Set title to frame.
		this.setSize(600,600);//Set size of frame.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(dragPanel);//Add panel called as dragPanel to frame.
		this.setVisible(true);
	}
}

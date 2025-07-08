package progressBar;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarDemo {
	
	JFrame frame;
	JProgressBar bar;
	
	ProgressBarDemo(){
		
		bar = new JProgressBar();
		//bar = new JProgressBar(0,500);//The range of bar is starting from 0 to 500.
		bar.setValue(0);//Set bar initial value as 0.
		bar.setBounds(0,0,420,50);//Set bounds of bar because of we set layout manager as null.
		bar.setStringPainted(true);//Add a percentage to progress bar.
		bar.setFont(new Font("MV Boli",Font.BOLD,21));//Set font.
		bar.setBackground(Color.black);//Set background color.
		bar.setForeground(Color.red);//Set foreground color.
		
		frame = new JFrame();
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		fill();
	}
	public void fill() {
		int counter=100;
		while(counter!=-1) {
			bar.setValue(counter);
			try {
				Thread.sleep(50);//Set filling time of bar.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter-=1;
		}
		bar.setString("Done!");
	}
}

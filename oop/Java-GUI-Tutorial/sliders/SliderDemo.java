package sliders;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo implements ChangeListener {
	
	/*Creating Objects*/
	JFrame frame;
	JPanel panel;
	JLabel label;
	JSlider slider;
	
	public SliderDemo() {
		panel = new JPanel();
		label = new JLabel();
		
		slider = new JSlider(0,100,50);//Creating slider that have range 0 to 100 and starting point is 50. 
		slider.setPreferredSize(new Dimension(400,200));//Set slider sizes.
		
		slider.setPaintTicks(true);//Set ticks visible.
		slider.setMinorTickSpacing(10);//Set ticks frequency.
		
		slider.setPaintTrack(true);//Set tracks visible.
		slider.setMajorTickSpacing(25);//Set track frequency.
		
		slider.setPaintLabels(true);//Set number of tracks visible.
		slider.setFont(new Font("MV Boli",Font.PLAIN,15));//Set font of track's numbers.
		
		slider.setOrientation(SwingConstants.VERTICAL);//Set slider as a vertical bar.
		//slider.setOrientation(SwingConstants.HORIZONTAL);
		
		slider.addChangeListener(this);//Add change listener to slider.
		
		label.setText("°C = "+slider.getValue());//Add text to label.
		label.setFont(new Font("MV Boli",Font.PLAIN,15));//Set font the label's text.
		
		panel.add(slider);
		panel.add(label);
		
		frame = new JFrame("Slider Demo");
		frame.add(panel);
		frame.setSize(420,420);
		frame.setVisible(true);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		label.setText("°C = "+slider.getValue());//Set label's text editable by changing slider's numbers.
		
	}

}

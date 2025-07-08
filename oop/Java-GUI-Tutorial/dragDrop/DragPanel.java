package dragDrop;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DragPanel extends JPanel {
	
	ImageIcon image = new ImageIcon("images.png");//Create a icon to add panel.
	final int WIDTH = image.getIconWidth();//Get icon width and initialize to WIDTH.
	final int HEIGHT = image.getIconHeight();//Get icon height and initialize to HEIGHT.
	Point imageCorner;//Create point to keep image corner points.
	Point prevPoint;//Create point to keep previous points.
	
	public DragPanel() {
		
		imageCorner = new Point(0,0);//Set point of image corner.
		ClickListener clickListener = new ClickListener();//Create instance of ClickListener class. 
		DragListener dragListener = new DragListener();//Create instance of DragListener class.
		this.addMouseListener(clickListener);//Add mouse listener as a clickListener instances. 
		this.addMouseMotionListener(dragListener);//Add drag listener as a dragListener instances.
		
	}
	
	//Repaint our image after we update new position to it.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
	}
	
	//Update previous point wo where we are click.
	private class ClickListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			prevPoint = e.getPoint();
		}
	}
	
	//Translate image corner to a new position wherever the current point is after dragging the mouse.
	private class DragListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e) {
			 Point currenPoint = e.getPoint();
			 imageCorner.translate(
					 
					 (int)(currenPoint.getX()-prevPoint.getX()),
					 (int)(currenPoint.getY()-prevPoint.getY())
					 
					 );
			 prevPoint = currenPoint;
			 repaint();
		}
	}	
}

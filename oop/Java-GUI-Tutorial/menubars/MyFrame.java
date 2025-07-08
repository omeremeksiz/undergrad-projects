package menubars;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame implements ActionListener {
	
	/* Necessary Declaration */
	
	JMenuBar menuBar;
	
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	
	JMenuItem saveItem;
	JMenuItem loadItem;
	JMenuItem exitItem;
	
	ImageIcon loadIcon;
	ImageIcon saveIcon;
	ImageIcon exitIcon;
	
	public MyFrame() {
		
		menuBar = new JMenuBar();//Create JMenuBar instance.
		
		fileMenu = new JMenu("File");//Create sub file menu to menuBar.
		editMenu = new JMenu("Edit");//Create sub edit menu to menuBar.
		helpMenu = new JMenu("Help");//Create sub help menu to menuBar.
		
		menuBar.add(fileMenu);//Add sub menus to main menu.
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		saveItem = new JMenuItem("Save");//Create save menu item to sub file menu.
		loadItem = new JMenuItem("Load");//Create load menu item to sub file menu.
		exitItem = new JMenuItem("Exit");//Create exit menu item to sub file menu.
		
		saveItem.addActionListener(this);//Add action to save item.
		loadItem.addActionListener(this);//Add action to load item.
		exitItem.addActionListener(this);//Add action to exit item.
		
		fileMenu.add(saveItem);//Add save item to sub file menu.
		fileMenu.add(loadItem);//Add load item to sub file menu.
		fileMenu.add(exitItem);//Add exit item to sub file menu.
		
		fileMenu.setMnemonic(KeyEvent.VK_F);//Alt + F for file.
		editMenu.setMnemonic(KeyEvent.VK_E);//Alt + E for edit.
		helpMenu.setMnemonic(KeyEvent.VK_H);//Alt + H for help.
		
		saveItem.setMnemonic(KeyEvent.VK_S);//This is S for load.
		loadItem.setMnemonic(KeyEvent.VK_L);//This is L for load.
		exitItem.setMnemonic(KeyEvent.VK_E);//This is E for load.
		
		loadIcon = new ImageIcon("bicon64.png");
		saveIcon = new ImageIcon("bicon64.png");
		exitIcon = new ImageIcon("bicon64.png");
		
		loadItem.setIcon(loadIcon);
		saveItem.setIcon(saveIcon);
		exitItem.setIcon(exitIcon);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		this.setJMenuBar(menuBar);//Instead of adding we set the menu bar.
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loadItem) {
			System.out.println("**beep boop* you loaded a file");
		}
		if(e.getSource()==saveItem) {
			System.out.println("**beep boop* you saved a file");
		}
		if(e.getSource()==exitItem) {
			System.exit(0);
		}
	}

}

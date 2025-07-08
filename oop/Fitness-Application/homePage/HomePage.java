package homePage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import signInPage.*;

public class HomePage extends JFrame implements ActionListener {
	
	/*Menu Elements Declaration Start*/
	JMenuBar menuBar;
	
	JMenu calorieMenu;
	JMenu bmiMenu;
	JMenu dietsMenu;
	JMenu idealMenu;
	JMenu bodyFatMenu;
	
	JMenuItem calorieMenuItem;
	JMenuItem bmiMenuItem;
	JMenuItem dietsMenuItem;
	JMenuItem idealMenuItem;
	JMenuItem bodyFatMenuItem;
	/*Menu Elements Declaration End*/
	
	/*Buttons Declaration Start*/
	JButton aboutButton = new JButton("About Us");
	JButton referancesButton = new JButton("Referances");
	/*Buttons Declaration End*/
	
	/*Image Icon Declaration Start*/
	ImageIcon logoIcon = new ImageIcon("logo1.png");
	JLabel iconLabel = new JLabel();
	/*Image Icon Declaration End*/
	
	/*Welcome Text Label Declaration Start*/
	JLabel textLabel = new JLabel();
	/*Welcome Text Label Declaration End*/
	
	/*Info Text Label Declaration Start*/
	JLabel infoLabel = new JLabel(); 
	/*Info Text Label Declaration End*/
	
	String[] userInfoCopy = new String[7];;
	
	public HomePage(String[] userInfoOriginal) {
		
		/*Get User Info From Login Page or Register Page Directly Start*/
		userInfoCopy = userInfoOriginal;
		/*Get User Info From Login Page or Register Page Directly Start*/
		
		/*Creating Menu Bar Start*/
		menuBar = new JMenuBar();//Creates menu bar instance.
		//menuBar.setBackground(Color.black);
		menuBar.setOpaque(true);
		/*Creating Menu Bar End*/
		
		/*Creating Menu Elements Start*/
		calorieMenu = new JMenu("Calori");
		bmiMenu = new JMenu("BMI");
		dietsMenu = new JMenu("Diets Program");
		idealMenu = new JMenu("Ideal Weight");
		bodyFatMenu = new JMenu("Body Fat");
		/*Creating Menu Elements End*/
		
		/*Change Menu Bar Elements Color Start*/
		calorieMenu.setForeground(new Color(0,204,0));
		bmiMenu.setForeground(new Color(0,204,0));
		dietsMenu.setForeground(new Color(0,204,0));
		idealMenu.setForeground(new Color(0,204,0));
		bodyFatMenu.setForeground(new Color(0,204,0));
		/*Change Menu Bar Elements Color End*/
		
		/*Creating Menu Items Start*/
		calorieMenuItem = new JMenuItem("Calori");
		bmiMenuItem = new JMenuItem("BMI");
		dietsMenuItem = new JMenuItem("Diets Program");
		idealMenuItem = new JMenuItem("Ideal Weight");
		bodyFatMenuItem = new JMenuItem("Body Fat");
		/*Creating Menu Items End*/
		
		/*Adding Action to Menu Elements Start*/
		calorieMenuItem.addActionListener(this);
		bmiMenuItem.addActionListener(this);
		dietsMenuItem.addActionListener(this);
		idealMenuItem.addActionListener(this);
		bodyFatMenuItem.addActionListener(this);
		/*Adding Action to Menu Elements End*/
		
		/*Adding Shortcuts for Menu Elements Start*/
		calorieMenu.setMnemonic(KeyEvent.VK_C);//Alt + C for Calorie Menu.
		bmiMenu.setMnemonic(KeyEvent.VK_B);//Alt + B for BMI Menu.
		dietsMenu.setMnemonic(KeyEvent.VK_D);//Alt + D for Calorie Menu.
		idealMenu.setMnemonic(KeyEvent.VK_I);//Alt + I for Calorie Menu.
		bodyFatMenu.setMnemonic(KeyEvent.VK_F);//Alt + F for Calorie Menu.
		/*Adding Shortcuts for Menu Elements End*/
		
		/*Adding Shortcuts for Menu Items Start*/
		calorieMenuItem.setMnemonic(KeyEvent.VK_K);//Alt + K for Calorie Menu.
		bmiMenuItem.setMnemonic(KeyEvent.VK_M);//Alt + M for BMI Menu.
		dietsMenuItem.setMnemonic(KeyEvent.VK_A);//Alt + A for Calorie Menu.
		idealMenuItem.setMnemonic(KeyEvent.VK_O);//Alt + O for Calorie Menu.
		bodyFatMenuItem.setMnemonic(KeyEvent.VK_S);//Alt + S for Calorie Menu.
		/*Adding Shortcuts for Menu Items End*/
		
		/*Set Menu Elements Non Focusable Start*/
		calorieMenu.setFocusable(false);
		bmiMenu.setFocusable(false);
		dietsMenu.setFocusable(false);
		idealMenu.setFocusable(false);
		bodyFatMenu.setFocusable(false);
		/*Set Menu Elements Non Focusable End*/
		
		/*Set Menu Items Non Focusable Start*/
		calorieMenuItem.setFocusable(false);
		bmiMenuItem.setFocusable(false);
		dietsMenuItem.setFocusable(false);
		idealMenuItem.setFocusable(false);
		bodyFatMenuItem.setFocusable(false);
		/*Set Menu Items Non Focusable End*/
		
		/*Adding Menu Items to Menu Elements Start*/
		calorieMenu.add(calorieMenuItem);
		bmiMenu.add(bmiMenuItem);
		dietsMenu.add(dietsMenuItem);
		idealMenu.add(idealMenuItem);
		bodyFatMenu.add(bodyFatMenuItem);
		/*Adding Menu Items to Menu Elements End*/
		
		/*Adding Menu Elements to Menu Bar Start*/
		menuBar.add(calorieMenu);
		menuBar.add(bmiMenu);
		menuBar.add(dietsMenu);
		menuBar.add(idealMenu);
		menuBar.add(bodyFatMenu);
		/*Adding Menu Elements to Menu Bar End*/
		
		/*Button Settings Start*/
		aboutButton.setBounds(215, 500, 100, 25);
		aboutButton.addActionListener(this);
		aboutButton.setFocusable(false);
		aboutButton.setFont(new Font("Sans Serif",Font.BOLD,12));
		aboutButton.setForeground(Color.green);
		aboutButton.setBackground(Color.black);
		
		referancesButton.setBounds(320, 500, 100, 25);
		referancesButton.addActionListener(this);
		referancesButton.setFocusable(false);
		referancesButton.setFont(new Font("Sans Serif",Font.BOLD,12));
		referancesButton.setForeground(Color.green);
		referancesButton.setBackground(Color.black);
		/*Button Settings End*/
		
		/*Locating Icon Start*/
		iconLabel.setIcon(logoIcon);
		Dimension size = iconLabel.getPreferredSize(); //Gets the size of the image
        iconLabel.setBounds(245, 30, size.width, size.height); //Sets the location of the image
		/*Locating Icon End*/
        
        /*Welcome Text Label Start*/
        textLabel.setText("WELCOME " + userInfoCopy[0].toUpperCase());
        textLabel.setFont(new Font("Consolas",Font.BOLD,16));
        textLabel.setForeground(Color.green);
        Dimension textSize = textLabel.getPreferredSize(); //Gets the size of the image
        textLabel.setBounds(254, 180, textSize.width, textSize.height); //Sets the location of the image
        /*Welcome Text Label End*/
        
        /*Welcome Text Label Start*/
        infoLabel.setText("<html>Take the first step to reach your ideal weight right away by using the great calculators and other services in the menu bar.<br>"
        		+"<br>"+"<br>"
        		+ "You can also get to know our company more through our users' feedback and articles by clicking the reference or about us button below.</html>");
        infoLabel.setFont(new Font("Consolas",Font.PLAIN,12));
        infoLabel.setForeground(Color.orange);
        infoLabel.setBounds(120, 220, 420, 100); //Sets the location of the image
        /*Welcome Text Label End*/
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(630,630);
		this.setTitle("Home Page");
		this.setLocationRelativeTo(null);//Set opening location of the frame center of the screen.
		this.getContentPane().setBackground(new Color(0,76,153));
		this.setResizable(false);//Make frame resizable.
		
		this.setJMenuBar(menuBar);
		this.add(aboutButton);
		this.add(referancesButton);
		this.add(iconLabel);
		this.add(textLabel);
		this.add(infoLabel);
		
		this.setLayout(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==calorieMenuItem) {
			//Go Calorie Calculation Page.
			new CaloriePage(userInfoCopy);
			this.dispose();
		}
		if(e.getSource()==bmiMenuItem) {
			//Go BMI Calculation Page.
			new BmiPage(userInfoCopy);
			this.dispose();
		}
		if(e.getSource()==dietsMenuItem) {
			//Go Diets Page.
			new DietsPage(userInfoCopy);
			this.dispose();
		}
		if(e.getSource()==idealMenuItem) {
			//Go Ideal Weight Calculation Page.
			new IdealPage(userInfoCopy);
			this.dispose();
		}
		if(e.getSource()==bodyFatMenuItem) {
			//Go Body Fat Calculation Page.
			new BodyFatPage(userInfoCopy);
			this.dispose();
		}
		
		if(e.getSource()==aboutButton) {
			//Go About Us Page.
			new AboutUsPage(userInfoCopy);
			this.dispose();
		}
		if(e.getSource()==referancesButton) {
			//Go References Page
			new ReferencesPage(userInfoCopy);
			this.dispose();
		}
		
	}
}

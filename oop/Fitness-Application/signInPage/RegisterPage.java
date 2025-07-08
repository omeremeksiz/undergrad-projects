package signInPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;

public class RegisterPage implements ActionListener, ChangeListener{
	
	JFrame registerFrame = new JFrame("User Register Page");//Creates register page frame.
	
	JButton registerButton = new JButton("Register");//Creates register button.
	
	/*Text Field Elements Declaration Start*/
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JTextField userAgeField = new JTextField(); 
	/*Text Field Elements Declaration End*/
	
	/*Radio Button Elements Declaration Start*/
	JRadioButton userMaleRadioButton = new JRadioButton("Male",true);
	JRadioButton userFemaleRadioButton = new JRadioButton("Female");
	JPanel radioPanel = new JPanel();
	ButtonGroup userGenderGroup;
	/*Radio Button Elements Declaration End*/
	
	/*Label Elements Declaration Start*/
	JLabel userIDLabel = new JLabel("User ID :");
	JLabel userPasswordLabel = new JLabel("User Password :");
	JLabel userGenderLabel = new JLabel("Gender :");
	JLabel userAgeLabel = new JLabel("Age :");
	JLabel userDailyLabel = new JLabel("Daily activity level :");
	/*Label Elements Declaration End*/
	
	/*Height Elements Declaration Start*/
	JLabel userHeightLabel = new JLabel("Height :");
	JPanel heightPanel = new JPanel();
	JSlider heightSlider = new JSlider(0,250,170);
	JLabel heightSliderLabel = new JLabel();
	/*Height Elements Declaration End*/
	
	/*Weight Elements Declaration Start*/
	JLabel userWeightLabel = new JLabel("Weight :");
	JPanel weightPanel = new JPanel();
	JSlider weightSlider = new JSlider(0,200,70);
	JLabel weightSliderLabel = new JLabel();
	/*Weight Elements Declaration End*/
	
	JComboBox dailyComboBox;
	
	public RegisterPage() {
		
		userIDLabel.setBounds(50,50,100,25);
		//userIDLabel.setForeground(Color.white);
		userPasswordLabel.setBounds(50,100,100,25);
		//userPasswordLabel.setForeground(Color.white);
		userGenderLabel.setBounds(50,200,100,25);
		//userGenderLabel.setForeground(Color.white);
		userHeightLabel.setBounds(50,250,100,25);
		//userHeightLabel.setForeground(Color.white);
		userWeightLabel.setBounds(50,300,100,25);
		//userWeightLabel.setForeground(Color.white);
		userAgeLabel.setBounds(50,150,100,25);
		//userAgeLabel.setForeground(Color.white);
		userDailyLabel.setBounds(50,375,150,25);
		//userDailyLabel.setForeground(Color.white);
		
		userIDField.setBounds(150,50,200,25);
		userPasswordField.setBounds(150,100,200,25);
		userAgeField.setBounds(150,150,200,25);
		
		userMaleRadioButton.setFocusable(false);
		userMaleRadioButton.addActionListener(this);
		userFemaleRadioButton.setFocusable(false);
		userFemaleRadioButton.addActionListener(this);
		
		userGenderGroup = new ButtonGroup();
		userGenderGroup.add(userMaleRadioButton);
		userGenderGroup.add(userFemaleRadioButton);
		
		radioPanel.setLayout(new GridLayout(1,2));
		radioPanel.add(userMaleRadioButton);
		radioPanel.add(userFemaleRadioButton);
		radioPanel.setBounds(150,200,150,25);
		
		/*Height Slider Start*/
		heightSlider.setPreferredSize(new Dimension(350,50));
		
		heightSlider.setPaintTicks(true);
		heightSlider.setMinorTickSpacing(5);
		heightSlider.setPaintTrack(true);
		heightSlider.setMajorTickSpacing(25);
		
		heightSlider.setPaintLabels(true);
		heightSlider.setFont(new Font("MV Boli",Font.PLAIN,10));
		
		heightSlider.setOrientation(SwingConstants.HORIZONTAL);
		
		heightSlider.addChangeListener(this);
		
		heightSliderLabel.setText(heightSlider.getValue()+" cm");
		heightSliderLabel.setFont(new Font("MV Boli",Font.PLAIN,16));
		
		heightPanel.add(heightSlider);
		heightPanel.add(heightSliderLabel);
		heightPanel.setBounds(125,250,450,50);
		/*Height Slider End*/
		
		/*Weight Slider Start*/
		weightSlider.setPreferredSize(new Dimension(350,50));
		
		weightSlider.setPaintTicks(true);
		weightSlider.setMinorTickSpacing(5);
		weightSlider.setPaintTrack(true);
		weightSlider.setMajorTickSpacing(25);
		
		weightSlider.setPaintLabels(true);
		weightSlider.setFont(new Font("MV Boli",Font.PLAIN,10));
		
		weightSlider.setOrientation(SwingConstants.HORIZONTAL);
		
		weightSlider.addChangeListener(this);
		
		weightSliderLabel.setText(weightSlider.getValue()+" kg");
		weightSliderLabel.setFont(new Font("MV Boli",Font.PLAIN,16));
		
		weightPanel.add(weightSlider);
		weightPanel.add(weightSliderLabel);
		weightPanel.setBounds(120,300,450,50);
		/*Weight Slider End*/
		
		/*Register Button Start*/
		registerButton.setBounds(50,500,100,25);
		registerButton.addActionListener(this);
		registerButton.setForeground(Color.green);
		registerButton.setBackground(Color.black);
		/*Register Button End*/
		
		/*Combo Box Start*/
		String[] activityTypes = {"Inactive : Never or rarely physical activity.",
							"Somewhat active : Include light activity or moderate activity.",
							"Active : Include at least 30 minutes of moderate activity.",
							"Very Active : Include large amounts of moderate or vigorous activity."
								};
		dailyComboBox = new JComboBox(activityTypes);
		dailyComboBox.addActionListener(this);
		dailyComboBox.setBounds(175,375,400,25);
		dailyComboBox.setFocusable(false);
		/*Combo Box End*/
		
		registerButton.setFocusable(false);
		
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.setSize(630,630);
		//registerFrame.getContentPane().setBackground(new Color(0,76,153));
		registerFrame.setResizable(false);
		
		registerFrame.add(userIDLabel);
		registerFrame.add(userPasswordLabel);
		registerFrame.add(userGenderLabel);
		registerFrame.add(userHeightLabel);
		registerFrame.add(userWeightLabel);
		registerFrame.add(userAgeLabel);
		registerFrame.add(userDailyLabel);
		
		registerFrame.add(userIDField);
		registerFrame.add(userPasswordField);
		
		registerFrame.getContentPane().add(radioPanel);
		
		registerFrame.add(registerButton);
		
		registerFrame.add(heightPanel);
		
		registerFrame.add(weightPanel);
		
		registerFrame.add(userAgeField);
		
		registerFrame.add(dailyComboBox);
		
		registerFrame.setLayout(null);
		registerFrame.setVisible(true);
	}
	
	/*Method to find selected gender start*/
	public String getSelectedOption() {
        Enumeration<AbstractButton> radioButtons = userGenderGroup.getElements();
        while (radioButtons.hasMoreElements()) {
            AbstractButton currentRadioButton = radioButtons.nextElement();
            if (currentRadioButton.isSelected()) {
                return currentRadioButton.getText();
            }
        }
        return null;
    }
	/*Method to find selected gender end*/

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registerButton) {
			String userID = userIDField.getText();//Get entered user ID.
			
			String userPassword = String.valueOf(userPasswordField.getPassword());//Get entered user password.
			
			String userAge = userAgeField.getText();//Get entered user age and cast by integer.
			
			/*Get entered user gender by radio buttons start.*/
			String userGender = getSelectedOption();
			/*Get entered user gender by radio buttons end.*/
			
			String userHeight = String.valueOf(heightSlider.getValue());//Get entered user height.
			
			String userWeight = String.valueOf(weightSlider.getValue());;//Get entered user weight.
			
			/*Select activity type by using combo boxes start*/
			String activityType;
			if(e.getSource()=="Inactive : Never or rarely physical activity.") {
				activityType = "type1";
			}
			else if (e.getSource()=="Somewhat active : Include light activity or moderate activity.") {
				activityType = "type2";
			}
			else if(e.getSource()=="Active : Include at least 30 minutes of moderate activity.") {
				activityType = "type3";
			}
			else {
				activityType = "type4";
			}
			/*Select activity type by using combo boxes end*/
			
			/*Empty text box block start*/
			if(userIDField.getText().isEmpty()|| 
					String.valueOf(userPasswordField.getPassword()).isEmpty()||
					userAgeField.getText().isEmpty()) {
				userID = "invalidUser";
				userPassword = "0";
				userAge = "0";
				userGender = "0";
				userHeight = "0";
				userHeight = "0";
				userWeight = "0";
				activityType = "0";
			}
			/*Empty text box block end*/
			
			/*Create new user data text file and write user data to it start.*/
			File newUserFile = new File(userID+".txt");
			
			FileWriter newUserFileWriter;
			try {
				newUserFileWriter = new FileWriter(userID+".txt");
				newUserFileWriter.write(userID);//Line 1.
				newUserFileWriter.write(System.getProperty( "line.separator" ));
				newUserFileWriter.write(userPassword);//Line 2.
				newUserFileWriter.write(System.getProperty( "line.separator" ));
				newUserFileWriter.write(userAge);//Line 3.
				newUserFileWriter.write(System.getProperty( "line.separator" ));
				newUserFileWriter.write(userGender);//Line 4.
				newUserFileWriter.write(System.getProperty( "line.separator" ));
				newUserFileWriter.write(userHeight);//Line 5.
				newUserFileWriter.write(System.getProperty( "line.separator" ));
				newUserFileWriter.write(userWeight);//Line 6.
				newUserFileWriter.write(System.getProperty( "line.separator" ));
				newUserFileWriter.write(activityType);//Line 7.
				newUserFileWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*Create new user data text file and write user data to it end.*/
			new LoginPage();
			registerFrame.dispose();
		}
		
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		heightSliderLabel.setText(heightSlider.getValue()+" cm");
		weightSliderLabel.setText(weightSlider.getValue()+" kg");
	}
}

package signInPage;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PasswordandID {
	
	String[] userInfo = new String[7];//Global string array to store user information.

	public PasswordandID(String userID) {
		//userID = "omer";//Temporary user ID.
		
		String line;
		int ind = 0;
		
		try {
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userID+".txt"))) {
				while((line = bufferedReader.readLine())!= null) {
					userInfo[ind] = line;
					ind++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Getter function to reach user data on another class.
	public String[] getUserInfo() {
		return userInfo;
	}
	
}

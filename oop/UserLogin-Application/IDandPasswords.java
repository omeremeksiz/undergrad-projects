import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String,String> logininfo = new HashMap<String, String>();
	
	public IDandPasswords() {
		logininfo.put("Bro", "pizza");
		logininfo.put("Omer", "remo");
		logininfo.put("Furkan", "nakruf");
	}
	
	// HashMap getter.
	protected HashMap getLoginInfo(){
		return logininfo;
	}
}

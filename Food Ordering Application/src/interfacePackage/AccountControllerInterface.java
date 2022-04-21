package interfacePackage;

import dataPackage.UserAccountData;

public interface AccountControllerInterface {
	
	public void addUser (String name, String email, String mobileNumber, String password);
	public UserAccountData getCurrentUser(String username, String password);
	
}

package interfacePackage;

import dataPackage.UserAccountData;

public interface AccountControllerInterface {
	void addUser (String name, String email, String mobileNumber, String password);
	UserAccountData getCurrentUser(String username, String password);	
}

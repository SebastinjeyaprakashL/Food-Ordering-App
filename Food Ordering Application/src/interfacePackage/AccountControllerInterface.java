package interfacePackage;

import dataPackage.UserAccountData;

public interface AccountControllerInterface {
	
	public void addUser (String name, String email, long mobileNumber, String password);
	public UserAccountData verifyUser(String username, String password);
	
}

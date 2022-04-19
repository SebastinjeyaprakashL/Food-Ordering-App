package interfacePackage;

import java.util.ArrayList;

import foodOrder.UserAccount;

public interface AccountControllerInterface {
	public String getName();
	public String getEmail();
	public String getPassword();
	public ArrayList<UserAccount> getUserAccounts();
}

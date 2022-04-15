package foodOrder;

import java.util.ArrayList;

public interface AccountController {
	public String getName();
	public String getEmail();
	public String getPassword();
	public ArrayList<UserAccount> getUserAccounts();
}

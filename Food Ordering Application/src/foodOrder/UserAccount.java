package foodOrder;

import java.util.ArrayList;

import interfacePackage.AccountControllerInterface;

public class UserAccount implements AccountControllerInterface {
	private int userId;
	private String name;
	private String email;
	private long mobileNum;
	private String password;
	private static ArrayList <UserAccount> userAccounts = new ArrayList <UserAccount>();
	
	UserAccount (String name, String email, long mobileNumber, String password){
		try {
			this.name = name;
			this.email = email;
			this.mobileNum = mobileNumber;
			this.password = password;
			userAccounts.add(this);
		}
		catch (Exception e) {
		e.printStackTrace();	
		}
		
	}

	public UserAccount() {
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public ArrayList<UserAccount> getUserAccounts() {
		return UserAccount.userAccounts;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
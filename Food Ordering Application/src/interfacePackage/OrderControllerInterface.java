package interfacePackage;

import dataPackage.HotelData;
import dataPackage.UserAccountData;

public interface OrderControllerInterface {
	public void createOrder(UserAccountData currentUser, HotelData hotel);	
}

package interfacePackage;

import dataPackage.HotelData;
import dataPackage.UserAccountData;

public interface OrderControllerInterface {
	void createOrder(UserAccountData currentUser, HotelData hotel);
}

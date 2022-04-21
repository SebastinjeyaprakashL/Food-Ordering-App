package foodOrder;

import inputOutputPackage.Input;
import inputOutputPackage.Output;
import dataPackage.HotelData;
import dataPackage.UserAccountData;
import handlerPackage.HotelHandler;
import handlerPackage.OrderHandler;
import interfacePackage.HotelControllerInterface;
import interfacePackage.OrderControllerInterface;

public class Main {
	
	public static void main(String[] args) {
		try {
			Output.printInConsole("Welcome To Food Ordering Console App");
			UserAccountData currentUser;
			Login login = new Login();
			do {
				currentUser = login.loginMenu();
				if (currentUser != null) {
					boolean staySignedInFlag = true;
					do {
						Output.printInConsole("Enter your choice :\n" +
											  "1 - New Order\n" +
											  "0 - Logout");
						int userOption = Input.getInt();
						if (userOption == 1) {
							HotelControllerInterface hotelHandler = new HotelHandler();
							HotelData chosenHotel = hotelHandler.chooseHotelToOrder();
							if (chosenHotel != null) {
								OrderControllerInterface orderHandler = new OrderHandler();
								orderHandler.createOrder(currentUser, chosenHotel);
							}
						}
						else {
							staySignedInFlag = false;
							currentUser = null;
							login = null;
						}
					}while (staySignedInFlag);
				}
			}while (currentUser != null);
		}
		catch (Exception e) {
			Output.printInConsole("We are facing issue in our side! Please comeback later.\nThank you!");
			Output.printInConsole(""+e);
		}	
		finally {
			Output.printInConsole("Logged Out Successfully!");
			System.gc();		
		}
	}
}

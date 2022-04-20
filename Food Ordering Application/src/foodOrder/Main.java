package foodOrder;

import consoleInputOutput.Input;
import consoleInputOutput.Output;
import dataPackage.HotelData;
import dataPackage.UserAccountData;
import databasePackage.Database;
import handlerPackage.HotelHandler;
import handlerPackage.OrderHandler;
import interfacePackage.HotelControllerInterface;
import interfacePackage.OrderControllerInterface;

public class Main {
	
	public static void main(String args []) {
		try {
			Database db = Database.getInstance();
			db.loadDb();
			Output.printInConsole("Welcome To Food Ordering Console App");
			UserAccountData currentUser = null;
			Login login = new Login();
			do {
				currentUser = login.loginMenu();
				if (currentUser != null) {
					boolean staySignedInFlag = true;
					do {
						Output.printInConsole("Enter your choice :"
												+ "\n1 - New Order"
												+ "\n0 - Logout");
						int userOption = Input.getInt();
						if (userOption == 1) {
							HotelControllerInterface hotelHandler = new HotelHandler();
							HotelData chosenHotel = hotelHandler.chooseHotelToOrder();
							if (chosenHotel != null) {
								OrderControllerInterface orderHandler = new OrderHandler();
								orderHandler.createOrder(currentUser, chosenHotel);
								continue;
							}
						}
						else {
							staySignedInFlag = false;
							currentUser = null;
							login = null;
						}
					}while (staySignedInFlag);
				}
				continue;
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

package foodOrder;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class Main {
	
	public static void main(String args []) {
		UserAccount user1 = new UserAccount("User1","user1@testmail.com",989898989, "testUser1");
		UserAccount user2 = new UserAccount("User2","User2@testmail.com",989898000, "testUser2");
		UserAccount user3 = new UserAccount("User3","User3@testmail.com",989898634, "testUse3");
		UserAccount user4 = new UserAccount("User4","test",989898634, "test");
		
		HotelHandler hotelHandler = new HotelHandler();
		hotelHandler.addHotel(1,"Hotel1");
		hotelHandler.addHotel(2,"Hotel2");
		
		
		MenuHandler menuHandler = new MenuHandler();
		menuHandler.addMenu(1,"chicken biriyani",100);
		menuHandler.addMenu(1,"mutton biriyani", 250);
		menuHandler.addMenu(1,"veg meals", 80);
		menuHandler.addMenu(1,"non-veg meals", 120);
		
		menuHandler.addMenu(2,"Tandoori",100);
		menuHandler.addMenu(2,"Grill", 180);
		menuHandler.addMenu(2,"Shawarma", 90);
		menuHandler.addMenu(2,"Atho", 120);
		
		boolean staySignedInFlag = true;
		Login login = new Login();
		UserAccount currentUser = login.loginMenu();
		
		if (currentUser != null) {
			do {
				UserOutput.consoleStringPrinter("Enter your choice : "
						+ "\n1 - New Order"
						+ "\n2 - Logout");
				int staySignedInOption = UserInputs.getIntUserInput();
				if (staySignedInOption == 1) {
					Hotel selectedHotel = hotelHandler.chooseHotelToOrder();
					if (selectedHotel != null) {
						OrderHandler orderHandler = new OrderHandler();
						orderHandler.createOrder(currentUser,selectedHotel);
						continue;
					}
				}
				else {
					break;
				}
				
			}while (staySignedInFlag == true);
			UserOutput.consoleStringPrinter("Logged Out Successfully");
			System.gc();
		}
		
		
		
	}
}

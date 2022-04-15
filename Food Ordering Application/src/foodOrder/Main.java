package foodOrder;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class Main {
	
	public static void main(String args []) {
		new UserAccount("User1","user1@testmail.com",989898989, "testUser1");
		new UserAccount("User2","User2@testmail.com",989898000, "testUser2");
		new UserAccount("User3","User3@testmail.com",989898634, "testUse3");
		new UserAccount("User4","test",989898634, "test");
		
		HotelHandler hotelHandler = new HotelHandler();
		hotelHandler.addHotel(1,"Hotel1");
		hotelHandler.addHotel(2,"Hotel2");
		
		
		MenuHandler menuHandler = new MenuHandler();
		menuHandler.addMenu(1,"Veg biriyani",100);
		menuHandler.addMenu(1,"Fried Rice", 250);
		menuHandler.addMenu(1,"Egg Biriyani", 80);
		menuHandler.addMenu(1,"non-veg meals", 120);
		
		menuHandler.addMenu(2,"Chicken Grill", 180);
		menuHandler.addMenu(2,"Shawarma Roll", 90);
		menuHandler.addMenu(2,"Shawarma Plate", 100);
		menuHandler.addMenu(2,"Egg Atho Fry", 120);
		
		boolean staySignedInFlag = true;
		Login login = new Login();
		UserAccount currentUser = login.loginMenu();
		
		if (currentUser != null) {
			try {
				do {
					UserOutput.consoleStringPrinter("Enter your choice : "
							+ "\n1 - New Order"
							+ "\n0 - Logout");
					int staySignedInOption = UserInputs.getIntUserInput();
					if (staySignedInOption == 1) {
						Hotel selectedHotel = hotelHandler.chooseHotelToOrder();
						if (selectedHotel != null) {
							OrderHandler orderHandler = new OrderHandler();
							orderHandler.createOrder(currentUser,selectedHotel);
							continue;
						}
					}
					else if(staySignedInOption == 0){
						break;
					}
					else {
						UserOutput.consoleStringPrinter("Invaid choice");
						continue;
					}
				}while (staySignedInFlag == true);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				UserOutput.consoleStringPrinter("Logged Out Successfully");
				login = null;
				System.gc();
			}	
		}		
	}
}

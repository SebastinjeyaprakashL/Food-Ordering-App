package foodOrder;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class Main {
	
	public static void main(String args []) {
		LoadData loadDb = new LoadData();
		Login login = new Login();
		UserAccount currentUser = login.loginMenu();
		HotelHandler hotelHandler = new HotelHandler();
		boolean staySignedInFlag = true;
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
				loadDb = null;
				login = null;
				System.gc();
			}	
		}		
	}
}

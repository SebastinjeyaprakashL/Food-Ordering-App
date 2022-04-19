package foodOrder;

import consoleInputOutput.Input;
import consoleInputOutput.Output;
import dataPackage.HotelData;
import handlerPackage.HotelHandler;
import handlerPackage.OrderHandler;

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
					Output.printInConsole("Enter your choice : "
							+ "\n1 - New Order"
							+ "\n0 - Logout");
					int staySignedInOption = Input.getInt();
					if (staySignedInOption == 1) {
						HotelData selectedHotel = hotelHandler.chooseHotelToOrder();
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
						
						Output.printInConsole("Invaid choice");
						continue;
					}
				}while (staySignedInFlag == true);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				Output.printInConsole("Logged Out Successfully");
				loadDb = null;
				login = null;
				System.gc();
			}	
		}		
	}
}

package foodOrder;

import java.util.ArrayList;
import java.util.HashMap;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class OrderHandler {
	public static HashMap <String , Integer> orderList;
	public void addDishToOrder(int orderId,String dishName, int count) { 
	}
	public void createOrder(UserAccount currentUser, int hotelId) {
		String dishName;
		int dishCount;
		orderList = new HashMap();
		MenuHandler menuHandler = new MenuHandler ();
		menuHandler.showHotelMenu(hotelId);
		ArrayList <HotelMenu> menuList = menuHandler.getCurrentHotelMenu(hotelId);
		do {
			UserOutput.consoleStringPrinter("Choose the food you want to order :");
			do {
				dishName = null;
				UserOutput.consoleStringPrinter("Enter the dish name :");
				dishName = UserInputs.getStringUserInput();
				for(HotelMenu menu : menuList) {
					if(menu.dishName.contains(dishName)) {
						UserOutput.consoleStringPrinter("Enter amount of "+ dishName+" to order");
						dishCount = UserInputs.getIntUserInput();
						orderList.put(dishName, dishCount);
					}
				}
				if(dishName == null) {
					UserOutput.consoleStringPrinter("Please enter correct dish name!");	
				}
			}while(dishName == null);
			
			UserOutput.consoleStringPrinter("Dish added successfully to the cart. Please enter your option :"
											+ "\n1 - Add More Dish"
											+ "\n2 - View Order Summary"
											+ "\n3 - Remove Added Dish"
											+ "\n4 - Cancel Order");
			int orderOption = UserInputs.getIntUserInput();
			switch (orderOption) {
			case 1:
				continue;
			case 2 : 
				viewOrderSummary();
				break;
			case 3:
				removeDishFromOrder();
				continue;
			case 4 :
				//false;
				break;
			}
			
			
		}while(true);
		
		
		
	}
	private void removeDishFromOrder() {
		UserOutput.consoleStringPrinter("Enter the dish , you need to remove :");
		String dishNameToRemove = UserInputs.getStringUserInput();
		if(orderList.containsKey(dishNameToRemove)) {
			int countOfDishPlacedInOrderList = orderList.get(dishNameToRemove);
			if ( countOfDishPlacedInOrderList > 1) {
				UserOutput.consoleStringPrinter("Enter the amount to remove :");
				int dishCountToRemove = UserInputs.getIntUserInput();
				if (dishCountToRemove >= countOfDishPlacedInOrderList ) {
					UserOutput.consoleStringPrinter("Entered count of dish is greater than or equal to the actually added count, Removing dish completely from the cart");
					orderList.remove(dishNameToRemove);
				}
				else {
					orderList.put(dishNameToRemove,countOfDishPlacedInOrderList-dishCountToRemove );
				}
			}
		}
		
	}
	private void viewOrderSummary() {
		// TODO Auto-generated method stub
		
	}
	
	
}

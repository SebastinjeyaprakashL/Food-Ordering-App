package foodOrder;

import java.util.ArrayList;
import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class OrderHandler {
	public static int orderId = 0;
	public static ArrayList <HotelMenu> menuList ;
	public static ArrayList <Order> order = new ArrayList<Order>();

	public void createOrder(UserAccount currentUser, Hotel hotel) {
		try {
			orderId = orderId + 1;
			MenuHandler menuHandler = new MenuHandler ();
			menuHandler.showHotelMenu(hotel.hotelId);
			menuList = menuHandler.getCurrentHotelMenu(hotel.hotelId);
			boolean userActionExitFlag = false;
			
			do {
			UserOutput.consoleStringPrinter("Please enter your option :"
					+ "\n1 - Add Dish To Order"
					+ "\n2 - View Order Summary"
					+ "\n3 - Remove Added Dish"
					+ "\n4 - Place Order"
					+ "\n5 - Cancel Order"
					+ "\n6 - Back to main menu");
			int orderOption = UserInputs.getIntUserInput();
			switch (orderOption) {
				case 1:
					addDish();
					
					break;
				case 2 : 
					viewOrderSummary(currentUser, hotel);
					break;
				case 3:
					removeDishFromOrder();
					break;
				case 4 :
					if (order.isEmpty()) {
						UserOutput.consoleStringPrinter("Couldn't place order!. Cart is empty!");
					}
					else {
						UserOutput.consoleStringPrinter("Your Order has been placed");
						viewOrderSummary(currentUser, hotel);
						order.clear();
						userActionExitFlag = true;
					}
					break;
				case 5 :
					if (order.isEmpty()) {
						UserOutput.consoleStringPrinter("No order exist!. Cart is empty!");
					}
					else {
						UserOutput.consoleStringPrinter("Your Order has been cancelled");
						orderId = orderId --;
						order.clear();
						userActionExitFlag = true;
					}
					break;
				case 6:
					userActionExitFlag = true;
					break;
				}
			}while(!userActionExitFlag);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void addDish() {
		try {
			String dishName;
			int dishCount = 0;
				do {
					dishName = null;
					dishCount = 0;
					UserOutput.consoleStringPrinter("Enter the dish name :");
					dishName = UserInputs.getStringUserInput();
					int existingDishCountInCurrentOrder = getDishCountInCurrentOrder(dishName);
					for(HotelMenu menu : menuList) {
						if(menu.dishName.equalsIgnoreCase(dishName)) {
							UserOutput.consoleStringPrinter("Enter amount of "+ dishName+" to order");
							dishCount = UserInputs.getIntUserInput();
								int newDishCount = existingDishCountInCurrentOrder + dishCount;
								Order newOrder = new Order(orderId,dishName, newDishCount);
								order.add(newOrder);
								UserOutput.consoleStringPrinter("Dish Added Successfully");
						}
					}
					if(dishCount == 0) {
						UserOutput.consoleStringPrinter("Please enter correct dish name!");	
					}
				}while(dishCount == 0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void removeDishFromOrder() {
	try {
		if (order.isEmpty()) {
			UserOutput.consoleStringPrinter("No dish added to the Cart! Cart is empty");
		}
		else {
			String dishNameToRemove ;
			int dishCountToRemove = 0;
			do {
				UserOutput.consoleStringPrinter("Enter the dish , you need to remove :");
				dishNameToRemove = UserInputs.getStringUserInput();
					for (Order currentOrder : order) {
						if (currentOrder.dishName.equalsIgnoreCase(dishNameToRemove)) {
							UserOutput.consoleStringPrinter("Enter the amount to remove :");
							dishCountToRemove = UserInputs.getIntUserInput();
							order.remove(currentOrder);
							int newDishCount = currentOrder.dishCount - dishCountToRemove;
							if (newDishCount > 0) {
								Order newOrder = new Order (orderId,currentOrder.dishName, newDishCount);
								order.add(newOrder);
							}
							UserOutput.consoleStringPrinter("Dish Removed from cart");
							break;
						}
					}
				
			}while(dishCountToRemove == 0);	
		}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void viewOrderSummary(UserAccount currentUser, Hotel hotel) {
		try {
			if (order.isEmpty()) {
				UserOutput.consoleStringPrinter("No dish added to the Cart! Cart is empty");
			}
			else {
				double grossTotal = 0;
				UserOutput.consoleStringPrinter("Order No: " + orderId
												+"\nCustomer Name : " +currentUser.getName()
												+ "\tHotel Name: "+hotel.hotelName
												+ "\nDishName \t\tUnitPrice \tQuantity \tPrice");
				
				for(Order currentOrder : order) {
					double currentDishPrice = getDishPrice(currentOrder.dishName);
					double currentDishTotalPrice = currentDishPrice * currentOrder.dishCount;
					grossTotal = grossTotal + currentDishTotalPrice;
					UserOutput.consoleStringPrinter(currentOrder.dishName +" \t\t"+currentDishPrice+ " \t\t"+currentOrder.dishCount +" \t\t"+currentDishTotalPrice);
				}	
				UserOutput.consoleStringPrinter("\t \t \t \t \t \tTOTAl :" + grossTotal);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public double getDishPrice(String dishName) {
		try {
			for(HotelMenu menuDetails : menuList) {
				if(menuDetails.dishName.equalsIgnoreCase(dishName)){
					return menuDetails.dishPrice; 
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;	
	}
	
	public int getDishCountInCurrentOrder (String dishName) {
		try {
			int dishCountInCurrentOrder = 0;
			for (Order o : order) {
				if (o.dishName.equalsIgnoreCase(dishName)) {
					dishCountInCurrentOrder =  o.dishCount;
					order.remove(o);
					return dishCountInCurrentOrder;
				}
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
		
}
	
	


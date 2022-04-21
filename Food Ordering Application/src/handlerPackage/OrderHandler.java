package handlerPackage;

import java.util.ArrayList;
import inputOutputPackage.Input;
import inputOutputPackage.Output;
import dataPackage.HotelData;
import dataPackage.HotelMenuData;
import dataPackage.OrderData;
import dataPackage.UserAccountData;
import databasePackage.DatabaseHandler;
import interfacePackage.MenuControllerInterface;
import interfacePackage.OrderControllerInterface;

public class OrderHandler implements OrderControllerInterface {
	public static ArrayList <HotelMenuData> menuList ;
	public static ArrayList <OrderData> order = new ArrayList<>();
	DatabaseHandler db = DatabaseHandler.getInstance();
	
	@Override
	public void createOrder(UserAccountData currentUser, HotelData hotel) {
		try {
			menuList = new ArrayList<>();
			MenuControllerInterface menuHandler = new MenuHandler ();
			menuHandler.showHotelMenu(hotel.hotelId);
			menuList = menuHandler.getCurrentHotelMenu(hotel.hotelId);
			boolean userActionExitFlag = false;
			
			do {
			Output.printInConsole("Please enter your option :"
					+ "\n1 - Add Dish To Order"
					+ "\n2 - View Order Summary"
					+ "\n3 - Remove Added Dish"
					+ "\n4 - Place Order"
					+ "\n5 - Cancel Order"
					+ "\n6 - Back to main menu");
			int orderOption = Input.getInt();
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
						Output.printInConsole("Couldn't place order!. Cart is empty!");
					}
					else {
						Output.printInConsole("Your Order has been placed");
						viewOrderSummary(currentUser, hotel);
						db.addOrderList(order,currentUser, hotel);
						order.clear();
						userActionExitFlag = true;
					}
					break;
				case 5 :
					if (order.isEmpty()) {
						Output.printInConsole("No order exist!. Cart is empty!");
					}
					else {
						Output.printInConsole("Your Order has been cancelled");
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
			Output.printInConsole(e+"");
		}		
	}
	
	private void addDish() {
		try {
			String dishName;
			int dishCount;
				do {
					dishCount = 0;
					Output.printInConsole("Enter the dish name :");
					dishName = Input.getString();
					int existingDishCountInCurrentOrder = getDishCountInCurrentOrder(dishName);
					for(HotelMenuData menu : menuList) {
						if(menu.dishName.equalsIgnoreCase(dishName)) {
							Output.printInConsole("Enter amount of "+ dishName+" to order");
							dishCount = Input.getInt();
								int newDishCount = existingDishCountInCurrentOrder + dishCount;								
								OrderData newOrder = new OrderData();
								newOrder.dishName = dishName;
								newOrder.dishCount = newDishCount;
								order.add(newOrder);
								Output.printInConsole("Dish Added Successfully");
						}
					}
					if(dishCount == 0) {
						Output.printInConsole("Please enter correct dish name!");	
					}
				}while(dishCount == 0);
		}
		catch (Exception e) {
			e.printStackTrace();
			Output.printInConsole ("Unable to add dish ! Please order from another hotel");
		}	
	}
	
	private void removeDishFromOrder() {
		try {
			if (order.isEmpty()) {
				Output.printInConsole("No dish added to the Cart! Cart is empty");
			}
			else {
				String dishNameToRemove ;
				int dishCountToRemove = 0;
				do {
					Output.printInConsole("Enter the dish , you need to remove :");
					dishNameToRemove = Input.getString();
						for (OrderData currentOrder : order) {
							if (currentOrder.dishName.equalsIgnoreCase(dishNameToRemove)) {
								Output.printInConsole("Enter the amount to remove :");
								dishCountToRemove = Input.getInt();
								order.remove(currentOrder);
								int newDishCount = currentOrder.dishCount - dishCountToRemove;
								if (newDishCount > 0) {
									OrderData newOrder = new OrderData();
									newOrder.dishName = currentOrder.dishName;
									newOrder.dishCount = newDishCount;
									order.add(newOrder);
								}
								Output.printInConsole("Dish Removed from cart");
								break;
							}
						}
					
				}while(dishCountToRemove == 0);	
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
			Output.printInConsole("Something went wrong ! Please order from another hotel");
		}
		
	}

	private void viewOrderSummary(UserAccountData currentUser, HotelData hotel) {
		try {
			if (order.isEmpty()) {
				Output.printInConsole("No dish added to the Cart! Cart is empty");
			}
			else {
				double grossTotal = 0;
				Output.printInConsole("Customer Name : " +currentUser.getName()
										+ "\tHotel Name: "+hotel.hotelName
										+ "\nDishName \t\tUnitPrice \tQuantity \tPrice");				
				for(OrderData currentOrder : order) {
					double currentDishPrice = getDishPrice(currentOrder.dishName);
					double currentDishTotalPrice = currentDishPrice * currentOrder.dishCount;
					grossTotal = grossTotal + currentDishTotalPrice;
					Output.printInConsole(currentOrder.dishName +" \t\t"+currentDishPrice+ " \t\t"+currentOrder.dishCount +" \t\t"+currentDishTotalPrice);
				}	
				Output.printInConsole("\t \t \t \t \t \tTOTAl :" + grossTotal);
			}
		}
		catch (Exception e) {
			Output.printInConsole(e+"");
		}
		
	}
	
	private double getDishPrice(String dishName) {
		try {
			for(HotelMenuData menuDetails : menuList) {
				if(menuDetails.dishName.equalsIgnoreCase(dishName)){
					return menuDetails.dishPrice; 
				}
			}
		}
		catch (Exception e) {
			Output.printInConsole(e+"");
		}
		return 0;	
	}
	
	private int getDishCountInCurrentOrder (String dishName) {
		try {
			int dishCountInCurrentOrder;
			for (OrderData o : order) {
				if (o.dishName.equalsIgnoreCase(dishName)) {
					dishCountInCurrentOrder =  o.dishCount;
					order.remove(o);
					return dishCountInCurrentOrder;
				}
			}	
		}
		catch (Exception e) {
			Output.printInConsole(e+"");
		}
		return 0;		
	}
		
}
	
	


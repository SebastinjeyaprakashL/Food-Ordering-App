package threadPackage;

import java.util.ArrayList;

import customExceptionPackage.InvalidThreadException;
import dataPackage.HotelData;
import dataPackage.OrderData;
import dataPackage.UserAccountData;
import databasePackage.DatabaseHandler;
import inputOutputPackage.Output;

public class OrderInsertionThread implements Runnable {
	private ArrayList <OrderData> newOrder;
	private UserAccountData currentUser;
	private HotelData currentHotel;
	DatabaseHandler db = DatabaseHandler.getInstance();
	
	public OrderInsertionThread (ArrayList<OrderData> newOrderList,UserAccountData currentUser, HotelData currentHotel) {
		newOrder = new ArrayList<>();
		this.newOrder = newOrderList;
		this.currentUser = currentUser;
		this.currentHotel = currentHotel;
		
	}

	@Override
	public void run() {
		try {
			db.addOrderList(newOrder, currentUser, currentHotel);
		} catch (InvalidThreadException e) {
			Output.printInConsole(e + "");
		}
	}

}

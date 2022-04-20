package databasePackage;

import java.util.ArrayList;

import consoleInputOutput.Output;
import dataPackage.HotelData;
import dataPackage.HotelMenuData;
import dataPackage.OrderData;
import dataPackage.UserAccountData;
import handlerPackage.HotelHandler;
import handlerPackage.MenuHandler;
import handlerPackage.UserAccountHandler;
import interfacePackage.AccountControllerInterface;
import interfacePackage.HotelControllerInterface;
import interfacePackage.MenuControllerInterface;

public class Database {
	
	private ArrayList <UserAccountData> userAccounts = new ArrayList <>();
	private ArrayList <OrderData> orderList = new ArrayList <>();
	private ArrayList <HotelData> hotels = new ArrayList<>();
	private ArrayList <HotelMenuData> menuList = new ArrayList<>();

	private static Database db = new Database();
	
	private Database() {}
	
	public static Database getInstance() {
		return db;
	}
	
	
	public void loadDb() {
		try {
			HotelControllerInterface hotelHandler = new HotelHandler();
			hotelHandler.addHotel(1,"Hotel1");
			hotelHandler.addHotel(2,"Hotel2");
			
			MenuControllerInterface menuHandler = new MenuHandler();
			menuHandler.addMenu(1,"Veg Biriyani",100);
			menuHandler.addMenu(1,"Fried Rice", 250);
			menuHandler.addMenu(1,"Egg Biriyani", 80);
			menuHandler.addMenu(1,"Non-Veg Meals", 120);
			
			menuHandler.addMenu(2,"Chicken Grill", 180);
			menuHandler.addMenu(2,"Shawarma Roll", 90);
			menuHandler.addMenu(2,"Shawarma Plate", 100);
			menuHandler.addMenu(2,"Egg Atho Fry", 120);
			
			AccountControllerInterface userHandler = new UserAccountHandler();
			userHandler.addUser("User","test@test.com",989898634, "test@123");
			userHandler.addUser("User1","user1@testmail.com",989898989, "testUser@1");
		}
		catch (Exception e) {
			Output.printInConsole(""+e);
		}
	}

	public ArrayList <UserAccountData> getUserAccounts() {
		return this.userAccounts;
	}

	public void addUserAccount(UserAccountData newUser) {
		this.userAccounts.add(newUser);
	}

	public ArrayList <OrderData> getOrderList() {
		return orderList;
	}

	public void addOrderList(ArrayList <OrderData> orderList) {
		this.orderList.addAll(orderList);
	}

	public ArrayList <HotelData> getHotels() {
		return this.hotels;
	}

	public void addHotel(HotelData newHotel) {
		this.hotels.add(newHotel);
	}

	public ArrayList <HotelMenuData> getMenuList() {
		return menuList;
	}

	public void addMenuList(HotelMenuData menuList) {
		this.menuList.add(menuList);
	}
}

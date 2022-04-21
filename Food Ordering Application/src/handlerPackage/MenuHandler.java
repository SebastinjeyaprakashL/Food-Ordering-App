package handlerPackage;

import java.util.ArrayList;

import inputOutputPackage.Output;
import dataPackage.HotelMenuData;
import databasePackage.Database;
import interfacePackage.MenuControllerInterface;

public class MenuHandler implements MenuControllerInterface {
	public Database db = Database.getInstance();
	
	@Override
	public void addMenu(int hotelId,String dishName, double dishPrice) {
		try {
			HotelMenuData menu = new HotelMenuData();
			menu.hotelId = hotelId;
			menu.dishName = dishName;
			menu.dishPrice = dishPrice;
			
			db.addHotelMenu(menu);
		}
		catch (Exception e) {
			Output.printInConsole("Something went wrong. Unable to add menu! " + e);
		}
		
	}
	
	@Override
	public void showHotelMenu(int hotelId) {
		try {
			ArrayList <HotelMenuData> currentHotelMenuList;
			currentHotelMenuList = getCurrentHotelMenu(hotelId);
			Output.printInConsole("\t\t-----------Menu-----------");
			for(HotelMenuData menu : currentHotelMenuList) {
				Output.printInConsole("\t\t"+menu.dishName + " - " + menu.dishPrice);
			}
			Output.printInConsole("\t\t-----------END-----------");
		}
		catch (Exception e) {
			Output.printInConsole("Problem in fetching menu list for the selected hotel. Please choose different hotel. " + e);
		}	
	}
	
	@Override
	public ArrayList<HotelMenuData> getCurrentHotelMenu(int hotelId){
		try {
			return db.getMenuList(hotelId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

}

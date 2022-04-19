package handlerPackage;

import java.util.ArrayList;

import consoleInputOutput.Output;
import dataPackage.HotelMenuData;

public class MenuHandler {
	public int hotelId ;
	public ArrayList <HotelMenuData> currentHotelmenuList;
	
	
	public void addMenu(int hotelId,String dishName, double dishPrice) {
		try {
			HotelMenuData menu = new HotelMenuData(hotelId,dishName,dishPrice);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void showHotelMenu(int hotelId) {
		try {
			currentHotelmenuList = getCurrentHotelMenu(hotelId);
			Output.printInConsole("\t\t-----------Menu-----------");
			for(HotelMenuData menu : currentHotelmenuList) {
				Output.printInConsole("\t\t"+menu.dishName + " - " + menu.dishPrice);
			}
			Output.printInConsole("\t\t-----------END-----------");
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<HotelMenuData> getCurrentHotelMenu(int hotelId){
		try {
			ArrayList <HotelMenuData> menuList = new ArrayList<>();
			for (HotelMenuData menu : HotelMenuData.menuList) {
				if(menu.hotelId == hotelId) {
					menuList.add(menu);
				}
			}
			return menuList;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}

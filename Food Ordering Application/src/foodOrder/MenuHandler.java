package foodOrder;

import java.util.ArrayList;

import consoleInputOutput.UserOutput;

public class MenuHandler {
	public int hotelId ;
	public static ArrayList <HotelMenu> hotelMenu = new ArrayList<HotelMenu>();
	public ArrayList <HotelMenu> currentHotelmenuList;
	
	
	public void addMenu(int hotelId,String dishName, double dishPrice) {
		HotelMenu menu = new HotelMenu(hotelId,dishName,dishPrice);
		hotelMenu.add(menu);
	}
	
	public void showHotelMenu(int hotelId) {
		
		currentHotelmenuList = getCurrentHotelMenu(hotelId);
		for(HotelMenu menu : currentHotelmenuList) {
			UserOutput.consoleStringPrinter(menu.dishName + " - " + menu.dishPrice);
		}
	}
	
	public ArrayList<HotelMenu> getCurrentHotelMenu(int hotelId){
		ArrayList <HotelMenu> menuList = new ArrayList <HotelMenu>();
		for (HotelMenu menu : HotelMenu.menuList) {
			if(menu.hotelId == hotelId) {
				menuList.add(menu);
			}
		}
		return menuList;
	}


}
